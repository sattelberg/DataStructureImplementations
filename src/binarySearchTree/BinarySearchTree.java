package binarySearchTree;
/*
 * Author: Allan J Sattelberg-Rivera
 * Description: Interface for a binary search tree
 */
public interface BinarySearchTree<T> {
	//returns the left subtree of the BST without removing it from the tree
	public BinarySearchTree<T> left();
	//returns the right subtree of the BST without removing it from the tree
	public BinarySearchTree<T> right();
	//returns the root of the this without removing it from the tree
	public T root();
	//sets the left subtree of this and returns the previous subtree
	public BinarySearchTree<T> setLeft(BinarySearchTree<T> l);
	//sets the right subtree of this and returns the previous subtree
	public BinarySearchTree<T> setRight(BinarySearchTree<T> r);
	//sets the root of this and returns the previous root
	public T setRoot(T root);
	//finds an element in a binary search tree and removes/returns it if it is present. returns NULL if not found
	public T getElt(T x);
	//inserts and element into a binary search tree
	public T insert(T x);
}


