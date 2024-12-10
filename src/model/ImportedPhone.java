package model;

public class ImportedPhone extends Phone {
    private String country;  // Quốc gia xách tay
    private String status;   // Trạng thái ("Mới" hoặc "Đã qua sử dụng")

    // Constructor
    public ImportedPhone(String id, String name, double price, int quantity, String manufacturer, String country, String status) {
        super(id, name, price, quantity, manufacturer);
        this.country = country;
        this.status = status;
    }

    // Overridden method to get details of imported phone
    @Override
    public String getDetails() {
        return "ImportedPhone [ID=" + getId() + ", Name=" + getName() + ", Price=" + getPrice() + ", Quantity=" + getQuantity() + ", Manufacturer=" + getManufacturer() + ", Country=" + country + ", Status=" + status + "]";
    }

    // Getters and Setters
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

