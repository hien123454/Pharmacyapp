package swing.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;

import swing.project.dao.NhanVienDAO;
import swing.project.dao.impl.NhanVienDAOImpl;
import swing.project.entity.NhanVien;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Color;

public class DangNhap extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnDN;
	private JTextField txtTK;
	private JPasswordField txtMK;
	private static TrangChu frmtrangchu = new TrangChu();
	private NhanVienDAO nv_dao = new NhanVienDAOImpl();
	private final JLabel lblNewLabel_4 = new JLabel("");

	public DangNhap() {
		getContentPane().setBackground(SystemColor.activeCaption);

		setBounds(100, 100, 1132, 673);
		setTitle("Quản lý nhà thuốc");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		ImageIcon imgex = new ImageIcon(this.getClass().getResource("/dtr.png"));
		lblNewLabel_4.setBounds(45, 68, 618, 489);
		getContentPane().add(lblNewLabel_4);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 153));
		panel.setBounds(663, 31, 455, 577);
		getContentPane().add(panel);
		panel.setBackground(SystemColor.activeCaption);
		panel.setLayout(null);

		txtTK = new JTextField();
		txtTK.setBounds(135, 236, 290, 46);
		panel.add(txtTK);
		txtTK.setFont(new Font("Arial", Font.PLAIN, 20));
		txtTK.setColumns(10);

		txtMK = new JPasswordField();
		txtMK.setBounds(135, 330, 290, 46);
		panel.add(txtMK);
		txtMK.setFont(new Font("Arial", Font.PLAIN, 20));

		btnDN = new JButton("Đăng nhập");
		btnDN.setToolTipText("Chọn sau khi nhập tài khoản và mật khẩu");
		btnDN.setBackground(SystemColor.window);
		btnDN.setBounds(261, 413, 164, 38);
		ImageIcon img211 = new ImageIcon(this.getClass().getResource("/in.png"));
		btnDN.setIcon(img211);
		panel.add(btnDN);
		btnDN.setFont(new Font("Arial", Font.PLAIN, 16));
		getRootPane().setDefaultButton(btnDN);

		JLabel lblNewLabel = new JLabel("Đăng nhập");
		lblNewLabel.setBounds(160, 106, 223, 44);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 43));

		JLabel lblNewLabel_2 = new JLabel("Mật khẩu");
		lblNewLabel_2.setBounds(10, 330, 115, 44);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 24));

		JLabel lblNewLabel_1 = new JLabel("Tài khoản");
		lblNewLabel_1.setBounds(10, 239, 115, 38);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 24));

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(28, 47, 122, 151);
		lblNewLabel_3.setIcon(imgex);
		panel.add(lblNewLabel_3);
		ImageIcon imgex2 = new ImageIcon(this.getClass().getResource("/log.jpg"));
		lblNewLabel_4.setIcon(imgex2);
		btnDN.addActionListener(this);

	}

	public static void main(String[] args) {
		new DangNhap().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btnDN || o == txtMK || o == txtTK) {
			char chMK[] = txtMK.getPassword();
			String strTK = txtTK.getText();
			String strMK = new String(chMK);
			java.util.List<NhanVien> list = nv_dao.getNhanVien();
			for (NhanVien nv : list) {
				if (strTK.trim().equals(nv.getTaiKhoan().toString())
						&& strMK.trim().equals(nv.getMatKhau().toString())) {
					setVisible(false);
					xoaHet();
					frmtrangchu.setVisible(true);
					break;
				}
			}
			if (frmtrangchu.isVisible() == false) {
				JOptionPane.showMessageDialog(this, "Nhập lại mật khẩu", "Sai mật khẩu!", JOptionPane.ERROR_MESSAGE);
				txtMK.selectAll();
				txtMK.requestFocus();
			}
		} else
			System.exit(0);
	}

	public void xoaHet() {
		frmtrangchu.dispose();
	}

}
