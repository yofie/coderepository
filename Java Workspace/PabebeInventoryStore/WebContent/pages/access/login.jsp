<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/pages/commons/scripts.jsp" %>
<title>Pabebe Inventory Store</title>
<script src="http://tympanus.net/Development/MinimalForm/js/modernizr.custom.js"></script>
</head>
<body>
    <!-- cover.css -->
    <style>
        /*
 * Globals
 */

/* Links */
a,
a:focus,
a:hover {
  color: #fff;
}

/* Custom default button */
.btn-default,
.btn-default:hover,
.btn-default:focus {
  color: #333;
  text-shadow: none; /* Prevent inheritence from `body` */
  background-color: #fff;
  border: 1px solid #fff;
}


/*
 * Base structure
 */

html,
body {
  height: 100%;
  background-color: #333;
}
body {
  color: #fff;
  text-align: center;
  text-shadow: 0 1px 3px rgba(0,0,0,.5);
}

/* Extra markup and styles for table-esque vertical and horizontal centering */
.site-wrapper {
  display: table;
  width: 100%;
  height: 100%; /* For at least Firefox */
  min-height: 100%;
}
.site-wrapper-inner {
  display: table-cell;
  vertical-align: top;
}
.cover-container {
  margin-right: auto;
  margin-left: auto;
}

/* Padding for spacing */
.inner {
  padding: 30px;
}


/*
 * Header
 */
.masthead-brand {
  margin-top: 10px;
  margin-bottom: 10px;
}

.masthead-nav > li {
  display: inline-block;
}
.masthead-nav > li + li {
  margin-left: 20px;
}
.masthead-nav > li > a {
  padding-right: 0;
  padding-left: 0;
  font-size: 16px;
  font-weight: bold;
  color: #fff; /* IE8 proofing */
  color: rgba(255,255,255,.75);
  border-bottom: 2px solid transparent;
}
.masthead-nav > li > a:hover,
.masthead-nav > li > a:focus {
  background-color: transparent;
  border-bottom-color: #a9a9a9;
  border-bottom-color: rgba(255,255,255,.25);
}
.masthead-nav > .active > a,
.masthead-nav > .active > a:hover,
.masthead-nav > .active > a:focus {
  color: #fff;
  border-bottom-color: #fff;
}

@media (min-width: 768px) {
  .masthead-brand {
    float: left;
  }
  .masthead-nav {
    float: right;
  }
}


/*
 * Cover
 */

.cover {
  padding: 0 20px;
  margin-top: -230px;
}
.cover .btn-lg {
  padding: 10px 20px;
  font-weight: bold;
}


/*
 * Footer
 */

.mastfoot {
  color: #999; /* IE8 proofing */
  color: rgba(255,255,255,.5);
}


/*
 * Affix and center
 */

@media (min-width: 768px) {
  /* Pull out the header and footer */
  .masthead {
    position: fixed;
    top: 0;
  }
  .mastfoot {
    position: fixed;
    bottom: 0;
  }
  /* Start the vertical centering */
  .site-wrapper-inner {
    vertical-align: middle;
  }
  /* Handle the widths */
  .masthead,
  .mastfoot,
  .cover-container {
    width: 100%; /* Must be percentage or pixels for horizontal alignment */
  }
}

@media (min-width: 992px) {
  .masthead,
  .mastfoot,
  .cover-container {
    width: 700px;
  }
}
        
    </style>
    <!-- END cover.css -->
<div class="site-wrapper">
    <div class="site-wrapper-inner">
        <div class="cover-container">
            <div class="masthead clearfix">
                <div class="inner">
                  <h3 class="masthead-brand">Samahang Pabebe ng Pilipinas</h3>
                  <nav>
                    <ul class="nav masthead-nav">
                      <li class="active"><a href="ValidateLogin">Home</a></li>
                      <li><a href="LogOut">Items</a></li>
                    </ul>
                  </nav>
                </div>
            </div>
            <div class="inner cover">
                <div class="wrap">
                    <!-- Invisible SVG -->
                    <svg viewBox="0 0 600 300" class="svg-defs">
                        <!-- Symbol wth text -->
                        <symbol id="s-text">
                            <symbol id="s-text">
                                                            <text text-anchor="middle"
                                                                      font-size= "70"
                                                                      x="50%"
                                                                      y="50%"
                                                                      dy=".35em"
                                                                      class="text"
                                                                      >
                                                              pabebe store
                                                            </text>
                                                            <text text-anchor="middle"
                                                                      font-size= "30"
                                                                      x="50%"
                                                                      y="65%"
                                                                      dy=".35em"
                                                                      class="text"
                                                                      >
                                                              inventory system
                                                            </text> 
                                                            </symbol>
                        </symbol>

                        <!-- Mask with text -->
                        <mask id="m-text" maskunits="userSpaceOnUse" maskcontentunits="userSpaceOnUse">
                            <rect width="100%" height="100%" class="mask__shape">
                            </rect>
                            <use xlink:href="#s-text" class="text-mask"></use>
                        </mask>
                    </svg>
                    
                    <div class="box-with-text">
                        <!-- Content for text -->
                        <div class="text-fill">
                            <!-- Element with animated shadows -->
                            <div class="shadows"></div>
                        </div>

                        <!-- SVG to cover text fill -->
                        <svg viewBox="0 0 600 300" class="svg-inverted-mask">
                            <!-- Big shape with hole in form of text -->
                            <rect width="100%" height="100%" mask="url(#m-text)" class="shape--fill" />
                            <!-- Transparent copy of text to keep patterned text selectable -->
                            <use xlink:href="#s-text" class="text--transparent"></use>
                        </svg>
                    </div>
                </div>


                <section>
                        <form id="theForm" class="simform" autocomplete="off" action="ValidateLogin" method="POST">
                                <div class="simform-inner">
                                        <ol class="questions">
                                                <li>
                                                        <span><label for="q1">Enter Username:</label></span>
                                                        <input id="q1" name="username" type="text" />
                                                </li>
                                                <li>
                                                        <span><label for="q2">Enter your Password:</label></span>
                                                        <input id="q2" name="password" type="password" />
                                                </li>
                                        </ol><!-- /questions -->
                                        <button class="submit" type="submit"  value="Login">Send answers</button>
                                        <div class="controls">
                                                <button class="next"></button>
                                                <div class="progress"></div>
                                                <span class="number">
                                                        <span class="number-current"></span>
                                                        <span class="number-total"></span>
                                                </span>
                                                <span class="error-message"></span>
                                        </div><!-- / controls -->
                                </div><!-- /simform-inner -->
                                <span class="final-message"></span>
                                <c:if test="${not empty usernameerrmsg}">
									<script>
									$(document).ready(function(){
									        $("#myModal").modal();
									    
									});
									</script>
                                </c:if>
                                <c:if test="${not empty passworderrmsg}">
									<script>
									$(document).ready(function(){
									        $("#myModal").modal();
									    
									});
									</script>
                                </c:if>
                        </form><!-- /simform -->			
                </section>
            </div>
            <div class="mastfoot">
                <div class="inner">
                  <p>Cover template for <a href="http://getbootstrap.com">Bootstrap</a>, by <a href="https://twitter.com/mdo">@mdo</a>.</p>
                </div>
	    	</div>
	    		<!-- Modal -->
	  <div class="modal fade" id="myModal" role="dialog">
		  <div class="cover-container">
		  			<div class="col-md-4 col-md-offset-4" style="margin-top: 10px">
	                    <div class="panel panel-danger">
	                        <div class="panel-heading">
	                            <button type="button" class="close" data-dismiss="modal">&times;</button>
		          				<h5 class="modal-title">Login Failed</h5>
	                        </div>
	                        <div class="panel-body">
	                            <h4>
					          	<c:out value="${usernameerrmsg}"/>
				              	<c:out value="${passworderrmsg}"/>
				              	</h4>
				            </div>
	                        <div class="panel-footer">
	                            <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
	                        </div>
	                    </div>
	                </div>
		  </div>
	  </div>
	</div>
    </div>
    
    
    
	<!-- 
	<form id="login" action="ValidateLogin" method="POST">
	<table align="center" width="400px">
		<tr>
			<td>Username</td>
			<td><input type="text" id="username" name="username" value="<c:out value="${username}"/>"/></td>
			<td><c:out value=" ${usernameerrmsg} "/></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" id="password" name="password" value="<c:out value="${password}"/>"/></td>
			<td><c:out value="${passworderrmsg}"/></td>
		</tr>		
		<tr>
			<td colspan="3" align="center"><input type="submit" value="Login"/></td>
	</table>
	</form>
	 -->
	
</div>

	<!-- HEADER & BG COLOR Style -->
	<style>
	@CHARSET "ISO-8859-1";

@import url(http://fonts.googleapis.com/css?family=Raleway:400,500,700|Open+Sans:800);

@font-face {
	font-weight: normal;
	font-style: normal;
	font-family: 'codropsicons';
	src:url('../fonts/codropsicons/codropsicons.eot');
	src:url('../fonts/codropsicons/codropsicons.eot?#iefix') format('embedded-opentype'),
		url('../fonts/codropsicons/codropsicons.woff') format('woff'),
		url('../fonts/codropsicons/codropsicons.ttf') format('truetype'),
		url('../fonts/codropsicons/codropsicons.svg#codropsicons') format('svg');
}

*, *:after, *:before { -webkit-box-sizing: border-box; box-sizing: border-box; }
.clearfix:before, .clearfix:after { content: ''; display: table; }
.clearfix:after { clear: both; }

/* Main stuff */
.svg-inverted-mask {
  position: absolute;
  width: 100%;
  height: 100%;
  top: 0; }

.mask__shape {
  fill: white; }

.box-with-text {
  position: absolute;
  top: 50%;
  width: 100%;
  padding-top: 50%;
  -webkit-transform: translateY(-50%);
  transform: translateY(-50%);
  /* Hide the line */ }
  .box-with-text:after {
    content: '';
    display: block;
    position: absolute;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    /* BACKGROUND COLOR */
  /*  border: 2px solid lightgoldenrodyellow;  */
  border: 2px solid #B3FFA1;
  }

.text-fill {
  position: absolute;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  margin: auto;
  overflow: hidden; }

.shape--fill {
    /* BACKGROUND COLOR */
  /*fill: lightgoldenrodyellow; } */
  fill: #B3FFA1;
}
/* Transparent copy of text to keep patterned text selectable */
.text--transparent {
  fill: transparent; }

/* Function for getting colors from list if we need quantity of colors more than colors in array  */
/* Function for creating multiple box-shadow */
/* Element with animated shadows */
.shadows {
  position: absolute;
  left: 50%;
  top: 50%;
  width: 1vmax;
  height: 1vmax;
  background: gold;
  border-radius: 50%;
  box-shadow: 0 0 0 2vmax purple, 0 0 0 4vmax crimson, 0 0 0 6vmax red, 0 0 0 8vmax orangered, 0 0 0 10vmax tomato, 0 0 0 12vmax gold, 0 0 0 14vmax yellow, 0 0 0 16vmax yellowgreen, 0 0 0 18vmax turquoise, 0 0 0 20vmax royalblue, 0 0 0 22vmax mediumslateblue, 0 0 0 24vmax mediumorchid, 0 0 0 26vmax purple, 0 0 0 28vmax crimson, 0 0 0 30vmax red, 0 0 0 32vmax orangered, 0 0 0 34vmax tomato, 0 0 0 36vmax gold, 0 0 0 38vmax yellow, 0 0 0 40vmax yellowgreen, 0 0 0 42vmax turquoise, 0 0 0 44vmax royalblue, 0 0 0 46vmax mediumslateblue, 0 0 0 48vmax mediumorchid, 0 0 0 50vmax darkviolet, 0 0 0 52vmax purple, 0 0 0 54vmax crimson, 0 0 0 56vmax red, 0 0 0 58vmax orangered, 0 0 0 60vmax tomato, 0 0 0 62vmax gold, 0 0 0 64vmax yellow, 0 0 0 66vmax yellowgreen, 0 0 0 68vmax turquoise, 0 0 0 70vmax royalblue, 0 0 0 72vmax mediumslateblue, 0 0 0 74vmax mediumorchid, 0 0 0 76vmax darkviolet, 0 0 0 78vmax purple, 0 0 0 80vmax crimson, 0 0 0 82vmax red, 0 0 0 84vmax orangered, 0 0 0 86vmax tomato, 0 0 0 88vmax gold, 0 0 0 90vmax yellow;
  -webkit-animation: shadows-move 4s linear infinite;
  animation: shadows-move 4s linear infinite; }

@-webkit-keyframes shadows-move {
  25% {
    box-shadow: 0 0 0 2vmax royalblue, 0 0 0 4vmax mediumslateblue, 0 0 0 6vmax mediumorchid, 0 0 0 8vmax purple, 0 0 0 10vmax crimson, 0 0 0 12vmax red, 0 0 0 14vmax orangered, 0 0 0 16vmax tomato, 0 0 0 18vmax gold, 0 0 0 20vmax yellow, 0 0 0 22vmax yellowgreen, 0 0 0 24vmax turquoise, 0 0 0 26vmax royalblue, 0 0 0 28vmax mediumslateblue, 0 0 0 30vmax mediumorchid, 0 0 0 32vmax darkviolet, 0 0 0 34vmax purple, 0 0 0 36vmax crimson, 0 0 0 38vmax red, 0 0 0 40vmax orangered, 0 0 0 42vmax tomato, 0 0 0 44vmax gold, 0 0 0 46vmax yellow, 0 0 0 48vmax yellowgreen, 0 0 0 50vmax turquoise, 0 0 0 52vmax royalblue, 0 0 0 54vmax mediumslateblue, 0 0 0 56vmax mediumorchid, 0 0 0 58vmax darkviolet, 0 0 0 60vmax purple, 0 0 0 62vmax crimson, 0 0 0 64vmax red, 0 0 0 66vmax orangered, 0 0 0 68vmax tomato, 0 0 0 70vmax gold, 0 0 0 72vmax yellow, 0 0 0 74vmax yellowgreen, 0 0 0 76vmax turquoise, 0 0 0 78vmax royalblue, 0 0 0 80vmax mediumslateblue, 0 0 0 82vmax mediumorchid, 0 0 0 84vmax darkviolet, 0 0 0 86vmax purple, 0 0 0 88vmax crimson, 0 0 0 90vmax red; }
  45% {
    box-shadow: 0 0 0 2vmax yellow, 0 0 0 4vmax yellowgreen, 0 0 0 6vmax turquoise, 0 0 0 8vmax royalblue, 0 0 0 10vmax mediumslateblue, 0 0 0 12vmax mediumorchid, 0 0 0 14vmax purple, 0 0 0 16vmax crimson, 0 0 0 18vmax red, 0 0 0 20vmax orangered, 0 0 0 22vmax tomato, 0 0 0 24vmax gold, 0 0 0 26vmax yellow, 0 0 0 28vmax yellowgreen, 0 0 0 30vmax turquoise, 0 0 0 32vmax royalblue, 0 0 0 34vmax mediumslateblue, 0 0 0 36vmax mediumorchid, 0 0 0 38vmax darkviolet, 0 0 0 40vmax purple, 0 0 0 42vmax crimson, 0 0 0 44vmax red, 0 0 0 46vmax orangered, 0 0 0 48vmax tomato, 0 0 0 50vmax gold, 0 0 0 52vmax yellow, 0 0 0 54vmax yellowgreen, 0 0 0 56vmax turquoise, 0 0 0 58vmax royalblue, 0 0 0 60vmax mediumslateblue, 0 0 0 62vmax mediumorchid, 0 0 0 64vmax darkviolet, 0 0 0 66vmax purple, 0 0 0 68vmax crimson, 0 0 0 70vmax red, 0 0 0 72vmax orangered, 0 0 0 74vmax tomato, 0 0 0 76vmax gold, 0 0 0 78vmax yellow, 0 0 0 80vmax yellowgreen, 0 0 0 82vmax turquoise, 0 0 0 84vmax royalblue, 0 0 0 86vmax mediumslateblue, 0 0 0 88vmax mediumorchid, 0 0 0 90vmax darkviolet; }
  75% {
    box-shadow: 0 0 0 2vmax orangered, 0 0 0 4vmax tomato, 0 0 0 6vmax gold, 0 0 0 8vmax yellow, 0 0 0 10vmax yellowgreen, 0 0 0 12vmax turquoise, 0 0 0 14vmax royalblue, 0 0 0 16vmax mediumslateblue, 0 0 0 18vmax mediumorchid, 0 0 0 20vmax purple, 0 0 0 22vmax crimson, 0 0 0 24vmax red, 0 0 0 26vmax orangered, 0 0 0 28vmax tomato, 0 0 0 30vmax gold, 0 0 0 32vmax yellow, 0 0 0 34vmax yellowgreen, 0 0 0 36vmax turquoise, 0 0 0 38vmax royalblue, 0 0 0 40vmax mediumslateblue, 0 0 0 42vmax mediumorchid, 0 0 0 44vmax darkviolet, 0 0 0 46vmax purple, 0 0 0 48vmax crimson, 0 0 0 50vmax red, 0 0 0 52vmax orangered, 0 0 0 54vmax tomato, 0 0 0 56vmax gold, 0 0 0 58vmax yellow, 0 0 0 60vmax yellowgreen, 0 0 0 62vmax turquoise, 0 0 0 64vmax royalblue, 0 0 0 66vmax mediumslateblue, 0 0 0 68vmax mediumorchid, 0 0 0 70vmax darkviolet, 0 0 0 72vmax purple, 0 0 0 74vmax crimson, 0 0 0 76vmax red, 0 0 0 78vmax orangered, 0 0 0 80vmax tomato, 0 0 0 82vmax gold, 0 0 0 84vmax yellow, 0 0 0 86vmax yellowgreen, 0 0 0 88vmax turquoise, 0 0 0 90vmax royalblue; } }
@keyframes shadows-move {
  25% {
    box-shadow: 0 0 0 2vmax royalblue, 0 0 0 4vmax mediumslateblue, 0 0 0 6vmax mediumorchid, 0 0 0 8vmax purple, 0 0 0 10vmax crimson, 0 0 0 12vmax red, 0 0 0 14vmax orangered, 0 0 0 16vmax tomato, 0 0 0 18vmax gold, 0 0 0 20vmax yellow, 0 0 0 22vmax yellowgreen, 0 0 0 24vmax turquoise, 0 0 0 26vmax royalblue, 0 0 0 28vmax mediumslateblue, 0 0 0 30vmax mediumorchid, 0 0 0 32vmax darkviolet, 0 0 0 34vmax purple, 0 0 0 36vmax crimson, 0 0 0 38vmax red, 0 0 0 40vmax orangered, 0 0 0 42vmax tomato, 0 0 0 44vmax gold, 0 0 0 46vmax yellow, 0 0 0 48vmax yellowgreen, 0 0 0 50vmax turquoise, 0 0 0 52vmax royalblue, 0 0 0 54vmax mediumslateblue, 0 0 0 56vmax mediumorchid, 0 0 0 58vmax darkviolet, 0 0 0 60vmax purple, 0 0 0 62vmax crimson, 0 0 0 64vmax red, 0 0 0 66vmax orangered, 0 0 0 68vmax tomato, 0 0 0 70vmax gold, 0 0 0 72vmax yellow, 0 0 0 74vmax yellowgreen, 0 0 0 76vmax turquoise, 0 0 0 78vmax royalblue, 0 0 0 80vmax mediumslateblue, 0 0 0 82vmax mediumorchid, 0 0 0 84vmax darkviolet, 0 0 0 86vmax purple, 0 0 0 88vmax crimson, 0 0 0 90vmax red; }
  45% {
    box-shadow: 0 0 0 2vmax yellow, 0 0 0 4vmax yellowgreen, 0 0 0 6vmax turquoise, 0 0 0 8vmax royalblue, 0 0 0 10vmax mediumslateblue, 0 0 0 12vmax mediumorchid, 0 0 0 14vmax purple, 0 0 0 16vmax crimson, 0 0 0 18vmax red, 0 0 0 20vmax orangered, 0 0 0 22vmax tomato, 0 0 0 24vmax gold, 0 0 0 26vmax yellow, 0 0 0 28vmax yellowgreen, 0 0 0 30vmax turquoise, 0 0 0 32vmax royalblue, 0 0 0 34vmax mediumslateblue, 0 0 0 36vmax mediumorchid, 0 0 0 38vmax darkviolet, 0 0 0 40vmax purple, 0 0 0 42vmax crimson, 0 0 0 44vmax red, 0 0 0 46vmax orangered, 0 0 0 48vmax tomato, 0 0 0 50vmax gold, 0 0 0 52vmax yellow, 0 0 0 54vmax yellowgreen, 0 0 0 56vmax turquoise, 0 0 0 58vmax royalblue, 0 0 0 60vmax mediumslateblue, 0 0 0 62vmax mediumorchid, 0 0 0 64vmax darkviolet, 0 0 0 66vmax purple, 0 0 0 68vmax crimson, 0 0 0 70vmax red, 0 0 0 72vmax orangered, 0 0 0 74vmax tomato, 0 0 0 76vmax gold, 0 0 0 78vmax yellow, 0 0 0 80vmax yellowgreen, 0 0 0 82vmax turquoise, 0 0 0 84vmax royalblue, 0 0 0 86vmax mediumslateblue, 0 0 0 88vmax mediumorchid, 0 0 0 90vmax darkviolet; }
  75% {
    box-shadow: 0 0 0 2vmax orangered, 0 0 0 4vmax tomato, 0 0 0 6vmax gold, 0 0 0 8vmax yellow, 0 0 0 10vmax yellowgreen, 0 0 0 12vmax turquoise, 0 0 0 14vmax royalblue, 0 0 0 16vmax mediumslateblue, 0 0 0 18vmax mediumorchid, 0 0 0 20vmax purple, 0 0 0 22vmax crimson, 0 0 0 24vmax red, 0 0 0 26vmax orangered, 0 0 0 28vmax tomato, 0 0 0 30vmax gold, 0 0 0 32vmax yellow, 0 0 0 34vmax yellowgreen, 0 0 0 36vmax turquoise, 0 0 0 38vmax royalblue, 0 0 0 40vmax mediumslateblue, 0 0 0 42vmax mediumorchid, 0 0 0 44vmax darkviolet, 0 0 0 46vmax purple, 0 0 0 48vmax crimson, 0 0 0 50vmax red, 0 0 0 52vmax orangered, 0 0 0 54vmax tomato, 0 0 0 56vmax gold, 0 0 0 58vmax yellow, 0 0 0 60vmax yellowgreen, 0 0 0 62vmax turquoise, 0 0 0 64vmax royalblue, 0 0 0 66vmax mediumslateblue, 0 0 0 68vmax mediumorchid, 0 0 0 70vmax darkviolet, 0 0 0 72vmax purple, 0 0 0 74vmax crimson, 0 0 0 76vmax red, 0 0 0 78vmax orangered, 0 0 0 80vmax tomato, 0 0 0 82vmax gold, 0 0 0 84vmax yellow, 0 0 0 86vmax yellowgreen, 0 0 0 88vmax turquoise, 0 0 0 90vmax royalblue; } }
/* Other stuff */
html,
body {}

body {
    /* BACKGROUND COLOR */
  /*background: lightgoldenrodyellow; } */
  background: #B3FFA1;}

.svg-defs {
  width: 0;
  height: 0; }

.wrap {
  width: 100%;
  height: 300px;
  position: relative;
  font: 800 14.5em/1 Open Sans, Impact;
  text-transform: uppercase;
  text-align: left;
  overflow: hidden;
  }

/*# sourceMappingURL=style21.css.map */
	
	</style>
	<!-- END HEADER & BG COLOR Style -->
	<!-- FOR Minimal Form Style -->
		<!-- demo.css -->
		<style>
		@import url(http://fonts.googleapis.com/css?family=Lato:400,700,400italic);
@font-face {
	font-weight: normal;
	font-style: normal;
	font-family: 'codropsicons';
	src:url('../fonts/codropsicons/codropsicons.eot');
	src:url('../fonts/codropsicons/codropsicons.eot?#iefix') format('embedded-opentype'),
		url('../fonts/codropsicons/codropsicons.woff') format('woff'),
		url('../fonts/codropsicons/codropsicons.ttf') format('truetype'),
		url('../fonts/codropsicons/codropsicons.svg#codropsicons') format('svg');
}

*, *:after, *:before { -webkit-box-sizing: border-box; -moz-box-sizing: border-box; box-sizing: border-box; }
.clearfix:before, .clearfix:after { content: ''; display: table; }
.clearfix:after { clear: both; }

body {
	color: rgba(0,0,0,0.45);
	font-size: 100%;
	line-height: 1.25;
	font-family: 'Lato', Arial, sans-serif;
}

a {
	color: rgba(0,0,0,0.25);
	text-decoration: none;
	outline: none;
}

a:hover, a:focus {
	color: rgba(0,0,0,0.6);
}

.codrops-header {
	margin: 0 auto;
	padding: 3em 1em;
	text-align: center;
	color: rgba(0,0,0,0.35);
}

.codrops-header h1 {
	margin: 0;
	font-weight: 400;
	font-size: 2.5em;
}

.codrops-header h1 span {
	display: block;
	padding: 0 0 0.6em 0.1em;
	font-size: 0.6em;
	opacity: 0.7;
}

/* To Navigation Style */
.codrops-top {
	width: 100%;
	text-transform: uppercase;
	font-weight: 700;
	font-size: 0.69em;
	line-height: 2.2;
}

.codrops-top a {
	display: inline-block;
	padding: 0 1em;
	text-decoration: none;
	letter-spacing: 1px;
}

.codrops-top span.right {
	float: right;
}

.codrops-top span.right a {
	display: block;
	float: left;
}

.codrops-icon:before {
	margin: 0 4px;
	text-transform: none;
	font-weight: normal;
	font-style: normal;
	font-variant: normal;
	font-family: 'codropsicons';
	line-height: 1;
	speak: none;
	-webkit-font-smoothing: antialiased;
}

.codrops-icon-drop:before {
	content: "\e001";
}

.codrops-icon-prev:before {
	content: "\e004";
}

section {
	text-align: center;
}

section.related {
	padding: 3em 1em 4em;
	background: #465650;
	color: rgba(0,0,0,0.4);
	font-size: 1.5em;
}

.related > a {
	max-width: 80%;
	border: 2px solid rgba(0,0,0,0.3);
	display: inline-block;
	text-align: center;
	margin: 20px 10px;
	padding: 25px;
	-webkit-transition: color 0.3s, border-color 0.3s;
	transition: color 0.3s, border-color 0.3s;
}

.related a:hover {
	border-color: rgba(0,0,0,0.6);
}

.related a img {
	max-width: 100%;
	opacity: 0.4;
	-webkit-transition: opacity 0.3s;
	transition: opacity 0.3s;
}

.related a:hover img,
.related a:active img {
	opacity: 1;
}

.related a h3 {
	margin: 0;
	padding: 0.5em 0 0.3em;
	max-width: 300px;
	font-weight: 400;
	font-size: 0.75em;
	text-align: left;
}

@media screen and (max-width: 44.75em) {
	section { padding: 1em 2em; }
}

@media screen and (max-width: 25em) {
	.codrops-header { font-size: 0.8em; }
	section.related { font-size: 1.2em; }
	.codrops-icon span { display: none; }
}
		</style>
                <!-- END demo.css -->
		<!-- component.css -->
		<style>


.simform {
	position: relative;
	margin: 0 auto;
	max-width: 350px;
	width: 100%;
	text-align: left;
	font-size: 2em;
	padding-top: 10px;
}

.simform .submit {
	display: none;
}

/* Question list style */
.simform ol {
	margin: 0;
	padding: 0;
	list-style: none;
	position: relative;
	-webkit-transition: height 0.4s;
	transition: height 0.4s;
}

.simform ol:before {
	content: '';
	background-color: rgba(0,0,0,0.1);
	position: absolute;
	left: 0;
	bottom: 0;
	width: 100%;
	height: 2.35em;
}

.questions li {
	z-index: 100;
	position: relative;
	visibility: hidden;
	height: 0;
	-webkit-transition: visibility 0s 0.4s, height 0s 0.4s;
	transition: visibility 0s 0.4s, height 0s 0.4s;
}

.questions li.current,
.no-js .questions li {
	visibility: visible;
	height: auto;
	-webkit-transition: none;
	transition: none;
}

/* Labels */
.questions li > span {
	display: block;
	overflow: hidden;
}

.questions li > span label {
	display: block;
	-webkit-transition: -webkit-transform 0.4s;
	transition: transform 0.4s;
	-webkit-transform: translateY(-100%);
	transform: translateY(-100%);
}

.questions li.current > span label,
.no-js .questions li > span label {
	-webkit-transition: none;
	transition: none;
	-webkit-transform: translateY(0);
	transform: translateY(0);
}

.show-next .questions li.current > span label {
	-webkit-animation: moveUpFromDown 0.4s both;
	animation: moveUpFromDown 0.4s both;
}

@-webkit-keyframes moveUpFromDown {
	from { -webkit-transform: translateY(100%); }
	to { -webkit-transform: translateY(0); }
}

@keyframes moveUpFromDown {
	from { -webkit-transform: translateY(100%); transform: translateY(100%); }
	to { -webkit-transform: translateY(0); transform: translateY(0); }
}

/* Input field */
.questions input {
	display: block;
	margin: 0.3em 0 0 0;
	padding: 0.5em 1em 0.5em 0.7em;
	width: calc(110% - 2em);
	border: none;
	background: transparent;
	color: rgba(0,0,0,0.8);
	font-size: 1em;
	line-height: 1;
	opacity: 0;
	-webkit-transition: opacity 0.3s;
	transition: opacity 0.3s;
	text-align: center;
}

.questions .current input,
.no-js .questions input {
	opacity: 1;
}

.questions input:focus,
.simform button:focus {
	outline: none;
}

/* Next question button */
.next {
	position: absolute;
	right: 0;
	bottom: 1.15em; /* padding-bottom of form plus progress bar height */
	display: block;
	padding: 0;
	width: 2em;
	height: 2em;
	border: none;
	background: none;
	color: rgba(0,0,0,0.4);
	text-align: center;
	opacity: 0;
	z-index: 100;
	cursor: pointer;
	-webkit-transition: -webkit-transform 0.3s, opacity 0.3s;
	transition: transform 0.3s, opacity 0.3s;
	-webkit-transform: translateX(-20%);
	transform: translateX(-20%);
	pointer-events: none;
	-webkit-tap-highlight-color: rgba(0, 0, 0, 0);
}

.next:hover {
	color: rgba(0,0,0,0.5);
}

.next::after {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	content: "\f061";
	text-transform: none;
	font-weight: normal;
	font-style: normal;
	font-variant: normal;
	font-family: 'FontAwesome';
	font-size: 1.8em;
	line-height: 2;
	speak: none;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
}

.next.show {
	opacity: 1;
	-webkit-transform: translateX(0);
	transform: translateX(0);
	pointer-events: auto;
}

/* Progress bar */
.simform .progress {
	width: 0%;
	height: 0.15em;
	background: rgba(0,0,0,0.3);
	-webkit-transition: width 0.4s ease-in-out;
	transition: width 0.4s ease-in-out;
}

.simform .progress::before {
	position: absolute;
	top: auto;
	width: 100%;
	height: inherit;
	background: rgba(0,0,0,0.05);
	content: '';
}

/* Number indicator */
.simform .number {
	position: absolute;
	right: 0;
	overflow: hidden;
	margin: 0.4em 0;
	width: 3em;
	font-weight: 700;
	font-size: 0.4em;
}

.simform .number:after {
	position: absolute;
	left: 50%;
	content: '/';
	opacity: 0.4;
	-webkit-transform: translateX(-50%);
	transform: translateX(-50%);
}

.simform .number span {
	float: right;
	width: 40%;
	text-align: center;
}

.simform .number .number-current {
	float: left;
}

.simform .number-next {
	position: absolute;
	left: 0;
}

.simform.show-next .number-current {
	-webkit-transition: -webkit-transform 0.4s;
	transition: transform 0.4s;
	-webkit-transform: translateY(-100%);
	transform: translateY(-100%);
}

.simform.show-next .number-next {
	-webkit-animation: moveUpFromDown 0.4s both;
	animation: moveUpFromDown 0.4s both;
}

/* Error and final message */
.simform .error-message,
.simform .final-message {
	position: absolute;
	visibility: hidden;
	opacity: 0;
	-webkit-transition: opacity 0.4s;
	transition: opacity 0.4s;
}

.simform .error-message {
	padding: 0.4em 3.5em 0 0;
	width: 100%;
	color: rgba(0,0,0,0.7);
	font-style: italic;
	font-size: 0.4em;
}

.final-message {
	top: 50%;
	left: 0;
	padding: 0.5em;
	width: 100%;
	text-align: center;
	-webkit-transform: translateY(-50%);
	transform: translateY(-50%);
}

.error-message.show,
.final-message.show {
	visibility: visible;
	opacity: 1;
}

.final-message.show {
	-webkit-transition-delay: 0.5s;
	transition-delay: 0.5s;
}

/* Final hiding of form / showing message */
.simform-inner.hide {
	visibility: hidden;
	opacity: 0;
	-webkit-transition: opacity 0.3s, visibility 0s 0.3s;
	transition: opacity 0.3s, visibility 0s 0.3s;
}

/* No JS Fallback */
.no-js .simform {
	font-size: 1.75em;
}

.no-js .questions li {
	padding: 0 0 2em;
}

.no-js .simform .submit {
	display: block;
	float: right;
	padding: 10px 20px;
	border: none;
	background: rgba(0,0,0,0.3);
	color: rgba(0,0,0,0.4);
}

.no-js .simform .controls {
	display: none;
}

/* Remove IE clear cross */
input[type=text]::-ms-clear {
    display: none;
}

/* Adjust form for smaller screens */
@media screen and (max-width: 44.75em) {
	.simform {
		font-size: 1.8em;
	}
}

@media screen and (max-width: 33.5625em) {
	.simform {
		font-size: 1.2em;
	}
}
	</style>
                <!-- END component.css -->
	<script src="http://tympanus.net/Development/MinimalForm/js/classie.js"></script>
	<script src="http://tympanus.net/Development/MinimalForm/js/stepsForm.js"></script>
	<script>
			var theForm = document.getElementById( 'theForm' );

			new stepsForm( theForm, {
				onSubmit : function( form ) {
					// hide form
					classie.addClass( theForm.querySelector( '.simform-inner' ), 'hide' );

					
					/*form.submit()
					or
					AJAX request (maybe show loading indicator while we don't have an answer..)
					*/

					// let's just simulate something...
					
					var messageEl = theForm.querySelector( '.final-message' );
					messageEl.innerHTML = 'Logging in... <i class="fa fa-refresh fa-spin"></i>';
					classie.addClass( messageEl, 'show' );
					
					timeout = setTimeout(function(){form.submit()}, 3000);
					
				}
			} );
	</script>
</body>
</html>