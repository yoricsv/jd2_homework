<%@ page
    contentType = "text/html;
                   charset=UTF-8"
    language    = "java"
%>

<%
    final   String WARNING = "<span></span>";
            String name    = (String) request.getAttribute("name");
            String surname = (String) request.getAttribute("surname");
            String phone   = (String) request.getAttribute("phone");
            String email   = (String) request.getAttribute("email");
%>

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

                
                <ul>
                    <li>
                        Name is: 
                        <%
                            if (    name != null
                                && !name.equals("")
                                )
                                out.print(name); 
                            else
                                out.print(WARNING);
                        %>
                    </li>
                    <li>
                        Surname is: 
                        <%
                            if (    surname != null
                                && !surname.equals("")
                                )
                                out.print(surname); 
                            else
                                out.print(WARNING);
                        %>
                    </li>
                    <li>
                        Phone is: 
                        <%
                            if (    phone != null
                                && !phone.equals("")
                                )
                                out.print(phone); 
                            else
                                out.print(WARNING);
                        %>
                    </li>
                    <li>
                        E-mail is: 
                        <%
                            if (    email != null
                                && !email.equals("")
                                )
                                out.print(email); 
                            else
                                out.print(WARNING);
                        %>
                    </li>
                </ul>

                <nav class = "err">
                    <button onclick = "location.href =
                        '/ui/index.jsp?name=<%= name %>&surname=<%= surname %>&phone=<%= phone %>&email=<%= email %>'">
                        Back to main
                    </button>

                    <button onclick = "location.href = '/ui/users'">
                        See users list
                    </button>
                </nav>
            </div>

        </div>

<%@ include file="../blocks/footer.jsp" %>
    </div>

</body>
</html>