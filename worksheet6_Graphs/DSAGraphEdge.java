public class DSAGraphEdge {
    private String label;
    private DSAGraphVertex from;
    private DSAGraphVertex to;

    public DSAGraphEdge(DSAGraphVertex fromVertex, DSAGraphVertex toVertex, String inLabel) {
        label = inLabel;
        from = fromVertex;
        to = toVertex;
    }

    // getters
    public String getLabel() {
        return label;
    }

    public DSAGraphVertex getFrom() {
        return getFrom();
    }

    public DSAGraphVertex getTo() {
        return to;
    }

}
