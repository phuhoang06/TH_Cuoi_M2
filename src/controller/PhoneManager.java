package controller;

import model.Phone;
import model.OfficialPhone;
import model.ImportedPhone;
import storage.CSVUtils;

import java.util.List;
import java.util.ArrayList;

public class PhoneManager {
    private List<Phone> phoneList;

    public PhoneManager() {
        this.phoneList = new ArrayList<>();
    }

    // Thêm mới điện thoại vào danh sách
    public void addPhone(Phone phone) {
        phoneList.add(phone);
        CSVUtils.writeToCSV(phoneList);
    }

    // Xóa điện thoại khỏi danh sách
    public void deletePhone(String id) {
        phoneList.removeIf(phone -> phone.getId().equals(id));
        CSVUtils.writeToCSV(phoneList);
    }

    // Tìm kiếm điện thoại theo tên hoặc ID
    public List<Phone> searchPhone(String keyword) {
        List<Phone> result = new ArrayList<>();
        for (Phone phone : phoneList) {
            if (phone.getId().contains(keyword) || phone.getName().contains(keyword)) {
                result.add(phone);
            }
        }
        return result;
    }

    // Hiển thị tất cả điện thoại
    public void displayPhones() {
        for (Phone phone : phoneList) {
            System.out.println(phone.getDetails());
        }
    }

    // Nạp lại danh sách điện thoại từ file CSV
    public void loadPhonesFromCSV() {
        this.phoneList = CSVUtils.readFromCSV();
    }
}
