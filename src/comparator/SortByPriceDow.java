package comparator;

import BT.Smartphone;

import java.util.Comparator;

public class SortByPriceDow implements Comparator<Smartphone> {
    @Override
    public int compare(Smartphone o1, Smartphone o2) {
        return Float.compare(o2.getPrice(),o1.getPrice());
    }
}
