public class LoaiB extends TheThuVien{
    private  int soNgayMuon=15;  
    private double phiThuongNien=50000; // Phí thường niên
    private int slSachMuon=4;

    @Override
    public int getSoNgayMuon() {
        return soNgayMuon;
    }
    public LoaiB(String id, String loaiThe) {
        setMaThe(id);
        setLoaiThe(loaiThe); // Gán loaiThe từ đối số
    }
    public LoaiB(String maThe) {
        super(maThe, "B");
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

}
