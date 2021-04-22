package com;

import cards.Card;
import cards.FaceOfCard;
import cards.SuitOfCard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DeckOfCards {
    private ArrayList< Card > cards;
    private int currentCard;
    private Random random; //random numbers generator
    private final int COUNT_CARDS = 52;

    public static void main(String[] args) {

        System.out.println("------Constructor:------");
        DeckOfCards deck = new DeckOfCards();
        deck.printCards(deck.cards);
        System.out.println();

        System.out.println("--------Shuffle:--------");
        deck.shuffleCards();
        deck.printCards(deck.cards);
        System.out.println();

        System.out.println("--------Deal Five:------");
        Card[] dealt = deck.dealFive();
        for (Card i : dealt) {
            System.out.println(i.toString());
        }
        System.out.println();

        System.out.println("-----Sort by face:------");
        deck.sortByFaceCards(deck.cards);
        deck.printCards(deck.cards);
        System.out.println();

        System.out.println("----Print by suit:------");
        deck.printBySuits();
        System.out.println();

        System.out.println("---Get distinct faces:--");
        List<Card> list = deck.getDistanceFaces(dealt);
        for (Card i : list) {
            System.out.println(i.toString());
        }
        System.out.println();

    }

    public DeckOfCards() {
        currentCard = 0;
        random = new Random();
        cards = new ArrayList<>();

        for (FaceOfCard.Face faceEnum : FaceOfCard.Face.values()) {
            for (SuitOfCard.Suit suitEnum : SuitOfCard.Suit.values()) {
                Card card = new Card(new FaceOfCard(faceEnum), new SuitOfCard(suitEnum));
                cards.add(card);
            }
        }
    }

    public void shuffleCards() {
        currentCard = 0;

        for (int first = 0; first < cards.size(); ++first) {
            int second = random.nextInt(cards.size());

            //swap
            Card temp = cards.get(first);
            cards.set(first, cards.get(second));
            cards.set(second, temp);
        }
    }

    public Card[] dealFive() {
        Card[] dealtFive = new Card[5];

        if (currentCard + 5 >= COUNT_CARDS) { //out of scope
            Arrays.fill(dealtFive, null);

            for (int i = currentCard; i < COUNT_CARDS; ++i) { //iterate through all cards till the end
                dealtFive[i-currentCard] = cards.get(i);
                i++;
            }
        } else {
            for (int i = currentCard; i < currentCard + 5; ++i) {
                dealtFive[i - currentCard] = cards.get(i);
            }
        }

        return dealtFive;
    }

    public void sortByFaceCards(ArrayList<Card> list) { //insertion sort
        for (int i = 1; i < list.size(); ++i) { //iterating through all elements
            Card temp = list.get(i);
            int j = i - 1;

            while (j >= 0 && (list.get(j).getFace().toInt() > temp.getFace().toInt())) { //move greater elements 1 position forward
                list.set(j+1, list.get(j));
                j--;
            }
            list.set(j+1, temp);
        }

        printCards(list);
    }

    public void printBySuits() {
        ArrayList<Card> sorted = new ArrayList<>(); //sorted array if needed

        for (SuitOfCard.Suit i : SuitOfCard.Suit.values()) { //sorting
            System.out.printf("%s :%n", i.toString()); //print name of suit
            for (Card j : cards) {
                if (j.getSuit().getSuit() == i) {
                    sorted.add(j);
                    System.out.printf("%s ", j.getFace().toString()); //print card's face
                }
            }
            System.out.println(); //newline
        }

    }

    public List<Card> getDistanceFaces(Card[] cards) {
        List<Card> distanced = new ArrayList<>();
        boolean flag = false; //is it repeated

        for (Card i : cards) {
            for (Card j : distanced) {
                if (j.getFace().toString() == i.getFace().toString()) {
                    flag = true;
                    break;
                }
            }
            if(flag == false) {
                distanced.add(i);
            }
            flag = false;
        }

        return distanced;
    }

    private void printCards (ArrayList<Card> list) {
        for (Card i : list) {
            System.out.println(i.toString());
        }
    }
}
