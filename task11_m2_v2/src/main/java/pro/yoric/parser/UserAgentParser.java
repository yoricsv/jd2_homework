package pro.yoric.parser;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "UserAgentParser", urlPatterns = "/parser")
public class UserAgentParser
    extends HttpServlet
{
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
        )
        throws ServletException,
               IOException
    {
        request.setAttribute("uas", "agent");       // uas - user agent servlet
        request.getRequestDispatcher("/parser/index.jsp").forward(request, response);
    }
    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
        )
        throws ServletException,
               IOException
    {
        doGet(request, response);
    }
}
