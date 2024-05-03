package trees.src;

import base.Node;

import java.util.Stack;
import base.*;
//write unit tests.
public class KthSmallestElement {

    public int kthsmallest(Node A, int B) {

        Stack<Node> stack = new Stack<>();
        fillStackLeftTree(stack,A);
        Node kthNode = fillStack(stack,B);
        return kthNode.val;

    }

    public void fillStackLeftTree(Stack<Node> stack, Node A){
        while(A!=null){
            stack.push(A);
            A = A.left;
        }
    }

    public Node fillStack(Stack<Node> stack, int k){

        int count = 0;
        while(!stack.isEmpty())
        {
            Node top = stack.pop();
            count+=1;
            if(count==k)
                return top;
            if(top.right!=null)
                fillStackLeftTree(stack,top.right);
        }
        return null;
    }

}
