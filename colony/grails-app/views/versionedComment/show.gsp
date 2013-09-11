
<%@ page import="colony.VersionedComment" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'versionedComment.label', default: 'VersionedComment')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-versionedComment" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-versionedComment" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list versionedComment">
			
				<g:if test="${versionedCommentInstance?.content}">
				<li class="fieldcontain">
					<span id="content-label" class="property-label"><g:message code="versionedComment.content.label" default="Content" /></span>
					
						<span class="property-value" aria-labelledby="content-label"><g:fieldValue bean="${versionedCommentInstance}" field="content"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${versionedCommentInstance?.created}">
				<li class="fieldcontain">
					<span id="created-label" class="property-label"><g:message code="versionedComment.created.label" default="Created" /></span>
					
						<span class="property-value" aria-labelledby="created-label"><g:formatDate date="${versionedCommentInstance?.created}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${versionedCommentInstance?.previous}">
				<li class="fieldcontain">
					<span id="previous-label" class="property-label"><g:message code="versionedComment.previous.label" default="Previous" /></span>
					
						<span class="property-value" aria-labelledby="previous-label"><g:link controller="versionedComment" action="show" id="${versionedCommentInstance?.previous?.id}">${versionedCommentInstance?.previous?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${versionedCommentInstance?.comment}">
				<li class="fieldcontain">
					<span id="comment-label" class="property-label"><g:message code="versionedComment.comment.label" default="Comment" /></span>
					
						<span class="property-value" aria-labelledby="comment-label"><g:link controller="comment" action="show" id="${versionedCommentInstance?.comment?.id}">${versionedCommentInstance?.comment?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${versionedCommentInstance?.id}" />
					<g:link class="edit" action="edit" id="${versionedCommentInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
