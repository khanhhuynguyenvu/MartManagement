package group.jpa.ogm.app.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
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

import com.arjuna.ats.internal.jdbc.drivers.modifiers.list;
import com.toedter.calendar.JDateChooser;

import group.jpa.ogm.app.controller.client.ClientController;
import group.jpa.ogm.app.entities.Account;
import group.jpa.ogm.app.entities.Category;
import group.jpa.ogm.app.entities.Good;

public class Gui_Manager extends JFrame implements ActionListener, MouseListener {

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

	JButton btnAdd_Acc, btnRemove_Acc, btnModify_Acc, btnSave_Acc, btnSearch_Acc;
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
	JLabel stock_lblGoodId, stock_lblGoodName, stock_lblEnterDate, stock_lblQuantity, stock_lblPrice,
			stock_lblCategoryName;
	JDateChooser stock_txtEnterDate;
	JButton stock_btnAdd, stock_btnRemove, stock_btnModify, stock_btnSave;

	JTable tableGood;
	DefaultTableModel tblModelGood;

	JComboBox<String> cbbCategoryName;
	DefaultComboBoxModel<String> modelcbbCategoryName;

	static ClientController callService;

	public Gui_Manager() throws RemoteException, NotBoundException {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1100, 700);
		setResizable(true);
		setTitle("Form Quản lý");
		setIconImage(new ImageIcon(getClass()
				.getResource("../ima/if_H_sign_hospital_hospital_sign_hospital__medical__road_sign_1887039.png"))
						.getImage());
		// tab
		tabManager = new JTabbedPane();
		tabManager.setTabPlacement(JTabbedPane.LEFT);

		callService = new ClientController("192.168.31.22", 9999);

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

		// acc_bt.add(acc_b1); // add button help, logout to Account Box
		add(acc_b1, BorderLayout.NORTH);
		acc_bt.add(Box.createVerticalStrut(0));

		// form quáº£n lÃ½ nhÃ¢n viÃªn
		Box acc_bqlbn = Box.createVerticalBox(); // acc_bqlbn: Box quáº£n lÃ½ nhÃ¢n viÃªn

		Box acc_bqlbn1 = Box.createHorizontalBox(); // acc_bqlbn1 lÃ  box Ä‘á»ƒ quáº£n lÃ½ text field

		Box acc_bqlbn1_Acc = Box.createVerticalBox();
		acc_bqlbn1_Acc.setBorder(BorderFactory.createTitledBorder("Thông tin tải khoản"));

		// id, username, pass, start, status

		// textfield ID
		Box acc_bqlbn1_Acc_Id = Box.createHorizontalBox();
		acc_bqlbn1_Acc_Id.add(lblAccId = new JLabel("Mã nhân viên: "));
		acc_bqlbn1_Acc_Id.add(Box.createHorizontalStrut(20));// Khoáº£ng cÃ¡ch giá»¯a chá»¯ vÃ  textfield
		acc_bqlbn1_Acc_Id.add(txtAccId = new JTextField());
		// txtAccId.setPreferredSize(getPreferredSize());

		// textfield UserName
		Box acc_bqlbn1_Acc_US = Box.createHorizontalBox();
		acc_bqlbn1_Acc_US.add(lblAccUserName = new JLabel("Tên tài khoản: "));
		acc_bqlbn1_Acc_US.add(Box.createHorizontalStrut(20));
		acc_bqlbn1_Acc_US.add(txtAccUserName = new JTextField());
		// cbbName.setPreferredSize(getPreferredSize());

		// textfield PassWord
		Box acc_bqlbn1_Acc_Pass = Box.createHorizontalBox();
		acc_bqlbn1_Acc_Pass.add(lblAccPass = new JLabel("Mật khẩu: "));
		acc_bqlbn1_Acc_Pass.add(Box.createHorizontalStrut(45));
		acc_bqlbn1_Acc_Pass.add(txtAccPass = new JTextField());
		// txtQuantity.setPreferredSize(getPreferredSize());

		// textfield StartingDate
		Box acc_bqlbn1_Acc_Start = Box.createHorizontalBox();
		acc_bqlbn1_Acc_Start.add(lblAccStartingDate = new JLabel("Ngày bắt đầu: "));
		acc_bqlbn1_Acc_Start.add(Box.createHorizontalStrut(20));
		acc_bqlbn1_Acc_Start.add(txtAccStartingDate = new JDateChooser());
		// txtPrice.setPreferredSize(getPreferredSize());

		// textfield Status
		Box acc_bqlbn1_Acc_Status = Box.createHorizontalBox();
		acc_bqlbn1_Acc_Status.add(lblAccStatus = new JLabel("Trạng thái: "));
		acc_bqlbn1_Acc_Status.add(Box.createHorizontalStrut(40));
		acc_bqlbn1_Acc_Status.add(radAccActive = new JRadioButton("Active"));
		acc_bqlbn1_Acc_Status.add(Box.createHorizontalStrut(10));
		acc_bqlbn1_Acc_Status.add(radAccNoActive = new JRadioButton("No"));
		acc_bqlbn1_Acc_Status.add(Box.createHorizontalGlue());
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

		Box acc_bqlbn2_ChucNang = Box.createVerticalBox(); // acc_bqlbn2_ChucNang lÃ  quáº£n lÃ½ dÃ²ng cÃ¡c nÃºt chá»©c
															// nÄƒng

		acc_bqlbn2_ChucNang.setBorder(BorderFactory.createTitledBorder("Chức năng"));
		acc_bqlbn2_ChucNang.setMaximumSize(getMaximumSize());

		Box acc_bqlbn2_ChucNang_1 = Box.createHorizontalBox();
		// acc_bqlbn2_ChucNang_1.add(Box.createHorizontalStrut(10));
		/*
		 * acc_bqlbn2_ChucNang_1.add( btnAdd_Acc = new JButton("Thêm", new
		 * ImageIcon(getClass().getResource("../ima/if_7_330410.png"))));
		 * btnAdd_Acc.setMaximumSize(getMaximumSize());
		 */
		acc_bqlbn2_ChucNang_1.add(Box.createHorizontalStrut(10));
		acc_bqlbn2_ChucNang_1.add(btnModify_Acc = new JButton("Cập nhật",
				new ImageIcon(getClass().getResource("../ima/if_brush-pencil_1055103.png"))));
		btnModify_Acc.setMaximumSize(getMaximumSize());
		acc_bqlbn2_ChucNang_1.add(Box.createHorizontalStrut(10));
		acc_bqlbn2_ChucNang_1.add(btnRemove_Acc = new JButton("Xoá",
				new ImageIcon(getClass().getResource("../ima/if_Save_1493294.png"))));
		btnRemove_Acc.setMaximumSize(getMaximumSize());
		acc_bqlbn2_ChucNang_1.add(Box.createHorizontalStrut(10));
		acc_bqlbn2_ChucNang_1.add(btnSave_Acc = new JButton("Lưu",
				new ImageIcon(getClass().getResource("../ima/if_receipt_3583272.png"))));
		btnSave_Acc.setMaximumSize(getMaximumSize());

		acc_bqlbn2_ChucNang.add(acc_bqlbn2_ChucNang_1);

		Box acc_bqlbn3_Danhsach = Box.createVerticalBox(); // acc_bqlbn3_Danhsach_Acc lÃ  quáº£n lÃ½ cÃ¡i báº£ng danh
		// sÃ¡ch

		acc_bqlbn3_Danhsach.setBorder(BorderFactory.createTitledBorder("Danh sách nhân viên"));
		Box acc_bqlbn3_Danhsach_Acc_1 = Box.createHorizontalBox();

		String[] headers = "Mã nhân viên; Tên tài khoản; Loại nhân viên;Mật khẩu; Ngày bắt đầu; Trạng thái".split(";");
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
		String[] timKiemNV = { "Tìm theo ID", "Tìm theo tên" };
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
		bNV_CN.add(stock_btnSave = new JButton("Lưu",
				new ImageIcon(getClass().getResource("../ima/if_Save_1493294.png"))));
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
		bStock_TT1.add(stock_lblCategoryName = new JLabel("Loại"));

		bStock_TT1.add(Box.createHorizontalStrut(30));

		modelcbbCategoryName = new DefaultComboBoxModel<String>();
		bStock_TT1.add(cbbCategoryName = new JComboBox<String>(modelcbbCategoryName));
		cbbCategoryName.setPreferredSize(new Dimension(150, 50));
		// cbbCategoryName.setSize(100, 100);

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
		// add(treeGoods, BorderLayout.WEST);

		///

		bStock.add(bStock_ChucNang = Box.createVerticalBox());

		bStock_ChucNang.add(bStock_CN = Box.createHorizontalBox());
		bStock_ChucNang.setBorder(BorderFactory.createTitledBorder("Chức năng"));

		bStock_CN.add(
				stock_btnAdd = new JButton("Thêm", new ImageIcon(getClass().getResource("../ima/if_7_330410.png"))));
		bStock_CN.add(Box.createHorizontalStrut(10));
		bStock_CN.add(stock_btnModify = new JButton("Sửa",
				new ImageIcon(getClass().getResource("../ima/if_brush-pencil_1055103.png"))));
		bStock_CN.add(Box.createHorizontalStrut(10));
		bStock_CN.add(stock_btnSave = new JButton("Lưu",
				new ImageIcon(getClass().getResource("../ima/if_Save_1493294.png"))));
		bStock_CN.add(Box.createHorizontalStrut(10));
		bStock_CN.add(stock_btnModify = new JButton("Tải lại danh sách",
				new ImageIcon(getClass().getResource("../ima/if_--07_1720774.png"))));
		bStock_CN.add(Box.createHorizontalStrut(10));
		bStock_CN.add(stock_btnRemove = new JButton("Xóa",
				new ImageIcon(getClass().getResource("../ima/if_user-trash_118932.png"))));

		// ***********************
		bStock.add(bStock_DanhSach = Box.createVerticalBox());
		bStock_DanhSach.setBorder(BorderFactory.createTitledBorder("Danh sách sản phẩm"));

		String[] headersStock = "Mã sản phẩm; Loại;Tên sản phẩm; Ngày nhập; Số lượng; Giá".split(";");
		tblModelGood = new DefaultTableModel(headersStock, 0);
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

		/* load data */

		LoadAccountsToTable();
		LoadAllCategoiesToComboBox();
		// LoadProductsToTable();

		/* add actionListener account frame */

		// btnAdd_Acc.addActionListener(this);
		btnModify_Acc.addActionListener(this);
		btnRemove_Acc.addActionListener(this);

		tableAccount.addMouseListener(this);

		/* add actionlListener stock frame */
		stock_btnAdd.addActionListener(this);

		add(tabManager, BorderLayout.CENTER);
		add(tabManager);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();

		if (obj.equals(btnModify_Acc)) {
			try {
				updateAccountActions();
			} catch (RemoteException | NotBoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (obj.equals(btnRemove_Acc)) {
			if (JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				try {
					RemoveAccountActions();
				} catch (RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {
				// no option
			}
		} else if(obj.equals(stock_btnAdd)) {
			try {
				AddProductActions();
			} catch (RemoteException | NotBoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tableAccount.getSelectedRow();

		if (row >= 0) {
			txtAccId.setText(tableAccount.getValueAt(row, 0).toString());
			txtAccUserName.setText(tableAccount.getValueAt(row, 1).toString());

			txtAccPass.setText(tableAccount.getValueAt(row, 3).toString());

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			try {
				txtAccStartingDate.setDate(sdf.parse((String) tableAccount.getValueAt(row, 4)));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			if (tableAccount.getValueAt(row, 5).toString().equals("No"))
				radAccNoActive.setSelected(true);
			else
				radAccActive.setSelected(true);

		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void AddAccountActions() throws AccessException, RemoteException, NotBoundException {
		String userName = txtAccUserName.getText();
		String passWord = txtAccPass.getText();
		Date startingDate = txtAccStartingDate.getDate();
		String getStatus = null;
		if (radAccActive.isSelected()) {
			getStatus = radAccActive.getText();
		} else {
			getStatus = radAccNoActive.getText();
		}

		Account ac = new Account();
		ac.setUsername(userName);
		ac.setPassword(passWord);
		ac.setStartingDate(startingDate);
		ac.setStatus(getStatus);

		callService.getAccountDAO().save(ac);
		System.out.println("DONE");
	}

	public void LoadAccountsToTable() throws AccessException, RemoteException, NotBoundException {
		List<Account> listAccounts = callService.getAccountDAO().findAll();

		System.out.println("size: " + listAccounts.size());

		if (listAccounts.size() > 0) {
			for (Account account : listAccounts) {
				String id = account.getId();
				String userName = account.getUsername();
				// int type = account.getType();
				String passWord = account.getPassword();
				Date startingDate = account.getStartingDate();

				System.out.println("date: " + startingDate);
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

				String status = account.getStatus();

				String rowData[] = { id, userName, "Nhân viên", passWord, sdf.format(startingDate), status };
				tblModelAccount.addRow(rowData);
			}
		}

	}

	public void updateAccountActions() throws AccessException, RemoteException, NotBoundException {
		String id = txtAccId.getText();
		String getUserName = txtAccUserName.getText();
		String getPassWord = txtAccPass.getText();
		Date getStartingDate = txtAccStartingDate.getDate();

		String getStatus = null;
		if (radAccActive.isSelected()) {
			getStatus = radAccActive.getText();
		} else {
			getStatus = radAccNoActive.getText();
		}

		Account ac = new Account();

		ac.setId(id);
		ac.setUsername(getUserName);
		ac.setPassword(getPassWord);
		ac.setStartingDate(getStartingDate);
		ac.setStatus(getStatus);

		callService.getAccountDAO().update(ac);
	}

	public void RemoveAccountActions() throws AccessException, RemoteException, NotBoundException {
		String id = txtAccId.getText();
		Account ac = new Account();
		ac.setId(id);
		callService.getAccountDAO().remove(ac);
	}
	/* method stock frame */

	public void LoadProductsToTable() throws AccessException, RemoteException, NotBoundException {
		ArrayList<Good> listGoods = (ArrayList<Good>) callService.getGoodDAO().findAll();

		for (int i = 0; i < listGoods.size(); i++) {
			String id = listGoods.get(i).getId();
			String name = listGoods.get(i).getName();
			SimpleDateFormat sdf = new SimpleDateFormat("dd//MM//yyyy");
			Date enterDate = listGoods.get(i).getEnterDate();
			int quantity = listGoods.get(i).getQuantity();
			double price = listGoods.get(i).getPrice();

			String rowData[] = { id, name, sdf.format(enterDate), Integer.toString(quantity), Double.toString(price) };
			tblModelGood.addRow(rowData);
		}
	}

	public void LoadAllCategoiesToComboBox() throws AccessException, RemoteException, NotBoundException {
		ArrayList<Category> listCategories = (ArrayList<Category>) callService.getCategoryDAO().findAll();

		for (int i = 0; i < listCategories.size(); i++) {
			String getName = listCategories.get(i).getName();
			modelcbbCategoryName.addElement(getName);
		}

	}

	public Category getProductByName() throws AccessException, RemoteException, NotBoundException {
		String name = (String) cbbCategoryName.getSelectedItem();

		Category category = callService.getCategoryDAO().findbyName(name);

		if (category != null)
			return category;
		return null;
	}

	public void AddProductActions() throws AccessException, RemoteException, NotBoundException {
		Category category = getProductByName();
		
		System.out.println("category name: " + category.getName());
		
		String name = stock_txtGoodName.getText();
		Date enterDate = stock_txtEnterDate.getDate();
		int qty = Integer.parseInt(stock_txtQuantity.getText());
		double price = Double.parseDouble(stock_txtPrice.getText());

		Good g = new Good();
		g.setName(name);
		g.setEnterDate(enterDate);
		g.setQuantity(qty);
		g.setPrice(price);
		g.setCategory(category);

		SimpleDateFormat sdf = new SimpleDateFormat("dd//MM//yyyy");
		
		

		String rowData[] = { name, category.getName(), sdf.format(enterDate), Integer.toString(qty),
				Double.toString(price) };
		tblModelGood.addRow(rowData);
		callService.getGoodDAO().save(g);
		System.out.println("DONE");
	}
}