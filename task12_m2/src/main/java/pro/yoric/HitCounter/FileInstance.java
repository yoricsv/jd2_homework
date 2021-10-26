package pro.yoric.HitCounter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileInstance
    implements IFileInstance
{
    private FileInstance(String initPath)                                      // PRIVATE CONSTRUCTOR
    {
        try
        {
            if(isForImage())
                imagePointer = new File(initPath + IMAGE_NAME);
            else
                filePointer  = new File(initPath + FILE_NAME);

            if(checkAccessToFile(filePointer))
            {
                BufferedWriter fbw =
                    new BufferedWriter(
                        new FileWriter(filePointer)
                    );

                if(!isForImage())
                    fbw.write(String.valueOf(THE_FIRST_HIT));

                fbw.flush();
                fbw.close();
            }
            else
                instanceFault();
        }
        catch (IOException e)
        {
            logger.error(e.toString(), e);
        }
    }

    private boolean checkAccessToFile(File filePtr)
    {
        if(filePtr.exists())
            return     filePtr.canRead()
                    && filePtr.canWrite();
        else
        {
            try
            {
                return     filePtr.getParentFile().mkdirs()
                        && filePtr.createNewFile()
                        && filePtr.canRead()
                        && filePtr.canWrite();
            }
            catch (IOException e)
            {
                logger.trace(e.toString(), e);
            }
        }
        return false;
    }

    public static FileInstance getInstance(boolean image)
    {
        useImageSetUp(image);

        if(isForImage())
            return instanceImage;

        return instanceFile;
    }

    public static FileInstance getInstance(String initPath, boolean image)
    {
        useImageSetUp(image);

        if(isForImage())
        {
            if (instanceImage == null)
                instanceImage = new FileInstance(initPath);

            return instanceImage;
        }
        else
        {
            if (instanceFile == null)
                instanceFile = new FileInstance(initPath);

            return instanceFile;
        }
    }

    private void instanceFault()
    {
        logger.error(
            "ERROR!\t File or Directory creation fault!\n" +
            "\t\tCheck The Path and Access rights"
        );

        if(isForImage())
            instanceImage  = null;
        else
            instanceFile = null;
    }

    @Override
    public File getFile(boolean image)
    {
        useImageSetUp(image);

        if(isForImage())
            return this.imagePointer;

        return this.filePointer;
    }

    public static void useImageSetUp(boolean image)
    {
        useImageSetUp = image;
    }

    public static boolean isForImage()
    {
        return useImageSetUp;
    }

    private static final  String FILE_NAME     = "visits.dat";
    private static final  String IMAGE_NAME    = "blank.png";

    private static final     int THE_FIRST_HIT = 1;
    private static       boolean useImageSetUp;

    private static  FileInstance instanceFile  = null;
    private static  FileInstance instanceImage = null;
    private                 File filePointer   = null;
    private                 File imagePointer  = null;

    private static final org.slf4j.Logger logger =
        org
        .slf4j
        .LoggerFactory
        .getLogger(
            FileInstance.class
    );
}