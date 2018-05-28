<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">  
       <head>  
       <link href="css/login.css" rel="stylesheet" type="text/css">
            <!--网站编码格式，UTF-8 国际编码，GBK或 gb2312 中文编码-->  
            <meta http-equiv="content-type" content="text/html;charset=utf-8" />  
            <meta http-equiv="X-UA-Compatible" content="IE=edge">  
            <meta name="Keywords" content="关键词一，关键词二">  
            <meta name="Description" content="网站描述内容">  
            <meta name="Author" content="Yvette Lau">          
            <title>CSSDemo</title>  
            <style>  
                *{  
                    margin: 0px;  
                    padding: 0px;  
                }  
                /*布局开始*/  
                #login_dialog {  
                    position: relative;  
                    left: 40%;  
                    top: 25%;  
                    background-color: #303a40;  
                    width: 600px;  
                    margin-left: -200px;  
                     
                    font-family: "黑体";  
                    /*禁止复制粘贴*/  
                    -moz-user-select: none;  
                    -webkit-user-select: none;  
                    user-select:none;  
                }  
                .register_dialog_title {  
                    height: 35px;  
                    line-height: 35px;  
                    margin: 0 5px;  
                }  
      
                .register_dialog_info {  
                    float: left;  
                    margin-left:10px;  
                    color: #fff;  
                    margin-top: 5px;  
                    font-size: 20px;  
                }  
                #register_dialog {  
                    position: fixed;  
                    left: 40%;  
                    top: 40%;  
                    background-color: #303a40;  
                    width: 500px;  
                /*  height: 600px; */  
                    margin-left: -200px;  
                    margin-top: -200px;  
                    font-family: "黑体";  
                    -moz-user-select:none; /*火狐*/  
                    -webkit-user-select:none; /*webkit浏览器*/  
                    -ms-user-select:none; /*IE10*/  
                    -khtml-user-select:none; /*早期浏览器*/  
                    user-select:none;  
                }  
      
                .register_dialog_info {  
                    float: left;  
                    margin-left:10px;  
                    color: #fff;  
                    margin-top: 5px;  
                    font-size: 20px;  
                }  
                .dialog_close {  
                    cursor: pointer;  
                    width: 40px;  
                    height:40px;  
                    border-radius:25px;  
                    float: right;  
                    line-height:40px;  
                    font-size: 20px;  
                    color: #d8dadb;  
                    font-family: "微软雅黑";  
                    text-align: center;  
                    cursor:center;  
                }  
                form{padding: 20px 0px;}  
                ul li {list-style: none;}  
                .sub {  
                    text-align: center;  
                    
                }  
                .sub input {  
                    display: inline-block;  
                    width: 300px;  
                    background-color: rgb(255, 109, 11);  
                    color: rgb(255, 255, 255);  
                    font-size: 20px;  
                    text-align: center;  
                    height: 40px;  
                    line-height: 40px;  
                    font-family: 黑体;  
                    outline: none;  
                    border: none;  
                    margin: auto;  
                }  
                .dialog_close:hover {  
                    background-color: #566  
                }  
                input[type = "submit"]:hover{cursor: pointer;}  
                /*布局结束*/  
                .reg-box { padding-left: 30px; }  
      
                .reg-box li { line-height: 44px; width: 500px; overflow: hidden; }  
      
                .reg-box li label { width: 68px; height: 50px; float: left; line-height: 50px; text-align: right; padding-right: 20px; }  
      
                .reg-box li input,.reg-box li select{ padding: 6px 0; font-size: 16px; width: 296px; height: 28px; line-height: 28px; border: 1px solid #dddddd; text-indent: 0.5em;  }  
      
                .reg-box li select option{font-size:16px;}  
      
                .registered .btn a { background: #ff7200; margin-left: 110px; }  
                  
                /*验证码*/  
                .add { width: 128px; height: 44px; float: left; _display: inline; cursor: pointer; margin-left: 20px; }  
      
                .reg-box li .sradd { width: 148px; text-indent: 4px; font-size: 14px; }  
      
                .reg-box li .input-code { width: 106px; padding: 10px; font-family: Arial; font-style: italic; color: red; letter-spacing: 1px; cursor: pointer; text-align: center; text-indent: 0; }  
      
                .yzm,.phoKey { background: #ff7200; text-align: center; line-height: 44px; color: #fff; }  
      
                .phoKey{letter-spacing: 3px; font-size:18px;}  
      
                .yzmc { background: #dddddd; text-align: center; line-height: 44px; color: #999; }  
      
                .error { clear:both;display:block;color: red; padding-left: 90px; padding-bottom:5px;height:20px;float: left; font-size:12px;line-height: 20px;}  
      
                input { background-color: #fff; outline: none; }  
      
                .reg-box li { width: auto; }  
      
                .reg-box li input.errorC, .errorC{ border: 1px solid red; }  
      
                .reg-box li input.checkedN , .checkedN{ border: 1px solid #1ece6d; } 
                .radio{
                	border:1px solid red !important;
                	width:20px !important;
                	height:20px !important;
                	position:relative;
                	top:5px;
                	
                } 
                .usersex{
                	position:relative;
                	top:-10px;
                }
                .result{text-align:center;}
                  
            </style>  
            <!--css js 文件的引入-->    
        </head>  
        <body class="login-bg">  
            <div id="login_dialog">  
                <div class="register_dialog_title">  
                    <p class="register_dialog_info">注册</p>  
                    <p class="dialog_close">X</p>  
                    <div class="clear"></div>  
                </div>  
                <div style="background-color:#ffffff;margin:10px;">  
                    <form action="/shareinformation/register.action" method="post">                
                        <ul class="reg-box">                   
                            <li>  
                                <label for="">账    号</label><input type="text" placeholder="请输入您的账号" class="account" maxlength="11" style="color:#999;"  name="userid" required="required"/><span class="error error5"></span>  
                            </li>
                            <li>  
                                <label for="">昵  称</label><input type="text" placeholder="请输入您的昵称" class="account" maxlength="11" style="color:#999;"  name="username" required="required"/><span class="error error5"></span>  
                            </li>
                            <li>  
                                <label for="">电    话</label><input type="text" placeholder="请输入您的电话" class="phone" maxlength="11" style="color:#999;"   name="userphone" required="required"/><span class="error error5"></span>  
                            </li>
                            <li>  
                                <label for="">q  q</label><input type="text" placeholder="请输入您的扣扣" class="qq" maxlength="11" style="color:#999;"   name="userqq" required="required"/><span class="error error5"></span>  
                            </li>
                            <li class="usersex">  
                                <label for="">性  别</label>
                                <input type="radio"  style="color:#999;" name="usersex" class="radio"/>男
                                <input type="radio" style="color:#999;" name="usersex" class="radio"/>女  
                            </li>
                            <li>  
                                <label for="">地  址</label><input type="text" placeholder="请输入您的地址" class="address" maxlength="11" style="color:#999;"   name="useraddress" required="required"/><span class="error error5"></span>  
                            </li>
                            <li>  
                                <label for="">密    码</label><input type="password" placeholder="请输入您的账密码" class = "password" style="color:#999;"   name="userpassword" required="required"/><span class="error error6"></span>  
                            </li>
                            <li>  
                                <label for="">验证密码</label><input type="password" placeholder="请验证您的密码" class="userpassword1" style="color:#999;" onBlur="textBlur()"  name="userpassword1" required="required"/><span class="error errors"></span>  
                            </li> 
                             
                        </ul>  
                        <div class="sub">  
                            <input type="submit" value="立即注册" />  
                        </div>                      
                    </form>  
                </div>  
            </div>
            <p class="result">
            	<s:property value="result" />
             <a href="/shareinformation/index.jsp">返回登陆页面</a> 
             <s:property value="result" /></p>  
        </body>  
            <script type="text/javascript">
            	function textBlur(){
            		var userpassword=document.getElementsByClassName('password');
            	   var userpassword1=document.getElementsByClassName('userpassword1');
            	   var errors=document.getElementsByClassName('errors');
            	if(userpassword[0].value!=userpassword1[0].value){
            		alert('两次密码输入不一致');
            		return false;
            	}
            	}
            	
            	
            	
            </script>  
    </html>