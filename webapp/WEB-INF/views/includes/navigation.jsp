<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<ul>
		<c:choose>
			<c:when test="${param.menu == 'notify' }">
				<li class="selected"><a href="">공지사항</a></li>
				<li><a href="">사용자 리스트</a></li>
				<li><a href="">매장 리스트</a></li>
				<li><a href="">고객센터</a></li>
			</c:when>

			<c:when test="${param.menu == 'users' }">
				<li><a href="">공지사항</a></li>
				<li class="selected"><a href="">사용자 리스트</a></li>
				<li><a href="">매장 리스트</a></li>
				<li><a href="">고객센터</a></li>
			</c:when>

			<c:when test="${param.menu == 'shop' }">
				<li><a href="">공지사항</a></li>
				<li><a href="">사용자 리스트</a></li>
				<li class="selected"><a href="">매장 리스트</a></li>
				<li><a href="">고객센터</a></li>
			</c:when>

			<c:when test="${param.menu == 'help' }">
				<li><a href="">공지사항</a></li>
				<li><a href="">사용자 리스트</a></li>
				<li><a href="">매장 리스트</a></li>
				<li class="selected"><a href="">고객센터</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="">공지사항</a></li>
				<li><a href="">사용자 리스트</a></li>
				<li><a href="">매장 리스트</a></li>
				<li><a href="">고객센터</a></li>
			</c:otherwise>
		</c:choose>
	</ul>