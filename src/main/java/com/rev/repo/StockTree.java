package com.rev.repo;

import java.util.Comparator;

import com.rev.entity.Stock;



// Java program for insertion in AVL Tree
	class Node {
	    Stock key;
	    int height;
	    
	    Node left, right;
	 
	    Node(Stock d) {
	        key = d;
	        height = 1;
	    }
	}
	
	/*
	 * 
	 * Need to define equals creteria for Node////TO DO????????????????????????
	 */
	 
	public class StockTree {
	 
	    private Node root;
	 
	    // A utility function to get height of the tree
	    int height(Node N) {
	        if (N == null)
	            return 0;
	 
	        return N.height;
	    }
	 
	    // A utility function to get maximum of two integers
	    int max(int a, int b) {
	        return (a > b) ? a : b;
	    }
	 
	    // A utility function to right rotate subtree rooted with y
	    // See the diagram given above.
	    Node rightRotate(Node y) {
	        Node x = y.left;
	        Node T2 = x.right;
	 
	        // Perform rotation
	        x.right = y;
	        y.left = T2;
	 
	        // Update heights
	        y.height = max(height(y.left), height(y.right)) + 1;
	        x.height = max(height(x.left), height(x.right)) + 1;
	 
	        // Return new root
	        return x;
	    }
	 
	    // A utility function to left rotate subtree rooted with x
	    // See the diagram given above.
	    Node leftRotate(Node x) {
	        Node y = x.right;
	        Node T2 = y.left;
	 
	        // Perform rotation
	        y.left = x;
	        x.right = T2;
	 
	        //  Update heights
	        x.height = max(height(x.left), height(x.right)) + 1;
	        y.height = max(height(y.left), height(y.right)) + 1;
	 
	        // Return new root
	        return y;
	    }
	 
	    // Get Balance factor of Node N
	    int getBalance(Node N) {
	        if (N == null)
	            return 0;
	 
	        return height(N.left) - height(N.right);
	    }
	 
	   public  Node insert(Node root, Stock newStock) {
	 
	        /* 1.  Perform the normal BST insertion */
	        if (newStock == null)
	            return new Node(newStock);
	        
	 
	        if (newStock.com)
	            root.left = insert(root.left, key);
	        else if (key > Node.key)
	            Node.right = insert(Node.right, key);
	        else // Duplicate keys not allowed
	            return Node;
	 
	        /* 2. Update height of this ancestor Node */
	        Node.height = 1 + max(height(Node.left),
	                              height(Node.right));
	 
	        /* 3. Get the balance factor of this ancestor
	              Node to check whether this Node became
	              unbalanced */
	        int balance = getBalance(Node);
	 
	        // If this Node becomes unbalanced, then there
	        // are 4 cases Left Left Case
	        if (balance > 1 && key < Node.left.key)
	            return rightRotate(Node);
	 
	        // Right Right Case
	        if (balance < -1 && key > Node.right.key)
	            return leftRotate(Node);
	 
	        // Left Right Case
	        if (balance > 1 && key > Node.left.key) {
	            Node.left = leftRotate(Node.left);
	            return rightRotate(Node);
	        }
	 
	        // Right Left Case
	        if (balance < -1 && key < Node.right.key) {
	            Node.right = rightRotate(Node.right);
	            return leftRotate(Node);
	        }
	 
	        /* return the (unchanged) Node pointer */
	        return Node;
	    }
	 
	    // A utility function to print preorder traversal
	    // of the tree.
	    // The function also prints height of every Node
	    void preOrder(Node Node) {
	        if (Node != null) {
	            System.out.print(Node.key + " ");
	            preOrder(Node.left);
	            preOrder(Node.right);
	        }
	    }
	 
	   /* public static void main(String[] args) {
	        NodeTree tree = new NodeTree();
	 
	         Constructing tree given in the above figure 
	        tree.setRoot(tree.insert(tree.getRoot(), 10));
	        tree.setRoot(tree.insert(tree.getRoot(), 20));
	        tree.setRoot(tree.insert(tree.getRoot(), 30));
	        tree.setRoot(tree.insert(tree.getRoot(), 40));
	        tree.setRoot(tree.insert(tree.getRoot(), 50));
	        tree.setRoot(tree.insert(tree.getRoot(), 25));
	 
	         The constructed AVL Tree would be
	             30
	            /  \
	          20   40
	         /  \     \
	        10  25    50
	        
	        System.out.println("Preorder traversal" +
	                        " of constructed tree is : ");
	        tree.preOrder(tree.getRoot());
	    }*/

		public Node getRoot() {
			return root;
		}

		public void setRoot(Node root) {
			this.root = root;
		}
	}