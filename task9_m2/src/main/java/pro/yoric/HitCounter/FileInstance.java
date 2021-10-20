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
            filePointer = new File(initPath + FILE_NAME);

            if(checkAccessToFile(filePointer))
            {
                BufferedWriter fbw =
                    new BufferedWriter(
                        new FileWriter(filePointer)
                    );
                fbw.write(THE_FIRST_HIT);
                fbw.flush();
                fbw.close();

                this.realFilePath = filePointer.getAbsolutePath();
            }
            else
                instanceFault();
        }
        catch (IOException e)
        {
            logger.error(e.toString(), e);
        }
    }

    private boolean checkAccessToFile(File FilePtr)
    {
        if(FilePtr.exists())
            return     FilePtr.canRead()
                    && FilePtr.canWrite();
        else
        {
            try
            {
                return     FilePtr.getParentFile().mkdirs()
                        && FilePtr.createNewFile()
                        && FilePtr.canRead()
                        && FilePtr.canWrite();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static FileInstance getInstance()
    {
        return instance;
    }

    public static FileInstance getInstance(String initPath)
    {
        if (instance == null)
            instance = new FileInstance(initPath);

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
// TODO: DELETE TEMPLATE BLOCK BEGIN -----------------------------------------------------------------------------------
    public String getInstancePath()
    {
        return this.realFilePath;
    }
// TODO: DELETE TEMPLATE BLOCK END -------------------------------------------------------------------------------------

    @Override
    public File getFile()
    {
        return this.filePointer;
    }

    private static final String FILE_NAME     = "visits.dat";
    private static final    int THE_FIRST_HIT = 1;

    private static FileInstance instance      = null;           // IMPORTANT!!!
    private                File filePointer   = null;
    private              String realFilePath  = "";

    private static final org.slf4j.Logger logger =
        org
        .slf4j
        .LoggerFactory
        .getLogger(
            FileInstance.class
    );
}