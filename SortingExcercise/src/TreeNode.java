
public class TreeNode {
	private int data;
	private TreeNode left = null;
	private TreeNode right = null;
	
	public TreeNode(int data, TreeNode left, TreeNode right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public TreeNode(int i) {
		data = i;
	}

	public TreeNode(int i, TreeNode left) {
		this.data = i;
		this.left = left;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode next) {
		this.right = next;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode previous) {
		this.left = previous;
	}
	
	public String toString(){
		return Integer.toString(this.getData());
	}
	
	
}
