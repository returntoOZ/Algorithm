import java.io.*;
import java.util.*;

public class Solution {
    static final int[] dx = {0,0,-1,1,1,1,-1,-1};
    static final int[] dy = {1,-1,0,0,1,-1,1,-1};

    static class Node {
        int x, y;
        Node(int x, int y){ this.x = x; this.y = y; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            char[][] map = new char[N][N];
            for (int i = 0; i < N; i++) {
                String s = br.readLine().trim();
                map[i] = s.toCharArray();
            }
            
            int[][] cnt = new int[N][N];
            for (int i = 0; i < N; i++) Arrays.fill(cnt[i], 0);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '*') {
                        cnt[i][j] = -1;
                        continue;
                    }
                    int mines = 0;
                    for (int d = 0; d < 8; d++) {
                        int ni = i + dx[d], nj = j + dy[d];
                        if (ni < 0 || ni >= N || nj < 0 || nj >= N) continue;
                        if (map[ni][nj] == '*') mines++;
                    }
                    cnt[i][j] = mines;
                }
            }

            boolean[][] vis = new boolean[N][N];
            int ans = 0;

            // 1) cnt == 0 인 셀들에 대해 BFS로 연쇄 개방 (각 컴포넌트에 대해 클릭 1번)
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (cnt[i][j] == 0 && !vis[i][j]) {
                        // BFS
                        Queue<Node> q = new ArrayDeque<>();
                        vis[i][j] = true;
                        q.offer(new Node(i, j));

                        while (!q.isEmpty()) {
                            Node cur = q.poll();
                            int x = cur.x, y = cur.y;
                            for (int d = 0; d < 8; d++) {
                                int nx = x + dx[d], ny = y + dy[d];
                                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                                if (cnt[nx][ny] == -1) continue; // 지뢰
                                if (vis[nx][ny]) continue;
                                vis[nx][ny] = true; // 이 셀은 드러남
                                if (cnt[nx][ny] == 0) {
                                    q.offer(new Node(nx, ny)); // 0이면 더 확장
                                }
                            }
                        }
                        ans++; // 이 0-컴포넌트를 열기 위한 1번 클릭
                    }
                }
            }

            // 2) 아직 방문되지 않은 비지뢰 셀들: 각각 1번씩 클릭 필요
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (cnt[i][j] != -1 && !vis[i][j]) ans++;
                }
            }

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }

        System.out.print(sb.toString());
    }
}