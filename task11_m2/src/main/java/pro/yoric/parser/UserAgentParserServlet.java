package pro.yoric.parser;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;

@WebServlet(name = "UserAgentParser", urlPatterns = "/detect")
public class UserAgentParserServlet
    extends HttpServlet
{
//    @Override
//    public void init(ServletConfig config)
//            throws ServletException
//    {
//        super.init(config);
//    }

    @Override
    protected void doGet(
            HttpServletRequest  req,
            HttpServletResponse resp
        )
    {
        try
        {
            PrintWriter out = resp.getWriter();
            req.setAttribute("uas", "agent");

            String uas = (String) req.getAttribute("uas");

            out.println(
                    "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <link href=\"resources/css/style.css\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
                    "    <title> Test servlet </title> \n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <div id = \"wrapper\">\n" +
                    "        <header><h1> Test </h1></header>\n" +
                    "        <div class = \"content\">\n" +
                    "            <p>\n" +

                    "Test value: " + uas +

                    "            </p>\n" +
                    "        </div>\n" +
                    "        <footer></footer>\n" +
                    "    </div>\n" +
                    "</body>\n" +
                    "</html>"
            );


            req.getRequestDispatcher("/index.jsp").forward(req, resp);
//            getServletContext().getRequestDispatcher("/parser/index.jsp").forward(req, resp);
        }
        catch (Exception e)
        {
            logger.trace(e.toString(), e);
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

    private static final long   serialVersionUID = 1L;
    private static final Logger logger =
        LoggerFactory
        .getLogger(
            UserAgentParserServlet.class
        );
}
