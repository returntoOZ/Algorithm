# [level 2] 튜플 - 64065 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/64065) 

### 성능 요약

메모리: 108 MB, 시간: 42.16 ms

### 구분

코딩테스트 연습 > 2019 카카오 개발자 겨울 인턴십

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2025년 10월 30일 15:33:23

### 문제 설명

<p class="default_cursor_land">셀수있는 수량의 순서있는 열거 또는 어떤 순서를 따르는 요소들의 모음을 튜플(tuple)이라고 합니다. n개의 요소를 가진 튜플을 n-튜플(n-tuple)이라고 하며, 다음과 같이 표현할 수 있습니다.</p>

<ul>
<li class="default_cursor_land">(a1, a2, a3, ..., an)</li>
</ul>

<p class="default_cursor_land">튜플은 다음과 같은 성질을 가지고 있습니다.</p>

<ol class="default_cursor_land">
<li class="default_cursor_land">중복된 원소가 있을 수 있습니다. ex : (2, 3, 1, 2)</li>
<li class="default_cursor_land">원소에 정해진 순서가 있으며, 원소의 순서가 다르면 서로 다른 튜플입니다. ex : (1, 2, 3) ≠ (1, 3, 2)</li>
<li class="default_cursor_land">튜플의 원소 개수는 유한합니다.</li>
</ol>

<p class="default_cursor_land">원소의 개수가 n개이고, <u><strong class="default_cursor_land">중복되는 원소가 없는</strong></u> 튜플 <code>(a1, a2, a3, ..., an)</code>이 주어질 때(단, a1, a2, ..., an은 자연수), 이는 다음과 같이 집합 기호 '{', '}'를 이용해 표현할 수 있습니다.</p>

<ul class="default_cursor_land">
<li class="default_cursor_land">{{a1}, {a1, a2}, {a1, a2, a3}, {a1, a2, a3, a4}, ... {a1, a2, a3, a4, ..., an}}</li>
</ul>

<p class="default_cursor_land">예를 들어 튜플이 (2, 1, 3, 4)인 경우 이는</p>

<ul class="default_cursor_land">
<li class="default_cursor_land">{{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}</li>
</ul>

<p class="default_cursor_land">와 같이 표현할 수 있습니다. 이때, 집합은 원소의 순서가 바뀌어도 상관없으므로</p>

<ul class="default_cursor_land">
<li class="default_cursor_land">{{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}</li>
<li class="default_cursor_land">{{2, 1, 3, 4}, {2}, {2, 1, 3}, {2, 1}}</li>
<li class="default_cursor_land">{{1, 2, 3}, {2, 1}, {1, 2, 4, 3}, {2}}</li>
</ul>

<p class="default_cursor_land">는 모두 같은 튜플 (2, 1, 3, 4)를 나타냅니다.</p>

<p>특정 튜플을 표현하는 집합이 담긴 문자열 s가 매개변수로 주어질 때, s가 표현하는 튜플을 배열에 담아 return 하도록 solution 함수를 완성해주세요.</p>

<h4><strong>[제한사항]</strong></h4>

<ul class="default_cursor_land">
<li class="default_cursor_land">s의 길이는 5 이상 1,000,000 이하입니다.</li>
<li class="default_cursor_land">s는 숫자와 '{', '}', ',' 로만 이루어져 있습니다.</li>
<li class="default_cursor_land">숫자가 0으로 시작하는 경우는 없습니다.</li>
<li class="default_cursor_land">s는 항상 중복되는 원소가 없는 튜플을 올바르게 표현하고 있습니다.</li>
<li class="default_cursor_land">s가 표현하는 튜플의 원소는 1 이상 100,000 이하인 자연수입니다.</li>
<li class="default_cursor_land">return 하는 배열의 길이가 1 이상 500 이하인 경우만 입력으로 주어집니다.</li>
</ul>

<hr class="default_cursor_land">

<h5 class="default_cursor_land"><strong>[입출력 예]</strong></h5>
<table class="table default_cursor_land">
        <thead><tr>
<th class="default_cursor_land">s</th>
<th class="default_cursor_land">result</th>
</tr>
</thead>
        <tbody><tr>
<td class="default_cursor_land"><code class="default_cursor_land">"{{2},{2,1},{2,1,3},{2,1,3,4}}"</code></td>
<td class="default_cursor_land">[2, 1, 3, 4]</td>
</tr>
<tr>
<td class="default_cursor_land"><code class="default_cursor_land">"{{1,2,3},{2,1},{1,2,4,3},{2}}"</code></td>
<td class="default_cursor_land">[2, 1, 3, 4]</td>
</tr>
<tr>
<td class="default_cursor_land"><code class="default_cursor_land">"{{20,111},{111}}"</code></td>
<td class="default_cursor_land">[111, 20]</td>
</tr>
<tr>
<td class="default_cursor_land"><code class="default_cursor_land">"{{123}}"</code></td>
<td class="default_cursor_land">[123]</td>
</tr>
<tr>
<td class="default_cursor_land"><code class="default_cursor_land">"{{4,2,3},{3},{2,3,4,1},{2,3}}"</code></td>
<td class="default_cursor_land">[3, 2, 4, 1]</td>
</tr>
</tbody>
      </table>
<h5 class="default_cursor_land"><strong>입출력 예에 대한 설명</strong></h5>

<h5 class="default_cursor_land"><strong>입출력 예 #1</strong></h5>

<p class="default_cursor_land">문제 예시와 같습니다.</p>

<h5 class="default_cursor_land"><strong>입출력 예 #2</strong></h5>

<p>문제 예시와 같습니다.</p>

<h5><strong>입출력 예 #3</strong></h5>

<p>(111, 20)을 집합 기호를 이용해 표현하면 {{111}, {111,20}}이 되며, 이는 {{20,111},{111}}과 같습니다.</p>

<h5><strong>입출력 예 #4</strong></h5>

<p>(123)을 집합 기호를 이용해 표현하면 {{123}} 입니다.</p>

<h5><strong>입출력 예 #5</strong></h5>

<p>(3, 2, 4, 1)을 집합 기호를 이용해 표현하면 {{3},{3,2},{3,2,4},{3,2,4,1}}이 되며, 이는 {{4,2,3},{3},{2,3,4,1},{2,3}}과 같습니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges