package com.mtur.dsa.graph;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class Graph {
    public int MAX_VERTICES = 100;

    private EdgeNode[] vertexEdges; // array of edges starting from this vertex (sourceIndex)
    private int[] vertexDegree; // amount of edges for the vertex.
    private int nVertices; // Vertex count
    private boolean isDirected;

    // Constructor for the case when we know how many vertices in the graph.
    public Graph(int nVertices, boolean isDirected) {
        this.nVertices = nVertices;
        this.isDirected = isDirected;
        this.vertexEdges = new EdgeNode[nVertices];
        this.vertexDegree = new int[nVertices];

        log.info("Constructed graph of {} vertices.", nVertices);
    }

    // Constructor for the case when we don't know the graph size - e.g. when reading from a stream.
    public Graph(boolean isDirected) {
        this.isDirected = isDirected;

        this.vertexEdges = new EdgeNode[MAX_VERTICES];
        this.vertexDegree = new int[MAX_VERTICES];
        this.nVertices = 0;

        log.info("Constructed graph with up to {} vertices", MAX_VERTICES);
    }

    public void addEdge(int srcIndex, int dstIndex) {
        addEdge(srcIndex, dstIndex, EdgeNode.DEFAULT_WEIGHT);
    }

    public void addEdge(int srcIndex, int dstIndex, int weight) {
        addEdgeInternal(srcIndex, dstIndex, weight);
        if (!isDirected) { // add opposite edge in case on undirected graph.
            addEdgeInternal(dstIndex, srcIndex, weight);
        }
    }

    public void addEdgeInternal(int srcIndex, int dstIndex, int weight) {
        if (srcIndex >= vertexEdges.length || dstIndex >= vertexEdges.length) {
            throw new IllegalArgumentException("Desired index for edge vertices is outside of vertices count.");
        }

        EdgeNode node = vertexEdges[srcIndex];
        if (node == null) {
            node = new EdgeNode(srcIndex, dstIndex, weight);
            vertexEdges[srcIndex] = node;
        } else {
            node.addNextEdge(dstIndex, weight);
        }

        vertexDegree[srcIndex]++;
    }

    @Override
    public String toString() {
        return "{" +
                "isDirected=" + isDirected +
                ", nVertices=" + nVertices +
                ", vertexEdges=" + Arrays.toString(vertexEdges) +
                ", vertexDegree=" + Arrays.toString(vertexDegree) +
                '}';
    }
}
