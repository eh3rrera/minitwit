$(document).ready(function() {
  $("#registerForm").validate({
    rules: {
      username: {
        required: true,
        minlength: 2,
        maxlength: 50
      },
      email: {
        required: true,
        email: true,
        minlength: 2,
        maxlength: 50
      },
      password: {
        required: true,
        minlength: 5,
        maxlength: 20
      },
      password2: {
        required: true,
        minlength: 5,
        maxlength: 20,
        equalTo: "[name=password]"
      }
    }
  });
});
