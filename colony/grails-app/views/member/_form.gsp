<%@ page import="colony.Member" %>



<div class="fieldcontain ${hasErrors(bean: memberInstance, field: 'created', 'error')} required">
	<label for="created">
		<g:message code="member.created.label" default="Created" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="created" precision="day"  value="${memberInstance?.created}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: memberInstance, field: 'fullname', 'error')} ">
	<label for="fullname">
		<g:message code="member.fullname.label" default="Fullname" />
		
	</label>
	<g:textField name="fullname" value="${memberInstance?.fullname}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: memberInstance, field: 'identity', 'error')} ">
	<label for="identity">
		<g:message code="member.identity.label" default="Identity" />
		
	</label>
	<g:textField name="identity" value="${memberInstance?.identity}"/>
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

