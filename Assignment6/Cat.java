package Assignment6;

public class Cat extends Pet implements Boardable{
    private String hairLength;
    private int[] boardStart;
    private int[] boardEnd;

    public Cat(String name, String ownerName, String color, String hairLength){
        super(name, ownerName, color);
        this.hairLength = hairLength;
    }

    public String getHairLength() {
        return hairLength;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CAT:" + "\n");
        sb.append(super.getPetName() + " owned by " + super.getOwnerName() + "\n");
        sb.append("Color: " + super.getColor() + "\n");
        sb.append("Sex: " + super.getSex() + "\n");
        sb.append("Hair: " + getHairLength() + "\n");
        return sb.toString();
    }

    @Override
    public void setBoardEnd(int month, int day, int year) {
        if (1 <= month && month <= 12){
            if (1 <= day && day <= 31){
                if (1000 <= year && year <= 9999){
                    boardEnd = new int[3];
                    boardEnd[0] = month;
                    boardEnd[1] = day;
                    boardEnd[2] = year;
                }
            }
        }
    }

    @Override
    public void setBoardStart(int month, int day, int year) {
        if (1 <= month && month <= 12){
            if (1 <= day && day <= 31){
                if (1000 <= year && year <= 9999){
                    boardStart = new int[3];
                    boardStart[0] = month;
                    boardStart[1] = day;
                    boardStart[2] = year;
                }
            }
        }
    }

    @Override
    public boolean boarding(int month, int day, int year) {
        if (boardStart == null){
            return false;
        } else if (year < boardStart[2]){
            return false;
        } else if (boardStart[2] == year && month < boardStart[1]){
            return false;
        } else if (boardStart[2] == year && boardStart[1] == month && day < boardStart[0]){
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args){
        Cat newCat = new Cat("Tom", "Bob", "Black", "Short");
        newCat.setSex(2);
        newCat.setBoardStart(10, 25, 1993);

        System.out.println(newCat.toString());
        System.out.println(newCat.boarding(11, 05, 2018));
        newCat.setBoardEnd(11, 05, 2018);
    }
}
