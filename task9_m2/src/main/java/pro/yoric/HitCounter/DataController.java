package pro.yoric.HitCounter;

import java.io.*;

public class DataController
    implements IDataController
{
    String file = FileInstance.getPath();

    @Override
    public int getInfo()
        throws FileNotFoundException
    {
        FileReader fr = new FileReader(file);
        return 0;
    }

    @Override
    public boolean setInfo()
        throws IOException
    {
        FileWriter fw = new FileWriter(file);
        return false;
    }






    public DataController()
        throws IOException
    {

    }

//        fw.write(str.charAt(i));
//    // System.out.println("Writing successful");
//            fw.close();                                 // close the file
//
//
//    int quantity;                                     // variable declaration
//    FileReader fr = null;                       // check if File exists or not
//
//    try
//    {
//        fr = new FileReader(file);
//    }
//    catch (FileNotFoundException fe)
//    {
//        System.out.println("File not found");
//    }
//
//    public DataController() throws IOException {
//    }
//
//    while((quantity = fr.read()) != -1)              // read from FileReader till the end of file
//        System.out.print((char)quantity);
//
//    fr.close();                                 // close the file




//    public DataController(String pathname) throws IOException {
//
//        super(pathname);
//    }
//
//    public DataController(String parent, String child) throws IOException {
//        super(parent, child);
//    }
//
//    public DataController(File parent, String child) throws IOException {
//        super(parent, child);
//    }
//
//    public DataController(URI uri) throws IOException {
//        super(uri);
//    }
}
