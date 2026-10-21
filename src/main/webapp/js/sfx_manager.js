// SFX를 관리하는 클래스

class SFXManager {
	constructor(sfxAudio, buttonElements, answerButtonElements,
			doorElements, objectElements) {
		// SFX를 관리하는 audio
		this.sfxAudio = sfxAudio;

		// SFX 소스 설정
		// - button elements
		this.setSfxSourceOnElements(
			buttonElements,
			"assets/sounds/sfxs/click_button_sfx.mp3"
		);
		// - answer button elements
		this.setSfxSourceOnElements(
			answerButtonElements,
			"assets/sounds/sfxs/answer_sfx.mp3"
		);
		// - door elements
		this.setSfxSourceOnElements(
			doorElements,
			"assets/sounds/sfxs/click_door_sfx.mp3"
		);
		// - object elements
		this.setSfxSourceOnElements(
			objectElements,
			"assets/sounds/sfxs/click_object_sfx.mp3"
		);
	}
	
	// 각 요소에 SFX 소스를 설정하는 메소드
	setSfxSourceOnElements(elements, sfxSource) {
		for (var i = 0; i < elements.length; i++) {
			var element = elements[i];
			
			// 클릭 이벤트 설정
			element.addEventListener("click", () => {
				this.sfxAudio.src = sfxSource;
				this.sfxAudio.volume = 0.5;
				this.sfxAudio.play();
			});
		}
	}
}

new SFXManager(
	parent.document.getElementsByClassName("sfx-audio")[0],
	document.querySelectorAll("#button"),
	document.querySelectorAll("#answer-button"),
	document.querySelectorAll("#door"),
	document.querySelectorAll("#object")
);