<#import "masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Sign In">
  <h2>Sign In</h2>
  <#if message??>
    <div class="success">${message}</div>
  </#if>
  <#if error??>
    <div class="error">
      <strong>Error:</strong> ${error}
    </div>
  </#if>
  <form id="loginForm" action="/login" method="post">
    <dl>
      <dt>Username:
	    <dd><input type="text" name="username" value="${username!}">
	    <dt>Password:
	    <dd><input type="password" name="password">
	  </dl>
	  <div class="actions"><input type="submit" value="Sign In"></div>
	</form>

  <script type="text/javascript" src="/js/login.js"></script>
</@layout.masterTemplate>
