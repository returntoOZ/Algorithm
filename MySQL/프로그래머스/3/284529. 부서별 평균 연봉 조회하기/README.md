# [level 3] 부서별 평균 연봉 조회하기 - 284529 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/284529) 

### 성능 요약

메모리: undefined, 시간: 

### 구분

코딩테스트 연습 > GROUP BY

### 채점결과

합계: 100.0 / 100.0

### 제출 일자

2025년 10월 22일 11:19:28

### 문제 설명

<p class="default_cursor_land"><code>HR_DEPARTMENT</code> 테이블은 회사의 부서 정보를 담은 테이블입니다. <code>HR_DEPARTMENT</code> 테이블의 구조는 다음과 같으며 <code>DEPT_ID</code>, <code>DEPT_NAME_KR</code>, <code>DEPT_NAME_EN</code>, <code>LOCATION</code>은 각각 부서 ID, 국문 부서명, 영문 부서명, 부서 위치를 의미합니다.</p>
<table class="table default_cursor_land">
        <thead><tr>
<th>Column name</th>
<th>Type</th>
<th>Nullable</th>
</tr>
</thead>
        <tbody><tr>
<td>DEPT_ID</td>
<td>VARCHAR</td>
<td>FALSE</td>
</tr>
<tr>
<td>DEPT_NAME_KR</td>
<td>VARCHAR</td>
<td>FALSE</td>
</tr>
<tr>
<td>DEPT_NAME_EN</td>
<td>VARCHAR</td>
<td>FALSE</td>
</tr>
<tr>
<td>LOCATION</td>
<td>VARCHAR</td>
<td>FLASE</td>
</tr>
</tbody>
      </table>
<p class="default_cursor_land"><code>HR_EMPLOYEES</code> 테이블은 회사의 사원 정보를 담은 테이블입니다. <code class="default_cursor_land">HR_EMPLOYEES</code> 테이블의 구조는 다음과 같으며 <code>EMP_NO</code>, <code class="default_cursor_land">EMP_NAME</code>, <code>DEPT_ID</code>, <code>POSITION</code>, <code>EMAIL</code>, <code class="default_cursor_land">COMP_TEL</code>, <code>HIRE_DATE</code>, <code>SAL</code>은 각각 사번, 성명, 부서 ID, 직책, 이메일, 전화번호, 입사일, 연봉을 의미합니다.</p>
<table class="table default_cursor_land">
        <thead><tr>
<th>Column name</th>
<th>Type</th>
<th>Nullable</th>
</tr>
</thead>
        <tbody><tr>
<td>EMP_NO</td>
<td>VARCHAR</td>
<td class="default_cursor_land">FALSE</td>
</tr>
<tr>
<td>EMP_NAME</td>
<td>VARCHAR</td>
<td>FALSE</td>
</tr>
<tr>
<td>DEPT_ID</td>
<td>VARCHAR</td>
<td>FALSE</td>
</tr>
<tr>
<td>POSITION</td>
<td class="default_cursor_land">VARCHAR</td>
<td>FALSE</td>
</tr>
<tr>
<td class="default_cursor_land">EMAIL</td>
<td>VARCHAR</td>
<td>FALSE</td>
</tr>
<tr>
<td>COMP_TEL</td>
<td>VARCHAR</td>
<td>FALSE</td>
</tr>
<tr>
<td>HIRE_DATE</td>
<td>DATE</td>
<td>FALSE</td>
</tr>
<tr>
<td>SAL</td>
<td>NUMBER</td>
<td>FALSE</td>
</tr>
</tbody>
      </table>
<hr class="default_cursor_land">

<h5 class="default_cursor_land">문제</h5>

<p class="default_cursor_land"><code>HR_DEPARTMENT</code>와 <code class="default_cursor_land">HR_EMPLOYEES</code> 테이블을 이용해 부서별 평균 연봉을 조회하려 합니다. 부서별로 부서 ID, 영문 부서명, 평균 연봉을 조회하는 SQL문을 작성해주세요.</p>

<p class="default_cursor_land">평균연봉은 소수점 첫째 자리에서 반올림하고 컬럼명은 <code class="default_cursor_land">AVG_SAL</code>로 해주세요.<br>
결과는 부서별 평균 연봉을 기준으로 내림차순 정렬해주세요.</p>

<hr class="default_cursor_land">

<h5 class="default_cursor_land">예시</h5>

<p class="default_cursor_land"><code class="default_cursor_land">HR_DEPARTMENT</code> 테이블이 다음과 같고</p>
<table class="table default_cursor_land">
        <thead><tr>
<th>DEPT_ID</th>
<th class="default_cursor_land">DEPT_NAME_KR</th>
<th class="default_cursor_land">DEPT_NAME_EN</th>
<th>LOCATION</th>
</tr>
</thead>
        <tbody><tr>
<td>D0005</td>
<td class="default_cursor_land">재무팀</td>
<td class="default_cursor_land">Finance</td>
<td>그렙타워 5층</td>
</tr>
<tr>
<td>D0006</td>
<td>구매팀</td>
<td class="default_cursor_land">Purchasing</td>
<td>그렙타워 5층</td>
</tr>
<tr>
<td>D0007</td>
<td>마케팅팀</td>
<td class="default_cursor_land">Marketing</td>
<td>그렙타워 6층</td>
</tr>
</tbody>
      </table>
<p class="default_cursor_land"><code>HR_EMPLOYEES</code> 테이블이 다음과 같을 때</p>
<table class="table default_cursor_land">
        <thead><tr>
<th>EMP_NO</th>
<th class="default_cursor_land">EMP_NAME</th>
<th class="default_cursor_land">DEPT_ID</th>
<th class="default_cursor_land">POSITION</th>
<th class="default_cursor_land">EMAIL</th>
<th class="default_cursor_land">COMP_TEL</th>
<th class="default_cursor_land">HIRE_DATE</th>
<th class="default_cursor_land">SAL</th>
</tr>
</thead>
        <tbody><tr>
<td>2019003</td>
<td class="default_cursor_land">한동희</td>
<td class="default_cursor_land">D0005</td>
<td class="default_cursor_land">팀장</td>
<td class="default_cursor_land"><a href="mailto:donghee_han@grep.com" target="_blank" rel="noopener">donghee_han@grep.com</a></td>
<td class="default_cursor_land">031-8000-1122</td>
<td class="default_cursor_land">2019-03-01</td>
<td class="default_cursor_land">57000000</td>
</tr>
<tr>
<td>2020032</td>
<td>한명지</td>
<td class="default_cursor_land">D0005</td>
<td class="default_cursor_land">팀원</td>
<td class="default_cursor_land"><a href="mailto:mungji_han@grep.com" target="_blank" rel="noopener" class="default_pointer_land">mungji_han@grep.com</a></td>
<td class="default_cursor_land">031-8000-1123</td>
<td class="default_cursor_land">2020-03-01</td>
<td class="default_cursor_land">52000000</td>
</tr>
<tr>
<td>2022003</td>
<td>김보라</td>
<td class="default_cursor_land">D0005</td>
<td>팀원</td>
<td class="default_cursor_land"><a href="mailto:bora_kim@grep.com" target="_blank" rel="noopener" class="default_pointer_land">bora_kim@grep.com</a></td>
<td class="default_cursor_land">031-8000-1126</td>
<td class="default_cursor_land">2022-03-01</td>
<td class="default_cursor_land">47000000</td>
</tr>
<tr>
<td>2018005</td>
<td class="default_cursor_land">이재정</td>
<td class="default_cursor_land">D0006</td>
<td class="default_cursor_land">팀장</td>
<td class="default_cursor_land"><a href="mailto:jaejung_lee@grep.com" target="_blank" rel="noopener" class="default_pointer_land">jaejung_lee@grep.com</a></td>
<td class="default_cursor_land">031-8000-1127</td>
<td class="default_cursor_land">2018-03-01</td>
<td class="default_cursor_land">60000000</td>
</tr>
<tr>
<td>2019032</td>
<td class="default_cursor_land">윤성희</td>
<td class="default_cursor_land">D0006</td>
<td class="default_cursor_land">팀원</td>
<td class="default_cursor_land"><a href="mailto:sunghee_yoon@grep.com" target="_blank" rel="noopener" class="default_pointer_land">sunghee_yoon@grep.com</a></td>
<td class="default_cursor_land">031-8000-1128</td>
<td class="default_cursor_land">2019-03-01</td>
<td class="default_cursor_land">57000000</td>
</tr>
<tr>
<td class="default_cursor_land">2020009</td>
<td class="default_cursor_land">송영섭</td>
<td class="default_cursor_land">D0006</td>
<td class="default_cursor_land">팀원</td>
<td class="default_cursor_land"><a href="mailto:yungseop_song@grep.com" target="_blank" rel="noopener" class="default_pointer_land">yungseop_song@grep.com</a></td>
<td class="default_cursor_land">031-8000-1130</td>
<td class="default_cursor_land">2020-03-01</td>
<td class="default_cursor_land">51000000</td>
</tr>
<tr>
<td>2021006</td>
<td class="default_cursor_land">이성주</td>
<td class="default_cursor_land">D0006</td>
<td class="default_cursor_land">팀원</td>
<td class="default_cursor_land"><a href="mailto:sungju_lee@grep.com" target="_blank" rel="noopener" class="default_pointer_land">sungju_lee@grep.com</a></td>
<td class="default_cursor_land">031-8000-1131</td>
<td class="default_cursor_land">2021-03-01</td>
<td class="default_cursor_land">49000000</td>
</tr>
<tr>
<td>2018004</td>
<td>이주리</td>
<td>D0007</td>
<td class="default_cursor_land">팀장</td>
<td class="default_cursor_land"><a href="mailto:joori_lee@grep.com" target="_blank" rel="noopener" class="default_pointer_land">joori_lee@grep.com</a></td>
<td>031-8000-1132</td>
<td class="default_cursor_land">2018-03-01</td>
<td>61000000</td>
</tr>
<tr>
<td>2020012</td>
<td>김사랑</td>
<td>D0007</td>
<td class="default_cursor_land">팀원</td>
<td class="default_cursor_land"><a href="mailto:sarang_kim@grep.com" target="_blank" rel="noopener" class="default_pointer_land">sarang_kim@grep.com</a></td>
<td class="default_cursor_land">031-8000-1133</td>
<td class="default_cursor_land">2020-03-01</td>
<td class="default_cursor_land">54000000</td>
</tr>
<tr>
<td>2021018</td>
<td>김히라</td>
<td class="default_cursor_land">D0007</td>
<td class="default_cursor_land">팀원</td>
<td><a href="mailto:heera_kim@grep.com" target="_blank" rel="noopener">heera_kim@grep.com</a></td>
<td class="default_cursor_land">031-8000-1136</td>
<td class="default_cursor_land">2021-03-01</td>
<td class="default_cursor_land">49000000</td>
</tr>
</tbody>
      </table>
<p class="default_cursor_land">SQL을 실행하면 다음과 같이 출력되어야 합니다.</p>
<table class="table default_cursor_land">
        <thead><tr>
<th class="default_cursor_land">DEPT_ID</th>
<th class="default_cursor_land">DEPT_NAME_EN</th>
<th class="default_cursor_land">AVG_SAL</th>
</tr>
</thead>
        <tbody><tr>
<td>D0007</td>
<td class="default_cursor_land">Marketing</td>
<td>54666667</td>
</tr>
<tr>
<td>D0006</td>
<td class="default_cursor_land">Purchasing</td>
<td class="default_cursor_land">54250000</td>
</tr>
<tr>
<td>D0005</td>
<td>Finance</td>
<td>52000000</td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges