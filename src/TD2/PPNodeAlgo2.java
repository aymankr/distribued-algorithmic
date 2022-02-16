package TD2;
import io.jbotsim.core.Color;
import io.jbotsim.core.Node;

public class PPNodeAlgo2 extends PPNode {
    Integer count = 1;

    @Override
    public void onStart() {
        setColor(Color.red);
    }
    @Override
    public void onSelection() {
    }
    @Override
    public void interactWith(Node responder) {
        if (this.getColor() == Color.red && responder.getColor() == Color.red) {
            responder.setColor(Color.blue);
            count += Integer.parseInt(responder.toString());
        }
    }

    @Override
    public String toString() {
        return count.toString();
    }
}