package comparator;

import BT.Smartphone;

import java.util.Comparator;

public class SortByPriceUp implements Comparator<Smartphone> {
    @Override
    public int compare(Smartphone o1, Smartphone o2) {
        return Float.compare(o1.getPrice(), o2.getPrice());
    }
}
