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
    public BinarySearchTree(BinaryTree n){
        super(n.getValue());

        if(n.getLeft()!=null)
            this.addLeft(n.getLeft());

        if(n.getRight()!=null)
            this.addRight(n.getRight());
    }

    @Override
    public void addLeaf(Node n){
        if(n.getValue() > this.value){
           if(getRight()==null){
               addRight(new BinarySearchTree(n);
           }else{//Has a right leaf
                getRight().addLeft(n);
           }
        }else{
            if(getLeft()==null){
                addLeft(n);
            }else{//Has a left leaf
                getLeft().addLeaf(n);
            }
        }
    }
}
