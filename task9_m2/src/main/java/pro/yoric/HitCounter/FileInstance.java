package pro.yoric.HitCounter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileInstance
    implements IFileInstance
{
    @Override
    public void doInit(String pathValue)
    {
        instancePath = pathValue;
    }

    @Override public String checkInit() { return instancePath; }          // TODO: DELETE!!!

    private FileInstance()                                      // PRIVATE CONSTRUCTOR
    {
        try
        {
            File f = new File(instancePath, FILE_NAME);

            if (!checkAccessToFile(f))
            {
                f.createNewFile();
                if (!checkAccessToFile(f))
                    logger.error(
                        "Error! Check The Path or Access rights"
                    );
                else
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
            }
            else
                this.realFilePath = f.getAbsolutePath();
        }
        catch (IOException e)
        {
            logger.debug(e.toString(), e);
        }
    }

    private boolean checkAccessToFile(File fileObj)
    {
        if (   fileObj.exists()
            && fileObj.canRead()
            && fileObj.canWrite())
            return true;
        else
            return false;
    }

    public static FileInstance getInstance()
    {
        if (instance == null)
            instance = new FileInstance();

        return instance;
    }

    @Override
    public String getPath()
    {
        if (instance == null)
            getInstance();

        return this.realFilePath;
    }

    private static FileInstance instance      = null;           // IMPORTANT!!!
    private static final String FILE_NAME     = "visit.dat";
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