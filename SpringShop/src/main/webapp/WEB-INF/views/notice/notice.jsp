<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<main>
  <table class="table">
	  <thead class="thead-dark">
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">Title</th>
	      <th scope="col">Date</th>
	      <th scope="col">Writer</th>
	    </tr>
	  </thead>
	  <tbody>

		<tr>
			<th scope="row">1</th>
			<td><a href="/read">제목</a></td>
			<td>22/01/07</td>
			<td>@mdo</td>
		</tr>	  			  		
		
	  </tbody>
	</table>
	<a class="btn btn-primary" href="upload">Write</a>
</main>
<script>
	let msg ="${MSG}";
	if(msg != ""){
		alert(msg)
	}
</script>

