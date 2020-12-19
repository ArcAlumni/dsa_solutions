public class Main {

    public static void main(String[] args) {

        //traversal();
        //topologicalSort();
        shortestPath();

    }

    public static void shortestPath() {

        Graph graph = new Graph();

        for (int i = 1; i <= 7; i++) {
            graph.addVertex(i);
        }

        int[][] edges = new int[][] { { 1, 2, 4 }, { 1, 7, 6 }, { 2, 3, 1 }, { 2, 4, 2 }, { 2, 6, 5 }, { 3, 4, 9 },
                { 4, 5, 2 }, { 5, 6, 1 }, { 5, 7, 3 }, { 6, 7, 1 } };

        for (int[] edge : edges) {
            graph.addEdge(edge[0], edge[1], edge[2]);
            graph.addEdge(edge[1], edge[0], edge[2]);
        }

        System.out.println(graph.dijkstra(7));
    }

    public static void topologicalSort() {

        Graph graph = new Graph();

        for (int i = 0; i <= 5; i++) {
            graph.addVertex(i);
        }

        graph.addEdge(2, 3);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(3, 1);

        System.out.println(graph.topologicalSort());
    }

    public static void traversal() {

        Graph graph = new Graph();

        for (int i = 1; i <= 7; i++) {
            graph.addVertex(i);
        }

        int[][] edges = new int[][] { { 1, 2, 4 }, { 1, 7, 6 }, { 2, 3, 1 }, { 2, 4, 2 }, { 2, 6, 5 }, { 3, 4, 9 },
                { 4, 5, 2 }, { 5, 6, 1 }, { 5, 7, 3 }, { 6, 7, 1 } };

        for (int[] edge : edges) {
            graph.addEdge(edge[0], edge[1], edge[2]);
            graph.addEdge(edge[1], edge[0], edge[2]);
        }

        System.out.println(graph.dfs(1));
        System.out.println(graph.bfs(1));

    }

}