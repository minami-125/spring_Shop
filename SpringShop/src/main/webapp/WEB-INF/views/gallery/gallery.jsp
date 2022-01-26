<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form>
<main>
	<!-- Gallery -->
	<table>	
	<tbody class="galleryList"></tbody>
	</table>
	<div id="pageNav"></div>
	<a class="w-49 btn btn-lg btn-primary" href="/gawrite">글쓰기</a>
	<div class="row">
	  <div class="col-lg-4 col-md-12 mb-4 mb-lg-0">
	    <img
	      src="https://mdbcdn.b-cdn.net/img/Photos/Horizontal/Nature/4-col/img%20(73).webp"
	      class="w-100 shadow-1-strong rounded mb-4"
	      alt="Boat on Calm Water"
	    />
	
	    <img
	      src="https://mdbcdn.b-cdn.net/img/Photos/Vertical/mountain1.webp"
	      class="w-100 shadow-1-strong rounded mb-4"
	      alt="Wintry Mountain Landscape"
	    />
	  </div>
	
	  <div class="col-lg-4 mb-4 mb-lg-0">
	    <img
	      src="https://mdbcdn.b-cdn.net/img/Photos/Vertical/mountain2.webp"
	      class="w-100 shadow-1-strong rounded mb-4"
	      alt="Mountains in the Clouds"
	    />
	
	    <img
	      src="https://mdbcdn.b-cdn.net/img/Photos/Horizontal/Nature/4-col/img%20(73).webp"
	      class="w-100 shadow-1-strong rounded mb-4"
	      alt="Boat on Calm Water"
	    />
	  </div>
	
	  <div class="col-lg-4 mb-4 mb-lg-0">
	    <img
	      src="https://mdbcdn.b-cdn.net/img/Photos/Horizontal/Nature/4-col/img%20(18).webp"
	      class="w-100 shadow-1-strong rounded mb-4"
	      alt="Waves at Sea"
	    />
	
	    <img
	      src="https://mdbcdn.b-cdn.net/img/Photos/Vertical/mountain3.webp"
	      class="w-100 shadow-1-strong rounded mb-4"
	      alt="Yosemite National Park"
	    />
	  </div>
	</div>
	
	<!-- Gallery -->
</main>
</form>
<!-- 멀티파일 업로드: 이미지 3개까지 / 사진 누르면 게시글로 넘어가게 / 3개중 0번째 이미지-->
<script>
	var data = {};
	
	$(document).ready(function(){
		showList(1);
	});
	
	function showList(pageNum){
		data.pageCnt = 6;
		data.curPage = pageNum;
		$.ajax({
			type : 'POST',
		    url : "/getGalleryList",
		    data : data,
		    error : function(error) {
		        alert("Error!");
		    },
		    success: function(value){
		    	$(".galleryList").children().remove();
		    	let list = "";
		    	let html = "";
		    	for(var i=0; i<value.list.length; i++){
		    		list = value.list[i];
		    		html += "<tr><td>"+list.ga_no+"</td>";
		    		html += "<td><a href='/galread?ga_no="+list.ga_no+"'>"+list.ga_title+"</a></td></tr>";
		    		html += "<tr><td>"+list.ga_writer+"</td>";
		    		html += "<td>"+list.ga_instate+"</td></tr>";
		    	}
		    	$(".galleryList").append(html);
		    	$("#pageNav").paging({
		    		pageSize: data.pageCnt,
		    		PAGE_PER_CNT: data.pageCnt,
		    		currentPage: value.paging.CUR_PAGE,
		    		pageTotal: value.paging.TOTAL_CNT
		    	});
		    }
		});
	}
	function goPage(pageNum){
		showList(pageNum)
	}

</script>
