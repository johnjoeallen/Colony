<!doctype html>
<!-- paulirish.com/2008/conditional-stylesheets-vs-css-hacks-answer-neither/ -->
<!--[if lt IE 7]> <html class="no-js ie6 oldie" lang="en"> <![endif]-->
<!--[if IE 7]>    <html class="no-js ie7 oldie" lang="en"> <![endif]-->
<!--[if IE 8]>    <html class="no-js ie8 oldie" lang="en"> <![endif]-->
<!--[if IE 9]>    <html class="no-js ie9" lang="en"> <![endif]-->
<!-- Consider adding an manifest.appcache: h5bp.com/d/Offline -->
<!--[if gt IE 9]><!--> <html class="no-js" lang="en" itemscope itemtype="http://schema.org/Product"> <!--<![endif]-->
<head>
	<meta charset="utf-8">

	<!-- Use the .htaccess and remove these lines to avoid edge case issues.
			 More info: h5bp.com/b/378 -->
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

	<title>Colony - social network</title>
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<meta name="author" content="humans.txt">

	<link rel="shortcut icon" href="images/favicon.png" type="image/x-icon" />

	<!-- Facebook Metadata /-->
	<meta property="fb:page_id" content="" />
	<meta property="og:image" content="" />
	<meta property="og:description" content=""/>
	<meta property="og:title" content=""/>

	<!-- Google+ Metadata /-->
	<meta itemprop="name" content="">
	<meta itemprop="description" content="">
	<meta itemprop="image" content="">

	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1">

	<!-- We highly recommend you use SASS and write your custom styles in sass/_custom.scss.
			 However, there is a blank style.css in the css directory should you prefer -->
	<link rel="stylesheet" href="/colony/components/gumby/css/gumby.css">
	<!-- <link rel="stylesheet" href="css/style.css"> -->

	<script src="/colony/components/gumby/js/libs/modernizr-2.6.2.min.js"></script>
</head>

<style>
	.btn,.drawer { margin-bottom:10px; }
	.drawer { text-align: center; }
	h1.lead { border-bottom: 1px dotted #ccc; margin-bottom: 30px; }
	h4.lead { margin-bottom:10px; }
	#icon_map ul li { font-size: 16px; }
	.smallify { font-size: 13px; }
	.modal h2, .modal .btn { margin: 5% 0 20px; }
	.content { margin-top: 60px; }
	.status { margin-top: 6px; }
	h1, h2, h3, h4, h5, h6 { 
		font-weight: 400; padding-bottom: 0px; color: rgb(51,51,50); }
	h1 { font-size: 1.5rem; }
	h2 { font-size: 1.3rem; }
	.posts { margin-bottom: 8px; color: rgb(51,51,50); }
	.posts.author.title { 
		font-size: .7rem; margin-bottom: 8px; padding-bottom: 8px; color: rgb(51,51,50); }
	.postbody {
		padding-left: 8px;
		#border-left: 1px dotted #ccc; 
		border-bottom: 1px dotted #ccc; 
		font-weight: normal; 
		font-size: .8rem; 
		color: rgb(51,51,50); }
	.postbody p { 
		font-weight: normal; font-size: .8rem; border-bottom: 0px; color: rgb(51,51,50); }
	.postbody ul { list-style-type: disc; }
	.postbody blockquote { font-style: italic; }
	.postbody cite { font-style: italic; font-size: .5rem}
	.navbar { min-height: 40px; }
</style>

<body>

	<div class="modal" id="modal1">
		<div class="content">
			<a class="close switch" gumby-trigger="|#modal1"><i class="icon-cancel" /></i></a>
			<div class="row">
				<div class="ten columns centered text-center">
					<h2>This is a modal.</h2>
					<p>Gumby modals are easy to make using Toggles &amp; Switches. The <span class="label default">.modal</span> class already has the required styles which you can open and close using Toggles &amp; Switches.</p>
				</div>
			</div>
		</div>
	</div>

	<div class="pretty navbar" gumby-fixed="top" id="nav3">
		<div class="row">
			<a class="toggle" gumby-trigger="#nav3 > .row > ul" href="#"><i class="icon-menu"></i></a>
			<h1 class="four columns logo">
				<a href="#">
					<img src="/colony/images/colony-logo.png" gumby-retina />
				</a>
			</h1>
			<ul class="eight columns">
				<li>
					<a href="#">New</a>
					<div class="dropdown">
						<ul>
							<li><a href="#">Status Message</a></li>
							<li><a href="#">Question</a></li>
							<li><a href="#">Post</a></li>
							<li><a href="#">Photo</a></li>
							<li><a href="#">Colony</a></li>
						</ul>
					</div>
				</li>
				<li><a href="#">Help</a></li>
				<li class="field"><input class="search input" type="search" placeholder="Search" /></li>
				<li><div class="pretty small primary btn"><a href="#">Login</a></div></li>
			</ul>
		</div>
	</div>

	<div class="content">
		<!-- 
		<div class="row">
		    <div class="fourteen columns">
		      <p>Welcome to Colony</p>
		    </div>
		</div>
		-->
		
		<div class="row">
			<div class="two columns">
				<p><b>COLONIES</b></p>
				<g:each in="${colonies}" var="colony">
					<p><a href="${createLink(controller: "ui", action: 'colony', params: [id: colony.id])}">${colony.name}</a></p>
				</g:each>
			</div>
			<div class="eight columns">
				<div class="row">
					<div class="eight columns centered text-center">
						<h1>${colony.name}</h1>
					</div>
				</div>
				
				<div class="row">
					<g:each in="${colony.posts}" var="post">
						<g:render template="${post.type.toLowerCase()+"_display"}" model="['post':post,'current':post.current]"/>
					</g:each>
				</div>
			</div>
			<div class="two columns">
				<p>Profile</p>
			</div>
		</div>
  	</div>
		
	<!-- Grab Google CDN's jQuery, fall back to local if offline -->
	<!-- 2.0 for modern browsers, 1.10 for .oldie -->
	<script>
	var oldieCheck = Boolean(document.getElementsByTagName('html')[0].className.match(/\soldie\s/g));
	if(!oldieCheck) {
	document.write('<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"><\/script>');
	} else {
	document.write('<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"><\/script>');
	}
	</script>
	<script>
	if(!window.jQuery) {
	if(!oldieCheck) {
	  document.write('<script src="components/gumby/js/libs/jquery-2.0.2.min.js"><\/script>');
	} else {
	  document.write('<script src="components/gumby/js/libs/jquery-1.10.1.min.js"><\/script>');
	}
	}
	</script>

	<!--
	Include gumby.js followed by UI modules.
	Or concatenate and minify into a single file
	<script src="components/gumby/js/libs/gumby.js"></script>
	<script src="components/gumby/js/libs/ui/gumby.retina.js"></script>
	<script src="components/gumby/js/libs/ui/gumby.fixed.js"></script>
	<script src="components/gumby/js/libs/ui/gumby.skiplink.js"></script>
	<script src="components/gumby/js/libs/ui/gumby.toggleswitch.js"></script>
	<script src="components/gumby/js/libs/ui/gumby.checkbox.js"></script>
	<script src="components/gumby/js/libs/ui/gumby.radiobtn.js"></script>
	<script src="components/gumby/js/libs/ui/gumby.tabs.js"></script>
	<script src="components/gumby/js/libs/ui/gumby.navbar.js"></script>
	<script src="components/gumby/js/libs/ui/gumby.fittext.js"></script>
	<script src="components/gumby/js/libs/ui/jquery.validation.js"></script>
	<script src="components/gumby/js/libs/gumby.init.js"></script> -->

	<script src="/colony/components/gumby/js/libs/gumby.min.js"></script>
	<script src="/colony/components/gumby/js/plugins.js"></script>
	<script src="/colony/components/gumby/js/main.js"></script>

	<!-- Change UA-XXXXX-X to be your site's ID -->
	<!--<script>
	window._gaq = [['_setAccount','UAXXXXXXXX1'],['_trackPageview'],['_trackPageLoadTime']];
	Modernizr.load({
	  load: ('https:' == location.protocol ? '//ssl' : '//www') + '.google-analytics.com/ga.js'
	});
	</script>-->

	<!-- Prompt IE 6 users to install Chrome Frame. Remove this if you want to support IE 6.
	   chromium.org/developers/how-tos/chrome-frame-getting-started -->
	<!--[if lt IE 7 ]>
	<script src="//ajax.googleapis.com/ajax/libs/chrome-frame/1.0.3/CFInstall.min.js"></script>
	<script>window.attachEvent('onload',function(){CFInstall.check({mode:'overlay'})})</script>
	<![endif]-->

  </body>
</html>
