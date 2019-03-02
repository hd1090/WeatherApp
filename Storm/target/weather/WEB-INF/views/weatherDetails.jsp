<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="//cdn.muicss.com/mui-0.9.41/css/mui.min.css"
	rel="stylesheet" type="text/css" />
<script src="//cdn.muicss.com/mui-0.9.41/js/mui.min.js"></script>
<script src="../js/harsj.js"></script>
<script>
	function yourFunction() {
		var action_src = ""
				+ document.getElementsByName("city")[0].value;
		var your_form = document.getElementById('your_form');
		your_form.action = action_src;
	}
</script>
</head>
<p><%=request.getAttribute("data") %></p>
	<form class="mui-form--inline" action="../rest/v1/weather/" method="GET">
		<div class="mui-textfield">
			<input type="text" name="city">
		</div>
		<button class="mui-btn">get weather()</button>
	</form>
</body>
</html>