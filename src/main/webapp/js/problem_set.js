// 힌트 버튼 클래스
class HintButton {
	constructor(hintInput) {
		this.hintInput = hintInput;
		
		this.hintInput.addEventListener("mouseenter", () => {
			this.showHintMessage();
		});
		this.hintInput.addEventListener("mouseleave", () => {
			this.hideHintMessage();
		})
		this.hintInput.addEventListener("click", () => {
			this.hideHintMessage();
		})
	}
	
	// 남은 시간 1분 감소 메시지를 띄우는 메소드
	showHintMessage() {
		// 힌트를 확인하면 남은 시간을 1분 감소시킨다는 메시지 레이블
		var hintMessageLabel = document.createElement("label");
		hintMessageLabel.className = "hint-message";
		hintMessageLabel.textContent = "힌트를 확인하면 남은 시간이 1분 감소됩니다.";
		document.body.appendChild(hintMessageLabel);
			
		// 힌트 버튼과 생성된 메시지의 크기/위치 측정
		var rect = this.hintInput.getBoundingClientRect();
		var labelWidth = hintMessageLabel.offsetWidth;
	
		// X축(가로) 중앙 위치를 픽셀 단위로 완벽하게 고정 (가로 흔들림 방지)
		var exactLeft = rect.left + (rect.width / 2) - (labelWidth / 2);
	
		// Y축(세로) 시작 위치와 목표 위치 설정
		var startTop = (rect.top - 38) + 10; // 시작할 때 아래쪽
		var endTop = rect.top - 38;         // 올라갈 목표 위치
	
		// 스타일 설정
		Object.assign(hintMessageLabel.style, {
			position: "fixed",
			left: exactLeft + "px",
			top: startTop + "px", // 세로 시작 위치 지정
			opacity: "0",
			padding: "10px 18px",
			background: "rgba(15, 18, 23, 0.9)",
			color: "rgba(245, 241, 232, 0.95)",
			border: "1px solid rgba(225, 205, 170, 0.4)",
			borderRadius: "6px",
			boxShadow: "0 10px 30px rgba(0, 0, 0, 0.6), inset 0 0 15px rgba(255, 225, 180, 0.04)",
			backdropFilter: "blur(6px)",
			fontFamily: '"Noto Sans KR", sans-serif',
			fontSize: "13px",
			fontWeight: "500",
			letterSpacing: "0.5px",
			whiteSpace: "nowrap",
			zIndex: "9999",
			// transform 대신 top 속성만 변화시켜 완벽한 수직(세로) 운동 보장
			transition: "opacity 0.25s ease, top 0.25s ease",
			pointerEvents: "none"
		});
			
		hintMessageLabel.style.top = endTop + "px";
		hintMessageLabel.style.opacity = "1";
	}
	
	// 남은 시간 1분 감소 메시지를 숨기는 메소드
	hideHintMessage() {
		var hintMessageLabel = document.getElementsByClassName("hint-message")[0];
	
		var rect = this.hintInput.getBoundingClientRect();
		var startTop = (rect.top - 38) + 10;
	
		hintMessageLabel.style.opacity = "0";
		hintMessageLabel.style.top = startTop + "px";
			
		hintMessageLabel.remove();
	}
}

new HintButton(document.getElementsByClassName("hint-button")[0]);