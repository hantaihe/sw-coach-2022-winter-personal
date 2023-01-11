SET FOREIGN_KEY_CHECKS=0;

TRUNCATE TABLE user;
INSERT INTO user(email, password, username, name, introduction)
VALUES
    ('skku@skku.edu', 'test1', 'skku_student1','학생1','테스트 학생'),
    ('skku2@skku.edu', 'test2', 'skku_student2','학생2','테스트 학생2');

TRUNCATE TABLE board;
INSERT INTO board(id, title, introduction)
VALUES
    (1,'자유게시판','이 게시판은 자유게시판입니다. 매너와 규칙 지켜주세요'),
    (2,'질문과 답변','이곳은 질문과 답변 게시판입니다. 매너와 규칙을 지켜주세요');

TRUNCATE TABLE post;
INSERT INTO post(board_id, user_id, title, content)
VALUES
    (1, 1, '스프링을 열심히 공부하고 싶습니다.','왜이래 잘 안풀릴까요.'),
    (1, 2, '저랑 스터디하실분?','혼자 공부하려니 너무 힘듭니다. 좀 알려주세요!');

TRUNCATE TABLE comment;
INSERT INTO comment(post_id, user_id, content)
VALUES
    (1, 1,'댓글입니다.'),
    (1, 2,'안녕하세요 댓글이에요');

SET FOREIGN_KEY_CHECKS=1;