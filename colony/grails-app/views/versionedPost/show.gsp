
<%@ page import="colony.VersionedPost" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'versionedPost.label', default: 'VersionedPost')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-versionedPost" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-versionedPost" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list versionedPost">
			
				<g:if test="${versionedPostInstance?.content}">
				<li class="fieldcontain">
					<span id="content-label" class="property-label"><g:message code="versionedPost.content.label" default="Content" /></span>
					
						<span class="property-value" aria-labelledby="content-label"><g:fieldValue bean="${versionedPostInstance}" field="content"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${versionedPostInstance?.created}">
				<li class="fieldcontain">
					<span id="created-label" class="property-label"><g:message code="versionedPost.created.label" default="Created" /></span>
					
						<span class="property-value" aria-labelledby="created-label"><g:formatDate date="${versionedPostInstance?.created}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${versionedPostInstance?.previous}">
				<li class="fieldcontain">
					<span id="previous-label" class="property-label"><g:message code="versionedPost.previous.label" default="Previous" /></span>
					
						<span class="property-value" aria-labelledby="previous-label"><g:link controller="versionedPost" action="show" id="${versionedPostInstance?.previous?.id}">${versionedPostInstance?.previous?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${versionedPostInstance?.comments}">
				<li class="fieldcontain">
					<span id="comments-label" class="property-label"><g:message code="versionedPost.comments.label" default="Comments" /></span>
					
						<g:each in="${versionedPostInstance.comments}" var="c">
						<span class="property-value" aria-labelledby="comments-label"><g:link controller="comment" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${versionedPostInstance?.post}">
				<li class="fieldcontain">
					<span id="post-label" class="property-label"><g:message code="versionedPost.post.label" default="Post" /></span>
					
						<span class="property-value" aria-labelledby="post-label"><g:link controller="post" action="show" id="${versionedPostInstance?.post?.id}">${versionedPostInstance?.post?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${versionedPostInstance?.tags}">
				<li class="fieldcontain">
					<span id="tags-label" class="property-label"><g:message code="versionedPost.tags.label" default="Tags" /></span>
					
						<g:each in="${versionedPostInstance.tags}" var="t">
						<span class="property-value" aria-labelledby="tags-label"><g:link controller="tag" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${versionedPostInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="versionedPost.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${versionedPostInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${versionedPostInstance?.id}" />
					<g:link class="edit" action="edit" id="${versionedPostInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
