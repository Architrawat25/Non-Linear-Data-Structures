public class Main {
    public static void main(String[] args) {

        /*
        BinaryTree tree=new BinaryTree();
        tree.root=new BinaryTree.Node(10);
        System.out.println(tree.root.data);
        tree.root.left=new BinaryTree.Node(20);
        tree.root.right=new BinaryTree.Node(30);
        System.out.println(tree.root.left.data);
        System.out.println(tree.root.right.data);
        */

        //Max number of nodes for a level are 2^level

        Bst bst=new Bst();
        bst.insert(54);
        bst.insert(30);
        bst.insert(18);
        bst.insert(12);
        bst.insert(6);
        bst.insert(48);
        bst.insert(36);
        bst.insert(24);

        //Depth First Search
        //Time complexity: O(n)
        //In-order traversal prints ascending data
          bst.inOrder();
//        System.out.println();
//        bst.preOrder();
//        System.out.println();
//        bst.postOrder();
//        System.out.println();

        //Height
//        bst.getHeight();


//        bst.deleteNode(bst.root, 18);
//        bst.inOrder();
        System.out.println();
        bst.bfs();

    }
}
