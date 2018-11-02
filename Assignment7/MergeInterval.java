package assignment7;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval{
    int start;
    int end;
    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}

public class MergeInterval {

    private static class IntervalComparator implements Comparator<Interval>{
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start < o2.start ? -1 : o1.start == o2.start ? 0 : 1;
        }
    }
    public static List<Interval> merge(List<Interval> intervals){
        Collections.sort(intervals, new IntervalComparator());
        List<Interval> res = new ArrayList<>();

        for (Interval i : intervals){
            if (res.isEmpty() || i.start > res.get(res.size() - 1).end){
                res.add(i);
            } else{
                res.get(res.size() - 1).end = Math.max(i.end, res.get(res.size() - 1).end);
            }
        }
        return res;
    }

    public static void main(String[] args){
        List<Interval> list = new ArrayList<>();
        Interval l1 = new Interval(1, 4);
        Interval l2 = new Interval(4, 5);
        list.add(l1);
        list.add(l2);
        System.out.println(merge(list).toArray());
    }
}
