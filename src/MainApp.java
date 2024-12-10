import controller.PhoneManager;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        PhoneManager phoneManager = new PhoneManager();
        phoneManager.loadPhonesFromCSV();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Thêm mới");
            System.out.println("2. Xóa");
            System.out.println("3. Xem danh sách");
            System.out.println("4. Tìm kiếm");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Đọc bỏ dòng newline

            switch (choice) {
                case 1:
                    // Thêm điện thoại
                    break;
                case 2:
                    // Xóa điện thoại
                    break;
                case 3:
                    phoneManager.displayPhones();
                    break;
                case 4:
                    // Tìm kiếm điện thoại
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    break;
            }
        } while (choice != 5);
    }
}
