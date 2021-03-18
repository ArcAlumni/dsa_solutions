class Prims {

    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        
        ArrayList<Vertex> graph = new ArrayList<>();
        
        Edge minEdge = new Edge(null, Integer.MAX_VALUE);
        int minVertex = -1;
        
        for(int i=0;i<V;i++){
            Vertex v = new Vertex(i);
            graph.add(v);
        }
        
        for(int i=0;i<V;i++){
            ArrayList<Edge> edges = graph.get(i).edges;
            for(ArrayList<Integer> edgeVal : adj.get(i)){
                Edge edge = new Edge(graph.get(edgeVal.get(0)), edgeVal.get(1));
                if(edge.cost < minEdge.cost){
                    minEdge = edge;
                    minVertex = i;
                }
                edges.add(edge);
            }
        }

        PriorityQueue<Edge> q = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);
        
        graph.get(minVertex).visited = true;
        
        for(Edge e : graph.get(minVertex).edges){
            q.add(e);
        }
        
        int cost = 0;
        
        while(!q.isEmpty()){
            
            Edge edge = q.poll();
            
            if(edge.to.visited){
               continue; 
            }
            
            for(Edge e : edge.to.edges){
                q.add(e);
            }
            
            cost += edge.cost;
            
            edge.to.visited = true;
        }
        
        return cost;
    }
    
    static class Vertex {
        int id;
        boolean visited;
        ArrayList<Edge> edges = new ArrayList<>();
        Vertex(int id){
            this.id = id;
        }
    }
    
    static class Edge {
        Vertex to;
        int cost;
        Edge(Vertex t, int c){
            to=t;
            cost=c;
        }
    }
    
}