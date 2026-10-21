// 화면 전환 효과를 관리함.

// 페이드 아웃 효과
class FadeOut {
	constructor() {
		document.addEventListener("DOMContentLoaded", () => {
		    const fadeScreen = document.getElementById("fade-screen");
		    // 현재 페이지의 모든 링크 가져오기
		    const doorLinks = document.querySelectorAll("#door-link");
			const doorImages = document.querySelectorAll("#door");
			// 현재 페이지의 
		    for (let i = 0; i < doorLinks.length; i++) {
				const doorLink = doorLinks[i];
				const doorImage = doorImages[i];
				// 방으로 이동 가능한 문인지 확인
				if (doorImage.getAttribute("src") == "assets/images/backgrounds/enter_door_background.jpg") {
			    	doorLink.addEventListener("click", (event) => {
			        	// 바로 페이지 이동하는 것을 막음
			        	event.preventDefault();
			        	// 이동할 주소 저장
						const nextPage = doorLink.href;
			        	// 화면 어둡게
			        	fadeScreen.classList.add("active");
						// 0.8초 후 이동
			            setTimeout(() => {
			            	window.location.href = nextPage;
			            }, 800);
			        });
				}
				else {
					doorLink.addEventListener("click", () => {
						event.preventDefault();
					});
				}
		    }
		});

	}
}

new FadeOut();