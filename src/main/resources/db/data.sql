insert into user_tb(username,password,email,phone,created_at) values ('ssar','1234','ssar@nate.com','01012345678',now());
insert into user_tb(username,password,email,phone,created_at) values ('user1','1234','user1@nate.com','01011112222',now());
insert into user_tb(username,password,email,phone,created_at) values ('user2','1234','user2@nate.com','01022223333',now());
insert into user_tb(username,password,email,phone,created_at) values ('user3','1234','user3@nate.com','01033334444',now());
insert into user_tb(username,password,email,phone,created_at) values ('user4','1234','user4@nate.com','01044445555',now());

insert into board_tb(title,content,category,board_img,user_id,created_at) values ('스포츠 제목1','스포츠 내용1','스포츠',null,1,now());
insert into board_tb(title,content,category,board_img,user_id,created_at) values ('스포츠 제목2','스포츠 내용2','스포츠',null,2,now());
insert into board_tb(title,content,category,board_img,user_id,created_at) values ('게임 제목3','게임 내용3','게임',null,3,now());
insert into board_tb(title,content,category,board_img,user_id,created_at) values ('게임 제목4','게임 내용4','게임',null,4,now());
insert into board_tb(title,content,category,board_img,user_id,created_at) values ('게임 제목5','게임 내용5','게임',null,5,now());
insert into board_tb(title,content,category,board_img,user_id,created_at) values ('음식 제목6','음식 내용6','음식',null,1,now());
insert into board_tb(title,content,category,board_img,user_id,created_at) values ('음식 제목7','음식 내용7','음식',null,2,now());
insert into board_tb(title,content,category,board_img,user_id,created_at) values ('음식 제목8','음식 내용8','음식',null,3,now());
insert into board_tb(title,content,category,board_img,user_id,created_at) values ('음식 제목9','음식 내용9','음식',null,4,now());
insert into board_tb(title,content,category,board_img,user_id,created_at) values ('영화 제목10','영화 내용10','영화',null,5,now());
insert into board_tb(title,content,category,board_img,user_id,created_at) values ('영화 제목11','영화 내용11','영화',null,1,now());


insert into reply_tb(comment,user_id,board_id,created_at) values ('댓글1',1,10,now());
insert into reply_tb(comment,user_id,board_id,created_at) values ('댓글2',2,11,now());
insert into reply_tb(comment,user_id,board_id,created_at) values ('댓글3',3,1,now());
insert into reply_tb(comment,user_id,board_id,created_at) values ('댓글4',4,2,now());
insert into reply_tb(comment,user_id,board_id,created_at) values ('댓글5',5,3,now());
insert into reply_tb(comment,user_id,board_id,created_at) values ('댓글6',1,4,now());
insert into reply_tb(comment,user_id,board_id,created_at) values ('댓글7',2,5,now());
insert into reply_tb(comment,user_id,board_id,created_at) values ('댓글8',3,6,now());
insert into reply_tb(comment,user_id,board_id,created_at) values ('댓글9',4,10,now());
insert into reply_tb(comment,user_id,board_id,created_at) values ('댓글10',5,11,now());
insert into reply_tb(comment,user_id,board_id,created_at) values ('댓글11',1,1,now());
insert into reply_tb(comment,user_id,board_id,created_at) values ('댓글12',2,2,now());
insert into reply_tb(comment,user_id,board_id,created_at) values ('댓글13',3,8,now());
insert into reply_tb(comment,user_id,board_id,created_at) values ('댓글14',4,9,now());

insert into reply2_tb(comment,user_id,reply_id,created_at) values ('대댓글1',5,14,now());
insert into reply2_tb(comment,user_id,reply_id,created_at) values ('대댓글2',4,13,now());
insert into reply2_tb(comment,user_id,reply_id,created_at) values ('대댓글3',3,12,now());
insert into reply2_tb(comment,user_id,reply_id,created_at) values ('대댓글4',2,11,now());
insert into reply2_tb(comment,user_id,reply_id,created_at) values ('대댓글5',1,10,now());
insert into reply2_tb(comment,user_id,reply_id,created_at) values ('대댓글6',5,9,now());
insert into reply2_tb(comment,user_id,reply_id,created_at) values ('대댓글7',4,8,now());
insert into reply2_tb(comment,user_id,reply_id,created_at) values ('대댓글8',3,7,now());
insert into reply2_tb(comment,user_id,reply_id,created_at) values ('대댓글9',2,6,now());
insert into reply2_tb(comment,user_id,reply_id,created_at) values ('대댓글10',1,5,now());
insert into reply2_tb(comment,user_id,reply_id,created_at) values ('대댓글11',3,4,now());
insert into reply2_tb(comment,user_id,reply_id,created_at) values ('대댓글12',5,3,now());
insert into reply2_tb(comment,user_id,reply_id,created_at) values ('대댓글13',4,2,now());