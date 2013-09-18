<%@ page import="colony.Member" %>



<div class="fieldcontain ${hasErrors(bean: memberInstance, field: 'username', 'error')} required">
	<label for="username">
		<g:message code="member.username.label" default="Username" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="username" required="" value="${memberInstance?.username}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: memberInstance, field: 'password', 'error')} ">
	<label for="password">
		<g:message code="member.password.label" default="Password" />
		
	</label>
	<g:textField name="password" value="${memberInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: memberInstance, field: 'nickname', 'error')} ">
	<label for="nickname">
		<g:message code="member.nickname.label" default="Nickname" />
		
	</label>
	<g:textField name="nickname" value="${memberInstance?.nickname}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: memberInstance, field: 'fullname', 'error')} ">
	<label for="fullname">
		<g:message code="member.fullname.label" default="Fullname" />
		
	</label>
	<g:textField name="fullname" value="${memberInstance?.fullname}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: memberInstance, field: 'email', 'error')} ">
	<label for="email">
		<g:message code="member.email.label" default="Email" />
		
	</label>
	<g:textField name="email" value="${memberInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: memberInstance, field: 'enabled', 'error')} ">
	<label for="enabled">
		<g:message code="member.enabled.label" default="Enabled" />
		
	</label>
	<g:checkBox name="enabled" value="${memberInstance?.enabled}" />
</div>

<div class="fieldcontain ${hasErrors(bean: memberInstance, field: 'accountExpired', 'error')} ">
	<label for="accountExpired">
		<g:message code="member.accountExpired.label" default="Account Expired" />
		
	</label>
	<g:checkBox name="accountExpired" value="${memberInstance?.accountExpired}" />
</div>

<div class="fieldcontain ${hasErrors(bean: memberInstance, field: 'accountLocked', 'error')} ">
	<label for="accountLocked">
		<g:message code="member.accountLocked.label" default="Account Locked" />
		
	</label>
	<g:checkBox name="accountLocked" value="${memberInstance?.accountLocked}" />
</div>

<div class="fieldcontain ${hasErrors(bean: memberInstance, field: 'passwordExpired', 'error')} ">
	<label for="passwordExpired">
		<g:message code="member.passwordExpired.label" default="Password Expired" />
		
	</label>
	<g:checkBox name="passwordExpired" value="${memberInstance?.passwordExpired}" />
</div>

<div class="fieldcontain ${hasErrors(bean: memberInstance, field: 'created', 'error')} required">
	<label for="created">
		<g:message code="member.created.label" default="Created" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="created" precision="day"  value="${memberInstance?.created}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: memberInstance, field: 'lastLogin', 'error')} required">
	<label for="lastLogin">
		<g:message code="member.lastLogin.label" default="Last Login" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="lastLogin" precision="day"  value="${memberInstance?.lastLogin}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: memberInstance, field: 'posts', 'error')} ">
	<label for="posts">
		<g:message code="member.posts.label" default="Posts" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${memberInstance?.posts?}" var="p">
    <li><g:link controller="post" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="post" action="create" params="['member.id': memberInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'post.label', default: 'Post')])}</g:link>
</li>
</ul>

</div>

