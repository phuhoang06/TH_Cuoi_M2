package model;

public class ImportedPhone extends Phone {
    private String country;  // Quốc gia xách tay
    private String status;   // Trạng thái ("Da sua chua" hoặc "Chua sua chua")

    public ImportedPhone(String id, String name, double price, int quantity, String manufacturer, String country, String status) {
        super(id, name, price, quantity, manufacturer);
        this.country = country;
        this.status = status;
    }

    @Override
    public String getDetails() {
        return super.toString() +
                ", Quốc gia xách tay: " + country +
                ", Trạng thái: " + status;
    }
}
