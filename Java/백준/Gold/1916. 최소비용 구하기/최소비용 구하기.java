import java.io.*;
import java.util.*;

public class Main {
	static int N, M, start, end;
	static int[] dist; // 1번부터 N번
	static List<List<node>> graph;
	
	static class node{
		int a;
		int w;
		
		node(int a, int w){
			this.a = a;
			this.w = w;
		}
	}
	
	static void dijkstra(int st) {
		PriorityQueue<node> pq = new PriorityQueue<>(
				(o1, o2) -> o1.w - o2.w
		);
		
		pq.add(new node(st, 0));
		dist[st] = 0;
		
		while(!pq.isEmpty()) {
			node cur = pq.poll();
			
			if(cur.a == end) return;
			
			for(node nxt : graph.get(cur.a)) {
				if(dist[nxt.a] <= dist[cur.a] + nxt.w) continue;
				dist[nxt.a] = dist[cur.a] + nxt.w;
				pq.add(new node(nxt.a, dist[nxt.a]));
			}
		}
				
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		graph = new ArrayList<>(N+1);
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		StringTokenizer st;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new node(b,w));
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		dijkstra(start);
		System.out.print(dist[end]);
	}
}
