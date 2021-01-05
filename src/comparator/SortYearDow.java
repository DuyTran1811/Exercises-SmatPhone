package comparator;

import BT.Smartphone;

import java.util.Comparator;

public class SortYearDow implements Comparator<Smartphone> {
    @Override
    public int compare(Smartphone o1, Smartphone o2) {
        return o2.getYear() - o1.getYear();
    }
}
