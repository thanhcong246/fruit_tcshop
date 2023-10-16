/**
 * phóng to hình ảnh
 */

// Mở modal
function openModal(imageSrc) {
	var modal = document.getElementById('imageModal');
	var modalImg = document.getElementById('modalImage');
	modal.style.display = 'block';

	// Đặt hình ảnh placeholder ban đầu
	modalImg.src = '/path/to/placeholder.jpg';

	// Tạo một hình ảnh mới để tải hình ảnh thực tế
	var realImage = new Image();
	realImage.src = imageSrc;

	// Đợi cho hình ảnh thực tế tải xong
	realImage.onload = function() {
		modalImg.src = imageSrc; // Đặt hình ảnh thực tế
	};
}

// Đóng modal
function closeModal() {
	var modal = document.getElementById('imageModal');
	modal.style.display = 'none';
}

/*------------------*/