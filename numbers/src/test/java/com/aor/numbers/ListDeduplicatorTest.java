package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {

    private List<Integer> list;
    private List<Integer> expected;

    @BeforeEach
    public void setList() {
        list = Arrays.asList(1,2,4,2,5);
        expected = Arrays.asList(1,2,4,5);
    }

    @Test
    public void deduplicate() {
        list = Arrays.asList(1,2,4,2,5);
        expected = Arrays.asList(1,2,4,5);

        ListSorter s = new ListSorter();

        ListDeduplicator deduplicator = new ListDeduplicator();
        List<Integer> distinct = deduplicator.deduplicate(list, s);

        Assertions.assertEquals(expected, distinct);
    }

    @Test
    public void deduplicate2() {
        list = Arrays.asList(1,2,4,2);
        expected = Arrays.asList(1,2,4);

        ListSorter s = new ListSorter();

        ListDeduplicator deduplicator = new ListDeduplicator();
        List<Integer> distinct = deduplicator.deduplicate(list, s);

        Assertions.assertEquals(expected, distinct);
    }
}
