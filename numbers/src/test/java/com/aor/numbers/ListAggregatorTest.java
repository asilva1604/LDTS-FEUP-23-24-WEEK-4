package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {

    private List<Integer> list;
    @BeforeEach
    public void setList() {
        list = Arrays.asList(1,2,4,2,5);
    }
    @Test
    public void sum() {
        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list);

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {
        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(5, max);
    }

    @Test
    public void min() {
        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {
        ListDeduplicator d = new ListDeduplicator();
        ListAggregator aggregator = new ListAggregator();
        int distinct = aggregator.distinct(list, d);

        Assertions.assertEquals(4, distinct);
    }

    @Test
    public void max_bug_72363() {
        list = Arrays.asList(-1, -4, -5);
        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(-1, max);
    }

    @Test
    public void distinct_bug_8726() {
        ListDeduplicator d = new ListDeduplicator();
        list = Arrays.asList(1, 2, 4, 2);
        ListAggregator aggregator = new ListAggregator();
        int distinct = aggregator.distinct(list, d);

        Assertions.assertEquals(3, distinct);
    }

    @Test
    public void maxPitImprove() {
        list = Arrays.asList(15, 10, -3);
        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(15, max);
    }
}
