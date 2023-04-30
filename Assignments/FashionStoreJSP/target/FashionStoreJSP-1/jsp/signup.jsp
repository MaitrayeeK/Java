<%-- 
    Document   : signup
    Created on : 19-Feb-2023, 8:32:01 PM
    Author     : maitr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='/FashionStoreJSP/webjars/bootstrap/5.2.3/css/bootstrap.min.css'>
        <script src='/FashionStoreJSP/webjars/jquery/3.6.2/dist/jquery.min.js'></script>
        <script src='/FashionStoreJSP/webjars/bootstrap/5.2.3/js/bootstrap.min.js'></script>
        <link rel='stylesheet' href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
        <title>Signup</title>
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap');

            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                font-family: 'Poppins', sans-serif
            }

            .container {
                margin: 50px auto;
            }

            .body {
                position: relative;
                width: 720px;
                height: auto;
                margin: 20px auto;
                border: 1px solid #dddd;
                border-radius: 18px;
                overflow: hidden;
                box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
            }

            .h-1 {
                font-size: 24px;
                font-weight: 700;
            }

            input, textarea {
                width: 100%;
                height: 2.5rem;
            }

            a {
                background-color: transparent;
                color: #ee82ee;
                border: 0px;
                padding: 0;
                font-size: 17px;
                text-decoration: none;
            }

            .btn {
                background-color: #ee82ee;
                width: 50% !important;
            }
        </style>
    </head>
    <body>
    <center><div class="mb-1 h-1 mt-2">FashionStore</div></center>
    <form>
        <div class="container body ps-5 pe-5">
            <div class="mt-2 align-items-center">
                <p class="h-1">Register</p>
                <div class="d-flex flex-column ">
                    <form>
                        <div class="row">
                            <div class="col mb-1 text-muted">
                                <label class="form-label" for="txtuname">Username</label><br>
                                <input type="text" name="txtuname" id="txtuname"/>
                            </div>
                            <div class="col mb-1 text-muted">
                                <label class="form-label" for="txtpassword">Password</label><br>
                                <input type="password" id="txtpassword" name="txtpassword"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col mb-1 text-muted">
                                <label class="form-label" for="txtpasswordq">Password Question</label><br>
                                <input type="text" id="txtpasswordq" name="txtpasswordq"/>
                            </div>
                            <div class="col mb-1 text-muted">
                                <label class="form-label" for="txtpassworda">Password Answer</label><br>
                                <input type="text" id="txtpassworda" name="txtpassworda"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col mb-1 text-muted">
                                <label class="form-label" for="txtemail">Email</label><br>
                                <input type="email" name="txtemail" id="txtemail"/>
                            </div>
                            <div class="col mb-1 text-muted">
                                <label class="form-label" for="txtphone">Phone</label><br>
                                <input type="text" id="txtphone" name="txtphone"/>
                            </div>
                        </div>
                        <div class="mb-1 text-muted">
                            <label class="form-label" for="txtaddr">Address</label><br>
                            <textarea type="password" id="txtaddr" name="txtaddr"></textarea>
                        </div>
                        <div class="row">
                            <div class="col mb-1 text-muted">
                                <label class="form-label" for="txtcity">City</label><br>
                                <input type="text" id="txtcity" name="txtcity"/>
                            </div>
                            <div class="col mb-1 text-muted">
                                <label class="form-label" for="txtstate">State</label><br>
                                <input type="text" id="txtstate" name="txtstate"/>
                            </div>
                            <div class="col mb-1 text-muted">
                                <label class="form-label" for="txtcountry">Country</label><br>
                                <input type="text" id="txtcountry" name="txtcountry"/>
                            </div>
                            <div class="col mb-1 text-muted">
                                <label class="form-label" for="txtpin">Pin</label><br>
                                <input type="text" id="txtpin" name="txtpin"/>
                            </div>
                        </div>
                        <input type="submit" class="btn mt-3" value="Sign-up" name="btnsignup">
                    </form>
                    <div class="mt-1 mb-3">
                        <p class="mb-0 text-muted">Already have an account?</p>
                        <a href="login.jsp">Login<span class="fas fa-chevron-right ms-1"></span></a>
                    </div>
                </div>
            </div>
        </div>
    </form>
</body>
</html>
