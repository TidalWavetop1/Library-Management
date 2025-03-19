import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class TTMuon {
    String idMuon;
    TheThuVien TheMuon;
    Calendar NgayMuon;
    Calendar HanMuon;
    ChiTietSach SachMuon;
    boolean TrangThai;

    public TTMuon() {

    }

    public TTMuon(String idMuon, TheThuVien TheMuon, Calendar NgayMuon, Calendar HanMuon, ChiTietSach SachMuon,
            boolean TrangThai) {
        this.idMuon = idMuon;
        this.TheMuon = TheMuon;
        this.NgayMuon = NgayMuon;
        this.HanMuon = HanMuon;
        this.SachMuon = SachMuon;
        this.TrangThai = TrangThai;
    }
    public TTMuon( TheThuVien TheMuon, Calendar NgayMuon, Calendar HanMuon, ChiTietSach SachMuon,
    boolean TrangThai) {
        TTMuon [] dsm= new TTMuon[0];
        dsm =NhapGhiDL(false, dsm);
        Random random=new Random();
        int randomNumber = random.nextInt(1000);
        String str=String.format("TT%03d", randomNumber);
       for(int i=0;i<dsm.length;i++){
        if(dsm[i].idMuon.equals(str)){
            randomNumber=random.nextInt(1000);
            str=String.format("TT%03d", randomNumber);
            i=0;
        }
       }
this.idMuon = str;
this.TheMuon = TheMuon;
this.NgayMuon = NgayMuon;
this.HanMuon = HanMuon;
this.SachMuon = SachMuon;
this.TrangThai = TrangThai;
}
    public void setHanMuon(Calendar hanMuon) {
        HanMuon = hanMuon;
    }

    public void setIdMuon(String idMuon) {
        this.idMuon = idMuon;
    }

    public void setNgayMuon(Calendar ngayMuon) {
        NgayMuon = ngayMuon;
    }

    public void setSachMuon(ChiTietSach sachMuon) {
        SachMuon = sachMuon;
    }

    public void setTrangThai(boolean trangThai) {
        TrangThai = trangThai;
    }

    public String toString() {
        // Định dạng ngày tháng với SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Định dạng ngày: ngày/tháng/năm
        String ngayMuonStr = NgayMuon != null ? sdf.format(NgayMuon.getTime()) : "Không xác định";
        String hanMuonStr = HanMuon != null ? sdf.format(HanMuon.getTime()) : "Không xác định";
        String trangThaiStr = TrangThai ? "Đang mượn" : "Đã trả";

        // Trả về chuỗi với thông tin đầy đủ
        return String.format("ID Mượn: %s\nThẻ mượn: %s\nNgày mượn: %s\nHạn mượn: %s\nSách mượn: %s\nTrạng thái: %s",
                idMuon,
                (TheMuon != null ? TheMuon.toString() : "Không xác định"),
                ngayMuonStr,
                hanMuonStr,
                (SachMuon != null ? SachMuon.toString() : "Không xác định"),
                trangThaiStr);
    }
    public static TTMuon[] NhapGhiDL(boolean a, TTMuon DSM[]) {
        if (a) {  // Ghi dữ liệu vào file
            try {
                FileWriter fw = new FileWriter("./data/TTMuon.txt");
                BufferedWriter bw = new BufferedWriter(fw);
    
                // Ghi thông tin từng đối tượng TTMuon vào file
                for (TTMuon t : DSM) {
                    // Ghi các thuộc tính của TTMuon vào file
                    bw.write(t.idMuon + ";" + t.TheMuon.getMaThe() + ";" +
                            formatDate(t.NgayMuon) + ";" + formatDate(t.HanMuon) + ";" +
                            t.SachMuon.getId() + ";" + t.TrangThai);
                    bw.newLine();
                }
    
                bw.close();
                fw.close();
            } catch (IOException e) {
                System.out.println("Lỗi khi ghi dữ liệu: " + e.getMessage());
            }
        } else {  // Đọc dữ liệu từ file và cập nhật vào DSM
            try {
                FileReader fr = new FileReader("./data/TTMuon.txt");
                BufferedReader br = new BufferedReader(fr);
                String line;
    
                // Đọc thông tin ChiTietSach và TheThuVien từ các file liên quan
                ChiTietSach[] Sach = new ChiTietSach[0];
                Sach = ChiTietSach.DocGhiDuLieuChiTietSach(false, Sach);
                TheThuVien[] DSTM = new TheThuVien[0];
                DSTM = TheThuVien.DocGhiDuLieuTheThuVien(false, DSTM);
    
                while ((line = br.readLine()) != null) {
                    String[] txt = line.split(";");
                    String idMuon = txt[0];
                    String idTM = txt[1];
                    String ngayMuonStr = txt[2];
                    String hanMuonStr = txt[3];
                    String idSachMuon = txt[4];
                    boolean trangThai = Boolean.parseBoolean(txt[5]);
                    // Chuyển ngày tháng thành đối tượng Calendar
                    Calendar NgayMuon = LayNgay(ngayMuonStr.split("/"));
                    Calendar HanMuon = LayNgay(hanMuonStr.split("/"));
    
                    // Tìm ChiTietSach và TheThuVien dựa trên ID
                    ChiTietSach SachMuon = ChiTietSach.timKiemChiTietSachTheoID(Sach, idSachMuon);
                    TheThuVien TheMuon = TheThuVien.SearchId(DSTM, idTM);
    
                        // Tạo đối tượng TTMuon mới và thêm vào mảng
                        TTMuon tmp = new TTMuon(idMuon, TheMuon, NgayMuon, HanMuon, SachMuon, trangThai);
                        DSM = TTMuon.addElementTTMuon(DSM, tmp);
                }
    
                br.close();
                fr.close();
            } catch (IOException e) {
                System.out.println("Lỗi khi đọc dữ liệu: " + e.getMessage());
            }
        }
        
  
        return DSM;
    }
    

    // Hàm để định dạng ngày tháng thành chuỗi "dd/MM/yyyy"
    private static String formatDate(Calendar calendar) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(calendar.getTime());
    }
    public static Calendar LayNgay(String str[]){
        Calendar Ngay=Calendar.getInstance();
        Ngay.set(Calendar.DAY_OF_YEAR,Integer.parseInt(str[0]));
        Ngay.set(Calendar.MONTH,Integer.parseInt(str[1]));
        Ngay.set(Calendar.YEAR, Integer.parseInt(str[2]));
        return Ngay;
      }
      public static String toStringNgay(Calendar Ngay){
        String str;
        str=Ngay.get(Calendar.DAY_OF_MONTH)+"/"+Ngay.get(Calendar.DAY_OF_MONTH)+"/"+Ngay.get(Calendar.YEAR);
        return str;
      }

    public static TTMuon[] addElementTTMuon(TTMuon[] DSM, TTMuon tmp) {
        TTMuon[] array = new TTMuon[DSM.length + 1];
        System.arraycopy(DSM, 0, array, 0, DSM.length);
        array[DSM.length] = tmp;
        return array;
    }

    public static TTMuon SearchId(TTMuon DS[], String idMuon) {
        for (TTMuon x : DS) {
            if (x.idMuon.equals(idMuon)) {
                return x;
            }
        }
        return null;
    }

    public static TTMuon[] xoaTTMuon(TTMuon[] DSM, String idMuon) {
        for (int i = 0; i < DSM.length; i++) {
            if (DSM[i].idMuon.equals(idMuon)) {
                TTMuon[] newArray = new TTMuon[DSM.length - 1];
                System.arraycopy(DSM, 0, newArray, 0, i);
                System.arraycopy(DSM, i + 1, newArray, i, DSM.length - i - 1);
                System.out.println("Xóa thông tin mượn thành công: " + idMuon);
                return newArray;
            }
        }
        System.out.println("Thông tin mượn không tồn tại.");
        return DSM;
    }

    public static void suaTTMuon(TTMuon[] DSM, String idMuon, TTMuon newTTMuon) {
        for (int i = 0; i < DSM.length; i++) {
            if (DSM[i].idMuon.equals(idMuon)) {
                DSM[i] = newTTMuon;
                System.out.println("Sửa thông tin mượn thành công: " + idMuon);
                return;
            }
        }
        System.out.println("Thông tin mượn không tồn tại.");
    }

    public static void xuatThongTin(TTMuon[] DSM) {
        for (TTMuon ttMuon : DSM) {
            System.out.println(ttMuon.toString());
        }
    }

    // public static TTMuon[] timKiemTheoIdNguoiMuon(TTMuon[] DSM, String idNguoiMuon) {
    //     TTMuon[] ketQua = new TTMuon[0];
    //     for (TTMuon ttMuon : DSM) {
    //         if (ttMuon.TheMuon.nguoiMuon.getId().equals(idNguoiMuon)) {
    //             ketQua = addElementTTMuon(ketQua, ttMuon);
    //         }
    //     }
    //     return ketQua;
    // }

    // public static Calendar tinhHanMuon(TheThuVien theThuVien, Calendar ngayMuon) {
    //     Calendar hanMuon = (Calendar) ngayMuon.clone();
    //     hanMuon.add(Calendar.DAY_OF_MONTH, theThuVien.getSoNgayMuon());
    //     return hanMuon;
    // }

}
