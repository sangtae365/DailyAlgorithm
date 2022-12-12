class Solution {
    static boolean visited[];
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[j] && computers[i][j] == 1){
                    dfs(i, j, n, computers);
                    answer++;
                }
            }
        }
        
        return answer;
    }
    public static void dfs(int x, int y, int n, int[][] computers){
        visited[x] = true;
        visited[y] = true;
        
        for(int i=0;i<n;i++){
            if(visited[i])continue;
            if(computers[y][i] == 1) dfs(y,i,n,computers);
        }
    }
    
}