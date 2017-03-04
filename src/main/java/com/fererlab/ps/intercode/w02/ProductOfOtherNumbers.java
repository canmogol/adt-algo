package com.fererlab.ps.intercode.w02;

public class ProductOfOtherNumbers {

    int[] getProductsOfAllIntsExceptAtIndex(int[] ints) {
        //    2,   3,   4,   5,   6
        //    1,   2,   6,  24,   120
        int resultLeft[] = new int[ints.length];
        int resultRight[] = new int[ints.length];
        int result[] = new int[ints.length];
        for (int i = 0; i < ints.length; i++) {
            if (i == 0) {
                resultLeft[i] = 1;
            } else {
                resultLeft[i] = resultLeft[i - 1] * ints[i - 1];
            }
            int j = ints.length - 1 - i;
            if (j == ints.length - 1) {
                resultRight[j] = 1;
            } else {
                resultRight[j] = resultRight[j + 1] * ints[j + 1];
            }
            if (resultRight[i] != 0) {
                result[i] = resultLeft[i] * resultRight[i];
            }
            if (resultLeft[j] != 0) {
                result[j] = resultLeft[j] * resultRight[j];
            }
        }
        return result;
    }

    int[] getProductsOfAllIntsExceptAtIndex_N2(int[] ints) {
        int result[] = new int[ints.length];
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] != 0 && j != i) {
                    if (result[i] == 0) {
                        result[i] = 1;
                    }
                    result[i] = result[i] * ints[j];
                }
            }
        }
        return result;
    }

}
