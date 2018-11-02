package assignment7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MergeIntervalTest {

    @Test
    public void merge() {
        Interval interval1 = new Interval(1, 4);
        Interval interval2 = new Interval(4, 5);
        MergeInterval test = new MergeInterval();
        List<Interval> list1 = new ArrayList<>();
        list1.add(interval1);
        list1.add(interval2);

        Interval interval3 = new Interval(1, 5);
        List<Interval> list2 = new ArrayList<>();
        list2.add(interval3);

        assertTrue(intervalEquals(test.merge(list1), list2));

    }

    private boolean intervalEquals(List<Interval> l1, List<Interval> l2){
        if (l1.size() != l2.size()) {
            return false;
        } else{
            for (int i = 0; i < l1.size(); i++){
                int l1Start = l1.get(i).start;
                int l2Start = l2.get(i).start;
                int l1End = l1.get(i).end;
                int l2End = l2.get(i).end;

                if (l1Start == l2Start && l2End == l1End){
                    return true;
                } else{
                    return false;
                }
            }
        }
        return false;
    }

}