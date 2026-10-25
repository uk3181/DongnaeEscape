# 방탈출 - 동래구 기록 복구 프로젝트
동래구 기록 복구 프로젝트는 봉사자들이 봉사 정신을 함양할 수 있도록 제작된 웹기반 방탈출 게임 프로그램이다. 플레이어는 제한 시간 내에 각종 문제를 풀어 방탈출을 시도할 수 있고, 관리자는 플레이어별 게임 플레이 기록을 확인할 수 있다.

## 프로젝트 소개
- **프로젝트명**: 동래구 기록 복구 프로젝트
- **부제**: 미래 붕괴 도시
- **프로젝트 유형**: 웹기반 방탈출 게임
- **개발 목적**: 봉사자들이 게임 형식을 통해 보다 더 흥미롭게 봉사 정신을 함양할 수 있도록 교육용으로 개발되었다. 또한 관리자가 각 봉사자별 게임 기록을 확인하고, 조건에 부합하는 봉사자의 봉사 시간을 1365 자원봉사포털 사이트에 입력할 수 있도록 도와준다.
- **핵심 주제**: "보이지 않던 행동이 사라지자 도시가 무너졌다."

## 프로젝트 개요

## 사용자 유형 및 주요 기능
### 봉사자(플레이어)
- 시스템, 진행요원(서연)과의 대화에 참여한다.
- 각 방 입장 후 오브젝트를 클릭한다.
- 게임 진행에 필요한 정보를 수집한다.
- 제시된 문제의 정답을 입력한다.
- 필요할 경우 각 문제의 힌트 조회할 수 있다.
### 관리자
- 대시보드 조회: 게임 이용 현황(전체 사용자수, 게임 성공 사용자수, 게임 실패 사용자수, 최근 접속 사용자 10명, 사용자별 최근 게임 기록)을 조회할 수 있다.
- 사용자 조회: 1365에 가입되어 있는 ID를 바탕으로 사용자별 게임 진행 상황(게임 성공 여부, 접속 시간, 종료 시간, 최근 마지막 해결 방, 최근 마지막 해결 오브젝트 등)을 조회할 수 있다.
- 플레이 기록 조회: 최근 50명 사용자들의 플레이 기록(접속 시간, 마지막 해결 방, 마지막 해결 오브젝트, 게임 성공 여부, 이해도)을 조회할 수 있다. 필요할 경우 ID별·게임 성공 여부별로 결과를 필터링할 수 있다.
- 게임 통계 조회: 전체 사용자들의 게임 플레이 기록의 통계를 조회할 수 있다. 대시보드에 보이는 항목보다 더 세부적인 정보(방별 해결 현황, 오브젝트별 해결 현황 등)가 확인 가능하다.

## 게임 진행 방식
**1. 1365 ID 입력 및 게임 시작**<br>
<br>
**2. 각 방 입장**<br>
게임에는 총 4개의 방이 존재한다. 각 방의 이름은 동래읍성, 동래시장, 온천천, 자원봉사센터인데, 4번째 방의 이름은 1~3번째 방의 모든 오브젝트를 해결하기 전까지는 UNKNOWN으로 표시가 되어 있다.<br>
<br>
**3. 각 오브젝트 클릭**<br>
각 방에는 5개의 오브젝트가 존재한다. 각 오브젝트를 클릭하기 전 게임 진행에 필요한 정보를 수집해야 한다.<br>
<br>
**4. 오브젝트에 해당하는 문제 해결**<br>
각 오브젝트를 클릭하면 봉사자가 해결해야 할 문제가 주어진다. 4지 선다 형식 또는 OX퀴즈 형식으로 구성되어 있으며, 문제를 틀릴 때마다 게임 진행에 남은 시간은 30초 감소한다. 힌트를 조회할 수 있으나 조회할 시 남은 시간은 1분 감소한다.<br>
<br>
**5. 최종 문제 해결**
4개의 각 방에 있는 모든 오브젝트에 대응하는 문제를 해결한 후, 마지막 문제를 해결해야 한다. 정답은 "자원봉사"이며, 이 역시 틀린 답안을 입력할 경우 게임 진행에 남은 시간은 30초 감소한다.<br>
<br>
**6. 엔딩**<br>
게임 성공 여부를 확인할 수 있다. 최종 문제까지 해결을 완료해야 게임에 성공하며, 시간 초과일 경우 게임에 실패한다.

## 주요 게임 시스템

## 개발 환경 및 기술 스택
- **Frontend**: HTML, CSS, JavaScript
- **Backend**: Java, JSP, Servlet
- **Database**: Oracle SQL
- **Server**: Apache Tomcat
- **플랫폼**: 웹 어플리케이션

## 배포 환경
- **Hosting**: AWS EC2
- **URL**: 봉사자용(https://dongnae-escape.kro.kr), 관리자용(https://dongnae-escape.kro.kr/admin)

## 프로젝트 구조
```
DongnaeEscape/
├── src/
│   └── main/
│       ├── java/ # JAVA 코드
│       │   ├── com.dongnae.escape/
│       │   │   ├── controller/ # 컨트롤러
│       │   │   │   ├── AdminController.java # 관리자용 페이지를 구성하는 컨트롤러
│       │   │   │   ├── ChatController.java # 진행요원(서연)과 주인공(플레이어) 간의 대화 내용을 설정하는 컨트롤러
│       │   │   │   ├── CheckAnswerController.java # 플레이어가 선택한 보기가 정답인지 확인하는 컨트롤러
│       │   │   │   ├── CheckInputAnswerController.java # 입력된 최종 정답을 확인하는 컨트롤러
│       │   │   │   ├── DashboardController.java # 대시보드 구성 컨트롤러
│       │   │   │   ├── EndingController.java # 엔딩 페이지를 설정하는 컨트롤러
│       │   │   │   ├── GameController.java # 게임 시작과 동시에 4개의 방이 있는 공간으로 이동함.
│       │   │   │   ├── GoToEndingController.java # 채팅 페이지, 엔딩 페이지로 순차적으로 이동하는 컨트롤러
│       │   │   │   ├── HintController.java # 힌트를 보여주기 위한 컨트롤러
│       │   │   │   ├── InputAnswerController.java # 최종 정답을 입력할 수 있도록 구성하는 컨트롤러
│       │   │   │   ├── PlayStatisticsController.java # 플레이 통게 페이지를 구성하는 컨트롤러
│       │   │   │   ├── PlayerInfoController.java # 플레이어의 정보를 설정하는 컨트롤러
│       │   │   │   ├── ProblemSetController.java # 문제 구성을 설정하는 컨트롤러
│       │   │   │   ├── RoomController.java # 방의 구성을 설정하는 컨트롤러
│       │   │   │   ├── SearchPlayRecordsController.java # 플레이 기록을 검색하는 컨트롤러
│       │   │   │   ├── SearchUserController.java # 사용자 조회 페이지 구성 컨트롤러
│       │   │   │   ├── SelectRoomController.java # 플레이어로부터 각 방을 해결했는지 여부를 알아내어, 문의 상태를 정하는 컨트롤러
│       │   │   │   ├── ShowInfoController.java # 어떤 오브젝트를 클릭해야 하는지 알려주는 컨트롤러
│       │   │   │   └── TimerController.java # 타이머의 남은 시간을 세션의 플레이어의 정보에 저장하는 컨트롤러
│       │   │   ├── dao/ # dao
│       │   │   │   ├── ChatDAO.java # 채팅 데이터를 처리하는 DAO
│       │   │   │   ├── PlayerInfoDAO.java # 플레이어의 정보를 관리하는 DAO
│       │   │   │   └── ProblemSetDAO.java # 문제 데이터를 처리하는 DAO
│       │   │   └── model/ # 모델
│       │   │       ├── Chat.java # 각 사용자 간의 대화 내용을 관리하는 모델
│       │   │       ├── Message.java # 메시지 데이터를 관리하는 모델
│       │   │       ├── PlayerInfo.java # 플레이어의 정보를 관리하는 모델
│       │   │       └── ProblemSet.java # 문제 데이터를 관리하는 모델
│       │   └── filter/ # 필터
│       │       └── CharacterEncodingFilter.java
│       ├── resources/
│       │   └── sql/ # 데이터베이스 기본 설정
│       │       ├── chat_data.sql # 각 채팅 데이터를 저장함.
│       │       ├── problem_set_data.sql # 각 문제의 데이터를 저장함.
│       │       ├── table.sql # 각종 테이블을 생성함.
│       │       └── tablespace.sql # 테이블스페이스를 생성함.
│       └── webapp/
│           ├── META-INF/
│           │   └── MANIFEST.MF
│           ├── WEB-INF/
│           │   ├── lib/
│           │   │   └── ojdbc17.jar
│           │   └── web.xml
│           ├── assets/
│           │   ├── images/ # 이미지
│           │   │   ├── backgrounds/ # 배경
│           │   │   │   ├── chat_background.jpg # 채팅 페이지 배경
│           │   │   │   ├── cleared_door_background.jpg # 해결을 완료한 방의 문
│           │   │   │   ├── closed_door_background.jpg # 미해결 상태이고 들어갈 수 없는 방의 문
│           │   │   │   ├── enter_door_background.jpg # 미해결 상태이고 들어갈 수 있는 방의 문
│           │   │   │   ├── failed_background.jpg # 게임 실패 엔딩 배경
│           │   │   │   ├── main_theme_background.jpg # 게임 시작 배경
│           │   │   │   ├── player_background.jpg # 채팅 페이지에 표시되는 플레이어 이미지
│           │   │   │   ├── problem_set_background.jpg # 문제 풀이 배경
│           │   │   │   ├── room1_background.jpg # 첫 번째 방(동래읍성) 배경
│           │   │   │   ├── room1_object1_background.png # 첫 번째 방 - 1번 오브젝트
│           │   │   │   ├── room1_object2_background.png # 첫 번째 방 - 2번 오브젝트
│           │   │   │   ├── room1_object3_background.png # 첫 번째 방 - 3번 오브젝트
│           │   │   │   ├── room1_object4_background.png # 첫 번째 방 - 4번 오브젝트
│           │   │   │   ├── room1_object5_background.png # 첫 번째 방 - 5번 오브젝트
│           │   │   │   ├── room2_background.jpg # 두 번째 방(동래시장) 배경
│           │   │   │   ├── room2_object1_background.png # 두 번째 방 - 1번 오브젝트
│           │   │   │   ├── room2_object2_background.png # 두 번째 방 - 2번 오브젝트
│           │   │   │   ├── room2_object3_background.png # 두 번째 방 - 3번 오브젝트
│           │   │   │   ├── room2_object4_background.png # 두 번째 방 - 4번 오브젝트
│           │   │   │   ├── room2_object5_background.png # 두 번째 방 - 5번 오브젝트
│           │   │   │   ├── room3_background.jpg # 세 번째 방(온천천) 배경
│           │   │   │   ├── room3_object1_background.png # 세 번째 방 - 1번 오브젝트
│           │   │   │   ├── room3_object2_background.png # 세 번째 방 - 2번 오브젝트
│           │   │   │   ├── room3_object3_background.png # 세 번째 방 - 3번 오브젝트
│           │   │   │   ├── room3_object4_background.png # 세 번째 방 - 4번 오브젝트
│           │   │   │   ├── room3_object5_background.png # 세 번째 방 - 5번 오브젝트
│           │   │   │   ├── room4_background.jpg # 네 번째 방(자원봉사센터) 배경
│           │   │   │   ├── room4_object1_background.png # 네 번째 방 - 1번 오브젝트
│           │   │   │   ├── room4_object2_background.png # 네 번째 방 - 2번 오브젝트
│           │   │   │   ├── room4_object3_background.png # 네 번째 방 - 3번 오브젝트
│           │   │   │   ├── room4_object4_background.png # 네 번째 방 - 4번 오브젝트
│           │   │   │   ├── room4_object5_background.png # 네 번째 방 - 5번 오브젝트
│           │   │   │   ├── rooms_background.jpg # 각 방을 입장할 수 있는 공간의 배경
│           │   │   │   ├── staff_background.jpg # 채팅 페이지에 표시되는 진행요원 이미지
│           │   │   │   ├── successful_background.jpg # 게임 성공 엔딩 배경
│           │   │   │   ├── system_background.jpg 채팅 페이지에 표시되는 시스템 이미지
│           │   │   └── icons/ # 아이곤
│           │   │       ├── info_icon.png # 게임 진행에 필요한 정보 버튼 아이콘
│           │   │       ├── muted_sound_icon.png # 음소거 상태의 버튼 아이콘
│           │   │       └── unmuted_sound_icon.png # 음소거 해제 상태의 버튼 아이콘
│           │   └── sounds/ # 사운드
│           │       ├── bgms/ # BGM
│           │       │   ├── chat_theme_bgm.mp3 # 채팅 BGM
│           │       │   ├── failed_bgm.mp3 # 게임 실패 엔딩 BGM
│           │       │   ├── main_theme_bgm.mp3 # 게임 시작 BGM
│           │       │   ├── room1_bgm.mp3 # 첫 번째 방(동래읍성) BGM
│           │       │   ├── room2_bgm.mp3 # 두 번째 방(동래시장) BGM
│           │       │   ├── room3_bgm.mp3 # 세 번째 방(온천천) BGM
│           │       │   ├── room4_bgm.mp3 # 네 벙째 방(자원봉사센터) BGM
│           │       │   ├── select_room_theme_bgm.mp3 # 각 방을 입장할 수 있는 공간 BGM
│           │       │   └── successful_bgm.mp3 # 게임 성공 엔딩 BGM
│           │       └── sfxs/ # SFX
│           │           ├── answer_sfx.mp3 # 문제 해결에 성공했을 때의 SFX
│           │           ├── click_button_sfx.mp3 # 각종 버튼을 클릭했을 때의 SFX
│           │           ├── click_door_sfx.mp3 # 각 방을 입장할 수 있는 공간에서 방 문을 클릭했을 때의 SFX
│           │           ├── click_object_sfx.mp3 # 각 방의 각 오브젝트를 클릭했을 때의 SFX
│           │           └── left_time_sfx.mp3 # 시간 압박 대사가 나타날 때의 SFX
│           ├── css/ # 스타일 시트
│           │   ├── admin.css # 관리자 전용 페이지 스타일 시트
│           │   ├── chat.css # 주인공과 진행요원 간의 대화 내용을 보여주는 페이지 스타일 시트
│           │   ├── dashboard.css # 관리자 전용 페이지 - 대시보드 스타일 시트
│           │   ├── ending.css # 엔딩 페이지 스타일 시트
│           │   ├── input_answer.css # 최종 정답을 입력하는 페이지 스타일 시트
│           │   ├── main_theme.css # 게임 시작 화면 스타일 시트
│           │   ├── play_records.css # 관리자 전용 페이지 - 플레이 기록 스타일 시트
│           │   ├── play_statistics.css # 관리자 전용 페이지 - 플레이 통계 스타일 시트
│           │   ├── problem_result.css # 문제 풀이의 결과(정답/오답)를 보여주는 페이지 스타일 시트
│           │   ├── problem_set.css # 문제를 푸는 페이지 스타일 시트
│           │   ├── room1.css # 첫 번째 방(동래읍성) 스타일 시트
│           │   ├── room2.css # 두 번째 방(동래시장) 스타일 시트
│           │   ├── room3.css # 세 번째 방(온천천) 스타일 시트
│           │   ├── room4.css # 네 번째 방(자원봉사센터) 스타일 시트
│           │   ├── select_room.css # 4개의 각 방으로 들어갈 수 있도록 해주는 페이지 스타일 시트
│           │   └── user.css # 관리자 전용 페이지 - 사용자 조회 스타일 시트
│           ├── js/ # JavaScript
│           │   ├── admin.js # 관리자 전용 페이지 관련 코드
│           │   ├── bgm_audio.js # BGM Audio를 관리하는 코드
│           │   ├── chat.js # 채팅 페이지 관련 코드
│           │   ├── main_theme.js # 메인 화면 관련 코드
│           │   ├── problem_set.js # 문제를 푸는 페이지 관련 코드
│           │   ├── screen_manager.js # 화면 전환 효과를 관리하는 코드
│           │   ├── session_storage_manager.js # 세션 스토리지를 관리하는 코드
│           │   ├── sfx_manager.js # SFX를 관리하는 코드
│           │   ├── sound_button.js # 사운드 버튼을 관리하는 코드
│           │   └── timer.js # 타이머 설정 코드
│           ├── admin.html # 관리자 전용 페이지
│           ├── chat.jsp # 주인공과 진행요원 간의 대화 내용을 보여주는 페이지
│           ├── dashboard.jsp # 관리자 전용 페이지 - 대시보드
│           ├── ending.jsp # 엔딩 페이지
│           ├── index.html # 최종적으로 게임이 사용자에게 보여지는 페이지
│           ├── input_answer.jsp # 최종 정답을 입력하는 페이지
│           ├── main_theme.html # 게임 시작 화면
│           ├── play_records.jsp # 관리자 전용 페이지 - 플레이 기록
│           ├── play_statistics.jsp # 관리자 전용 페이지 - 플레이 통계
│           ├── problem_result.jsp # 문제 풀이의 결과(정답/오답)를 보여주는 페이지
│           ├── problem_set.jsp # 문제를 푸는 페이지
│           ├── room.jsp # 각 방의 모습을 구성하는 페이지
│           ├── select_room.jsp # 4개의 각 방으로 들어갈 수 있도록 해주는 페이지
│           └── user.jsp # 관리자 전용 페이지 - 사용자 조회
└── README.md
```

## 시스템 요구사항
### 운영 체제
- Windows
### 개발 환경
- **언어**: Python
- **플랫폼**: 데스크탑 애플리케이션
### 라이브러리

## 개발팀
| 이름 | GitHub | 담당 역할 |
| --- | ------ | ------ |
| 정재욱 | [@uk3181](https://github.com/uk3181) | JAVA, HTML, JavaScript 대부분(admin.js, bgm_audio.js, chat.js, main_theme.js, problem_set.js, session_storage.js, sfx_manager.js, sound_button.js, timer.js), SQL 개발 |

## 라이선스
Copyright © 2026 J DongnaeEscape. All rights reserved.<br>
본 프로젝트의 소스 코드는 교육 목적으로 작성되었으며, 저작권자의 사전 허가 없이 복제, 수정, 배포 및 상업적 이용을 할 수 없다.
