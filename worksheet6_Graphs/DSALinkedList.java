
/*********************************************************
 * Author: Vishmi Kalansooriya                               
 * Date:  31st August 2021                                    
 * Purpose: Implementing a Linked list              
 *********************************************************************************************************/
import java.io.*;
import java.util.*;

public class DSALinkedList implements Iterable, Serializable

{

    public class DSAListNode implements Serializable {
        private Object m_Value;
        private DSAListNode Next;
        private DSAListNode previous;

        public DSAListNode(Object inValue) {
            m_Value = inValue;
            Next = null;
            previous = null;

        }

        // setters
        public void setValue(Object pValue) {
            m_Value = pValue;
        }

        public void setNext(DSAListNode newNext) {
            Next = newNext;
        }

        public void setPrevious(DSAListNode newPrevious) {
            previous = newPrevious;
        }

        // getters
        public Object getValue() {
            return m_Value;
        }

        public DSAListNode getNext() {
            return Next;
        }

        public DSAListNode getPrevious() {
            return previous;
        }

    }

    // Fields
    private DSAListNode head;
    private DSAListNode tail;

    // Default cunstructor.
    public DSALinkedList() {
        head = null; // Both the head and the tail are null at the begining because there are no
                     // links at the very first.
        tail = null;
    }

    /*********************************************************
     * Method name : isEmpty Import :None Export : None Purpose: To check if the
     * linkedlist is empty
     *********************************************************************************************************/
    public boolean isEmpty() {

        return (head == null);
    }

    /*********************************************************
     * Method name : insertFirst Import :pValue (Object) Export : None Purpose: To
     * insert a node as the first link of the linkedList.
     *********************************************************************************************************/
    public void insertFirst(Object pValue) {
        DSAListNode newLink = new DSAListNode(pValue);
        if (isEmpty()) {
            head = newLink;
            tail = newLink;
            head.previous = null;
            tail.Next = null;
        } else {
            head.previous = newLink;
            newLink.Next = head;
            newLink.previous = null;
            head = newLink;
        }

    }

    /*********************************************************
     * Method name : insertFirst Import :pValue (Object) Export : None Purpose: To
     * insert a node at the end of the linkedList.
     *********************************************************************************************************/
    public void insertLast(Object pValue) {
        DSAListNode newLink = new DSAListNode(pValue);
        if (isEmpty()) {
            head = newLink;
            tail = newLink;
            head.previous = null;
            tail.Next = null;

        } else {
            tail.Next = newLink;
            newLink.previous = tail;
            tail = newLink;
            tail.Next = null;
        }

    }

    /*********************************************************
     * Method name : peekFirst Import :NONE Export : nodeValue Purpose: To see the
     * Object node at the begining of the linkedList.
     *********************************************************************************************************/
    public Object peekFirst() throws Exception {
        Object nodeValue = 0;
        if (isEmpty()) {
            throw new Exception(" Sorry !The linkedList is empty.");
        } else {
            nodeValue = head.getValue();
        }

        return nodeValue;
    }

    /*********************************************************
     * Method name : peekFirst Import :NONE Export : nodeValue Purpose: To see the
     * node at the end of the linkedList.
     *********************************************************************************************************/
    public Object peekLast() throws Exception {
        Object nodeValue = 0;
        if (isEmpty()) {
            throw new Exception(" Sorry !The linkedList is empty.");
        } else {
            nodeValue = tail.getValue();
        }

        return nodeValue;
    }

    /*********************************************************
     * Method name : peekFirst Import :NONE Export : nodeValue Purpose: To remove
     * the node at the begining of the linkedList.
     *********************************************************************************************************/
    public Object removeFirst() throws Exception {
        Object nodeValue = head.getValue();
        if (isEmpty()) {
            throw new Exception(" Sorry !The linkedList is empty.");

        } else {

            if (head != tail) {
                head = head.getNext();

            } else {
                head = null;
                tail = null;
            }

        }
        return nodeValue;
    }

    /*********************************************************
     * Method name : peekFirst Import :NONE Export : nodeValue Purpose: To remove
     * the node at the end of the linkedList.
     *********************************************************************************************************/
    public Object removeLast() throws Exception {
        Object nodeValue = tail.getValue();
        if (isEmpty()) {
            throw new Exception(" Sorry !The linkedList is empty.");

        } else {

            if (head != tail) {
                tail = tail.getPrevious();

            } else {
                head = null;
                tail = null;
            }

        }

        return nodeValue;
    }

    public Iterator iterator() {
        // System.out.println("halo " + this);

        return new DSALinkedListIterator(this);
    }

    private class DSALinkedListIterator implements Iterator {

        private DSAListNode iterNext;

        public DSALinkedListIterator(DSALinkedList theList) {
            iterNext = theList.head;

        }

        /*********************************************************
         * Method name : hasNext Import :NONE Export : None Purpose: To check whther
         * their is a node next.
         *********************************************************************************************************/
        public boolean hasNext() {
            return (iterNext != null);
        }

        /*********************************************************
         * Method name : next Import :NONE Export : value Purpose: To keep the iter at
         * the current value.
         *********************************************************************************************************/
        public Object next() {
            Object value;
            if (iterNext == null) {
                value = null;
            } else {
                value = iterNext.getValue();
                iterNext = iterNext.getNext();
            }
            return value;
        }

        public void remove() {
            throw new UnsupportedOperationException("Not supported");
        }

    }

    public static void save(DSALinkedList objToSave, String fileName) {
        FileOutputStream fileStrm;
        ObjectOutputStream objStrm;

        try {
            fileStrm = new FileOutputStream(fileName);
            objStrm = new ObjectOutputStream(fileStrm);
            objStrm.writeObject(objToSave);

            objStrm.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    public static DSALinkedList load(String fileName) throws IllegalArgumentException {
        FileInputStream fileStrm;
        ObjectInputStream objStrm;
        DSALinkedList inObject = null;

        try {
            fileStrm = new FileInputStream(fileName);
            objStrm = new ObjectInputStream(fileStrm);
            inObject = (DSALinkedList) objStrm.readObject();
            objStrm.close();
        } catch (ClassNotFoundException error) {
            System.out.println(" Class DSALinkedList class not found" + error);

        } catch (Exception error) {
            throw new IllegalArgumentException("Unable to load the object from the file." + error.getMessage());
        }

        return inObject;

    }

    public DSAListNode find(Object inValue) {
        DSAListNode node = recFind(head, inValue);

        return node;
    }

    private DSAListNode recFind(DSAListNode node, Object inValue) {
        DSAListNode found;

        if (node == null) // The base case.
        {
            found = null;
        } else if (node.getValue() == inValue) // second base case
        {
            found = node;
        } else {
            found = recFind(node.getNext(), inValue); // recurse.
        }

        return found;

    }

    public int getCount() {
        return recCount(head);
    }

    private int recCount(DSAListNode node) {
        int i = 1;
        if (node == null) {
            i = 0;
        } else if (node.getNext() != null) {
            i = 1 + recCount(node.getNext());
        }

        return i;
    }

}
