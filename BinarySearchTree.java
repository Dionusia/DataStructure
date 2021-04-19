import java.io.IOException;

public class BinarySearchTree {

    Node root;

    //we start adding Nodes
    public void addNode(int key, int name){

        //we create a new Node and initialize it
        Node newNode = new Node(key, name);

        //we check if it in did is our root
        if(root== null){
            root= newNode;
        }else{
            //we create another node
            Node focusNode= root;
            Node parent;

            while(true){
                parent = focusNode;

                //we check in which side our new node will go 
                if (key< focusNode.key){

                    focusNode = focusNode.leftChild;

                    if(focusNode == null){
                        parent.leftChild = newNode;
                        return;
                    }

                }else if(key > focusNode.key){

                    focusNode= focusNode.rightChild;

                    if(focusNode == null){
                        parent.rightChild = newNode;
                        return;
                    }

                }
            }
        }


    }

    public void inOrderTraverseTree(Node focusNode){

        if(focusNode != null){

            inOrderTraverseTree(focusNode.leftChild);
            System.out.println(focusNode);

            inOrderTraverseTree(focusNode.rightChild);

        }
    }

    /*public void preorderTraverseTree(Node focusNode){

        if(focusNode != null){

            //System.out.println(focusNode);

            preorderTraverseTree(focusNode.leftChild);
            preorderTraverseTree(focusNode.rightChild);

        }
    }

    public void postorderTraverseTree(Node focusNode){

        if(focusNode != null){

            postorderTraverseTree(focusNode.leftChild);
            postorderTraverseTree(focusNode.rightChild);

            //System.out.println(focusNode);

        }
    }*/

    
    class Node {

        int key;
        int name;

        Node leftChild;
        Node rightChild;

        Node(int key, int name){
            this.key = key;
            this.name=name;
        }

        public String toString(){
            return name + " has a key " +key;
        }
    }

    //function for search
    public Node findNode(int key){
        Node focusNode = root;

        while(focusNode.key != key){
            if(key < focusNode.key){
                focusNode = focusNode.leftChild;
            } else{
                focusNode = focusNode.rightChild;
            }

            if(focusNode == null){
                return null;
            }
        }

        return focusNode;
    }

    //change Volume
    public void changeNode(int key, int newVolume){
        Node getFocusNode = findNode(key);

        if(getFocusNode != null){
            getFocusNode.name = newVolume;
            System.out.println(getFocusNode.toString());
        }else{
            System.out.println("date not found");
        }

    }


    public Node deleteNode(Node root, int key){

        if(root == null){
            return root;
        }
        if(key < root.key){
            root.leftChild = deleteNode(root.leftChild,key);
        }
        else{
            if(root.leftChild == null){
                return root.rightChild;
            }
            else if(root.rightChild ==null)  
                return root.leftChild;

            root.key = getMinKey(root.rightChild);
            root.rightChild = deleteNode(root.rightChild,root.key);
        }
        return root;
    
    }

    public int getMinKey(Node root){
        int min = root.key;
        while(root.leftChild != null){
            min = root.leftChild.key;
            root = root.leftChild;
        }
        return min;
    }

    public static void main(String[] args) {
        
        BinarySearchTree theTree = new BinarySearchTree();
        
        theTree.addNode(50,3);
        theTree.addNode(30,4);
        theTree.addNode(20,5);
        theTree.addNode(40,6);
        theTree.addNode(70,7);
        theTree.addNode(60,8);
        theTree.addNode(80,9);
        

        //theTree.inOrderTraverseTree(theTree.root);
        theTree.deleteNode(theTree.root,30);
        theTree.inOrderTraverseTree(theTree.root);


    }
}