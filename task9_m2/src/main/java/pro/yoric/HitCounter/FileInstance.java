package pro.yoric.HitCounter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileInstance
{
    public static String doCheckInit() { return path; }                     // TODO: DELETE!!!

    public static void doInit(String pathValue)
    {
        path = pathValue;
    }

    static FileInstance instance = null;                    // IMPORTANT!!!

    private FileInstance(File f)                            // PRIVATE CONSTRUCTOR
    {
        try
        {
            if (f.createNewFile())
                shortFilePath = f.getPath();
            else
                shortFilePath = f.getAbsolutePath();

            BufferedWriter fbw =
                    new BufferedWriter(
                            new FileWriter(f)
                    );
            fbw.write(init());
            fbw.flush();
            fbw.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static String getPath()
    {
        if (instance == null)
        {
            File f = new File(path, FILENAME);

            if (f.exists()
                    && f.canRead()
                    && f.canWrite())
                return shortFilePath = f.getAbsolutePath();
            else
            {
                instance = new FileInstance(f);
                return shortFilePath;
            }
        }

        return shortFilePath = path + FILENAME;
    }

    public int init()
    {
        return this.visitsCounter;
    }

    private static final String FILENAME      = "visit.dat";
    private static       String path          = "";
    private static       String shortFilePath = "";
    private                 int visitsCounter = 1;           // IMPORTANT!!! Initialize from one !!!
}