
public class Tree{


	class TreeNode{
		
		int data;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int data){
			this.data = data;
		}
	}
	
	private TreeNode head;
	
	public TreeNode insertData(TreeNode head,int data){
		
		if(head == null){
			head = new TreeNode(data);
			return head;
		}
		else if(head.data > data){
			return head.left = insertData(head.left,data);
		}
		else{
			return head.right = insertData(head.right,data);
		}
	
	}
	
	public void traverseInOrder(TreeNode head){
		if(head==null)
			return;
		System.out.println(head.data);
		traverseInOrder(head.left);
		traverseInOrder(head.right);
	}
	
	
	
	public static void main(String[] args){
		
		Tree tree = new Tree();
	}	
	
}	
