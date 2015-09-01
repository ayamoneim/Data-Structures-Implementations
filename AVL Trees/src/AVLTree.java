public class AVLTree<Element extends Comparable<Element>> implements
		AvlTreeInterface<Element> {

	private Node<Element> root;

	public AVLTree() {
		this.root = null;
	}

	public void setRoot(Node node) {
		this.root = node;
	}

	public Node<Element> getRoot() {
		return this.root;
	}

	/*
	 * Paramenters -->Element to be inserted e -->current node The method starts
	 * traversing the tree from the root going left if the element to be
	 * inserted is less than curr element (thus belongs to the left
	 * sub-tree)else goes down the right sub-tree till it hits the bottom then
	 * the new node is attached and the rebalancing procedure is carried out as
	 * the recursive call un-warp updating the heights of all the nodes on the
	 * path from the inserted node to the root
	 */
	private Node<Element> insert(Element e, Node node) {

		if (node == null) {
			return new Node(e);
		}

		int compare = node.compareTo(e);

		if (compare > 0) {
			node.setLeft(insert(e, node.getLeft()));
		} else if (compare < 0) {
			node.setRight(insert(e, node.getRight()));
		}
		return rebalanceTree(node);
	}

	private int heightOf(Node node) {
		return node == null ? -1 : node.getHeight();
	}

	/*
	 * The method fixes the heights of the tree after insertions and carries out
	 * double/single rotations to maintain the tree balanced
	 */
	private Node<Element> rebalanceTree(Node node) {
		if (node == null)
			return node;

		// Currently the problem is in the left subtree

		if (heightOf(node.getLeft()) - heightOf(node.getRight()) >= 2) {
			// Is it in the left of the left subtree or the right of the left
			// subtree ?

			if (heightOf(node.getLeft().getLeft()) >= heightOf(node.getLeft()
					.getRight())) {

				node = SingleLeftRotation(node);
			} else {
				node = DoubleLeftRotation(node);

			}

			// Currently the problem is in the right subtree
		} else if (heightOf(node.getRight()) - heightOf(node.getLeft()) >= 2) {
			// Is it in the left of the right subtree or the right of the right
			// subtree ?
			if (heightOf(node.getRight().getRight()) >= heightOf(node
					.getRight().getLeft())) {
				node = SingleRightRotation(node);
			} else {
				node = DoubleRightRotation(node);

			}
		}

		node.setHeight(Math.max(heightOf(node.getLeft()),
				heightOf(node.getRight())) + 1);
		return node;
	}

	private Node DoubleRightRotation(Node node) {
		node.setRight(SingleLeftRotation(node.getRight()));
		return SingleRightRotation(node);
	}

	private Node SingleRightRotation(Node node) {
		Node<Element> node0 = node.getRight();
		node.setRight(node0.getLeft());
		node0.setLeft(node);
		node.setHeight(Math.max(heightOf(node.getLeft()),
				heightOf(node.getRight())) + 1);
		node0.setHeight(Math.max(heightOf(node0.getLeft()),
				heightOf(node0.getRight())) + 1);
		return node0;
	}

	private Node DoubleLeftRotation(Node node) {
		node.setLeft(SingleRightRotation(node.getLeft()));
		return SingleLeftRotation(node);
	}

	private Node SingleLeftRotation(Node node) {
		Node<Element> node0 = node.getLeft();
		node.setLeft(node0.getRight());
		node0.setRight(node);
		node.setHeight(Math.max(heightOf(node.getLeft()),
				heightOf(node.getRight())) + 1);
		node0.setHeight(Math.max(heightOf(node0.getLeft()),
				heightOf(node0.getRight())) + 1);
		return node0;
	}

	/*
	 * Parameters : (The element to search for e ,current node) Compares the
	 * element to the current element ,if the element is bigger than the current
	 * element look up the right subtree else if the element is less than the
	 * current element look up left subtree else the element is equal the
	 * current element return true .If a null node is reached return false.
	 */
	private boolean lookUp(Element e, Node node) {
		if (node == null)
			return false;
		boolean ans = false;
		int compareResult = node.compareTo(e);
		if (compareResult > 0) {
			return ans | lookUp(e, node.getLeft());
		} else if (compareResult < 0) {
			return ans | lookUp(e, node.getRight());
		} else {
			return true;
		}
	}

	/*
	 * First Search for the element to be deleted when found delete it and
	 * replace it with its successor/predecessor if present and recursively do
	 * the same but changing the target element to be deleted then start
	 * rebalancing up the tree till the root
	 */
	private Node<Element> delete(Element e, Node<Element> node) {

		if (node == null)
			return node;

		int compareResult = node.compareTo(e);
		if (compareResult > 0) {
			node.setLeft(delete(e, node.getLeft()));
		} else if (compareResult < 0) {
			node.setRight(delete(e, node.getRight()));
		} else if (node.getLeft() != null && node.getRight() != null) {
			node.setData(getMin(node.getRight()).getData());
			node.setRight(delete(node.getData(), node.getRight()));
		} else {
			if (node.getLeft() != null) {
				node = node.getLeft();
			} else {
				node = node.getRight();
			}
		}
		return rebalanceTree(node);
	}

	/* The method carries out in Order traversal
	 *Returns 1st node greater than current  
	 */

	private Node<Element> getMin(Node<Element> right) {
		Node<Element> curr = right;
		while (curr.getLeft() != null)
			curr = curr.getLeft();
		return curr;
	}

	@Override
	public int getTreeHeight() {
		if (this.root != null)
			return this.root.getHeight();
		return -1;
	}

	@Override
	public void insert(Element e) {
		this.root = insert(e, this.root);
	}

	@Override
	public boolean lookUp(Element e) {
		return lookUp(e, this.root);
	}

	@Override
	public Node delete(Element e) {
		return this.root = delete(e, this.root);
	}

	public void printTree(Node curr) {
		if (curr != null) {
			printTree(curr.getLeft());
			System.out.println(curr.getData());
			printTree(curr.getRight());
		}
	}

}
