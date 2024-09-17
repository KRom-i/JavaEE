package homeWork7;


import java.util.LinkedList;

abstract class FirstPath {
    private boolean[] marked;
    private int[] edgeTo;
    private int source;

    public FirstPath(Graph g, int source) {
        this.source = source;
        edgeTo = new int[g.getVertexCount()];
        marked = new boolean[g.getVertexCount()];
        fs(g, source);
    }

    abstract void fs(Graph g, int source);

    public boolean[] getMarked () {
        return marked;
    }

    public int[] getEdgeTo () {
        return edgeTo;
    }

    public boolean hasPathTo(int dist) {
        return marked[dist];
    }

    public LinkedList<Integer> pathTo(int dist) {
        if (!hasPathTo(dist)) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = dist;
        while (vertex != source) {
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }
}
