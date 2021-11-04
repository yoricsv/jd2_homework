<%@ page language="java" %>

<!DOCTYPE html>
<html lang = "en">

<%@ include file="../blocks/head.jsp" %>

<body>
    <div id = "wrapper">

        <header>
            <h1>
                Registered users
            </h1>
        </header>

        <div class = "content">

            <div class = "sign_in">
                <div>
                    <p>
                        List of the users
                    </p>
                </div>

                <ul class = "users">

                    <%
                        List<String> names = (List<String>) req.getAttribute("userNames");

                        if (    names != null
 //                           && !names.isEmpty()
                            )
                        {
                            for (String userNames : names)
                            {
                                out.println(
                                    "<li>" +
                                        userNames +
                                    "</li>"
                                );
                            }
                        }
                    %>
                    <%-- <li>
                        Anton
                        <!-- Anton -->
                    </li>
                    <li>
                        Tanya
                        <!-- Tanya -->
                    </li>
                    <li>
                        Barbara
                        <!-- Barbara -->
                    </li> --%>

                </ul>

                <nav class = "err">
                    <button onclick = "location.href = '/ui'">
                        Back to main
                    </button>

                    <button onclick = "location.href = '/ui/users'">
                        Reload list
                    </button>
                </nav>
            </div>

        </div>

<%@ include file="../blocks/footer.jsp" %>
    </div>

</body>
</html>