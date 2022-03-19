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
        System.out.println(gameDescription()); System.out.println();

        System.out.println(ruleSet()); System.out.println();
        Scanner reader = new Scanner(System.in);
        Hydra myHydra = new Hydra();

        myHydra.hydraHeads(); int inputHeads = reader.nextInt(); //set # of heads
        myHydra.hydraTails(); int inputTails = reader.nextInt(); //set # of tails

        System.out.println(HydraMonster(inputHeads, inputTails)); //tell player what monster they've made
        System.out.println(); String selected = "You have selected: ";

        playerMoves myPlayer = new playerMoves(); //output moves from interface
        myPlayer.MovesAvailable();
        myPlayer.Move1(); myPlayer.Move2(); myPlayer.Move3(); myPlayer.Move4();
        myPlayer.SelectMove();
        int moveSelector = reader.nextInt(); //choose the player's attack(move)

        if (moveSelector < 0 || moveSelector > 4) { System.out.println("Please try again."); }
        if (moveSelector == 1) {
            inputHeads = inputHeads - 1;
            System.out.print(selected); myPlayer.Move1();
            System.out.println(HydraMonster(inputHeads, inputTails)); }
        if (moveSelector == 2) {
            inputTails = inputTails - 1;
            System.out.print(selected); myPlayer.Move2();
            System.out.println(HydraMonster(inputHeads, inputTails)); }
        if (moveSelector == 3) {
            inputHeads = inputHeads - 2;
            System.out.print(selected); myPlayer.Move3();
            System.out.println(HydraMonster(inputHeads, inputTails)); }
        if (moveSelector == 4) {
            inputTails = inputTails - 2;
            System.out.print(selected); myPlayer.Move4();
            System.out.println(HydraMonster(inputHeads, inputTails)); }
    }

    private static String HydraMonster (int heads, int tails) {
        return "The hydra monster has " + heads + " heads and " + tails + " tails.";
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

