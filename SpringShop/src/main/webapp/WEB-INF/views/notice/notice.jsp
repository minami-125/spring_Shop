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
	  <tbody class="noticeList">
<!-- 	
	<c:forEach var="allNotice" items="${allNotice }">
		<tr>
			<th scope="row">${allNotice.ni_no}</th>
			<td><a href="/read">${allNotice.ni_title }</a></td>
			<td>${allNotice.ni_instate }</td>
			<td>${allNotice.ni_writer }</td>
		</tr>	  			  		
	</c:forEach> -->
		
	  </tbody>
	</table>
	<div id="pageNav"></div>
	<a class="btn btn-primary" href="/upload">Write</a>
</main>
<script>
	var data = {}; //객체
	
	let msg ="${MSG}";
	if(msg != ""){
		alert(msg)
	}
	
	$(document).ready(function(){
		getList(1);
	});
	
	function getList(selPage){		
		// http header type (method) : GET POST PUT FETCH DELETE
		// QueryString(파라미터) = 객체(Object)
		// error , success , complete : 콜백함수 
		// error : 서버에서 http status code error 2xx 제외 나머지
		// success : 2xx 
		// complete : error 건 success 상관없이 무조건 실행되는 함수
		data.pagePerCnt = 5;
		data.curPage = selPage;
		$.ajax({
		    type : 'POST',
		    url : "/getNoticeList",
		    data : data,
		    error : function(error) {
		        alert("Error!");
		    },
		    success : function(value) {
		    	console.log(value);
		    	$(".noticeList").children().remove(); //기존 리스트 지우고 다음 리스트 출력
		    	let list = "";
		    	let html = "";
		    	for (var i = 0; i < value.list.length; i++) {
					list = value.list[i];
					html += "<tr><th scope='row'>"+list.ni_no+"</th>";
					html += "<td><a href='/read?ni_no="+list.ni_no+"'>"+list.ni_title+"</a></td>";
					html += "<td>"+list.ni_instate+"</td>";
					html += "<td>"+list.ni_writer+"</td></tr>";
				}
		    	$(".noticeList").append(html);
		    	$("#pageNav").paging({ 
					pageSize : data.pagePerCnt,  
					PAGE_PER_CNT:  data.pagePerCnt, 
					currentPage: value.paging.CUR_PAGE,
					pageTotal: value.paging.TOTAL_CNT  
				});
		    }
		});
	}
	function goPage(selPage){
		getList(selPage)
	}
	
</script>

