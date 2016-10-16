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
  <script type="text/javascript" src="/js/register.js"></script>
</@layout.masterTemplate>
