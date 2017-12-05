package fr.unice.abr.tree.binary;



import static org.junit.Assert.*;

public class BinaryTreeTest {
    private BinaryTree bTest;

    @org.junit.Before
    public void addLeaf() throws Exception {
        bTest = new BinaryTree(1,
                new BinaryTree(2, new BinaryTree(3)),
                new BinaryTree(4, new BinaryTree(5, new BinaryTree(6))));
        assertTrue(bTest.getValue()==1);
        assertTrue(bTest.getLeft().getValue()==2);
        assertTrue(bTest.getLeft().getLeft().getValue()==3);
        assertTrue(bTest.getRight().getValue()==4);
        assertTrue(bTest.getRight().getLeft().getValue()==5);
        assertTrue(bTest.getRight().getLeft().getLeft().getValue()==6);

    }

    @org.junit.Test
    public void addLeft() throws Exception {
        bTest.getRight().getLeft().getLeft().addLeft(new BinaryTree(7));
        assertTrue(bTest.getRight().getLeft().getLeft().getLeft().getValue()==7);

    }

    @org.junit.Test
    public void addRight() throws Exception {
        bTest.getRight().getLeft().getLeft().addRight(new BinaryTree(8));
        assertTrue(bTest.getRight().getLeft().getLeft().getRight().getValue()==8);
    }


}
