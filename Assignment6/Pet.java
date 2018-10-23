package Assignment6;

import java.util.HashSet;

public class Pet {
    private String petName;
    private String ownerName;
    private String color;
    protected Integer sex;
    private static final int MALE = 0;
    private static final int FEMALE = 1;
    private static final int SPAYED = 2;
    private static final int NEUTERED = 3;

    public Pet(String petName, String ownerName, String color){
        this.petName = petName;
        this.color = color;
        this.ownerName = ownerName;
    }

    public String getPetName(){
        return petName;
    }

    public String getOwnerName(){
        return ownerName;
    }

    public String getColor(){
        return color;
    }

    public void setSex(int sexid){
        HashSet<Integer> set = new HashSet<>();
        set.add(MALE);
        set.add(FEMALE);
        set.add(SPAYED);
        set.add(NEUTERED);

        if (set.contains(sexid)){
            this.sex = sexid;
        } else {
            System.out.println("Please set the correct sexid");
        }
    }

    public String getSex(){
        if (sex == MALE){
            return "Male";
        } else if (sex == FEMALE){
            return "Female";
        } else if (sex == SPAYED){
            return "Spayed";
        } else if (sex == NEUTERED){
            return "Neutered";
        } else {
            return "";
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(getPetName() + " owned by " + getOwnerName() + "\n");
        sb.append("Color: " + getColor() + "\n");
        sb.append("Sex: " + getSex() + "\n");
        return sb.toString();
    }

    public static void main(String[] args){
        Pet newPet = new Pet("Spot", "Mary", "Black and White");
        newPet.setSex(0);
        System.out.println(newPet.toString());
    }
}
