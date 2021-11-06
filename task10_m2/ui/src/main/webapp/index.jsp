<%@ page
    contentType = "text/html;
                   charset=UTF-8"
    language    = "java"
%>

<%
    String name    = request.getParameter("name");
    String surname = request.getParameter("surname");
    String phone   = request.getParameter("phone");
    String email   = request.getParameter("email");
%>

<!DOCTYPE html>
<html lang = "en">

<head>
    <meta   charset     = "utf-8"/>
    <meta   content     = "ie=edge"
            http-equiv  = "x-ua-compatible"/>

    <link   href        = "resources/css/style.css"
            media       = "all"
            rel         = "stylesheet"
            type        = "text/css"/>

    <title>
        Registration
    </title> 
</head>

<body>
    <div id = "wrapper">

        <header>
            <h1>
                Welcome! Please, sign up before using.
            </h1>
        </header>

        <div class = "content">

            <form action = "/ui/signup"
                  method = "get">
                <fieldset>
                    <legend>
                        <p>
                            Sign Up
                        </p>
                    </legend>

                    <label class = "required"
                           for   = "name">
                            Name:
                    </label>
                    <br/>
                    <input name        = "name" required
                           placeholder = "required your name or nickname"
                           type        = "text"
                           value       = "<%
                                if(    name == null
                                    || name.equals("")
                                    || name.equals("null")
                                    )
                                    out.print("");
                                else
                                    out.print(name); %>"
                    >
                    <br/>

                    <label for = "surname">
                        Surname:
                    </label>
                    <br/>
                    <input name        = "surname"
                           type        = "text"
                           value       = "<%
                                if(    surname == null
                                    || surname.equals("")
                                    || surname.equals("null")
                                    )
                                    out.print("");
                                else
                                    out.print(surname); %>" 
                    >
                    <br/>

                    <label for = "phone">
                        Phone:
                    </label>
                    <br/>
                    <input name        = "phone"
                           placeholder = "enter your phone"
                           type        = "tel"
                           value       = "<%
                                if(    phone == null
                                    || phone.equals("")
                                    || phone.equals("null")
                                    )
                                    out.print("");
                                else
                                    out.print(phone); %>" 
                    >
                    <br/>

                    <label for   = "email">
                        E-mail:
                    </label>
                    <br/>
                    <input name        = "email"
                           placeholder = "enter your e-mail"
                           type        = "email"
                           value       = "<%
                                if(    email == null
                                    || email.equals("")
                                    || email.equals("null")
                                    )
                                    out.print("");
                                else
                                    out.print(email); %>" 
                    >
                    <br/>

                    <nav>
                        <button onclick = "location.href = '/ui/signup'">
                            Sign Up
                        </button>
                    </nav>
                </fieldset>
            </form>
           
        </div>

<%@ include file="resources/blocks/footer.jsp" %>
    </div>

</body>
</html>