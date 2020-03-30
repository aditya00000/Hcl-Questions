import java.util.HashMap; 
import java.util.Map; 



class Node 
{ 
	int key; 
	Node left, right, parent; 

	Node(int key) 
	{ 
		this.key = key; 
		left = right = parent = null; 
	} 
} 

class BinaryTree 
{ 
	Node root, n3, n4, lcp; 

	
	Node insert(Node node, int key) 
	{ 
		
		if (node == null) 
			return new Node(key); 

		
		if (key < node.key) 
		{ 
			node.left = insert(node.left, key); 
			node.left.parent = node; 
		} 
		else if (key > node.key) 
		{ 
			node.right = insert(node.right, key); 
			node.right.parent = node; 
		} 

		
		return node; 
	} 

	
	Node LCP(Node n3, Node n4) 
	{ 
		
		Map<Node, Boolean> ancestors = new HashMap<Node, Boolean>(); 

		
		while (n3 != null) 
		{ 
			ancestors.put(n3, Boolean.TRUE); 
			n3 = n3.parent; 
		} 

		 
		while (n4 != null) 
		{ 
			if (ancestors.containsKey(n4) != ancestors.isEmpty()) 
				return n4; 
			n4 = n4.parent; 
		} 

		return null; 
	} 

	
	public static void main(String[] args) 
	{ 
		BinaryTree tree = new BinaryTree(); 
		tree.root = tree.insert(tree.root, 20); 
		tree.root = tree.insert(tree.root, 8); 
		tree.root = tree.insert(tree.root, 22); 
		tree.root = tree.insert(tree.root, 4); 
		tree.root = tree.insert(tree.root, 12); 
		tree.root = tree.insert(tree.root, 10); 
		tree.root = tree.insert(tree.root, 14); 

		tree.n3 = tree.root.left.right.left; 
		tree.n4 = tree.root.left; 
		tree.lcp = tree.LCP(tree.n3, tree.n4); 

		System.out.println("LCP of " + tree.n3.key + " and " + tree.n4.key 
				+ " is " + tree.lcp.key); 
	} 
}