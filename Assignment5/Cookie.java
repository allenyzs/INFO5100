package INFO5100Assignment5;

public class Cookie extends DessertItem{
    private int number;
    private int price;

    public Cookie(String name, int number, int price){
        super(name);
        this.number = number;
        this.price = price;
    }

    public int getCost(){
        return (int)(number * price / 12 + 0.5f);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(number + " @ " + DessertShoppe.cents2dollarsAndCentsmethod(price) + " /dz." + "\n");
        sb.append(name + " " + DessertShoppe.cents2dollarsAndCentsmethod(getCost()) + "\n");
        return sb.toString();
    }
}
