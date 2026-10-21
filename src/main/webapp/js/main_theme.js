// 메인 화면 관련 코드

// 게임 시작 버튼
class StartButton {
	constructor(idEntry, startButton) {
		// ID를 입력하라는 메시지가 띄워져 있는지 확인하기 위한 필드
		this.isOpenedInputIdMessage = false;

		// 클릭 이벤트 처리
		startButton.addEventListener("click", () => {
			// 사용자가 입력한 ID
			var id = idEntry.value;
			if (id.length == 0) {
				// ID가 입력되지 않았을 경우 ID를 입력하라는 메시지를 띄움.
				this.showInputIdMessage();
				// 5초 후 ID를 입력하라는 메시지를 숨김.
				setTimeout(() => {
					this.hideInputIdMessage();
				}, 5000);
			}
			else {
				window.location.href = "start-game?id=" + id;
			}
		});
	}
	
	// ID를 입력하라는 메시지를 띄우는 메소드
	showInputIdMessage() {
		if (!this.isOpenedInputIdMessage) {
			this.isOpenedInputIdMessage = true;
			
			// ID를 입력하라는 메시지 레이블
			var inputIdMessageLabel = document.createElement("label");
			inputIdMessageLabel.className = "input-id-message";
			inputIdMessageLabel.textContent = "ID를 입력하세요.";
			document.body.appendChild(inputIdMessageLabel);
	
			// 스타일 설정
			Object.assign(inputIdMessageLabel.style, {
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
	
			setTimeout(() => {
				inputIdMessageLabel.style.transform = "translate(-50%, 0)";
				inputIdMessageLabel.style.opacity = "1";
			}, 20);
		}
	}

	// ID를 입력하라는 메시지를 숨기는 메소드
	hideInputIdMessage() {
		if (this.isOpenedInputIdMessage) {
			this.isOpenedInputIdMessage = false;

			// ID를 입력하라는 메시지
			var inputIdMessageLabel
					= document.getElementsByClassName("input-id-message")[0];

			inputIdMessageLabel.style.opacity = "0";
			inputIdMessageLabel.style.transform = "translate(-50%, -15px)";

			setTimeout(() => {
				inputIdMessageLabel.remove();
			}, 400); // 애니메이션 끝난 뒤 DOM 제거
		}
	}
}

new StartButton(
	document.getElementsByName("id")[0],
	document.getElementsByClassName("start-button")[0]
);