package pro.yoric.registration.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RegistrationServlet
    extends HttpServlet
{
    @Override
    protected void doGet(
        HttpServletRequest req,
        HttpServletResponse resp
        )
        throws ServletException,
            IOException
    {
        RequestDispatcher requestDispatcher =
            req.getRequestDispatcher("views/signup.jsp");
        requestDispatcher.forward(req, resp);
    }
}
