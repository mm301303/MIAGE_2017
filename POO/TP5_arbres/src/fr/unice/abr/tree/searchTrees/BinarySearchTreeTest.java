package fr.unice.abr.tree.searchTrees;

import fr.unice.abr.tree.binary.BinaryTree;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    private BinarySearchTree bTest;

    @org.junit.Test
    public void addLeaf() throws Exception {
        bTest = new BinarySearchTree(0);
        bTest.addLeaf(new BinarySearchTree(1));
        assertTrue(bTest.getRight().getValue()==1);
        bTest.addLeaf(new BinarySearchTree(-1));
        assertTrue(bTest.getLeft().getValue()==-1);

        bTest.addLeaf(new BinarySearchTree(2));

        System.out.println(bTest.getRight().getLeft());

        assertTrue(bTest.getRight().getLeft().getValue()==2);

        bTest.addLeaf(new BinarySearchTree(-3));

        assertTrue(bTest.getLeft().getLeft().getValue()==-3);

        bTest.addLeaf(new BinarySearchTree(-2));
        assertTrue(bTest.getLeft().getRight().getValue()==2);


    }

    public BinarySearchTree getRight(BinarySearchTree b){
        return getRight(b);
    }


}