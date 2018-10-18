package INFO5100Assignment5;

public class Sundae extends IceCream{
    private int topping;
    private String SundaeName;

    public Sundae(String name, int price, String SundaeName, int topping){
        super(name, price);
        this.SundaeName = SundaeName;
        this.topping = topping;
    }

    @Override
    public int getCost() {
        return super.getCost() + topping;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SundaeName + " Sundae with \n");
        sb.append(name + " " + DessertShoppe.cents2dollarsAndCentsmethod(getCost()) + "\n");
        return sb.toString();
    }
}
