<%@ page language="java" %>




<!DOCTYPE html>
<html lang = "en">

<%@ include file="../blocks/head.jsp" %>

<body>
    <div id = "wrapper">

        <header>
            <h1>
                ERROR!
            </h1>
        </header>

        <div class = "content">

            <div class = "sign_in err">
                <div>
                    <p>
                        Inability to add information. Required fields are empty!
                    </p>
                </div>

                <p>
                    You must enter your name with e-mail address or phone number.
                    <br/>
                    Please, go back and fill in all required fields.
                </p>

                <%! final String WARNING = "<span></span>"; %>

                <ul>
                    <li>
                        Name is: 
                        <%
                            (<%= request.getParameter("name") %> == null)
                                ? request.getParameter("name") 
                                : "<%= WARNING %>"
                        %>
                    </li>
                    <li>
                        Surname is: 
                        <%
                            (<%= request.getParameter("surname") %> == null)
                                ? request.getParameter("surname") 
                                : "<%= WARNING %>"
                        %>
                    </li>
                    <li>
                        Phone is: 
                        <%
                            (<%= request.getParameter("phone") %> == null)
                                ? request.getParameter("phone") 
                                : "<%= WARNING %>"
                        %>
                    </li>
                    <li>
                        E-mail is: 
                        <%
                            (<%= request.getParameter("email") %> == null)
                                ? request.getParameter("email") 
                                : "<%= WARNING %>"
                        %>
                    </li>
                </ul>

                <nav class = "err">
                    <button onclick = "location.href = '/'">
                        Back to main
                    </button>

                    <button onclick = "location.href = '/users'">
                        See users list
                    </button>
                </nav>
            </div>

        </div>

<%@ include file="../blocks/footer.jsp" %>
    </div>

</body>
</html>