package Lec30_Feb23;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

	private int[][] matrix;
	private int numV;

	public Graph() {
		this(5);
	}

	public Graph(int vertices) {

		numV = vertices;
		matrix = new int[numV + 1][numV + 1];
	}

	public void addEdge(int u, int v, int wt) {

		matrix[u][v] = wt;
		matrix[v][u] = wt;

	}

	@Override
	public String toString() {

		String str = "";
		for (int u = 1; u <= numV; u++) {

			str += (u + "->");
			for (int v = 1; v <= numV; v++) {

				if (matrix[u][v] != 0) {
					str += (v + "{" + matrix[u][v] + "}, ");
				}
			}
			str += "\n";
		}

		return str;
	}

	public int numEdges() {

		int edges = 0;

		for (int u = 1; u <= numV; u++) {
			for (int v = 1; v <= numV; v++) {

				if (matrix[u][v] != 0) {
					edges++;
				}
			}

		}
		return edges / 2;

	}

	public boolean containsEdge(int u, int v) {

		return matrix[u][v] != 0;
	}

	public int removeEdge(int u, int v) {

		int val = matrix[u][v];
		matrix[u][v] = 0;
		matrix[v][u] = 0;

		return val;
	}

	public boolean hasPath(int u, int v) {

		return hasPath(u, v, new HashMap<>(), "");
	}

	private boolean hasPath(int u, int v, HashMap<Integer, Boolean> visited, String asf) {

		if (containsEdge(u, v)) {
			System.out.println(asf + u + v);
			return true;
		}

		visited.put(u, true);

		for (int nbr = 1; nbr <= numV; nbr++) {

			if (containsEdge(u, nbr) && !visited.containsKey(nbr)) {

				boolean ans = hasPath(nbr, v, visited, asf + u);
				if (ans) {
					return true;
				}
			}

		}

		return false;

	}

	public void hasAllPath(int u, int v) {
		hasAllPath(u, v, new HashMap<>(), "");
	}

	private void hasAllPath(int u, int v, HashMap<Integer, Boolean> visited, String asf) {

		if (u == v) {
			System.out.println(asf + v);
			return;
		}

		visited.put(u, true);

		for (int nbr = 1; nbr <= numV; nbr++) {

			if (containsEdge(u, nbr) && !visited.containsKey(nbr)) {

				hasAllPath(nbr, v, visited, asf + u);

			}

		}

		visited.remove(u);

	}

	class pair {
		int data;
		String psf;

		public pair(int d, String p) {
			data = d;
			psf = p;
		}
	}

	public boolean BFS(int u, int v) {

		LinkedList<pair> queue = new LinkedList<>();

		pair np = new pair(u, "");
		queue.addLast(np);

		HashMap<Integer, Boolean> visited = new HashMap<>();

		while (!queue.isEmpty()) {

			pair rp = queue.removeFirst();

			if (visited.containsKey(rp.data)) {

				// isCyclic
				continue;
			}

			if (rp.data == v) {
				System.out.println(rp.psf + v);
				return true;
			}

			System.out.println(rp.data + "->" + rp.psf + rp.data);

			visited.put(rp.data, true);

			for (int nbr = 1; nbr <= numV; nbr++) {

				if (containsEdge(rp.data, nbr) && !visited.containsKey(nbr)) {
					pair nbrPair = new pair(nbr, rp.psf + rp.data);
					queue.addLast(nbrPair);
				}
			}

		}

		return false;

	}

	public void BFT() {

		HashMap<Integer, Boolean> visited = new HashMap<>();

		for (int u = 1; u <= numV; u++) {

			if (visited.containsKey(u)) {
				continue;
			}

			LinkedList<pair> queue = new LinkedList<>();
			pair np = new pair(u, "");
			queue.addLast(np);

			while (!queue.isEmpty()) {

				pair rp = queue.removeFirst();

				if (visited.containsKey(rp.data)) {

					// isCyclic
					continue;
				}

				System.out.println(rp.data + " -> " + rp.psf + rp.data + ", ");

				visited.put(rp.data, true);

				for (int nbr = 1; nbr <= numV; nbr++) {

					if (containsEdge(rp.data, nbr) && !visited.containsKey(nbr)) {
						pair nbrPair = new pair(nbr, rp.psf + rp.data);
						queue.addLast(nbrPair);
					}
				}

			}

		}
	}

}
