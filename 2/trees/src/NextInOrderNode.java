import base.*;

import java.util.Stack;

//https://leetcode.com/problems/binary-search-tree-iterator/
//173. Binary Search base.Tree Iterator

public class NextInOrderNode {

    Tree tree;
    Stack<Node> stack = new Stack<>();

    NextInOrderNode(Tree tree) {
        this.tree = tree;
        fillStack(stack,tree.head);
    }

    public void fillStack(Stack<Node> stack, Node head){
        while(head!=null){
            stack.push(head);
            head = head.left;
        }
    }

    public int getNext(){
        Node topElem = stack.pop();
        if(topElem.right!=null){
            fillStack(stack,topElem.right); //if there is a right node present, push all the elements from it's left branch in the stack.
        }
        return topElem.val;
    }

    public boolean hasNext(){
        return !stack.isEmpty();
    }


}
