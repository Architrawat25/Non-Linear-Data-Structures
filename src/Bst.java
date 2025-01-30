import java.util.LinkedList;
import java.util.Queue;

public class Bst {

    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    Node root;
    Bst(){
       this.root=null;
    }

    //Time complexity: O(log n) or O(level)
    //Worst case: skewed tree O(n)
    public void insert(int data){
        root=insertData(root, data);
    }
    public Node insertData(Node root, int data){
        if(root==null){
            root=new Node(data);
        }
        else if(data<root.data){
            root.left=insertData(root.left, data);
        }
        else if(data>root.data){
            root.right=insertData(root.right, data);
        }
        return root;
    }

    public void inOrder(){
        inOrderTraversal(root);
    }
    public void inOrderTraversal(Node root){
        if(root!=null) {
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }

    public void preOrder(){
        preOrderTraversal(root);
    }
    public void preOrderTraversal(Node root){
        if(root!=null) {
            System.out.print(root.data + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public void postOrder(){
        postOrderTraversal(root);
    }
    public void postOrderTraversal(Node root){
        if(root!=null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void getHeight(){
        System.out.println(height(root)-1);
    }
    public int height(Node root){
        if(root==null){
            return 0;
        }
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        return Math.max(leftHeight,rightHeight) +1;
    }

//    public void delete(int element){
//        deleteNode(root, element);
//    }
    public Node deleteNode(Node root, int key){
        if(root==null){
            return root;
        }
        else{
            if(key < root.data){
                return root.left=deleteNode(root.left, key);
            }
            else if(key > root.data){
                return root.right=deleteNode(root.right, key);
            }
            //Key found
            else{
                if(root.left==null){
                    return root.right;
                }
                else if(root.right==null){
                    return root.left;
                }
                else{
                    /*Replacing with the smallest value in right SubTree
                    or the Greatest value in left subtree*/
                    root.data=findMin(root.right);
                    //Deleting duplicate data
                    root.right=deleteNode(root.right, root.data);
                }
            }
        }
        return root;
    }
    //For finding the smallest value in right SubTree
    public int findMin(Node root){
        Node temp=root;
        int min=root.data;
        while(temp.left!=null){
            temp=temp.left;
            min=temp.data;
        }
        return min;
    }

    public void bfs(){
        breathFirstSearch(root);
    }
    public void breathFirstSearch(Node root){
        if(root==null){
            System.out.println("tree is empty");
            return;
        }
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node deleted=q.poll();
            System.out.print(deleted.data+" ");
//            System.out.println("Queue before adding children: " + q);
            if(deleted.left!=null){
                q.add(deleted.left);
            }
            if(deleted.right!=null){
                q.add(deleted.right);
            }
        }
    }


}







