package swing.project;

import javax.swing.JFrame;
import javax.swing.JPanel;

import swing.project.dao.NhanVienDAO;
import swing.project.dao.impl.NhanVienDAOImpl;
import swing.project.entity.NhanVien;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ThongTinNhanVien extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnDoiMK;
	private NhanVienDAO nv_dao = new NhanVienDAOImpl();
	private JPasswordField lblMK;
	private JTextField lblTK;
	private JTextField lblTen;
	private JTextField lblMa;
	private JTextField lblCL;
	private JButton btnCN;
	private JTextField lblTien;
	private JTextField lblSDT;
	private JTextField lblDC;

	public ThongTinNhanVien() {
		setSize(927, 833);
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.window);
		panel.setBounds(212, 10, 500, 785);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel.setBounds(181, 0, 133, 124);
		ImageIcon imgex = new ImageIcon(this.getClass().getResource("/dtr.png"));
		lblNewLabel.setIcon(imgex);
		panel.add(lblNewLabel);

		btnDoiMK = new JButton("Đổi mật khẩu");
		btnDoiMK.setToolTipText("Chọn để sửa mật khẩu\r\n");
		btnDoiMK.setBackground(SystemColor.control);
		btnDoiMK.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnDoiMK.setBounds(31, 706, 191, 41);
		ImageIcon img2111 = new ImageIcon(this.getClass().getResource("/rf.png"));
		btnDoiMK.setIcon(img2111);
		panel.add(btnDoiMK);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(31, 202, 434, 58);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Tên nhân viên:\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 10, 120, 41);
		panel_1.add(lblNewLabel_1);

		lblTen = new JTextField();
		lblTen.setEditable(false);
		lblTen.setColumns(10);
		lblTen.setBounds(125, 10, 299, 41);
		panel_1.add(lblTen);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(31, 270, 434, 58);
		panel.add(panel_1_1);

		JLabel lblNewLabel_1_1 = new JLabel("Tài khoản:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(10, 10, 105, 41);
		panel_1_1.add(lblNewLabel_1_1);

		lblTK = new JTextField();
		lblTK.setEditable(false);
		lblTK.setBounds(125, 10, 299, 41);
		panel_1_1.add(lblTK);
		lblTK.setColumns(10);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBounds(31, 338, 434, 58);
		panel.add(panel_1_2);

		JLabel lblNewLabel_1_2 = new JLabel("Mật khẩu:\r\n\r\n");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(10, 10, 105, 41);
		panel_1_2.add(lblNewLabel_1_2);

		lblMK = new JPasswordField();
		lblMK.setEditable(false);
		lblMK.setBackground(new Color(240, 240, 240));
		lblMK.setBounds(125, 10, 299, 41);
		panel_1_2.add(lblMK);

		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setBounds(31, 406, 434, 58);
		panel.add(panel_1_3);

		JLabel lblNewLabel_1_3 = new JLabel("Ca làm:\r\n");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(10, 10, 105, 41);
		panel_1_3.add(lblNewLabel_1_3);

		lblCL = new JTextField();
		lblCL.setEditable(false);
		lblCL.setColumns(10);
		lblCL.setBounds(125, 10, 299, 41);
		panel_1_3.add(lblCL);

		JPanel panel_1_4 = new JPanel();
		panel_1_4.setLayout(null);
		panel_1_4.setBounds(31, 134, 434, 58);
		panel.add(panel_1_4);

		JLabel lblNewLabel_1_4 = new JLabel("Mã nhân viên:\r\n");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(10, 10, 120, 41);
		panel_1_4.add(lblNewLabel_1_4);

		lblMa = new JTextField();
		lblMa.setEditable(false);
		lblMa.setColumns(10);
		lblMa.setBounds(125, 10, 299, 41);
		panel_1_4.add(lblMa);

		btnCN = new JButton("Cập nhật mật khẩu");
		btnCN.setToolTipText("Chọn sau khi sửa mật khẩu xong");
		btnCN.setEnabled(false);
		btnCN.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnCN.setBackground(SystemColor.menu);
		btnCN.setBounds(232, 706, 233, 41);
		ImageIcon img211 = new ImageIcon(this.getClass().getResource("/sua.png"));
		btnCN.setIcon(img211);
		panel.add(btnCN);
		
		JPanel panel_1_3_1 = new JPanel();
		panel_1_3_1.setLayout(null);
		panel_1_3_1.setBounds(31, 474, 434, 58);
		panel.add(panel_1_3_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Tiền lương:\r\n");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3_1.setBounds(10, 10, 105, 41);
		panel_1_3_1.add(lblNewLabel_1_3_1);
		
		lblTien = new JTextField();
		lblTien.setEditable(false);
		lblTien.setColumns(10);
		lblTien.setBounds(125, 10, 299, 41);
		panel_1_3_1.add(lblTien);
		
		JPanel panel_1_3_2 = new JPanel();
		panel_1_3_2.setLayout(null);
		panel_1_3_2.setBounds(31, 542, 434, 58);
		panel.add(panel_1_3_2);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("SĐT:");
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3_2.setBounds(10, 10, 105, 41);
		panel_1_3_2.add(lblNewLabel_1_3_2);
		
		lblSDT = new JTextField();
		lblSDT.setEditable(false);
		lblSDT.setColumns(10);
		lblSDT.setBounds(125, 10, 299, 41);
		panel_1_3_2.add(lblSDT);
		
		JPanel panel_1_3_3 = new JPanel();
		panel_1_3_3.setLayout(null);
		panel_1_3_3.setBounds(31, 610, 434, 58);
		panel.add(panel_1_3_3);
		
		JLabel lblNewLabel_1_3_3 = new JLabel("Địa chỉ\r\n");
		lblNewLabel_1_3_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3_3.setBounds(10, 10, 105, 41);
		panel_1_3_3.add(lblNewLabel_1_3_3);
		
		lblDC = new JTextField();
		lblDC.setEditable(false);
		lblDC.setColumns(10);
		lblDC.setBounds(125, 10, 299, 41);
		panel_1_3_3.add(lblDC);
		btnCN.addActionListener(this);
		btnDoiMK.addActionListener(this);
		doc();
	}

	public void doc() {
		java.util.List<NhanVien> list = nv_dao.getNhanVien();
		for (NhanVien nv : list) {
			lblMa.setText(nv.getMaNhanVien().toString());
			lblTen.setText(nv.getTenNhanVien().toString());
			lblTK.setText(nv.getTaiKhoan().toString());
			lblMK.setText(nv.getMatKhau().toString());
			lblCL.setText(Integer.toString(nv.getCaLam()));
			lblTien.setText(Double.toString(nv.getTienLuong()));
			lblSDT.setText(nv.getSoDienThoai().toString());
			lblDC.setText(nv.getDiaChi().toString());
			break;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btnDoiMK) {
			lblMK.setEditable(true);
			btnDoiMK.setEnabled(false);
			btnCN.setEnabled(true);
		}
		if (o == btnCN) {
			char chMK[] = lblMK.getPassword();
			long ma = Long.parseLong(lblCL.getText().toString());
			String ten = lblTen.getText();
			String tk = lblTK.getText();
			String mk = new String(chMK);
			int ca = Integer.parseInt(lblCL.getText().toString());
			double tien = Double.parseDouble(lblTien.getText().toString());
			String sdt = lblSDT.getText();
			String dc = lblDC.getText();
			NhanVien nv = new NhanVien(ma, ten, ca, tien, sdt, dc, tk, mk);
			nv_dao.xoaNV(ma);
			nv_dao.suaNV(nv);
			JOptionPane.showMessageDialog(this, "Cập nhật thành công. ");
			doc();
			lblMK.setEditable(false);
			btnDoiMK.setEnabled(true);
			btnCN.setEnabled(false);
		}

	}
}
