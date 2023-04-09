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
		curPage: 1,
		itemLim: 5,
	},
	async mounted() {
		await this.getTodo();
	},
	computed: {
		// Get row by slicing with start and end
		displayedTask: function () {
			const start = (this.curPage - 1) * this.itemLim;
			const end = start + this.itemLim;
			return this.rows.slice(start, end);
		},
		// Get total number of pages
		pageCount: function () {
			return Math.ceil(this.rows.length / this.itemLim);
		},
		// Get page number
		pageNumbers: function () {
			const numbers = [];
			for (let i = 1; i <= this.pageCount; i++) numbers.push(i);
			return numbers;
		},
	},
	methods: {
		// Get all tasks, filter by done status if needed
		async getTodo() {
			const res = await fetch("http://192.168.10.182:3008/api/todo");
			const json = await res.json();
			this.rows = this.hideDone ? json.filter(({ done }) => done === false) : json;
			this.rows.forEach((row) => (row.status = row.done ? "Completed" : "Pending"));
		},

		// Reload the list
		async reloadTodo(status, fullReload = false) {
			if (status === 200) await this.getTodo();
			if (fullReload) location.reload();
		},

		// Show or hide task by done status
		async toggleHideDone() {
			this.reloadTodo(200, false);
			this.hideDone = !this.hideDone;
		},

		// Set the current page number
		setPage(pageNumber) {
			this.curPage = pageNumber;
		},

		// Edit task
		editTodo(row) {
			this.editForm.id = row.id;
			this.editForm.name = row.name;
			this.editForm.done = row.done;
			this.editForm.timer = row.timer;
		},

		// Add new task
		async addTodo(name) {
			const settings = {
				method: "POST",
				headers: { Accept: "application/json", "Content-Type": "application/json" },
				body: JSON.stringify({ name: name }),
			};

			const post = await fetch("http://192.168.10.182:3008/api/todo", settings);
			await this.reloadTodo(post.status, false);
		},

		// Toggle done status of task
		async toggleStatus(row) {
			const settings = {
				method: "PUT",
				headers: { Accept: "application/json", "Content-Type": "application/json" },
				body: JSON.stringify({ ...row, done: !row.done }),
			};

			const put = await fetch(`http://192.168.10.182:3008/api/todo/${row.id}`, settings);
			await this.reloadTodo(put.status, false);
		},

		// Save task
		async saveTodo() {
			const settings = {
				method: "PUT",
				headers: { Accept: "application/json", "Content-Type": "application/json" },
				body: JSON.stringify(this.editForm),
			};

			const put = await fetch(`http://192.168.10.182:3008/api/todo/${this.editForm.id}`, settings);
			await this.reloadTodo(put.status, true);
		},

		// Delete task
		async deleteTodo(row) {
			const settings = {
				method: "DELETE",
			};

			const del = await fetch(`http://192.168.10.182:3008/api/todo/${row.id}`, settings);
			await this.reloadTodo(del.status, false);
		},
	},
});
