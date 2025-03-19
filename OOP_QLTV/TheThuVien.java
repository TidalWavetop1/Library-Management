import java.io.*;
import java.util.Scanner;
public abstract  class TheThuVien {
    private String maThe; // Mã thẻ
    private String loaiThe; // Loại thẻ A hoặc B
    public static final int ID_LENGTH = 4;

    public TheThuVien(){
        
    }

    // Constructor để tạo thẻ thư viện, mặc định sẽ có loại thẻ A hoặc B
    public TheThuVien(String maThe, String loaiThe) {
        this.maThe = maThe;
        this.loaiThe = loaiThe;
        // Cài đặt thông tin cho từng loại thẻ
        // if (loaiThe.equals("A")) {
        //     this.soNgayMuon = 30; // Thẻ A mượn 30 ngày
        //     this.phiThuongNien = 100000; // Phí thường niên cho thẻ A
        //     this.slSachMuon=7;
        // } else if (loaiThe.equals("B")) {
        //     this.soNgayMuon = 15; // Thẻ B mượn 15 ngày
        //     this.phiThuongNien = 50000; // Phí thường niên cho thẻ B
        //     this.slSachMuon=4;
        // } else {
        //     this.soNgayMuon = 0;
        //     this.phiThuongNien = 0;
        //     // System.out.println("Loại thẻ không hợp lệ.");
        // }
    }

    // Getter và Setter
    public String getMaThe() {
        return maThe;
    }

    public void setMaThe(String maThe) {
        if(isValidId(maThe)) {
            this.maThe = maThe;
        }
        else {
            throw new IllegalArgumentException("ID phải là chuỗi gồm 4 chữ số.");
        }
    }

    public String getLoaiThe() {
        return loaiThe;
    }

    public void setLoaiThe(String loaiThe) {
        this.loaiThe = loaiThe;
    }
    public abstract int getSlsachmuon();
    public abstract int getSoNgayMuon();

    public static boolean isValidId(String maThe) {
        if (maThe.length() != ID_LENGTH) {
            System.out.println("ID phải có đúng " + ID_LENGTH + " chữ số.");
            return false;
        }
        if (!maThe.matches("^[0-9]+$")) {
            System.out.println("ID chỉ được chứa các chữ số.");
            return false;
        }
        return true;
    }

    public static boolean isIdExist(TheThuVien[] theThuVien, String id) {
        return SearchId(theThuVien, id) != null;
    }

    public static TheThuVien SearchId(TheThuVien[] theThuVien, String id) {
        for (TheThuVien x : theThuVien) {
            // Kiểm tra xem đối tượng x có phải là null không và mã thẻ có khớp không
            if (x != null && x.getMaThe() != null && x.getMaThe().equals(id)) {
                // Kiểm tra loại thẻ và trả về đối tượng tương ứng
                if (x.getLoaiThe().equals("A")) {
                    return new LoaiA(x.getMaThe());  // Trả về đối tượng LoaiA
                } else if (x.getLoaiThe().equals("B")) {
                    return new LoaiB(x.getMaThe());  // Trả về đối tượng LoaiB
                }
            }
        }
        return null;  // Nếu không tìm thấy thẻ nào khớp với id
    }
    
    // Phương thức nhập thông tin
    public void nhapThongTin(TheThuVien[] theThuVien) {
        Scanner sc = new Scanner(System.in);
    
        do {
            System.out.print("Nhập mã thẻ thư viện (4 chữ số): ");
            String inputId = sc.nextLine();
    
            // Kiểm tra mã thẻ phải là 4 chữ số
            if (!inputId.matches("\\d{4}")) {
                System.out.println("Mã thẻ không hợp lệ. Mã thẻ phải là 4 chữ số.");
                continue; // Yêu cầu nhập lại nếu mã thẻ không hợp lệ
            }
    
            try {
                setMaThe(inputId); // Gọi setter để kiểm tra tính hợp lệ
                if (SearchId(theThuVien, inputId) != null) {
                    System.out.println("ID vừa nhập đã tồn tại, vui lòng nhập ID khác.");
                } else {
                    break; // ID hợp lệ, thoát khỏi vòng lặp
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    
        System.out.print("Nhập loại thẻ thư viện (A hoặc B): ");
        loaiThe = sc.nextLine();
        while (!loaiThe.equals("A") && !loaiThe.equals("B")) {
            System.out.println("Loại thẻ không hợp lệ. Vui lòng nhập lại (A hoặc B).");
            System.out.print("Nhập loại thẻ thư viện (A hoặc B): ");
            loaiThe = sc.nextLine();
        }
    }
    
    public static TheThuVien[] themThe(TheThuVien[] theThuVien, TheThuVien tmp) {
        if (isIdExist(theThuVien, tmp.getMaThe())) {
            System.out.println("ID đã tồn tại. Không thể thêm.");
            return theThuVien;
        }
        TheThuVien[] array = new TheThuVien[theThuVien.length + 1];
        System.arraycopy(theThuVien, 0, array, 0, theThuVien.length);
        array[theThuVien.length] = tmp;
        return array;
    }

    public static TheThuVien[] chinhThe(TheThuVien[] theThuVien, String id, String theMoi) {
        TheThuVien x = SearchId(theThuVien, id);
        if (x != null) {
            for(TheThuVien tmp: theThuVien){
               if(tmp.maThe!=null){
     if(tmp.maThe.equals(id)){
                 tmp.setLoaiThe(theMoi);
               }
               }
          
            }
             System.out.println("Cập nhật thành công.");
         } else {
             System.out.println("Không tìm thấy danh mục cần sửa.");
         }
         return theThuVien;
    }

    public static TheThuVien[] xoaThe(TheThuVien[] theThuVien, String id) {
        if (!isIdExist(theThuVien, id)) {
            System.out.println("Không tìm thấy danh mục cần xóa.");
            return theThuVien;
        }

        int index = -1;
        for (int i = 0; i < theThuVien.length; i++) {
            if (theThuVien[i].getMaThe().equals(id)) {
                index = i;
                break;
            }
        }

        TheThuVien[] newArray = new TheThuVien[theThuVien.length - 1];
        System.arraycopy(theThuVien, 0, newArray, 0, index);
        System.arraycopy(theThuVien, index + 1, newArray, index, theThuVien.length - index - 1);

        System.out.println("Danh mục đã được xóa.");
        return newArray;
    }

    public static TheThuVien[] DocGhiDuLieuTheThuVien(boolean ghi, TheThuVien[] theThuVien) {
        if (ghi) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("./data/TheThuVien.txt"))) {
                bw.write("" + theThuVien.length);
                bw.newLine();
                for (TheThuVien t : theThuVien) {
                    bw.write(t.getMaThe() + ";" + t.getLoaiThe());
                    bw.newLine();
                }
            } catch (IOException e) {
                System.out.println("Lỗi khi ghi dữ liệu: " + e.getMessage());
            }
        } else {
            try (BufferedReader br = new BufferedReader(new FileReader("./data/TheThuVien.txt"))) {
                int slTheThuVien = Integer.parseInt(br.readLine());
                TheThuVien[] array = new TheThuVien[slTheThuVien];
                for (int i = 0; i < slTheThuVien; i++) {
                    String line = br.readLine();
                    String[] data = line.split(";");
                    String maThe = data[0];
                    String loaiThe = data[1];
                    TheThuVien t =new TheThuVien() {
                        @Override
                        public int getSlsachmuon() {
                            throw new UnsupportedOperationException("Not supported yet.");
                        }

                        @Override
                        public int getSoNgayMuon() {
                            throw new UnsupportedOperationException("Not supported yet.");
                        }
                        
                    };

                    if (loaiThe.equals("A")) {
                        t = new LoaiA(maThe, loaiThe); // Tạo đối tượng LoaiA
                    } else if (loaiThe.equals("B")) {
                        t = new LoaiB(maThe, loaiThe); // Tạo đối tượng LoaiB
                    }
                    
                    array[i] = t;
                }
                return array;
            } catch (IOException e) {
                System.out.println("Lỗi khi đọc dữ liệu: " + e.getMessage());
                return new TheThuVien[0];
            }
        }
        return theThuVien;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-10s", maThe, loaiThe);
    }

    // Phương thức hiển thị thông tin thẻ
    public void hienThiThongTin() {
        System.out.println("Mã thẻ: " + maThe);
        System.out.println("Loại thẻ: " + loaiThe);
        // System.out.println("Số ngày mượn: " + soNgayMuon);
        // System.out.println("Phí thường niên: " + phiThuongNien);
    }
}
