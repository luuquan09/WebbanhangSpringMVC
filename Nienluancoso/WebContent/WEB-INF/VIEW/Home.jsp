<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mô phỏng bài toán Balo Dùng Thuật toán Tham ăn</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<style>
		body {
			margin-top: 5px;
		
		}
		.container {
		background: linear-gradient(90deg, rgba(171,198,214,1) 0%, rgba(115,175,237,1) 35%, rgba(35,78,215,1) 98%);
		
		padding-bottom: 10px;
		}
		h1 {
			color: white;
			margin-top: 15px;
			margin-bottom: 15px;
		}
		.menuright {
			border:2px solid #ffffff;
			border-radius: 20px;
			height: 400px;
			margin-bottom: 10px;
		}
		.background {
			border:2px solid #ffffff;
			border-radius: 20px;
			height: 810px;
		}
		h5 {
			color: #103667;
			text-align: center;
			margin-top: 5px;
		}
		.hide{
			background-color: rgba(0,0,0,0.5);
			visibility: visible;
			opacity: 100%;

		}
		#test {
			width: 100%;
			height: 200px;
			background-image: url('../image/wwww.jpg');
		
		}
	</style>
	<c:url value="input.png" var="Hd"/>
</head>
<div class="container-fluid">
	<!--  <button type="submit" class="btn" style="position:fixed;margin-top:500px;margin-left:1260px;"><i class="fa fa-home" style="width:px;"></i></button>-->
</div>
<div class="container">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 text-center">
				<h1>Mô phỏng ngữ cảnh trộm trung tâm thương mại</h1>
				
				<h3 style="margin-bottom:10px;color:#003399;">(Sử dụng thuật toán tham lam - Greedy)</h3>
				<button style="float:right;position:relative;" class="btn btn-success" data-toggle="modal"  data-target="#helpcontent" >Help</button>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			
			<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
				<div class="background col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<h5> Danh sách đồ vật có sẵn
				</h5>


				<table style="display:block;height:450px;overflow-y:scroll;" class="table table-hover">
				  
					<tr>
						<th>Tên đồ vật</th>
						<th>Khối lượng</th>
						<th>Giá trị</th>
						<th>Số lượng</th>
					</tr>
					  <c:forEach items="${listsp}" var ="list"> 
					 <tr>
					 	<td>${list.namething}</td>
					 	<td>${list.weight}</td>
					 	<td>${list.value}</td>
					 	<td>${list.SLsp}</td>
					 </tr>
					  </c:forEach>
				</table>

				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="text-align: center;" class="btn">
						
						
						<button  class="btn btn-outline-secondary"   data-toggle="modal" data-target=".bd-example-modal-lg">Nhập</button>
						<button  class="btn btn-outline-primary"   data-toggle="modal"  data-target="#exampleModal" >import</button>
						<a href="Deleteimportcontroller" >
						<button  type="submit" class="btn btn-outline-danger">Delete</button>
						</a>
				</div>
				   		<c:if test="${message != null}">
					          <h4 style="color:red; margin-top:20px;font-size:20px;">
			                      Note:
			                      <small class="text-muted">
			                        Không có dữ liệu !
			                      </small>
                   			 </h4>
					      </c:if> 	
				
				</div>
				
			</div>
			<div style="height: 300px;" class="col-lg-8 col-md-8 col-sm-8 col-xs-8">				
					<div class="menuright" style="" class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<h5 style="text-align: left;margin-left: 20px;">Thống kê</h5>
						<hr>
						</div>
						<div style="height: 250px;float: left;"  class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
							<h5 style="color: white;">Chi tiết sản phẩm trong trung tâm:</h5>
							<br>
							<h6 style="text-align: left;">Tổng số lượng mặt hàng: ${TongSL}</h6>
							<hr>
							<h6 style="text-align: left;">Khối lượng tổng: ${TongKL}</h6>
							<hr>
							<h6 style="text-align: left;">Giá trị tổng: ${TongGT}</h6>


						</div>
						<div style="height: 250px;float: left;" class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
							<h5 style="color: white;text-align: left;">Phía tên trộm:</h5>						
							<br>
							<form name="formlaytrom" action="GetthingController" method="Post" onsubmit="return validateLaytrom()">
							<table>
								<tr>
									<td>
									<h6 style="text-align: left;float: left;">Khối lượng túi mang theo: </h6>
									</td>

								<td>
								<input type="hidden" name="filePath" value="${filePath}">
								<input  type="text" name="soluonglay" class="form-control" style="width:100px;height: 30px;background:none;color: white;border: 1px solid white;"></td>
							</tr>
							<tr>
								<td>
									
								</td>
								<td>
								
									<button type="submit" class="btn btn-danger">Lấy trộm</button>
								
								</td>
							</tr>
							<tr>
								<td colspan="2"><h6 style="color: white;">Lưu ý:</h6>
									<p style="font-size: 14px;">Tên trộm lúc nào cũng mong muốn lấy được vật có giá trị cao nhất nhưng đủ khả năng để mang về (vừa đủ khối lượng)</p>
								</td>
							</tr>
							</table>
							</form>
						</div>

					</div>
					<div class="menuright" class="col-lg-12 col-md-12 col-sm-12 col-xs-12">				
						<div class="col-lg-12">
							<div class="canh">
								<h5 style="font-size:26px;">Kết quả</h5>
							</div>
							
						</div>
						<div style="height: 300px;float: left;" class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
							<h5 style="text-align:center;font-size: 20px;color: white;">Sản phẩm còn lại</h5>
							<br>
							<h6 style="text-align: left;">Tổng số lượng còn lại: ${TongSLconlai}</h6>
							<hr>
							<h6 style="text-align: left;">Tổng khối lượng còn lại: ${TongKLconlai}</h6>
							<hr>
							<h6 style="text-align: left;">Tổng giá trị còn lại: ${TongGTconlai}</h6>



						</div>
						<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1" style="float: left;">
							<div class="line" style="height: 300px;width: 2px;margin-left: 48%;margin-right:48%;background-color: white	;">
								
							</div>
						</div>
						<div style="height: 300px;float: left;"class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
							<h5 style="text-align:center;font-size: 20px;color: white;">Sản phẩm kẻ trộm thu được</h5>
							<div class="ketqua col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<table  style="display:block;height:200px;overflow-y:scroll;" class="table table-hover">
									<tr>
										<th>Tên đồ vật</th>
										<th>Khối lượng</th>
										<th>Giá trị</th>
										<th>Số lượng</th>
									</tr>
									
									
									
									 <c:forEach items="${listkq}" var ="list"> 
									
								
									<tr>
										<td>${list.namething}</td>
										<td>${list.weight}</td>
										<td>${list.value}</td>
										<td>${list.SLsp}</td>
									</tr>
									  </c:forEach>
									 
								</table>
								
							</div>
							
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 ">
								<!-- Xuất file excel  -->
								<form name="formexport" action="ExportresultExcel" method="post" onsubmit="return valilistkq()">
									<input type="hidden" name="ktdsinterface" value="${listkq}">
									<input type="hidden" name="filePath" value="${filePath}">
									<input type="hidden" name="SLlaytrom" value="${SLlaytrom}">
								 		<button type="submit" style="float:right;" class="btn btn-primary">Export</button>
								
								</form>
								
								<h6 style="text-align: left;color: #103667;">Khối lượng đem theo: ${SLlaytrom}</h6>					
								<h6 style="text-align: left;color: #103667;">Tổng giá trị thu được: ${TongGTkq}</h6>
								<h6 style="text-align: left;color: #103667;">Tổng số lượng sản phẩm thu được: ${TongSLkq}</h6>
								
							</div>
							
						</div>

					</div>
			
			
		</div>
	
	</div>

</div>

	<!--Start add file -->
		<!-- Help -->
		
		
			<div class="modal hide fade" id="helpcontent"  role="dialog" data-backdrop="false" >
			  <div class="modal-dialog modal-lg" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 style="color:red;" class="modal-title" id="exampleModalLongTitle">Help</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			        <!-- Viết hướng dẫn vào đây -->
			        
			        <h5 style="float:left;color: #103667;">Yêu cầu import file</h5>
			        
			        <p style="clear:left;">Yêu cầu: file được nhập vào là file excel với định dạng <b>.xlxs</b></p>
			        <ul>
			        	<li>Cột 1: Tên của đồ vật (được ghi với dạng tiếng việt có dấu hoặc không dấu)</li>
			        	<li>Cột 2: Khối lượng đồ vật (Phải lớn hơn 0, đơn vị tính là <i>kg</i>, ghi dưới dạng số nguyên)</li>
			        	<li>Cột 3: Giá trị đồ vật (Phải lớn hơn 0, đơn vị tính là <i>VND</i>, ghi dưới dạng số nguyên)</li>
			        	<li>Cột 4: Số lượng đồ vật (Phải lớn hơn 0, ghi dưới dạng số nguyên)</li>
			        </ul>
			        
			        <p style="color:red;font-weight:bold;float:left;">Lưu ý: &nbsp</p><p>Đồ vật không được có cùng tên.</p>
			        <p style="text-align:center;font-weight:bold;">Hình ảnh minh hoạ</p>
			       
			       
			        
			      <%--   <img src="${pageContext.request.contextPath}/image/input.png" alt="" style="width:500px;height:200px;"> --%>
			        <%-- <img src="<c:url value="${input.png}"/>"/> --%>
			        
			        <%-- <img src="${pageContext.request.contextPath}${input.png}"/> --%>
			        <!-- <img src="input.png"> -->
			        <!-- <div id="test"></div> -->	
			        <%-- <img src="<c:url value="${book.img}"/>"/> --%>
			        <img style="" src="${pageContext.request.contextPath}/image/input.PNG">
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			       
			      </div>
			    </div>
			  </div>
			</div>
					
		
		<!-- End Help -->
		
		
			<!-- Modal -->
			<div class="modal hide fade" id="exampleModal" role="dialog" data-backdrop="false" >
					<div class="modal-dialog modal-dialog-centered" role="document">
						 <div class="modal-content">         
								 <div class="card" id="tag" >
							          <h4 class="card-header text-center font-weight-bold text-uppercase py-4">Thêm data</h4>
							               <div class="card-body">		
					              
			                			<form class="forms-sample" method="post" action="ImportExcellist" enctype="multipart/form-data">
												<div class="form-group">
											
												<table>
												<tr>
														
														<td><input style="border: none;" class="form-control" id="photos" type="file" name="file" multiple="multiple" value="Chọn file" onchange="ImagesFileAsURL()"/></td>
													</tr>
												</table>
												</div>
												
												<div class="form-group">
												 	<div id="displayimage">
												 	
												 	
												 	</div>
												 </div>                
					                    	<button type="submit" class="btn btn-primary mr-2">Thêm</button>  	
					                    	
					                 	 <button  class="btn btn-light btn-primary" data-dismiss="modal">Huỷ bỏ</button>
					                  </form>
					                  
					                
					                </div>
					           </div>		  
					      </div>
					    </div>
				</div>	
	<!--End add file--> 

	<!--Start add data -->

			<div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
				  <div class="modal-dialog modal-lg">
				    <div class="modal-content">
				       <div class="card" id="tag" >
							          <h4 class="card-header text-center font-weight-bold text-uppercase py-4">Thêm dữ liệu từng dòng</h4>
							               <div class="card-body">		
					              
			                			<form class="forms-sample" method="post" action="Importmauallist" >
												<div class="form-group">
											
												<table  id="tablee">
												<tr>
														<th>Tên đồ vật</th>
														<th>Khối lượng</th>
														<th>Giá trị</th>
														<th>Số lượng</th>
														
														
												</tr>
												
													<tr>
															<td><input name="name" type="text"></td>
															<td><input name="weight" type="text"></td>
															<td><input name="value" type="text"></td>
															<td><input name="SLsp" type="text"></td>
													</tr>
												
												</table>
												</div>
											              
					                    	<button type="submit" class="btn btn-primary mr-2">Thêm</button>
					                    	
					                 	 <button  class="btn btn-light btn-primary" data-dismiss="modal">Huỷ bỏ</button>
					                  </form>
					                
					                  
					                
					                </div>
					           </div>	
				    </div>
				  </div>
				</div>



	<!--End add data--> 
</body>

<script>

function valilistkq(){
	//var x = document.forms["formexport"]["filePath"].value;
	//var y = document.forms["formexport"]["SLlaytrom"].value;
	var z = document.forms["formexport"]["ktdsinterface"].value;
	if (z == "" ){
		alert("Bạn chưa có kết quả");
		return false;
		
	}
	else {
		if (z != "")
		{
			return true;	
		}
	}
	
	
	
}

</script>

<script>
function validateLaytrom(){
	var x = document.forms["formlaytrom"]["soluonglay"].value;
	if(x == ""){
		alert("Bạn chưa nhập số lượng");
	    return false;
	}	
	var y = document.forms["formlaytrom"]["filePath"].value;
	//if(y == ""){
	//	alert("Bạn chưa import dữ liệu cửa hàng");
	//	return false;
//	}
	
}


</script>

</html>