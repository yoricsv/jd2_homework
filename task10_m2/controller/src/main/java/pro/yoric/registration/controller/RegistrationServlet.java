package pro.yoric.registration.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import pro.yoric.registration.data.UserBean;

import java.util.Date;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/signup")
public class RegistrationServlet
    extends HttpServlet
{
    @Override
    public void init(ServletConfig config)
        throws ServletException
    {
        super.init(config);

        bean = new UserBean();
    }

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp
        )
    {
        try
        {
            HttpSession session     = req.getSession();
            Date        currentDate = new Date();

            String      userName    = req.getParameter("name");
            String      userSurname = req.getParameter("surname");
            String      userPhone   = req.getParameter("phone");
            String      userEmail   = req.getParameter("email");

            bean.setName(userName);
            bean.setSurname(userSurname);
            bean.setPhone(userPhone);
            bean.setEmail(userEmail);

            addSignUpCookies(resp, currentDate);

            addDataToSession(
                session,
                userName,
                userSurname,
                userPhone,
                userEmail
            );

            RequestDispatcher requestDispatcher =
                req.getRequestDispatcher(
                    "resources/jsp/signin.jsp"
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

    private void addSignUpCookies (
            HttpServletResponse resp,
            Date                currentDate
        )
    {
        Cookie cookie =
                new Cookie(
                    "SIGNUP",
                    String.valueOf(currentDate)
                );

        cookie.setMaxAge(300);
        resp.addCookie(cookie);
    }

    private void addDataToSession (
            HttpSession session,
            String      userName,
            String      userSurname,
            String      userPhone,
            String      userEmail
        )
    {
        session.setAttribute("name",    userName);
        session.setAttribute("surname", userSurname );
        session.setAttribute("phone",   userPhone );
        session.setAttribute("email",   userEmail );

        session.getLastAccessedTime();
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
