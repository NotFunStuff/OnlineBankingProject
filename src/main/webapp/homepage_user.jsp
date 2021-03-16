<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html class="no-js" lang="">
<head>
<meta charset="ISO-8859-1">

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Class Management Web - made by FunStuff I</title>
<meta name="description" content="Ela Admin - HTML5 Admin Template">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="apple-touch-icon" href="https://i.imgur.com/QRAUqs9.png">

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
<link rel="stylesheet" href="assets/css/tmd.css">

<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800'
	rel='stylesheet' type='text/css'>
</head>

<body>
	<jsp:include page="menu_bar.jsp"></jsp:include>

	<!-- Right Panel -->

	<div id="right-panel" class="right-panel">

		<jsp:include page="header.jsp"></jsp:include>

		<div class="content">
			<div class="animated fadeIn">
				<div class="col-md-12">
					<div class="card-body card-block">
						<div class="row">
							<div class="col-lg-6">
								<div class="feed-box text-center">
									<section class="card">
										<div class="card-body">
											<div class="corner-ribon blue-ribon">
												<i class="fa fa-twitter"></i>
											</div>
											<a href="#"> <img
												class="align-self-center rounded-circle mr-3"
												style="width: 85px; height: 85px;" alt=""
												src="images/admin.jpg">
											</a>
											<h2>Name</h2>
											<p>Bio</p>
											<div class="row form-group">
												<div class="col col-md-3 tmd">
													<label class=" form-control-label">Time Created:</label>
												</div>
												<div class="col-12 col-md-9">
													<p class="form-control-static">10/3/2021</p>
												</div>
											</div>
											<div class="row form-group">
												<div class="col col-md-3 tmd">
													<label class=" form-control-label">Dob:</label>
												</div>
												<div class="col-12 col-md-9">
													<p class="form-control-static">28/09/2000</p>
												</div>
											</div>
											<div class="row form-group">
												<div class="col col-md-3 tmd">
													<label class=" form-control-label">Balance:</label>
												</div>
												<div class="col-12 col-md-9">
													<p class="form-control-static">1000000000000</p>
												</div>
											</div>
											<div class="row form-group">
												<div class="col col-md-3 tmd">
													<label class=" form-control-label">Phone Number:</label>
												</div>
												<div class="col-12 col-md-9">
													<p class="form-control-static">0987654321</p>
												</div>
											</div>
											<div class="row form-group">
												<div class="col col-md-3 tmd">
													<label class=" form-control-label">Role:</label>
												</div>
												<div class="col-12 col-md-9">
													<p class="form-control-static">User</p>
												</div>
											</div>
										</div>
									</section>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="card">
									<div class="card-header">
										<h4>Exchange Tab</h4>
									</div>
									<div class="card-body card-block">
										<div class="custom-tab">
											<nav>
												<div class="nav nav-tabs" id="nav-tab" role="tablist">
													<a class="nav-item nav-link active"
														id="custom-nav-home-tab" data-toggle="tab"
														href="#custom-nav-home" role="tab"
														aria-controls="custom-nav-home" aria-selected="true">Withdraw</a>
													<a class="nav-item nav-link" id="custom-nav-profile-tab"
														data-toggle="tab" href="#custom-nav-profile" role="tab"
														aria-controls="custom-nav-profile" aria-selected="false">Deposit</a>
													<a class="nav-item nav-link" id="custom-nav-contact-tab"
														data-toggle="tab" href="#custom-nav-contact" role="tab"
														aria-controls="custom-nav-contact" aria-selected="false">Transfer</a>
												</div>
											</nav>
											<div class="tab-content pl-3 pt-2" id="nav-tabContent">
												<div class="tab-pane fade show active" id="custom-nav-home"
													role="tabpanel" aria-labelledby="custom-nav-home-tab">
													<form action="#" method="post"
														class="form-horizontal card-body card-block" id="myForm1">
														<div class="row form-group">
															<div class="col col-md-3 tmd">
																<label class=" form-control-label">Withdrawable
																	Amount of money:</label>
															</div>
															<div class="col-12 col-md-9">
																<p class="form-control-static">Balance - 50k</p>
															</div>
														</div>
														<div class="row form-group">
															<div class="col col-md-3">
																<label for="saveRate" class=" form-control-label">Withdraw:</label>
															</div>
															<div class="col-12 col-md-9">
																<input type="number" id="hf-email" name="saveRate"
																	placeholder="Min of 1.000" class="form-control">
															</div>
														</div>
														<p class="align-center-tmd">
															<button type="submit" class="btn btn-success"
																id="#submitBtn1">
																<i class="fa fa-dot-circle-o"></i> Submit
															</button>
														</p>
													</form>
												</div>
												<div class="tab-pane fade" id="custom-nav-profile"
													role="tabpanel" aria-labelledby="custom-nav-profile-tab">
													<form action="#" method="post"
														class="form-horizontal card-body card-block" id="myForm2">
														<div class="row form-group">
															<div class="col col-md-3 tmd">
																<label class=" form-control-label">Current
																	Balance:</label>
															</div>
															<div class="col-12 col-md-9">
																<p class="form-control-static">Balance</p>
															</div>
														</div>
														<div class="row form-group">
															<div class="col col-md-3">
																<label for="saveRate" class=" form-control-label">Deposit:</label>
															</div>
															<div class="col-12 col-md-9">
																<input type="number" id="hf-email" name="saveRate"
																	placeholder="Min of 1.000" class="form-control">
															</div>
														</div>
														<p class="align-center-tmd">
															<button type="submit" class="btn btn-success"
																id="#submitBtn2">
																<i class="fa fa-dot-circle-o"></i> Submit
															</button>
														</p>
													</form>
												</div>
												<div class="tab-pane fade" id="custom-nav-contact"
													role="tabpanel" aria-labelledby="custom-nav-contact-tab">
													<form action="#" method="post"
														class="form-horizontal card-body card-block" id="myForm3">
														<div class="row form-group">
															<div class="col col-md-3 tmd">
																<label class=" form-control-label">Transferable
																	Amount of money:</label>
															</div>
															<div class="col-12 col-md-9">
																<p class="form-control-static">Balance - 50k</p>
															</div>
														</div>
														<div class="row form-group">
															<div class="col col-md-3">
																<label for="saveRate" class=" form-control-label">Receiver
																	phone number:</label>
															</div>
															<div class="col-12 col-md-9">
																<input type="text" id="hf-email" name="saveRate"
																	placeholder="0987654321" class="form-control">
															</div>
														</div>
														<div class="row form-group">
															<div class="col col-md-3">
																<label for="saveRate" class=" form-control-label">Transfer
																	Ammount:</label>
															</div>
															<div class="col-12 col-md-9">
																<input type="number" id="hf-email" name="saveRate"
																	placeholder="Min of 1.000" class="form-control">
															</div>
														</div>
														<p class="align-center-tmd">
															<button type="submit" class="btn btn-success"
																id="#submitBtn3">
																<i class="fa fa-dot-circle-o"></i> Submit
															</button>
														</p>
													</form>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6">
							<div class="card">
								<div class="card-header">
									<h4>Interest Statistic</h4>
								</div>
								<div class="card-body">
									<div class="custom-tab">
										<nav>
											<div class="nav nav-tabs" id="nav-tab" role="tablist">
												<a class="nav-item nav-link active" id="custom-nav-save-tab"
													data-toggle="tab" href="#custom-nav-save" role="tab"
													aria-controls="custom-nav-save" aria-selected="false">Saving</a>
												<a class="nav-item nav-link" id="custom-nav-loan-tab"
													data-toggle="tab" href="#custom-nav-loan" role="tab"
													aria-controls="custom-nav-loan" aria-selected="false">Loaning</a>
											</div>
										</nav>
										<div class="tab-content pl-3 pt-2" id="nav-tabContent">
											<div class="tab-pane fade show active" id="custom-nav-save"
												role="tabpanel" aria-labelledby="custom-nav-save-tab">
												<div class="row form-group">
													<div class="col col-md-3 tmd">
														<label class=" form-control-label">Saving Amount:</label>
													</div>
													<div class="col-12 col-md-9">
														<p class="form-control-static">Balance</p>
													</div>
												</div>
												<div class="row form-group">
													<div class="col col-md-3 tmd">
														<label class=" form-control-label">Interest
															Earned:</label>
													</div>
													<div class="col-12 col-md-9">
														<p class="form-control-static">Compute</p>
													</div>
												</div>
												<div class="row form-group">
													<div class="col col-md-3 tmd">
														<label class=" form-control-label">Current
															Interest rate:</label>
													</div>
													<div class="col-12 col-md-9">
														<p class="form-control-static">100%</p>
													</div>
												</div>
												<div class="row form-group hidden">
													<div class="col col-md-12 tmd">
														<label class=" form-control-label">Your account is
															not saving account</label>
													</div>
												</div>
											</div>
											<div class="tab-pane fade" id="custom-nav-loan"
												role="tabpanel" aria-labelledby="custom-nav-loan-tab">
												<div class="row form-group">
													<div class="col col-md-3 tmd">
														<label class=" form-control-label">Loan Amount:</label>
													</div>
													<div class="col-12 col-md-9">
														<p class="form-control-static">- Balance</p>
													</div>
												</div>
												<div class="row form-group">
													<div class="col col-md-3 tmd">
														<label class=" form-control-label">Loan Interest
															Amount:</label>
													</div>
													<div class="col-12 col-md-9">
														<p class="form-control-static">Compute</p>
													</div>
												</div>
												<div class="row form-group">
													<div class="col col-md-3 tmd">
														<label class=" form-control-label">Loan Interest
															rate:</label>
													</div>
													<div class="col-12 col-md-9">
														<p class="form-control-static">100%</p>
													</div>
												</div>
												<div class="row form-group hidden">
													<div class="col col-md-12 tmd">
														<label class=" form-control-label">Your account is
															not saving account</label>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-6 ">
							<section class="card">
								<div class="card-header">
									<h4>Service</h4>
								</div>
								<br>
								<div class="col-lg-12">
									<div class="row form-group">
										<div class="col-lg-6 ">
											<button type="button" class="btn btn-block btn-primary">
												<i class="fa fa-film"></i>&nbsp; Movie
											</button>
										</div>
										<div class="col-lg-6 ">
											<button type="button" class="btn btn-block btn-warning">
												<i class="fa fa-cutlery"></i>&nbsp; Restaurant
											</button>
										</div>
									</div>
								</div>
								<div class="col-lg-12">
									<div class="row form-group">
										<div class="col-lg-6 ">
											<button type="button" class="btn btn-block btn-danger">
												<i class="fa fa-shopping-cart"></i>&nbsp; Clothes
											</button>
										</div>
										<div class="col-lg-6 ">
											<button type="button" class="btn btn-block btn-secondary">
												<i class="fa fa-lightbulb-o"></i>&nbsp; Electronics
											</button>
										</div>
									</div>
								</div>
							</section>
						</div>
					</div>
				</div>
			</div>

		</div>
		<!-- .animated -->
	
	<!-- .content -->


	<jsp:include page="footer.jsp"></jsp:include>
</div>

</body>

</html>