package by.bsuir.part6;

public class TST<Value>{
    private Node root;    //корень дерева

    private class Node {
        char c;
        Node left;
        Node mid;
        Node right;
        Value val;
    }

    private Value get(String key){
        Node node = get(root,key,0);
        if (node == null) return null;
        return (Value) node.val;
    }

    private Node get(Node node,String key, int digit){
        if (node == null){
            return null;
        }
        char c = key.charAt(digit);
        if (c < node.c){
            return get(node.left,key,digit);
        }
        else if (c > node.c){
            return get(node.right,key,digit);
        } else if (digit > key.length() -1){
            return get (node.mid,key,digit);
        }else {
            return node;
        }
    }

    private void put(String key, Value val){
        root = put(root,key,val,0);
    }

    private Node put(Node node,String key,Value val, int digit){
        char c = key.charAt(digit);
        if (node == null){
            node = new Node();
            node.c = c;
        }

        if (c < node.c){
            node.left = put(node.left,key,val,digit);
        }
        else if (c > node.c){
            node.right = put(node.right,key, val , digit);
        }
        else if(digit < key.length() -1){
            node.mid = put(node.mid,key, val, digit +1);
        }
        else{
            node.val = val;
        }
        return node;

    }






}
