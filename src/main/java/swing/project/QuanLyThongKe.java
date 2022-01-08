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
import java.awt.Container;

import javax.swing.Box;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTable;

import swing.project.dao.HoaDonDAO;
import swing.project.dao.impl.DuocPhamDAOImpl;
import swing.project.dao.impl.HoaDonDAOImpl;
import swing.project.entity.DuocPham;
import swing.project.entity.DuocPham2;
import swing.project.entity.HoaDon;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class QuanLyThongKe extends JFrame implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnQL;
	private JButton btnBH;
	private JButton btnTKT;
	private JButton btnDX;
	LocalDate localdate = LocalDate.now();
	DuocPhamDAOImpl duocPhamDAOz = new DuocPhamDAOImpl();
	private HoaDonDAO hd_dao = new HoaDonDAOImpl();
	private DefaultTableModel model;
	private JTable DSHoaDon;
	private JRadioButton rdoTHH;
	private JRadioButton rdoTMN;
	private JButton btnTK;
	private JButton btnRefresh;
	private ButtonGroup btg;
	private DefaultTableModel dfTableHD;
	private JTable tableHD;
	private JTextField txtTongTienThuDuoc;
	private JTextField txtSLT;
	private Container panel_14;
	private JRadioButton rdoLine;
	private JRadioButton rdoBar;
	private ButtonGroup btg2;
	private JSpinner snpNam;
	private JSpinner snpThang;
	private JSpinner snpNgay;
	private JRadioButton rdoThang;
	private JRadioButton rdoNgay;
	private JButton btnBieuDo;
	private JButton btnRe;
	private JButton btnTT;
	private JButton btnHDSD;
	private static DangNhap frmlg = new DangNhap();
	private static QuanLyThuoc frmql = new QuanLyThuoc();
	private static QuanLyBanHang frmbh = new QuanLyBanHang();
	private static ThongTinNhanVien frmtt = new ThongTinNhanVien();

	@SuppressWarnings("deprecation")
	public QuanLyThongKe() {
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

		btnTKT = new JButton("Quản lý thống kê    ");
		btnTKT.setToolTipText("Chức nằng quản lý thống kê");
		btnTKT.setBackground(SystemColor.window);
		btnTKT.setFont(new Font("Times New Roman", Font.BOLD, 18));
		ImageIcon imgtk = new ImageIcon(this.getClass().getResource("/tk.png"));
		btnTKT.setIcon(imgtk);
		panel_9.add(btnTKT);

		Component verticalStrut_6 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_6);
		
		JPanel panel_3 = new JPanel();
		verticalBox.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnHDSD = new JButton("Hướng dẫn sử dụng");
		btnHDSD.setToolTipText("Chức nằng quản lý thống kê");
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
		panel_11.setBounds(0, 0, 1311, 558);
		panel_10.add(panel_11);
		panel_11.setLayout(null);

		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(255, 250, 240));
		panel_12.setBounds(0, 0, 1333, 41);
		panel_11.add(panel_12);
		panel_12.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblTit = new JLabel("QUẢN LÝ THỐNG KÊ");
		lblTit.setForeground(new Color(0, 0, 128));
		lblTit.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblTit.setBackground(new Color(0, 0, 128));
		panel_12.add(lblTit);

		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(255, 255, 204));

		panel_13.setBounds(10, 59, 1292, 499);
		panel_11.add(panel_13);
		panel_13.setLayout(null);

		JPanel panel_18 = new JPanel();
		panel_18.setBackground(new Color(255, 255, 204));
		panel_18.setBounds(10, 50, 201, 418);
		panel_18.setLayout(new BoxLayout(panel_18, BoxLayout.X_AXIS));

		JScrollPane scrollPane2 = new JScrollPane();
		panel_18.add(scrollPane2);

		String[] tieuDe1 = { "Ngày lập hóa đơn", "Tổng tiền" };
		dfTableHD = new DefaultTableModel(tieuDe1, 0);
		tableHD = new JTable(dfTableHD);
		tableHD.setBackground(Color.WHITE);
		scrollPane2.setViewportView(tableHD);
		DocDanhSachHoaDonVaoBang2();

		panel_13.add(panel_18);

		JLabel lblTDT = new JLabel("Tổng doanh thu:");
		lblTDT.setBounds(10, 10, 101, 30);
		panel_13.add(lblTDT);
		lblTDT.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		panel_14 = new JPanel();
		panel_14.setBackground(new Color(255, 255, 204));
		panel_14.setBounds(399, 0, 893, 499);
		vebar();
		panel_13.add(panel_14);

		txtTongTienThuDuoc = new JTextField();
		txtTongTienThuDuoc.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtTongTienThuDuoc.setEditable(false);
		txtTongTienThuDuoc.setBounds(121, 10, 90, 30);
		txtTongTienThuDuoc.setText(String.valueOf(tinhtong()));
		panel_13.add(txtTongTienThuDuoc);
		txtTongTienThuDuoc.setColumns(10);

		JPanel panel_19 = new JPanel();
		panel_19.setBackground(SystemColor.window);
		panel_19.setBounds(221, 10, 168, 458);
		panel_13.add(panel_19);
		panel_19.setLayout(null);

		rdoLine = new JRadioButton("Biểu đồ đường");
		rdoLine.setToolTipText("Hiển thị biểu đồ đường");
		rdoLine.setBackground(SystemColor.window);
		rdoLine.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rdoLine.setBounds(37, 31, 121, 21);
		panel_19.add(rdoLine);

		rdoBar = new JRadioButton("Biểu đồ cột");
		rdoBar.setToolTipText("Hiển thị biểu đồ cột");
		rdoBar.setBackground(SystemColor.window);
		rdoBar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rdoBar.setBounds(37, 83, 121, 21);
		panel_19.add(rdoBar);

		btg2 = new ButtonGroup();
		btg2.add(rdoLine);
		btg2.add(rdoBar);

		snpNam = new JSpinner();
		snpNam.setModel(new SpinnerNumberModel(new Integer(2000), new Integer(2000), null, new Integer(1)));
		snpNam.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		snpNam.setBounds(10, 136, 148, 31);
		panel_19.add(snpNam);

		snpThang = new JSpinner();
		snpThang.setEnabled(false);
		snpThang.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		snpThang.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		snpThang.setBounds(37, 205, 121, 31);
		panel_19.add(snpThang);

		snpNgay = new JSpinner();
		snpNgay.setEnabled(false);
		snpNgay.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		snpNgay.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		snpNgay.setBounds(37, 274, 121, 31);
		panel_19.add(snpNgay);

		rdoThang = new JRadioButton("");
		rdoThang.setBackground(SystemColor.window);
		rdoThang.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rdoThang.setBounds(10, 205, 21, 31);
		panel_19.add(rdoThang);

		rdoNgay = new JRadioButton("");
		rdoNgay.setBackground(SystemColor.textHighlightText);
		rdoNgay.setEnabled(false);
		rdoNgay.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rdoNgay.setBounds(10, 274, 21, 31);
		panel_19.add(rdoNgay);

		btnBieuDo = new JButton("Thống kê");
		btnBieuDo.setToolTipText(
				"Thống kê ra bảng các hóa đơn, tổng doanh thu và hiển thị biểu đồ ứng với nút biểu đồ đã chọn theo ngày/tháng/năm khi đã chọn");
		btnBieuDo.setBackground(SystemColor.control);
		btnBieuDo.setEnabled(true);
		btnBieuDo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnBieuDo.setBounds(10, 326, 148, 41);
		ImageIcon img211 = new ImageIcon(this.getClass().getResource("/grp.png"));
		btnBieuDo.setIcon(img211);
		panel_19.add(btnBieuDo);

		btnRe = new JButton("Làm mới");
		btnRe.setToolTipText("Làm mới lại bảng thống kê hóa đơn, tổng doanh thu và biểu đồ ban đầu");
		btnRe.setBackground(SystemColor.control);
		btnRe.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnRe.setBounds(10, 390, 148, 41);
		ImageIcon img2111 = new ImageIcon(this.getClass().getResource("/rf.png"));
		btnRe.setIcon(img2111);
		panel_19.add(btnRe);

		JPanel panel_15 = new JPanel();
		panel_15.setBackground(new Color(255, 255, 204));
		panel_15.setBounds(186, 583, 1115, 261);
		panel_15.setLayout(new BoxLayout(panel_15, BoxLayout.X_AXIS));
		JScrollPane scrollPane = new JScrollPane();
		panel_15.add(scrollPane);
		String[] tieuDe = { "Mã Thuốc", "Tên Thuốc", "Đơn vị tính", "Số Lượng", "Giá Nhập", "Giá Bán", "Ngày Nhập",
				"Ngày Sản Xuất", "Hạn SD", "Loại Thuốc", "Mã Nhà CC", "Tên Nhà CC", "Xuất Xứ", "Mô tả" };
		model = new DefaultTableModel(tieuDe, 0);
		DSHoaDon = new JTable(model);
		scrollPane.setViewportView(DSHoaDon);
		DocDuLieuDataBaseVaoTable();
		panel_10.add(panel_15);

		JPanel panel_16 = new JPanel();
		panel_16.setBackground(new Color(255, 255, 204));
		panel_16.setBounds(10, 583, 165, 261);
		panel_10.add(panel_16);
		panel_16.setLayout(null);

		rdoTHH = new JRadioButton("Thống kê thuốc hết hạn");
		rdoTHH.setToolTipText(
				"Chọn thống kê thuốc hết hạn thì có thể chọn nút thống kê để hiện thị danh sách thuốc hết hạn");
		rdoTHH.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rdoTHH.setBackground(new Color(255, 255, 204));
		rdoTHH.setBounds(6, 6, 153, 21);
		panel_16.add(rdoTHH);

		rdoTMN = new JRadioButton("Thống kê thuốc mới nhập");
		rdoTMN.setToolTipText(
				"Chọn thống kê thuốc mới nhập thì có thể chọn nút thống kê để hiện thị danh sách thuốc mới nhập");
		rdoTMN.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rdoTMN.setBackground(new Color(255, 255, 204));
		rdoTMN.setBounds(6, 29, 153, 21);
		panel_16.add(rdoTMN);

		btnTK = new JButton("Thống kê");
		btnTK.setToolTipText(
				"Có thể thống kê sau khi chọn thống kê thuốc hết hạn hoặc thống kê thuốc mới nhập qua đó hiển thị danh sách thuốc đã thống kê và số lượng thuốc ứng với lựa chọn");
		btnTK.setBackground(SystemColor.window);
		btnTK.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnTK.setBounds(6, 56, 153, 41);
		ImageIcon img1 = new ImageIcon(this.getClass().getResource("/srch.png"));
		btnTK.setIcon(img1);
		panel_16.add(btnTK);
		btg = new ButtonGroup();
		btg.add(rdoTMN);
		btg.add(rdoTHH);

		btnRefresh = new JButton("Refresh");
		btnRefresh.setToolTipText("Làm mới lại bảng thống kê thuốc và bỏ các lựa chọn thống kê");
		btnRefresh.setBackground(SystemColor.window);
		btnRefresh.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnRefresh.setBounds(6, 108, 153, 41);
		ImageIcon imgrf = new ImageIcon(this.getClass().getResource("/rf.png"));
		btnRefresh.setIcon(imgrf);
		panel_16.add(btnRefresh);
		btnTK.setEnabled(false);

		JLabel lblTTK = new JLabel("Số lượng thuốc:");
		lblTTK.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTTK.setBounds(30, 147, 103, 32);
		panel_16.add(lblTTK);

		txtSLT = new JTextField();
		txtSLT.setEditable(false);
		txtSLT.setColumns(10);
		txtSLT.setBounds(30, 189, 103, 19);
		panel_16.add(txtSLT);
		txtSLT.setText(String.valueOf(demsl2()));

		rdoBar.setSelected(true);

		btnQL.addActionListener(this);
		btnBH.addActionListener(this);
		btnTK.addActionListener(this);
		btnDX.addActionListener(this);
		rdoTHH.addActionListener(this);
		rdoTMN.addActionListener(this);
		btnTKT.addActionListener(this);
		btnRefresh.addActionListener(this);
		rdoLine.addActionListener(this);
		rdoBar.addActionListener(this);
		rdoThang.addActionListener(this);
		rdoNgay.addActionListener(this);
		btnBieuDo.addActionListener(this);
		btnRe.addActionListener(this);
		btnTT.addActionListener(this);
		btnHDSD.addActionListener(this);

	}

	public void XoaHetDuLieuTrenTableModel() {
		DefaultTableModel dm = (DefaultTableModel) DSHoaDon.getModel();
		dm.getDataVector().removeAllElements();
	}

	public void DocDuLieuDataBaseVaoTable() {

		List<DuocPham> list = duocPhamDAOz.getDanhSachDuocPham();
		for (DuocPham sp : list) {
			model.addRow(new Object[] { sp.getMaDuocPham(), sp.getTenDuocPham(), sp.getDonViTinh(), sp.getSoLuong(),
					sp.getGiaNhap(), sp.getGiaBan(), sp.getNgayNhap(), sp.getNgaySanXuat(), sp.getNgayHetHan(),
					sp.getLoaiDuocPham().getTenLoai(), sp.getNhaCungCap().getMaNhaCungCap(),
					sp.getNhaCungCap().getTenNhaCungCap(), sp.getNhaCungCap().getXuatXu(),
					sp.getMoTa() });
		}
	}

	public void DocDanhSachHoaDonVaoBang2() {
		List<HoaDon> list = hd_dao.getDanhSachHoaDon();
		for (HoaDon kh : list) {
			dfTableHD.addRow(new Object[] { kh.getNgayLapHoaDon(), kh.getTongTien() });
		}
		set();

	}

	public void set() {
		for (int i = 0; i < dfTableHD.getRowCount(); i++) {
			for (int j = i + 1; j < dfTableHD.getRowCount(); j++) {
				if (dfTableHD.getValueAt(i, 0).toString().equals(dfTableHD.getValueAt(j, 0).toString())) {
					dfTableHD.setValueAt(Double.toString(Double.parseDouble(dfTableHD.getValueAt(i, 1).toString())
							+ Double.parseDouble(dfTableHD.getValueAt(j, 1).toString())), j, 1);
					dfTableHD.setValueAt("0", i, 1);
				}
			}
		}
		for (int j = 0; j < 100; j++) {
			for (int i = 0; i < dfTableHD.getRowCount(); i++) {
				if (dfTableHD.getValueAt(i, 1).toString() == "0") {
					dfTableHD.removeRow(i);
				}
			}
		}
	}

	public void XoaHetDuLieuTrenTableModel2() {
		DefaultTableModel dm = (DefaultTableModel) tableHD.getModel();
		dm.getDataVector().removeAllElements();
	}

	public static void main(String[] args) {
		new QuanLyThongKe().setVisible(true);

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

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
		if (o.equals(btnDX)) {
			setVisible(false);
			frmlg.setVisible(true);
		}
		if (o.equals(btnBH)) {
			setVisible(false);
			frmbh.setVisible(true);
		}
		if (o.equals(btnQL)) {
			setVisible(false);
			frmql.setVisible(true);
		}
		if (o.equals(btnTT)) {
			frmtt.setVisible(true);
		}
		if (o == btnRefresh) {
			btnTK.setEnabled(false);
			btg.clearSelection();
			XoaHetDuLieuTrenTableModel();
			DocDuLieuDataBaseVaoTable();
			XoaHetDuLieuTrenTableModel2();
			DocDanhSachHoaDonVaoBang2();
			txtTongTienThuDuoc.setText(String.valueOf(tinhtong()));
			txtSLT.setText(String.valueOf(demsl2()));
		}

		if (rdoBar.isSelected()) {
			btnBieuDo.setEnabled(true);
			panel_14.removeAll();
			panel_14.revalidate();
			panel_14.repaint();
			vebar();
		}
		if (rdoLine.isSelected()) {
			btnBieuDo.setEnabled(true);
			panel_14.removeAll();
			panel_14.revalidate();
			panel_14.repaint();
			veline();
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
		if (o == btnBieuDo && rdoThang.isSelected() && rdoNgay.isSelected()) {
			for (int i = 0; i < dfTableHD.getRowCount(); i++) {
				int nam = (Integer) snpNam.getValue();
				int thang = (Integer) snpThang.getValue();
				int ngay = (Integer) snpNgay.getValue();
				double s = 0;
				if (nam == Integer.parseInt(dfTableHD.getValueAt(i, 0).toString().substring(0, 4))
						&& thang == Integer.parseInt(dfTableHD.getValueAt(i, 0).toString().substring(5, 7))
						&& ngay == Integer.parseInt(dfTableHD.getValueAt(i, 0).toString().substring(8, 10))) {
					XoaHetDuLieuTrenTableModel2();
					List<HoaDon> list = hd_dao.getTheoNgay(ngay, thang, nam);
					for (HoaDon hd : list) {
						dfTableHD.addRow(new Object[] { hd.getNgayLapHoaDon(), hd.getTongTien() });
						s += hd.getTongTien();
					}
					set();
					snpNam.setEnabled(false);
					rdoThang.setSelected(false);
					rdoThang.setEnabled(false);
					txtTongTienThuDuoc.setText(String.valueOf(s));

					btnBieuDo.setEnabled(true);
					panel_14.removeAll();
					panel_14.revalidate();
					panel_14.repaint();

				}
			}
		}
		if (o == btnBieuDo && rdoThang.isSelected() && !(rdoNgay.isSelected())) {
			for (int i = 0; i < dfTableHD.getRowCount(); i++) {
				int nam = (Integer) snpNam.getValue();
				int thang = (Integer) snpThang.getValue();
				int ngay = (Integer) snpNgay.getValue();
				double s = 0;
				if (nam == Integer.parseInt(dfTableHD.getValueAt(i, 0).toString().substring(0, 4))
						&& thang == Integer.parseInt(dfTableHD.getValueAt(i, 0).toString().substring(5, 7))
						&& ngay != Integer.parseInt(dfTableHD.getValueAt(i, 0).toString().substring(8, 10))) {
					XoaHetDuLieuTrenTableModel2();
					List<HoaDon> list = hd_dao.getTheoThang(thang, nam);
					for (HoaDon hd : list) {
						dfTableHD.addRow(new Object[] { hd.getNgayLapHoaDon(), hd.getTongTien() });
						s += hd.getTongTien();
					}
					set();
					snpNam.setEnabled(false);
					rdoThang.setSelected(false);
					rdoThang.setEnabled(false);
					txtTongTienThuDuoc.setText(String.valueOf(s));
					if (dfTableHD.getRowCount() == 1) {
						btnBieuDo.setEnabled(true);
						panel_14.removeAll();
						panel_14.revalidate();
						panel_14.repaint();
					} else if (dfTableHD.getRowCount() > 1) {
						if (rdoBar.isSelected()) {
							btnBieuDo.setEnabled(true);
							panel_14.removeAll();
							panel_14.revalidate();
							panel_14.repaint();
							vebar();
						}
						if (rdoLine.isSelected()) {
							btnBieuDo.setEnabled(true);
							panel_14.removeAll();
							panel_14.revalidate();
							panel_14.repaint();
							veline();
						}
					}
				}
			}
		}
		if (o == btnBieuDo && !(rdoThang.isSelected()) && !(rdoNgay.isSelected())) {
			for (int i = 0; i < dfTableHD.getRowCount(); i++) {
				int nam = (Integer) snpNam.getValue();
				int thang = (Integer) snpThang.getValue();
				int ngay = (Integer) snpNgay.getValue();
				double s = 0;
				if (nam == Integer.parseInt(dfTableHD.getValueAt(i, 0).toString().substring(0, 4))
						&& thang != Integer.parseInt(dfTableHD.getValueAt(i, 0).toString().substring(5, 7))
						&& ngay != Integer.parseInt(dfTableHD.getValueAt(i, 0).toString().substring(8, 10))) {
					XoaHetDuLieuTrenTableModel2();
					List<HoaDon> list = hd_dao.getTheoNam(nam);
					for (HoaDon hd : list) {
						dfTableHD.addRow(new Object[] { hd.getNgayLapHoaDon(), hd.getTongTien() });
						s += hd.getTongTien();
					}
					set();

					snpNam.setEnabled(false);
					rdoThang.setSelected(false);
					rdoThang.setEnabled(false);
					txtTongTienThuDuoc.setText(String.valueOf(s));
					if (dfTableHD.getRowCount() == 1) {
						btnBieuDo.setEnabled(true);
						panel_14.removeAll();
						panel_14.revalidate();
						panel_14.repaint();
					} else if (dfTableHD.getRowCount() > 1) {
						if (rdoBar.isSelected()) {
							btnBieuDo.setEnabled(true);
							panel_14.removeAll();
							panel_14.revalidate();
							panel_14.repaint();
							vebar();
						}
						if (rdoLine.isSelected()) {
							btnBieuDo.setEnabled(true);
							panel_14.removeAll();
							panel_14.revalidate();
							panel_14.repaint();
							veline();
						}
					}

				}
			}
		}

		if (o == btnRe) {
			XoaHetDuLieuTrenTableModel2();
			DocDanhSachHoaDonVaoBang2();
			snpNam.setEnabled(true);
			rdoThang.setEnabled(true);
			btg2.clearSelection();
			rdoBar.setSelected(true);
			if (rdoBar.isSelected()) {
				btnBieuDo.setEnabled(true);
				panel_14.removeAll();
				panel_14.revalidate();
				panel_14.repaint();
				vebar();
			}
			txtTongTienThuDuoc.setText(String.valueOf(tinhtong()));
		}
		if (rdoThang.isSelected()) {
			rdoThang.setEnabled(false);
			rdoNgay.setEnabled(true);
			snpThang.setEnabled(true);
			if (rdoNgay.isSelected()) {
				rdoNgay.setEnabled(false);
				snpNgay.setEnabled(true);
			} else
				snpNgay.setEnabled(false);

		} else {
			rdoNgay.setEnabled(false);
			rdoNgay.setSelected(false);
			snpThang.setEnabled(false);
			snpNgay.setEnabled(false);
		}

		if (rdoTHH.isSelected()) {
			btnTK.setEnabled(true);
			if (o.equals(btnTK) && rdoTHH.isSelected()) {
				try {
					XoaHetDuLieuTrenTableModel();
					int sl = 0;
					List<DuocPham> list = duocPhamDAOz.timDuocPhamHH();
					if (list != null && list.size() > 0) {
						for (DuocPham sp : list) {
							model.addRow(new Object[] { sp.getMaDuocPham(), sp.getTenDuocPham(), sp.getDonViTinh(),
									sp.getSoLuong(), sp.getGiaNhap(), sp.getGiaBan(), sp.getNgayNhap(),
									sp.getNgaySanXuat(), sp.getNgayHetHan(), sp.getLoaiDuocPham().getTenLoai(),
									sp.getNhaCungCap().getMaNhaCungCap(), sp.getNhaCungCap().getTenNhaCungCap(),
									sp.getNhaCungCap().getXuatXu(), sp.getMoTa() });

							sl += sp.getSoLuong();
						}
						txtSLT.setText(String.valueOf(sl));
					} else {
						JOptionPane.showMessageDialog(null, " không tìm thấy");
						return;
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, " không tìm thấy");
				}
			}
		}

		if (rdoTMN.isSelected()) {
			btnTK.setEnabled(true);
			if (o.equals(btnTK) && rdoTMN.isSelected()) {
				try {
					XoaHetDuLieuTrenTableModel();
					int sl = 0;
					List<DuocPham2> list = duocPhamDAOz.timDuocPhamMN();
					if (list != null && list.size() > 0) {
						for (DuocPham2 sp : list) {
							model.addRow(new Object[] { sp.getMaDuocPham(), sp.getTenDuocPham(), sp.getDonViTinh(),
									sp.getSoLuong(), sp.getGiaNhap(), sp.getGiaBan(), sp.getNgayNhap(),
									sp.getNgaySanXuat(), sp.getNgayHetHan(), sp.getLoaiDuocPham().getTenLoai(),
									sp.getNhaCungCap().getMaNhaCungCap(), sp.getNhaCungCap().getTenNhaCungCap(),
									sp.getNhaCungCap().getXuatXu(), sp.getMoTa() });

							sl += sp.getSoLuong();
						}
						txtSLT.setText(String.valueOf(sl));
					} else {
						JOptionPane.showMessageDialog(null, " không tìm thấy");
						return;
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, " không tìm thấy");
				}
			}
		}
	}

	public int demsl() {
		List<HoaDon> hd = hd_dao.getDanhSachHoaDon();
		int sl = 0;
		for (HoaDon h : hd) {
			sl += h.getSoLuongDuocPham();
		}
		return sl;
	}

	public int demsl2() {
		List<DuocPham> dp = duocPhamDAOz.getDanhSachDuocPham();
		int sl = 0;
		for (DuocPham dpp : dp) {
			sl += dpp.getSoLuong();
		}
		return sl;
	}

	public double tinhtong() {
		List<HoaDon> hd = hd_dao.getDanhSachHoaDon();
		Long tt = (long) 0;
		for (HoaDon h : hd) {
			tt += h.getTongTien();
		}
		return tt;
	}

	public void veline() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		ArrayList<String> ll = new ArrayList<String>();
		ArrayList<String> ll2 = new ArrayList<String>();
		for (int i = 0; i < tableHD.getRowCount(); i++) {
			ll.add(tableHD.getModel().getValueAt(i, 0) + " ");
			ll2.add(tableHD.getModel().getValueAt(i, 1) + " ");
			dataset.setValue(Double.parseDouble(ll2.get(i)), "", ll.get(i));
		}
		JFreeChart chart = ChartFactory.createLineChart("Biểu đồ thống kê doanh thu theo đường", "Ngày", "Doanh thu",
				dataset);
		CategoryPlot plot = chart.getCategoryPlot();
		Font f = new Font("Dialog", Font.PLAIN, 15);
		plot.getDomainAxis().setLabelFont(f);
		plot.getRangeAxis().setLabelFont(f);
		plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_90);
		chart.getPlot().setBackgroundPaint(new Color(255, 255, 204));
		panel_14.setLayout(new BorderLayout(0, 0));
		ChartPanel chadrt = new ChartPanel(chart);
		chadrt.setBounds(544, 10, 727, 421);
		panel_14.add(chadrt);
		panel_14.validate();
	}

	public void vebar() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		ArrayList<String> ll = new ArrayList<String>();
		ArrayList<String> ll2 = new ArrayList<String>();
		for (int i = 0; i < tableHD.getRowCount(); i++) {
			ll.add(tableHD.getModel().getValueAt(i, 0) + " ");
			ll2.add(tableHD.getModel().getValueAt(i, 1) + " ");
			dataset.setValue(Double.parseDouble(ll2.get(i)), "", ll.get(i));
		}
		JFreeChart chart = ChartFactory.createBarChart("Biểu đồ thống kê doanh thu theo cột", "Ngày", "Doanh thu",
				dataset);
		CategoryPlot plot = chart.getCategoryPlot();
		Font f = new Font("Dialog", Font.PLAIN, 15);
		plot.getDomainAxis().setLabelFont(f);
		plot.getRangeAxis().setLabelFont(f);
		plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_90);
		chart.getPlot().setBackgroundPaint(new Color(255, 255, 204));
		panel_14.setLayout(new BorderLayout(0, 0));
		ChartPanel chadrt = new ChartPanel(chart);
		chadrt.setBounds(544, 10, 727, 421);
		panel_14.add(chadrt);
		panel_14.validate();
	}
}