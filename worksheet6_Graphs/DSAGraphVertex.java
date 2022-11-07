import java.util.*;;

public class DSAGraphVertex implements Iterable {
    private String label;
    private DSALinkedList links;
    private boolean visited;

    public DSAGraphVertex(String inLabel) {
        label = inLabel;
        links = new DSALinkedList();
        visited = false;
    }

    // getters.
    public String getLabel() {
        return label;
    }

    public DSALinkedList getAdjacent() {
        return links;
    }

    public boolean getVisited() {
        return visited;
    }

    // Setters

    public void setVisited() {
        visited = true;
    }

    public void clearVisited() {
        visited = false;
    }

    /******************************************************
     * Name : addEdge Import : node (DSAGraphVertex) Export : None purpose : To add
     * an edge to the graph.
     */

    public void addEdge(DSAGraphVertex node) {
        if (links.find(node) == null) {
            links.insertLast(node);
        }

    }

    public void display() {
        Iterator<DSAGraphVertex> iter = links.iterator();
        while (iter.hasNext()) {
            DSAGraphVertex links = iter.next();
            System.out.print(links.getLabel());

            if (iter.hasNext()) {
                System.out.print(",");

            }
        }

        System.out.println(" \n ");
    }

    public Iterator iterator() {
        return this.iterator();
    }

}
