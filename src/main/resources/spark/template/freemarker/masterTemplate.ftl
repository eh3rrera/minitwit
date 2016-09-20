<#macro masterTemplate title="Welcome">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <title>${title} | MiniTwit</title>
    <link href="/jquery-validation/validate.css" type="text/css" rel="stylesheet" />
    <link href="/css/style.css" type="text/css" rel="stylesheet" />
    <script src="/jquery/jquery.min.js" type="text/javascript"></script>
    <script src="/jquery-validation/jquery.validate.min.js" type="text/javascript"></script>
    <script src="/jquery-validation/messages_ja.js" type="text/javascript"></script>
  </head>
  <body>
    <div class="page">
      <h1>MiniTwit</h1>
		  <div class="navigation">
		    <#if user??>
		    	<a href="/">my timeline</a> |
		    	<a href="/public">public timeline</a> |
		    	<a href="/logout">sign out [${user.username}]</a>
		  	<#else>
			    <a href="/public">public timeline</a> |
			    <a href="/register">sign up</a> |
			    <a href="/login">sign in</a>
		  	</#if>
		  </div>
		  <div class="body"><#nested /></div>
		  <div class="footer">MiniTwit &mdash; A Spark Application</div>
		</div>
  </body>
</html>
</#macro>
