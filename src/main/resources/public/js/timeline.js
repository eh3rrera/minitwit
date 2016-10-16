$(document).ready(function() {
  $("#messageForm").validate({
    rules: {
      text: {
        required: true,
        maxlength: 160
      }
    }
  });

  $("#pagenow").keyup(function() {
    var pagenow = $(this).val().replace(/[^\d]/g,'') * 1;

    if (pagenow <= 0) {
      pagenow = 1;
    }

    var pagetotal = $("#pagetotal").text() * 1;

    if (pagetotal < pagenow) {
      pagenow = pagetotal;
    }

    $(this).val(pagenow);
    var hidden_pagenow = $("#hidden_pagenow").val() * 1;

    if (pagenow === hidden_pagenow) {
      return;
    }

    var step = $("#step").val();
    var kind = $("#hidden_kind").val();
    var href = "/" + kind + "/" + step + "/" + pagenow;
    $(location).attr("href", href);
  });

  $("#step").keyup(function() {
    var step = $(this).val().replace(/[^\d]/g,'') * 1;

    if (step <= 0) {
      step = 1;
    }

    var count = $("#hidden_count").val() * 1;

    if (count < step) {
      step = count;
    }

    $(this).val(step);
    var hidden_step = $("#hidden_step").val() * 1;

    if (step === hidden_step) {
      return;
    }

    var kind = $("#hidden_kind").val();
    var href = "/" + kind + "/" + step + "/1";
    $(location).attr("href", href);
  });
});
