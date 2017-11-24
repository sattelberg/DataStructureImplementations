package allandatastructures;

/**
 * 
 * @author Allan Sattelberg-Rivera
 * An implementation of a Red Black Binary Search Tree for 
 * objects that implement the Comparable interface
 *
 */
public class RBBinaryTree<T extends Comparable<T>>{
	//a pointer to the left subtree of this
	private RBBinaryTree<T> left;
	//a pointer to the right subtree of this
	private RBBinaryTree<T> right;
	//a pointer to the parent tree of this
	private RBBinaryTree<T> parent;
	//the value stored at the  root of  this
	private T root;
	//the color of the root of this,  false = red, true  = black
	private boolean color;
	/**
	 * constructor with a root.  makes leaves black trees with null roots
	 * @param x: the value of the root of this
	 */
	public RBBinaryTree(T x) {
		this.root = x;
		if (x == null) {
			this.left = null;
			this.right = null;
		}else {
			this.left = new RBBinaryTree<T>(null);
			this.right = new RBBinaryTree<T>(null);
		}
		this.color = true;
	}
	/**
	 * default constructor, makes all values of this null
	 */
	public RBBinaryTree() {
		this.root = null;
		this.left = null;
		this.right = null;
	}
	//returns the color of the root of this
	public boolean color() {
		return this.color;
	}
	//returns the left subtree of the this
	public RBBinaryTree<T> left(){
		return this.left;
	}
	//returns the right subtree of this
	public RBBinaryTree<T> right(){
		return this.right;
	}
	//returns the parent tree of this
	public RBBinaryTree<T> parent() {
		return this.parent;
	}
	//returns the root of the this
	public T root(){
		return this.root;
	}
	/**
	 * 	THE FOLLOWING 4 METHODS ARE FOR SETTING UP TEST CASES ONLY
	 * 	DO NOT USE THEM IN YOUR ACTUAL CODING OR YOU DEFEAT THE
	 * 	PURPOSE OF A RBBINARY TREE
	 */
	/**
	 * @sets the root of this to x;
	 */
	public void setRoot(T x) {
		this.root = x;
	}
	/**
	 * @sets the color of this to color
	 * @param color the new color of this
	 */
	public void setColor(boolean color) {
		this.color = color;
	}
	//sets the left tree of this
	public void setLeft(RBBinaryTree<T> left) {
		this.left = left;
	}
	//sets the right subtree of this
	public void setRight(RBBinaryTree<T> right) {
		this.right = right;
	}
	//sets the parent of this
	public  void setParent(RBBinaryTree<T> parent) {
		this.parent = parent;
	}
	/**
	 * copies all the values from T  to this
	 * @param T the tree from which all values are copied
	 */
	public void setTree (RBBinaryTree<T> T) {
		this.root = T.root;
		this.left = T.left;
		this.right = T.right;
		this.parent = T.parent;
		this.color = T.color;
	}
	/**
	 *this = #this.parent 
	 *
	 *since changing object that this points to is not allowed in java,
	 *the data is swapped between the two objects and the .parent field of the 
	 *children of all relevant nodes are updated
	 */
	private void setToParent() {
		RBBinaryTree<T> oldTop = this.parent;
		RBBinaryTree<T> holder = new RBBinaryTree<T>();
		holder.setTree(oldTop);
		oldTop.setTree(this);
		oldTop.parent = this;
		this.left.parent = oldTop;
		this.right.parent = oldTop;
		this.setTree(holder);
		if (holder.left.equals(this)){
			this.left = oldTop;
			this.right.parent = this;
		}else if(holder.right.equals(this)) {
			this.right = oldTop;
			this.left.parent = this;
		}
	}
	/**
	 * inserts x into #this and updates #this 
	 * this is an approximately balanced RBBinaryTree<T>
	 * @param x the value to be inserted
	 */
	public  void insert(T x) {
		RBBinaryTree<T> xTree = new RBBinaryTree<T>(x);
		xTree.color = false;
		RBBinaryTree<T> p = this.locateParent(xTree);
		//makes the node black and the root of the 
		//tree if no other elts
		if (p.root == null) {
			xTree.color = true;
			this.setTree(xTree);
		}else if (p.root().compareTo(x) < 0) {
			p.right = xTree;
			xTree.parent = p;
		}else {
			p.left =  xTree;
			xTree.parent = p;
		}
		this.RBInsertFixup(xTree);
	}
	/**
	 * ensures that this is approximately balanced and 
	 * satisfies the requirements of a RBBinaryTree<T>
	 * after inserting z
	 * @param z the newly inserted element
	 */
	public void RBInsertFixup(RBBinaryTree<T> z) {
		 this.RBInsertFixup1(z);
		/*
		 * RBBinary Tree pp holds the parent of z before Fixup 2
		 * this allows us to redefine z for fixup 3
		 */
		RBBinaryTree<T> pp = z.parent;
		this.RBInsertFixup2(z);
		if (z.right.equals(pp) || z.left.equals(pp)) {
			z = pp;
		}
		this.RBInsertFixup3(z);
		this.color = true;
	}
	/**while both the parent and uncle of  the newly inserted element are red,
	 * makes both the parent and uncle black and the grandparent red 
	 * moves up the tree, making this correction while relevant
	 */
	public void RBInsertFixup1(RBBinaryTree<T> z) {
		while (z.parent != null && !z.parent.color) {
			/*
			 * if the while loop has caused the root to become red, then
			 * the root is turned black
			 */
			if (z.parent.parent == null) {
				z.parent.color = true;
			}else {
			/*
			 * while both the parent of z and the parent's sibling are red, the black of
			 * z's grandparent is pushed down
			 */
			RBBinaryTree<T> x = z.parent.parent.left;
			RBBinaryTree<T> y = z.parent.parent.right;
			if (!(x.color || y.color)){
				x.color = true;
				y.color = true;
				z.parent.parent.color = false;
				z = z.parent;
			}else {
				return;
			}
		}
		}
	}
	/**
	 * if the parent of z is red and the uncle of z is black
	 * but (z is the left subtree of z.parent) != (z.parent is the left  subtree of z.parent.parent)
	 * performs a rotate to make this statement true, thus allowing RBInsertFixup3 to function
	 * @param z
	 */
	public void RBInsertFixup2(RBBinaryTree<T> z){
		if (z.parent == null || z.parent.root == null || z.parent.color) {
			return;
		}
		RBBinaryTree<T> x = z.parent;
		RBBinaryTree<T> w = x.parent;
		if (z.equals(x.right) && x.equals(w.left) && (!z.color && !x.color)){
			this.leftRotate(z);
		}else if (z.equals(x.left) && x.equals(w.right)) {
			this.rightRotate(z);
		}
	}
	/**
	 * if  (z is the left subtree of z.parent) == (z.parent is the left  subtree of z.parent.parent)
	 * and [!(z.color or z.parent.color) and z.uncle.color]
	 *  rotates the tree s.t z.parent is the new root of the subtree with a root of #z.parent.parent
	 *  and swaps their colors
	 * @param z the bottom most problematic element in the subtree to be fixed
	 */
	public void RBInsertFixup3(RBBinaryTree<T> z) {
		if (z.parent == null || z.parent.color) {
			return;
		}
		RBBinaryTree<T> x = z.parent;
		RBBinaryTree<T> w = x.parent;
		if(z.equals(x.left) && x.equals(w.left)) {
			this.rightRotate(x);
			x.color = true;
			w.color = false;
		
		}else if(z.equals(x.right) && x.equals(w.right)) {
			this.leftRotate(x);
			x.color = true;
			w.color = false;
		}
	}
	/**
	 * performs a right rotate on z.parent
	 * @param z the element whose parent is to be rotated
	 */
	public  void rightRotate(RBBinaryTree<T> z) {
		RBBinaryTree<T> holder = z.right;
		RBBinaryTree<T> x = z.parent;
		z.right = x;
		x.left = holder;
		z.parent = x.parent;
		x.parent = z;
		if (z.parent == null) {
			this.setToParent();
		}else if (z.parent.left == x ) {
			z.parent.left =z;
		}else if (z.parent.right == x) {
			z.parent.right = z;
		}
	}

	/**
	 * performs a left rotate on z.parent
	 * @param z the element whose parent is to be rotated
	 */
	public void leftRotate(RBBinaryTree<T> z) {
		RBBinaryTree<T> holder = z.left;
		RBBinaryTree<T> x = z.parent;
		z.left = x;
		x.right = holder;
		z.parent = x.parent;
		x.parent = z;
		if (z.parent == null) {
			this.setToParent();
		}else if (z.parent.left == x ) {
			z.parent.left =z;
		}else if (z.parent.right == x) {
			z.parent.right = z;
		}
	}	
	/**
	 * finds the subtree that will be the parent of z
	 * @param z the subtree whose parent is to be located
	 * @return the subtree that is a parent of z
	 */
	public RBBinaryTree<T> locateParent(RBBinaryTree<T> z) {
		if (this.root == null) {
			return this;
		}
		if (z.root.compareTo(this.root()) < 0) {
			if (this.left.root==null) {
				return this;
			}else {
				return this.left.locateParent(z);
			}
		}else {
			if(this.right.root == null) {
				return this;
			}else {
				return this.right.locateParent(z);
			}
		}
	}
}

