package by.bsuir.part3;
// написать реализации методов put() и get()
// для класса Дерева Бинарного Поиска (BST)

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left;
        private Node right;
        private int n;

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            this.n = n;
        }


        private int size(Node x) {
            if (x == null) {
                return 0;
            } else {
                return x.n;
            }

        }

        public Key getKey() {
            return key;
        }

        public Value getVal() {
            return val;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public int getN() {
            return n;
        }
    }

    public int size(Node node) {
        return node.size(node);
    }

    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) {
                return x.val;
            } else if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;

        }
        return x.val;
    }

    public Node put(Node x, Key key, Value val) {


        if (x == null) {
            return new Node(key, val, 1);
        }

        int cmp = key.compareTo(x.key);

        if (cmp < 0) {
            x.left = new Node(key, val, 1);
        } else if (cmp > 0) {
            x.right = new Node(key, val, 1);
        } else {
            x.val = val;
        }
        x.n = 1 + size(x.left) + size(x.right);
        return x;

    }

}
