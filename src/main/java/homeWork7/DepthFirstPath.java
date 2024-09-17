package homeWork7;


public class DepthFirstPath extends FirstPath{

    public DepthFirstPath (Graph g, int source) {
        super (g, source);
    }

    @Override
    void fs (Graph g, int source) {
        super.getMarked ()[source] = true;
        for (int w : g.getAdjList(source)) {
            if (!super.getMarked ()[w]) {
                super.getEdgeTo ()[w] = source;
                fs(g, w);
            }
        }
    }
}
