            <div class = "sign_in">
            <!-- <div class = "sign_in">                                                 signin.jsp -->
            <!-- <div class = "sign_in">                                                 users.jsp -->
            <!-- <div class = "sign_in err">                                             failure.jsp -->
                <div>
                    <p>
                        <!-- Information added successfully!                             signin.jsp -->
                        <!-- List of the users                                           users.jsp -->
                        <!-- Inability to add information. Required fields are empty!    failure.jsp -->
                    </p>
                </div>

<%!
    String state0 = "<div class = \"sign_in\">";
    String state1 = "<div class = \"sign_in err\">";
    String stateInfoGood = "Information added successfully!"
    String stateInfoUser = "List of the users"
    String stateInfoFail = "Inability to add information. Required fields are empty!"
%> 


                <p>
<%--
                    Hello, 'name'!                                                  <!--signin.jsp-->
                    <br/>                                                           <!--signin.jsp-->
                    Below, is the information you entered:                          <!--signin.jsp-->

                    <!--""-->                                                       <!--users.jsp-->

                    You must enter your name with e-mail address or phone number.   <!--failure.jsp-->
                    <br/>                                                           <!--failure.jsp-->
                    Please, go back and fill in all required fields.                <!--failure.jsp-->
--%>
                </p>

                <ul>
<%--
                <ul>                                                                <!--signin.jsp-->
                <ul class = "users">                                                <!--users.jsp-->
                <ul>                                                                <!--failure.jsp-->

                    <li>                                                            <!--signin.jsp-->
                        Name is: 'name'                                             <!--signin.jsp-->
                    </li>                                                           <!--signin.jsp-->
                    <li>                                                            <!--signin.jsp-->
                        Surname is: 'surname'                                       <!--signin.jsp-->
                    </li>                                                           <!--signin.jsp-->
                    <li>                                                            <!--signin.jsp-->
                        Phone is: 'phone'                                           <!--signin.jsp-->
                    </li>                                                           <!--signin.jsp-->
                    <li>                                                            <!--signin.jsp-->
                        E-mail is: 'email'                                          <!--signin.jsp-->
                    </li>                                                           <!--signin.jsp-->


                    <li>                                                            <!--users.jsp-->
                        Anton                                                       <!--users.jsp-->
                    </li>                                                           <!--users.jsp-->
                    <li>                                                            <!--users.jsp-->
                        ...                                                         <!--users.jsp-->
                    </li>                                                           <!--users.jsp-->
                    <li>                                                            <!--users.jsp-->
                        Kim                                                         <!--users.jsp-->
                    </li>                                                           <!--users.jsp-->

                    <li>                                                            <!--failure.jsp-->
                        Name is: <span></span>                                      <!--failure.jsp-->
                    </li>                                                           <!--failure.jsp-->
                    <li>                                                            <!--failure.jsp-->
                        Surname is: 'surname'                                       <!--failure.jsp-->
                    </li>                                                           <!--failure.jsp-->
                    <li>                                                            <!--failure.jsp-->
                        Phone is: <span></span>                                     <!--failure.jsp-->
                    </li>                                                           <!--failure.jsp-->
                    <li>                                                            <!--failure.jsp-->
                        E-mail is: <span></span>                                    <!--failure.jsp-->
                    </li>                                                           <!--failure.jsp-->
--%>
                </ul>

                <nav>
<%--
                <nav>                                                               <!--signin.jsp-->
                <nav class = "err">                                                 <!--users.jsp-->
                <nav class = "err">                                                 <!--failure.jsp-->
--%>
                    <button onclick = "location.href = '/ui'">
                        Back to main
                    </button>

                    <button onclick = "location.href = '/ui/users'">
                        See users list
                    </button>
                </nav>
            </div>