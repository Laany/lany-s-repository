<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css">
<link rel="stylesheet" type="text/css" href="css/skin_/nav.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<title>底部内容页</title>
</head>

<body>
<div id="container">
	<div id="bd">
    	<div class="sidebar">
        	<div class="sidebar-bg"></div>
            <i class="sidebar-hide"></i>
            <h2><a href="javascript:;"><i class="h2-icon" title="切换到树型结构"></i><span>安全管理</span></a></h2>
            <ul class="nav">
                <li class="nav-li">
                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">资料管理</span></a>
                    <ul class="subnav">
                    	<li class="subnav-li" href="default.html" data-id="8"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">视频管理</span></a></li>
                        <li class="subnav-li" href="form.html" data-id="9"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">文件管理</span></a></li>
                        <li class="subnav-li" href="default.html" data-id="10"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">音乐管理</span></a></li>
                        <li class="subnav-li" href="default.html" data-id="11"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">自定义设置1</span></a></li>
                    </ul>
                </li>
                <li class="nav-li current">
                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">用户信息设置</span></a>
                	<ul class="subnav">
                    	<li class="subnav-li current" href="/shareinformation/aa/UserAction" data-id="1"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">用户管理</span></a></li>
                        <li class="subnav-li" href="default.html" data-id="2"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">表单</span></a></li>
                        <li class="subnav-li" href="default.html" data-id="3"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">表格</span></a></li>
                        <li class="subnav-li" href="default.html" data-id="4"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">自定义设置2</span></a></li>
                    </ul>
                </li>
                <li class="nav-li">
                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">文件下载</span></a>
                    <ul class="subnav">
                    	<li class="subnav-li" href="/shareinformation/aa/informationAction.action" data-id="5"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">下载查询</span></a></li>
                        <li class="subnav-li" href="default.html" data-id="6"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">下载管理</span></a></li>
                        <li class="subnav-li" href="default.html" data-id="7"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">类型选择</span></a></li>
                    </ul>
                </li>
                <li class="nav-li last-nav-li">
                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">文件上传</span></a>
                    <ul class="subnav">
                    	<li class="subnav-li" href="default.html" data-id="12"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">上传查询</span></a></li>
                        <li class="subnav-li" href="file.jsp" data-id="13"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">上传管理</span></a></li>
                        <li class="subnav-li" href="default.html" data-id="14"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">类型选择</span></a></li>
                    </ul>
                </li>
            </ul>
            <div class="tree-list outwindow">
            	<div class="tree ztree"></div>
            </div>
        </div>
        <div class="main">
        	<div class="title">
                <i class="sidebar-show"></i>
                <ul class="tab ue-clear">
                   
                </ul>
                <i class="tab-more"></i>
                <i class="tab-close"></i>
            </div>
            <div class="content">
            </div>
        </div>
    </div>
</div>

<div class="more-bab-list">
	<ul></ul>
    <div class="opt-panel-ml"></div>
    <div class="opt-panel-mr"></div>
    <div class="opt-panel-bc"></div>
    <div class="opt-panel-br"></div>
    <div class="opt-panel-bl"></div>
</div>
</body>
<script type="text/javascript" src="js/nav.js"></script>
<script type="text/javascript" src="js/Menu.js"></script>
<script type="text/javascript" src="js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript">
	var menu = new Menu({
		defaultSelect: $('.nav').find('li[data-id="1"]')	
	});
	
	// 左侧树结构加载
	var setting = {};

		var zNodes =[
			{ name:"新闻管理",
			   children: [
				 { name:"新闻视频管理",icon:'img/skin_/leftlist.png'},
				 { name:"新闻频道管理",icon:'img/skin_/leftlist.png'},
				 { name:"地方新闻管理",icon:'img/skin_/leftlist.png'}
			]},
			{ name:"用户信息设置", open:true,
			   children: [
				 { name:"首页", checked:true,icon:'img/skin_/leftlist.png'},
				 { name:"表单",icon:'img/skin_/leftlist.png'},
				 { name:"表格",icon:'img/skin_/leftlist.png'},
				 { name:"自定义设置",icon:'img/skin_/leftlist.png'}
			]},
			{ name:"工作安排",
			   children: [
				 { name:"工作安排",icon:'img/skin_/leftlist.png'},
				 { name:"安排管理",icon:'img/skin_/leftlist.png'},
				 { name:"类型选择",icon:'img/skin_/leftlist.png'},
				 { name:"自定义设置",icon:'img/skin_/leftlist.png'}
			]},
			{ name:"数据管理",
			   children: [
				 { name:"工作安排",icon:'img/skin_/leftlist.png'},
				 { name:"安排管理",icon:'img/skin_/leftlist.png'},
				 { name:"类型选择",icon:'img/skin_/leftlist.png'},
				 { name:"自定义设置",icon:'img/skin_/leftlist.png'}
			]}
		];

	$.fn.zTree.init($(".tree"), setting, zNodes);
	
	
	$('.sidebar h2').click(function(e) {
        $('.tree-list').toggleClass('outwindow');
		$('.nav').toggleClass('outwindow');
    });
	
	$(document).click(function(e) {
		if(!$(e.target).is('.tab-more')){
			 $('.tab-more').removeClass('active');
			 $('.more-bab-list').hide();
		}
    });
</script>
</html>
