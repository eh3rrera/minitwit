<#import "masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Sign In">
    <h2>Sign Up</h2>
    <#if error??>
    	<div class="error">
    		<strong>Error:</strong> ${error}
    	</div>
    </#if>
    <form action="/register" method="post">
    <dl>
      <dt>Username:
      <dd><input type="text" name="username" maxlength="50" size="30" value="${username!}">
      <dt>E-Mail:
      <dd><input type="text" name="email" maxlength="50" size="30" value="${email!}">
      <dt>Password:
      <dd><input type="password" name="password" maxlength="20" size="30">
      <dt>Password <small>(repeat)</small>:
      <dd><input type="password" name="password2" maxlength="20" size="30">
    </dl>
    <div class="actions"><input type="submit" value="Sign Up"></div>
  </form>
</@layout.masterTemplate>