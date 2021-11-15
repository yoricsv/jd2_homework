package pro.yoric.parser;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
            String input = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:95.0) Seamonkey/23.23 Gecko/20100101 Firefox/95.0";

            StringController controller = new StringController();

//            req.setAttribute("uas", controller.parse(req.getHeader("User-agent")));       //TODO: When Parser start to work use this

            String fromParser = controller.parse(req.getHeader("User-agent"));

            if(fromParser == null)
                req.setAttribute("uas", "controller return NULL");
            else
                req.setAttribute("uas", fromParser);

//            Matcher matcher =
//                Pattern.compile(
//                    Pattern.quote(
//                        "(.*)(^Seamonkey)/(\\d+)(.*)(Firefox|MozillaDeveloperPreview)(.*Tablet\\sbrowser)?/(\\d+)(.*)$"
//                    )
//                ).matcher(input);
//
//            Matcher matcher = pattern.matcher(input);
//
//            if(matcher.matches())
//                req.setAttribute("uas", "IS FIREFOX");
//            else
//                req.setAttribute("uas", "IS SEAMONKEY");


//            PrintWriter out = resp.getWriter();
//            String uas = (String) req.getAttribute("uas");
//            out.println(
//                    "<!DOCTYPE html>\n" +
//                    "<html lang=\"en\">\n" +
//                    "<head>\n" +
//                    "    <link href=\"resources/css/style.css\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
//                    "    <title> Test servlet </title> \n" +
//                    "</head>\n" +
//                    "<body>\n" +
//                    "    <div id = \"wrapper\">\n" +
//                    "        <header><h1> Test </h1></header>\n" +
//                    "        <div class = \"content\">\n" +
//                    "            <p>\n" +
//
//                    "Test value: " + uas +
//
//                    "            </p>\n" +
//                    "        </div>\n" +
//                    "        <footer></footer>\n" +
//                    "    </div>\n" +
//                    "</body>\n" +
//                    "</html>"
//            );


            req.getRequestDispatcher("/index.jsp").forward(req, resp);
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
