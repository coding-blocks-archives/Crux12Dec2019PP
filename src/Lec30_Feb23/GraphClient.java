package Lec30_Feb23;

public class GraphClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph gp = new Graph(7);
		gp.addEdge(1, 2, 3);
		gp.addEdge(1, 4, 2);
		gp.addEdge(2, 3, 4);
		gp.addEdge(2, 5, 5);
		gp.addEdge(3, 4, 1);
		gp.addEdge(5, 6, 6);
		gp.addEdge(5, 7, 1);
		gp.addEdge(6, 7, 2);

		System.out.println(gp);

		System.out.println(gp.numEdges());
		System.out.println(gp.removeEdge(2, 5));
		System.out.println(gp.removeEdge(5, 6));
		System.out.println(gp.removeEdge(7, 6));

		System.out.println(gp);

		System.out.println(gp.hasPath(1, 7));
		System.out.println("-------------");

		gp.hasAllPath(1, 7);

		System.out.println("-------------");

		System.out.println(gp.BFS(1, 7));

		gp.BFT();

	}

}
