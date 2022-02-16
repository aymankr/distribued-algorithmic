package TD2;
import io.jbotsim.core.Topology;
import io.jbotsim.ui.JViewer;

public class App {
    public static void main(String[] args) {
        Topology tp = new Topology();
        tp.setDefaultNodeModel(PPNodeAlgo3.class);
        tp.setTimeUnit(100);
        new PPScheduler(tp);
        new JViewer(tp);
        tp.start();
    }
}