package fr.unice.abr.tree.binary;

import fr.unice.abr.tree.Node;

import java.util.InvalidPropertiesFormatException;

public class BinaryTree extends Node {

    public BinaryTree(int nodevalue, Node... nodes) throws InvalidPropertiesFormatException {
        super(nodevalue, nodes);
        if(nodes.length>2) throw new InvalidPropertiesFormatException("A binary tree has only two leafs per node !");

    }

    public BinaryTree(int nodevalue){
        super(nodevalue, new Node[0]);
    }

    public Node getLeft(){
        return this.nodes[0];
    }

    public Node getRight(){
        return this.nodes[1];
    }


}
