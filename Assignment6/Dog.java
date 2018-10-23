package Assignment6;

public class Dog extends Pet implements Boardable{
    private String size;
    private int[] boardStart;
    private int[] boardEnd;

    public Dog(String name, String ownerName, String color, String size){
        super(name, ownerName, color);
        this.size = size;
    }

    public String getSize(){
        return size;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("DOG:" + "\n");
        sb.append(super.getPetName() + " owned by " + super.getOwnerName() + "\n");
        sb.append("Color: " + super.getColor() + "\n");
        sb.append("Sex: " + super.getSex() + "\n");
        sb.append("Size: " + getSize() + "\n");
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
        Dog newDog = new Dog("Spot", "Susan", "White", "Medium");
        newDog.setSex(2);
        newDog.setBoardStart(10, 25, 1993);

        System.out.println(newDog.toString());
        System.out.println(newDog.boarding(11, 05, 2018));
        newDog.setBoardEnd(11, 05, 2018);
    }
}
