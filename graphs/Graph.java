import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Graph {

	private int noOfvertices;

	public int getNodeCount() {
		return noOfvertices;
	}

	Map<Integer, Vertex> vertices = new HashMap<>();

	public void addVertex(int id) {
		vertices.put(id, new Vertex(id));
		noOfvertices++;
	}

	public void addEdge(int fromVertex, int toVertex) {
		addEdge(fromVertex, toVertex, 0);
	}

	public void addEdge(int fromVertex, int toVertex, int weight) {
		Vertex from = vertices.get(fromVertex);
		Vertex to = vertices.get(toVertex);
		from.addEdge(to, weight);
	}

	public List<Integer> dfs(int startVertex) {
		List<Integer> li = new ArrayList<>();
		Set<Integer> visited = new HashSet<>();
		dfsHelper(startVertex, li, visited);
		return li;
	}

	private void dfsHelper(int startVertex, List<Integer> li, Set<Integer> visited) {
		li.add(startVertex);
		visited.add(startVertex);
		for (Edge edge : vertices.get(startVertex).edges) {
			if (!visited.contains(edge.to.id))
				dfsHelper(edge.to.id, li, visited);
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
			for (Edge edge : vertices.get(vtx).edges) {
				if (!visited.contains(edge.to.id)) {
					q.add(edge.to.id);
					visited.add(edge.to.id);
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
			for (Edge edge : vertices.get(vertex).edges) {
				incomingEdges.put(edge.to.id, incomingEdges.get(edge.to.id) + 1);
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
			for (Edge edge : vertices.get(vertex).edges) {
				int inDegree = incomingEdges.get(edge.to.id);
				if (inDegree == 1) {
					sources.add(edge.to.id);
				} else {
					incomingEdges.put(edge.to.id, incomingEdges.get(edge.to.id) - 1);
				}
			}
		}

		return li;
	}

	public Map<Integer, List<Integer>> dijkstra(int srcVertex) {

		Vertex sourceVertex = vertices.get(srcVertex);

		sourceVertex.distance = 0;
		sourceVertex.parent = null;

		PriorityQueue<Vertex> minHeap = new PriorityQueue<>((v1, v2) -> v1.distance - v2.distance);
		minHeap.add(sourceVertex);

		sourceVertex.visited = true;

		while (!minHeap.isEmpty()) {
			Vertex currVertex = minHeap.poll();
			for (Edge edge : currVertex.edges) {
				if (!edge.to.visited) {
					int newDistance = currVertex.distance + edge.weight;
					if (newDistance < edge.to.distance) {
						minHeap.remove(edge.to);
						edge.to.distance = newDistance;
						edge.to.parent = currVertex;
						minHeap.add(edge.to);
					}
				}
			}
			currVertex.visited = true;
		}

		HashMap<Integer, List<Integer>> res = new HashMap<>();

		for (Vertex v : vertices.values()) {
			List<Integer> path = new ArrayList<>();
			for (Vertex vertex = v; vertex != null; vertex = vertex.parent) {
				path.add(vertex.id);
			}
			Collections.reverse(path);
			res.put(v.id, path);
		}

		return res;
	}

	public int prims(int srcVertex) {

		int cost = 0;
		Vertex source = vertices.get(srcVertex);

		PriorityQueue<Edge> minHeap = new PriorityQueue<>((e1, e2) -> e1.weight - e2.weight);

		for (Edge edge : source.edges) {
			minHeap.add(edge);
		}

		source.visited = true;

		while (!minHeap.isEmpty()) {

			Edge minWeightedEdge = minHeap.poll();

			if (minWeightedEdge.to.visited) {
				continue;
			}

			minWeightedEdge.to.visited = true;
			cost += minWeightedEdge.weight;

			for (Edge edge : minWeightedEdge.to.edges) {
				minHeap.add(edge);
			}
		}

		return cost;
	}

	public int countDisjointSets() {

		UnionFind unionFind = new UnionFind(vertices.keySet());

		for (int v : vertices.keySet()) {
			for (Edge edge : vertices.get(v).edges) {
				unionFind.unify(v, edge.to.id);
			}
		}

		return unionFind.getDisjointSetCount();
	}

}

class Vertex {

	int id;
	List<Edge> edges = new LinkedList<>();
	int distance = Integer.MAX_VALUE;
	Vertex parent;
	boolean visited;

	Vertex(int id) {
		this.id = id;
	}

	public void addEdge(Vertex to, int weight) {
		edges.add(new Edge(this, to, weight));
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public String toString() {
		return String.valueOf(id);
	}

}

class Edge {

	Vertex from;
	Vertex to;
	int weight;
	boolean visited;

	Edge(Vertex from, Vertex to) {
		this.from = from;
		this.to = to;
	}

	Edge(Vertex from, Vertex to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return from.id + "-->" + to.id + "(" + weight + ")";
	}

}