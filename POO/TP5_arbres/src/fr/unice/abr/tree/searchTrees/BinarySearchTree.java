package fr.unice.abr.tree.searchTrees;

import fr.unice.abr.tree.Node;
import fr.unice.abr.tree.binary.BinaryTree;

import java.util.InvalidPropertiesFormatException;

public class BinarySearchTree extends BinaryTree {

    public BinarySearchTree(int nodevalue, Node... nodes) throws InvalidPropertiesFormatException {
        super(nodevalue, nodes);
    }

    public BinarySearchTree(int nodevalue) {
        super(nodevalue);
    }

    @Override
    public void addLeaf(Node n){
        if(n.getValue() > this.value){
           if(getRight()==null){
               addRight(n);
           }else{//Has a right leaf
                nodes[1].addLeaf(n);
           }
        }else{
            if(getLeft()==null){
                nodes[0] = n;
            }else{//Has a left leaf
                addLeft(n);
            }
        }
    }
}
