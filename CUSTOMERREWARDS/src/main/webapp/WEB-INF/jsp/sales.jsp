<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SALES</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<br>

				<h3>SALES data</h3>
				<hr>
				<a href="/record" >Create more records</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="/report" >View Customer Rewards Report</a>
				<hr>
				<table>
					<tr>
						<td><b>CUSTOMER ID&nbsp;&nbsp;&nbsp;</td>
						<td><b>SALES DATE&nbsp;&nbsp;&nbsp;</td>
						<td><b>SALES AMOUNT</td>
					</tr>
					<c:forEach items="${sales}" var="sale">
						<tr>
							<td>${sale.customerId}&nbsp;&nbsp;&nbsp;</td>
							<td>${sale.salesDate}&nbsp;&nbsp;&nbsp;</td>
							<td>${sale.salesAmount}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>


</body>
</html>