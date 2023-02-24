// Global variables
var lockBoard = false;

var flipCounter = 0;
var correctPairs = 0;
var clicks = 0;
var score = 0;
var finalScore = 0;

var card1, card2, card3;

var flipping = false;
var time = 0;
var coolDown = 0;

// Helper Functions - Update Score
const updateScore = (update) => {
	score += update;
	document.querySelector("#score").innerHTML = `Current score: ${score}`;
};

// Helper Functions - RNG
const getRandNum = (min, max) => Math.random() * (max - min) + min;

// Helper Functions - Shuffle Array
const shuffle = (array) => {
	for (var i = array.length - 1; i > 0; i--) {
		const j = Math.floor(Math.random() * (i + 1));
		[array[i], array[j]] = [array[j], array[i]];
	}

	return array;
};

// Helper Functions - Timer counter
const setTimer = () => {
	const date = new Date(0);
	date.setSeconds(++time);

	const timeStr = date.toISOString().substring(11, 19);
	document.querySelector("#timer").innerHTML = `Time elapse: ${timeStr}`;
};

// Helper Functions - Reset variables
const resetHelper = () => {
	flipping = false;
	flipCounter = 0;
	correctPairs = 0;
	clicks = 0;
	score = 0;
	time = 0;

	document.querySelector("#flips").innerHTML = `Card(s) flipped: ${flipCounter}`;
	document.querySelector("#score").innerHTML = `Current score: ${score}`;
	document.querySelector("#gameEnds").style.visibility = "hidden";
	if (coolDown) clearInterval(coolDown);
	resetCards();
};

// Helper Functions - Flip Cards
const flipCard = function () {
	if (flipping) return;
	if (this === card1 || this === card2) return;

	this.lastChild.classList.add("flip");
	document.querySelector("#flips").innerHTML = `Card(s) flipped: ${++flipCounter}`;

	switch (++clicks) {
		case 1:
			card1 = this;
			return;

		case 2:
			card2 = this;
			if (card1.dataset.id != card2.dataset.id) {
				updateScore(-1);
				coverCard();
			}
			return;

		case 3:
			card3 = this;
			if (card1.dataset.id != card3.dataset.id) {
				updateScore(-1);
				coverCard();
			} else {
				ifWin();
			}
			return;

		default:
			return;
	}
};

// Helper Functions - Desplay Winning Message
const ifWin = () => {
	updateScore(3);
	correctPairs++;
	clicks = 0;

	if (correctPairs == finalScore) {
		document.querySelector("#gameEnds").style.visibility = "visible";
		document.querySelector("#finalScore").innerHTML = `You scored ${score} points!`;
	}

	clearInterval(coolDown);
	resetCards();
};

// Helper Functions - Reset Card Status
const resetCards = () => {
	flipping = false;
	card1 = null;
	card2 = null;
	card3 = null;
};

// Helper Functions - Coveing Up the Cards
const coverCard = () => {
	clicks = 0;
	flipping = true;

	setTimeout(() => {
		if (card1) card1.lastChild.classList.remove("flip");
		if (card2) card2.lastChild.classList.remove("flip");
		if (card3) card3.lastChild.classList.remove("flip");
		resetCards();
	}, 700);
};

// Main Function - Start Game
const start = () => {
	resetHelper();

	if (document.querySelector("input").value > 10) document.getElementById("numTri").value = 10;
	finalScore = document.querySelector("input").value;
	const gameBody = document.querySelector("#gameBody");

	// Remove leftover cards
	while (gameBody.firstChild) gameBody.removeChild(gameBody.lastChild);

	// Generate triples
	var randomNums = [];
	for (var i = 0; i < finalScore; i++) randomNums.push(i, i, i);

	// Shuffle the cards
	randomNums = shuffle(randomNums);

	// Start placing the cards
	for (var i = 0; i < finalScore * 3; i++) {
		const outerDiv = document.createElement("div");
		const innerDiv = document.createElement("div");

		outerDiv.dataset.id = `${randomNums[i]}`;
		outerDiv.classList.add("card");
		innerDiv.classList.add("content");

		const newImg1 = document.createElement("img");
		newImg1.src = `./assets/${randomNums[i] + 1}.jpg`;
		newImg1.alt = `${i % 10}`;
		newImg1.classList.add("backFace");

		const newImg2 = document.createElement("img");
		newImg2.src = `./assets/back.jpg`;
		newImg2.alt = "2";
		newImg2.classList.add("frontFace");

		outerDiv.addEventListener("click", flipCard);
		innerDiv.appendChild(newImg1);
		innerDiv.appendChild(newImg2);
		outerDiv.appendChild(innerDiv);
		gameBody.appendChild(outerDiv);
	}

	// Append flipping function to all cards
	const cards = document.querySelectorAll("card");
	cards.forEach((card) => card.addEventListener("click", (event) => flipCard(event)));

	flipping = false;
	coolDown = setInterval(setTimer, 1000);
};
