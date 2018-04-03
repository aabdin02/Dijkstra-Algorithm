import java.util.LinkedList;

public class Main{
	
	public static void main(String[]args)
	{
		GraphNode a = new GraphNode('A');
		GraphNode b = new GraphNode('B');
		GraphNode c = new GraphNode('C');
		GraphNode d = new GraphNode('D');

		a.addEdge(b, 5.0);
		a.addEdge(c, 1.0);
		b.addEdge(a, 5.0);
		b.addEdge(d, 2.0);
		b.addEdge(c, 1.0);
		c.addEdge(a, 1.0);
		c.addEdge(b, 1.0);
		c.addEdge(d, 1.0);
		d.addEdge(b, 2.0);
		d.addEdge(c, 1.0);
		a.printDepthFirst(); // For testing the constructions of the graph
		a.resetVisited();//Make sure the graph elements have been set to non-visited
		Dijkstra path = new Dijkstra();
		printPath(path.shortestPath(d,a));

	}

	public static void printPath(LinkedList<GraphNode> nodes){
		while(!nodes.isEmpty()){
			GraphNode node = nodes.pop();
			System.out.println(node.value);
			System.out.println(node.minimumDistance);
		}
	}
}