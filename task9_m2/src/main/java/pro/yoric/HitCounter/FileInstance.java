package pro.yoric.HitCounter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FileInstance
{
    static FileInstance instance = null;                    // IMPORTANT!!!

    private FileInstance(File f)                            // PRIVATE CONSTRUCTOR
    {
        try
        {

            if (f.createNewFile())                         // TODO: Need Check this!
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
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static String getPath()
    {
        if (instance == null)
        {
            File f = new File(/*FILEPATH,*/ FILENAME);            // TODO: Problem with path!

            if (   f.exists()
                && f.canRead()
                && f.canWrite())
                return shortFilePath = f.getAbsolutePath();
            else
            {
                instance = new FileInstance(f);
                return shortFilePath;
            }
        }

        return shortFilePath = /*FILEPATH +*/ FILENAME;            // TODO: Problem with path!
    }

    public int init()
    {
        return this.visitsCounter;
    }

    private static final String FILENAME      = "visit.dat";
    private static final String FILEPATH      = "src/main/webapp/resources";
    private static       String shortFilePath = "";
    private              int    visitsCounter = 1;              // Initialize from one !!!

//    public static void main(String[] args) {
//        System.out.println(getPath());
//    }
}