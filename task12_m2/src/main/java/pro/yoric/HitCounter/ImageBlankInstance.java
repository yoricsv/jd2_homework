package pro.yoric.HitCounter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ImageBlankInstance
    implements IImageBlankInstance
{
    private ImageBlankInstance(String initPath)                                      // PRIVATE CONSTRUCTOR
    {
        try
        {
            imagePointer = new File(initPath + FILE_NAME);

            if(checkAccessToFile(imagePointer))
            {
                BufferedWriter fbw =
                    new BufferedWriter(
                        new FileWriter(imagePointer)
                    );
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

    public static ImageBlankInstance getInstance()
    {
        return instance;
    }

    public static ImageBlankInstance getInstance(String initPath)
    {
        if (instance == null)
            instance = new ImageBlankInstance(initPath);

        return instance;
    }

    private void instanceFault()
    {
        logger.error(
            "ERROR!\t File or Directory creation fault!\n" +
            "\t\tCheck The Path and Access rights"
        );
        instance = null;
    }

    @Override
    public File getImage()
    {
        return this.imagePointer;
    }

    private static final   String FILE_NAME    = "blank.png";

    private static ImageBlankInstance instance = null;
    private                  File imagePointer = null;

    private static final org.slf4j.Logger logger =
        org
        .slf4j
        .LoggerFactory
        .getLogger(
                ImageBlankInstance.class
        );
}
