package controller;

import model.Phone;
import storage.CSVUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneManager {
    private List<Phone> phoneList;

    public PhoneManager() {
        this.phoneList = CSVUtils.readFromCSV();
    }

    // Xóa điện thoại theo ID
    public void deletePhoneById(String id) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Tìm kiếm điện thoại với ID tương ứng
            Phone phoneToDelete = null;
            for (Phone phone : phoneList) {
                if (phone.getId().equals(id)) {
                    phoneToDelete = phone;
                    break;
                }
            }

            // Nếu không tìm thấy, ném ngoại lệ
            if (phoneToDelete == null) {
                throw new NotFoundProductException("ID điện thoại không tồn tại.");
            }

            // Xác nhận từ người dùng trước khi xóa
            System.out.println("Bạn có chắc chắn muốn xóa điện thoại này? (Yes/No)");
            String confirmation = scanner.nextLine().trim();

            if (confirmation.equalsIgnoreCase("Yes")) {
                phoneList.remove(phoneToDelete);
                CSVUtils.writeToCSV(phoneList); // Cập nhật lại file CSV
                System.out.println("Đã xóa điện thoại thành công!");
                displayPhones(); // Hiển thị lại danh sách sau khi xóa
            } else if (confirmation.equalsIgnoreCase("No")) {
                System.out.println("Hủy thao tác xóa. Quay lại menu chính.");
            } else {
                System.out.println("Lựa chọn không hợp lệ. Quay lại menu chính.");
            }

        } catch (NotFoundProductException e) {
            System.out.println(e.getMessage());
        }
    }

    // Hiển thị danh sách điện thoại
    public void displayPhones() {
        if (phoneList.isEmpty()) {
            System.out.println("Danh sách điện thoại trống.");
            return;
        }

        System.out.println("Danh sách điện thoại:");
        for (Phone phone : phoneList) {
            System.out.println(phone.getDetails());
        }
    }

    // Chức năng tìm kiếm gần đúng theo ID hoặc Tên điện thoại
    public List<Phone> searchPhones(String keyword) {
        List<Phone> result = new ArrayList<>();
        for (Phone phone : phoneList) {
            // Kiểm tra từ khóa có trong ID hoặc Tên điện thoại (không phân biệt hoa thường)
            if (phone.getId().toLowerCase().contains(keyword.toLowerCase()) ||
                    phone.getName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(phone);
            }
        }
        return result;
    }

    // Hiển thị danh sách tìm kiếm
    public void displaySearchResults(List<Phone> results) {
        if (results.isEmpty()) {
            System.out.println("Không tìm thấy điện thoại nào phù hợp với từ khóa.");
        } else {
            System.out.println("Kết quả tìm kiếm:");
            for (Phone phone : results) {
                System.out.println(phone.getDetails());
            }
        }
    }

}



