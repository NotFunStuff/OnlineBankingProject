<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Register</title>
<meta name="description" content="Ela Admin - HTML5 Admin Template">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="apple-touch-icon" href="https://i.imgur.com/QRAUqs9.png">
<link rel="shortcut icon" href="https://i.imgur.com/QRAUqs9.png">

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
<link rel="stylesheet" href="assets/css/style.css">


<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="assets/css/tmd.css">
<!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->
</head>
<body>
<body class="bg-dark">

	<div class="sufee-login d-flex align-content-center flex-wrap">
		<div class="container">
			<div class="login-content">
				<div class="login-form">
					<form>
						<div class="form-group">
							<label>User Name</label> <input type="text" class="form-control"
								placeholder="User Name"> <span><small>This
									is your log in name</small></span>
						</div>
						<div class="form-group">
							<label>Name</label> <input type="text" class="form-control"
								placeholder="Name"> <span><small>This is
									your display name</small></span>
						</div>
						<div class="form-group">
							<label>Password</label> <input type="password"
								class="form-control" placeholder="Password"> <span><small>Should
									be more than 6 letters or number with at least one uppercase
									character</small></span>
						</div>
						<div class="form-group">
							<label>Phone Number</label> <input type="text"
								class="form-control" placeholder="0987654321">
						</div>
						<div class="row form-group">
							<div class="form-check-inline">
								<div class="col col-md-3">
									<label class=" form-control-label">Role: </label>
								</div>
								<div class="col col-md-9">
									<div class="radio">
										<label for="radio1" class="form-check-label"> <input
											type="radio" id="radio1" name="time" value="User"
											class="form-check-input">User
										</label>
									</div>
									<div class="radio">
										<label for="radio2" class="form-check-label"> <input
											type="radio" id="radio2" name="time" value="Business"
											class="form-check-input">Business
										</label>
									</div>
								</div>
							</div>
						</div>
						<div class="row form-group">
							<div class="col col-md-3">
								<label class=" form-control-label">DoB:</label>
							</div>
							<div class="col-12 col-md-9">
								<input type="date" name="dob">
							</div>
						</div>
						<div class="checkbox">
							<label> <input type="checkbox"> Agree the terms
								and policy
							</label>
						</div>

						<button type="submit"
							class="btn btn-primary btn-flat m-b-30 m-t-30">Register</button>
						<div class="register-link m-t-15 text-center">
							<p>
								Already have account ? <a href="#"> Sign in</a>
							</p>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/jquery@2.2.4/dist/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.14.4/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/jquery-match-height@0.7.2/dist/jquery.matchHeight.min.js"></script>
	<script src="assets/js/main.js"></script>
	<script> // not test yet
        document.querySelector('#submitBtn').addEventListener("click", () => {
            fetch(`http://localhost:8080/account/addAccount`, {
                    method: 'POST',
                    body: JSON.stringify({                                          
                        username: document.getElementsByName('userName').value,
                        name: document.getElementsByName('name').value,
                        password: document.getElementsByName('password').value,
                        phoneNumber: document.getElementsByName('phoneNumber').value,
                        timeCreated: new Date(),
                        dob: document.getElementsByName('dob').value,
                        role: document.getElementsByName('role').value
                    })             
                }).then(r => r.json())
                .then(res => {                    
                    window.location.replace("/login.html");
                })
        })
    </script>
</body>
</html>