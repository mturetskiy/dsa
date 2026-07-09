package com.mtur.dsa.graph;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.util.List;

@Slf4j
public class GraphOperations {
    public static Graph readGraph(String fileName) {
        log.info("Loading graph from file: {}", fileName);
        List<String> lines = IOUtils.readLines(GraphOperations.class.getResourceAsStream("/" + fileName));
        if (lines.isEmpty()) {
            throw new IllegalArgumentException("No lines found in the file: " + fileName);
        }

        String header = lines.get(0);
        String[] headerValues = header.split(" ");
        if (headerValues.length != 2) {
            throw new IllegalArgumentException("Bad graph file format. Expected 2 values in header");
        }

        int nVertices = Integer.parseInt(headerValues[0]);
        boolean isDirected = Boolean.parseBoolean(headerValues[1]);

        Graph graph = new Graph(nVertices, isDirected);

        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] edgeValues = line.split(" ");
            if (edgeValues.length != 2) {
                throw new IllegalArgumentException("Bad graph file format. Expected 2 values for edge at pos: " + i);
            }

            int srcVertexNum = Integer.parseInt(edgeValues[0]);
            int dstVertexNum = Integer.parseInt(edgeValues[1]);
            // VertexNum in file is 1-based, where VertexIndex in array is 0-based.
            graph.addEdge(srcVertexNum - 1, dstVertexNum - 1);
        }

        return graph;
    }

    public static void main(String[] args) {
        Graph graph = GraphOperations.readGraph("graph1.csv");
        log.info("Loaded graph: {}", graph);
    }
}
