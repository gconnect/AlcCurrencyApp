package com.gconnect.alccurrencyapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class exchangeRate {

    ArrayList<MoneyRate> ratesArrayList = new ArrayList<>(); //contains all 20 monies and their btc & eth rates

    exchangeRate() {}

    //Method to populate the ratesArrayList
    void add(String currency, Double btcRate, Double ethRate) {
        MoneyRate moneyRate = new MoneyRate(currency, btcRate, ethRate);
        ratesArrayList.add(moneyRate);
    }

    //This method sorts the ratesArrayList alphabetically OR by the currencies' values in BTC
    //...since BTC and ETH maintain a constant rate across all currencies
    void orderList(final int mode) {
        Collections.sort(ratesArrayList, new Comparator<MoneyRate>() {
            @Override
            public int compare(MoneyRate lhs, MoneyRate rhs) {
                if(mode == Constants.ORDER_ALPHABETICAL)return lhs.getCurrency().compareTo(rhs.getCurrency());
                else return Double.compare(lhs.getBtcRate(), rhs.getBtcRate());
            }
        });
    }

    //Custom class carries name of currency and its BTC and ETH rates and methods to return these properties
    class MoneyRate{
        private String currency;
        private double btcRate, ethRate;

        MoneyRate(String currency, double btcRate, double ethRate) {
            this.currency = currency;
            this.btcRate = btcRate;
            this.ethRate = ethRate;
        }

        String getCurrency() {
            return currency;
        }

        double getBtcRate() {
            return btcRate;
        }

        double getEthRate() {
            return ethRate;
        }
    }

}