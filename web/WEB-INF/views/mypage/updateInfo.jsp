<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image/x-icon" href="${ pageContext.servletContext.contextPath }/assets/img/favicon.png">
<title>Wonderful Welfare Workspace</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>

<body>
    <div class="main-wrapper">
		<jsp:include page="../common/navbar.jsp"/>
		
		<div class="page-wrapper">
			<div class="content container-fluid">
                <div class="row">
                    <div class="col-xs-6" >
                        <h4 class="page-title">My Profile</h4>
                    </div>
                    <form class="col-xs-6 text-right m-b-30">
                    </form>
                </div>
            
	            <form>
	                <div class="row">
	                	<div class="col-md-2">
	                		<div class="author-img-wrap" align="center">
	                			<img class="img-responsive img-circle" src="${ pageContext.servletContext.contextPath }/assets/img/user.jpg" alt="">
	                        </div>
	                        <br>
	                        <div align="center">
	                        	<button type="button" class="btn btn-primary">사진 변경</button>
	                        </div>
	                	</div>
	                	
	                	<div class="col-md-5">
	                        <div class="card-box">
	                    		<div class="profile-view">
	                    			<div class="form-horizontal">
	                    				<div class="form-group" style="back">
		                                    <label class="control-label col-lg-3">ID</label>
		                                    <div class="col-md-9">
		                                        <input type="text" class="form-control" value="${ memberInfo.memberId }" readonly>
		                                    </div>
		                                </div>
		                                <div class="form-group">
		                                    <label class="control-label col-lg-3">사번</label>
		                                    <div class="col-md-9">
		                                        <input type="text" class="form-control" value="${ memberInfo.memberNo }" readonly>
		                                    </div>
		                                </div>
		                                <div class="form-group">
		                                    <label class="control-label col-lg-3">이름</label>
		                                    <div class="col-md-9">
		                                        <input type="text" class="form-control" value="${ memberInfo.name }" readonly>
		                                    </div>
		                                </div>
		                                <div class="form-group">
		                                    <label class="control-label col-lg-3">부서</label>
		                                    <div class="col-md-9">
		                                        <input type="text" class="form-control" value="${ memberInfo.department.deptName }" readonly>
		                                    </div>
		                                </div>
		                                <div class="form-group">
		                                    <label class="control-label col-lg-3">직급</label>
		                                    <div class="col-md-9">
		                                        <input type="text" class="form-control" value="${ memberInfo.job.jobName }" readonly>
		                                    </div>
		                                </div>
		                                <div class="form-group">
		                                    <label class="control-label col-lg-3">E-mail</label>
		                                    <div class="col-md-9">
		                                        <input type="email" class="form-control" value="${ memberInfo.email }" readonly>
		                                    </div>
		                                </div>
		                                <div class="form-group">
		                                    <label class="control-label col-lg-3">사내전화</label>
		                                    <div class="col-md-9">
		                                        <input type="text" class="form-control" value="${ memberInfo.department.deptCallNumber }" readonly>
		                                    </div>
		                                </div>
		                                <div class="form-group">
		                                    <label class="control-label col-lg-3">입사일</label>
		                                    <div class="col-md-9">
		                                        <input type="date" class="form-control" value="${ memberInfo.enrollDate }" readonly>
		                                    </div>
		                                </div>
		                                <div class="form-group">
		                                    <label class="control-label col-lg-3">재직 상태</label>
		                                    <div class="col-md-9">
		                                        <input type="text" class="form-control" value="재직" readonly>
		                                    </div>
		                                </div>
		                                <div class="form-group">
		                                    <label class="control-label col-lg-3">권한</label>
		                                    <div class="col-md-9">
		                                        <input type="text" class="form-control" value="${ memberInfo.role.roleName }" readonly>
		                                    </div>
		                                </div>
			                        </div>
			                    </div>
	                        </div>
	                    </div>
	                    
	                    <div class="col-md-5">
	                        <div class="card-box">
	                    		<div class="profile-view">
	                    			<div class="form-horizontal">
	                    				<div class="form-group">
		                                    <label class="control-label col-lg-3">성별</label>
		                                    <div class="col-md-9">
		                                    	<label class="radio-inline">
		                                			<input type="radio" name="gender" value="M" <c:if test="${ memberInfo.gender == '남'}">checked</c:if>>남
		                            			</label>
		                            			<label class="radio-inline">
		                                			<input type="radio" name="gender" value="F"<c:if test="${ memberInfo.gender == '여'}">checked</c:if>>여
		                            			</label>
		                                    </div>
		                                </div>
	                                    <div class="form-group">
	                                    	<label class="control-label col-lg-3">생년월일</label>
	                                    	<div class="col-md-9">
	                                            <div class="cal-icon">
	                                               	<input type="text" class="form-control floating datetimepicker" value="${ memberInfo.birthday }">
	                                            </div>
	                                        </div>
	                                	</div>
	                                	<div class="form-group">
		                                    <label class="control-label col-lg-3">휴대전화</label>
		                                    <div class="col-md-9">
		                                        <input type="tel" class="form-control" value="${ memberInfo.phone }">
		                                    </div>
		                                </div>
		                                <div class="form-group">
		                                    <label class="control-label col-lg-3">자택주소</label>
		                                    <div class="col-md-9">
		                                    	<div class="input-group">
		                                    		<span><input type="text" class="form-control" name="zipCode" id="zipCode" value="${ memberInfo.address }" readonly></span>
	                                            	<span class="input-group-btn">
														<button type="button" class="btn btn-primary" id="searchZipCode">검색</button>
													</span>
												</div>
											</div>												
		                                </div>
		                                <div class="form-group">
		                                    <label class="control-label col-lg-3"></label>
		                                    <div class="col-md-9">
		                                        <input type="text" class="form-control" name="address1" id="address1" value="" readonly>
		                                    </div>
		                                </div>
		                                <div class="form-group">
		                                    <label class="control-label col-lg-3"></label>
		                                    <div class="col-md-9">
		                                        <input type="text" class="form-control" name="address2" id="address2" value="">
		                                    </div>
		                                </div>
			                        </div>
			                    </div>
	                        </div>
	                    </div>
	                </div>
	                
	                <div align="center">
	                	<button type="submit" class="btn btn-success">프로필 수정</button>
	                	<button type="reset" class="btn btn-default">돌아가기</button>
	                </div>
	            </form>
            </div>
        </div>
    </div>
    
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script>
    	const $searchZipCode = document.getElementById("searchZipCode");
    	
    	$searchZipCode.onclick = function() {
			// 우편번호 검색 창을 오픈하면서 동시에 사용자가 선택한 주소 정보(data 객체)를 전달
    		new daum.Postcode({
    			oncomplete: function(data){
					// 팝업창에서 검색결과 항목을 선택했을 떄 실행할 코드
    				document.getElementById("zipCode").value = data.zonecode;
    				document.getElementById("address1").value = data.address;
    				document.getElementById("address2").focus();
    			}
    		}).open();
    	}
    </script>
</body>

</html>