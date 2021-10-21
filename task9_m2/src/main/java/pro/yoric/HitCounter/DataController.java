package pro.yoric.HitCounter;

import java.io.*;
import java.util.Scanner;

public class DataController
    implements IDataController
{
    IFileInstance file = FileInstance.getInstance();

    public DataController() {this(null);}

    public DataController(IFileInstance file) {
        this.file = file;
    }

    public String checkPath()
    {
        return file.getFile().getPath();
    }

    @Override
    public String getInfo()
//        throws IOException
    {
        try
        {
            BufferedReader readInfo =
                    new BufferedReader(
                            new FileReader(file.getFile())
                    );

            while (readInfo.readLine() != null)
                quantity = String.valueOf(readInfo);

            readInfo.close();



//            BufferedWriter fbw =
//                new BufferedWriter(
//                    new FileWriter(file.getFile())
//                );
//            fbw.write("2");
//            fbw.flush();
//            fbw.close();

            return quantity;
        }
        catch (IOException e)
        {
            System.out.println("Method getInfo!");
        }

//        BufferedWriter fbw =
//                    new BufferedWriter(
//                        new FileWriter(file.getFile())
//                    );
//                fbw.write("Test data 2");
//                fbw.flush();
//                fbw.close();


//        FileWriter writer = new FileWriter(file.getFile());
//        writer.write("Test data");
//        writer.close();



//        Scanner scanner = new Scanner(file.getFile());
//
//        quantity = 0;
//        while(scanner.){
//            quantity = Integer.parseInt(String.valueOf(scanner.nextInt()));
//        }





//        FileInputStream fileInputStream = new FileInputStream(file.getFile());
//
//        int i;
//
//        while((i = fileInputStream.read()) != -1)
//        {
//            quantity = i;
//        }


//        FileReader scanner = new FileReader(file.getFile());
//        char[] buf = new char[4096];
//        int c = scanner.read(buf);
//        StringBuilder sb = new StringBuilder();
//        while(c != -1)
//        {
//            quantity = scanner.read(buf);
//        }



//        FileInputStream fileDataStream =              new FileInputStream(file.getFile());
//        FileReader      fileDataRead   = (FileReader) new InputStreamReader(fileDataStream, "utf-8");
//        BufferedReader  fbr            =              new BufferedReader(fileDataRead);
//
////        BufferedReader fbr =
////            new BufferedReader(
////                new InputStreamReader(
////                    new FileInputStream(file.getFile()), "utf-8")
////        );
//quantity = Integer.parseInt(String.valueOf(fbr));
////        quantity = Integer.parseInt(fbr.readLine());
////        int max = Integer.MIN_VALUE;                                      // TODO: Delete if the file will be rewritable
////
////        while ((content = fbr.readLine()) != null)
////        {
////            if (Integer.parseInt(content) > max)                          // TODO: Delete if the file will be rewritable
////                quantity = Integer.parseInt(content);
////        }
//        fbr.close();
//        fileDataRead.close();
        return quantity = null;
    }

    @Override
    public void setInfo(int newValue)
        throws IOException
    {


//        FileOutputStream fileOutputStream = new FileOutputStream(file.getFile());
//
//        String greetings = "Привет! Добро пожаловать на JavaRush - лучший сайт для тех, кто хочет стать программистом!";
//
//        fileOutputStream.write(greetings.getBytes());
//
//        fileOutputStream.close();



//        BufferedWriter fbw =
//            new BufferedWriter(
//                 new FileWriter(file.getFile())
//        );

        FileWriter fbw =
            new FileWriter(file.getFile(), false);
        fbw.write(String.valueOf(newValue));
        fbw.flush();
        fbw.close();
    }



//    private boolean checkAccessToFile(File FilePtr)
//    {
//        if(FilePtr.exists())
//            return     FilePtr.canRead()
//                    && FilePtr.canWrite();
//        else
//        {
//            try {
//                return FilePtr.canRead()
//                        && FilePtr.canWrite();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return false;
//    }

    private String quantity;
}
