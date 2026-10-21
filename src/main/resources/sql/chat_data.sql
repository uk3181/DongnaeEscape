/* 각 채팅 데이터를 저장함. */

/* -------------------- 오프닝 -------------------- */
INSERT INTO CHAT VALUES(
	0,
	0,
	0,
	1,
	0, -- 시스템
	'DONGNAE CITY SYSTEM: 도시 기능률 17%, 공공 유지 기록 78% 손실'
);
INSERT INTO CHAT VALUES(
	0,
	0,
	0,
	2,
	0, -- 시스템
	'공동체 연결망 OFF, 환경 관리 시스템 OFF, 취약계층 지원망 OFF, 재난 대응 보조망 OFF'
);
INSERT INTO CHAT VALUES(
	0,
	0,
	0,
	3,
	2, -- 주인공
	'뭐야... 시스템이 전부 멈췄잖아.'
);
INSERT INTO CHAT VALUES(
	0,
	0,
	0,
	4,
	1, -- 진행요원
	'조사요원, 들리세요?'
);
INSERT INTO CHAT VALUES(
	0,
	0,
	0,
	5,
	2, -- 주인공
	'들려요. 데이터 서버가 망가진 겁니까?'
);
INSERT INTO CHAT VALUES(
	0,
	0,
	0,
	6,
	1, -- 진행요원
	'처음엔 저희도 그렇게 생각했어요.'
);
INSERT INTO CHAT VALUES(
	0,
	0,
	0,
	7,
	1, -- 진행요원
	'그런데 이상한 점이 있어요.'
);
INSERT INTO CHAT VALUES(
	0,
	0,
	0,
	8,
	1, -- 진행요원
	'과거에는 사람들이 함께 환경을 정비하고 누군가를 도왔는데 현재는 사람들이 그냥 지나치고 있잖아요.'
);
INSERT INTO CHAT VALUES(
	0,
	0,
	0,
	9,
	1, -- 진행요원
	'사라진 건 데이터만이 아니에요.'
);
INSERT INTO CHAT VALUES(
	0,
	0,
	0,
	10,
	2, -- 주인공
	'그럼 뭐죠?'
);
INSERT INTO CHAT VALUES(
	0,
	0,
	0,
	11,
	1, -- 진행요원
	'사람들이 하던 어떤 ''행동'' 자체가 사라지고 있어요.'
);
INSERT INTO CHAT VALUES(
	0,
	0,
	0,
	12,
	0, -- 시스템
	'ERROR: UNKNOWN BEHAVIOR DATA LOST'
);
INSERT INTO CHAT VALUES(
	0,
	0,
	0,
	13,
	0, -- 시스템
	'행동 기록 복구 필요'
);
INSERT INTO CHAT VALUES(
	0,
	0,
	0,
	14,
	0, -- 시스템
	'복구 가능 시간: 40:00'
);
INSERT INTO CHAT VALUES(
	0,
	0,
	0,
	15,
	1, -- 진행요원
	'과거 기록이 남아 있는 네 곳을 찾았어요.'
);
INSERT INTO CHAT VALUES(
	0,
	0,
	0,
	16,
	1, -- 진행요원
	'동래읍성, 동래시장, 온천천, UNKNOWN'
);
INSERT INTO CHAT VALUES(
	0,
	0,
	0,
	17,
	1, -- 진행요원
	'그곳에 남아 있는 기록을 복구하면 이 도시가 왜 이렇게 됐는지 알 수 있을 거예요.'
);
INSERT INTO CHAT VALUES(
	0,
	0,
	0,
	18,
	0, -- 시스템
	'COUNTDOWN START'
);

/* -------------------- 구간 전환 -------------------- */
INSERT INTO CHAT VALUES(
	1,
	0,
	0,
	1,
	0, -- 시스템
	'구간 이동 중...'
);

/* -------------------- 입장 -------------------- */
-- 1번 방
INSERT INTO CHAT VALUES(
	2,
	1,
	0,
	1,
	2, -- 주인공
	'완전히 버려진 느낌이야...'
);
INSERT INTO CHAT VALUES(
	2,
	1,
	0,
	2,
	1, -- 진행요원
	'이곳은 원래 많은 사람이 오가고 함께 관리하던 공간이었어요.'
);
INSERT INTO CHAT VALUES(
	2,
	1,
	0,
	3,
	2, -- 주인공
	'관리하는 사람이 사라진 건가요?'
);
INSERT INTO CHAT VALUES(
	2,
	1,
	0,
	4,
	1, -- 진행요원
	'아뇨. 사람은 있어요.'
);
INSERT INTO CHAT VALUES(
	2,
	1,
	0,
	5,
	1, -- 진행요원
	'하지만 이제는 아무도 먼저 움직이지 않아요.'
);
INSERT INTO CHAT VALUES(
	2,
	1,
	0,
	6,
	0, -- 시스템
	'ERROR: 행동 데이터 손실'
);
INSERT INTO CHAT VALUES(
	2,
	1,
	0,
	7,
	0, -- 시스템
	'''누군가 시키지 않아도 스스로 움직였던 행동'''
);
INSERT INTO CHAT VALUES(
	2,
	1,
	0,
	8,
	0, -- 시스템
	'관련 기록을 복구하십시오.'
);

-- 2번 방
INSERT INTO CHAT VALUES(
	2,
	2,
	0,
	1,
	2, -- 주인공
	'여긴 사람이 있잖아요.'
);
INSERT INTO CHAT VALUES(
	2,
	2,
	0,
	2,
	1, -- 진행요원
	'네.'
);
INSERT INTO CHAT VALUES(
	2,
	2,
	0,
	3,
	2, -- 주인공
	'그런데 왜 이렇게 엉망이죠?'
);
INSERT INTO CHAT VALUES(
	2,
	2,
	0,
	4,
	1, -- 진행요원
	'이곳에서는 이제 ''내 일이 아닌 일''에는 아무도 움직이지 않아요.'
);
INSERT INTO CHAT VALUES(
	2,
	2,
	0,
	5,
	0, -- 시스템
	'공동체 연결률 : 3%'
);
INSERT INTO CHAT VALUES(
	2,
	2,
	0,
	6,
	0, -- 시스템
	'ERROR: 상호 도움 행동 기록 소실'
);

-- 3번 방
INSERT INTO CHAT VALUES(
	2,
	3,
	0,
	1,
	2, -- 주인공
	'... 이건 너무 심한데.'
);
INSERT INTO CHAT VALUES(
	2,
	3,
	0,
	2,
	1, -- 진행요원
	'환경 관리 기록이 사라진 이후의 모습이에요.'
);
INSERT INTO CHAT VALUES(
	2,
	3,
	0,
	3,
	2, -- 주인공
	'이것도 그 사람들이 했던 행동과 관련 있는 거예요?'
);
INSERT INTO CHAT VALUES(
	2,
	3,
	0,
	4,
	1, -- 진행요원
	'온천천에 남아 있는 과거 활동 데이터가 있어요.'
);

-- 4번 방
INSERT INTO CHAT VALUES(
	2,
	4,
	0,
	1,
	2, -- 주인공
	'여기가 중심이었군요.'
);
INSERT INTO CHAT VALUES(
	2,
	4,
	0,
	2,
	1, -- 진행요원
	'맞아요.'
);
INSERT INTO CHAT VALUES(
	2,
	4,
	0,
	3,
	2, -- 주인공
	'그럼 여기서 사람들에게 봉사하라고 지시했던 건가요?'
);
INSERT INTO CHAT VALUES(
	2,
	4,
	0,
	4,
	1, -- 진행요원
	'아니요.'
);
INSERT INTO CHAT VALUES(
	2,
	4,
	0,
	5,
	2, -- 주인공
	'그럼 센터는 무슨 일을 했죠?'
);
INSERT INTO CHAT VALUES(
	2,
	4,
	0,
	6,
	1, -- 진행요원
	'사람들의 마음만으로 모든 활동이 안전하게 이어질 수는 없었어요.'
);
INSERT INTO CHAT VALUES(
	2,
	4,
	0,
	7,
	1, -- 진행요원
	'좋은 마음이 실제 행동으로 이어지고, 그 행동이 안전하게 지속될 수 있도록 연결하는 곳이 필요했어요.'
);
INSERT INTO CHAT VALUES(
	2,
	4,
	0,
	8,
	2, -- 주인공
	'그러니까 자원봉사는 그냥 좋은 일을 하는 게 아니었군.'
);

/* -------------------- 오브젝트 설명 -------------------- */
-- 1번 방 - 1번 오브젝트
INSERT INTO CHAT VALUES(
	3,
	1,
	1,
	1,
	0, -- 시스템
	'오래된 깃발이 바람도 없는 공간에서 미세하게 흔들리고 있습니다. 깃발에는 과거 동래읍성을 지키던 사람들의 표식이 남아 있습니다.'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	1,
	2,
	2, -- 주인공
	'깃발이라면 그냥 장식품 아닌가?'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	1,
	3,
	1, -- 진행요원
	'꼭 그렇지는 않을 거예요. 옛날에는 깃발 하나로 사람들에게 상황을 알리거나, 모일 장소를 알려주기도 했으니까요.'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	1,
	4,
	2, -- 주인공
	'그러니까 이 깃발도 누군가에게 무언가를 알리기 위한 물건이었다는 거네.'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	1,
	5,
	0, -- 시스템
	'깃발의 뒷면에서 희미한 문장이 발견되었습니다. 「혼자 지키는 성은 오래 버티지 못한다.」'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	1,
	6,
	2, -- 주인공
	'처음부터 사람을 모으는 게 목적이었던 건가?'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	1,
	7,
	1, -- 진행요원
	'아마도요. 깃발이 가리키는 곳에서 첫 번째 기록을 찾아보세요.'
);

-- 1번 방 - 2번 오브젝트
INSERT INTO CHAT VALUES(
	3,
	1,
	2,
	1,
	2, -- 주인공
	'비석에는 이름이 굉장히 많이 적혀 있는데?'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	2,
	2,
	1, -- 진행요원
	'자세히 보세요. 이름만 있는 게 아니에요. 날짜와 함께 여러 행동에 대한 기록도 남아 있어요.'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	2,
	3,
	2, -- 주인공
	'"성벽 보수", "식량 운반", "부상자 지원"... 전부 사람들이 직접 했던 일이네.'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	2,
	4,
	0, -- 시스템
	'기록 일부가 손상되어 있습니다. 남아 있는 문장만으로 원래의 내용을 복원해야 합니다.'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	2,
	5,
	2, -- 주인공
	'누가 얼마나 큰 일을 했는지가 아니라, 뭘 했는지를 기록해 놓은 거구나.'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	2,
	6,
	1, -- 진행요원
	'맞아요. 어쩌면 이곳에서 찾고 있는 기록도 유명한 사람들의 기록이 아닐 수 있어요.'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	2,
	7,
	2, -- 주인공
	'평범한 사람들이 했던 행동?'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	2,
	8,
	1, -- 진행요원
	'그 가능성을 기억해두세요.'
);

-- 1번 방 - 3번 오브젝트
INSERT INTO CHAT VALUES(
	3,
	1,
	3,
	1,
	0, -- 시스템
	'돌문에 작은 문양이 새겨져 있습니다. 문양은 현재의 동래구 지도와 비슷한 형태를 보입니다.'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	3,
	2,
	2, -- 주인공
	'이게 동래의 옛 지도였던 건가?'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	3,
	3,
	1, -- 진행요원
	'아마 그런 것 같아요. 그런데 이상하네요. 지도에 표시된 장소 중 몇 곳은 지금도 존재하고 있어요.'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	3,
	4,
	2, -- 주인공
	'그러면 도시 자체가 완전히 사라진 건 아니네.'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	3,
	5,
	1, -- 진행요원
	'네. 건물과 길은 남아 있는데, 그곳에서 일어나던 무언가가 사라진 것일 수도 있어요.'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	3,
	6,
	2, -- 주인공
	'건물이 아니라... 사람들이 하던 행동이?'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	3,
	7,
	0, -- 시스템
	'돌문에서 새로운 문장이 확인되었습니다.'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	3,
	8,
	0, -- 시스템
	'「장소가 남아 있어도, 그곳을 움직이던 손길이 사라지면 기록은 멈춘다.」'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	3,
	9,
	2, -- 주인공
	'점점 우리가 찾아야 할 게 뭔지 알 것 같아.'
);

-- 1번 방 - 4번 오브젝트
INSERT INTO CHAT VALUES(
	3,
	1,
	4,
	1,
	2, -- 주인공
	'보물상자라니... 드디어 진짜 보물인가?'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	4,
	2,
	1, -- 진행요원
	'지금까지 나온 것들을 생각하면 돈이나 보석은 아닐 것 같은데요.'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	4,
	3,
	2, -- 주인공
	'하긴. 이 게임에서 보물을 찾은 적은 한 번도 없으니까.'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	4,
	4,
	0, -- 시스템
	'상자에는 금화나 귀중품 대신 여러 장의 작은 종이가 들어 있습니다.'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	4,
	5,
	2, -- 주인공
	'이건 사람 이름이네.'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	4,
	6,
	1, -- 진행요원
	'그리고 옆에는 날짜와 활동 내용이 적혀 있어요.'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	4,
	7,
	2, -- 주인공
	'성벽을 고친 사람, 물을 나른 사람, 길을 정리한 사람...'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	4,
	8,
	1, -- 진행요원
	'서로 모르는 사람들이 같은 일을 했던 기록이에요.'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	4,
	9,
	2, -- 주인공
	'그 사람들이 대가를 받고 한 일인지도 모르겠는데?'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	4,
	10,
	0, -- 시스템
	'보물상자 마지막 부분에서 한 문장이 발견되었습니다.'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	4,
	11,
	0, -- 시스템
	'「가장 오래 남는 보물은 누군가를 위해 남긴 시간이다.」'
);

-- 1번 방 - 5번 오브젝트
INSERT INTO CHAT VALUES(
	3,
	1,
	5,
	1,
	2, -- 주인공
	'이 문이 다음 장소로 이어지는 건가?'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	5,
	2,
	1, -- 진행요원
	'아마도요. 지금까지 찾은 단서들을 보면 다음 기록은 사람들이 실제로 생활하던 곳에 있을 가능성이 높아요.'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	5,
	3,
	2, -- 주인공
	'시장 같은 곳?'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	5,
	4,
	0, -- 시스템
	'출입문에서 마지막 기록이 발견되었습니다.'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	5,
	5,
	0, -- 시스템
	'「성은 사람들이 지켰고, 마을은 사람들이 돌보았다.」'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	5,
	6,
	2, -- 주인공
	'그렇다면 다음에는 사람들이 살아가던 공간을 찾아야겠네.'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	5,
	7,
	1, -- 진행요원
	'맞아요. 하지만 기억하세요. 지금까지의 기록에는 공통점이 하나 있습니다.'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	5,
	8,
	2, -- 주인공
	'서로 다른 사람들이 같은 공간을 위해 움직였다는 것.'
);
INSERT INTO CHAT VALUES(
	3,
	1,
	5,
	9,
	1, -- 진행요원
	'바로 그겁니다.'
);

-- 2번 방 - 1번 오브젝트
INSERT INTO CHAT VALUES(
	3,
	2,
	1,
	1,
	2, -- 주인공
	'첫 번째부터 쓰레기 봉투네.'
);
INSERT INTO CHAT VALUES(
	3,
	2,
	1,
	2,
	1, -- 진행요원
	'시장이라면 이상하지는 않지만... 저걸 보세요.'
);
INSERT INTO CHAT VALUES(
	3,
	2,
	1,
	3,
	2, -- 주인공
	'주변에 쓰레기가 너무 많아.'
);
INSERT INTO CHAT VALUES(
	3,
	2,
	1,
	4,
	0, -- 시스템
	'기록에는 과거 시장의 청소 활동이 정기적으로 이루어졌다고 표시되어 있습니다.'
);
INSERT INTO CHAT VALUES(
	3,
	2,
	1,
	5,
	2, -- 주인공
	'그런데 지금은 아무도 치우지 않은 것처럼 보이네.'
);
INSERT INTO CHAT VALUES(
	3,
	2,
	1,
	6,
	1, -- 진행요원
	'누군가 한 번 치우지 않았다고 도시가 바로 무너지지는 않겠죠.'
);
INSERT INTO CHAT VALUES(
	3,
	2,
	1,
	7,
	2, -- 주인공
	'하지만 아무도 치우지 않으면?'
);
INSERT INTO CHAT VALUES(
	3,
	2,
	1,
	8,
	1, -- 진행요원
	'작은 문제가 쌓이고, 결국 모두가 불편해지겠죠.'
);

-- 2번 방 - 2번 오브젝트
INSERT INTO CHAT VALUES(
	3,
	2,
	2,
	1,
	0, -- 시스템
	'상자 안에서 오래된 물품 전달 기록이 발견되었습니다.'
);
INSERT INTO CHAT VALUES(
	3,
	2,
	2,
	2,
	2, -- 주인공
	'"식료품 전달", "의약품 전달", "생필품 지원"...'
);
INSERT INTO CHAT VALUES(
	3,
	2,
	2,
	3,
	1, -- 진행요원
	'시장이 단순히 물건을 사고파는 곳만은 아니었던 것 같네요.'
);
INSERT INTO CHAT VALUES(
	3,
	2,
	2,
	4,
	2, -- 주인공
	'필요한 사람이 있으면 다른 사람이 물건을 건네주기도 했던 거구나.'
);
INSERT INTO CHAT VALUES(
	3,
	2,
	2,
	5,
	0, -- 시스템
	'일부 기록에는 금액이 기록되어 있지 않습니다.'
);
INSERT INTO CHAT VALUES(
	3,
	2,
	2,
	6,
	2, -- 주인공
	'돈을 주고받은 기록이 없다고?'
);
INSERT INTO CHAT VALUES(
	3,
	2,
	2,
	7,
	1, -- 진행요원
	'어쩌면 거래가 아니라 도움을 기록한 것일 수도 있어요.'
);

-- 2번 방 - 3번 오브젝트
INSERT INTO CHAT VALUES(
	3,
	2,
	3,
	1,
	2, -- 주인공
	'게시판에 종이가 엄청 많이 붙어 있어.'
);
INSERT INTO CHAT VALUES(
	3,
	2,
	3,
	2,
	1, -- 진행요원
	'대부분 오래된 공지네요.'
);
INSERT INTO CHAT VALUES(
	3,
	2,
	3,
	3,
	2, -- 주인공
	'"시장 청소 참여자 모집", "어르신 이동 지원", "행사 준비 도움 요청"...'
);
INSERT INTO CHAT VALUES(
	3,
	2,
	3,
	4,
	0, -- 시스템
	'게시물의 상당수가 사람들의 참여를 요청하는 내용입니다.'
);
INSERT INTO CHAT VALUES(
	3,
	2,
	3,
	5,
	2, -- 주인공
	'그런데 이상하다.'
);
INSERT INTO CHAT VALUES(
	3,
	2,
	3,
	6,
	1, -- 진행요원
	'뭐가요?'
);
INSERT INTO CHAT VALUES(
	3,
	2,
	3,
	7,
	2, -- 주인공
	'누가 참여했는지는 적혀 있는데, 누가 돈을 냈는지는 적혀 있지 않아.'
);
INSERT INTO CHAT VALUES(
	3,
	2,
	3,
	8,
	1, -- 진행요원
	'중요한 건 돈이 아니었던 거겠죠.'
);
INSERT INTO CHAT VALUES(
	3,
	2,
	3,
	9,
	2, -- 주인공
	'그럼... 사람들의 시간과 행동 자체가 기록이었던 거네.'
);

-- 2번 방 - 4번 오브젝트
INSERT INTO CHAT VALUES(
	3,
	2,
	4,
	1,
	2, -- 주인공
	'전구가 왜 여기 있는 거지?'
);
INSERT INTO CHAT VALUES(
	3,
	2,
	4,
	2,
	1, -- 진행요원
	'전구 옆을 보세요. 오래된 작업 기록이 있어요.'
);
INSERT INTO CHAT VALUES(
	3,
	2,
	4,
	3,
	2, -- 주인공
	'"야간 시장 조명 점검."'
);
INSERT INTO CHAT VALUES(
	3,
	2,
	4,
	4,
	0, -- 시스템
	'전기 시설 관리 담당자가 아닌 주민들도 조명 점검에 참여했던 기록이 있습니다.'
);
INSERT INTO CHAT VALUES(
	3,
	2,
	4,
	5,
	2, -- 주인공
	'전문가가 아닌 사람들도 같이 관리했다고?'
);
INSERT INTO CHAT VALUES(
	3,
	2,
	4,
	6,
	1, -- 진행요원
	'작은 일이라도 누군가 해야 하니까요.'
);
INSERT INTO CHAT VALUES(
	3,
	2,
	4,
	7,
	2, -- 주인공
	'한 사람이 모든 걸 하는 게 아니라, 여러 사람이 조금씩 맡았던 거네.'
);

-- 2번 방 - 5번 오브젝트
INSERT INTO CHAT VALUES(
	3,
	2,
	5,
	1,
	2, -- 주인공
	'의자 하나가 덩그러니 놓여 있네.'
);
INSERT INTO CHAT VALUES(
	3,
	2,
	5,
	2,
	0, -- 시스템
	'의자에 앉는 사람을 위한 안내문이 발견되었습니다.'
);
INSERT INTO CHAT VALUES(
	3,
	2,
	5,
	3,
	0, -- 시스템
	'「잠시 쉬어가세요. 필요한 사람이 먼저 앉을 수 있도록 자리를 비워주세요.」'
);
INSERT INTO CHAT VALUES(
	3,
	2,
	5,
	4,
	2, -- 주인공
	'그냥 의자인데도 다른 사람을 배려하라는 내용이네.'
);
INSERT INTO CHAT VALUES(
	3,
	2,
	5,
	5,
	1, -- 진행요원
	'지금까지 발견한 기록도 비슷했죠.'
);
INSERT INTO CHAT VALUES(
	3,
	2,
	5,
	6,
	2, -- 주인공
	'청소하고, 물건을 나누고, 행사에 참여하고, 시설을 관리하고...'
);
INSERT INTO CHAT VALUES(
	3,
	2,
	5,
	7,
	1, -- 진행요원
	'전부 아주 작은 행동이에요.'
);
INSERT INTO CHAT VALUES(
	3,
	2,
	5,
	8,
	2, -- 주인공
	'그런데 그런 행동들이 모이면 도시 전체가 달라지는 거고.'
);
INSERT INTO CHAT VALUES(
	3,
	2,
	5,
	9,
	0, -- 시스템
	'의자 아래에서 다음 장소를 가리키는 기록이 발견되었습니다.'
);

-- 3번 방 - 1번 오브젝트
INSERT INTO CHAT VALUES(
	3,
	3,
	1,
	1,
	2, -- 주인공
	'이번에는 그냥 돌인데?'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	1,
	2,
	1, -- 진행요원
	'그냥 돌처럼 보여도 주변을 한번 살펴보세요.'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	1,
	3,
	2, -- 주인공
	'돌 주변에 물길이 정리되어 있네.'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	1,
	4,
	0, -- 시스템
	'과거 기록에 하천 주변의 돌과 물길을 정리한 활동이 확인됩니다.'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	1,
	5,
	2, -- 주인공
	'이런 것도 사람들이 직접 했던 거야?'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	1,
	6,
	1, -- 진행요원
	'네. 눈에 잘 띄지 않는 일이지만 누군가는 해야 했겠죠.'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	1,
	7,
	2, -- 주인공
	'우리가 찾던 기록은 계속 이런 것만 나오네.'
);

-- 3번 방 - 2번 오브젝트
INSERT INTO CHAT VALUES(
	3,
	3,
	2,
	1,
	2, -- 주인공
	'나무에도 기록이 남아 있어?'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	2,
	2,
	0, -- 시스템
	'나무의 식재 날짜와 관리 기록이 확인됩니다.'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	2,
	3,
	2, -- 주인공
	'물을 주고, 주변을 정리하고, 상태를 확인했다는 내용이네.'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	2,
	4,
	1, -- 진행요원
	'누군가 심는 것보다 중요한 건 계속 돌보는 일이기도 하죠.'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	2,
	5,
	2, -- 주인공
	'한 번의 행동으로 끝나는 게 아니구나.'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	2,
	6,
	1, -- 진행요원
	'도시도 마찬가지일 거예요.'
);

-- 3번 방 - 3번 오브젝트
INSERT INTO CHAT VALUES(
	3,
	3,
	3,
	1,
	2, -- 주인공
	'작은 배가 물 위에 떠 있어.'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	3,
	2,
	1, -- 진행요원
	'배 안쪽을 확인해 보세요.'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	3,
	3,
	2, -- 주인공
	'청소 도구가 들어 있어.'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	3,
	4,
	0, -- 시스템
	'과거 온천천 정화 활동에서 사용되었던 도구로 확인됩니다.'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	3,
	5,
	2, -- 주인공
	'설마 이걸 타고 쓰레기를 치운 거야?'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	3,
	6,
	1, -- 진행요원
	'기록상으로는 그렇습니다.'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	3,
	7,
	2, -- 주인공
	'시장에서 봤던 기록하고 똑같네.'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	3,
	8,
	1, -- 진행요원
	'사람들이 자신의 공간을 직접 관리했다는 점에서요.'
);

-- 3번 방 - 4번 오브젝트
INSERT INTO CHAT VALUES(
	3,
	3,
	4,
	1,
	2, -- 주인공
	'갑자기 풍선?'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	4,
	2,
	1, -- 진행요원
	'주변에 행사 기록이 있는 것 같아요.'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	4,
	3,
	2, -- 주인공
	'"온천천 주민 행사."'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	4,
	4,
	0, -- 시스템
	'행사 준비, 안전 관리, 환경 정리 등에 참여한 사람들의 기록입니다.'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	4,
	5,
	2, -- 주인공
	'행사를 즐기는 사람뿐 아니라 준비하는 사람들도 있었던 거네.'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	4,
	6,
	1, -- 진행요원
	'그리고 행사가 끝난 뒤 정리하는 사람도 있었겠죠.'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	4,
	7,
	2, -- 주인공
	'보이지 않는 사람이 많았겠네.'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	4,
	8,
	1, -- 진행요원
	'바로 그 점이 중요해 보여요.'
);

-- 3번 방 - 5번 오브젝트
INSERT INTO CHAT VALUES(
	3,
	3,
	5,
	1,
	2, -- 주인공
	'이제 구름까지 조사해야 하는 거야?'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	5,
	2,
	1, -- 진행요원
	'구름 자체보다 그 아래를 보세요.'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	5,
	3,
	2, -- 주인공
	'온천천 전체가 보이네.'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	5,
	4,
	0, -- 시스템
	'지금까지 발견한 모든 기록이 하나의 문장으로 연결됩니다.'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	5,
	5,
	0, -- 시스템
	'「누군가에게는 작은 일이었지만, 누군가에게는 도시를 유지하는 일이었다.」'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	5,
	6,
	2, -- 주인공
	'이제 알 것 같아.'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	5,
	7,
	1, -- 진행요원
	'무엇을요?'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	5,
	8,
	2, -- 주인공
	'우리가 찾고 있는 건 특정한 사건이나 물건이 아니야.'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	5,
	9,
	1, -- 진행요원
	'그렇다면 무엇일까요?'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	5,
	10,
	2, -- 주인공
	'사람들이 서로를 위해 했던 행동들.'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	5,
	11,
	0, -- 시스템
	'새로운 위치 정보가 활성화되었습니다.'
);
INSERT INTO CHAT VALUES(
	3,
	3,
	5,
	12,
	0, -- 시스템
	'다음 기록 위치: 자원봉사센터'
);

-- 4번 방 - 1번 오브젝트
INSERT INTO CHAT VALUES(
	3,
	4,
	1,
	1,
	2, -- 주인공
	'칠판에 일정표가 적혀 있어.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	1,
	2,
	1, -- 진행요원
	'내용을 읽어보세요.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	1,
	3,
	2, -- 주인공
	'청소, 배식, 환경 정리, 행사 지원, 어르신 도움...'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	1,
	4,
	0, -- 시스템
	'모든 활동에는 담당자와 참여 날짜가 기록되어 있습니다.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	1,
	5,
	2, -- 주인공
	'지금까지 봤던 것들이 전부 모여 있네.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	1,
	6,
	1, -- 진행요원
	'동래읍성에서 시작해서 시장과 온천천까지 이어졌던 활동들이죠.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	1,
	7,
	2, -- 주인공
	'결국 같은 사람들이 같은 행동을 반복했던 게 아니라...'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	1,
	8,
	1, -- 진행요원
	'서로 다른 사람들이 필요한 곳에서 역할을 맡았던 거예요.'
);

-- 4번 방 - 2번 오브젝트
INSERT INTO CHAT VALUES(
	3,
	4,
	2,
	1,
	0, -- 시스템
	'오래된 TV에서 도시 붕괴 당시의 영상 기록이 재생됩니다.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	2,
	2,
	2, -- 주인공
	'사람들이 떠나고 있어...'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	2,
	3,
	1, -- 진행요원
	'화면 오른쪽을 보세요.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	2,
	4,
	2, -- 주인공
	'쓰레기가 쌓이고, 하천 관리도 멈췄네.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	2,
	5,
	0, -- 시스템
	'영상 기록에는 여러 시설의 관리 중단 시점이 표시되어 있습니다.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	2,
	6,
	2, -- 주인공
	'건물이 무너져서 도시가 망한 게 아니었어.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	2,
	7,
	1, -- 진행요원
	'네.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	2,
	8,
	2, -- 주인공
	'사람들이 하나씩 하던 일을 멈추면서 도시가 무너진 거야.'
);

-- 4번 방 - 3번 오브젝트
INSERT INTO CHAT VALUES(
	3,
	4,
	3,
	1,
	2, -- 주인공
	'화분 하나가 남아 있네.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	3,
	2,
	1, -- 진행요원
	'아직 살아 있는 것 같아요.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	3,
	3,
	2, -- 주인공
	'이런 곳에서 살아남았다는 게 신기한데.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	3,
	4,
	0, -- 시스템
	'화분 관리 기록이 발견되었습니다.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	3,
	5,
	2, -- 주인공
	'물을 준 사람들의 이름이 계속 바뀌어 있어.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	3,
	6,
	1, -- 진행요원
	'한 사람이 계속 관리한 게 아니네요.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	3,
	7,
	2, -- 주인공
	'누군가가 못 오면 다른 사람이 대신 돌본 거구나.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	3,
	8,
	1, -- 진행요원
	'그렇죠.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	3,
	9,
	2, -- 주인공
	'결국 중요한 건 누가 했느냐가 아니라, 누군가가 계속 이어갔다는 거네.'
);

-- 4번 방 - 4번 오브젝트
INSERT INTO CHAT VALUES(
	3,
	4,
	4,
	1,
	2, -- 주인공
	'신발 한 켤레가 놓여 있어.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	4,
	2,
	0, -- 시스템
	'신발의 이동 기록을 확인할 수 있습니다.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	4,
	3,
	2, -- 주인공
	'이동 기록?'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	4,
	4,
	1, -- 진행요원
	'여러 장소의 활동 기록과 일치하네요.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	4,
	5,
	2, -- 주인공
	'동래읍성, 시장, 온천천...'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	4,
	6,
	1, -- 진행요원
	'한 장소에서 끝난 게 아니라 계속 다른 장소로 이동했던 거예요.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	4,
	7,
	2, -- 주인공
	'필요한 곳으로 직접 찾아갔다는 뜻이네.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	4,
	8,
	0, -- 시스템
	'신발 밑창에서 마지막 기록이 발견되었습니다.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	4,
	9,
	0, -- 시스템
	'「도움을 기다리는 곳이 있다면, 누군가는 그곳으로 걸어갔다.」'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	4,
	10,
	2, -- 주인공
	'이제 거의 답에 가까워진 것 같은데...'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	4,
	11,
	1, -- 진행요원
	'하지만 마지막 기록을 확인하기 전까지는 판단하지 마세요.'
);

-- 4번 방 - 5번 오브젝트
INSERT INTO CHAT VALUES(
	3,
	4,
	5,
	1,
	2, -- 주인공
	'마지막은 펜이네.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	5,
	2,
	1, -- 진행요원
	'기록을 남기는 물건이네요.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	5,
	3,
	2, -- 주인공
	'지금까지 찾은 모든 기록도 결국 누군가가 남긴 거였지.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	5,
	4,
	0, -- 시스템
	'펜 옆에서 마지막 문서가 발견되었습니다.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	5,
	5,
	0, -- 시스템
	'「도시는 건물로 만들어지지 않는다. 사람들의 작은 행동이 쌓여 도시가 된다.」'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	5,
	6,
	2, -- 주인공
	'이제 이해했어.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	5,
	7,
	1, -- 진행요원
	'무엇을 이해했나요?'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	5,
	8,
	2, -- 주인공
	'동래읍성에서는 성을 지키는 사람들이 있었고, 시장에서는 서로 필요한 것을 나누는 사람들이 있었고, 온천천에서는 환경을 관리하는 사람들이 있었어.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	5,
	9,
	1, -- 진행요원
	'그리고 그 행동들이 모두 사라지면서 도시도 무너졌죠.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	5,
	10,
	2, -- 주인공
	'결국 우리가 복구해야 했던 건 건물이나 시설이 아니었어.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	5,
	11,
	0, -- 시스템
	'지금까지 수집한 기록을 모두 분석합니다.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	5,
	12,
	2, -- 주인공
	'사람들이 서로를 위해 내놓았던 시간과 행동.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	5,
	13,
	1, -- 진행요원
	'그렇다면 마지막으로 남은 질문은 하나네요.'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	5,
	14,
	2, -- 주인공
	'이 모든 행동을 하나의 말로 표현한다면 무엇일까?'
);
INSERT INTO CHAT VALUES(
	3,
	4,
	5,
	15,
	0, -- 시스템
	'최종 기록 복구 준비가 완료되었습니다.'
);

/* -------------------- 힌트 -------------------- */
-- 1번 방 - 1번 오브젝트
INSERT INTO CHAT VALUES(
	4,
	1,
	1,
	1,
	1, -- 진행요원
	'자원봉사의 ‘자발성’은 다른 사람의 요구가 아니라 자신의 의지로 참여하는 것을 의미한다.'
);

-- 1번 방 - 2번 오브젝트
INSERT INTO CHAT VALUES(
	4,
	1,
	2,
	1,
	1, -- 진행요원
	'책임감은 자신에게 맡겨진 역할을 끝까지 성실하게 수행하는 태도와 관련이 있다.'
);

-- 1번 방 - 3번 오브젝트
INSERT INTO CHAT VALUES(
	4,
	1,
	3,
	1,
	1, -- 진행요원
	'자원봉사는 금전적인 보상이나 이익을 받기 위한 활동이 아니라는 점을 생각해 보자.'
);

-- 1번 방 - 4번 오브젝트
INSERT INTO CHAT VALUES(
	4,
	1,
	4,
	1,
	1, -- 진행요원
	'봉사활동 중 알게 된 개인정보나 사적인 내용은 다른 사람에게 함부로 알려서는 안 된다.'
);

-- 1번 방 - 5번 오브젝트
INSERT INTO CHAT VALUES(
	4,
	1,
	5,
	1,
	1, -- 진행요원
	'봉사활동에서는 상대방을 존중하고 배려하는 태도가 중요하다는 점을 생각해 보자.'
);

-- 2번 방 - 1번 오브젝트
INSERT INTO CHAT VALUES(
	4,
	2,
	1,
	1,
	1, -- 진행요원
	'자원봉사는 개인의 이익보다 사회에 필요한 일을 자신의 의지로 돕는 활동이라는 점을 생각해 보자.'
);

-- 2번 방 - 2번 오브젝트
INSERT INTO CHAT VALUES(
	4,
	2,
	2,
	1,
	1, -- 진행요원
	'자원봉사는 서로를 배려하고 함께 나누는 마음에서 시작된다는 점을 생각해 보자.'
);

-- 2번 방 - 3번 오브젝트
INSERT INTO CHAT VALUES(
	4,
	2,
	3,
	1,
	1, -- 진행요원
	'자원봉사는 봉사자와 지역사회가 서로 도움을 주고받으며 함께 성장하는 활동이라는 점을 생각해 보자.'
);

-- 2번 방 - 4번 오브젝트
INSERT INTO CHAT VALUES(
	4,
	2,
	4,
	1,
	1, -- 진행요원
	'자원봉사에서는 단순한 결과뿐 아니라 참여하는 과정에서의 마음가짐과 태도도 중요하다.'
);

-- 2번 방 - 5번 오브젝트
INSERT INTO CHAT VALUES(
	4,
	2,
	5,
	1,
	1, -- 진행요원
	'자원봉사는 개인의 이익보다 공동체와 이웃을 위한 마음이 중요하다는 점을 생각해 보자.'
);

-- 3번 방 - 1번 오브젝트
INSERT INTO CHAT VALUES(
	4,
	3,
	1,
	1,
	1, -- 진행요원
	'봉사활동을 신청하기 전에는 활동에 필요한 기본 정보를 꼼꼼히 확인하는 것이 중요하다.'
);

-- 3번 방 - 2번 오브젝트
INSERT INTO CHAT VALUES(
	4,
	3,
	2,
	1,
	1, -- 진행요원
	'봉사활동은 다른 사람의 선택보다 내가 책임감을 가지고 꾸준히 참여할 수 있는지를 먼저 생각해 보자.'
);

-- 3번 방 - 3번 오브젝트
INSERT INTO CHAT VALUES(
	4,
	3,
	3,
	1,
	1, -- 진행요원
	'봉사활동은 자신의 상황과 관심사를 고려하여 시간과 거리 등을 종합적으로 살펴보는 것이 좋다.'
);

-- 3번 방 - 4번 오브젝트
INSERT INTO CHAT VALUES(
	4,
	3,
	4,
	1,
	1, -- 진행요원
	'버려지는 물건을 그냥 버리지 않고 새로운 디자인과 쓰임을 더해 다시 활용하는 방법을 떠올려 보자.'
);

-- 3번 방 - 5번 오브젝트
INSERT INTO CHAT VALUES(
	4,
	3,
	5,
	1,
	1, -- 진행요원
	'시각장애인이 책이나 정보를 안전하고 편리하게 이용할 수 있도록 돕는 활동이라는 점을 생각해 보자.'
);

-- 4번 방 - 1번 오브젝트
INSERT INTO CHAT VALUES(
	4,
	4,
	1,
	1,
	1, -- 진행요원
	'봉사활동 중 사고가 발생하면 혼자 판단하지 말고 즉시 담당자에게 상황을 알리는 것이 중요하다.'
);

-- 4번 방 - 2번 오브젝트
INSERT INTO CHAT VALUES(
	4,
	4,
	2,
	1,
	1, -- 진행요원
	'자신과 다른 사람의 안전을 지키기 위해서는 현장에서 정해진 안전에 관한 규칙을 준수해야 한다.'
);

-- 4번 방 - 3번 오브젝트
INSERT INTO CHAT VALUES(
	4,
	4,
	3,
	1,
	1, -- 진행요원
	'봉사활동에서는 다른 사람을 돕는 것만큼 자신의 안전과 주변 사람의 안전을 지키는 것도 중요하다.'
);

-- 4번 방 - 4번 오브젝트
INSERT INTO CHAT VALUES(
	4,
	4,
	4,
	1,
	1, -- 진행요원
	'사용법을 모르는 도구는 혼자 판단해 사용하지 말고, 담당자에게 안전한 사용 방법을 먼저 확인해 보자.'
);

-- 4번 방 - 5번 오브젝트
INSERT INTO CHAT VALUES(
	4,
	4,
	5,
	1,
	1, -- 진행요원
	'자원봉사에서 책임은 정해진 약속을 지키고 자신에게 맡겨진 역할을 성실히 수행하는 태도이다.'
);

/* -------------------- 방 클리어 -------------------- */
-- 1번 방
INSERT INTO CHAT VALUES(
	5,
	1,
	0,
	1,
	0, -- 시스템
	'동래읍성 행동 기록 복구 완료.'
);
INSERT INTO CHAT VALUES(
	5,
	1,
	0,
	2,
	0, -- 시스템
	'CODE [자]'
);
INSERT INTO CHAT VALUES(
	5,
	1,
	0,
	3,
	2, -- 주인공
	'자...'
);
INSERT INTO CHAT VALUES(
	5,
	1,
	0,
	4,
	1, -- 진행요원
	'이 도시를 움직였던 사람들은 명령을 기다리지 않았어요.'
);
INSERT INTO CHAT VALUES(
	5,
	1,
	0,
	5,
	2, -- 주인공
	'필요한 일을 스스로 선택했어.'
);
INSERT INTO CHAT VALUES(
	5,
	1,
	0,
	6,
	0, -- 시스템
	'UNKNOWN BEHAVIOR 복구율 25%'
);

-- 2번 방
INSERT INTO CHAT VALUES(
	5,
	2,
	0,
	1,
	0, -- 시스템
	'공동체 연결망 일부 복구.'
);
INSERT INTO CHAT VALUES(
	5,
	2,
	0,
	2,
	0, -- 시스템
	'CODE [원]'
);
INSERT INTO CHAT VALUES(
	5,
	2,
	0,
	3,
	2, -- 주인공
	'자... 원...'
);
INSERT INTO CHAT VALUES(
	5,
	2,
	0,
	4,
	1, -- 진행요원
	'두 글자가 연결됐네요.'
);
INSERT INTO CHAT VALUES(
	5,
	2,
	0,
	5,
	2, -- 주인공
	'자원?'
);

INSERT INTO CHAT VALUES(
	5,
	2,
	0,
	6,
	1, -- 진행요원
	'아직 판단하기엔 일러요.'
);
-- 3번 방
INSERT INTO CHAT VALUES(
	5,
	3,
	0,
	1,
	0, -- 시스템
	'ARCHIVE RECOVERY: 환경정화 활동, 취약계층 지원, 장애인 지원, 재난복구, 문화행사 지원, 안전 활동, 교육 활동'
);
INSERT INTO CHAT VALUES(
	5,
	3,
	0,
	2,
	0, -- 시스템
	'공통 분류 검색 중'
);
INSERT INTO CHAT VALUES(
	5,
	3,
	0,
	3,
	0, -- 시스템
	'분류명 : 「자원봉사」'
);
INSERT INTO CHAT VALUES(
	5,
	3,
	0,
	4,
	2, -- 주인공
	'자원... 봉사?'
);
INSERT INTO CHAT VALUES(
	5,
	3,
	0,
	5,
	1, -- 진행요원
	'찾았네요.'
);
INSERT INTO CHAT VALUES(
	5,
	3,
	0,
	6,
	2, -- 주인공
	'지금까지 우리가 찾은 행동들이 전부...'
);
INSERT INTO CHAT VALUES(
	5,
	3,
	0,
	7,
	1, -- 진행요원
	'네. 과거에는 이 행동들을 ''자원봉사''라고 불렀어요.'
);
INSERT INTO CHAT VALUES(
	5,
	3,
	0,
	8,
	0, -- 시스템
	'CODE [봉]'
);
INSERT INTO CHAT VALUES(
	5,
	3,
	0,
	9,
	2, -- 주인공
	'그럼 마지막 글자는...'
);
INSERT INTO CHAT VALUES(
	5,
	3,
	0,
	10,
	0, -- 시스템
	'ERROR: CENTRAL ARCHIVE DETECTED'
);

-- 4번 방
INSERT INTO CHAT VALUES(
	5,
	4,
	0,
	1,
	0, -- 시스템
	'코드 획득: [사]'
);
INSERT INTO CHAT VALUES(
	5,
	4,
	0,
	2,
	0, -- 시스템
	'코드 입력:'
);
INSERT INTO CHAT VALUES(
	5,
	4,
	0,
	3,
	1, -- 진행요원
	'이제 입력하세요.'
);
INSERT INTO CHAT VALUES(
	5,
	4,
	0,
	4,
	2, -- 주인공
	'...이건...'
);

/* -------------------- 성공 엔딩 -------------------- */
INSERT INTO CHAT VALUES(
	6,
	0,
	0,
	1,
	0, -- 시스템
	'정답 확인 완료'
);
INSERT INTO CHAT VALUES(
	6,
	0,
	0,
	2,
	0, -- 시스템
	'입력된 기록 - 「자원봉사」'
);
INSERT INTO CHAT VALUES(
	6,
	0,
	0,
	3,
	1, -- 진행요원
	'복구되고 있어요!'
);
INSERT INTO CHAT VALUES(
	6,
	0,
	0,
	4,
	1, -- 진행요원
	'사라졌던 기록들이 하나씩 돌아오고 있어요.'
);
INSERT INTO CHAT VALUES(
	6,
	0,
	0,
	5,
	2, -- 주인공
	'...이 도시를 지탱하던 건, 결국 사람이었네.'
);
INSERT INTO CHAT VALUES(
	6,
	0,
	0,
	6,
	1, -- 진행요원
	'네. 누군가 먼저 나서고, 누군가를 돕고, 함께 움직였던 기록들.'
);
INSERT INTO CHAT VALUES(
	6,
	0,
	0,
	7,
	0, -- 시스템
	'복구율 100%. 동래구 정상화 완료.'
);
INSERT INTO CHAT VALUES(
	6,
	0,
	0,
	8,
	2, -- 주인공
	'기록이 사라진 게 아니었어.'
);
INSERT INTO CHAT VALUES(
	6,
	0,
	0,
	9,
	2, -- 주인공
	'우리가 그 가치를 잊고 있었던 거야.'
);
INSERT INTO CHAT VALUES(
	6,
	0,
	0,
	10,
	1, -- 진행요원
	'이제 다시 시작할 수 있어요.'
);
INSERT INTO CHAT VALUES(
	6,
	0,
	0,
	11,
	0, -- 시스템
	'복구 작업을 종료합니다.'
);

/* -------------------- 실패 엔딩 -------------------- */
INSERT INTO CHAT VALUES(
	7,
	0,
	0,
	1,
	0, -- 시스템
	'시간 초과'
);
INSERT INTO CHAT VALUES(
	7,
	0,
	0,
	2,
	1, -- 진행요원
	'늦었어요.'
);
INSERT INTO CHAT VALUES(
	7,
	0,
	0,
	3,
	2, -- 주인공
	'...조금만 더 시간이 있었다면.'
);
INSERT INTO CHAT VALUES(
	7,
	0,
	0,
	4,
	1, -- 진행요원
	'시간이 부족했던 게 아니에요.'
);
INSERT INTO CHAT VALUES(
	7,
	0,
	0,
	5,
	1, -- 진행요원
	'사라진 기록을 찾는 동안, 우리가 왜 이걸 복구해야 하는지 잊어버린 거죠.'
);
INSERT INTO CHAT VALUES(
	7,
	0,
	0,
	6,
	2, -- 주인공
	'...'
);
INSERT INTO CHAT VALUES(
	7,
	0,
	0,
	7,
	1, -- 진행요원
	'도시가 무너진 이유도 결국 같았을 거예요. 아무도 서로의 행동을 기억하지 않았으니까.'
);
INSERT INTO CHAT VALUES(
	7,
	0,
	0,
	8,
	0, -- 시스템
	'복구되지 않은 기록이 존재합니다.'
);
INSERT INTO CHAT VALUES(
	7,
	0,
	0,
	9,
	0, -- 시스템
	'동래구 정상화 실패.'
);
INSERT INTO CHAT VALUES(
	7,
	0,
	0,
	10,
	2, -- 주인공
	'...아직 끝난 건 아니겠지.'
);
INSERT INTO CHAT VALUES(
	7,
	0,
	0,
	11,
	0, -- 시스템
	'기록 복구 작업을 종료합니다.'
);

COMMIT;