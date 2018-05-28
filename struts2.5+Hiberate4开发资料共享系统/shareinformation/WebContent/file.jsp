<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/login.css" rel="stylesheet" type="text/css">
<style type="text/css">

/*分别定义HTML中和标记之的距离样式*/

html, body, h1, form, fieldset, legend, ol, li {

    margin: 0;

    padding: 0;

}

/*定义<body>标记样式*/

body {

    background: #ffffff;

    color: #111111;

    font-family: Georgia, "Times New Roman", Times, serif;

    padding-left: 20px;

    

}

/*定义付费内容的样式*/

form#payment {

    background: #9cbc2c;

    -webkit-border-radius: 5px;

    border-radius: 5px;

    padding: 20px;

    width: 400px;

    margin:auto;

}

form#payment fieldset {

    border: none;

    margin-bottom: 10px;

}

form#payment fieldset:last-of-type { margin-bottom: 0; }

form#payment legend {

    color: #384313;

    font-size: 16px;

    font-weight: bold;

    padding-bottom: 10px;

    text-shadow: 0 1px 1px #c0d576;

}

form#payment > fieldset > legend:before {

    content: "Step " counter(fieldsets) ": ";

    counter-increment: fieldsets;

}

form#payment fieldset fieldset legend {

    color: #111111;

    font-size: 13px;

    font-weight: normal;

    padding-bottom: 0;

}

form#payment ol li {

    background: #b9cf6a;

    background: rgba(255, 255, 255, .3);

    border-color: #e3ebc3;

    border-color: rgba(255, 255, 255, .6);

    border-style: solid;

    border-width: 2px;

    -webkit-border-radius: 5px;

    line-height: 30px;

    list-style: none;

    padding: 5px 10px;

    margin-bottom: 2px;

}

form#payment ol ol li {

    background: none;

    border: none;

    float: left;

}

form#payment label {

    float: left;

    font-size: 13px;

    width: 110px;

}

form#payment fieldset fieldset label {

    background: none no-repeat left 50%;

    line-height: 20px;

    padding: 0 0 0 30px;

    width: auto;

}

form#payment fieldset fieldset label:hover { cursor: pointer; }

form#payment input:not([type=radio]), form#payment textarea {

    background: #ffffff;

    border: #FC3 solid 1px;

    -webkit-border-radius: 3px;

    font: italic 13px Georgia, "Times New Roman", Times, serif;

    outline: none;

    padding: 5px;

    width: 200px;

}

form#payment input:not([type=submit]):focus, form#payment textarea:focus {

    background: #eaeaea;

    border: #F00 solid 1px;

}

form#payment input[type=radio] {

    float: left;

    margin-right: 5px;

}

form {position:absolute; left:50%; top:50%; transform:translate(-50%,-50%);}

</style>
</head>

<body class="login-bg">
	<form id="payment" action="/shareinformation/aa/up.action" method="POST" enctype="multipart/form-data">
		<fieldset>
        <legend>文件上传</legend>
        <ol>

            <li>

                <label for="name">选择上传文件</label>

                <input id="name" name="upload" type="file" placeholder="文件上传" required autofocus>

            </li>

            <li>

                <label for="email">输入新的文件名：</label>

                <input id="email" name="filename" type="text" placeholder="文件名" required>

            </li>

            <li>

                <input id="phone" name="phone" type="submit" value="确认上传" required>

            </li>

        </ol>

    </fieldset>
			<!-- 选择上传文件       <input type="file" name="upload"><br><br>
			输入的新文件名   <input type="text" name="filename"><br><br>
			<input type="submit" value="确认上传"> -->
	</form>
</body>
</html>

<%-- <s:form action="up" namespace="/aa" enctype="multipart/form-data">
		<s:file label="上传文件" name="upload" id=""/>
		<s:textfield label="新建文件名" name="filename"/>
		<s:submit value="上传"/>
	</s:form> --%>