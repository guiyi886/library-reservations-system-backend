CREATE TABLE manager_tb
(
    id               INT AUTO_INCREMENT PRIMARY KEY,
    manager_id       VARCHAR(10) NOT NULL,
    manager_password VARCHAR(15) NOT NULL,
    manager_name     VARCHAR(15) NOT NULL,
    manager_sex      CHAR(1),
    manager_addtime  DATE,
    manager_phone    VARCHAR(11)
);

INSERT INTO manager_tb (manager_id, manager_password, manager_name, manager_sex, manager_addtime, manager_phone)
VALUES ('1234567890', 'password1', '张三', '男', '2023-01-01', '13812345678'),
       ('2345678901', 'password2', '李四', '女', '2023-02-01', '13998765432'),
       ('3456789012', 'password3', '王五', '男', '2023-03-01', '13655557777'),
       ('4567890123', 'password4', '赵六', '女', '2023-04-01', '13511112222'),
       ('5678901234', 'password5', '钱七', '男', '2023-05-01', '13299998888');

CREATE TABLE student_tb
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    stu_id       VARCHAR(10) NOT NULL,
    stu_password VARCHAR(15) NOT NULL,
    stu_name     VARCHAR(15) NOT NULL,
    stu_sex      CHAR(1),
    stu_addtime  DATE,
    stu_phone    VARCHAR(15),
    stu_score    int         not null
);
INSERT INTO student_tb (stu_id, stu_password, stu_name, stu_sex, stu_addtime, stu_phone)
VALUES ('S001', 'password1', '张三', '男', '2023-01-01', '13812345678'),
       ('S002', 'password2', '李四', '女', '2023-02-01', '13998765432'),
       ('S003', 'password3', '王五', '男', '2023-03-01', '13655557777'),
       ('S004', 'password4', '赵六', '女', '2023-04-01', '13511112222'),
       ('S005', 'password5', '钱七', '男', '2023-05-01', '13299998888');

# drop table lb_users;

CREATE TABLE seat_tb
(
    id                INT AUTO_INCREMENT PRIMARY KEY,
    seat_state        INT        NOT NULL,
    seat_reserve_time DATE,
    seat_position     VARCHAR(5) NOT NULL
);

INSERT INTO seat_tb (seat_state, seat_reserve_time, seat_position)
VALUES (1, '2023-01-01', 'A'),
       (0, NULL, 'B'),
       (1, '2023-02-15', 'C'),
       (0, NULL, 'A'),
       (1, '2023-03-20', 'B'),
       (1, '2023-04-25', 'C'),
       (0, NULL, 'A'),
       (0, NULL, 'B'),
       (1, '2023-05-30', 'C'),
       (1, '2023-06-10', 'A'),
       (0, NULL, 'B'),
       (0, NULL, 'C'),
       (1, '2023-07-15', 'A'),
       (1, '2023-08-20', 'B'),
       (0, NULL, 'C'),
       (1, '2023-09-25', 'A'),
       (1, '2023-10-30', 'B'),
       (0, NULL, 'C'),
       (1, '2023-11-15', 'A'),
       (1, '2023-12-20', 'B');

CREATE TABLE absent_tb
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    absent_num  INT         NOT NULL,
    absent_time DATE,
    stu_id      VARCHAR(10) NOT NULL,
    rebook_time DATE
);

-- 缺席学生表数据
INSERT INTO absent_tb (absent_num, absent_time, stu_id, rebook_time)
VALUES (1, '2023-01-10', '2023451164', '2023-01-15'),
       (3, '2023-02-20', '2021451346', '2023-02-25');

CREATE TABLE book_tb
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    book_time    DATE,
    stu_id       VARCHAR(10) NOT NULL,
    book_seat_id INT         NOT NULL,
    book_arrive  INT         NOT NULL
);

-- 预约记录表数据
INSERT INTO book_tb (book_time, stu_id, book_seat_id, book_arrive)
VALUES ('2023-01-10', '2023451164', 1, 1),
       ('2023-02-20', '2021451346', 2, 0),
       ('2023-03-15', '2022458912', 3, 1);

SELECT *
FROM book_tb
WHERE book_time BETWEEN DATE_SUB(NOW(), INTERVAL 7 DAY) AND NOW();

select stu_id
from student_tb
where stu_score < 100;

update student_tb
set stu_score=stu_score + 1
where stu_id in (select stu_id from student_tb where stu_score < 100);

UPDATE student_tb
SET stu_score = stu_score + 1
WHERE stu_id IN (SELECT stu_id
                 FROM (SELECT stu_id FROM student_tb WHERE stu_score < 100) AS temp_table);

update student_tb
set stu_score=stu_score + 1
where stu_id in (select stu_id
                 from (select stu_id from student_tb where stu_score < 100) AS temp_tb);

update book_tb
set book_arrive=2
where id = 1;

update seat_tb
set seat_state=1
where id in (select book_seat_id from book_tb where id = 2);

update seat_tb
set seat_state=1
where id in (null);