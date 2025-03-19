import java.util.Scanner;

public class QLTV implements QuyTrinhQuanLy{
    
        @Override
        public void Menu() {
            // Menu cho thủ thư
            Scanner scanner = new Scanner(System.in);  // Chỉ tạo một đối tượng Scanner duy nhất
            int choice = 0;
        
            do {
                System.out.println("\n===== Menu Quan Ly Thu Vien =====");
                System.out.println("1. Quan ly thong tin thu thu");
                System.out.println("2. Quan ly thong tin doc gia");
                System.out.println("3. Quan ly nha xuat ban");
                System.out.println("4. Quan ly thong tin tac gia");
                System.out.println("5. Quan ly cac dau sach (tua sach) dang co trong thu vien");
                System.out.println("6. Quan ly chi tiet sach");
                System.out.println("7. Quan ly thong tin the loai");
                System.out.println("8. Quan ly the thu vien");
                System.out.println("9. Quan ly vi tri");
                System.out.println("10. Thoat");
                System.out.print("Chon chuc nang: ");
                
                // Đảm bảo người dùng nhập đúng số
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Đọc dấu xuống dòng sau khi nhập số
                } else {
                    System.out.println("Vui long nhap so");
                    scanner.nextLine(); // Đọc và bỏ qua dữ liệu không hợp lệ
                    continue;  // Tiếp tục vòng lặp và yêu cầu nhập lại
                }
        
                if (choice == 10) {
                    break;
                }
        
                switch (choice) {
                    case 1: {
                        System.out.println("QUẢN LÝ THÔNG TIN THỦ THƯ");
                        System.out.println("1.Thêm dữ liệu mới");
                        System.out.println("2.Xoá dữ liệu");
                        System.out.println("3.Sửa dữ liệu");
                        System.out.println("4.Quay lại");
                        System.out.print("Chọn chức năng: ");
                        int c = scanner.nextInt();
                        scanner.nextLine(); // Đọc dấu xuống dòng sau khi nhập
        
                        switch (c) {
                            case 1:
                                ThuThu(c);
                                break;
                            case 2:
                                ThuThu(c);
                                break;
                            case 3:
                                ThuThu(c);
                                break;
                            default:
                                break;
                        }
                        break;
                    }
                    case 2: {
                        System.out.println("QUẢN LÝ THÔNG TIN ĐỘC GIẢ");
                        System.out.println("1.Thêm dữ liệu mới");
                        System.out.println("2.Xoá dữ liệu");
                        System.out.println("3.Sửa dữ liệu");
                        System.out.println("4.Quay lại");
                        System.out.print("Chọn chức năng: ");
                        int c = scanner.nextInt();
                        scanner.nextLine(); // Đọc dấu xuống dòng sau khi nhập
        
                        switch (c) {
                            case 1:
                                NguoiMuon(c);
                                System.out.println("Nhap du lieu thanh cong");
                                break;
                            case 2:
                                NguoiMuon(c);
                                break;
                            case 3:
                                NguoiMuon(c);
                                break;
                            case 4:
                                return;
                            default:
                                System.out.println("Lua chon khong hop le!");
                                break;
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("QUAN LY THONG TIN NHA XUAT BAN");
                        System.out.println("1.Them du lieu moi");
                        System.out.println("2.Xoa du lieu");
                        System.out.println("3.Sua du lieu");
                        System.out.println("4.Quay lai");
                        System.out.print("Chon chuc nang: ");
                        int c = scanner.nextInt();
                        scanner.nextLine(); // Đọc dấu xuống dòng sau khi nhập
        
                        switch (c) {
                            case 1:
                                NhaXuatBan(1);
                                System.out.println("Nhap du lieu moi thanh cong");
                                break;
                            case 2:
                                NhaXuatBan(2);
                                break;
                            case 3:
                                NhaXuatBan(3);
                                break;
                            default:
                                break;
                        }
                        break;
                    }
                    case 4: {
                        System.out.println("QUAN LY THONG TIN TAC GIA");
                        System.out.println("1.Them du lieu moi");
                        System.out.println("2.Xoa du lieu");
                        System.out.println("3.Sua du lieu");
                        System.out.println("4.Quay lai");
                        System.out.print("Chon chuc nang: ");
                        int c = scanner.nextInt();
                        scanner.nextLine(); // Đọc dấu xuống dòng sau khi nhập
        
                        switch (c) {
                            case 1:
                                TacGia(c);
                                break;
                            case 2:
                                TacGia(c);
                                break;
                            case 3:
                                TacGia(c);
                                break;
                            default:
                                break;
                        }
                        break;
                    }
                    case 5: {
                        int c = 0;
                        System.out.println("QUAN LY THONG TIN CAC DAU SACH");
                        System.out.println("1.Them du lieu moi");
                        System.out.println("2.Xoa du lieu");
                        System.out.println("3.Sua du lieu");
                        System.out.println("4.Quay lai");
                        System.out.print("Chon chuc nang: ");
                        c = Integer.parseInt(scanner.nextLine());
                        switch (c) {
                            case 1:
                                Sach(c);
                                break;
                            case 2:
                                Sach(c);
                                break;
                            case 3:
                                Sach(c);
                                break;
                            default:
                                break;
                        }
                        break;
                    }
                    case 6: {
                        int c = 0;
                        System.out.println("QUAN LY CHI TIET SACH");
                        System.out.println("1.Them du lieu moi");
                        System.out.println("2.Xoa du lieu");
                        System.out.println("3.Sua du lieu");
                        System.out.println("4.Quay lai");
                        System.out.print("Chon chuc nang: ");
                        c = Integer.parseInt(scanner.nextLine());
    
                        switch (c) {
                            case 1:
                                ChiTietSach(c);
                                System.out.println("Nhap du lieu thanh cong");
                                break;
                            case 2:
                                ChiTietSach(c);
                                break;
                            case 3:
                                ChiTietSach(c);
    
                                break;
                            default:
                                break;
    
                        }
                        break;
                    }
                    case 7: {
                        int c = 0;
                        System.out.println("QUAN LY THONG TIN DU LIEU");
                        System.out.println("1.Them du lieu moi");
                        System.out.println("2. Xoa du lieu");
                        System.out.println("3.Sua du lieu");
                        System.out.println("4.Quay lai");
                        c = Integer.parseInt(scanner.nextLine());
    
                        switch (c) {
                            case 1:
                                TheLoai(1);
                                System.out.println("Nhap du lieu thanh cong");
                                break;
                            case 2:
                                TheLoai(2);
                                break;
                            case 3:
                                TheLoai(3);
                                break;
                            default:
                                break;
    
                        }
                        break;
                    }
                    case 8: {
                        int c = 0;
                        System.out.println("QUAN LY THONG TIN THE THU VIEN");
                        System.out.println("1.Them du lieu moi");
                        System.out.println("2. Xoa du lieu");
                        System.out.println("3.Sua du lieu");
                        System.out.println("4.Quay lai");
                        c = Integer.parseInt(scanner.nextLine());
                        System.out.print("ChOn c: " + c);
                        switch (c) {
                            case 1:
                                TheThuVien(1);
                                System.out.println("Nhap du lieu thanh cong");
                                break;
                            case 2:
                                TheThuVien(2);
                                break;
                            case 3:
                                TheThuVien(3);
                                break;
                            default:
                                break;
                        }
                    }
                    case 9: {
                        System.out.println("QUAN LI THONG TIN VI TRI");
                        System.out.println("1.Them vi tri moi");
                        System.out.println("2. Xoa vi tri");
                        System.out.println("3.Quay lai");
                        int p = scanner.nextInt();
                        scanner.nextLine(); // Đọc dấu xuống dòng sau khi nhập
        
                        switch (p) {
                            case 1:
                                ViTri(1);  // Thêm vị trí mới
                                break;
                            case 2:
                                ViTri(2);  // Xóa vị trí
                                break;
                            default:
                                System.out.println("Lua chon khong hop le. Quay lai.");
                                break;
                        }
                        break;
                    }
                    default:
                        System.out.println("Lua chon khong hop le. Vui long chon lai!");
                        break;
                }
            } while (choice != 10);
        
            scanner.close();  // Đảm bảo Scanner được đóng sau khi hoàn tất
        }
        
    
        @Override
        public void Sach(int a) {  
            //Thêm Sách mới
            Sach [] dSach=new Sach[0];
            dSach=Sach.DocGhiDuLieuSach(false, dSach);
            Scanner sc=new Scanner(System.in);
            for(Sach tmp:dSach){
                System.out.println(tmp.toString());
            }
            
          if(a==1){
            System.out.println("Nhap so luong sach muon them");
            int n=Integer.parseInt(sc.nextLine());
            int i=1;
            while(i<=n){
                dSach=Sach.themSach(dSach);
                i++;
            }
            for(Sach p:dSach){
                System.out.println(p.toString());
            }
            Sach.DocGhiDuLieuSach(true, dSach);
          }
          else if(a==2){
            System.out.println("Nhap ma sach muon xoa");
            ChiTietSach[] dsCTSachs=new ChiTietSach[0];
          dsCTSachs=  ChiTietSach.DocGhiDuLieuChiTietSach(false, dsCTSachs);
            String masachxoa=sc.nextLine();
            boolean tontai=false;
            for(int i=0;i<dsCTSachs.length;i++){
                if(dsCTSachs[i].getSach().getMaTaiLieu().equals(masachxoa)){
                    tontai=true;
                    dsCTSachs[i].toString();
                }
            }
            if(!tontai){
                
                Sach.xoaSach(masachxoa, dSach);
                
            }
            else{
                System.out.println("Cac chi tiet sach tren chua duoc xoa. Muon xoa tua sach nay, can phai xoa cac chi tiet sach truoc");
            }
            

          }
          else if(a==3){
            System.out.println("Nhap ma sach muon sua");
            Sach.suaSach(sc.nextLine());
          }
          
        }
    
        @Override
        public void ChiTietSach(int a) {
            ChiTietSach [] ds=new ChiTietSach[0];
            ds=   ChiTietSach.DocGhiDuLieuChiTietSach(false, ds);
            if(a==1){
                ChiTietSach.themCTSach(ds);
            }
            if(a==2){
                ChiTietSach.xoaCTSach(ds);
            }
            if(a==3){
                ChiTietSach.suaCTSach(ds);
            }
        }
    
        @Override
        public void ThuThu(int a) {
            ThuThu[] dstt=new ThuThu[0];
            dstt=ThuThu.DocGhiDuLieuThuThu(false, dstt);
            Scanner scanner=new Scanner(System.in); 
            for(ThuThu tmp: dstt){
                System.out.println(tmp.toString());
            }
             switch (a) {
                 case 1:
                 System.out.println("Them du lieu");
                    dstt=ThuThu.nhapDanhSachThuThu(dstt);
                    for(ThuThu tmp: dstt){
                        System.out.println(tmp.toString());
                    }
                    ThuThu.DocGhiDuLieuThuThu(true, dstt);
                break;
                 case 2:
                 System.out.println("Nhap ma thu thu can xoa");    
                 dstt=ThuThu.removeThuThu(dstt,scanner.nextLine());
                 ThuThu.DocGhiDuLieuThuThu(true, dstt);
                break;
                 case 3:
                 System.out.println("Nhap ma thu thu can sua");    
                 ThuThu tmp= ThuThu.SearchId(dstt,scanner.nextLine());
                 if(tmp==null){
                    System.out.println("Ma thu thu ban vua nhap khong ton tai");
                    return;
                 }
                 else{

                 }
                 System.out.println("Thong tin thu thu can sua hien tai la");
                 System.out.println(tmp.toString());
                 int c;


                 while (true) { 
                     System.out.println("Chon thong tin muon sua");
                     System.out.println("1.Tên");
                     System.out.println("2.Tuổi");
                     System.out.println("3.Giờ làm");
                     System.out.println("4.Lương");
                     System.out.println("Chọn: ");
                     c=Integer.parseInt(scanner.nextLine());
                     if(c==1){
                        System.out.println("Nhap ten moi");
                        tmp.setTen(scanner.nextLine());
                     }
                     else if(c==2){
                 
                         System.out.print("Nhap tuoi: ");
                          while (true) {
            int tuoi;
            try {
                tuoi = Integer.parseInt(scanner.nextLine());
                if (tuoi > 18) {
                    tmp.setTuoi(tuoi); // Sử dụng setter để kiểm tra tuổi
                    break;
                }
                System.out.println("Tuoi phai lon hon 18. Vui long nhap lai.");
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap mot so hop le.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
                     }
                     else if(c==3){
                        int SoGioLam;
                        System.out.print("Nhap so gio lam: ");
                        while (true) {
                            try {
                                SoGioLam = Integer.parseInt(scanner.nextLine());
                                if (SoGioLam > 0)
                                    {
                                        tmp.setSoGioLam(SoGioLam);
                                        break;
                                    }
                                System.out.println("So gio lam phai lon hon 0. Vui long nhap lai.");
                            } catch (NumberFormatException e) {
                                System.out.println("Vui long nhap so hop le.");
                            }
                        }
                
                    }
                     else if(c==4){
                        System.out.print("Nhap luong: ");
                        int Luong;
                        while (true) {
                            try {
                                Luong = Integer.parseInt(scanner.nextLine());
                                if (Luong > 0)
                                    break;
                                System.out.println("Luong phai lon hon 0. Vui long nhap lai.");
                            } catch (NumberFormatException e) {
                                System.out.println("Vui long nhap so hop le.");
                            }
                        }
                     }
                     else if(c==5){
                        System.out.print("Nhap dia chi: ");
                        tmp.setDiaChi(scanner.nextLine());
                     }
                     break;
                    }
                 ThuThu.updateThuThu(dstt, tmp.getMaThuThu(), tmp);
                 ThuThu.DocGhiDuLieuThuThu(true, dstt);
                 System.out.println("Sua thong tin thu thu thanh cong");
                 
         }
    }

    @Override
    public void ViTri(int a) {
        viTri[] dViTri = viTri.DocGhiDuLieuViTri(false, new viTri[0]);
    
        if (a == 1) {
            // Thêm mới vị trí
            dViTri = viTri.nhapDanhSachViTri(dViTri);
            viTri.DocGhiDuLieuViTri(true, dViTri);
        } else if (a == 2) {
            String maxoa;
            boolean tontai = false;
            System.out.println("Nhap ma vi tri muon xoa");
    
            // Tạo một Scanner duy nhất
            Scanner sc = new Scanner(System.in);
            maxoa = sc.nextLine();
    
            // Lấy thông tin chi tiết sách
            ChiTietSach[] dsct = ChiTietSach.DocGhiDuLieuChiTietSach(false, new ChiTietSach[0]);
    
            // Kiểm tra nếu vị trí đang sử dụng
            for (int i = 0; i < dsct.length; i++) {
                if (dsct[i].getViTri().getId().equals(maxoa)) {
                    System.out.println(dsct[i].toString());
                    tontai = true;
                }
            }
    
            if (tontai) {
                System.out.println("Ton tai nhung chi tiet sach tren dang su dung vi tri nay. Neu muon xoa vi tri nay vui long doi vi tri cua nhung chi tiet sach tren truoc");
            } else {
                // Nếu không có chi tiết sách nào sử dụng vị trí này, tiến hành xóa
                dViTri = viTri.removeViTri(dViTri, maxoa);
                viTri.DocGhiDuLieuViTri(true, dViTri);
            }
        }
    }
    

    @Override
    public void TacGia(int a) {
        TacGia[] dstg=new TacGia[0];
        dstg=TacGia.DocGhiDuLieuTacGia(false, dstg);
        Scanner sc=new Scanner(System.in);
        if(a==1){
            System.out.println("Nhap so luong du lieu can them");
            int n=Integer.parseInt(sc.nextLine());
            int i=1;
            System.out.println("n: "+n);
            while (i<=n) { 
               System.out.println("Nhap du lieu thu "+i);
               TacGia tacGiaMoi= new TacGia();
               tacGiaMoi.NhapThongTin();
               dstg=TacGia.themTacGia(dstg, tacGiaMoi); 
               i++;
            }
            TacGia.DocGhiDuLieuTacGia(true, dstg);
        }
        if(a==2){
           System.out.println("Nhap ma tac gia can xoa");
           String id=sc.nextLine();
           dstg= TacGia.xoaTacGia(dstg, id);
           TacGia.DocGhiDuLieuTacGia(true, dstg);
           
        }
        if(a==3){
            //Sửa
            System.out.println("Nhap ma tac gia");
            String id=sc.nextLine();
            TacGia tmp=new TacGia();
            tmp=TacGia.timKiemTheoId(dstg, id);
            if(tmp==null){
               System.out.println("Ma ban vua nhap khong ton tai");
               System.out.println("Vui long nhap lai ma moi");
               tmp=TacGia.timKiemTheoId(dstg, sc.nextLine());
            }
            System.out.println(tmp.toString());
            System.out.println("Nhap ten tac gia moi");
            tmp.setTenTacGia(sc.nextLine());
           dstg= TacGia.suaTacGia(dstg, id, tmp.getTenTacGia());
           TacGia.DocGhiDuLieuTacGia(true, dstg);

        }
    }

    @Override
    public void NhaXuatBan(int a) {
        NhaXuatBan[] ds=new NhaXuatBan[0];
        ds=NhaXuatBan.DocGhiDuLieuNhaXuatBan(false, ds);
         if(a==1){
            System.out.println("Nhap so luong du lieu can them");
            Scanner scanner =new Scanner(System.in);
            int n=Integer.parseInt(scanner.nextLine());
            int i=1;

            while(i<=n){
                System.out.println("Nhap nha xuat ban thu "+i);
                NhaXuatBan tmp=new NhaXuatBan();
                tmp.nhapThongTin(ds);
                ds=NhaXuatBan.themNhaXuatBan(ds, tmp);
                i++;
            }
            NhaXuatBan.DocGhiDuLieuNhaXuatBan(true, ds);
         }
         else if (a==2) {
             System.out.println("Nhap ma Nha Xuat Ban can xoa");
             Scanner scanner =new Scanner(System.in);
            ds= NhaXuatBan.xoaNhaXuatBan(ds, scanner.nextLine());
            NhaXuatBan.DocGhiDuLieuNhaXuatBan(true, ds);
         }
        else if(a==3){
            System.out.println("Nhap ma Nha Xuat Ban can sua");
            Scanner scanner =new Scanner(System.in);
            String id=scanner.nextLine();
            System.out.println("Nhap ten moi");
            String ten=scanner.nextLine();
           ds= NhaXuatBan.chinhNhaXuatBAn(ds, id, ten);
            NhaXuatBan.DocGhiDuLieuNhaXuatBan(true, ds);
        }
    }

    @Override
    public void TheLoai(int a) {
        TheLoai[] ds = new TheLoai[0];
        ds = TheLoai.DocGhiDuLieuTheLoai(false, ds);
        System.out.println("The loai");
        for(TheLoai tmp:ds){
            System.out.println(tmp.toString());
        }
        if(a == 1){
            System.out.println("Nhập số lượng cần thêm");
            Scanner scanner = new Scanner(System.in);
            int n=Integer.parseInt(scanner.nextLine());
            int i=1;
             
            while(i<=n){
                System.out.println("Nhập thể loại thứ "+i);
                TheLoai tmp=new TheLoai();
                tmp.nhapThongTin(ds);
                ds = TheLoai.themTheLoai(ds, tmp);
                i++;
            }
            for(TheLoai tmp:ds){
                System.out.println(tmp.toString());
            }
            TheLoai.DocGhiDuLieuTheLoai(true, ds);
        }
        else if (a==2) {
            System.out.println("Nhập mã thể loại cần xoá");
            Scanner scanner =new Scanner(System.in);
           ds= TheLoai.xoaTheLoai(ds, scanner.nextLine());
           TheLoai.DocGhiDuLieuTheLoai(true, ds);
        }
       else if(a==3){
           System.out.println("Nhập mã thể loại cần sửa");
           Scanner scanner =new Scanner(System.in);
           String id=scanner.nextLine();
           System.out.println("Nhập tên mới");
           String ten=scanner.nextLine();
           ds = TheLoai.chinhTheLoai(ds, id, ten);
           
           TheLoai.DocGhiDuLieuTheLoai(true, ds);
       }
      
    }

    @Override
    public void TheThuVien(int a) {
        TheThuVien[] ds = new TheThuVien[0];
        ds = TheThuVien.DocGhiDuLieuTheThuVien(false, ds);
        if(a == 1){
            System.out.println("Nhập số lượng cần thêm");
            Scanner scanner = new Scanner(System.in);
            int n=Integer.parseInt(scanner.nextLine());
            int i=1;

            while(i<=n){
                System.out.println("Nhập thẻ thư viện thứ "+i);
                TheThuVien tmp = new TheThuVien(){
                    @Override
                    public int getSlsachmuon() {
                        throw new UnsupportedOperationException("Not supported yet.");
                    }

                    @Override
                    public int getSoNgayMuon() {
                        throw new UnsupportedOperationException("Not supported yet.");
                    }
                };
                tmp.nhapThongTin(ds);
                ds = TheThuVien.themThe(ds, tmp);
                i++;
            }
            TheThuVien.DocGhiDuLieuTheThuVien(true, ds);
        }
        else if (a==2) {
            System.out.println("Nhập mã thẻ thư viện cần xoá");
            Scanner scanner =new Scanner(System.in);
           ds= TheThuVien.xoaThe(ds, scanner.nextLine());
           TheThuVien.DocGhiDuLieuTheThuVien(true, ds);
        }
       else if(a==3){
           System.out.println("Nhập mã thẻ thư viện cần sửa");
           Scanner scanner =new Scanner(System.in);
           String id=scanner.nextLine();
           System.out.println("Nhập loại thẻ mới");
           String ten=scanner.nextLine();
           ds = TheThuVien.chinhThe(ds, id, ten);
           TheThuVien.DocGhiDuLieuTheThuVien(true, ds);
       }
    }
    @Override
    public void NguoiMuon(int a) {
        Scanner scanner=new Scanner(System.in);
          NguoiMuon [] ds=new NguoiMuon[0];
        ds=NguoiMuon.NhapGhiDL(false, ds);
        System.out.println("\n"+NguoiMuon.head());
        for(NguoiMuon tmp:ds){
            System.out.println(tmp.toString());
        }
  

        if (a == 1) { // Thêm người mượn
            System.out.println("Nhập thông tin người mượn:");
            String maNguoiMuon;
        
            while (true) {
                System.out.print("Mã người mượn (bắt đầu bằng 'NM' và 4 chữ số): ");
                maNguoiMuon = scanner.nextLine();
        
                if (maNguoiMuon.matches("NM\\d{4}")) {
                    break; // Thoát vòng lặp nếu hợp lệ
                } else {
                    System.out.println("Mã người mượn không hợp lệ. Vui lòng nhập lại!");
                }
            }
        
            System.out.println("Mã người mượn hợp lệ: " + maNguoiMuon);
            
            // Nhập thông tin còn lại
            System.out.print("Tên: ");
            String ten = scanner.nextLine();
            System.out.print("Tuổi: ");
            int tuoi = Integer.parseInt(scanner.nextLine());
            System.out.print("Địa chỉ: ");
            String diaChi = scanner.nextLine();
            System.out.print("Mã thẻ thư viện: ");
            String maThe = scanner.nextLine();
        
            // Giả sử có phương thức tạo thẻ thư viện từ mã thẻ
            TheThuVien[] dsttv = new TheThuVien[0];
            dsttv =TheThuVien.DocGhiDuLieuTheThuVien(false, dsttv);
            TheThuVien theThuVien = TheThuVien.SearchId(dsttv, maThe);
            while(theThuVien==null){
                System.out.println("Ma the thu vien ban vua nhap khong ton tai");
                System.out.println("Vui long nhap lai");
                maThe = scanner.nextLine();
                theThuVien = TheThuVien.SearchId(dsttv, maThe);
                
            }
            // Tạo người mượn mới và thêm vào danh sách
            NguoiMuon nguoiMuonMoi = new NguoiMuon(maNguoiMuon, ten, tuoi, diaChi, theThuVien);
            ds = NguoiMuon.addElementNguoiMuon(ds, nguoiMuonMoi); // Thêm vào danh sách
            System.out.println("Đã thêm người mượn thành công!");
            
        } else if (a == 2) { // Xóa người mượn
            System.out.print("Nhập mã người mượn cần xóa: ");
            String maNguoiMuonXoa = scanner.nextLine();
            ds = NguoiMuon.xoaNguoiMuon(ds, maNguoiMuonXoa); // Xóa khỏi danh sách
            System.out.println("Đã xóa người mượn thành công!");
            NguoiMuon.NhapGhiDL(true, ds);
        
        } 
        else if (a == 3) { // Sửa thông tin người mượn
            System.out.print("Nhập mã người mượn cần sửa: ");
            String maNguoiMuonSua = scanner.nextLine();
            NguoiMuon nguoiMuonCanSua = NguoiMuon.SearchId(ds, maNguoiMuonSua); // Tìm người mượn
            if (nguoiMuonCanSua != null) {
                System.out.println("Thông tin người mượn hiện tại:");
                nguoiMuonCanSua.hienThiThongTin(); // Hiển thị thông tin hiện tại

                System.out.println("Chọn thông tin muốn sửa:");
                System.out.println("1. Tên");
                System.out.println("2. Tuổi");
                System.out.println("3. Địa chỉ");
                System.out.println("4. Mã thẻ thư viện");
                System.out.print("Chọn chức năng: ");
                int suaChoice = Integer.parseInt(scanner.nextLine());

                switch (suaChoice) {
                    case 1: // Sửa tên
                        System.out.print("Nhập tên mới: ");
                        String tenMoi = scanner.nextLine();
                        nguoiMuonCanSua.setTen(tenMoi);
                        break;
                    case 2: // Sửa tuổi
                        System.out.print("Nhập tuổi mới: ");
                        int tuoiMoi = Integer.parseInt(scanner.nextLine());
                        nguoiMuonCanSua.setTuoi(tuoiMoi);
                        break;
                    case 3: // Sửa địa chỉ
                        System.out.print("Nhập địa chỉ mới: ");
                        String diaChiMoi = scanner.nextLine();
                        nguoiMuonCanSua.setDiaChi(diaChiMoi);
                        break;
                    case 4: // Sửa mã thẻ thư viện
                        System.out.print("Nhập mã thẻ thư viện mới: ");
                        String maTheMoi = scanner.nextLine();
                        TheThuVien []dsttv=new TheThuVien[0];
                      TheThuVien theThuVienMoi=  TheThuVien.SearchId(dsttv, maTheMoi);
                        nguoiMuonCanSua.setTheThuVien(theThuVienMoi);
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                        break;
                }

                System.out.println("Đã cập nhật thông tin người mượn thành công!");

                System.out.println("Đã cập nhật thông tin người mượn thành công!");
            } else {
                System.out.println("Không tìm thấy người mượn với mã này!");
            }

        } else if (a == 4) {
            System.out.println("Quay lại menu chính.");
        } else {
            System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
        }

        // Lưu lại dữ liệu sau khi thực hiện các thao tác
        NguoiMuon.NhapGhiDL(true, ds);

    }


}