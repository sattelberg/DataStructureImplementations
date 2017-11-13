package binarySearchTree;

public class RedBlackNode<T>{
	//represents the color of the node. Red = 0, Black = 1
	public boolean color;
	
	//the object stored in the BST
	public T data;
	public RedBlackNode(T x){
		this.color = false;
		this.data = x;
		
	}
	public RedBlackNode(){
		this.color = false;
		this.data = null;
	}
}
