public class BST<T extends Comparable<T>> {
    Comparable data;
    BSTNode<T> left;
    BSTNode<T> right;
    BSTNode<T> root;


    public BST(){
        root = null;
    }

    public boolean find(T value){
        return find(root,value);
    }

    private boolean find(BSTNode<T> node, T value){
        if(node==null){
            return false;
        }
        if(value.compareTo(node.getData())==0){
            return true;
        }
        else if(value.compareTo(node.getData()) > 0){
            return find(node.getRight(),value);
        }
        else{
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
            if(value.compareTo(node.getData()) > 0) {
                node.setRight(insert(value, node.getRight()));
                return node;
            } else {
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
        if(value.compareTo(node.getData()) == 0){
            if(node.getLeft()==null){
                return node.getRight();
            }
            else if(node.getRight()==null){
                return node.getLeft();
            }
            else{
                if(node.getRight().getLeft() == null){
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
        else if (value.compareTo(node.getData())< 0) {
            node.setLeft(delete(node.getLeft(), value));
            return node;
        } else {
            node.setRight(delete(node.getRight(), value));
            return node;
        }

    }

    private T removeSmallest (BSTNode<T> node) {

        if(node.getLeft().getLeft() == null) {
            T smallest = node.getLeft().getData();
            node.setLeft(node.getLeft().getRight());
            return smallest;
        }
        return removeSmallest(node.getLeft());
    }

}
