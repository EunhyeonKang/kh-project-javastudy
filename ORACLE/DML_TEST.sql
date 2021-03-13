CREATE TABLE MEMBER(
    MEMBER_NO    NUMBER       PRIMARY KEY,
    MEMBER_NAME  VARCHAR2(20) NOT NULL,
    AGE          NUMBER,
    GENDER       CHAR(1)      CHECK(GENDER IN ('M','F')),
    ENROLL_DATE  DATE         DEFAULT SYSDATE
);
--INSERT
--INSERT INTO ���̺��� VALUES(�÷� ������� �� ����)
INSERT INTO MEMBER VALUES(1,'�̸�1',20,'F',SYSDATE);
INSERT INTO MEMBER VALUES(2,'�̸�2',21,'M',SYSDATE);
INSERT INTO MEMBER VALUES(3,'�̸�3',22,'M',DEFAULT);

--INSERT INTO ���̺��� (�÷���1,�÷���2 ...)VALUES(��1,��2 ...)
INSERT INTO MEMBER(MEMBER_NO,MEMBER_NAME,AGE,GENDER,ENROLL_DATE)VALUES(4,'�̸�',23,'F',SYSDATE);
INSERT INTO MEMBER(GENDER,ENROLL_DATE,MEMBER_NAME,AGE,MEMBER_NO)VALUES('M',SYSDATE,'�̸�5',24,5);
INSERT INTO MEMBER(MEMBER_NO,MEMBER_NAME,GENDER)VALUES(6,'�̸�6','F');

SELECT * FROM MEMBER;
--UPDATE
--UPDATE ���̺��� SET ������ �÷��̸� = ������ ��, ������ �÷��̸� = ������ �� VALUE ������ ROW���ñ���
UPDATE MEMBER SET AGE = 25 WHERE MEMBER_NO=6;
--WHERE �� ���� ��� 33���� ������Ʈ��.
UPDATE MEMBER SET AGE = 33;

UPDATE MEMBER SET MEMBER_NAME='�̸�55',AGE=55,GENDER='F' WHERE MEMBER_NO=5;
UPDATE MEMBER SET AGE=10 WHERE GENDER='M';
UPDATE MEMBER SET AGE=13 WHERE GENDER='M' AND MEMBER_NAME='�̸�3';

--DELETE
--DELETE FROM ���̺��� WHERE ������ ROE ���ñ���
DELETE FROM MEMBER WHERE MEMBER_NO =5;
DELETE FROM MEMBER WHERE GENDER ='M';
DELETE FROM MEMBER;


COMMIT;

DELETE FROM MEMBER;
ROLLBACK;
TRUNCATE TABLE MEMBER;