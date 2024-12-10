package model;

public class OfficialPhone extends Phone {
    private int warrantyPeriod; // Thời gian bảo hành (tháng)
    private String warrantyScope; // Phạm vi bảo hành ("Toan Quoc" hoặc "Quoc Te")

    public OfficialPhone(String id, String name, double price, int quantity, String manufacturer, int warrantyPeriod, String warrantyScope) {
        super(id, name, price, quantity, manufacturer);
        this.warrantyPeriod = warrantyPeriod;
        this.warrantyScope = warrantyScope;
    }

    @Override
    public String getDetails() {
        return super.toString() +
                ", Thời gian bảo hành: " + warrantyPeriod + " tháng" +
                ", Phạm vi bảo hành: " + warrantyScope;
    }
}
