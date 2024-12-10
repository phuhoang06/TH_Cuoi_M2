import controller.PhoneManager;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        PhoneManager phoneManager = new PhoneManager();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nMENU CHỨC NĂNG:");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xóa");
            System.out.println("3. Xem danh sách");
            System.out.println("4. Tìm kiếm");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng newline

            switch (choice) {
                case 1:
                    System.out.println("Chức năng thêm mới chưa triển khai.");
                    break;

                case 2:
                    // Chức năng xóa
                    System.out.print("Nhập ID điện thoại muốn xóa: ");
                    String id = scanner.nextLine();
                    phoneManager.deletePhoneById(id);
                    break;

                case 3:
                    // Hiển thị danh sách điện thoại
                    phoneManager.displayPhones();
                    break;

                case 4:
                    System.out.println("Chức năng tìm kiếm chưa triển khai.");
                    break;

                case 5:
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
