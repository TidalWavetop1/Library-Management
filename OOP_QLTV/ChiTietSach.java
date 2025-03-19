import java.io.*;
import java.util.Scanner;

public class ChiTietSach {
    String id;
    private Sach sach; // Thông tin sách
    private viTri Vtri; // Vị trí của sách trong thư viện
        private TheThuVien theThuVien; // Người mượn sách (nếu có)
    
        // Constructor
        public ChiTietSach(String id,Sach sach, viTri Vtri) {
            this.id=id;
            this.sach = sach;
            this.Vtri=Vtri;
            this.theThuVien = null;
        }
    
        public ChiTietSach(String id,Sach sach, viTri Vtri, TheThuVien theThuVien) {
            this.id=id;
            this.sach = sach;
            this.Vtri = Vtri;
            this.theThuVien = theThuVien;
        }

    // Getter và Setter
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
        
        public Sach getSach() {
            return sach;
        }
    
        public void setSach(Sach sach) {
            this.sach = sach;
        }
    
        public viTri getViTri() {
            return Vtri;
        }
    
        public void setViTri(viTri viTri) {
            this.Vtri = viTri;
        }
    
        public TheThuVien getTheThuVien() {
            return theThuVien;
        }
    
        public void setTheThuVien(TheThuVien theThuVien) {
            this.theThuVien = theThuVien;
        }
    
     
    
        // Ghi hoặc đọc dữ liệu
        /**
         * @param ghi
         * @param dsChiTietSach
         * @return
         */
        public static ChiTietSach[] DocGhiDuLieuChiTietSach(boolean ghi, ChiTietSach[] dsChiTietSach) {
            if (ghi) { // Ghi dữ liệu
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("./data/ChiTietSach.txt"))) {
                    for (ChiTietSach c : dsChiTietSach) {
                        String ttv;
                        if(c.theThuVien==null){
                            ttv="0000";
                        }
                        else{
                           ttv=c.getTheThuVien().getMaThe();
                        }
                        bw.write(c.id+";"+c.sach.getMaTaiLieu() + ";" + c.getViTri().getId() + ";" + ttv);
                        bw.newLine();
                    }
                    // System.out.println("Ghi dữ liệu thành công!");
                } catch (IOException e) {
                    System.err.println("Lỗi ghi dữ liệu: " + e.getMessage());
                }
            } else { // Đọc dữ liệu
                try (BufferedReader br = new BufferedReader(new FileReader("./data/ChiTietSach.txt"))) {
                    Sach[] dsSach = Sach.DocGhiDuLieuSach(false, new Sach[0]);
                    TheThuVien[] dsThe = TheThuVien.DocGhiDuLieuTheThuVien(false, new TheThuVien[0]);
                    viTri []ViTri=new viTri[0];
                    ViTri= viTri.DocGhiDuLieuViTri(false, ViTri);
                    TheThuVien.DocGhiDuLieuTheThuVien(false, dsThe);
                while (true) {
                    String line = br.readLine();
                    if (line == null || line.isEmpty()) break;
                    String tmp[] = line.split(";");
                    String MaCTSach=tmp[0];
                    String maSach = tmp[1];
                    String vTri = tmp[2];
                    String maThethuVien = tmp[3];
                    Sach sach=Sach.SearchId(dsSach, maSach);
                    viTri vtri=new viTri();      
                    vtri=viTri.SearchId(ViTri, vTri);
                    TheThuVien the =new TheThuVien() {
                        @Override
                        public int getSlsachmuon() {
                            throw new UnsupportedOperationException("Not supported yet.");
                        }

                        @Override
                        public int getSoNgayMuon() {
                            throw new UnsupportedOperationException("Not supported yet.");
                        }
                    };
                    the=TheThuVien.SearchId(dsThe, maThethuVien);
                   
                        ChiTietSach a=new ChiTietSach(MaCTSach, sach, vtri, the);
                        dsChiTietSach= themChiTietSach(dsChiTietSach, a);
                
                  
             
                     
                }
             
                // System.out.println("Đọc dữ liệu thành công!");
            } catch (IOException | NumberFormatException e) {
                System.err.println("Lỗi đọc dữ liệu: " + e.getMessage());
            }
        }
     
        return dsChiTietSach;
    }
    public static String head(){
        String header = String.format("%-10s %-40s %-10s %-10s", 
        "Mã Số", 
        "Tên Sách", 
        "Mã Vị Trí", 
        "Mã Thẻ");
       return header;
    }
    @Override
    public String toString() {
        if(getTheThuVien()==null){
            return String.format(
                "%-10s %-40s %-10s %-10s", 
                getId(), 
                getSach().getTenTaiLieu(), 
                getViTri().getId(), 
                "0000"
            );
        }
        return String.format(
            "%-10s %-40s %-10s %-10s", 
            getId(), 
            getSach().getTenTaiLieu(), 
            getViTri().getId(), 
            getTheThuVien().getMaThe()
        );
    }
    
    public static void printHeader() {
        System.out.printf("%-10s %-40s %-10s %-10s%n", "ID", "Ten Tai Lieu", "Vi Tri", "Ma The");
    }
    
    // Thêm mới chi tiết sách
    public static ChiTietSach[] themChiTietSach(ChiTietSach[] dsChiTietSach, ChiTietSach chiTietMoi) {
        ChiTietSach[] dsMoi = new ChiTietSach[dsChiTietSach.length + 1];
        System.arraycopy(dsChiTietSach, 0, dsMoi, 0, dsChiTietSach.length);
        dsMoi[dsChiTietSach.length] = chiTietMoi;
        // DocGhiDuLieuChiTietSach(true, dsMoi);
        // System.out.println("Thêm mới chi tiết sách thành công!");
        return dsMoi;
    }

 public static void themCTSach(ChiTietSach[] dsChiTietSachs) {
    @SuppressWarnings("resource")
    Scanner scanner = new Scanner(System.in);
    System.out.println("Nhap so luong chi tiet sach muon them: ");
    int soLuong = scanner.nextInt();
    scanner.nextLine(); // Đọc bỏ dòng trống

    ChiTietSach[] dsMoi = dsChiTietSachs; // Sao chép danh sách ban đầu
   
    for (int i = 0; i < soLuong; i++) {
        System.out.println("Nhap thong tin chi tiet sach thu " + (i + 1) + ":");

        System.out.print("Nhap ma chi tiet sach: ");
        String maChiTiet = scanner.nextLine();
        System.out.print("Nhap ma tua sach: ");
        String maTuaSach = scanner.nextLine();
        Sach [] DS=new Sach[0];
        DS=Sach.DocGhiDuLieuSach(false, DS);
        Sach sach=Sach.SearchId(DS, maTuaSach);
        while (sach==null) { 
           System.out.println("Ma sach vua nhap khong ton tai");
           System.out.println("Vui long nhap lai");
           sach=Sach.SearchId(DS, scanner.nextLine());
        }

        System.out.print("Nhap ma vi tri: ");
        String maViTri = scanner.nextLine();
        viTri dsvt[]=new viTri[0];
        dsvt=viTri.DocGhiDuLieuViTri(false, dsvt);
        viTri Vitri=viTri.SearchId(dsvt, maViTri);
        while(Vitri==null){
            System.out.println("Ma vi tri ban vua nhap khong ton tai");
            System.out.println("Vui long nhap lai");
            Vitri=viTri.SearchId(dsvt, scanner.nextLine());
        }
        System.out.print("Nhap ma the thu vien: ");
        String maTheThuVien = scanner.nextLine();
        TheThuVien []dsthe=new TheThuVien[0];
        dsthe=TheThuVien.DocGhiDuLieuTheThuVien(false, dsthe);
        TheThuVien the= TheThuVien.SearchId(dsthe, maTheThuVien);

        // Tạo đối tượng mới
        ChiTietSach chiTietMoi = new ChiTietSach(maChiTiet, sach, Vitri, the);

        // Thêm vào danh sách
        dsMoi = themChiTietSach(dsMoi, chiTietMoi);
    }

    System.out.println("Danh sach sau khi them:");
    for (ChiTietSach chiTiet : dsMoi) {
        System.out.println(chiTiet);
    }
    DocGhiDuLieuChiTietSach(true, dsMoi);
}
public static void suaCTSach(ChiTietSach[] dsChiTietSachs) {
    @SuppressWarnings("resource")
    Scanner scanner = new Scanner(System.in);

    System.out.println("Nhap ma chi tiet sach can sua: ");
    String maChiTietCanSua = scanner.nextLine();

    // Tìm chi tiết sách theo mã
    ChiTietSach chiTietCanSua = null;
    for (ChiTietSach chiTiet : dsChiTietSachs) {
        if (chiTiet.getId().equals(maChiTietCanSua)) {
            chiTietCanSua = chiTiet;
            break;
        }
    }

    if (chiTietCanSua == null) {
        System.out.println("Ma chi tiet sach khong ton tai!");
        return;
    }

    // Hiển thị thông tin hiện tại
    System.out.println("Thong tin hien tai:");
    System.out.println(chiTietCanSua);

    // Sửa thông tin
    System.out.print("Nhap ma tua sach moi (hoac enter de giu nguyen): ");
    String maTuaSachMoi = scanner.nextLine();
    if (!maTuaSachMoi.isEmpty()) {
        Sach[] DS = Sach.DocGhiDuLieuSach(false, new Sach[0]);
        Sach sachMoi = Sach.SearchId(DS, maTuaSachMoi);
        while (sachMoi == null) {
            System.out.println("Ma tua sach khong ton tai, vui long nhap lai:");
            maTuaSachMoi = scanner.nextLine();
            sachMoi = Sach.SearchId(DS, maTuaSachMoi);
        }
        chiTietCanSua.setSach(sachMoi);
    }

    System.out.print("Nhap ma vi tri moi (hoac enter de giu nguyen): ");
    String maViTriMoi = scanner.nextLine();
    if (!maViTriMoi.isEmpty()) {
        viTri[] dsvt = viTri.DocGhiDuLieuViTri(false, new viTri[0]);
        viTri viTriMoi = viTri.SearchId(dsvt, maViTriMoi);
        while (viTriMoi == null) {
            System.out.println("Ma vi tri khong ton tai, vui long nhap lai:");
            maViTriMoi = scanner.nextLine();
            viTriMoi = viTri.SearchId(dsvt, maViTriMoi);
        }
        chiTietCanSua.setViTri(viTriMoi);
    }

    System.out.print("Nhap ma the thu vien moi (hoac enter de giu nguyen): ");
    String maTheThuVienMoi = scanner.nextLine();
    if (!maTheThuVienMoi.isEmpty()) {
        TheThuVien[] dsthe = TheThuVien.DocGhiDuLieuTheThuVien(false, new TheThuVien[0]);
        TheThuVien theMoi = TheThuVien.SearchId(dsthe, maTheThuVienMoi);
        while (theMoi == null) {
            System.out.println("Ma the thu vien khong ton tai, vui long nhap lai:");
            maTheThuVienMoi = scanner.nextLine();
            theMoi = TheThuVien.SearchId(dsthe, maTheThuVienMoi);
        }
        chiTietCanSua.setTheThuVien(theMoi);
    }

    System.out.println("Da cap nhat thong tin chi tiet sach thanh cong!");
    System.out.println("Thong tin moi:");
    System.out.println(chiTietCanSua);

    // Lưu dữ liệu sau khi sửa
    DocGhiDuLieuChiTietSach(true, dsChiTietSachs);
}
public static ChiTietSach[] xoaCTSach(ChiTietSach[] dsChiTietSachs) {
    try (Scanner scanner = new Scanner(System.in)) {
        System.out.println("Nhap ma chi tiet sach can xoa: ");
        String maChiTietCanXoa = scanner.nextLine();

        // Tìm chỉ mục của chi tiết sách cần xóa
        int indexCanXoa = -1;
        for (int i = 0; i < dsChiTietSachs.length; i++) {
            if (dsChiTietSachs[i].getId().equals(maChiTietCanXoa)) {
                indexCanXoa = i;
                break;
            }
        }

        if (indexCanXoa == -1) {
            System.out.println("Ma chi tiet sach khong ton tai!");
            return dsChiTietSachs; // Trả về danh sách gốc nếu không tìm thấy
        }

        // Xác nhận xóa
        System.out.println("Ban co chac chan muon xoa chi tiet sach nay? (y/n): ");
        String confirm = scanner.nextLine();
        if (!confirm.equalsIgnoreCase("y")) {
            System.out.println("Da huy thao tac xoa.");
            return dsChiTietSachs;
        }

        // Tạo danh sách mới sau khi xóa
        ChiTietSach[] dsMoi = new ChiTietSach[dsChiTietSachs.length - 1];
        for (int i = 0, j = 0; i < dsChiTietSachs.length; i++) {
            if (i != indexCanXoa) {
                dsMoi[j++] = dsChiTietSachs[i];
            }
        }

        System.out.println("Da xoa chi tiet sach thanh cong!");

        // Lưu danh sách sau khi xóa
        DocGhiDuLieuChiTietSach(true, dsMoi);

        return dsMoi; // Trả về danh sách mới
    }
}



    // // Tìm kiếm sách theo mã
    public static ChiTietSach timKiemChiTietSachTheoID(ChiTietSach[] dsChiTietSach, String maSach) {
        for (ChiTietSach cts : dsChiTietSach) {
            if (cts.id.equals(maSach)) {
                return cts;
            }
        }
        return null;
    }

    // // Tìm kiếm sách theo tên
    // public static void timKiemChiTietSachBangTen(ChiTietSach[] dsChiTietSach, String tuKhoa) {
    //     boolean timThay = false;
    //     for (ChiTietSach cts : dsChiTietSach) {
    //         if (cts.getSach().getTenTaiLieu().toLowerCase().contains(tuKhoa.toLowerCase())) {
    //             System.out.println(cts);
    //             timThay = true;
    //         }
    //     }
    //     if (!timThay) {
    //         System.out.println("Không tìm thấy sách với từ khóa \"" + tuKhoa + "\".");
    //     }
    // }
}
