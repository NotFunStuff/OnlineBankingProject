<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Online Banking Web - made by team 14C36</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="apple-touch-icon" href="https://i.imgur.com/QRAUqs9.png">
<!-- <link rel="shortcut icon" href="https://i.imgur.com/QRAUqs9.png"> -->

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/normalize.css@8.0.0/normalize.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/pixeden-stroke-7-icon@1.2.3/pe-icon-7-stroke/dist/pe-icon-7-stroke.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.2.0/css/flag-icon.min.css">
<link rel="stylesheet" href="assets/css/cs-skin-elastic.css">
<link rel="stylesheet"
	href="assets/css/lib/datatable/dataTables.bootstrap.min.css">
<link rel="stylesheet" href="assets/css/style.css">

<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800'
	rel='stylesheet' type='text/css'>

<!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->
</head>
<body>
	<jsp:include page="menu_bar_admin.jsp"></jsp:include>

	<!-- Right Panel -->

	<div id="right-panel" class="right-panel">
		<jsp:include page="header.jsp"></jsp:include>
		<div class="content">
			<div class="animated fadeIn">
				<div class="row">
					<div class="col-md-12">
						<div class="card">
							<div class="card-header">
								<strong>Create Investment Form</strong>
							</div>
							<div class="card-body card-block">
								<form action="/class_edit_{classId}" id="myForm1" method="POST"
									class="form-horizontal">
									<div class="row form-group">
										<div class="col col-md-3">
											<label class="form-control-label">Username</label>
										</div>
										<div class="col-12 col-md-9">
											<p class="form-control-static">usermame</p>
										</div>
									</div>
									<div class="row form-group">
										<div class="col col-md-3">
											<label class=" form-control-label">Invest Type</label>
										</div>
										<div class="col col-md-9">
											<div class="form-check">
												<div class="radio">
													<label for="radio1" class="form-check-label "> <input
														type="radio" id="radio1" name="radios" value="save"
														class="form-check-input">Save
													</label>
												</div>
												<div class="radio">
													<label for="radio2" class="form-check-label "> <input
														type="radio" id="radio2" name="radios" value="loan"
														class="form-check-input">Loan
													</label>
												</div>
											</div>
										</div>
									</div>
									<div class="row form-group">
										<div class="col col-md-3">
											<label for="select" class=" form-control-label">Interest</label>
										</div>
										<div class="col-12 col-md-9">
											<select name="select" id="select" class="form-control">
												<option value="0.5">0.5%</option>
												<option value="1">1%</option>
												<option value="2">2%</option>
												<option value="4">4%</option>
												<option value="8">8%</option>
											</select>
										</div>
									</div>
									<div class="row form-group">
										<div class="col col-md-3">
											<label for="select" class=" form-control-label">Term</label>
										</div>
										<div class="col-12 col-md-9">
											<select name="select" id="select" class="form-control">
												<option value="1">1 month</option>
												<option value="3">3 months</option>
												<option value="6">6 months</option>
												<option value="12">12 months</option>
												<option value="24">24 months</option>
											</select>
										</div>
									</div>
								</form>

							</div>
							<div class="card-footer">
								<button type="submit" id="submitBtn"
									class="btn btn-primary btn-sm">
									<i class="fa fa-dot-circle-o"></i> Submit
								</button>
								<button type="reset" class="btn btn-danger btn-sm">
									<i class="fa fa-ban"></i> Reset
								</button>
							</div>
						</div>
					</div>


				</div>
			</div>
			<!-- .animated -->
		</div>
		<!-- .content -->
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>