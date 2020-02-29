package Lec30_Feb23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
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
		String color;

		public pair(int d, String p) {
			data = d;
			psf = p;
		}

		public pair(int d, String p, String c) {
			data = d;
			psf = p;
			color = c;
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

	public boolean DFS(int u, int v) {

		LinkedList<pair> stack = new LinkedList<>();

		pair np = new pair(u, "");
		stack.addFirst(np);

		HashMap<Integer, Boolean> visited = new HashMap<>();

		while (!stack.isEmpty()) {

			pair rp = stack.removeFirst();

			if (visited.containsKey(rp.data)) {

				// isCyclic
				continue;
			}

			if (rp.data == v) {
				System.out.println(rp.psf + v);
				return true;
			}

			visited.put(rp.data, true);

			for (int nbr = 1; nbr <= numV; nbr++) {

				if (containsEdge(rp.data, nbr) && !visited.containsKey(nbr)) {
					pair nbrPair = new pair(nbr, rp.psf + rp.data);
					stack.addFirst(nbrPair);
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

	public void DFT() {

		HashMap<Integer, Boolean> visited = new HashMap<>();

		for (int u = 1; u <= numV; u++) {

			if (visited.containsKey(u)) {
				continue;
			}

			LinkedList<pair> stack = new LinkedList<>();
			pair np = new pair(u, "");
			stack.addFirst(np);

			while (!stack.isEmpty()) {

				pair rp = stack.removeFirst();

				if (visited.containsKey(rp.data)) {

					// isCyclic
					continue;
				}

				System.out.println(rp.data + " -> " + rp.psf + rp.data + ", ");

				visited.put(rp.data, true);

				for (int nbr = 1; nbr <= numV; nbr++) {

					if (containsEdge(rp.data, nbr) && !visited.containsKey(nbr)) {
						pair nbrPair = new pair(nbr, rp.psf + rp.data);
						stack.addFirst(nbrPair);
					}
				}

			}

		}
	}

	public boolean isCyclic() {

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

					return true;
				}

				visited.put(rp.data, true);

				for (int nbr = 1; nbr <= numV; nbr++) {

					if (containsEdge(rp.data, nbr) && !visited.containsKey(nbr)) {
						pair nbrPair = new pair(nbr, rp.psf + rp.data);
						queue.addLast(nbrPair);
					}
				}

			}

		}

		return false;
	}

	public boolean isConnected() {

		HashMap<Integer, Boolean> visited = new HashMap<>();

		int cc = 0;
		for (int u = 1; u <= numV; u++) {

			if (visited.containsKey(u)) {
				continue;
			}

			cc++;

			LinkedList<pair> queue = new LinkedList<>();
			pair np = new pair(u, "");
			queue.addLast(np);

			while (!queue.isEmpty()) {

				pair rp = queue.removeFirst();

				if (visited.containsKey(rp.data)) {

					// isCyclic
					continue;
				}

				visited.put(rp.data, true);

				for (int nbr = 1; nbr <= numV; nbr++) {

					if (containsEdge(rp.data, nbr) && !visited.containsKey(nbr)) {
						pair nbrPair = new pair(nbr, rp.psf + rp.data);
						queue.addLast(nbrPair);
					}
				}

			}

		}

		return cc == 1;
	}

	public boolean isTree() {

		return isConnected() && !isCyclic();
	}

	public ArrayList<ArrayList<Integer>> getConnectedComp() {

		HashMap<Integer, Boolean> visited = new HashMap<>();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

		for (int u = 1; u <= numV; u++) {

			if (visited.containsKey(u)) {
				continue;
			}

			ArrayList<Integer> eachLevel = new ArrayList<>();

			LinkedList<pair> queue = new LinkedList<>();
			pair np = new pair(u, "");
			queue.addLast(np);

			while (!queue.isEmpty()) {

				pair rp = queue.removeFirst();

				if (visited.containsKey(rp.data)) {

					// isCyclic
					continue;
				}

				eachLevel.add(rp.data);

				visited.put(rp.data, true);

				for (int nbr = 1; nbr <= numV; nbr++) {

					if (containsEdge(rp.data, nbr) && !visited.containsKey(nbr)) {
						pair nbrPair = new pair(nbr, rp.psf + rp.data);
						queue.addLast(nbrPair);
					}
				}

			}

			ans.add(eachLevel);

		}

		return ans;
	}

	public boolean isBipertite() {

		HashMap<Integer, String> visited = new HashMap<>();

		for (int u = 1; u <= numV; u++) {

			if (visited.containsKey(u)) {
				continue;
			}

			LinkedList<pair> queue = new LinkedList<>();
			pair np = new pair(u, "", "R");
			queue.addLast(np);

			while (!queue.isEmpty()) {

				pair rp = queue.removeFirst();

				if (visited.containsKey(rp.data)) {

					String oc = visited.get(rp.data);
					String nc = rp.color;

					if (!oc.equals(nc)) {
						return false;
					}

					continue;
				}

				visited.put(rp.data, rp.color);

				for (int nbr = 1; nbr <= numV; nbr++) {

					if (containsEdge(rp.data, nbr) && !visited.containsKey(nbr)) {

						String c = rp.color.equals("R") ? "G" : "R";
						pair nbrPair = new pair(nbr, rp.psf + rp.data, c);
						queue.addLast(nbrPair);
					}
				}

			}

		}

		return true;
	}

	class PrimsPair implements Comparable<PrimsPair> {

		int v;
		int c;

		PrimsPair(int v, int c) {
			this.v = v;
			this.c = c;
		}

		@Override
		public int compareTo(PrimsPair o) {
			return this.c - o.c;
		}
	}

	class resultPair {

		int parent;
		int wt;

		public resultPair() {
			// TODO Auto-generated constructor stub
		}

		resultPair(int p, int w) {
			parent = p;
			wt = w;
		}
	}

	public void MST() {

		boolean[] isMst = new boolean[numV + 1];
		int[] cost = new int[numV + 1];

		resultPair[] resultSet = new resultPair[numV + 1];

		for (int i = 1; i <= numV; i++) {
			cost[i] = Integer.MAX_VALUE;
			resultSet[i] = new resultPair();
		}

		PriorityQueue<PrimsPair> pq = new PriorityQueue<>();

		// cost
		cost[1] = 0;

		// PrimsPair
		PrimsPair np = new PrimsPair(1, 0);

		// ResultPair
		resultSet[1].parent = -1;
		resultSet[1].wt = 0;

		pq.add(np);

		while (!pq.isEmpty()) {

			PrimsPair rp = pq.remove();

			if (isMst[rp.v]) {
				continue;
			}

			isMst[rp.v] = true;

			for (int nbr = 1; nbr <= numV; nbr++) {

				if (containsEdge(nbr, rp.v) && !isMst[nbr]) {

					int oc = cost[nbr];
					int nc = matrix[rp.v][nbr];

					if (nc < oc) {

						cost[nbr] = nc;
						PrimsPair temp = new PrimsPair(nbr, nc);
						pq.add(temp);

						resultSet[nbr].parent = rp.v;
						resultSet[nbr].wt = nc;

					}

				}

			}

		}

		printMST(resultSet);

	}

	public void printMST(resultPair[] set) {

		for (int i = 1; i < set.length; i++) {

			System.out.println(set[i].parent + " - " + i + " : " + set[i].wt);

		}

	}

	public void Dijkstra() {

		boolean[] isMst = new boolean[numV + 1];
		int[] cost = new int[numV + 1];

		resultPair[] resultSet = new resultPair[numV + 1];

		for (int i = 1; i <= numV; i++) {
			cost[i] = Integer.MAX_VALUE;
			resultSet[i] = new resultPair();
		}

		PriorityQueue<PrimsPair> pq = new PriorityQueue<>();

		// cost
		cost[1] = 0;

		// PrimsPair
		PrimsPair np = new PrimsPair(1, 0);

		// ResultPair
		resultSet[1].parent = -1;
		resultSet[1].wt = 0;

		pq.add(np);

		while (!pq.isEmpty()) {

			PrimsPair rp = pq.remove();

			if (isMst[rp.v]) {
				continue;
			}

			isMst[rp.v] = true;

			for (int nbr = 1; nbr <= numV; nbr++) {

				if (containsEdge(nbr, rp.v) && !isMst[nbr]) {

					int oc = cost[nbr];
					int nc = matrix[rp.v][nbr] + cost[rp.v];

					if (nc < oc) {

						cost[nbr] = nc;
						PrimsPair temp = new PrimsPair(nbr, nc);
						pq.add(temp);

						resultSet[nbr].parent = rp.v;
						resultSet[nbr].wt = nc;

					}

				}

			}

		}

		printMST(resultSet);

	}

}
