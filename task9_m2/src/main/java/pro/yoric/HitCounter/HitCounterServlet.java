package pro.yoric.HitCounter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HitCounterServlet", urlPatterns = "/task9m2")
public class HitCounterServlet
     extends HttpServlet
{
    IHitCounter iHitCounter = new HitCounter();

    @Override
    public void init()
    {
        absoluteAppPath =
            this.getServletConfig()
                .getServletContext()
                .getRealPath("");
        path =
            this.getServletConfig()
                .getInitParameter(
                    "WEB_FILE_PATH"
                );
        initFilePath = absoluteAppPath + path;

        IFileInstance initFile = FileInstance.getInstance(initFilePath);
// TODO: DELETE TEMPLATE BLOCK BEGIN -----------------------------------------------------------------------------------
        File file = new File(initFilePath + "visits.dat");

        checkReturn(file);

        if (file.canRead()
                && file.canWrite())
            state = "<br/>>>>>>  After creation: Can The file read? - " + file.canRead() +
                    "<br/>>>>>>  After creation: Can The file write? - " + file.canWrite();
// TODO: DELETE TEMPLATE BLOCK END -------------------------------------------------------------------------------------
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
//                    int amount = iHitCounter.getCalls();                            //TODO: After debugging - UNCOMMENT!

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
// TODO: DELETE TEMPLATE BLOCK BEGIN -----------------------------------------------------------------------------------
                "The Path from WEB.XML BEFORE: "                + getWebXmlPath()               + "<br/>"+
                "The servlet absolute path BEFORE: "            + getAbsolutePath()             + "<br/><br/>"+

                "Prepared path to init: "                       + initFilePath                  + "<br/><br/>"+
                "Check BEFORE return throw try/catch: "         + stateBefore                   + "<br/><br/>"+
                "Check AFTER return throw try/catch: "          + state                         + "<br/><br/>"+

                "The Path from WEB.XML AFTER: "                 + getWebXmlPath()               + "<br/>"+
                "The servlet absolute path AFTER: "             + getAbsolutePath()             + "<br/><br/>"//+

//                "The Path before Instance (initFilePath): " + checkPath.getInstancePath()   + "<br/>"+
//                "The Path after Instance (realFilePath): "      + checkPath.getPath()           + "<br/>"
// TODO: DELETE TEMPLATE BLOCK END -------------------------------------------------------------------------------------
//                "The number of visits is: " + amount                              //TODO: After debugging - UNCOMMENT!
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

//            iHitCounter.setCall();                                                //TODO: After debugging - UNCOMMENT!
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

// TODO: DELETE TEMPLATE BLOCK BEGIN -----------------------------------------------------------------------------------
    public String checkBefore(File file)
    {
        if (   file.canRead()
            && file.canWrite())
            return stateBefore =
                "<br/>>>>>> Before creation: Can The file read? - " + file.canRead() +
                "<br/>>>>>> Before creation: Can The file write? - " + file.canWrite();
        return stateBefore = ">>> The File doesn't exist! IT'S RIGHT!!!!";
    }

    public boolean checkReturn(File file)
    {
        checkBefore(file);
        try
        {
            return     file.getParentFile().mkdirs()
                    && file.createNewFile();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public  String getWebXmlPath()  {return path;}
    public  String getAbsolutePath(){return absoluteAppPath;}
    private String path, initFilePath, absoluteAppPath, stateBefore, state;
// TODO: DELETE TEMPLATE BLOCK END -------------------------------------------------------------------------------------

    private static final long   serialVersionUID = 1L;
    private static final Logger logger =
        LoggerFactory
        .getLogger(
            HitCounterServlet.class
    );
}
