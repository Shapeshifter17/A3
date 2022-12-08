public class Node {

        int element;
        int h;  //for height
        Node leftChild;
        Node rightChild;
        String key;
        String value;

        //default constructor to create null node
        public Node(String key) {
            this.key = key;
            this.value = null;
        }

    public Node(String key, String value){
        this.key = key;
        this.value = value;
    }
}
