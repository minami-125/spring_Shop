<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form method="post" action="/edit" enctype= "multipart/form-data">
<main>
  <div class="form-group">
    Title: <input class="form-control" name="ni_title" id="ni_title" aria-describedby="emailHelp" value="${selectOne.ni_title }">
   	Writer: <p type="text" class="form-control" name="ni_writer" id="ni_writer" aria-describedby="emailHelp">${selectOne.ni_writer }</p>
    Date: <p type="text" class="form-control" name="ni_instate" id="ni_instate" aria-describedby="emailHelp">${selectOne.ni_instate }</p>
  </div>
  <div class="form-group">
    Content:<br>  
  	<table>
  	<tr>
  		<td id="right">
		    <input class="form-control" name="ni_content" id="ni_content" value="${selectOne.ni_content }">
    	</td>
  		<td>
    <!-- 파일 출력 -->
		    <img src="resources/file/${selectOne.saved_file_name }" alt="error">
		    <p>파일명: ${selectOne.file_name }</p>  		
  		</td>
  	</tr>
  	</table>
  	<br>
    <input type="file" name="file">
  </div>
  <br>
  <a class="btn btn-primary" href="/notice">Notice</a>
  <button class="btn btn-primary" type="submit" name="ni_no" value="${selectOne.ni_no }">Edit</button>
   <input type="button" class="btn btn-primary" onclick="fileDel(${selectOne.ni_no })" value="Delete">
</main>
</form>

<script>
	let msg = "${MSG}";
	if(msg != ""){
		alert(msg);
	}
	
	//삭제
	function fileDel(no){
		var data = {};
		data.saved_file_name = "${selectOne.saved_file_name}";
		data.file_name = "${selectOne.file_name}";
		data.ni_no = no;
		$.ajax({
		    type : 'POST',
		    url : "/delete",
		    data : data,
		    error : function(error) {
		        alert("Error!");
		    },
		    success : function(value) {
		    	if(value > 0){
			    	alert("삭제성공");
			        location.href="/notice";
		    	}else{
		    		alert("삭제실패");
		    	}
		    }
		});
	}
	
</script>
<style>
	table {width:100%;}
	td {width: 50%;}
	#right {border-right: 1px solid black; }
</style>