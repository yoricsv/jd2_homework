<%@ page
    contentType = "text/html;
                   charset=UTF-8"
    language    = "java"
%>

<% String agent = (String) request.getHeader("User-agent"); %>
<%-- <% String useragent = (String) request.getAttribute("uas"); %> --%>

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
                    Servlet response : 
                    <%
                        if(request.getAttribute("uas") == null)
                            out.println("uas is null");
                        else if (request.getAttribute("uas").isEmpty())
                            out.println("uas isn't null, but empty");
                        else
                            out.println(uas);
                    %>
                    ${uas}<br/>

                    Hello, html response : <% if(agent != null && !agent.isEmpty()) out.println(agent); %> user!
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