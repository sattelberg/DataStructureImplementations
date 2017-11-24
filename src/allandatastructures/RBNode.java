package binarySearchTree;
/*
 * A Node in a Red Black Binary Search Tree
 */
public class RBNode{
	//represents the color of the node. Red = 0, Black = 1
	public boolean color;
	//the object stored in the BST
	public Integer data;
	//a pointer to the parent of this
	public RBBinarySearchTreeInterface parent;
	public RBNode(Integer x){
		this.color = false;
		this.data = x;
		
	}
	public RBNode(){
		this.color = false;
		this.data = null;
	}
	public RBNode(Integer x, boolean color){
		this.color = color;
		this.data = x;
		
	}
}
