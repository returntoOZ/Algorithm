# [level 3] 조건에 맞는 사용자와 총 거래금액 조회하기 - 164668 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/164668) 

### 성능 요약

메모리: 0.0 MB, 시간: 0.00 ms

### 구분

코딩테스트 연습 > GROUP BY

### 채점결과

Empty

### 제출 일자

2025년 10월 16일 21:04:47

### 문제 설명

<p class="default_cursor_land">다음은 중고 거래 게시판 정보를 담은 <code class="default_cursor_land">USED_GOODS_BOARD</code> 테이블과 중고 거래 게시판 사용자 정보를 담은 <code class="default_cursor_land">USED_GOODS_USER</code> 테이블입니다. <code>USED_GOODS_BOARD</code> 테이블은 다음과 같으며 <code class="default_cursor_land">BOARD_ID</code>, <code>WRITER_ID</code>, <code>TITLE</code>, <code>CONTENTS</code>, <code>PRICE</code>, <code class="default_cursor_land">CREATED_DATE</code>, <code>STATUS</code>, <code>VIEWS</code>는 게시글 ID, 작성자 ID, 게시글 제목, 게시글 내용, 가격, 작성일, 거래상태, 조회수를 의미합니다.</p>
<table class="table default_cursor_land">
        <thead><tr>
<th class="default_cursor_land">Column name</th>
<th class="default_cursor_land">Type</th>
<th class="default_cursor_land">Nullable</th>
</tr>
</thead>
        <tbody><tr>
<td class="default_cursor_land">BOARD_ID</td>
<td class="default_cursor_land">VARCHAR(5)</td>
<td class="default_cursor_land">FALSE</td>
</tr>
<tr>
<td class="default_cursor_land">WRITER_ID</td>
<td class="default_cursor_land">VARCHAR(50)</td>
<td>FALSE</td>
</tr>
<tr>
<td class="default_cursor_land">TITLE</td>
<td class="default_cursor_land">VARCHAR(100)</td>
<td>FALSE</td>
</tr>
<tr>
<td class="default_cursor_land">CONTENTS</td>
<td class="default_cursor_land">VARCHAR(1000)</td>
<td>FALSE</td>
</tr>
<tr>
<td>PRICE</td>
<td>NUMBER</td>
<td>FALSE</td>
</tr>
<tr>
<td class="default_cursor_land">CREATED_DATE</td>
<td>DATE</td>
<td>FALSE</td>
</tr>
<tr>
<td>STATUS</td>
<td class="default_cursor_land">VARCHAR(10)</td>
<td>FALSE</td>
</tr>
<tr>
<td>VIEWS</td>
<td class="default_cursor_land">NUMBER</td>
<td class="default_cursor_land">FALSE</td>
</tr>
</tbody>
      </table>
<p class="default_cursor_land"><code>USED_GOODS_USER</code> 테이블은 다음과 같으며 <code>USER_ID</code>, <code>NICKNAME</code>, <code>CITY</code>, <code>STREET_ADDRESS1</code>, <code>STREET_ADDRESS2</code>, <code>TLNO</code>는 각각 회원 ID, 닉네임, 시, 도로명 주소, 상세 주소, 전화번호를 를 의미합니다.</p>
<table class="table default_cursor_land">
        <thead><tr>
<th class="default_cursor_land">Column name</th>
<th class="default_cursor_land">Type</th>
<th class="default_cursor_land">Nullable</th>
</tr>
</thead>
        <tbody><tr>
<td class="default_cursor_land">USER_ID</td>
<td>VARCHAR(50)</td>
<td>FALSE</td>
</tr>
<tr>
<td class="default_cursor_land">NICKNAME</td>
<td>VARCHAR(100)</td>
<td>FALSE</td>
</tr>
<tr>
<td class="default_cursor_land">CITY</td>
<td class="default_cursor_land">VARCHAR(100)</td>
<td class="default_cursor_land">FALSE</td>
</tr>
<tr>
<td class="default_cursor_land">STREET_ADDRESS1</td>
<td class="default_cursor_land">VARCHAR(100)</td>
<td class="default_cursor_land">FALSE</td>
</tr>
<tr>
<td class="default_cursor_land">STREET_ADDRESS2</td>
<td class="default_cursor_land">VARCHAR(100)</td>
<td class="default_cursor_land">TRUE</td>
</tr>
<tr>
<td class="default_cursor_land">TLNO</td>
<td class="default_cursor_land">VARCHAR(20)</td>
<td class="default_cursor_land">FALSE</td>
</tr>
</tbody>
      </table>
<hr class="default_cursor_land">

<h5 class="default_cursor_land">문제</h5>

<p class="default_cursor_land"><code class="default_cursor_land">USED_GOODS_BOARD</code>와 <code class="default_cursor_land">USED_GOODS_USER</code> 테이블에서 완료된 중고 거래의 총금액이 70만 원 이상인 사람의 회원 ID, 닉네임, 총거래금액을 조회하는 SQL문을 작성해주세요. 결과는 총거래금액을 기준으로 오름차순 정렬해주세요.</p>

<hr class="default_cursor_land">

<h5 class="default_cursor_land">예시</h5>

<p class="default_cursor_land"><code class="default_cursor_land">USED_GOODS_BOARD</code> 테이블이 다음과 같고</p>
<table class="table default_cursor_land">
        <thead><tr>
<th>BOARD_ID</th>
<th>WRITER_ID</th>
<th class="default_cursor_land">TITLE</th>
<th class="default_cursor_land">CONTENTS</th>
<th class="default_cursor_land">PRICE</th>
<th class="default_cursor_land">CREATED_DATE</th>
<th class="default_cursor_land">STATUS</th>
<th class="default_cursor_land">VIEWS</th>
</tr>
</thead>
        <tbody><tr>
<td class="default_cursor_land">B0001</td>
<td class="default_cursor_land">zkzkdh1</td>
<td class="default_cursor_land">캠핑의자</td>
<td class="default_cursor_land">가벼워요 깨끗한 상태입니다. 2개</td>
<td class="default_cursor_land">25000</td>
<td class="default_cursor_land">2022-11-29</td>
<td class="default_cursor_land">SALE</td>
<td>34</td>
</tr>
<tr>
<td>B0002</td>
<td>miyeon89</td>
<td>벽걸이 에어컨</td>
<td class="default_cursor_land">엘지 휘센 7평</td>
<td>100000</td>
<td class="default_cursor_land">2022-11-29</td>
<td class="default_cursor_land">SALE</td>
<td class="default_cursor_land">55</td>
</tr>
<tr>
<td class="default_cursor_land">B0003</td>
<td class="default_cursor_land">dhfkzmf09</td>
<td class="default_cursor_land">에어팟 맥스</td>
<td class="default_cursor_land">에어팟 맥스 스카이 블루 색상 판매합니다.</td>
<td class="default_cursor_land">450000</td>
<td class="default_cursor_land">2022-11-26</td>
<td class="default_cursor_land">DONE</td>
<td>67</td>
</tr>
<tr>
<td>B0004</td>
<td>sangjune1</td>
<td>파파야나인 포르쉐 푸쉬카</td>
<td class="default_cursor_land">예민하신분은 피해주세요</td>
<td class="default_cursor_land">30000</td>
<td class="default_cursor_land">2022-11-30</td>
<td>DONE</td>
<td class="default_cursor_land">78</td>
</tr>
<tr>
<td>B0005</td>
<td class="default_cursor_land">zkzkdh1</td>
<td class="default_cursor_land">애플워치7</td>
<td class="default_cursor_land">애플워치7 실버 스텐 45미리 판매합니다.</td>
<td class="default_cursor_land">700000</td>
<td class="default_cursor_land">2022-11-30</td>
<td>DONE</td>
<td>99</td>
</tr>
</tbody>
      </table>
<p class="default_cursor_land"><code>USED_GOODS_USER</code> 테이블이 다음과 같을 때</p>
<table class="table default_cursor_land">
        <thead><tr>
<th>USER_ID</th>
<th class="default_cursor_land">NICKNAME</th>
<th>CITY</th>
<th class="default_cursor_land">STREET_ADDRESS1</th>
<th>STREET_ADDRESS2</th>
<th>TLNO</th>
</tr>
</thead>
        <tbody><tr>
<td>cjfwls91</td>
<td class="default_cursor_land">점심만금식</td>
<td>성남시</td>
<td class="default_cursor_land">분당구 내정로 185</td>
<td>501호</td>
<td>01036344964</td>
</tr>
<tr>
<td>zkzkdh1</td>
<td class="default_cursor_land">후후후</td>
<td class="default_cursor_land">성남시</td>
<td class="default_cursor_land">분당구 내정로 35</td>
<td class="default_cursor_land">가동 1202호</td>
<td>01032777543</td>
</tr>
<tr>
<td>spdlqj12</td>
<td>크크큭</td>
<td>성남시</td>
<td class="default_cursor_land">분당구 수내로 206</td>
<td class="default_cursor_land">2019동 801호</td>
<td class="default_cursor_land">01087234922</td>
</tr>
<tr>
<td>xlqpfh2</td>
<td>잉여킹</td>
<td>성남시</td>
<td class="default_cursor_land">분당구 수내로 1</td>
<td class="default_cursor_land">001-004</td>
<td>01064534911</td>
</tr>
<tr>
<td>dhfkzmf09</td>
<td>찐찐</td>
<td>성남시</td>
<td class="default_cursor_land">분당구 수내로 13</td>
<td class="default_cursor_land">A동 1107호</td>
<td>01053422914</td>
</tr>
</tbody>
      </table>
<p class="default_cursor_land">SQL을 실행하면 다음과 같이 출력되어야 합니다.</p>
<table class="table default_cursor_land">
        <thead><tr>
<th>USER_ID</th>
<th>NICKNAME</th>
<th>TOTAL_SALES</th>
</tr>
</thead>
        <tbody><tr>
<td>zkzkdh1</td>
<td>후후후</td>
<td>700000</td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges