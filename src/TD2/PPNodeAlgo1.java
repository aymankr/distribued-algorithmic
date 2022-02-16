package TD2;
import io.jbotsim.core.Color;
import io.jbotsim.core.Node;

public class PPNodeAlgo1 extends PPNode {
    Integer count = 1;

    @Override
    public void onStart() {
        setColor(Color.blue);
    }
    @Override
    public void onSelection() {
        setColor(Color.red);
    }
    @Override
    public void interactWith(Node responder) {
        if (this.getColor() == Color.red && responder.getColor() == Color.blue) {
            responder.setColor(Color.GREEN);
            count++;
        }
    }

    @Override
    public String toString() {
        return count.toString();
    }
}