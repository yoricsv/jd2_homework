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
import javax.naming.NamingException;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "HitCounterServlet", urlPatterns = "/task9m2")
public class HitCounterServlet
     extends HttpServlet
{
    IHitCounter iHitCounter = new HitCounter();
    FileInstance checkPath  = FileInstance.getInstance();                          //TODO: DELETE!

    @Override
    public void init() throws ServletException
    {
        setInitParam();
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
//                    int amount = iHitCounter.getCalls();                         //TODO: After debugging - UNCOMMENT!

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
                "Initialization path after init: " + checkPath.getPath() + "<br/>"+                 //TODO: DELETE!
                "Initialization path is: " + setInitParam()                        //TODO: DELETE!
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

//            iHitCounter.setCall();                                               //TODO: After debugging - UNCOMMENT!
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

    private String getAllInitParamFromContext()                                     //TODO: DELETE!
    {
        Enumeration <String> initParamNames =
            getServletConfig()
               .getInitParameterNames();

        String paramList = "";

        while (initParamNames.hasMoreElements())
        {
            String param = initParamNames.nextElement();

            paramList +=
                "[ "  + param +
                " = " + getServletConfig()
                            .getInitParameter(param) +
                " ]\n";
        }
         return paramList;
    }



    private String setInitParam()                                                   //TODO: DELETE!
//    private void setInitParam()                                                     //TODO: To check - comment this!
    {
//        String absoluteAppPath = req.getServletContext().getRealPath("");
//        String instanceFilePath = absoluteAppPath + File.separator + "resources\\data\\" + FILENAME;
//        File fileLocation = new File (instanceFilePath);
//        if(!fileLocation.exists())
//            fileLocation.mkdir();

        InitialContext initialContext = null;
        try {
            initialContext = new InitialContext();
            String path = (String) initialContext.lookup("java:comp/env/ENV_FILE_PATH");
            iHitCounter.doInit(path);                                                   //TODO: To check - comment this!
            return path;

        } catch (NamingException e) {
            e.printStackTrace();
        }




        ServletConfig conf = this.getServletConfig();
//        String path        = conf.getInitParameter("WEB_FILE_PATH");
//        iHitCounter.doInit(path);                                                   //TODO: To check - comment this!
//        return path;                                                               //TODO: DELETE!
        return "";
    }


    private static final long   serialVersionUID = 1L;
    private static final Logger logger =
        LoggerFactory
        .getLogger(
            HitCounterServlet.class
    );
}
