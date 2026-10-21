// Sound 버튼을 관리하는 클래스

class SoundButton {
	constructor(bgmAudio, soundButton) {
		// BGM을 관리하는 audio
		this.bgmAudio = bgmAudio;
		// Sound 버튼
		this.soundButton = soundButton;
		
		// BGM 버튼 이미지 설정
		if (this.bgmAudio.id == "unmuted")
			this.soundButton.src = "assets/images/icons/unmuted_sound_icon.png";
		else // "muted"
			this.soundButton.src = "assets/images/icons/muted_sound_icon.png";
		
		// BGM 버튼 클릭 설정
		this.soundButton.addEventListener("click", () => {
			// id를 통해 BGM의 재생 여부를 알 수 있음.
			var id = this.bgmAudio.id;
			if (id == "unmuted") { // BGM이 재생되지 않게 변경
				this.bgmAudio.volume = 0;
				this.bgmAudio.id = "muted";
				this.soundButton.src = "assets/images/icons/muted_sound_icon.png"
				this.bgmAudio.pause();
			}
			else { // id == "muted" - BGM이 재생되게 변경
				this.bgmAudio.volume = 0.75;
				this.bgmAudio.id = "unmuted";
				this.soundButton.src = "assets/images/icons/unmuted_sound_icon.png"
				this.bgmAudio.play();
			}
		});
	}
}

new SoundButton(
	parent.document.getElementsByClassName("bgm-audio")[0],
	document.getElementsByClassName("sound-button")[0]
);