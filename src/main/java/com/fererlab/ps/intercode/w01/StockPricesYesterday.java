package com.fererlab.ps.intercode.w01;

public class StockPricesYesterday {

    public int getMaxProfit(int[] stockPricesYesterday) {
        int min = stockPricesYesterday[0];
        int max = stockPricesYesterday[1];
        for (int i = 0; i < stockPricesYesterday.length - 1; i++) {
            min = Math.min(min, stockPricesYesterday[i]);
            max = Math.max(max, stockPricesYesterday[i + 1]);
        }
        return (max - min > 0 ? max - min : 0);
    }

}
