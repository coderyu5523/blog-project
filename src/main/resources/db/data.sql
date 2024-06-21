insert into user_tb(username,password,email,phone,created_at) values ('ssar','1234','ssar@nate.com','01012345678',now());
insert into user_tb(username,password,email,phone,created_at) values ('user1','1234','user1@nate.com','01011112222',now());
insert into user_tb(username,password,email,phone,created_at) values ('user2','1234','user2@nate.com','01022223333',now());
insert into user_tb(username,password,email,phone,created_at) values ('user3','1234','user3@nate.com','01033334444',now());
insert into user_tb(username,password,email,phone,created_at) values ('user4','1234','user4@nate.com','01044445555',now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('축구 경기 리뷰: 팀 A vs 팀 B', '팀 A와 팀 B의 치열한 경기가 펼쳐졌습니다. 경기 결과는 2-1로 팀 A가 승리하였습니다.', '스포츠', null, 1, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('야구 경기 예고: 선수 소개 및 분석', '다음 주 열릴 야구 경기에서 주목할 선수들과 경기 분석을 제공합니다.', '스포츠', null, 2, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('농구 시즌 개막: 주요 팀과 선수들', '이번 농구 시즌의 주요 팀과 선수들을 소개합니다. 팬들이 기대할 만한 포인트들을 짚어봅니다.', '스포츠', null, 3, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('테니스 대회 결승전: 선수 인터뷰', '테니스 대회 결승전에 진출한 선수들과의 인터뷰를 통해 그들의 각오와 전략을 들어봅니다.', '스포츠', null, 4, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('올림픽 메달 순위 업데이트', '현재 올림픽 메달 순위를 업데이트합니다. 각국의 메달 획득 현황과 주요 경기 결과를 전해드립니다.', '스포츠', null, 5, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('마라톤 대회 준비 요령', '마라톤 대회에 참가하기 위한 준비 요령과 훈련 방법을 소개합니다. 초보자도 쉽게 따라 할 수 있습니다.', '스포츠', null, 1, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('수영 대회 주요 이슈 및 결과', '최근 열린 수영 대회의 주요 이슈와 경기 결과를 정리합니다. 선수들의 기록과 인터뷰도 포함됩니다.', '스포츠', null, 2, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('배드민턴 경기 전략 및 팁', '배드민턴 경기를 위한 전략과 팁을 소개합니다. 초보자도 쉽게 배울 수 있는 기본 기술부터 고급 전략까지 다룹니다.', '스포츠', null, 3, now());


INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('최신 게임 출시 소식', '올해 가장 기대되는 게임이 드디어 출시되었습니다. 게임 플레이와 그래픽에 대한 첫인상을 소개합니다.', '게임', null, 4, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('게임 리뷰: 히트맨 3', '히트맨 3의 스토리와 게임 플레이, 그래픽을 중심으로 리뷰를 작성했습니다. 스포일러 주의!', '게임', null, 5, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('게임 공략: 더 위쳐 3', '더 위쳐 3의 주요 퀘스트 공략과 숨겨진 요소들을 찾는 방법을 안내합니다.', '게임', null, 1, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('e스포츠 대회 결과', '최근 열린 e스포츠 대회의 결과를 요약하고, 주요 경기의 하이라이트를 전해드립니다.', '게임', null, 2, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('게임 업데이트 소식', '이번 주 업데이트된 게임 패치 노트와 새로운 기능들에 대해 소개합니다.', '게임', null, 3, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('게임 개발자 인터뷰', '인기 게임의 개발자를 인터뷰하여 게임 개발 과정과 앞으로의 업데이트 계획에 대해 들어보았습니다.', '게임', null, 4, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('인디 게임 추천', '최근 주목받고 있는 인디 게임들을 소개합니다. 저렴한 가격에 높은 퀄리티를 자랑하는 게임들을 모았습니다.', '게임', null, 5, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('게임 커뮤니티 핫이슈', '현재 게임 커뮤니티에서 가장 화제가 되고 있는 주제와 관련된 토론을 소개합니다.', '게임', null, 1, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('게임 이벤트 안내', '다가오는 게임 이벤트에 대한 정보와 참가 방법을 안내합니다. 놓치지 마세요!', '게임', null, 2, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('VR 게임 체험기', '최신 VR 게임을 직접 체험해보고 작성한 리뷰입니다. 몰입감과 그래픽에 대해 자세히 다룹니다.', '게임', null, 3, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('게임 추천: RPG 장르', '올해 주목할 만한 RPG 게임들을 추천합니다. 각 게임의 특징과 장단점을 분석했습니다.', '게임', null, 4, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('모바일 게임 인기 순위', '이번 달 가장 인기 있는 모바일 게임들을 소개합니다. 다운로드 수와 평점 기준으로 순위를 매겼습니다.', '게임', null, 5, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('고전 게임 다시보기', '어린 시절의 추억을 떠올리게 하는 고전 게임들을 다시 플레이해본 경험을 공유합니다.', '게임', null, 1, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('맛있는 파스타 레시피', '집에서 쉽게 만들 수 있는 맛있는 파스타 레시피를 소개합니다.', '음식', null, 1, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('서울 최고의 맛집 추천', '서울에서 꼭 가봐야 할 최고의 맛집을 추천합니다.', '음식', null, 2, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('비건을 위한 맛있는 음식', '비건을 위한 다양한 맛있는 음식들을 소개합니다.', '음식', null, 3, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('달콤한 디저트 레시피', '집에서 만들 수 있는 달콤한 디저트 레시피 모음입니다.', '음식', null, 4, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('간편한 아침 식사 아이디어', '바쁜 아침에 간편하게 준비할 수 있는 아침 식사 아이디어를 공유합니다.', '음식', null, 5, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('한국 전통 음식 소개', '외국인 친구들에게 소개해주기 좋은 한국 전통 음식들을 소개합니다.', '음식', null, 1, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('여름철 시원한 음료 레시피', '더운 여름에 시원하게 즐길 수 있는 음료 레시피를 소개합니다.', '음식', null, 2, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('다이어트에 좋은 음식', '다이어트 중에도 맛있게 먹을 수 있는 음식들을 소개합니다.', '음식', null, 3, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('세계의 길거리 음식', '세계 각국의 다양한 길거리 음식을 소개합니다.', '음식', null, 4, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('특별한 날을 위한 케이크 레시피', '생일이나 기념일에 만들기 좋은 케이크 레시피를 공유합니다.', '음식', null, 5, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('간단한 저녁 식사 아이디어', '간단하게 준비할 수 있는 저녁 식사 아이디어를 소개합니다.', '음식', null, 1, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('건강한 스무디 레시피', '건강하고 맛있는 스무디를 만들 수 있는 레시피를 공유합니다.', '음식', null, 2, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('중국 음식 베스트 10', '한 번쯤 꼭 먹어봐야 할 중국 음식 베스트 10을 소개합니다.', '음식', null, 3, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('간식으로 좋은 홈메이드 요리', '간식으로 즐기기 좋은 홈메이드 요리를 소개합니다.', '음식', null, 4, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('이탈리아 음식 탐방', '이탈리아에서 꼭 먹어봐야 할 음식들을 소개합니다.', '음식', null, 5, now());


INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('올해 최고의 영화 리뷰', '올해 개봉한 최고의 영화를 리뷰합니다. 스토리와 연기, 연출에 대해 자세히 다룹니다.', '영화', null, 1, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('영화 추천: 로맨스 장르', '가장 감동적인 로맨스 영화를 추천합니다. 연인과 함께 보면 좋은 영화들입니다.', '영화', null, 2, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('스릴러 영화 베스트 10', '손에 땀을 쥐게 하는 최고의 스릴러 영화 10편을 소개합니다.', '영화', null, 3, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('애니메이션 영화 추천', '아이들과 함께 보기 좋은 애니메이션 영화를 추천합니다.', '영화', null, 4, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('고전 영화 다시 보기', '영화사에 길이 남을 고전 명작 영화를 다시 보며 감상을 나눕니다.', '영화', null, 5, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('최고의 액션 영화 장면', '가장 짜릿한 액션 장면을 선보인 영화들을 소개합니다.', '영화', null, 1, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('인디 영화 추천', '독특한 매력을 가진 인디 영화를 소개합니다. 예술적이고 실험적인 작품들을 만나보세요.', '영화', null, 2, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('코미디 영화 베스트', '웃음을 보장하는 최고의 코미디 영화를 추천합니다.', '영화', null, 3, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('감독 인터뷰: 영화 제작 비하인드', '유명 감독과의 인터뷰를 통해 영화 제작 과정과 비하인드 스토리를 들어봅니다.', '영화', null, 4, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('영화 속 명대사', '영화 속에서 잊을 수 없는 명대사들을 모아봤습니다.', '영화', null, 5, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('최신 영화 트레일러 모음', '최근 개봉 예정인 영화들의 트레일러를 모아봤습니다.', '영화', null, 1, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('영화 음악 베스트', '영화 속에서 감동을 더해준 최고의 영화 음악을 소개합니다.', '영화', null, 2, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('영화 촬영지 탐방', '유명 영화의 촬영지를 실제로 방문해보고 그 경험을 공유합니다.', '영화', null, 3, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('감동적인 실화 영화', '실화를 바탕으로 한 감동적인 영화를 추천합니다.', '영화', null, 4, now());

INSERT INTO board_tb (title, content, category, board_img, user_id, created_at)
VALUES ('다큐멘터리 영화 추천', '현실을 생생하게 담아낸 최고의 다큐멘터리 영화를 소개합니다.', '영화', null, 5, now());

-- 댓글 더미

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('이번 경기 정말 흥미로웠어요!', 1, 8, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('선수들의 열정이 느껴졌어요.', 2, 8, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('다음 경기가 기대됩니다.', 3, 7, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('팀워크가 정말 훌륭했어요.', 4, 6, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('심판의 판정이 아쉬웠어요.', 5, 5, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('경기 내내 손에 땀을 쥐게 했어요.', 1, 4, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('최고의 경기였습니다!', 2, 3, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('이번 시즌 우승할 것 같아요.', 3, 20, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('선수 인터뷰가 인상적이었어요.', 4, 20, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('다음 시즌도 기대할게요.', 5, 20, now());




INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('이 게임 정말 재미있어요!', 1, 21, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('그래픽이 정말 놀랍네요.', 2, 21, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('다음 업데이트가 기대됩니다.', 3, 21, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('친구들과 함께 플레이하기 좋아요.', 4, 20, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('이 게임의 스토리가 정말 마음에 들어요.', 3, 20, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('캐릭터 디자인이 인상적이에요.', 2, 20, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('버그가 좀 있긴 하지만 전체적으로 만족스러워요.', 1, 20, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('멀티플레이 모드가 더 재미있네요.', 4, 19, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('이 게임에 대한 공략이 필요해요.', 1, 18, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('사운드트랙이 정말 좋네요.', 2, 18, now());


INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('이 레시피 정말 맛있어요!', 2, 36, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('간단하게 따라 할 수 있어서 좋네요.', 3, 35, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('다음에 다른 요리도 소개해 주세요.', 4, 35, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('아이들이 정말 좋아했어요.', 5, 35, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('비건 레시피도 올려주시면 좋겠어요.', 1, 34, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('디저트 레시피 감사합니다.', 2, 33, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('다이어트 중인데, 저칼로리 음식도 부탁드려요.', 3, 33, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('한국 전통 음식에 대해 더 알고 싶어요.', 4, 33, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('다음 주말에 이 요리 해볼게요.', 5, 36, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('정말 유용한 정보 감사합니다.', 1, 35, now());


INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('이 영화 정말 감동적이었어요!', 1, 51, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('스토리가 정말 흥미진진했어요.', 4, 51, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('다음에 또 보고 싶어요.', 5, 51, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('배우들의 연기가 인상적이었어요.', 4, 50, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('OST가 정말 좋았어요.', 3, 50, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('감독의 연출이 뛰어났어요.', 1, 50, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('영화의 메시지가 깊이 와닿았어요.', 1, 49, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('다음에 친구들과 함께 보러 가야겠어요.', 5, 48, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('영화의 결말이 예상치 못했어요.', 4, 48, now());

INSERT INTO reply_tb (comment, user_id, board_id, created_at)
VALUES ('이 영화의 후속편이 기대돼요.', 5, 47, now());



-- 대댓글

INSERT INTO reply2_tb (comment, user_id, reply_id, created_at)
VALUES ('저도 그 경기 봤어요! 정말 대단했죠.', 2, 10, now());

INSERT INTO reply2_tb (comment, user_id, reply_id, created_at)
VALUES ('그 선수의 플레이가 인상적이었어요.', 3, 10, now());

INSERT INTO reply2_tb (comment, user_id, reply_id, created_at)
VALUES ('맞아요, 심판 판정이 아쉬웠어요.', 4, 9 ,now());

INSERT INTO reply2_tb (comment, user_id, reply_id, created_at)
VALUES ('이번 시즌 정말 기대됩니다.', 2, 9, now());

INSERT INTO reply2_tb (comment, user_id, reply_id, created_at)
VALUES ('다음 경기에서도 좋은 결과 있기를!', 1, 8, now());

INSERT INTO reply2_tb (comment, user_id, reply_id, created_at)
VALUES ('이 게임 정말 중독성 있어요.', 1, 20, now());

INSERT INTO reply2_tb (comment, user_id, reply_id, created_at)
VALUES ('업데이트가 빨리 됐으면 좋겠네요.', 2, 20, now());

INSERT INTO reply2_tb (comment, user_id, reply_id, created_at)
VALUES ('친구들과 함께 하면 더 재미있어요.', 5, 19, now());

INSERT INTO reply2_tb (comment, user_id, reply_id, created_at)
VALUES ('버그 수정이 필요해 보여요.', 3, 19, now());

INSERT INTO reply2_tb (comment, user_id, reply_id, created_at)
VALUES ('스토리가 정말 흥미로워요.', 4, 18, now());

INSERT INTO reply2_tb (comment, user_id, reply_id, created_at)
VALUES ('이 레시피 정말 유용해요.', 2, 30, now());

INSERT INTO reply2_tb (comment, user_id, reply_id, created_at)
VALUES ('아이들이 정말 좋아했어요.', 3, 29, now());

INSERT INTO reply2_tb (comment, user_id, reply_id, created_at)
VALUES ('다이어트 레시피도 부탁드려요.', 4, 29, now());

INSERT INTO reply2_tb (comment, user_id, reply_id, created_at)
VALUES ('다음에 이 요리 꼭 해봐야겠어요.', 5, 28, now());

INSERT INTO reply2_tb (comment, user_id, reply_id, created_at)
VALUES ('한국 음식 정말 맛있어요!', 1, 27, now());

INSERT INTO reply2_tb (comment, user_id, reply_id, created_at)
VALUES ('이 영화 정말 감동적이었어요.', 2, 40, now());

INSERT INTO reply2_tb (comment, user_id, reply_id, created_at)
VALUES ('배우들의 연기가 최고였어요.', 3, 40, now());

INSERT INTO reply2_tb (comment, user_id, reply_id, created_at)
VALUES ('OST가 마음에 들어요.', 4, 40, now());

INSERT INTO reply2_tb (comment, user_id, reply_id, created_at)
VALUES ('다음에 또 보고 싶어요.', 5, 39, now());

INSERT INTO reply2_tb (comment, user_id, reply_id, created_at)
VALUES ('영화의 결말이 충격적이었어요.', 1, 38, now());
