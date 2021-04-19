import java.io.IOException;

public class BinarySearchTree {

    Node root;

    //we start adding Nodes
    public void addNode(String key, String name){

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
                if (key.compareTo(focusNode.key) < 0){

                    focusNode = focusNode.leftChild;

                    if(focusNode == null){
                        parent.leftChild = newNode;
                        return;
                    }

                }else if(key.compareTo(focusNode.key) > 0){

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

    public void preorderTraverseTree(Node focusNode){

        if(focusNode != null){

            System.out.println(focusNode);

            preorderTraverseTree(focusNode.leftChild);
            preorderTraverseTree(focusNode.rightChild);

        }
    }


    
    class Node {

        String key;
        String name;

        Node leftChild;
        Node rightChild;

        Node(String key, String name){
            this.key = key;
            this.name=name;
        }

        public String toString(){
            return name + " has a key " +key;
        }
    }

    public static void main(String[] args) {
        
        BinarySearchTree theTree = new BinarySearchTree();
        try{
        FiletoArray ar = new FiletoArray("agn.us.txt", "Volume");
        String[] array= ar.getDate();
        for(int i=0; i<array.length; i++){
            theTree.addNode(array[i], "Volume");
        }

        theTree.preorderTraverseTree(theTree.root);
    }catch(IOException e){}
    }
}
