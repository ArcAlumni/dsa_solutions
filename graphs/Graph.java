package ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Graph {

    HashMap<Integer, List<Edge>> vertices = new HashMap<>();

    public void addVertex(int val) {
        vertices.put(val, new LinkedList<>());
    }

    public void addEdge(int fromVertex, int toVertex) {
        addEdge(fromVertex, toVertex, 0);
    }

    public void addEdge(int fromVertex, int toVertex, int weight) {
        Edge edge = new Edge(toVertex);
        edge.setWeight(weight);
        vertices.get(fromVertex).add(edge);
    }

    public List<Integer> dfs(int root) {
        List<Integer> li = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        dfs(root, li, visited);
        return li;
    }

    public void dfs(int root, List<Integer> li, Set<Integer> visited) {
        li.add(root);
        visited.add(root);
        for (Edge edge : vertices.get(root)) {
            if (!visited.contains(edge.toVertex))
                dfs(edge.toVertex, li, visited);
        }
    }

    public List<Integer> bfs(int root) {
        List<Integer> li = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        visited.add(root);
        while (!q.isEmpty()) {
            int vtx = q.poll();
            li.add(vtx);
            for (Edge edge : vertices.get(vtx)) {
                if (!visited.contains(edge.toVertex)) {
                    q.add(edge.toVertex);
                    visited.add(edge.toVertex);
                }
            }
        }
        return li;
    }
}

class Edge {

    int toVertex;
    int weight;

    Edge(int toVertex) {
        this.toVertex = toVertex;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}