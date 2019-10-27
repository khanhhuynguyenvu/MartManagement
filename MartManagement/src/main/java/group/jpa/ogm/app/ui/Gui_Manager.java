package group.jpa.ogm.app.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;



public class Gui_Manager extends JFrame {

	JButton acc_btnLogout, acc_btnHelp;

	// Manganer tab

	JTabbedPane tabManager;

	// ----- Form Account

	JTextField txtAccId, txtAccUserName, txtAccPass;
	JTextField txtAccSearch;
	JDateChooser txtAccStartingDate;
	JRadioButton radAccActive, radAccNoActive;
	ButtonGroup grAccStatus;

	JTable tableAccount;
	DefaultTableModel tblModelAccount;
	//

	JLabel lblAccId, lblAccUserName, lblAccPass, lblAccType, lblAccStartingDate, lblAccStatus, lblAccActive,
			lblAccNoActive;

	JButton acc_btnAdd_Acc, acc_btnRemove_Acc, acc_btnModify_Acc, acc_btnSave_Acc, acc_btnSearch_Acc;
	// Quản lý nhân viên
	private JLabel lblNhanVienID, lblHoNhanVien, lblTenNhanVien, lblSDTNhanVien, lblNSNhanVien, lblDiaChiNhanVien;
	private JTextField txtNhanVienID, txtHoNhanVien, txtTenNhanVien, txtSDTNhanVien, txtDiaChiNhanVien, txtTimNhanVien;
//private DatePicker datePicker;
	private JButton btnThemNV, btnSuaNV, btnLuuNV, btnTimNV, btnXoaNV, btnCapNhat;
	private JComboBox<String> cbbTimNhanVien;
	private JTable tableNhanVien;
	private DefaultTableModel modelNhanVien;

	/* Quan ly kho */
	JTextField stock_txtGoodtId, stock_txtGoodName, stock_txtQuantity, stock_txtPrice;
	JLabel stock_lblGoodId, stock_lblGoodName, stock_lblEnterDate, stock_lblQuantity, stock_lblPrice;
	JDateChooser stock_txtEnterDate;
	JButton stock_btnAdd, stock_btnRemove, stock_btnModify, stock_btnSave;
	
	JTable tableGood;
	DefaultTableModel tblModelGood;

	public Gui_Manager() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1100, 700);
		setResizable(true);
		setTitle("Form Quáº£n lÃ½");
		setIconImage(new ImageIcon(getClass()
				.getResource("../ima/if_H_sign_hospital_hospital_sign_hospital__medical__road_sign_1887039.png"))
						.getImage());
		// tab
		tabManager = new JTabbedPane();
		tabManager.setTabPlacement(JTabbedPane.LEFT);

		//
		Box acc_bt = Box.createVerticalBox();// CÃ¡i nÃ y lÃ  quáº£n lÃ½ chung cá»§a cáº£ frame
		/**
		 * CÃ¡i nÃ y lÃ  tiÃªu Ä‘ï¿½?
		 */

		////////////////////////////////
		Box acc_b1 = Box.createHorizontalBox();
		acc_b1.setMaximumSize(getMaximumSize());
		acc_b1.add(Box.createHorizontalStrut(20));
		acc_b1.add(new JLabel(
				new ImageIcon(getClass().getResource("../ima/if_cv_job_seeker_employee_unemployee_work_2620524.png"))));
		acc_b1.add(Box.createHorizontalStrut(10));

		acc_b1.add(Box.createHorizontalStrut(400));
		acc_b1.add(acc_btnLogout = new JButton("Đăng nhập",
				new ImageIcon(getClass().getResource("../ima/if_Logout_105217.png"))));
		acc_bt.add(Box.createVerticalStrut(10));
		acc_b1.add(Box.createHorizontalStrut(10));
		acc_b1.add(acc_btnHelp = new JButton("Thông tin",
				new ImageIcon(getClass().getResource("../ima/if_user_help_1902262.png"))));

		//acc_bt.add(acc_b1); // add button help, logout to Account Box
		add(acc_b1, BorderLayout.NORTH);
		acc_bt.add(Box.createVerticalStrut(0));

		// form quáº£n lÃ½ nhÃ¢n viÃªn
		Box acc_bqlbn = Box.createVerticalBox(); // acc_bqlbn: Box quáº£n lÃ½ nhÃ¢n viÃªn

		Box acc_bqlbn1 = Box.createHorizontalBox(); // acc_bqlbn1 lÃ  box Ä‘á»ƒ quáº£n lÃ½ text field

		Box acc_bqlbn1_Acc = Box.createVerticalBox();
		acc_bqlbn1_Acc.setBorder(BorderFactory.createTitledBorder("Thông tin nhân viên"));

		// id, username, pass, start, status

		// textfield ID
		Box acc_bqlbn1_Acc_Id = Box.createHorizontalBox();
		acc_bqlbn1_Acc_Id.add(new JLabel("Mã nhân viên: "));
		acc_bqlbn1_Acc_Id.add(Box.createHorizontalStrut(20));// Khoáº£ng cÃ¡ch giá»¯a chá»¯ vÃ  textfield
		acc_bqlbn1_Acc_Id.add(txtAccId = new JTextField());
		txtAccId.setPreferredSize(getPreferredSize());

		// textfield UserName
		Box acc_bqlbn1_Acc_US = Box.createHorizontalBox();
		acc_bqlbn1_Acc_US.add(new JLabel("Tên tài khoản: "));
		acc_bqlbn1_Acc_US.add(Box.createHorizontalStrut(60));
		acc_bqlbn1_Acc_US.add(txtAccUserName = new JTextField());
		// cbbName.setPreferredSize(getPreferredSize());

		// textfield PassWord
		Box acc_bqlbn1_Acc_Pass = Box.createHorizontalBox();
		acc_bqlbn1_Acc_Pass.add(new JLabel("Mật khẩu: "));
		acc_bqlbn1_Acc_Pass.add(Box.createHorizontalStrut(90));
		acc_bqlbn1_Acc_Pass.add(txtAccPass = new JTextField());
		// txtQuantity.setPreferredSize(getPreferredSize());

		// textfield StartingDate
		Box acc_bqlbn1_Acc_Start = Box.createHorizontalBox();
		acc_bqlbn1_Acc_Start.add(new JLabel("Ngày bắt đầu: "));
		acc_bqlbn1_Acc_Start.add(Box.createHorizontalStrut(120));
		acc_bqlbn1_Acc_Start.add(txtAccStartingDate = new JDateChooser());
		// txtPrice.setPreferredSize(getPreferredSize());

		// textfield Status
		Box acc_bqlbn1_Acc_Status = Box.createHorizontalBox();
		acc_bqlbn1_Acc_Status.add(new JLabel("Trạng thái: "));
		acc_bqlbn1_Acc_Status.add(Box.createHorizontalStrut(120));
		acc_bqlbn1_Acc_Status.add(radAccActive = new JRadioButton("Active"));
		acc_bqlbn1_Acc_Status.add(Box.createHorizontalStrut(10));
		acc_bqlbn1_Acc_Status.add(radAccNoActive = new JRadioButton("No"));

		grAccStatus = new ButtonGroup();
		grAccStatus.add(radAccActive);
		grAccStatus.add(radAccNoActive);

		// add khoáº£ng khoáº£ng cÃ¡ch giá»¯a textfield
		acc_bqlbn1_Acc.add(acc_bqlbn1_Acc_Id);
		acc_bqlbn1_Acc.add(Box.createVerticalStrut(5));
		acc_bqlbn1_Acc.add(acc_bqlbn1_Acc_US);
		acc_bqlbn1_Acc.add(Box.createVerticalStrut(10));
		acc_bqlbn1_Acc.add(acc_bqlbn1_Acc_Pass);
		acc_bqlbn1_Acc.add(Box.createVerticalStrut(5));
		acc_bqlbn1_Acc.add(acc_bqlbn1_Acc_Start);
		acc_bqlbn1_Acc.add(Box.createVerticalStrut(5));
		acc_bqlbn1_Acc.add(acc_bqlbn1_Acc_Status);

		acc_bqlbn1.add(Box.createHorizontalStrut(10));
		acc_bqlbn.add(acc_bqlbn1);

		Box acc_bqlbn2_ChucNang = Box.createVerticalBox(); // acc_bqlbn2_ChucNang lÃ  quáº£n lÃ½ dÃ²ng cÃ¡c nÃºt chá»©c nÄƒng

		acc_bqlbn2_ChucNang.setBorder(BorderFactory.createTitledBorder("Chức năng"));
		acc_bqlbn2_ChucNang.setMaximumSize(getMaximumSize());

		Box acc_bqlbn2_ChucNang_1 = Box.createHorizontalBox();
		acc_bqlbn2_ChucNang_1.add(Box.createHorizontalStrut(10));
		acc_bqlbn2_ChucNang_1.add(
				acc_btnAdd_Acc = new JButton("ThÃªm", new ImageIcon(getClass().getResource("../ima/if_7_330410.png"))));
		acc_btnAdd_Acc.setMaximumSize(getMaximumSize());
		acc_bqlbn2_ChucNang_1.add(Box.createHorizontalStrut(10));
		acc_bqlbn2_ChucNang_1.add(acc_btnModify_Acc = new JButton("Cập nhật",
				new ImageIcon(getClass().getResource("../ima/if_brush-pencil_1055103.png"))));
		acc_btnModify_Acc.setMaximumSize(getMaximumSize());
		acc_bqlbn2_ChucNang_1.add(Box.createHorizontalStrut(10));
		acc_bqlbn2_ChucNang_1.add(acc_btnRemove_Acc = new JButton("Xoá",
				new ImageIcon(getClass().getResource("../ima/if_Save_1493294.png"))));
		acc_btnRemove_Acc.setMaximumSize(getMaximumSize());
		acc_bqlbn2_ChucNang_1.add(Box.createHorizontalStrut(10));
		acc_bqlbn2_ChucNang_1.add(acc_btnSave_Acc = new JButton("Lưu",
				new ImageIcon(getClass().getResource("../ima/if_receipt_3583272.png"))));
		acc_btnSave_Acc.setMaximumSize(getMaximumSize());

		acc_bqlbn2_ChucNang.add(acc_bqlbn2_ChucNang_1);

		Box acc_bqlbn3_Danhsach = Box.createVerticalBox(); // acc_bqlbn3_Danhsach_Acc lÃ  quáº£n lÃ½ cÃ¡i báº£ng danh
		// sÃ¡ch

		acc_bqlbn3_Danhsach.setBorder(BorderFactory.createTitledBorder("Danh sách nhân viên"));
		Box acc_bqlbn3_Danhsach_Acc_1 = Box.createHorizontalBox();

		String[] headers = "Mã nhân viên; Tên tài khoản; Mật khẩu; Ngày bắt đầu; Trạng thái".split(";");
		tblModelAccount = new DefaultTableModel(headers, 0);
		acc_bqlbn3_Danhsach_Acc_1.add(new JScrollPane(tableAccount = new JTable(tblModelAccount)));
		tableAccount.setDefaultEditor(Object.class, null);
		acc_bqlbn3_Danhsach.add(acc_bqlbn3_Danhsach_Acc_1);

		acc_bqlbn1.add(acc_bqlbn1_Acc); // add box gá»“m cÃ¡c textfield
		acc_bqlbn.add(acc_bqlbn2_ChucNang); // add buttons
		acc_bqlbn.add(acc_bqlbn3_Danhsach); // add table

		acc_bt.add(acc_bqlbn);
		add(acc_bt);
		/// quáº£n li nhan viÃªn

		Box bNhanVien = Box.createVerticalBox();
		Box bNV1, bNV2, bNV3;
		Box bNV_TT, bNV_TT1, bNV_TT2, bNV_TT3, bNV_TT4, bNV_TT5, bNV_TT6;
		Box bNV_TK, bNV_TK1, bNV_CN;

		bNhanVien.add(bNV1 = Box.createHorizontalBox());

		bNV1.add(bNV_TT = Box.createVerticalBox());
		bNV_TT.setBorder(BorderFactory.createTitledBorder("Thông tin nhân viên"));

		bNV_TT.add(bNV_TT1 = Box.createHorizontalBox());
		bNV_TT.add(Box.createVerticalStrut(10));
		bNV_TT1.add(lblNhanVienID = new JLabel("Mã nhân viên"));
		bNV_TT1.add(Box.createHorizontalStrut(10));
		bNV_TT1.add(txtNhanVienID = new JTextField());

		bNV_TT.add(bNV_TT2 = Box.createHorizontalBox());
		bNV_TT.add(Box.createVerticalStrut(10));
		bNV_TT2.add(lblHoNhanVien = new JLabel("Họ"));
		bNV_TT2.add(Box.createHorizontalStrut(10));
		bNV_TT2.add(txtHoNhanVien = new JTextField());

		bNV_TT.add(bNV_TT3 = Box.createHorizontalBox());
		bNV_TT.add(Box.createVerticalStrut(10));
		bNV_TT3.add(lblTenNhanVien = new JLabel("Tên"));
		bNV_TT3.add(Box.createHorizontalStrut(10));
		bNV_TT3.add(txtTenNhanVien = new JTextField());

		bNV_TT.add(bNV_TT4 = Box.createHorizontalBox());
		bNV_TT.add(Box.createVerticalStrut(10));
		bNV_TT4.add(lblSDTNhanVien = new JLabel(""));
		bNV_TT4.add(Box.createHorizontalStrut(10));
		bNV_TT4.add(txtSDTNhanVien = new JTextField());

		bNV_TT.add(bNV_TT5 = Box.createHorizontalBox());
		bNV_TT.add(Box.createVerticalStrut(10));
		bNV_TT5.add(lblDiaChiNhanVien = new JLabel("Địa chỉ"));
		bNV_TT5.add(Box.createHorizontalStrut(10));
		bNV_TT5.add(txtDiaChiNhanVien = new JTextField());

		bNV_TT.add(bNV_TT6 = Box.createHorizontalBox());
		bNV_TT6.add(lblNSNhanVien = new JLabel("Ngày sinh"));
		bNV_TT6.add(Box.createHorizontalStrut(10));
		// bNV_TT6.add(datePicker = new DatePicker());

		lblTenNhanVien.setPreferredSize(lblNhanVienID.getPreferredSize());
		lblDiaChiNhanVien.setPreferredSize(lblNhanVienID.getPreferredSize());
		lblHoNhanVien.setPreferredSize(lblNhanVienID.getPreferredSize());
		lblSDTNhanVien.setPreferredSize(lblNhanVienID.getPreferredSize());
		lblNSNhanVien.setPreferredSize(lblNhanVienID.getPreferredSize());

		// ***********************
		bNV1.add(bNV_TK = Box.createVerticalBox());
		bNV_TK.setMinimumSize(getMinimumSize());
		bNV_TK.setBorder(BorderFactory.createTitledBorder("Tìm kiếm nhâ nvie6n"));
		bNV_TK.add(bNV_TK1 = Box.createHorizontalBox());
		String[] timKiemNV = { "Tìm theo ID", "Tìm theo tên"};
		bNV_TK1.add(cbbTimNhanVien = new JComboBox<String>(timKiemNV));
		bNV_TK1.add(Box.createHorizontalStrut(10));
		bNV_TK1.add(txtTimNhanVien = new JTextField(1));
		bNV_TK1.add(Box.createHorizontalStrut(10));
		bNV_TK1.add(btnTimNV = new JButton("Tìm",
				new ImageIcon(getClass().getResource("../ima/if_search_magnifying_glass_find_103857.png"))));
		bNV_TK.add(Box.createVerticalStrut(185));

		// ***********************
		bNhanVien.add(bNV2 = Box.createVerticalBox());
		bNV2.add(bNV_CN = Box.createHorizontalBox());
		bNV2.setBorder(BorderFactory.createTitledBorder("Chức năng"));
		bNV_CN.add(stock_btnAdd = new JButton("Thêm", new ImageIcon(getClass().getResource("../ima/if_7_330410.png"))));
		bNV_CN.add(Box.createHorizontalStrut(10));
		bNV_CN.add(stock_btnModify = new JButton("Sửa",
				new ImageIcon(getClass().getResource("../ima/if_brush-pencil_1055103.png"))));
		bNV_CN.add(Box.createHorizontalStrut(10));
		bNV_CN.add(
				stock_btnSave = new JButton("Lưu", new ImageIcon(getClass().getResource("../ima/if_Save_1493294.png"))));
		bNV_CN.add(Box.createHorizontalStrut(10));

		bNV_CN.add(Box.createHorizontalStrut(10));
		bNV_CN.add(stock_btnRemove = new JButton("Xoá",
				new ImageIcon(getClass().getResource("../ima/if_user-trash_118932.png"))));

		// ***********************
		bNhanVien.add(bNV3 = Box.createVerticalBox());
		bNV3.setBorder(BorderFactory.createTitledBorder("Danh sách nhân viên"));

		String[] headersNV = "Mã nah6n viên;Họ tên; Địa chỉ; Ngày sinh; Giới tinh".split(";");
		modelNhanVien = new DefaultTableModel(headersNV, 0);
		JScrollPane scrollNV = new JScrollPane();
		scrollNV.setViewportView(tableNhanVien = new JTable(modelNhanVien));
		tableNhanVien.setRowHeight(20);
		tableNhanVien.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		bNV3.add(scrollNV);

		// form kho hang

		Box bStock = Box.createVerticalBox();

		Box bStock_ThongTin, bStock_ChucNang, bStock_DanhSach, bStock_CN;
		Box bStock_TT, bStock_TT1, bStock_TT2, bStock_TT3, bStock_TT4, bStock_TT5;

		bStock.add(bStock_ThongTin = Box.createVerticalBox());

		bStock_ThongTin.setBorder(BorderFactory.createTitledBorder("Thông tin hàng hóa"));

		bStock_ThongTin.add(bStock_TT1 = Box.createHorizontalBox());
		bStock_ThongTin.add(Box.createVerticalStrut(10));
		bStock_TT1.add(stock_lblGoodId = new JLabel("Mã sản phẩm"));
		bStock_TT1.add(Box.createHorizontalStrut(10));
		bStock_TT1.add(stock_txtGoodtId = new JTextField());

		bStock_ThongTin.add(bStock_TT2 = Box.createHorizontalBox());
		bStock_ThongTin.add(Box.createVerticalStrut(10));
		bStock_TT2.add(stock_lblGoodName = new JLabel("Tên sản phẩm"));
		bStock_TT2.add(Box.createHorizontalStrut(10));
		bStock_TT2.add(stock_txtGoodName = new JTextField());

		bStock_ThongTin.add(bStock_TT3 = Box.createHorizontalBox());
		bStock_ThongTin.add(Box.createVerticalStrut(10));
		bStock_TT3.add(stock_lblEnterDate = new JLabel("Ngày nhập"));
		bStock_TT3.add(Box.createHorizontalStrut(10));
		bStock_TT3.add(stock_txtEnterDate = new JDateChooser());

		bStock_ThongTin.add(bStock_TT4 = Box.createHorizontalBox());
		bStock_ThongTin.add(Box.createVerticalStrut(10));
		bStock_TT4.add(stock_lblQuantity = new JLabel("Số lượng"));
		bStock_TT4.add(Box.createHorizontalStrut(10));
		bStock_TT4.add(stock_txtQuantity = new JTextField());

		bStock_ThongTin.add(bStock_TT5 = Box.createHorizontalBox());
		bStock_ThongTin.add(Box.createVerticalStrut(10));
		bStock_TT5.add(stock_lblPrice = new JLabel("Giá"));
		bStock_TT5.add(Box.createHorizontalStrut(10));
		bStock_TT5.add(stock_txtPrice = new JTextField());
		
		// tree
		DynamicTree treeGoods;
		treeGoods = new DynamicTree();
		
		treeGoods.setPreferredSize(new Dimension(250, 150));
		bStock.add(treeGoods);
		//add(treeGoods, BorderLayout.WEST);

		///

		bStock.add(bStock_ChucNang = Box.createVerticalBox());

		bStock_ChucNang.add(bStock_CN = Box.createHorizontalBox());
		bStock_ChucNang.setBorder(BorderFactory.createTitledBorder("Chức năng"));

		bStock_CN
				.add(stock_btnAdd = new JButton("Thêm", new ImageIcon(getClass().getResource("../ima/if_7_330410.png"))));
		bStock_CN.add(Box.createHorizontalStrut(10));
		bStock_CN.add(btnSuaNV = new JButton("Sửa",
				new ImageIcon(getClass().getResource("../ima/if_brush-pencil_1055103.png"))));
		bStock_CN.add(Box.createHorizontalStrut(10));
		bStock_CN.add(btnLuuNV = new JButton("Lưu", new ImageIcon(getClass().getResource("../ima/if_Save_1493294.png"))));
		bStock_CN.add(Box.createHorizontalStrut(10));
		bStock_CN.add(btnCapNhat = new JButton("Tải lại danh sách",
				new ImageIcon(getClass().getResource("../ima/if_--07_1720774.png"))));
		bStock_CN.add(Box.createHorizontalStrut(10));
		bStock_CN.add(
				btnXoaNV = new JButton("Xóa", new ImageIcon(getClass().getResource("../ima/if_user-trash_118932.png"))));

		// ***********************
		bStock.add(bStock_DanhSach = Box.createVerticalBox());
		bStock_DanhSach.setBorder(BorderFactory.createTitledBorder("Danh sách sản phẩm"));

		String[] headersStock = "Mã sản phẩm; Tên sản phẩm; Ngày nhập; Số lượng; Giá".split(";");
		tblModelGood = new DefaultTableModel(headersNV, 0);
		JScrollPane scrollStock = new JScrollPane();
		scrollStock.setViewportView(tableGood = new JTable(tblModelGood));
		tableGood.setRowHeight(20);
		tableGood.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		bStock_DanhSach.add(scrollStock);

		// Box bNV_TT, bNV_TT1, bNV_TT2, bNV_TT3, bNV_TT4, bNV_TT5, bNV_TT6;
		// Box bNV_TK, bNV_TK1, bStock_CN;

		tabManager.addTab("Quản lý tài khoản", new ImageIcon(getClass().getResource("../ima/if_Account_1891016.png")),
				acc_bt);

		tabManager.addTab("Quản lý nhân viên", new ImageIcon(getClass().getResource("../ima/if_group_318580.png")),
				bNhanVien);
		tabManager.addTab("Quản lý kho", new ImageIcon(getClass().getResource("../ima/if_group_318580.png")), bStock);
		
		add(tabManager, BorderLayout.CENTER);
		add(tabManager);
	}

	public static void main(String[] args) {
		new Gui_Manager().setVisible(true);
	}
}
