package TD1;

import io.jbotsim.core.Color;
import io.jbotsim.core.Message;
import io.jbotsim.core.Node;

import java.util.ArrayList;

public class TreeNodeV2 extends Node {
    private Node parent;
    private ArrayList<Node> children;

    @Override
    public void onStart() { // Initialisation par défaut
        setColor(Color.green); // Non informé
        parent = null;
        children = new ArrayList<>();
    }

    @Override
    public void onSelection() { // Noeud sélectionné
        setColor(Color.red); // Informé
        parent = this;
        sendAll(new Message("", "TREE"));
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
            }
        }
        else if (message.getFlag().equals("CHILD")){
            children.add(this);
        }
    }

    @Override
    public String toString() {
        return getID() + " " + children.size();
    }
}
