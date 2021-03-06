<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.virtusa.project.services.admin.AdminServices,com.virtusa.project.ui.service.UiServices" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8" />
	<title>Table Style</title>
	<link rel="stylesheet" href="../css/tablecss.css"> 
	<meta name="viewport" content="initial-scale=1.0; maximum-scale=1.0; width=device-width;">
	<style>
		.sortingTable{
			margin-top: 120px;
		}
		.sortingTable th a{
			color: #fff;
		}
	</style>
</head>

<body>
<jsp:include page="/isValidMember" />
<jsp:include page="member_header.html"></jsp:include>
<h1>.</h1>
<table class="sortingTable">
<th> <a href="view_book_by_id.jsp">Sort By Id</a><br/></th>
<th> <a href="view_book_by_name.jsp">Sort By Name</a><br/></th>
<th> <a href="view_book_by_author.jsp">Sort By Author</a><br/></th>
<th> <a href="view_book_by_rating.jsp">Sort By Rating</a><br/></th>
<th> <a href="member_home_page.jsp">Home</a><br/></th>
</table>
<%-- <div class="table-title">
<h3>Data Table</h3>
</div>
<table class="table-fill">
<thead>
<tr>
<th class="text-left">BookID</th>
<th class="text-left">Name</th>
<th class="text-left">Edition</th>
<th class="text-left">Rating</th>
<th class="text-left">IssuedBy</th>
</tr>
</thead>
 <tbody class="table-hover">
<%
	UiServices uiServices = new UiServices();
	out.print(uiServices.displayBookDetails());
%>
</tbody> 
</table> --%>
 <jsp:include page="footer.html"></jsp:include>
</body>
</html>