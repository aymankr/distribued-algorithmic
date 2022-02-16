package TD1;

import TD1.TreeNodeV5;
import io.jbotsim.core.Topology;
import io.jbotsim.ui.JViewer;

public class App {
    public static void main(String[] args) {
        Topology tp = new Topology();
        tp.setDefaultNodeModel(TreeNodeV5.class);
        tp.setTimeUnit(500); // 1 ronde = 500ms
        new JViewer(tp);
        tp.start();
    }
}
