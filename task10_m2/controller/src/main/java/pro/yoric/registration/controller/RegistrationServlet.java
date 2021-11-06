package pro.yoric.registration.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import pro.yoric.registration.bean.UserBean;
import pro.yoric.registration.data.UserDAO;
import pro.yoric.registration.data.SessionHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
            userName    = req.getParameter("name");
            userSurname = req.getParameter("surname");
            userPhone   = req.getParameter("phone");
            userEmail   = req.getParameter("email");

            resp.setContentType("text/html; charset=UTF-8");

            addCookies(req, resp);
            addSession(req);

            String path;
            if (!isSignUpSuccess())
                path = "resources/jsp/failure.jsp";
            else
            {
                UserBean bean =
                    new UserBean(
                        userName,
                        userSurname,
                        userPhone,
                        userEmail
                    );
                dao.addUser(bean);
                path = "resources/jsp/signin.jsp";
            }

            prepareRequest(req);
            req.getRequestDispatcher(path).forward(req, resp);
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

    private void prepareRequest(HttpServletRequest req)
    {
        req.setAttribute("name",    userName);
        req.setAttribute("surname", userSurname );
        req.setAttribute("phone",   userPhone );
        req.setAttribute("email",   userEmail );
    }
    private boolean isSignUpSuccess()
    {
        return
            userName != null
        && !userName.equals("")
        && (
                    userPhone != null
                && !userPhone.equals("")
                ||  userEmail != null
                && !userEmail.equals("")
            );
    }

    private void addCookies (
            HttpServletRequest  req,
            HttpServletResponse resp
        )
    {
        Cookie cookie =
            new Cookie(
                "SIGNUP",
                req.getHeader("Referer")
            );
        cookie.setPath("/resources/cookies");
        cookie.setMaxAge(-1);
        resp.addCookie(cookie);
    }

    private void addSession(HttpServletRequest  req)
    {
        SessionHandler session = new SessionHandler(req);

        session.addKeyValue("name",    userName);
        session.addKeyValue("surname", userSurname);
        session.addKeyValue("phone",   userPhone);
        session.addKeyValue("email",   userEmail);
    }

    private UserDAO dao;
    private String  userName;
    private String  userSurname;
    private String  userPhone;
    private String  userEmail;

    private static final long   serialVersionUID = 1L;
    private static final Logger logger =
        LoggerFactory
        .getLogger(
            RegistrationServlet.class
        );
}
