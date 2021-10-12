package pro.yoric.HitCounter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.*;

class FileInstance
{
    static FileInstance instance = null;                    // IMPORTANT!!!

    private FileInstance(File f)                            // PRIVATE CONSTRUCTOR
    {
        try
        {
            if (!f.createNewFile())
            {
                BufferedWriter fbw =
                    new BufferedWriter(
                        new FileWriter(f)
                );
                fbw.write(0);
                fbw.flush();
                fbw.close();
                shortFilePath = f.getPath();
            }
            else
                shortFilePath = f.getAbsolutePath();

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
            File f = new File(FILEPATH, FILENAME);

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

        return shortFilePath = FILEPATH + FILENAME;
    }

    private static final String FILENAME      = "visit.dat";
    private static final String FILEPATH      = "resources/";
    private static       String shortFilePath = "";
}