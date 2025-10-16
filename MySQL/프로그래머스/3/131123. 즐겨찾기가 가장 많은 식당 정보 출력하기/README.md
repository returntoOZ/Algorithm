# [level 3] 즐겨찾기가 가장 많은 식당 정보 출력하기 - 131123 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/131123) 

### 성능 요약

메모리: 0.0 MB, 시간: 0.00 ms

### 구분

코딩테스트 연습 > GROUP BY

### 채점결과

Empty

### 제출 일자

2025년 10월 16일 20:52:40

### 문제 설명

<p class="default_cursor_land">다음은 식당의 정보를 담은 <code>REST_INFO</code> 테이블입니다. <code>REST_INFO</code> 테이블은 다음과 같으며 <code>REST_ID</code>, <code>REST_NAME</code>, <code>FOOD_TYPE</code>, <code>VIEWS</code>, <code>FAVORITES</code>, <code>PARKING_LOT</code>, <code>ADDRESS</code>, <code>TEL</code>은 식당 ID, 식당 이름, 음식 종류, 조회수, 즐겨찾기수, 주차장 유무, 주소, 전화번호를 의미합니다.</p>
<table class="table default_cursor_land">
        <thead><tr>
<th>Column name</th>
<th class="default_cursor_land">Type</th>
<th class="default_cursor_land">Nullable</th>
</tr>
</thead>
        <tbody><tr>
<td>REST_ID</td>
<td class="default_cursor_land">VARCHAR(5)</td>
<td class="default_cursor_land">FALSE</td>
</tr>
<tr>
<td>REST_NAME</td>
<td class="default_cursor_land">VARCHAR(50)</td>
<td class="default_cursor_land">FALSE</td>
</tr>
<tr>
<td>FOOD_TYPE</td>
<td class="default_cursor_land">VARCHAR(20)</td>
<td class="default_cursor_land">TRUE</td>
</tr>
<tr>
<td>VIEWS</td>
<td class="default_cursor_land">NUMBER</td>
<td>TRUE</td>
</tr>
<tr>
<td>FAVORITES</td>
<td class="default_cursor_land">NUMBER</td>
<td>TRUE</td>
</tr>
<tr>
<td>PARKING_LOT</td>
<td class="default_cursor_land">VARCHAR(1)</td>
<td class="default_cursor_land">TRUE</td>
</tr>
<tr>
<td class="default_cursor_land">ADDRESS</td>
<td>VARCHAR(100)</td>
<td class="default_cursor_land">TRUE</td>
</tr>
<tr>
<td class="default_cursor_land">TEL</td>
<td>VARCHAR(100)</td>
<td class="default_cursor_land">TRUE</td>
</tr>
</tbody>
      </table>
<hr>

<h5 class="default_cursor_land">문제</h5>

<p class="default_cursor_land"><code>REST_INFO</code> 테이블에서 음식종류별로 즐겨찾기수가 가장 많은 식당의 음식 종류, ID, 식당 이름, 즐겨찾기수를 조회하는 SQL문을 작성해주세요. 이때 결과는 음식 종류를 기준으로 내림차순 정렬해주세요.</p>

<hr>

<h5 class="default_cursor_land">예시</h5>

<p class="default_cursor_land"><code>REST_INFO</code> 테이블이 다음과 같을 때</p>
<table class="table">
        <thead><tr>
<th>REST_ID</th>
<th>REST_NAME</th>
<th>FOOD_TYPE</th>
<th class="default_cursor_land">VIEWS</th>
<th>FAVORITES</th>
<th>PARKING_LOT</th>
<th>ADDRESS</th>
<th>TEL</th>
</tr>
</thead>
        <tbody><tr>
<td>00001</td>
<td class="default_cursor_land">은돼지식당</td>
<td>한식</td>
<td class="default_cursor_land">1150345</td>
<td class="default_cursor_land">734</td>
<td>N</td>
<td>서울특별시 중구 다산로 149</td>
<td>010-4484-8751</td>
</tr>
<tr>
<td>00002</td>
<td class="default_cursor_land">하이가쯔네</td>
<td>일식</td>
<td>120034</td>
<td>112</td>
<td>N</td>
<td>서울시 중구 신당동 375-21</td>
<td>NULL</td>
</tr>
<tr>
<td>00003</td>
<td>따띠따띠뜨</td>
<td>양식</td>
<td>1234023</td>
<td class="default_cursor_land">102</td>
<td class="default_cursor_land">N</td>
<td>서울시 강남구 신사동 627-3 1F</td>
<td>02-6397-1023</td>
</tr>
<tr>
<td>00004</td>
<td class="default_cursor_land">스시사카우스</td>
<td class="default_cursor_land">일식</td>
<td class="default_cursor_land">1522074</td>
<td class="default_cursor_land">230</td>
<td>N</td>
<td>서울시 서울시 강남구 신사동 627-27</td>
<td>010-9394-2554</td>
</tr>
<tr>
<td>00005</td>
<td class="default_cursor_land">코슌스</td>
<td>일식</td>
<td>15301</td>
<td>123</td>
<td>N</td>
<td>서울특별시 강남구 언주로153길</td>
<td>010-1315-8729</td>
</tr>
</tbody>
      </table>
<p>SQL을 실행하면 다음과 같이 출력되어야 합니다.</p>
<table class="table">
        <thead><tr>
<th>FOOD_TYPE</th>
<th>REST_ID</th>
<th>REST_NAME</th>
<th>FAVORITES</th>
</tr>
</thead>
        <tbody><tr>
<td>한식</td>
<td>00001</td>
<td>은돼지식당</td>
<td>734</td>
</tr>
<tr>
<td>일식</td>
<td>00004</td>
<td>스시사카우스</td>
<td>230</td>
</tr>
<tr>
<td>양식</td>
<td>00003</td>
<td>따띠따띠뜨</td>
<td>102</td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges