package com.adobe.prj.orderapp.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayUtilTest {

    @Test
    public void testGetSum() {
        int [] sample = {4,5,1,2,6};
        int expected = 18;
        int actual = ArrayUtil.getSum(sample);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetOccurence() {
        int[] sample = {4,5,1,4,2,4};
        int expected = 3;
        int actual = ArrayUtil.getOccurence(sample,4);
        assertEquals(expected, actual);
    }

    @Test
    public void testSort() {
        int [] sample = {4,5,1,2,6};
        ArrayUtil.sort(sample);
        int expected[] = {1,2,4,5,6};
        assertArrayEquals(expected, sample);
    }
}
