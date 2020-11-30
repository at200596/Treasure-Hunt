package treasurehunt;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class TreasureHunt {

    static Scanner input = new Scanner(System.in);
    static String[][] board = new String[5][5];
    static ArrayList <Integer> randomXCoords = new ArrayList<>();
    static ArrayList <Integer> randomYCoords = new ArrayList<>();
    static Random rand = new Random();
    static int howMuchTreasure = rand.nextInt((10 - 1) + 1) + 1;
    static int count = howMuchTreasure;
    static String[] guessedCoordinates = new String[howMuchTreasure*2];
    static int totalPoints = 0;

    public static void main(String[] args) {
        setUpBoard();
        printingBoard();

        for (int i = 0; i < howMuchTreasure; i++) {
            int randX = rand.nextInt(5);
            int randY = rand.nextInt(5);
//            int TreasureAmount = rand.nextInt(10);
//            board[randX][randY] = "["+TreasureAmount+"]";
            

            randomXCoords.add(randX);
            randomYCoords.add(randY);

        }
        
        usersCoordinates();

    }
    public static void setUpBoard(){
        for( int i =0; i<5; i++){
            for(int j=0; j<5; j++){
                board[i][j] = "[ ]";
            }
        }
    }
    public static void printingBoard() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                
                System.out.print(board[i][j]);

            }
            System.out.println("");

        }
    }

    public static void usersCoordinates() {
        try {
            int guesses = 10;
            while ((guesses > 0) && (howMuchTreasure > 0)) {

                System.out.println("You have " + guesses + " guesses left");
                System.out.println("There are " + howMuchTreasure + " bits of treasure left");

                System.out.println();
                System.out.println("Enter a X Coordinate");
                int xCoord = input.nextInt();

                System.out.println("Enter a Y Coordinate");
                int yCoord = input.nextInt();
                
                int loopCount = 0;

                for (int i = 0; i < 5; i++) {
                    if ((xCoord == randomXCoords.get(i))&&(loopCount == 0)) {
                        System.out.println("That is the correct X Coordinate");
                        loopCount++;
                        if (yCoord == randomYCoords.get(i)) {
                            guessedCoordinates[i] = (xCoord + "," + yCoord);
                            loopCount = 0;
                            correctCoordinates();
                            

                        }
                    }

                }
                guesses--;
            }
            System.out.println();

            if (guesses == 0) {
                System.out.println("You have run out of guesses");
                
                System.out.println("The treasure was at these coordinates:");
                System.out.println();
                System.out.println("Your total points are: " + totalPoints);
                for (int i = 0; i < count; i++) {
                    System.out.println(randomXCoords.get(i) + "," + randomYCoords.get(i));

                }
            }
            if (howMuchTreasure == 0) {
                System.out.println("You have found all of the treasure!");
            }

        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public static void correctCoordinates() {
        System.out.println("You have guessed the correct coordinates");
        System.out.println();
        int treasure = rand.nextInt(100);
        System.out.println("You have received " + treasure + " points");

        
        totalPoints = totalPoints + treasure;

        System.out.println("Your total points are: " + totalPoints);
        System.out.println();

        howMuchTreasure--;

    }

}
