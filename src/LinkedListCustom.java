import java.util.Arrays;

public class LinkedListCustom {

     class Node {
        Node previous;
        Node next;
        String key;
        String value;

        public Node(String id, String info){
            this.key = id;
            this.value = info;
        }
    }

    //Initialization
    LinkedListCustom.Node head, tail = null;

    //add a node to the list
    public void addNode(String id, String info) {

        //Create a new node
        LinkedListCustom.Node newNode = new LinkedListCustom.Node(id,info);

        //if list is empty, head and tail points to newNode
        if(head == null) {
            head = tail = newNode;
            //head's previous will be null
            head.previous = null;
        }
        else {
            //add newNode to the end of list. tail->next set to newNode
            tail.next = newNode;
            //newNode->previous set to tail
            newNode.previous = tail;
            //newNode becomes new tail
            tail = newNode;
        }
        tail.next = null;
    }


    //Returns the keys
    public String[] print() {
        String arr [] = new String[getSize()];

        Node temp = head;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp.key;
            temp = temp.next;
        }
        Arrays.sort(arr);

        return arr;
    }

    private void deleteNode(Node node) {
        if (node != null) {
            // Here we can rely on 'node' actually being in our list
            if (node.previous != null)
                node.previous.next = node.next;
            else
                head = node.next;
            if (node.next != null)
                node.next.previous = node.previous;
            else
                tail = node.previous;
        }
    }
    public void deleteValue(String key) {
        Node current = head;
        while (current != null && !current.key.equals(key) ) {
            current = current.next;
        }
        deleteNode(current);

    }

    public int getSize(){
        Node temp = head;
        int count = 0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    public String getValue(String key){
        Node current = head;
        while (current!=null){
            if (current.key.equals(key)){
                return current.value;
            }
            current = current.next;
        }
        return "String not found";
    }

    public String nextKey(String key){
        Node current = head;
        while (current.next!=null){
            if (current.key.equals(key)){
                return current.next.key;
            }
            current = current.next;
        }
        return "String not found";
    }

    public String prevKey(String key){
        Node current = head;
        while (current.next!=null){
            if (current.key.equals(key)){
                return current.previous.key;
            }
            current = current.next;
        }
        return "String not found";
    }

    public int rangeKey(String key1, String key2){
        int count = 0;
        Node current = head;
        boolean passedFirstKey = false;

        while (current!=null){
            if (passedFirstKey) {
                count++;
            }
            if (current.key.equals(key1)){
                System.out.println("Found first");
                passedFirstKey = true;
            }
            if (current.key.equals(key2)){
                System.out.println("found second");
                passedFirstKey = false;
            }

            current = current.next;
        }

        return count - 1 ;
    }



}
