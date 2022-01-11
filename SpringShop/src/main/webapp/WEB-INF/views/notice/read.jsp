<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form method="post" action="/edit">
<main>
  <div class="form-group">
    Title: <input class="form-control" name="ni_title" id="ni_title" aria-describedby="emailHelp" value="${selectOne.ni_title }">
   	Writer: <p type="text" class="form-control" name="ni_writer" id="ni_writer" aria-describedby="emailHelp">${selectOne.ni_writer }</p>
    Date: <p type="text" class="form-control" name="ni_instate" id="ni_instate" aria-describedby="emailHelp">${selectOne.ni_instate }</p>
  </div>
  <div class="form-group">
    Content:<input class="form-control" name="ni_content" id="ni_content" rows="3" value="${selectOne.ni_content }">
  </div>
  <br>
  <a class="btn btn-primary" href="/notice">Notice</a>
  <button class="btn btn-primary" type="submit" name="ni_no" value="${selectOne.ni_no }">Edit</button>
  <a class="btn btn-primary" href="/delete?ni_no=${selectOne.ni_no }">Delete</a>
</main>
</form>

<script>
	let msg = "${MSG}";
	if(msg != ""){
		alert(msg);
	}
</script>