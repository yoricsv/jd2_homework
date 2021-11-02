package pro.yoric.registration.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import pro.yoric.registration.data.UserBean;

@WebServlet(name = "UserListServlet", urlPatterns = "/users")
public class UsersListServlet
    extends HttpServlet
{
    @Override
    public void init(ServletConfig config)
        throws ServletException
    {
        super.init(config);
    }

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp
        )
    {
        try
        {
            bean.getName();
            bean.getSurname();
            bean.getPhone();
            bean.getEmail();

            RequestDispatcher requestDispatcher =
                req.getRequestDispatcher(
                    "resources/jsp/users.jsp"
                );
            requestDispatcher.forward(req, resp);
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

    private UserBean bean;
    private static final org.slf4j.Logger logger =
            org
            .slf4j
            .LoggerFactory
            .getLogger(
                    RegistrationServlet.class
            );

}



