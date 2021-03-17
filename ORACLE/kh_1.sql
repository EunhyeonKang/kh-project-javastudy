SELECT * FROM EMPLOYEE;
SELECT * FROM DEPARTMENT;
SELECT * FROM LOCATION;

SELECT EMP_NAME,DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

SELECT * FROM EMPLOYEE;
SELECT * FROM JOB;
SELECT EMP_NAME,JOB_CODE,JOB_NAME
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE);


SELECT EMP_NAME, DEPT_CODE,DEPT_TITLE,LOCAL_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE=DEPT_ID)
JOIN LOCATION ON (LOCAL_CODE = LOCATION_ID);

SELECT DEPT_TITLE,SUM(SALARY)
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE=DEPT_ID)
JOIN LOCATION ON (LOCAL_CODE = LOCATION_ID)
GROUP BY DEPT_TITLE;

SELECT * FROM EMPLOYEE;


--1 �ֹι�ȣ�� 1970�����̸鼭 ������ �����̰�, ���� ������ ��������
--�����, �ֹι�ȣ, �μ���, ���޸��� ��ȸ�Ͻÿ�.
SELECT EMP_NAME �����, EMP_NO �ֹι�ȣ, DEPT_TITLE �μ���, JOB_NAME ���޸� 
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
JOIN JOB USING (JOB_CODE)
WHERE 
(SUBSTR(EMP_NO,1,2) BETWEEN 70 AND 79) AND 
SUBSTR(EMP_NO,8,1)=2 AND 
SUBSTR(EMP_NAME,1,1)='��';

--2. �̸��� '��'�ڰ� ���� �������� ���, �����, �μ����� ��ȸ�Ͻÿ�.
SELECT EMP_ID, EMP_NAME, DEPT_TITLE 
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_ID=DEPT_CODE)
WHERE EMP_NAME LIKE '%��%';

--@@@@@@@@@@
--3. �ؿܿ����ο� �ٹ��ϴ� �����, ���޸�, �μ��ڵ�, �μ����� ��ȸ�Ͻÿ�.
SELECT EMP_NAME �����, JOB_NAME ���޸�, DEPT_CODE �μ��ڵ�, DEPT_TITLE �μ���
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
JOIN DEPARTMENT ON (DEPT_ID=DEPT_CODE)
WHERE DEPT_TITLE LIKE '�ؿܿ���%';

--4. ���ʽ�����Ʈ�� �޴� �������� �����, ���ʽ�����Ʈ, �μ���, �ٹ��������� ��ȸ�Ͻÿ�.
SELECT EMP_NAME �����,BONUS ���ʽ�����Ʈ,DEPT_TITLE �μ���,LOCAL_NAME �ٹ������� 
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_ID=DEPT_CODE)
LEFT JOIN LOCATION ON (LOCAL_CODE=LOCATION_ID)
WHERE BONUS IS NOT NULL;

--5.�μ��ڵ尡 D2�� �������� �����, ���޸�, �μ���, �ٹ��������� ��ȸ�Ͻÿ�.
SELECT EMP_NAME �����, JOB_NAME ���޸�,DEPT_TITLE �μ���,LOCAL_NAME �ٹ�������
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
JOIN DEPARTMENT ON (DEPT_ID=DEPT_CODE)
JOIN LOCATION ON (LOCAL_CODE=LOCATION_ID)
WHERE DEPT_CODE = 'D2';

--6. �ѱ�(KO)�� �Ϻ�(JP)�� �ٹ��ϴ� �������� �����, �μ���, ������, �������� ��ȸ�Ͻÿ�.
SELECT EMP_NAME �����, DEPT_TITLE �μ���, LOCAL_NAME ������, NATIONAL_NAME ������
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_ID=DEPT_CODE)
JOIN LOCATION ON (LOCAL_CODE=LOCATION_ID)
JOIN NATIONAL USING (NATIONAL_CODE)
WHERE NATIONAL_NAME IN ('�ѱ�','�Ϻ�');

--7.���� �μ��� �ٹ��ϴ� �������� �����, �μ���, �����̸��� ��ȸ�Ͻÿ�. (SELF JOIN ���)
SELECT E1.EMP_NAME �����, D1.DEPT_TITLE �μ���,E2.EMP_NAME �����̸� 
FROM EMPLOYEE E1
JOIN DEPARTMENT D1 ON (DEPT_ID = DEPT_CODE)
JOIN EMPLOYEE E2 ON (E1.DEPT_CODE = E2.DEPT_CODE)
WHERE E1.EMP_NAME != E2.EMP_NAME
ORDER BY 1;

--8. ���ʽ�����Ʈ�� ���� ������ �߿���
--������ ����� ����� �������� �����, ���޸�, �޿��� ��ȸ�Ͻÿ�
--��, JOIN �� IN ����� ��
SELECT EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE 
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME IN ('����','���') AND BONUS IS NULL;

SELECT * FROM EMPLOYEE;
SELECT * FROM LOCATION;
SELECT * FROM DEPARTMENT;
SELECT * FROM JOB;
SELECT * FROM NATIONAL;

-- �μ��ڵ尡 D5�� ���� ���, �̸�, �μ��ڵ�, �޿� ���
SELECT EMP_ID,EMP_NAME,DEPT_CODE,SALARY
FROM EMPLOYEE WHERE DEPT_CODE='D5';
--�޿��� 300���� �̻��� ������ ���, �̸�, �μ��ڵ�, �޿� ���
SELECT EMP_ID,EMP_NAME,DEPT_CODE,SALARY
FROM EMPLOYEE WHERE SALARY >=3000000;

-- 1. UNION(������) : �� ��ȸ����� �ߺ��� �����͸� �����ϰ� ��ħ + ù��° �÷����� ����
SELECT EMP_ID,EMP_NAME,DEPT_CODE,SALARY
FROM EMPLOYEE WHERE DEPT_CODE='D5'
UNION
SELECT EMP_ID,EMP_NAME,DEPT_CODE,SALARY
FROM EMPLOYEE WHERE SALARY >=3000000;

--  2. UNION ALL(������) : �ߺ������� ����, ���� X
SELECT EMP_ID,EMP_NAME,DEPT_CODE,SALARY
FROM EMPLOYEE WHERE DEPT_CODE='D5'
UNION ALL
SELECT EMP_ID,EMP_NAME,DEPT_CODE,SALARY
FROM EMPLOYEE WHERE SALARY >=3000000;

--  3. INTERSECT(������) : �������� SELECT��� �� ����κи� ���
SELECT EMP_ID,EMP_NAME,DEPT_CODE,SALARY
FROM EMPLOYEE WHERE DEPT_CODE='D5'
INTERSECT
SELECT EMP_ID,EMP_NAME,DEPT_CODE,SALARY
FROM EMPLOYEE WHERE SALARY >=3000000;

--  4. MINUS(������) : ���� SELECT���� ���� SELECT�� ��ġ�� �ʴ� �κи� ���
SELECT EMP_ID,EMP_NAME,DEPT_CODE,SALARY
FROM EMPLOYEE WHERE DEPT_CODE='D5'
MINUS
SELECT EMP_ID,EMP_NAME,DEPT_CODE,SALARY
FROM EMPLOYEE WHERE SALARY >=3000000;

----------------------------------------------------------------------
--�������� ���� �����ϴ� DB����
-- 1. JOIN / 2.SUBQUERY
--�������� ��� �޿�
SELECT FLOOR(AVG(SALARY)) FROM EMPLOYEE;
--�����߿� ������ ��ձ޿����� �޿��� ���� ����� �̸� ��ȸ
SELECT EMP_NAME FROM EMPLOYEE
WHERE SALARY > (SELECT FLOOR(AVG(SALARY)) FROM EMPLOYEE);

--  1. ������ ��������
--  �������� ��ȸ����� (1�� 1��) -> 1���� ���ϰ�
-----------------------------------------------------------------
--������ ������ ������ �̸��� ���
--1)������ ������ ������ �̸� ���
SELECT MANAGER_ID FROM EMPLOYEE WHERE EMP_NAME ='������';
--2)��ȸ�� ���̵� Ȱ���ؼ� �Ŵ��� �̸� ��ȸ
SELECT EMP_NAME FROM EMPLOYEE WHERE EMP_ID=214;
--SUBQUERY
SELECT EMP_NAME 
FROM EMPLOYEE 
WHERE 
EMP_ID=(SELECT MANAGER_ID FROM EMPLOYEE WHERE EMP_NAME ='������');
--JOIN 
SELECT E2.EMP_NAME
FROM EMPLOYEE E1
JOIN EMPLOYEE E2 ON (E1.MANAGER_ID = E2.EMP_ID)
WHERE E1.EMP_NAME = '������';


--  1. �����ؿ� �޿��� ���� ������� �˻��ؼ�, �����ȣ, ����̸�, �޿��� ���
--  ��, �����ش� ��� X
SELECT EMP_ID,EMP_NAME,SALARY 
FROM EMPLOYEE 
WHERE SALARY = (SELECT SALARY FROM EMPLOYEE WHERE EMP_NAME = '������') AND
EMP_NAME NOT IN ('������');

--  2. EMPLOYEE���̺��� �⺻�޿��� ���� ��������� ���� ��������� ������ ���
--  ��������� ���, �����, �޿�
--  1) ���������� ����ɶ� �ʿ��� ��
SELECT EMP_ID,EMP_NAME, SALARY 
FROM EMPLOYEE
WHERE SALARY = (SELECT MAX(SALARY) FROM EMPLOYEE)
OR SALARY = (SELECT MIN(SALARY) FROM EMPLOYEE);

--  3. D1, D2 �μ��� �ٹ��ϴ� ����� �� �⺻�޿��� D5�μ��� ��ձ޿����� ���� ����鸸
-- �μ���ȣ, �����ȣ, �����, �޿� ���
SELECT DEPT_CODE, EMP_ID,EMP_NAME,SALARY 
FROM EMPLOYEE
WHERE SALARY > (SELECT AVG(SALARY) FROM EMPLOYEE WHERE DEPT_CODE = 'D5')
AND DEPT_CODE IN ('D1','D2');

SELECT * FROM EMPLOYEE;

--  2. ������ �������� : �������� ��ȸ����� ���� �������� ���
--  ������ �Ǵ� �ڳ��� ���� �μ��� �ִ� ������� ��ü ����
--  �����Ⱑ ���� �μ��ڵ�
SELECT DEPT_CODE FROM EMPLOYEE WHERE EMP_NAME = '������';
--  �ڳ��� ���� �μ��ڵ�
SELECT DEPT_CODE FROM EMPLOYEE WHERE EMP_NAME = '�ڳ���';

SELECT DEPT_CODE  FROM EMPLOYEE WHERE EMP_NAME IN ('������','�ڳ���');
--IN
SELECT EMP_NAME, DEPT_CODE,SALARY FROM EMPLOYEE
WHERE 
DEPT_CODE IN (SELECT DEPT_CODE  FROM EMPLOYEE WHERE EMP_NAME IN ('������','�ڳ���'));
--NOT IN
SELECT EMP_NAME, DEPT_CODE,SALARY FROM EMPLOYEE
WHERE 
DEPT_CODE NOT IN (SELECT DEPT_CODE  FROM EMPLOYEE WHERE EMP_NAME IN ('������','�ڳ���'));

-- ���¿�, ������ ����� �޿����(SAL_LEVEL)�� ���� ����� �����, �޿� ���
SELECT EMP_NAME, SALARY 
FROM EMPLOYEE
WHERE SAL_LEVEL IN (SELECT SAL_LEVEL FROM EMPLOYEE WHERE EMP_NAME IN ('���¿�','������'))
AND EMP_NAME NOT IN ('���¿�','������');

SELECT * FROM EMPLOYEE;

-----------------------------------------------------------------
--  1. ������ ��������
-----------------------------------------------------------------
--  1. ������ ��������
-----------------------------------------------------------------
