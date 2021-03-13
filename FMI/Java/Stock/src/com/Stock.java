package com;

public class Stock {
    private final String symbol; //the symbol of the stock
    private final String name; //the name of the stock
    private double previousClosingPrice; //the previous closing prise of this stock
    private double currentPrice; //the current price of the stock

    //constructs a stock withs a specified symbol and name
    public Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
        setCurrentPrice(0);
        setPreviousClosingPrice(0);
    }

    //returns the symbol of the stock
    public String getSymbol() {
        return symbol;
    }

    //returns the name of the stock
    public String getName() {
        return name;
    }

    //returns the previous closing price of the stock
    public double getPreviousClosingPrice() {
        return previousClosingPrice;
    }

    //returns the current price of the stock
    public double getCurrentPrice() {
        return currentPrice;
    }

    //sets the previous closing price of this stock
    public void setPreviousClosingPrice(double price) {
        //if the price is either negative number or zero it's assigned to 0
        if (price > 0)
            previousClosingPrice = price;
        else
            previousClosingPrice = 0;
    }

    //sets the current price of this stock
    public void setCurrentPrice(double price) {
        //if the price is either negative number or zero it's assigned to 0
        if (price > 0)
            currentPrice = price;
        else
            currentPrice = 0;
    }

    //returns the percentage of change of this stock
    public double changePercent() {
        if (previousClosingPrice != 0) {
            return ((currentPrice - previousClosingPrice) / previousClosingPrice); //normally to get the percentage this has to be multiplied by 100,
                                                                                   //but we are getting a fractional number, so it's not needed
                                                                                   //ex. : 50% = 0.5
        } else
            return 0; //default return value when the previous closing price is equal to 0

    }
}
