fetch('https://jsonplaceholder.typicode.com/posts')
	.then(function (response) {
		if (response.ok) {
			return response.json();
		} else {
			return Promise.reject({
				status: response.status,
				statusText: response.statusText
			});
		}
	})
	.then(function (posts) {
		//console.log('success', posts);
		return fetch('https://jsonplaceholder.typicode.com/users/' + posts[50].userId);
	})
	.then(function (response) {
		return response.json();
	})
	.then(function (user) {
		console.log(user.email);
	})
	.catch(function (error) {
		console.log('error', error);
	});