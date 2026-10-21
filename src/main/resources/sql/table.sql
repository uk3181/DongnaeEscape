-- 문제 데이터를 저장하는 테이블
CREATE TABLE PROBLEM_SET (
    ROOM_NUMBER NUMBER(1), -- 방 번호: 1~4
    QUESTION_NUMBER NUMBER(1), -- 문제 번호: 1~5
    QUESTION NVARCHAR2(500), -- 문제
    CHOICE_NUMBER NUMBER(1), -- 보기 번호: 1~4
    CHOICE NVARCHAR2(500), -- 보기
    ANSWER NUMBER(1), -- 정답
    ITEM NVARCHAR2(100) -- 아이템
) TABLESPACE COM_DONGNAE_ESCAPE;


-- 채팅 데이터를 저장하는 테이블
CREATE TABLE CHAT (
    CHAT_TYPE NUMBER(2), -- 채팅 종류
    					 -- 0(오프닝), 1(구간 전환), 2(입장), 3(오브젝트 설명),
    					 -- 4(힌트), 5(방 클리어), 6(성공 엔딩), 7(실패 엔딩)
    ROOM_NUMBER NUMBER(1), -- 방 번호: 1~4
    OBJECT_NUMBER NUMBER(1), -- 오브젝트 번호: 1~5
    CHAT_ORDER NUMBER(2), -- 채팅 순서 - 각 사용자들의 대화를 순서대로 나열함.
    USER_TYPE NUMBER(1), -- 사용자 종류: 0(시스템), 1(진행요원), 2(주인공)
    MESSAGE NVARCHAR2(500) -- 채팅 메시지
) TABLESPACE COM_DONGNAE_ESCAPE;

-- 플레이어의 정보를 저장하는 테이블
CREATE TABLE PLAYER_INFO (
	ID VARCHAR2(20), -- 1365 ID
	START_TIME DATE, -- 접속 시간
	END_TIME DATE, -- 종료 시간
	CODE NVARCHAR2(20), -- 획득 코드
	LAST_SOLVED_ROOM_NUMBER NUMBER(1), -- 마지막으로 푼 문제에 해당하는 방 번호: 1~4
	LAST_SOLVED_OBJECT_NUMBER NUMBER(1), -- 마지막으로 푼 문제에 대항하는 오브젝트 번호: 1~5
	GAME_SUCCESSFUL NUMBER(1) -- 최종 게임 성공 여부: 0(실패), 1(성공)
) TABLESPACE COM_DONGNAE_ESCAPE;