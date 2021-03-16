<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Class Management Web - made by FunStuff I</title>    
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="https://i.imgur.com/QRAUqs9.png">
    <!-- <link rel="shortcut icon" href="https://i.imgur.com/QRAUqs9.png"> -->

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/normalize.css@8.0.0/normalize.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/pixeden-stroke-7-icon@1.2.3/pe-icon-7-stroke/dist/pe-icon-7-stroke.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.2.0/css/flag-icon.min.css">
    <link rel="stylesheet" href="assets/css/cs-skin-elastic.css">
    <link rel="stylesheet" href="assets/css/lib/datatable/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/style.css">

    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>

    <!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->
</head>
<body>
<jsp:include page="menu_bar_admin.jsp"></jsp:include>

	<!-- Right Panel -->

	<div id="right-panel" class="right-panel">
	<jsp:include page="header.jsp"></jsp:include>
	<div class="content">
            <div class="animated fadeIn">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header">
                            <strong>Manage Rate</strong>
                        </div>
                        <div class="card-body card-block">
                            <div class="font-weight-bold"> Current Bank money: 1000000000000000 </div> <br>
                            <div class="row">
                                <div class="col">
                                    <section class="card">
                                        <div class="card-header font-weight-bold">Savings deposit
                                            statistic: </div>
                                        <form action="#" method="post" class="form-horizontal card-body card-block" id="myForm1">
                                            <div class="row form-group">
                                                <div class="col col-md-3"><label
                                                        class=" form-control-label">Current Saving Rate:</label></div>
                                                <div class="col-12 col-md-9">
                                                    <p class="form-control-static">100%</p>
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-3"><label
                                                        class=" form-control-label">Current Saving Account:</label></div>
                                                <div class="col-12 col-md-9">
                                                    <p class="form-control-static">100</p>
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-3"><label for="saveRate"
                                                        class=" form-control-label">Change Saving Rate to(%):</label></div>
                                                <div class="col-12 col-md-9"><input type="email" id="hf-email"
                                                        name="saveRate" placeholder="x.xx"
                                                        class="form-control"></div>
                                            </div>                                            
                                        </form>
                                        <div class="card-footer">
                                            <button type="submit" class="btn btn-primary btn-sm" id ="#submitBtn1">
                                                <i class="fa fa-dot-circle-o"></i> Submit
                                            </button>                                            
                                        </div>
                                    </section>
                                </div>
                                <div class="col">
                                    <section class="card">
                                        <div class="card-header font-weight-bold">Bank Loan
                                            statistic: </div>
                                        <form action="#" method="post" class="form-horizontal card-body card-block" id="myForm2">
                                            <div class="row form-group">
                                                <div class="col col-md-3"><label
                                                        class=" form-control-label">Current Loaning Rate:</label></div>
                                                <div class="col-12 col-md-9">
                                                    <p class="form-control-static">100%</p>
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-3"><label
                                                        class=" form-control-label">Current Loaning Account:</label></div>
                                                <div class="col-12 col-md-9">
                                                    <p class="form-control-static">100</p>
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-3"><label for="saveRate"
                                                        class=" form-control-label">Change Loaning Rate to(%):</label></div>
                                                <div class="col-12 col-md-9"><input type="email" id="hf-email"
                                                        name="saveRate" placeholder="x.xx"
                                                        class="form-control"></div>
                                            </div>                                            
                                        </form>
                                        <div class="card-footer">
                                            <button type="submit" class="btn btn-primary btn-sm" id ="#submitBtn2">
                                                <i class="fa fa-dot-circle-o"></i> Submit
                                            </button>                                            
                                        </div>
                                    </section>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div><!-- .animated -->
        </div><!-- .content -->
	<jsp:include page="footer.jsp"></jsp:include>	
	</div>
</body>
</html>