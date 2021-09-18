package LinkedList2;
import LinkedList.LinkedList;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LinkedList2 myLL2 = new LinkedList2();

        Node firstNode = new Node(23);
        Node secondNode = new Node(24);
        Node thirdNode= new Node(22);
        Node fourthNode = new Node(22);
        Node fifthNode = new Node(22);
        Node sixthNode = new Node(22);
        Node seventhNode = new Node(23);
        Node eighthNode = new Node(23);
//
//        Node firstNodeForInsertInHead = new Node(666);
//        Node secondNodeForInsertInHead = new Node(666);
//        Node firstNodeForInsertInMiddle = new Node(666);
//        Node secondNodeForInsertInMiddle = new Node(666);
//        Node firstNodeForInsertInEnd= new Node(666);
//        Node secondNodeForInsertInEnd = new Node(666);
//
//        myLL2.insertAfter(null, firstNodeForInsertInHead);
        myLL2.addInTail(firstNode);
        myLL2.addInTail(secondNode);
        myLL2.addInTail(thirdNode);
//        myLL2.addInTail(fourthNode);
//        myLL2.addInTail(fifthNode);
//        myLL2.addInTail(sixthNode);
//        myLL2.addInTail(seventhNode);
//        myLL2.addInTail(eighthNode);
//        myLL2.insertAfter(firstNodeForInsertInHead, secondNodeForInsertInHead);
//        myLL2.insertAfter(fourthNode, firstNodeForInsertInMiddle);
//        myLL2.insertAfter(firstNodeForInsertInMiddle,secondNodeForInsertInMiddle);
//        myLL2.insertAfter(seventhNode,firstNodeForInsertInEnd);
//        myLL2.insertAfter(firstNodeForInsertInEnd,secondNodeForInsertInEnd);
//        myLL2.removeAll(23);
//        myLL2.removeAll(24);
//        myLL2.removeAll(23);
//
//        ArrayList<Node> list = myLL2.findAll(22);
//        ArrayList<Node> list = myLL2.findAll(22);
//        for (Node x :  list) {
//            System.out.println(x.value);
//        }
//        myLL2.removeAll(22);
        Node c = myLL2.head;
        while (c!=null) {
            System.out.println(c.value);
            c = c.next;
        }
    }
}