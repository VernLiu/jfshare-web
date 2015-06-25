<%@page import="com.jfshare.common.Env"%>
<%@page import="com.jfshare.common.Config"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String ctx = request.getContextPath();
	String jsPath = Env.JS_PATH;
	String jsVersion = Env.JS_VERSION;
	String cssPath = Env.CSS_PATH;
	String cssVersion = Env.CSS_VERSION;
	String systemVersion = Env.SYSTEM_VERSION;
%>