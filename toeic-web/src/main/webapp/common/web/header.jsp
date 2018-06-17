<!--HEADER ROW-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="formLogout" value="/logout.html">
    <c:param name="typeUrl" value="Logout"/>
</c:url>

<div id="header-row">
    <div class="container">
        <div class="row">
            <!--LOGO-->
            <div class="span3"><a class="brand" href="#"><img src="template/web/img/logo3.png"/></a></div>
            <!-- /LOGO -->

            <!-- MAIN NAVIGATION -->
            <div class="span9">
                <div class="navbar  pull-right">
                    <div class="navbar-inner">
                        <a data-target=".navbar-responsive-collapse" data-toggle="collapse" class="btn btn-navbar"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></a>
                        <div class="nav-collapse collapse navbar-responsive-collapse">
                            <ul class="nav">
                                <li class="active"><a href="">Trang Chủ</a></li>

                                <%--<li class="dropdown">--%>
                                    <%--<a href="about.html" class="dropdown-toggle" data-toggle="dropdown">About <b class="caret"></b></a>--%>
                                    <%--<ul class="dropdown-menu">--%>
                                        <%--<li><a href="about.html">Company</a></li>--%>
                                        <%--<li><a href="about.html">History</a></li>--%>
                                        <%--<li><a href="about.html">Team</a></li>--%>
                                    <%--</ul>--%>

                                <%--</li>--%>

                                <li><a href="login.html">Đăng Nhập</a></li>
                                <li><a href="blog.html">Blog</a></li>
                                <c:if test="${sessionScope.user !=null}">
                                    <li class="light-blue">
                                        <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                                            <span class="user-info">
									            <small>Xin Chào : </small>
									                ${sessionScope.user}
                                            </span>

                                            <i class="ace-icon fa fa-caret-down"></i>
                                        </a>

                                        <ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                                            <li>
                                                <form action="${formLogout}" method="post">
                                                    <button>
                                                        <i class="ace-icon fa fa-power-off"></i>
                                                        Logout
                                                    </button>
                                                </form>
                                            </li>
                                        </ul>
                                    </li>
                                </c:if>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <!-- MAIN NAVIGATION -->
        </div>
    </div>
</div>
<!-- /HEADER ROW -->