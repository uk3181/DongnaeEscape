// 타이머 설정

class Timer {
	constructor(leftTimeLi) {
		// 세션 스토리지에 각 플래그 값이 저장되지 않으면 값을 지정함.
		if (sessionStorage.getItem("openedMessageTime") == null) {
			// 세션 스토리지의 각 아이템을 설정함.
			this.setSessionStorageItems();
		}

		// 남은 시간을 나타내는 li
		this.leftTimeLi = leftTimeLi;
	}
	
	// 세션 스토리지의 각 아이템을 설정하는 메소드
	setSessionStorageItems() {
		// 시간 압박 대사를 띄운 시간(초 단위)을 기록함.
		sessionStorage.setItem("openedMessageTime", -1);
		// 현재 시간 압박 대사가 띄워져 있는지 확인함.
		sessionStorage.setItem("isOpenedMessage", false);

		// 각 남은 시간 구간별 시간 압박 대사를 띄운 기록이 있는지 확인함.
		sessionStorage.setItem("openedMessageIn30Minutes", false); // 30분 이하
		sessionStorage.setItem("openedMessageIn20Minutes", false); // 20분 이하
		sessionStorage.setItem("openedMessageIn10Minutes", false); // 10분 이하
		sessionStorage.setItem("openedMessageIn5Minutes", false); // 5분 이하
		sessionStorage.setItem("openedMessageIn1Minute", false); // 1분 이하
	}
	
	// 남은 시간을 1초 감소하는 메소드
	decrease1Second() {
		// 남은 분
		var leftMinutes = parseInt(this.leftTimeLi.textContent.slice(7, 9));
		// 남은 초
		var leftSeconds = parseInt(this.leftTimeLi.textContent.slice(10));
		
		// 전체 남은 시간을 초로 환산한 값
		var allLeftSeconds = leftMinutes * 60 + leftSeconds;
		// 전체 남은 시간을 1초 감소
		allLeftSeconds--;
		
		// 남은 분과 초 재설정
		leftMinutes = Math.trunc(allLeftSeconds / 60);
		leftSeconds = allLeftSeconds % 60;
		
		// 남은 시간 li 재설정
		this.leftTimeLi.textContent = "남은 시간: "
				+ this.getLeftMinutesString(leftMinutes) + ":"
				+ this.getLeftSecondsString(leftSeconds);
				
		return allLeftSeconds;
	}
	
	// 남은 분을 문자열로 반환하는 메소드
	getLeftMinutesString(leftMinutes) {
		var leftMinutesString = leftMinutes.toString();
		if (leftMinutes < 10) // 남은 분을 두 자리로 맞춤.
			leftMinutesString = "0" + leftMinutesString;
		return leftMinutesString
	}
	
	// 남은 초를 문자열로 반환하는 메소드
	getLeftSecondsString(leftSeconds) {
		var leftSecondsString = leftSeconds.toString();
		if (leftSeconds < 10) // 남은 초를 두 자리로 맞춤.
			leftSecondsString = "0" + leftSecondsString;
		return leftSecondsString;
	}
	
	// 타이머를 실행하는 메소드
	executeTimer() {
		var intervalId = setInterval(() => {
			var leftSeconds = this.decrease1Second();
			fetch("save-timer", {
		    	method: "POST",
		    	headers: {
		        	"Content-Type": "application/x-www-form-urlencoded"
		    	},
		    	body: "left_seconds=" + leftSeconds
			});
			// 남은 시간 30분 이하
			if (leftSeconds > 20 * 60 && leftSeconds <= 30 * 60) {
				this.manageLeftTimeMessage(
					"openedMessageIn30Minutes",
					"아직은 여유 있지만 오래 머무르면 위험해요.",
					leftSeconds
				);
			}
			// 남은 시간 20분 이하
			if (leftSeconds > 10 * 60 && leftSeconds <= 20 * 60) {
				this.manageLeftTimeMessage(
					"openedMessageIn20Minutes",
					"데이터 손상이 빨라지고 있어요.",
					leftSeconds
				);
			}
			// 남은 시간 10분 이하
			if (leftSeconds > 5 * 60 && leftSeconds <= 10 * 60) {
				this.manageLeftTimeMessage(
					"openedMessageIn10Minutes",
					"붕괴 임박입니다. 서둘러야 해요.",
					leftSeconds
				);
			}
			// 남은 시간 5분 이하
			if (leftSeconds > 1 * 60 && leftSeconds <= 5 * 60) {
				this.manageLeftTimeMessage(
					"openedMessageIn5Minutes",
					"시간이 거의 없습니다!",
					leftSeconds
				);
			}
			// 남은 시간 1분 이하
			if (leftSeconds <= 1 * 60) {
				this.manageLeftTimeMessage(
					"openedMessageIn1Minute",
					"지금 입력하세요!",
					leftSeconds
				);
			}
			// 남은 시간이 0초 이하면 타이머를 종료함. (시간 압박 대사가 띄워져 있을 경우 해당 대사를 숨김.)
			if (leftSeconds <= 0) {
				clearInterval(intervalId);
				this.hideLeftTimeMessage();
				sessionStorage.setItem("isOpenedMessage", false);
				this.leftTimeLi.textContent = "남은 시간: 00:00";
				window.location.href = "goto-ending?successful=false";
			}
		}, 1000);
	}
	
	// 시간 압박 대사의 열고 숨기기를 관리하는 메소드
	manageLeftTimeMessage(recordName, message, leftSeconds) {
		// 시간 압박 대사를 띄운 적이 없음.
		if (sessionStorage.getItem(recordName) == "false") {
			this.showLeftTimeMessage(message);
			sessionStorage.setItem("isOpenedMessage", true);
			sessionStorage.setItem(recordName, true);
			sessionStorage.setItem("openedMessageTime", leftSeconds);
		}
		// 현재 시간 압박 대사가 띄워져 있고, 해당 대사가 띄워진 후 5초가 지남.
		else if (sessionStorage.getItem("isOpenedMessage") == "true"
				&& leftSeconds <= parseInt(sessionStorage.getItem("openedMessageTime")) - 5) {
			this.hideLeftTimeMessage();
			sessionStorage.setItem("isOpenedMessage", false);
		}
	}
	
	// 시간 압박 대사를 띄우는 메소드
	showLeftTimeMessage(textContent) {
		var leftTimeLabel = parent.document.createElement("label");
		leftTimeLabel.className = "left-time-label";
		leftTimeLabel.textContent = textContent;
		parent.document.body.appendChild(leftTimeLabel);

		// 스타일 설정
		Object.assign(leftTimeLabel.style, {
			position: "fixed",
			top: "75px",
			left: "50%",
			transform: "translate(-50%, -15px)", // 위쪽에서 살짝 내려오며 등장 준비
			opacity: "0",
			padding: "13px 26px",
			background: "rgba(15, 18, 23, 0.88)",
			color: "rgba(245, 241, 232, 0.95)",
			border: "1px solid rgba(225, 205, 170, 0.4)",
			borderRadius: "6px",
			boxShadow: "0 10px 30px rgba(0, 0, 0, 0.6), inset 0 0 15px rgba(255, 225, 180, 0.04)",
			backdropFilter: "blur(6px)",
			fontFamily: '"Noto Sans KR", sans-serif',
			fontSize: "15px",
			fontWeight: "500",
			letterSpacing: "1.5px",
			zIndex: "9999",
			transition: "opacity 0.4s ease, transform 0.4s cubic-bezier(0.16, 1, 0.3, 1)",
			pointerEvents: "none"
		});
		
		// 시간 압박 SFX 재생
		var leftTimeSfxAudio = parent.document.createElement("audio");
		leftTimeSfxAudio.src = "assets/sounds/sfxs/left_time_sfx.mp3";
		leftTimeSfxAudio.play();
		
		setTimeout(() => {
			leftTimeLabel.style.transform = "translate(-50%, 0)";
			leftTimeLabel.style.opacity = "1";
		}, 20);
	}
	
	// 시간 압박 대사를 숨기는 메소드
	hideLeftTimeMessage() {
		var leftTimeLabels = parent.document.getElementsByClassName("left-time-label");
		
		for (var i = 0; i < leftTimeLabels.length; i++) {
			var leftTimeLabel = leftTimeLabels[i];
			leftTimeLabel.style.opacity = "0";
			leftTimeLabel.style.transform = "translate(-50%, -15px)";
			setTimeout(() => {
				leftTimeLabel.remove();
			}, 400); // 애니메이션 끝난 뒤 DOM 제거
		}
	}
}

var timer = new Timer(document.getElementsByClassName("left-time")[0]);
// 타이머 실행
timer.executeTimer();