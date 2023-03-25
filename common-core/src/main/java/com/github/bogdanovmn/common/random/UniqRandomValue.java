package com.github.bogdanovmn.common.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class UniqRandomValue<T>{
    private final ArrayList<T> values;
    private int maxIndex;

    public UniqRandomValue(T... values) {
        this(Arrays.asList(values));
    }

    public UniqRandomValue(Collection<T> values) {
        if (values.isEmpty()) {
            throw new IllegalArgumentException("Not empty collection is expecting");
        }
        this.values = new ArrayList<>(values);
        this.maxIndex = this.values.size() - 1;
    }

    public T next() {
        if (values.size() == 1) {
            return values.get(0);
        }
        int index = randomInRange(0, maxIndex);
        T value = values.get(index);
        swapElementWithLast(index);
        maxIndex--;

        if (maxIndex < 0) {
            maxIndex = values.size() - 1;
        }

        return value;
    }

    private void swapElementWithLast(int index) {
        T value = values.get(index);
        T lastItem = values.get(maxIndex);
        values.set(maxIndex, value);
        values.set(index, lastItem);
    }

    private int randomInRange(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
