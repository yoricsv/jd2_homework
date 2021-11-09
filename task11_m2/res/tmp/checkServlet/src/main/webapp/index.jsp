<%@ page
    contentType = "text/html;
                   charset=UTF-8"
    language    = "java"
%>

<% String uas   = (String) request.getAttribute("uas"); %>

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

<%@ include file="resources/blocks/header.jsp" %>

        <div class = "content">

            <div class = "sign_in">
                <div>
                    <p>
                        Browser type detection
                    </p>
                </div>

                <p>
                    <%--
                        String agent = (String) request.getHeader("User-agent");
                        if(agent != null && !agent.isEmpty()) out.println("Browser response: " + agent);

                        if(uas == null)
                            out.println("Servlet response: uas is null");
                        else if (uas.isEmpty())
                            out.println("Servlet response: uas isn't null, but empty");
                        else
                            out.println("Servlet response: " + uas);
                    --%>
                    Hello, ${uas} user!
                </p>

                <nav>
                    <button onclick = "location.href = '/parser/detect'">
                        Update page
                    </button>
                </nav>
            </div>
           
        </div>

<%@ include file="resources/blocks/footer.jsp" %>
    </div>

</body>
</html>