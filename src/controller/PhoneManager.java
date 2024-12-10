package controller;

import model.Phone;
import model.OfficialPhone;
import model.ImportedPhone;
import storage.CSVUtils;
import java.util.List;

public class PhoneManager {
    private List<Phone> phoneList;

    public PhoneManager() {
        this.phoneList = CSVUtils.readFromCSV();
    }

    // Lấy ID tự động tăng
    private int getNextId() {
        if (phoneList.isEmpty()) {
            return 1; // Bắt đầu từ 1 nếu danh sách rỗng
        }
        // Lấy ID lớn nhất hiện tại và tăng lên 1
        return phoneList.size() + 1;
    }

    // Validate dữ liệu đầu vào
    private boolean validateData(String name, double price, int quantity, String manufacturer,
                                 int warrantyPeriod, String warrantyScope, String country, String status) {
        // Kiểm tra tên không được trống
        if (name == null || name.isEmpty()) {
            System.out.println("Tên điện thoại không được để trống.");
            return false;
        }
        // Giá và số lượng phải là số dương
        if (price <= 0 || quantity <= 0) {
            System.out.println("Giá bán và số lượng phải là số dương.");
            return false;
        }
        // Thời gian bảo hành phải trong khoảng hợp lệ
        if (warrantyPeriod < 0 || warrantyPeriod > 730) {
            System.out.println("Thời gian bảo hành phải từ 0 đến 730 ngày.");
            return false;
        }
        // Phạm vi bảo hành chỉ nhận "Toan Quoc" hoặc "Quoc Te"
        if (warrantyScope != null && !warrantyScope.equals("Toan Quoc") && !warrantyScope.equals("Quoc Te")) {
            System.out.println("Phạm vi bảo hành chỉ được là 'Toan Quoc' hoặc 'Quoc Te'.");
            return false;
        }
        // Quốc gia xách tay không được là "Viet Nam"
        if (country != null && country.equals("Viet Nam")) {
            System.out.println("Quốc gia xách tay không được là 'Viet Nam'.");
            return false;
        }
        // Trạng thái chỉ nhận "Da sua chua" hoặc "Chua sua chua"
        if (status != null && !status.equals("Da sua chua") && !status.equals("Chua sua chua")) {
            System.out.println("Trạng thái chỉ được là 'Da sua chua' hoặc 'Chua sua chua'.");
            return false;
        }
        return true;
    }

    // Thêm điện thoại chính hãng
    public void addOfficialPhone(String name, double price, int quantity, String manufacturer,
                                 int warrantyPeriod, String warrantyScope) {
        if (!validateData(name, price, quantity, manufacturer, warrantyPeriod, warrantyScope, null, null)) {
            return;
        }
        int id = getNextId();
        OfficialPhone officialPhone = new OfficialPhone(String.valueOf(id), name, price, quantity, manufacturer, warrantyPeriod, warrantyScope);
        phoneList.add(officialPhone);
        CSVUtils.writeToCSV(phoneList);
        System.out.println("Đã thêm điện thoại chính hãng thành công!");
    }

    // Thêm điện thoại xách tay
    public void addImportedPhone(String name, double price, int quantity, String manufacturer,
                                 String country, String status) {
        if (!validateData(name, price, quantity, manufacturer, 0, null, country, status)) {
            return;
        }
        int id = getNextId();
        ImportedPhone importedPhone = new ImportedPhone(String.valueOf(id), name, price, quantity, manufacturer, country, status);
        phoneList.add(importedPhone);
        CSVUtils.writeToCSV(phoneList);
        System.out.println("Đã thêm điện thoại xách tay thành công!");
    }

    // Hiển thị danh sách điện thoại
    public void displayPhones() {
        for (Phone phone : phoneList) {
            System.out.println(phone.getDetails());
        }
    }
}
