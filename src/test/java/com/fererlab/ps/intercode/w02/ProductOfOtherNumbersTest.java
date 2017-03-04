package com.fererlab.ps.intercode.w02;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ProductOfOtherNumbersTest {

    private ProductOfOtherNumbers productOfOtherNumbers;

    @Before
    public void setUp() throws Exception {
        productOfOtherNumbers = new ProductOfOtherNumbers();
    }

    @Test
    public void testGetProductsOfAllIntsExceptAtIndex() throws Exception {
        int[] ints = productOfOtherNumbers.getProductsOfAllIntsExceptAtIndex(new int[]{1, 7, 3, 4});
        assertArrayEquals(ints, new int[]{84, 12, 28, 21});
    }

    @Test
    public void testGetProductsOfAllIntsExceptAtIndex_N2() throws Exception {
        int[] ints = productOfOtherNumbers.getProductsOfAllIntsExceptAtIndex_N2(new int[]{1, 7, 3, 4});
        assertArrayEquals(ints, new int[]{84, 12, 28, 21});
    }

}