  // UPDATE HOMESTAY IMAGE FOR BINDED DIV

  $(document).ready(function() {
    var readURL = function(input, element) {
      if (input.files && input.files[0]) {
          var reader = new FileReader();

          reader.onload = function (e) {
              $(element).css({ 
                'background': "url(\'" + e.target.result + "\')",
                'background-size': 'cover'
              })
          }

          reader.readAsDataURL(input.files[0]);
      }
  }

  // HOMESTAY IMAGE BINDING DIV AND FORM

  $('#cover-img-wrapper').click(function(){
    $('#cover-input').click();
  });
  $("#cover-input").on('change', function(){
    readURL(this, '#cover-img-wrapper');
  });

  $('#img-1').click(function(){
    $('#image-input-1').click();
  });
  $("#image-input-1").on('change', function(){
    readURL(this, '#img-1');
  });

  $('#img-2').click(function(){
    $('#image-input-2').click();
  });
  $("#image-input-2").on('change', function(){
    readURL(this, '#img-2');
  });

  $('#img-3').click(function(){
    $('#image-input-3').click();
  });
  $("#image-input-3").on('change', function(){
    readURL(this, '#img-3');
  });

  // HOMESTAY FORM VALIDATION

  $("#homestay-create-form").validate({
    ignore: "",
    rules: {
      cover: 'required',
      Homestay_License_document: {
        required: true,
        extension: "pdf,jpg,png"
      },
      Hourse_document: {
        required: true,
        extension: "pdf,jpg,png"
      },
      Price: {
        required: true,
        number: true,
        min: 0
      },
      Description: {
        required: true,
        minlength: 130
      },
      Telno: {
        number: true,
        minlength: 9,
        maxlength: 10
      }
    },
    errorClass: 'is-invalid',
    validClass: 'is-valid',
    errorElement: 'div',
    errorPlacement: function(error, element) {
      var elementId = element.attr('id')
      if(elementId == 'cover-input') {
        element.addClass('dis-none')
        $('#cover-img-wrapper').addClass('img-input-error')
        return
      } else if (elementId == 'image-input-1') {
        element.addClass('dis-none')
        $('#img-1').addClass('img-input-error')
        return
      } else if (elementId == 'image-input-2') {
        element.addClass('dis-none')
        $('#img-2').addClass('img-input-error')
        return
      } else if (elementId == 'image-input-3') {
        element.addClass('dis-none')
        $('#img-3').addClass('img-input-error')
        return
      } else if (elementId == 'open-time-input') {
        return
      } else if (elementId == 'close-time-input') {
        return
      } else {
        error.addClass('invalid-feedback')
      }

      if ( element.prop( "type" ) === "checkbox" ) {
        error.insertAfter( element.parent( "label" ) );
      } else {
        error.insertAfter( element );
      }
    }

  });
  
  // HOMESTAY IMAGE ERROR CLASS MANAGEMENT

  $('#cover-input').change(function() {
    if ($('#cover-img-wrapper').hasClass('img-input-error')) {
      $('#cover-img-wrapper').removeClass('img-input-error')
    }
  });

  $('#image-input-1').change(function() {
    if ($('#img-1').hasClass('img-input-error')) {
      $('#img-1').removeClass('img-input-error')
    }
  });

  $('#image-input-2').change(function() {
    if ($('#img-2').hasClass('img-input-error')) {
      $('#img-2').removeClass('img-input-error')
    }
  });

  $('#image-input-3').change(function() {
    if ($('#img-3').hasClass('img-input-error')) {
      $('#img-3').removeClass('img-input-error')
    }
  });

  // HOMESTAY DATETIME PICKER

  $('#homestay-open-time').datetimepicker({
    format: 'LT'
  });

  $('#homestay-close-time').datetimepicker({
    format: 'LT'
  });

});