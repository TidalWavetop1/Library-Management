public class ConNguoi {
    protected String ten;       // Tên của người 
    protected int tuoi;         // Tuổi của người
    protected String diaChi;    // Địa chỉ của người

    // Constructor có tham số
    public ConNguoi(String ten, int tuoi, String diaChi) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.diaChi = diaChi;
    }

    // Constructor mặc định
    public ConNguoi() {
    }

    // Getter và Setter
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        if (tuoi > 18) {
            this.tuoi = tuoi;
        } else {
            throw new IllegalArgumentException("Tuoi phai lon hon 18.");
        }
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    // Phương thức hiển thị thông tin
    public void hienThiThongTin() {
        System.out.println("Tên: " + ten);
        System.out.println("Tuổi: " + tuoi);
        System.out.println("Địa chỉ: " + diaChi);
    }
}
