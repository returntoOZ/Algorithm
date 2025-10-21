# [level 4] 연간 평가점수에 해당하는 평가 등급 및 성과금 조회하기 - 284528 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/284528) 

### 성능 요약

메모리: undefined, 시간: 

### 구분

코딩테스트 연습 > GROUP BY

### 채점결과

합계: 100.0 / 100.0

### 제출 일자

2025년 10월 21일 16:53:23

### 문제 설명

<p class="default_cursor_land"><code>HR_DEPARTMENT</code> 테이블은 회사의 부서 정보를 담은 테이블입니다. <code>HR_DEPARTMENT</code> 테이블의 구조는 다음과 같으며 <code class="default_cursor_land">DEPT_ID</code>, <code>DEPT_NAME_KR</code>, <code class="default_cursor_land">DEPT_NAME_EN</code>, <code class="default_cursor_land">LOCATION</code>은 각각 부서 ID, 국문 부서명, 영문 부서명, 부서 위치를 의미합니다.</p>
<table class="table default_cursor_land">
        <thead><tr>
<th class="default_cursor_land">Column name</th>
<th class="default_cursor_land">Type</th>
<th class="default_cursor_land">Nullable</th>
</tr>
</thead>
        <tbody><tr>
<td class="default_cursor_land">DEPT_ID</td>
<td>VARCHAR</td>
<td class="default_cursor_land">FALSE</td>
</tr>
<tr>
<td class="default_cursor_land">DEPT_NAME_KR</td>
<td>VARCHAR</td>
<td class="default_cursor_land">FALSE</td>
</tr>
<tr>
<td class="default_cursor_land">DEPT_NAME_EN</td>
<td>VARCHAR</td>
<td class="default_cursor_land">FALSE</td>
</tr>
<tr>
<td class="default_cursor_land">LOCATION</td>
<td>VARCHAR</td>
<td class="default_cursor_land">FLASE</td>
</tr>
</tbody>
      </table>
<p class="default_cursor_land"><code>HR_EMPLOYEES</code> 테이블은 회사의 사원 정보를 담은 테이블입니다. <code class="default_cursor_land">HR_EMPLOYEES</code> 테이블의 구조는 다음과 같으며 <code class="default_cursor_land">EMP_NO</code>, <code class="default_cursor_land">EMP_NAME</code>, <code>DEPT_ID</code>, <code class="default_cursor_land">POSITION</code>, <code class="default_cursor_land">EMAIL</code>, <code class="default_cursor_land">COMP_TEL</code>, <code class="default_cursor_land">HIRE_DATE</code>, <code class="default_cursor_land">SAL</code>은 각각 사번, 성명, 부서 ID, 직책, 이메일, 전화번호, 입사일, 연봉을 의미합니다.</p>
<table class="table default_cursor_land">
        <thead><tr>
<th class="default_cursor_land">Column name</th>
<th class="default_cursor_land">Type</th>
<th class="default_cursor_land">Nullable</th>
</tr>
</thead>
        <tbody><tr>
<td class="default_cursor_land">EMP_NO</td>
<td>VARCHAR</td>
<td>FALSE</td>
</tr>
<tr>
<td class="default_cursor_land">EMP_NAME</td>
<td>VARCHAR</td>
<td class="default_cursor_land">FALSE</td>
</tr>
<tr>
<td class="default_cursor_land">DEPT_ID</td>
<td>VARCHAR</td>
<td>FALSE</td>
</tr>
<tr>
<td class="default_cursor_land">POSITION</td>
<td>VARCHAR</td>
<td>FALSE</td>
</tr>
<tr>
<td class="default_cursor_land">EMAIL</td>
<td class="default_cursor_land">VARCHAR</td>
<td class="default_cursor_land">FALSE</td>
</tr>
<tr>
<td>COMP_TEL</td>
<td class="default_cursor_land">VARCHAR</td>
<td class="default_cursor_land">FALSE</td>
</tr>
<tr>
<td>HIRE_DATE</td>
<td class="default_cursor_land">DATE</td>
<td class="default_cursor_land">FALSE</td>
</tr>
<tr>
<td>SAL</td>
<td class="default_cursor_land">NUMBER</td>
<td class="default_cursor_land">FALSE</td>
</tr>
</tbody>
      </table>
<p class="default_cursor_land"><code class="default_cursor_land">HR_GRADE</code> 테이블은 2022년 사원의 평가 정보를 담은 테이블입니다. <code class="default_cursor_land">HR_GRADE</code>의 구조는 다음과 같으며 <code class="default_cursor_land">EMP_NO</code>, <code>YEAR</code>, <code class="default_cursor_land">HALF_YEAR</code>, <code class="default_cursor_land">SCORE</code>는 각각 사번, 연도, 반기, 평가 점수를 의미합니다.</p>
<table class="table default_cursor_land">
        <thead><tr>
<th>Column name</th>
<th class="default_cursor_land">Type</th>
<th class="default_cursor_land">Nullable</th>
</tr>
</thead>
        <tbody><tr>
<td>EMP_NO</td>
<td class="default_cursor_land">VARCHAR</td>
<td class="default_cursor_land">FALSE</td>
</tr>
<tr>
<td class="default_cursor_land">YEAR</td>
<td class="default_cursor_land">NUMBER</td>
<td class="default_cursor_land">FALSE</td>
</tr>
<tr>
<td class="default_cursor_land">HALF_YEAR</td>
<td class="default_cursor_land">NUMBER</td>
<td class="default_cursor_land">FALSE</td>
</tr>
<tr>
<td class="default_cursor_land">SCORE</td>
<td class="default_cursor_land">NUMBER</td>
<td class="default_cursor_land">FALSE</td>
</tr>
</tbody>
      </table>
<hr class="default_cursor_land">

<h5 class="default_cursor_land">문제</h5>

<p class="default_cursor_land"><code class="default_cursor_land">HR_DEPARTMENT</code>, <code class="default_cursor_land">HR_EMPLOYEES</code>, <code class="default_cursor_land">HR_GRADE</code> 테이블을 이용해 사원별 성과금 정보를 조회하려합니다. 평가 점수별 등급과 등급에 따른 성과금 정보가 아래와 같을 때, 사번, 성명, 평가 등급, 성과금을 조회하는 SQL문을 작성해주세요.</p>

<p class="default_cursor_land">평가등급의 컬럼명은 <code class="default_cursor_land">GRADE</code>로, 성과금의 컬럼명은 <code class="default_cursor_land">BONUS</code>로 해주세요.<br>
결과는 사번 기준으로 오름차순 정렬해주세요.</p>
<table class="table default_cursor_land">
        <thead><tr>
<th>기준 점수</th>
<th class="default_cursor_land">평가 등급</th>
<th class="default_cursor_land">성과금(연봉 기준)</th>
</tr>
</thead>
        <tbody><tr>
<td class="default_cursor_land">96 이상</td>
<td>S</td>
<td class="default_cursor_land">20%</td>
</tr>
<tr>
<td>90 이상</td>
<td>A</td>
<td class="default_cursor_land">15%</td>
</tr>
<tr>
<td>80 이상</td>
<td>B</td>
<td class="default_cursor_land">10%</td>
</tr>
<tr>
<td>이외</td>
<td>C</td>
<td class="default_cursor_land">0%</td>
</tr>
</tbody>
      </table>
<hr class="default_cursor_land">

<h5 class="default_cursor_land">예시</h5>

<p class="default_cursor_land"><code class="default_cursor_land">HR_DEPARTMENT</code> 테이블이 다음과 같고</p>
<table class="table default_cursor_land">
        <thead><tr>
<th class="default_cursor_land">DEPT_ID</th>
<th class="default_cursor_land">DEPT_NAME_KR</th>
<th class="default_cursor_land">DEPT_NAME_EN</th>
<th class="default_cursor_land">LOCATION</th>
</tr>
</thead>
        <tbody><tr>
<td>D0001</td>
<td class="default_cursor_land">법무팀</td>
<td class="default_cursor_land">Law Dep</td>
<td class="default_cursor_land">그렙타워 4층</td>
</tr>
<tr>
<td>D0002</td>
<td class="default_cursor_land">인사팀</td>
<td class="default_cursor_land">Human resources</td>
<td class="default_cursor_land">그렙타워 4층</td>
</tr>
<tr>
<td>D0003</td>
<td class="default_cursor_land">총무팀</td>
<td class="default_cursor_land">General Affairs</td>
<td class="default_cursor_land">그렙타워 4층</td>
</tr>
</tbody>
      </table>
<p class="default_cursor_land"><code class="default_cursor_land">HR_EMPLOYEES</code> 테이블이 다음과 같고</p>
<table class="table default_cursor_land">
        <thead><tr>
<th class="default_cursor_land">EMP_NO</th>
<th class="default_cursor_land">EMP_NAME</th>
<th class="default_cursor_land">DEPT_ID</th>
<th class="default_cursor_land">POSITION</th>
<th class="default_cursor_land">EMAIL</th>
<th class="default_cursor_land">COMP_TEL</th>
<th>HIRE_DATE</th>
<th class="default_cursor_land">SAL</th>
</tr>
</thead>
        <tbody><tr>
<td class="default_cursor_land">2017002</td>
<td class="default_cursor_land">정호식</td>
<td class="default_cursor_land">D0001</td>
<td class="default_cursor_land">팀장</td>
<td class="default_cursor_land"><a href="mailto:hosick_jung@grep.com" target="_blank" rel="noopener" class="default_pointer_land">hosick_jung@grep.com</a></td>
<td class="default_cursor_land">031-8000-1101</td>
<td class="default_cursor_land">2017-03-01</td>
<td class="default_cursor_land">65000000</td>
</tr>
<tr>
<td class="default_cursor_land">2018001</td>
<td class="default_cursor_land">김민석</td>
<td class="default_cursor_land">D0001</td>
<td class="default_cursor_land">팀원</td>
<td class="default_cursor_land"><a href="mailto:minseock_kim@grep.com" target="_blank" rel="noopener" class="default_pointer_land">minseock_kim@grep.com</a></td>
<td class="default_cursor_land">031-8000-1102</td>
<td class="default_cursor_land">2018-03-01</td>
<td class="default_cursor_land">60000000</td>
</tr>
<tr>
<td>2019001</td>
<td class="default_cursor_land">김솜이</td>
<td>D0002</td>
<td class="default_cursor_land">팀장</td>
<td class="default_cursor_land"><a href="mailto:somi_kim@grep.com" target="_blank" rel="noopener" class="default_pointer_land">somi_kim@grep.com</a></td>
<td class="default_cursor_land">031-8000-1106</td>
<td class="default_cursor_land">2019-03-01</td>
<td class="default_cursor_land">60000000</td>
</tr>
<tr>
<td class="default_cursor_land">2020002</td>
<td class="default_cursor_land">김연주</td>
<td>D0002</td>
<td>팀원</td>
<td class="default_cursor_land"><a href="mailto:yeonjoo_kim@grep.com" target="_blank" rel="noopener" class="default_pointer_land">yeonjoo_kim@grep.com</a></td>
<td class="default_cursor_land">031-8000-1107</td>
<td class="default_cursor_land">2020-03-01</td>
<td>53000000</td>
</tr>
<tr>
<td>2020005</td>
<td class="default_cursor_land">양성태</td>
<td class="default_cursor_land">D0003</td>
<td class="default_cursor_land">팀원</td>
<td class="default_cursor_land"><a href="mailto:sungtae_yang@grep.com" target="_blank" rel="noopener" class="default_pointer_land">sungtae_yang@grep.com</a></td>
<td class="default_cursor_land">031-8000-1112</td>
<td>2020-03-01</td>
<td class="default_cursor_land">53000000</td>
</tr>
</tbody>
      </table>
<p class="default_cursor_land"><code>HR_GRADE</code> 테이블이 다음과 같을 때</p>
<table class="table default_cursor_land">
        <thead><tr>
<th>EMP_NO</th>
<th>YEAR</th>
<th class="default_cursor_land">HALF_YEAR</th>
<th class="default_cursor_land">SCORE</th>
</tr>
</thead>
        <tbody><tr>
<td class="default_cursor_land">2017002</td>
<td class="default_cursor_land">2022</td>
<td class="default_cursor_land">1</td>
<td class="default_cursor_land">92</td>
</tr>
<tr>
<td class="default_cursor_land">2018001</td>
<td class="default_cursor_land">2022</td>
<td class="default_cursor_land">1</td>
<td class="default_cursor_land">89</td>
</tr>
<tr>
<td class="default_cursor_land">2019001</td>
<td class="default_cursor_land">2022</td>
<td class="default_cursor_land">1</td>
<td class="default_cursor_land">94</td>
</tr>
<tr>
<td class="default_cursor_land">2020002</td>
<td class="default_cursor_land">2022</td>
<td class="default_cursor_land">1</td>
<td class="default_cursor_land">90</td>
</tr>
<tr>
<td class="default_cursor_land">2020005</td>
<td class="default_cursor_land">2022</td>
<td class="default_cursor_land">1</td>
<td class="default_cursor_land">92</td>
</tr>
<tr>
<td class="default_cursor_land">2017002</td>
<td class="default_cursor_land">2022</td>
<td class="default_cursor_land">2</td>
<td class="default_cursor_land">84</td>
</tr>
<tr>
<td class="default_cursor_land">2018001</td>
<td class="default_cursor_land">2022</td>
<td class="default_cursor_land">2</td>
<td class="default_cursor_land">89</td>
</tr>
<tr>
<td class="default_cursor_land">2019001</td>
<td class="default_cursor_land">2022</td>
<td class="default_cursor_land">2</td>
<td class="default_cursor_land">81</td>
</tr>
<tr>
<td class="default_cursor_land">2020002</td>
<td class="default_cursor_land">2022</td>
<td class="default_cursor_land">2</td>
<td class="default_cursor_land">91</td>
</tr>
<tr>
<td class="default_cursor_land">2020005</td>
<td class="default_cursor_land">2022</td>
<td class="default_cursor_land">2</td>
<td class="default_cursor_land">81</td>
</tr>
</tbody>
      </table>
<p class="default_cursor_land">다음과 같이 사원별 성과금 정보를 출력해야 합니다.</p>
<table class="table default_cursor_land">
        <thead><tr>
<th class="default_cursor_land">EMP_NO</th>
<th class="default_cursor_land">EMP_NAME</th>
<th class="default_cursor_land">GRADE</th>
<th class="default_cursor_land">BONUS</th>
</tr>
</thead>
        <tbody><tr>
<td class="default_cursor_land">2017002</td>
<td class="default_cursor_land">정호식</td>
<td class="default_cursor_land">B</td>
<td class="default_cursor_land">6500000</td>
</tr>
<tr>
<td class="default_cursor_land">2018001</td>
<td class="default_cursor_land">김민석</td>
<td class="default_cursor_land">B</td>
<td class="default_cursor_land">6000000</td>
</tr>
<tr>
<td class="default_cursor_land">2019001</td>
<td class="default_cursor_land">김솜이</td>
<td class="default_cursor_land">B</td>
<td class="default_cursor_land">6000000</td>
</tr>
<tr>
<td class="default_cursor_land">2020002</td>
<td class="default_cursor_land">김연주</td>
<td class="default_cursor_land">A</td>
<td class="default_cursor_land">7950000</td>
</tr>
<tr>
<td class="default_cursor_land">2020005</td>
<td class="default_cursor_land">양성태</td>
<td class="default_cursor_land">B</td>
<td>5300000</td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges