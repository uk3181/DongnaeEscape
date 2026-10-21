// 관리자 전용 페이지 관련 코드

// 메뉴 버튼 클래스
class MenuButton {
	constructor(menuButtons, analysisFrame) {
		for (var i = 0; i < menuButtons.length; i++) {
			let menuButton = menuButtons[i];
			// 클릭 이벤트 처리
			menuButton.addEventListener("click", () => {
				switch (menuButton.value) {
					case "대시보드":
						analysisFrame.src = "dashboard";
						break;
					case "사용자 조회":
						analysisFrame.src = "search-user";
						break;
					case "플레이 기록":
						analysisFrame.src = "search-play-records";
						break;
					case "게임 통계":
						analysisFrame.src = "play-statistics";
						break;
				}
			});
		}
	}
}

new MenuButton(
	document.getElementsByName("menu"),
	document.getElementsByClassName("analysis-frame")[0]
);