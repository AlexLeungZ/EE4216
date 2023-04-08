var app = new Vue({
	el: "#app",
	data: {
		rows: [],
		editForm: {
			id: "",
			name: "",
			done: false,
		},
	},
	async mounted() {
		this.getTodo();
	},
	methods: {
		getTodo() {
			fetch("http://192.168.10.182:3008/api/todo").then((response) => {
				response.json().then((data) => {
					console.log(data);
					app.rows = data.map((movie) => {
						return {
							id: movie.id,
							name: movie.name,
							done: movie.done,
						};
					});
				});
			});
		},
	},
});
