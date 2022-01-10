<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form method="get" action="/read">
<main>
  <div class="form-group">
    Title: <p class="form-control" name="ni_title" id="ni_title" aria-describedby="emailHelp">${selectOne.ni_title }</p>
   	Writer: <input type="text" class="form-control" name="ni_writer" value="${selectOne.ni_writer }" id="ni_writer" aria-describedby="emailHelp">
    Date: <input type="text" class="form-control" name="ni_instate" value="${selectOne.ni_instate }" id="ni_instate" aria-describedby="emailHelp">
  </div>
  <div class="form-group">
    Content:<input class="form-control" name="ni_content" id="ni_content" rows="3" value="${selectOne.ni_content }">
  </div>
  <br>
  <a class="btn btn-primary" href="/notice">Notice</a>
  <a class="btn btn-primary" href="/edit">Edit</a>
  <a class="btn btn-primary" href="/delete">Delete</a>
</main>
</form>

<script>
	let msg = "${MSG}";
	if(msg != ""){
		alert(msg);
	}
</script>