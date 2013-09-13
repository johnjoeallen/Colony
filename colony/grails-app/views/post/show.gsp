
<%@ page import="colony.Post" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'post.label', default: 'Post')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-post" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-post" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list post">
			
				<g:if test="${postInstance?.type}">
				<li class="fieldcontain">
					<span id="type-label" class="property-label"><g:message code="post.type.label" default="Type" /></span>
					
						<span class="property-value" aria-labelledby="type-label"><g:fieldValue bean="${postInstance}" field="type"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${postInstance?.current}">
				<li class="fieldcontain">
					<span id="current-label" class="property-label"><g:message code="post.current.label" default="Current" /></span>
					
						<span class="property-value" aria-labelledby="current-label"><g:link controller="versionedPost" action="show" id="${postInstance?.current?.id}">${postInstance?.current?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${postInstance?.member}">
				<li class="fieldcontain">
					<span id="member-label" class="property-label"><g:message code="post.member.label" default="Member" /></span>
					
						<span class="property-value" aria-labelledby="member-label"><g:link controller="member" action="show" id="${postInstance?.member?.id}">${postInstance?.member?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${postInstance?.id}" />
					<g:link class="edit" action="edit" id="${postInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
