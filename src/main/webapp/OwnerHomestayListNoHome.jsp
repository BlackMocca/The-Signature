<%-- 
    Document   : OwnerHomestayListNoHome
    Created on : Feb 21, 2018, 11:06:18 AM
    Author     : huag1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Owner Homestay List</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
    crossorigin="anonymous">
  <link rel="stylesheet" href="css/index.css">
  <link rel="stylesheet" href="css/navbar.css">
  <link href="https://fonts.googleapis.com/css?family=Barlow+Condensed:300" rel="stylesheet">
  <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>

<body>
  <div class="container-fluid management-page">

    <!-- NAV BAR START -->
    <div class="row justify-content-between navbar-wrapper">
        <div class="col col-md-6 col-12 navbar-left-menu">
          <div class="row">
            <div class="col col-md-2 col-12">
              <a href="#">
                <div class="row">
                  <div class="col navbar-menu navbar-menu-first">
                    <img class="navbar-logo" src="logo.png" alt="">
                  </div>
                </div>
              </a>
            </div>
            <div class="col col-md-3 col-12">
              <a href="#">
                <div class="row">
                  <div class="col navbar-menu">TRAVELLER</div>
                </div>
              </a>
            </div>
            <div class="col col-md-3 col-12">
              <a href="#">
                <div class="row">
                  <div class="col navbar-menu navbar-menu-last navbar-menu-selected">OWNER</div>
                </div>
              </a>
            </div>
          </div>
        </div>
        <div class="col col-md-6 col-12 bd">
          <div class="row justify-content-end">
            <div class="col col-md-3 col-12 navbar-menu navbar-menu-first navbar-username">Username</div>
            <div class="col col-md-2 col-12">
              <a href="#">
                <div class="row">
                  <div class="col navbar-menu navbar-logout logout-btn">LOGOUT</div>
                </div>
              </a>
            </div>
          </div>
        </div>
      </div>
      <!-- NAV BAR END -->

    <!-- BODY START -->
    <div class="row body-wrapper">

      <!-- SIDE BAR START -->
      <div class="col col-md-4 col-12 sidebar-wrapper bd">
          <div class="row">
            <div class="col col-12 bd">
              <a href="#">
                <div class="row">
                  <div class="col sidebar sidebar-selected">
                    <h1>MANAGEMENT</h1>
                  </div>
                </div>
              </a>
            </div>
            <div class="col col-12 bd">
              <a href="#">
                <div class="row">
                  <div class="col sidebar sidebar-last">
                    <h1>REQUEST</h1>
                  </div>
                </div>
              </a>
            </div>
          </div>
        </div>
        <!-- SIDE BAR END -->

      <!-- CONTENT START -->
      <div class="col col-md-8 col-12 bd text-center">
        <button class="btn btn-square add-homestay-btn">
          ADD HOMESTAY
        </button>
      </div>
      <!-- CONTENT END -->

    </div>
    <!-- BODY END -->

  </div>


  <!-- SWEET ALERT START -->
  <script>
    // IF CREATE COMPLETE
    if (true) {
      swal("Completed!", "Please wait for contact.", "success");
    }
  </script>
  <!-- SWEET ALERT END -->

</body>

</html>