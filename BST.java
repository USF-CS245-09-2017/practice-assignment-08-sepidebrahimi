//Sepid Ebrahimi, CS245, Prof. David Guy

public class BST<T extends Comparable<T>> {
    BSTNode<T> root;


    public BST(){ //constructor
        root = null;
    }

    public boolean find(T value){
        return find(root,value);
    }

    private boolean find(BSTNode<T> node, T value){ //find the node
        if(node==null){ // if node does not exist
            return false;
        }
        if(value.compareTo(node.getData())==0){
            return true;
        }
        else if(value.compareTo(node.getData()) > 0){ //if value is greater than the node, go to the right side of the node
            return find(node.getRight(),value);
        }
        else{ //if value is smaller than the node, go to the left side of the node
            return find(node.getLeft(),value);
        }
    }


    public void insert(T value)
    {
        root = insert(value, root);
    }
    public BSTNode<T> insert (T value, BSTNode<T> node) {
            if(node == null) {
                return new BSTNode<T>(value);
            }
            if(value.compareTo(node.getData()) > 0) { //if value is greater than the node, go to the right side of the node
                node.setRight(insert(value, node.getRight()));
                return node;
            } else { //if value is smaller than the node, go to the left side of the node
                node.setLeft(insert(value, node.getLeft()));
                return node;
            }
    }



    public void print(){
        print(root);
    }
    public void print(BSTNode<T> node){
        if(node!= null){
            print(node.getLeft());
            System.out.println(node.getData() + " ");
            print(node.getRight());
        }

    }

    protected void delete(T string) {
        root = delete(root, string);
    }
    private BSTNode<T> delete(BSTNode<T> node, T value){
        if(node == null){
            return null;
        }
        if(value.compareTo(node.getData()) == 0){ //if value is equal to the data of the node
            if(node.getLeft()==null){ // if there is no child on the left
                return node.getRight();
            }
            else if(node.getRight()==null){//if there is no child on the right
                return node.getLeft();
            }
            else{
                if(node.getRight().getLeft() == null){ //if the node on the right has a child on left
                    node.setData(node.getRight().getData());
                    node.setRight(node.getRight().getRight());
                    return node;
                }
                else{
                    node.setData(removeSmallest(node.getRight()));
                    return node;
                }
            }
        }
        else if (value.compareTo(node.getData())< 0) {  //if value is smaller than node's value
            node.setLeft(delete(node.getLeft(), value));
            return node;
        } else { //if value is greater than node's value
            node.setRight(delete(node.getRight(), value));
            return node;
        }

    }

    private T removeSmallest (BSTNode<T> node) {

        if(node.getLeft().getLeft() == null) { //if the left node does not have a child on left
            T smallest = node.getLeft().getData();
            node.setLeft(node.getLeft().getRight());
            return smallest;
        }
        return removeSmallest(node.getLeft());
    }

}
