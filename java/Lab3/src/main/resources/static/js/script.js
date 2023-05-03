var app = new Vue({
	el: "#app",
	data: {
		rows: [],
		editForm: {
			id: "",
			name: "",
			year: "",
			rank: 0.0,
		},
	},
	async mounted() {
		this.getMovies();
	},
	methods: {
		getMovies() {
			fetch("http://192.168.10.182:3008/api/movies").then((response) => {
				response.json().then((data) => {
					console.log(data);
					app.rows = data.map((movie) => {
						return {
							id: movie.id,
							year: movie.year,
							name: movie.name,
							rank: movie.rank.toFixed(1),
						};
					});
				});
			});
		},
		editMovie(movie) {
			this.editForm.id = movie.id;
			this.editForm.year = movie.year;
			this.editForm.name = movie.name;
			this.editForm.rank = movie.rank;
		},
		saveMovie() {
			fetch(`http://192.168.10.182:3008/api/movies/${this.editForm.id}`, {
				method: "PUT",
				headers: {
					"Content-Type": "application/json",
				},
				body: JSON.stringify(this.editForm),
			}).then((response) => {
				if (response.status == 200) {
					this.getMovies();
				}
			});
		},
		deleteMovie(movie) {
			fetch("http://192.168.10.182:3008/api/movies/" + movie.id, {
				method: "DELETE",
			}).then((response) => {
				if (response.status == 200) {
					this.getMovies();
				}
			});
		},
	},
});
