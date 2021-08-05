package com.vishal.linkedlist;

public class ReverseAlternateKSizeElement {

    public static SinglyNode reverse(SinglyNode head, int k) {
        if(head == null || head.next == null || k == 1){
            return head;
        }
        SinglyNode curr = head;
        SinglyNode prev = head;
        SinglyNode start = null;
        SinglyNode justPrev = null;
        SinglyNode kStart = null;
        SinglyNode temp = null;
        int size = 0;
        int n = 0;
        while(curr != null){
            curr = curr.next;
            size++;
        }
        curr = head;

        while(curr != null){

            if(size >= k){

                if(n % 2 == 0){
                    for(int i = 0; i < k; i++){
                        temp = curr.next;
                        curr.next = justPrev;
                        justPrev = curr;
                        curr = temp;
                    }
                    if(start == null){
                        start = justPrev;
                    }

                    if(kStart != null){
                        prev.next = justPrev;
                        prev = kStart;
                    }
                    kStart = curr;
                    justPrev = null;
                    n++;
                }else{
                    prev.next = kStart;
                    prev = kStart;
                    for(int i = 0; i < k; i++){
                        justPrev = curr;
                        curr = curr.next;
                    }
                    prev = justPrev;
                    kStart = curr;
                    n++;
                }

                size -= k;

            }else{
                prev.next = curr;
                break;
            }

        }
        return start;
    }

}
