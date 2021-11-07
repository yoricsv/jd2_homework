<%@ page
    contentType = "text/html;
                   charset=UTF-8"
    language    = "java"
%>

<% String agent   = (String) request.getAttribute("agent"); %>

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
        User-Agent Parser
    </title> 
</head>

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
                        Browser type detection
                    </p>
                </div>

                <p>
                    Hello, ${agent} user!
                </p>

                <nav>
                    <button onclick = "location.href = '/parser'">
                        Update page
                    </button>
                </nav>
            </div>
           
        </div>

<%@ include file="resources/blocks/footer.jsp" %>
    </div>

</body>
</html>