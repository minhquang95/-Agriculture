<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <title><dec:title default="Login Page"/> </title>
    <meta name="description" content="overview &amp; stats" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
    <link rel="stylesheet" href="<c:url value='/template/assets/css/bootstrap.min.css' />" />
    <link rel="stylesheet" href="<c:url value='/template/font-awesome/4.5.0/css/font-awesome.min.css' />" />
    <link rel="stylesheet" href="<c:url value='/template/font/font-awesome.min.css' />" />
    <link rel="stylesheet" href="<c:url value='/template/assets/css/ace.min.css'/>" class="ace-main-stylesheet" id="main-ace-style" />
    <link rel="stylesheet" href="<c:url value='/template/assets/css/ace-part2.min.css' />" class="ace-main-stylesheet" />
    <link rel="stylesheet" href="<c:url value='/template/assets/css/ace-ie.min.css' />" />
    <script src="<c:url value='/template/assets/js/ace-extra.min.js' />"></script>
    <script src="<c:url value='/template/assets/js/html5shiv.min.js' />"></script>
    <script src="<c:url value='/template/assets/js/respond.min.js' />"></script>
    <dec:head />
</head>
<body class="login-layout">

<div class="main-container">
    <div class="main-content">
        <div class="row">
            <div class="col-sm-10 col-sm-offset-1">
                <div class="login-container">
                    <%@ include file="/common/login/header.jsp"%>
                    <div class="position-relative">
                        <dec:body/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%--<%@ include file="/common/web/footer.jsp" %>--%>

<script src="<c:url value='/template/assets/js/bootstrap.min.js' />"></script>
<script src="<c:url value='/template/assets/js/excanvas.min.js' />"></script>
<script src="<c:url value='/template/assets/js/jquery-ui.custom.min.js' />"></script>
<script src="<c:url value='/template/assets/js/jquery.ui.touch-punch.min.js' />"></script>
<script src="<c:url value='/template/assets/js/jquery.easypiechart.min.js' />"></script>
<script src="<c:url value='/template/assets/js/jquery.sparkline.min.js' />"></script>
<script src="<c:url value='/template/assets/js/jquery.flot.min.js' />"></script>
<script src="<c:url value='/template/assets/js/jquery.flot.pie.min.js' />"></script>
<script src="<c:url value='/template/assets/js/jquery.flot.resize.min.js' />"></script>

<script src="<c:url value='/template/assets/js/ace-elements.min.js' />"></script>
<script src="<c:url value='/template/assets/js/ace.min.js' />"></script>

</body>
</html>
