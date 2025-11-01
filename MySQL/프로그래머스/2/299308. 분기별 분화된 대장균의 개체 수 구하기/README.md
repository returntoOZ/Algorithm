# [level 2] 분기별 분화된 대장균의 개체 수 구하기 - 299308 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/299308) 

### 성능 요약

메모리: undefined, 시간: 

### 구분

코딩테스트 연습 > String， Date

### 채점결과

합계: 100.0 / 100.0

### 제출 일자

2025년 11월 01일 09:40:57

### 문제 설명

<p class="default_cursor_land">대장균들은 일정 주기로 분화하며, 분화를 시작한 개체를 부모 개체, 분화가 되어 나온 개체를 자식 개체라고 합니다.<br>
다음은 실험실에서 배양한 대장균들의 정보를 담은 <code>ECOLI_DATA</code> 테이블입니다. <code>ECOLI_DATA</code> 테이블의 구조는 다음과 같으며,  <code>ID</code>, <code>PARENT_ID</code>, <code>SIZE_OF_COLONY</code>, <code class="default_cursor_land">DIFFERENTIATION_DATE</code>, <code>GENOTYPE</code> 은 각각 대장균 개체의 ID, 부모 개체의 ID, 개체의 크기, 분화되어 나온 날짜, 개체의 형질을 나타냅니다.</p>
<table class="table default_cursor_land">
        <thead><tr>
<th class="default_cursor_land">Column name</th>
<th class="default_cursor_land">Type</th>
<th class="default_cursor_land">Nullable</th>
</tr>
</thead>
        <tbody><tr>
<td class="default_cursor_land">ID</td>
<td class="default_cursor_land">INTEGER</td>
<td class="default_cursor_land">FALSE</td>
</tr>
<tr>
<td>PARENT_ID</td>
<td class="default_cursor_land">INTEGER</td>
<td>TRUE</td>
</tr>
<tr>
<td class="default_cursor_land">SIZE_OF_COLONY</td>
<td class="default_cursor_land">INTEGER</td>
<td>FALSE</td>
</tr>
<tr>
<td>DIFFERENTIATION_DATE</td>
<td class="default_cursor_land">DATE</td>
<td>FALSE</td>
</tr>
<tr>
<td>GENOTYPE</td>
<td class="default_cursor_land">INTEGER</td>
<td>FALSE</td>
</tr>
</tbody>
      </table>
<p class="default_cursor_land">최초의 대장균 개체의 <code class="default_cursor_land">PARENT_ID</code> 는 NULL 값입니다.</p>

<hr>

<h5 class="default_cursor_land">문제</h5>

<p class="default_cursor_land">각 분기(<code>QUARTER</code>)별 분화된 대장균의 개체의 총 수(<code>ECOLI_COUNT</code>)를 출력하는 SQL 문을 작성해주세요. 이때 각 분기에는 'Q' 를 붙이고 분기에 대해 오름차순으로 정렬해주세요. 대장균 개체가 분화되지 않은 분기는 없습니다.</p>

<hr>

<h5 class="default_cursor_land">예시</h5>

<p class="default_cursor_land">예를 들어 <code class="default_cursor_land">ECOLI_DATA</code> 테이블이 다음과 같다면</p>
<table class="table default_cursor_land">
        <thead><tr>
<th>ID</th>
<th class="default_cursor_land">PARENT_ID</th>
<th class="default_cursor_land">SIZE_OF_COLONY</th>
<th class="default_cursor_land">DIFFERENTIATION_DATE</th>
<th>GENOTYPE</th>
</tr>
</thead>
        <tbody><tr>
<td>1</td>
<td class="default_cursor_land">NULL</td>
<td class="default_cursor_land">10</td>
<td class="default_cursor_land">2019/01/01</td>
<td>5</td>
</tr>
<tr>
<td>2</td>
<td>NULL</td>
<td class="default_cursor_land">2</td>
<td class="default_cursor_land">2019/05/01</td>
<td>3</td>
</tr>
<tr>
<td>3</td>
<td class="default_cursor_land">1</td>
<td class="default_cursor_land">100</td>
<td class="default_cursor_land">2020/01/01</td>
<td>4</td>
</tr>
<tr>
<td>4</td>
<td class="default_cursor_land">2</td>
<td class="default_cursor_land">17</td>
<td class="default_cursor_land">2022/04/01</td>
<td>4</td>
</tr>
<tr>
<td>5</td>
<td class="default_cursor_land">2</td>
<td class="default_cursor_land">10</td>
<td class="default_cursor_land">2020/09/01</td>
<td>6</td>
</tr>
<tr>
<td>6</td>
<td class="default_cursor_land">4</td>
<td class="default_cursor_land">101</td>
<td class="default_cursor_land">2021/12/01</td>
<td>22</td>
</tr>
</tbody>
      </table>
<p class="default_cursor_land">각 분기별로 분화된 대장균 개체는 다음과 같습니다.</p>

<p class="default_cursor_land">1분기 : ID 1, ID 3<br>
2분기 : ID 2, ID 4<br>
3분기 : ID 5<br>
4분기 : ID 6</p>

<p class="default_cursor_land">따라서 결과는 다음과 같아야 합니다</p>
<table class="table default_cursor_land">
        <thead><tr>
<th class="default_cursor_land">QUARTER</th>
<th class="default_cursor_land">ECOLI_COUNT</th>
</tr>
</thead>
        <tbody><tr>
<td class="default_cursor_land">1Q</td>
<td class="default_cursor_land">2</td>
</tr>
<tr>
<td>2Q</td>
<td class="default_cursor_land">2</td>
</tr>
<tr>
<td>3Q</td>
<td class="default_cursor_land">1</td>
</tr>
<tr>
<td>4Q</td>
<td class="default_cursor_land">1</td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges