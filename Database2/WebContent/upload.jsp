<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>File Upload</title>
</head>
 
<body background="images/light.jpg" >
<img alt="header" src="images/logo.gif" id="header" width=100%  /> 
    <h1>File Upload Form</h1>
    <hr/>
 
    <fieldset>
        <legend>Upload File</legend>
        <form action="Upload" method="post" enctype="multipart/form-data" >
            <label for="filename_1">File: </label>
            <input id="filename_1" type="file" name="filename_1" size="50"/><br/>
            <br/>
            <input type="submit" value="Upload File"/>
        </form>
    </fieldset>
    <br>
    <div style="text-align: left">
		<a href="/Database/navigation.html">Back</a>
		<a href="/Database/index.html">Logout</a>
	</div>
</body>
</html>


