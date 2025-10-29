# [level 3] 대여 기록이 존재하는 자동차 리스트 구하기 - 157341 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/157341) 

### 성능 요약

메모리: 0.0 MB, 시간: 0.00 ms

### 구분

코딩테스트 연습 > String， Date/대여 기록이 존재하는 자동차 리스트 구하기

### 채점결과

Empty

### 제출 일자

2025년 10월 29일 21:31:56

### 문제 설명

<p class="default_cursor_land">다음은 어느 자동차 대여 회사에서 대여 중인 자동차들의 정보를 담은 <code>CAR_RENTAL_COMPANY_CAR</code> 테이블과 자동차 대여 기록 정보를 담은 <code>CAR_RENTAL_COMPANY_RENTAL_HISTORY</code> 테이블입니다. <code>CAR_RENTAL_COMPANY_CAR</code> 테이블은 아래와 같은 구조로 되어있으며, <code>CAR_ID</code>, <code>CAR_TYPE</code>, <code>DAILY_FEE</code>, <code class="default_cursor_land">OPTIONS</code> 는 각각 자동차 ID, 자동차 종류, 일일 대여 요금(원), 자동차 옵션 리스트를 나타냅니다.</p>
<table class="table default_cursor_land">
        <thead><tr>
<th>Column name</th>
<th class="default_cursor_land">Type</th>
<th class="default_cursor_land">Nullable</th>
</tr>
</thead>
        <tbody><tr>
<td>CAR_ID</td>
<td>INTEGER</td>
<td>FALSE</td>
</tr>
<tr>
<td>CAR_TYPE</td>
<td>VARCHAR(255)</td>
<td class="default_cursor_land">FALSE</td>
</tr>
<tr>
<td>DAILY_FEE</td>
<td>INTEGER</td>
<td class="default_cursor_land">FALSE</td>
</tr>
<tr>
<td>OPTIONS</td>
<td class="default_cursor_land">VARCHAR(255)</td>
<td class="default_cursor_land">FALSE</td>
</tr>
</tbody>
      </table>
<p class="default_cursor_land">자동차 종류는 '세단', 'SUV', '승합차', '트럭', '리무진' 이 있습니다. 자동차 옵션 리스트는 콤마(',')로 구분된 키워드 리스트(예: '열선시트', '스마트키', '주차감지센서')로 되어있으며, 키워드 종류는 '주차감지센서', '스마트키', '네비게이션', '통풍시트', '열선시트', '후방카메라', '가죽시트' 가 있습니다.</p>

<p class="default_cursor_land"><code class="default_cursor_land">CAR_RENTAL_COMPANY_RENTAL_HISTORY</code> 테이블은 아래와 같은 구조로 되어있으며, <code>HISTORY_ID</code>, <code>CAR_ID</code>, <code class="default_cursor_land">START_DATE</code>, <code class="default_cursor_land">END_DATE</code> 는 각각 자동차 대여 기록 ID, 자동차 ID, 대여 시작일, 대여 종료일을 나타냅니다.</p>
<table class="table default_cursor_land">
        <thead><tr>
<th>Column name</th>
<th>Type</th>
<th>Nullable</th>
</tr>
</thead>
        <tbody><tr>
<td>HISTORY_ID</td>
<td>INTEGER</td>
<td>FALSE</td>
</tr>
<tr>
<td>CAR_ID</td>
<td>INTEGER</td>
<td>FALSE</td>
</tr>
<tr>
<td>START_DATE</td>
<td>DATE</td>
<td>FALSE</td>
</tr>
<tr>
<td>END_DATE</td>
<td>DATE</td>
<td class="default_cursor_land">FALSE</td>
</tr>
</tbody>
      </table>
<hr>

<h5>문제</h5>

<p class="default_cursor_land"><code>CAR_RENTAL_COMPANY_CAR</code> 테이블과 <code class="default_cursor_land">CAR_RENTAL_COMPANY_RENTAL_HISTORY</code> 테이블에서 자동차 종류가 '세단'인 자동차들 중 10월에 대여를 시작한 기록이 있는 자동차 ID 리스트를 출력하는 SQL문을 작성해주세요. 자동차 ID 리스트는 중복이 없어야 하며, 자동차 ID를 기준으로 내림차순 정렬해주세요.</p>

<hr>

<h5 class="default_cursor_land">예시</h5>

<p class="default_cursor_land">예를 들어 <code class="default_cursor_land">CAR_RENTAL_COMPANY_CAR</code> 테이블이 다음과 같고</p>
<table class="table default_cursor_land">
        <thead><tr>
<th class="default_cursor_land">CAR_ID</th>
<th class="default_cursor_land">CAR_TYPE</th>
<th class="default_cursor_land">DAILY_FEE</th>
<th class="default_cursor_land">OPTIONS</th>
</tr>
</thead>
        <tbody><tr>
<td class="default_cursor_land">1</td>
<td class="default_cursor_land">세단</td>
<td class="default_cursor_land">16000</td>
<td class="default_cursor_land">가죽시트,열선시트,후방카메라</td>
</tr>
<tr>
<td>2</td>
<td>SUV</td>
<td class="default_cursor_land">14000</td>
<td class="default_cursor_land">스마트키,네비게이션,열선시트</td>
</tr>
<tr>
<td>3</td>
<td class="default_cursor_land">세단</td>
<td class="default_cursor_land">22000</td>
<td class="default_cursor_land">주차감지센서,후방카메라,가죽시트</td>
</tr>
<tr>
<td>4</td>
<td class="default_cursor_land">세단</td>
<td class="default_cursor_land">12000</td>
<td class="default_cursor_land">주차감지센서</td>
</tr>
</tbody>
      </table>
<p class="default_cursor_land"><code class="default_cursor_land">CAR_RENTAL_COMPANY_RENTAL_HISTORY</code> 테이블이 다음과 같다면</p>
<table class="table default_cursor_land">
        <thead><tr>
<th>HISTORY_ID</th>
<th class="default_cursor_land">CAR_ID</th>
<th class="default_cursor_land">START_DATE</th>
<th class="default_cursor_land">END_DATE</th>
</tr>
</thead>
        <tbody><tr>
<td>1</td>
<td class="default_cursor_land">4</td>
<td class="default_cursor_land">2022-09-27</td>
<td class="default_cursor_land">2022-09-27</td>
</tr>
<tr>
<td class="default_cursor_land">2</td>
<td class="default_cursor_land">3</td>
<td class="default_cursor_land">2022-10-03</td>
<td class="default_cursor_land">2022-10-04</td>
</tr>
<tr>
<td>3</td>
<td class="default_cursor_land">2</td>
<td class="default_cursor_land">2022-10-05</td>
<td class="default_cursor_land">2022-10-05</td>
</tr>
<tr>
<td class="default_cursor_land">4</td>
<td class="default_cursor_land">1</td>
<td class="default_cursor_land">2022-10-11</td>
<td class="default_cursor_land">2022-10-14</td>
</tr>
<tr>
<td class="default_cursor_land">5</td>
<td class="default_cursor_land">3</td>
<td class="default_cursor_land">2022-10-13</td>
<td class="default_cursor_land">2022-10-15</td>
</tr>
</tbody>
      </table>
<p class="default_cursor_land">10월에 대여를 시작한 기록이 있는 '세단' 종류의 자동차는 자동차 ID가 1, 3 인 자동차이고, 자동차 ID를 기준으로 내림차순 정렬하면 다음과 같이 나와야 합니다.</p>
<table class="table default_cursor_land">
        <thead><tr>
<th>CAR_ID</th>
</tr>
</thead>
        <tbody><tr>
<td>3</td>
</tr>
<tr>
<td>1</td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges