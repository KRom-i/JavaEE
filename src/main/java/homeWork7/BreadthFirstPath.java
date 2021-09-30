package homeWork7;

import java.util.LinkedList;

public class BreadthFirstPath extends FirstPath{

    public BreadthFirstPath (Graph g, int source) {
        super (g, source);
    }

    @Override
    void fs (Graph g, int source) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(source);
        super.getMarked ()[source] = true;

        while (!queue.isEmpty()) {
            int vertex = queue.removeFirst();
            for (int w : g.getAdjList(vertex)) {
                if (!super.getMarked ()[w]) {
                    super.getMarked ()[w] = true;
                    super.getEdgeTo ()[w] = vertex;
                    queue.addLast(w);
                }
            }
        }
    }
}
