package pro.yoric.HitCounter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.InitialContext;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;

@WebServlet(name = "HitCounterServlet", urlPatterns = "/task9m2")
public class HitCounterServlet
     extends HttpServlet
{
    IHitCounter iHitCounter = new HitCounter();
    FileInstance checkPath  = FileInstance.getInstance();       //TODO: DELETE!

    @Override
    public void init()
    {
//       checkPath.doInit(setInitParam());
    }

    @Override
    protected void doGet(
        HttpServletRequest  req,
        HttpServletResponse resp
    )
        throws ServletException,
               IOException
    {
        try
        {
            PrintWriter out    = resp.getWriter();
//                    int amount = iHitCounter.getCalls();      //TODO: After debugging - UNCOMMENT!

            out.println(
                "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "\n" +
                "<head>\n" +
                "    <meta   charset     = \"utf-8\"/>\n" +
                "    <meta   content     = \"ie=edge\"\n" +
                "            http-equiv  = \"x-ua-compatible\"/>\n" +
                "\n" +
                "    <link   href        = \"resources/css/style.css\"\n" +
                "            media       = \"all\"\n" +
                "            rel         = \"stylesheet\"\n" +
                "            type        = \"text/css\"/>\n" +
                "\n" +
                "    <title>\n" +
                "        First servlet\n" +
                "    </title> \n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "    <div id = \"wrapper\">\n" +
                "\n" +
                "        <header>\n" +
                "            <h1>\n" +
                "                The visits counter via file\n" +
                "            </h1>\n" +
                "        </header>\n" +
                "\n" +
                "        <div class = \"content\">\n" +
                "            <p>\n"
            );

            out.println(
                "The Path from WEB.XML: " + getWebXmlPath()  + "<br/>"+
                "The servlet absolute path: " + getAbsolutePath()  + "<br/><br/>"+
                "Prepared path to init: " + setInitParam()  + "<br/>"+
                        "Check BEFORE return throw try/catch: " + stateBefore  + "<br/>"+
                        "Check AFTER return throw try/catch: " + state  + "<br/><br/>"+
//                "" + state  + "<br/>"+
                "The Path before Instance (instanceFilePath): " + checkPath.getInstancePath() + "<br/>"+
                "The Path after Instance (realFilePath): " + checkPath.getPath() + "<br/>"

//                "The number of visits is: " + amount          //TODO: After debugging - UNCOMMENT!
            );

            out.println(
                "            </p>\n" +
                "        </div>\n" +
                "\n" +
                "        <footer>\n" +
                "            <p>\n" +
                "                <b>\n" +
                "                     Developed by: \n" +
                "                </b>\n" +
                "                Sergei Selivonchyk\n" +
                "            </p>\n" +
                "            <p>\n" +
                "                <b>\n" +
                "                     Contact information:\n" +
                "                </b>\n" +
                "                <br/>\n" +
                "                <b>\n" +
                "                     Follow Me:\n" +
                "                </b>\n" +
                "                <a href=\"https://www.linkedin.com/in/yoric/\">\n" +
                "                     LinkedIn\n" +
                "                </a>\n" +
                "                <br/>\n" +
                "                <b>\n" +
                "                     E-mail:\n" +
                "                </b>\n" +
                "                <a href = \"my e-mail:\" onclick = \"this.href = 'mailto:yoricsv@yandex.ru'\">\n" +
                "                    yoricsv@yandex.ru\n" +
                "                </a>\n" +
                "            </p>\n" +
                "        </footer>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>"
            );

//            iHitCounter.setCall();                            //TODO: After debugging - UNCOMMENT!
        }
        catch(Exception e)
        {
            logger.error(e.toString(), e);
        }
    }

    @Override
    protected void doPost(
        HttpServletRequest  req,
        HttpServletResponse resp
    )
        throws ServletException,
               IOException
    {
        doGet(req, resp);
    }


    private String setInitParam()                               //TODO: DELETE!
//    private void setInitParam()                               //TODO: To check - comment this!
    {
        absoluteAppPath    = this.getServletConfig().getServletContext().getRealPath("");
        path               = this.getServletConfig().getInitParameter("WEB_FILE_PATH");
        instanceFilePath   = absoluteAppPath + path;

        File file = new File(instanceFilePath + "visits.dat");

        checkReturn(file);

//            return file.getParentFile().mkdirs()
//            && file.createNewFile();
        if (file.canRead()
        && file.canWrite())
            state = "After creation Can The file read? - " + file.canRead() +
                    "After creation Can The file write? - " + file.canWrite();

        return instanceFilePath;//file.getPath();

        /* NIO */
//        Path path = Paths.get(instanceFilePath + "visits.dat"); //"data/logging.properties"
//        Path path = Paths.get(instanceFilePath);//"data/subdir"
//
//        boolean pathExists =
//            Files.exists(
//                path,
//                LinkOption.NOFOLLOW_LINKS
//            );
//
//        try
//        {
//            Path newDir = Files.createDirectory(path);
//        }
//        catch(FileAlreadyExistsException e)
//        {
//            logger.warn(e.toString(), e);
//        }
//        catch (IOException e)
//        {
//            logger.trace(e.toString(), e);
//        }
//        return instanceFilePath ;

//        iHitCounter.doInit(path);                             //TODO: To check - comment this!
    }

    public String checkBefore(File file)
    {
        if (   file.canRead()
                && file.canWrite())
            return stateBefore = "Before creation Can The file read? - " + file.canRead() +
                    "Before creation Can The file write? - " + file.canWrite();
        return stateBefore = "File not exist! IT'S RIGHT!!!!";
    }

    public boolean checkReturn(File file)
    {
        checkBefore(file);
        try
        {
            return file.getParentFile().mkdirs()
                    && file.createNewFile();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return false;
    }


    public String getWebXmlPath()  {return path;}               //TODO: DELETE!
    public String getAbsolutePath(){return absoluteAppPath;}    //TODO: DELETE!
    private String path, instanceFilePath, absoluteAppPath, stateBefore, state;     //TODO: DELETE!




    private static final long   serialVersionUID = 1L;
    private static final Logger logger =
        LoggerFactory
        .getLogger(
            HitCounterServlet.class
    );
    private      InitialContext initialContext   = null;
}
