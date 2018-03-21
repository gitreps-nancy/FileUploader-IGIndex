<html>
<head>
<title>File Uploader</title>
</head>
<body>
	<form method="POST" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data">
		<table>
			<tr>
				<td>File to upload:</td>
				<td><input type="file" name="file" /></td>
			</tr>
			<tr>
				<td>URL:</td>
				<td><input type="text" name="txtUrl" /></td>
			</tr>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="txtUsername" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="text" name="txtPassword" /></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="file" /></td>
			</tr>
			<tr>
				<td>Type:</td>
				<td><input type="radio" name="type" value="topic">Topic
					<input type="radio" name="type" value="queue">Queue
				</td>
			</tr>
		</table>
		<br />
		<input type="submit" value="Submit" />
	</form>
</body>
</html>