package Assignment6;

import java.util.ArrayList;

public class Mreview implements Comparable<Mreview> {
    private String title;
    private ArrayList<Integer> ratings;

    public Mreview(){
        title = "";
        ratings = new ArrayList<>();
    }

    public Mreview(String title){
        this.title = title;
        ratings = new ArrayList<>();
    }

    public Mreview(String title, ArrayList<Integer> ratings){
        this.title = title;
        this.ratings = ratings;
    }

    public void addRating(int r){
        ratings.add(r);
    }

    public double aveRating(){
        double res = 0.0;
        for (int n : ratings){
            res += n;
        }
        res = res / numRatings();
        return res;
    }

    @Override
    public int compareTo(Mreview o) {
        // The higher rating Mreview get higher priority
        return (this.aveRating() - o.aveRating() > 0) ? -1 : 1;
    }

    public boolean equals(Mreview o) {
        if (title == o.title && ratings.equals(o.ratings)){
            return true;
        } else {
            return false;
        }
    }

    public String getTitle(){
        return title;
    }

    public int numRatings(){
        return ratings.size();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(title + "\n");
        for (int n : ratings){
            sb.append(n + " ");
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Mreview a = new Mreview("Kill Bill");
        a.addRating(3);
        a.addRating(4);
        a.addRating(3);

        Mreview c = new Mreview("Kill Bill");
        c.addRating(3);
        c.addRating(4);
        c.addRating(3);

        Mreview b = new Mreview("Inception");
        b.addRating(5);
        b.addRating(4);
        b.addRating(5);

        System.out.println(a.toString());
        System.out.println(a.aveRating());

        System.out.println(a.compareTo(b));
        System.out.println(a.equals(c));
    }
}
