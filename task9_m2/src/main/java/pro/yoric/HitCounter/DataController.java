package pro.yoric.HitCounter;

import java.io.*;

public class DataController
    implements IDataController
{
    String file = FileInstance.getPath();

    @Override
    public int getInfo()
        throws IOException
    {
        BufferedReader fbr = new BufferedReader(
                                new FileReader(file)
                            );

        int max = Integer.MIN_VALUE;                    // TODO: Delete if the file will be rewritable

        while ((content = fbr.readLine()) != null)
        {
            if (Integer.parseInt(content) > max)        // TODO: Delete if the file will be rewritable
                quantity = Integer.parseInt(content);
        }
        fbr.close();
        return quantity;
    }

    @Override
    public boolean setInfo()
        throws IOException
    {
        FileWriter fw = new FileWriter(file);

//        if (fw.write(0))
//            return false;

//        fw.write(str.charAt(i));          // System.out.println("Writing successful");

        fw.close();
        return false;
    }

//    public DataController(String pathname) throws IOException { super(pathname); }
//    public DataController(String parent, String child) throws IOException { super(parent, child); }
//    public DataController(File parent, String child) throws IOException { super(parent, child); }
//    public DataController(URI uri) throws IOException { super(uri); }

    private int    quantity;
    private String content;
}
