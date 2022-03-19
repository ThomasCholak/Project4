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

        myHydra.hydraHeads(); int inputHeads = reader.nextInt();
        myHydra.hydraTails(); int inputTails = reader.nextInt();

        System.out.println(HydraMonster(inputHeads, inputTails)); System.out.println();

        playerMoves myPlayer = new playerMoves();
        myPlayer.MovesAvailable();
        myPlayer.Move1(); myPlayer.Move2(); myPlayer.Move3(); myPlayer.Move4();
        myPlayer.SelectMove();
        int moveSelector = reader.nextInt(); //choose the player's attack(move)

        if (moveSelector < 0 || moveSelector > 4) { System.out.println("please try again."); }
        if (moveSelector == 1) { myPlayer.Move1(); }
        if (moveSelector == 2) { myPlayer.Move2(); }
        if (moveSelector == 3) { myPlayer.Move3(); }
        if (moveSelector == 4) { myPlayer.Move4(); }

    }
    public static String HydraMonster (int heads, int tails) {
        String hydraCreation = "Your hydra monster has " + heads + " heads and " + tails + " tails.";
        return hydraCreation;
    }
    public static String ruleSet () {
        String Rule0 = "Hydra Game - Here are the handy rules of the game:";
        String Rule1 = "If PyPy cuts off exactly one head, a new head grows immediately.";
        String Rule2 = "If PyPy cuts off exactly one tail, two new tails grow immediately.";
        String Rule3 = "PyPy cuts off exactly two tails, a new head grows immediately.";
        String Rule4 = "If PyPy cuts off exactly two heads, nothing happens.";
        String Rules = Rule0 + "\n" + Rule1 + "\n" + Rule2 + "\n" + Rule3 + "\n" + Rule4;
        return Rules;
    }
    public static String gameDescription() {
        String desc1 = "Princess Perly has been kidnapped by the magical Hydra! The kingdom is in chaos. Now only PyPy — the bravest Knight of the country — can save the day!";
        String desc2 = "Hydra is a powerful magical creature with H heads and T tails. Hydra can breathe fire from each of its heads, and can shoot poison from each of its tails. The only way to";
        String desc3 = "kill Hydra is to cut off all H heads and all T tails. Please note that a Hydra with 0 heads and T > 0 tails is still alive — in which case it is called a ‘Headless Hydra’.";
        String fullDesc = desc1 + "\n" + desc2 + "\n" + desc3;
        return fullDesc;
    }
}

