package TD1;

import io.jbotsim.core.Color;
import io.jbotsim.core.Message;
import io.jbotsim.core.Node;

import java.util.ArrayList;

public class TreeNodeV3 extends Node{
    private Node parent;
    private ArrayList<Node> children;
    private Integer time;

    @Override
    public void onStart() { // Initialisation par défaut
        setColor(Color.green); // Non informé
        parent = null;
        children = new ArrayList<>();
        time = null;
    }

    @Override
    public void onSelection() { // Noeud sélectionné
        setColor(Color.red); // Informé
        parent = this;
        sendAll(new Message("", "TREE"));
        time = getTime();
    }

    @Override
    public void onMessage(Message message) {
        if (message.getFlag().equals("TREE")){
            if (parent == null){
                parent = message.getSender();
                setColor(Color.red); // Devient informé
                this.getCommonLinkWith(parent).setWidth(3);
                sendAll(new Message("", "TREE"));
                send(parent, new Message("", "CHILD"));
                time = getTime();
            }
        }
        else if (message.getFlag().equals("CHILD")){
            children.add(message.getSender());
        }
    }

    @Override
    public void onClock() {
        if (time != null && getTime() == time+2 && children.isEmpty()) {
            setColor(Color.gray);
            send(parent, new Message("I finished.", "CHILD"));
        }
    }

    @Override
    public String toString() {
        return getID() + " " + children.size();
    }
}
