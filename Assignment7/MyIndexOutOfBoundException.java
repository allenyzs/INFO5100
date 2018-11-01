package Assignment7;

public class MyIndexOutOfBoundException extends Exception{
    public int lowerBound;
    public int upperBound;
    public int index;

    public MyIndexOutOfBoundException(){

    }

    public MyIndexOutOfBoundException(int lowerBound, int upperBound, int index){
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.index = index;
    }

    @Override
    public String toString() {
        return "Error Message: Index: " + index + ", but Lower bound: " + lowerBound + ", Upper bound: " + upperBound;
    }
}
