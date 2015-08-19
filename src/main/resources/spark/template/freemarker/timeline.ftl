<#import "masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Timeline">
    <h2>${pageTitle}</h2>
    <#if user??>
    	<#if profileUser?? && user.id != profileUser.id>
    		<div class="followstatus">
    		<#if followed>
    			<a class="unfollow" href="/t/${profileUser.username}/unfollow">Unfollow user</a>
    		<#else>
    			<a class="follow" href="/t/${profileUser.username}/follow">Follow user</a>.
    		</#if>
    		</div>
    	<#elseif pageTitle != 'Public Timeline'>
    		<div class="twitbox">
        		<h3>What's on your mind ${user.username}?</h3>
        		<form action="/message" method="post">
          		<p><input type="text" name="text" size="60" maxlength="160"><!--
          		--><input type="submit" value="Share">
        		</form>
      		</div>
    	</#if>
    </#if>
    <ul class="messages">
    <#if messages??>
    <#list messages as message>
		<li><img src="${message.gravatar}"><p>
		<strong><a href="/t/${message.username}">${message.username}</a></strong>
		${message.text}
		<small>&mdash; ${message.pubDateStr}</small>
	<#else>
		<li><em>There're no messages so far.</em>
	</#list>
	<#else>
		<li><em>There're no messages so far.</em>
	</#if>
	</ul>
</@layout.masterTemplate>