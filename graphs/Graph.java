import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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

    public List<Integer> dfs(int startVertex) {
        List<Integer> li = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        dfs(startVertex, li, visited);
        return li;
    }

    public void dfs(int startVertex, List<Integer> li, Set<Integer> visited) {
        li.add(startVertex);
        visited.add(startVertex);
        for (Edge edge : vertices.get(startVertex)) {
            if (!visited.contains(edge.toVertex))
                dfs(edge.toVertex, li, visited);
        }
    }

    public List<Integer> bfs(int startVertex) {
        List<Integer> li = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(startVertex);
        visited.add(startVertex);
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

    public List<Integer> topologicalSort() {

        Map<Integer, Integer> incomingEdges = new HashMap<>();

        for (int vertex : vertices.keySet()) {
            incomingEdges.put(vertex, 0);
        }

        for (int vertex : vertices.keySet()) {
            for (Edge edge : vertices.get(vertex)) {
                incomingEdges.put(edge.toVertex, incomingEdges.get(edge.toVertex) + 1);
            }
        }

        Queue<Integer> sources = new LinkedList<>();

        for (int v : incomingEdges.keySet()) {
            if (incomingEdges.get(v) == 0) {
                sources.add(v);
            }
        }

        List<Integer> li = new ArrayList<>();

        while (!sources.isEmpty()) {
            int vertex = sources.poll();
            li.add(vertex);
            for (Edge edge : vertices.get(vertex)) {
                int inDegree = incomingEdges.get(edge.toVertex);
                if (inDegree == 1) {
                    sources.add(edge.toVertex);
                } else {
                    incomingEdges.put(edge.toVertex, incomingEdges.get(edge.toVertex) - 1);
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