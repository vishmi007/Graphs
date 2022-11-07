import java.util.*;
import java.io.*;

public class TestHarness {
    public static void main(String args[]) throws Exception {

        testOne();
        Scanner sc = new Scanner(System.in);
        String fileName = "";
        System.out.println("please enter the name of the file that you want to read");
        fileName = sc.nextLine();
        DSAGraph getGraph = readFile(fileName);
        // addingEdges(fileName, getGraph);

    }

    public static void testOne() {
        DSAGraph graph = new DSAGraph();
        graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");
        graph.addVertex("c");
        graph.addEdge("a", "b");
        graph.addEdge("a", "c");
        graph.addEdge("a", "d");
        graph.addEdge("b", "a");
        graph.displayAsList();
    }

    public static DSAGraph readFile(String pFileName) {
        DSAGraph read = new DSAGraph();

        FileInputStream fileStream = null;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        int lineNum;
        String line;
        try {
            fileStream = new FileInputStream(pFileName);

            rdr = new InputStreamReader(fileStream);
            bufRdr = new BufferedReader(rdr);
            lineNum = 0;

            // bufRdr.readLine();
            line = bufRdr.readLine();

            while (line != null) {
                lineNum++;
                String[] splitLine;
                splitLine = line.split(",");

                {
                    read.addVertex(splitLine[0]);
                    read.addEdge(splitLine[1], splitLine[0]);
                }

                line = bufRdr.readLine();
            }

            fileStream.close();
            // read.displayAsList();

        } catch (IOException errorDetails) {
            if (fileStream != null) {
                try {
                    fileStream.close();
                } catch (IOException ex2) {
                }
            }
            System.out.println("Error in fileProcessing: " + errorDetails.getMessage());
            System.out.println("Sorry we could not find the file you are reffering to");
        }

        read.displayAsList();
        return read;
    }

    public static void addingEdges(String pFileName, DSAGraph pGraph) {
        // DSAGraph read = new DSAGraph();
        // pGraph.displayAsList();
        FileInputStream fileStream = null;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        int lineNum;
        String line;
        try {
            fileStream = new FileInputStream(pFileName);

            rdr = new InputStreamReader(fileStream);
            bufRdr = new BufferedReader(rdr);
            lineNum = 0;

            // bufRdr.readLine();
            line = bufRdr.readLine();

            while (line != null) {
                lineNum++;
                String[] splitLine;
                splitLine = line.split(",");

                {
                    // read.addVertex(splitLine[0]);
                    pGraph.addEdge(splitLine[1], splitLine[0]);
                }

                line = bufRdr.readLine();
            }

            fileStream.close();
            // read.displayAsList();

        } catch (IOException errorDetails) {
            if (fileStream != null) {
                try {
                    fileStream.close();
                } catch (IOException ex2) {
                }
            }
            System.out.println("Error in fileProcessing: " + errorDetails.getMessage());
            System.out.println("Sorry we could not find the file you are reffering to");
        }

        pGraph.displayAsList();
    }

}
