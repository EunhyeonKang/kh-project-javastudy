/*�����ּ�*/
--�����ּ�

--1. ����� ���� ���� 
CREATE USER aclass IDENTIFIED BY 1234;
--2. ������ ������ ����,�����͸� �����ϴ� ������ �ο�
GRANT CONNECT,RESOURCE TO aclass;


CREATE USER bclass IDENTIFIED BY 1234;
GRANT CONNECT, RESOURCE TO bclass;