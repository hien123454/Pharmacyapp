package swing.project;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Component;

import javax.swing.Box;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JComboBox;

import swing.project.dao.ChiTietHoaDonDAO;
import swing.project.dao.DuocPhamDAO;
import swing.project.dao.HoaDonDAO;
import swing.project.dao.KhachHangDAO;
import swing.project.dao.impl.ChiTietHoaDonDAOImpl;
import swing.project.dao.impl.DuocPhamDAOImpl;
import swing.project.dao.impl.HoaDonDAOImpl;
import swing.project.dao.impl.KhachHangDAOImpl;
import swing.project.entity.ChiTietHoaDon;
import swing.project.entity.DuocPham;
import swing.project.entity.HoaDon;
import swing.project.entity.KhachHang;
import swing.project.entity.NhanVien;

import javax.swing.BoxLayout;

public class QuanLyBanHang extends JFrame implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaHD;
	private JTextField txtNgay;
	private JComboBox<String> cbMaNV;
	private JButton btnQL;
	private JButton btnBH;
	private JButton btnTK;
	private JButton btnDX;
	LocalDate localdate = LocalDate.now();
	DuocPhamDAOImpl duocPhamDAOz = new DuocPhamDAOImpl();
	private static DangNhap frmlg = new DangNhap();
	private static QuanLyThuoc frmql = new QuanLyThuoc();
	private static QuanLyThongKe frmtk = new QuanLyThongKe();
	private static ThongTinNhanVien frmtt = new ThongTinNhanVien();
	private JTextField txtTenKH;
	private JTextField txtTongTien;
	private JTextField txtSDT;
	private JTextField txtTenNV;
	private JButton btnHDMoi;
	private JTextField txtTimThuoc;
	private JTextField txtSoLuong;
	private JTextField txtTimTheoTenKH;
	private JTextField txtTimHDTheoMa;
	private JButton btnXoaThuoc;
	private JButton btnThem;
	private JButton btnXuatHD;
	private JButton btnTimHDTheoMa;
	private JButton btnTimThuoc_HD;
	private JButton btnTimTheoTenKH;
	private DefaultTableModel dftableTimThuoc;
	private JTable tableTimThuoc;
	private DefaultTableModel dftableThuocDaChon;
	private JTable tableThuocDaChon;
	private DefaultTableModel dfTableHD;
	private JTable tableHD;
	private int soluongdp = 0;
	private long thanhTien = 0;
	private String tenNV = "";
	private HoaDonDAO hd_dao = new HoaDonDAOImpl();
	private ChiTietHoaDonDAO cthd_dao = new ChiTietHoaDonDAOImpl();
	private DuocPhamDAO dp_dao = new DuocPhamDAOImpl();
	private KhachHangDAO kh_dao = new KhachHangDAOImpl();
	private JComboBox<String> cbGhiChu;
	private JButton btnTT;
	private JButton btnHDSD;

	public QuanLyBanHang() {
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
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnHDSD = new JButton("Hướng dẫn sử dụng");
		btnHDSD.setToolTipText("Chức năng quản lý thống kê");
		btnHDSD.setFont(new Font("Times New Roman", Font.BOLD, 18));
		ImageIcon imgtk1111 = new ImageIcon(this.getClass().getResource("/hd.png"));
		btnHDSD.setIcon(imgtk1111);
		btnHDSD.setBackground(Color.WHITE);
		panel_3.add(btnHDSD);

		Component verticalStrut_7_1 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_7_1);

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

		btnDX = new JButton("Đăng xuất");
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
		panel_11.setBounds(0, 0, 1301, 433);
		panel_10.add(panel_11);
		panel_11.setLayout(null);

		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(255, 250, 240));
		panel_12.setBounds(0, 0, 1333, 44);
		panel_11.add(panel_12);
		panel_12.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblTit = new JLabel("QUẢN LÝ BÁN HÀNG");
		lblTit.setForeground(new Color(0, 0, 128));
		lblTit.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblTit.setBackground(new Color(0, 0, 128));
		panel_12.add(lblTit);

		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(255, 255, 204));

		panel_13.setBounds(10, 54, 1300, 379);
		panel_11.add(panel_13);
		panel_13.setLayout(null);

		txtMaHD = new JTextField();
		txtMaHD.setEditable(false);
		txtMaHD.setBackground(new Color(255, 255, 255));
		txtMaHD.setColumns(10);
		txtMaHD.setBounds(1028, 10, 212, 29);
		panel_13.add(txtMaHD);

		cbMaNV = new JComboBox<String>();
		cbMaNV.addItem(null);
		cbMaNV.addItem("18050901");
		cbMaNV.addItem("18050902");
		cbMaNV.addItem("18050903");
		cbMaNV.setBackground(Color.WHITE);
		cbMaNV.setBounds(1028, 243, 212, 28);
		panel_13.add(cbMaNV);

		JLabel lblMaHoaDon = new JLabel("Mã hóa đơn:");
		lblMaHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblMaHoaDon.setBounds(926, 9, 85, 29);
		panel_13.add(lblMaHoaDon);

		txtNgay = new JTextField();
		txtNgay.setEditable(false);
		txtNgay.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtNgay.setBackground(Color.WHITE);
		txtNgay.setColumns(10);
		txtNgay.setBounds(1028, 49, 212, 29);
		panel_13.add(txtNgay);

		txtTenKH = new JTextField();
		txtTenKH.setToolTipText("Bắt đầu bằng kí tự viết hoa");
		txtTenKH.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtTenKH.setColumns(10);
		txtTenKH.setBackground(Color.WHITE);
		txtTenKH.setBounds(1028, 88, 212, 29);
		panel_13.add(txtTenKH);

		txtTongTien = new JTextField();
		txtTongTien.setEditable(false);
		txtTongTien.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtTongTien.setColumns(10);
		txtTongTien.setBackground(Color.WHITE);
		txtTongTien.setBounds(1028, 127, 212, 29);
		panel_13.add(txtTongTien);

		txtSDT = new JTextField();
		txtSDT.setToolTipText("Gồm 10-11 số");
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtSDT.setColumns(10);
		txtSDT.setBackground(Color.WHITE);
		txtSDT.setBounds(1028, 166, 212, 29);
		panel_13.add(txtSDT);

		txtTenNV = new JTextField();
		txtTenNV.setEditable(false);
		txtTenNV.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtTenNV.setColumns(10);
		txtTenNV.setBackground(Color.WHITE);
		txtTenNV.setBounds(1028, 282, 212, 29);
		panel_13.add(txtTenNV);

		JLabel lblTenKH = new JLabel("Tên Khách hàng:");
		lblTenKH.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTenKH.setBounds(926, 87, 99, 29);
		panel_13.add(lblTenKH);

		JLabel lblTongTien = new JLabel("Tổng tiền:");
		lblTongTien.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTongTien.setBounds(926, 126, 65, 29);
		panel_13.add(lblTongTien);

		JLabel lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSDT.setBounds(926, 165, 85, 29);
		panel_13.add(lblSDT);

		JLabel lblGhichu = new JLabel("Ghi chú:");
		lblGhichu.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGhichu.setBounds(926, 204, 59, 29);
		panel_13.add(lblGhichu);

		JLabel lblMaNV = new JLabel("Mã nhân viên:");
		lblMaNV.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblMaNV.setBounds(926, 243, 85, 29);
		panel_13.add(lblMaNV);

		JLabel lblTenNV = new JLabel("Tên nhân viên:");
		lblTenNV.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTenNV.setBounds(926, 281, 92, 29);
		panel_13.add(lblTenNV);

		btnHDMoi = new JButton("Hóa đơn mới");
		btnHDMoi.setToolTipText("Chọn để thêm hóa đơn mới");
		btnHDMoi.setBackground(SystemColor.window);
		btnHDMoi.setBounds(936, 321, 158, 41);
		ImageIcon imghdm = new ImageIcon(this.getClass().getResource("/hdm.png"));
		btnHDMoi.setIcon(imghdm);
		panel_13.add(btnHDMoi);

		btnXuatHD = new JButton("Xuất hóa đơn");
		btnXuatHD.setToolTipText("Chọn để thêm một hóa đơn khi đã nhập đầy đủ thông tin");
		btnXuatHD.setBackground(SystemColor.window);
		btnXuatHD.setEnabled(false);
		btnXuatHD.setBounds(1117, 321, 158, 41);
		ImageIcon img211 = new ImageIcon(this.getClass().getResource("/themhd.png"));
		btnXuatHD.setIcon(img211);

		panel_13.add(btnXuatHD);

		JPanel panel_14 = new JPanel();
		panel_14.setBounds(0, 0, 540, 311);

		JScrollPane scrollPane = new JScrollPane();
		panel_14.add(scrollPane);
		String[] tieude2 = { "Tên dược phẩm", "Đơn vị", "Số lượng", "Giá bán" };
		dftableTimThuoc = new DefaultTableModel(tieude2, 0);
		tableTimThuoc = new JTable(dftableTimThuoc);
		docthuoc();
		scrollPane.setViewportView(tableTimThuoc);
		panel_13.add(panel_14);
		panel_14.setLayout(new BoxLayout(panel_14, BoxLayout.X_AXIS));
		JPanel panel_16 = new JPanel();
		panel_16.setBounds(550, 0, 366, 311);
		panel_16.setLayout(new BoxLayout(panel_16, BoxLayout.X_AXIS));
		JScrollPane scrollPane2 = new JScrollPane();
		panel_16.add(scrollPane2);
		dftableThuocDaChon = new DefaultTableModel(tieude2, 0);
		tableThuocDaChon = new JTable(dftableThuocDaChon);

		scrollPane2.setViewportView(tableThuocDaChon);
		panel_13.add(panel_16);
		JLabel lblTimThuoc = new JLabel("Tìm theo tên:");
		lblTimThuoc.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTimThuoc.setBounds(10, 326, 78, 29);
		panel_13.add(lblTimThuoc);

		txtTimThuoc = new JTextField();
		txtTimThuoc.setColumns(10);
		txtTimThuoc.setBounds(98, 327, 102, 29);
		panel_13.add(txtTimThuoc);

		JLabel lblSoLuong = new JLabel("Số lượng:");
		lblSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSoLuong.setBounds(267, 326, 59, 29);
		panel_13.add(lblSoLuong);

		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(336, 327, 92, 29);
		panel_13.add(txtSoLuong);

		btnThem = new JButton("Thêm");
		btnThem.setToolTipText("Thêm thuốc vào hóa đơn mới khi đã nhập số lượng");
		btnThem.setEnabled(false);
		btnThem.setBackground(Color.WHITE);
		btnThem.setBounds(438, 321, 102, 41);
		btnThem.setIcon(img211);

		panel_13.add(btnThem);

		btnTimThuoc_HD = new JButton("");
		btnTimThuoc_HD.setToolTipText("Tìm tên thuốc cần nhập vào hóa đơn mới");
		btnTimThuoc_HD.setBackground(Color.WHITE);
		btnTimThuoc_HD.setBounds(217, 321, 40, 41);
		ImageIcon img1 = new ImageIcon(this.getClass().getResource("/srch.png"));
		btnTimThuoc_HD.setIcon(img1);
		panel_13.add(btnTimThuoc_HD);

		btnXoaThuoc = new JButton("Xóa");
		btnXoaThuoc.setToolTipText("Xóa thuốc trong hóa đơn");
		btnXoaThuoc.setEnabled(false);
		btnXoaThuoc.setBackground(Color.WHITE);
		btnXoaThuoc.setBounds(687, 321, 97, 41);
		ImageIcon img2111 = new ImageIcon(this.getClass().getResource("/rmv.png"));
		btnXoaThuoc.setIcon(img2111);

		panel_13.add(btnXoaThuoc);

		JLabel lblNgyLp = new JLabel("Ngày lập:");
		lblNgyLp.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNgyLp.setBounds(926, 48, 85, 29);
		panel_13.add(lblNgyLp);

		cbGhiChu = new JComboBox<String>();
		cbGhiChu.addItem(null);
		cbGhiChu.addItem("Bán kê đơn");
		cbGhiChu.addItem("Bán không kê đơn");
		cbGhiChu.setBackground(Color.WHITE);
		cbGhiChu.setBounds(1028, 205, 212, 28);
		panel_13.add(cbGhiChu);

		JPanel panel_15 = new JPanel();
		panel_15.setBackground(new Color(255, 255, 204));
		panel_15.setBounds(10, 458, 1291, 386);

		panel_10.add(panel_15);
		panel_15.setLayout(null);

		JPanel panel_18 = new JPanel();
		panel_18.setToolTipText("Hiển thị thông tin hóa đơn ứng với mục hóa đơn đã chọn");
		panel_18.setBounds(0, 54, 1292, 332);

		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setToolTipText("Hiển thị thông tin hóa đơn ứng với mục hóa đơn đã chọn");
		panel_18.add(scrollPane3);
		String[] tieuDe1 = { "Mã hóa đơn", "Ngày lập hóa đơn", "Mã nhân viên", "Tên nhân viên", "Tên Khách hàng",
				"Số điện thoại", "Số loại dược phẩm", "Tổng tiền", "Ghi chú" };
		dfTableHD = new DefaultTableModel(tieuDe1, 0);
		tableHD = new JTable(dfTableHD);
		DocDanhSachHoaDonVaoBang();
		scrollPane3.setViewportView(tableHD);

		panel_15.add(panel_18);
		panel_18.setLayout(new BoxLayout(panel_18, BoxLayout.X_AXIS));
		JLabel lblTmTheoTn = new JLabel("Tìm theo tên khách hàng:");
		lblTmTheoTn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTmTheoTn.setBounds(127, 9, 152, 35);
		panel_15.add(lblTmTheoTn);
		JLabel lblTimTheoTenKH = new JLabel("Tìm theo mã hóa đơn:");
		lblTimTheoTenKH.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTimTheoTenKH.setBounds(759, 9, 129, 35);
		panel_15.add(lblTimTheoTenKH);
		txtTimTheoTenKH = new JTextField();
		txtTimTheoTenKH.setColumns(10);
		txtTimTheoTenKH.setBounds(289, 10, 212, 35);
		panel_15.add(txtTimTheoTenKH);
		txtTimHDTheoMa = new JTextField();
		txtTimHDTheoMa.setColumns(10);
		txtTimHDTheoMa.setBounds(898, 10, 212, 35);
		panel_15.add(txtTimHDTheoMa);
		btnTimTheoTenKH = new JButton("");
		btnTimTheoTenKH.setToolTipText("Tìm hóa đơn theo tên khách hàng");
		btnTimTheoTenKH.setBackground(Color.WHITE);
		btnTimTheoTenKH.setBounds(512, 10, 46, 35);
		ImageIcon img12 = new ImageIcon(this.getClass().getResource("/srch.png"));
		btnTimTheoTenKH.setIcon(img12);
		panel_15.add(btnTimTheoTenKH);
		btnTimHDTheoMa = new JButton("");
		btnTimHDTheoMa.setToolTipText("Tìm hóa đơn theo mã");
		btnTimHDTheoMa.setBackground(Color.WHITE);
		btnTimHDTheoMa.setBounds(1120, 9, 46, 35);
		ImageIcon img123 = new ImageIcon(this.getClass().getResource("/srch.png"));
		btnTimHDTheoMa.setIcon(img123);
		panel_15.add(btnTimHDTheoMa);
		btnQL.addActionListener(this);
		btnBH.addActionListener(this);
		btnTK.addActionListener(this);
		btnDX.addActionListener(this);
		btnHDMoi.addActionListener(this);
		btnThem.addActionListener(this);
		btnTimHDTheoMa.addActionListener(this);
		btnTimTheoTenKH.addActionListener(this);
		btnXoaThuoc.addActionListener(this);
		btnXuatHD.addActionListener(this);
		cbMaNV.addActionListener(this);
		btnTimThuoc_HD.addActionListener(this);
		tableHD.addMouseListener(this);
		tableThuocDaChon.addMouseListener(this);
		btnTT.addActionListener(this);
		btnHDSD.addActionListener(this);
	}

	public static void main(String[] args) {
		new QuanLyBanHang().setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		btnXoaThuoc.setEnabled(false);
		btnThem.setEnabled(false);
		btnXuatHD.setEnabled(false);
		int row = tableHD.getSelectedRow();
		txtMaHD.setEditable(false);
		txtMaHD.setText(dfTableHD.getValueAt(row, 0).toString());
		txtNgay.setText(dfTableHD.getValueAt(row, 1).toString());
		cbMaNV.setSelectedItem(dfTableHD.getValueAt(row, 2).toString());
		txtTenNV.setText(dfTableHD.getValueAt(row, 3).toString());
		txtTenKH.setText(dfTableHD.getValueAt(row, 4).toString());
		txtTongTien.setText(dfTableHD.getValueAt(row, 7).toString());
		txtSDT.setText(dfTableHD.getValueAt(row, 5).toString());
		cbGhiChu.setSelectedItem(dfTableHD.getValueAt(row, 8).toString());

		reset(dftableThuocDaChon);
		long mahd = Long.parseLong(dfTableHD.getValueAt(row, 0).toString());
		java.util.List<ChiTietHoaDon> list = cthd_dao.getDanhSachChiTietHoaDonTheoMaHoaDon((long) mahd);

		for (ChiTietHoaDon ctthd : list) {
			dftableThuocDaChon.addRow(new Object[] { ctthd.getDuocPham().getTenDuocPham(),
					ctthd.getDuocPham().getDonViTinh(), ctthd.getSoLuong(), ctthd.getDuocPham().getGiaBan() });
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			setSoLuongDP();
			btnXoaThuoc.setEnabled(true);
		} else if (o.equals(btnXoaThuoc)) {
			xoaThuocDaChon();
		} else if (o.equals(btnXuatHD)) {
			themHD();
			JOptionPane.showMessageDialog(this, "Thêm thành công!");
		} else if (o.equals(btnHDMoi)) {
			XoaThuoc();
			docthuoc();
			XoaHetDuLieuTrenTableModel();
			DocDanhSachHoaDonVaoBang();
			java.util.List<HoaDon> list = hd_dao.getDanhSachHoaDon();
			int r = tableHD.getSelectedRowCount();
			Random rand = new Random();
			int d = rand.nextInt(1600);
			for (@SuppressWarnings("unused")
			HoaDon hd : list) {
				if (d != Integer.parseInt(dfTableHD.getValueAt(r, 0).toString())) {
					d += 1;
					String st = Integer.toString(d);
					txtMaHD.setText(st);
				}
			}
			txtTenKH.setText("");
			txtNgay.setText("");
			txtTenNV.setText("");
			txtTongTien.setText("");
			txtSDT.setText("");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-LLLL-dd");
			txtNgay.setText(localdate.format(formatter));
			txtMaHD.requestFocus();
			btnXoaThuoc.setEnabled(true);
			txtMaHD.setEditable(true);
			btnThem.setEnabled(true);
			btnXuatHD.setEnabled(true);
			reset(dftableThuocDaChon);
			thanhTien = 0;
			soluongdp = 0;
		} else if (o.equals(btnTimHDTheoMa)) {
			timTheoMaHoaDon();
		} else if (o.equals(btnTimTheoTenKH)) {
			timTheoTenKH();
		} else if (o.equals(cbMaNV)) {
			setTenNV(txtTenNV);
		} else if (o.equals(btnTimThuoc_HD)) {
			String madp = txtTimThuoc.getText();
			DocDanhSachDuocPhamTheoTenVaoBang(madp);
			btnThem.setEnabled(true);
		} else if (o.equals(btnQL)) {
			setVisible(false);
			frmql.setVisible(true);
		} else if (o.equals(btnDX)) {
			setVisible(false);
			frmlg.setVisible(true);
		} else if (o.equals(btnTK)) {
			setVisible(false);
			frmtk.setVisible(true);

		} else if (o.equals(btnTT)) {
			frmtt.setVisible(true);
		} else if (o.equals(btnHDSD)) {
			String fileName = "C:\\STD\\Eclipse\\\\HDSD\\\\HDSD2.chm";
			String[] commands = {"cmd", "/c", fileName};
			try {
			Runtime.getRuntime().exec(commands);
			} catch (Exception ex) {
			ex.printStackTrace();
			}
		}

	}

	public void setTenNV(JTextField txtten) {
		tenNV = "";
		if (cbMaNV.getSelectedItem().toString().equalsIgnoreCase("18050901")) {
			tenNV = "Vũ";
		} else if (cbMaNV.getSelectedItem().toString().equalsIgnoreCase("18050902")) {
			tenNV = "Sơn";
		} else if (cbMaNV.getSelectedItem().toString().equalsIgnoreCase("18050903")) {
			tenNV = "Nhật";
		}
		txtten.setText(tenNV);
	}

	public void DocDanhSachHoaDonVaoBang() {
		java.util.List<HoaDon> list = hd_dao.getDanhSachHoaDon();
		for (HoaDon hd : list) {
			dfTableHD.addRow(new Object[] { hd.getMaHoaDon(), hd.getNgayLapHoaDon(), hd.getNhanVien().getMaNhanVien(),
					hd.getNhanVien().getTenNhanVien(), hd.getKhachHang().getTenKhachHang(),
					hd.getKhachHang().getSoDienThoai(), hd.getSoLuongDuocPham(), hd.getTongTien(), hd.getGhiChu() });
		}
	}

	public void XoaHetDuLieuTrenTableModel() {
		DefaultTableModel dm = (DefaultTableModel) tableHD.getModel();
		dm.getDataVector().removeAllElements();
	}

	public void XoaThuoc() {
		DefaultTableModel dm = (DefaultTableModel) tableTimThuoc.getModel();
		dm.getDataVector().removeAllElements();
	}

	public void docthuoc() {
		List<DuocPham> l = dp_dao.timCHH();
		if (l != null && l.size() > 0) {
			for (DuocPham dpp : l) {
				dftableTimThuoc.addRow(
						new Object[] { dpp.getTenDuocPham(), dpp.getDonViTinh(), dpp.getSoLuong(), dpp.getGiaBan() });
			}
		}
	}

	public void reset(DefaultTableModel dfTable) {
		dfTable.setRowCount(0);
	}

	public void DocDanhSachDuocPhamTheoTenVaoBang(String tenDuocPham) {
		int i = 0;
		if (tenDuocPham != null && tenDuocPham.trim().length() > 0) {
			try {
				java.util.List<DuocPham> list = dp_dao.timDuocPhamTen(tenDuocPham);
				reset(dftableTimThuoc);
				for (DuocPham dp : list) {

					dftableTimThuoc.addRow(
							new Object[] { dp.getTenDuocPham(), dp.getDonViTinh(), dp.getSoLuong(), dp.getGiaBan() });
					i += 1;

				}
				if (i == 0) {

					JOptionPane.showMessageDialog(null, " KHÔNG TÌM THẤY ");
					return;
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, " DỮ KIỆU KHÔNG HỢP LỆ ");
				txtTimThuoc.selectAll();
				txtTimThuoc.requestFocus();
			}
		}
	}

	public void setSoLuongDP() {
		int soluong = Integer.parseInt(txtSoLuong.getText().toString());
		int row = tableTimThuoc.getSelectedRow();
		int thuoc_da_chon = tableTimThuoc.getSelectedColumnCount();
		int soluongkho = Integer.parseInt(dftableTimThuoc.getValueAt(row, 2).toString());
		long giaban = 0;
		String tendp = dftableTimThuoc.getValueAt(row, 0).toString();
		LocalDate ngayHH = null;
		java.util.List<DuocPham> list = dp_dao.getDanhSachDuocPham();
		if (txtSoLuong.getText() != null && thuoc_da_chon > 0) {
			for (DuocPham dp : list) {
				if (dp.getTenDuocPham().equalsIgnoreCase(tendp)) {
					ngayHH = dp.getNgayHetHan();
					giaban = (long) dp.getGiaBan();
				}
			}
			if ((isHetHan(ngayHH))) {
				if (isDuSoLuong(soluong, soluongkho)) {
					if (kiemtraThem(dftableTimThuoc.getValueAt(row, 0).toString())) {
						thanhTien += ((long) soluong) * giaban;
						txtTongTien.setText(String.valueOf(thanhTien));
						dftableThuocDaChon.addRow(new Object[] { dftableTimThuoc.getValueAt(row, 0).toString(),
								dftableTimThuoc.getValueAt(row, 1).toString(), soluong,
								dftableTimThuoc.getValueAt(row, 3).toString() });
						soluongdp += 1;
					} else {
						JOptionPane.showMessageDialog(null, " Dược phẩm đã thêm rồi ");
						return;
					}

				} else {
					JOptionPane.showMessageDialog(null, " Dược phẩm không đủ số lượng ");
					return;
				}

			} else {
				JOptionPane.showMessageDialog(null, " Dược phẩm hết đã hết hạn sử dụng ");
				return;
			}

		} else {
			JOptionPane.showMessageDialog(null, " Chọn dược phẩm và số lượng dược phẩm thêm vào hóa đơn ");
		}

	}

	public boolean isHetHan(LocalDate hsd) {
		int i = localdate.compareTo(hsd);
		if (i < 0)
			return true;
		return false;
	}

	public boolean isDuSoLuong(int slchon, int slkho) {
		if (slchon > slkho)
			return false;
		return true;
	}

	public void xoaThuocDaChon() {
		int row = tableThuocDaChon.getSelectedRow();
		long giaban = 0;
		int soluong = Integer.parseInt(dftableThuocDaChon.getValueAt(row, 2).toString());
		String tendp = dftableThuocDaChon.getValueAt(row, 0).toString();
		java.util.List<DuocPham> list = dp_dao.getDanhSachDuocPham();
		for (DuocPham dp : list) {
			if (dp.getTenDuocPham().equalsIgnoreCase(tendp)) {
				giaban = (long) dp.getGiaBan();
			}
		}
		thanhTien -= giaban * soluong;
		soluongdp -= 1;
		txtTongTien.setText(String.valueOf(thanhTien));
		dftableThuocDaChon.removeRow(row);
	}

	public void timTheoMaHoaDon() {
		String str_mahd = txtTimHDTheoMa.getText();
		if (str_mahd != null && str_mahd.trim().length() > 0) {
			try {

				long maHoaDon = Long.parseLong(str_mahd);
				HoaDon hd = hd_dao.timHoaDonTheoMa(maHoaDon);
				if (hd != null) {
					reset(dfTableHD);
					dfTableHD.addRow(new Object[] { hd.getMaHoaDon(), hd.getNgayLapHoaDon(),
							hd.getNhanVien().getMaNhanVien(), hd.getNhanVien().getTenNhanVien(),
							hd.getKhachHang().getTenKhachHang(), hd.getKhachHang().getSoDienThoai(),
							hd.getSoLuongDuocPham(), hd.getTongTien(), hd.getGhiChu() });

				} else {
					JOptionPane.showMessageDialog(null, " KHÔNG TÌM THẤY ");
					return;
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, " DỮ KIỆU KHÔNG HỢP LỆ ");
				txtTimHDTheoMa.selectAll();
				txtTimHDTheoMa.requestFocus();
			}
		}

	}

	public void timTheoTenKH() {
		String tenkh = txtTimTheoTenKH.getText();
		java.util.List<HoaDon> list = hd_dao.getDanhSachHoaDonTheoTenKhachHang(tenkh);

		if (tenkh != null && tenkh.trim().length() > 0) {
			try {

				if (list.size() > 0) {
					for (HoaDon hd : list) {
						reset(dfTableHD);
						dfTableHD.addRow(new Object[] { hd.getMaHoaDon(), hd.getNgayLapHoaDon(),
								hd.getNhanVien().getMaNhanVien(), hd.getNhanVien().getTenNhanVien(),
								hd.getKhachHang().getTenKhachHang(), hd.getKhachHang().getSoDienThoai(),
								hd.getSoLuongDuocPham(), hd.getTongTien(), hd.getGhiChu() });
					}

				} else {
					JOptionPane.showMessageDialog(null, " KHÔNG TÌM THẤY ");
					return;
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, " DỮ KIỆU KHÔNG HỢP LỆ ");
				txtTimTheoTenKH.selectAll();
				txtTimTheoTenKH.requestFocus();
			}
		}
	}

	public void themHD() {
		long mahd = Long.parseLong(txtMaHD.getText());
		Random rand = new Random();
		long makh = rand.nextInt(1600);
		String tenkh = txtTenKH.getText();
		String sdt = txtSDT.getText();
		String ghichu = cbGhiChu.getSelectedItem().toString();
		long manv = Long.parseLong(cbMaNV.getSelectedItem().toString());

		String tendp = "";
		int soluongmua = 0;
		java.util.List<DuocPham> list = dp_dao.getDanhSachDuocPham();

		if (valid(tenkh, sdt, tenNV, ghichu)) {
			if (soluongdp > 0) {
				if (kiemtraMaHoaDon(mahd)) {
					NhanVien nvthem = new NhanVien(manv, tenNV, "BRVT", "0358984752");
					KhachHang hkthem = new KhachHang(makh, tenkh, sdt);
					kh_dao.themKH(hkthem);
					HoaDon hdthem = new HoaDon(mahd, localdate, soluongdp, thanhTien, ghichu, hkthem, nvthem);
					for (int i = 0; i < soluongdp; i++) {
						tendp = dftableThuocDaChon.getValueAt(i, 0).toString();
						soluongmua = Integer.parseInt(dftableThuocDaChon.getValueAt(i, 2).toString());
						DuocPham duocpham = null;
						DuocPham duocphamsua = null;
						for (DuocPham dp : list) {
							if (dp.getTenDuocPham().equalsIgnoreCase(tendp)) {
								duocphamsua = new DuocPham(dp.getMaDuocPham(), dp.getTenDuocPham(),
										dp.getSoLuong() - soluongmua, dp.getGiaNhap(), dp.getGiaBan(),
										dp.getDonViTinh(), dp.getNgayNhap(), dp.getNgaySanXuat(), dp.getNgayHetHan(),
										dp.getMoTa(), dp.getLoaiDuocPham(), dp.getNhaCungCap());
								duocpham = new DuocPham(dp.getMaDuocPham(), dp.getTenDuocPham(), soluongmua,
										dp.getGiaNhap(), dp.getGiaBan(), dp.getDonViTinh(), dp.getNgayNhap(),
										dp.getNgaySanXuat(), dp.getNgayHetHan(), dp.getMoTa(), dp.getLoaiDuocPham(),
										dp.getNhaCungCap());
							}
						}

						ChiTietHoaDon cthd = new ChiTietHoaDon(soluongmua, hdthem, duocpham);
						XoaThuoc();
						dp_dao.suaDuocPham(duocphamsua);
						docthuoc();
						cthd_dao.themChiTietHoaDon(cthd);
					}
					hd_dao.themHoaDon(hdthem);
					dfTableHD.addRow(new Object[] { hdthem.getMaHoaDon(), hdthem.getNgayLapHoaDon(),
							hdthem.getNhanVien().getMaNhanVien(), hdthem.getNhanVien().getTenNhanVien(),
							hdthem.getKhachHang().getTenKhachHang(), hdthem.getKhachHang().getSoDienThoai(),
							hdthem.getSoLuongDuocPham(), hdthem.getTongTien(), hdthem.getGhiChu() });
				} else {
					JOptionPane.showMessageDialog(null, "Mã hóa đơn trùng");
					return;

				}

			} else {
				JOptionPane.showMessageDialog(null, "Chưa thêm dược phẩm");
				return;
			}
		}

	}

	public boolean kiemtraThem(String ten) {
		for (int i = 0; i < soluongdp; i++) {
			if (ten.equalsIgnoreCase(dftableThuocDaChon.getValueAt(i, 0).toString())) {
				return false;
			}
		}
		return true;
	}

	public boolean valid(String tenkh, String sdt, String tenNV, String ghichu) {

		if (!(tenkh.length() > 0 && tenkh.matches("[A-Z][a-z ]*"))) {
			txtTenKH.requestFocus();
			txtTenKH.selectAll();
			JOptionPane.showMessageDialog(null, " Tên khách bắt đầu bằng kí tự viết hoa ");
			return false;
		}

		if (!(sdt.length() > 0 && sdt.matches("[\\d]{10,11}"))) {
			txtSDT.requestFocus();
			txtSDT.selectAll();
			JOptionPane.showMessageDialog(null, " Số điện thoại không hợp lệ ");
			return false;
		}

		if (tenNV.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, " Chọn nhân viên ");
			return false;
		}
		return true;
	}

	public boolean kiemtraMaHoaDon(long mahd) {
		java.util.List<HoaDon> list = hd_dao.getDanhSachHoaDon();
		for (HoaDon hd : list) {
			if (hd.getMaHoaDon() == mahd) {
				return false;
			}
		}
		return true;
	}
}
