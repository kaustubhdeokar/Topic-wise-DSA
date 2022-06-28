package tree;

import java.util.List;

public class NArrNode {
    public int val;
    public List<NArrNode> children;

    public NArrNode() {}

    public NArrNode(int _val) {
        val = _val;
    }

    public NArrNode(int _val, List<NArrNode> _children) {
        val = _val;
        children = _children;
    }
}
