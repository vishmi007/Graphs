import java.util.*;
import java.io.*;

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