import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ThuThu extends ConNguoi {
    private String maThuThu;
    private int SoGioLam;
    private int Luong;

    // Constructor
    public ThuThu(String maThuThu, String ten, int tuoi, String diaChi, int SoGioLam, int Luong) {
        super(ten, tuoi, diaChi);
        this.maThuThu = maThuThu;
        setSoGioLam(SoGioLam);
        setLuong(Luong);
    }

    public ThuThu() {
    }

    // Getter và Setter
    public String getMaThuThu() {
        return maThuThu;
    }

    public void setMaThuThu(String maThuThu) {
        if (maThuThu.matches("\\d{3}")) {
            this.maThuThu = maThuThu;
        } else {
            throw new IllegalArgumentException("Ma thu thu phai la 3 chu so.");
        }
    }

    public void setLuong(int Luong) {
        if (Luong > 0) {
            this.Luong = Luong;
        } else {
            throw new IllegalArgumentException("Luong phai lon hon 0.");
        }
    }

    public void setSoGioLam(int SoGioLam) {
        if (SoGioLam > 0) {
            this.SoGioLam = SoGioLam;
        } else {
            throw new IllegalArgumentException("Số giờ làm phải lớn hơn 0.");
        }
    }

    public int getSoGioLam() {
        return SoGioLam;
    }

    public int getLuong() {
        return Luong;
    }

    public int TinhLuong() {
        return SoGioLam * Luong;
    }

    public static ThuThu[] nhapDanhSachThuThu(ThuThu[] dsThuThu) {
        Scanner sc = new Scanner(System.in);
        int soLuong = 0;

        while (true) {
            System.out.print("Nhap so luong thu thu muon them: ");
            try {
                soLuong = Integer.parseInt(sc.nextLine());
                if (soLuong > 0) {
                    break;
                } else {
                    System.out.println("So luong phai lon hon 0. Vui long nhap lai!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap mot so hop le!");
            }
        }

        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhap thong tin thu thu thu " + (i + 1) + ":");
            try {
                ThuThu tt = new ThuThu();
                tt.inputThuThu();
                dsThuThu = ThuThu.addElementThuThu(dsThuThu, tt);
            } catch (Exception e) {
                System.out.println("Co loi khi nhap thong tin thu thu. Vui long thu lai!");
                i--;
            }
        }

        System.out.println("Nhap du lieu thu thu thanh cong!");
        return dsThuThu;
    }

    public void inputThuThu() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ma thu thu: ");
                // Kiểm tra trùng lặp nếu cần
                ThuThu[] dsThuThu = new ThuThu[0];
                dsThuThu = DocGhiDuLieuThuThu(false, dsThuThu);
                boolean matontai=false;
                while (true) {
                    try {
                        System.out.print("Nhap ma thu thu: ");
                        maThuThu = sc.nextLine();
                        setMaThuThu(maThuThu);
                
                        matontai = false; // Mặc định là không tồn tại
                
                        // Kiểm tra mã thủ thư trong danh sách
                        for (ThuThu tt : dsThuThu) {
                            if (tt != null && tt.getMaThuThu().equals(maThuThu)) {
                                System.out.println("Ma thu thu vua nhap da ton tai, vui long nhap ma khac.");
                                matontai = true;
                                break; // Thoát khỏi vòng lặp for khi tìm thấy mã tồn tại
                            }
                        }
                
                        if (!matontai) {
                            // Nếu mã không tồn tại, thoát vòng lặp while
                            break;
                        }
                
                    } catch (IllegalArgumentException e) {
                        
                        System.out.println(e.getMessage());
                    }
                }
                

    

        System.out.print("Nhap ten thu thu: ");
        ten = sc.nextLine();

        System.out.print("Nhap tuoi: ");
        while (true) {
            try {
                tuoi = Integer.parseInt(sc.nextLine());
                if (tuoi > 18) {
                    setTuoi(tuoi); // Sử dụng setter để kiểm tra tuổi
                    break;
                }
                System.out.println("Tuoi phai lon hon 18. Vui long nhap lai.");
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap mot so hop le.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.print("Nhap so gio lam: ");
        while (true) {
            try {
                SoGioLam = Integer.parseInt(sc.nextLine());
                if (SoGioLam > 0)
                    break;
                System.out.println("So gio lam phai lon hon 0. Vui long nhap lai.");
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so hop le.");
            }
        }

        System.out.print("Nhap luong: ");
        while (true) {
            try {
                Luong = Integer.parseInt(sc.nextLine());
                if (Luong > 0)
                    break;
                System.out.println("Luong phai lon hon 0. Vui long nhap lai.");
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so hop le.");
            }
        }

        System.out.print("Nhap dia chi: ");
        diaChi = sc.nextLine();
    }

    @SuppressWarnings("resource")
    public static ThuThu[] DocGhiDuLieuThuThu(boolean write, ThuThu[] dsThuThu) {

        if (write) {
            // Ghi dữ liệu vào file
            try {
                File dir = new File("./data");
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                FileWriter fw = new FileWriter("./data/Thuthu.txt");
                BufferedWriter bw = new BufferedWriter(fw);
                for (ThuThu tt : dsThuThu) {
                    if (tt != null) {
                        bw.write(tt.getMaThuThu() + ";" + tt.getTen() + ";" + tt.getTuoi() + ";" + tt.getDiaChi() + ";"
                                + tt.getSoGioLam() + ";" + tt.getLuong());
                        bw.newLine();
                    }
                }
                bw.close();
                // System.out.println("File ghi thành công!");
            } catch (IOException e) {
                System.out.println("Lỗi khi ghi file: " + e.getMessage());
            }
        } else {
            try {

                FileReader fr = new FileReader("./data/Thuthu.txt");
                BufferedReader br;
                br = new BufferedReader(fr);
                String line = "";
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(";");
                    if (parts.length == 6) {
                        String maThuThu = parts[0];
                        String name = parts[1];
                        int tuoi = Integer.parseInt(parts[2]);
                        String address = parts[3];
                        int soGioLam = Integer.parseInt(parts[4]);
                        int luong = Integer.parseInt(parts[5]);
                        ThuThu tmp = new ThuThu(maThuThu, name, tuoi, address, soGioLam, luong);
                        dsThuThu = addElementThuThu(dsThuThu, tmp);
                    }
                }

            } catch (FileNotFoundException e) {
                System.out.println("File khong ton tai. Khoi tao danh sach rong.");
                dsThuThu = new ThuThu[0];
            } catch (IOException e) {
                System.out.println("Loi khi doc du lieu: " + e.getMessage());
                dsThuThu = new ThuThu[0];
            }
        }

        return dsThuThu;
    }

    // Tìm kiếm bằng tên
    public static ThuThu findNameThuThu(ThuThu[] DS, String tenThuThu) {
        for (ThuThu x : DS) {
            if (x.getTen().equalsIgnoreCase(tenThuThu)) {
                return x;
            }
        }
        System.out.println("Khong tim thay thu thu.\n");
        return null;
    }

    public static ThuThu[] findNameThuThu_tuongdoi(ThuThu[] DS, String tenThuThu) {
        ThuThu[] y = new ThuThu[DS.length];
        int count = 0;
        for (ThuThu x : DS) {
            if (x.getTen().toLowerCase().contains(tenThuThu.toLowerCase())) {
                y[count] = x;
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Khong tim thay thu thu.\n");
            return new ThuThu[0];
        }
        ThuThu[] result = new ThuThu[count];
        System.arraycopy(y, 0, result, 0, count);
        return result;
    }

    // Sửa
    public static void updateThuThu(ThuThu[] DS, String maThuThu, ThuThu newInfo) {
        for (int i = 0; i < DS.length; i++) {
            if (DS[i].getMaThuThu().equals(maThuThu)) {
                DS[i].setTen(newInfo.getTen());
                DS[i].setTuoi(newInfo.getTuoi());
                DS[i].setDiaChi(newInfo.getDiaChi());
                DS[i].setSoGioLam(newInfo.getSoGioLam());
                DS[i].setLuong(newInfo.getLuong());
                System.out.println("Da cap nhat thong tin thu thu voi ma: " + maThuThu);
                return;
            }
        }
        System.out.println("Khong tim thay thu thu voi ma: " + maThuThu);
    }

    // Xóa
    public static ThuThu[] removeThuThu(ThuThu[] DS, String maThuThu) {
        int index = -1;
        for (int i = 0; i < DS.length; i++) {
            if (DS[i].getMaThuThu().equals(maThuThu)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Khong tim thay thu thu voi ma: " + maThuThu);
            return DS;
        }

        ThuThu[] newArray = new ThuThu[DS.length - 1];
        System.arraycopy(DS, 0, newArray, 0, index);
        System.arraycopy(DS, index + 1, newArray, index, DS.length - index - 1);
        System.out.println("Da xoa thu thu voi ma: " + maThuThu);
        return newArray;
    }

    // Thêm thủ thư vào mảng
    public static ThuThu[] addElementThuThu(ThuThu[] dsThuThu, ThuThu tmp) {
        ThuThu[] newArray = new ThuThu[dsThuThu.length + 1];
        System.arraycopy(dsThuThu, 0, newArray, 0, dsThuThu.length);
        newArray[dsThuThu.length] = tmp;
        return newArray;
    }

    // Tìm thủ thư theo mã
    public static ThuThu SearchId(ThuThu[] dsThuThu, String maThuThu) {
        for (ThuThu tt : dsThuThu) {
            if (tt.getMaThuThu().equals(maThuThu)) {
                return tt;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("%10s%15s%10d%20s%10d%10d", maThuThu, ten, tuoi, diaChi, SoGioLam, Luong);
    }

    public static String head() {
        return String.format("%-10s %-15s %-10s %-20s %-10s %-10s",
                "Mã Thủ Thư", "Tên", "Tuổi", "Địa Chỉ", "Số Giờ Làm", "Lương");
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("Ma thu thu: " + maThuThu);
    }
}