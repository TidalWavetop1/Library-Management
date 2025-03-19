public class LoaiA extends TheThuVien{
    private  int soNgayMuon=30;  
    private double phiThuongNien=100000; // Phí thường niên
    private int slSachMuon=7;

    public LoaiA(String id, String loaiThe) {
        setMaThe(id);
        setLoaiThe(loaiThe); // Gán loaiThe từ đối số
    }
    public LoaiA(String maThe) {
        super(maThe, "A");
    }
    public void setSoNgayMuon(int soNgayMuon) {
        this.soNgayMuon = soNgayMuon;
    }

    public double getPhiThuongNien() {
        return phiThuongNien;
    }

    public void setPhiThuongNien(double phiThuongNien) {
        this.phiThuongNien = phiThuongNien;
    }

    @Override
    public int getSlsachmuon() {
        return slSachMuon;
    }
    @Override
    public int getSoNgayMuon() {
        return soNgayMuon;
    }
    
    

}
