<%-- 
    Document   : signup
    Created on : Dec 4, 2015, 3:20:19 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <!DOCTYPE html>
    <html>
        <head>
        <title>Sign Up</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">

        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/tinymce/jquery.tinymce.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/tinymce/tinymce.min.js"></script>

    </head>
                    <body>
                        
                        
                         <div class="container-fluid col-lg-12">
                <header id="top" class="main-about">
                    <nav class="navbar navbar-inverse navbar-fixed-top">
                        <!--    <a class="navbar-brand" href="#">CFS</a> -->
                        <div class="container">
                            <ul class="nav nav-pills nav-justified">
                                <li role="presentation" ><a href="${pageContext.request.contextPath}/home">Home</a></li>
                                <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/about">About Us</a></li>
                                <li role="presentation"><a href="${pageContext.request.contextPath}/contact">Contact Us</a></li>
                                <li role="presentation"><a href="#myModal" data-toggle="modal" data-target="#myModal">Log-in</a></li>
                            </ul>
                        </div>
                    </nav>
                          
                        
                        <h1>Sign Up Now</h1>


                        <div class="container" style="margin-top:60px">
                            <div id="signup" class="panel panel-default col-md-8 col-md-offset-2 page-header">
                                <div class="panel-body">
                                    <h2 class="page-header" style="margin-top:0;">Sign up</h2>
                                    <form action="/sign/up" method="post" id="frm-signUpForm">
                                        <div class="row">
                                            <div class="col-xs-6 col-md-6">
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="fa fa-user fa-fw"></i></span>
                                                    <input type="text" name="username" maxlength="32" id="frm-signUpForm-username" required data-nette-rules='[{"op":":filled","msg":"Please enter your username."},{"op":":minLength","msg":"Username must have at least 3 characters.","arg":3},{"op":":maxLength","msg":"Username can&#39;t have more than 32 characters.","arg":32}]' value="" class="form-control" placeholder="Username">
                                                </div>
                                            </div>
                                            <div class="col-xs-6 col-md-6">
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="fa fa-globe fa-fw"></i></span>
                                                    <select name="country" id="frm-signUpForm-country" class="form-control">
                                                        <option value="AF">Afghanistan</option>
                                                        <option value="AX">Aland Islands</option>
                                                        <option value="AL">Albania</option>
                                                        <option value="DZ">Algeria</option>
                                                        <option value="AS">American Samoa</option>
                                                        <option value="AD">Andorra</option>
                                                        <option value="AO">Angola</option>
                                                        <option value="AI">Anguilla</option>
                                                        <option value="AQ">Antarctica</option>
                                                        <option value="AG">Antigua And Barbuda</option>
                                                        <option value="AR">Argentina</option>
                                                        <option value="AM">Armenia</option>
                                                        <option value="AW">Aruba</option>
                                                        <option value="AU">Australia</option>
                                                        <option value="AT">Austria</option>
                                                        <option value="AZ">Azerbaijan</option>
                                                        <option value="BS">Bahamas</option>
                                                        <option value="BH">Bahrain</option>
                                                        <option value="BD">Bangladesh</option>
                                                        <option value="BB">Barbados</option>
                                                        <option value="BY">Belarus</option>
                                                        <option value="BE">Belgium</option>
                                                        <option value="BZ">Belize</option>
                                                        <option value="BJ">Benin</option>
                                                        <option value="BM">Bermuda</option>
                                                        <option value="BT">Bhutan</option>
                                                        <option value="BO">Bolivia</option>
                                                        <option value="BA">Bosnia And Herzegovina</option>
                                                        <option value="BW">Botswana</option>
                                                        <option value="BV">Bouvet Island</option>
                                                        <option value="BR">Brazil</option>
                                                        <option value="IO">British Indian Ocean Territory</option>
                                                        <option value="BN">Brunei Darussalam</option>
                                                        <option value="BG">Bulgaria</option>
                                                        <option value="BF">Burkina Faso</option>
                                                        <option value="BI">Burundi</option>
                                                        <option value="KH">Cambodia</option>
                                                        <option value="CM">Cameroon</option>
                                                        <option value="CA">Canada</option>
                                                        <option value="CV">Cape Verde</option>
                                                        <option value="KY">Cayman Islands</option>
                                                        <option value="CF">Central African Republic</option>
                                                        <option value="TD">Chad</option>
                                                        <option value="CL">Chile</option>
                                                        <option value="CN">China</option>
                                                        <option value="CX">Christmas Island</option>
                                                        <option value="CC">Cocos (Keeling) Islands</option>
                                                        <option value="CO">Colombia</option>
                                                        <option value="KM">Comoros</option>
                                                        <option value="CG">Congo</option>
                                                        <option value="CD">Congo, Democratic Republic</option>
                                                        <option value="CK">Cook Islands</option>
                                                        <option value="CR">Costa Rica</option>
                                                        <option value="CI">Cote D'Ivoire</option>
                                                        <option value="HR">Croatia</option>
                                                        <option value="CU">Cuba</option>
                                                        <option value="CY">Cyprus</option>
                                                        <option value="CZ">Czech Republic</option>
                                                        <option value="DK">Denmark</option>
                                                        <option value="DJ">Djibouti</option>
                                                        <option value="DM">Dominica</option>
                                                        <option value="DO">Dominican Republic</option>
                                                        <option value="EC">Ecuador</option>
                                                        <option value="EG">Egypt</option>
                                                        <option value="SV">El Salvador</option>
                                                        <option value="GQ">Equatorial Guinea</option>
                                                        <option value="ER">Eritrea</option>
                                                        <option value="EE">Estonia</option>
                                                        <option value="ET">Ethiopia</option>
                                                        <option value="FK">Falkland Islands (Malvinas)</option>
                                                        <option value="FO">Faroe Islands</option>
                                                        <option value="FJ">Fiji</option>
                                                        <option value="FI">Finland</option>
                                                        <option value="FR">France</option>
                                                        <option value="GF">French Guiana</option>
                                                        <option value="PF">French Polynesia</option>
                                                        <option value="TF">French Southern Territories</option>
                                                        <option value="GA">Gabon</option>
                                                        <option value="GM">Gambia</option>
                                                        <option value="GE">Georgia</option>
                                                        <option value="DE">Germany</option>
                                                        <option value="GH">Ghana</option>
                                                        <option value="GI">Gibraltar</option>
                                                        <option value="GR">Greece</option>
                                                        <option value="GL">Greenland</option>
                                                        <option value="GD">Grenada</option>
                                                        <option value="GP">Guadeloupe</option>
                                                        <option value="GU">Guam</option>
                                                        <option value="GT">Guatemala</option>
                                                        <option value="GG">Guernsey</option>
                                                        <option value="GN">Guinea</option>
                                                        <option value="GW">Guinea-Bissau</option>
                                                        <option value="GY">Guyana</option>
                                                        <option value="HT">Haiti</option>
                                                        <option value="HM">Heard Island &amp; Mcdonald Islands</option>
                                                        <option value="VA">Holy See (Vatican City State)</option>
                                                        <option value="HN">Honduras</option>
                                                        <option value="HK">Hong Kong</option>
                                                        <option value="HU">Hungary</option>
                                                        <option value="IS">Iceland</option>
                                                        <option value="IN">India</option>
                                                        <option value="ID">Indonesia</option>
                                                        <option value="IR">Iran, Islamic Republic Of</option>
                                                        <option value="IQ">Iraq</option>
                                                        <option value="IE">Ireland</option>
                                                        <option value="IM">Isle Of Man</option>
                                                        <option value="IL">Israel</option>
                                                        <option value="IT">Italy</option>
                                                        <option value="JM">Jamaica</option>
                                                        <option value="JP">Japan</option>
                                                        <option value="JE">Jersey</option>
                                                        <option value="JO">Jordan</option>
                                                        <option value="KZ">Kazakhstan</option>
                                                        <option value="KE">Kenya</option>
                                                        <option value="KI">Kiribati</option>
                                                        <option value="KR">Korea</option>
                                                        <option value="KW">Kuwait</option>
                                                        <option value="KG">Kyrgyzstan</option>
                                                        <option value="LA">Lao People's Democratic Republic</option>
                                                        <option value="LV">Latvia</option>
                                                        <option value="LB">Lebanon</option>
                                                        <option value="LS">Lesotho</option>
                                                        <option value="LR">Liberia</option>
                                                        <option value="LY">Libyan Arab Jamahiriya</option>
                                                        <option value="LI">Liechtenstein</option>
                                                        <option value="LT">Lithuania</option>
                                                        <option value="LU">Luxembourg</option>
                                                        <option value="MO">Macao</option>
                                                        <option value="MK">Macedonia</option>
                                                        <option value="MG">Madagascar</option>
                                                        <option value="MW">Malawi</option>
                                                        <option value="MY">Malaysia</option>
                                                        <option value="MV">Maldives</option>
                                                        <option value="ML">Mali</option>
                                                        <option value="MT">Malta</option>
                                                        <option value="MH">Marshall Islands</option>
                                                        <option value="MQ">Martinique</option>
                                                        <option value="MR">Mauritania</option>
                                                        <option value="MU">Mauritius</option>
                                                        <option value="YT">Mayotte</option>
                                                        <option value="MX">Mexico</option>
                                                        <option value="FM">Micronesia, Federated States Of</option>
                                                        <option value="MD">Moldova</option>
                                                        <option value="MC">Monaco</option>
                                                        <option value="MN">Mongolia</option>
                                                        <option value="ME">Montenegro</option>
                                                        <option value="MS">Montserrat</option>
                                                        <option value="MA">Morocco</option>
                                                        <option value="MZ">Mozambique</option>
                                                        <option value="MM">Myanmar</option>
                                                        <option value="NA">Namibia</option>
                                                        <option value="NR">Nauru</option>
                                                        <option value="NP">Nepal</option>
                                                        <option value="NL">Netherlands</option>
                                                        <option value="AN">Netherlands Antilles</option>
                                                        <option value="NC">New Caledonia</option>
                                                        <option value="NZ">New Zealand</option>
                                                        <option value="NI">Nicaragua</option>
                                                        <option value="NE">Niger</option>
                                                        <option value="NG">Nigeria</option>
                                                        <option value="NU">Niue</option>
                                                        <option value="NF">Norfolk Island</option>
                                                        <option value="MP">Northern Mariana Islands</option>
                                                        <option value="NO">Norway</option>
                                                        <option value="OM">Oman</option>
                                                        <option value="PK">Pakistan</option>
                                                        <option value="PW">Palau</option>
                                                        <option value="PS">Palestinian Territory, Occupied</option>
                                                        <option value="PA">Panama</option>
                                                        <option value="PG">Papua New Guinea</option>
                                                        <option value="PY">Paraguay</option>
                                                        <option value="PE">Peru</option>
                                                        <option value="PH">Philippines</option>
                                                        <option value="PN">Pitcairn</option>
                                                        <option value="PL">Poland</option>
                                                        <option value="PT">Portugal</option>
                                                        <option value="PR">Puerto Rico</option>
                                                        <option value="QA">Qatar</option>
                                                        <option value="RE">Reunion</option>
                                                        <option value="RO">Romania</option>
                                                        <option value="RU">Russian Federation</option>
                                                        <option value="RW">Rwanda</option>
                                                        <option value="BL">Saint Barthelemy</option>
                                                        <option value="SH">Saint Helena</option>
                                                        <option value="KN">Saint Kitts And Nevis</option>
                                                        <option value="LC">Saint Lucia</option>
                                                        <option value="MF">Saint Martin</option>
                                                        <option value="PM">Saint Pierre And Miquelon</option>
                                                        <option value="VC">Saint Vincent And Grenadines</option>
                                                        <option value="WS">Samoa</option>
                                                        <option value="SM">San Marino</option>
                                                        <option value="ST">Sao Tome And Principe</option>
                                                        <option value="SA">Saudi Arabia</option>
                                                        <option value="SN">Senegal</option>
                                                        <option value="RS">Serbia</option>
                                                        <option value="SC">Seychelles</option>
                                                        <option value="SL">Sierra Leone</option>
                                                        <option value="SG">Singapore</option>
                                                        <option value="SK">Slovakia</option>
                                                        <option value="SI">Slovenia</option>
                                                        <option value="SB">Solomon Islands</option>
                                                        <option value="SO">Somalia</option>
                                                        <option value="ZA">South Africa</option>
                                                        <option value="GS">South Georgia And Sandwich Isl.</option>
                                                        <option value="ES">Spain</option>
                                                        <option value="LK">Sri Lanka</option>
                                                        <option value="SD">Sudan</option>
                                                        <option value="SR">Suriname</option>
                                                        <option value="SJ">Svalbard And Jan Mayen</option>
                                                        <option value="SZ">Swaziland</option>
                                                        <option value="SE">Sweden</option>
                                                        <option value="CH">Switzerland</option>
                                                        <option value="SY">Syrian Arab Republic</option>
                                                        <option value="TW">Taiwan</option>
                                                        <option value="TJ">Tajikistan</option>
                                                        <option value="TZ">Tanzania</option>
                                                        <option value="TH">Thailand</option>
                                                        <option value="TL">Timor-Leste</option>
                                                        <option value="TG">Togo</option>
                                                        <option value="TK">Tokelau</option>
                                                        <option value="TO">Tonga</option>
                                                        <option value="TT">Trinidad And Tobago</option>
                                                        <option value="TN">Tunisia</option>
                                                        <option value="TR">Turkey</option>
                                                        <option value="TM">Turkmenistan</option>
                                                        <option value="TC">Turks And Caicos Islands</option>
                                                        <option value="TV">Tuvalu</option>
                                                        <option value="UG">Uganda</option>
                                                        <option value="UA">Ukraine</option>
                                                        <option value="AE">United Arab Emirates</option>
                                                        <option value="GB">United Kingdom</option>
                                                        <option value="US">United States</option>
                                                        <option value="UM">United States Outlying Islands</option>
                                                        <option value="UY">Uruguay</option>
                                                        <option value="UZ">Uzbekistan</option>
                                                        <option value="VU">Vanuatu</option>
                                                        <option value="VE">Venezuela</option>
                                                        <option value="VN">Viet Nam</option>
                                                        <option value="VG">Virgin Islands, British</option>
                                                        <option value="VI">Virgin Islands, U.S.</option>
                                                        <option value="WF">Wallis And Futuna</option>
                                                        <option value="EH">Western Sahara</option>
                                                        <option value="YE">Yemen</option>
                                                        <option value="ZM">Zambia</option>
                                                        <option value="ZW">Zimbabwe</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-xs-6 col-md-6">
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="fa fa-envelope-o fa-fw"></i></span>
                                                    <input type="text" name="email" id="frm-signUpForm-email" required data-nette-rules='[{"op":":filled","msg":"Please enter your email."},{"op":":email","msg":"Email is not valid."}]' value="" class="form-control" placeholder="Your Email">
                                                </div>
                                            </div>
                                            <div class="col-xs-6 col-md-6">
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="fa fa-envelope-o fa-fw"></i></span>
                                                    <input type="text" name="email2" id="frm-signUpForm-email2" required data-nette-rules='[{"op":":filled","msg":"Please enter your email."},{"op":":valid","rules":[{"op":":equal","msg":"Emails do not match!","arg":{"control":"email"}}],"control":"email"}]' value="" class="form-control" placeholder="Re-enter Email">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-xs-6 col-md-6">
                                                <div class="input-group nom">
                                                    <span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
                                                    <input type="password" name="password" maxlength="64" id="frm-signUpForm-password" required data-nette-rules='[{"op":":filled","msg":"Please enter your password."},{"op":":minLength","msg":"Password must have at least 5 characters.","arg":5},{"op":":maxLength","msg":"Passoword can&#39;t have more than 64 characters.","arg":64}]' class="form-control" placeholder="Password">
                                                </div>
                                            </div>
                                            <div class="col-xs-6 col-md-6">
                                                <div class="input-group nom">
                                                    <span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
                                                    <input type="password" name="password2" id="frm-signUpForm-password2" required data-nette-rules='[{"op":":filled","msg":"Please enter your password."},{"op":":valid","rules":[{"op":":equal","msg":"Passwords do not match!","arg":{"control":"password"}}],"control":"password"}]' class="form-control" placeholder="Re-enter Password">
                                                </div>
                                            </div>
                                        </div>
                                        <hr>
                                        <input type="submit" name="send" id="frm-signUpForm-send" value="Sign up" class="btn btn-primary btn-sm">
                                    </form>
                                </div>
                            </div>
                        </div>




                        <div class="modal fade" id="myModal">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                        <h4 class="modal-title">Log-in</h4>
                                    </div>
                                    <div class="modal-body">
                                        <div class="form-group">
                                            <label for="exampleInputEmail1">Email address</label>
                                            <input class="form-control" id="exampleInputEmail1" placeholder="Enter email" type="email">
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputPassword1">Password</label>
                                            <input class="form-control" id="exampleInputPassword1" placeholder="Password" type="password">
                                        </div>
                                        <p class="text-left"><a href="http://localhost:8080/CFBlog/jsp/signup.jsp">Create New Account</a></p>
                                        <p class="text-right"><a href="#">Forgot password?</a></p>
                                    </div>
                                    <div class="modal-footer">
                                        <a href="#" data-dismiss="modal" class="btn">Close</a>
                                        <a href="#" class="btn btn-primary">Log-in</a>
                                    </div>
                                </div>
                            </div>
                        </div>


                            <!-- Starting Footer -->
                            <footer class="main-footer">
                                <p>All rights reserved to the design team - Counter Factual Simulation &#169;J&#94;2 & G</p>
                                <a href="#top">Back to top &raquo;</a>
                            </footer>
                      
                        <!-- Placed at the end of the document so the pages load faster -->
                        <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
                        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

                    </body>
                    </html>
