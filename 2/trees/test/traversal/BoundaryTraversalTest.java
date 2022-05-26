package traversal;

import base.Tree;
import org.junit.Before;
import org.junit.Test;

public class BoundaryTraversalTest {

    Tree tree = new Tree();

    @Before
    public void setUp() throws Exception {
        insertElements(tree);
    }
   /*
          7
        /   \
       2      9
      / \    / \
     1   4  8   10
        / \
       3   5
    */

    private void insertElements(Tree tree) {
        tree.head = tree.insert(tree.head, 7);
        tree.head = tree.insert(tree.head, 2);
        tree.head = tree.insert(tree.head, 1);
        tree.head = tree.insert(tree.head, 4);
        tree.head = tree.insert(tree.head, 3);
        tree.head = tree.insert(tree.head, 5);
        tree.head = tree.insert(tree.head, 9);
        tree.head = tree.insert(tree.head, 8);
        tree.head = tree.insert(tree.head, 10);
    }

    @Test
    public void testBoundaryTraversal(){
        BoundaryTraversal boundaryTraversal = new BoundaryTraversal();
        boundaryTraversal.boundaryTraversal(tree.head);
    }

}
