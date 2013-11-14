
<%@ page import="colony.Colony" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'colony.label', default: 'Colony')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-colony" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-colony" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list colony">
			
				<g:if test="${colonyInstance?.created}">
				<li class="fieldcontain">
					<span id="created-label" class="property-label"><g:message code="colony.created.label" default="Created" /></span>
					
						<span class="property-value" aria-labelledby="created-label"><g:formatDate date="${colonyInstance?.created}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${colonyInstance?.open}">
				<li class="fieldcontain">
					<span id="open-label" class="property-label"><g:message code="colony.open.label" default="Open" /></span>
					
						<span class="property-value" aria-labelledby="open-label"><g:formatBoolean boolean="${colonyInstance?.open}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${colonyInstance?.contributors}">
				<li class="fieldcontain">
					<span id="contributors-label" class="property-label"><g:message code="colony.contributors.label" default="Contributors" /></span>
					
						<g:each in="${colonyInstance.contributors}" var="c">
						<span class="property-value" aria-labelledby="contributors-label"><g:link controller="member" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${colonyInstance?.entries}">
				<li class="fieldcontain">
					<span id="entries-label" class="property-label"><g:message code="colony.entries.label" default="Entries" /></span>
					
						<g:each in="${colonyInstance.entries}" var="e">
						<span class="property-value" aria-labelledby="entries-label"><g:link controller="entry" action="show" id="${e.id}">${e?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${colonyInstance?.followers}">
				<li class="fieldcontain">
					<span id="followers-label" class="property-label"><g:message code="colony.followers.label" default="Followers" /></span>
					
						<g:each in="${colonyInstance.followers}" var="f">
						<span class="property-value" aria-labelledby="followers-label"><g:link controller="member" action="show" id="${f.id}">${f?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${colonyInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="colony.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${colonyInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${colonyInstance?.id}" />
					<g:link class="edit" action="edit" id="${colonyInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
