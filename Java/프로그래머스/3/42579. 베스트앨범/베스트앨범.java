import java.util.*;

class Solution {
    class song implements Comparable<song>{
        int id;
        int cnt;
        
        song(int id, int cnt){
            this.id = id;
            this.cnt = cnt;
        }
        
        @Override
        public int compareTo(song sng){
            if(this.cnt != sng.cnt){
                return sng.cnt - this.cnt;
            }
            return this.id - sng.id;
        }
    }
    
    class sing implements Comparable<sing>{
        String gen;
        int cnt;
        
        sing(String gen, int cnt){
            this.gen = gen;
            this.cnt = cnt;
        }
        
        @Override
        public int compareTo(sing sng){
            return sng.cnt - this.cnt;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        int len = genres.length;
        
        HashMap<String, Integer> genre = new HashMap<>();
        HashMap<String, ArrayList<song>> songlist = new HashMap<>();
        
        for(int i=0; i<len; i++){
            String gen = genres[i];
            int ply = plays[i];
            
            genre.put(gen, genre.getOrDefault(gen, 0) + ply);
            
            if(!songlist.containsKey(gen)){
                songlist.put(gen, new ArrayList<>());
            }
            songlist.get(gen).add(new song(i, ply));
        }
        
        int idx = 0;
        sing[] arr = new sing[genre.size()];
        for(Map.Entry<String, Integer> entry: genre.entrySet()){
            String gen = entry.getKey();
            int cnt = entry.getValue();
            
            arr[idx++] = new sing(gen, cnt);
        }
        
        // 1. 장르 별 총합을 구하기 ex) 클래식 1500, 팝 3100
        Arrays.sort(arr);
        // 2. 장르 내에서 정렬하기 ex) 클래식 3: 800, 0: 500, 2: 150 
        for(ArrayList<song> list : songlist.values()){
            Collections.sort(list);
        }

        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            ArrayList<song> list = songlist.get(arr[i].gen);
            
            for(int j=0; j<list.size(); j++){
                if(j==2) break;
                answer.add(list.get(j).id);
            }
        }
        
        int[] ans = new int[answer.size()];
        for(int i=0; i<ans.length; i++){
            ans[i] = answer.get(i);
        }
        
        return ans;
    }
}