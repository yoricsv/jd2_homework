<%@ page
    contentType = "text/html;
                   charset=UTF-8"
    import      = "java.util.List"
    language    = "java"
%>

<% List<String> names = (List<String>) request.getAttribute("userNames"); %>

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
                        if (    names != null
                            && !names.isEmpty()
                            )
                            for (String userName : names)
                                out.println(
                                    "<li> " +
                                        userName +
                                    "</li>"
                                );
                    %>

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