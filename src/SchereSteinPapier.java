import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SchereSteinPapier {
    public static String userInput;
    public static String computerOutput;

    public static Scanner ssp;

    public static ArrayList<String> SchereSteinPapierArray = new ArrayList<>();


    private void addComputerChoicesToArray() {
        SchereSteinPapierArray.add("Schere ✂️");
        SchereSteinPapierArray.add("Stein \uD83E\uDEA8");
        SchereSteinPapierArray.add("Papier \uD83D\uDCDD");
    }

    private void automaticComputerChoice() {
        this.addComputerChoicesToArray();
        Collections.shuffle(SchereSteinPapierArray);

        computerOutput = SchereSteinPapierArray.get(0);

      System.out.println("Der"+TerminalColorStrings.ANSI_GREEN+" Computer"+TerminalColorStrings.ANSI_RESET+" hat "+computerOutput+ " ausgewählt.\n");

    }

    private void userChoice() {
        ssp = new Scanner(System.in);
        System.out.println("Gib ein Schere ✂️ | Stein \uD83E\uDEA8 | Papier \uD83D\uDCDD");
        userInput = ssp.nextLine();

        switch (userInput.toLowerCase()) {
            case "schere" -> userInput = "Schere ✂️";
            case "stein" -> userInput = "Stein \uD83E\uDEA8";
            case "papier" -> userInput = "Papier \uD83D\uDCDD";
        }
        System.out.println("Der "+TerminalColorStrings.ANSI_BLUE+"User"+TerminalColorStrings.ANSI_RESET+" hat "+userInput+ " ausgewählt.\n");
    }

    public void winLogic() {
      //          Schere verliert gegen stein, Schere gewinnt gegen Papier
        //        Stein gewinnt gegen schere verliert aber gegen papier
          //      papier verliert gegen schere aber gewinnt gegen stein

        if (userInput.equals(computerOutput)) {
            System.out.println("Niemand hat gewonnen.. \uD83E\uDD1D");
            return;
        }
        if (userInput.equals("Schere ✂️") && !computerOutput.equals("Stein \uD83E\uDEA8")) {
            System.out.println(TerminalColorStrings.ANSI_YELLOW+"(GEWINNER) "+TerminalColorStrings.ANSI_BLUE+"User:"+TerminalColorStrings.ANSI_RESET+ "("+userInput+")" + " hat gewonnen.");
        return;
        }

        if (userInput.equals("Stein \uD83E\uDEA8") && !computerOutput.equals("Papier \uD83D\uDCDD")) {
            System.out.println(TerminalColorStrings.ANSI_YELLOW+"(GEWINNER) "+TerminalColorStrings.ANSI_BLUE+"User:"+TerminalColorStrings.ANSI_RESET+ "("+userInput+")" + " hat gewonnen.");
            return;
        }


        if (userInput.equals("Papier \uD83D\uDCDD") && !computerOutput.equals("Schere ✂️")) {
            System.out.println(TerminalColorStrings.ANSI_YELLOW+"(GEWINNER) "+TerminalColorStrings.ANSI_BLUE+"User:"+TerminalColorStrings.ANSI_RESET+ "("+userInput+")" + " hat gewonnen.");
        } else {
            System.out.println(TerminalColorStrings.ANSI_YELLOW+"(GEWINNER) "+ TerminalColorStrings.ANSI_GREEN+"Computer:"+TerminalColorStrings.ANSI_RESET+ "("+computerOutput+")"+" hat gewonnen.");
        }
    }

    private void determineWinner() {
    System.out.println(TerminalColorStrings.ANSI_BLUE+"User:"+TerminalColorStrings.ANSI_RESET+" ("+userInput+") vs"+TerminalColorStrings.ANSI_GREEN+" Computer: "+TerminalColorStrings.ANSI_RESET+ "("+ computerOutput+")\n");
    this.winLogic();
    }

    public void run() {
        userChoice();
        automaticComputerChoice();
        determineWinner();
    }
}