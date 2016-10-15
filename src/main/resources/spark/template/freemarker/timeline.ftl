<#import "masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Timeline">
	<table>
		<tr>
			<td>
		  <h2>${pageTitle}</h2>
			</td>
		  <#if pagenow == 1>
				<td>&nbsp;<<&nbsp;</td>
				<td>&nbsp;<&nbsp;</td>
		  <#else>
				<td>
					<a href="/${kind}/${step}/1">&nbsp;<<&nbsp;</a>
				</td>
				<td>
					<a href="/${kind}/${step}/${pagenow - 1}">&nbsp;<&nbsp;</a>
				</td>
		  </#if>
			<td>
				<input type="text" class="onlydigit" id="pagenow" value="${pagenow}">
				&nbsp;of&nbsp;
				<span id="pagetotal">${pagetotal}</span>
				&nbsp;pages
				<input type="hidden" id="hidden_pagenow" value="${pagenow}">
			</td>
		  <#if pagenow == pagetotal>
				<td>&nbsp;>&nbsp;</td>
				<td>&nbsp;>>&nbsp;</td>
		  <#else>
				<td>
					<a href="/${kind}/${step}/${pagenow + 1}">&nbsp;>&nbsp;</a>
				</td>
				<td>
					<a href="/${kind}/${step}/${pagetotal}">&nbsp;>>&nbsp;</a>
				</td>
		  </#if>
			<td>
				<input type="text" class="onlydigit" id="step" value="${step}">
				&nbsp;rows&nbsp;/&nbsp;page
				<input type="hidden" id="hidden_kind" value="${kind}">
				<input type="hidden" id="hidden_step" value="${step}">
				<input type="hidden" id="hidden_count" value="${count}">
			</td>
		</tr>
	</table>

  <#if user??>
    <#if profileUser?? && userId != profileUserId>
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
        <form id="messageForm" action="/message" method="post">
          <p>
          <input type="text" name="text">
          <p>
          <input type="submit" value="Share">
        </form>
      </div>
    </#if>
  </#if>
	
  <ul class="messages">
    <#if messages??>
      <#list messages as message>
  		  <li>
  		    <img src="${message.gravatar}">
  		    <p>
  		    <strong>
  		      <a href="/t/${message.username}">${message.username}</a>
  		    </strong>
  		    ${message.text}
  		    <small>&mdash; ${message.pubDateStr}</small>
  		  </li>
      </#list>
	  <#else>
		  <li>
		    <em>There're no messages so far.</em>
		  </li>
		</#if>
	</ul>

  <script type="text/javascript" src="/js/timeline.js"></script>
</@layout.masterTemplate>
