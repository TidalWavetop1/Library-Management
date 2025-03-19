
import java.util.Calendar;
import java.util.Scanner;

public class ChucNangNguoiMuon implements QuyTrinhQuanLy {

    @Override
    public void Menu() {
        // TODO Auto-generated method stub
        int choice = -1;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        boolean t = true;
        do {
            System.out.println("MENU");
            System.out.println("1. Thong tin ve sach");
            System.out.println("2. Thong tin ve cac chi tiet sach");
            System.out.println("3. Thong tin ve tac gia");
            System.out.println("4. Thong tin ve cac the loai");
            System.out.println("5. Thong tin ve nguoi muon");
            System.out.println("6. Thong tin cua thu thu");
            System.out.println("7. Muon sach");
            System.out.println("8. Tra sach");
            System.out.println("0. Thoat");
            
            try {
                choice = Integer.parseInt(scanner.nextLine()); // Thử chuyển chuỗi thành số nguyên
                switch (choice) {
                    case 0:
                        System.out.println("Thoát chương trình");
                        t = false;
                    case 1:
                        System.out.println("1.Xem tat ca cac sach dang co");
                        System.out.println("2.Tim kiem sach");
                        Scanner sc = new Scanner(System.in);
                        int a;
                        while (true) {
                            System.out.print("Chọn một số (1 hoặc 2): ");
                            if (sc.hasNextInt()) { // Kiểm tra xem người dùng có nhập một số nguyên không
                                a = sc.nextInt();
                                if (a == 1 || a == 2) {
                                    break; // Nếu nhập hợp lệ, thoát khỏi vòng lặp
                                } else {
                                    System.out.println("Số không hợp lệ. Vui lòng nhập 1 hoặc 2.");
                                }
                            } else {
                                System.out.println("Đầu vào không phải là số. Vui lòng nhập một số nguyên.");
                                sc.next(); // Đọc bỏ phần đầu vào không hợp lệ
                            }

                        }
                        Sach(a);

                        break;
                    case 2:
                        System.out.println("1.Xem tat ca cac chi tiet dang co");
                        System.out.println("2.Tim kiem sach");
                        Scanner Sc = new Scanner(System.in);
                        while (true) {
                            System.out.print("Chọn một số (1 hoặc 2): ");
                            if (Sc.hasNextInt()) {
                                a = Sc.nextInt();
                                if (a == 1 || a == 2) {
                                    break; // Nếu nhập hợp lệ, thoát khỏi vòng lặp
                                } else {
                                    System.out.println("Số không hợp lệ. Vui lòng nhập 1 hoặc 2.");
                                }
                            } else {
                                System.out.println("Đầu vào không phải là số. Vui lòng nhập một số nguyên.");
                                Sc.next();
                            }

                        }
                        ChiTietSach(a);
                        Sc.close();
                        break;
                    case 3:
                        System.out.println("1.Xem tat ca cac tac gia co sach trong thu vien");
                        System.out.println("2.Tim kiem tac gia");
                        Scanner scanner1 = new Scanner(System.in);
                        while (true) {
                            System.out.print("Chọn một số (1 hoặc 2): ");
                            if (scanner1.hasNextInt()) {
                                a = scanner1.nextInt();
                                if (a == 1 || a == 2) {
                                    break; // Nếu nhập hợp lệ, thoát khỏi vòng lặp
                                } else {
                                    System.out.println("Số không hợp lệ. Vui lòng nhập 1 hoặc 2.");
                                }
                            } else {
                                System.out.println("Đầu vào không phải là số. Vui lòng nhập một số nguyên.");
                                scanner1.next();
                            }

                        }
                        TacGia(a);
                        break;
                    case 4:
                        System.out.println("1.Xem tat ca cac the loai hien co trong thu vien");
                        System.out.println("2.Tim kiem the loai");
                        Scanner scanner2 = new Scanner(System.in);
                        while (true) {
                            System.out.print("Chọn một số (1 hoặc 2): ");
                            if (scanner2.hasNextInt()) {
                                a = scanner2.nextInt();
                                if (a == 1 || a == 2) {
                                    break; // Nếu nhập hợp lệ, thoát khỏi vòng lặp
                                } else {
                                    System.out.println("Số không hợp lệ. Vui lòng nhập 1 hoặc 2.");
                                }
                            } else {
                                System.out.println("Đầu vào không phải là số. Vui lòng nhập một số nguyên.");
                                scanner2.next();
                            }

                        }
                        TheLoai(a);
                        break;
                    case 5:
                        System.out.println("1.Xem tat ca thong tin nguoi muon da dang ky trong thu vien");
                        System.out.println("2.Tim kiem nguoi muon thong qua ten");
                        Scanner scanner3 = new Scanner(System.in);
                        while (true) {
                            System.out.print("Chọn một số (1 hoặc 2): ");
                            if (scanner3.hasNextInt()) {
                                a = scanner3.nextInt();
                                if (a == 1 || a == 2) {
                                    break;
                                } else {
                                    System.out.println("Số không hợp lệ. Vui lòng nhập 1 hoặc 2.");
                                }
                            } else {
                                System.out.println("Đầu vào không phải là số. Vui lòng nhập một số nguyên.");
                                scanner3.next();
                            }
                        }
                        NguoiMuon(a);
                        break;
                    case 6:
                        System.out.println("1.Xem tat ca thong tin nguoi muon da dang ky trong thu vien");
                        System.out.println("2.Tim kiem nguoi muon thong qua ten");
                        Scanner scanner4 = new Scanner(System.in);
                        while (true) {
                            System.out.print("Chọn một số (1 hoặc 2): ");
                            if (scanner4.hasNextInt()) {
                                a = scanner4.nextInt();
                                if (a == 1 || a == 2) {
                                    break;
                                } else {
                                    System.out.println("Số không hợp lệ. Vui lòng nhập 1 hoặc 2.");
                                }
                            } else {
                                System.out.println("Đầu vào không phải là số. Vui lòng nhập một số nguyên.");
                                scanner4.next();
                            }

                        }
                        NguoiMuon(a);
                        break;
                    case 7:
                        MuonSach();
                        break;
                    case 8:
                        traSach();
                    default:
                        System.out.println("Vui long nhap tu 0 den 9");
                }

            } catch (NumberFormatException e) {
            }
        } while (t);
    }

    public void MuonSach() {
        TheThuVien[] dsthe = new TheThuVien[0];
        TTMuon[] dsm = new TTMuon[0];
        ChiTietSach[] cts = new ChiTietSach[0];
        cts = ChiTietSach.DocGhiDuLieuChiTietSach(false, cts);
        dsthe = TheThuVien.DocGhiDuLieuTheThuVien(false, dsthe);
        dsm = TTMuon.NhapGhiDL(false, dsm);
        System.out.println("Nhap ma the thu vien cua ban");
        Scanner sc = new Scanner(System.in);
        TheThuVien the = TheThuVien.SearchId(dsthe, sc.nextLine());
        int s = 0;
        if (the != null) {

            for (int i = 0; i < dsm.length; i++) {

                if (dsm[i].TheMuon.getMaThe().equals(the.getMaThe())) {
                    if (dsm[i].TrangThai) {
                        s++;
                    }
                }
            }
            if (s < the.getSlsachmuon()) {
                System.out.println("Nhap ma sach muon muon");
                String sachmuon = sc.nextLine();
                for (int i = 0; i < cts.length; i++) {
                    if (cts[i].getSach().getMaTaiLieu().equals(sachmuon)) {
                            cts[i].setTheThuVien(the);         
                        Calendar calendar = Calendar.getInstance();
                        Calendar hanmuon = Calendar.getInstance();
                        hanmuon.add(Calendar.DAY_OF_MONTH, the.getSoNgayMuon());
                        TTMuon newtt = new TTMuon(the, calendar, hanmuon, cts[i], true);
                        dsm = TTMuon.addElementTTMuon(dsm, newtt);
                        System.out.println("Ban da muon sach thanh cong");
                        System.out.println("Han phai tra la: " + TTMuon.toStringNgay(hanmuon));
                        break;
                    }
                }
                ChiTietSach.DocGhiDuLieuChiTietSach(true, cts);
                TTMuon.NhapGhiDL(true, dsm);
            }
        }
    }

    public void traSach() {
        TheThuVien[] dsthe = new TheThuVien[0];
        TTMuon[] dsm = new TTMuon[0];
        ChiTietSach[] cts = new ChiTietSach[0];
        cts = ChiTietSach.DocGhiDuLieuChiTietSach(false, cts);
        dsthe = TheThuVien.DocGhiDuLieuTheThuVien(false, dsthe);
        dsm = TTMuon.NhapGhiDL(false, dsm);
        System.out.println("Nhap ma the thu vien cua ban");
        Scanner sc = new Scanner(System.in);
        TheThuVien the = TheThuVien.SearchId(dsthe, sc.nextLine());
        System.out.println("Nhap ma the thu vien cua ban");
        for (int i = 0; i < dsm.length; i++) {
            if (dsm[i].TheMuon.getMaThe().equals(the.getMaThe())) {
                if (dsm[i].TrangThai) {
                    System.out.println(dsm[i].toString());
                }
            }
        }
        System.out.println("Nhap ma hoa don muon ma ban muon tra");
        String mamuon = sc.nextLine();
    
        boolean thanhcong=false;
        TTMuon tmp=new TTMuon();
        for (int i = 0; i < dsm.length; i++) {
            if (dsm[i].idMuon.equals(mamuon)) {
                dsm[i].TrangThai = false;
                tmp=dsm[i];
                for (int j = 0; j < cts.length; j++) {
                    if (dsm[i].SachMuon.id.equals(cts[j].id)) {
                        cts[j].setTheThuVien(null);
                        System.out.println("Tra sach thanh cong");
                        TTMuon.NhapGhiDL(true, dsm);
                        ChiTietSach.DocGhiDuLieuChiTietSach(true, cts);
                       thanhcong=true;
                    }
                }
            }
        }

        // if(thanhcong){
            
        //     tmp=TTMuon.SearchId(dsm, mamuon);
        //     System.out.println("Phi tre han cua ban la");
        //     if(tmp.TheMuon.getLoaiThe()=="A"){
        //         System.out.println( LoaiA.phitrehan(tmp.NgayMuon,  Calendar.getInstance()));
        //     }
        // }
    }

    @Override
    public void Sach(int a) {
        Sach[] dsSach = new Sach[0];
        dsSach = Sach.DocGhiDuLieuSach(false, dsSach);
        if (a == 1) {
            System.out.println("Hiển thị tất cả các sách...");
            System.out.println(Sach.head());
            for (Sach tmp : dsSach) {
                System.out.println(tmp.toString());
            }
        } else if (a == 2) {
            System.out.println("Tìm kiếm sách...");
            System.out.println("Nhập từ khoá bạn muốn tìm kiếm");
            Scanner sc = new Scanner(System.in);
            Sach.timKiemSachTheoTen(sc.nextLine());
        }
    }

    @Override
    public void ThuThu(int a) {
        ThuThu[] dstt = new ThuThu[0];
        dstt = ThuThu.DocGhiDuLieuThuThu(false, dstt);
        String head = String.format("%5s%15s%2s%10s%3s%10s", "Mã thủ thư", "Tên", "Tuổi", "Địa chỉ", "Số giờ làm",
                "Lương");
        System.out.println(head);
        for (ThuThu tmp : dstt) {
            System.out.println(tmp.toString());
        }
        if (a == 1) {
            System.out.println("Hiển thị tất cả các thủ thư");
            System.out.println(ThuThu.head());
            for (ThuThu tmp : dstt) {
                System.out.println(tmp.toString());
            }
        } else if (a == 2) {
            System.out.println("Tìm kiếm tác giả...");
            System.out.println("Nhập từ khoá bạn muốn tìm kiếm");
            Scanner sc = new Scanner(System.in);
            ThuThu[] ds = new ThuThu[0];
            ds = ThuThu.findNameThuThu_tuongdoi(dstt, sc.nextLine());
            System.out.println(ThuThu.head());
            for (ThuThu tmp : ds) {
                System.out.println(tmp.toString());
            }
        }
    }

    @Override
    public void ViTri(int a) {
        throw new UnsupportedOperationException("Unimplemented method 'ViTri'");
    }

    @Override
    public void TacGia(int a) {
        TacGia[] dstg = new TacGia[0];
        dstg = TacGia.DocGhiDuLieuTacGia(false, dstg);
        if (a == 1) {
            System.out.println("Hiển thị tất cả các sách...");
            System.out.println(TacGia.head());
            for (TacGia tmp : dstg) {
                System.out.println(tmp.toString());
            }
        } else if (a == 2) {
            System.out.println("Tìm kiếm tác giả...");
            System.out.println("Nhập từ khoá bạn muốn tìm kiếm");
            Scanner sc = new Scanner(System.in);
            TacGia[] ds = new TacGia[0];
            ds = TacGia.timKiemTheoTen(dstg, sc.nextLine());
            System.out.println(TacGia.head());
            for (TacGia tmp : ds) {
                System.out.println(tmp.toString());
            }
        }
    }

    @Override
    public void NhaXuatBan(int a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'NhaXuatBan'");
    }

    @Override
    public void TheLoai(int a) {
        TheLoai[] dstg = new TheLoai[0];
        dstg = TheLoai.DocGhiDuLieuTheLoai(false, dstg);
        if (a == 1) {
            System.out.println("Hiển thị tất cả các thể loại...");
            System.out.println(TheLoai.head());
            for (TheLoai tmp : dstg) {
                System.out.println(tmp.toString());
            }
        } else if (a == 2) {
            System.out.println("Tìm kiếm tác giả...");
            System.out.println("Nhập từ khoá bạn muốn tìm kiếm");
            Scanner sc = new Scanner(System.in);
            TheLoai[] ds = new TheLoai[0];
            ds = TheLoai.searchPartialName(dstg, sc.nextLine());
            System.out.println(TacGia.head());
            for (TheLoai tmp : ds) {
                System.out.println(tmp.toString());
            }
        }
    }

    @Override
    public void ChiTietSach(int a) {
        ChiTietSach[] dsSach = new ChiTietSach[0];
        dsSach = ChiTietSach.DocGhiDuLieuChiTietSach(false, dsSach);
        if (a == 1) {
            System.out.println("Hien thi tat ca cac thong tin chi tiet cua sach...");
            System.out.println(ChiTietSach.head());
            for (ChiTietSach tmp : dsSach) {
                System.out.println(tmp.toString());
            }
        } else if (a == 2) {
            System.out.println("Tìm kiếm sách...");
            System.out.println("Nhập tên sách bạn muốn xem chi tiết tìm kiếm");
            Sach(2);
            System.out.println("Nhap ma sach ma ban muon xem chi tiet");
            Scanner sc = new Scanner(System.in);
            String maCT = sc.nextLine();
            System.out.println("Thong tin chi tiet cua ma tai lieu ban vua nhap la");
            System.out.println(ChiTietSach.head());
            for (int i = 0; i < dsSach.length; i++) {
                if (dsSach[i].getSach().getMaTaiLieu().equals(maCT)) {
                    System.out.println(dsSach[i].toString());
                }
            }

        }
    }

    @Override
    public void TheThuVien(int a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'TheThuVien'");
    }

    @Override
    public void NguoiMuon(int a) {
        NguoiMuon[] ds = new NguoiMuon[0];
        ds = NguoiMuon.NhapGhiDL(false, ds);
        if (a == 1) {
            System.out.println("Hien thi tat ca thong tin nguoi muon da dang ky...");
            System.out.println(NguoiMuon.head());
            for (NguoiMuon tmp : ds) {
                System.out.println(tmp.toString());
            }
        } else if (a == 2) {
            System.out.println("Tim kiem nguoi muon...");
            System.out.println("Nhap ten nguoi muon:");
            Scanner sc = new Scanner(System.in);
            NguoiMuon[] dsnm = new NguoiMuon[0];
            dsnm = NguoiMuon.findNameThuMuon_tuongdoi(ds, sc.nextLine());
            System.out.println(NguoiMuon.head());
            for (NguoiMuon tmp : dsnm) {
                System.out.println(tmp.toString());
            }
        }
    }

}
