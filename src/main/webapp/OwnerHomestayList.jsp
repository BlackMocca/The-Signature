<%-- 
    Document   : OwnerHomestayList
    Created on : Feb 21, 2018, 11:05:45 AM
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

        <!-- VERIFIED HOMESTAY ROW START -->
        <div class="row">
          <div class="col homestay-row">
            <div class="row">

              <div class="col col-md-6 col-12">
                <a href="#">
                  <div class="row homestay-image-wrapper">
                    <div class="col col-12 homestay-image" style="background-image: url('https://lumiere-a.akamaihd.net/v1/images/r_moana_header_poststreet_mobile_bd574a31.jpeg');"></div>
                  </div>
                </a>
              </div>

              <div class="col col-md-6 col-12">
                <div class="row">
                  <div class="col-12 homestay-detail">
                    <div class="row">
                      <div class="col-4 detail-title">NAME</div>
                      <div class="col-8 detail-value">Homestay Name</div>
                    </div>
                  </div>
                  <div class="col-12 homestay-detail">
                    <div class="row">
                      <div class="col-4 detail-title">LOCATION</div>
                      <div class="col-8 detail-value">Homestay Location</div>
                    </div>
                  </div>
                  <div class="col-12 homestay-detail">
                    <div class="row">
                      <div class="col-4 detail-title">PRICE</div>
                      <div class="col-8 price detail-value">10000000 THB/ROOM</div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- VERIFIED HOMESTAY ROW END -->


        <!-- DENIED HOMESTAY ROW START -->
        <div class="row">
          <div class="col homestay-row">
            <div class="row homestay-denied-border">

              <div class="col col-md-6 col-12">
                <a href="#">
                  <div class="row homestay-image-wrapper">
                    <div class="col col-12 homestay-image" style="background-image: url('https://lumiere-a.akamaihd.net/v1/images/r_moana_header_poststreet_mobile_bd574a31.jpeg');"></div>
                  </div>
                </a>
              </div>

              <div class="col col-md-6 col-12">
                <div class="row">
                  <div class="col-12 homestay-detail">
                    <div class="row">
                      <div class="col-4 detail-title">NAME</div>
                      <div class="col-8 detail-value">Homestay Name</div>
                    </div>
                  </div>
                  <div class="col-12 homestay-detail">
                    <div class="row">
                      <div class="col-4 detail-title">LOCATION</div>
                      <div class="col-8 detail-value">Homestay Location</div>
                    </div>
                  </div>
                  <div class="col-12 homestay-detail">
                    <div class="row">
                      <div class="col-4 detail-title">PRICE</div>
                      <div class="col-8 price detail-value">10000000 THB/ROOM</div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- DENIED HOMESTAY ROW END -->

        <!-- ADD HOME BUTTON START -->
        <div class="row">
          <div class="col add-home-wrapper">
            <div class="row justify-content-end">
              <div class="col col-md-4 col-12">
                  <a href="OwnerHomestayCreate.jsp"><button class="btn btn-square add-homestay-btn add-homestay-btn-list-page">ADD HOMESTAY</button></a>
              </div>
            </div>
          </div>
        </div>
        <!-- ADD HOME BUTTON END -->

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
