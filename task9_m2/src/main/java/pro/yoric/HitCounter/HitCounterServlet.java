package pro.yoric.HitCounter;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "HitCounterServlet", urlPatterns = "/task9m2")
public class HitCounterServlet
     extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest  req,
                         HttpServletResponse resp)
        throws ServletException,
               IOException
    {
        try
        {
//            setInitParam();
            String checkPath = FileInstance.doCheckInit();



            PrintWriter out    = resp.getWriter();
//                    int amount = iHitCounter.getVisits();                         //TODO: UNCOMMENT!

            out.println(
                "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "\n" +
                "<head>\n" +
                "    <meta   charset     = \"utf-8\"/>\n" +
                "    <meta   content     = \"ie=edge\"\n" +
                "            http-equiv  = \"x-ua-compatible\"/>\n" +
                "\n" +
                "    <link   href        = \"css/style.css\"\n" +
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
                "                This is First Servlet!\n" +
                "            </h1>\n" +
                "        </header>\n" +
                "\n" +
                "        <div class = \"content\">\n" +
                "            <p>\n"
            );

            out.println(
//                "The number of visits is: " +
                        "'filePath' contains: " +
                        setInitParam()
//                        checkPath                                                   //TODO: DELETE!
//                amount                                                            //TODO: UNCOMMENT!
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

//            iHitCounter.setVisit();                                               //TODO: UNCOMMENT!
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest  req,
                          HttpServletResponse resp)
        throws ServletException,
               IOException
    {
        doGet(req, resp);
    }

    private String setInitParam()//void setInitParam()
    {
        ServletConfig conf = getServletConfig();
        path = conf.getInitParameter("filePath");
        return path;
//        iHitCounter.doInitParam(path);
    }

    private static final long        serialVersionUID = 1L;
    private              IHitCounter iHitCounter      = null;
    private static       String      path;
}
