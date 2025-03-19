import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TacGia {
    private String id;
    private String tenTacGia; // Tên tác giả

    // Constructor
    public TacGia(String id, String tenTacGia) {
        this.id = id;
        this.tenTacGia = tenTacGia;
    }
    public TacGia(){}

    // Getter và Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }
   public void NhapThongTin(){
    System.out.println("Nhap ma tac gia, dinh dang(TG0000)"); 
    Scanner sc=new Scanner(System.in);
   TacGia []dstg=new TacGia[0];
   dstg=DocGhiDuLieuTacGia(false, dstg);
   String id=sc.nextLine();
   while(timKiemTheoId(dstg, id)!=null)  {
      System.out.println("Ma tac gia ban vua nhap da ton tai");
      System.out.println("Vui long nhap lai ma khac" );
      id=sc.nextLine();
   }   
   System.out.println("Nhap ten tac gia");
    setId(id);
    setTenTacGia(sc.nextLine());

   }
    public void hienThiThongTin() {
        System.out.println("Ten tac gia: " + tenTacGia);
    }
    public static String head(){
        String header = String.format("%-10s %-20s", "Ma Tac Gia", "Ten Tac Gia");
        return header;
    }
    
    @Override
    public String toString() {
        return String.format("%5s%20s", id, tenTacGia);
    }

    public static TacGia[] DocGhiDuLieuTacGia(boolean ghi, TacGia[] dsTacGia) {
        if (ghi) {
            try {
                FileWriter fw = new FileWriter("./data/TacGia.txt");
                BufferedWriter bw = new BufferedWriter(fw);

                // Ghi số lượng tác giả

                // Ghi từng tác giả
                for (TacGia t : dsTacGia) {
                    bw.write(t.getId() + ";" + t.getTenTacGia());
                    bw.newLine();
                }
                bw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                FileReader fr = new FileReader("./data/TacGia.txt");
                BufferedReader br = new BufferedReader(fr);

                // Đọc số lượng tác giả

                String line;
                while ((line = br.readLine()) != null) {
                    String[] txt = line.split(";");
                    String id = txt[0];
                    String tenTacGia = txt[1];
                    TacGia tmp=new TacGia(id, tenTacGia);
                    dsTacGia=themTacGia(dsTacGia, tmp);
                }
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return dsTacGia;
    }

    // Thêm
    public static TacGia[] themTacGia(TacGia[] dsTacGia, TacGia tacGiaMoi) {
        TacGia[] dsMoi = new TacGia[dsTacGia.length + 1];
        System.arraycopy(dsTacGia, 0, dsMoi, 0, dsTacGia.length);
        dsMoi[dsTacGia.length] = tacGiaMoi;
        DocGhiDuLieuTacGia(true, dsMoi);
        return dsMoi;
    }

    // XÓa
    public static TacGia[] xoaTacGia(TacGia[] dsTacGia, String id) {
        boolean daXoa = false;

        TacGia[] dsMoi = new TacGia[dsTacGia.length - 1];
        int index = 0;

        for (TacGia tacGia : dsTacGia) {
            if (!tacGia.getId().equals(id)) {
                if (index < dsMoi.length) {
                    dsMoi[index++] = tacGia;
                }
            } else {
                daXoa = true;
            }
        }

        if (daXoa) {
            DocGhiDuLieuTacGia(true, dsMoi);
            System.out.println("Xoa tac gia thanh cong!");
        } else {
            System.out.println("Khong tim thay tac gia voi ID: " + id);
            return dsTacGia;
        }
        return dsMoi;
    }

    // Sửa
    public static TacGia[] suaTacGia(TacGia[] dsTacGia, String id, String tenMoi) {
        boolean daTimThay = false;

        for (TacGia tacGia : dsTacGia) {
            if (tacGia.getId().equals(id)) {
                tacGia.setTenTacGia(tenMoi);
                daTimThay = true;
                break;
            }
        }

        if (daTimThay) {
            DocGhiDuLieuTacGia(true, dsTacGia);
        } else {
            System.out.println("Khong tim thay tac gia voi ID: " + id);
        }
        return dsTacGia;
    }

    // Tìm kiếm bằng ID
    public static TacGia timKiemTheoId(TacGia[] dsTacGia, String id) {
        for (TacGia tacGia : dsTacGia) {
            if (tacGia.getId().equals(id)) {
                return tacGia; 
            }
        }
        return null; 
    }

    // Tìm kiếm bằng tên
    public static TacGia[] timKiemTheoTen(TacGia[] dsTacGia, String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase(); 
        TacGia[] ketQuaTam = new TacGia[dsTacGia.length];
        int index = 0;

        for (TacGia tacGia : dsTacGia) {
            if (tacGia.getTenTacGia().toLowerCase().contains(tuKhoa)) { 
                ketQuaTam[index++] = tacGia;
            }
        }

        TacGia[] ketQua = new TacGia[index];
        System.arraycopy(ketQuaTam, 0, ketQua, 0, index);
        return ketQua;
    }
}
