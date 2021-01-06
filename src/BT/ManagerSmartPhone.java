package BT;

import comparator.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerSmartPhone {
    String fileSmartPhone = "SmartPhone.csv";
    ArrayList<Smartphone> listSmartphone = new ArrayList<>(readToFile());

    public void ceartSmartPhone(Scanner input) throws InvalidBrandNameException {
        System.out.println("Mã thiết bị: ");
        String id = input.nextLine();
        System.out.println("Hãng sản xuất: ");
        // đọc vào tên hãng và remove khoảng trắng thừa
        String brand = input.nextLine().trim();
        System.out.println("Tên thiết bị: ");
        String name = input.nextLine();
        System.out.println("Giá bán: ");
        float price = Float.parseFloat(input.nextLine());
        System.out.println("Năm sản xuất: ");
        int year = Integer.parseInt(input.nextLine());
        System.out.println("Kích thước màn hình: ");
        String screenSize = input.nextLine();
        listSmartphone.add(new Smartphone(id, brand, name, price, year, screenSize));
    }

    public void ShowSmartPhone() {
        if (listSmartphone.size() > 0) {
            System.out.printf("%-20s%-20s%-20s%-15s%-15s%-15s\n",
                    "Mã thiết bị", "Hãng sản xuất", "Tên thiết bị",
                    "Giá bán", "Năm sản xuất", "Màn hình");
            for (Smartphone smartphone : listSmartphone) {
                System.out.printf("%-20s%-20s%-20s%-15.2f%-15d%-15s\n",
                        smartphone.getId(), smartphone.getBrand(),
                        smartphone.getName(), smartphone.getPrice(),
                        smartphone.getYear(), smartphone.getScreenSize());
            }
        } else {
            System.out.println("Danh Sach Rong");
        }
    }

    public void sort(Scanner input) {
        if (listSmartphone.size() > 0) {
            System.out.println("1. Sắp xếp smartphone theo tên hãng a-z");
            System.out.println("2. Sắp xếp smartphone theo giá bán giảm dần");
            System.out.println("3. Sắp xếp smartphone theo giá bán tăng dần");
            System.out.println("4. Sắp xếp smartphone theo năm sản xuất cũ->mới");
            System.out.println("5. Sắp xếp smartphone theo năm sản xuất mới->cũ");
            int options = input.nextInt();
            switch (options) {
                case 1:
                    listSmartphone.sort(new SortByBrandAZ());
                    break;
                case 2:
                    listSmartphone.sort(new SortByPriceDow());
                    break;
                case 3:
                    listSmartphone.sort(new SortByPriceUp());
                    break;
                case 4:
                    listSmartphone.sort(new SortYearDow());
                    break;
                case 5:
                    listSmartphone.sort(new SortYearUp());
                    break;
            }
        } else {
            System.out.println("Danh Sach Rong");
        }
    }

    public void WriterFile() {
        File file = new File(fileSmartPhone);
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            PrintWriter printWriter = new PrintWriter(file);
            for (Smartphone smart : listSmartphone) {
                printWriter.println(smart.getId());
                printWriter.println(smart.getBrand());
                printWriter.println(smart.getName());
                printWriter.println(smart.getPrice());
                printWriter.println(smart.getYear());
                printWriter.println(smart.getScreenSize());
            }
            printWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Smartphone> readToFile() {
        ArrayList<Smartphone> list = new ArrayList<>();
        File file = new File(fileSmartPhone);
        try {
            if (!file.exists()) {
                file.createNewFile();
                Scanner scan = new Scanner(file);
                while (scan.hasNextLine()) {
                    String id = scan.nextLine();
                    String brand = scan.nextLine();
                    String name = scan.nextLine();
                    float price = Float.parseFloat(scan.nextLine());
                    int year = Integer.parseInt(scan.nextLine());
                    String screenSize = scan.nextLine();
                    Smartphone smartphone = new Smartphone(id, brand, name, price, year, screenSize);
                    list.add(smartphone);
                }
            }
        } catch (IOException | InvalidBrandNameException e) {
            e.printStackTrace();
        }
        return list;
    }
}
