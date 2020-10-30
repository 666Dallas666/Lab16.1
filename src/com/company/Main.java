package com.company;
import java.util.ArrayDeque;
import java.util.Scanner;
class Pianica {
    private ArrayDeque<Integer> Player1 = new ArrayDeque<Integer>(5);
    private ArrayDeque<Integer> Player2 = new ArrayDeque<Integer>(5);
    private int counter = 0;
    public void GameModule(){
        int Card1;
        int Card2;
        while (true){
            Card1 = Player1.pollFirst();
            Card2 = Player2.pollFirst();
            if (Card1 > Card2){
                Player1.add(Card1);
                Player1.add(Card2);
            }
            else{
                Player2.add(Card2);
                Player2.add(Card1);
            }
            counter++;
            if (Player2.isEmpty()){
                System.out.println("first" + counter);
                return;
            }
            else if (Player1.isEmpty()){
                System.out.println("second" + counter);
                return;
            }
            if (counter >= 106){
                System.out.println("botva");
                return;
            }
        }
    }
    public void Input(){
        boolean c = false;
        int[] deck = new int[10];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите колоду первого игрока: ");
        for (int i = 0; i < 5; i++)
            deck[i] = scanner.nextInt();
        System.out.println("Введите колоду второго игрока: ");
        for (int i = 5; i < 10; i++)
            deck[i] = scanner.nextInt();
        for (int i = 0; i < deck.length; i++){
            if (deck[i] < 0 || deck[i] > 9){
                System.out.println("Ошибка! Карты не могут повторяться или находиться вне диапазона от 0 до 9\nПовторите ввод:");
                c = true;
            }
            for (int j = 0; j < deck.length; j++)
                if (deck[i] == deck[j] && j != i){
                    System.out.println("Ошибка! Карты не могут повторяться или находиться вне диапазона от 0 до 9\nПовторите ввод:");
                    c = true;
                    break;
                }
            if (c){
                c = false;
                System.out.println("Введите колоду первого игрока: ");
                for (int l = 0; l < 5; l++)
                    deck[l] = scanner.nextInt();
                System.out.println("Введите колоду второго игрока: ");
                for (int l = 5; l < 10; l++)
                    deck[l] = scanner.nextInt();
                i = -1;
            }
        }
        for (int i = 0; i < 5; i++)
            Player1.add(deck[i]);
        for (int i = 5; i < 10; i++)
            Player2.add(deck[i]);
    }
}
public class Main {
    public static void main(String[] args) {
        Pianica Test = new Pianica();
        Test.Input();
        Test.GameModule();
    }
}