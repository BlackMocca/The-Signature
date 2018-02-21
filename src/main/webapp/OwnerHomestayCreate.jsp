<%-- 
    Document   : OwnerHomestayCreate
    Created on : Feb 21, 2018, 11:03:58 AM
    Author     : ChanonPingpong
--%>

<%@page import="com.the.signature.models.ENV"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Owner Homestay Create</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
    crossorigin="anonymous">
  <link rel="stylesheet" href="css/tempusdominus-bootstrap-4.min.css" />
  <link rel="stylesheet" href="css/index.css">
  <link rel="stylesheet" href="css/navbar.css">
  <link href="https://fonts.googleapis.com/css?family=Barlow+Condensed:300" rel="stylesheet">
  <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
  <link rel="stylesheet" href="/The-Signature/css/ownerHomestayCreate.css">
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

        <!-- HOMESTAY CREATE FORM START -->
        <div class="row">
          <div class="col homestay-create-form">

            <form action="" id="homestay-create-form">

            <div class="row">
              <div class="col">
                <div class="row">
                  <div class="col-md-8 col-12 homestay-cover homestay-create-cover homestay-default-img" id="cover-img-wrapper"></div>
                  <div class="col-md-4 col-12">
                    <div class="row homestay-img-wrapper">
                      <div class="col-12 col-sm-4 col-md-12 homestay-img homestay-create-image homestay-default-img" id="img-1"></div>
                      <div class="col-12 col-sm-4 col-md-12 homestay-img homestay-create-image homestay-default-img" id="img-2"></div>
                      <div class="col-12 col-sm-4 col-md-12 homestay-img homestay-create-image homestay-default-img" id="img-3"></div>
                    </div>
                  </div>
                  <input id="cover-input" class="dis-none" type="file" accept="image/*" name="cover" required/>
                  <input id="image-input-1" class="dis-none" type="file" accept="image/*" name="img-1" required/>
                  <input id="image-input-2" class="dis-none" type="file" accept="image/*" name="img-2" required/>
                  <input id="image-input-3" class="dis-none" type="file" accept="image/*" name="img-3" required/>
                </div>
              </div>
            </div>

            <div class="row form-wrapper">
              <div class="col-12">
                <div class="row">
                  <div class="col-md-6 col-12">
                    <div class="row">
                      <div class="col-12 form-header">ADDRESS</div>
                    </div>
                    <div class="row form-content">
                      <div class="col-12">
                        <div class="form-group">
                            <label>Province*</label>
                            <select class="form-control" name="homestay_prov" id="" required>
                              <option value="Bangkok">Bangkok</option>
                              <option value="Chiangmai">Chiangmai</option>
                              <option value="Nakornpathom">Nakornpathom</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Dicstrict*</label>
                            <input class="form-control" type="text" placeholder="" name="homestay_disc" required>
                        </div>
                        <div class="form-group">
                            <label>Sub-Dicstrict*</label>
                            <input class="form-control" type="text" placeholder="" name="homestay_sub_disc" required>
                        </div>
                        <div class="form-group">
                            <label>Detail*</label>
                            <textarea class="form-control" type="text" placeholder="" rows="5" name="homestay_addr_detail" required></textarea>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6 col-12 form-right">
                    <div class="row">
                      <div class="col-12 form-header">CONTACT</div>
                    </div>
                    <div class="row form-content">
                      <div class="col-12">
                        <div class="form-group">
                            <label>Tel No.*</label>
                            <input class="form-control" type="text" placeholder="" name="homestay_telno" required>
                        </div>
                        <div class="form-group">
                            <label>Operation Time*</label><br />
                            <label>Open-Time</label>
                            <div class="input-group date" id="homestay-open-time" data-target-input="nearest">
                              <input type="text" id="open-time-input" class="form-control datetimepicker-input" data-target="#homestay-open-time" name="homestay_open_time" required/>
                              <div class="input-group-append homestay-open-icon" data-target="#homestay-open-time" data-toggle="datetimepicker">
                                  <div class="input-group-text icon-block"><i class="far fa-clock"></i></div>
                              </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label>Close-Time</label>
                            <div class="input-group date" id="homestay-close-time" data-target-input="nearest">
                              <input type="text" id="close-time-input" class="form-control datetimepicker-input" data-target="#homestay-close-time" name="homestay_close_time" required/>
                              <div class="input-group-append" data-target="#homestay-close-time" data-toggle="datetimepicker">
                                  <div class="input-group-text icon-block"><i class="far fa-clock"></i></div>
                              </div>
                            </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="row form-wrapper">
              <div class="col-12">
                <div class="row">
                  <div class="col-md-6 col-12">
                    <div class="row">
                      <div class="col-12 form-header">DESCRIPTION</div>
                    </div>
                    <div class="row form-content">
                      <div class="col-12">
                        <div class="form-group">
                            <label>Homestay Description*</label>
                            <textarea class="form-control" type="text" placeholder="" rows="5" name="homestay_desc" required></textarea>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6 col-12 form-right">
                    <div class="row">
                      <div class="col-12 form-header">RULES AND CONDITION</div>
                    </div>
                    <div class="row form-content">
                      <div class="col-12">
                        <div class="form-group">
                            <label>Homestay Rules and Condition*</label>
                            <textarea class="form-control" type="text" placeholder="" rows="5" name="homestay_rules_cond" required></textarea>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="row form-wrapper">
              <div class="col-12">
                <div class="row">
                  <div class="col-md-6 col-12">
                    <div class="row">
                      <div class="col-12 form-header">DOCUMENT</div>
                    </div>
                    <div class="row form-content">
                      <div class="col-12">
                        <div class="form-group">
                            <label>Open License* (.pdf, .jpg, .png only)</label>
                            <input class="form-control" type="file" placeholder="" name="open_license" required>
                        </div>
                        <div class="form-group">
                            <label>Copy of ID Card* (.pdf, .jpg, .png only)</label>
                            <input class="form-control" type="file" placeholder="" name="copy_idcard" required>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6 col-12 form-right">
                    <div class="row">
                      <div class="col-12 form-header">PRICE</div>
                    </div>
                    <div class="row form-content">
                      <div class="col-12">
                        <div class="form-group">
                            <label>Room / Night*</label>
                            <input class="form-control" type="Number" placeholder="" name="homestay_price">
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>

          </div>
        </div>
        <!-- HOMESTAY CREATE FORM END -->

        <!-- HOMESTAY CREATE BUTTON START -->
        <div class="row homestay-create-btn-wrapper">
          <div class="col">
            <div class="row justify-content-end">
              <div class="col col-md-4 col-12">
                <a href="#"><button class="btn btn-light btn-cancel btn-square">CANCEL</button></a>
                <button class="btn btn-square add-homestay-btn add-homestay-btn-list-page">CREATE</button>
              </div>
            </div>
          </div>
        </div>
        <!-- HOMESTAY CREATE BUTTON END -->

        </form>

      </div>
      <!-- CONTENT END -->

    </div>
    <!-- BODY END -->

  </div>

  <script
  src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
  integrity="sha256-3edrmyuQ0w65f8gfBsqowzjJe2iM6n0nKciPUp8y+7E="
  crossorigin="anonymous"></script>
  <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.min.js"></script>
  <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
  <script src="js/moment.js"></script>
  <script src="js/tempusdominus-bootstrap-4.min.js"></script>
  <script src="js/main.js"></script>
</body>

</html>
