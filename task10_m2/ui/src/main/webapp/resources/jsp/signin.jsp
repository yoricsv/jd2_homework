<%@ page language="java" contentType="text/html; charset=UTF-8" %>

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
                    Hello, <% out.print(request.getAttribute("name")); %>!
                    <br/>
                    Below, is the information you entered:
                </p>

                <ul>
                    <li>Name is: <% out.print(request.getAttribute("name")); %>
                    </li>

                    <%
                        if (request.getAttribute("surname") != null)
                        {
                            out.println(
                                "<li>Surname is: "              +
                                    request.getAttribute("surname") +
                                "</li>"
                            );
                        }
                        if (request.getAttribute("phone") != null)
                        {
                            out.println(
                                "<li>Phone is: "                +
                                    request.getAttribute("phone")   +
                                "</li>"
                            );
                        }

                        if (request.getAttribute("email") != null)
                        {
                            out.println(
                                "<li>E-mail is: "               +
                                    request.getAttribute("email")   +
                                "</li>"
                            );
                        }

                    %>

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