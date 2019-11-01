package group.jpa.ogm.app.ui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import group.jpa.ogm.app.controller.client.ClientController;
import group.jpa.ogm.app.entities.Account;
import group.jpa.ogm.app.entities.Employee;

import group.jpa.ogm.app.repository.account.AccountDAOImpl;

import group.jpa.ogm.app.entities.Good;
import group.jpa.ogm.app.entities.Invoice;
import group.jpa.ogm.app.entities.InvoiceDetails;
import javassist.expr.Instanceof;

/**
 * 
 * @author Ngô Tuấn Kiệt
 *
 */

public class Gui_Employee extends JFrame implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/////////////// ///////////////
	private JPasswordField txtmkc, txtmkm, txtnlmkm;
	private JTabbedPane tbpqlcn;

	// Employee

	private JLabel lblId, lblFullName, lblAddress, lblDateOfBirth;
	private JTextField txtId, txtFullName, txtAddress, txtDateOfBirth;

	private JLabel lblOldPass, lblConfirmPass, lblNewPass;
	private JTextField txtOldPass, txtConfirmPass, txtNewPass;

	private JButton btnChangePass, btnCancel;

	// Order

	JTextField txtSearch, txtProductId, txtQuantity, txtPrice;
	JLabel lblSearch, lblName, lblQuantity, lblPrice;
	JButton btnSearch;
	JButton btnAdd, btnRemove, btnModify, btnSave, btnIcon, btnLogout, btnPrintInvoice;

	JComboBox<String> cbbProductName;
	DefaultComboBoxModel<String> modelcbbProductName;

	JLabel lblSumInvoice;
	double sumInvoice;

	///////////////

	private JTabbedPane tbp;

	private JTable table;
	private DefaultTableModel tablemodel;

	private JTable tableProduct;
	private DefaultTableModel modelProduct;
	/*
	 * private NhanVienNhanBenhDaos nhanVienNhanBenhDaos; private List<BenhNhan>
	 * dsbn; private List<NhanVien> dsnv;
	 */
	private JButton btnHelp;
	private Account account;

	static ClientController callService;

	public Gui_Employee(Account account) throws RemoteException, NotBoundException {
		this.account = account;

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1100, 700);
		setResizable(true);
		setTitle("Nhân viên bán hàng");
		setIconImage(new ImageIcon(getClass()
				.getResource("../ima/if_H_sign_hospital_hospital_sign_hospital__medical__road_sign_1887039.png"))
						.getImage());

		callService = new ClientController("192.168.31.22", 9999);

		Box bt = Box.createVerticalBox();// CÃ¡i nÃ y lÃ  quáº£n lÃ½ chung cá»§a cáº£ frame
		/**
		 * 
		 */
		////////////////////////////////
		Box b1 = Box.createHorizontalBox();
		b1.setMaximumSize(getMaximumSize());
		b1.add(Box.createHorizontalStrut(20));
		b1.add(new JLabel(
				new ImageIcon(getClass().getResource("../ima/if_cv_job_seeker_employee_unemployee_work_2620524.png"))));
		b1.add(Box.createHorizontalStrut(10));

		b1.add(Box.createHorizontalStrut(400));
		b1.add(btnLogout = new JButton("Đăng xuất",
				new ImageIcon(getClass().getResource("../ima/if_Logout_105217.png"))));
		bt.add(Box.createVerticalStrut(10));
		b1.add(Box.createHorizontalStrut(10));
		b1.add(btnHelp = new JButton("Hỗ trợ",
				new ImageIcon(getClass().getResource("../ima/if_user_help_1902262.png"))));
		bt.add(b1);
		bt.add(Box.createVerticalStrut(0));
		/////////////////////////////////
		/**
		 * 
		 */
		/////////////////////////////////
		Box bqlbn = Box.createVerticalBox();
		Box bqlbn1 = Box.createHorizontalBox();
		Box bqlbn1_ThongTin = Box.createVerticalBox();
		bqlbn1_ThongTin.setBorder(BorderFactory.createTitledBorder("Thông tin nhân viên"));

		Box bqlbn1_ThongTin_IdBN = Box.createHorizontalBox();
		bqlbn1_ThongTin_IdBN.add(new JLabel("Tìm thông tin sảm phẩm: "));
		bqlbn1_ThongTin_IdBN.add(Box.createHorizontalStrut(20));
		bqlbn1_ThongTin_IdBN.add(txtSearch = new JTextField());
		txtSearch.setPreferredSize(getPreferredSize());
		bqlbn1_ThongTin_IdBN.add(Box.createHorizontalStrut(10));
		bqlbn1_ThongTin_IdBN.add(btnSearch = new JButton("Tìm"));

		Box bqlbn1_ThongTin_Ho = Box.createHorizontalBox();
		bqlbn1_ThongTin_Ho.add(new JLabel("Tên sản phẩm: "));
		bqlbn1_ThongTin_Ho.add(Box.createHorizontalStrut(60));
		modelcbbProductName = new DefaultComboBoxModel<String>();
		bqlbn1_ThongTin_Ho.add(cbbProductName = new JComboBox<String>(modelcbbProductName));

		Box bqlbn1_ThongTin_PId = Box.createHorizontalBox();
		bqlbn1_ThongTin_PId.add(new JLabel("Mã sản phẩm: "));
		bqlbn1_ThongTin_PId.add(Box.createHorizontalStrut(60));
		bqlbn1_ThongTin_PId.add(txtProductId = new JTextField());

		// cbbName.setPreferredSize(getPreferredSize());

		Box bqlbn1_ThongTin_Ten = Box.createHorizontalBox();
		bqlbn1_ThongTin_Ten.add(new JLabel("Số lượng: "));
		bqlbn1_ThongTin_Ten.add(Box.createHorizontalStrut(90));
		bqlbn1_ThongTin_Ten.add(txtQuantity = new JTextField());
		// txtQuantity.setPreferredSize(getPreferredSize());

		Box bqlbn1_ThongTin_Sdt = Box.createHorizontalBox();
		bqlbn1_ThongTin_Sdt.add(new JLabel("Giá: "));
		bqlbn1_ThongTin_Sdt.add(Box.createHorizontalStrut(120));
		bqlbn1_ThongTin_Sdt.add(txtPrice = new JTextField());
		// txtPrice.setPreferredSize(getPreferredSize());

		bqlbn1_ThongTin.add(bqlbn1_ThongTin_IdBN);
		bqlbn1_ThongTin.add(Box.createVerticalStrut(5));
		bqlbn1_ThongTin.add(bqlbn1_ThongTin_Ho);
		bqlbn1_ThongTin.add(Box.createVerticalStrut(10));
		bqlbn1_ThongTin.add(bqlbn1_ThongTin_PId);
		bqlbn1_ThongTin.add(Box.createVerticalStrut(10));

		bqlbn1_ThongTin.add(bqlbn1_ThongTin_Ten);
		bqlbn1_ThongTin.add(Box.createVerticalStrut(5));
		bqlbn1_ThongTin.add(bqlbn1_ThongTin_Sdt);

		bqlbn1.add(bqlbn1_ThongTin);
		bqlbn1.add(Box.createHorizontalStrut(10));// Giáº£n cÃ¡ch giá»¯a hai box thÃ´ng tin vÃ  tÃ¬m kiáº¿m
		// bqlbn1.add(bqlbn1_TimKiem_BenhNhan_BacSi);

		Box bqlbn2_ChucNang = Box.createVerticalBox(); // bqlbn2_ChucNang lÃ  quáº£n lÃ½ dÃ²ng cÃ¡c nÃºt chá»©c nÄƒng
		bqlbn2_ChucNang.setBorder(BorderFactory.createTitledBorder("Chức năng"));
		bqlbn2_ChucNang.setMaximumSize(getMaximumSize());
		Box bqlbn2_ChucNang_1 = Box.createHorizontalBox();
		bqlbn2_ChucNang_1.add(Box.createHorizontalStrut(10));
		bqlbn2_ChucNang_1
				.add(btnAdd = new JButton("Thêm", new ImageIcon(getClass().getResource("../ima/if_7_330410.png"))));
		btnAdd.setMaximumSize(getMaximumSize());
		bqlbn2_ChucNang_1.add(Box.createHorizontalStrut(10));
		bqlbn2_ChucNang_1.add(btnModify = new JButton("Cập nhật",
				new ImageIcon(getClass().getResource("../ima/if_brush-pencil_1055103.png"))));
		btnModify.setMaximumSize(getMaximumSize());
		bqlbn2_ChucNang_1.add(Box.createHorizontalStrut(10));
		bqlbn2_ChucNang_1.add(
				btnRemove = new JButton("Xóa", new ImageIcon(getClass().getResource("../ima/if_Save_1493294.png"))));
		btnRemove.setMaximumSize(getMaximumSize());
		/*
		 * bqlbn2_ChucNang_1.add(Box.createHorizontalStrut(10));
		 * bqlbn2_ChucNang_1.add(btnPrintInvoice = new JButton("In hóa đơn", new
		 * ImageIcon(getClass().getResource("../ima/if_receipt_3583272.png"))));
		 * btnPrintInvoice.setMaximumSize(getMaximumSize());
		 */

		bqlbn2_ChucNang.add(bqlbn2_ChucNang_1);

		Box bqlbn3_Danhsach = Box.createVerticalBox(); // bqlbn3_Danhsach lÃ  quáº£n lÃ½ cÃ¡i báº£ng danh sÃ¡ch
		bqlbn3_Danhsach.setBorder(BorderFactory.createTitledBorder("Danh sách mua"));
		Box bqlbn3_Danhsach_1 = Box.createHorizontalBox();
		String[] headers = "Mã sản phẩm; Tên sản phẩm; Số lượng; Giá mỗi sản phẩm; Thành tiền".split(";");
		modelProduct = new DefaultTableModel(headers, 0);
		bqlbn3_Danhsach_1.add(new JScrollPane(tableProduct = new JTable(modelProduct)));
		// tableProduct.setDefaultEditor(Object.class, null);
		bqlbn3_Danhsach.add(bqlbn3_Danhsach_1);

		Box bqlbn3_Sum = Box.createHorizontalBox();
		bqlbn3_Sum.add(Box.createHorizontalGlue());
		bqlbn3_Sum.add(new JLabel("Tong"));
		bqlbn3_Sum.add(Box.createHorizontalStrut(10));
		bqlbn3_Sum.add(lblSumInvoice = new JLabel());

		bqlbn3_Sum.add(btnPrintInvoice = new JButton("In hóa đơn",
				new ImageIcon(getClass().getResource("../ima/if_receipt_3583272.png"))));
		// btnPrintInvoice.setMaximumSize(getMaximumSize());
		bqlbn3_Danhsach.add(bqlbn3_Sum);

		bqlbn.add(bqlbn1);
		bqlbn.add(bqlbn2_ChucNang);
		bqlbn.add(bqlbn3_Danhsach);
		/////////////////////////////////
		/**
		 * CÃ¡i nÃ y lÃ  quáº£n lÃ½ cÃ¡ nhÃ¢n
		 */
		/////////////////////////////////

		tbpqlcn = new JTabbedPane();

		Box b_BasicInfo, b_ChangePassword;

		b_BasicInfo = Box.createVerticalBox();// b_BasicInfo quáº£n lÃ½ chung cá»§a xem thÃ´ng tin

		Box b_BasicInfo_Id = Box.createHorizontalBox();
		b_BasicInfo_Id.add(Box.createHorizontalStrut(10));
		b_BasicInfo_Id.add(lblId = new JLabel("Mã nhân viên:"));
		lblId.setFont(new Font("Times new roman", Font.PLAIN, 16));
		b_BasicInfo_Id.add(Box.createHorizontalStrut(50));
		b_BasicInfo_Id.add(txtId = new JTextField());
		b_BasicInfo_Id.add(Box.createHorizontalStrut(50));

		Box b_BasicInfo_FullName = Box.createHorizontalBox();
		b_BasicInfo_FullName.add(Box.createHorizontalStrut(10));
		b_BasicInfo_FullName.add(lblFullName = new JLabel("Họ và tên: "));
		lblFullName.setFont(new Font("Times new roman", Font.PLAIN, 16));
		b_BasicInfo_FullName.add(Box.createHorizontalStrut(90));
		b_BasicInfo_FullName.add(txtFullName = new JTextField());
		b_BasicInfo_FullName.add(Box.createHorizontalStrut(50));

		Box b_BasicInfo_DOfBirth = Box.createHorizontalBox();
		b_BasicInfo_DOfBirth.add(Box.createHorizontalStrut(10));
		b_BasicInfo_DOfBirth.add(lblDateOfBirth = new JLabel("Ngày sinh:"));
		lblDateOfBirth.setFont(new Font("Times new roman", Font.PLAIN, 16));
		b_BasicInfo_DOfBirth.add(Box.createHorizontalStrut(90));
		b_BasicInfo_DOfBirth.add(txtDateOfBirth = new JTextField());
		b_BasicInfo_DOfBirth.add(Box.createHorizontalStrut(50));

		Box b_BasicInfo_Address = Box.createHorizontalBox();
		b_BasicInfo_Address.add(Box.createHorizontalStrut(10));
		b_BasicInfo_Address.add(lblAddress = new JLabel("Địa chỉ:"));
		lblAddress.setFont(new Font("Times new roman", Font.PLAIN, 16));
		b_BasicInfo_Address.add(Box.createHorizontalStrut(110));
		b_BasicInfo_Address.add(txtAddress = new JTextField());
		b_BasicInfo_Address.add(Box.createHorizontalStrut(50));

		b_BasicInfo.add(Box.createVerticalStrut(10));
		b_BasicInfo.add(b_BasicInfo_Id);
		b_BasicInfo.add(Box.createVerticalStrut(10));
		b_BasicInfo.add(b_BasicInfo_FullName);

		b_BasicInfo.add(Box.createVerticalStrut(10));
		b_BasicInfo.add(b_BasicInfo_DOfBirth);

		b_BasicInfo.add(Box.createVerticalStrut(10));
		b_BasicInfo.add(b_BasicInfo_Address);
		b_BasicInfo.add(Box.createVerticalStrut(300));

		b_ChangePassword = Box.createVerticalBox();// b_ChangePassword lÃ  quáº£n lÃ½ chung cá»§a Ä‘á»•i máº­t kháº©u

		Box b_ChangePassword_mkc = Box.createHorizontalBox();
		b_ChangePassword_mkc.add(Box.createHorizontalStrut(20));
		b_ChangePassword_mkc.add(lblOldPass = new JLabel("Nhập lại mật khẩu"));
		lblOldPass.setFont(new Font("Times new roman", Font.PLAIN, 16));
		b_ChangePassword_mkc.add(Box.createHorizontalStrut(50));
		b_ChangePassword_mkc.add(txtOldPass = new JPasswordField());
		b_ChangePassword_mkc.add(Box.createHorizontalStrut(20));

		Box b_ChangePassword_mkm = Box.createHorizontalBox();
		b_ChangePassword_mkm.add(Box.createHorizontalStrut(20));
		b_ChangePassword_mkm.add(lblNewPass = new JLabel("Nhập mật khẩu mới"));
		lblNewPass.setFont(new Font("Times new roman", Font.PLAIN, 16));
		b_ChangePassword_mkm.add(Box.createHorizontalStrut(60));
		b_ChangePassword_mkm.add(txtNewPass = new JPasswordField());
		b_ChangePassword_mkm.add(Box.createHorizontalStrut(20));

		Box b_ChangePassword_nlmkm = Box.createHorizontalBox();
		b_ChangePassword_nlmkm.add(Box.createHorizontalStrut(20));
		b_ChangePassword_nlmkm.add(lblConfirmPass = new JLabel("Nhập lại mật khẩu mới"));
		lblConfirmPass.setFont(new Font("Times new roman", Font.PLAIN, 16));
		b_ChangePassword_nlmkm.add(Box.createHorizontalStrut(40));
		b_ChangePassword_nlmkm.add(txtConfirmPass = new JPasswordField());
		b_ChangePassword_nlmkm.add(Box.createHorizontalStrut(20));

		Box b_ChangePassword_button = Box.createHorizontalBox();
		b_ChangePassword_button.add(Box.createHorizontalStrut(20));
		b_ChangePassword_button.add(btnChangePass = new JButton("Đổi mật khẩu",
				new ImageIcon(getClass().getResource("../ima/if_Access_field_pin_input_password_2629858 .png"))));
		btnChangePass.setSize(new Dimension(50, 20));
		b_ChangePassword_button.add(Box.createHorizontalStrut(50));
		b_ChangePassword_button.add(
				btnCancel = new JButton("Hủy", new ImageIcon(getClass().getResource("../ima/if_Delete_1493279.png"))));
		btnCancel.setMaximumSize(new Dimension(150, 60));
		b_ChangePassword_button.add(Box.createHorizontalStrut(20));
		b_ChangePassword.add(Box.createVerticalStrut(10));
		b_ChangePassword.add(b_ChangePassword_mkc);
		b_ChangePassword.add(Box.createVerticalStrut(10));
		b_ChangePassword.add(b_ChangePassword_mkm);
		b_ChangePassword.add(Box.createVerticalStrut(10));
		b_ChangePassword.add(b_ChangePassword_nlmkm);
		b_ChangePassword.add(Box.createVerticalStrut(10));
		b_ChangePassword.add(b_ChangePassword_button);
		b_ChangePassword.add(Box.createVerticalStrut(300));

		tbpqlcn.addTab("Xem Thông tin", b_BasicInfo);
		tbpqlcn.addTab("Thay đổi mật khẩu", b_ChangePassword);
		tbpqlcn.setFont(new Font("Times new Roman", Font.PLAIN, 20));
		/////////////////////////////////
		/**
		 * CÃ¡i nÃ y lÃ  quáº£n lÃ½ cÃ¡c tab
		 */
		/////////////////////////////////
		tbp = new JTabbedPane();
		tbp.addTab("Thông tin cá nhân", tbpqlcn);
		tbp.addTab("Quản lý bán hàng", bqlbn);
		tbp.setFont(new Font("Times new Roman", Font.PLAIN, 20));
		tbp.setTabPlacement(JTabbedPane.LEFT);
		/////////////////////////////////
		/**
		 *
		 */
		/////////////////////////////////
		/*
		 * txtmanv.setEditable(false); txttennv.setEditable(false);
		 * txthonv.setEditable(false); txtngaysinhnv.setEditable(false);
		 * txtdiachinv.setEditable(false); txtsdtnv.setEditable(false);
		 */

		// btnLuu.setEnabled(false);
//		table.setDefaultEditor(Object.class, null);
//		table.setEnabled(false);

		// cmbTimbs.setEnabled(false);
		btnChangePass.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ChangePass();
				} catch (RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		hienthithongtin();
		bt.add(tbp);
		add(bt);
		setLocationRelativeTo(null);
		setVisible(true);
		LoadAllProductToComboBox();

		btnSearch.addActionListener(this);
		btnAdd.addActionListener(this);
		btnRemove.addActionListener(this);
		btnPrintInvoice.addActionListener(this);

		cbbProductName.addActionListener(this);
		tableProduct.addMouseListener(this);
	}

	public void LoadAllProductToComboBox() throws AccessException, RemoteException, NotBoundException {
		ArrayList<Good> listGoods = (ArrayList<Good>) callService.getGoodDAO().findAll();

		for (int i = 0; i < listGoods.size(); i++) {
			String getName = listGoods.get(i).getName();
			modelcbbProductName.addElement(getName);
		}

	}

	public void LoadProductByKey(String key) throws AccessException, RemoteException, NotBoundException {
		ArrayList<Good> listGoods = (ArrayList<Good>) callService.getGoodDAO().findByProductKey(key);
		if (listGoods.size() > 0) {
			modelcbbProductName.removeAllElements();

			for (int i = 0; i < listGoods.size(); i++) {
				String getName = listGoods.get(i).getName();
				modelcbbProductName.addElement(getName);
			}
		} else {
			JOptionPane.showConfirmDialog(this, "440");
		}

	}

	public void LoadProductByName(String name) throws AccessException, RemoteException, NotBoundException {
		Good g = callService.getGoodDAO().findByProductName(name);

		if (g != null) {
			txtProductId.setText(g.getId());
			txtQuantity.setText(g.getQuantity().toString());
			txtPrice.setText(g.getPrice().toString());
		}
	}

	public void BuyProduct() {

		String name = cbbProductName.getSelectedItem().toString();
		String id = txtProductId.getText();
		double price = Double.parseDouble(txtPrice.getText());
		int quantity = Integer.parseInt(txtQuantity.getText());
		double total = price * quantity;

		String rowData[] = { id, name, Integer.toString(quantity), Double.toString(price), Double.toString(total) };
		sumInvoice += total;
		lblSumInvoice.setText(Double.toString(sumInvoice));

		modelProduct.addRow(rowData);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();

		if (obj.equals(btnAdd)) {
			BuyProduct();
		} else if (obj.equals(btnRemove)) {
			int row = tableProduct.getSelectedRow();
			if (row >= 0) {
				modelProduct.removeRow(row);
			}
		} else if (obj.equals(btnPrintInvoice)) {
			PrintInvoiceActions();
		} else if (obj.equals(btnSearch)) {
			try {
				SearchActions();
			} catch (RemoteException | NotBoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (obj.equals(cbbProductName)) {
			if (cbbProductName.getItemCount() > 0) {
				String name = cbbProductName.getSelectedItem().toString();

				try {
					LoadProductByName(name);
				} catch (RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tableProduct.getSelectedRow();
		if (row >= 0) {

			txtProductId.setText(tableProduct.getValueAt(row, 0).toString());

			modelcbbProductName.removeAllElements();
			modelcbbProductName.setSelectedItem(tableProduct.getValueAt(row, 1).toString());
			// .setText(tableProduct.getValueAt(row, 1).toString());
			txtQuantity.setText(tableProduct.getValueAt(row, 2).toString());
			txtPrice.setText(tableProduct.getValueAt(row, 3).toString());

			/*
			 * if (table.getValueAt(row, 3).equals("NS")) { comboBox.setSelectedIndex(1); }
			 * else { comboBox.setSelectedIndex(0); }
			 */
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

	public void hienthithongtin() throws AccessException, RemoteException, NotBoundException {
		System.out.println(account.getId());
		System.out.println("user :" + account.getUsername());
		if (callService == null)
			System.out.println("Không thể đăng nhập Error XKFME");
		else {
			System.out.println("xx");
			Employee em = callService.getEmployeeDAO().getEmp(account.getId());
			txtId.setText(em.getId());
			txtFullName.setText(em.getFullName());
			txtDateOfBirth.setText(em.getBirthdate().toString());
			txtAddress.setText(em.getAddress());
		}

	}

	private void XoaTrangDoiMatKhau() {
		txtOldPass.setText("");
		txtConfirmPass.setText("");
		txtNewPass.setText("");
	}

	public boolean ChangePass() throws AccessException, RemoteException, NotBoundException {
		String mkc = "", mkm = "", nlmkm = "";
		char a[], b[], c[];
		a = ((JPasswordField) txtOldPass).getPassword();
		b = ((JPasswordField) txtConfirmPass).getPassword();
		c = ((JPasswordField) txtNewPass).getPassword();
		for (int i = 0; i < a.length; i++) {
			mkc = mkc + a[i];
		}
		for (int i = 0; i < b.length; i++) {
			mkm = mkm + b[i];
		}
		for (int i = 0; i < c.length; i++) {
			nlmkm = nlmkm + c[i];
		}
		if (!callService.getAccountDAO().checkPassOld(account.getPassword(), mkc)) {
			JOptionPane.showMessageDialog(new JFrame(), "Mật khẩu cũ không khớp");
			XoaTrangDoiMatKhau();
			return false;
		} else if (!mkm.equals(nlmkm)) {
			JOptionPane.showMessageDialog(new JFrame(), "Nhập lại mật khẩu mới không khớp");
			XoaTrangDoiMatKhau();
			return false;
		} else if (callService.getAccountDAO().changePass(account, nlmkm)) {
			JOptionPane.showMessageDialog(new JFrame(), "Đổi mật khẩu không thành công");
			XoaTrangDoiMatKhau();
			return false;
		}
		JOptionPane.showMessageDialog(new JFrame(), "Đổi mật khẩu thành công");
		new FrmMain();
		dispose();
		return true;
	}

	public void PrintInvoiceActions() {
		Invoice inVoice = new Invoice();
		Employee em = new Employee();
		Account ac = new Account();
		ac.setUsername("Luan");
		em.setAccount(ac);

		inVoice.setInvoiceDate(new Date());

		try {
			callService.getInvoiceDAO().save(inVoice);
		} catch (RemoteException | NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		InvoiceDetails inVoiceDetails = new InvoiceDetails();

		List<Good> listGoods = new ArrayList<>();

		for (int i = 0; i < modelProduct.getRowCount(); i++) {
			String id = modelProduct.getValueAt(i, 0).toString();
			String name = modelProduct.getValueAt(i, 1).toString();
			String quantity = (String) modelProduct.getValueAt(i, 2);
			String price = (String) modelProduct.getValueAt(i, 3);

			Good g = new Good();
			g.setId(id);
			g.setName(name);
			g.setQuantity(Integer.parseInt(quantity));
			// g.setPrice(Double.parseDouble(price));

			listGoods.add(g);
		}

		inVoiceDetails.setGoods(listGoods);
		inVoiceDetails.setInvoice(inVoice);

		try {
			callService.getInvoiceDetailsDAO().save(inVoiceDetails);
		} catch (RemoteException | NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println("DONE PRINT INVOICE");
	}

	public void SearchActions() throws AccessException, RemoteException, NotBoundException {
		if (txtSearch.getText() != null) {
			String key = txtSearch.getText();

			System.out.println("key: " + key);

			LoadProductByKey(key);
		}
	}

}