package INFO5100Assignment5;

public class Candy extends DessertItem {
    private double weight;
    private int price;

    public Candy(String name, double weight, int price){
        super(name);
        this.weight = weight;
        this.price = price;
    }

    public int getCost(){
        return (int)(weight * price + 0.5f);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(weight + " lbs. @ " + DessertShoppe.cents2dollarsAndCentsmethod(price) + " /lb." + "\n");
        sb.append(name + " " + DessertShoppe.cents2dollarsAndCentsmethod(getCost()) + "\n");
        return sb.toString();
    }
}