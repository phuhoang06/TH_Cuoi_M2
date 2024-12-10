package model;

public class OfficialPhone extends Phone {
    private int warrantyPeriod; // Thời gian bảo hành (tháng)
    private String warrantyScope; // Phạm vi bảo hành ("Trong nước" hoặc "Quốc tế")

    // Constructor
    public OfficialPhone(String id, String name, double price, int quantity, String manufacturer, int warrantyPeriod, String warrantyScope) {
        super(id, name, price, quantity, manufacturer);
        this.warrantyPeriod = warrantyPeriod;
        this.warrantyScope = warrantyScope;
    }

    // Overridden method to get details of official phone
    @Override
    public String getDetails() {
        return "OfficialPhone [ID=" + getId() + ", Name=" + getName() + ", Price=" + getPrice() + ", Quantity=" + getQuantity() + ", Manufacturer=" + getManufacturer() + ", Warranty Period=" + warrantyPeriod + " months, Warranty Scope=" + warrantyScope + "]";
    }

    // Getters and Setters
    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getWarrantyScope() {
        return warrantyScope;
    }

    public void setWarrantyScope(String warrantyScope) {
        this.warrantyScope = warrantyScope;
    }
}

