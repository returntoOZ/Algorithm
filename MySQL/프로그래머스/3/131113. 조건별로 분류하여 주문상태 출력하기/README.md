# [level 3] 조건별로 분류하여 주문상태 출력하기 - 131113 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/131113) 

### 성능 요약

메모리: 0.0 MB, 시간: 0.00 ms

### 구분

코딩테스트 연습 > String， Date

### 채점결과

Empty

### 제출 일자

2025년 10월 28일 13:32:27

### 문제 설명

<p class="default_cursor_land">다음은 식품공장의 주문정보를 담은 <code class="default_cursor_land">FOOD_ORDER</code> 테이블입니다. <code class="default_cursor_land">FOOD_ORDER</code> 테이블은 다음과 같으며 <code>ORDER_ID</code>, <code class="default_cursor_land">PRODUCT_ID</code>, <code class="default_cursor_land">AMOUNT</code>, <code class="default_cursor_land">PRODUCE_DATE</code>, <code class="default_cursor_land">IN_DATE</code>,<code class="default_cursor_land">OUT_DATE</code>,<code class="default_cursor_land">FACTORY_ID</code>, <code class="default_cursor_land">WAREHOUSE_ID</code>는 각각 주문 ID, 제품 ID, 주문양, 생산일자, 입고일자, 출고일자, 공장 ID, 창고 ID를 의미합니다.</p>
<table class="table default_cursor_land">
        <thead><tr>
<th class="default_cursor_land">Column name</th>
<th class="default_cursor_land">Type</th>
<th class="default_cursor_land">Nullable</th>
</tr>
</thead>
        <tbody><tr>
<td class="default_cursor_land">ORDER_ID</td>
<td class="default_cursor_land">VARCHAR(10)</td>
<td class="default_cursor_land">FALSE</td>
</tr>
<tr>
<td class="default_cursor_land">PRODUCT_ID</td>
<td class="default_cursor_land">VARCHAR(5)</td>
<td class="default_cursor_land">FALSE</td>
</tr>
<tr>
<td class="default_cursor_land">AMOUNT</td>
<td class="default_cursor_land">NUMBER</td>
<td>FALSE</td>
</tr>
<tr>
<td>PRODUCE_DATE</td>
<td class="default_cursor_land">DATE</td>
<td>TRUE</td>
</tr>
<tr>
<td>IN_DATE</td>
<td class="default_cursor_land">DATE</td>
<td>TRUE</td>
</tr>
<tr>
<td>OUT_DATE</td>
<td class="default_cursor_land">DATE</td>
<td class="default_cursor_land">TRUE</td>
</tr>
<tr>
<td>FACTORY_ID</td>
<td class="default_cursor_land">VARCHAR(10)</td>
<td>FALSE</td>
</tr>
<tr>
<td>WAREHOUSE_ID</td>
<td class="default_cursor_land">VARCHAR(10)</td>
<td>FALSE</td>
</tr>
</tbody>
      </table>
<hr>

<h5 class="default_cursor_land">문제</h5>

<p class="default_cursor_land"><code class="default_cursor_land">FOOD_ORDER</code> 테이블에서 2022년 5월 1일을 기준으로 주문 ID, 제품 ID, 출고일자, 출고여부를 조회하는 SQL문을 작성해주세요. 출고여부는 2022년 5월 1일까지 출고완료로 이 후 날짜는 출고 대기로 미정이면 출고미정으로 출력해주시고, 결과는 주문 ID를 기준으로 오름차순 정렬해주세요.</p>

<hr class="default_cursor_land">

<h5 class="default_cursor_land">예시</h5>

<p class="default_cursor_land"><code>FOOD_ORDER</code> 테이블이 다음과 같을 때</p>
<table class="table default_cursor_land">
        <thead><tr>
<th class="default_cursor_land">ORDER_ID</th>
<th class="default_cursor_land">PRODUCT_ID</th>
<th class="default_cursor_land">AMOUNT</th>
<th class="default_cursor_land">PRODUCE_DATE</th>
<th>IN_DATE</th>
<th>OUT_DATE</th>
<th>FACTORY_ID</th>
<th>WAREHOUSE_ID</th>
</tr>
</thead>
        <tbody><tr>
<td class="default_cursor_land">OD00000051</td>
<td class="default_cursor_land">P0002</td>
<td class="default_cursor_land">4000</td>
<td class="default_cursor_land">2022-04-01</td>
<td>2022-04-21</td>
<td>2022-04-21</td>
<td>FT19970003</td>
<td>WH0005</td>
</tr>
<tr>
<td class="default_cursor_land">OD00000052</td>
<td class="default_cursor_land">P0003</td>
<td class="default_cursor_land">2500</td>
<td class="default_cursor_land">2022-04-10</td>
<td>2022-04-27</td>
<td>2022-04-27</td>
<td>FT19970003</td>
<td>WH0006</td>
</tr>
<tr>
<td class="default_cursor_land">OD00000053</td>
<td class="default_cursor_land">P0005</td>
<td class="default_cursor_land">6200</td>
<td class="default_cursor_land">2022-04-15</td>
<td>2022-04-30</td>
<td>2022-05-01</td>
<td>FT19940003</td>
<td>WH0003</td>
</tr>
<tr>
<td>OD00000054</td>
<td class="default_cursor_land">P0006</td>
<td class="default_cursor_land">1000</td>
<td class="default_cursor_land">2022-04-21</td>
<td>2022-04-30</td>
<td>NULL</td>
<td>FT19940003</td>
<td>WH0009</td>
</tr>
<tr>
<td class="default_cursor_land">OD00000055</td>
<td class="default_cursor_land">P0008</td>
<td class="default_cursor_land">1500</td>
<td class="default_cursor_land">2022-04-25</td>
<td>2022-05-11</td>
<td>2022-05-11</td>
<td>FT19980003</td>
<td>WH0009</td>
</tr>
</tbody>
      </table>
<p class="default_cursor_land">SQL을 실행하면 다음과 같이 출력되어야 합니다.</p>
<table class="table default_cursor_land">
        <thead><tr>
<th class="default_cursor_land">ORDER_ID</th>
<th class="default_cursor_land">PRODUCT_ID</th>
<th class="default_cursor_land">OUT_DATE</th>
<th class="default_cursor_land">출고여부</th>
</tr>
</thead>
        <tbody><tr>
<td class="default_cursor_land">OD00000051</td>
<td class="default_cursor_land">P0002</td>
<td class="default_cursor_land">2022-04-21</td>
<td class="default_cursor_land">출고완료</td>
</tr>
<tr>
<td class="default_cursor_land">OD00000052</td>
<td class="default_cursor_land">P0003</td>
<td class="default_cursor_land">2022-04-27</td>
<td>출고완료</td>
</tr>
<tr>
<td class="default_cursor_land">OD00000053</td>
<td>P0005</td>
<td class="default_cursor_land">2022-05-01</td>
<td class="default_cursor_land">출고완료</td>
</tr>
<tr>
<td>OD00000054</td>
<td>P0006</td>
<td class="default_cursor_land"></td>
<td class="default_cursor_land">출고미정</td>
</tr>
<tr>
<td>OD00000055</td>
<td>P0008</td>
<td class="default_cursor_land">2022-05-11</td>
<td class="default_cursor_land">출고대기</td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges