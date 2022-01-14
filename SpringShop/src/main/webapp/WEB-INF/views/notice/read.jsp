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
    <!-- 파일 출력 -->
    <img src="resources/file/${selectOne.saved_file_name }" alt="error">
    <input class="form-control" name="ni_content" id="ni_content" rows="3" value="${selectOne.ni_content }">
    <input type="file" name="file">
  </div>
  <br>
  <a class="btn btn-primary" href="/notice">Notice</a>
  <button class="btn btn-primary" type="submit" name="ni_no" value="${selectOne.ni_no }">Edit</button>
  <input type="button" class="btn btn-primary" onclick="fDel(${selectOne.ni_no })" value="Delete">
</main>
</form>

<script>
	let msg = "${MSG}";
	if(msg != ""){
		alert(msg);
	}
	
	//삭제
	function fDel(ni_no){
		
		const sendingData = new FormData();
		for (let key of sendingData.keys()) {
			  console.log(key);
			}

		// FormData의 value 확인
		for (let value of sendingData.values()) {
		  console.log(value);
		}
		
		$.ajax({
		    type : 'POST',
		    url : "/delete",
		    data : sendingData,
		    processData : false,
		    contetnType : false,
		    error : function(error) {
		        alert("Error!")
		    },
		    success : function(data) {
		        alert("삭제 성공!")
		    }
		})
		
		
	}
	
</script>