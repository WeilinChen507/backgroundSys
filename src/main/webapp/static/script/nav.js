
$(function() {
	var showLeftNav = true;
	$('#nav_slide_btn').click(function() {
		if (showLeftNav) {
			$('#content_body').animate({'left':'0'});
			$('#left_nav').animate({'left':'-2rem'});
			showLeftNav = false;
		} else {
			$('#left_nav').animate({'left':'0'});
			$('#content_body').animate({'left':'2rem'});
			showLeftNav = true;
		}
	})
})