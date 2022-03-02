package TD3;

import io.jbotsim.core.Color;
import io.jbotsim.core.Message;
import io.jbotsim.core.Node;

import java.util.HashMap;
import java.util.HashSet;

public class CircleNode extends Node {
    double angle;
    HashSet<Node> neighbours = new HashSet<>();
    HashMap<Node, HashSet> network = new HashMap<>();
    boolean endNetwork = false;

    public void onStart() {
        angle = (Math.random() > 0.5) ? 0.1 : -0.1;
    }
    public void onClock() {
        setDirection((getDirection()-angle)%(2.0*Math.PI));
        move(2);
        sendAll(new Message("", "BEACON"));
    }

    @Override
    public void onSelection() {
        setColor(Color.red);
        if (endNetwork) {
            System.out.println();
        }
    }

    @Override
    public void onMessage(Message message) {
        if (message.getFlag().equals("BEACON")){
            if (message.getSender() != null) {
                neighbours.add(message.getSender());
            }
            sendAll(new Message(neighbours, "NETWORK"));
        }
        else if (message.getFlag().equals("NETWORK")){
            network.put(message.getSender(), (HashSet)message.getContent());
        }
    }

    @Override
    public String toString() {
        return "neighbours : " + neighbours.size()
                + "\n network : " + network.size();
    }
}