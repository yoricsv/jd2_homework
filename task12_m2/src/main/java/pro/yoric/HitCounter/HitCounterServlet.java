package pro.yoric.HitCounter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;

@WebServlet(name = "HitCounterServlet", urlPatterns = "/task12m2")
public class HitCounterServlet
     extends HttpServlet
{
    @Override
    public void init()
    {
        String absoluteAppPath =
            this.getServletConfig()
                .getServletContext()
                .getRealPath("");
        String path =
            this.getServletConfig()
                .getInitParameter(
                    "WEB_FILE_PATH"
                );
        String imagePath =
            this.getServletConfig()
                .getInitParameter(
                    "WEB_IMAGE_PATH"
                );

        file     = FileInstance.getInstance(absoluteAppPath + path,      false);
        image    = FileInstance.getInstance(absoluteAppPath + imagePath, true);
        iCounter = new HitCounter();

    }

    @Override
    protected void doGet(
            HttpServletRequest  req,
            HttpServletResponse resp
        )
    {
        try
        {
            PrintWriter out = resp.getWriter();

            String amount = iCounter.getCalls();

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
                "The number of visits is: <br/>" +
                "<img alt=\"\" src=\"" + image.getFile(true).getPath() +
                "\" />\n<br/>"
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

            iCounter.setCall();
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
    {
        doGet(req, resp);
    }

    private IHitCounter  iCounter = null;
    private FileInstance file     = null;
    private FileInstance image    = null;

    private static final long   serialVersionUID = 1L;
    private static final Logger logger =
        LoggerFactory
        .getLogger(
            HitCounterServlet.class
    );
}
