<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form method="get" action="/read">
<main>
  <div class="form-group">
    <p class="form-control" name="ni_title" id="ni_title" aria-describedby="emailHelp">${details.ni_title }</p>
    <input type="text" class="form-control" name="ni_writer" value="${printNoticee.ni_title }" id="ni_writer" aria-describedby="emailHelp" placeholder="Enter name">
 	<td>${printNoticee.ni_title }</td>
  </div>
  <br>
  <div class="form-group">
    <label for="exampleFormControlTextarea1">Example</label>
    <textarea class="form-control" name="ni_content" id="ni_content" rows="3" placeholder="Type text here"></textarea>
  </div>
  <br>
  <input type="button" type="submit" value="Upload" class="btn btn-primary" onclick="check()">
  <button type="reset" class="btn btn-primary">Reset</button>
</main>
</form>

<script>


</script>