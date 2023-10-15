package com.aor.numbers;

public class DivisibleFilter implements GenericListFilter{
    private final int num;

    public DivisibleFilter(int num) {
        this.num = num;
    }
    @Override
    public boolean accept(Integer number) {
        return number % num == 0;
    }
}
