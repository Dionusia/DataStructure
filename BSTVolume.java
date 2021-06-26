public class BSTVolume {

    StringHandler handler = new StringHandler();
    Node root;

    BSTVolume(){root=null;}

    //we start adding Nodes
    public void addNodeVolume(long key, long name){

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

    class Node {

        long key;
        long name;

        Node leftChild;
        Node rightChild;

        Node(long key, long name){
            this.key = name;
            this.name=key;
        }


        public String toString(){
            // return "Date: " + handler.dateFormat(key) + " Volume: " + name;
            return "Volume: " + key + " Date: " + handler.dateFormat(name);            
        }
    }

    


        //Find the max node in BST 
    public Node findMinimum(Node node){
        if(node.leftChild != null){
            return findMinimum(node.leftChild);
        }
        return node;
    }

    
    //Find the max node in BST
    public Node findMaximum(Node node){
        if(node.rightChild != null){
            return findMaximum(node.rightChild);
        }
        return node;
    }  
}
    

