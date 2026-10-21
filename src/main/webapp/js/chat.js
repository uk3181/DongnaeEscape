// 채팅 메시지 클래스
class ChatMessage {
	constructor(systemMessageLabel, staffMessageLabel, playerMessageLabel) {
		// 시스템 메시지
		var systemMessage = systemMessageLabel.dataset.message;
		// 진행요원 메시지
		var staffMessage = staffMessageLabel.dataset.message;
		// 주인공 메시지
		var playerMessage = playerMessageLabel.dataset.message;
		
		if (systemMessage != "")
			this.showMessage(systemMessageLabel, systemMessage);
		if (staffMessage != "")
			this.showMessage(staffMessageLabel, staffMessage);
		if (playerMessage != "")
			this.showMessage(playerMessageLabel, playerMessage);
	}
	
	// 메시지 내용을 화면에 보여주는 메소드
	showMessage(messageLabel, message) {
		messageLabel.textContent = "";
		let messageIndex = 0;
		var intervalId = setInterval(() => {
			messageLabel.textContent += message[messageIndex];
			messageIndex++;
			if (messageIndex == message.length)
				clearInterval(intervalId);
		}, 12);
	}
}

new ChatMessage(
	document.getElementsByClassName("system-message")[0],
	document.getElementsByClassName("staff-message")[0],
	document.getElementsByClassName("player-message")[0]
);