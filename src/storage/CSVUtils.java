package storage;

import model.Phone;
import model.OfficialPhone;
import model.ImportedPhone;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class CSVUtils {

    // Đọc dữ liệu từ file CSV và trả về danh sách điện thoại
    public static List<Phone> readFromCSV() {
        List<Phone> phones = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("phones.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals("Official")) {
                    phones.add(new OfficialPhone(data[1], data[2], Double.parseDouble(data[3]), Integer.parseInt(data[4]), data[5], Integer.parseInt(data[6]), data[7]));
                } else if (data[0].equals("Imported")) {
                    phones.add(new ImportedPhone(data[1], data[2], Double.parseDouble(data[3]), Integer.parseInt(data[4]), data[5], data[6], data[7]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phones;
    }

    // Ghi danh sách điện thoại vào file CSV
    public static void writeToCSV(List<Phone> phoneList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("phones.csv"))) {
            writer.write("Type,ID,Name,Price,Quantity,Manufacturer,Warranty Period/Warranty Scope/Country/Status\n");
            for (Phone phone : phoneList) {
                if (phone instanceof OfficialPhone) {
                    OfficialPhone officialPhone = (OfficialPhone) phone;
                    writer.write("Official," + officialPhone.getId() + "," + officialPhone.getName() + "," + officialPhone.getPrice() + "," + officialPhone.getQuantity() + "," + officialPhone.getManufacturer() + "," + officialPhone.getWarrantyPeriod() + "," + officialPhone.getWarrantyScope() + "\n");
                } else if (phone instanceof ImportedPhone) {
                    ImportedPhone importedPhone = (ImportedPhone) phone;
                    writer.write("Imported," + importedPhone.getId() + "," + importedPhone.getName() + "," + importedPhone.getPrice() + "," + importedPhone.getQuantity() + "," + importedPhone.getManufacturer() + "," + importedPhone.getCountry() + "," + importedPhone.getStatus() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
