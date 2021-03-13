package com;

public class StockTest {
    public static void main(String[] args) {
        Stock stockDefault = new Stock("a", "stock1"); //creating default stock with chosen symbol and name

        //setting valid values
        stockDefault.setPreviousClosingPrice(1.23);
        stockDefault.setCurrentPrice(7.89);

        System.out.printf("1. Data for the Stock:\n Symbol: %s\n Name: %s\n Previous closing price: %.2f\n Current price: %.2f\n Percentage change: %.4f\n",
                stockDefault.getSymbol(), stockDefault.getName(), stockDefault.getPreviousClosingPrice(), stockDefault.getCurrentPrice() ,stockDefault.changePercent());


        //setting invalid values (so they get the default value "0")
        stockDefault.setPreviousClosingPrice(-100);
        stockDefault.setCurrentPrice(-12.5);

        System.out.printf("\n2. Data for the Stock:\n Symbol: %s\n Name: %s\n Previous closing price: %.0f\n Current price: %.0f\n Percentage change: %.0f\n",
                stockDefault.getSymbol(), stockDefault.getName(), stockDefault.getPreviousClosingPrice(), stockDefault.getCurrentPrice() ,stockDefault.changePercent());


        //setting previous closing price to be 0 (so the percentage change is "0")
        stockDefault.setPreviousClosingPrice(0);
        stockDefault.setCurrentPrice(12.5);

        System.out.printf("\n3. Data for the Stock:\n Symbol: %s\n Name: %s\n Previous closing price: %.0f\n Current price: %.2f\n Percentage change: %.0f\n",
                stockDefault.getSymbol(), stockDefault.getName(), stockDefault.getPreviousClosingPrice(), stockDefault.getCurrentPrice() ,stockDefault.changePercent());

    }
}
