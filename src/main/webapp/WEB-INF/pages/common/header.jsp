<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<!-- css公共样式表 -->
<link rel="stylesheet" href="<%=basePath%>static/css/common/style.css"/>
<link rel="stylesheet" href="<%=basePath%>static/css/common/common.css"/>
<script type="text/javascript">
<!--
var basePath = "<%=basePath%>";
//-->
</script>
<!-- 公共JS插件 -->
<script type="text/javascript" src="<%=basePath%>static/js/common/plugin/jquery/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>static/js/common/plugin/bootstrap/bootstrap.min.js"></script>