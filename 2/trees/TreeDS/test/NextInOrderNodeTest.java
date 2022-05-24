import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NextInOrderNodeTest {

    Tree tree = new Tree();

    @Before
    public void setUp() throws Exception {
        insertElements(tree);
    }

    private void insertElements(Tree tree) {
        tree.head = tree.insert(tree.head, 5);
        tree.head = tree.insert(tree.head, 3);
        tree.head = tree.insert(tree.head, 1);
        tree.head = tree.insert(tree.head, 4);
        tree.head = tree.insert(tree.head, 7);
        tree.head = tree.insert(tree.head, 6);
        tree.head = tree.insert(tree.head, 8);
    }

                /*
                     5
                    /  \
                   3    7
                  / \  / \
                  1 4  6  8
                */
    @Test
    public void testNextInOrderTraversal(){
        NextInOrderNode nextInOrderNode = new NextInOrderNode(tree);

        Assert.assertEquals("incorrect inorder traversal",1,nextInOrderNode.getNext());
        Assert.assertTrue("next element should be present as traversal is incomplete",nextInOrderNode.hasNext());

        Assert.assertEquals("incorrect inorder traversal",3,nextInOrderNode.getNext());
        Assert.assertTrue("next element should be present as traversal is incomplete",nextInOrderNode.hasNext());

        Assert.assertEquals("incorrect inorder traversal",4,nextInOrderNode.getNext());
        Assert.assertTrue("next element should be present as traversal is incomplete",nextInOrderNode.hasNext());

        Assert.assertEquals("incorrect inorder traversal",5,nextInOrderNode.getNext());
        Assert.assertTrue("next element should be present as traversal is incomplete",nextInOrderNode.hasNext());

        Assert.assertEquals("incorrect inorder traversal",6,nextInOrderNode.getNext());
        Assert.assertTrue("next element should be present as traversal is incomplete",nextInOrderNode.hasNext());

        Assert.assertEquals("incorrect inorder traversal",7,nextInOrderNode.getNext());
        Assert.assertTrue("next element should be present as traversal is incomplete",nextInOrderNode.hasNext());

        Assert.assertEquals("incorrect inorder traversal",8,nextInOrderNode.getNext());
        Assert.assertFalse("next element should NOT be present as traversal is complete",nextInOrderNode.hasNext());
    }


}