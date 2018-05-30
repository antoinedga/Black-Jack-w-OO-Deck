import java.lang.*;
public class Deck {
    public int value;
    public boolean status;
    public String type;
    public String name;

    public Deck() {
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int x) {
        this.value = x;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean x) {
          this.status = x;
    }

    public void setType(String x) { this.type = x;
    }
    public String getType(){
        return this.type;
    }

    public void setName(String x) {
       this.name = x;
    }

    public String getName() {
        return this.name;
    }

}

