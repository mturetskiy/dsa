package com.mtur.dsa.graph;

import lombok.Data;

@Data
public class EdgeNode {
    public static final int DEFAULT_WEIGHT = 1;

    private int srcIndex;
    private int destIndex; // sourceIndex is position of this edgeNode in the  edges array of the Graph.
    private int weight;
    private EdgeNode next; // if there are other edges from this vertex

    public EdgeNode(int srcIndex, int destIndex, int weight) {
        this.srcIndex = srcIndex;
        this.destIndex = destIndex;
        this.weight = weight;
    }

    public EdgeNode(int srcIndex, int destIndex) {
        this(srcIndex, destIndex, DEFAULT_WEIGHT);
    }

    public EdgeNode addNextEdge(int destIndex, int weight) {
        EdgeNode nextNode = new EdgeNode(this.srcIndex, destIndex, weight);
        this.next = nextNode;
        return nextNode;
    }

    public EdgeNode addNextEdge(int destIndex) {
        return addNextEdge(destIndex, DEFAULT_WEIGHT);
    }

    @Override
    public String toString() {
        return "{" +
                "destIndex=" + destIndex +
                ", has next=" + (next != null) +
                '}';
    }
}
