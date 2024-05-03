package tree;

public class SerialiseDeserialise {
    
    public void serialize(Node root, ArrayList<Integer> list) 
	{
	    if(root == null){
	        list.add(-1);
	        return;
	    }
	    list.add(root.data);
	    serialize(root.left, list);
	    serialize(root.right, list);
	}
	
	//Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> list)
    {
        Node node = null;
        if(list.size()==0){
            return node;
        }
        
        int[] index = {0};
        node = constructNode(list, index);
        return node;
        
    }
    
    public Node constructNode(ArrayList<Integer> list, int[] index)
    {
        int idx = index[0];
        if(list.get(idx)==-1)
        {
            index[0]+=1;
            return null;
        }
        Node node = new Node(list.get(idx));
        index[0]+=1;
        node.left = constructNode(list, index);
        node.right = constructNode(list, index);
        return node;
    }

}
