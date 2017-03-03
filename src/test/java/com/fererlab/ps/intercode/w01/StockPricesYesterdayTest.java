package com.fererlab.ps.intercode.w01;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StockPricesYesterdayTest {

    public static final int MIN = 5;
    public static final int MAX = 11;
    public static final int DIFF = MAX - MIN;

    private int[] stockPrices;
    private StockPricesYesterday stockPricesYesterday;

    @Before
    public void setUp() throws Exception {
        stockPricesYesterday = new StockPricesYesterday();
    }

    @Test
    public void testGetMaxProfit_success() throws Exception {
        stockPrices = new int[]{10, 7, MIN, 8, MAX, 9};
        int maxProfit = stockPricesYesterday.getMaxProfit(stockPrices);
        assertThat(maxProfit, is(DIFF));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetMaxProfit_fail() throws Exception {
        stockPricesYesterday.getMaxProfit(new int[]{});
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetMaxProfitMin_success() throws Exception {
        stockPrices = new int[]{MIN};
        int maxProfit = stockPricesYesterday.getMaxProfit(stockPrices);
        assertThat(maxProfit, is(0));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetMaxProfitMax_success() throws Exception {
        stockPrices = new int[]{MAX};
        int maxProfit = stockPricesYesterday.getMaxProfit(stockPrices);
        assertThat(maxProfit, is(0));
    }

    @Test
    public void testGetMaxProfitMinMax_success() throws Exception {
        stockPrices = new int[]{MIN, MAX};
        int maxProfit = stockPricesYesterday.getMaxProfit(stockPrices);
        assertThat(maxProfit, is(DIFF));
    }

    @Test
    public void testGetMaxProfitMaxMin_success() throws Exception {
        stockPrices = new int[]{MAX, MIN};
        int maxProfit = stockPricesYesterday.getMaxProfit(stockPrices);
        assertThat(maxProfit, is(0));
    }

}
