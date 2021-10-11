package pro.yoric.HitCounter;

import java.io.File;
import java.io.IOException;
import java.net.URI;


class FileInstance
{
    static FileInstance instance = null;                 // IMPORTANT!!!

    private FileInstance(String fileName)                // PRIVATE CONSTRUCTOR
    {
        try
        {
            File f = new File(fileName);

            if (!f.createNewFile())
                this.filePath = f.getPath();             // File already exists
            else
                this.filePath = f.getAbsolutePath();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    static public FileInstance getInstance()             // FACTORY METHOD (can provide the instance)
    {
        if (instance == null)
            instance = new FileInstance(FILENAME);

        return instance;
    }

    public String getPath()
    {
        return this.filePath;
    }

    private static final String       FILENAME = "visit.dat";
    private              String       filePath = "";
}
//    File visits = FileInstance.getInstance(); // GET FILE INSTANCE
//
//        visits.addPath(FILEPATH);
//
//                if()
//                {
//                try
//                {
//                visits.createNewFile();
//                }
//                catch (IOException e)
//                {
//                e.printStackTrace();
//                }
//
//                }





public class DataController
    extends File
{
    public DataController(String pathname)
    {

        super(pathname);
    }

    public DataController(String parent, String child)
    {
        super(parent, child);
    }

    public DataController(File parent, String child)
    {
        super(parent, child);
    }

    public DataController(URI uri)
    {
        super(uri);
    }
}
