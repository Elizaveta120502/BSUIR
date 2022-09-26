package by.bsuir.part3;
// написать реализации методов put() и get()
// для класса Дерева Бинарного Поиска (BST)

public class BST<Key extends Comparable<Key>,Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value Val;
        private Node left;
        private Node right;
        private int N;

        public Node(Key key, Value val, int n) {
            this.key = key;
            Val = val;
            N = n;
        }

        public int size() {
            return size(root);
        }

        private int size(Node x) {
            if (x == null) {
                return 0;
            } else {
                return x.N;
            }

        }

        public Value get(Key key) {
            Node x = root;
            while (x != null) {
                int cmp = key.compareTo(x.key);
                if (cmp == 0) {
                    return x.Val;
                }
                else if (cmp < 0) x = x.left;
                else if (cmp > 0) x = x.right;

            }
            return x.Val;
        }

        public Node put(Node x,Key key, Value val){

                if (x == null) return new Node(key, val, 1);
                int cmp = key.compareTo(x.key);
                if      (cmp < 0) x.left  = put(x.left,  key, val);
                else if (cmp > 0) x.right = put(x.right, key, val);
                else              x.Val   = val;
                x.N = 1 + size(x.left) + size(x.right);
                return x;

        }
        }

}
