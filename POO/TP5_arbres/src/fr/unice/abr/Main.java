package fr.unice.abr;

import fr.unice.abr.tree.Node;
import fr.unice.abr.tree.binary.BinaryTree;

import java.util.InvalidPropertiesFormatException;

public class Main {

    public static void main(String[] args) {
        try {
            BinaryTree bTree = new BinaryTree(4, new Node(3), new Node(2));
            BinaryTree bTree2 = new BinaryTree(5, bTree);
            bTree2.addLeaf(new Node(-6));
            System.out.println(bTree.toString());
            System.out.println("-"+bTree2.toString());

        } catch (InvalidPropertiesFormatException e) {
            e.printStackTrace();
        }
    }
}
