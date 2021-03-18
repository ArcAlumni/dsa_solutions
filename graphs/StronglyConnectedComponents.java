class StronglyConnectedComponents
{
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> g) {
    
        boolean[] visited = new boolean[V];    
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<V;i++){
            if(!visited[i])
                dfsFillStack(g, i, visited, stack);
        }
        
        ArrayList<ArrayList<Integer>> rg = reverseEdges(g);
        
        for(int i=0;i<V;i++){
            visited[i] = false;
        }
        
        int c = 0;
        
        while(!stack.isEmpty()){
            int v = stack.pop();
            if(!visited[v]){
                c++;
                dfs(rg, v, visited);
            }            
        }
        
        return c;
    }
    
    ArrayList<ArrayList<Integer>> reverseEdges(ArrayList<ArrayList<Integer>> g){
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        for(int i=0;i<g.size();i++){
            res.add(new ArrayList<>());
        }
        
        int v = 0;
        for(ArrayList<Integer> edges : g){
            for(int edge : edges){
                res.get(edge).add(v);
            }
            v++;
        }
        
        return res;
    }
    
    void dfs(ArrayList<ArrayList<Integer>> g, int v, boolean[] visited){
        
        visited[v] = true;
        
        for(int e : g.get(v)){
            if(!visited[e]){
                dfs(g, e, visited);
            }
        }
        
    }
    
    void dfsFillStack(ArrayList<ArrayList<Integer>> g, int v, boolean[] visited, Stack<Integer> stack){
        
        visited[v] = true;
        
        for(int e : g.get(v)){
            if(!visited[e]){
                dfsFillStack(g, e, visited, stack);
            }
        }
        
        stack.push(v);
    }
    
}