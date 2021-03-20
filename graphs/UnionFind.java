import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UnionFind {

	private int setCount;

	private Map<Integer, Integer> setSizeMap;

	private Map<Integer, Integer> parentMap;

	UnionFind(Set<Integer> vertices) {
		parentMap = new HashMap<>();
		for (int vertex : vertices) {
			parentMap.put(vertex, vertex);
		}
		setSizeMap = new HashMap<>();
		for (int vertex : vertices) {
			setSizeMap.put(vertex, 1);
		}
		setCount = vertices.size();
	}

	int find(int vertex) {
		int root = vertex;
		while (parentMap.get(root) != root) {
			root = parentMap.get(root);
		}
		while (vertex != root) {
			int parent = parentMap.get(vertex);
			parentMap.put(vertex, root);
			vertex = parent;
		}
		return root;
	}

	void unify(int vertex1, int vertex2) {
		int vertex1Root = find(vertex1);
		int vertex2Root = find(vertex2);
		if (vertex1Root == vertex2Root) {
			return;
		}
		if (setSizeMap.get(vertex1Root) > setSizeMap.get(vertex2Root)) {
			parentMap.put(vertex2Root, vertex1Root);
			setSizeMap.put(vertex1Root, setSizeMap.get(vertex1Root) + setSizeMap.get(vertex2Root));
		} else {
			parentMap.put(vertex1Root, vertex2Root);
			setSizeMap.put(vertex2Root, setSizeMap.get(vertex2Root) + setSizeMap.get(vertex1Root));
		}
		setCount--;
	}

	boolean isConnected(int v1, int v2) {
		return find(v1) == find(v2);
	}

	int getDisjointSetCount() {
		return setCount;
	}

}
