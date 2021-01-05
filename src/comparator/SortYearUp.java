package comparator;

import BT.Smartphone;

import java.util.Comparator;

public class SortYearUp implements Comparator<Smartphone> {
    @Override
    public int compare(Smartphone o1, Smartphone o2) {
        return o1.getYear() - o2.getYear();
    }
}
