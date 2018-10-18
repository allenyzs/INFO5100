package INFO5100Assignment5;

public class IceCream extends DessertItem{
    private int cost;

    public IceCream(String name, int cost){
        super(name);
        this.cost = cost;
    }

    public int getCost(){
        return cost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + " " + DessertShoppe.cents2dollarsAndCentsmethod(cost) + "\n");
        return sb.toString();
    }
}
