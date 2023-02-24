const imageLink = [
	"https://images.pexels.com/photos/302769/pexels-photo-302769.jpeg",
	"https://images.pexels.com/photos/323705/pexels-photo-323705.jpeg",
];

const modalDisplay = () => {
	var x = document.getElementById("myModal");
	x.style.display = "flex";
};

const modalClose = () => {
	var x = document.getElementById("myModal");
	x.style.display = "none";
};

const modalDisplayImg = (id) => {
	var x = document.getElementById("myModalImg");
	x.style.display = "flex";

	x.getElementsByTagName("img")[0].src = imageLink[id];
};

const modalCloseImg = () => {
	var x = document.getElementById("myModalImg");
	x.style.display = "none";
};
