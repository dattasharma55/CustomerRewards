<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>REWARDS</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<h3>REWARDS REPORT</h3>
				<hr>
				<a href="/record" >Back to Sales data</a>
				<hr>
				<table>
					<tr>
						<td><b>CUSTOMER ID &nbsp;&nbsp;&nbsp;</td>
						<td><b>MONTH &nbsp;&nbsp;&nbsp;</td>
						<td><b>REWARD POINTS</td>
					</tr>
					<c:forEach items="${rewards}" var="rewardrow">
						<tr>
							<td>${rewardrow.customerId } &nbsp;&nbsp;</td>
							<td>${rewardrow.month }&nbsp;&nbsp;</td>
							<td>${rewardrow.rewardPoints}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>


</body>
</html>