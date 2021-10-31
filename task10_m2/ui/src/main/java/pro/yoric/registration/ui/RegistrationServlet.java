package pro.yoric.registration.ui;

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
