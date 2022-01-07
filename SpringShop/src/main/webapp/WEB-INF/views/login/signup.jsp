<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main>
	<div class="container-fluid">
		<div class="container">
			<h2 class="text-center" id="title">Facundo farm and Resort</h2>
 			<hr>
			<div class="row">
				<div class="col-md-5">
				<c:choose>
					<c:when test="${loginMember == null }">
						<form role="form" method="post" action="/home">
							<fieldset>							
								<p class="text-uppercase pull-center">SIGN UP</p>	
	 							<div class="form-group">
									<input type="text" name="mi_id" id="username" class="form-control input-lg" placeholder="Username">
								</div>
								<div class="form-group">
									<input type="password" name="mi_pw" id="password" class="form-control input-lg" placeholder="Password" >
								</div>
								<div class="form-group">
									<input type="text" name="mi_name" id="name" class="form-control input-lg" placeholder="Name">
								</div>
								<div class="form-group">
									<input type="email" name="mi_email" id="email" class="form-control input-lg" placeholder="Email" >
								</div>
								<div class="form-group">
									<input type="text" name="mi_mobile" id="mobile" class="form-control input-lg" placeholder="Mobile phone">
								</div>
								<div class="form-group">
									<input type="text" name="mi_birthday" id="birthday" class="form-control input-lg" placeholder="Birthday">
								</div>
								<div class="form-group">
									<input type="text" name="mi_tell" id="tell" class="form-control input-lg" placeholder="Tell">
								</div>
								<div class="form-group">
									<input type="text" name="mi_addr" id="address" class="form-control input-lg" placeholder="Address">
								</div>
								<p></p>
	 							<div>
	 								<input type="submit" class="btn btn-lg btn-primary value="Register">
	 							</div>
							</fieldset>
						</form>
					</c:when>
					<c:otherwise>
						<form role="form" method="post" action="/update">
							<fieldset>							
								<p class="text-uppercase pull-center">SIGN UP</p>	
	 							<div class="form-group">
									<input type="text" name="mi_id" id="username" class="form-control input-lg" placeholder="Username" readonly="readonly" value="${loginMember.mi_id }">
								</div>
								<div class="form-group">
									<input type="password" name="mi_pw" id="password" class="form-control input-lg" placeholder="Password" value="${loginMember.mi_pw }">
								</div>
								<div class="form-group">
									<input type="text" name="mi_name" id="name" class="form-control input-lg" placeholder="Name" value="${loginMember.mi_name }">
								</div>
								<div class="form-group">
									<input type="email" name="mi_email" id="email" class="form-control input-lg" placeholder="Email" value="${loginMember.mi_email }">
								</div>
								<div class="form-group">
									<input type="text" name="mi_mobile" id="mobile" class="form-control input-lg" placeholder="Mobile phone" value="${loginMember.mi_mobile }">
								</div>
								<div class="form-group">
									<input type="text" name="mi_birthday" id="birthday" class="form-control input-lg" placeholder="Birthday" value="${loginMember.mi_birthday }">
								</div>
								<div class="form-group">
									<input type="text" name="mi_tell" id="tell" class="form-control input-lg" placeholder="Tell" value="${loginMember.mi_tell }">
								</div>
								<div class="form-group">
									<input type="text" name="mi_addr" id="address" class="form-control input-lg" placeholder="Address" value="${loginMember.mi_addr }">
								</div>
								<p></p>
	 							<div>
	 								<input type="submit" class="btn btn-lg btn-primary value="Register"> 
	 								<a class="btn btn-lg btn-primary" href="/drop?mi_id=${loginMember.mi_id }">탈퇴</a> <!-- LoginController.java로 id값 전송 -->
	 							</div>
	 							
							</fieldset>
						</form>
					</c:otherwise>				
				</c:choose>
				</div>
			</div>
		</div>
	</div>
</main>

<script>
	let msg = "${MSG}";
	if(msg != ""){
		alert(msg);
	}
</script>