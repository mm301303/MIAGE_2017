package fr.unice.abr.tree.binary;

import fr.unice.abr.tree.Node;

import java.util.InvalidPropertiesFormatException;

public class BinaryTree extends Node {

    public BinaryTree(int nodevalue, Node... nodes) throws InvalidPropertiesFormatException {
        super(nodevalue, nodes);
        if(count>2) throw new InvalidPropertiesFormatException("A binary tree has only two leafs per node !");

    }

    public BinaryTree(int nodevalue){
        super(nodevalue);
    }

    @Override
    public void addLeaf(Node n){
        if(this.count<2) {
           this.count++;
           addLeaf(n);
        }else{
            System.out.println("cannot add more");
        }
    }

    public void  addLeft(Node n){
        nodes[0] = n;
    }
    public void  addRight(Node n){
        nodes[1] = n;
    }

    public BinaryTree getLeft(){
        return (BinaryTree)this.nodes[0];
    }

    public BinaryTree getRight(){
        return (BinaryTree)this.nodes[1];
    }


}
