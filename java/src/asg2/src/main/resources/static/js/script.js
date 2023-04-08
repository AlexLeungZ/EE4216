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
		await this.getTodo();
	},
	methods: {
		async getTodo() {
			const res = await fetch("http://192.168.10.182:3008/api/todo");
			const json = await res.json();
			this.rows = json;
		},

		editTodo(row) {
			this.editForm.id = row.id;
			this.editForm.name = row.name;
			this.editForm.done = row.done;
		},

		async saveTodo() {
			const settings = {
				method: "PUT",
				headers: { Accept: "application/json", "Content-Type": "application/json" },
				body: JSON.stringify(this.editForm),
			};

			const post = await fetch(`http://192.168.10.182:3008/api/todo/${this.editForm.id}`, settings);
			await this.reloadRow(post.status);
			location.reload();
		},

		async deleteTodo(row) {
			const settings = {
				method: "DELETE",
			};

			const del = await fetch(`http://192.168.10.182:3008/api/todo/${row.id}`, settings);
			await this.reloadRow(del.status);
		},

		async reloadRow(status) {
			if (status === 200) {
				const res = await fetch("http://192.168.10.182:3008/api/todo");
				const json = await res.json();
				this.rows = json;
			}
		},
	},
});
