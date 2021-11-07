<%@ page language="java" contentType="text/html; charset=UTF-8" %>

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
<%-- 
                <jsp:useBean id="reqFault" class="pro.yoric.registration.bean.UserBean" scope="request" />
                <ul>
                    <li>
                        Name is: 
                        <% if ( !"name".isEmpty()) { %>
                            <jsp:getProperty name="reqFault" property="name"/>
                        <% } else { %>
                            <%= WARNING %>
                        <% } %>
                    </li>
                    <li>
                        Surname is: 
                        <% if ( !"surname".isEmpty()) { %>
                            <jsp:getProperty name="reqFault" property="name"/>
                        <% } else { %>
                            <%= WARNING %>
                        <% } %>
                    </li>
                    <li>
                        Phone is: 
                        <% if ( !"".isEmpty()) { %>
                            <jsp:getProperty name="reqFault" property="name"/>
                        <% } else { %>
                            <%= WARNING %>
                        <% } %>
                    </li>
                    <li>
                        E-mail is: 
                        <% if ( !"email".isEmpty()) { %>
                            <jsp:getProperty name="reqFault" property="name"/>
                        <% } else { %>
                            <%= WARNING %>    
                        <% } %>
                    </li>
                </ul>
--%>
                <ul> 

                    <%-- <%
                        if (req.getAttribute("name") != null)
                            out.println(
                                "<li>Name is: "                 +
                                    req.getAttribute("name")    +
                                "</li>"
                            );
                        else
                            out.println(
                                "<li>Name is: "                 +
                                    WARNING                     +
                                "</li>"
                            );

                        if (req.getAttribute("surname") != null)
                            out.println(
                                "<li>Surname is: "              +
                                    req.getAttribute("surname") +
                                "</li>"
                            );
                        else
                            out.println(
                                "<li>Surname is: "              +
                                    WARNING                     +
                                "</li>"
                            );

                        if (req.getAttribute("phone") != null)
                            out.println(
                                "<li>Phone is: "                +
                                    req.getAttribute("phone")   +
                                "</li>"
                            );
                        else
                            out.println(
                                "<li>Phone is: "                +
                                    WARNING                     +
                                "</li>"
                            );

                        if (req.getAttribute("email") != null)
                            out.println(
                                "<li>E-mail is: "               +
                                    req.getAttribute("email")   +
                                "</li>"
                            );
                        else
                            out.println(
                                "<li>E-mail is: "               +
                                    WARNING                     +
                                "</li>"
                            );

                    %> --%>

                </ul>

                <nav class = "err">
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