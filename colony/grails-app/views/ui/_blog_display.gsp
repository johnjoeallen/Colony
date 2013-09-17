<div class="posts">
	<h2>${current.title}</h2>
	<span class="posts author title">${post.members.collect { k, v -> v.fullname }.join(", ")} in ${post.colonies.collect { k, v -> "<a href=\"@${v.name}\">${v.name}</a>" }.join(", ")} --  ${current.created}</span>
	<div class="postbody">
		<markdown:renderHtml>${current.content}</markdown:renderHtml>
	</div>
</div>