import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<Integer> list[] = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0;i<edge.length;i++){
            list[edge[i][0]].add(edge[i][1]);
            list[edge[i][1]].add(edge[i][0]);
        }
        
        // for(int i=1;i<=n;i++){
        //     Collections.sort(list[i]);
        // }
        
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[n+1];
        queue.add(1);
        visited[1] = true;
        
        while(true){
            Queue<Integer> temp = new LinkedList<>();
            
            while(!queue.isEmpty()){
                int cur = queue.poll();
                for(int next : list[cur]){
                    if(visited[next])continue;
                    temp.add(next);
                    visited[next] = true;
                }
            }
            if(temp.isEmpty())break;
            queue.addAll(temp);
            answer = temp.size();
        }
        
        return answer;
    }
}