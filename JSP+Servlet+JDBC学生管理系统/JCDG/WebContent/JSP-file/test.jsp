<%@page import="jcdg.Grade"%>
<%@page import="jcdg.Student"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="/JCDG/ui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="/JCDG/ui/themes/icon.css">
		<link rel="stylesheet" type="text/css" href="/JCDG/ui/demo.css">
	<script type="text/javascript" src="/JCDG/ui/jquery.min.js"></script>
	<script type="text/javascript" src="/JCDG/ui/jquery.easyui.min.js"></script>
	<script type="text/javascript">
	function f1(param){
		for(var i =1;i<=6;i++){
		var id =document.getElementById("d"+i);
		id.style.display="none";
		if(i===param)
		{
		id.style.display="block";
		}
		}
		}

function altRows(id){
	if(document.getElementsByTagName){  
		
		var table = document.getElementById(id);  
		var rows = table.getElementsByTagName("tr"); 
		 
		for(i = 0; i < rows.length; i++){          
			if(i % 2 == 0){
				rows[i].className = "evenrowcolor";
			}else{
				rows[i].className = "oddrowcolor";
			}      
		}
	}
}

window.onload=function(){
	altRows('alternatecolor2');
	altRows('alternatecolor5');
}
//修改提交按钮
        function loadLocal(){
        	<%
        	Student student = (Student)request.getAttribute("result2");
       
        		%>   
        		<%
        		if (student != null)
        		{%>
        				$('#ll').form('load',{
    					student_id:'<%=student.getId() %>',
    					student_name:'<%=student.getName() %>',
    					school:'<%=student.getSchool() %>',
    					student_tel:'<%=student.getTel() %>',
    					student_qq:'<%=student.getQq() %>',
    					address:'<%=student.getAddress() %>'
    			});
			<% 
			}
			%>
		}
		function loadLocalg(){
			<%
        		Grade grade = (Grade)request.getAttribute("result3");
       
        		%>
        		
        		<%
        		if (grade != null)
        		{
        		%>
						$('#gg').form('load',{
						student_id:'<%=grade.getStudent_id() %>',
						student_name:'<%=grade.getStudent_name() %>',
						grade:'<%=grade.getGrade() %>',
				});
				<% 
                } 
                %>
		}
 
		function clearForm(){
			$('#ll').form('clear');
			$('#ss1').val("修改");
			$('#mm1').val("取消");
		}
		//添加提交按钮
		function submitForma(){
			$('#ff').form('submit');
		}
		function clearForma(){
			$('#ff').form('clear');
		}
		function clearForm1(){
			$('#ff2').form('clear');

		}
		function clearForm2(){
			$('#gg').form('clear');
			$('#ss').val("修改");
			$('#mm').val("取消");
		}
	</script>


	<style type="text/css">
	.ibutton {
	padding: 3px 15px;
	*padding: 0 15px; 
	*height: 24px; 
	font-size: 20px; 
	text-align: center; 
	text-shadow: #CF510B 0 1px 0; 
	border:1px solid #00EEEE 50%; 
	border-radius: 10px; 
	background: #00EEEE 50%; 
	background-image: -webkit-linear-gradient(#00EEEE 50%,#00CED1 100%); 
	color:black; cursor: pointer; display: inline-block; }  

	table.altrowstable {
		font-family: verdana,arial,sans-serif;
		font-size:20px;
		width:1500px;
		height:438px;
		color:BLACK;
		border-width: 1px;
		border-color: #a9c6c9;
		border-collapse: collapse;
	}
	table.altrowstable th {
		border-width: 1px;
		padding: 8px;
		border-style: solid;
		border-color: #a9c6c9;
		text-align: center; 
	}
	table.altrowstable td {
		border-width: 1px;
		padding: 8px;
		border-style: solid;
		border-color: #a9c6c9;
		text-align: center; 
	}
	.oddrowcolor{
		background-color:#FFFFFF;
	}
	.evenrowcolor{
		background-color:#F5FFFA;
	}
	</style>

</head>

		<body class="easyui-layout">
				<div data-options="region:'north'" style="height:100px; background: #00EEEE;background: -webkit-linear-gradient(#00EEEE 50%,#00CED1 100%);background: linear-gradient( #00EEEE 50%, #00CED1 100%);">

				<p  style="font-size:60px;display:inline;"><img src="/JCDG/jsp/test2.jpg"  height="96" width="96" style="display:inline;"> 
				<FONT style="FONT-SIZE: 40pt; FILTER: shadow(color=#af2dco); WIDTH: 100%; COLOR: #000000; LINE-HEIGHT: 100%; FONT-FAMILY: 华文行楷" size=6>
					四川大学锦城学院
				</FONT>	</p>
				</div>
		 <div data-options="region:'west'" style="width:200px;">
        <div class="easyui-panel" data-options="title:'功能导航',border:false,fit:true">
            <div class="easyui-accordion" data-options="fit:true,border:false">
                <div title="系统菜单" data-options="iconCls:'icon-save'">
<ul class="easyui-tree" data-options="url:'${pageContext.request.contextPath}/menuAction!allTreeNode.action',parentField:'pid',lines:true,onClick:function(node){var url = '${pageContext.request.contextPath}'+node.attributes.url;addTab({title:node.text,href:url});}">
             	<ul>
					<li ><input type="button" class="ibutton"  value="学生信息添加" onclick="f1(1) ;"></li>
					<br>
					<li><input type="button"  class="ibutton" value="信息修改查询" onclick="f1(2);"></li>
					<br>
					<li><input type="button" class="ibutton"   value="学生删除" onclick="f1(3);"></li>
						<br>
					<li><input type="button" class="ibutton"   value="成绩添加" onclick="f1(4);"></li>
						<br>
					<li><input type="button" class="ibutton"   value="成绩修改查询" onclick="f1(5);"></li>
							<br>
					<li><input type="button" class="ibutton"   value="成绩删除" onclick="f1(6);"></li>

				</ul>
              </ul> 
                </div>
            </div>
        </div>
			
			
       
				</div>
		<div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:100px;padding:10px;">east region</div>
		<div data-options="region:'south',border:false" style="height:50px; background: #00EEEE;background: -webkit-linear-gradient(#00C5CD 50%,#00CED1 100%);background: linear-gradient( #00C5CD 50%, #00CED1 100%);padding:10px;">south region</div>
		<div data-options="region:'center',title:'欢迎'"  style="background-image:url(/JCDG/jsp/bg.jpg);background-repeat:no-repeat;width:100%; height:100%;">
		
				<!-- 表 -->
				<div style="display:none;" id="d1">

<!-- 添加框 -->

		<div style="margin:0px 0;width:300px"></div>
	<div class="easyui-panel" title="请输入学生信息" style="width:100%;max-width:400px;padding:30px 60px;">
		<form id="ff" method="post" action="/JCDG/AddStudent">
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="student_id" style="width:260px" data-options="label:'学号:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="student_name" style="width:260px" data-options="label:'姓名:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="school" style="width:260px" data-options="label:'学校:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="student_tel" style="width:260px" data-options="label:'手机号码:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="student_qq" style="width:260px" data-options="label:'QQ',required:true">
			</div>
						<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="address" style="width:260px" data-options="label:'地址',required:true">
			</div>
		
		<div style="text-align:center;padding:5px 0">
			<input type="submit" value="确认" class="easyui-linkbutton"style="width:80px">
					<input  value="清空" class="easyui-linkbutton"onclick="clearForma()" style="width:80px">
		</div></form>
	</div>

		</div>
	<!-- 按钮2-->
	
			<div style="display:none;" id="d2">
	
			<table class="altrowstable" id="alternatecolor2">
			
<tr>
<th>学号</th><th>姓名</th><th>学校</th><th>手机</th><th>QQ</th><th>地址</th>
</tr>

<%
List<Student> temp=(List<Student>)request.getAttribute("result");
for(int i=0;i<temp.size();i++)
{
%>
<tr>
		<td><%=temp.get(i).getId() %></td>
		<td><%=temp.get(i).getName() %></td>
		<td><%=temp.get(i).getSchool() %></td>
		<td><%=temp.get(i).getTel() %></td>
		<td><%=temp.get(i).getQq() %></td>
		<td><%=temp.get(i).getAddress() %></td>
</tr>
<%
}
%>
</table>

							<!-- 搜索框-->
<div style="margin:0px 0;"></div>
	<div  class="easyui-panel" style="width:100%;max-width:200px;padding:10px 10px;">
		<input class="easyui-searchbox" data-options="prompt:'请输入学号',searcher:doSearch1" style="width:100%">
	</div>
	<script>
		function doSearch1(value){
			alert('You input: ' + value);
			window.location.href="/JCDG/GetIndex?id="+value;
		}
	</script>


	<div class="easyui-panel" title="New Topic" style="width:100%;max-width:400px;padding:30px 60px;">
	<form id="ll" method="post" action="/JCDG/AlterStudent">
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="student_id" style="width:260px" data-options="label:'学号:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="student_name" style="width:260px" data-options="label:'姓名:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="school" style="width:260px" data-options="label:'学校:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="student_tel" style="width:260px" data-options="label:'手机号码:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="student_qq" style="width:260px" data-options="label:'QQ',required:true">
			</div>
						<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="address" style="width:260px" data-options="label:'地址',required:true">
			</div>
			<div style="margin:20px 0;">
		<input  id="ss1" value="修改" class="easyui-linkbutton" style="width:80px" onclick="loadLocal()">
		<input type="submit" value="确认" class="easyui-linkbutton"style="width:80px">
					<input  id="mm1" value="取消" class="easyui-linkbutton"onclick="clearForm()" style="width:80px">
	</div>
		</form>
	</div>

	</div>
	
	<!-- 删除 -->
	
	<div style="display:none;" id="d3">
		
					<div style="margin:0px 0;width:300px"></div>
	<div class="easyui-panel" title="请输入要删除学生学号" style="width:100%;max-width:400px;padding:30px 60px;">
		<form id="dd" method="post" action="/JCDG/DeleteStudent">
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="id" style="width:260px" data-options="label:'学号:',required:true">
			</div>

		<div style="text-align:center;padding:5px 0">
			<input type="submit" value="确认">
		</div>		
		</form>
	</div>			
	
				</div>
				
				<!-- 成绩添加 -->
						<div style="display:none;" id="d4">
			
<!-- 添加框 -->

		<div style="margin:0px 0;width:300px"></div>
	<div class="easyui-panel" title="请输入学生信息" style="width:100%;max-width:400px;padding:30px 60px;">
		<form id="ff2" method="post" action="/JCDG/AddGrade">
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="student_id" style="width:260px" data-options="label:'学号:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="student_name" style="width:260px" data-options="label:'姓名:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="grade" style="width:260px" data-options="label:'成绩:',required:true">
			</div>
		
		
		<div style="text-align:center;padding:5px 0">
			<input type="submit" value="确认" class="easyui-linkbutton"style="width:80px">
					<input  value="清空" class="easyui-linkbutton"onclick="clearForma1()" style="width:80px">
		</div></form>
	</div>

		</div>
<div style="display:none;" id="d5">
								<!-- 搜索框-->
	

<table class="altrowstable" id="alternatecolor5">

<tr>
<th>学号</th><th>姓名</th><th>成绩</th>
</tr>

<%
List<Grade> temp1=(List<Grade>)request.getAttribute("result1");
for(int i=0;i<temp1.size();i++)
{
%>
<tr>
		<td><%=temp1.get(i).getStudent_id() %></td>
		<td><%=temp1.get(i).getStudent_name() %></td>
		<td><%=temp1.get(i).getGrade() %></td>
</tr>
<%
}
%>




	</table>

<div style="margin:0px 0;"></div>

	<div class="easyui-panel" style="width:100%;max-width:200px;padding:10px 10px;">
		<input class="easyui-searchbox" data-options="prompt:'请输入学号',searcher:doSearch2" style="width:100%">
	</div>
	<script>
		function doSearch2(value){
			alert('You input: ' + value);
			window.location.href="/JCDG/GetIndex2?id="+value;
		}
	</script>
	<div class="easyui-panel" title="New Topic" style="width:100%;max-width:400px;padding:30px 60px;">
		<form id="gg" method="post" action="/JCDG/AlterGrade">
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="student_id" style="width:260px" data-options="label:'学号:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="student_name" style="width:260px" data-options="label:'姓名:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="grade" style="width:260px" data-options="label:'总成绩:',required:true">
			</div>
			<div style="margin:20px 0;">
				<input  id="ss" value="修改" class="easyui-linkbutton" style="width:80px" onclick="loadLocalg()">
				<input type="submit" value="确认" class="easyui-linkbutton"style="width:80px">
				<input  id="mm"  value="取消" class="easyui-linkbutton"onclick="clearForm2()" style="width:80px">
			</div>
		</form>
	</div>

	</div>
		
	<!-- 删除 -->
	
	<div style="display:none;" id="d6">
		
					<div style="margin:0px 0;width:300px"></div>
	<div class="easyui-panel" title="请输入要删除学生学号" style="width:100%;max-width:400px;padding:30px 60px;">
		<form id="dd" method="post" action="/JCDG/DeleteGrade">
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="student_id" style="width:260px" data-options="label:'学号:',required:true">
			</div>

		<div style="text-align:center;padding:5px 0">
			<input type="submit" value="确认">
		</div>		
		</form>
	</div>			
	
				</div>
					
		
		
		
		
		
		
		
		
		
	</div>


		</body>
</html>