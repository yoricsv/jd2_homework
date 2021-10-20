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
            inputFile = new File(initPath + FILE_NAME);

            if(checkAccessToFile(inputFile))
            {
                BufferedWriter fbw =
                    new BufferedWriter(
                        new FileWriter(inputFile)
                    );
                fbw.write(THE_FIRST_HIT);
                fbw.flush();
                fbw.close();

                this.realFilePath = inputFile.getAbsolutePath();
                this.inputFile = inputFile;
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
//        else
//        {
//            try
//            {
//                return     fileObj.getParentFile().mkdirs()
//                        && fileObj.createNewFile()
//                        && fileObj.canRead()
//                        && fileObj.canWrite();
//            }
//            catch (IOException e)
//            {
//                e.printStackTrace();
//            }
//        }
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
        return this.initPath;
    }
// TODO: DELETE TEMPLATE BLOCK END -------------------------------------------------------------------------------------

    @Override
    public File getFile()
    {
        if (instance == null)
            getInstance();

        return this.inputFile;
    }

    private static FileInstance instance      = null;           // IMPORTANT!!!
    private static final String FILE_NAME     = "visits.dat";
    private        final    int THE_FIRST_HIT = 1;
    private              String initPath      = "";
    private                File inputFile     = null;
// TODO: DELETE TEMPLATE BLOCK BEGIN -----------------------------------------------------------------------------------
    private              String realFilePath  = "";
// TODO: DELETE TEMPLATE BLOCK END -------------------------------------------------------------------------------------
    private static final org.slf4j.Logger logger =
        org
        .slf4j
        .LoggerFactory
        .getLogger(
            FileInstance.class
    );
}