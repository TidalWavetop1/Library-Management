import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class TheLoai {
    private String maTheLoai;  // Mã thể loại
    private String tenTheLoai; // Tên thể loại
    public static final int ID_LENGTH = 4;

    public TheLoai() {
        
    }

    // Constructor
    public TheLoai(String maTheLoai, String tenTheLoai) {
        this.maTheLoai = maTheLoai;
        this.tenTheLoai = tenTheLoai;
    }

    // Phương thức nhập thông tin
    public void nhapThongTin(TheLoai[] theLoai) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Nhập mã thể loại: ");
            String inputId = sc.nextLine();
            try {
                setMaTheLoai(inputId); // Gọi setter để kiểm tra tính hợp lệ
                if (SearchId(theLoai, inputId) != null) {
                    System.out.println("ID vừa nhập đã tồn tại, vui lòng nhập ID khác.");
                } else {
                    break; // ID hợp lệ, thoát khỏi vòng lặp
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        System.out.print("Nhập tên thể loại: ");
        tenTheLoai = sc.nextLine();
        while (tenTheLoai.trim().isEmpty()) {
            System.out.println("Tên thể loại không được để trống. Vui lòng nhập lại.");
            System.out.print("Nhập tên thể loại: ");
            tenTheLoai = sc.nextLine();
        }
        System.out.println("Danh mục mới đã được tạo thành công.");
    }

    // Getter và Setter
    public String getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) {
        if (isValidId(maTheLoai)) {
            this.maTheLoai = maTheLoai;
        } else {
            throw new IllegalArgumentException("ID phải là chuỗi gồm 4 chữ số.");
        }  
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    // Hiển thị thông tin thể loại
    public void hienThiTheLoai() {
        System.out.println("Mã thể loại: " + maTheLoai);
        System.out.println("Tên thể loại: " + tenTheLoai);
    }

    // Phương thức tiện ích
    public static boolean isValidId(String maTheLoai) {
        if (maTheLoai.length() != ID_LENGTH) {
            System.out.println("ID phải có đúng " + ID_LENGTH + " chữ số.");
            return false;
        }
        if (!maTheLoai.matches("^[0-9]+$")) {
            System.out.println("ID chỉ được chứa các chữ số.");
            return false;
        }
        return true;
    }

    public static boolean isIdExist(TheLoai[] theLoai, String id) {
        return SearchId(theLoai, id) != null;
    }

    public static TheLoai SearchId(TheLoai[] theLoai, String id) {
        for (TheLoai x : theLoai) {
            if (x.getMaTheLoai().equals(id)) {
                return x;
            }
        }
        return null;
    }

    public static TheLoai[] themTheLoai(TheLoai[] theLoai, TheLoai tmp) {
        if (isIdExist(theLoai, tmp.getMaTheLoai())) {
            System.out.println("ID đã tồn tại. Không thể thêm.");
            return theLoai;
        }
        TheLoai[] array = new TheLoai[theLoai.length + 1];
        System.arraycopy(theLoai, 0, array, 0, theLoai.length);
        array[theLoai.length] = tmp;
        return array;
    }

    public static TheLoai[] chinhTheLoai(TheLoai[] theLoai, String id, String tenTheLoaiMoi) {
        TheLoai x = SearchId(theLoai, id);
        if (x != null) {
            for(TheLoai tmp: theLoai){
               if(tmp.getMaTheLoai().equals(id)){
                 tmp.setTenTheLoai(tenTheLoaiMoi);
               }
            }
             System.out.println("Cập nhật thành công.");
         } else {
             System.out.println("Không tìm thấy danh mục cần sửa.");
         }
         return theLoai;
    }

    public static TheLoai[] xoaTheLoai(TheLoai[] theLoai, String id) {
        if (!isIdExist(theLoai, id)) {
            System.out.println("Không tìm thấy danh mục cần xóa.");
            return theLoai;
        }

        int index = -1;
        for (int i = 0; i < theLoai.length; i++) {
            if (theLoai[i].getMaTheLoai().equals(id)) {
                index = i;
                break;
            }
        }

        TheLoai[] newArray = new TheLoai[theLoai.length - 1];
        System.arraycopy(theLoai, 0, newArray, 0, index);
        System.arraycopy(theLoai, index + 1, newArray, index, theLoai.length - index - 1);

        System.out.println("Danh mục đã được xóa.");
        return newArray;
    }

    public static TheLoai searchExactName(TheLoai[] theLoai, String name) {
        for (TheLoai x : theLoai) {
            if (x.getTenTheLoai().equals(name)) {
                return x;
            }
        }
        System.out.println("Không tìm thấy danh mục với tên chính xác.");
        return null;
    }

    public static TheLoai[] searchPartialName(TheLoai[] theLoai, String name1) {
        TheLoai[] resultArray = new TheLoai[theLoai.length];
        int resultCount = 0;
        for (TheLoai x : theLoai) {
            if (x.getTenTheLoai().toLowerCase().contains(name1.toLowerCase())) {
                resultArray[resultCount] = x;
                resultCount++;
            }
        }
        if (resultCount == 0) {
            System.out.println("Không tìm thấy danh mục gần đúng.");
            return new TheLoai[0];
        }
        TheLoai[] finalResult = new TheLoai[resultCount];
        System.arraycopy(resultArray, 0, finalResult, 0, resultCount);
        return finalResult;
    }
    
    public static TheLoai[] DocGhiDuLieuTheLoai(boolean a,TheLoai TheLoai[]){
        //true: ghi
        int slTheLoai;

        if(a){
            try {

                FileWriter fw =new FileWriter("./data/TheLoai.txt");
                BufferedWriter bw =new BufferedWriter(fw);
                        bw.write(""+TheLoai.length);
                        bw.newLine();
                        for(TheLoai t:TheLoai){
                            // bw.write(t.toString());
                            bw.write(t.getMaTheLoai()+";"+t.getTenTheLoai());
                            bw.newLine();
                        }
                            bw.close();
                            fw.close();
                        } catch (Exception e) {
                        }
            }
        else{
               try {
                    FileReader fr=new FileReader("./data/TheLoai.txt");
                    BufferedReader br =new BufferedReader(fr);
                    String line="";
                    slTheLoai = Integer.parseInt(br.readLine());      
                    while(true){
                    
                        line=br.readLine();
                        if (line == null || line.trim().isEmpty()) {
                            break;
                        }
                        
                        String txt[]=line.split(";");
                        String id=txt[0];
                        String name=txt[1]; 
                        TheLoai tmp=new TheLoai(id, name);
                        TheLoai=themTheLoai(TheLoai, tmp);
                                }
                                    br.close();
                                    fr.close();
                        } catch (Exception e) {
                                
                        }
            }
        return TheLoai;
    }

    @Override
    public String toString(){
        return String.format("%-10s %-20s", maTheLoai, tenTheLoai);
    }
    public static String head(){
        return String.format("%-10s %-20s", "Mã Thể Loại", "Tên Thể Loại");
    }
    public String toStringDoc(){
        String tmp=maTheLoai+";"+tenTheLoai;
        return tmp;
    }
}
