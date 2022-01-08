package swing.project;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Component;
import javax.swing.Box;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TrangChu extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static DangNhap frmlg = new DangNhap();
	private static QuanLyThuoc frmql = new QuanLyThuoc();
	private static QuanLyBanHang frmbh = new QuanLyBanHang();
	private static QuanLyThongKe frmtk = new QuanLyThongKe();
	private static ThongTinNhanVien frmtt = new ThongTinNhanVien();

	private JButton btnQL;
	private JButton btnBH;
	private JButton btnTK;
	private JButton btnDX;
	private JButton btnTT;
	private JButton btnHDSD;

	public TrangChu() {
		getContentPane().setBackground(new Color(255, 255, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 2000, 1500);
		setLocationRelativeTo(null);
		setResizable(false);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 153));
		getContentPane().add(panel, BorderLayout.WEST);
		Box verticalBox = Box.createVerticalBox();
		panel.add(verticalBox);

		Component verticalStrut = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		verticalBox.add(panel_1);

		ImageIcon img2 = new ImageIcon(this.getClass().getResource("/ava.jpg"));
		Image dd = img2.getImage();
		Image ddd = dd.getScaledInstance(196, 177, java.awt.Image.SCALE_SMOOTH);
		img2 = new ImageIcon(ddd);
		JLabel lblAva = new JLabel("");
		lblAva.setBackground(UIManager.getColor("Button.foreground"));
		lblAva.setIcon(img2);
		lblAva.setBounds(56, 10, 196, 196);
		panel_1.add(lblAva);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 153));
		verticalBox.add(panel_2);

		btnTT = new JButton("Xem thông tin");
		btnTT.setToolTipText("Xem thông tin nhân viên");
		btnTT.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel_2.add(btnTT);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_2);

		Component verticalStrut_5 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_5);

		Component verticalStrut_4 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_4);

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_3);

		JPanel panel_7 = new JPanel();
		verticalBox.add(panel_7);
		panel_7.setLayout(new GridLayout(0, 1, 0, 0));

		btnQL = new JButton("Quản lý thuốc          ");
		btnQL.setToolTipText("Chức năng quản lý thuốc");
		btnQL.setBackground(SystemColor.window);
		btnQL.setFont(new Font("Times New Roman", Font.BOLD, 18));
		ImageIcon imgql = new ImageIcon(this.getClass().getResource("/ql.png"));
		btnQL.setIcon(imgql);
		panel_7.add(btnQL);

		Component verticalStrut_11 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_11);

		JPanel panel_8 = new JPanel();
		verticalBox.add(panel_8);
		panel_8.setLayout(new GridLayout(0, 1, 0, 0));

		btnBH = new JButton("Quản lý bán hàng   ");
		btnBH.setToolTipText("Chức năng quản lý bán hàng");
		btnBH.setBackground(SystemColor.window);
		btnBH.setFont(new Font("Times New Roman", Font.BOLD, 18));
		ImageIcon imgbh = new ImageIcon(this.getClass().getResource("/bh.png"));
		btnBH.setIcon(imgbh);
		panel_8.add(btnBH);

		Component verticalStrut_10 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_10);

		JPanel panel_9 = new JPanel();
		verticalBox.add(panel_9);
		panel_9.setLayout(new GridLayout(0, 1, 0, 0));

		btnTK = new JButton("Quản lý thống kê    ");
		btnTK.setToolTipText("Chức năng quản lý thống kê");
		btnTK.setBackground(SystemColor.window);
		btnTK.setFont(new Font("Times New Roman", Font.BOLD, 18));
		ImageIcon imgtk = new ImageIcon(this.getClass().getResource("/tk.png"));
		btnTK.setIcon(imgtk);
		panel_9.add(btnTK);

		Component verticalStrut_6 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_6);
		
		JPanel panel_3 = new JPanel();
		verticalBox.add(panel_3);
		
		btnHDSD = new JButton("Hướng dẫn sử dụng");
		btnHDSD.setToolTipText("Chức năng quản lý thống kê");
		btnHDSD.setFont(new Font("Times New Roman", Font.BOLD, 18));
		ImageIcon imgtk1111 = new ImageIcon(this.getClass().getResource("/hd.png"));
		btnHDSD.setIcon(imgtk1111);
		btnHDSD.setBackground(Color.WHITE);
		panel_3.add(btnHDSD);
		
		Component verticalStrut_6_1 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_6_1);

		JPanel panel_13 = new JPanel();
		verticalBox.add(panel_13);
		panel_13.setLayout(new GridLayout(1, 0, 0, 0));

		Component verticalStrut_7 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_7);

		Component verticalStrut_8 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_8);

		Component verticalStrut_9 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_9);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 153));
		verticalBox.add(panel_6);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_6.add(horizontalStrut_2);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel_6.add(horizontalStrut_1);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel_6.add(horizontalStrut);

		btnDX = new JButton("\u0110\u0103ng Xu\u1EA5t");
		btnDX.setToolTipText("Trở về trang đăng nhập");
		btnDX.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnDX.setBackground(Color.WHITE);
		ImageIcon imgex = new ImageIcon(this.getClass().getResource("/ex.png"));
		btnDX.setIcon(imgex);
		panel_6.add(btnDX);

		JPanel panel_10 = new JPanel();
		panel_10.setBackground(SystemColor.activeCaptionBorder);
		getContentPane().add(panel_10, BorderLayout.CENTER);
		panel_10.setLayout(null);

		JPanel panel_11 = new JPanel();
		panel_11.setBackground(SystemColor.activeCaptionBorder);
		panel_11.setBounds(0, 121, 1311, 723);
		panel_10.add(panel_11);
		panel_11.setLayout(null);

		JLabel lblhome = new JLabel("");
		lblhome.setBounds(0, 0, 1301, 736);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/home.jpg"));
		lblhome.setIcon(img);

		panel_11.add(lblhome);

		JPanel panel_12 = new JPanel();
		panel_12.setBounds(0, 0, 1333, 123);
		panel_10.add(panel_12);
		panel_12.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel = new JLabel("HỆ THỐNG QUẢN LÝ THÔNG TIN QUẦY THUỐC");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setBackground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		panel_12.add(lblNewLabel);

		JLabel lblCaMtBnh = new JLabel("CỦA MỘT BỆNH VIỆN");
		lblCaMtBnh.setForeground(new Color(0, 0, 128));
		lblCaMtBnh.setFont(new Font("Times New Roman", Font.BOLD, 40));
		panel_12.add(lblCaMtBnh);

		btnQL.addActionListener(this);
		btnBH.addActionListener(this);
		btnTK.addActionListener(this);
		btnDX.addActionListener(this);
		btnTT.addActionListener(this);
		btnHDSD.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnDX)) {
			setVisible(false);
			frmlg.setVisible(true);
		}
		if (o.equals(btnQL)) {
			setVisible(false);
			frmql.setVisible(true);
		}
		if (o.equals(btnBH)) {
			setVisible(false);
			frmbh.setVisible(true);
		}
		if (o.equals(btnTK)) {
			setVisible(false);
			frmtk.setVisible(true);
		}
		if (o.equals(btnTT)) {
			frmtt.setVisible(true);
		}
		if (o.equals(btnHDSD)) {
			String fileName = "C:\\STD\\Eclipse\\\\HDSD\\\\HDSD2.chm";
			String[] commands = {"cmd", "/c", fileName};
			try {
			Runtime.getRuntime().exec(commands);
			} catch (Exception ex) {
			ex.printStackTrace();
			}
		}

	}
}
