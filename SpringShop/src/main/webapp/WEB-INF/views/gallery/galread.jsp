<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form method = "post" action="/edit">
<main>
	<div>
		<table>
		<tr>
		<td>Title</td>
		<td><input class="form-control" name="ga_title" id="ga_title" value="${galEdit.ga_title }"></td>
		</tr>
		<tr>
		<td>Name</td>
		<td><p name="ga_writer" id="ga_writer">${galEdit.ga_writer }</p></td>
		<td>Date</td>
		<td><p name="ga_instate" id="ga_instate">${galEdit.ga_instate }</p></td>
		</tr>
		<tr>
		<td>Content</td>
		<tr>
		<td><input class="form-control" name="ga_content" id="ga_content" value="${galEdit.ga_content }"></td>
		<c:forEach var="" items="">
		<td>
		<img src="resources/file/${galEdit.saved_file_name }" alt="error" width="100px" height="100px"></td>
		
		</c:forEach>

		</tr>
		<tr>
		<td><button type="submit" class="btn btn-primary" name="ga_no" value="${galEdit.ga_no }">Edit</button></td>
  		<td></td>
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