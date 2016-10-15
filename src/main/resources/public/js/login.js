$(document).ready(function() {
  $("#loginForm").validate({
    rules: {
      username: {
        required: true,
        minlength: 2,
        maxlength: 50
      },
      password: {
        required: true,
        minlength: 5
      }
    }
  });
});
