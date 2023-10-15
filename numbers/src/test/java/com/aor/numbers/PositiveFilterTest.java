package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositiveFilterTest {
    @Test
    public void test1() {
        PositiveFilter filter = new PositiveFilter();
        Assertions.assertTrue(filter.accept(2));
    }

    @Test
    public void test2() {
        PositiveFilter filter = new PositiveFilter();
        Assertions.assertTrue(filter.accept(999999999));
    }

    @Test
    public void test3() {
        PositiveFilter filter = new PositiveFilter();
        Assertions.assertFalse(filter.accept(0));
    }

    @Test
    public void test4() {
        PositiveFilter filter = new PositiveFilter();
        Assertions.assertFalse(filter.accept(-10));
    }
}
