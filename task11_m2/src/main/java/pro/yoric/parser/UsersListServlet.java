package pro.yoric.parser;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(name = "UsersListServlet", urlPatterns = "/users")
public class UsersListServlet
    extends HttpServlet
{
    @Override
    public void init(ServletConfig config)
        throws ServletException
    {
        super.init(config);

        dao = UserDAO.getInstance();
    }

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp
        )
    {
        try
        {
            List<String> names = dao.getUsersList();

            req.setAttribute("userNames", names);

            req.getRequestDispatcher(
                "resources/jsp/users.jsp"
            ).forward(req, resp);
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

    private UserDAO  dao;

    private static final long   serialVersionUID = 2L;
    private static final Logger logger =
        LoggerFactory
        .getLogger(
            RegistrationServlet.class
        );
}



