
<%@ page import="colony.Member" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'member.label', default: 'Member')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-member" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-member" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list member">
			
				<g:if test="${memberInstance?.username}">
				<li class="fieldcontain">
					<span id="username-label" class="property-label"><g:message code="member.username.label" default="Username" /></span>
					
						<span class="property-value" aria-labelledby="username-label"><g:fieldValue bean="${memberInstance}" field="username"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${memberInstance?.password}">
				<li class="fieldcontain">
					<span id="password-label" class="property-label"><g:message code="member.password.label" default="Password" /></span>
					
						<span class="property-value" aria-labelledby="password-label"><g:fieldValue bean="${memberInstance}" field="password"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${memberInstance?.nickname}">
				<li class="fieldcontain">
					<span id="nickname-label" class="property-label"><g:message code="member.nickname.label" default="Nickname" /></span>
					
						<span class="property-value" aria-labelledby="nickname-label"><g:fieldValue bean="${memberInstance}" field="nickname"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${memberInstance?.fullname}">
				<li class="fieldcontain">
					<span id="fullname-label" class="property-label"><g:message code="member.fullname.label" default="Fullname" /></span>
					
						<span class="property-value" aria-labelledby="fullname-label"><g:fieldValue bean="${memberInstance}" field="fullname"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${memberInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="member.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${memberInstance}" field="email"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${memberInstance?.enabled}">
				<li class="fieldcontain">
					<span id="enabled-label" class="property-label"><g:message code="member.enabled.label" default="Enabled" /></span>
					
						<span class="property-value" aria-labelledby="enabled-label"><g:formatBoolean boolean="${memberInstance?.enabled}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${memberInstance?.accountExpired}">
				<li class="fieldcontain">
					<span id="accountExpired-label" class="property-label"><g:message code="member.accountExpired.label" default="Account Expired" /></span>
					
						<span class="property-value" aria-labelledby="accountExpired-label"><g:formatBoolean boolean="${memberInstance?.accountExpired}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${memberInstance?.accountLocked}">
				<li class="fieldcontain">
					<span id="accountLocked-label" class="property-label"><g:message code="member.accountLocked.label" default="Account Locked" /></span>
					
						<span class="property-value" aria-labelledby="accountLocked-label"><g:formatBoolean boolean="${memberInstance?.accountLocked}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${memberInstance?.passwordExpired}">
				<li class="fieldcontain">
					<span id="passwordExpired-label" class="property-label"><g:message code="member.passwordExpired.label" default="Password Expired" /></span>
					
						<span class="property-value" aria-labelledby="passwordExpired-label"><g:formatBoolean boolean="${memberInstance?.passwordExpired}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${memberInstance?.created}">
				<li class="fieldcontain">
					<span id="created-label" class="property-label"><g:message code="member.created.label" default="Created" /></span>
					
						<span class="property-value" aria-labelledby="created-label"><g:formatDate date="${memberInstance?.created}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${memberInstance?.lastLogin}">
				<li class="fieldcontain">
					<span id="lastLogin-label" class="property-label"><g:message code="member.lastLogin.label" default="Last Login" /></span>
					
						<span class="property-value" aria-labelledby="lastLogin-label"><g:formatDate date="${memberInstance?.lastLogin}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${memberInstance?.posts}">
				<li class="fieldcontain">
					<span id="posts-label" class="property-label"><g:message code="member.posts.label" default="Posts" /></span>
					
						<g:each in="${memberInstance.posts}" var="p">
						<span class="property-value" aria-labelledby="posts-label"><g:link controller="post" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${memberInstance?.id}" />
					<g:link class="edit" action="edit" id="${memberInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
