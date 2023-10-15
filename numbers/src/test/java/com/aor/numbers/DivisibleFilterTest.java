package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class DivisibleFilterTest {
    @Test
    public void test1() {
        DivisibleFilter filter = new DivisibleFilter(2);
        boolean res = filter.accept(4);
        Assertions.assertTrue(res);
    }

    @Test
    public void test2() {
        DivisibleFilter filter = new DivisibleFilter(2);
        boolean res = filter.accept(5);
        Assertions.assertFalse(res);
    }

    @Test
    public void test3() {
        DivisibleFilter filter = new DivisibleFilter(2);
        boolean res = filter.accept(-4);
        Assertions.assertTrue(res);
    }

    @Test
    public void test4() {
        DivisibleFilter filter = new DivisibleFilter(-3);
        boolean res = filter.accept(9);
        Assertions.assertTrue(res);
    }
}
