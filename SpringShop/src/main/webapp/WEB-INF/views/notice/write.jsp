<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<main>
<form name="noticeForm" method="post" action="/write" enctype="multipart/form-data">
  <div class="form-group">
    <label for="exampleInputEmail1">Title</label>
    <input type="text" class="form-control" name="ni_title" id="ni_title" aria-describedby="emailHelp" placeholder="Enter Title">
    <input type="text" class="form-control" name="ni_writer" id="ni_writer" aria-describedby="emailHelp" placeholder="Enter Name">
  </div>
  <br>
  <div class="form-group">
    <label for="exampleFormControlTextarea1">Example textarea</label>
    <textarea class="form-control" name="ni_content" id="ni_content" rows="3" placeholder="Type text here"></textarea>
    <input type="file" name="file">
  </div>
  <br>
  <input type="button" type="submit" value="Upload" class="btn btn-primary" onclick="check()">
  <button type="reset" class="btn btn-primary">Reset</button>
</form>

</main>

<script>
	
	function check(){
		
		var ni_title = $("#ni_title").val()
		var ni_writer = $("#ni_writer").val()
		var ni_content = $("#ni_content").val()
		
		if(ni_title==""||ni_writer==""||ni_content==""){
			alert("공백이면 안됩니다.");
			return;
		}
		
		document.noticeForm.submit()
		
		
		
		/* if(ni_title==""){
			alert("제목이 공백이면 안됩니다.");
			$("#ni_title").focus();
			return;
		}
		else if(ni_writer==""){
			alert("작성자가 공백이면 안됩니다.");
			$("#ni_writer").focus();
			return;
		}
		else if(ni_content==""){
			alert("내용이 공백이면 안됩니다.");
			$("#ni_content").focus();
			return;
		} */

	}

	

	

</script>