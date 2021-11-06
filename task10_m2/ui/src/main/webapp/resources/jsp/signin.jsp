<%@ page
    contentType = "text/html;
                   charset=UTF-8"
    language    = "java"
%>

<%
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
                Welcome!
            </h1>
        </header>

        <div class = "content">

            <div class = "sign_in">
                <div>
                    <p>
                        Information added successfully!
                    </p>
                </div>

                <p>
                    Hello, ${name}!
                    <br/>
                    Below, is the information you entered:
                </p>

                <ul>
                    <li>
                        Name is: ${name}
                    </li>

                <% if ( surname != null && surname != "") { %>
                    <li>
                        Surname is: ${surname}
                    </li>
                <% } %>

                <% if ( phone != null && phone != "") { %>
                    <li>
                        Phone is: ${phone}
                    </li>
                <% } %>
                <% if ( email != null && email != "") { %>
                    <li>
                        E-mail is: ${email}
                    </li>
                <% } %>

                </ul>

                <nav>
                    <button onclick = "location.href = '/ui'">
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