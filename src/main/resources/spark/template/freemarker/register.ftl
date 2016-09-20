<#import "masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Sign In">
  <h2>Sign Up</h2>
  <#if error??>
    <div class="error">
      <strong>Error:</strong> ${error}
    </div>
  </#if>
  <form id="registerForm" action="/register" method="post">
    <dl>
      <dt>Username:
      <dd><input type="text" name="username" value="${username!}">
      <dt>E-Mail:
      <dd><input type="text" name="email" value="${email!}">
      <dt>Password:
      <dd><input type="password" name="password">
      <dt>Password <small>(repeat)</small>:
      <dd><input type="password" name="password2">
    </dl>
    <div class="actions"><input type="submit" value="Sign Up"></div>
  </form>
  <script>
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
  </script>
</@layout.masterTemplate>
