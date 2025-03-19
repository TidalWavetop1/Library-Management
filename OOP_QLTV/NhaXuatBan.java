import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class NhaXuatBan {
    private String maNXB; // Mã nhà xuất bản
    private String tenNXB; // Tên nhà xuất bản
    public static final int ID_LENGTH = 4;

    // Constructor
    public NhaXuatBan() {

    }

    public NhaXuatBan(String maNXB, String tenNXB) {
        this.maNXB = maNXB;
        this.tenNXB = tenNXB;

    }

    // Getter và Setter
    public String getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(String maNXB) {
        if (isValidId(maNXB)) {
            this.maNXB = maNXB;
        } else {
            throw new IllegalArgumentException("ID phải là chuỗi gồm 4 chữ số.");
        }
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    // Phương thức nhập thông tin
    public void nhapThongTin(NhaXuatBan[] nhaXuatBan) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Nhập mã nhà xuất bản: ");
            String inputId = sc.nextLine();
            try {
                setMaNXB(inputId); // Gọi setter để kiểm tra tính hợp lệ
                if (SearchId(nhaXuatBan, inputId) != null) {
                    System.out.println("ID vừa nhập đã tồn tại, vui lòng nhập ID khác.");
                } else {
                    break; // ID hợp lệ, thoát khỏi vòng lặp
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        System.out.print("Nhập tên nhà xuất bản: ");
        tenNXB = sc.nextLine();
        while (tenNXB.trim().isEmpty()) {
            System.out.println("Tên nhà xuất bản không được để trống. Vui lòng nhập lại.");
            System.out.print("Nhập tên nhà xuất bản: ");
            tenNXB = sc.nextLine();
        }
    }

    public static boolean isValidId(String maNXB) {
        if (maNXB.length() != ID_LENGTH) {
            System.out.println("ID phải có đúng " + ID_LENGTH + " chữ số.");
            return false;
        }
        if (!maNXB.matches("^[0-9]+$")) {
            System.out.println("ID chỉ được chứa các chữ số.");
            return false;
        }
        return true;
    }

    public static boolean isIdExist(NhaXuatBan[] nhaXuatBan, String id) {
        return SearchId(nhaXuatBan, id) != null;
    }

    public static NhaXuatBan SearchId(NhaXuatBan[] nhaXuatBan, String id) {
        for (NhaXuatBan x : nhaXuatBan) {
            if (x.getMaNXB().equals(id)) {
                return x;
            }
        }
        return null;
    }

    public static NhaXuatBan[] themNhaXuatBan(NhaXuatBan[] nhaXuatBan, NhaXuatBan tmp) {
        if (isIdExist(nhaXuatBan, tmp.getMaNXB())) {
            System.out.println("ID đã tồn tại. Không thể thêm.");
            return nhaXuatBan;
        }
        NhaXuatBan[] array = new NhaXuatBan[nhaXuatBan.length + 1];
        System.arraycopy(nhaXuatBan, 0, array, 0, nhaXuatBan.length);
        array[nhaXuatBan.length] = tmp;
        return array;
    }

    public static NhaXuatBan[] chinhNhaXuatBAn(NhaXuatBan[] nhaXuatBan, String id, String tenNhaXuatBanMoi) {
        NhaXuatBan x = SearchId(nhaXuatBan, id);
        if (x != null) {
            for (NhaXuatBan tmp : nhaXuatBan) {
                if (tmp.getMaNXB().equals(id)) {
                    tmp.setTenNXB(tenNhaXuatBanMoi);
                }
            }
            // System.out.println("Cập nhật thành công.");
        } else {
            System.out.println("Không tìm thấy danh mục cần sửa.");
        }
        return nhaXuatBan;
    }

    public static NhaXuatBan[] xoaNhaXuatBan(NhaXuatBan[] nhaXuatBan, String id) {
        if (!isIdExist(nhaXuatBan, id)) {
            System.out.println("Không tìm thấy danh mục cần xóa.");
            return nhaXuatBan;
        }

        int index = -1;
        for (int i = 0; i < nhaXuatBan.length; i++) {
            if (nhaXuatBan[i].getMaNXB().equals(id)) {
                index = i;
                break;
            }
        }

        NhaXuatBan[] newArray = new NhaXuatBan[nhaXuatBan.length - 1];
        System.arraycopy(nhaXuatBan, 0, newArray, 0, index);
        System.arraycopy(nhaXuatBan, index + 1, newArray, index, nhaXuatBan.length - index - 1);

        System.out.println("Danh mục đã được xóa.");
        return newArray;
    }

    public static NhaXuatBan searchExactName(NhaXuatBan[] nhaXuatBan, String name) {
        for (NhaXuatBan x : nhaXuatBan) {
            if (x.getTenNXB().equals(name)) {
                return x;
            }
        }
        System.out.println("Không tìm thấy danh mục với tên chính xác.");
        return null;
    }

    public static NhaXuatBan[] searchPartialName(NhaXuatBan[] nhaXuatBan, String name1) {
        NhaXuatBan[] resultArray = new NhaXuatBan[nhaXuatBan.length];
        int resultCount = 0;
        for (NhaXuatBan x : nhaXuatBan) {
            if (x.getTenNXB().toLowerCase().contains(name1.toLowerCase())) {
                resultArray[resultCount] = x;
                resultCount++;
            }
        }
        if (resultCount == 0) {
            System.out.println("Không tìm thấy danh mục gần đúng.");
            return new NhaXuatBan[0];
        }
        NhaXuatBan[] finalResult = new NhaXuatBan[resultCount];
        System.arraycopy(resultArray, 0, finalResult, 0, resultCount);
        return finalResult;
    }

    // Phương thức hiển thị thông tin nhà xuất bản
    public String hienThiThongTin() {
        return String.format("%s%s", getMaNXB(), getTenNXB());
    }

    public static NhaXuatBan[] DocGhiDuLieuNhaXuatBan(boolean a, NhaXuatBan NhaXuatBan[]) {
        // true: ghi
        int slNhaXuatBan;

        if (a) {
            try {
                FileWriter fw = new FileWriter("./data/NhaXuatBan.txt");
                BufferedWriter bw = new BufferedWriter(fw);
                for (NhaXuatBan t : NhaXuatBan) {
                    // bw.write(t.toString());
                    bw.write(t.getMaNXB() + ";" + t.getTenNXB());
                    bw.newLine();
                }
                bw.close();
                fw.close();
            } catch (Exception e) {
            }
        } else {
            try {
                FileReader fr = new FileReader("./data/NhaXuatBan.txt");
                BufferedReader br = new BufferedReader(fr);
                String line = "";

                while (true) {

                    line = br.readLine();
                    if (line == "") {
                        break;
                    }

                    String txt[] = line.split(";");
                    String id = txt[0];
                    String name = txt[1];
                    NhaXuatBan tmp = new NhaXuatBan(id, name);

                    NhaXuatBan = themNhaXuatBan(NhaXuatBan, tmp);
                }
                br.close();
                fr.close();
            } catch (Exception e) {
                // System.out.println("Không tìm thấy file");
            }
        }
        return NhaXuatBan;
    }
}
