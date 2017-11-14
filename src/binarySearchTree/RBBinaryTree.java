package binarySearchTree;
/*
 * Author: Allan J Sattelberg-Rivera
 * Description: Interface for a binary search tree
 */

public class RBBinaryTree{
	public class RBNode{
		//represents the color of the node. Red = false, Black = true
		public boolean color;
		//the object stored in the BST
		public Integer data;
		//a pointer to the parent of this
		public RBBinaryTree parent;
		public RBNode(Integer x){
			this.color = false;
			this.data = x;
			this.parent = null;
		}
		
	}
	private RBBinaryTree left;
	private RBBinaryTree right;
	private RBNode root;
	//constructor
	public RBBinaryTree(RBNode x) {
		this.root = x;
		this.left = null;
		this.right = null;
	}
	public RBBinaryTree() {
		this.root = null;
		this.left = null;
		this.right = null;
	}
	//returns the left subtree of the BSInteger without removing it from the tree
	public RBBinaryTree left(){
		return this.left;
	}
	//returns the right subtree of the BSInteger without removing it from the tree
	public RBBinaryTree right(){
		return this.right;
	}
	//returns the root of the this without removing it from the tree
	public RBNode rootNode(){
		return this.root;
	}
	//sets the left subtree of this and returns the previous subtree
	public RBBinaryTree setLeft(RBBinaryTree l){
		RBBinaryTree left = this.left;
		this.left = l;
		return left;
	}
	//sets the right subtree of this and returns the previous subtree
	public RBBinaryTree setRight(RBBinaryTree r){
		RBBinaryTree right = this.right;
		this.right = r;
		return right;
	}
	//inserts a node containing data = x into the tree
	public void insert(Integer x) {
		RBNode newNode = new RBNode(x);
		RBBinaryTree p = this.locateParent(x);
		newNode.parent = p;
		if (p.root == null) {
			this.root = newNode;
		}else if (p.root() <= x) {
			p.right = new RBBinaryTree(newNode);
		}else {
			p.left = new RBBinaryTree(newNode);
		}
		RBInsertFixup(newNode);
	}
	public void RBInsertFixup(RBNode x) {};
	public RBBinaryTree locateParent(Integer x) {
		return null;
	}
	//reports the object at the root of this without removing it
	public Integer root() {
		return this.root.data;
	}
}

