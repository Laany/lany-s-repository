<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>My HTML starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
<link rel="stylesheet" type="text/css" href="styles.css">
-->
<style>
.c1{
width:200px;
height:200px;
border:red solid 1px
}
</style>
<script type="text/javascript">
function f1(param){
for(var i =1;i<=4;i++){
var id =document.getElementById("d"+i);
id.style.display="none";
if(i===param)
{
id.style.display="block";
}
}
}
</script>
</head>
<body>
<input type="button" value="按钮1" onclick="f1(1);">
<input type="button" value="按钮2" onclick="f1(2);">
<input type="button" value="按钮3" onclick="f1(3);">
<input type="button" value="按钮4" onclick="f1(4);">
<div id="d1" class="c1">111111111</div>
<div id="d2" class="c1" style="display:none">22222222</div>
<div id="d3" class="c1" style="display:none">33333333</div>
<div id="d4" class="c1" style="display:none">44444444</div>
</body>
</html>