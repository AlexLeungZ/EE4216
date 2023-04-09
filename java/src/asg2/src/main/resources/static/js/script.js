var app = new Vue({
	el: "#app",
	data: {
		rows: [],
		editForm: {
			id: "",
			name: "",
			done: false,
			timer: 0,
		},
		hideDone: false,
		showInput: false,
		newName: "",
	},
	async mounted() {
		await this.getTodo();
	},
	methods: {
		async getTodo() {
			const res = await fetch("http://192.168.10.182:3008/api/todo");
			const json = await res.json();
			this.rows = this.hideDone ? json.filter(({ done }) => done === false) : json;
			this.rows.forEach((row) => (row.status = row.done ? "Completed" : "Pending"));
		},

		async reloadTodo(status, fullReload = false) {
			if (status === 200) await this.getTodo();
			if (fullReload) location.reload();
		},

		async toggleHideDone() {
			this.reloadTodo(200, false);
			this.hideDone = !this.hideDone;
		},

		editTodo(row) {
			this.editForm.id = row.id;
			this.editForm.name = row.name;
			this.editForm.done = row.done;
			this.editForm.timer = row.timer;
		},

		async addTodo(name) {
			const settings = {
				method: "POST",
				headers: { Accept: "application/json", "Content-Type": "application/json" },
				body: JSON.stringify({ name: name }),
			};

			const post = await fetch("http://192.168.10.182:3008/api/todo", settings);
			await this.reloadTodo(post.status, false);
		},

		async toggleStatus(row) {
			const settings = {
				method: "PUT",
				headers: { Accept: "application/json", "Content-Type": "application/json" },
				body: JSON.stringify({ ...row, done: !row.done }),
			};

			const put = await fetch(`http://192.168.10.182:3008/api/todo/${row.id}`, settings);
			await this.reloadTodo(put.status, false);
		},

		async saveTodo() {
			const settings = {
				method: "PUT",
				headers: { Accept: "application/json", "Content-Type": "application/json" },
				body: JSON.stringify(this.editForm),
			};

			const put = await fetch(`http://192.168.10.182:3008/api/todo/${this.editForm.id}`, settings);
			await this.reloadTodo(put.status, true);
		},

		async deleteTodo(row) {
			const settings = {
				method: "DELETE",
			};

			const del = await fetch(`http://192.168.10.182:3008/api/todo/${row.id}`, settings);
			await this.reloadTodo(del.status, false);
		},
	},
});
