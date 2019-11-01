package group.jpa.ogm.app.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;

import com.arjuna.ats.internal.jdbc.drivers.modifiers.list;

import group.jpa.ogm.app.controller.client.ClientController;
import group.jpa.ogm.app.entities.Category;
import group.jpa.ogm.app.entities.Good;

public class TreeProducts extends JPanel {

	public JTree tree;
	DefaultMutableTreeNode root;
	static ClientController callService;

	public TreeProducts() throws RemoteException, NotBoundException {
		super(new GridLayout(1, 0));
		root = new DefaultMutableTreeNode("Kho");

		callService = new ClientController("172.16.0.101", 9999);

		tree = new JTree(root);

		
		LoadGoodsToTree();

		JScrollPane scrollPane = new JScrollPane(tree);
		add(scrollPane, BorderLayout.NORTH);
	}

	public void LoadGoodsToTree() throws AccessException, RemoteException, NotBoundException {
		List<Category> listCategories = callService.getCategoryDAO().findAll();

		if (listCategories.size() > 0) {
			for (int i = 0; i < listCategories.size(); i++) {
				
				DefaultMutableTreeNode category = new DefaultMutableTreeNode(listCategories.get(i).getName());
				root.add(category);
				
				
				List<Good> listGoods = (List<Good>) callService.getGoodDAO().findAllGoodsByCategoryName(listCategories.get(i).getId());
				if(listGoods.size() > 0) {
					for(int j = 0; j < listGoods.size(); j++) {
						category.add(new DefaultMutableTreeNode(listGoods.get(i).getName()));
					}
				}
				
				
			}
		} else {
			System.out.println("NO");
		}

	}
	/*
	 * public static void main(String[] args) { SwingUtilities.invokeLater(new
	 * Runnable() {
	 * 
	 * @Override public void run() { try { new TreeProducts().setVisible(true);; }
	 * catch (RemoteException | NotBoundException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); } } }); }
	 */
}
