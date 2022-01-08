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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JComboBox;

import com.toedter.calendar.JDateChooser;

import swing.project.dao.impl.DuocPhamDAOImpl;
import swing.project.entity.DuocPham;
import swing.project.entity.DuocPham2;
import swing.project.entity.LoaiDuocPham;
import swing.project.entity.NhaCungCap;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

public class QuanLyThuoc extends JFrame implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaThuoc;
	private JTextField txtTenThuoc;
	private JTextField txtGiaNhap;
	private JTextField txtGiaBan;
	private JDateChooser dateChooserNhap;
	private JDateChooser dateChooserSX;
	private JDateChooser dateChooserHH;
	private JTextField txtTenNhaCungCap;
	private DefaultTableModel dftable;
	private JTable table;
	private JTextField txtTimTheoMa;
	private JTextField txtTimTheoTen;
	private JComboBox<String> cbDonVi;
	private JComboBox<String> cbloaiDuocPham;
	private JComboBox<String> txtMaNhaCungCap;
	private ButtonGroup btg;
	private JButton btnQL;
	private JButton btnBH;
	private JButton btnTK;
	private JButton btnDX;
	private JButton btnTimTheoMa;
	private JButton btnTimTheoTen;
	private JButton btnRF;
	private JRadioButton rdoHetHan;
	private JRadioButton rdoChuaHH;
	private JButton btnThemThuoc;
	private JButton btnXoaThuoc;
	private JButton btnSuaThuoc;
	private JButton btnXoaTrang;
	private JSpinner txtSoLuong;
	private JTextArea txtMoTa;
	LocalDate localdate = LocalDate.now();
	DuocPhamDAOImpl duocPhamDAOz = new DuocPhamDAOImpl();
	private JButton btnTT;
	private JButton btnHDSD;
	private static DangNhap frmlg = new DangNhap();
	private static QuanLyBanHang frmbh = new QuanLyBanHang();
	private static QuanLyThongKe frmtk = new QuanLyThongKe();
	private static ThongTinNhanVien frmtt = new ThongTinNhanVien();
	private JTextField cbXuatXu;

	public QuanLyThuoc() {
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
		panel_11.setBounds(0, 0, 1311, 419);
		panel_10.add(panel_11);
		panel_11.setLayout(null);

		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(255, 250, 240));
		panel_12.setBounds(0, 0, 1333, 44);
		panel_11.add(panel_12);
		panel_12.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblTit = new JLabel("QUẢN LÝ THÔNG TIN THUỐC");
		lblTit.setForeground(new Color(0, 0, 128));
		lblTit.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblTit.setBackground(new Color(0, 0, 128));
		panel_12.add(lblTit);

		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(255, 255, 204));

		panel_13.setBounds(10, 54, 1126, 365);
		panel_11.add(panel_13);
		panel_13.setLayout(null);

		JLabel lblNewLabel = new JLabel("Mã thuốc:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(56, 112, 67, 29);
		panel_13.add(lblNewLabel);

		txtMaThuoc = new JTextField();
		txtMaThuoc.setEditable(false);
		txtMaThuoc.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtMaThuoc.setBackground(Color.WHITE);

		txtMaThuoc.setBounds(188, 113, 175, 29);
		panel_13.add(txtMaThuoc);
		txtMaThuoc.setColumns(10);

		JLabel lblTenThuoc = new JLabel("Tên thuốc");
		lblTenThuoc.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTenThuoc.setBounds(419, 112, 67, 29);
		panel_13.add(lblTenThuoc);

		txtTenThuoc = new JTextField();
		txtTenThuoc.setToolTipText("Không được để trống");
		txtTenThuoc.setColumns(10);
		txtTenThuoc.setBounds(542, 113, 212, 29);
		panel_13.add(txtTenThuoc);

		JLabel lblSoLuong = new JLabel("Số lượng:");
		lblSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSoLuong.setBounds(56, 151, 67, 29);
		panel_13.add(lblSoLuong);

		txtSoLuong = new JSpinner();
		txtSoLuong.setBounds(188, 152, 67, 26);
		panel_13.add(txtSoLuong);

		JLabel lblDonVi = new JLabel("Đơn vị tính:");
		lblDonVi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDonVi.setBounds(325, 152, 75, 29);
		panel_13.add(lblDonVi);

		cbDonVi = new JComboBox<String>();
		cbDonVi.addItem(null);
		cbDonVi.addItem("Hộp");
		cbDonVi.addItem("Vĩ");
		cbDonVi.addItem("Viên");
		cbDonVi.setBackground(UIManager.getColor("Button.highlight"));
		cbDonVi.setBounds(419, 153, 142, 26);
		panel_13.add(cbDonVi);

		JLabel lblGiaNhap = new JLabel("Giá nhập");
		lblGiaNhap.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGiaNhap.setBounds(645, 152, 67, 29);
		panel_13.add(lblGiaNhap);

		txtGiaNhap = new JTextField();
		txtGiaNhap.setToolTipText("Giá nhập phải nhỏ hơn giá bán");
		txtGiaNhap.setColumns(10);
		txtGiaNhap.setBounds(712, 152, 129, 29);
		panel_13.add(txtGiaNhap);

		JLabel lblGiBn = new JLabel("Giá bán");
		lblGiBn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGiBn.setBounds(920, 151, 52, 29);
		panel_13.add(lblGiBn);

		txtGiaBan = new JTextField();
		txtGiaBan.setToolTipText("Giá bán phải lớn hơn giá nhập");
		txtGiaBan.setColumns(10);
		txtGiaBan.setBounds(982, 152, 129, 29);
		panel_13.add(txtGiaBan);

		JLabel lblNgayNhap = new JLabel("Ngày nhập:");
		lblNgayNhap.setToolTipText("Ngày nhập phải sau ngày sản xuất và trước ngày hết hạn");
		lblNgayNhap.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNgayNhap.setBounds(56, 190, 75, 29);
		panel_13.add(lblNgayNhap);

		dateChooserNhap = new JDateChooser();
		dateChooserNhap.getCalendarButton().setToolTipText("Ngày nhập phải sau ngày sản xuất và trước ngày hết hạn");
		dateChooserNhap.setBounds(188, 188, 212, 29);
		dateChooserNhap.setDateFormatString("yyyy-MM-dd");
		panel_13.add(dateChooserNhap);

		JLabel lblNgaySX = new JLabel("Ngày sản xuất:");
		lblNgaySX.setToolTipText("Ngày sản xuất phải trước ngày nhập và ngày hết hạn");
		lblNgaySX.setHorizontalAlignment(SwingConstants.LEFT);
		lblNgaySX.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNgaySX.setBounds(419, 189, 94, 29);
		panel_13.add(lblNgaySX);

		dateChooserSX = new JDateChooser();
		dateChooserSX.getCalendarButton().setToolTipText("Ngày sản xuất phải trước ngày nhập và ngày hết hạn");
		dateChooserSX.setBounds(542, 189, 212, 29);
		dateChooserSX.setDateFormatString("yyyy-MM-dd");
		panel_13.add(dateChooserSX);

		dateChooserHH = new JDateChooser();
		dateChooserHH.getCalendarButton().setToolTipText("Ngày hết hạn phải sau ngày sản xuất và ngày nhập");
		dateChooserHH.setBounds(899, 190, 212, 29);
		dateChooserHH.setDateFormatString("yyyy-MM-dd");
		panel_13.add(dateChooserHH);

		JLabel lblHanSD = new JLabel("Ngày hết hạn:");
		lblHanSD.setToolTipText("Ngày hết hạn phải sau ngày sản xuất và ngày nhập");
		lblHanSD.setHorizontalAlignment(SwingConstants.LEFT);
		lblHanSD.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblHanSD.setBounds(783, 191, 86, 29);
		panel_13.add(lblHanSD);

		JLabel lbltenLoai = new JLabel("Loại:");
		lbltenLoai.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbltenLoai.setBounds(783, 112, 38, 29);
		panel_13.add(lbltenLoai);

		cbloaiDuocPham = new JComboBox<String>();
		cbloaiDuocPham.addItem(null);
		cbloaiDuocPham.addItem("da liễu");
		cbloaiDuocPham.addItem("kháng sinh");
		cbloaiDuocPham.addItem("an thần ");
		cbloaiDuocPham.addItem("giảm đau");
		cbloaiDuocPham.addItem("tránh thai");
		cbloaiDuocPham.setBackground(Color.WHITE);
		cbloaiDuocPham.setBounds(899, 114, 212, 26);
		panel_13.add(cbloaiDuocPham);

		JLabel lblmaNCC = new JLabel("Mã nhà cung cấp:");
		lblmaNCC.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblmaNCC.setBounds(56, 229, 108, 29);
		panel_13.add(lblmaNCC);

		JLabel lblTenNCC = new JLabel("Tên nhà cung cấp:");
		lblTenNCC.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTenNCC.setBounds(419, 230, 113, 29);
		panel_13.add(lblTenNCC);

		JLabel lblXutX = new JLabel("Xuất xứ:");
		lblXutX.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblXutX.setBounds(783, 230, 67, 29);
		panel_13.add(lblXutX);

		txtMaNhaCungCap = new JComboBox<String>();
		txtMaNhaCungCap.addItem(null);
		txtMaNhaCungCap.addItem("1");
		txtMaNhaCungCap.addItem("2");
		txtMaNhaCungCap.addItem("3");
		txtMaNhaCungCap.addItem("4");
		txtMaNhaCungCap.setBackground(Color.WHITE);
		txtMaNhaCungCap.setBounds(188, 232, 212, 26);
		panel_13.add(txtMaNhaCungCap);

		JLabel lblMT = new JLabel("Mô tả:");
		lblMT.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblMT.setBounds(56, 268, 67, 29);
		panel_13.add(lblMT);

		txtTenNhaCungCap = new JTextField();
		txtTenNhaCungCap.setEditable(false);
		txtTenNhaCungCap.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtTenNhaCungCap.setBackground(Color.WHITE);
		txtTenNhaCungCap.setColumns(10);
		txtTenNhaCungCap.setBounds(542, 228, 212, 29);
		panel_13.add(txtTenNhaCungCap);

		txtMoTa = new JTextArea();
		txtMoTa.setColumns(40);
		txtMoTa.setRows(8);
		txtMoTa.setBounds(188, 269, 929, 70);
		panel_13.add(txtMoTa);

		JPanel panel_16 = new JPanel();
		panel_16.setBounds(0, 0, 1172, 62);
		panel_13.add(panel_16);
		panel_16.setLayout(null);

		JLabel lbltimTheoma = new JLabel("Tìm theo mã:");
		lbltimTheoma.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbltimTheoma.setBounds(99, 15, 78, 29);
		panel_16.add(lbltimTheoma);

		txtTimTheoMa = new JTextField();
		txtTimTheoMa.setColumns(10);
		txtTimTheoMa.setBounds(187, 16, 212, 29);
		panel_16.add(txtTimTheoMa);

		txtTimTheoTen = new JTextField();
		txtTimTheoTen.setColumns(10);
		txtTimTheoTen.setBounds(627, 16, 212, 29);
		panel_16.add(txtTimTheoTen);

		JLabel lblTmTheoTn = new JLabel("Tìm theo tên:");
		lblTmTheoTn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTmTheoTn.setBounds(539, 15, 78, 29);
		panel_16.add(lblTmTheoTn);

		btnTimTheoMa = new JButton("");
		btnTimTheoMa.setToolTipText("Tìm thuốc theo mã");
		btnTimTheoMa.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnTimTheoMa.setBackground(Color.WHITE);
		btnTimTheoMa.setBounds(409, 9, 46, 43);
		ImageIcon img1 = new ImageIcon(this.getClass().getResource("/srch.png"));
		btnTimTheoMa.setIcon(img1);
		panel_16.add(btnTimTheoMa);

		btnTimTheoTen = new JButton("");
		btnTimTheoTen.setToolTipText("Tìm thuốc theo tên");
		btnTimTheoTen.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnTimTheoTen.setBackground(Color.WHITE);
		btnTimTheoTen.setBounds(849, 9, 46, 43);
		ImageIcon img21 = new ImageIcon(this.getClass().getResource("/srch.png"));
		btnTimTheoTen.setIcon(img21);
		panel_16.add(btnTimTheoTen);

		btnRF = new JButton("Refresh");
		btnRF.setToolTipText("Làm mới lại danh sách thuốc ban đầu");
		btnRF.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnRF.setBackground(Color.WHITE);
		btnRF.setBounds(952, 9, 115, 43);
		ImageIcon imgrf = new ImageIcon(this.getClass().getResource("/rf.png"));
		btnRF.setIcon(imgrf);
		panel_16.add(btnRF);

		rdoHetHan = new JRadioButton("Thuốc Hết hạn");
		rdoHetHan.setFont(new Font("Times New Roman", Font.BOLD, 16));
		rdoHetHan.setBackground(new Color(255, 255, 204));
		rdoHetHan.setBounds(302, 68, 165, 21);
		panel_13.add(rdoHetHan);

		rdoChuaHH = new JRadioButton("Thuốc chưa hết hạn");
		rdoChuaHH.setFont(new Font("Times New Roman", Font.BOLD, 16));
		rdoChuaHH.setBackground(new Color(255, 255, 204));
		rdoChuaHH.setBounds(469, 68, 165, 21);
		panel_13.add(rdoChuaHH);

		btg = new ButtonGroup();
		btg.add(rdoChuaHH);
		btg.add(rdoHetHan);
		
		cbXuatXu = new JTextField();
		cbXuatXu.setFont(new Font("Tahoma", Font.PLAIN, 10));
		cbXuatXu.setEditable(false);
		cbXuatXu.setColumns(10);
		cbXuatXu.setBackground(Color.WHITE);
		cbXuatXu.setBounds(899, 229, 212, 29);
		panel_13.add(cbXuatXu);

		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(255, 255, 204));

		panel_14.setBounds(1146, 54, 154, 356);
		panel_11.add(panel_14);
		panel_14.setLayout(null);

		btnThemThuoc = new JButton("Thêm thuốc");
		btnThemThuoc.setToolTipText("Thêm thuốc khi đã nhập đầy đủ thông tin");
		btnThemThuoc.setBackground(SystemColor.window);
		btnThemThuoc.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnThemThuoc.setBounds(10, 55, 141, 43);

		ImageIcon img211 = new ImageIcon(this.getClass().getResource("/add.png"));
		btnThemThuoc.setIcon(img211);

		panel_14.add(btnThemThuoc);

		btnXoaThuoc = new JButton("Xóa thuốc");
		btnXoaThuoc.setToolTipText("Xóa thuốc ướng với thối đã chọn trong bảng");
		btnXoaThuoc.setBackground(SystemColor.window);
		btnXoaThuoc.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnXoaThuoc.setBounds(10, 125, 141, 43);
		ImageIcon img2111 = new ImageIcon(this.getClass().getResource("/rmv.png"));
		btnXoaThuoc.setIcon(img2111);
		panel_14.add(btnXoaThuoc);

		btnSuaThuoc = new JButton("Sửa thuốc");
		btnSuaThuoc.setToolTipText("Sửa thuốc ừng với thuốc đã chọn trong bảng");
		btnSuaThuoc.setBackground(SystemColor.window);
		btnSuaThuoc.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnSuaThuoc.setBounds(10, 197, 141, 43);
		ImageIcon img21111 = new ImageIcon(this.getClass().getResource("/sua.png"));
		btnSuaThuoc.setIcon(img21111);
		panel_14.add(btnSuaThuoc);

		btnXoaTrang = new JButton("Xóa trắng");
		btnXoaTrang.setToolTipText("Xóa các thông tin đang hiển thị khi chọn thuốc bất kì trong danh sách");
		btnXoaTrang.setBackground(SystemColor.window);
		btnXoaTrang.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnXoaTrang.setBounds(10, 268, 141, 43);
		ImageIcon img211111 = new ImageIcon(this.getClass().getResource("/xt.png"));
		btnXoaTrang.setIcon(img211111);
		panel_14.add(btnXoaTrang);

		JPanel panel_15 = new JPanel();
		panel_15.setToolTipText("Hiển thị thông tin ứng với thuốc đã chọn");
		panel_15.setBackground(new Color(255, 255, 204));
		panel_15.setBounds(10, 429, 1291, 415);
		panel_15.setLayout(new BoxLayout(panel_15, BoxLayout.X_AXIS));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("Hiển thị thông tin ứng với thuốc đã chọn");
		panel_15.add(scrollPane);
		String[] tieuDe = { "Mã Thuốc", "Tên Thuốc", "Đơn vị tính", "Số Lượng", "Giá Nhập", "Giá Bán", "Ngày Nhập",
				"Ngày Sản Xuất", "Hạn SD", "Loại Thuốc", "Mã Nhà CC", "Tên Nhà CC", "Xuất Xứ", "Mô tả" };
		dftable = new DefaultTableModel(tieuDe, 0);
		table = new JTable(dftable);
		DocDuLieuDataBaseVaoTable();
		scrollPane.setViewportView(table);
		panel_10.add(panel_15);

		table.addMouseListener(this);
		btnQL.addActionListener(this);
		btnBH.addActionListener(this);
		btnTK.addActionListener(this);
		btnDX.addActionListener(this);
		btnTimTheoMa.addActionListener(this);
		btnTimTheoTen.addActionListener(this);
		btnRF.addActionListener(this);
		rdoChuaHH.addActionListener(this);
		rdoHetHan.addActionListener(this);
		btnThemThuoc.addActionListener(this);
		btnXoaThuoc.addActionListener(this);
		btnSuaThuoc.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		txtMaNhaCungCap.addActionListener(this);
		btnTT.addActionListener(this);
		btnHDSD.addActionListener(this);
	}

	public void XoaHetDuLieuTrenTableModel() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();
	}

	public void DocDuLieuDataBaseVaoTable() {

		List<DuocPham> list = duocPhamDAOz.getDanhSachDuocPham();
		for (DuocPham sp : list) {
			dftable.addRow(new Object[] { sp.getMaDuocPham(), sp.getTenDuocPham(), sp.getDonViTinh(), sp.getSoLuong(),
					sp.getGiaNhap(), sp.getGiaBan(), sp.getNgayNhap(), sp.getNgaySanXuat(), sp.getNgayHetHan(),
					sp.getLoaiDuocPham().getTenLoai(), sp.getNhaCungCap().getMaNhaCungCap(),
					sp.getNhaCungCap().getTenNhaCungCap(), sp.getNhaCungCap().getXuatXu(),
					sp.getMoTa() });
		}
	}

	public static void main(String[] args) {
		new QuanLyThuoc().setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		int row = table.getSelectedRow();
		txtMaThuoc.setText(dftable.getValueAt(row, 0).toString());
		txtTenThuoc.setText(dftable.getValueAt(row, 1).toString());
		cbDonVi.setSelectedItem(dftable.getValueAt(row, 2).toString());
		txtSoLuong.setValue(dftable.getValueAt(row, 3));
		txtGiaNhap.setText(dftable.getValueAt(row, 4).toString());
		txtGiaBan.setText(dftable.getValueAt(row, 5).toString());
		String dateValue = dftable.getValueAt(row, 6).toString();
		java.util.Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dateValue);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			dateChooserNhap.setCalendar(cal);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String dateValue1 = dftable.getValueAt(row, 7).toString();
		java.util.Date date1;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(dateValue1);
			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(date1);
			dateChooserSX.setCalendar(cal1);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String dateValue2 = dftable.getValueAt(row, 8).toString();
		java.util.Date date2;
		try {
			date2 = new SimpleDateFormat("yyyy-MM-dd").parse(dateValue2);
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(date2);
			dateChooserHH.setCalendar(cal2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cbloaiDuocPham.setSelectedItem(dftable.getValueAt(row, 9).toString());
		txtMaNhaCungCap.setSelectedItem(dftable.getValueAt(row, 10).toString());
		txtTenNhaCungCap.setText(dftable.getValueAt(row, 11).toString());
		cbXuatXu.setText(dftable.getValueAt(row, 12).toString());
		txtMoTa.setText(dftable.getValueAt(row, 13).toString());
		LocalDate hh = LocalDate.of(Integer.parseInt(dftable.getValueAt(row, 8).toString().substring(0, 4)),
				Integer.parseInt(dftable.getValueAt(row, 8).toString().substring(5, 7)),
				Integer.parseInt(dftable.getValueAt(row, 8).toString().substring(8, 10)));
		if (hh.isAfter(localdate)) {
			rdoChuaHH.setSelected(true);
		} else
			rdoHetHan.setSelected(true);
		txtMaThuoc.setEditable(false);
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
		if (o.equals(btnRF)) {
			XoaHetDuLieuTrenTableModel();
			DocDuLieuDataBaseVaoTable();
		}
		if (o.equals(btnXoaTrang)) {
			btg.clearSelection();
			List<DuocPham> list = duocPhamDAOz.getDanhSachDuocPham();
			int r = table.getSelectedRowCount();
			Random rand = new Random();
			int d = rand.nextInt(50);
			for (@SuppressWarnings("unused")
			DuocPham dp : list) {
				if (d != Integer.parseInt(dftable.getValueAt(r, 0).toString())) {
					d += 1;
					String st = Integer.toString(d);
					txtMaThuoc.setText(st);
				}
			}
			txtTenThuoc.setText("");
			txtSoLuong.setValue(0);
			txtGiaNhap.setText("");
			txtGiaBan.setText("");
			dateChooserNhap.setCalendar(null);
			dateChooserSX.setCalendar(null);
			dateChooserHH.setCalendar(null);
			txtMoTa.setText("");
			txtTenNhaCungCap.setText("");
			txtTenNhaCungCap.setText("");
			cbloaiDuocPham.setSelectedIndex(0);
			cbDonVi.setSelectedIndex(0);
			cbXuatXu.setText("");
			txtMaNhaCungCap.setSelectedIndex(0);

		}
		if (o.equals(btnTimTheoMa)) {
			String aa = txtTimTheoMa.getText();
			if (aa != null && aa.trim().length() > 0) {
				try {
					Long Ma = Long.parseLong(aa.trim());
					DuocPham list = duocPhamDAOz.timDuocPhamTheoMa(Ma);
					if (list != null) {
						XoaHetDuLieuTrenTableModel();
						dftable.addRow(new Object[] { list.getMaDuocPham(), list.getTenDuocPham(), list.getDonViTinh(),
								list.getSoLuong(), list.getGiaNhap(), list.getGiaBan(), list.getNgayNhap(),
								list.getNgaySanXuat(), list.getNgayHetHan(), list.getLoaiDuocPham().getTenLoai(),
								list.getNhaCungCap().getMaNhaCungCap(), list.getNhaCungCap().getTenNhaCungCap(),
								list.getNhaCungCap().getXuatXu(), list.getMoTa() });
					} else {
						JOptionPane.showMessageDialog(null, " không tìm thấy ");
						return;
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "không hợp lệ");
				}
			} else {
				XoaHetDuLieuTrenTableModel();
				DocDuLieuDataBaseVaoTable();
			}
		}
		if (o.equals(btnTimTheoTen)) {
			String ten = txtTimTheoTen.getText();
			if (ten.length() > 0) {
				try {
					XoaHetDuLieuTrenTableModel();
					List<DuocPham> list = duocPhamDAOz.timDuocPhamTen(ten);
					if (list != null && list.size() > 0) {
						for (DuocPham sp : list) {
							dftable.addRow(new Object[] { sp.getMaDuocPham(), sp.getTenDuocPham(), sp.getDonViTinh(),
									sp.getSoLuong(), sp.getGiaNhap(), sp.getGiaBan(), sp.getNgayNhap(),
									sp.getNgaySanXuat(), sp.getNgayHetHan(), sp.getLoaiDuocPham().getTenLoai(),
									sp.getNhaCungCap().getMaNhaCungCap(), sp.getNhaCungCap().getTenNhaCungCap(),
									sp.getNhaCungCap().getXuatXu(), sp.getMoTa() });
						}
					} else {
						JOptionPane.showMessageDialog(null, " không tìm thấy");
						return;
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "không hợp lệ");
				}
			} else {
				XoaHetDuLieuTrenTableModel();
				DocDuLieuDataBaseVaoTable();
			}
		}

		if (o.equals(btnSuaThuoc)) {
			String maDuocPham = txtMaThuoc.getText();
			if (!(maDuocPham.length() > 0)) {
				JOptionPane.showMessageDialog(this, "Chọn thuốc cần cập nhật. ");
			}
			if (validData1()) {
				DuocPham dpnew = revertSachFromTextfields();
				DuocPham2 dpnew2 = revertSachFromTextfields2();
				if (JOptionPane.showConfirmDialog(null, "Bạn có muốn cập nhật lại không?", "Warning!",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					XoaHetDuLieuTrenTableModel();
					duocPhamDAOz.suaDuocPham(dpnew);
					duocPhamDAOz.suaDuocPham2(dpnew2);
					DocDuLieuDataBaseVaoTable();
					JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
				} else
					DocDuLieuDataBaseVaoTable();

			}
		}
		if (o.equals(btnThemThuoc)) {
			if (validData1()) {
				DateFormat dayy = new SimpleDateFormat("dd");
				DateFormat monthh = new SimpleDateFormat("MM");
				DateFormat yearr = new SimpleDateFormat("yyyy");
				int ngayNhapngay = Integer.parseInt(dayy.format(dateChooserNhap.getDate()));
				int thangNhap = Integer.parseInt(monthh.format(dateChooserNhap.getDate()));
				int namNhap = Integer.parseInt(yearr.format(dateChooserNhap.getDate()));
				int ngaySanXuatngay = Integer.parseInt(dayy.format(dateChooserSX.getDate()));
				int thangSanXuat = Integer.parseInt(monthh.format(dateChooserSX.getDate()));
				int namSanXuat = Integer.parseInt(yearr.format(dateChooserSX.getDate()));
				int ngayHetHanngay = Integer.parseInt(dayy.format(dateChooserHH.getDate()));
				int thangHetHan = Integer.parseInt(monthh.format(dateChooserHH.getDate()));
				int namHetHan = Integer.parseInt(yearr.format(dateChooserHH.getDate()));
				Long maDuocPham = Long.parseLong(txtMaThuoc.getText());
				String tenDuocPham = txtTenThuoc.getText();
				int soLuong = (Integer) txtSoLuong.getValue();
				Double giaNhap = Double.parseDouble(txtGiaNhap.getText());
				Double giaBan = Double.parseDouble(txtGiaBan.getText());
				String donViTinh = cbDonVi.getSelectedItem().toString();
				LocalDate ngayNhap1 = LocalDate.of(namNhap, thangNhap, ngayNhapngay);
				LocalDate ngaySanXuat = LocalDate.of(namSanXuat, thangSanXuat, ngaySanXuatngay);
				LocalDate ngayHetHan = LocalDate.of(namHetHan, thangHetHan, ngayHetHanngay);
				String moTa = txtMoTa.getText();
				String tenLoai = cbloaiDuocPham.getSelectedItem().toString();
				Long manhaCungCap = Long.parseLong((String) txtMaNhaCungCap.getSelectedItem());
				String tennhaCungCap = txtTenNhaCungCap.getText();
				String tenxuatsu = cbXuatXu.getText();
				LoaiDuocPham loaiDuocPham = new LoaiDuocPham(tenLoai);
				NhaCungCap nhaCungCap = new NhaCungCap();
				nhaCungCap.setMaNhaCungCap(manhaCungCap);
				nhaCungCap.setTenNhaCungCap(tennhaCungCap);
				nhaCungCap.setXuatXu(tenxuatsu);
				DuocPham sp = new DuocPham(maDuocPham, tenDuocPham, soLuong, giaNhap, giaBan, donViTinh, ngayNhap1,
						ngaySanXuat, ngayHetHan, moTa, loaiDuocPham, nhaCungCap);
				DuocPham2 sp2 = new DuocPham2(maDuocPham, tenDuocPham, soLuong, giaNhap, giaBan, donViTinh, ngayNhap1,
						ngaySanXuat, ngayHetHan, moTa, loaiDuocPham, nhaCungCap);
				boolean xet2 = duocPhamDAOz.themDuocPham2(sp2);
				boolean xet = duocPhamDAOz.themDuocPham(sp);
				if (xet == false || xet2 == false) {
					JOptionPane.showMessageDialog(this, "trùng");
					return;
				}

				dftable.addRow(new Object[] { sp.getMaDuocPham(), sp.getTenDuocPham(), sp.getDonViTinh(),
						sp.getSoLuong(), sp.getGiaNhap(), sp.getGiaBan(), sp.getNgayNhap(), sp.getNgaySanXuat(),
						sp.getNgayHetHan(), sp.getLoaiDuocPham().getTenLoai(), sp.getNhaCungCap().getMaNhaCungCap(),
						sp.getNhaCungCap().getTenNhaCungCap(), sp.getNhaCungCap().getXuatXu(),
						sp.getMoTa() });
				JOptionPane.showMessageDialog(this, "Thêm thành công!");
			}
		}
		if (o.equals(txtMaNhaCungCap)) {
			if (txtMaNhaCungCap.getSelectedItem().toString().equalsIgnoreCase("1")) {
				txtTenNhaCungCap.setText("Phong");
				cbXuatXu.setText("Việt Nam");
			} else if (txtMaNhaCungCap.getSelectedItem().toString().equalsIgnoreCase("2")) {
				txtTenNhaCungCap.setText("Hiển");
				cbXuatXu.setText("Trung Quốc");
			} else if (txtMaNhaCungCap.getSelectedItem().toString().equalsIgnoreCase("3")) {
				txtTenNhaCungCap.setText("Huy");
				cbXuatXu.setText("Mỹ");
			} else if (txtMaNhaCungCap.getSelectedItem().toString().equalsIgnoreCase("4")) {
				txtTenNhaCungCap.setText("Vũ");
				cbXuatXu.setText("Việt Nam");
			} else if (txtMaNhaCungCap.getSelectedItem().toString().equalsIgnoreCase("5")) {
				txtTenNhaCungCap.setText("Hoa");
				cbXuatXu.setText("Mỹ");
			}
		}
		if (o.equals(cbXuatXu)) {
			if (txtMaNhaCungCap.getSelectedItem().toString().equalsIgnoreCase("Việt Nam")) {
				txtMaNhaCungCap.setSelectedItem("1");
			} else if (txtMaNhaCungCap.getSelectedItem().toString().equalsIgnoreCase("Trung Quốc")) {
				txtMaNhaCungCap.setSelectedItem("2");
			} else if (txtMaNhaCungCap.getSelectedItem().toString().equalsIgnoreCase("Mỹ")) {
				txtMaNhaCungCap.setSelectedItem("3");
			} else if (txtMaNhaCungCap.getSelectedItem().toString().equalsIgnoreCase("Việt Nam")) {
				txtMaNhaCungCap.setSelectedItem("4");
			} else if (txtMaNhaCungCap.getSelectedItem().toString().equalsIgnoreCase("Mỹ")) {
				txtMaNhaCungCap.setSelectedItem("5");
			}
		}
		if (o.equals(btnXoaThuoc)) {
			try {
				int r = table.getSelectedRow();
				Long a = Long.parseLong(dftable.getValueAt(r, 0).toString());
				if (JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?", "Warning!",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					dftable.removeRow(r);
					duocPhamDAOz.xoaDuocPham(a);
					duocPhamDAOz.xoaDuocPham2(a);
					JOptionPane.showMessageDialog(this, "Xóa thành công!");
				} else
					DocDuLieuDataBaseVaoTable();

			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Phải chọn dòng để xóa!");
			}
		}
		if (o.equals(btnDX)) {
			setVisible(false);
			frmlg.setVisible(true);
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

	private DuocPham revertSachFromTextfields() {
		DateFormat dayy = new SimpleDateFormat("dd");
		DateFormat monthh = new SimpleDateFormat("MM");
		DateFormat yearr = new SimpleDateFormat("yyyy");
		int ngayNhapngay = Integer.parseInt(dayy.format(dateChooserNhap.getDate()));
		int thangNhap = Integer.parseInt(monthh.format(dateChooserNhap.getDate()));
		int namNhap = Integer.parseInt(yearr.format(dateChooserNhap.getDate()));
		int ngaySanXuatngay = Integer.parseInt(dayy.format(dateChooserSX.getDate()));
		int thangSanXuat = Integer.parseInt(monthh.format(dateChooserSX.getDate()));
		int namSanXuat = Integer.parseInt(yearr.format(dateChooserSX.getDate()));
		int ngayHetHanngay = Integer.parseInt(dayy.format(dateChooserHH.getDate()));
		int thangHetHan = Integer.parseInt(monthh.format(dateChooserHH.getDate()));
		int namHetHan = Integer.parseInt(yearr.format(dateChooserHH.getDate()));
		Long maDuocPham = Long.parseLong(txtMaThuoc.getText());
		String tenDuocPham = txtTenThuoc.getText();
		int soLuong = (Integer) txtSoLuong.getValue();
		Double giaNhap = Double.parseDouble(txtGiaNhap.getText());
		Double giaBan = Double.parseDouble(txtGiaBan.getText());
		String donViTinh = cbDonVi.getSelectedItem().toString();
		LocalDate ngayNhap1 = LocalDate.of(namNhap, thangNhap, ngayNhapngay);
		LocalDate ngaySanXuat = LocalDate.of(namSanXuat, thangSanXuat, ngaySanXuatngay);
		LocalDate ngayHetHan = LocalDate.of(namHetHan, thangHetHan, ngayHetHanngay);
		String moTa = txtMoTa.getText();
		String tenLoai = cbloaiDuocPham.getSelectedItem().toString();
		Long manhaCungCap = Long.parseLong((String) txtMaNhaCungCap.getSelectedItem());
		String tennhaCungCap = txtTenNhaCungCap.getText();
		String tenxuatsu = cbXuatXu.getText();
		NhaCungCap nhaCungCap = new NhaCungCap();
		nhaCungCap.setMaNhaCungCap(manhaCungCap);
		nhaCungCap.setTenNhaCungCap(tennhaCungCap);
		nhaCungCap.setXuatXu(tenxuatsu);
		LoaiDuocPham loaiDuocPham = new LoaiDuocPham(tenLoai);
		return new DuocPham(maDuocPham, tenDuocPham, soLuong, giaNhap, giaBan, donViTinh, ngayNhap1, ngaySanXuat,
				ngayHetHan, moTa, loaiDuocPham, nhaCungCap);
	}

	private DuocPham2 revertSachFromTextfields2() {
		DateFormat dayy = new SimpleDateFormat("dd");
		DateFormat monthh = new SimpleDateFormat("MM");
		DateFormat yearr = new SimpleDateFormat("yyyy");
		int ngayNhapngay = Integer.parseInt(dayy.format(dateChooserNhap.getDate()));
		int thangNhap = Integer.parseInt(monthh.format(dateChooserNhap.getDate()));
		int namNhap = Integer.parseInt(yearr.format(dateChooserNhap.getDate()));
		int ngaySanXuatngay = Integer.parseInt(dayy.format(dateChooserSX.getDate()));
		int thangSanXuat = Integer.parseInt(monthh.format(dateChooserSX.getDate()));
		int namSanXuat = Integer.parseInt(yearr.format(dateChooserSX.getDate()));
		int ngayHetHanngay = Integer.parseInt(dayy.format(dateChooserHH.getDate()));
		int thangHetHan = Integer.parseInt(monthh.format(dateChooserHH.getDate()));
		int namHetHan = Integer.parseInt(yearr.format(dateChooserHH.getDate()));
		Long maDuocPham = Long.parseLong(txtMaThuoc.getText());
		String tenDuocPham = txtTenThuoc.getText();
		int soLuong = (Integer) txtSoLuong.getValue();
		Double giaNhap = Double.parseDouble(txtGiaNhap.getText());
		Double giaBan = Double.parseDouble(txtGiaBan.getText());
		String donViTinh = cbDonVi.getSelectedItem().toString();
		LocalDate ngayNhap1 = LocalDate.of(namNhap, thangNhap, ngayNhapngay);
		LocalDate ngaySanXuat = LocalDate.of(namSanXuat, thangSanXuat, ngaySanXuatngay);
		LocalDate ngayHetHan = LocalDate.of(namHetHan, thangHetHan, ngayHetHanngay);
		String moTa = txtMoTa.getText();
		String tenLoai = cbloaiDuocPham.getSelectedItem().toString();
		Long manhaCungCap = Long.parseLong((String) txtMaNhaCungCap.getSelectedItem());
		String tennhaCungCap = txtTenNhaCungCap.getText();
		String tenxuatsu = cbXuatXu.getText();
		NhaCungCap nhaCungCap = new NhaCungCap();
		nhaCungCap.setMaNhaCungCap(manhaCungCap);
		nhaCungCap.setTenNhaCungCap(tennhaCungCap);
		nhaCungCap.setXuatXu(tenxuatsu);
		LoaiDuocPham loaiDuocPham = new LoaiDuocPham(tenLoai);
		return new DuocPham2(maDuocPham, tenDuocPham, soLuong, giaNhap, giaBan, donViTinh, ngayNhap1, ngaySanXuat,
				ngayHetHan, moTa, loaiDuocPham, nhaCungCap);
	}


	private boolean validData1() {
		String GiaNhap = txtGiaNhap.getText().trim();
		String GiaBan = txtGiaBan.getText().trim();
		DateFormat dayy = new SimpleDateFormat("dd");
		DateFormat monthh = new SimpleDateFormat("MM");
		DateFormat yearr = new SimpleDateFormat("yyyy");
		int ngayNhapngay = Integer.parseInt(dayy.format(dateChooserNhap.getDate()));
		int thangNhap = Integer.parseInt(monthh.format(dateChooserNhap.getDate()));
		int namNhap = Integer.parseInt(yearr.format(dateChooserNhap.getDate()));
		int ngaySanXuatngay = Integer.parseInt(dayy.format(dateChooserSX.getDate()));
		int thangSanXuat = Integer.parseInt(monthh.format(dateChooserSX.getDate()));
		int namSanXuat = Integer.parseInt(yearr.format(dateChooserSX.getDate()));
		int ngayHetHanngay = Integer.parseInt(dayy.format(dateChooserHH.getDate()));
		int thangHetHan = Integer.parseInt(monthh.format(dateChooserHH.getDate()));
		int namHetHan = Integer.parseInt(yearr.format(dateChooserHH.getDate()));
		LocalDate ngaynhaphang = LocalDate.of(namNhap, thangNhap, ngayNhapngay);
		LocalDate ngaysx = LocalDate.of(namSanXuat, thangSanXuat, ngaySanXuatngay);
		LocalDate ngayhh = LocalDate.of(namHetHan, thangHetHan, ngayHetHanngay);
		if (!(kiemtraNgayNhapNgaySX(ngaynhaphang, ngaysx))) {
			JOptionPane.showMessageDialog(this, "ngày nhập phải sau ngày sản xuất", "Cảnh báo",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (!(kiemtraNgaySXNgayHH(ngaysx, ngayhh))) {
			JOptionPane.showMessageDialog(this, "ngày hết hạn phải sau ngày sản xuất", "Cảnh báo",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}


		if (GiaNhap.length() > 0) {
			try {
				Double Gianhapx = Double.parseDouble(GiaNhap);
				if (Gianhapx <= 0) {
					JOptionPane.showMessageDialog(this, "Giá Nhập không được âm", "Cảnh báo",
							JOptionPane.WARNING_MESSAGE);
					txtGiaNhap.selectAll();
					txtGiaNhap.requestFocus();
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Nhập sai định dạng Số Lượng Giá Nhập!", "Cảnh báo",
						JOptionPane.WARNING_MESSAGE);
				txtGiaNhap.selectAll();
				txtGiaNhap.requestFocus();
				return false;
			}
		}
		if (GiaBan.length() > 0) {
			try {
				int GiaBanx = Integer.parseInt(GiaBan);
				if (GiaBanx <= 0) {
					JOptionPane.showMessageDialog(this, "Giá Bán không được âm", "Cảnh báo",
							JOptionPane.WARNING_MESSAGE);
					txtGiaBan.selectAll();
					txtGiaBan.requestFocus();
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Nhập sai định dạng Giá Bán!", "Cảnh báo",
						JOptionPane.WARNING_MESSAGE);
				txtGiaBan.selectAll();
				txtGiaBan.requestFocus();
				return false;
			}
		}
		
		return true;
	}

	public boolean kiemtraNgaySXNgayHH(LocalDate ngaysx, LocalDate ngayhh) {
		boolean i = ngaysx.isBefore(ngayhh);
		if (i)
			return true;
		return false;
	}

	public boolean kiemtraNgayNhapNgaySX(LocalDate ngaynhap, LocalDate ngaysx) {
		boolean i = ngaysx.isBefore(ngaynhap);
		if (i)
			return true;
		return false;
	}
}
