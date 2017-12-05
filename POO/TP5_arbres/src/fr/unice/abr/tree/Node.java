package fr.unice.abr.tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Un arbre n-aire
 */
public class Node {
    protected int count;
    protected int value;
    protected Node[] nodes;
    private static int MAX_DECLARATION = 10;//pourquoi faire plus ?

    public Node(int nodeValue, Node... nodes){
        this.value=nodeValue;
        this.count = nodes.length;
        int i=0;
        this.nodes = new Node[MAX_DECLARATION];
        for(Node n : nodes) {
            if(n!=null) {
                this.nodes[i] = n;
                i++;
            }else break;
        }
    }

    public Node(int nodeValue, Node node){
        this(nodeValue, new Node[]{node});
    }

    public void addLeaf(Node node){
        this.nodes[count++] = node;
    }

    @Override
    public String toString(){
        String str = this.value+"\n";
        int i = 0;
        if(this.count>0){
            for(Node n : nodes) {
                if(n!=null) {
                    str += "leaf "+i+" :"+nodes[i].toString();
                    i++;
                }else {
                    break;
                }
            }
        }
        return  str;
    }

}
