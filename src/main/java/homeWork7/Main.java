package homeWork7;

public class Main {

    public static void main (String[] args) {

        Graph graph = new Graph (10);

        graph.addEdge(1, 2);
        graph.addEdge(0, 4);
        graph.addEdge(1, 4);
        graph.addEdge(1, 3);
        graph.addEdge(1, 0);
        graph.addEdge(2, 0);
        graph.addEdge(5, 7);
        graph.addEdge(8, 4);
        graph.addEdge(9, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 2);
        graph.addEdge(0, 8);
        graph.addEdge(8, 2);
        graph.addEdge (0,9);
        graph.addEdge (9,8);

        System.out.println(graph.getVertexCount());
        System.out.println(graph.getEdgeCount());
        System.out.println(graph.getAdjList(0));

        BreadthFirstPath bfp = new BreadthFirstPath(graph, 0);
        System.out.println(bfp.hasPathTo(2));
        System.out.println(bfp.pathTo(2));


    }
}
