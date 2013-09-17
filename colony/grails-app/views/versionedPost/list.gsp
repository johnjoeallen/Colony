
<%@ page import="colony.VersionedPost" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'versionedPost.label', default: 'VersionedPost')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-versionedPost" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-versionedPost" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="content" title="${message(code: 'versionedPost.content.label', default: 'Content')}" />
					
						<g:sortableColumn property="created" title="${message(code: 'versionedPost.created.label', default: 'Created')}" />
					
						<th><g:message code="versionedPost.previous.label" default="Previous" /></th>
					
						<th><g:message code="versionedPost.member.label" default="Member" /></th>
					
						<g:sortableColumn property="title" title="${message(code: 'versionedPost.title.label', default: 'Title')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${versionedPostInstanceList}" status="i" var="versionedPostInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${versionedPostInstance.id}">${fieldValue(bean: versionedPostInstance, field: "content")}</g:link></td>
					
						<td><g:formatDate date="${versionedPostInstance.created}" /></td>
					
						<td>${fieldValue(bean: versionedPostInstance, field: "previous")}</td>
					
						<td>${fieldValue(bean: versionedPostInstance, field: "member")}</td>
					
						<td>${fieldValue(bean: versionedPostInstance, field: "title")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${versionedPostInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
