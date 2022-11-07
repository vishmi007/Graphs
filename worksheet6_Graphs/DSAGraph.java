import java.util.*;

public class DSAGraph implements Iterable {

    private DSALinkedList vertices;
    private int edgeCount;

    public DSAGraph() {
        vertices = new DSALinkedList();
    }

    public DSAGraphVertex addVertex(String inLabel) {
        DSAGraphVertex newVertex = new DSAGraphVertex(inLabel);

        // System.out.println(newVertex.getLabel());
        if (findLabel(newVertex.getLabel()) == null) {
            vertices.insertLast(newVertex);

        }
        return newVertex;

    }

    public void addEdge(String labelOne, String labelTwo) {
        // DSAGraphVertex ver1 = new DSAGraphVertex(labelOne);
        // DSAGraphVertex ver2 = new DSAGraphVertex(labelTwo);

        DSAGraphVertex label1 = getVertex(labelOne);
        DSAGraphVertex label2 = getVertex(labelTwo);

        if (label1 == null) {
            addVertex(labelOne);
        }
        if (label2 == null) {
            addVertex(labelTwo);
        }

        DSAGraphVertex fromVertex = getVertex(labelOne);
        DSAGraphVertex toVertex = getVertex(labelTwo);
        fromVertex.addEdge(toVertex);
        toVertex.addEdge(fromVertex);

        // if ((findLabel(toVertex.getLabel())) == null)
        Iterator<DSAGraphVertex> iter = vertices.iterator();

        // while (iter.hasNext()) {
        // DSAGraphVertex vertex = iter.next();
        // if (!vertices.equals(fromVertex) && !vertices.equals(toVertex)) {
        // fromVertex.addEdge(toVertex);
        // toVertex.addEdge(fromVertex);
        // }

        // }
        edgeCount++;

    }

    // public void addEdge(DSAGraphNode ver1, DSAGraphNode ver2) {
    // ver1 = labFind(ver1.getLabel());
    // ver2 = labFind(ver2.getLabel());
    // DSAGraphEdge edge = ver1.getEdge(ver2.getLabel());

    // if (edge == null) {
    // edge = new DSAGraphEdge(ver1, ver2);
    // }

    // ver1.addEdge(ver2, edge);
    // ver2.addEdge(ver1, edge);

    // }

    public boolean hasVertex(String inLabel) {
        boolean flag = false;
        for (Object e : vertices) {
            DSAListNode node = (DSAListNode) e;
            DSAGraphVertex vertex = (DSAGraphVertex) node.getValue();

            if (inLabel.equals(vertex.getLabel())) {
                flag = true;
            }

        }

        return flag;

    }

    public int getVertexCount() {
        return vertices.getCount();
    }

    public int getEdgeCount() {
        return edgeCount;

    }

    public DSAGraphVertex getVertex(String inLabel) {
        Iterator<DSAGraphVertex> iterator = vertices.iterator();
        DSAGraphVertex nodes = null;
        while (iterator.hasNext()) {
            DSAGraphVertex node = iterator.next();
            if (inLabel.equals(node.getLabel())) {
                nodes = node;
            }
        }

        return nodes;

    }

    public DSALinkedList getAdjacent(String inLabel) {
        DSALinkedList adjacent = null;
        Iterator<DSAGraphVertex> dSAGraphVertexIterator = getVertex(inLabel).getAdjacent().iterator();
        while (dSAGraphVertexIterator.hasNext()) {
            if (dSAGraphVertexIterator.next().equals(getVertex(inLabel))) {
                adjacent = getVertex(inLabel).getAdjacent();
            }
        }

        return adjacent;
    }

    public boolean isAdjacent(DSAGraphVertex nodeOne, DSAGraphVertex nodeTwo) {
        boolean flag = false;
        Iterator<DSAGraphVertex> iter = nodeOne.getAdjacent().iterator();
        while (iter.hasNext()) {
            DSAGraphVertex node = iter.next();
            if (nodeOne.getLabel() == nodeTwo.getLabel()) {
                flag = true;
            }
        }

        return flag;

    }

    public void displayAsList() {
        Iterator<DSAGraphVertex> iterator = vertices.iterator();
        while (iterator.hasNext()) {
            DSAGraphVertex vertex = iterator.next();
            System.out.print(" Vertex " + vertex.getLabel() + " is connected to ");
            vertex.display();
        }
    }

    private DSAGraphVertex findLabel(String inLabel) {
        Iterator<DSAGraphVertex> iter = vertices.iterator();
        DSAGraphVertex newVertex = null;

        while (iter.hasNext()) {
            DSAGraphVertex vertex = iter.next();
            if (inLabel.equals((vertex.getLabel()))) {
                newVertex = vertex;
            }
        }

        return newVertex;
    }

    public Iterator iterator() {
        return this.iterator();
    }

}
