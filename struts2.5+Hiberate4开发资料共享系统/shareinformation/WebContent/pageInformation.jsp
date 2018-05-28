<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
  .button{
    color:red;
    background:black;
  }
  .table{
  	width: 100%;
  	height:400px;
  }
  
  .bordered {
            border: solid #ccc 1px;
            -moz-border-radius: 6px;
            -webkit-border-radius: 6px;
            border-radius: 6px;
            -webkit-box-shadow: 0 1px 1px #ccc;
            -moz-box-shadow: 0 1px 1px #ccc;
            box-shadow: 0 1px 1px #ccc;
        }

        .bordered tr:hover {
            background: #fbf8e9;
            -o-transition: all 0.1s ease-in-out;
            -webkit-transition: all 0.1s ease-in-out;
            -moz-transition: all 0.1s ease-in-out;
            -ms-transition: all 0.1s ease-in-out;
            transition: all 0.1s ease-in-out;
        }

        .bordered td, .bordered th {
            border-left: 1px solid #ccc;
            border-top: 1px solid #ccc;
            padding: 10px;
            text-align: left;
        }

        .bordered th {
            background-color: #dce9f9;
            background-image: -webkit-gradient(linear, left top, left bottom, from(#ebf3fc), to(#dce9f9));
            background-image: -webkit-linear-gradient(top, #ebf3fc, #dce9f9);
            background-image: -moz-linear-gradient(top, #ebf3fc, #dce9f9);
            background-image: -ms-linear-gradient(top, #ebf3fc, #dce9f9);
            background-image: -o-linear-gradient(top, #ebf3fc, #dce9f9);
            background-image: linear-gradient(top, #ebf3fc, #dce9f9);
            -webkit-box-shadow: 0 1px 0 rgba(255, 255, 255, .8) inset;
            -moz-box-shadow: 0 1px 0 rgba(255, 255, 255, .8) inset;
            box-shadow: 0 1px 0 rgba(255, 255, 255, .8) inset;
            border-top: none;
            text-shadow: 0 1px 0 rgba(255, 255, 255, .5);
        }

        .bordered td:first-child, .bordered th:first-child {
            border-left: none;
        }

        .bordered th:first-child {
            -moz-border-radius: 6px 0 0 0;
            -webkit-border-radius: 6px 0 0 0;
            border-radius: 6px 0 0 0;
        }

        .bordered th:last-child {
            -moz-border-radius: 0 6px 0 0;
            -webkit-border-radius: 0 6px 0 0;
            border-radius: 0 6px 0 0;
        }

        .bordered th:only-child {
            -moz-border-radius: 6px 6px 0 0;
            -webkit-border-radius: 6px 6px 0 0;
            border-radius: 6px 6px 0 0;
        }

        .bordered tr:last-child td:first-child {
            -moz-border-radius: 0 0 0 6px;
            -webkit-border-radius: 0 0 0 6px;
            border-radius: 0 0 0 6px;
        }

        .bordered tr:last-child td:last-child {
            -moz-border-radius: 0 0 6px 0;
            -webkit-border-radius: 0 0 6px 0;
            border-radius: 0 0 6px 0;
        }
</style>
<script type="text/javascript">  
      
        function validate()  
        {  
            var page = document.getElementsByName("page")[0].value;  
                  
            if(page > <s:property value="#request.infpageBean.totalPage"/>)  
            {  
                alert("你输入的页数大于最大页数，页面将跳转到首页！");  
                  
                /* window.document.location.href = "informationAction";  */ 
                window.document.location.href = "/shareinformation/WebContent/pageInformation.jsp";
                  
                return false;  
            }  
              
            return true;  
        }  
      
    </script>  
  
</head>
<body>
<h1><font color="blue">资料下载</font></h1><hr>  
      
   <table class="bordered" align="center">
      
        <tr>  
            <th>文件号</th>  
            <th>文件名</th>  
            <th>文件大小</th> 
            <th>被下载次数</th>
           	<th>操作</th>
        </tr> 
      
    <s:iterator value="#request.infpageBean.list" var="information">  
      
        <tr>  
            <td><s:property value="#information.fileid"/></td>  
            <td><s:property value="#information.filename"/></td>  
            <td><s:property value="#information.filesize"/></td>
            <td><s:property value="#information.frequency"/></td>
            <td align="center">  
                <a href="/shareinformation/aa/admin!deleteInformation.action?fileid=${fileid}">删除</a> 
                <a href="/shareinformation/aa/download!?filename=${filename}" >下载</a>
           	</td>           
        </tr>  
      
    </s:iterator>  
      
    </table>  
      
    <center>  
      
        <font size="5">共<font color="red"><s:property value="#request.infpageBean.totalPage"/></font>页 </font>    
        <font size="5">共<font color="red"><s:property value="#request.infpageBean.allRows"/></font>条记录</font><br><br>
         <font size="5">第<font color="red"><s:property value="#request.infpageBean.currentPage"/></font>页</font><br><br>
        
          
        <s:if test="#request.infpageBean.currentPage == 1">  
            首页   上一页  
        </s:if>  
          
        <s:else>  
            <a href="/shareinformation/aa/informationAction.action">首页</a>  
                 
            <a href="/shareinformation/aa/informationAction.action?page=<s:property value="#request.infpageBean.currentPage - 1"/>">上一页</a>  
        </s:else>  
          
        <s:if test="#request.infpageBean.currentPage != #request.infpageBean.totalPage">  
            <a href="/shareinformation/aa/informationAction.action?page=<s:property value="#request.infpageBean.currentPage + 1"/>">下一页</a>  
                 
            <a href="/shareinformation/aa/informationAction.action?page=<s:property value="#request.infpageBean.totalPage"/>">尾页</a>  
        </s:if>  
          
        <s:else>  
            下一页   尾页  
        </s:else>  
      
    </center><br>  
      
    <center>  
          
        <form action="/shareinformation/aa/informationAction.action" onsubmit="return validate();">  
            <font size="4">跳转至</font>  
            <input type="text" size="2" name="page">页  
            <input type="submit" value="跳转">  
        </form>  
          
    </center>  
</body>
</html>