
public class BinarySearchTree {

    private StringHandler handler = new StringHandler();
    Node root;
    
    BinarySearchTree(){root=null;}


    //we start adding Nodes
    public void addNode(long key, long name){

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

    
    class Node {

        private long key;
        private long name;

        Node leftChild;
        Node rightChild;

        Node(long key, long name){
            this.key = key;
            this.name=name;
        }

        public String toString(){
            return "Date: " + handler.dateFormat(key) + " Volume: " + name; //go to string
            
        }
    }

    //function for search
    public Node findNode(long key){
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
    public void changeNode(long key, long newVolume){
        Node getFocusNode = findNode(key);

        if(getFocusNode != null){
            getFocusNode.name = newVolume;
            System.out.println(getFocusNode.toString());
        }else{
            System.out.println("Date not found");
        }

    }


    public Node deleteNode(Node root, long key){
        
        if(root == null){
            return root;
        }
        if(key < root.key){
            root.leftChild = deleteNode(root.leftChild,key);
        }
        else if (key > root.key){
            root.rightChild = deleteNode(root.rightChild, key);
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

    public long getMinKey(Node root){
        long min = root.key;
        while(root.leftChild != null){
            min = root.leftChild.key;
            root = root.leftChild;
        }
        return min;
    }
    
    //Find the max node in BST 
    public Node findMinimum(Node node){
        if(node.leftChild != null){
          return findMinimum(node.leftChild);
        }
        return node;
    }
    
    //Find the min node in BST
    public Node findMaximum(Node node){
        if(node.rightChild != null){
          return findMaximum(node.rightChild);
        }
        return node;
      }

}