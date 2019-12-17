<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>


<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>index</title>
		<link href="index.css" type="text/css" rel="stylesheet" />

	</head>
	<body>
		<!-- Header 영역 -->
		<tiles:insertAttribute name="header" />
		
		<div id="main">
			<!-- Main content 영역 -->
			<tiles:insertAttribute name="content" />
			
		</div>
		
		<!-- Footer 영역 -->
		<tiles:insertAttribute name="footer" />

		
	</body>
</html>
