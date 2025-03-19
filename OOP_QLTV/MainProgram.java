import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuyTrinhQuanLy a;
        int choice;
   

               while (true) {
            System.out.println("========== Menu ==========");
            System.out.println("1. Menu cua thu thu");
            System.out.println("2. Menu của nguoi muon");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon cua ban: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    a = new QLTV();
                    a.Menu();
                    break;
                case 2:
                    a = new ChucNangNguoiMuon();
                    a.Menu();
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại!");
            }
        }
    }
}
