import controller.PhoneManager;
import model.Phone;

import java.util.List;
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
                    System.out.println("Chức năng xóa chưa triển khai.");
                    break;

                case 3:
                    phoneManager.displayPhones();
                    break;

                case 4:
                    // Chức năng tìm kiếm
                    System.out.print("Nhập từ khóa tìm kiếm (ID hoặc Tên điện thoại): ");
                    String keyword = scanner.nextLine();
                    List<Phone> results = phoneManager.searchPhones(keyword);
                    phoneManager.displaySearchResults(results);
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
