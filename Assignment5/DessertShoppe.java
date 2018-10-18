package INFO5100Assignment5;

public class DessertShoppe{
    static final double taxRate = 0.065d;
    static final String storeName = "M & M Dessert Shoppe";
    static final int maxSize = 30;
    static final int width = 30;

    public static String cents2dollarsAndCentsmethod(int cent){
        int temp = cent % 100;
        String cur = "";
        if (temp < 10){
            cur = "0";
        }
        String res = Integer.toString(cent / 100) + "." + cur + Integer.toString(cent % 100);
        return res;
    }
}
