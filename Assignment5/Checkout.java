package INFO5100Assignment5;

import java.util.ArrayList;
import java.util.List;

public class Checkout{
    private List<DessertItem> list;

    public Checkout(){
        this.list = new ArrayList<>();
    }

    public int numberOfItems(){
        return list.size();
    }

    public void enterItem(DessertItem item){
        list.add(item);
    }

    public void clear(){
        list = new ArrayList<>();
    }

    public int totalCost(){
        int totalCost = 0;
        for (DessertItem item : list){
            totalCost += item.getCost();
        }
        return totalCost;
    }

    public int totalTax(){
        return Math.round((int)(totalCost() * DessertShoppe.taxRate + 0.5f));
    }

    public String toString(){
        String res = "";
        res += "\t" + DessertShoppe.storeName + "\n";
        res += "\t" + "--------------------" + "\n";

        for (DessertItem item : list){
            res += item.toString();
        }
        res += "\n";
        res += "Tax" + " " + DessertShoppe.cents2dollarsAndCentsmethod(totalTax()) + "\n";
        res += "Total Cost" + " " + DessertShoppe.cents2dollarsAndCentsmethod(totalCost() + totalTax());

        return res;
    }
}
