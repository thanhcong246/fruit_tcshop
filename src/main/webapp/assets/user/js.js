// Xử lý active
document.addEventListener("DOMContentLoaded", function() {
	var currentPageURL = window.location.pathname;
	var navLinks = document.querySelectorAll(".nav-link-active-category");

	navLinks.forEach(function(link) {
		var linkURL = link.querySelector('a').getAttribute("href");

		var categoryPatternCategory = /^\/fruit_shop\/san-pham\/category\/[0-9]+/; // category
		var currentPageCategory = currentPageURL.match(categoryPatternCategory);
		var linkCategory = linkURL.match(categoryPatternCategory);

		if (linkURL === currentPageURL || currentPageCategory && linkCategory && currentPageCategory[0] === linkCategory[0]) {
			link.classList.add("active");
		} else {
			link.classList.remove("active");
		}
	});
});
