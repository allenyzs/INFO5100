package assignment7;

class Tool {
    private int strength;
    protected char type;

    public Tool(){}

    public Tool(int strength){
        this.strength = strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }
}

class Rock extends Tool {
    public Rock(){}

    public Rock(int strength){
        super(strength);
        super.type = 'r';
    }

    public boolean fight(Tool tool){
        double temp = 1.0;
        if (tool.type == 's'){
            temp *= 2;
        } else if (tool.type == 'p'){
            temp /= 2;
        }
        return temp * this.getStrength() - tool.getStrength() > 0;
    }
}

class Scissors extends Tool{
    public Scissors(){}

    public Scissors(int strength){
        super(strength);
        super.type = 's';
    }

    public boolean fight(Tool tool){
        double temp = 1.0;
        if (tool.type == 'p'){
            temp *= 2;
        } else if (tool.type == 'r'){
            temp /= 2;
        }
        return temp * this.getStrength() - tool.getStrength() > 0;
    }
}

class Paper extends Tool{
    public Paper(){}

    public Paper(int strength){
        super(strength);
        super.type = 'p';
    }

    public boolean fight(Tool tool){
        double temp = 1.0;
        if (tool.type == 'r'){
            temp *= 2;
        } else if (tool.type == 's'){
            temp /= 2;
        }
        return temp * this.getStrength() - tool.getStrength() > 0;
    }
}

public class RockPaperScissorsGame {
    public static void main(String args[]){
        Scissors s = new Scissors(5);
        Paper p = new Paper(7);
        Rock r = new Rock(15);
        System.out.println(s.fight(p) + " , "+ p.fight(s) );
        System.out.println(p.fight(r) + " , "+ r.fight(p) );
        System.out.println(r.fight(s) + " , "+ s.fight(r) );
    }
}
