package com.daelly.common.guava;

import com.google.common.graph.GraphBuilder;
import com.google.common.graph.ImmutableGraph;
import org.junit.jupiter.api.Test;

public class GraphsTests {

    @Test
    public void basicGraph() {
        ImmutableGraph<Integer> graph = GraphBuilder.directed()
                .<Integer>immutable()
                .addNode(1)
                .putEdge(2, 3)
                .putEdge(3, 4)
                .putEdge(2, 5)
                .putEdge(3, 6)
                .putEdge(4, 6)
                .putEdge(6, 5)
                .build();

        System.out.println(graph.adjacentNodes(6));
    }
}
