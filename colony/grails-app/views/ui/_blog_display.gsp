<div class="posts">
	<h2>${current.title}</h2>
	<span class="posts author title">by ${post.member.fullname}, ${current.created}</span>
	<div class="postbody">
		<markdown:renderHtml>${current.content}</markdown:renderHtml>
	</div>
</div>