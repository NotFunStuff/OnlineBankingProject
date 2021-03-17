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
                            {msg}
                            <div class="card-header">
                                <strong>Edit Account Form</strong>
                            </div>
                            <div class="card-body card-block">
                                <form action="/class_edit_{classId}" id="myForm1" method="POST" class="form-horizontal">
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label class="form-control-label">Username</label>
                                        </div>
                                        <div class="col-12 col-md-9">
                                            <p class="form-control-static">usermame</p>
                                        </div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label for="text-input"
                                                class=" form-control-label">Name</label></div>
                                        <div class="col-12 col-md-9"><input type="text" id="text-input" name="className"
                                                class="form-control" value=""></div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label for="text-input"
                                                class=" form-control-label">Bio</label></div>
                                        <div class="col-12 col-md-9"><input type="text" id="text-input" name="classRoom"
                                                class="form-control"></div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label class=" form-control-label">Phone
                                                Number</label></div>
                                        <div class="col-12 col-md-9"><input type="text" name="name" placeholder="Name"
                                                value="{bio_value}" class="form-control"></div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label for="file-input"
                                                class=" form-control-label">Avatar</label></div>
                                        <div class="col-12 col-md-9"><input type="file" id="file-input" name="ava"
                                                class="form-control-file"></div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label class=" form-control-label">Date of
                                                Birth</label></div>
                                        <div class="col-12 col-md-9">
                                            <input type="date" name="date">
                                        </div>
                                    </div>
                                    <div class="row form-group hidden">
                                        <div class="col col-md-3"><label class=" form-control-label">Business name</label></div>
                                        <div class="col-12 col-md-9"><input type="text" name="business_name" placeholder="Business Name"
                                                value="{bio_value}" class="form-control"></div>
                                    </div>
                                    <div class="row form-group hidden">
                                        <div class="col col-md-3"><label class=" form-control-label">Location</label></div>
                                        <div class="col-12 col-md-9"><input type="text" name="location" placeholder="Name"
                                                value="{bio_value}" class="form-control"></div>
                                    </div>
                                    <div class="row form-group hidden">
                                        <div class="col col-md-3"><label class=" form-control-label">Industry</label></div>
                                        <div class="col-12 col-md-9"><input type="text" name="industry" placeholder="Name"
                                                value="{bio_value}" class="form-control"></div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3">
                                            <label class=" form-control-label">Invest money</label>
                                        </div>
                                        <div class="col-12 col-md-9">
                                            <p class="form-control-static hidden">+ - 1000</p>
                                            <p class="form-control-static">This account has not invest money yet <button
                                                    type="button"
                                                    class="btn btn-link btn-sm hidden">Edit</button><button
                                                    type="button" class="btn btn-link btn-sm">Add</button></p>

                                        </div>
                                    </div>


                                </form>

                            </div>
                            <div class="card-footer">
                                <button type="submit" id="submitBtn" class="btn btn-primary btn-sm">
                                    <i class="fa fa-dot-circle-o"></i> Submit
                                </button>
                                <button type="reset" class="btn btn-danger btn-sm">
                                    <i class="fa fa-ban"></i> Reset
                                </button>
                            </div>
                        </div>
                    </div>


                </div>
            </div><!-- .animated -->
        </div><!-- .content -->
        <jsp:include page="footer.jsp"></jsp:include>
        <script>
        //not finished
        let uid = req.params.id
        const response = await fetch('http://localhost:8000/account/getAccountById/' + uid, {
            method: 'GET'
        })
        const json = await response.json()
        document.querySelector('.un').innerHTML = json.username        
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
                            password: json.password,
                            bio: document.getElementsByName('bio').value,
                            phoneNumber: document.getElementsByName('phoneNumber').value,
                            dob: document.getElementsByName('date').value,
                            ava: document.getElementsByName('ava').value,
                            businessName: document.getElementsByName('business_name').value,
                            industry: document.getElementsByName('industry').value,
                            location: document.getElementsByName('location').value
                        })
                    }).then(r => r.json())
                    .then(res => {                        
                    	window.location.replace("\account_list_admin.html");
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
                        window.location.replace("\account_list_admin.html");
                    })
            })
        }
    </script>
        </div>
</body>
</html>