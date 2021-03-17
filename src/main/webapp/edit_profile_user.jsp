<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Online Banking Web - made by team 14C36</title>
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
				<div class="row">

					<div class="col-md-12">
						<div class="card">
							<div class="card-header">
								<strong>Edit Profiles Form</strong>
							</div>
							<div class="card-body card-block">
								<form action="/profiles" id="myForm1"
									enctype="multipart/form-data" method="POST"
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
											<label for="password-input" class=" form-control-label">Password</label>
										</div>
										<div class="col-12 col-md-9">
											<input type="password" id="password-input" name="password"
												placeholder="Password" class="form-control"><small
												class="help-block form-text">Should be more than 6
												letters or number with at least one uppercase character</small>
										</div>
									</div>
									<div class="row form-group">
										<div class="col col-md-3">
											<label class=" form-control-label">Name</label>
										</div>
										<div class="col-12 col-md-9">
											<input type="text" name="name" placeholder="Name"
												value="{name_value}" class="form-control">
										</div>
									</div>
									<div class="row form-group">
										<div class="col col-md-3">
											<label class=" form-control-label">Bio</label>
										</div>
										<div class="col-12 col-md-9">
											<input type="text" name="name" placeholder="Name"
												value="{bio_value}" class="form-control">
										</div>
									</div>
									<div class="row form-group">
										<div class="col col-md-3">
											<label class=" form-control-label">Phone Number</label>
										</div>
										<div class="col-12 col-md-9">
											<input type="text" name="name" placeholder="Name"
												value="{bio_value}" class="form-control">
										</div>
									</div>
									<div class="row form-group">
										<div class="col col-md-3">
											<label for="file-input" class=" form-control-label">Avatar</label>
										</div>
										<div class="col-12 col-md-9">
											<input type="file" id="file-input" name="ava"
												class="form-control-file">
										</div>
									</div>
									<div class="row form-group">
										<div class="col col-md-3">
											<label class=" form-control-label">DoB</label>
										</div>
										<div class="col-12 col-md-9">
											<input type="date" name="date">
										</div>
									</div>
									<div class="row form-group hidden">
										<div class="col col-md-3">
											<label class=" form-control-label">Business name</label>
										</div>
										<div class="col-12 col-md-9">
											<input type="text" name="business_name"
												placeholder="Business Name" value="{bio_value}"
												class="form-control">
										</div>
									</div>
									<div class="row form-group hidden">
										<div class="col col-md-3">
											<label class=" form-control-label">Location</label>
										</div>
										<div class="col-12 col-md-9">
											<input type="text" name="location" placeholder="Name"
												value="{bio_value}" class="form-control">
										</div>
									</div>
									<div class="row form-group hidden">
										<div class="col col-md-3">
											<label class=" form-control-label">Industry</label>
										</div>
										<div class="col-12 col-md-9">
											<input type="text" name="industry" placeholder="Name"
												value="{bio_value}" class="form-control">
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
		<script>
    //not finished
    let uid = req.params.id
    const response = await fetch('http://localhost:8000/account/getAccountById/' + uid, {
        method: 'GET'
    })
    const json = await response.json()
    document.querySelector('.un').innerHTML = json.username
    document.getElementsbyName('password').value= json.password
    document.getElementsByName('name').value = json.name
    document.getElementsByName('bio').value = json.bio
    document.getElementsByName('phoneNumber').value = json.phoneNumber
    document.getElementsByName('date').value = json.date              
    if (json.role === 'business') {
        const response = await fetch('http://localhost:8000/account/getBusinessById/' + uid, {
            method: 'GET'
        })
        const jsonBusiness = await response.json()
        document.getElementsByName('business_name').value = jsonBusiness.businessName
        document.getElementsByName('industry').value = jsonBusiness.industry
        document.getElementsByName('location').value = jsonBusiness.location
        document.querySelector('#submitBtn').addEventListener("click", () => {
            fetch(`http://localhost:8000/account/editBusiness`, {
                    method: 'POST',
                    body: JSON.stringify({
                        // name: "A",
                        // bio: "abcde",
                        // phone: 01234,
                        // location; "VN"
                        id: uid,
                        username: json.username,
                        name: document.getElementsByName('name').value,
                        bio: document.getElementsByName('bio').value,
                        phoneNumber: document.getElementsByName('phoneNumber').value,
                        password:  document.getElementsByName('password').value,
                        dob: document.getElementsByName('dob').value,
                        ava: document.getElementsByName('ava').value,
                        businessName: document.getElementsByName('business_name').value,
                        industry: document.getElementsByName('industry').value,
                        location: document.getElementsByName('location').value
                    })
                }).then(r => r.json())
                .then(res => {                   
                	window.location.replace("\homepage_user.html");
                })
        })
    } else {
        document.querySelector('#submitBtn').addEventListener("click", () => {
            fetch(`http://localhost:8000/account/editAccount`, {
                    method: 'POST',
                    body: JSON.stringify({
                        // name: "A",
                        // bio: "abcde",
                        // phone: 01234,
                        // location; "VN"
                        id: uid,
                        username: json.username,
                        name: document.getElementsByName('name').value,
                        bio: document.getElementsByName('bio').value,
                        phoneNumber: document.getElementsByName('phoneNumber').value,
                        dob: document.getElementsByName('dob').value,
                        ava: document.getElementsByName('ava').value
                    })
                }).then(r => r.json())
                .then(res => {
                    
                    window.location.replace("\homepage_user.html");
                })
        })
    }
</script>
	</div>
</body>
</html>