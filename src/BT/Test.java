package BT;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choices;
        ManagerSmartPhone manager = new ManagerSmartPhone();
        do {
            System.out.println("=================== MENU ===================");
            System.out.println("1. Thêm 1 smartphone vào danh sách");
            System.out.println("2. Sắp xếp theo thứ thực tuỳ chọn ");
            System.out.println("3. Hiển thị danh sách smartphone ra màn hình");
            System.out.println("4. Ghi File");
            System.out.println("0. Thoát chương trình");
            choices = input.nextInt();
            input.nextLine();
            switch (choices) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    try {
                        manager.ceartSmartPhone(input);
                    } catch (InvalidBrandNameException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Them Thanh Cong");
                    break;
                case 2:
                    manager.sort(input);
                    manager.ShowSmartPhone();
                    break;
                case 3:
                    manager.ShowSmartPhone();
                    break;
                case 4:
                    manager.WriterFile();
                    break;
            }
        } while (true);
    }
}
