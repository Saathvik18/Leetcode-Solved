/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
           // Node temp = new Node();
            return head;
        }
        Node c_head = new Node(head.val);
        Node final_head = new Node(head.val);
        Node temp_head = new Node(head.val);
        final_head = c_head;
        temp_head = head;
        
        HashMap<Node,Node> hash = new HashMap<>();
        hash.put(head,c_head);
        head = head.next;

        while(head != null){
            Node temp = new Node(head.val);
            c_head.next = temp;
            c_head = c_head.next;
            hash.put(head,c_head);
            head = head.next;
            
        }

        c_head = final_head;
        head = temp_head;

        while(head != null){
            if(head.random == null){
                head = head.next;
                c_head = c_head.next;
                continue;
            }

            Node temp = new Node(c_head.val);
            temp = hash.get(head.random);
            c_head.random = temp;
            head = head.next;
            c_head = c_head.next;
        }
    return final_head;
    }
}