/*
Thomas Cholak
Professor Steve Riegerix
CMP SCI 2261
20 March 2022

Assignment: Game where Knight PyPy has 4 moves and his goal is to kill a Hydra.
 */

package edu.umsl;

import java.util.Scanner;

public class HydraGame {

    public static void main (String[] args) {
        System.out.println(gameDescription());
        System.out.println();
        int turnCounter = 0; //track # of turns player has taken

        System.out.println(ruleSet());
        System.out.println();
        Scanner reader = new Scanner(System.in);
        Hydra myHydra = new Hydra();

        boolean retry = true;
        int inputHeads = 0;
        int inputTails = 0;

        String selected = "You have selected: ";
        String errorValidation = "Please enter a valid integer.";

        do {
            try {
                myHydra.hydraHeads();
                inputHeads = reader.nextInt();
                myHydra.hydraTails();
                inputTails = reader.nextInt();
                if (inputHeads < 0 || inputTails < 0) { //checks numbers for negatives
                    System.out.println("Please input a positive number!");
                } else {
                    retry = false;
                }
            } catch (Exception ex) {
                System.out.println(errorValidation);
                reader.next();
            }
        } while (retry);

        int S = bestCounter(inputHeads, inputTails); //calculates the least amount of turns needed to win

        System.out.println(HydraMonster(inputHeads, inputTails)); //tell player what monster they've made
        System.out.println();
        playerMoves myPlayer = new playerMoves(); //output moves from Player interface

        myPlayer.MovesAvailable();
        System.out.println("Quit - Enter 5 at any time to quit the game.");

        do {
            try {
                if (inputHeads % 2 == 1 && inputTails == 0) {
                    System.out.println("The dragon is now unkillable. You have failed Princess Perly.");
                    System.out.println("The best knight in the land could have beaten the hydra in " + S + " turns.");
                    return;
                } else if (inputHeads == 0 && inputTails == 0) {
                    System.out.println("You have saved Princess Pearly. Great job!");
                    System.out.println("It took you " + turnCounter + " turns to beat the hydra.");
                    System.out.println("The least amount of turns you could have taken is " + S + " turns.");
                    return;
                } else {
                    myPlayer.Move1(); //display moves
                    myPlayer.Move2();
                    myPlayer.Move3();
                    myPlayer.Move4();
                    myPlayer.SelectMove();
                    int moveSelector = reader.nextInt(); //choose the player's attack(move)

                    if (moveSelector < 0 || moveSelector > 5) {
                        System.out.println("Please try again.");
                    }
                    if (moveSelector == 1) {
                        if (inputHeads == 0) {
                            System.out.println("No heads available to chop, please try again.");
                            System.out.println();
                        } else {
                            inputHeads = inputHeads - 1;
                            turnCounter++; //turn counter increases by 1
                            System.out.print(selected);
                            myPlayer.Move1();
                            System.out.println(HydraMonster(inputHeads, inputTails));
                            System.out.println("The hydra grows back a head.");
                            inputHeads = inputHeads + 1;
                            System.out.println(HydraMonster(inputHeads, inputTails));
                            System.out.println();
                        }
                    }
                    if (moveSelector == 2) {
                        if (inputTails == 0) {
                            System.out.println("No tails available to chop. Please try again.");
                            System.out.println();
                        } else {
                            inputTails = inputTails - 1;
                            turnCounter++;
                            System.out.print(selected);
                            myPlayer.Move2();
                            System.out.println(HydraMonster(inputHeads, inputTails));
                            System.out.println("The hydra grows back two tails.");
                            inputTails = inputTails + 2;
                            System.out.println(HydraMonster(inputHeads, inputTails));
                            System.out.println();
                        }
                    }
                    if (moveSelector == 3) {
                        if (inputHeads <= 1) {
                            System.out.println("Not enough heads available to chop. Please try again");
                            System.out.println(HydraMonster(inputHeads, inputTails));
                            System.out.println();
                        } else {
                            inputHeads = inputHeads - 2;
                            turnCounter++;
                            System.out.print(selected);
                            myPlayer.Move3();
                            System.out.println(HydraMonster(inputHeads, inputTails));
                            System.out.println("Nothing happens...");
                            System.out.println(HydraMonster(inputHeads, inputTails));
                            System.out.println();
                        }
                    }
                    if (moveSelector == 4) {
                        if (inputTails <= 1) {
                            System.out.println("Not enough tails available to chop. Please try again.");
                            System.out.println(HydraMonster(inputHeads, inputTails));
                            System.out.println();
                        } else {
                            inputTails = inputTails - 2;
                            turnCounter++;
                            System.out.print(selected);
                            myPlayer.Move4();
                            System.out.println(HydraMonster(inputHeads, inputTails));
                            System.out.println("The hydra grows back a head.");
                            inputHeads = inputHeads + 1;
                            System.out.println(HydraMonster(inputHeads, inputTails));
                            System.out.println();
                        }
                    }
                    if (moveSelector == 5) {
                        System.out.println("You have selected the quit option.\n Thanks for playing!");
                        System.out.println("Try to beat the hydra in " + S + " turns next time.");
                        return;
                    }
                }
            } catch (Exception ex) {
                System.out.println(errorValidation);
                reader.next();
            }
        } while (true);
    }
    private static Integer bestCounter (int heads, int tails) { //calculate the least amount of moves
        if (heads % 2 == 1 && tails % 2 == 0) { //heads odd and tails even
            int x = tails / 2;
            int y  = (heads + x) / 2;
            return x + y; }
        if (heads % 2 == 0 && tails % 2 ==1) { //heads even, tails odd
            int x = (tails + 1) / 2;
            int y = (heads + x) / 2;
            return x + y + 1; }
        if (heads % 2 == 1 && tails % 2 == 1) { //heads and tails odd
            int x = ((heads + 1) / 2) + ((tails + 1) / 2);
            return x + 1; }
        else { //both even
            int x = (tails / 2);
            int y = (heads / 2);
            return x + y + 1; }
    }
    private static String HydraMonster (int heads, int tails) {
        return "The hydra monster has " + heads + " head(s) and " + tails + " tail(s).";
    }
    private static String ruleSet () {
        String Rule0 = "Hydra Game - Here are the handy rules of the game:";
        String Rule1 = "If PyPy cuts off exactly one head, a new head grows immediately.";
        String Rule2 = "If PyPy cuts off exactly one tail, two new tails grow immediately.";
        String Rule3 = "PyPy cuts off exactly two tails, a new head grows immediately.";
        String Rule4 = "If PyPy cuts off exactly two heads, nothing happens.";
        return Rule0 + "\n" + Rule1 + "\n" + Rule2 + "\n" + Rule3 + "\n" + Rule4;
    }
    private static String gameDescription() {
        String desc1 = "Princess Perly has been kidnapped by the magical Hydra! The kingdom is in chaos. Now only PyPy — the bravest Knight of the country — can save the day!";
        String desc2 = "Hydra is a powerful magical creature with H heads and T tails. Hydra can breathe fire from each of its heads, and can shoot poison from each of its tails. The only way to";
        String desc3 = "kill Hydra is to cut off all H heads and all T tails. Please note that a Hydra with 0 heads and T > 0 tails is still alive — in which case it is called a ‘Headless Hydra’.";
        return desc1 + "\n" + desc2 + "\n" + desc3;
    }
}

