package pro.yoric.registration.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import pro.yoric.registration.bean.UserBean;
import pro.yoric.registration.data.UserDAO;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/signup")
public class RegistrationServlet
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
            HttpSession session     = req.getSession();
            String      userName    = req.getParameter("name");
            String      userSurname = req.getParameter("surname");
            String      userPhone   = req.getParameter("phone");
            String      userEmail   = req.getParameter("email");
            String      reference   = req.getHeader("Referer");

            resp.setContentType("text/html; charset=UTF-8");

            if ( !isSignUpSuccess(
                    userName,
                    userPhone,
                    userEmail
                ))
                path = "resources/jsp/failure.jsp";
            else
            {
                bean = new UserBean (
                            userName,
                            userSurname,
                            userPhone,
                            userEmail
                        );
                dao.addUser(bean);

                addSignUpCookies(resp, reference);

                addDataToSession(
                    session,
                    userName,
                    userSurname,
                    userPhone,
                    userEmail
                );

                path = "resources/jsp/signin.jsp";
            }

            req.setAttribute("name",    userName);
            req.setAttribute("surname", userSurname );
            req.setAttribute("phone",   userPhone );
            req.setAttribute("email",   userEmail );

            RequestDispatcher requestDispatcher =
                req.getRequestDispatcher(path);
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

    private boolean isSignUpSuccess(
            String name,
            String phone,
            String email
        )
    {
        return
            name != null
        && !name.isEmpty()
        && (
                    phone != null
                && !phone.isEmpty()
                ||  email != null
                && !email.isEmpty()
            );
    }

    private void addSignUpCookies (
            HttpServletResponse resp,
            String              reference
        )
    {
        Cookie cookie =
                new Cookie(
                    "SIGNUP",
                    reference
                );
        cookie.setPath("/resources/cookies");
        cookie.setMaxAge(-1);
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

        session.setMaxInactiveInterval(86400);
        session.setMaxInactiveInterval(-1);
    }

    private List<String> getAllFromSession(HttpSession session)
    {
        List<String> sessionList = new ArrayList<>();

        Enumeration<String> keys = session.getAttributeNames();

        while(keys.hasMoreElements())
        {
            sessionList.add(keys.nextElement());
        }

        return sessionList;
    }

    private UserBean bean;
    private UserDAO  dao;
    private String   path;

    private static final org.slf4j.Logger logger =
        org
        .slf4j
        .LoggerFactory
        .getLogger(
            RegistrationServlet.class
        );
}
