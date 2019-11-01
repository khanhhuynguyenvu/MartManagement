package group.jpa.ogm.app.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import group.jpa.ogm.app.controller.client.ClientController;
import group.jpa.ogm.app.entities.Account;
import group.jpa.ogm.app.entities.Employee;
import group.jpa.ogm.app.repository.employee.EmployeeDAO;

public class FrmLogin extends JFrame implements ActionListener {

	JCheckBox chkAdmin;
	JPasswordField pwfPass;
	JTextField txtUserName;
	JButton btnConfirm;
	JComboBox<String> cmbloaitk;
	

	public FrmLogin() throws RemoteException {
		super("Đăng nhập");
	
		setSize(450, 350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// ----------------------------------------------------------
		JPanel pNorth = new JPanel();
		pNorth.setBackground(new Color(255, 255, 255));

		JLabel lblTitle;
		pNorth.add(lblTitle = new JLabel("Login to App"));
		lblTitle.setFont(new Font("serif", Font.BOLD, 26));

		add(pNorth, BorderLayout.NORTH);

		// ----------------------------------------------------------
		JPanel pCenter = new JPanel();
		pCenter.setBackground(new Color(255, 255, 255));

		JSeparator sprHorizontal2;
		pCenter.add(sprHorizontal2 = new JSeparator());
		sprHorizontal2.setPreferredSize(new Dimension(450, 1));

		sprHorizontal2.setOpaque(true);
		sprHorizontal2.setBackground(Color.GRAY);

		JLabel lblUsername, lblPassword;

		Box b = Box.createVerticalBox();
		b.add(Box.createVerticalStrut(50));
		Box b1, b2, b3;

		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(20));
		b1.add(lblUsername = new JLabel("USERNAME"));
		b1.add(Box.createHorizontalStrut(20));
		b1.add(txtUserName = new JTextField());

		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(40));
		b2.add(lblPassword = new JLabel("PASSWORD"));
		b2.add(Box.createHorizontalStrut(20));
		b2.add(pwfPass = new JPasswordField());

		b.add(b3 = Box.createHorizontalBox());
		b3.add(Box.createHorizontalStrut(5));
		String s[] = { "Nhân Viên","Quản Lý" };
		cmbloaitk = new JComboBox<>(s);
		b3.add(new JLabel("Loại tài khoản"));
		b3.add(Box.createHorizontalStrut(10));
		b3.add(cmbloaitk);
		
		
		
		b3.add(btnConfirm = new JButton("LOGIN"));

		btnConfirm.setFocusPainted(false);
		// btnConfirm.setBorder(new RoundedBorder(5));

		lblPassword.setPreferredSize(lblUsername.getPreferredSize());

		pCenter.add(b);
		add(pCenter, BorderLayout.CENTER);

		btnConfirm.addActionListener(this);

	}

	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();

		if (obj.equals(btnConfirm)) {
			try {
				LoginAction();
			} catch (AccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NotBoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	private void LoginAction() throws AccessException, RemoteException, NotBoundException {
		String userName = txtUserName.getText();
		String passWord = new String(pwfPass.getPassword());
		
		ClientController callSerivce;
		callSerivce = new ClientController("192.168.31.109",9999);
		
		Account ac = callSerivce.getAccountDAO().findByUserName(userName);
		System.out.println(ac.getType());
		System.out.println(ac.getId());
		
		
		String loai = cmbloaitk.getItemAt(cmbloaitk.getSelectedIndex());
		if (loai.equalsIgnoreCase("Nhân Viên") ) {
			
			if(ac.getPassword().equals(passWord) && ac.getType()==1) {

				new Gui_Employee(ac).setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(new JFrame(), "Đăng nhập không thành công");	
			}	
		}else if(loai.equalsIgnoreCase("Quản lý")) {			
			if(ac.getPassword().equals(passWord) && ac.getType()!=1 ) {
				new Gui_Manager(ac).setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(new JFrame(), "Đăng nhập không thành công");
			}
		}
		

		
		
		
		

	}

}
