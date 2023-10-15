package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListFiltererTest {
    private List<Integer> list;

    @BeforeEach
    public void generateList() {
        list = Arrays.asList(0, 3, 4, -10, -2, -9);
    }

    @Test
    public void test1() {
        GenericListFilter filter = new PositiveFilter();
        ListFilterer filterer = new ListFilterer(filter);
        List<Integer> expected = Arrays.asList(3, 4);
        Assertions.assertEquals(expected, filterer.filter(list));
    }

    @Test
    public void test2() {
        GenericListFilter filter = new DivisibleFilter(2);
        ListFilterer filterer = new ListFilterer(filter);
        List<Integer> expected = Arrays.asList(0, 4, -10, -2);
        Assertions.assertEquals(filterer.filter(list), expected);
    }
    @Test
    public void test3() {
        GenericListFilter divisibleFilter = new DivisibleFilter(2);
        GenericListFilter positiveFilter = new PositiveFilter();
        ListFilterer filterer = new ListFilterer(divisibleFilter);
        list = filterer.filter(list);
        filterer = new ListFilterer(positiveFilter);
        list = filterer.filter(list);
        List<Integer> expected = Arrays.asList(4);
        Assertions.assertEquals(expected, list);
    }
}
