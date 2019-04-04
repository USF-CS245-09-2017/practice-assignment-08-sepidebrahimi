//Sepid Ebrahimi, CS245, Prof. David Guy

public class BSTNode<T extends Comparable<T>> {
    private T data;
    private BSTNode<T> left;
    private BSTNode<T> right;

    public BSTNode(T newData) { //constructor
        data = newData;
        left = null;
        right = null;
    }

    public BSTNode<T> getLeft() { //get the node on the left
        return left;
    }

    public BSTNode<T> getRight() { //get the node on the right
        return right;
    }

    public T getData() { //get the data of the node
        return data;
    }

    public void setLeft(BSTNode<T> newNode) { //set the left node
        left = newNode;
    }

    public void setRight(BSTNode<T> newNode) { //set the right node
        right = newNode;
    }

    public void setData(T newData) { // set the data of the node
        data = newData;
    }
}