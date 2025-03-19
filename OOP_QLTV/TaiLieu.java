
public abstract class TaiLieu {
    private String maTaiLieu; // Mã tài liệu
    private String tenTaiLieu; // Tên tài liệu
    private TacGia tacGia; // Tham chiếu đến tác giả
    private NhaXuatBan nhaXuatBan; // Tham chiếu đến nhà xuất bản
    private int namXuatBan; // Năm xuất bản

    // Constructor
    public TaiLieu(String maTaiLieu, String tenTaiLieu, NhaXuatBan nhaXuatBan, TacGia tacGia, int namXuatBan) {
        this.maTaiLieu = maTaiLieu;
        this.tenTaiLieu = tenTaiLieu;
        this.nhaXuatBan = nhaXuatBan;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
    }
    public TaiLieu(){}
    // Getter và Setter
    public String getMaTaiLieu() {
        return maTaiLieu;
    }

    public void setMaTaiLieu(String maTaiLieu) {
        if (maTaiLieu == null || maTaiLieu.length() != 6 || !maTaiLieu.startsWith("TL")) {
            System.out.println("Ma tai lieu phai bat dau bang 'TL' va theo sau la 4 so.");
            return;
        }

        String soSo = maTaiLieu.substring(2);
        try {
            int so = Integer.parseInt(soSo);
            if (so < 0 || so > 9999) {
                System.out.println("Sau 'TL' phai la 4 chu so.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Ma tai lieu khong hop le.");
            return;
        }

        this.maTaiLieu = maTaiLieu;
    }

    public String getTenTaiLieu() {
        return tenTaiLieu;
    }

    public void setTenTaiLieu(String tenTaiLieu) {
        this.tenTaiLieu = tenTaiLieu;
    }

    public NhaXuatBan getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(NhaXuatBan nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public TacGia getTacGia() {
        return tacGia;
    }

    public void setTacGia(TacGia tacGia) {
        this.tacGia = tacGia;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        int currentYear = java.time.Year.now().getValue();
        if (namXuatBan >= 1000 && namXuatBan <= currentYear) {
            this.namXuatBan = namXuatBan;
        } else {
            System.out.println("Nam xuat ban khong hop le. Vui long nhap nam tu 1000 den " + currentYear + ".");
        }
    }

     

    // Phương thức hiển thị thông tin tài liệu
    public abstract void hienThiThongTin();

    @Override
    public String toString() {
        return this.maTaiLieu + ";" + this.tenTaiLieu + ";" + this.nhaXuatBan.getMaNXB()+ ";" + this.tacGia.getId() + ";" + this.namXuatBan;
    }
}
