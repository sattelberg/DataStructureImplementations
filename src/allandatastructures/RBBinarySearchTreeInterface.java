package binarySearchTree;
/*
 * Author: Allan J Sattelberg-Rivera
 * Description: Interface for a binary search tree
 */
public interface RBBinarySearchTreeInterface {
	//returns the left subtree of the BSIntegerwithout removing it from the tree
	public RBBinarySearchTreeInterface left();
	//returns the right subtree of the BSIntegerwithout removing it from the tree
	public RBBinarySearchTreeInterface right();
	//returns the root of the this without removing it from the tree
	public Integer root();
	//sets the left subtree of this and returns the previous subtree
	public RBBinarySearchTreeInterface setLeft(RBBinarySearchTreeInterface l);
	//sets the right subtree of this and returns the previous subtree
	public RBBinarySearchTreeInterface setRight(RBBinarySearchTreeInterface r);
	//finds an element in a binary search tree and removes/returns it if it is present. returns NULL if not found
	public Integer getElt(Integer x);
	//inserts and element into a binary search tree
	public Integer insert(Integer x);
}


