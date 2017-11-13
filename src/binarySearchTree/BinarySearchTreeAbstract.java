package binarySearchTree;
/*
 * Author: Allan J Sattelberg-Rivera
 * Description: Interface for a binary search tree
 */
public abstract class BinarySearchTreeAbstract<T> implements BinarySearchTree<T>{
	private BinarySearchTree<T> left;
	private BinarySearchTree<T> right;
	private T root;
	//returns the left subtree of the BST without removing it from the tree
	public BinarySearchTree<T> left(){
		return this.left;
	}
	//returns the right subtree of the BST without removing it from the tree
	public BinarySearchTree<T> right(){
		return this.right;
	}
	//returns the root of the this without removing it from the tree
	public T root(){
		return this.root;
	}
	//sets the left subtree of this and returns the previous subtree
	public BinarySearchTree<T> setLeft(BinarySearchTree<T> l){
		BinarySearchTree<T> left = this.left;
		this.left = l;
		return left;
	}
	//sets the right subtree of this and returns the previous subtree
	public BinarySearchTree<T> setRight(BinarySearchTree<T> r){
		BinarySearchTree<T> right = this.right;
		this.right = r;
		return right;
	}
	//sets the root of this and returns the previous root
	public T setRoot(T x){
		T root = this.root;
		this.root = x;
		return root;
	}
}

