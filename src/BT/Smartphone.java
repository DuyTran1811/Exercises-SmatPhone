package BT;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Comparable<Smartphone> {
    private String id;     // ma san pham
    private String brand;  // hang san xuat
    private String name;   // ten san pham
    private float price;    // gia san pham
    private int year;       // nam
    private String screenSize; // kich thuoc man hinh

    public Smartphone() {
    }

    public Smartphone(String id, String brand, String name, float price, int year, String screenSize) throws InvalidBrandNameException {
        this.id = id;
        this.setBrand(brand);
        this.name = name;
        this.price = price;
        this.year = year;
        this.screenSize = screenSize;
    }

    public void setBrand(String brand) throws InvalidBrandNameException {
        if (checkBrand(brand)) {
            this.brand = brand;
        } else {
            this.brand = null;
            throw new InvalidBrandNameException("Tên Hãng Không Hợp Lệ Vui Long Nhập Lại ");
        }
    }

    private boolean checkBrand(String brand) {
        String regex = "^apple|samsung|huawei|xiaomi|oppo|vsmart$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(brand);
        return matcher.matches();
    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public String getScreenSize() {
        return screenSize;
    }

    @Override
    public int compareTo(Smartphone o) {
        return id.compareTo(o.id);
    }
}
