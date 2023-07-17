function appendMessage(sender, message) {
	const chatLog = document.getElementById("chatLog");
	const messageDiv = document.createElement("div");
	messageDiv.classList.add("chat-messages");
	messageDiv.innerHTML = `<strong>${sender}: </strong>${message}`;
	chatLog.appendChild(messageDiv);

}

function changeFormat(data) {

appendMessage("BOT", data);
}

function sendMessage() {
	console.log("Method is calling");
	const userMessage = document.getElementById("userMessage").value;
	const user = document.getElementById("user").value;
	appendMessage("You", userMessage);

	// Create a JSON object with the collected data
	const jsonData = {
		"chatMessages": [{
			"role": user,
			"content": userMessage
		}]
	};

	// Convert JSON object to a string
	const jsonString = JSON.stringify(jsonData);

	// URL of the Spring Boot API endpoint
	const url = "/chat";


	// Options for the fetch API (specify method, headers, body, etc.)
	const requestOptions = {
		method: "POST",
		headers: {
			"Content-Type": "application/json"
		},
		body: jsonString
	};


	// Make the POST request using the fetch API
	fetch(url, requestOptions)
		.then(response => response.text())
		.then(data => {
			console.log("Response from server:", data);

			/*appendMessage("BOT", data);*/
			changeFormat(data);
			// You can handle the response data here
		})
		.catch(error => {
			console.error("Error:", error);
			// Handle any errors that occurred during the request
		});

	// Clear the input field after sending the message
	document.getElementById("userMessage").value = "";

}