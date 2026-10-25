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
### 1. 1365 ID 입력 및 게임 시작
### 2. 각 방 입장
게임에는 총 4개의 방이 존재한다. 각 방의 이름은 동래읍성, 동래시장, 온천천, 자원봉사센터인데, 4번째 방의 이름은 1~3번째 방의 모든 오브젝트를 해결하기 전까지는 UNKNOWN으로 표시가 되어 있다.
### 3. 각 오브젝트 클릭
각 방에는 5개의 오브젝트가 존재한다. 각 오브젝트를 클릭하기 전 게임 진행에 필요한 정보를 수집해야 한다.
### 4. 오브젝트에 해당하는 문제 해결
각 오브젝트를 클릭하면 봉사자가 해결해야 할 문제가 주어진다. 4지 선다 형식 또는 OX퀴즈 형식으로 구성되어 있으며, 문제를 틀릴 때마다 게임 진행에 남은 시간은 30초 감소한다. 힌트를 조회할 수 있으나 조회할 시 남은 시간은 1분 감소한다.
### 5. 최종 문제 해결
4개의 각 방에 있는 모든 오브젝트에 대응하는 문제를 해결한 후, 마지막 문제를 해결해야 한다. 정답은 "자원봉사"이며, 이 역시 틀린 답안을 입력할 경우 게임 진행에 남은 시간은 30초 감소한다.
### 6. 엔딩
게임 성공 여부를 확인할 수 있다. 최종 문제까지 해결을 완료해야 게임에 성공하며, 시간 초과일 경우 게임에 실패한다.





## 시스템 요구사항
### 운영 체제
- Windows
### 개발 환경
- **언어**: Python
- **플랫폼**: 데스크탑 애플리케이션
### 라이브러리
| 라이브러리 | 유형 | 용도 |
|-----------|------|------|
| tkinter | 표준 | GUI 프레임워크 (버튼, 레이블, 엔트리 등) |
| sortedcontainers | 외부 | 정렬된 상태의 데이터 관리 |
| datetime | 표준 | 날짜 및 시간 처리 |
| matplotlib | 외부 | 학습·성적 데이터 그래프 시각화 |
| math | 표준 | 수학 계산 처리 |
| numpy | 외부 | 숫자·배열의 빠른 계산 처리 |
| sklearn.linear_model | 외부 | 선형 회귀 모델을 이용한 성적 예측 |
| pathlib | 표준 | 파일과 폴더의 경로 관리 |
| pickle | 표준 | Python 객체의 직렬화 및 역직렬화 |

## 설치 및 실행
### 1. 애플리케이션 설치
- (1) 다운로드: [Installer 다운로드 링크](https://github.com/uk3181/J-Study-Checker/releases/download/v1.0/J.Study.Checker.Installer.exe)
- (2) 설치: J.Study.Checker.Installer.exe 실행 후 안내에 따라 설치 진행
### 2. 애플리케이션 실행
- Windows 시작 메뉴에서 앱 J Study Checker를 찾아서 실행

## 프로젝트 구조
```
J-Study-Checker/
├── .github/
│   └── workflows/
│       └── build.yml
├── Datas/ # 사용자 및 학습 데이터 저장
│   └── user_list.bin # 시스템의 데이터를 이진 파일로 관리함.
├── Fonts/
│   └── NanumGothic/
│       └── NanumGothic/
│           ├── NanumGothic.otf
│           ├── NanumGothic.ttf
│           ├── NanumGothicBold.otf
│           ├── NanumGothicBold.ttf
│           ├── NanumGothicExtraBold.otf
│           ├── NanumGothicExtraBold.ttf
│           ├── NanumGothicLight.otf
│           └── NanumGothicLight.ttf
├── Images/
│   ├── Backgrounds/ # 각 프레임의 배경화면
│   │   ├── analysis_grades_background.png
│   │   ├── analysis_study_background.png
│   │   ├── calculator_background.png
│   │   ├── home_background.png
│   │   ├── login_background.png
│   │   ├── notification_background.png
│   │   ├── register_background.png
│   │   ├── reminder_background.png
│   │   ├── stopwatch_background.png
│   │   ├── study_background.png
│   │   ├── study_calendar_background.png
│   │   ├── time_table_background.png
│   │   ├── timer_background.png
│   │   └── user_background.png
│   ├── Graphs/ # 학습 및 성적 데이터를 시각화한 그래프
│   │   ├── break_time_per_days_graph.png
│   │   ├── break_time_per_subjects_graph.png
│   │   ├── focus_rate_per_days_graph.png
│   │   ├── focus_rate_per_subjects_graph.png
│   │   ├── grade_data_graph.png
│   │   ├── studying_time_per_days_graph.png
│   │   └── studying_time_per_subjects_graph.png
│   └── Icons/ # 애플리케이션 및 각 버튼의 아이콘
│   │   ├── app_icon.png
│   │   ├── custom_timer_button_1.png
│   │   ├── custom_timer_button_2.png
│   │   ├── five_minutes_timer_button_1.png
│   │   ├── five_minutes_timer_button_2.png
│   │   ├── notification_icon_1.png
│   │   ├── notification_icon_2.png
│   │   ├── one_minute_timer_button_1.png
│   │   ├── one_minute_timer_button_2.png
│   │   ├── ten_minutes_timer_button_1.png
│   │   ├── ten_minutes_timer_button_2.png
│   │   ├── user_icon_1.png
│   │   └── user_icon_2.png
├── SourceCodes/ # 프로그램의 주요 GUI 및 기능 구현
│   ├── analysis_grades_frame.py # 성적 분석 프레임
│   ├── analysis_grades.py # 성적 분석 시스템 - 성적 예측, 성적 분석 그래프 생성 등
│   ├── analysis_study.py # 학습 분석 시스템 - 학습 분석 그래프 생성 등
│   ├── analysis_study_frame.py # 학습 분석 프레임
│   ├── app.py # 최종적으로 실행되는 앱
│   ├── calculator_frame.py # 계산기 프레임
│   ├── home_frame.py # 홈 프레임 - 시스템의 다양한 기능을 선택하여 실행시킬 수 있음.
│   ├── login_frame.py # 로그인 프레임 - 앱을 실행하였을 때 나타남.
│   ├── menu_button.py # 메뉴 버튼 UI 구현
│   ├── notification_frame.py # 알림 프레임
│   ├── notification_system.py # 알림 시스템 - 리마인더 알림 업데이트, 사용자 정보 변경 알림 업데이트
│   ├── path_settings.py # 모든 소스코드의 기본 경로를 설정함.
│   ├── register_frame.py # 회원가입 프레임
│   ├── reminder_frame.py # 리마인더 프레임
│   ├── reset_file.py # 시스템의 데이터를 초기화하는 코드
│   ├── stopwatch_frame.py # 스톱워치 프레임
│   ├── study_frame.py # 학습 프레임
│   ├── time_table_frame.py # 요일별 학습 시간을 보여주는 프레임
│   ├── timer_frame.py # 타이머 프레임
│   ├── user.py # 사용자 클래스 및 시스템 - 사용자 추가, 수정, 삭제
│   └── user_frame.py # 사용자 프레임
├── README.md
├── System Modeling and Design.pdf
├── System Requirements Specification.pdf
└── privacy-policy.html
```

## 사용자 유형별 기능
### 일반 사용자(학생)
- 기본적인 컴퓨터 사용 및 GUI 조작 능력을 갖추고 있다.
- 자신의 학습 과목 및 학습 계획을 관리할 수 있다.
- 학습 시간, 휴식 시간 및 성적 등의 정보를 직접 관리할 수 있다.
- 시스템에서 제공하는 학습 및 성적 분석 결과를 이해하고 활용할 수 있다.

## 주요 클래스
| 클래스 | 설명 |
|--------|------|
| `User` | 사용자의 기본 정보: ID, 비밀번호, 이름, 나이, 성별, 학습 데이터 목록, 성적 데이터 목록 등 |
| `StudyData` | 학습 데이터: 날짜, 과목명, 학습 시간 등 |
| `GradeData` | 성적 데이터: 날짜, 점수 등 |
| `ReminderData` | 리마인더 데이터: 날짜, 메모 |

## 개발자
| 이름 | GitHub |
|------|--------|
| 정재욱 | [@uk3181](https://github.com/uk3181) |

## 라이선스
Copyright © 2026 J Study Checker. All rights reserved.<br>
본 프로젝트의 소스 코드는 교육 목적으로 작성되었으며, 저작권자의 사전 허가 없이 복제, 수정, 배포 및 상업적 이용을 할 수 없다.
