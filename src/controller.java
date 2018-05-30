import java.util.*;
import java.lang.*;
public class controller {

    Random random = new Random();


   public controller (){
   }

    Deck actualDeck[] = new Deck[53];

    public void filldeck(){

        for (int i = 1; i < 53; i++) {
            actualDeck[i] = new Deck();
        }
        for(int i = 1 ; i < 53; i++){
            actualDeck[i].setStatus(true);
        }
        for (int i = 1; i < 14; i++) {
            actualDeck[i].setType("Club");
            if (i == 11 || i == 12 || i == 13) {
                actualDeck[i].setValue(10);
            } else
                actualDeck[i].setValue(i);
        }
        for (int i = 14; i < 27; i++) {
            actualDeck[i].setType("Hearts");
            actualDeck[i].setValue((i - 13));
            if (i == 26 || i == 23 || i == 24 || i == 25) {
                actualDeck[i].setValue(10);
            }
        }
        for (int i = 27; i < 40; i++) {
            actualDeck[i].setType("Diamonds");
            actualDeck[i].setValue((i - 26));
            if (i > 34) {
                actualDeck[i].setValue(10);
            }
        }

        for (int i = 40; i < 53; i++) {
            actualDeck[i].setType("Spades");
            actualDeck[i].setValue(i - 39);
            if (i > 47) {
                actualDeck[i].setValue(10);
            }
        }

        for (int i = 1; i < 53; i++) {

            if (i == 1 || i == 14 || i == 27 || i == 40) {
                actualDeck[i].setName("Ace");
            }
           else  if (i == 2 || i == 15 || i == 28 || i == 41) {
                actualDeck[i].setName("Two");
            }
            else if (i == 3 || i == 16 || i == 29 || i == 42) {
                actualDeck[i].setName("Three");
            }
            else if (i == 4 || i == 17 || i == 30 || i == 43) {
                actualDeck[i].setName("Four");
            }

            else if (i == 5 || i == 18 || i == 31 || i == 44) {
                actualDeck[i].setName("Five");
            }
            else if (i == 6 || i == 19 || i == 32 || i == 45) {
                actualDeck[i].setName("Six");
            }
            else if (i == 7 || i == 20 || i == 33 || i == 46) {
                actualDeck[i].setName("Seven");
            }
            else if (i == 8 || i == 21 || i == 34 || i == 47) {
                actualDeck[i].setName("Eight");
            }
            else if (i == 9 || i == 22 || i == 35 || i == 48) {
                actualDeck[i].setName("Nine");
            }
            else if (i == 10 || i == 23 || i == 36 || i == 49) {
                actualDeck[i].setName("Ten");
            }
            else if (i == 11 || i == 24 || i == 37 || i == 50) {
                actualDeck[i].setName("Jack");
            }
            else if (i == 12 || i == 25 || i == 38 || i == 51) {
                actualDeck[i].setName("Queen");
            }
            else if (i == 13 || i == 26 || i == 39 || i == 52) {
                actualDeck[i].setName("King");
            }
            else{}

        }
    }
    public void printdeck(){

        for( int i = 1; i < 53; i++){

            System.out.println( actualDeck[i].getName() + " of " + actualDeck[i].getType());

        }
    }
    public int hit(){
        int card = random.nextInt(52) + 1;

        if (actualDeck[card].getStatus()){
            System.out.println("Your card is " + actualDeck[card].getName() + " of " + actualDeck[card].getType());
            actualDeck[card].setStatus(false);
            return actualDeck[card].getValue();
        }
        return hit();
    }
    public int dealerhit(){
        int card = random.nextInt(53) + 1;

        if (actualDeck[card].getStatus()){
            actualDeck[card].setStatus(false);
            return actualDeck[card].getValue();
        }
        return dealerhit();

    }

    public boolean hold(int player, int dealer){

        System.out.printf("Player's %d \t Dealer's: %d", player , dealer);
        if(player > dealer){
            System.out.println("You win! ");
            return true;
        }

        else if(dealer > player){
            System.out.println("Dealer wins!");
        }

        resetDeck();
        return false;
    }

    public void resetDeck(){
        for( int i = 1; i < actualDeck.length; i++){
            actualDeck[i].setStatus(true);
        }
    }
    public boolean check(int player){
        if(player > 21){
            System.out.println("You went over 21, you lose!");
            return true;
        }
        return false;
    }

    public void test() {
        for (int i = 1; i < 53; i++) {
            int card = random.nextInt(52) + 1;

            if (actualDeck[card].getStatus()) {
                System.out.println("Your card is " + actualDeck[card].getName() + " of " + actualDeck[card].getType());
                actualDeck[card].setStatus(false);
            } else hit();
        }
    }

}
