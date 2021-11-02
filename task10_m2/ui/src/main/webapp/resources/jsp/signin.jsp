<%@ page language="java" %>

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
                    Hello, 'name'!
                    <br/>
                    Below, is the information you entered:
                </p>

                <jsp:useBean id="reqFault" class="pro.yoric.model.UserData" scope="application" />

                <ul>
                    <li>
                        Name is: <jsp:getProperty name="reqFault" property="name"    />
                    </li>
                    <li>
                        Surname is: <jsp:getProperty name="reqFault" property="surname" />
                    </li>
                    <li>
                        Phone is: <jsp:getProperty name="reqFault" property="phone"   />
                    </li>
                    <li>
                        E-mail is: <jsp:getProperty name="reqFault" property="email"   />
                    </li>
                </ul>

                <nav>
                    <button onclick = "location.href = '/'">
                        Back to main
                    </button>

                    <button onclick = "location.href = '/users'">
                        See users list
                    </button>
                </nav>
            </div>

        </div>

<%@ include file="../blocks/footer.jsp" %>
    </div>

</body>
</html>