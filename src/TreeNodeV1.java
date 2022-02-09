import io.jbotsim.core.Color;
import io.jbotsim.core.Message;
import io.jbotsim.core.Node;

import java.util.ArrayList;

public class TreeNodeV1 extends Node {
    private Node parent;

    @Override
    public void onStart() { // Initialisation par défaut
        setColor(Color.green); // Non informé
        parent = null;
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
            }
        }
    }
}
