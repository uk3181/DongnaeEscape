// BGM Audio를 관리함.

class BGMAudio {
	constructor(bgmAudio, soundButton) {
		// BGM을 관리하는 audio
		this.bgmAudio = bgmAudio;
		// Sound 버튼
		this.soundButton = soundButton;
	}
	
	// BGM을 설정하는 메소드
	setBGMSettings() {
		// BGM 소스 설정
		var bgmSource = this.soundButton.id;
		if (this.bgmAudio.id == "muted") // BGM이 재생되고 있지 않음.
			// BGM 변경
			this.bgmAudio.src = bgmSource;
		else { // BGM이 재생되고 있음.
			// BGM이 바뀔 때만 BGM을 다시 재생함.
			if (bgmSource != this.bgmAudio.getAttribute("src")) {
				this.bgmAudio.src = bgmSource;
				this.bgmAudio.play();
			}
		}
	}
}

var bgmAudio = new BGMAudio(parent.document.getElementsByClassName("bgm-audio")[0],
		document.getElementsByClassName("sound-button")[0]);
// BGM을 설정함.
bgmAudio.setBGMSettings();