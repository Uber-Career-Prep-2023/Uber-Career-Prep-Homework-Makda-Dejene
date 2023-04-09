class BinarySearchTree {
    class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public int min() {
        if (root == null) {
            throw new RuntimeException();
        }
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.val;
    }

    public int max() {
        if (root == null) {
            throw new RuntimeException();
        }
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.val;
    }

    public boolean contains(int val) {
        Node current = root;
        while (current != null) {
            if (current.val == val) {
                return true;
            } else if (current.val > val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
        } else {
            Node current = root;
            while (true) {
                if (current.val == val) {
                    return; 
                } else if (current.val > val) {
                    if (current.left == null) {
                        current.left = new Node(val);
                        return;
                    } else {
                        current = current.left;
                    }
                } else {
                    if (current.right == null) {
                        current.right = new Node(val);
                        return;
                    } else {
                        current = current.right;
                    }
                }
            }
        }
    }

    public int delete(int val) {
        if (root == null) {
            return null;
        }
        Node current = root;
        Node parent = null;
        while (current != null) {
            if (current.val == val) {
                if (current.left == null && current.right == null) {
                    if (parent == null) {
                        root = null;
                    } else if (parent.left == current) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                } else if (current.left == null) {
                    if (parent == null) {
                        root = current.right;
                    } else if (parent.left == current) {
                        parent.left = current.right;
                    } else {
                        parent.right = current.right;
                    }
                } else if (current.right == null) {
                    if (parent == null) {
                        root = current.left;
                    } else if (parent.left == current) {
                        parent.left = current.left;
                    } else {
                        parent.right = current.left;
                    }
                } else {
                    Node min = current.right;
                    while (min.left != null) {
                        min = min.left;
                    }
                    int temp = min.val;
                    delete(min.val);
                    current.val = temp;
                }
                return val;
            } else if (current.val > val) {
                parent = current;
                current = current.left;
            } else {
                parent = current;
                current = current.right;
            }
        }
        return null;
    }
}
