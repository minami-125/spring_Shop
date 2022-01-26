<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form method="post" action="/upload" enctype="multipart/form-data">
<main>
	<div>
		<table>
		<tr>
		<td>Title</td>
		<td><input type="text" class="form-control" name="ga_title" id="ga_title" placeholder="Enter Title"></td>
		</tr>
		<tr>
		<td>Name</td>
		<td><input type="text" class="form-control" name="ga_writer" id="ga_writer" placeholder="Enter Name"></td>
		</tr>
		<tr>
		<td>Content</td>
		<td><textarea class="form-control" rows="3" name="ga_content" id="ga_content" placeholder="Enter Content"></textarea></td>
		</tr>
		<tr>
		<td><button type="submit" class="btn btn-primary">Upload</button></td>
  		<td><button type="reset" class="btn btn-primary">Reset</button></td>
		</tr>
		<tr>
		<td> <input type="file" name="files" multiple></td>
		
		</tr>
		</table>
		
	</div>
</main>
</form>
<script>
	let msg = "${MSG}";
	if(msg != ""){
		alert(msg);
	}
</script>