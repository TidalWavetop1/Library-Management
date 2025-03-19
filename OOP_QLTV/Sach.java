import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Sach extends TaiLieu {
    private int soTrang; // Số trang của sách
    private TheLoai theLoai; // Thể loại sách

    // Constructor
    public Sach(String maTaiLieu, String tenTaiLieu, NhaXuatBan nhaXuatBan, TacGia tacGia, int namXuatBan, int soTrang,
            TheLoai theLoai) {
        super(maTaiLieu, tenTaiLieu, nhaXuatBan, tacGia, namXuatBan);
        this.soTrang = soTrang;
        this.theLoai = theLoai;
    }
    public Sach(){

    }
        // Getter và Setter
        public int getSoTrang() {
            return soTrang;
        }
    
        public void setSoTrang(int soTrang) {
            if (soTrang > 0) {
                this.soTrang = soTrang;
            } else {
                System.out.println("So trang phai lon hon 0.");
            }
        }
    
        public TheLoai getTheLoai() {
            return theLoai;
        }
    
        public void setTheLoai(TheLoai theLoai) {
                this.theLoai = theLoai;
    
        }
    
        // Hiển thị thông tin sách
        @Override
        public void hienThiThongTin() {
            
            System.out.println("Ma tai lieu: " + getMaTaiLieu());
            System.out.println("Ten tai lieu: " + getTenTaiLieu());
            getTacGia().hienThiThongTin();
            getNhaXuatBan().hienThiThongTin(); 
            System.out.println("Nam xuat ban: " + getNamXuatBan());
            System.out.println("So trang: " + soTrang);
            System.out.println("The loai: " + theLoai);
        }
    
      public static  Sach[] DocGhiDuLieuSach(boolean ghi, Sach[] dsSach) {
        if (ghi) {
            try {
                FileWriter fw = new FileWriter("./data/Sach.txt");
                BufferedWriter bw = new BufferedWriter(fw);
    
                for (Sach s : dsSach) {
                    bw.write(s.getMaTaiLieu() + ";" + s.getTenTaiLieu() + ";" 
                             + s.getNhaXuatBan().getMaNXB() + ";" 
                             + s.getTacGia().getId() + ";" 
                             + s.getNamXuatBan() + ";" 
                             + s.getSoTrang() + ";" 
                             + s.getTheLoai().getMaTheLoai());
                    bw.newLine(); // Chỉ xuống dòng sau mỗi dòng dữ liệu
                }
    
                bw.close();
                fw.close();
                // System.out.println("Ghi dữ liệu sách thành công.");
            } catch (IOException e) {
                System.err.println("Lỗi khi ghi dữ liệu sách: " + e.getMessage());
            }
        } else {
            try {
                File file = new File("./data/Sach.txt");
                if (!file.exists() || file.length() == 0) {
                    System.err.println("File không tồn tại hoặc trống. Không thể đọc dữ liệu.");
                    return dsSach;
                }
    
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
    
                NhaXuatBan[] dsNXB = NhaXuatBan.DocGhiDuLieuNhaXuatBan(false, new NhaXuatBan[0]);
                TacGia[] dstg = TacGia.DocGhiDuLieuTacGia(false, new TacGia[0]);
                TheLoai[] dstl = TheLoai.DocGhiDuLieuTheLoai(false, new TheLoai[0]);
    
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.trim().isEmpty()) continue; // Bỏ qua dòng trống
    
                    String[] txt = line.split(";");
                    if (txt.length != 7) {
                        System.err.println("Dòng dữ liệu không hợp lệ: " + line);
                        continue; // Bỏ qua dòng lỗi
                    }
    
                    String maTaiLieu = txt[0];
                    String tenTaiLieu = txt[1];
                    NhaXuatBan tmp = NhaXuatBan.SearchId(dsNXB, txt[2]);
                    TacGia tg = TacGia.timKiemTheoId(dstg, txt[3]);
                    int namXuatBan = Integer.parseInt(txt[4]);
                    int soTrang = Integer.parseInt(txt[5]);
                    TheLoai theLoai = TheLoai.SearchId(dstl, txt[6]);
    
                    Sach sach = new Sach(maTaiLieu, tenTaiLieu, tmp, tg, namXuatBan, soTrang, theLoai);
                    dsSach = Sach.addElementBooks(dsSach, sach);
                }
    
                br.close();
                fr.close();
            } catch (IOException e) {
                System.err.println("Lỗi khi đọc dữ liệu sách: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.err.println("Dữ liệu số không hợp lệ: " + e.getMessage());
            }
        }
    
        return dsSach;
    }
    
    
    @Override
    public String toString() {
        return String.format("%-20s %-35s %-15s %-10s %-10d %-5d %-15s", 
                             getMaTaiLieu(), 
                             getTenTaiLieu(), 
                             getNhaXuatBan().getMaNXB(), 
                             getTacGia().getId(), 
                             getNamXuatBan(), 
                             soTrang, 
                             theLoai.getMaTheLoai());
    }
    public static  String head(){
        String header = String.format("%-20s %-30s %-15s %-10s %-10s %-5s %-15s", 
        "Mã Tài Liệu", 
        "Tên Tài Liệu", 
        "Mã NXB", 
        "ID Tác Giả", 
        "Năm XB", 
        "Số Trang", 
        "Mã Thể Loại");
        return header;
    }
    
        // Thêm sách
        public static Sach[] themSach(Sach [] dsSach) {
            Scanner scanner = new Scanner(System.in);
            
    
            System.out.print("Nhập mã tài liệu: ");
            String maTaiLieu = scanner.nextLine();
            System.out.print("Nhập ten tài liệu: ");
            String tenTaiLieu=scanner.nextLine();
            System.out.print("Nhập mã nhà xuất bản: ");
            String maNXB = scanner.nextLine();
            NhaXuatBan []dsNXB=new NhaXuatBan[0];
            dsNXB=NhaXuatBan.DocGhiDuLieuNhaXuatBan(false,dsNXB);
             NhaXuatBan NXB=new NhaXuatBan();
             NXB= NhaXuatBan.SearchId(dsNXB,maNXB);
             while(NXB==null){
                System.out.println("Nha xuat ban ban vua nhap khong ton tai trong CSDL vui long nhap lai");
                 NXB= NhaXuatBan.SearchId(dsNXB,maNXB);
             }
            System.out.print("Nhập mã tác giả: ");
            String idTacGia = scanner.nextLine();
            TacGia []dstg=new TacGia[0];
            dstg=TacGia.DocGhiDuLieuTacGia(false, dstg);
            TacGia tg=new TacGia();
            tg=TacGia.timKiemTheoId(dstg, idTacGia);
            while(tg==null){
                System.out.println("Tac gia ban vua nhap khong co trong co so du lieu vui long nhap lai ");
                tg=TacGia.timKiemTheoId(dstg, scanner.nextLine());
            }
        
            System.out.print("Nhập mã thể loại: ");
            String idTheLoai = scanner.nextLine();
            TheLoai[] dstl=new TheLoai[0];
            dstl=TheLoai.DocGhiDuLieuTheLoai(false, dstl);
            TheLoai theLoai = TheLoai.SearchId(dstl,idTheLoai);
            while(theLoai==null){
                 System.out.println("The loai ban vua nhap khong co trong co so du lieu,vui long nhap lai");
                 theLoai=TheLoai.SearchId(dstl, scanner.nextLine());
            }
            System.out.print("Nhập năm xuất bản: ");
            int namXuatBan = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhập số trang: ");
            int soTrang = scanner.nextInt();
    
    
       
             Sach sachMoi = new Sach(maTaiLieu, tenTaiLieu, NXB,tg, namXuatBan, soTrang, theLoai);
             Sach[] dsMoi = new Sach[dsSach.length + 1];
             System.arraycopy(dsSach, 0, dsMoi, 0, dsSach.length); 
             dsMoi[dsMoi.length - 1] = sachMoi;
    
        
             System.out.println("Da them sach thanh cong!");
             return dsMoi;
        }
    
        // Tìm kiếm bằng tên
        public static void timKiemSachTheoTen(String tuKhoa) {
            Sach[] dsSach = new Sach[0];
            dsSach = DocGhiDuLieuSach(false, dsSach);
            boolean timThay = false;
        
            System.out.println("Ket qua tim kiem sach chua tu \"" + tuKhoa + "\":");
            for (Sach sach : dsSach) {
                if (sach.getTenTaiLieu().toLowerCase().contains(tuKhoa.toLowerCase())) {
                    sach.hienThiThongTin();
                    System.out.println("--------------------");
                    timThay = true;
                }
            }
        
            if (!timThay) {
                System.out.println("Khong tim thay sach nao chua tu khoa \"" + tuKhoa + "\".");
            }
        }
        
    // Tìm kiếm bằng id
    public static Sach timKiemSachTheoID(Sach DS[], String a) {
        for (Sach x : DS) {
            if (x.getMaTaiLieu().equals(a)) {

                return x;
            }
        }
        return null;
    }

    // Xóa
    public static Sach[] xoaSach(String maTaiLieu, Sach[] dSach) {
        boolean timThay = false;
        int indexXoa = -1;
    
        // Tìm vị trí của sách cần xóa
        for (int i = 0; i < dSach.length; i++) {
            if (dSach[i].getMaTaiLieu().equals(maTaiLieu)) {
                timThay = true;
                indexXoa = i;
                break;
            }
        }
    
        if (timThay) {
            // Tạo mảng mới sau khi xóa phần tử
            Sach[] dsMoi = new Sach[dSach.length - 1];
            int j = 0;
            for (int i = 0; i < dSach.length; i++) {
                if (i != indexXoa) {
                    dsMoi[j] = dSach[i];
                    j++;
                }
            }
    
            // Ghi lại dữ liệu nếu cần (giả sử hàm DocGhiDuLieuSach thực hiện điều này)
            DocGhiDuLieuSach(true, dsMoi);
    
            System.out.println("Đã xóa sách với mã tài liệu: " + maTaiLieu);
            return dsMoi;
        } else {
            System.out.println("Không tìm thấy sách với mã tài liệu: " + maTaiLieu);
            return dSach; // Trả lại mảng ban đầu nếu không tìm thấy
        }
    }
    
    
    // Sửa
    public static void suaSach( String maTaiLieu) {
        Scanner sc = new Scanner(System.in);
    
        Sach[] dsSach = new Sach[0];
      dsSach=  DocGhiDuLieuSach(false, dsSach);
        NhaXuatBan[] dsNXB = NhaXuatBan.DocGhiDuLieuNhaXuatBan(false, new NhaXuatBan[0]);
        TacGia[] dsTacGia = TacGia.DocGhiDuLieuTacGia(false, new TacGia[0]);
        TheLoai[] dsTheLoai = TheLoai.DocGhiDuLieuTheLoai(false, new TheLoai[0]);
    
        boolean timThay = false;
    
        for (Sach sach : dsSach) {
            if (sach.getMaTaiLieu().equals(maTaiLieu)) {
                timThay = true;
    
                System.out.println("Thong tin hien tai cua sach:");
                sach.hienThiThongTin();
    
                // Nhập tên tài liệu mới
                System.out.print("Nhap ten tai lieu moi (de trong neu khong muon doi): ");
                String tenTaiLieu = sc.nextLine();
                if (!tenTaiLieu.trim().isEmpty()) {
                    sach.setTenTaiLieu(tenTaiLieu);
                }
    
                // Nhập số trang mới
                System.out.print("Nhap so trang moi (nhap -1 neu khong muon doi): ");
                int soTrang = sc.nextInt();
                sc.nextLine(); // Đọc bỏ dấu Enter
                if (soTrang > 0) {
                    sach.setSoTrang(soTrang);
                }
    
                // Nhập thể loại mới
                String maTheLoai;
                boolean validTheLoai = false;
                do {
                    System.out.print("Nhap ma the loai moi (de trong neu khong muon doi): ");
                    maTheLoai = sc.nextLine();
                    if (!maTheLoai.trim().isEmpty()) {
                        // Kiểm tra mã thể loại có tồn tại không
                        TheLoai theLoai = TheLoai.SearchId(dsTheLoai, maTheLoai);
                        if (theLoai != null) {
                            sach.setTheLoai(theLoai);
                            validTheLoai = true;
                        } else {
                            System.out.println("Ma the loai khong hop le, vui long nhap lai!");
                        }
                    } else {
                        validTheLoai = true; // Không thay đổi thể loại
                    }
                } while (!validTheLoai);
    
                // Nhập mã nhà xuất bản mới
                String maNXB;
                boolean validNXB = false;
                do {
                    System.out.print("Nhap ma nha xuat ban moi (de trong neu khong muon doi): ");
                    maNXB = sc.nextLine();
                    if (!maNXB.trim().isEmpty()) {
                        // Kiểm tra mã nhà xuất bản có tồn tại không
                        NhaXuatBan nhaXuatBan = NhaXuatBan.SearchId(dsNXB, maNXB);
                        if (nhaXuatBan != null) {
                            sach.setNhaXuatBan(nhaXuatBan);
                            validNXB = true;
                        } else {
                            System.out.println("Ma nha xuat ban khong hop le, vui long nhap lai!");
                        }
                    } else {
                        validNXB = true; // Không thay đổi nhà xuất bản
                    }
                } while (!validNXB);
    
                // Nhập mã tác giả mới
                String maTacGia;
                boolean validTacGia = false;
                do {
                    System.out.print("Nhap ma tac gia moi (de trong neu khong muon doi): ");
                    maTacGia = sc.nextLine();
                    if (!maTacGia.trim().isEmpty()) {
                        // Kiểm tra mã tác giả có tồn tại không
                        TacGia tacGia = TacGia.timKiemTheoId(dsTacGia, maTacGia);
                        if (tacGia != null) {
                            sach.setTacGia(tacGia);
                            validTacGia = true;
                        } else {
                            System.out.println("Ma tac gia khong hop le, vui long nhap lai!");
                        }
                    } else {
                        validTacGia = true; // Không thay đổi tác giả
                    }
                } while (!validTacGia);
                System.out.println(sach.toString());
                System.out.println("Sach da duoc cap nhat.");
                break;
            }
        }
    
        if (timThay) {
            // Lưu lại dữ liệu sau khi sửa
            DocGhiDuLieuSach(true, dsSach);
        } else {
            System.out.println("Khong tim thay sach voi ma tai lieu: " + maTaiLieu);
        }
    }
    
    public static Sach[] addElementBooks(Sach[] Sach, Sach tmp) {
        Sach[] array = new Sach[Sach.length+1];
        System.arraycopy(Sach, 0, array, 0, Sach.length);
        array[Sach.length] = tmp;
        return array;}
        public static Sach SearchId(Sach DS[],String a){
            for(Sach x : DS){
                 if(x.getMaTaiLieu().equals(a)){
                   
                  return x;
                 }
            }
              return null;
          }

     
        // public TaiLieu[] DocGhiDuLieuTaiLieu(Boolean ghi, TaiLieu[] taiLieu) {
        //     // TODO Auto-generated method stub
        //     throw new UnsupportedOperationException("Unimplemented method 'DocGhiDuLieuTaiLieu'");
        // }
}
