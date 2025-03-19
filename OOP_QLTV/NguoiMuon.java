import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class NguoiMuon extends ConNguoi {
    private String maNguoiMuon; // Mã người mượn
    private TheThuVien theThuVien; // Thẻ thư viện của người mượn

    // Constructor
    public NguoiMuon(String maNguoiMuon, String ten, int tuoi, String diaChi, TheThuVien theThuVien) {
        super(ten, tuoi, diaChi); // Gọi constructor của lớp ConNguoi
        this.maNguoiMuon = maNguoiMuon;
        this.theThuVien = theThuVien;
        // this.sachMuon = new Sach[10]; // Giới hạn mượn tối đa 10 sách
        // this.soLuongSachMuon = 0;
    }

    // Getter và Setter
    public String getMaNguoiMuon() {
        return maNguoiMuon;
    }

    public void setMaNguoiMuon(String maNguoiMuon) {
        this.maNguoiMuon = maNguoiMuon;
    }

    public TheThuVien getTheThuVien() {
        return theThuVien;
    }

    public void setTheThuVien(TheThuVien theThuVien) {
        this.theThuVien = theThuVien;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-20s %-5d %-20s %-10s %-5s",
                maNguoiMuon, ten, tuoi, diaChi, theThuVien.getMaThe(), theThuVien.getLoaiThe());
    }

    public static String head() {
        return String.format("%-12s %-20s %-5s %-25s %-12s %-8s\n",
                "MaMuon", "Ten", "Tuoi", "DiaChi", "MaThe", "LoaiThe") +
                "-------------------------------------------------------------";
    }

    // Phương thức hiển thị thông tin người mượn
    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin(); // Hiển thị thông tin của người (từ lớp ConNguoi)
        System.out.println("Ma nguoi muon: " + maNguoiMuon);
        System.out.println("The thu vien: " + theThuVien.getMaThe() + " - Loai: " + theThuVien.getLoaiThe());
        // System.out.println("Số lượng sách đã mượn: " + soLuongSachMuon);
        // System.out.println("Danh sách sách đã mượn: ");
        // for (int i = 0; i < soLuongSachMuon; i++) {
        // System.out.println("- " + sachMuon[i].getTenTaiLieu());
        // }
    }

    // Tính phí dựa trên loại thẻ và thời gian mượn
    public double tinhPhiMuuon() {
        int soNgayMuon = 0;
        if (theThuVien.getLoaiThe().equals("A")) {
            soNgayMuon = 30; // Thẻ A mượn tối đa 30 ngày
        } else if (theThuVien.getLoaiThe().equals("B")) {
            soNgayMuon = 15; // Thẻ B mượn tối đa 15 ngày
        }

        // Tính phí: Giả sử mỗi ngày tính phí 500 đồng
        double phi = soNgayMuon * 500;
        System.out.println("Phí mượn sách: " + phi + " VND");
        return phi;
    }

    public static NguoiMuon[] NhapGhiDL(boolean a, NguoiMuon DS[]) {
        int sl;
        if (a) {
            // Ghi dữ liệu
            try (FileWriter fw = new FileWriter("./data/NguoiMuon.txt");
                    BufferedWriter bw = new BufferedWriter(fw)) {

                for (NguoiMuon nguoiMuon : DS) {
                    bw.write(String.format("%s;%s;%d;%s;%s",
                            nguoiMuon.getMaNguoiMuon(),
                            nguoiMuon.getTen(),
                            nguoiMuon.getTuoi(),
                            nguoiMuon.getDiaChi(),
                            nguoiMuon.getTheThuVien().getMaThe()));
                    bw.newLine();
                }
            } catch (Exception e) {
                System.out.println("Loi khi ghi file: " + e.getMessage());
            }
        } else {
            // Đọc dữ liệu
            try (FileReader fr = new FileReader("./data/NguoiMuon.txt");
                    BufferedReader br = new BufferedReader(fr)) {
                DS = new NguoiMuon[0]; // Start with an empty array

                String line;
                TheThuVien[] dsttv = new TheThuVien[0];
                dsttv = TheThuVien.DocGhiDuLieuTheThuVien(false, dsttv);
                while ((line = br.readLine()) != null && !line.isEmpty()) {
                    String[] txt = line.split(";");
                    String maNguoiMuon = txt[0];
                    String ten = txt[1];
                    int tuoi = Integer.parseInt(txt[2]);
                    String diaChi = txt[3];
                    String maThe = txt[4];

                    // Tạo đối tượng TheThuVien (giả sử có phương thức tạo từ mã thẻ)
                    TheThuVien theThuVien = TheThuVien.SearchId(dsttv, maThe);

                    NguoiMuon tmp = new NguoiMuon(maNguoiMuon, ten, tuoi, diaChi, theThuVien);
                    DS = addElementNguoiMuon(DS, tmp);
                }
            } catch (Exception e) {
                System.out.println("Loi khi doc file: " + e.getMessage());
            }
        }
        return DS;
    }

    public static NguoiMuon[] addElementNguoiMuon(NguoiMuon DS[], NguoiMuon tmp) {
        NguoiMuon[] array = new NguoiMuon[DS.length + 1];
        System.arraycopy(DS, 0, array, 0, DS.length);
        array[DS.length] = tmp;
        return array;
    }

    public static NguoiMuon SearchId(NguoiMuon DS[], String maMguoiMuon) {
        for (NguoiMuon x : DS) {
            if (x.getMaNguoiMuon().equals(maMguoiMuon)) {
                return x;
            }
        }
        return null;
    }

    public static boolean suaNguoiMuon(NguoiMuon[] DS, String maNguoiMuon, String tenMoi, int tuoiMoi, String diaChiMoi,
            TheThuVien theThuVienMoi) {
        NguoiMuon nguoiMuonCanSua = SearchId(DS, maNguoiMuon);
        if (nguoiMuonCanSua == null) {
            System.out.println("Khong tim thay nguoi muon voi ma " + maNguoiMuon);
            return false;
        }

        // Kiểm tra xem thông tin mới có trùng với người mượn khác không
        for (NguoiMuon nm : DS) {
            if (nm != nguoiMuonCanSua &&
                    nm.getTen().equals(tenMoi) &&
                    nm.getTuoi() == tuoiMoi &&
                    nm.getDiaChi().equals(diaChiMoi) &&
                    nm.getTheThuVien().getMaThe().equals(theThuVienMoi.getMaThe())) {
                System.out.println("Thong tin moi trung voi mot nguoi muon khac.");
                return false;
            }
        }

        // Cập nhật thông tin
        nguoiMuonCanSua.setTen(tenMoi);
        nguoiMuonCanSua.setTuoi(tuoiMoi);
        nguoiMuonCanSua.setDiaChi(diaChiMoi);
        nguoiMuonCanSua.setTheThuVien(theThuVienMoi);

        System.out.println("Da cap nhat thong tin nguoi muon thanh cong");
        return true;
    }

    public static NguoiMuon[] xoaNguoiMuon(NguoiMuon[] DS, String maNguoiMuon) {
        int indexCanXoa = -1;
        for (int i = 0; i < DS.length; i++) {
            if (DS[i].getMaNguoiMuon().equals(maNguoiMuon)) {
                indexCanXoa = i;
                break;
            }
        }

        if (indexCanXoa == -1) {
            System.out.println("Khong tim thay nguoi muon voi ma " + maNguoiMuon);
            return DS;
        }

        NguoiMuon[] newDS = new NguoiMuon[DS.length - 1];
        for (int i = 0, j = 0; i < DS.length; i++) {
            if (i != indexCanXoa) {
                newDS[j++] = DS[i];
            }
        }

        System.out.println("Da xoa nguoi muon thanh cong.");
        return newDS;
    }

    public static NguoiMuon[] findNameThuMuon_tuongdoi(NguoiMuon[] DS, String tenNguoiMuon) {
        NguoiMuon[] ketQua = new NguoiMuon[0];
        for (NguoiMuon nm : DS) {
            if (nm.getTen().toLowerCase().contains(tenNguoiMuon.toLowerCase())) {
                ketQua = addElementNguoiMuon(ketQua, nm);
            }
        }
        return ketQua;
    }
}
