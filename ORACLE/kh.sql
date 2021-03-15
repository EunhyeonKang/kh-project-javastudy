SELECT * FROM EMPLOYEE;

SELECT EMP_NAME,EMAIL,PHONE FROM EMPLOYEE;
SELECT * FROM EMPLOYEE WHERE JOB_CODE='J5';
--EMPLOYEE ���̺��� �����, ��ȭ��ȣ, ���� ��ȸ
SELECT EMP_NAME, PHONE,SALARY FROM EMPLOYEE;
--EMPLOYEE ���̺��� �����, ��ȭ��ȣ, ���� ��ȸ ������ 300�����̻��� ����� ��ȸ
SELECT EMP_NAME, PHONE,SALARY FROM EMPLOYEE WHERE SALARY>=3000000;
--EMPLOYEE ���̺��� �����, ��ȭ��ȣ, ���� ��ȸ ������ 300�����̻��̸鼭 �����ڵ尡 J3�� ����� ��ȸ
SELECT EMP_NAME, PHONE,SALARY FROM EMPLOYEE WHERE SALARY>=3000000 AND JOB_CODE='J3';
--EMPLOYEE ���̺��� �����, ����, ������ȸ
SELECT EMP_NAME AS "�̸�",SALARY AS "����", SALARY*12 AS "����" FROM EMPLOYEE;
SELECT EMP_NAME "�̸�",SALARY "����", SALARY*12 "����" FROM EMPLOYEE;
SELECT EMP_NAME NAME,SALARY "����(��)", SALARY*12 ���� FROM EMPLOYEE;
SELECT EMP_NAME,SALARY,'��' FROM EMPLOYEE;

--EMPLOYEE ���̺��� �̸�,����,�Ѽ��ɾ�(���ʽ��� ���Ե� �ݾ�), �Ǽ��ɾ�(�� ���ɾ� - (����*���� 3%))
--���ʽ��� ������ �Ŵ� �����
SELECT EMP_NAME,SALARY*12 ����, (SALARY+(SALARY*BONUS))*12 �Ѽ��ɾ�,(SALARY+(SALARY*BONUS))*12-(SALARY*0.03*12) �Ǽ��ɾ� FROM EMPLOYEE;

--��¥ +1 -> ������ ��¥, ��¥-1 -> ������¥, ������ ��¥ - ������¥
SELECT EMP_NAME �̸�,FLOOR(SYSDATE-HIRE_DATE) �ٹ��ϼ� FROM EMPLOYEE;

--�ǽ� 
--EMPLOYEE ���̺��� 20�� �̻� �ټ��� ������ �̸�, ����, ���ʽ����� ���
SELECT EMP_NAME, SALARY, BONUS FROM EMPLOYEE WHERE FLOOR(SYSDATE-HIRE_DATE)>=365*20;

SELECT * FROM EMPLOYEE;

--���Ῥ����
SELECT EMP_NAME,SALARY||'��' FROM EMPLOYEE; -- || SALARY�� '��'�� �������ִ� ������

--�� ������ ������ ������ �ϳ��� ������� ������ִ� ������
--�μ� �ڵ尡 D6�̰� �޿��� 200�������� ���̹޴� ������ �̸�, �μ��ڵ�,�޿� ���
SELECT EMP_NAME, DEPT_CODE, SALARY FROM EMPLOYEE WHERE DEPT_CODE='D6' AND SALARY>2000000;

--�޿��� 350�������� ���̹ް� 600�������� ���Թ޴� ������ �̸��� �޿� ��ȸ
SELECT EMP_NAME, SALARY FROM EMPLOYEE WHERE SALARY>=3500000 AND SALARY <=6000000;

SELECT EMP_NAME,SALARY FROM EMPLOYEE
WHERE SALARY BETWEEN 3500000 AND 6000000;

--EMPLOYEE���̺��� ����� 90/0101 ~ 01/01/01 �� ����� ��ü ���� ���
SELECT * FROM EMPLOYEE WHERE HIRE_DATE BETWEEN '90/01/01' AND '01/01/01';


--LIKE ������ '%', '_' ->���ϵ� ī��
-- ���ϵ�ī�� : �ƹ��ų� ��ü�ؼ� ����Ҽ� �ִ°�

SELECT * FROM EMPLOYEE WHERE EMP_NAME LIKE '��%'; -- %�� ���ڼ� ������� ������ �����ϴ� ��簪 
SELECT * FROM EMPLOYEE WHERE EMP_NAME LIKE '��%';
SELECT * FROM EMPLOYEE WHERE EMP_NAME LIKE '��__';

--�̸��� '��'�� ���ԵǾ� �ִ� ������ ��� ���� ���
SELECT * FROM EMPLOYEE WHERE EMP_NAME LIKE '%��%';--�� �ڿ� % �־��ָ� �� ���ԵǾ��ִ� �̸��� ����ã��������

--EMAIL �� ID �� _ ���ڸ��� 3�ڸ��� ���� ������� ���
SELECT * FROM EMPLOYEE WHERE EMAIL LIKE'___%';  -- EMAIL �� 4�����̻��� 
--ESCAPE�ɼ�  "\"
SELECT * FROM EMPLOYEE WHERE EMAIL LIKE '___#_%' ESCAPE '#'; --#�ڿ� ���ڴ� ���ϵ�ī�尡�ƴ϶� ���ھ� ǥ��
--NOT LIKE
SELECT EMP_NAME,SALARY FROM EMPLOYEE WHERE EMP_NAME NOT LIKE '��%'; --LIKE '��;�ϸ� ������ 2�� ã�µ� NOTLIKE�ϸ� ������ �ƴѻ��ã���ڵ� �׷��� 21���� ��µ� 
SELECT * FROM EMPLOYEE;

--1. EMPLOYEE ���̺��� �̸����� ������ ������ ��� �̸�
SELECT EMP_NAME FROM EMPLOYEE WHERE EMP_NAME LIKE '%��';
--2. EMPLOYEE���̺��� ��ȭ��ȣ ó�� �ڸ��� 010�� �ƴѻ���� �̸�,��ȭ��ȣ ���
SELECT EMP_NAME, PHONE FROM EMPLOYEE WHERE PHONE NOT LIKE '010%';
--3. EMPLOYEE���̺��� �����ּҿ� 'S'�� ���鼭,DEPT_CODE�� D9 �Ǵ� D6�̸�
--������� 90/01/01~00/12/01�̸鼭, ������ 270���� �̻��� ����� ��ü���� ���
SELECT * FROM EMPLOYEE 
WHERE EMAIL LIKE '%s%' AND (DEPT_CODE ='D9' OR DEPT_CODE='D6') AND
(HIRE_DATE BETWEEN '90/0101' AND '00/12/01') AND 
SALARY >=2700000;

--IS NUJLL/ IS NOT NULL
--�����ڵ� ����, �μ���ġ�� ���� ���� ����(�μ��ڵ�(DEPT_CODE)�� NULL�� ���� �̸���ȸ
SELECT * FROM EMPLOYEE WHERE MANAGER_ID IS NULL AND DEPT_CODE IS NOT NULL;

--IN / NOT IN
--�μ��ڵ尡 D6�̰ų� D9�� ���� ��ü������ȸ
SELECT * FROM EMPLOYEE WHERE DEPT_CODE = 'D6' OR DEPT_CODE='D9' OR DEPT_CODE = 'D2';
SELECT * FROM EMPLOYEE WHERE DEPT_CODE NOT IN ('D6','D2','D9','D1');

--�μ��� �� �����ڵ�(JOB_CODE)�� J7 �Ǵ� J2�̰�, �޿��� 200���� �ʰ��� ����� �̸�,�޿�,�����ڵ� ���
SELECT EMP_NAME, SALARY , JOB_CODE FROM EMPLOYEE WHERE JOB_CODE IN ('J2','J7') AND SALARY>2000000;

--�������� ASC
--���� : ������ -> ū��
--��¥ : ������ -> ������
--���� : ������

--�������� DESC
--���� : ū�� -> ������
--��¥ : ������ -> ������
--���� : ���� ����

SELECT * FROM EMPLOYEE ORDER BY EMP_NAME DESC;

SELECT EMP_ID,EMP_NAME,EMAIL FROM EMPLOYEE ORDER BY SALARY;
--ORDER BY (���°�÷�����)
SELECT EMP_ID,EMP_NAME,SALARY FROM EMPLOYEE ORDER BY 3 DESC;


--1
SELECT EMP_NAME �̸�, EMP_NO �ֹι�ȣ, SALARY �޿�, HIRE_DATE �Ի��� FROM EMPLOYEE
WHERE((SYSDATE-HIRE_DATE)>=365*5) AND ((SYSDATE-HIRE_DATE)<=365*10);
--2
SELECT EMP_NAME, DEPT_CODE,HIRE_DATE,FLOOR(ENT_DATE-HIRE_DATE)||'��' �ٹ��Ⱓ, ENT_DATE FROM EMPLOYEE WHERE ENT_YN ='Y';
--3
SELECT EMP_NAME, SALARY+(SALARY*0.5) "�λ� �޿�",(SYSDATE-HIRE_DATE)/365 �ټӳ�� FROM EMPLOYEE
WHERE (SYSDATE-HIRE_DATE)>=365*10 ORDER BY 3;
--4
SELECT EMP_NAME, EMP_NO, EMAIL, PHONE, SALARY FROM EMPLOYEE
WHERE (HIRE_DATE BETWEEN '99/01/01' AND '10/01/01')AND SALARY <= 2000000;
--5
SELECT EMP_NAME, EMP_NO,SALARY, DEPT_CODE FROM EMPLOYEE WHERE
(SALARY BETWEEN 2000000 AND 3000000) AND EMP_NO LIKE '___4___2%'
ORDER BY 2 DESC;
--6
SELECT EMP_NAME, FLOOR((SYSDATE-HIRE_DATE)/1000)*(SALARY*0.1) "Ư�� ���ʽ�" FROM EMPLOYEE
WHERE EMP_NO LIKE '_______1%' AND BONUS IS NULL ORDER BY 1;

-----------------------------------------------------------------------

--1. ���ڸ� ó���ϴ� �Լ�
--  1) LENGTH : �־��� �� �Ǵ� �÷��� ���ڿ� ����(���� ����)�� ��ȯ�ϴ� �Լ�
SELECT EMP_NAME,LENGTH(EMP_NAME) �̸�����,EMAIL,LENGTH(EMAIL) �̸��ϱ��� FROM EMPLOYEE;
--  2) LEHGTH : �־��� �� �Ǵ� �÷��� ���ڿ� ����(BYTE)�� ��ȯ�ϴ� �Լ�
SELECT EMP_NAME,LENGTHB(EMP_NAME),EMAIL,LENGTHB(EMAIL) FROM EMPLOYEE;
--  3) INSTR : ã�� ����(��)�� ������ ��ġ���� ������ Ƚ����ŭ ��Ÿ�� ��ġ�� ��ȯ
SELECT INSTR('HELLO WORLD HI HIGH','H',1,1) FROM DUAL;
SELECT INSTR('HELLO WORLD HI HIGH','H',1,2) FROM DUAL;
SELECT INSTR('HELLO WORLD HI HIGH','H',1,3) FROM DUAL;
SELECT INSTR('HELLO WORLD HI HIGH','H',2,1) FROM DUAL;
SELECT INSTR('HELLO WORLD HI HIGH','H',2,2) FROM DUAL;
SELECT INSTR('HELLO WORLD HI HIGH','H',-1,1) FROM DUAL;

--EMPLOYEE ���̺��� EMAIL�÷����� @�� ��ġ�� ���
SELECT EMAIL,INSTR(EMAIL,'@',1,1) FROM EMPLOYEE; 

--  4) LPAD/RPAD : �־��� �÷� ���ڿ��� ������ ���ڿ��� ����/�����ʿ� ���ٿ� ���� N�� ���ڿ��� ��ȯ
SELECT EMAIL, LENGTH(EMAIL),LPAD(EMAIL,20,'-') ,RPAD(EMAIL,20,'-')FROM EMPLOYEE;
SELECT EMAIL, LENGTH(EMAIL),LPAD(EMAIL,10,'-') ,RPAD(EMAIL,10,'-')FROM EMPLOYEE;
SELECT EMAIL,LPAD(EMAIL,INSTR(EMAIL,'@',1,1)-1,'#') FROM EMPLOYEE;

--  5) LTRIM/RTRIM : �־��� �÷��̳� ���ڿ��� ���� �Ǵ� �����ʿ��� ������ STR�� ���Ե� ��� ���ڸ� ������ ������ ��ȯ
SELECT 'aaaKH' FROM DUAL;
SELECT LTRIM('aaaKH','a') FROM DUAL;
SELECT LTRIM('aaaKaH','a') FROM DUAL;
SELECT RTRIM('aaaKHaaa','a') FROM DUAL;

SELECT LTRIM('ABACAAABCKH','ABC')FROM DUAL;

--TRIM : �־��� �÷��̳� ���ڿ� ��/��/���ʿ� �ִ� ������ ���ڸ� ������ �������� ��ȯ
SELECT TRIM(LEADING 'a' FROM 'aaaKHaaa')FROM DUAL;
SELECT TRIM(TRAILING 'a' FROM 'aaaKHaaa')FROM DUAL;
SELECT TRIM(BOTH 'a' FROM 'aaaKHaaa')FROM DUAL;
SELECT TRIM(BOTH 'B' FROM TRIM(LEADING 'A' FROM 'ABACAAABCKH'))FROM DUAL;

SELECT * FROM DEPARTMENT;
SELECT TRIM(TRAILING '��' FROM DEPT_TITLE) FROM DEPARTMENT;
--DUAL ���̺� ���
--'982341678934509hello89798739273402' ���ڿ��� �� �� ��� ���� ����
SELECT RTRIM(LTRIM('982341678934509hello89798739273402','0123456789'),'01234556789') FROM DUAL;

--  7) SUBSTR : �÷��̳� ���ڿ����� ������ ��ġ���� ������ ������ ���ڿ��� �߶󳻾� ����
SELECT 'SHOWMETHEMONEY' FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY',1,4) FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY',5,2) FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY',-8,2) FROM DUAL;
-- EMPLOYEE ���̺��� ����� �� ���� ���
SELECT SUBSTR(EMP_NAME,1,1) �� FROM EMPLOYEE;
SELECT LPAD(EMP_NAME,2,'#') FROM EMPLOYEE;

--EMPLOYEE ���̺��� ���ڸ� �����ȣ, �����, �ֹι�ȣ, ����
--�ֹι�ȣ �� 6�ڸ��� * ó�� EX) 990101-1******
SELECT * FROM EMPLOYEE;
SELECT EMP_ID, EMP_NAME, SUBSTR(EMP_NO,1,8)||'*******', SALARY FROM EMPLOYEE WHERE SUBSTR(EMP_NO,8,1) IN ('1','3');

--  8) LOWER / UPPER / INITCAP
SELECT LOWER('Welcome TO My World') FROM DUAL;
SELECT UPPER('Welcome TO My World') FROM DUAL;
SELECT INITCAP('Welcome TO My World') FROM DUAL;

--  9) CONCAT : �÷��� ���� Ȥ�� ���ڿ� �� ���� ���޹޾� �ϳ��� ��ģ �� ����
SELECT CONCAT('�����ٶ�','ABCD'),'�ȳ��ϼ��� 'FROM DUAL;
SELECT '�����ٶ�'||'ABCD'||'�ȳ��ϼ���' FROM DUAL;

--  10) REPLACE : ���ڿ��� ��ȯ
SELECT REPLACE('next007@nate.com','nate.com','iei.or.kr')FROM DUAL;

-- 2. ���� ó���Լ�
--  1) ABS : ���밪
SELECT ABS(10) FROM DUAL;
SELECT ABS(-10) FROM DUAL;
--  2) MOD : ���ڷ� ���� ���ڸ� ������ �������� ���ϴ� �Լ�
SELECT MOD(10,3) FROM DUAL;
SELECT MOD(10,2) FROM DUAL;
SELECT MOD(10,4) FROM DUAL;
--  3) ROUND/FLOOR/CEIL : �ݿø�, ����, �ø�
SELECT FLOOR(126.465) FROM DUAL;
SELECT CEIL(126.465) FROM DUAL;
SELECT ROUND(126.465) FROM DUAL;
SELECT ROUND(126.465,2) FROM DUAL;
SELECT ROUND(126.456,-2) FROM DUAL;
SELECT ROUND(126.456,-1) FROM DUAL;

-- 3. ��¥ó���Լ�
--  1) SYSDATE : �ý��ۿ� ����� ���� ��¥�� ��ȯ
SELECT SYSDATE FROM DUAL;
SELECT SYSDATE, CURRENT_DATE,LOCALTIMESTAMP, CURRENT_TIMESTAMP FROM DUAL;

--  2) MONTHS_BETWEEN : ��¥ �� ���� ���޹޾�, ���� �� ���̸� ���������� ����
SELECT EMP_NAME,HIRE_DATE, MONTHS_BETWEEN(SYSDATE,HIRE_DATE) FROM EMPLOYEE;
--  3) ADD_MONTHS : ���ڷ� ���޹��� ��¥�� ���ڷ� ���޹��� ���ڸ�ŭ ���� ���� ���ؼ� ��¥ �� ����
SELECT SYSDATE FROM DUAL;
SELECT ADD_MONTHS(SYSDATE,4) FROM DUAL;
SELECT ADD_MONTHS(SYSDATE+10,1) FROM DUAL;
--  4) NEXT_DAY : ���ڷ� ���޹��� ��¥�� ���ڷ� ���޹��� ���� �� ���� ����� ���� ���ϳ�¥
-- 1=�Ͽ���, ... 7= �����
SELECT SYSDATE+1 FROM DUAL;

SELECT NEXT_DAY(SYSDATE,3) FROM DUAL;
SELECT NEXT_DAY(SYSDATE,'������') FROM DUAL;
SELECT NEXT_DAY(SYSDATE,'��') FROM DUAL;
--  5)LAST_DAY : ���ڷ� ���޹��� ��¥�� ���� ���� ��������¥�� ���Ͽ� ����
SELECT LAST_DAY(SYSDATE+30) FROM DUAL;

--  6)EXTRACT : ��¥ �����Ϳ��� �⵵,��,�� ������ ����
SELECT SYSDATE FROM DUAL;
SELECT EXTRACT(YEAR FROM SYSDATE)FROM DUAL;
SELECT EXTRACT(MONTH FROM SYSDATE)FROM DUAL;
SELECT EXTRACT(DAY FROM SYSDATE)FROM DUAL;


--  EMPLOYEE ���̺��� ����� �̸�, �Ի���, ������ ���
-- ��, �Ի����� YYYY��M��D�Ϸ� ���
-- ���� ��� �� �Ҽ����̸� �ø����� ���()29.124 -> 30)
-- ��� �� ������ �Ի��� ���� ��������
SELECT * FROM EMPLOYEE;
SELECT EMP_NAME, EXTRACT(YEAR FROM HIRE_DATE)||'��'||EXTRACT(MONTH FROM HIRE_DATE)||'��'||EXTRACT(DAY FROM HIRE_DATE)||'��' �Ի���, CEIL((SYSDATE-HIRE_DATE)/365) ���� FROM EMPLOYEE ORDER BY 2;

--  4.����ȯ �Լ�
--  1) TO_CHAR : ��¥��������, ���ڵ����͸� ������ �����ͷ� ��ȯ�Ͽ� ����
--  TO_CHAR([����/��¥������],����)
SELECT SYSDATE FROM DUAL;
SELECT TO_CHAR(SYSDATE,'YYYY/MM/DD/DAY')FROM DUAL;
SELECT TO_CHAR(SYSDATE,'YYYY/MONTH/DD/DY')FROM DUAL;
SELECT TO_CHAR(SYSDATE,'YYYY/MONTH/DD/PMHH12"��"MI"��"SS"��"')FROM DUAL;
SELECT TO_CHAR(SYSDATE,'YYYY/MONTH/DD/HH24"��"MI"��"SS"��"')FROM DUAL;
SELECT TO_CHAR(SYSDATE,'FMYYYY/MONTH/DD/HH24"��"MI"��"SS"��"')FROM DUAL;

SELECT TO_CHAR(1000000,'999,999,999')FROM DUAL;
SELECT TO_CHAR(1000000,'999,999')FROM DUAL;
SELECT TO_CHAR(1000000,'$000,000,000')FROM DUAL;

--  2) TO_DATE : ���� Ȥ�� ������ �����͸� ��¥�� �����ͷ� ��ȯ�Ͽ� ����
--  TO_DATE(����|����, ����)
SELECT TO_DATE(20210201,'YYYYMMDD') FROM DUAL;
SELECT TO_DATE('20210709','YYYYMMDD')FROM DUAL;
SELECT TO_CHAR(TO_DATE(20210201,'YYYYMMDD'), 'YYYY/MM/DD/HH24"��"MI"��"SS"��"')FROM DUAL;

--  3) TO_NUMBER : ���� �����͸� ����Ÿ������ ��ȯ�Ͽ� ����
SELECT TO_NUMBER('1,000,000','9,999,999') FROM DUAL;
SELECT TO_NUMBER('100')FROM DUAL;
SELECT TO_NUMBER('1000'+'100') FROM DUAL; --������� ���ڷ� ����ȯ�ؼ� +����


-- 5.��Ÿ�Լ�
--  1) NVL : NULL�� �Ǿ��ִ� �÷��� ���� ������ ���� Ȥ�� ���ڷ� �����Ͽ� ����

SELECT SALARY,BONUS FROM EMPLOYEE;
SELECT SALARY,NVL(BONUS,0) FROM EMPLOYEE;
SELECT SALARY,BONUS, ((SALARY+SALARY*NVL(BONUS,0))*12)FROM EMPLOYEE;
SELECT EMP_NAME, NVL(DEPT_CODE,'�μ�����') FROM EMPLOYEE;

--  2) DECODE : �������� ��쿡 ������ �� �� �ִ� ����� ����
-- DECODE(ǥ����, ����1,���1,����2,���2,����3,���3.....)
/*
    switch(ǥ����){
    case ����1 : ���1;break;
    case ����2 : ���2;break;
    case ����3 : ���3;break;
    default : ���� �����ϴ� ������ ������ �����ϴ� ����
    }
*/
SELECT EMP_NAME, EMP_NO,
DECODE(SUBSTR(EMP_NO,8,1),'1','����','2','����','��������') ����
FROM EMPLOYEE;

--  3) CASE : �������� ��쿡 ������ �� �� �ִ� ����� ����(�������� ����)
SELECT EMP_NAME,EMP_NO,
CASE 
WHEN SUBSTR(EMP_NO,8,1)=1 THEN '����'
--WHEN SUBSTR(EMP_NO,8,1) IN(1,3) THEN '����'
--WHEN SUBSTR(EMP_NO,8,1) IN(2,4) THEN '����'
WHEN SUBSTR(EMP_NO,8,1)=2 THEN '����'
WHEN SUBSTR(EMP_NO,8,1)=3 THEN '����'
WHEN SUBSTR(EMP_NO,8,1)=4 THEN '����'
ELSE '��������'
END
AS ����
FROM EMPLOYEE;

--EMPLOYEE ���̺��� 60��� �� �� 65�� �̸��� "60���� �ʹ�", 65��� �̻��� "60���� �Ĺ�"
--��, �̸��� ���� ����� ��
SELECT EMP_NAME,EMP_NO,
CASE
WHEN SUBSTR(EMP_NO,1,2) >=65 THEN '60���� �Ĺ�'
WHEN SUBSTR(EMP_NO,1,2) < 65 THEN '60���� �ʹ�'
END
AS ����
FROM EMPLOYEE WHERE SUBSTR(EMP_NO,1,2) BETWEEN 60 AND 69;