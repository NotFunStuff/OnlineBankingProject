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
                <div class="row">

                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header">
                                <strong class="card-title">Class list</strong>
                            </div>
                            <div class="card-body">
                                <table id="bootstrap-data-table" class="table table-striped table-bordered">
                                    <thead>
                                        <tr>
                                            <th scope="col">ID</th>
                                            <th scope="col">UserName</th>
                                            <th scope="col">Name</th>
                                            <th scope="col">Bio</th>
                                            <th scope="col">DOB</th>
                                            <th scope="col">Time Created</th>
                                            <th scope="col">Balance</th>
                                            <th scope="col">Role</th>
                                            <th scope="col">#</th>
                                            <th scope="col">#</th>
                                        </tr>
                                    </thead>
                                    <tbody id ="services">  
                                        <!-- content -->
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>


                </div>
            </div><!-- .animated -->
        </div><!-- .content -->
        <jsp:include page="footer.jsp"></jsp:include>
        <script> //not finished
        fetch(`http://localhost:8080/account/getAllAccounts`, {
                method: 'GET'
            }).then(r => r.json())
            .then(res => {   
                entry = ""
                res.forEach(element => {
                    entry += `
                            <tr>
                                <td>${element.accountId}</td>
                        <td>${element.userName}</td>
                        <td>${element.name}</td>
                        <td>${element.bio}</td>
                        <td>${element.dateOfBirth}</td>
                        <td>${element.timeCreated}</td>
                        <td>${element.balance}</td>
                        <td>${element.role}</td>
                        <td><a href="/Failure(Java)/SE2Project/HTML/edit_profile_admin.html/?params=${element.accountId}">Edit</a></td>
                        <td><a href="javascript:confirmDelete('${String(element.accountId)}')">Delete</a></td>  
                            </tr>
                        `
                });

                document.querySelector('#services').innerHTML = entry
            })
    </script>
        </div>
</body>
</html>