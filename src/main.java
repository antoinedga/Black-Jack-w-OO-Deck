import java.util.*;


public class main {

    public static void main(String[] arg){

        int bank = 1000;
        int bid = 0;
        int game = 1;
        int decision = 0;
        int wins = 0;
        int playerHand = 0;
        int dealerHand = 0;
        boolean holdGame = false;
        int lose = 0;
        boolean checkHand = false;
        boolean endgame = true;
        double rate = ((double)wins/game) * 100;

        Scanner input = new Scanner(System.in);

        controller control = new controller();
        control.filldeck();
        control.test();

        System.out.println("Welcome to Black Jack V.2.");

        while(true){
            System.out.print(" Bank: " + bank + "\nPlease enter your starting bid: $");
            bid = input.nextInt();
            System.out.printf("GAME #%d", game);
            System.out.println();
            endgame = true;
            playerHand += control.hit();
            dealerHand += control.dealerhit();
            System.out.println("Hands: " + playerHand);

            while(endgame){

                System.out.println("\n1.Hit\t2.Hold\n3.Status\t4.quit");
                decision = input.nextInt();

                switch(decision) {
                    case 1:
                        playerHand += control.hit();
                        dealerHand += control.dealerhit();
                        System.out.println("Hands: " + playerHand);
                        checkHand = control.check(playerHand);
                        if (checkHand) {
                            playerHand = dealerHand = 0;
                            control.resetDeck();
                            lose++;
                            game++;
                            endgame = false;
                        }
                        break;
                    case 2:
                        holdGame = control.hold(playerHand, dealerHand);
                        if (holdGame) {
                            wins++;
                            game++;
                            bank = bank + bid;
                            playerHand = dealerHand = 0;
                            endgame = false;
                        } else {
                            lose++;
                            game++;
                            bank = bank - bid;
                            playerHand = dealerHand = 0;
                            endgame = false;
                        }
                        control.resetDeck();
                        break;

                    case 3:
                        System.out.printf("Bank: %d \t Bid: %d \nWins: %d\t Total Games: %d\n Success: %.f", bank, bid, wins, game, rate);
                        break;

                    case 4:
                        System.exit(1);
                        break;

                    default:
                        System.out.println("IMPROPER ENTRY! TRY AGAIN!!!");
                        break;
                }


            }

        }

    }
}
