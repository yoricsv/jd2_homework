package pro.yoric.parser;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(name = "UserAgentParser", urlPatterns = "/parser")
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
            req.getSession().setAttribute("uas", "agent");

            req.getRequestDispatcher("/parser/index.jsp").forward(req, resp);
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
