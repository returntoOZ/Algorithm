# [level 1] 완주하지 못한 선수 - 42576 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42576?language=java) 

### 성능 요약

메모리: 97.6 MB, 시간: 73.84 ms

### 구분

코딩테스트 연습 > 해시

### 채점결과

정확성: 58.3<br/>효율성: 41.7<br/>합계: 100.0 / 100.0

### 제출 일자

2025년 09월 27일 10:35:06

### 문제 설명

<p class="default_cursor_land">수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.</p>

<p class="default_cursor_land">마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.</p>

<h5 class="default_cursor_land">제한사항</h5>

<ul class="default_cursor_land">
<li class="default_cursor_land">마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.</li>
<li class="default_cursor_land">completion의 길이는 participant의 길이보다 1 작습니다.</li>
<li class="default_cursor_land">참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.</li>
<li class="default_cursor_land">참가자 중에는 동명이인이 있을 수 있습니다.</li>
</ul>

<h5 class="default_cursor_land">입출력 예</h5>
<table class="table default_cursor_land">
        <thead><tr>
<th class="default_cursor_land">participant</th>
<th class="default_cursor_land">completion</th>
<th class="default_cursor_land">return</th>
</tr>
</thead>
        <tbody><tr>
<td class="default_cursor_land">["leo", "kiki", "eden"]</td>
<td class="default_cursor_land">["eden", "kiki"]</td>
<td class="default_cursor_land">"leo"</td>
</tr>
<tr>
<td>["marina", "josipa", "nikola", "vinko", "filipa"]</td>
<td class="default_cursor_land">["josipa", "filipa", "marina", "nikola"]</td>
<td class="default_cursor_land">"vinko"</td>
</tr>
<tr>
<td class="default_cursor_land">["mislav", "stanko", "mislav", "ana"]</td>
<td class="default_cursor_land">["stanko", "ana", "mislav"]</td>
<td>"mislav"</td>
</tr>
</tbody>
      </table>
<h5 class="default_cursor_land">입출력 예 설명</h5>

<p class="default_cursor_land">예제 #1<br>
"leo"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.</p>

<p class="default_cursor_land">예제 #2<br>
"vinko"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.</p>

<p class="default_cursor_land">예제 #3<br>
"mislav"는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.</p>

<hr>

<p>※ 공지 - 2023년 01월 25일 테스트케이스가 추가되었습니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges