package pro.yoric.HitCounter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileInstance
    implements IFileInstance
{

    @Override
    public void doInit(String path)
    {
        this.instancePath = path + FILE_NAME;
    }

    private FileInstance()                                      // PRIVATE CONSTRUCTOR
    {
        try
        {
            File f = new File(this.instancePath);

            if (!f.createNewFile())
                if (!checkAccessToFile(f))
                    instanceFault();

            if(checkAccessToFile(f))
            {
                BufferedWriter fbw =
                    new BufferedWriter(
                        new FileWriter(f)
                    );
                fbw.write(THE_FIRST_HIT);
                fbw.flush();
                fbw.close();

                this.realFilePath = f.getAbsolutePath();
            }
            else
                instanceFault();
        }
        catch (IOException e)
        {
            logger.error(e.toString(), e);
        }
    }

    private boolean checkAccessToFile(File fileObj)
    {
        if(fileObj.exists())
            return     fileObj.canRead()
                    && fileObj.canWrite();
        else
            return     fileObj.getParentFile().mkdir()
                    && fileObj.exists();
    }

    public static FileInstance getInstance()
    {
        if (instance == null)
            instance = new FileInstance();

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

    public String getInstancePath()
    {
        return this.instancePath;
    }

    @Override
    public String getPath()
    {
        if (instance == null)
            getInstance();
//        return this.instancePath;
        return this.realFilePath;
    }

    private static FileInstance instance      = null;           // IMPORTANT!!!
    private static final String FILE_NAME     = "visits.dat";
    private        final    int THE_FIRST_HIT = 1;
    private              String instancePath  = "";
    private              String realFilePath  = "";

    private static final org.slf4j.Logger logger =
        org
        .slf4j
        .LoggerFactory
        .getLogger(
            FileInstance.class
    );
}