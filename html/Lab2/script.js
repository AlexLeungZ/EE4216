var app = new Vue({
	el: "#app",
	data: {
		asc: 1,
		active: {},
		arrow: {
			arrow: true,
			asc: true,
			dsc: false,
		},
		columns: {
			id: "ID",
			name: "Full Name",
			phone: "Phone",
		},
		rows: [
			{ id: 1, name: "Test Name 1", phone: "123-456-7890" },
			{ id: 2, name: "Test Name 2", phone: "123-456-7891" },
			{ id: 3, name: "Test Name 3", phone: "123-456-7892" },
		],
	},
	methods: {
		sortData() {
			prop = this.active;
			this.rows.sort((a, b) => this.asc * (a[prop] > b[prop] ? -1 : 1));
			this.arrow.asc = !this.arrow.asc;
			this.arrow.dsc = !this.arrow.dsc;
			this.asc = -1 * this.asc;
		},
	},
	// Checkpoint 2
	beforeCreate: async function () {
		const response = await fetch("https://jsonplaceholder.typicode.com/users");
		const json = await response.json();

		const subset = json.map(({ id, name, phone }) => ({ id, name, phone }));
		this.rows = subset;
	},
});
