--PL/SQL�� ����� ��³����� ȭ�鿡 �����ִ� ����
SET SERVEROUTPUT ON;  

BEGIN
    DBMS_OUTPUT.PUT_LINE('HELLO ORACLE');
END;
/
--���� set serveroutput on �����ָ� hello oracle �Ⱥ��δ�


SELECT * FROM EMPLOYEE;
--�̸��� �������� ������ ��� ���
SELECT EMP_ID FROM EMPLOYEE WHERE EMP_NAME = '������';
--����� ������ �����ߴٰ� ����ϱ�

DECLARE  --���� ����� (�����̸� �ڷ���)
    ID NUMBER;
BEGIN
    SELECT EMP_ID 
    INTO ID
    FROM EMPLOYEE WHERE EMP_NAME = '&�̸�'; --�����ȣ�� �ּ��ȿ��־ ó���Ǵϱ� �ٸ������λ���ϼ�
    DBMS_OUTPUT.PUT_LINE(ID);
    
EXCEPTION -- ���ܻ�Ȳ ó���� BEGIN�� WHERE �����Ͱ� ������� �Ʒ��ڵ�� ó���Ѵ�.
    WHEN NO_DATA_FOUND THEN DBMS_OUTPUT.PUT_LINE('�����Ͱ� �����ϴ�');
END;
/

--����� �Է¹޾Ƽ� �̸� �����ڵ�, �μ��ڵ� ���
DECLARE
    NAME VARCHAR2(20);
    J_CODE VARCHAR2(20);
    D_CODE VARCHAR2(20);
BEGIN
    SELECT EMP_NAME ,JOB_CODE,DEPT_CODE
    INTO NAME , J_CODE, D_CODE
    FROM EMPLOYEE WHERE EMP_ID='&���';
    DBMS_OUTPUT.PUT_LINE('�̸� : '||NAME);
    DBMS_OUTPUT.PUT_LINE('�����ڵ� : '||J_CODE);
    DBMS_OUTPUT.PUT_LINE('�μ��ڵ� : '||D_CODE);
EXCEPTION
     WHEN NO_DATA_FOUND THEN DBMS_OUTPUT.PUT_LINE('�����Ͱ� �����ϴ�');
END;
/
--�����ȣ�� �Է¹޾Ƽ�
-- �̸�, �μ���, ���޸� ��� -> JOIN�ؼ� �ϸ�� ���� ���������� �����ְ��� 
DECLARE --���� 3�� 
    NAME VARCHAR2(20);
    D_TITLE VARCHAR2(20);
    J_NAME VARCHAR2(20);
BEGIN
    SELECT EMP_NAME, DEPT_TITLE,JOB_NAME
    INTO NAME, D_TITLE, J_NAME
    FROM EMPLOYEE
    JOIN
    JOIN
    WHERE EMP_ID='&���';
    DBMS_OUTPUT.PUT_LINE('�̸� : ' || NAME);
    DBMS_OUTPUT.PUT_LINE('�μ� : ' || D_TITLE);
    DBMS_OUTPUT.PUT_LINE('���� : ' || J_NAME);
END;
/

DECLARE --�������� �ۼ��� 
    NAME VARCHAR2(20);
    D_TITLE VARCHAR2(20);
    J_NAME VARCHAR2(20);
BEGIN
    SELECT 
        EMP_NAME,
        (SELECT DEPT_TITLE FROM DEPARTMENT D WHERE E.DEPT_CODE = D.DEPT_ID),
        (SELECT JOB_NAME FROM JOB J WHERE E.JOB_CODE = J.JOB_CODE)
    INTO NAME, D_TITLE, J_NAME
    FROM EMPLOYEE E
    WHERE EMP_ID='&���';
    DBMS_OUTPUT.PUT_LINE('�̸� : ' || NAME);
    DBMS_OUTPUT.PUT_LINE('�μ� : ' || D_TITLE);
    DBMS_OUTPUT.PUT_LINE('���� : ' || J_NAME);
END;
/


/*
��������
������ [constant] �ڷ���(ũ��) [NOT NULL] [:=�ʱⰪ];   
CONSTANT -> ��� (�������ʴ¼�)
*/

DECLARE
    NO1 NUMBER :=10;
BEGIN
    DBMS_OUTPUT.PUT_LINE(NO1);
    NO1 :=100;
    DBMS_OUTPUT.PUT_LINE(NO1);
END;
/

DECLARE
    NAME EMPLOYEE.EMP_NAME%TYPE;
    D_CODE EMPLOYEE.DEPT_CODE%TYPE;
    -- NAME VARCHAR2(3); ũ�� ���ڶ� �������ڳ� ��ó�� �����ϸ� ���������������� 
BEGIN
    SELECT EMP_NAME,DEPT_CODE
    INTO NAME,D_CODE
    FROM EMPLOYEE WHERE EMP_ID='&������Է��϶��̺κ���';
    DBMS_OUTPUT.PUT_LINE(NAME);
    DBMS_OUTPUT.PUT_LINE(D_CODE);
END;
/

DECLARE
    MYROW EMPLOYEE%ROWTYPE;  -- ���ٿ� �ش��ϴ� ��� Ÿ���� ������
BEGIN
    SELECT EMP_NAME,EMAIL,PHONE,SALARY,HIRE_DATE
    INTO MYROW.EMP_NAME,MYROW.EMAIL,MYROW.PHONE,MYROW.SALARY,MYROW.HIRE_DATE
    FROM EMPLOYEE WHERE EMP_ID='&���';
    DBMS_OUTPUT.PUT_LINE(MYROW.EMP_NAME);
END;
/

DECLARE 
    --MYRECORD ��� ������Ÿ�� �ۼ�
    TYPE MYRECORD IS RECORD(
        NAME EMPLOYEE.EMP_NAME%TYPE,
        EMAIL EMPLOYEE.EMAIL%TYPE,
        PHONE EMPLOYEE.PHONE%TYPE,
        SAL EMPLOYEE.SALARY%TYPE,
        H_DATE EMPLOYEE.HIRE_DATE%TYPE
    );
    --MTRECORD Ÿ�� ���� ����
    MY MYRECORD;
BEGIN
    SELECT EMP_NAME, EMAIL,PHONE,SALARY,HIRE_DATE
    INTO MY
    FROM EMPLOYEE WHERE EMP_ID = '&���';
    DBMS_OUTPUT.PUT_LINE(MY.NAME);
    DBMS_OUTPUT.PUT_LINE(MY.EMAIL);
    DBMS_OUTPUT.PUT_LINE(MY.PHONE);
    DBMS_OUTPUT.PUT_LINE(MY.SAL);
    DBMS_OUTPUT.PUT_LINE(MY.H_DATE);
END;
/

--@�ǽ�����1
--���, �����, �����ڵ�, �޿��� ���� �� �ִ� ���������� ���ؼ� (%TYPE)
--������ ����� ���, �����, �����ڵ�, �޿��� �͸���� ���� ��ũ��Ʈ ����Ͻÿ�.
DECLARE
    E_NO EMPLOYEE.EMP_NO%TYPE;
    E_NAME EMPLOYEE.EMP_NAME%TYPE;
    E_JOB_C EMPLOYEE.JOB_CODE%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
BEGIN
    SELECT  EMP_NO, EMP_NAME,JOB_CODE,SALARY
    INTO E_NO, E_NAME, E_JOB_C, SAL
    FROM EMPLOYEE WHERE EMP_NAME='&����̸��Է�';
    DBMS_OUTPUT.PUT_LINE(E_NO);
    DBMS_OUTPUT.PUT_LINE(E_NAME);
    DBMS_OUTPUT.PUT_LINE(E_JOB_C);
    DBMS_OUTPUT.PUT_LINE(SAL);
END;
/
SELECT * FROM EMPLOYEE;
--@�ǽ�����2
--���, �����, �μ���,���޸��� ���� �� �ִ� ���������� ���ؼ� (RECORD)
-- ������� �˻��Ͽ� �ش� ����� ���, �����, �μ���, ���޸���
-- �͸���� ���� ��ũ��Ʈ ����Ͻÿ�

DECLARE 
    TYPE TEST_RECORD IS RECORD(
        E_NO EMPLOYEE.EMP_NO%TYPE,
        E_NAME EMPLOYEE.EMP_NAME%TYPE,
        D_TITLE DEPARTMENT.DEPT_TITLE%TYPE,
        J_NAME JOB.JOB_NAME%TYPE
    );   
    TEST1 TEST_RECORD;
BEGIN
    SELECT EMP_NO, EMP_NAME, DEPT_TITLE, JOB_NAME
    INTO TEST1
    FROM EMPLOYEE
    LEFT JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
    LEFT JOIN JOB USING(JOB_CODE)
    WHERE EMP_NAME = '&������Է�';
    DBMS_OUTPUT.PUT_LINE(TEST1.E_NO);
    DBMS_OUTPUT.PUT_LINE(TEST1.E_NAME);
    DBMS_OUTPUT.PUT_LINE(TEST1.D_TITLE);
    DBMS_OUTPUT.PUT_LINE(TEST1.J_NAME);
END;
/
SELECT * FROM EMPLOYEE;
--@�ǽ�����3
-- �����ȣ�� �Է��Ͽ� �ش� ����� ã�� (%ROWTYPE�� ���)
-- �����, �ֹι�ȣ, �Ի���, �μ�����
-- �͸����� ���� ��ũ��Ʈ ����Ͻÿ�

DECLARE
    EMP EMPLOYEE%ROWTYPE;  
    DEP DEPARTMENT%ROWTYPE;
BEGIN
    SELECT EMP_NAME,EMP_NO,HIRE_DATE,DEPT_TITLE
    INTO EMP.EMP_NAME,EMP.EMP_NO,EMP.HIRE_DATE,DEP.DEPT_TITLE
    FROM EMPLOYEE 
    LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
    WHERE EMP_ID ='&�����ȣ';
    DBMS_OUTPUT.PUT_LINE(EMP.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE(EMP.EMP_NO);
    DBMS_OUTPUT.PUT_LINE(EMP.HIRE_DATE);
    DBMS_OUTPUT.PUT_LINE(DEP.DEPT_TITLE);
END;
/

--���ù�
-- IF, IF ~ ELSE, IF ELSE IF
/*
    IF(���ǽ�){
        ���ǽ��� TRUE�� �����ϴ� �ڵ�
    }
    IF ���� THEN ���� TRUE�� ������ ����
    END IF
*/
-- �����ȣ�� �Է¹޾Ƽ� ���,�̸�,�޿�,���ʽ� ���
-- ���࿡ ���ʽ��� ������ '���ʽ��� ���޹��� �ʴ� ����Դϴ�.'���
DECLARE
    ID EMPLOYEE.EMP_ID%TYPE;
    NAME EMPLOYEE.EMP_NAME%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
    BO EMPLOYEE.BONUS%TYPE;
BEGIN
    SELECT EMP_ID,EMP_NAME,SALARY, NVL(BONUS,0)
    INTO ID,NAME,SAL,BO
    FROM EMPLOYEE WHERE EMP_ID = '&�����ȣ';
    DBMS_OUTPUT.PUT_LINE('��� : '||ID);
    DBMS_OUTPUT.PUT_LINE('�̸� : '||NAME);
    DBMS_OUTPUT.PUT_LINE('�޿� : '||SAL);
    DBMS_OUTPUT.PUT_LINE('���ʽ��� : '||BO*100||'%');
    IF(BO=0)
    THEN DBMS_OUTPUT.PUT_LINE('���ʽ��� ���޹��� �ʴ� ����Դϴ�.');
    END IF;
END;
/

SELECT * FROM JOB;


--�����ȣ�� �Է¹ް� ���, �̸�, �μ��ڵ�, �μ����� ���
--�̶� �����ڵ尡 J1,J2�̸� '�ӿ����Դϴ�.',�׿ܴ� '�Ϲ������Դϴ�.'
DECLARE
    ID EMPLOYEE.EMP_ID%TYPE;
    NAME EMPLOYEE.EMP_NAME%TYPE;
    D_CODE EMPLOYEE.DEPT_CODE%TYPE;
    D_TITLE DEPARTMENT.DEPT_TITLE%TYPE;
    J_CODE EMPLOYEE.JOB_CODE%TYPE;
BEGIN
    SELECT EMP_ID,EMP_NAME,DEPT_CODE,DEPT_TITLE,JOB_CODE
    INTO ID,NAME,D_CODE,D_TITLE,J_CODE
    FROM EMPLOYEE
    LEFT JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
    WHERE EMP_ID ='&���';
    DBMS_OUTPUT.PUT_LINE('��� : '||ID);
    DBMS_OUTPUT.PUT_LINE('�̸� : '||NAME);
    DBMS_OUTPUT.PUT_LINE('�μ��ڵ� : '||D_CODE);
    DBMS_OUTPUT.PUT_LINE('�μ��� : '||D_TITLE);
    IF J_CODE IN ('J1','J2')
    THEN DBMS_OUTPUT.PUT_LINE('�ӿ��� �Դϴ�.');
    ELSE DBMS_OUTPUT.PUT_LINE('�Ϲ����� �Դϴ�.');
    END IF;
END;
/

--����� �Է� ���� �� �޿��� ���� ����� ������ ���
--����� ���, �̸�, �޿�, �޿����
--500���� �̻� : A / 300 ~ 500���� : B / �׿� C
DECLARE
    ID EMPLOYEE.EMP_ID%TYPE;
    NAME EMPLOYEE.EMP_NAME%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
    SALGRADE CHAR(1);
BEGIN
    SELECT EMP_ID,EMP_NAME, SALARY 
    INTO ID,NAME,SAL
    FROM EMPLOYEE WHERE EMP_ID = '&���';
    DBMS_OUTPUT.PUT_LINE('��� : '|| ID);
    DBMS_OUTPUT.PUT_LINE('�̸� : '|| NAME);
    DBMS_OUTPUT.PUT_LINE('�޿� : '|| SAL);
    IF SAL>=5000000 THEN SALGRADE :='A';
    ELSIF 3000000<=SAL AND SAL <5000000 THEN SALGRADE :='B';
    ELSE SALGRADE :='C';
    END IF;
    DBMS_OUTPUT.PUT_LINE('�޿���� : '|| SALGRADE);
END;
/



