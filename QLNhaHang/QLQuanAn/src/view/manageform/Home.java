package view.manageform;

import DAO.BanDAO;
import DAO.ChiTietHoaDonDAO;
import DAO.ChiTietPhieuNhapDAO;
import DAO.CongThucDAO;
import DAO.HoaDonDAO;
import DAO.LoaiMonAnDAO;
import DAO.MonAnDAO;
import DAO.NguyenLieuDAO;
import DAO.NhaCungCapDAO;
import DAO.NhanVienDAO;
import DAO.PhieuNhapDAO;
import DAO.TaiKhoanDAO;
import DAO.ThongTinDatBanDAO;
import DTO.BanDTO;
import DTO.CenterTableCellRenderer;
import DTO.ChiTietHoaDonDTO;
import DTO.ChiTietPhieuNhapDTO;
import DTO.CongThucDTO;
import DTO.HoaDonDTO;
import DTO.LoaiMonAnDTO;
import DTO.MonAnDTO;
import DTO.NguyenLieuDTO;
import DTO.NhaCungCapDTO;
import DTO.NhanVienDTO;
import DTO.NumToVND;
import DTO.PhieuNhapDTO;
import DTO.RightTableCellRenderer;
import DTO.TaiKhoanDTO;
import DTO.ThongTinDatBanDTO;
import DTO.Utils;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import view.loginform.login;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

public class Home extends javax.swing.JFrame {

    //<editor-fold defaultstate="collapsed" desc="Method Code">
    private TaiKhoanDTO login;

    public TaiKhoanDTO getLogin() {
        return login;
    }

    public void setLogin(TaiKhoanDTO login) {
        this.login = login;
    }

    boolean flag = false;
    private DoiMatKhau dmk = null;

    private LoaiMonAnDAO loaimonan = new LoaiMonAnDAO();
    private MonAnDAO monan = new MonAnDAO();
    ArrayList<LoaiMonAnDTO> listLMA = new ArrayList<>();
    ArrayList<MonAnDTO> listMA = new ArrayList<>();
    private CongThucDAO CThuc = new CongThucDAO();
    private NguyenLieuDAO ngLieu = new NguyenLieuDAO();
    ArrayList<NguyenLieuDTO> listNgLieu = new ArrayList<>();
    ArrayList<CongThucDTO> listCThuc = new ArrayList<>();
    private BanDAO ban = new BanDAO();
    ArrayList<BanDTO> listBan = new ArrayList<>();

    private NhanVienDAO nv = new NhanVienDAO();
    ArrayList<NhanVienDTO> listNV = new ArrayList<>();

    List<HoaDonDTO> listHD;
    private final int rowsPerPage = 10;
    private int currentPage = 1;
    private boolean isLastClicked = false;
    int totalPages = 0;
    private boolean isFirstClicked = false;

    int idTable = -1;
    private JPanel selectedTable = null;
    private int selectedTableId = -1;
    DefaultTableModel defaultTableModelBillDetails;

    private String daChuyenNhacc = "";

    //</editor-fold>
    public Home(TaiKhoanDTO acc) throws SQLException {
        initComponents();
        this.login = acc;
        jLabelRoles.setText(login.getTendangnhap());
        if (login.getTrangthai().equals("Nhân viên")) {
            jTabbedPane1.setEnabled(false);
        }
        load();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupQuyen = new javax.swing.ButtonGroup();
        jLabelRoles = new javax.swing.JLabel();
        jLabelThoat = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jToolBarHeThong = new javax.swing.JToolBar();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jToolBar4 = new javax.swing.JToolBar();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabelChooseDish = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabelSwitchTable = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabelCombineTable = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabelOrderTable = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanelTables = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabelCancelOrder = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBillDetails = new javax.swing.JTable();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTextAreaOrderInfor = new javax.swing.JTextArea();
        jTextFieldSelectedTable = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelWordTotal = new javax.swing.JLabel();
        jLabelTotal = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JButton();
        toolbarDoiMK = new javax.swing.JToolBar();
        jPanel49 = new javax.swing.JPanel();
        jToolBar7 = new javax.swing.JToolBar();
        jPanel18 = new javax.swing.JPanel();
        jPanel94 = new javax.swing.JPanel();
        jPanel95 = new javax.swing.JPanel();
        jTextField7 = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        txbDoanhThu_NV = new javax.swing.JTextField();
        jPanel96 = new javax.swing.JPanel();
        jPanel97 = new javax.swing.JPanel();
        jLabel120 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableTKDSHD_NV = new javax.swing.JTable();
        jPanel120 = new javax.swing.JPanel();
        jPanel122 = new javax.swing.JPanel();
        jLabel121 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        tableTKCTHD_NV = new javax.swing.JTable();
        jPanel123 = new javax.swing.JPanel();
        btnLast_NV = new javax.swing.JLabel();
        btnFirst_NV = new javax.swing.JLabel();
        btnPrevious_NV = new javax.swing.JLabel();
        btnNext_NV = new javax.swing.JLabel();
        txbPage_NV = new javax.swing.JLabel();
        dateTKNBD_NV = new com.toedter.calendar.JDateChooser();
        dateTKNKT_NV = new com.toedter.calendar.JDateChooser();
        jToolBar8 = new javax.swing.JToolBar();
        jPanel98 = new javax.swing.JPanel();
        jPanel99 = new javax.swing.JPanel();
        jTextField23 = new javax.swing.JTextField();
        jLabel126 = new javax.swing.JLabel();
        jPanel100 = new javax.swing.JPanel();
        jLabel127 = new javax.swing.JLabel();
        jPanel101 = new javax.swing.JPanel();
        jLabel128 = new javax.swing.JLabel();
        jPanel102 = new javax.swing.JPanel();
        jLabel129 = new javax.swing.JLabel();
        jToolBarQuanLy = new javax.swing.JToolBar();
        jPanel25 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jToolBar6 = new javax.swing.JToolBar();
        jPanel27 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        cbMaNV = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        txbTenDangNhap = new javax.swing.JTextField();
        cbTenNV = new javax.swing.JComboBox<>();
        cbTrangThai = new javax.swing.JComboBox<>();
        jPanel32 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        rdoQuanTri = new javax.swing.JRadioButton();
        rdoNhanVien = new javax.swing.JRadioButton();
        jPanel34 = new javax.swing.JPanel();
        btnResetPass = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        btnThemTK = new javax.swing.JButton();
        btnXoaTK = new javax.swing.JButton();
        btnSuaTK = new javax.swing.JButton();
        btnLoadTK = new javax.swing.JButton();
        btnSaveTK = new javax.swing.JButton();
        btnHuyTK = new javax.swing.JButton();
        jPanel29 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableDSTK = new javax.swing.JTable();
        jToolBar9 = new javax.swing.JToolBar();
        jPanel37 = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        jPanel38 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        txbMaNV = new javax.swing.JTextField();
        txbDiaChiNV = new javax.swing.JTextField();
        txbSDTNV = new javax.swing.JTextField();
        txbLCB = new javax.swing.JTextField();
        jPanel48 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        txbSoCa = new javax.swing.JLabel();
        txbTongLuong = new javax.swing.JLabel();
        cbSex = new javax.swing.JComboBox<>();
        dateNgaySinh = new com.toedter.calendar.JDateChooser();
        dateNgayVaoLam = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        txbHoTenNV = new javax.swing.JTextField();
        jPanel39 = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        btnThemNV = new javax.swing.JButton();
        btnXoaNV = new javax.swing.JButton();
        btnSuaNV = new javax.swing.JButton();
        btnLoadNV = new javax.swing.JButton();
        btnHuyNV = new javax.swing.JButton();
        btnLuuNV = new javax.swing.JButton();
        jPanel40 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        txbSearchNV = new javax.swing.JTextField();
        jPanel41 = new javax.swing.JPanel();
        jPanel46 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        cbLuongSearch = new javax.swing.JComboBox<>();
        cbSexSearch = new javax.swing.JComboBox<>();
        jPanel42 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tableDSNV = new javax.swing.JTable();
        jToolBar11 = new javax.swing.JToolBar();
        jPanel57 = new javax.swing.JPanel();
        jPanel58 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jPanel59 = new javax.swing.JPanel();
        jPanel66 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        txbSearchLMA = new javax.swing.JTextField();
        jPanel60 = new javax.swing.JPanel();
        jPanel65 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        cbTenLoaiMonAn = new javax.swing.JComboBox<>();
        jPanel61 = new javax.swing.JPanel();
        jPanel67 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tableDSLoaiMonAn = new javax.swing.JTable();
        jPanel62 = new javax.swing.JPanel();
        jPanel68 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tableDSMonAnTheoLoai = new javax.swing.JTable();
        jPanel63 = new javax.swing.JPanel();
        jPanel64 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        btnThemLMA = new javax.swing.JButton();
        btnXoaLMA = new javax.swing.JButton();
        btnSuaLMA = new javax.swing.JButton();
        btnLoadLMA = new javax.swing.JButton();
        btnLuuLMA = new javax.swing.JButton();
        btnHuyLMA = new javax.swing.JButton();
        jToolBar12 = new javax.swing.JToolBar();
        jPanel78 = new javax.swing.JPanel();
        jPanel79 = new javax.swing.JPanel();
        jLabel104 = new javax.swing.JLabel();
        jPanel80 = new javax.swing.JPanel();
        jPanel84 = new javax.swing.JPanel();
        jLabel108 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        txbMaMonAn = new javax.swing.JTextField();
        txbGia = new javax.swing.JTextField();
        txbDVT = new javax.swing.JTextField();
        txbTenMonAn = new javax.swing.JTextField();
        cbLoaiMon = new javax.swing.JComboBox<>();
        jPanel81 = new javax.swing.JPanel();
        txbAnh = new javax.swing.JTextField();
        txbChonAnh = new javax.swing.JLabel();
        imgHinh = new javax.swing.JLabel();
        jPanel82 = new javax.swing.JPanel();
        jPanel85 = new javax.swing.JPanel();
        jLabel109 = new javax.swing.JLabel();
        btnThemMonAn = new javax.swing.JButton();
        btnXoaMonAn = new javax.swing.JButton();
        btnSuaMonAn = new javax.swing.JButton();
        btnLoadMonAn = new javax.swing.JButton();
        btnLuuMonAn = new javax.swing.JButton();
        btnHuyMonAn = new javax.swing.JButton();
        jPanel83 = new javax.swing.JPanel();
        jPanel86 = new javax.swing.JPanel();
        jLabel107 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tableMonAn = new javax.swing.JTable();
        jToolBar13 = new javax.swing.JToolBar();
        jPanel69 = new javax.swing.JPanel();
        jPanel70 = new javax.swing.JPanel();
        jLabel85 = new javax.swing.JLabel();
        jPanel71 = new javax.swing.JPanel();
        jPanel74 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        txbSoChoNgoi = new javax.swing.JTextField();
        txbMaBan = new javax.swing.JTextField();
        cbTrangThaiBan = new javax.swing.JComboBox<>();
        txbKhuVuc = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jPanel72 = new javax.swing.JPanel();
        jPanel75 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        jPanel77 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jpanelDSBan = new javax.swing.JPanel();
        jPanel73 = new javax.swing.JPanel();
        jPanel76 = new javax.swing.JPanel();
        jLabel88 = new javax.swing.JLabel();
        btnThemBan = new javax.swing.JButton();
        btnXoaBan = new javax.swing.JButton();
        btnSuaBan = new javax.swing.JButton();
        btnHuyBan = new javax.swing.JButton();
        btnLuuBan = new javax.swing.JButton();
        btnLoadBan = new javax.swing.JButton();
        jToolBar10 = new javax.swing.JToolBar();
        jPanel103 = new javax.swing.JPanel();
        jTextField24 = new javax.swing.JTextField();
        jPanel104 = new javax.swing.JPanel();
        jPanel110 = new javax.swing.JPanel();
        jLabel130 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        cbCTTenNguyenLieu = new javax.swing.JComboBox<>();
        cbCTTenMonAn = new javax.swing.JComboBox<>();
        txbHamLuong = new javax.swing.JTextField();
        jLabel145 = new javax.swing.JLabel();
        txbCTDVT = new javax.swing.JTextField();
        jPanel105 = new javax.swing.JPanel();
        jPanel111 = new javax.swing.JPanel();
        jLabel131 = new javax.swing.JLabel();
        btnThemCT = new javax.swing.JButton();
        btnXoaCT = new javax.swing.JButton();
        btnSuaCT = new javax.swing.JButton();
        btnLoadCT = new javax.swing.JButton();
        btnLuuCT = new javax.swing.JButton();
        btnHuyCT = new javax.swing.JButton();
        jPanel106 = new javax.swing.JPanel();
        jPanel112 = new javax.swing.JPanel();
        jLabel132 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        txbMaNL = new javax.swing.JTextField();
        txbTenNL = new javax.swing.JTextField();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jPanel107 = new javax.swing.JPanel();
        jPanel113 = new javax.swing.JPanel();
        jLabel133 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tableDSCT = new javax.swing.JTable();
        jPanel108 = new javax.swing.JPanel();
        jPanel114 = new javax.swing.JPanel();
        jLabel134 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tableNguyenLieu = new javax.swing.JTable();
        jPanel109 = new javax.swing.JPanel();
        jPanel115 = new javax.swing.JPanel();
        jLabel135 = new javax.swing.JLabel();
        btnThemNL = new javax.swing.JButton();
        btnXoaNL = new javax.swing.JButton();
        btnSuaNL = new javax.swing.JButton();
        btnLoadNL = new javax.swing.JButton();
        btnLuuNL = new javax.swing.JButton();
        btnHuyNL = new javax.swing.JButton();
        jToolBar16 = new javax.swing.JToolBar();
        jPanel117 = new javax.swing.JPanel();
        jPanel118 = new javax.swing.JPanel();
        jLabel116 = new javax.swing.JLabel();
        cb_TenNguyenLieu_PN = new javax.swing.JComboBox<>();
        jLabel117 = new javax.swing.JLabel();
        txbSoLuongPN = new javax.swing.JTextField();
        jScrollPane17 = new javax.swing.JScrollPane();
        table_dsNhaCungCap = new javax.swing.JTable();
        jLabel151 = new javax.swing.JLabel();
        txbDonGiaPN = new javax.swing.JTextField();
        jLabel152 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        txbThanhTienPN = new javax.swing.JTextField();
        btnChuyen = new javax.swing.JButton();
        jLabel118 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        jdc_NgNhap = new com.toedter.calendar.JDateChooser();
        btnThemPhieu = new javax.swing.JButton();
        btnHuyPhieu = new javax.swing.JButton();
        jTextField30 = new javax.swing.JTextField();
        jPanel121 = new javax.swing.JPanel();
        jTextField35 = new javax.swing.JTextField();
        jScrollPane18 = new javax.swing.JScrollPane();
        tableDsPhieuNhap = new javax.swing.JTable();
        btnXuatPhieu = new javax.swing.JButton();
        jLabel155 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        txbMaPhieuCanTim = new javax.swing.JTextField();
        btnTimPhieu = new javax.swing.JButton();
        jPanel119 = new javax.swing.JPanel();
        jTextField36 = new javax.swing.JTextField();
        jScrollPane19 = new javax.swing.JScrollPane();
        table_CTPN = new javax.swing.JTable();
        btnTaoPhieu = new javax.swing.JButton();
        jLabel157 = new javax.swing.JLabel();
        txbTongTienPN = new javax.swing.JTextField();
        btnXoa = new javax.swing.JButton();
        jdc_NgNhap_PN = new com.toedter.calendar.JDateChooser();
        jLabel158 = new javax.swing.JLabel();
        txbNhaCungCap = new javax.swing.JTextField();
        jToolBarThongKe = new javax.swing.JToolBar();
        jPanel116 = new javax.swing.JPanel();
        toolbarchart = new javax.swing.JTabbedPane();
        jToolBar5 = new javax.swing.JToolBar();
        jPanel87 = new javax.swing.JPanel();
        jPanel88 = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        txbDoanhThu = new javax.swing.JTextField();
        jPanel89 = new javax.swing.JPanel();
        jPanel90 = new javax.swing.JPanel();
        jLabel105 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableTKDSHD = new javax.swing.JTable();
        jPanel91 = new javax.swing.JPanel();
        jPanel92 = new javax.swing.JPanel();
        jLabel106 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        tableTKCTHD = new javax.swing.JTable();
        jPanel93 = new javax.swing.JPanel();
        btnLast = new javax.swing.JLabel();
        btnFirst = new javax.swing.JLabel();
        btnPrevious = new javax.swing.JLabel();
        btnNext = new javax.swing.JLabel();
        txbPage = new javax.swing.JLabel();
        dateTKNBD = new com.toedter.calendar.JDateChooser();
        dateTKNKT = new com.toedter.calendar.JDateChooser();
        jLabel45 = new javax.swing.JLabel();
        cbTKTenNV = new javax.swing.JComboBox<>();
        btnChartDoanhThu = new javax.swing.JButton();
        jToolBar15 = new javax.swing.JToolBar();
        jToolBar14 = new javax.swing.JToolBar();
        jPanel26 = new javax.swing.JPanel();
        panelChart = new javax.swing.JPanel();
        jLabel115 = new javax.swing.JLabel();
        txbDoanhThuChart = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 204));
        setUndecorated(true);
        setResizable(false);

        jLabelRoles.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelRoles.setForeground(new java.awt.Color(51, 51, 51));
        jLabelRoles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/t1.png"))); // NOI18N
        jLabelRoles.setText("admin");

        jLabelThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/exit.png"))); // NOI18N
        jLabelThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelThoatMouseClicked(evt);
            }
        });

        jTabbedPane1.setForeground(new java.awt.Color(51, 51, 51));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jToolBarHeThong.setRollover(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jTabbedPane2.setBackground(new java.awt.Color(204, 255, 255));
        jTabbedPane2.setForeground(new java.awt.Color(0, 0, 0));
        jTabbedPane2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jToolBar4.setRollover(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "Thông tin bàn ăn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(0, 51, 153))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 204, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelChooseDish.setBackground(new java.awt.Color(255, 255, 255));
        jLabelChooseDish.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelChooseDish.setForeground(new java.awt.Color(0, 0, 0));
        jLabelChooseDish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-plus-40.png"))); // NOI18N
        jLabelChooseDish.setText("Chọn món");
        jLabelChooseDish.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jLabelChooseDish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLabelChooseDishActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelChooseDish, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelChooseDish, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-return-50.png"))); // NOI18N
        jLabel3.setText("Trả lại");
        jLabel3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLabel3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelSwitchTable.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSwitchTable.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelSwitchTable.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSwitchTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-convert-40.png"))); // NOI18N
        jLabelSwitchTable.setText("Chuyển bàn");
        jLabelSwitchTable.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jLabelSwitchTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLabelSwitchTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelSwitchTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelSwitchTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelCombineTable.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCombineTable.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelCombineTable.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCombineTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-gather-50.png"))); // NOI18N
        jLabelCombineTable.setText("Gộp bàn");
        jLabelCombineTable.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jLabelCombineTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLabelCombineTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelCombineTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelCombineTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelOrderTable.setBackground(new java.awt.Color(255, 255, 255));
        jLabelOrderTable.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelOrderTable.setForeground(new java.awt.Color(0, 0, 0));
        jLabelOrderTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/l1.png"))); // NOI18N
        jLabelOrderTable.setText("Đặt bàn");
        jLabelOrderTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLabelOrderTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelOrderTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelOrderTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/l1.png"))); // NOI18N
        jLabel13.setText("Danh Sách Bàn");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanelTables.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Sảnh", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 24), new java.awt.Color(0, 102, 204))); // NOI18N

        javax.swing.GroupLayout jPanelTablesLayout = new javax.swing.GroupLayout(jPanelTables);
        jPanelTables.setLayout(jPanelTablesLayout);
        jPanelTablesLayout.setHorizontalGroup(
            jPanelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelTablesLayout.setVerticalGroup(
            jPanelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTables, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelTables, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/checklist.png"))); // NOI18N
        jLabel14.setText("Chi Tiết Đặt Bàn");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelCancelOrder.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCancelOrder.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelCancelOrder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCancelOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-cancel-50.png"))); // NOI18N
        jLabelCancelOrder.setText("Hủy");
        jLabelCancelOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCancelOrderMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelCancelOrder, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelCancelOrder, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
        );

        jTableBillDetails.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTableBillDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tên món", "SL", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableBillDetails.setRowHeight(40);
        jScrollPane1.setViewportView(jTableBillDetails);

        jTextAreaOrderInfor.setEditable(false);
        jTextAreaOrderInfor.setBackground(new java.awt.Color(102, 203, 255));
        jTextAreaOrderInfor.setColumns(20);
        jTextAreaOrderInfor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextAreaOrderInfor.setForeground(new java.awt.Color(0, 0, 0));
        jTextAreaOrderInfor.setLineWrap(true);
        jTextAreaOrderInfor.setRows(5);
        jTextAreaOrderInfor.setText("Không có thông tin");
        jScrollPane15.setViewportView(jTextAreaOrderInfor);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 16, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTextFieldSelectedTable.setBackground(new java.awt.Color(0, 204, 102));
        jTextFieldSelectedTable.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextFieldSelectedTable.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldSelectedTable.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldSelectedTable.setText("Chưa chọn bàn");

        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-budgeting-32.png"))); // NOI18N
        jLabel12.setText("Tính Tiền");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("Tổng Tiền:");

        jLabelWordTotal.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabelWordTotal.setForeground(new java.awt.Color(0, 0, 0));
        jLabelWordTotal.setText("Bằng chữ: ...............................");

        jLabelTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelTotal.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTotal.setText("0");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-invoice-24.png"))); // NOI18N
        jLabel10.setText("In");
        jLabel10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLabel10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelWordTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jLabelTotal))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelWordTotal)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldSelectedTable)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldSelectedTable)
                            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 151, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jToolBar4.add(jPanel2);

        jTabbedPane2.addTab("Trang Chủ", jToolBar4);

        toolbarDoiMK.setRollover(true);
        toolbarDoiMK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                toolbarDoiMKMouseClicked(evt);
            }
        });

        jPanel49.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1426, Short.MAX_VALUE)
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 718, Short.MAX_VALUE)
        );

        toolbarDoiMK.add(jPanel49);

        jTabbedPane2.addTab("Đổi Mật Khẩu", toolbarDoiMK);

        jToolBar7.setRollover(true);

        jPanel95.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jTextField7.setBackground(new java.awt.Color(0, 102, 102));
        jTextField7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(0, 0, 0));
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setText("THỐNG KÊ HÓA ĐƠN");

        jLabel66.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(0, 0, 0));
        jLabel66.setText("Ngày bắt đầu");

        jLabel67.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(0, 0, 0));
        jLabel67.setText("Ngày kết thúc");

        jLabel119.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(0, 0, 0));
        jLabel119.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel119.setText("Doanh thu");

        txbDoanhThu_NV.setEditable(false);
        txbDoanhThu_NV.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txbDoanhThu_NV.setForeground(new java.awt.Color(0, 0, 0));

        jPanel96.setBackground(new java.awt.Color(255, 255, 255));
        jPanel96.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel97.setBackground(new java.awt.Color(204, 204, 204));

        jLabel120.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel120.setForeground(new java.awt.Color(51, 51, 51));
        jLabel120.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/list_3176366.png"))); // NOI18N
        jLabel120.setText("Danh sách hóa đơn");

        javax.swing.GroupLayout jPanel97Layout = new javax.swing.GroupLayout(jPanel97);
        jPanel97.setLayout(jPanel97Layout);
        jPanel97Layout.setHorizontalGroup(
            jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel97Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel120)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel97Layout.setVerticalGroup(
            jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel97Layout.createSequentialGroup()
                .addComponent(jLabel120, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        tableTKDSHD_NV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tableTKDSHD_NV.setForeground(new java.awt.Color(0, 51, 51));
        tableTKDSHD_NV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã HD", "Tên bàn", "Tên NV", "Ngày vào", "Ngày ra", "Tổng (VAT 10%)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTKDSHD_NV.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableTKDSHD_NV.setRowHeight(40);
        tableTKDSHD_NV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTKDSHD_NVMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tableTKDSHD_NV);

        javax.swing.GroupLayout jPanel96Layout = new javax.swing.GroupLayout(jPanel96);
        jPanel96.setLayout(jPanel96Layout);
        jPanel96Layout.setHorizontalGroup(
            jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel97, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel96Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6)
                .addContainerGap())
        );
        jPanel96Layout.setVerticalGroup(
            jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel96Layout.createSequentialGroup()
                .addComponent(jPanel97, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel120.setBackground(new java.awt.Color(255, 255, 255));
        jPanel120.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel122.setBackground(new java.awt.Color(204, 204, 204));

        jLabel121.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(51, 51, 51));
        jLabel121.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/list_3176366.png"))); // NOI18N
        jLabel121.setText("Danh sách món ăn");

        javax.swing.GroupLayout jPanel122Layout = new javax.swing.GroupLayout(jPanel122);
        jPanel122.setLayout(jPanel122Layout);
        jPanel122Layout.setHorizontalGroup(
            jPanel122Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel122Layout.createSequentialGroup()
                .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel122Layout.setVerticalGroup(
            jPanel122Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel122Layout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tableTKCTHD_NV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tableTKCTHD_NV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Món ăn", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTKCTHD_NV.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableTKCTHD_NV.setRowHeight(40);
        jScrollPane20.setViewportView(tableTKCTHD_NV);

        javax.swing.GroupLayout jPanel120Layout = new javax.swing.GroupLayout(jPanel120);
        jPanel120.setLayout(jPanel120Layout);
        jPanel120Layout.setHorizontalGroup(
            jPanel120Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel122, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel120Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane20, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel120Layout.setVerticalGroup(
            jPanel120Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel120Layout.createSequentialGroup()
                .addComponent(jPanel122, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane20)
                .addContainerGap())
        );

        btnLast_NV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnLast_NV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-next-50.png"))); // NOI18N
        btnLast_NV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLast_NVMouseClicked(evt);
            }
        });

        btnFirst_NV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnFirst_NV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-back-to-50.png"))); // NOI18N
        btnFirst_NV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFirst_NVMouseClicked(evt);
            }
        });

        btnPrevious_NV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPrevious_NV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-back-50.png"))); // NOI18N
        btnPrevious_NV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrevious_NVMouseClicked(evt);
            }
        });

        btnNext_NV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNext_NV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-next-page-50.png"))); // NOI18N
        btnNext_NV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNext_NVMouseClicked(evt);
            }
        });

        txbPage_NV.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        txbPage_NV.setForeground(new java.awt.Color(0, 0, 0));
        txbPage_NV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txbPage_NV.setText("1");

        javax.swing.GroupLayout jPanel123Layout = new javax.swing.GroupLayout(jPanel123);
        jPanel123.setLayout(jPanel123Layout);
        jPanel123Layout.setHorizontalGroup(
            jPanel123Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel123Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(btnFirst_NV)
                .addGap(70, 70, 70)
                .addComponent(btnPrevious_NV)
                .addGap(91, 91, 91)
                .addComponent(txbPage_NV, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(btnNext_NV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLast_NV)
                .addGap(69, 69, 69))
        );
        jPanel123Layout.setVerticalGroup(
            jPanel123Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel123Layout.createSequentialGroup()
                .addGroup(jPanel123Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFirst_NV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLast_NV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPrevious_NV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNext_NV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txbPage_NV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        dateTKNBD_NV.setDateFormatString("dd/MM/yyyy");
        dateTKNBD_NV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        dateTKNKT_NV.setDateFormatString("dd/MM/yyyy");
        dateTKNKT_NV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel95Layout = new javax.swing.GroupLayout(jPanel95);
        jPanel95.setLayout(jPanel95Layout);
        jPanel95Layout.setHorizontalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField7)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel95Layout.createSequentialGroup()
                .addGroup(jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel95Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel123, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel96, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel95Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel66)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateTKNBD_NV, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateTKNKT_NV, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel95Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel119, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txbDoanhThu_NV, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel95Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel120, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel95Layout.setVerticalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel95Layout.createSequentialGroup()
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel95Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(dateTKNKT_NV, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel95Layout.createSequentialGroup()
                        .addComponent(dateTKNBD_NV, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel96, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel120, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel95Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel123, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel95Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txbDoanhThu_NV)
                            .addComponent(jLabel119))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel94Layout = new javax.swing.GroupLayout(jPanel94);
        jPanel94.setLayout(jPanel94Layout);
        jPanel94Layout.setHorizontalGroup(
            jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel95, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel94Layout.setVerticalGroup(
            jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel94Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel95, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1426, Short.MAX_VALUE)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel94, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 718, Short.MAX_VALUE)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel94, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jToolBar7.add(jPanel18);

        jTabbedPane2.addTab("Doanh Thu", jToolBar7);

        jToolBar8.setRollover(true);

        jPanel98.setBackground(new java.awt.Color(255, 204, 204));

        jPanel99.setBackground(new java.awt.Color(153, 204, 255));
        jPanel99.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jTextField23.setEditable(false);
        jTextField23.setBackground(new java.awt.Color(255, 255, 255));
        jTextField23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField23.setForeground(new java.awt.Color(51, 51, 51));
        jTextField23.setText("Thông báo");

        jLabel126.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel126.setForeground(new java.awt.Color(0, 0, 0));
        jLabel126.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel126.setText("THÔNG BÁO");

        jPanel100.setBackground(new java.awt.Color(204, 204, 204));

        jLabel127.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel127.setForeground(new java.awt.Color(0, 0, 0));
        jLabel127.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel127.setText("Bạn có muốn đăng xuất không?");

        jPanel101.setBackground(new java.awt.Color(255, 255, 255));
        jPanel101.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));

        jLabel128.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(0, 0, 0));
        jLabel128.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel128.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/ok1.png"))); // NOI18N
        jLabel128.setText("Có");
        jLabel128.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel128MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel101Layout = new javax.swing.GroupLayout(jPanel101);
        jPanel101.setLayout(jPanel101Layout);
        jPanel101Layout.setHorizontalGroup(
            jPanel101Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel128, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
        );
        jPanel101Layout.setVerticalGroup(
            jPanel101Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel101Layout.createSequentialGroup()
                .addComponent(jLabel128, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel102.setBackground(new java.awt.Color(255, 255, 255));
        jPanel102.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));

        jLabel129.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel129.setForeground(new java.awt.Color(0, 0, 0));
        jLabel129.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel129.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-cancel-32.png"))); // NOI18N
        jLabel129.setText("Không");
        jLabel129.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel129MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel102Layout = new javax.swing.GroupLayout(jPanel102);
        jPanel102.setLayout(jPanel102Layout);
        jPanel102Layout.setHorizontalGroup(
            jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel129, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
        );
        jPanel102Layout.setVerticalGroup(
            jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel102Layout.createSequentialGroup()
                .addComponent(jLabel129, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel100Layout = new javax.swing.GroupLayout(jPanel100);
        jPanel100.setLayout(jPanel100Layout);
        jPanel100Layout.setHorizontalGroup(
            jPanel100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel127, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel100Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jPanel101, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jPanel102, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel100Layout.setVerticalGroup(
            jPanel100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel100Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel127, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel101, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel102, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel99Layout = new javax.swing.GroupLayout(jPanel99);
        jPanel99.setLayout(jPanel99Layout);
        jPanel99Layout.setHorizontalGroup(
            jPanel99Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField23)
            .addComponent(jLabel126, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel99Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel100, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel99Layout.setVerticalGroup(
            jPanel99Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel99Layout.createSequentialGroup()
                .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel126)
                .addGap(18, 18, 18)
                .addComponent(jPanel100, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel98Layout = new javax.swing.GroupLayout(jPanel98);
        jPanel98.setLayout(jPanel98Layout);
        jPanel98Layout.setHorizontalGroup(
            jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel98Layout.createSequentialGroup()
                .addGap(382, 382, 382)
                .addComponent(jPanel99, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(564, Short.MAX_VALUE))
        );
        jPanel98Layout.setVerticalGroup(
            jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel98Layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jPanel99, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(248, Short.MAX_VALUE))
        );

        jToolBar8.add(jPanel98);

        jTabbedPane2.addTab("Đăng xuất", jToolBar8);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        jToolBarHeThong.add(jPanel1);

        jTabbedPane1.addTab("Hệ Thống", jToolBarHeThong);

        jToolBarQuanLy.setRollover(true);
        jToolBarQuanLy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jPanel25.setBackground(new java.awt.Color(204, 255, 204));

        jTabbedPane3.setBackground(new java.awt.Color(255, 204, 153));
        jTabbedPane3.setForeground(new java.awt.Color(0, 0, 0));
        jTabbedPane3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jToolBar6.setRollover(true);

        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "Quản lý tài khoản", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 153))); // NOI18N

        jPanel30.setBackground(new java.awt.Color(153, 153, 153));
        jPanel30.setForeground(new java.awt.Color(204, 204, 204));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 0, 0));
        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-person-32.png"))); // NOI18N
        jLabel39.setText("Thông tin tài khoản");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 0, 0));
        jLabel40.setText("Mã nhân viên");

        cbMaNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbMaNV.setForeground(new java.awt.Color(0, 0, 0));
        cbMaNV.setEnabled(false);

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 0, 0));
        jLabel41.setText("Tên đăng nhập");

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 0, 0));
        jLabel42.setText("Tên nhân viên");

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 0, 0));
        jLabel43.setText("Trạng thái");

        txbTenDangNhap.setEditable(false);
        txbTenDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txbTenDangNhap.setForeground(new java.awt.Color(0, 0, 0));

        cbTenNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbTenNV.setForeground(new java.awt.Color(0, 0, 0));
        cbTenNV.setEnabled(false);

        cbTrangThai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbTrangThai.setForeground(new java.awt.Color(0, 0, 0));
        cbTrangThai.setEnabled(false);

        jPanel32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jPanel33.setBackground(new java.awt.Color(153, 153, 153));

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 0, 0));
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-admin-50.png"))); // NOI18N
        jLabel44.setText("Cấp quyền");

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        buttonGroupQuyen.add(rdoQuanTri);
        rdoQuanTri.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        rdoQuanTri.setForeground(new java.awt.Color(51, 51, 51));
        rdoQuanTri.setText("Quản trị");

        buttonGroupQuyen.add(rdoNhanVien);
        rdoNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        rdoNhanVien.setForeground(new java.awt.Color(51, 51, 51));
        rdoNhanVien.setText("Nhân viên");

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(rdoQuanTri, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rdoNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoQuanTri)
                    .addComponent(rdoNhanVien))
                .addGap(0, 18, Short.MAX_VALUE))
        );

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));
        jPanel34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 2));

        btnResetPass.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnResetPass.setForeground(new java.awt.Color(0, 0, 0));
        btnResetPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnResetPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/up.png"))); // NOI18N
        btnResetPass.setText("Đặt lại mật khẩu");
        btnResetPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetPassMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnResetPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(39, 39, 39))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnResetPass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        jPanel35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jPanel36.setBackground(new java.awt.Color(153, 153, 153));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 0, 0));
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-setting-50.png"))); // NOI18N
        jLabel46.setText("Xử lý");

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE)
        );

        btnThemTK.setBackground(new java.awt.Color(204, 255, 255));
        btnThemTK.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThemTK.setForeground(new java.awt.Color(0, 0, 0));
        btnThemTK.setText("Thêm");
        btnThemTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemTKActionPerformed(evt);
            }
        });

        btnXoaTK.setBackground(new java.awt.Color(204, 204, 255));
        btnXoaTK.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoaTK.setForeground(new java.awt.Color(0, 0, 0));
        btnXoaTK.setText("Xóa");
        btnXoaTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaTKMouseClicked(evt);
            }
        });

        btnSuaTK.setBackground(new java.awt.Color(255, 204, 204));
        btnSuaTK.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSuaTK.setForeground(new java.awt.Color(0, 0, 0));
        btnSuaTK.setText("Sửa");
        btnSuaTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaTKMouseClicked(evt);
            }
        });

        btnLoadTK.setBackground(new java.awt.Color(255, 255, 204));
        btnLoadTK.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLoadTK.setForeground(new java.awt.Color(0, 0, 0));
        btnLoadTK.setText("Tải lại");
        btnLoadTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoadTKMouseClicked(evt);
            }
        });

        btnSaveTK.setBackground(new java.awt.Color(204, 255, 204));
        btnSaveTK.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSaveTK.setForeground(new java.awt.Color(0, 0, 0));
        btnSaveTK.setText("Lưu");
        btnSaveTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveTKActionPerformed(evt);
            }
        });

        btnHuyTK.setBackground(new java.awt.Color(255, 102, 102));
        btnHuyTK.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnHuyTK.setForeground(new java.awt.Color(0, 0, 0));
        btnHuyTK.setText("Hủy");
        btnHuyTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHuyTKMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnThemTK, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoadTK, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoaTK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveTK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSuaTK, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyTK, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemTK, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaTK, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaTK, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoadTK, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveTK, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyTK, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbMaNV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txbTenDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                            .addComponent(cbTenNV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbTrangThai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 17, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                        .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                        .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84))))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(txbTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(cbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(3, 3, 3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel29.setForeground(new java.awt.Color(0, 0, 0));

        jPanel31.setBackground(new java.awt.Color(153, 153, 153));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 0));
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/l1.png"))); // NOI18N
        jLabel38.setText("Danh sách tài khoản");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        tableDSTK.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tableDSTK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tên đăng nhập", "Mã thành viên", "Tên hiển thị", "Cấp quyền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDSTK.setRowHeight(40);
        tableDSTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDSTKMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tableDSTK);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jToolBar6.add(jPanel27);

        jTabbedPane3.addTab("Tài Khoản", jToolBar6);

        jToolBar9.setRollover(true);

        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "Quản lý nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(0, 0, 153))); // NOI18N

        jTextField6.setBackground(new java.awt.Color(204, 153, 255));
        jTextField6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(0, 0, 0));
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setText("QUẢN LÝ NHÂN VIÊN");

        jPanel38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jPanel43.setBackground(new java.awt.Color(204, 204, 204));

        jLabel54.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(0, 0, 0));
        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-admin-50.png"))); // NOI18N
        jLabel54.setText("Thông tin nhân viên");

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel54)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE)
        );

        jLabel55.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(0, 0, 0));
        jLabel55.setText("Mã nhân viên");

        jLabel56.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(0, 0, 0));
        jLabel56.setText("Giới tính");

        jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(0, 0, 0));
        jLabel57.setText("Ngày sinh");

        jLabel58.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 0, 0));
        jLabel58.setText("Địa chỉ");

        jLabel59.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(0, 0, 0));
        jLabel59.setText("SĐT");

        jLabel60.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(0, 0, 0));
        jLabel60.setText("Ngày vào làm");

        jLabel61.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(0, 0, 0));
        jLabel61.setText("Lương cơ bản");

        txbMaNV.setEditable(false);
        txbMaNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txbMaNV.setForeground(new java.awt.Color(0, 0, 0));

        txbDiaChiNV.setEditable(false);
        txbDiaChiNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txbDiaChiNV.setForeground(new java.awt.Color(0, 0, 0));

        txbSDTNV.setEditable(false);
        txbSDTNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txbSDTNV.setForeground(new java.awt.Color(0, 0, 0));

        txbLCB.setEditable(false);
        txbLCB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txbLCB.setForeground(new java.awt.Color(0, 0, 0));

        jPanel48.setBackground(new java.awt.Color(255, 255, 204));
        jPanel48.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thông tin lương", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanel48.setForeground(new java.awt.Color(0, 0, 0));

        jLabel62.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(0, 0, 0));
        jLabel62.setText("Tổng ca (Tháng): ");

        jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(0, 0, 0));
        jLabel63.setText("Tổng tiền:");

        txbSoCa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txbSoCa.setForeground(new java.awt.Color(0, 0, 0));
        txbSoCa.setText("0 ca");

        txbTongLuong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txbTongLuong.setForeground(new java.awt.Color(0, 0, 0));
        txbTongLuong.setText("0 VND");

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txbTongLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addComponent(jLabel62)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txbSoCa)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(txbSoCa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txbTongLuong)
                    .addComponent(jLabel63))
                .addGap(0, 24, Short.MAX_VALUE))
        );

        cbSex.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        dateNgaySinh.setDateFormatString("dd/MM/yyyy");
        dateNgaySinh.setEnabled(false);
        dateNgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        dateNgayVaoLam.setDateFormatString("dd/MM/yyyy");
        dateNgayVaoLam.setEnabled(false);
        dateNgayVaoLam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Họ tên");

        txbHoTenNV.setEditable(false);
        txbHoTenNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txbDiaChiNV, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txbSDTNV, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txbLCB, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSex, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateNgayVaoLam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel55, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txbMaNV)
                            .addComponent(txbHoTenNV))))
                .addContainerGap())
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txbMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txbHoTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSex, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txbDiaChiNV, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(txbSDTNV)
                        .addGap(1, 1, 1))
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateNgayVaoLam, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txbLCB, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jPanel44.setBackground(new java.awt.Color(204, 204, 204));

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 0, 0));
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-setting-50.png"))); // NOI18N
        jLabel47.setText("Xử lý");

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel47)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnThemNV.setBackground(new java.awt.Color(204, 255, 204));
        btnThemNV.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThemNV.setForeground(new java.awt.Color(0, 0, 0));
        btnThemNV.setText("Thêm");
        btnThemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNVActionPerformed(evt);
            }
        });

        btnXoaNV.setBackground(new java.awt.Color(255, 255, 204));
        btnXoaNV.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoaNV.setForeground(new java.awt.Color(0, 0, 0));
        btnXoaNV.setText("Xóa");
        btnXoaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNVActionPerformed(evt);
            }
        });

        btnSuaNV.setBackground(new java.awt.Color(255, 204, 204));
        btnSuaNV.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSuaNV.setForeground(new java.awt.Color(0, 0, 0));
        btnSuaNV.setText("Sửa");
        btnSuaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaNVActionPerformed(evt);
            }
        });

        btnLoadNV.setBackground(new java.awt.Color(204, 204, 255));
        btnLoadNV.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLoadNV.setForeground(new java.awt.Color(0, 0, 0));
        btnLoadNV.setText("Tải lại");
        btnLoadNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadNVActionPerformed(evt);
            }
        });

        btnHuyNV.setBackground(new java.awt.Color(255, 102, 102));
        btnHuyNV.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnHuyNV.setForeground(new java.awt.Color(0, 0, 0));
        btnHuyNV.setText("Hủy");
        btnHuyNV.setEnabled(false);
        btnHuyNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyNVActionPerformed(evt);
            }
        });

        btnLuuNV.setBackground(new java.awt.Color(204, 255, 255));
        btnLuuNV.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLuuNV.setForeground(new java.awt.Color(0, 0, 0));
        btnLuuNV.setText("Lưu");
        btnLuuNV.setEnabled(false);
        btnLuuNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuNVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoaNV, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(btnSuaNV, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(btnLoadNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(btnHuyNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(btnLuuNV, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnXoaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnSuaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(btnLoadNV, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLuuNV, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnHuyNV, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jPanel40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jPanel45.setBackground(new java.awt.Color(204, 204, 204));

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 0, 0));
        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/sb.png"))); // NOI18N
        jLabel48.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel48)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(0, 0, 0));
        jLabel50.setText("Tên nhân viên");

        txbSearchNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txbSearchNV.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addComponent(jLabel50)
                        .addGap(0, 269, Short.MAX_VALUE))
                    .addComponent(txbSearchNV))
                .addContainerGap())
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txbSearchNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jPanel46.setBackground(new java.awt.Color(204, 204, 204));

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(0, 0, 0));
        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-filter-50.png"))); // NOI18N
        jLabel49.setText("Lọc");

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 0, 0));
        jLabel51.setText("Lương");

        jLabel52.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 0, 0));
        jLabel52.setText("Giới tính");

        cbLuongSearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbLuongSearch.setForeground(new java.awt.Color(0, 0, 0));
        cbLuongSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbSexSearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbSexSearch.setForeground(new java.awt.Color(0, 0, 0));
        cbSexSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel51)
                    .addComponent(cbLuongSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel52)
                    .addComponent(cbSexSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(jLabel52))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbLuongSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSexSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jPanel47.setBackground(new java.awt.Color(204, 204, 204));

        jLabel53.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(0, 0, 0));
        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/l1.png"))); // NOI18N
        jLabel53.setText("Danh sách nhân viên");

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel53)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane11.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane11.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tableDSNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tableDSNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã NV", "Họ tên", "Giới tính", "Ngày sinh", "Địa chỉ", "SĐT", "Ngày vào làm", "Lương cơ bản"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDSNV.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableDSNV.setRowHeight(40);
        tableDSNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDSNVMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tableDSNV);

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11)
                .addContainerGap())
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField6)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jToolBar9.add(jPanel37);

        jTabbedPane3.addTab("Nhân Viên", jToolBar9);

        jToolBar11.setRollover(true);

        jPanel57.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "Quản lý loại món ăn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(0, 0, 204))); // NOI18N

        jPanel58.setBackground(new java.awt.Color(255, 255, 153));

        jLabel77.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(0, 0, 0));
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel77.setText("QUẢN LÝ LOẠI MÓN");

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addComponent(jLabel77)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel59.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jPanel66.setBackground(new java.awt.Color(153, 153, 153));
        jPanel66.setForeground(new java.awt.Color(153, 153, 153));

        jLabel78.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(0, 0, 0));
        jLabel78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/checklist.png"))); // NOI18N
        jLabel78.setText("Thông tin loại món ăn");

        javax.swing.GroupLayout jPanel66Layout = new javax.swing.GroupLayout(jPanel66);
        jPanel66.setLayout(jPanel66Layout);
        jPanel66Layout.setHorizontalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel78)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel66Layout.setVerticalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jLabel83.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(0, 0, 0));
        jLabel83.setText("Tên loại món ăn");

        txbSearchLMA.setEditable(false);
        txbSearchLMA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txbSearchLMA.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txbSearchLMA, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addComponent(jPanel66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel83)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txbSearchLMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel60.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jPanel65.setBackground(new java.awt.Color(153, 153, 153));

        jLabel79.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(0, 0, 0));
        jLabel79.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/sb.png"))); // NOI18N
        jLabel79.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel65Layout.setVerticalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel84.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(0, 0, 0));
        jLabel84.setText("Tên loại món ăn");

        cbTenLoaiMonAn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbTenLoaiMonAn.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel60Layout = new javax.swing.GroupLayout(jPanel60);
        jPanel60.setLayout(jPanel60Layout);
        jPanel60Layout.setHorizontalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel60Layout.createSequentialGroup()
                        .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cbTenLoaiMonAn, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel60Layout.setVerticalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addComponent(jPanel65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTenLoaiMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel61.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jPanel67.setBackground(new java.awt.Color(153, 153, 153));

        jLabel81.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(0, 0, 0));
        jLabel81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/list_3176366.png"))); // NOI18N
        jLabel81.setText("Danh sách loại món ăn");

        javax.swing.GroupLayout jPanel67Layout = new javax.swing.GroupLayout(jPanel67);
        jPanel67.setLayout(jPanel67Layout);
        jPanel67Layout.setHorizontalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel81)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel67Layout.setVerticalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        tableDSLoaiMonAn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tableDSLoaiMonAn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã loại món ăn", "Tên loại món ăn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDSLoaiMonAn.setRowHeight(40);
        tableDSLoaiMonAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDSLoaiMonAnMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tableDSLoaiMonAn);

        javax.swing.GroupLayout jPanel61Layout = new javax.swing.GroupLayout(jPanel61);
        jPanel61.setLayout(jPanel61Layout);
        jPanel61Layout.setHorizontalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8)
                .addContainerGap())
        );
        jPanel61Layout.setVerticalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addComponent(jPanel67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        jPanel62.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jPanel68.setBackground(new java.awt.Color(153, 153, 153));

        jLabel82.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(0, 0, 0));
        jLabel82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/l1.png"))); // NOI18N
        jLabel82.setText("Danh sách được tìm kiếm");

        javax.swing.GroupLayout jPanel68Layout = new javax.swing.GroupLayout(jPanel68);
        jPanel68.setLayout(jPanel68Layout);
        jPanel68Layout.setHorizontalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel82)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel68Layout.setVerticalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel82, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        tableDSMonAnTheoLoai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tableDSMonAnTheoLoai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã món ăn", "Tên món ăn", "Đơn vị tính", "Đơn giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDSMonAnTheoLoai.setRowHeight(40);
        jScrollPane9.setViewportView(tableDSMonAnTheoLoai);

        javax.swing.GroupLayout jPanel62Layout = new javax.swing.GroupLayout(jPanel62);
        jPanel62.setLayout(jPanel62Layout);
        jPanel62Layout.setHorizontalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel62Layout.setVerticalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addComponent(jPanel68, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel63.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jPanel64.setBackground(new java.awt.Color(153, 153, 153));

        jLabel80.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(0, 0, 0));
        jLabel80.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-setting-50.png"))); // NOI18N
        jLabel80.setText("Xử lý");

        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(jPanel64);
        jPanel64.setLayout(jPanel64Layout);
        jPanel64Layout.setHorizontalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel64Layout.setVerticalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        btnThemLMA.setBackground(new java.awt.Color(204, 255, 204));
        btnThemLMA.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThemLMA.setForeground(new java.awt.Color(0, 0, 0));
        btnThemLMA.setText("Thêm");
        btnThemLMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemLMAActionPerformed(evt);
            }
        });

        btnXoaLMA.setBackground(new java.awt.Color(255, 255, 204));
        btnXoaLMA.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoaLMA.setForeground(new java.awt.Color(0, 0, 0));
        btnXoaLMA.setText("Xóa");
        btnXoaLMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaLMAActionPerformed(evt);
            }
        });

        btnSuaLMA.setBackground(new java.awt.Color(255, 204, 204));
        btnSuaLMA.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSuaLMA.setForeground(new java.awt.Color(0, 0, 0));
        btnSuaLMA.setText("Sửa");
        btnSuaLMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaLMAActionPerformed(evt);
            }
        });

        btnLoadLMA.setBackground(new java.awt.Color(204, 204, 255));
        btnLoadLMA.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLoadLMA.setForeground(new java.awt.Color(0, 0, 0));
        btnLoadLMA.setText("Tải lại");
        btnLoadLMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadLMAActionPerformed(evt);
            }
        });

        btnLuuLMA.setBackground(new java.awt.Color(204, 255, 255));
        btnLuuLMA.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLuuLMA.setForeground(new java.awt.Color(0, 0, 0));
        btnLuuLMA.setText("Lưu");
        btnLuuLMA.setEnabled(false);
        btnLuuLMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuLMAActionPerformed(evt);
            }
        });

        btnHuyLMA.setBackground(new java.awt.Color(255, 102, 102));
        btnHuyLMA.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnHuyLMA.setForeground(new java.awt.Color(0, 0, 0));
        btnHuyLMA.setText("Hủy");
        btnHuyLMA.setEnabled(false);
        btnHuyLMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyLMAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel63Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnHuyLMA, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaLMA, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemLMA, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaLMA, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoadLMA, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuuLMA, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addComponent(jPanel64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnThemLMA, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(btnXoaLMA, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnSuaLMA, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(btnLoadLMA, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLuuLMA, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnHuyLMA, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel57Layout.createSequentialGroup()
                        .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jToolBar11.add(jPanel57);

        jTabbedPane3.addTab("Loại Món", jToolBar11);

        jToolBar12.setRollover(true);

        jPanel78.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)), "Quản lý món ăn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(0, 51, 204))); // NOI18N

        jPanel79.setBackground(new java.awt.Color(255, 204, 102));

        jLabel104.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(0, 0, 0));
        jLabel104.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel104.setText("QUẢN LÝ MÓN ĂN");

        javax.swing.GroupLayout jPanel79Layout = new javax.swing.GroupLayout(jPanel79);
        jPanel79.setLayout(jPanel79Layout);
        jPanel79Layout.setHorizontalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel104, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel79Layout.setVerticalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel104, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
        );

        jPanel80.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jPanel84.setBackground(new java.awt.Color(153, 153, 153));

        jLabel108.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(0, 0, 0));
        jLabel108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/list_3176366.png"))); // NOI18N
        jLabel108.setText("Thông tin món ăn");

        javax.swing.GroupLayout jPanel84Layout = new javax.swing.GroupLayout(jPanel84);
        jPanel84.setLayout(jPanel84Layout);
        jPanel84Layout.setHorizontalGroup(
            jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel84Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel108)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel84Layout.setVerticalGroup(
            jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel84Layout.createSequentialGroup()
                .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jLabel110.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(0, 0, 0));
        jLabel110.setText("Mã");

        jLabel111.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(0, 0, 0));
        jLabel111.setText("Tên");

        jLabel112.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(0, 0, 0));
        jLabel112.setText("ĐVT");

        jLabel113.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(0, 0, 0));
        jLabel113.setText("Giá");

        jLabel114.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(0, 0, 0));
        jLabel114.setText("Loại");

        txbMaMonAn.setEditable(false);
        txbMaMonAn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txbMaMonAn.setForeground(new java.awt.Color(0, 0, 0));

        txbGia.setEditable(false);
        txbGia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txbGia.setForeground(new java.awt.Color(0, 0, 0));

        txbDVT.setEditable(false);
        txbDVT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txbDVT.setForeground(new java.awt.Color(0, 0, 0));

        txbTenMonAn.setEditable(false);
        txbTenMonAn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txbTenMonAn.setForeground(new java.awt.Color(0, 0, 0));

        cbLoaiMon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbLoaiMon.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel80Layout = new javax.swing.GroupLayout(jPanel80);
        jPanel80.setLayout(jPanel80Layout);
        jPanel80Layout.setHorizontalGroup(
            jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel84, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel80Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel111, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel112, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                        .addComponent(jLabel113, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel114, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel110))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txbMaMonAn)
                    .addComponent(txbGia)
                    .addComponent(txbDVT)
                    .addComponent(txbTenMonAn)
                    .addComponent(cbLoaiMon, 0, 354, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel80Layout.setVerticalGroup(
            jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel80Layout.createSequentialGroup()
                .addComponent(jPanel84, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel110)
                    .addComponent(txbMaMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel111)
                    .addComponent(txbTenMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel112)
                    .addComponent(txbDVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel113)
                    .addComponent(txbGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel114)
                    .addComponent(cbLoaiMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        jPanel81.setBackground(new java.awt.Color(204, 204, 204));
        jPanel81.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "Hình ảnh", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        txbAnh.setEditable(false);
        txbAnh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txbAnh.setForeground(new java.awt.Color(0, 0, 0));

        txbChonAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-share-50.png"))); // NOI18N
        txbChonAnh.setEnabled(false);
        txbChonAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txbChonAnhMouseClicked(evt);
            }
        });

        imgHinh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgHinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/f.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel81Layout = new javax.swing.GroupLayout(jPanel81);
        jPanel81.setLayout(jPanel81Layout);
        jPanel81Layout.setHorizontalGroup(
            jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel81Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(imgHinh, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                    .addComponent(txbAnh))
                .addGap(18, 18, 18)
                .addComponent(txbChonAnh)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel81Layout.setVerticalGroup(
            jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel81Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txbChonAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txbAnh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imgHinh, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel82.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jPanel85.setBackground(new java.awt.Color(153, 153, 153));

        jLabel109.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(0, 0, 0));
        jLabel109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-setting-50.png"))); // NOI18N
        jLabel109.setText("Xử lý");

        javax.swing.GroupLayout jPanel85Layout = new javax.swing.GroupLayout(jPanel85);
        jPanel85.setLayout(jPanel85Layout);
        jPanel85Layout.setHorizontalGroup(
            jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel85Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel109, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel85Layout.setVerticalGroup(
            jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel85Layout.createSequentialGroup()
                .addComponent(jLabel109, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnThemMonAn.setBackground(new java.awt.Color(204, 255, 204));
        btnThemMonAn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThemMonAn.setForeground(new java.awt.Color(0, 0, 0));
        btnThemMonAn.setText("Thêm");
        btnThemMonAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMonAnActionPerformed(evt);
            }
        });

        btnXoaMonAn.setBackground(new java.awt.Color(255, 255, 204));
        btnXoaMonAn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoaMonAn.setForeground(new java.awt.Color(0, 0, 0));
        btnXoaMonAn.setText("Xóa");
        btnXoaMonAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaMonAnActionPerformed(evt);
            }
        });

        btnSuaMonAn.setBackground(new java.awt.Color(255, 204, 204));
        btnSuaMonAn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSuaMonAn.setForeground(new java.awt.Color(0, 0, 0));
        btnSuaMonAn.setText("Sửa");
        btnSuaMonAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaMonAnActionPerformed(evt);
            }
        });

        btnLoadMonAn.setBackground(new java.awt.Color(204, 204, 255));
        btnLoadMonAn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLoadMonAn.setForeground(new java.awt.Color(0, 0, 0));
        btnLoadMonAn.setText("Tải lại");
        btnLoadMonAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadMonAnActionPerformed(evt);
            }
        });

        btnLuuMonAn.setBackground(new java.awt.Color(204, 255, 255));
        btnLuuMonAn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLuuMonAn.setForeground(new java.awt.Color(0, 0, 0));
        btnLuuMonAn.setText("Lưu");
        btnLuuMonAn.setEnabled(false);
        btnLuuMonAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuMonAnActionPerformed(evt);
            }
        });

        btnHuyMonAn.setBackground(new java.awt.Color(255, 102, 102));
        btnHuyMonAn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnHuyMonAn.setForeground(new java.awt.Color(0, 0, 0));
        btnHuyMonAn.setText("Hủy");
        btnHuyMonAn.setEnabled(false);
        btnHuyMonAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyMonAnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel82Layout = new javax.swing.GroupLayout(jPanel82);
        jPanel82.setLayout(jPanel82Layout);
        jPanel82Layout.setHorizontalGroup(
            jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel85, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel82Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnHuyMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuuMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoadMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel82Layout.setVerticalGroup(
            jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel82Layout.createSequentialGroup()
                .addComponent(jPanel85, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThemMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnXoaMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnSuaMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnLoadMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btnLuuMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnHuyMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel83.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jPanel86.setBackground(new java.awt.Color(153, 153, 153));

        jLabel107.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(0, 0, 0));
        jLabel107.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/l1.png"))); // NOI18N
        jLabel107.setText("Danh sách thực đơn");

        javax.swing.GroupLayout jPanel86Layout = new javax.swing.GroupLayout(jPanel86);
        jPanel86.setLayout(jPanel86Layout);
        jPanel86Layout.setHorizontalGroup(
            jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel86Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel107)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel86Layout.setVerticalGroup(
            jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel86Layout.createSequentialGroup()
                .addComponent(jLabel107, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        tableMonAn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tableMonAn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã ", "Tên ", "DVT", "Đơn giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableMonAn.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableMonAn.setRowHeight(40);
        tableMonAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMonAnMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tableMonAn);

        javax.swing.GroupLayout jPanel83Layout = new javax.swing.GroupLayout(jPanel83);
        jPanel83.setLayout(jPanel83Layout);
        jPanel83Layout.setHorizontalGroup(
            jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel86, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel83Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel83Layout.setVerticalGroup(
            jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel83Layout.createSequentialGroup()
                .addComponent(jPanel86, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane10)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel78Layout = new javax.swing.GroupLayout(jPanel78);
        jPanel78.setLayout(jPanel78Layout);
        jPanel78Layout.setHorizontalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel78Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel81, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel82, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel78Layout.setVerticalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel78Layout.createSequentialGroup()
                .addComponent(jPanel79, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel78Layout.createSequentialGroup()
                        .addComponent(jPanel80, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel81, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel82, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jToolBar12.add(jPanel78);

        jTabbedPane3.addTab("Món Ăn", jToolBar12);

        jToolBar13.setRollover(true);

        jPanel69.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "Quản lý bàn ăn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(0, 51, 204))); // NOI18N

        jPanel70.setBackground(new java.awt.Color(153, 255, 204));

        jLabel85.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(0, 0, 0));
        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setText("QUẢN LÝ BÀN ĂN");

        javax.swing.GroupLayout jPanel70Layout = new javax.swing.GroupLayout(jPanel70);
        jPanel70.setLayout(jPanel70Layout);
        jPanel70Layout.setHorizontalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel85, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel70Layout.setVerticalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel70Layout.createSequentialGroup()
                .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jPanel71.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        jPanel74.setBackground(new java.awt.Color(153, 153, 153));

        jLabel86.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(0, 0, 0));
        jLabel86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/l1.png"))); // NOI18N
        jLabel86.setText("Thông tin bàn ăn");

        javax.swing.GroupLayout jPanel74Layout = new javax.swing.GroupLayout(jPanel74);
        jPanel74.setLayout(jPanel74Layout);
        jPanel74Layout.setHorizontalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel74Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(311, Short.MAX_VALUE))
        );
        jPanel74Layout.setVerticalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel74Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel86)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jLabel99.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(0, 0, 0));
        jLabel99.setText("Mã bàn");

        jLabel101.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(0, 0, 0));
        jLabel101.setText("Số chỗ ngồi");

        jLabel102.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(0, 0, 0));
        jLabel102.setText("Tên khu vực");

        jLabel103.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(0, 0, 0));
        jLabel103.setText("Trạng thái");

        txbSoChoNgoi.setEditable(false);
        txbSoChoNgoi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txbSoChoNgoi.setForeground(new java.awt.Color(0, 0, 0));

        txbMaBan.setEditable(false);
        txbMaBan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txbMaBan.setForeground(new java.awt.Color(0, 0, 0));

        cbTrangThaiBan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbTrangThaiBan.setForeground(new java.awt.Color(0, 0, 0));
        cbTrangThaiBan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trống", "Có người" }));
        cbTrangThaiBan.setEnabled(false);

        txbKhuVuc.setEditable(false);
        txbKhuVuc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txbKhuVuc.setForeground(new java.awt.Color(0, 0, 0));
        txbKhuVuc.setText("SẢNH");

        jLabel94.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-restaurant-60.png"))); // NOI18N

        jLabel95.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-restaurant-60 (1).png"))); // NOI18N

        jLabel96.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-restaurant-60 (2).png"))); // NOI18N

        jLabel97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-restaurant-60 (1).png"))); // NOI18N

        jLabel98.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-restaurant-60.png"))); // NOI18N

        javax.swing.GroupLayout jPanel71Layout = new javax.swing.GroupLayout(jPanel71);
        jPanel71.setLayout(jPanel71Layout);
        jPanel71Layout.setHorizontalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel71Layout.createSequentialGroup()
                .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel71Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel101, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel102, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(jLabel103, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel71Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel94)
                            .addComponent(jLabel90))))
                .addGap(18, 18, 18)
                .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel71Layout.createSequentialGroup()
                        .addComponent(jLabel89)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel95)
                        .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel71Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel91)
                                .addGap(123, 123, 123)
                                .addComponent(jLabel92))
                            .addGroup(jPanel71Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel96)))
                        .addGap(34, 34, 34)
                        .addComponent(jLabel97)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel93)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel98)
                        .addGap(46, 46, 46))
                    .addGroup(jPanel71Layout.createSequentialGroup()
                        .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txbSoChoNgoi, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txbMaBan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                            .addComponent(cbTrangThaiBan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txbKhuVuc))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel71Layout.setVerticalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel71Layout.createSequentialGroup()
                .addComponent(jPanel74, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txbMaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txbSoChoNgoi, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txbKhuVuc, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTrangThaiBan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel71Layout.createSequentialGroup()
                        .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel71Layout.createSequentialGroup()
                                .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel71Layout.createSequentialGroup()
                                        .addGap(0, 31, Short.MAX_VALUE)
                                        .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel91)
                                            .addComponent(jLabel93)
                                            .addComponent(jLabel90)))
                                    .addGroup(jPanel71Layout.createSequentialGroup()
                                        .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel89)
                                            .addComponent(jLabel92))
                                        .addGap(8, 8, 8)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel94))
                            .addGroup(jPanel71Layout.createSequentialGroup()
                                .addComponent(jLabel95)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel71Layout.createSequentialGroup()
                        .addComponent(jLabel97)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel71Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel96, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel98, javax.swing.GroupLayout.Alignment.TRAILING)))))
        );

        jPanel72.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        jPanel75.setBackground(new java.awt.Color(153, 153, 153));

        jLabel87.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(0, 0, 0));
        jLabel87.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/list_3176366.png"))); // NOI18N
        jLabel87.setText("Danh sách bàn ăn");

        javax.swing.GroupLayout jPanel75Layout = new javax.swing.GroupLayout(jPanel75);
        jPanel75.setLayout(jPanel75Layout);
        jPanel75Layout.setHorizontalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel75Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel75Layout.setVerticalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel75Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel87)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel77.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "Sảnh", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 24), new java.awt.Color(0, 102, 102))); // NOI18N

        jScrollPane14.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane14.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        javax.swing.GroupLayout jpanelDSBanLayout = new javax.swing.GroupLayout(jpanelDSBan);
        jpanelDSBan.setLayout(jpanelDSBanLayout);
        jpanelDSBanLayout.setHorizontalGroup(
            jpanelDSBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 829, Short.MAX_VALUE)
        );
        jpanelDSBanLayout.setVerticalGroup(
            jpanelDSBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );

        jScrollPane14.setViewportView(jpanelDSBan);

        javax.swing.GroupLayout jPanel77Layout = new javax.swing.GroupLayout(jPanel77);
        jPanel77.setLayout(jPanel77Layout);
        jPanel77Layout.setHorizontalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel77Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel77Layout.setVerticalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel77Layout.createSequentialGroup()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel72Layout = new javax.swing.GroupLayout(jPanel72);
        jPanel72.setLayout(jPanel72Layout);
        jPanel72Layout.setHorizontalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel72Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel72Layout.setVerticalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel72Layout.createSequentialGroup()
                .addComponent(jPanel75, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel73.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        jPanel76.setBackground(new java.awt.Color(153, 153, 153));

        jLabel88.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(0, 0, 0));
        jLabel88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-setting-50.png"))); // NOI18N
        jLabel88.setText("Xử lý");

        javax.swing.GroupLayout jPanel76Layout = new javax.swing.GroupLayout(jPanel76);
        jPanel76.setLayout(jPanel76Layout);
        jPanel76Layout.setHorizontalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel76Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel76Layout.setVerticalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
        );

        btnThemBan.setBackground(new java.awt.Color(204, 255, 204));
        btnThemBan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThemBan.setForeground(new java.awt.Color(0, 0, 0));
        btnThemBan.setText("Thêm");
        btnThemBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemBanActionPerformed(evt);
            }
        });

        btnXoaBan.setBackground(new java.awt.Color(255, 255, 204));
        btnXoaBan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoaBan.setForeground(new java.awt.Color(0, 0, 0));
        btnXoaBan.setText("Xóa");
        btnXoaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaBanActionPerformed(evt);
            }
        });

        btnSuaBan.setBackground(new java.awt.Color(255, 204, 204));
        btnSuaBan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSuaBan.setForeground(new java.awt.Color(0, 0, 0));
        btnSuaBan.setText("Sửa");
        btnSuaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaBanActionPerformed(evt);
            }
        });

        btnHuyBan.setBackground(new java.awt.Color(255, 102, 102));
        btnHuyBan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnHuyBan.setForeground(new java.awt.Color(0, 0, 0));
        btnHuyBan.setText("Hủy");
        btnHuyBan.setEnabled(false);
        btnHuyBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyBanActionPerformed(evt);
            }
        });

        btnLuuBan.setBackground(new java.awt.Color(204, 255, 255));
        btnLuuBan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLuuBan.setForeground(new java.awt.Color(0, 0, 0));
        btnLuuBan.setText("Lưu");
        btnLuuBan.setEnabled(false);
        btnLuuBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuBanActionPerformed(evt);
            }
        });

        btnLoadBan.setBackground(new java.awt.Color(204, 204, 255));
        btnLoadBan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLoadBan.setForeground(new java.awt.Color(0, 0, 0));
        btnLoadBan.setText("Tải lại");
        btnLoadBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadBanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel73Layout = new javax.swing.GroupLayout(jPanel73);
        jPanel73.setLayout(jPanel73Layout);
        jPanel73Layout.setHorizontalGroup(
            jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel73Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLoadBan, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(btnThemBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(84, 84, 84)
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLuuBan, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(btnXoaBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnHuyBan, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(btnSuaBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(52, 52, 52))
        );
        jPanel73Layout.setVerticalGroup(
            jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel73Layout.createSequentialGroup()
                .addComponent(jPanel76, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemBan, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuyBan, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuuBan, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoadBan, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel69Layout = new javax.swing.GroupLayout(jPanel69);
        jPanel69.setLayout(jPanel69Layout);
        jPanel69Layout.setHorizontalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel69Layout.setVerticalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addComponent(jPanel70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel69Layout.createSequentialGroup()
                        .addComponent(jPanel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel73, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jToolBar13.add(jPanel69);

        jTabbedPane3.addTab("Bàn", jToolBar13);

        jToolBar10.setRollover(true);

        jPanel103.setBackground(new java.awt.Color(204, 204, 204));
        jPanel103.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "Công thức món ăn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(0, 102, 102))); // NOI18N

        jTextField24.setBackground(new java.awt.Color(204, 255, 153));
        jTextField24.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jTextField24.setForeground(new java.awt.Color(0, 0, 0));
        jTextField24.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField24.setText("CÔNG THỨC MÓN ĂN");

        jPanel104.setBackground(new java.awt.Color(255, 255, 255));
        jPanel104.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel104.setForeground(new java.awt.Color(255, 255, 255));

        jPanel110.setBackground(new java.awt.Color(153, 153, 153));

        jLabel130.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel130.setForeground(new java.awt.Color(0, 0, 0));
        jLabel130.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/checklist.png"))); // NOI18N
        jLabel130.setText("Thông tin công thức");

        javax.swing.GroupLayout jPanel110Layout = new javax.swing.GroupLayout(jPanel110);
        jPanel110.setLayout(jPanel110Layout);
        jPanel110Layout.setHorizontalGroup(
            jPanel110Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel110Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel130, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel110Layout.setVerticalGroup(
            jPanel110Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel110Layout.createSequentialGroup()
                .addComponent(jLabel130, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jLabel136.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel136.setForeground(new java.awt.Color(0, 0, 0));
        jLabel136.setText("Tên món");

        jLabel137.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel137.setForeground(new java.awt.Color(0, 0, 0));
        jLabel137.setText("Tên nguyên liệu");

        jLabel138.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel138.setForeground(new java.awt.Color(0, 0, 0));
        jLabel138.setText("Hàm lượng");

        cbCTTenNguyenLieu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbCTTenNguyenLieu.setForeground(new java.awt.Color(0, 0, 0));
        cbCTTenNguyenLieu.setEnabled(false);

        cbCTTenMonAn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbCTTenMonAn.setForeground(new java.awt.Color(0, 0, 0));
        cbCTTenMonAn.setEnabled(false);

        txbHamLuong.setEditable(false);
        txbHamLuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txbHamLuong.setForeground(new java.awt.Color(0, 0, 0));

        jLabel145.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel145.setForeground(new java.awt.Color(0, 0, 0));
        jLabel145.setText("Đơn vị");

        txbCTDVT.setEditable(false);
        txbCTDVT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txbCTDVT.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel104Layout = new javax.swing.GroupLayout(jPanel104);
        jPanel104.setLayout(jPanel104Layout);
        jPanel104Layout.setHorizontalGroup(
            jPanel104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel110, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel104Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel104Layout.createSequentialGroup()
                        .addComponent(jLabel136)
                        .addGap(80, 80, 80)
                        .addComponent(cbCTTenMonAn, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel104Layout.createSequentialGroup()
                        .addGroup(jPanel104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel137)
                            .addComponent(jLabel138))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbCTTenNguyenLieu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txbHamLuong)))
                    .addGroup(jPanel104Layout.createSequentialGroup()
                        .addComponent(jLabel145)
                        .addGap(100, 100, 100)
                        .addComponent(txbCTDVT)))
                .addContainerGap())
        );
        jPanel104Layout.setVerticalGroup(
            jPanel104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel104Layout.createSequentialGroup()
                .addComponent(jPanel110, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel136)
                    .addComponent(cbCTTenMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel137)
                    .addComponent(cbCTTenNguyenLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel138)
                    .addComponent(txbHamLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel145)
                    .addComponent(txbCTDVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jPanel105.setBackground(new java.awt.Color(255, 255, 255));
        jPanel105.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jPanel111.setBackground(new java.awt.Color(153, 153, 153));

        jLabel131.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel131.setForeground(new java.awt.Color(0, 0, 0));
        jLabel131.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-setting-50.png"))); // NOI18N
        jLabel131.setText("Chức năng");

        javax.swing.GroupLayout jPanel111Layout = new javax.swing.GroupLayout(jPanel111);
        jPanel111.setLayout(jPanel111Layout);
        jPanel111Layout.setHorizontalGroup(
            jPanel111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel111Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel131, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel111Layout.setVerticalGroup(
            jPanel111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel111Layout.createSequentialGroup()
                .addComponent(jLabel131, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        btnThemCT.setBackground(new java.awt.Color(204, 255, 204));
        btnThemCT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThemCT.setForeground(new java.awt.Color(0, 0, 0));
        btnThemCT.setText("Thêm");
        btnThemCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCTActionPerformed(evt);
            }
        });

        btnXoaCT.setBackground(new java.awt.Color(255, 255, 204));
        btnXoaCT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoaCT.setForeground(new java.awt.Color(0, 0, 0));
        btnXoaCT.setText("Xóa");
        btnXoaCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaCTActionPerformed(evt);
            }
        });

        btnSuaCT.setBackground(new java.awt.Color(255, 204, 204));
        btnSuaCT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSuaCT.setForeground(new java.awt.Color(0, 0, 0));
        btnSuaCT.setText("Sửa");
        btnSuaCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaCTActionPerformed(evt);
            }
        });

        btnLoadCT.setBackground(new java.awt.Color(204, 204, 255));
        btnLoadCT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLoadCT.setForeground(new java.awt.Color(0, 0, 0));
        btnLoadCT.setText("Tải lại");
        btnLoadCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadCTActionPerformed(evt);
            }
        });

        btnLuuCT.setBackground(new java.awt.Color(204, 255, 255));
        btnLuuCT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLuuCT.setForeground(new java.awt.Color(0, 0, 0));
        btnLuuCT.setText("Lưu");
        btnLuuCT.setEnabled(false);
        btnLuuCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuCTActionPerformed(evt);
            }
        });

        btnHuyCT.setBackground(new java.awt.Color(255, 102, 102));
        btnHuyCT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnHuyCT.setForeground(new java.awt.Color(0, 0, 0));
        btnHuyCT.setText("Hủy");
        btnHuyCT.setEnabled(false);
        btnHuyCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyCTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel105Layout = new javax.swing.GroupLayout(jPanel105);
        jPanel105.setLayout(jPanel105Layout);
        jPanel105Layout.setHorizontalGroup(
            jPanel105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel111, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel105Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemCT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoadCT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLuuCT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaCT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSuaCT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyCT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel105Layout.setVerticalGroup(
            jPanel105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel105Layout.createSequentialGroup()
                .addComponent(jPanel111, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemCT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaCT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaCT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoadCT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuuCT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyCT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        jPanel106.setBackground(new java.awt.Color(255, 255, 255));
        jPanel106.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jPanel112.setBackground(new java.awt.Color(153, 153, 153));

        jLabel132.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel132.setForeground(new java.awt.Color(0, 0, 0));
        jLabel132.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/list_3176366.png"))); // NOI18N
        jLabel132.setText("Thông tin nguyên liệu");

        javax.swing.GroupLayout jPanel112Layout = new javax.swing.GroupLayout(jPanel112);
        jPanel112.setLayout(jPanel112Layout);
        jPanel112Layout.setHorizontalGroup(
            jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel112Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel132, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel112Layout.setVerticalGroup(
            jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel112Layout.createSequentialGroup()
                .addComponent(jLabel132, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jLabel139.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel139.setForeground(new java.awt.Color(0, 0, 0));
        jLabel139.setText("Tên nguyên liệu");

        jLabel140.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel140.setForeground(new java.awt.Color(0, 0, 0));
        jLabel140.setText("Mã nguyên liệu");

        txbMaNL.setEditable(false);
        txbMaNL.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txbMaNL.setForeground(new java.awt.Color(0, 0, 0));

        txbTenNL.setEditable(false);
        txbTenNL.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txbTenNL.setForeground(new java.awt.Color(0, 0, 0));

        jLabel147.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-salt-bae-96.png"))); // NOI18N

        jLabel148.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-crab-48.png"))); // NOI18N

        jLabel149.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-shrimp-and-lobster-48.png"))); // NOI18N

        jLabel150.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-octopus-48.png"))); // NOI18N

        javax.swing.GroupLayout jPanel106Layout = new javax.swing.GroupLayout(jPanel106);
        jPanel106.setLayout(jPanel106Layout);
        jPanel106Layout.setHorizontalGroup(
            jPanel106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel112, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel106Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel139)
                    .addComponent(jLabel140)
                    .addGroup(jPanel106Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel146)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel147)))
                .addGap(18, 18, 18)
                .addGroup(jPanel106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel106Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel148)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel149)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel141)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel150)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel142)
                        .addGap(72, 72, 72)
                        .addComponent(jLabel143)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel144)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txbTenNL)
                    .addComponent(txbMaNL))
                .addContainerGap())
        );
        jPanel106Layout.setVerticalGroup(
            jPanel106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel106Layout.createSequentialGroup()
                .addComponent(jPanel112, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel140)
                    .addComponent(txbMaNL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel139)
                    .addComponent(txbTenNL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel106Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel141, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                            .addComponent(jLabel142, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel143, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel144, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel148, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                            .addComponent(jLabel149, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel150, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(jPanel106Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel147, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel146, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        jPanel107.setBackground(new java.awt.Color(255, 255, 255));
        jPanel107.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jPanel113.setBackground(new java.awt.Color(153, 153, 153));

        jLabel133.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel133.setForeground(new java.awt.Color(0, 0, 0));
        jLabel133.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/l1.png"))); // NOI18N
        jLabel133.setText("Danh sách công thức");

        javax.swing.GroupLayout jPanel113Layout = new javax.swing.GroupLayout(jPanel113);
        jPanel113.setLayout(jPanel113Layout);
        jPanel113Layout.setHorizontalGroup(
            jPanel113Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel113Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel133)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel113Layout.setVerticalGroup(
            jPanel113Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel133, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jScrollPane12.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane12.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tableDSCT.setBackground(new java.awt.Color(255, 255, 255));
        tableDSCT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tableDSCT.setForeground(new java.awt.Color(0, 0, 0));
        tableDSCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên món ăn", "Tên nguyên liệu", "Hàm lượng", "Đơn vị"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDSCT.setPreferredSize(new java.awt.Dimension(225, 1000));
        tableDSCT.setRowHeight(40);
        tableDSCT.setShowGrid(true);
        tableDSCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDSCTMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(tableDSCT);

        javax.swing.GroupLayout jPanel107Layout = new javax.swing.GroupLayout(jPanel107);
        jPanel107.setLayout(jPanel107Layout);
        jPanel107Layout.setHorizontalGroup(
            jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel113, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel107Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel107Layout.setVerticalGroup(
            jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel107Layout.createSequentialGroup()
                .addComponent(jPanel113, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel108.setBackground(new java.awt.Color(255, 255, 255));
        jPanel108.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jPanel114.setBackground(new java.awt.Color(153, 153, 153));

        jLabel134.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel134.setForeground(new java.awt.Color(0, 0, 0));
        jLabel134.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/l1.png"))); // NOI18N
        jLabel134.setText("Danh sách nguyên liệu");

        javax.swing.GroupLayout jPanel114Layout = new javax.swing.GroupLayout(jPanel114);
        jPanel114.setLayout(jPanel114Layout);
        jPanel114Layout.setHorizontalGroup(
            jPanel114Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel114Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel134, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
        );
        jPanel114Layout.setVerticalGroup(
            jPanel114Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel114Layout.createSequentialGroup()
                .addComponent(jLabel134, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jScrollPane13.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane13.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tableNguyenLieu.setBackground(new java.awt.Color(255, 255, 255));
        tableNguyenLieu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tableNguyenLieu.setForeground(new java.awt.Color(0, 0, 0));
        tableNguyenLieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nguyên liệu", "Tên nguyên liệu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableNguyenLieu.setPreferredSize(new java.awt.Dimension(150, 1000));
        tableNguyenLieu.setRowHeight(40);
        tableNguyenLieu.setShowGrid(true);
        tableNguyenLieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableNguyenLieuMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(tableNguyenLieu);

        javax.swing.GroupLayout jPanel108Layout = new javax.swing.GroupLayout(jPanel108);
        jPanel108.setLayout(jPanel108Layout);
        jPanel108Layout.setHorizontalGroup(
            jPanel108Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel108Layout.createSequentialGroup()
                .addComponent(jPanel114, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel108Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel108Layout.setVerticalGroup(
            jPanel108Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel108Layout.createSequentialGroup()
                .addComponent(jPanel114, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel109.setBackground(new java.awt.Color(255, 255, 255));
        jPanel109.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jPanel115.setBackground(new java.awt.Color(153, 153, 153));

        jLabel135.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel135.setForeground(new java.awt.Color(0, 0, 0));
        jLabel135.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-setting-50.png"))); // NOI18N
        jLabel135.setText("Xử lý");

        javax.swing.GroupLayout jPanel115Layout = new javax.swing.GroupLayout(jPanel115);
        jPanel115.setLayout(jPanel115Layout);
        jPanel115Layout.setHorizontalGroup(
            jPanel115Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel115Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel135, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel115Layout.setVerticalGroup(
            jPanel115Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel115Layout.createSequentialGroup()
                .addComponent(jLabel135, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        btnThemNL.setBackground(new java.awt.Color(204, 255, 204));
        btnThemNL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThemNL.setForeground(new java.awt.Color(51, 51, 51));
        btnThemNL.setText("Thêm");
        btnThemNL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNLActionPerformed(evt);
            }
        });

        btnXoaNL.setBackground(new java.awt.Color(255, 255, 204));
        btnXoaNL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoaNL.setForeground(new java.awt.Color(51, 51, 51));
        btnXoaNL.setText("Xóa");
        btnXoaNL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNLActionPerformed(evt);
            }
        });

        btnSuaNL.setBackground(new java.awt.Color(255, 204, 204));
        btnSuaNL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSuaNL.setForeground(new java.awt.Color(51, 51, 51));
        btnSuaNL.setText("Sửa");
        btnSuaNL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaNLActionPerformed(evt);
            }
        });

        btnLoadNL.setBackground(new java.awt.Color(204, 204, 255));
        btnLoadNL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLoadNL.setForeground(new java.awt.Color(51, 51, 51));
        btnLoadNL.setText("Tải lại");
        btnLoadNL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadNLActionPerformed(evt);
            }
        });

        btnLuuNL.setBackground(new java.awt.Color(204, 255, 255));
        btnLuuNL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLuuNL.setForeground(new java.awt.Color(51, 51, 51));
        btnLuuNL.setText("Lưu");
        btnLuuNL.setEnabled(false);
        btnLuuNL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuNLActionPerformed(evt);
            }
        });

        btnHuyNL.setBackground(new java.awt.Color(255, 102, 102));
        btnHuyNL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnHuyNL.setForeground(new java.awt.Color(51, 51, 51));
        btnHuyNL.setText("Hủy");
        btnHuyNL.setEnabled(false);
        btnHuyNL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyNLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel109Layout = new javax.swing.GroupLayout(jPanel109);
        jPanel109.setLayout(jPanel109Layout);
        jPanel109Layout.setHorizontalGroup(
            jPanel109Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel115, javax.swing.GroupLayout.PREFERRED_SIZE, 169, Short.MAX_VALUE)
            .addGroup(jPanel109Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel109Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHuyNL, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuuNL, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoadNL, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaNL, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaNL, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemNL, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel109Layout.setVerticalGroup(
            jPanel109Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel109Layout.createSequentialGroup()
                .addComponent(jPanel115, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThemNL, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoaNL, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSuaNL, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLoadNL, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLuuNL, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHuyNL, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel103Layout = new javax.swing.GroupLayout(jPanel103);
        jPanel103.setLayout(jPanel103Layout);
        jPanel103Layout.setHorizontalGroup(
            jPanel103Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField24)
            .addGroup(jPanel103Layout.createSequentialGroup()
                .addGroup(jPanel103Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel103Layout.createSequentialGroup()
                        .addComponent(jPanel107, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel108, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jPanel109, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel103Layout.createSequentialGroup()
                        .addComponent(jPanel104, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel105, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel106, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel103Layout.setVerticalGroup(
            jPanel103Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel103Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel103Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel103Layout.createSequentialGroup()
                        .addGroup(jPanel103Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel105, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel106, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel103Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel108, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel109, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel103Layout.createSequentialGroup()
                        .addComponent(jPanel104, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel107, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jToolBar10.add(jPanel103);

        jTabbedPane3.addTab("Công Thức", jToolBar10);

        jToolBar16.setRollover(true);

        jPanel117.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Quản lý nhập kho", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(0, 51, 204))); // NOI18N

        jPanel118.setBackground(new java.awt.Color(204, 255, 255));
        jPanel118.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel116.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(0, 0, 0));
        jLabel116.setText("Tên Nguyên Liệu");

        cb_TenNguyenLieu_PN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cb_TenNguyenLieu_PN.setForeground(new java.awt.Color(0, 0, 0));
        cb_TenNguyenLieu_PN.setEnabled(false);

        jLabel117.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(0, 0, 0));
        jLabel117.setText("Số lượng:");

        txbSoLuongPN.setEditable(false);
        txbSoLuongPN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txbSoLuongPN.setForeground(new java.awt.Color(0, 0, 0));
        txbSoLuongPN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txbSoLuongPNKeyReleased(evt);
            }
        });

        table_dsNhaCungCap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        table_dsNhaCungCap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Họ Tên", "Địa Chỉ", "Email", "SĐT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_dsNhaCungCap.setRowHeight(40);
        table_dsNhaCungCap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_dsNhaCungCapMouseClicked(evt);
            }
        });
        jScrollPane17.setViewportView(table_dsNhaCungCap);

        jLabel151.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel151.setForeground(new java.awt.Color(0, 0, 0));
        jLabel151.setText("Đơn giá:");

        txbDonGiaPN.setEditable(false);
        txbDonGiaPN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txbDonGiaPN.setForeground(new java.awt.Color(0, 0, 0));
        txbDonGiaPN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txbDonGiaPNKeyReleased(evt);
            }
        });

        jLabel152.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel152.setForeground(new java.awt.Color(0, 0, 0));
        jLabel152.setText("Ngày nhập:");

        jLabel153.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel153.setForeground(new java.awt.Color(0, 0, 204));
        jLabel153.setText("Thành Tiền:");

        txbThanhTienPN.setEditable(false);
        txbThanhTienPN.setBackground(new java.awt.Color(255, 255, 255));
        txbThanhTienPN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txbThanhTienPN.setForeground(new java.awt.Color(0, 0, 255));

        btnChuyen.setBackground(new java.awt.Color(204, 255, 204));
        btnChuyen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnChuyen.setForeground(new java.awt.Color(0, 153, 51));
        btnChuyen.setText("Chuyển");
        btnChuyen.setEnabled(false);
        btnChuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenActionPerformed(evt);
            }
        });

        jLabel118.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel118.setForeground(new java.awt.Color(0, 51, 255));
        jLabel118.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel118.setText("NGUYÊN LIỆU");

        jLabel154.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel154.setForeground(new java.awt.Color(0, 51, 255));
        jLabel154.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel154.setText("NHÀ CUNG CẤP");

        jdc_NgNhap.setDateFormatString("dd/MM/yyyy");
        jdc_NgNhap.setEnabled(false);
        jdc_NgNhap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnThemPhieu.setBackground(new java.awt.Color(255, 255, 255));
        btnThemPhieu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnThemPhieu.setForeground(new java.awt.Color(0, 153, 255));
        btnThemPhieu.setText("Thêm");
        btnThemPhieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemPhieuActionPerformed(evt);
            }
        });

        btnHuyPhieu.setBackground(new java.awt.Color(255, 255, 255));
        btnHuyPhieu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnHuyPhieu.setForeground(new java.awt.Color(0, 153, 255));
        btnHuyPhieu.setText("Hủy");
        btnHuyPhieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyPhieuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel118Layout = new javax.swing.GroupLayout(jPanel118);
        jPanel118.setLayout(jPanel118Layout);
        jPanel118Layout.setHorizontalGroup(
            jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel118Layout.createSequentialGroup()
                .addGroup(jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel118Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel118Layout.createSequentialGroup()
                                .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cb_TenNguyenLieu_PN, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel118Layout.createSequentialGroup()
                                .addComponent(jLabel117, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txbSoLuongPN))
                            .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                            .addGroup(jPanel118Layout.createSequentialGroup()
                                .addGroup(jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel151, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel152, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jdc_NgNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txbDonGiaPN)))
                            .addComponent(jLabel118, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel154, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel118Layout.createSequentialGroup()
                        .addGroup(jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel118Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jLabel153, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel118Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(btnThemPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btnHuyPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel118Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnChuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11))
                            .addComponent(txbThanhTienPN))))
                .addContainerGap())
        );
        jPanel118Layout.setVerticalGroup(
            jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel118Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel118, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cb_TenNguyenLieu_PN)
                    .addComponent(jLabel116, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel117, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txbSoLuongPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel151, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txbDonGiaPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel118Layout.createSequentialGroup()
                        .addComponent(jLabel152, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel118Layout.createSequentialGroup()
                        .addComponent(jdc_NgNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel154, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txbThanhTienPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel153, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        jTextField30.setEditable(false);
        jTextField30.setBackground(new java.awt.Color(0, 204, 255));
        jTextField30.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jTextField30.setForeground(new java.awt.Color(0, 0, 0));
        jTextField30.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField30.setText("QUẢN LÝ PHIẾU NHẬP");

        jPanel121.setBackground(new java.awt.Color(204, 204, 204));
        jPanel121.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        jTextField35.setEditable(false);
        jTextField35.setBackground(new java.awt.Color(255, 255, 153));
        jTextField35.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField35.setForeground(new java.awt.Color(0, 0, 0));
        jTextField35.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField35.setText("DANH SÁCH CÁC PHIẾU NHẬP KHO");

        tableDsPhieuNhap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tableDsPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên NCC", "Ngày Nhập", "Tổng Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDsPhieuNhap.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableDsPhieuNhap.setRowHeight(40);
        tableDsPhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDsPhieuNhapMouseClicked(evt);
            }
        });
        jScrollPane18.setViewportView(tableDsPhieuNhap);

        javax.swing.GroupLayout jPanel121Layout = new javax.swing.GroupLayout(jPanel121);
        jPanel121.setLayout(jPanel121Layout);
        jPanel121Layout.setHorizontalGroup(
            jPanel121Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField35)
            .addGroup(jPanel121Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane18)
                .addContainerGap())
        );
        jPanel121Layout.setVerticalGroup(
            jPanel121Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel121Layout.createSequentialGroup()
                .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnXuatPhieu.setBackground(new java.awt.Color(204, 204, 255));
        btnXuatPhieu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnXuatPhieu.setForeground(new java.awt.Color(0, 102, 102));
        btnXuatPhieu.setText("Xuất Phiếu");
        btnXuatPhieu.setEnabled(false);
        btnXuatPhieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatPhieuActionPerformed(evt);
            }
        });

        jLabel155.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel155.setForeground(new java.awt.Color(0, 0, 0));
        jLabel155.setText("Ngày nhập kho:");

        jLabel156.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel156.setForeground(new java.awt.Color(0, 0, 0));
        jLabel156.setText("Mã phiếu nhập:");

        txbMaPhieuCanTim.setBackground(new java.awt.Color(255, 255, 255));
        txbMaPhieuCanTim.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txbMaPhieuCanTim.setForeground(new java.awt.Color(0, 0, 0));

        btnTimPhieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/sb.png"))); // NOI18N
        btnTimPhieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimPhieuActionPerformed(evt);
            }
        });

        jPanel119.setBackground(new java.awt.Color(204, 255, 204));
        jPanel119.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        jTextField36.setBackground(new java.awt.Color(255, 204, 204));
        jTextField36.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField36.setForeground(new java.awt.Color(0, 0, 0));
        jTextField36.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField36.setText("THÔNG TIN PHIẾU NHẬP");

        table_CTPN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        table_CTPN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên Nguyên Liệu", "Tên Nhà  Cung Cấp", "Ngày Nhập", "Số lượng", "Đơn Giá", "Thành Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_CTPN.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        table_CTPN.setRowHeight(40);
        jScrollPane19.setViewportView(table_CTPN);

        btnTaoPhieu.setBackground(new java.awt.Color(255, 153, 102));
        btnTaoPhieu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnTaoPhieu.setForeground(new java.awt.Color(0, 153, 51));
        btnTaoPhieu.setText("Nhập hàng");
        btnTaoPhieu.setEnabled(false);
        btnTaoPhieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoPhieuActionPerformed(evt);
            }
        });

        jLabel157.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel157.setForeground(new java.awt.Color(0, 0, 204));
        jLabel157.setText("Tổng Tiền:");

        txbTongTienPN.setEditable(false);
        txbTongTienPN.setBackground(new java.awt.Color(255, 255, 255));
        txbTongTienPN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txbTongTienPN.setForeground(new java.awt.Color(0, 0, 255));

        btnXoa.setBackground(new java.awt.Color(255, 255, 255));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(0, 153, 255));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel119Layout = new javax.swing.GroupLayout(jPanel119);
        jPanel119.setLayout(jPanel119Layout);
        jPanel119Layout.setHorizontalGroup(
            jPanel119Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField36, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
            .addGroup(jPanel119Layout.createSequentialGroup()
                .addGroup(jPanel119Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel119Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel157, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txbTongTienPN))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel119Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnTaoPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addGroup(jPanel119Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel119Layout.setVerticalGroup(
            jPanel119Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel119Layout.createSequentialGroup()
                .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel119Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txbTongTienPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel157, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel119Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        jdc_NgNhap_PN.setDateFormatString("dd/MM/yyyy");
        jdc_NgNhap_PN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jdc_NgNhap_PN.setMinSelectableDate(new java.util.Date(-62135791113000L));

        jLabel158.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel158.setForeground(new java.awt.Color(0, 0, 0));
        jLabel158.setText("Nhà Cung Cấp");

        txbNhaCungCap.setEditable(false);
        txbNhaCungCap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txbNhaCungCap.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel117Layout = new javax.swing.GroupLayout(jPanel117);
        jPanel117.setLayout(jPanel117Layout);
        jPanel117Layout.setHorizontalGroup(
            jPanel117Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel117Layout.createSequentialGroup()
                .addGroup(jPanel117Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField30, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel117Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel117Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel117Layout.createSequentialGroup()
                                .addComponent(jLabel158)
                                .addGap(18, 18, 18)
                                .addComponent(txbNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel155, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jdc_NgNhap_PN, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel117Layout.createSequentialGroup()
                                .addComponent(jPanel118, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel119, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel117Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel117Layout.createSequentialGroup()
                                .addComponent(btnXuatPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
                            .addComponent(jPanel121, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel117Layout.createSequentialGroup()
                                .addComponent(jLabel156, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txbMaPhieuCanTim, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnTimPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))))
                .addContainerGap())
        );
        jPanel117Layout.setVerticalGroup(
            jPanel117Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel117Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel117Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel117Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel155, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel158, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txbNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel156, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txbMaPhieuCanTim)
                    .addComponent(btnTimPhieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdc_NgNhap_PN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addGroup(jPanel117Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel117Layout.createSequentialGroup()
                        .addComponent(jPanel121, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXuatPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel118, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel119, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jToolBar16.add(jPanel117);

        jTabbedPane3.addTab("Phiếu nhập", jToolBar16);

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );

        jToolBarQuanLy.add(jPanel25);

        jTabbedPane1.addTab("Quản Lý", jToolBarQuanLy);

        jToolBarThongKe.setRollover(true);

        toolbarchart.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jToolBar5.setRollover(true);

        jPanel88.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jTextField5.setBackground(new java.awt.Color(0, 102, 102));
        jTextField5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(0, 0, 0));
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setText("THỐNG KÊ HÓA ĐƠN");

        jLabel64.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(0, 0, 0));
        jLabel64.setText("Ngày bắt đầu");

        jLabel65.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(0, 0, 0));
        jLabel65.setText("Ngày kết thúc");

        jLabel100.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(0, 0, 0));
        jLabel100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel100.setText("Doanh thu");

        txbDoanhThu.setEditable(false);
        txbDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txbDoanhThu.setForeground(new java.awt.Color(0, 0, 0));

        jPanel89.setBackground(new java.awt.Color(255, 255, 255));
        jPanel89.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel90.setBackground(new java.awt.Color(204, 204, 204));

        jLabel105.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(51, 51, 51));
        jLabel105.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/list_3176366.png"))); // NOI18N
        jLabel105.setText("Danh sách hóa đơn");

        javax.swing.GroupLayout jPanel90Layout = new javax.swing.GroupLayout(jPanel90);
        jPanel90.setLayout(jPanel90Layout);
        jPanel90Layout.setHorizontalGroup(
            jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel90Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel105)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel90Layout.setVerticalGroup(
            jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel90Layout.createSequentialGroup()
                .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        tableTKDSHD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tableTKDSHD.setForeground(new java.awt.Color(0, 51, 51));
        tableTKDSHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã HD", "Tên bàn", "Tên NV", "Ngày vào", "Ngày ra", "Tổng (VAT 10%)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTKDSHD.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableTKDSHD.setRowHeight(40);
        tableTKDSHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTKDSHDMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tableTKDSHD);

        javax.swing.GroupLayout jPanel89Layout = new javax.swing.GroupLayout(jPanel89);
        jPanel89.setLayout(jPanel89Layout);
        jPanel89Layout.setHorizontalGroup(
            jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel90, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel89Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        jPanel89Layout.setVerticalGroup(
            jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel89Layout.createSequentialGroup()
                .addComponent(jPanel90, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel91.setBackground(new java.awt.Color(255, 255, 255));
        jPanel91.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel92.setBackground(new java.awt.Color(204, 204, 204));

        jLabel106.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(51, 51, 51));
        jLabel106.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/list_3176366.png"))); // NOI18N
        jLabel106.setText("Danh sách món ăn");

        javax.swing.GroupLayout jPanel92Layout = new javax.swing.GroupLayout(jPanel92);
        jPanel92.setLayout(jPanel92Layout);
        jPanel92Layout.setHorizontalGroup(
            jPanel92Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel92Layout.createSequentialGroup()
                .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel92Layout.setVerticalGroup(
            jPanel92Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel92Layout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tableTKCTHD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tableTKCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Món ăn", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTKCTHD.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableTKCTHD.setRowHeight(40);
        jScrollPane16.setViewportView(tableTKCTHD);

        javax.swing.GroupLayout jPanel91Layout = new javax.swing.GroupLayout(jPanel91);
        jPanel91.setLayout(jPanel91Layout);
        jPanel91Layout.setHorizontalGroup(
            jPanel91Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel92, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel91Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel91Layout.setVerticalGroup(
            jPanel91Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel91Layout.createSequentialGroup()
                .addComponent(jPanel92, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane16)
                .addContainerGap())
        );

        btnLast.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-next-50.png"))); // NOI18N
        btnLast.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLastMouseClicked(evt);
            }
        });

        btnFirst.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-back-to-50.png"))); // NOI18N
        btnFirst.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFirstMouseClicked(evt);
            }
        });

        btnPrevious.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-back-50.png"))); // NOI18N
        btnPrevious.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPreviousMouseClicked(evt);
            }
        });

        btnNext.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-next-page-50.png"))); // NOI18N
        btnNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNextMouseClicked(evt);
            }
        });

        txbPage.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        txbPage.setForeground(new java.awt.Color(0, 0, 0));
        txbPage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txbPage.setText("1");

        javax.swing.GroupLayout jPanel93Layout = new javax.swing.GroupLayout(jPanel93);
        jPanel93.setLayout(jPanel93Layout);
        jPanel93Layout.setHorizontalGroup(
            jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel93Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(btnFirst)
                .addGap(70, 70, 70)
                .addComponent(btnPrevious)
                .addGap(91, 91, 91)
                .addComponent(txbPage, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(btnNext)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLast)
                .addGap(69, 69, 69))
        );
        jPanel93Layout.setVerticalGroup(
            jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel93Layout.createSequentialGroup()
                .addGroup(jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFirst, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPrevious, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txbPage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        dateTKNBD.setDateFormatString("dd/MM/yyyy");
        dateTKNBD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        dateTKNKT.setDateFormatString("dd/MM/yyyy");
        dateTKNKT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel45.setText("Nhân viên");

        cbTKTenNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbTKTenNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));

        btnChartDoanhThu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnChartDoanhThu.setText("Biểu đồ");
        btnChartDoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChartDoanhThuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel88Layout = new javax.swing.GroupLayout(jPanel88);
        jPanel88.setLayout(jPanel88Layout);
        jPanel88Layout.setHorizontalGroup(
            jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField5)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel88Layout.createSequentialGroup()
                .addGroup(jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel88Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel93, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel89, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel88Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel64)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateTKNBD, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateTKNKT, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel88Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txbDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel88Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTKTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnChartDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel88Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel91, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel88Layout.setVerticalGroup(
            jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel88Layout.createSequentialGroup()
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel88Layout.createSequentialGroup()
                        .addGroup(jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(dateTKNBD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbTKTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                                    .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(btnChartDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(dateTKNKT, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 4, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel89, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel91, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel88Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel93, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel88Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txbDoanhThu)
                            .addComponent(jLabel100))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel87Layout = new javax.swing.GroupLayout(jPanel87);
        jPanel87.setLayout(jPanel87Layout);
        jPanel87Layout.setHorizontalGroup(
            jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel88, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel87Layout.setVerticalGroup(
            jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel87Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel88, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToolBar5.add(jPanel87);

        toolbarchart.addTab("Doanh thu", jToolBar5);

        jToolBar15.setRollover(true);
        toolbarchart.addTab("Thống kê lương", jToolBar15);

        jToolBar14.setRollover(true);

        panelChart.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelChartLayout = new javax.swing.GroupLayout(panelChart);
        panelChart.setLayout(panelChartLayout);
        panelChartLayout.setHorizontalGroup(
            panelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1418, Short.MAX_VALUE)
        );
        panelChartLayout.setVerticalGroup(
            panelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 628, Short.MAX_VALUE)
        );

        jLabel115.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(0, 0, 0));
        jLabel115.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel115.setText("Doanh thu");

        txbDoanhThuChart.setEditable(false);
        txbDoanhThuChart.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txbDoanhThuChart.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel115, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txbDoanhThuChart, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txbDoanhThuChart)
                    .addComponent(jLabel115))
                .addGap(17, 17, 17))
        );

        jToolBar14.add(jPanel26);

        toolbarchart.addTab("Biểu đồ", jToolBar14);

        javax.swing.GroupLayout jPanel116Layout = new javax.swing.GroupLayout(jPanel116);
        jPanel116.setLayout(jPanel116Layout);
        jPanel116Layout.setHorizontalGroup(
            jPanel116Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolbarchart)
        );
        jPanel116Layout.setVerticalGroup(
            jPanel116Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolbarchart)
        );

        jToolBarThongKe.add(jPanel116);

        jTabbedPane1.addTab("Thống Kê", jToolBarThongKe);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelRoles)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelThoat)
                        .addGap(16, 16, 16))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelThoat)
                    .addComponent(jLabelRoles))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //<editor-fold defaultstate="collapsed" desc="Event">
    private void jLabelThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelThoatMouseClicked
        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát chương trình không?", "Thông báo", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabelThoatMouseClicked

    private void jLabel129MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel129MouseClicked
        try {
            new Home(this.login).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel129MouseClicked

    private void jLabel128MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel128MouseClicked
        login log = new login();
        log.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jLabel128MouseClicked

    private void toolbarDoiMKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toolbarDoiMKMouseClicked

        try {
            dmk = new DoiMatKhau(login, this);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        dmk.setAlwaysOnTop(true); // Đặt form đổi mật khẩu luôn ở phía trước
        dmk.setVisible(true);

        // Người dùng hoàn thành đổi mật khẩu và đóng form đổi mật khẩu
        dmk.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                dmk.setAlwaysOnTop(false); // Cho phép người dùng tương tác với các cửa sổ khác
            }
        });
    }//GEN-LAST:event_toolbarDoiMKMouseClicked

    private void btnHuyNLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyNLActionPerformed
        loadNL();
    }//GEN-LAST:event_btnHuyNLActionPerformed

    private void btnLuuNLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuNLActionPerformed
        String tenNL = txbTenNL.getText().trim();

        if (tenNL.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên nguyên liệu!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (flag) {
            try {
                if (ngLieu.themNgLieu(tenNL)) {
                    JOptionPane.showMessageDialog(this, "Thêm nguyên liệu thành công!!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    loadNL();
                    showAllCThuc();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm nguyên liệu thất bại!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Lỗi khi thêm nguyên liệu!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            try {
                int maNL = Integer.parseInt(txbMaNL.getText());
                if (ngLieu.capNhatNgLieu(maNL, tenNL)) {
                    JOptionPane.showMessageDialog(this, "Cập nhật thông tin nguyên liệu thành công!!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    loadNL();
                    showAllCThuc();
                } else {
                    JOptionPane.showMessageDialog(this, "Cập nhật thông tin nguyên liệu thất bại!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật thông tin nguyên liệu!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }//GEN-LAST:event_btnLuuNLActionPerformed

    private void btnLoadNLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadNLActionPerformed
        loadNL();
        showAllCThuc();
    }//GEN-LAST:event_btnLoadNLActionPerformed

    private void btnSuaNLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaNLActionPerformed
        flag = false;
        btnLuuNL.setEnabled(true);
        btnHuyNL.setEnabled(true);
        btnThemNL.setEnabled(false);
        btnXoaNL.setEnabled(false);
        btnSuaNL.setEnabled(false);
        txbTenNL.setEditable(true);
    }//GEN-LAST:event_btnSuaNLActionPerformed

    private void btnXoaNLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNLActionPerformed
        try {
            if (Integer.parseInt(txbMaNL.getText()) == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn nguyên liệu cần xóa!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else {
                int confirmResult = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa nguyên liệu này không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
                if (confirmResult == JOptionPane.YES_OPTION) {
                    if (ngLieu.xoaNgLieu(Integer.parseInt(txbMaNL.getText()))) {
                        JOptionPane.showMessageDialog(this, "Xóa nguyên liệu thành công!!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        loadNL();
                        showAllCThuc();
                    } else {
                        JOptionPane.showMessageDialog(this, "Xóa nguyên liệu thất bại!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } else {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Không xóa được nguyên liệu này!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_btnXoaNLActionPerformed

    private void btnThemNLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNLActionPerformed
        flag = true;
        btnLuuNL.setEnabled(true);
        btnHuyNL.setEnabled(true);
        btnThemNL.setEnabled(false);
        btnXoaNL.setEnabled(false);
        btnSuaNL.setEnabled(false);
        txbMaNL.setText("");
        txbTenNL.setText("");
        txbTenNL.setEditable(true);
    }//GEN-LAST:event_btnThemNLActionPerformed

    private void tableNguyenLieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableNguyenLieuMouseClicked
        int row = tableNguyenLieu.getSelectedRow();

        txbMaNL.setText(tableNguyenLieu.getValueAt(row, 0).toString());
        txbTenNL.setText(tableNguyenLieu.getValueAt(row, 1).toString());
    }//GEN-LAST:event_tableNguyenLieuMouseClicked

    private void tableDSCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDSCTMouseClicked
        int row = tableDSCT.getSelectedRow();

        txbHamLuong.setText(tableDSCT.getValueAt(row, 2).toString());
        txbCTDVT.setText(tableDSCT.getValueAt(row, 3).toString());
        cbCTTenMonAn.setSelectedItem(tableDSCT.getValueAt(row, 0).toString());
        cbCTTenNguyenLieu.setSelectedItem(tableDSCT.getValueAt(row, 1).toString());
    }//GEN-LAST:event_tableDSCTMouseClicked

    private void btnHuyCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyCTActionPerformed
        loadCT();
    }//GEN-LAST:event_btnHuyCTActionPerformed

    private void btnLuuCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuCTActionPerformed
        try {
            String tenMon = cbCTTenMonAn.getSelectedItem().toString();

            int maMon = -1; // Giả sử không tìm thấy mã
            for (MonAnDTO monan : listMA) {
                if (monan.getTenmonan().equals(tenMon)) {
                    maMon = monan.getMamonan();
                    break; // Tìm thấy mã, thoát vòng lặp
                }
            }

            String tenNguyenLieu = cbCTTenNguyenLieu.getSelectedItem().toString();

            int maNguyenLieu = -1; // Giả sử không tìm thấy mã
            for (NguyenLieuDTO nguyenLieu : listNgLieu) {
                if (nguyenLieu.getTennguyenlieu().equals(tenNguyenLieu)) {
                    maNguyenLieu = nguyenLieu.getManguyenlieu();
                    break; // Tìm thấy mã, thoát vòng lặp
                }
            }

            String donVi = txbCTDVT.getText();
            String slText = txbHamLuong.getText();

            if (donVi.isEmpty() || slText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int sl = Integer.parseInt(slText);

            boolean kt1 = CThuc.themCThuc(maMon, maNguyenLieu, sl, donVi);
            boolean kt2 = CThuc.suaCThuc(maMon, maNguyenLieu, sl, donVi);

            if (flag) {
                if (kt1) {
                    JOptionPane.showMessageDialog(this, "Thêm công thức thành công!!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    loadCT();
                    showAllCThuc();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm công thức thất bại!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else {
                if (kt2) {
                    JOptionPane.showMessageDialog(this, "Cập nhật thông tin công thức thành công!!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    loadCT();
                    showAllCThuc();
                } else {
                    JOptionPane.showMessageDialog(this, "Cập nhật thông tin công thức thất bại!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là một số nguyên!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi không mong muốn!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_btnLuuCTActionPerformed

    private void btnLoadCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadCTActionPerformed
        loadCT();
        showAllCThuc();
    }//GEN-LAST:event_btnLoadCTActionPerformed

    private void btnSuaCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaCTActionPerformed
        flag = false;
        cbCTTenNguyenLieu.setEnabled(true);
        cbCTTenMonAn.setEnabled(true);
        txbHamLuong.setEditable(true);
        txbCTDVT.setEditable(true);
        btnLuuCT.setEnabled(true);
        btnHuyCT.setEnabled(true);
        btnThemCT.setEnabled(false);
        btnXoaCT.setEnabled(false);
        btnSuaCT.setEnabled(false);
    }//GEN-LAST:event_btnSuaCTActionPerformed

    private void btnXoaCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaCTActionPerformed
        String tenMon = cbCTTenMonAn.getSelectedItem().toString();

        int maMon = CThuc.layMaMonAn(tenMon);

        boolean kt = CThuc.xoaCThuc(maMon);
        try {
            if (maMon == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn công thức cần xóa!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                int confirmResult = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa công thức này không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
                if (confirmResult == JOptionPane.YES_OPTION) {
                    if (kt) {
                        JOptionPane.showMessageDialog(this, "Xóa công thức thành công!!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        loadCT();
                        showAllCThuc();
                    } else {
                        JOptionPane.showMessageDialog(this, "Xóa công thức thất bại!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } else {
                    // Không làm gì nếu người dùng chọn NO
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Không xóa được công thức này!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_btnXoaCTActionPerformed

    private void btnThemCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCTActionPerformed
        flag = true;
        cbCTTenNguyenLieu.setEnabled(true);
        cbCTTenMonAn.setEnabled(true);
        txbHamLuong.setEditable(true);
        txbCTDVT.setEditable(true);
        txbHamLuong.setText("");
        txbCTDVT.setText("");
        btnLuuCT.setEnabled(true);
        btnHuyCT.setEnabled(true);
        btnThemCT.setEnabled(false);
        btnXoaCT.setEnabled(false);
        btnSuaCT.setEnabled(false);
    }//GEN-LAST:event_btnThemCTActionPerformed

    private void btnLoadBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadBanActionPerformed
        loadDSBan();
        loadBan();
    }//GEN-LAST:event_btnLoadBanActionPerformed

    private void btnLuuBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuBanActionPerformed
        int slNguoi = Integer.parseInt(txbSoChoNgoi.getText());
        String trangThai = (String) cbTrangThaiBan.getSelectedItem();

        if (flag) {
            try {
                if (ban.themBan(slNguoi, trangThai)) {
                    JOptionPane.showMessageDialog(this, "Thêm bàn thành công!!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    loadDSBan();
                    loadBan();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm bàn thất bại!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Lỗi khi thêm bàn!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            int maBan = Integer.parseInt(txbMaBan.getText()); // Lấy mã bàn từ JTextField

            try {
                if (ban.capNhatBan(maBan, slNguoi, trangThai)) {
                    JOptionPane.showMessageDialog(this, "Cập nhật thông tin bàn thành công!!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    loadDSBan();
                    loadBan();
                } else {
                    JOptionPane.showMessageDialog(this, "Cập nhật thông tin bàn thất bại!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật thông tin bàn!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }//GEN-LAST:event_btnLuuBanActionPerformed

    private void btnHuyBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyBanActionPerformed
        loadBan();
    }//GEN-LAST:event_btnHuyBanActionPerformed

    private void btnSuaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaBanActionPerformed
        flag = false;
        cbTrangThaiBan.setEnabled(true);
        txbSoChoNgoi.setEditable(true);
        cbTrangThaiBan.removeAllItems();
        cbTrangThaiBan.addItem("Trống");
        cbTrangThaiBan.addItem("Có người");
        btnLuuBan.setEnabled(true);
        btnHuyBan.setEnabled(true);
        btnThemBan.setEnabled(false);
        btnXoaBan.setEnabled(false);
        btnSuaBan.setEnabled(false);
    }//GEN-LAST:event_btnSuaBanActionPerformed

    private void btnXoaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaBanActionPerformed
        boolean ktMaBan = ban.xoaBan(Integer.parseInt(txbMaBan.getText()));
        try {
            if (Integer.parseInt(txbMaBan.getText()) == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn bàn cần xóa!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                int confirmResult = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa bàn này không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
                if (confirmResult == JOptionPane.YES_OPTION) {
                    if (ktMaBan) {
                        JOptionPane.showMessageDialog(this, "Xóa bàn thành công!!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        loadBan();
                        loadDSBan();
                    } else {
                        JOptionPane.showMessageDialog(this, "Xóa bàn thất bại!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } else {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Không xóa được bàn này!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_btnXoaBanActionPerformed

    private void btnThemBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemBanActionPerformed
        flag = true;
        cbTrangThaiBan.setEnabled(true);
        txbMaBan.setText("");
        txbSoChoNgoi.setText("");
        txbSoChoNgoi.setEditable(true);
        cbTrangThaiBan.removeAllItems();
        cbTrangThaiBan.addItem("Trống");
        cbTrangThaiBan.addItem("Có người");

        btnLuuBan.setEnabled(true);
        btnHuyBan.setEnabled(true);
        btnThemBan.setEnabled(false);
        btnXoaBan.setEnabled(false);
        btnSuaBan.setEnabled(false);
    }//GEN-LAST:event_btnThemBanActionPerformed

    private void tableMonAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMonAnMouseClicked
        int row = tableMonAn.getSelectedRow();
        listMA = monan.layDSMon();
        if (row >= 0) {
            txbMaMonAn.setText(tableMonAn.getValueAt(row, 0).toString());
            txbTenMonAn.setText(tableMonAn.getValueAt(row, 1).toString());
            txbDVT.setText(tableMonAn.getValueAt(row, 2).toString());
            txbGia.setText(tableMonAn.getValueAt(row, 3).toString());

            cbLoaiMon.setEnabled(true);

            int maMonAn = Integer.parseInt(tableMonAn.getValueAt(row, 0).toString());
            String tenLoaiMon = monan.layTenLoaiTheoMaMon(maMonAn);
            cbLoaiMon.setSelectedItem(tenLoaiMon);

            // Hiển thị hình ảnh tương ứng hoặc hình ảnh mặc định
            String duongDanHinhAnh = listMA.get(row).getHinhanh(); // Lấy đường dẫn hình ảnh từ danh sách món ăn

            ImageIcon imageIcon;
            if (duongDanHinhAnh != null && !duongDanHinhAnh.isEmpty()) {
                // Nếu đường dẫn hình ảnh không rỗng, sử dụng hình ảnh từ đường dẫn
                imageIcon = new ImageIcon(getClass().getResource("/view/Images/" + duongDanHinhAnh));
            } else {
                // Nếu không có hình ảnh được cung cấp, sử dụng hình ảnh mặc định
                // Thay "path_to_default_image" bằng đường dẫn đến hình ảnh mặc định của bạn
                imageIcon = new ImageIcon(getClass().getResource("/view/icon/food.jpg"));
            }

            // Đảm bảo hình ảnh được hiển thị với kích thước phù hợp
            Image image = imageIcon.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(image);

            // Hiển thị hình ảnh trong imgHinh (đổi imgHinh thành tên JLabel thực tế của bạn)
            imgHinh.setIcon(imageIcon);
        }
    }//GEN-LAST:event_tableMonAnMouseClicked

    private void btnHuyMonAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyMonAnActionPerformed
        loadMonAn();
    }//GEN-LAST:event_btnHuyMonAnActionPerformed

    private void btnLuuMonAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuMonAnActionPerformed
         int maLoai = loaimonan.layMaTheoTenDcChon(cbLoaiMon.getSelectedItem().toString());
        int mamon = Integer.parseInt(txbMaMonAn.getText().trim());
        String tenMon = txbTenMonAn.getText();
        String dvt = txbDVT.getText();
        double gia;
        String hinh = txbAnh.getText();

        try {
            gia = Double.parseDouble(txbGia.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giá phải là một số dương!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (tenMon.trim().isEmpty() || dvt.trim().isEmpty() || hinh.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (gia <= 0) {
            JOptionPane.showMessageDialog(this, "Giá phải là một số dương lớn hơn 0!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (flag) {
            try {
                if (monan.themMonAn(maLoai, tenMon, dvt, gia, hinh)) {
                    JOptionPane.showMessageDialog(this, "Thêm món ăn thành công!!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    showMonAn();
                    loadMonAn();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm món ăn thất bại!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Món ăn này đã tồn tại!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            try {
                if (monan.capNhatMonAn(maLoai, mamon, tenMon, dvt, gia, hinh)) {
                    JOptionPane.showMessageDialog(this, "Sửa món ăn thành công!!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    showMonAn();
                    loadMonAn();
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa món ăn thất bại!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Món ăn này đã tồn tại!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }//GEN-LAST:event_btnLuuMonAnActionPerformed

    private void btnLoadMonAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadMonAnActionPerformed
        loadMonAn();
    }//GEN-LAST:event_btnLoadMonAnActionPerformed

    private void btnSuaMonAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaMonAnActionPerformed
        flag = false;

        btnLuuMonAn.setEnabled(true);
        btnHuyMonAn.setEnabled(true);

        btnThemMonAn.setEnabled(false);
        btnXoaMonAn.setEnabled(false);
        btnSuaMonAn.setEnabled(false);
        btnLoadMonAn.setEnabled(false);
        txbChonAnh.setEnabled(true);

        txbMaMonAn.setEditable(false);
        txbTenMonAn.setEditable(true);
        txbDVT.setEditable(true);
        txbGia.setEditable(true);
        txbAnh.setEditable(true);
    }//GEN-LAST:event_btnSuaMonAnActionPerformed

    private void btnXoaMonAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaMonAnActionPerformed
        String maMonText = txbMaMonAn.getText();
        if (!maMonText.isEmpty()) {
            int maMon = Integer.parseInt(maMonText);
            boolean ktMa = monan.xoaMonAn(maMon);

            int maLoaiDcChon = loaimonan.layMaTheoTenDcChon(cbLoaiMon.getSelectedItem().toString());
            try {
                if (!ktMa) {
                    JOptionPane.showMessageDialog(this, "Vui lòng chọn món ăn cần xóa!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    int confirmResult = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa món ăn này không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
                    if (confirmResult == JOptionPane.YES_OPTION) {
                        if (monan.xoaMonAn(maMon)) {
                            JOptionPane.showMessageDialog(this, "Xóa món ăn thành công!!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            showMonAn();
                            loadMonAn();
                        } else {
                            JOptionPane.showMessageDialog(this, "Xóa món ăn thất bại!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    } else {
                        // Người dùng không chọn xóa
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Không được xóa món ăn!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã món ăn cần xóa!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_btnXoaMonAnActionPerformed

    private void btnThemMonAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMonAnActionPerformed
        flag = true;

        btnLuuMonAn.setEnabled(true);
        btnHuyMonAn.setEnabled(true);

        btnThemMonAn.setEnabled(false);
        btnXoaMonAn.setEnabled(false);
        btnSuaMonAn.setEnabled(false);
        btnLoadMonAn.setEnabled(false);

        txbMaMonAn.setEditable(false);
        txbTenMonAn.setEditable(true);
        txbDVT.setEditable(true);
        txbGia.setEditable(true);
        txbAnh.setEditable(true);
        txbChonAnh.setEnabled(true);

        txbMaMonAn.setText("");
        txbTenMonAn.setText("");
        txbDVT.setText("");
        txbGia.setText("");
        txbAnh.setText("");
    }//GEN-LAST:event_btnThemMonAnActionPerformed

    private void txbChonAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txbChonAnhMouseClicked
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        // Chỉ cho phép người dùng chọn file ảnh
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "jpeg", "gif");
        chooser.setFileFilter(filter);

        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            String fileName = selectedFile.getName();

            // Hiển thị tên file ảnh trên jTextField18
            txbAnh.setText(fileName);

            // Load hình ảnh lên jLabel106
            imgHinh.setText("");
            ImageIcon icon = new ImageIcon(selectedFile.getAbsolutePath());
            Image image = icon.getImage().getScaledInstance(imgHinh.getWidth(), imgHinh.getHeight(), Image.SCALE_SMOOTH);
            imgHinh.setIcon(new ImageIcon(image));
        }
    }//GEN-LAST:event_txbChonAnhMouseClicked

    private void btnHuyLMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyLMAActionPerformed
        loadLMA();
    }//GEN-LAST:event_btnHuyLMAActionPerformed

    private void btnLuuLMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuLMAActionPerformed
        String tenLoai = txbSearchLMA.getText().trim();
        int maLoai = loaimonan.layMaTheoTenDcChon(cbTenLoaiMonAn.getSelectedItem().toString());
        if (flag) {
            try {
                if (loaimonan.themLoaiMonAn(tenLoai)) {
                    JOptionPane.showMessageDialog(this, "Thêm loại món ăn thành công!!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    showLoaiMonAn();
                    loadLMA();
                    loadTenLMAtoComboBox();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm loại món ăn thất bại!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Loại món ăn này đã tồn tại!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            try {
                if (loaimonan.suaLoaiMonAn(maLoai, tenLoai)) {
                    JOptionPane.showMessageDialog(this, "Sửa loại món ăn thành công!!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    showLoaiMonAn();
                    loadLMA();
                    loadTenLMAtoComboBox();
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa loại món ăn thất bại!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Loại món ăn này đã tồn tại!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }//GEN-LAST:event_btnLuuLMAActionPerformed

    private void btnLoadLMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadLMAActionPerformed
        loadLMA();
    }//GEN-LAST:event_btnLoadLMAActionPerformed

    private void btnSuaLMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaLMAActionPerformed
        flag = false;
        txbSearchLMA.setEditable(true);

        btnThemLMA.setEnabled(false);
        btnXoaLMA.setEnabled(false);
        btnSuaLMA.setEnabled(false);

        btnLuuLMA.setEnabled(true);
        btnHuyLMA.setEnabled(true);
    }//GEN-LAST:event_btnSuaLMAActionPerformed

    private void btnXoaLMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaLMAActionPerformed
        int maLoaiDcChon = loaimonan.layMaTheoTenDcChon(cbTenLoaiMonAn.getSelectedItem().toString());
        try {
            if (maLoaiDcChon == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn loại món ăn cần xóa!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                int confirmResult = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa loại món ăn này không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
                if (confirmResult == JOptionPane.YES_OPTION) {
                    if (loaimonan.xoaLoaiMonAn(maLoaiDcChon)) {
                        JOptionPane.showMessageDialog(this, "Xóa loại món ăn thành công!!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        showLoaiMonAn();
                        loadLMA();
                    } else {
                        JOptionPane.showMessageDialog(this, "Xóa loại món ăn thất bại!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } else {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Không được xóa loại món ăn!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_btnXoaLMAActionPerformed

    private void btnThemLMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemLMAActionPerformed
        flag = true;
        txbSearchLMA.setText("");
        txbSearchLMA.setEditable(true);

        btnThemLMA.setEnabled(false);
        btnXoaLMA.setEnabled(false);
        btnSuaLMA.setEnabled(false);

        btnLuuLMA.setEnabled(true);
        btnHuyLMA.setEnabled(true);
    }//GEN-LAST:event_btnThemLMAActionPerformed

    private void tableDSLoaiMonAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDSLoaiMonAnMouseClicked
        int row = tableDSLoaiMonAn.getSelectedRow();
        if (row >= 0) {
            Object value = tableDSLoaiMonAn.getValueAt(row, 1);
            txbSearchLMA.setText(value.toString());
            cbTenLoaiMonAn.setSelectedItem(value);
        }
    }//GEN-LAST:event_tableDSLoaiMonAnMouseClicked

    private void tableDSNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDSNVMouseClicked
        int selectedRow = tableDSNV.getSelectedRow();

        if (selectedRow != -1) {
            Object selectedMaNV = tableDSNV.getValueAt(selectedRow, 0);
            txbMaNV.setText((String) selectedMaNV);

            Object selectedHoTen = tableDSNV.getValueAt(selectedRow, 1);
            txbHoTenNV.setText((String) selectedHoTen);

            Object selectedSex = tableDSNV.getValueAt(selectedRow, 2);
            cbSex.setSelectedItem(selectedSex);

            Object selectedNgaysinh = tableDSNV.getValueAt(selectedRow, 3);
            dateNgaySinh.setDate((Date) selectedNgaysinh);

            Object selectedDiachi = tableDSNV.getValueAt(selectedRow, 4);
            txbDiaChiNV.setText((String) selectedDiachi);

            Object selectedSdt = tableDSNV.getValueAt(selectedRow, 5);
            txbSDTNV.setText((String) selectedSdt);

            Object selectedNgayvaolam = tableDSNV.getValueAt(selectedRow, 6);
            dateNgayVaoLam.setDate((Date) selectedNgayvaolam);

            Object selectedLuong = tableDSNV.getValueAt(selectedRow, 7);
            txbLCB.setText(String.valueOf(selectedLuong));

            txbSoCa.setText("30 ca");
            txbTongLuong.setText(String.valueOf(((double) selectedLuong * 30)) + " VND");
        }
    }//GEN-LAST:event_tableDSNVMouseClicked

    private void btnLuuNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuNVActionPerformed
        String str_manv = txbMaNV.getText().trim();
        String str_hoten = txbHoTenNV.getText().trim();
        String str_gioitinh = cbSex.getSelectedItem().toString();

        // Định dạng của JDateChooser
        Date date_ngaysinh = dateNgaySinh.getDate();

        String str_diachi = txbDiaChiNV.getText().trim();
        String str_sdt = txbSDTNV.getText().trim();

        Date date_ngayvaolam = dateNgayVaoLam.getDate();

        String str_lcb = txbLCB.getText().trim();

        if (str_manv.equals("") || str_hoten.equals("") || str_gioitinh.equals("") || str_diachi.equals("") || str_sdt.equals("") || str_lcb.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!");
        } else {
            if (str_sdt.length() < 10) {
                JOptionPane.showMessageDialog(this, "Số điện thoại không đúng định dạng!");
            } else {
                try {
                    double lcb = Double.parseDouble(str_lcb);
                    if (lcb <= 0) {
                        JOptionPane.showMessageDialog(this, "Lương cơ bản phải lớn hơn 0!");
                    } else {
                        if (flag == true) {
                            NhanVienDTO nv = NhanVienDAO.getInstance().GetEmployeeByStaffID(str_manv);
                            if (nv != null && nv.getManhanvien().equals(str_manv)) {
                                JOptionPane.showMessageDialog(this, "Mã nhân viên " + str_manv + " đã tồn tại trong danh sách tài khoản hoặc danh sách tài khoản đã xóa.\nVui lòng chọn mã nhân viên khác!!!.");
                            } else {
                                if (NhanVienDAO.getInstance().themNV(str_manv, str_hoten, str_gioitinh, date_ngaysinh, str_diachi, str_sdt, date_ngayvaolam, lcb)) {
                                    JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công!!!");
                                    loadDSNV();
                                    loadNV();

                                    btnLoadNV.setEnabled(true);
                                    btnLuuNV.setEnabled(false);
                                    btnHuyNV.setEnabled(false);

                                    btnThemNV.setEnabled(true);
                                    btnXoaNV.setEnabled(true);
                                    btnSuaNV.setEnabled(true);
                                } else {
                                    JOptionPane.showMessageDialog(this, "Thêm nhân viên thất bại!");
                                }
                            }
                        } else {
                            if (flag == false) {
                                try {
                                    if (NhanVienDAO.getInstance().suaNV(str_manv, str_hoten, str_gioitinh, date_ngaysinh, str_diachi, str_sdt, date_ngayvaolam, lcb)) {
                                        JOptionPane.showMessageDialog(this, "Sửa thông tin nhân viên thành công!");
                                        loadDSNV();
                                        loadNV();

                                        btnLoadNV.setEnabled(true);
                                        btnLuuNV.setEnabled(false);
                                        btnHuyNV.setEnabled(false);

                                        btnThemNV.setEnabled(true);
                                        btnXoaNV.setEnabled(true);
                                        btnSuaNV.setEnabled(true);
                                    } else {
                                        JOptionPane.showMessageDialog(this, "Sửa thông tin nhân viên thất bại!");
                                    }
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(this, "Ngày vào làm phải lớn hơn ngày sinh.\nVui lòng điền lại thông tin!");
                                }
                            }
                        }

                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lương có bản phải có giá trị số!");
                }
            }
        }
    }//GEN-LAST:event_btnLuuNVActionPerformed

    private void btnHuyNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyNVActionPerformed
        loadNV();
    }//GEN-LAST:event_btnHuyNVActionPerformed

    private void btnLoadNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadNVActionPerformed
        loadNV();
    }//GEN-LAST:event_btnLoadNVActionPerformed

    private void btnSuaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaNVActionPerformed
        if (txbMaNV.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên cần sửa thông tin!");
        } else {
            // TODO add your handling code here:

            txbMaNV.setEditable(true);
            txbHoTenNV.setEditable(true);
            txbDiaChiNV.setEditable(true);
            txbSDTNV.setEditable(true);
            txbLCB.setEditable(true);
            cbSex.setEditable(true);
            dateNgaySinh.setEnabled(true);
            dateNgayVaoLam.setEnabled(true);

            btnLoadNV.setEnabled(true);
            btnLuuNV.setEnabled(true);
            btnHuyNV.setEnabled(true);

            btnThemNV.setEnabled(false);
            btnXoaNV.setEnabled(false);
            btnSuaNV.setEnabled(false);

            flag = false;
        }
    }//GEN-LAST:event_btnSuaNVActionPerformed

    private void btnXoaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNVActionPerformed
        String str_manv = txbMaNV.getText().trim();
        if (str_manv.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên cần xóa!");
        } else {
            if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa nhân viên này không?", "Thông báo", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                if (NhanVienDAO.getInstance().xoaNV(str_manv)) {
                    JOptionPane.showMessageDialog(this, "Xóa nhân viên thành công!");
                    try {
                        loadDSNV();
                        loadNV();
                    } catch (SQLException ex) {
                        Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa nhân viên thất bại");
                }
            }
        }
    }//GEN-LAST:event_btnXoaNVActionPerformed

    private void btnThemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNVActionPerformed
        txbMaNV.setText("");
        txbHoTenNV.setText("");
        txbDiaChiNV.setText("");
        txbSDTNV.setText("");
        txbLCB.setText("");

        txbMaNV.setEditable(true);
        txbHoTenNV.setEditable(true);
        txbDiaChiNV.setEditable(true);
        txbSDTNV.setEditable(true);
        txbLCB.setEditable(true);
        cbSex.setEditable(true);
        dateNgaySinh.setEnabled(true);
        dateNgayVaoLam.setEnabled(true);

        btnLoadNV.setEnabled(true);
        btnLuuNV.setEnabled(true);
        btnHuyNV.setEnabled(true);

        btnThemNV.setEnabled(false);
        btnXoaNV.setEnabled(false);
        btnSuaNV.setEnabled(false);

        flag = true;
    }//GEN-LAST:event_btnThemNVActionPerformed

    private void tableDSTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDSTKMouseClicked
        int selectedRow = tableDSTK.getSelectedRow();

        if (selectedRow != -1) {
            Object selectedMaNV = tableDSTK.getValueAt(selectedRow, 1);
            cbMaNV.setSelectedItem(selectedMaNV);

            Object selectedTenDangNhap = tableDSTK.getValueAt(selectedRow, 0);
            txbTenDangNhap.setText((String) selectedTenDangNhap);

            Object selectedTenHienThi = tableDSTK.getValueAt(selectedRow, 2);
            cbTenNV.setSelectedItem(selectedTenHienThi);

            Object selectedTrangThai = tableDSTK.getValueAt(selectedRow, 3);
            cbTrangThai.setSelectedItem(selectedTrangThai);

            if (selectedTrangThai.equals("Admin")) {
                rdoQuanTri.setSelected(true); // Chọn radiobutton Quản trị
                rdoNhanVien.setSelected(false); // Bỏ chọn radiobutton Nhân viên
            } else {
                rdoQuanTri.setSelected(false); // Bỏ chọn radiobutton Quản trị
                rdoNhanVien.setSelected(true); // Chọn radiobutton Nhân viên
            }
        }
    }//GEN-LAST:event_tableDSTKMouseClicked

    private void btnHuyTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyTKMouseClicked
        flag = true;
        txbTenDangNhap.setEditable(false);
        txbTenDangNhap.setText("");
        cbMaNV.setEnabled(false);
        cbTenNV.setEnabled(false);
        cbTrangThai.setEnabled(false);
    }//GEN-LAST:event_btnHuyTKMouseClicked

    private void btnSaveTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveTKActionPerformed
        String str_tendangnhap = txbTenDangNhap.getText().trim();
        String str_manhanvien = cbMaNV.getSelectedItem().toString();
        String str_tenhienthi = cbTenNV.getSelectedItem().toString();
        String str_trangthai = cbTrangThai.getSelectedItem().toString();

        if (flag) {
            TaiKhoanDTO taiKhoanDTO;
            taiKhoanDTO = TaiKhoanDAO.getInstance().layDSTKtheoMaNV(str_manhanvien);
            if (taiKhoanDTO != null && (taiKhoanDTO.getManhanvien() != null && taiKhoanDTO.getManhanvien().equals(str_manhanvien))) {
                JOptionPane.showMessageDialog(this, "Nhân viên " + str_manhanvien + " đã có tài khoản!!!");
            }
            try {
                if (themTK(str_tendangnhap, str_manhanvien, str_tenhienthi, str_trangthai)) {
                    JOptionPane.showMessageDialog(this, "Thêm tài khoản thành công!!!");
                    try {
                        loadDSTK();
                        txbTenDangNhap.setEditable(false);
                        cbMaNV.setEnabled(false);
                        cbTenNV.setEnabled(false);
                        cbTrangThai.setEnabled(false);
                        flag = false;
                    } catch (SQLException ex) {
                        Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm tài khoản thất bại!!!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Tài khoản đã tồn tại!!!");
            }
        } else {
            try {
                if (TaiKhoanDAO.getInstance().suaTK(str_tendangnhap, str_trangthai)) {
                    JOptionPane.showMessageDialog(this, "Sửa tài khoản" + str_tendangnhap + " thành công!!!");
                    try {
                        loadDSTK();
                        txbTenDangNhap.setEditable(false);
                        cbMaNV.setEnabled(false);
                        cbTenNV.setEnabled(false);
                        cbTrangThai.setEnabled(false);
                        flag = false;
                    } catch (SQLException ex) {
                        Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnSaveTKActionPerformed

    private void btnLoadTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoadTKMouseClicked
        try {
            loadDSTK();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLoadTKMouseClicked

    private void btnSuaTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaTKMouseClicked
        flag = false;
        cbTrangThai.setEnabled(true);
    }//GEN-LAST:event_btnSuaTKMouseClicked

    private void btnXoaTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaTKMouseClicked
        String str_tendangnhap = txbTenDangNhap.getText().trim();

        if (login.getTendangnhap().equals(str_tendangnhap)) {
            JOptionPane.showMessageDialog(this, "Lỗi xóa tài khoản? \nTài khoản đang được đăng nhập!!!");
            return;
        }

        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa tài khoản không?", "Thông báo", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            try {
                if (TaiKhoanDAO.getInstance().deleteTK(str_tendangnhap)) {
                    JOptionPane.showMessageDialog(this, "Xóa tài khoản " + str_tendangnhap + " thành công!!!");
                    txbTenDangNhap.setText("");
                    loadDSTK();
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa tài khoản " + str_tendangnhap + " thất bại!!!");
                }
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnXoaTKMouseClicked

    private void btnThemTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemTKActionPerformed
        flag = true;
        txbTenDangNhap.setEditable(true);
        cbMaNV.setEnabled(true);
        cbTenNV.setEnabled(true);
        cbTrangThai.setEnabled(true);
    }//GEN-LAST:event_btnThemTKActionPerformed

    private void btnResetPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetPassMouseClicked
        String tenDangNhap = txbTenDangNhap.getText().trim();
        if (ResetPass(tenDangNhap)) {
            JOptionPane.showMessageDialog(this, "Reset mật khẩu tài khoản " + tenDangNhap + " thành công!!!");
        } else {
            JOptionPane.showMessageDialog(this, "Reset mật khẩu tài khoản " + tenDangNhap + " thất bại!!!");
        }
    }//GEN-LAST:event_btnResetPassMouseClicked

    private void tableTKDSHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTKDSHDMouseClicked
        int pos = tableTKDSHD.getSelectedRow();

        if (pos >= 0) {
            Object selectedMaHD = tableTKDSHD.getValueAt(pos, 0);
            int mahd = 0; // Khởi tạo một giá trị mặc định
            if (selectedMaHD instanceof Integer) {
                mahd = (Integer) selectedMaHD;
            } else if (selectedMaHD instanceof String) {
                try {
                    mahd = Integer.parseInt((String) selectedMaHD);
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }
            }

            List<ChiTietHoaDonDTO> listCTHD = null;
            try {
                listCTHD = ChiTietHoaDonDAO.getInstance().layTKDSCTHD(mahd);
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }

            DefaultTableModel model = (DefaultTableModel) tableTKCTHD.getModel();
            model.setRowCount(0);
            for (ChiTietHoaDonDTO cthd : listCTHD) {
                String tenMonAn = "";
                for (MonAnDTO ma : listMA) {
                    if (ma.getMamonan() == cthd.getMamonan()) {
                        tenMonAn = ma.getTenmonan();
                        break;
                    }
                }

                double dongia = 0;
                for (MonAnDTO ma : listMA) {
                    if (ma.getMamonan() == cthd.getMamonan()) {
                        dongia = ma.getDongia();
                        break;
                    }
                }
                Object[] row = {tenMonAn, cthd.getSoluong(), dongia, (cthd.getSoluong() * dongia)};
                model.addRow(row);
            }

            // Thiết lập chiều rộng của từng cột
            int[] columnWidths = {257, 80, 140, 140}; // Chiều rộng mong muốn cho từng cột
            for (int i = 0; i < columnWidths.length; i++) {
                TableColumn column = tableTKCTHD.getColumnModel().getColumn(i);
                column.setPreferredWidth(columnWidths[i]);
            }

            // Tạo một đối tượng CenterRenderer
            CenterRenderer centerRenderer = new CenterRenderer();
            RightRenderer rightRenderer = new RightRenderer();

            // Áp dụng CenterRenderer cho các cột 1 và 2
            tableTKCTHD.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

            tableTKCTHD.getColumnModel().getColumn(2).setCellRenderer(new CurrencyRenderer());
            tableTKCTHD.getColumnModel().getColumn(3).setCellRenderer(new CurrencyRenderer());
        }
    }//GEN-LAST:event_tableTKDSHDMouseClicked

    private void btnNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseClicked
        int totalRows = listHD.size();
        totalPages = (int) Math.ceil((double) totalRows / rowsPerPage);
        // Kiểm tra xem trang hiện tại có phải là trang cuối cùng không
        if (currentPage < totalPages) {
            // Tăng chỉ số trang hiện tại
            currentPage++;

            try {
                // Gọi hàm updateTableData để cập nhật dữ liệu trang mới
                updateTableData(currentPage, rowsPerPage);
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Cập nhật trường txbPage để hiển thị trang hiện tại
            txbPage.setText(Integer.toString(currentPage));
        } else {
            JOptionPane.showMessageDialog(this, "Bạn đã ở trang cuối cùng.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnNextMouseClicked

    private void btnPreviousMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPreviousMouseClicked
        // Kiểm tra xem trang hiện tại có phải là trang đầu tiên không
        if (currentPage > 1) {
            // Giảm chỉ số trang hiện tại
            currentPage--;

            try {
                // Gọi hàm loadTKDSHD để cập nhật dữ liệu cho trang mới
                loadTKDSHD();
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Cập nhật trường txbPage để hiển thị trang hiện tại
            txbPage.setText(Integer.toString(currentPage));
        } else {
            // Hiển thị thông báo cho người dùng khi đạt đến trang đầu tiên
            JOptionPane.showMessageDialog(this, "Bạn đã ở trang đầu tiên.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnPreviousMouseClicked

    private void btnLastMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLastMouseClicked
        if (!isLastClicked) {
            // Nếu nút Last chưa được click trước đó
            currentPage = totalPages;

            try {
                // Gọi hàm loadTKDSHD để cập nhật dữ liệu cho trang mới
                loadTKDSHD();
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Cập nhật trường txbPage để hiển thị trang cuối cùng
            txbPage.setText(Integer.toString(currentPage));

            // Đặt trạng thái của nút Last thành true
            isLastClicked = true;
        } else {
            // Nếu nút Last đã được click trước đó, quay lại trang đầu tiên
            currentPage = 1;

            try {
                // Gọi hàm loadTKDSHD để cập nhật dữ liệu cho trang mới
                loadTKDSHD();
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Cập nhật trường txbPage để hiển thị trang đầu tiên
            txbPage.setText(Integer.toString(currentPage));

            // Đặt trạng thái của nút Last thành false
            isLastClicked = false;
        }
    }//GEN-LAST:event_btnLastMouseClicked

    private void btnFirstMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFirstMouseClicked
        if (!isFirstClicked) {
            // Nếu nút First chưa được click trước đó
            currentPage = 1;

            try {
                // Gọi hàm loadTKDSHD để cập nhật dữ liệu cho trang mới
                loadTKDSHD();
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Cập nhật trường txbPage để hiển thị trang đầu tiên
            txbPage.setText(Integer.toString(currentPage));

            // Đặt trạng thái của nút First thành true
            isFirstClicked = true;
        } else {
            // Nếu nút First đã được click trước đó, quay lại trang cuối cùng
            currentPage = totalPages;

            try {
                // Gọi hàm loadTKDSHD để cập nhật dữ liệu cho trang mới
                loadTKDSHD();
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Cập nhật trường txbPage để hiển thị trang cuối cùng
            txbPage.setText(Integer.toString(currentPage));

            // Đặt trạng thái của nút First thành false
            isFirstClicked = false;
        }
    }//GEN-LAST:event_btnFirstMouseClicked

    private void btnChartDoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChartDoanhThuActionPerformed
        try {
            loadChartDoanhThu();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnChartDoanhThuActionPerformed

    private void jLabelCancelOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCancelOrderMouseClicked
        cancelOrder();
    }//GEN-LAST:event_jLabelCancelOrderMouseClicked

    private void jLabelChooseDishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLabelChooseDishActionPerformed
        chooseDish(idTable);
    }//GEN-LAST:event_jLabelChooseDishActionPerformed

    private void jLabel3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLabel3ActionPerformed
        reload();
    }//GEN-LAST:event_jLabel3ActionPerformed

    private void jLabelSwitchTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLabelSwitchTableActionPerformed
        switchTable();
    }//GEN-LAST:event_jLabelSwitchTableActionPerformed

    private void jLabelCombineTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLabelCombineTableActionPerformed
        combineTable();
    }//GEN-LAST:event_jLabelCombineTableActionPerformed

    private void jLabelOrderTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLabelOrderTableActionPerformed
        orderTable();
    }//GEN-LAST:event_jLabelOrderTableActionPerformed

    private void table_dsNhaCungCapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_dsNhaCungCapMouseClicked
        int pos = table_dsNhaCungCap.getSelectedRow();

        if (pos >= 0) {
            Object selectedMa = table_dsNhaCungCap.getValueAt(pos, 0);
            int maNCC = Integer.parseInt(selectedMa.toString());

            Object selectedTen = table_dsNhaCungCap.getValueAt(pos, 1);
            txbNhaCungCap.setText(selectedTen.toString());

            // Gọi phương thức để lấy danh sách nguyên liệu theo mã nhà cung cấp
            List<NguyenLieuDTO> danhSachNguyenLieu = null;
            try {
                danhSachNguyenLieu = NguyenLieuDAO.getInstance().layDSNguyenLieuTheoMaNCC(maNCC);
            } catch (SQLException ex) {
                // Xử lý ngoại lệ nếu cần
                ex.printStackTrace();
            }

            // Xóa các mục hiện có trong combobox cb_TenNguyenLieu_PN trước khi thêm mới
            cb_TenNguyenLieu_PN.removeAllItems();

            // Thêm danh sách nguyên liệu vào combobox
            for (NguyenLieuDTO nl : danhSachNguyenLieu) {
                cb_TenNguyenLieu_PN.addItem(nl.getTennguyenlieu());
            }
        }
    }//GEN-LAST:event_table_dsNhaCungCapMouseClicked

    private void btnChuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenActionPerformed
        try {
            // Kiểm tra xem đã chuyển nhà cung cấp hay chưa
            if ((daChuyenNhacc.equals(txbNhaCungCap.getText().trim()) || daChuyenNhacc.equals(""))) {
                // Lấy thông tin từ các trường nhập liệu
                String str_tennl = cb_TenNguyenLieu_PN.getSelectedItem().toString();
                int int_soluong = Integer.parseInt(txbSoLuongPN.getText().trim());
                double double_dongia = Double.parseDouble(txbDonGiaPN.getText().trim());
                Date date_ngaynhap = jdc_NgNhap.getDate();
                String str_tenNCC = txbNhaCungCap.getText().trim();

                // Lấy mô hình của bảng
                DefaultTableModel model = (DefaultTableModel) table_CTPN.getModel();

                // Kiểm tra xem nguyên liệu đã tồn tại trong bảng chưa
                boolean found = false;
                for (int i = 0; i < model.getRowCount(); i++) {
                    String maNguyenLieu = model.getValueAt(i, 0).toString();
                    if (maNguyenLieu.equals(str_tennl)) {
                        // Nếu nguyên liệu đã tồn tại, cập nhật số lượng và thành tiền
                        int_soluong += Integer.parseInt(model.getValueAt(i, 3).toString());
                        model.setValueAt(int_soluong, i, 3); // Cập nhật số lượng

                        // Cập nhật thành tiền
                        double thanhTien = int_soluong * double_dongia;
                        model.setValueAt(thanhTien, i, 5);

                        found = true;
                        break;
                    }
                }

                if (!found) {
                    // Nếu nguyên liệu chưa tồn tại, thêm một hàng mới vào bảng
                    // Tính toán thành tiền cho hàng hiện tại
                    double thanhTien = int_soluong * double_dongia;

                    // Tạo một hàng mới để thêm vào bảng
                    Object[] row = {str_tennl, str_tenNCC, date_ngaynhap, int_soluong, double_dongia, thanhTien};

                    // Thêm hàng mới vào mô hình của bảng
                    model.addRow(row);
                }

                // Tính tổng tiền của phiếu nhập
                double tongTien = tinhTongTienCTPN(model);
                DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

                // Hiển thị tổng tiền lên trường nhập liệu tương ứng
                txbTongTienPN.setText(decimalFormat.format(tongTien) + " VND");

                // Thiết lập chiều rộng của từng cột
                int[] columnWidths = {200, 200, 150, 80, 100, 150};
                for (int i = 0; i < columnWidths.length; i++) {
                    TableColumn column = table_CTPN.getColumnModel().getColumn(i);
                    column.setPreferredWidth(columnWidths[i]);
                }

                table_CTPN.getColumnModel().getColumn(4).setCellRenderer(new CurrencyRenderer());
                table_CTPN.getColumnModel().getColumn(5).setCellRenderer(new CurrencyRenderer());
                table_CTPN.getColumnModel().getColumn(3).setCellRenderer(new CenterRenderer());
                table_CTPN.getColumnModel().getColumn(2).setCellRenderer(new DateRenderer());

                daChuyenNhacc = str_tenNCC;

                btnTaoPhieu.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "Hãy hoàn tất việc nhập hàng cho nhà cung cấp!!!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            // Xử lý ngoại lệ khi người dùng nhập không hợp lệ
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số nguyên vào ô Số lượng và số thực vào ô Đơn giá", "Lỗi Nhập Liệu", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnChuyenActionPerformed

    private void btnThemPhieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemPhieuActionPerformed
        if (txbNhaCungCap.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhà cung cấp!!!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        cb_TenNguyenLieu_PN.setEnabled(true);
        txbSoLuongPN.setEditable(true);
        txbDonGiaPN.setEditable(true);
        jdc_NgNhap.setEnabled(true);
        btnChuyen.setEnabled(true);
    }//GEN-LAST:event_btnThemPhieuActionPerformed

    private void tableDsPhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDsPhieuNhapMouseClicked

    }//GEN-LAST:event_tableDsPhieuNhapMouseClicked

    private void btnTimPhieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimPhieuActionPerformed
        try {
            loadDSPNTheoMa();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTimPhieuActionPerformed

    private void btnTaoPhieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoPhieuActionPerformed
        try {
            String tenNCC = txbNhaCungCap.getText().toString();
            int maNCC = NhaCungCapDAO.getInstance().layMaNCCTheoTen(tenNCC); // Lấy mã NCC từ tên NCC
            Date ngayNhap = jdc_NgNhap.getDate(); // Lấy ngày nhập từ jDateChooser

            // Tạo phiếu nhập mới trong bảng PHIEUNHAP
            int maPhieuNhap = PhieuNhapDAO.getInstance().taoPhieuNhap(maNCC, ngayNhap);

            List<ChiTietPhieuNhapDTO> danhSachChiTiet = layDanhSachChiTietTuData();
            ChiTietPhieuNhapDAO.getInstance().luuChiTietPhieuNhap(maPhieuNhap, danhSachChiTiet);

            // Hiển thị thông báo thành công
            JOptionPane.showMessageDialog(this, "Đã tạo phiếu nhập thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

            DefaultTableModel model = (DefaultTableModel) table_CTPN.getModel();
            try {
                loadDSPN();
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
            model.setRowCount(0); // Xóa tất cả các dòng dữ liệu trong bảng
            daChuyenNhacc = "";
            try {
                loadPN();
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin hợp lệ!", "Lỗi Nhập Liệu", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnTaoPhieuActionPerformed

    private void txbSoLuongPNKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txbSoLuongPNKeyReleased
        tinhToanThanhTien();
    }//GEN-LAST:event_txbSoLuongPNKeyReleased

    private void txbDonGiaPNKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txbDonGiaPNKeyReleased
        tinhToanThanhTien();
    }//GEN-LAST:event_txbDonGiaPNKeyReleased

    private void btnHuyPhieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyPhieuActionPerformed
        try {
            loadPN();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnHuyPhieuActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // Lấy chỉ mục của dòng được chọn
        int selectedRow = table_CTPN.getSelectedRow();

        // Kiểm tra xem có dòng nào được chọn không
        if (selectedRow != -1) {
            // Xóa dòng được chọn khỏi mô hình của bảng
            DefaultTableModel model = (DefaultTableModel) table_CTPN.getModel();
            model.removeRow(selectedRow);

            // Tính tổng tiền của phiếu nhập
            double tongTien = tinhTongTienCTPN(model);
            DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

            // Hiển thị tổng tiền lên trường nhập liệu tương ứng
            txbTongTienPN.setText(decimalFormat.format(tongTien) + " VND");
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn phiếu cần xóa!!!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tableTKDSHD_NVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTKDSHD_NVMouseClicked
        int pos = tableTKDSHD_NV.getSelectedRow();

        if (pos >= 0) {
            Object selectedMaHD = tableTKDSHD_NV.getValueAt(pos, 0);
            int mahd = 0; // Khởi tạo một giá trị mặc định
            if (selectedMaHD instanceof Integer) {
                mahd = (Integer) selectedMaHD;
            } else if (selectedMaHD instanceof String) {
                try {
                    mahd = Integer.parseInt((String) selectedMaHD);
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }
            }

            List<ChiTietHoaDonDTO> listCTHD = null;
            try {
                listCTHD = ChiTietHoaDonDAO.getInstance().layTKDSCTHD(mahd);
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }

            DefaultTableModel model = (DefaultTableModel) tableTKCTHD_NV.getModel();
            model.setRowCount(0);
            for (ChiTietHoaDonDTO cthd : listCTHD) {
                String tenMonAn = "";
                for (MonAnDTO ma : listMA) {
                    if (ma.getMamonan() == cthd.getMamonan()) {
                        tenMonAn = ma.getTenmonan();
                        break;
                    }
                }

                double dongia = 0;
                for (MonAnDTO ma : listMA) {
                    if (ma.getMamonan() == cthd.getMamonan()) {
                        dongia = ma.getDongia();
                        break;
                    }
                }
                Object[] row = {tenMonAn, cthd.getSoluong(), dongia, (cthd.getSoluong() * dongia)};
                model.addRow(row);
            }

            // Thiết lập chiều rộng của từng cột
            int[] columnWidths = {257, 80, 140, 140}; // Chiều rộng mong muốn cho từng cột
            for (int i = 0; i < columnWidths.length; i++) {
                TableColumn column = tableTKCTHD_NV.getColumnModel().getColumn(i);
                column.setPreferredWidth(columnWidths[i]);
            }

            // Tạo một đối tượng CenterRenderer
            CenterRenderer centerRenderer = new CenterRenderer();
            RightRenderer rightRenderer = new RightRenderer();

            // Áp dụng CenterRenderer cho các cột 1 và 2
            tableTKCTHD_NV.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

            tableTKCTHD_NV.getColumnModel().getColumn(2).setCellRenderer(new CurrencyRenderer());
            tableTKCTHD_NV.getColumnModel().getColumn(3).setCellRenderer(new CurrencyRenderer());

        }
    }//GEN-LAST:event_tableTKDSHD_NVMouseClicked

    private void btnLast_NVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLast_NVMouseClicked
        if (!isLastClicked) {
            // Nếu nút Last chưa được click trước đó
            currentPage = totalPages;

            try {
                // Gọi hàm loadTKDSHD để cập nhật dữ liệu cho trang mới
                loadTKDSHD_NV();
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Cập nhật trường txbPage để hiển thị trang cuối cùng
            txbPage_NV.setText(Integer.toString(currentPage));

            // Đặt trạng thái của nút Last thành true
            isLastClicked = true;
        } else {
            // Nếu nút Last đã được click trước đó, quay lại trang đầu tiên
            currentPage = 1;

            try {
                // Gọi hàm loadTKDSHD để cập nhật dữ liệu cho trang mới
                loadTKDSHD_NV();
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Cập nhật trường txbPage để hiển thị trang đầu tiên
            txbPage_NV.setText(Integer.toString(currentPage));

            // Đặt trạng thái của nút Last thành false
            isLastClicked = false;
        }
    }//GEN-LAST:event_btnLast_NVMouseClicked

    private void btnFirst_NVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFirst_NVMouseClicked
        if (!isFirstClicked) {
            // Nếu nút First chưa được click trước đó
            currentPage = 1;

            try {
                // Gọi hàm loadTKDSHD để cập nhật dữ liệu cho trang mới
                loadTKDSHD_NV();
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Cập nhật trường txbPage để hiển thị trang đầu tiên
            txbPage_NV.setText(Integer.toString(currentPage));

            // Đặt trạng thái của nút First thành true
            isFirstClicked = true;
        } else {
            // Nếu nút First đã được click trước đó, quay lại trang cuối cùng
            currentPage = totalPages;

            try {
                // Gọi hàm loadTKDSHD để cập nhật dữ liệu cho trang mới
                loadTKDSHD_NV();
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Cập nhật trường txbPage để hiển thị trang cuối cùng
            txbPage_NV.setText(Integer.toString(currentPage));

            // Đặt trạng thái của nút First thành false
            isFirstClicked = false;
        }
    }//GEN-LAST:event_btnFirst_NVMouseClicked

    private void btnPrevious_NVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevious_NVMouseClicked
        // Kiểm tra xem trang hiện tại có phải là trang đầu tiên không
        if (currentPage > 1) {
            // Giảm chỉ số trang hiện tại
            currentPage--;

            try {
                // Gọi hàm loadTKDSHD để cập nhật dữ liệu cho trang mới
                loadTKDSHD_NV();
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Cập nhật trường txbPage để hiển thị trang hiện tại
            txbPage_NV.setText(Integer.toString(currentPage));
        } else {
            // Hiển thị thông báo cho người dùng khi đạt đến trang đầu tiên
            JOptionPane.showMessageDialog(this, "Bạn đã ở trang đầu tiên.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnPrevious_NVMouseClicked

    private void btnNext_NVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNext_NVMouseClicked
        int totalRows = listHD.size();
        totalPages = (int) Math.ceil((double) totalRows / rowsPerPage);
        // Kiểm tra xem trang hiện tại có phải là trang cuối cùng không
        if (currentPage < totalPages) {
            // Tăng chỉ số trang hiện tại
            currentPage++;

            try {
                // Gọi hàm updateTableData để cập nhật dữ liệu trang mới
                updateTableDataNV(currentPage, rowsPerPage);
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Cập nhật trường txbPage để hiển thị trang hiện tại
            txbPage_NV.setText(Integer.toString(currentPage));
        } else {
            JOptionPane.showMessageDialog(this, "Bạn đã ở trang cuối cùng.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnNext_NVMouseClicked

    private void jLabel10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLabel10ActionPerformed
        exportBill();
    }//GEN-LAST:event_jLabel10ActionPerformed

    private void btnXuatPhieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatPhieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXuatPhieuActionPerformed
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Giao diện (Không code được trong này)">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChartDoanhThu;
    private javax.swing.JButton btnChuyen;
    private javax.swing.JLabel btnFirst;
    private javax.swing.JLabel btnFirst_NV;
    private javax.swing.JButton btnHuyBan;
    private javax.swing.JButton btnHuyCT;
    private javax.swing.JButton btnHuyLMA;
    private javax.swing.JButton btnHuyMonAn;
    private javax.swing.JButton btnHuyNL;
    private javax.swing.JButton btnHuyNV;
    private javax.swing.JButton btnHuyPhieu;
    private javax.swing.JButton btnHuyTK;
    private javax.swing.JLabel btnLast;
    private javax.swing.JLabel btnLast_NV;
    private javax.swing.JButton btnLoadBan;
    private javax.swing.JButton btnLoadCT;
    private javax.swing.JButton btnLoadLMA;
    private javax.swing.JButton btnLoadMonAn;
    private javax.swing.JButton btnLoadNL;
    private javax.swing.JButton btnLoadNV;
    private javax.swing.JButton btnLoadTK;
    private javax.swing.JButton btnLuuBan;
    private javax.swing.JButton btnLuuCT;
    private javax.swing.JButton btnLuuLMA;
    private javax.swing.JButton btnLuuMonAn;
    private javax.swing.JButton btnLuuNL;
    private javax.swing.JButton btnLuuNV;
    private javax.swing.JLabel btnNext;
    private javax.swing.JLabel btnNext_NV;
    private javax.swing.JLabel btnPrevious;
    private javax.swing.JLabel btnPrevious_NV;
    private javax.swing.JLabel btnResetPass;
    private javax.swing.JButton btnSaveTK;
    private javax.swing.JButton btnSuaBan;
    private javax.swing.JButton btnSuaCT;
    private javax.swing.JButton btnSuaLMA;
    private javax.swing.JButton btnSuaMonAn;
    private javax.swing.JButton btnSuaNL;
    private javax.swing.JButton btnSuaNV;
    private javax.swing.JButton btnSuaTK;
    private javax.swing.JButton btnTaoPhieu;
    private javax.swing.JButton btnThemBan;
    private javax.swing.JButton btnThemCT;
    private javax.swing.JButton btnThemLMA;
    private javax.swing.JButton btnThemMonAn;
    private javax.swing.JButton btnThemNL;
    private javax.swing.JButton btnThemNV;
    private javax.swing.JButton btnThemPhieu;
    private javax.swing.JButton btnThemTK;
    private javax.swing.JButton btnTimPhieu;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaBan;
    private javax.swing.JButton btnXoaCT;
    private javax.swing.JButton btnXoaLMA;
    private javax.swing.JButton btnXoaMonAn;
    private javax.swing.JButton btnXoaNL;
    private javax.swing.JButton btnXoaNV;
    private javax.swing.JButton btnXoaTK;
    private javax.swing.JButton btnXuatPhieu;
    private javax.swing.ButtonGroup buttonGroupQuyen;
    private javax.swing.JComboBox<String> cbCTTenMonAn;
    private javax.swing.JComboBox<String> cbCTTenNguyenLieu;
    private javax.swing.JComboBox<String> cbLoaiMon;
    private javax.swing.JComboBox<String> cbLuongSearch;
    private javax.swing.JComboBox<String> cbMaNV;
    private javax.swing.JComboBox<String> cbSex;
    private javax.swing.JComboBox<String> cbSexSearch;
    private javax.swing.JComboBox<String> cbTKTenNV;
    private javax.swing.JComboBox<String> cbTenLoaiMonAn;
    private javax.swing.JComboBox<String> cbTenNV;
    private javax.swing.JComboBox<String> cbTrangThai;
    private javax.swing.JComboBox<String> cbTrangThaiBan;
    private javax.swing.JComboBox<String> cb_TenNguyenLieu_PN;
    private com.toedter.calendar.JDateChooser dateNgaySinh;
    private com.toedter.calendar.JDateChooser dateNgayVaoLam;
    private com.toedter.calendar.JDateChooser dateTKNBD;
    private com.toedter.calendar.JDateChooser dateTKNBD_NV;
    private com.toedter.calendar.JDateChooser dateTKNKT;
    private com.toedter.calendar.JDateChooser dateTKNKT_NV;
    private javax.swing.JLabel imgHinh;
    private javax.swing.JButton jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jLabel3;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JLabel jLabelCancelOrder;
    private javax.swing.JButton jLabelChooseDish;
    private javax.swing.JButton jLabelCombineTable;
    private javax.swing.JButton jLabelOrderTable;
    private javax.swing.JLabel jLabelRoles;
    private javax.swing.JButton jLabelSwitchTable;
    private javax.swing.JLabel jLabelThoat;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JLabel jLabelWordTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel100;
    private javax.swing.JPanel jPanel101;
    private javax.swing.JPanel jPanel102;
    private javax.swing.JPanel jPanel103;
    private javax.swing.JPanel jPanel104;
    private javax.swing.JPanel jPanel105;
    private javax.swing.JPanel jPanel106;
    private javax.swing.JPanel jPanel107;
    private javax.swing.JPanel jPanel108;
    private javax.swing.JPanel jPanel109;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel110;
    private javax.swing.JPanel jPanel111;
    private javax.swing.JPanel jPanel112;
    private javax.swing.JPanel jPanel113;
    private javax.swing.JPanel jPanel114;
    private javax.swing.JPanel jPanel115;
    private javax.swing.JPanel jPanel116;
    private javax.swing.JPanel jPanel117;
    private javax.swing.JPanel jPanel118;
    private javax.swing.JPanel jPanel119;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel120;
    private javax.swing.JPanel jPanel121;
    private javax.swing.JPanel jPanel122;
    private javax.swing.JPanel jPanel123;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel73;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel75;
    private javax.swing.JPanel jPanel76;
    private javax.swing.JPanel jPanel77;
    private javax.swing.JPanel jPanel78;
    private javax.swing.JPanel jPanel79;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel80;
    private javax.swing.JPanel jPanel81;
    private javax.swing.JPanel jPanel82;
    private javax.swing.JPanel jPanel83;
    private javax.swing.JPanel jPanel84;
    private javax.swing.JPanel jPanel85;
    private javax.swing.JPanel jPanel86;
    private javax.swing.JPanel jPanel87;
    private javax.swing.JPanel jPanel88;
    private javax.swing.JPanel jPanel89;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel90;
    private javax.swing.JPanel jPanel91;
    private javax.swing.JPanel jPanel92;
    private javax.swing.JPanel jPanel93;
    private javax.swing.JPanel jPanel94;
    private javax.swing.JPanel jPanel95;
    private javax.swing.JPanel jPanel96;
    private javax.swing.JPanel jPanel97;
    private javax.swing.JPanel jPanel98;
    private javax.swing.JPanel jPanel99;
    private javax.swing.JPanel jPanelTables;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTableBillDetails;
    private javax.swing.JTextArea jTextAreaOrderInfor;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextFieldSelectedTable;
    private javax.swing.JToolBar jToolBar10;
    private javax.swing.JToolBar jToolBar11;
    private javax.swing.JToolBar jToolBar12;
    private javax.swing.JToolBar jToolBar13;
    private javax.swing.JToolBar jToolBar14;
    private javax.swing.JToolBar jToolBar15;
    private javax.swing.JToolBar jToolBar16;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JToolBar jToolBar6;
    private javax.swing.JToolBar jToolBar7;
    private javax.swing.JToolBar jToolBar8;
    private javax.swing.JToolBar jToolBar9;
    private javax.swing.JToolBar jToolBarHeThong;
    private javax.swing.JToolBar jToolBarQuanLy;
    private javax.swing.JToolBar jToolBarThongKe;
    private com.toedter.calendar.JDateChooser jdc_NgNhap;
    private com.toedter.calendar.JDateChooser jdc_NgNhap_PN;
    private javax.swing.JPanel jpanelDSBan;
    private javax.swing.JPanel panelChart;
    private javax.swing.JRadioButton rdoNhanVien;
    private javax.swing.JRadioButton rdoQuanTri;
    private javax.swing.JTable tableDSCT;
    private javax.swing.JTable tableDSLoaiMonAn;
    private javax.swing.JTable tableDSMonAnTheoLoai;
    private javax.swing.JTable tableDSNV;
    private javax.swing.JTable tableDSTK;
    private javax.swing.JTable tableDsPhieuNhap;
    private javax.swing.JTable tableMonAn;
    private javax.swing.JTable tableNguyenLieu;
    private javax.swing.JTable tableTKCTHD;
    private javax.swing.JTable tableTKCTHD_NV;
    private javax.swing.JTable tableTKDSHD;
    private javax.swing.JTable tableTKDSHD_NV;
    private javax.swing.JTable table_CTPN;
    private javax.swing.JTable table_dsNhaCungCap;
    private javax.swing.JToolBar toolbarDoiMK;
    private javax.swing.JTabbedPane toolbarchart;
    private javax.swing.JTextField txbAnh;
    private javax.swing.JTextField txbCTDVT;
    private javax.swing.JLabel txbChonAnh;
    private javax.swing.JTextField txbDVT;
    private javax.swing.JTextField txbDiaChiNV;
    private javax.swing.JTextField txbDoanhThu;
    private javax.swing.JTextField txbDoanhThuChart;
    private javax.swing.JTextField txbDoanhThu_NV;
    private javax.swing.JTextField txbDonGiaPN;
    private javax.swing.JTextField txbGia;
    private javax.swing.JTextField txbHamLuong;
    private javax.swing.JTextField txbHoTenNV;
    private javax.swing.JTextField txbKhuVuc;
    private javax.swing.JTextField txbLCB;
    private javax.swing.JTextField txbMaBan;
    private javax.swing.JTextField txbMaMonAn;
    private javax.swing.JTextField txbMaNL;
    private javax.swing.JTextField txbMaNV;
    private javax.swing.JTextField txbMaPhieuCanTim;
    private javax.swing.JTextField txbNhaCungCap;
    private javax.swing.JLabel txbPage;
    private javax.swing.JLabel txbPage_NV;
    private javax.swing.JTextField txbSDTNV;
    private javax.swing.JTextField txbSearchLMA;
    private javax.swing.JTextField txbSearchNV;
    private javax.swing.JLabel txbSoCa;
    private javax.swing.JTextField txbSoChoNgoi;
    private javax.swing.JTextField txbSoLuongPN;
    private javax.swing.JTextField txbTenDangNhap;
    private javax.swing.JTextField txbTenMonAn;
    private javax.swing.JTextField txbTenNL;
    private javax.swing.JTextField txbThanhTienPN;
    private javax.swing.JLabel txbTongLuong;
    private javax.swing.JTextField txbTongTienPN;
    // End of variables declaration//GEN-END:variables

    //</editor-fold>
    public void load() throws SQLException {
        loadDSTK();
        loadFontTable(tableDSTK);
        loadMaNhanVientoComboBox();
        loadTenNhanVientoComboBox();
        loadTrangThaitoComboBox();
        loadLuongNVtoComboBox();
        loadTenLMAtoComboBox();

        loadDSNV();
        loadFontTable(tableDSNV);

        txbSearchNV.getDocument().addDocumentListener(documentListener);
        cbLuongSearch.addActionListener(luongSearchListener);
        cbSexSearch.addActionListener(gioitinhSearchListener);

        //Món ăn
        showLoaiMonAn();
        loadFontTable(tableDSLoaiMonAn);
        loadFontTable(tableDSMonAnTheoLoai);

        cbTenLoaiMonAn.addActionListener(tenLoaiMonAnSearchListener);

        showMonAn();
        loadFontTable(tableMonAn);
        showAllCThuc();
        loadFontTable(tableDSCT);
        loadFontTable(tableNguyenLieu);
        loadDSBan();

        loadComboBoxTKTenNV();
        loadDateTK();
        loadFirstPage();
        loadFontTable(tableTKDSHD);
        loadDataChange();
        loadFontTable(tableTKCTHD);
        //txbSearchLMA.getDocument().addDocumentListener(documentListenerSearchLMA);

        loadFirstPage_NV();
        loadFontTable(tableTKDSHD_NV);
        loadFontTable(tableTKCTHD_NV);
        loadDataChange_NV();

        // Tony
        defaultTableModelBillDetails = (DefaultTableModel) jTableBillDetails.getModel();
        settingJTableBillDetails();
        Home.loadFontTable(jTableBillDetails);
        jLabelChooseDish.setEnabled(false);
        jLabelSwitchTable.setEnabled(false);
        jLabelCombineTable.setEnabled(false);
        jLabelOrderTable.setEnabled(false);
        jLabelCancelOrder.setEnabled(false);
        loadTable();

        loadDSNCC();
        loadFontTable(table_dsNhaCungCap);
        loadFontTable(table_CTPN);
        loadDSPN();
        loadFontTable(tableDsPhieuNhap);
        loadSearchPhieuNhap();
    }

    //Load giao diện JTalbe
    public static void loadFontTable(JTable table) {
        // Set title font size
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 16));

        // Set title alignment to center
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);

        // Increase header height
        header.setPreferredSize(new Dimension(header.getWidth(), 40));
    }

    //<editor-fold defaultstate="collapsed" desc="Phương thức">
    private void loadMonAn() {
        txbMaMonAn.setText("");
        txbTenMonAn.setText("");
        txbDVT.setText("");
        txbGia.setText("");
        txbAnh.setText("");
        txbChonAnh.setEnabled(false);

        btnLuuMonAn.setEnabled(false);
        btnHuyMonAn.setEnabled(false);

        btnThemMonAn.setEnabled(true);
        btnXoaMonAn.setEnabled(true);
        btnSuaMonAn.setEnabled(true);
        btnLoadMonAn.setEnabled(true);
    }

    private void loadComboBoxTKTenNV() throws SQLException {
        listNV = (ArrayList<NhanVienDTO>) nv.layDSNV();
        DefaultComboBoxModel model2 = (DefaultComboBoxModel) cbTKTenNV.getModel();
        int startingIndex = 1; // Chỉ số index bắt đầu thêm dữ liệu

        // Thêm dữ liệu từ index 1
        for (NhanVienDTO nv : listNV) {
            model2.insertElementAt(nv.getHoten(), startingIndex++);
        }
    }

    // Renderer cho cột ngày
    private class DateRenderer extends DefaultTableCellRenderer {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof Date) {
                value = sdf.format(value);
            }
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }

    public class CurrencyRenderer extends DefaultTableCellRenderer {

        DecimalFormat df = new DecimalFormat("#,### VND");

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Canh phải dữ liệu trong ô
            setHorizontalAlignment(RIGHT);

            if (value instanceof Double) {
                value = df.format(value);
            }
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }
    
    public void loadDSTK() throws SQLException {
        List<TaiKhoanDTO> listTK = TaiKhoanDAO.getInstance().layDSTK();
        DefaultTableModel model = (DefaultTableModel) tableDSTK.getModel();
        model.setRowCount(0);
        for (TaiKhoanDTO tk : listTK) {
            Object[] row = {tk.getTendangnhap(), tk.getManhanvien(), tk.getTenhienthi(), tk.getTrangthai()};
            model.addRow(row);
        }
    }

    public void loadMaNhanVientoComboBox() throws SQLException {
        // Lấy danh sách mã nhân viên từ cơ sở dữ liệu
        List<String> listMaNhanVien = TaiKhoanDAO.getInstance().layDSMaNhanVien();

        // Xóa toàn bộ items hiện có trong JComboBox (nếu có)
        cbMaNV.removeAllItems();

        // Thêm mã nhân viên vào JComboBox
        for (String maNhanVien : listMaNhanVien) {
            cbMaNV.addItem(maNhanVien);
        }
    }

    public void loadTenNhanVientoComboBox() throws SQLException {
        // Lấy danh sách mã nhân viên từ cơ sở dữ liệu
        List<String> listTenNhanVien = TaiKhoanDAO.getInstance().layDSTenNhanVien();

        // Xóa toàn bộ items hiện có trong JComboBox (nếu có)
        cbTenNV.removeAllItems();

        // Thêm mã nhân viên vào JComboBox
        for (String maNhanVien : listTenNhanVien) {
            cbTenNV.addItem(maNhanVien);
        }
    }

    public void loadLuongNVtoComboBox() throws SQLException {
        // Lấy danh sách lương nhân viên từ cơ sở dữ liệu
        List<NhanVienDTO> listNhanVien = NhanVienDAO.getInstance().layDSNV();

        // Sử dụng Set để lưu trữ các giá trị lương duy nhất
        Set<Double> uniqueLuong = new HashSet<>();

        // Xóa toàn bộ items hiện có trong JComboBox (nếu có)
        cbLuongSearch.removeAllItems();

        // Thêm lương nhân viên vào Set để loại bỏ các giá trị trùng lặp
        for (NhanVienDTO nhanVien : listNhanVien) {
            uniqueLuong.add(nhanVien.getLuongcoban());
        }

        // Thêm các giá trị lương duy nhất vào JComboBox
        for (Double luong : uniqueLuong) {
            cbLuongSearch.addItem(String.valueOf(luong));
        }
    }

    public void loadTrangThaitoComboBox() throws SQLException {
        // Lấy danh sách mã nhân viên từ cơ sở dữ liệu
        List<String> listTenNhanVien = TaiKhoanDAO.getInstance().layDSTrangThai();

        // Xóa toàn bộ items hiện có trong JComboBox (nếu có)
        cbTrangThai.removeAllItems();

        // Thêm mã nhân viên vào JComboBox
        for (String maNhanVien : listTenNhanVien) {
            cbTrangThai.addItem(maNhanVien);
        }
    }

    private boolean ResetPass(String tendangnhap) {
        return TaiKhoanDAO.getInstance().ResetPassWord(tendangnhap);
    }

    private boolean themTK(String tendangnhap, String manhanvien, String tenhienthi, String trangthai) {
        return TaiKhoanDAO.getInstance().themTK(tendangnhap, manhanvien, tenhienthi, trangthai);
    }

    public void loadDSNV() throws SQLException {
        List<NhanVienDTO> listNV = NhanVienDAO.getInstance().layDSNV();
        DefaultTableModel model = (DefaultTableModel) tableDSNV.getModel();
        model.setRowCount(0);

        for (NhanVienDTO nv : listNV) {
            Object[] row = {nv.getManhanvien(), nv.getHoten(), nv.getPhai(), nv.getNgaysinh(), nv.getDiachi(), nv.getSdt(), nv.getNgayvaolam(), nv.getLuongcoban()};
            model.addRow(row);
        }

        // Thiết lập chiều rộng của từng cột
        int[] columnWidths = {80, 200, 80, 150, 300, 150, 150, 200}; // Chiều rộng mong muốn cho từng cột
        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = tableDSNV.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }

        // Thêm renderer cho cột ngày sinh và lương cơ bản
        tableDSNV.getColumnModel().getColumn(3).setCellRenderer(new DateRenderer());
        tableDSNV.getColumnModel().getColumn(7).setCellRenderer(new CurrencyRenderer());
    }

    // Định nghĩa hàm refreshTable để cập nhật bảng với danh sách nhân viên
    private void refreshTable(List<NhanVienDTO> list) {
        // Lấy mô hình của bảng
        DefaultTableModel model = (DefaultTableModel) tableDSNV.getModel();

        // Xóa tất cả các hàng hiện có trong bảng
        model.setRowCount(0);

        // Duyệt qua danh sách nhân viên và thêm từng nhân viên vào bảng
        for (NhanVienDTO nv : list) {
            model.addRow(new Object[]{nv.getManhanvien(), nv.getHoten(), nv.getPhai(), nv.getNgaysinh(), nv.getDiachi(), nv.getSdt(), nv.getNgayvaolam(), nv.getLuongcoban()});
        }

        // Thiết lập chiều rộng của từng cột
        int[] columnWidths = {80, 200, 80, 150, 300, 150, 150, 200}; // Chiều rộng mong muốn cho từng cột
        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = tableDSNV.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }

        // Thêm renderer cho cột ngày sinh và lương cơ bản
        tableDSNV.getColumnModel().getColumn(3).setCellRenderer(new DateRenderer());
        tableDSNV.getColumnModel().getColumn(7).setCellRenderer(new CurrencyRenderer());
    }

    // Định nghĩa hàm refreshTable để cập nhật bảng với danh sách nhân viên
    private void refreshTableLMA(List<LoaiMonAnDTO> list) {
        // Lấy mô hình của bảng
        DefaultTableModel model = (DefaultTableModel) tableDSLoaiMonAn.getModel();

        // Xóa tất cả các hàng hiện có trong bảng
        model.setRowCount(0);

        // Duyệt qua danh sách nhân viên và thêm từng nhân viên vào bảng
        for (LoaiMonAnDTO lma : list) {
            model.addRow(new Object[]{lma.getMaloaimonan(), lma.getTenloaimonan()});
        }
    }

    private void loadNV() {
        txbMaNV.setText("");
        txbHoTenNV.setText("");
        txbDiaChiNV.setText("");
        txbSDTNV.setText("");
        txbLCB.setText("");

        txbMaNV.setEditable(false);
        txbHoTenNV.setEditable(false);
        txbDiaChiNV.setEditable(false);
        txbSDTNV.setEditable(false);
        txbLCB.setEditable(false);
        cbSex.setEditable(false);
        dateNgaySinh.setEnabled(false);
        dateNgayVaoLam.setEnabled(false);

        btnLoadNV.setEnabled(true);
        btnLuuNV.setEnabled(false);
        btnHuyNV.setEnabled(false);

        btnThemNV.setEnabled(true);
        btnXoaNV.setEnabled(true);
        btnSuaNV.setEnabled(true);

        flag = false;

        try {
            loadDSNV();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Định nghĩa DocumentListener và phương thức searchEmployee trong một
    DocumentListener documentListener = new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            searchEmployee();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            searchEmployee();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            searchEmployee();
        }

        private void searchEmployee() {
            String str_tennv = txbSearchNV.getText().trim();

            try {
                // Tìm kiếm nhân viên theo tên
                List<NhanVienDTO> listEmployee = NhanVienDAO.getInstance().timNVTheoTen(str_tennv);

                // Cập nhật bảng với kết quả tìm kiếm
                refreshTable(listEmployee);
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };

    // Khai báo một ActionListener cho JComboBox
    ActionListener luongSearchListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Lấy giá trị lương được chọn từ JComboBox
            double selectedLuong = Double.parseDouble(cbLuongSearch.getSelectedItem().toString());

            try {
                // Thực hiện tìm kiếm nhân viên theo lương
                List<NhanVienDTO> listNhanVien = NhanVienDAO.getInstance().timNVTheoLuong(selectedLuong);

                // Cập nhật bảng với danh sách nhân viên được tìm thấy
                refreshTable(listNhanVien);
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };

    // Khai báo một ActionListener cho JComboBox
    ActionListener gioitinhSearchListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Lấy giá trị lương được chọn từ JComboBox
            String gioitinh = cbSexSearch.getSelectedItem().toString().trim();

            try {
                // Thực hiện tìm kiếm nhân viên theo lương
                List<NhanVienDTO> listNhanVien = NhanVienDAO.getInstance().timNVTheoGioiTinh(gioitinh);

                // Cập nhật bảng với danh sách nhân viên được tìm thấy
                refreshTable(listNhanVien);
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };

    public class CenterRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setHorizontalAlignment(CENTER); // Canh giữa dữ liệu trong ô
            return component;
        }
    }

    public class RightRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setHorizontalAlignment(RIGHT); // Canh phải dữ liệu trong ô
            return component;
        }
    }

    public void loadFirstPage() {
        currentPage = 1;
        try {
            loadTKDSHD();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        txbPage.setText(Integer.toString(currentPage));
    }

    public void loadTKDSHD() throws SQLException {
        // Lấy danh sách bàn và nhân viên từ cơ sở dữ liệu
        DefaultTableModel modelCTHD = (DefaultTableModel) tableTKCTHD.getModel();
        modelCTHD.setRowCount(0); // Xóa dữ liệu khỏi bảng tableTKCTHD

        listNV = (ArrayList<NhanVienDTO>) nv.layDSNV();

        // Lấy ngày bắt đầu và kết thúc từ các thành phần ngày tháng trên giao diện
        Date dateNgayBatDau = dateTKNBD.getDate();
        Date dateNgayKetThuc = dateTKNKT.getDate();

        // Kiểm tra ngày bắt đầu phải nhỏ hơn ngày kết thúc
        if (dateNgayBatDau != null && dateNgayKetThuc != null && dateNgayBatDau.after(dateNgayKetThuc)) {
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu phải nhỏ hơn ngày kết thúc.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tableTKDSHD.getModel();
        model.setRowCount(0);

        String tennv = cbTKTenNV.getSelectedItem().toString();
        String manv = null;

        if (!tennv.equals("Tất cả")) {
            // Tìm mã nhân viên dựa trên tên nhân viên
            for (NhanVienDTO nv : listNV) {
                if (nv.getHoten().equals(tennv)) {
                    manv = nv.getManhanvien();
                    break;
                }
            }
            // Lấy danh sách hóa đơn cho nhân viên được chọn
            listHD = HoaDonDAO.getInstance().layTKDSHDtheoTenNV(dateNgayBatDau, dateNgayKetThuc, manv);
        } else {
            // Lấy danh sách hóa đơn cho tất cả nhân viên
            listHD = HoaDonDAO.getInstance().layTKDSHD(dateNgayBatDau, dateNgayKetThuc);
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String strNgayBatDau = dateFormat.format(dateNgayBatDau);
        String strNgayKetThuc = dateFormat.format(dateNgayKetThuc);

        if (listHD == null || listHD.isEmpty()) {
            txbPage.setText("1");
            JOptionPane.showMessageDialog(this, "Không có hóa đơn vào khoảng thời gian từ " + strNgayBatDau + " - " + strNgayKetThuc);
            return; // Dừng chương trìnhD
        }

        // Hiển thị dữ liệu trên bảng và tính tổng doanh thu
        int startIndex = (currentPage - 1) * rowsPerPage;
        int endIndex = Math.min(startIndex + rowsPerPage, listHD.size());
        for (int i = startIndex; i < endIndex; i++) {
            HoaDonDTO hd = listHD.get(i);
            String tenNhanVien = "";
            for (NhanVienDTO nv : listNV) {
                if (nv.getManhanvien().equals(hd.getManhanvien())) {
                    tenNhanVien = nv.getHoten();
                    break;
                }
            }

            Object[] row = {hd.getMahoadon(), ("Bàn " + hd.getMaban()), tenNhanVien, hd.getNgayvao(), hd.getNgayra(), hd.getThanhtien()};
            model.addRow(row);
        }

        // Thiết lập chiều rộng của từng cột
        int[] columnWidths = {70, 120, 180, 110, 110, 160};
        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = tableTKDSHD.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }

        // Thêm renderer cho cột ngày sinh và lương cơ bản
        tableTKDSHD.getColumnModel().getColumn(0).setCellRenderer(new CenterRenderer());
        tableTKDSHD.getColumnModel().getColumn(1).setCellRenderer(new CenterRenderer());
        tableTKDSHD.getColumnModel().getColumn(3).setCellRenderer(new DateRenderer());
        tableTKDSHD.getColumnModel().getColumn(4).setCellRenderer(new DateRenderer());

        // Áp dụng renderer cho cột số tiền
        tableTKDSHD.getColumnModel().getColumn(5).setCellRenderer(new CurrencyRenderer());

        // Hiển thị tổng doanh thu
        DecimalFormat df = new DecimalFormat("#,### VND");
        txbDoanhThu.setText(df.format(tongDoanhThu()));
        txbDoanhThuChart.setText(df.format(tongDoanhThu()));
    }

    private double tongDoanhThu() {
        double tong = 0;
        for (HoaDonDTO hd : listHD) {
            tong += hd.getThanhtien();
        }
        return tong;
    }

    private void updateTableData(int currentPage, int rowsPerPage) throws SQLException {
        // Lấy chỉ số bắt đầu và kết thúc của dữ liệu trang hiện tại       
        int startIndex = (currentPage - 1) * rowsPerPage;
        int endIndex = Math.min(startIndex + rowsPerPage, listHD.size());

        // Xóa dữ liệu hiện tại trên bảng
        DefaultTableModel model = (DefaultTableModel) tableTKDSHD.getModel();
        model.setRowCount(0);

        // Hiển thị dữ liệu của trang hiện tại trên bảng
        for (int i = startIndex; i < endIndex; i++) {
            HoaDonDTO hd = listHD.get(i);

            String tenNhanVien = "";
            for (NhanVienDTO nv : listNV) {
                if (nv.getManhanvien().equals(hd.getManhanvien())) {
                    tenNhanVien = nv.getHoten();
                    break;
                }
            }
            Object[] row = {hd.getMahoadon(), ("Bàn " + hd.getMaban()), tenNhanVien, hd.getNgayvao(), hd.getNgayra(), hd.getThanhtien()};
            model.addRow(row);
        }

        // Thiết lập chiều rộng của từng cột
        int[] columnWidths = {70, 120, 180, 110, 110, 160};
        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = tableTKDSHD.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }

        // Thêm renderer cho cột ngày sinh và lương cơ bản
        tableTKDSHD.getColumnModel().getColumn(0).setCellRenderer(new CenterRenderer());
        tableTKDSHD.getColumnModel().getColumn(1).setCellRenderer(new CenterRenderer());
        tableTKDSHD.getColumnModel().getColumn(3).setCellRenderer(new DateRenderer());
        tableTKDSHD.getColumnModel().getColumn(4).setCellRenderer(new DateRenderer());

        // Áp dụng renderer cho cột số tiền
        tableTKDSHD.getColumnModel().getColumn(5).setCellRenderer(new CurrencyRenderer());

        // Hiển thị tổng doanh thu của trang hiện tại
        DecimalFormat df = new DecimalFormat("#,### VND");
        txbDoanhThu.setText(df.format(tongDoanhThu()));
        txbDoanhThuChart.setText(df.format(tongDoanhThu()));
    }

    private void updateTableDataNV(int currentPage, int rowsPerPage) throws SQLException {
        // Lấy chỉ số bắt đầu và kết thúc của dữ liệu trang hiện tại       
        int startIndex = (currentPage - 1) * rowsPerPage;
        int endIndex = Math.min(startIndex + rowsPerPage, listHD.size());

        // Xóa dữ liệu hiện tại trên bảng
        DefaultTableModel model = (DefaultTableModel) tableTKDSHD_NV.getModel();
        model.setRowCount(0);

        // Hiển thị dữ liệu của trang hiện tại trên bảng
        for (int i = startIndex; i < endIndex; i++) {
            HoaDonDTO hd = listHD.get(i);

            String tenNhanVien = "";
            for (NhanVienDTO nv : listNV) {
                if (nv.getManhanvien().equals(hd.getManhanvien())) {
                    tenNhanVien = nv.getHoten();
                    break;
                }
            }
            Object[] row = {hd.getMahoadon(), ("Bàn " + hd.getMaban()), tenNhanVien, hd.getNgayvao(), hd.getNgayra(), hd.getThanhtien()};
            model.addRow(row);
        }

        // Thiết lập chiều rộng của từng cột
        int[] columnWidths = {70, 80, 180, 110, 110, 150};
        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = tableTKDSHD_NV.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }

        // Thêm renderer cho cột ngày sinh và lương cơ bản
        tableTKDSHD_NV.getColumnModel().getColumn(0).setCellRenderer(new CenterRenderer());
        tableTKDSHD_NV.getColumnModel().getColumn(1).setCellRenderer(new CenterRenderer());
        tableTKDSHD_NV.getColumnModel().getColumn(3).setCellRenderer(new DateRenderer());
        tableTKDSHD_NV.getColumnModel().getColumn(4).setCellRenderer(new DateRenderer());

        // Áp dụng renderer cho cột số tiền
        tableTKDSHD_NV.getColumnModel().getColumn(5).setCellRenderer(new CurrencyRenderer());

        // Hiển thị tổng doanh thu của trang hiện tại
        DecimalFormat df = new DecimalFormat("#,### VND");
        txbDoanhThu.setText(df.format(tongDoanhThu()));
        txbDoanhThuChart.setText(df.format(tongDoanhThu()));
    }

    public void loadFirstPage_NV() {
        currentPage = 1;
        try {
            loadTKDSHD_NV();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        txbPage_NV.setText(Integer.toString(currentPage));
    }

    public void loadTKDSHD_NV() throws SQLException {
        // Lấy danh sách bàn và nhân viên từ cơ sở dữ liệu
        DefaultTableModel modelCTHD = (DefaultTableModel) tableTKCTHD_NV.getModel();
        modelCTHD.setRowCount(0); // Xóa dữ liệu khỏi bảng tableTKCTHD    

        // Lấy ngày bắt đầu và kết thúc từ các thành phần ngày tháng trên giao diện
        Date dateNgayBatDau = dateTKNBD_NV.getDate();
        Date dateNgayKetThuc = dateTKNKT_NV.getDate();

        // Kiểm tra ngày bắt đầu phải nhỏ hơn ngày kết thúc
        if (dateNgayBatDau != null && dateNgayKetThuc != null && dateNgayBatDau.after(dateNgayKetThuc)) {
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu phải nhỏ hơn ngày kết thúc.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tableTKDSHD_NV.getModel();
        model.setRowCount(0);

        String maNhanVien = "";
        if (login != null) {
            maNhanVien = login.getManhanvien();
        } else {
            JOptionPane.showMessageDialog(this, "Lỗi");
        }
        listHD = HoaDonDAO.getInstance().layTKDSHDtheoTenNV(dateNgayBatDau, dateNgayKetThuc, maNhanVien);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String strNgayBatDau = dateFormat.format(dateNgayBatDau);
        String strNgayKetThuc = dateFormat.format(dateNgayKetThuc);

        if (listHD == null || listHD.isEmpty()) {
            txbPage.setText("1");
            JOptionPane.showMessageDialog(this, "Không có hóa đơn vào khoảng thời gian từ " + strNgayBatDau + " - " + strNgayKetThuc);
            return; // Dừng chương trìnhD
        }

        // Hiển thị dữ liệu trên bảng và tính tổng doanh thu
        int startIndex = (currentPage - 1) * rowsPerPage;
        int endIndex = Math.min(startIndex + rowsPerPage, listHD.size());
        for (int i = startIndex; i < endIndex; i++) {
            HoaDonDTO hd = listHD.get(i);
            String tenNhanVien = "";
            for (NhanVienDTO nv : listNV) {
                if (nv.getManhanvien().equals(hd.getManhanvien())) {
                        tenNhanVien = nv.getHoten();
                    break;
                }
            }

            Object[] row = {hd.getMahoadon(), ("Bàn " + hd.getMaban()), tenNhanVien, hd.getNgayvao(), hd.getNgayra(), hd.getThanhtien()};
            model.addRow(row);
        }

        // Thiết lập chiều rộng của từng cột
        int[] columnWidths = {70, 80, 180, 110, 110, 150};
        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = tableTKDSHD_NV.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }

        // Thêm renderer cho cột ngày sinh và lương cơ bản
        tableTKDSHD_NV.getColumnModel().getColumn(0).setCellRenderer(new CenterRenderer());
        tableTKDSHD_NV.getColumnModel().getColumn(1).setCellRenderer(new CenterRenderer());
        tableTKDSHD_NV.getColumnModel().getColumn(3).setCellRenderer(new DateRenderer());
        tableTKDSHD_NV.getColumnModel().getColumn(4).setCellRenderer(new DateRenderer());

        // Áp dụng renderer cho cột số tiền
        tableTKDSHD_NV.getColumnModel().getColumn(5).setCellRenderer(new CurrencyRenderer());

        // Hiển thị tổng doanh thu
        DecimalFormat df = new DecimalFormat("#,### VND");
        txbDoanhThu_NV.setText(df.format(tongDoanhThu()));
    }

    public void loadDateTK() {
        Date ngayHienTai = new Date();

        // Khởi tạo Calendar và thiết lập ngày hiện tại
        Calendar cal = Calendar.getInstance();
        cal.setTime(ngayHienTai);

        // Thiết lập ngày 1 của tháng và giờ, phút, giây, millisecond là 0
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        // Lấy ngày bắt đầu (ngày 1 của tháng)
        Date ngayBatDau = cal.getTime();

        // Thiết lập ngày cuối của tháng
        cal.add(Calendar.MONTH, 1); // Chuyển đến tháng tiếp theo
        cal.add(Calendar.DAY_OF_MONTH, -1); // Lùi lại một ngày để lấy ngày cuối của tháng
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);

        // Lấy ngày kết thúc (ngày cuối của tháng)
        Date ngayKetThuc = cal.getTime();

        dateTKNBD.setDate(ngayBatDau);
        dateTKNKT.setDate(ngayKetThuc);
        dateTKNBD_NV.setDate(ngayBatDau);
        dateTKNKT_NV.setDate(ngayKetThuc);
    }

    public void loadDataChange() {
        dateTKNBD.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    // Xử lý khi ngày bắt đầu thay đổi
                    try {
                        loadTKDSHD();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        // Xử lý ngoại lệ nếu cần
                    }
                }
            }
        });

        dateTKNKT.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    // Xử lý khi ngày kết thúc thay đổi
                    try {
                        loadTKDSHD();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        // Xử lý ngoại lệ nếu cần
                    }
                }
            }
        });

        cbTKTenNV.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // Xử lý khi dữ liệu trong JComboBox thay đổi
                    // Gọi phương thức loadTKDSHD() hoặc bất kỳ hoạt động nào bạn muốn thực hiện khi dữ liệu thay đổi
                    loadFirstPage(); // Xử lý ngoại lệ nếu cần
                }
            }
        });
    }

    public void loadDataChange_NV() {
        dateTKNBD_NV.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    // Xử lý khi ngày bắt đầu thay đổi
                    try {
                        loadTKDSHD_NV();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        // Xử lý ngoại lệ nếu cần
                    }
                }
            }
        });

        dateTKNKT_NV.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    // Xử lý khi ngày kết thúc thay đổi
                    try {
                        loadTKDSHD_NV();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        // Xử lý ngoại lệ nếu cần
                    }
                }
            }
        });
    }

    public void loadSearchPhieuNhap() {
        jdc_NgNhap_PN.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    // Xử lý khi ngày bắt đầu thay đổi
                    try {
                        loadDSPNTheoNgay();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        // Xử lý ngoại lệ nếu cần
                    }
                }
            }
        });
    }

    public void loadChartDoanhThu() throws SQLException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Lấy ngày bắt đầu và kết thúc từ các thành phần ngày tháng trên giao diện
        Date dateNgayBatDau = dateTKNBD.getDate();
        Date dateNgayKetThuc = dateTKNKT.getDate();
        listHD = HoaDonDAO.getInstance().layTKDSHD(dateNgayBatDau, dateNgayKetThuc);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String strNgayBatDau = dateFormat.format(dateNgayBatDau);
        String strNgayKetThuc = dateFormat.format(dateNgayKetThuc);

        if (listHD == null || listHD.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không có hóa đơn vào khoảng thời gian từ " + strNgayBatDau + " - " + strNgayKetThuc);
            return;
        }

        List<Double> doanhThuTheoNgay = new ArrayList<>();
        double doanhThuNgayHienTai = 0;
        Date ngayTruoc = null;

        for (HoaDonDTO hd : listHD) {
            Date ngayHoaDon = hd.getNgayra();

            if (ngayTruoc == null || !dateFormat.format(ngayHoaDon).equals(dateFormat.format(ngayTruoc))) {
                if (ngayTruoc != null) {
                    doanhThuTheoNgay.add(doanhThuNgayHienTai);
                    SimpleDateFormat dayMonthFormat = new SimpleDateFormat("dd/MM");
                    String ngayThang = dayMonthFormat.format(ngayTruoc);
                    dataset.addValue(doanhThuNgayHienTai, "Doanh thu", ngayThang);
                }
                doanhThuNgayHienTai = 0;
                ngayTruoc = ngayHoaDon;
            }
            doanhThuNgayHienTai += hd.getThanhtien();
        }
        doanhThuTheoNgay.add(doanhThuNgayHienTai);
        SimpleDateFormat dayMonthFormat = new SimpleDateFormat("dd/MM");
        String ngayThang = dayMonthFormat.format(ngayTruoc);
        dataset.addValue(doanhThuNgayHienTai, "Doanh thu", ngayThang);

        String title = "Thống kê doanh thu";
        String row = "Từ ngày " + strNgayBatDau + " - " + strNgayKetThuc;
        String col = "Doanh thu (VND)";
        // Create chart
        JFreeChart chart = ChartFactory.createBarChart(title, row, col, dataset);

        // Thiết lập font chữ cho tiêu đề của biểu đồ
        Font titleFont = new Font("Segoe UI", Font.BOLD, 24);
        chart.getTitle().setFont(titleFont);

        // Thiết lập font chữ cho nhãn trên trục x và trục y
        Font labelFont = new Font("Segoe UI", Font.BOLD, 16);
        CategoryPlot plot = chart.getCategoryPlot();
        plot.getDomainAxis().setLabelFont(labelFont); // Trục x
        plot.getRangeAxis().setLabelFont(labelFont); // Trục y

        // Set gridline color
        plot.setRangeGridlinePaint(Color.BLACK);

        // Tạo panel để chứa biểu đồ
        ChartPanel chartPanel = new ChartPanel(chart);

        // Đặt chiều rộng của mỗi cột (tính theo pixel)
        double columnWidth = 30.0; // Chiều rộng cố định cho mỗi cột

        // Tính toán chiều rộng của biểu đồ dựa trên số lượng cột và chiều rộng mỗi cột
        double chartWidth = dataset.getColumnCount() * columnWidth;

        // Đặt chiều rộng của biểu đồ
        Dimension chartDimension = new Dimension((int) chartWidth, 600);
        chartPanel.setPreferredSize(chartDimension);

        // Đặt khoảng cách giữa các cột
        plot.getDomainAxis().setCategoryMargin(0.1);

        // Xóa nội dung của panel hiện tại và thêm biểu đồ mới vào
        panelChart.removeAll();
        panelChart.setLayout(new BorderLayout());
        panelChart.add(chartPanel, BorderLayout.CENTER);
        panelChart.revalidate();
        panelChart.repaint();
    }

    public void loadDSNCC() throws SQLException {
        List<NhaCungCapDTO> listNCC = NhaCungCapDAO.getInstance().layDSNCC();
        DefaultTableModel model = (DefaultTableModel) table_dsNhaCungCap.getModel();
        model.setRowCount(0);
        for (NhaCungCapDTO ncc : listNCC) {
            Object[] row = {ncc.getMancc(), ncc.getTenncc(), ncc.getDiachi(), ncc.getEmail(), ncc.getSdt()};
            model.addRow(row);
        }
    }

    private void tinhToanThanhTien() {
        try {
            int soLuong = Integer.parseInt(txbSoLuongPN.getText());
            double donGia = Double.parseDouble(txbDonGiaPN.getText());
            double thanhTien = soLuong * donGia;

            // Định dạng số tiền và hiển thị lên ô nhập liệu
            DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
            txbThanhTienPN.setText(decimalFormat.format(thanhTien) + " VND");
        } catch (NumberFormatException e) {
            // Hiển thị thông báo lỗi và đặt lại giá trị ô nhập liệu thành 0
            JOptionPane.showMessageDialog(this, "Vui lòng nhập giá trị số!!!");
            txbThanhTienPN.setText("0");
        }
    }

    private double tinhTongTienCTPN(DefaultTableModel model) {
        double tongTien = 0;
        int rowCount = model.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            double thanhTien = (double) model.getValueAt(i, 5); // Cột thứ 6 là cột chứa thành tiền
            tongTien += thanhTien;
        }
        return tongTien;
    }

    // Phương thức để lấy danh sách chi tiết phiếu nhập từ dữ liệu
    private List<ChiTietPhieuNhapDTO> layDanhSachChiTietTuData() {
        List<ChiTietPhieuNhapDTO> danhSach = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) table_CTPN.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            String str_tenNL = (String) model.getValueAt(i, 0);
            int maNguyenLieu = NguyenLieuDAO.getInstance().layMaNLTheoTen(str_tenNL);
            double donGiaNhap = (double) model.getValueAt(i, 4);
            int soLuongNhap = (int) model.getValueAt(i, 3);

            ChiTietPhieuNhapDTO chiTiet = new ChiTietPhieuNhapDTO(maNguyenLieu, donGiaNhap, soLuongNhap);
            danhSach.add(chiTiet);
        }
        return danhSach;
    }

    private void loadDSPN() throws SQLException {
        List<PhieuNhapDTO> list = PhieuNhapDAO.getInstance().layDSPN();
        DefaultTableModel model = (DefaultTableModel) tableDsPhieuNhap.getModel();
        model.setRowCount(0);

        for (PhieuNhapDTO pn : list) {
            double tongtien = 0;
            List<ChiTietPhieuNhapDTO> listCTPN = ChiTietPhieuNhapDAO.getInstance().layDSPNtheoMaPN(pn.getMapn());
            for (ChiTietPhieuNhapDTO ctpn : listCTPN) {
                tongtien += (ctpn.getSoluongnhap() * ctpn.getDongianhap());
            }

            String tenNCC = NhaCungCapDAO.getInstance().layTenNCCTheoMa(pn.getMancc());
            Object[] row = {pn.getMapn(), tenNCC, pn.getNgaynhap(), tongtien};
            model.addRow(row);
        }

        // Thiết lập chiều rộng của từng cột
        int[] columnWidths = {50, 200, 100, 150}; // Chiều rộng mong muốn cho từng cột
        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = tableDsPhieuNhap.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }

        tableDsPhieuNhap.getColumnModel().getColumn(2).setCellRenderer(new DateRenderer());
        tableDsPhieuNhap.getColumnModel().getColumn(0).setCellRenderer(new CenterRenderer());
        tableDsPhieuNhap.getColumnModel().getColumn(3).setCellRenderer(new CurrencyRenderer());
    }

    private void loadDSPNTheoNgay() throws SQLException {
        Date ngay = jdc_NgNhap_PN.getDate();

        List<PhieuNhapDTO> list = PhieuNhapDAO.getInstance().timDSPNTheoNgay(ngay);
        DefaultTableModel model = (DefaultTableModel) tableDsPhieuNhap.getModel();
        model.setRowCount(0);

        for (PhieuNhapDTO pn : list) {
            double tongtien = 0;
            List<ChiTietPhieuNhapDTO> listCTPN = ChiTietPhieuNhapDAO.getInstance().layDSPNtheoMaPN(pn.getMapn());
            for (ChiTietPhieuNhapDTO ctpn : listCTPN) {
                tongtien += (ctpn.getSoluongnhap() * ctpn.getDongianhap());
            }

            String tenNCC = NhaCungCapDAO.getInstance().layTenNCCTheoMa(pn.getMancc());
            Object[] row = {pn.getMapn(), tenNCC, pn.getNgaynhap(), tongtien};
            model.addRow(row);
        }

        // Thiết lập chiều rộng của từng cột
        int[] columnWidths = {50, 200, 100, 150}; // Chiều rộng mong muốn cho từng cột
        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = tableDsPhieuNhap.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }

        tableDsPhieuNhap.getColumnModel().getColumn(2).setCellRenderer(new DateRenderer());
        tableDsPhieuNhap.getColumnModel().getColumn(0).setCellRenderer(new CenterRenderer());
        tableDsPhieuNhap.getColumnModel().getColumn(3).setCellRenderer(new CurrencyRenderer());
    }

    private void loadDSPNTheoMa() throws SQLException {
        String str_mapn = txbMaPhieuCanTim.getText().trim();
        if (str_mapn.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã phiếu cần tìm!!!");
            return;
        }

        int mapn = 0;
        try {
            mapn = Integer.parseInt(str_mapn);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Mã phiếu nhập là giá trị số!!!");
        }

        List<PhieuNhapDTO> list = PhieuNhapDAO.getInstance().timDSPNTheoMa(mapn);
        DefaultTableModel model = (DefaultTableModel) tableDsPhieuNhap.getModel();
        model.setRowCount(0);

        for (PhieuNhapDTO pn : list) {
            double tongtien = 0;
            List<ChiTietPhieuNhapDTO> listCTPN = ChiTietPhieuNhapDAO.getInstance().layDSPNtheoMaPN(pn.getMapn());
            for (ChiTietPhieuNhapDTO ctpn : listCTPN) {
                tongtien += (ctpn.getSoluongnhap() * ctpn.getDongianhap());
            }

            String tenNCC = NhaCungCapDAO.getInstance().layTenNCCTheoMa(pn.getMancc());
            Object[] row = {pn.getMapn(), tenNCC, pn.getNgaynhap(), tongtien};
            model.addRow(row);
        }

        // Thiết lập chiều rộng của từng cột
        int[] columnWidths = {50, 200, 100, 150}; // Chiều rộng mong muốn cho từng cột
        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = tableDsPhieuNhap.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }

        tableDsPhieuNhap.getColumnModel().getColumn(2).setCellRenderer(new DateRenderer());
        tableDsPhieuNhap.getColumnModel().getColumn(0).setCellRenderer(new CenterRenderer());
        tableDsPhieuNhap.getColumnModel().getColumn(3).setCellRenderer(new CurrencyRenderer());
    }

    private void loadPN() throws SQLException {
        txbNhaCungCap.setText("");
        cb_TenNguyenLieu_PN.removeAllItems();
        txbSoLuongPN.setText("");
        txbDonGiaPN.setText("");
        jdc_NgNhap.setDate(null);
        txbTongTienPN.setText("");
        txbThanhTienPN.setText("");
        btnChuyen.setEnabled(false);

        loadDSPN();
    }

    public void showLoaiMonAn() {
        listLMA = loaimonan.layDSLoaiMonAn();

        DefaultTableModel model = (DefaultTableModel) tableDSLoaiMonAn.getModel();
        tableDSLoaiMonAn.removeAll();
        model.getDataVector().clear();

        for (LoaiMonAnDTO k : listLMA) {
            model.addRow(new Object[]{k.getMaloaimonan(), k.getTenloaimonan()});
        }
    }

    public void loadTenLMAtoComboBox() throws SQLException {
        // Lấy danh sách lương nhân viên từ cơ sở dữ liệu
        listLMA = loaimonan.layDSLoaiMonAn();

        // Thêm lương nhân viên vào Set để loại bỏ các giá trị trùng lặp
        for (LoaiMonAnDTO ma : listLMA) {
            cbTenLoaiMonAn.addItem(ma.getTenloaimonan());
        }
    }

    // Khai báo một ActionListener cho JComboBox
    ActionListener tenLoaiMonAnSearchListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Lấy giá trị lương được chọn từ JComboBox
            String tenLoai = cbTenLoaiMonAn.getSelectedItem().toString().trim();

            // Thực hiện tìm kiếm nhân viên theo lương
            listMA = monan.layDSMonDcTK(tenLoai);
            // Cập nhật bảng với danh sách nhân viên được tìm thấy
            refreshTableMA(listMA);
        }
    };

    // Định nghĩa hàm refreshTable để cập nhật bảng với danh sách nhân viên
    private void refreshTableMA(List<MonAnDTO> list) {
        // Lấy mô hình của bảng
        DefaultTableModel model = (DefaultTableModel) tableDSMonAnTheoLoai.getModel();

        // Xóa tất cả các hàng hiện có trong bảng
        model.setRowCount(0);

        // Duyệt qua danh sách nhân viên và thêm từng nhân viên vào bảng
        for (MonAnDTO ma : list) {
            model.addRow(new Object[]{ma.getMaloaimonan(), ma.getTenmonan(), ma.getDvt(), ma.getDongia()});
        }
    }

    private void loadLMA() {
        showLoaiMonAn();

        txbSearchLMA.setText("");

        btnThemLMA.setEnabled(true);
        btnXoaLMA.setEnabled(true);
        btnSuaLMA.setEnabled(true);
        btnLoadLMA.setEnabled(true);

        btnLuuLMA.setEnabled(false);
        btnHuyLMA.setEnabled(false);
    }

    public void showMonAn() {
        listMA = monan.layDSMon();

        DefaultTableModel model = (DefaultTableModel) tableMonAn.getModel();
        model.setRowCount(0);

        for (MonAnDTO k : listMA) {
            model.addRow(new Object[]{k.getMamonan(), k.getTenmonan(), k.getDvt(), k.getDongia()});
        }

        // lấy tên loại món vào combobox
        DefaultComboBoxModel model1 = (DefaultComboBoxModel) cbLoaiMon.getModel();
        model1.removeAllElements();
        for (LoaiMonAnDTO k : listLMA) {
            model1.addElement(k.getTenloaimonan());
        }

        int[] columnWidths = {60, 460, 100, 150}; // Chiều rộng mong muốn cho từng cột
        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = tableMonAn.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }

        tableMonAn.getColumnModel().getColumn(0).setCellRenderer(new CenterTableCellRenderer());
        tableMonAn.getColumnModel().getColumn(2).setCellRenderer(new CenterTableCellRenderer());
        tableMonAn.getColumnModel().getColumn(3).setCellRenderer(new CurrencyRenderer());

        txbAnh.setEnabled(false);
    }

    public void loadCT() {
        cbCTTenNguyenLieu.setEnabled(false);
        cbCTTenMonAn.setEnabled(false);
        txbHamLuong.setEditable(false);
        txbCTDVT.setEditable(false);
        txbHamLuong.setText("");
        txbCTDVT.setText("");
        btnLuuCT.setEnabled(false);
        btnHuyCT.setEnabled(false);
        btnThemCT.setEnabled(true);
        btnXoaCT.setEnabled(true);
        btnSuaCT.setEnabled(true);
    }

    public void showAllCThuc() {
        listCThuc = CThuc.layDSCThuc();
        listNgLieu = ngLieu.layDSNLieu();

        DefaultTableModel model = (DefaultTableModel) tableDSCT.getModel();
        tableDSCT.removeAll();
        model.getDataVector().clear();

        for (CongThucDTO k : listCThuc) {
            model.addRow(new Object[]{k.getTenmonan(), k.getTennguyenlieu(), k.getSoluong(), k.getDonvi()});
        }

        //lấy tên món vào combobox
        DefaultComboBoxModel model1 = (DefaultComboBoxModel) cbCTTenMonAn.getModel();
        model1.removeAllElements();
        for (MonAnDTO k : listMA) {
            model1.addElement(k.getTenmonan());
        }

        DefaultComboBoxModel model2 = (DefaultComboBoxModel) cbCTTenNguyenLieu.getModel();
        model2.removeAllElements();
        for (NguyenLieuDTO k : listNgLieu) {
            model2.addElement(k.getTennguyenlieu());
        }

        DefaultTableModel model3 = (DefaultTableModel) tableNguyenLieu.getModel();
        tableNguyenLieu.removeAll();
        model3.getDataVector().clear();

        for (NguyenLieuDTO k : listNgLieu) {
            model3.addRow(new Object[]{k.getManguyenlieu(), k.getTennguyenlieu()});
        }
    }

    public void loadNL() {
        btnLuuNL.setEnabled(false);
        btnHuyNL.setEnabled(false);
        btnThemNL.setEnabled(true);
        btnXoaNL.setEnabled(true);
        btnSuaNL.setEnabled(true);
        txbMaNL.setText("");
        txbTenNL.setText("");
        txbTenNL.setEditable(false);
    }

    public void loadBan() {
        btnThemBan.setEnabled(true);
        btnSuaBan.setEnabled(true);
        btnXoaBan.setEnabled(true);

        btnLuuBan.setEnabled(false);
        btnHuyBan.setEnabled(false);
        txbSoChoNgoi.setEditable(true);
        txbSoChoNgoi.setText("");
        txbMaBan.setText("");
        cbTrangThaiBan.setEnabled(false);
    }

    public void loadDSBan() {
        jpanelDSBan.removeAll();
        listBan = ban.layDSBan();

        // Số bàn trên mỗi hàng
        int bPerRow = 5;

        // Số hàng được tính dựa trên số lượng bàn và số bàn trên mỗi hàng
        int rows = (int) Math.ceil((double) listBan.size() / bPerRow);

        // Thiết lập GridLayout cho jPanel116
        jpanelDSBan.setLayout(new GridLayout(rows, bPerRow, 30, 30));

        int count = 0; // đếm số lượng bàn trong 1 dòng;
        for (BanDTO a : listBan) {
            // Tạo biến để lưu đường dẫn của biểu tượng
            String iconPath = "/view/icon/";
            if (a.getTrangthai().equals("Có người")) {
                iconPath += "icons8-restaurant-table-96.png";
            } else {
                iconPath += "icons8-restaurant-table-nobody-96.png";
            }

            // Tạo JLabel để hiển thị icon của bàn và mã
            JLabel lBan = new JLabel();
            lBan.setIcon(new ImageIcon(getClass().getResource(iconPath)));
            lBan.setText(String.valueOf("Bàn " + a.getMaban()));
            lBan.setHorizontalTextPosition(JLabel.CENTER); //căn giữa mã bàn theo chiều ngang
            lBan.setVerticalTextPosition(JLabel.BOTTOM); // đặt mã bàn dưới icon
            lBan.setPreferredSize(new Dimension(120, 120));  // lập kích thước cho JLabel

            // Thêm lBan vào rowPanel
            jpanelDSBan.add(lBan);
            count++;

            // Gán sự kiện MouseListener cho lBan
            lBan.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);

                    // Lấy mã bàn từ JLabel
                    String maBanText = lBan.getText();
                    // Sử dụng biểu thức chính quy để lấy số từ chuỗi
                    Pattern pattern = Pattern.compile("\\d+"); // Biểu thức chính quy để lấy số từ chuỗi
                    Matcher matcher = pattern.matcher(maBanText);
                    int maBan = 0;
                    if (matcher.find()) {
                        maBan = Integer.parseInt(matcher.group()); // Lấy số từ kết quả của matcher
                        // Sử dụng số mã bàn ở đây
                    } else {
                        // Không tìm thấy số, xử lý tương ứng
                    }

                    // Lấy thông tin chi tiết của bàn từ mã bàn
                    BanDTO selectedBan = ban.layTTTheoMaBan(maBan);

                    // Nếu bàn được chọn không tồn tại, không làm gì cả
                    if (selectedBan == null) {
                        return;
                    }

                    // Gán thông tin vào các trường JTextField và JComboBox
                    txbMaBan.setText(String.valueOf(selectedBan.getMaban()));
                    txbSoChoNgoi.setText(String.valueOf(selectedBan.getSoluongnguoi()));
                    cbTrangThaiBan.setSelectedItem(selectedBan.getTrangthai());
                }
            });

            // Nếu đã đủ số bàn trên mỗi hàng, tạo một dòng mới
            if (count == bPerRow) {
                count = 0; // Reset biến đếm
            }

            // Lấy TRẠNG THÁI vào combobox
            DefaultComboBoxModel model1 = (DefaultComboBoxModel) cbTrangThaiBan.getModel();
            model1.removeAllElements();
            for (BanDTO k : listBan) {
                model1.addElement(k.getTrangthai());
            }
        }
        // Cập nhật giao diện sau khi thay đổi
        jpanelDSBan.revalidate();
        jpanelDSBan.repaint();
    }

    private void exportBill() {
        XuatHoaDon xuatHoaDon = new XuatHoaDon(idTable, this);
        xuatHoaDon.setVisible(true);
    }

    private void settingJTableBillDetails() {
        jTableBillDetails.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        int[] columnWidths = {230, 50, 140, 160}; // Chiều rộng mong muốn cho từng cột
        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = jTableBillDetails.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }

        jTableBillDetails.getColumnModel().getColumn(1).setCellRenderer(new CenterTableCellRenderer());
        jTableBillDetails.getColumnModel().getColumn(2).setCellRenderer(new RightTableCellRenderer());
        jTableBillDetails.getColumnModel().getColumn(3).setCellRenderer(new RightTableCellRenderer());
    }

    // Xóa hết tất cả các bàn
    private void deleteTab(JPanel jPanelTable) {
        jPanelTable.removeAll();
    }

    private void loadTable() {
        deleteTab(jPanelTables);
        jPanelTables.setLayout(new GridLayout(3, 0));
        ArrayList<BanDTO> banDTOs = BanDAO.getInstance().getTables();

        JPanel jPanelRow = null;

        for (int i = 0; i < banDTOs.size(); i++) {
            // tạo 1 dòng trong danh sách bàn khi bắt đầu or sẽ tạo 1 dòng mới khi dòng cũ đã có 6 bàn
            if (i % 6 == 0) {
                jPanelRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 15));
                // add dòng vào danh sách bàn
                jPanelTables.add(jPanelRow);
            }

            // Tạo bàn
            BanDTO tableChooserBanDTO = banDTOs.get(i);
            JPanel jPanelTable = new JPanel(new BorderLayout());

            if (tableChooserBanDTO.getMaban() == idTable) {
                jPanelTable.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.RED), "Bàn " + tableChooserBanDTO.getMaban(), TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM));
                selectedTable = jPanelTable;
                selectedTableId = tableChooserBanDTO.getMaban();
            } else {
                jPanelTable.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.BLUE), "Bàn " + tableChooserBanDTO.getMaban(), TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM));
            }

            // gán icon cho bàn
            JLabel jLabelIcon = new JLabel();

            ImageIcon icon;
            if (tableChooserBanDTO.getTrangthai().equals("Có người")) {
                icon = new ImageIcon(getClass().getResource("/view/icon/icons8-restaurant-table-50.png"));
            } else if (tableChooserBanDTO.getTrangthai().equals("Trống")) {
                icon = new ImageIcon(getClass().getResource("/view/icon/icons8-restaurant-table-nobody-50.png"));
            } else if (tableChooserBanDTO.getTrangthai().equals("Đã đặt")) {
                icon = new ImageIcon(getClass().getResource("/view/icon/icons8-restaurant-table-haveorder-50.png"));
            } else {
                continue;
            }

            Image image = icon.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
            jLabelIcon.setIcon(new ImageIcon(image));

            jPanelTable.add(jLabelIcon, BorderLayout.CENTER);

            // đặt kích thước bàn
            jPanelTable.setPreferredSize(new Dimension(80, 80)); // Sử dụng setPreferredSize thay cho setSize

            // bắt sự kiện click cho từng bàn
            jPanelTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (selectedTable != null) {
                        selectedTable.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.BLUE), "Bàn " + selectedTableId, TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM));
                    }

                    jPanelTable.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.RED), "Bàn " + tableChooserBanDTO.getMaban(), TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM));

                    selectedTable = jPanelTable;
                    selectedTableId = tableChooserBanDTO.getMaban();

                    idTable = tableChooserBanDTO.getMaban();
                    jLabelChooseDish.setEnabled(true);

                    jTextAreaOrderInfor.setText("Chưa có thông tin!");
                    defaultTableModelBillDetails.setRowCount(0);
                    jTextFieldSelectedTable.setText("Bàn " + idTable);

                    if (tableChooserBanDTO.getTrangthai().equals("Có người")) {
                        loadBill();
                        jLabelSwitchTable.setEnabled(true);
                        jLabelCombineTable.setEnabled(true);
                    } else {
                        jLabelSwitchTable.setEnabled(false);
                        jLabelCombineTable.setEnabled(false);
                    }

                    if (tableChooserBanDTO.getTrangthai().equals("Trống")) {
                        jLabelOrderTable.setEnabled(true);
                    } else {
                        jLabelOrderTable.setEnabled(false);
                    }

                    if (tableChooserBanDTO.getTrangthai().equals("Đã đặt")) {
                        loadInforOrderTable();
                        jLabelCancelOrder.setEnabled(true);
                    } else {
                        jLabelCancelOrder.setEnabled(false);
                    }
                }

            });

            // add bàn vào dòng
            jPanelRow.add(jPanelTable);

        }

        jPanelTables.revalidate(); // Cập nhật bố cục
        jPanelTables.repaint();    // Vẽ lại
    }

    private void loadInforOrderTable() {
        ThongTinDatBanDTO thongTinDatBanDTO = ThongTinDatBanDAO.getInstance().getInforOrderTable(idTable);

        if (thongTinDatBanDTO != null) {
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            StringBuilder infor = new StringBuilder();
            infor.append("Họ và tên: ").append(thongTinDatBanDTO.getHotenkh()).append("\n");
            infor.append("Số điện thoại: ").append(thongTinDatBanDTO.getSdt()).append("\n");
            infor.append("Thời gian: ").append(timeFormat.format(thongTinDatBanDTO.getNgaydat())).append(" ").append(dateFormat.format(thongTinDatBanDTO.getNgaydat()));
            jTextAreaOrderInfor.setText(infor.toString());
        }
    }

    private void loadBill() {
        double total = 0;

        HoaDonDTO hoaDonDTO = HoaDonDAO.getInstance().getBillByTableId(idTable);

        if (hoaDonDTO != null) {
            ArrayList<ChiTietHoaDonDTO> chiTietHoaDonDTOs = ChiTietHoaDonDAO.getInstance().getBillDetailsByBillId(hoaDonDTO.getMahoadon());

            for (ChiTietHoaDonDTO chiTietHoaDonDTO : chiTietHoaDonDTOs) {
                MonAnDTO monAnDTO = MonAnDAO.getInstance().getDishById(chiTietHoaDonDTO.getMamonan());

                if (monAnDTO != null) {
                    defaultTableModelBillDetails.addRow(new Object[]{monAnDTO.getTenmonan(), chiTietHoaDonDTO.getSoluong(), Utils.VNDCurrencyFormat(monAnDTO.getDongia()), Utils.VNDCurrencyFormat(monAnDTO.getDongia() * chiTietHoaDonDTO.getSoluong())});
                    total += monAnDTO.getDongia() * chiTietHoaDonDTO.getSoluong();
                } else {
                    JOptionPane.showMessageDialog(this, "Không thể lấy thông tin món ăn!!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        jLabelTotal.setText(Utils.VNDCurrencyFormat(total));
        jLabelWordTotal.setText("Bằng chữ: " + NumToVND.num2String((long) total) + " đồng.");
    }

    // load giao diện chọn món
    private void chooseDish(int idTable) {
        setVisible(false);
        ChonMonAn chonMonAn = new ChonMonAn(idTable, login.getManhanvien(), this);
        chonMonAn.setVisible(true);
    }

    private void switchTable() {
        setVisible(false);
        ChuyenBan chuyenBan = new ChuyenBan(idTable, this);
        chuyenBan.setVisible(true);
    }

    private void combineTable() {
        setVisible(false);
        GopBan gopBan = new GopBan(idTable, this);
        gopBan.setVisible(true);
    }

    private void orderTable() {
        DatBan datBan = new DatBan(idTable, this);
        datBan.setVisible(true);
    }

    private void cancelOrder() {
        if (JOptionPane.showConfirmDialog(this, "Xác nhận hủy thông tin đặt bàn này?", "Thông báo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
            ThongTinDatBanDTO thongTinDatBanDTO = ThongTinDatBanDAO.getInstance().getInforOrderTable(idTable);
            if (thongTinDatBanDTO != null) {
                if (ThongTinDatBanDAO.getInstance().removeInforOrderTable(thongTinDatBanDTO.getMattdb()) && BanDAO.getInstance().updateTableStatus(idTable, "Trống")) {
                    JOptionPane.showMessageDialog(this, "Hủy đặt bàn thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    reload();
                } else {
                    JOptionPane.showMessageDialog(this, "Không thể hủy thông tin đặt bàn!!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Không thể lấy thông tin đặt bàn!!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void reload() {
        // Tony
        loadTable();

        jTextAreaOrderInfor.setText("Chưa có thông tin!");
        defaultTableModelBillDetails.setRowCount(0);

        BanDTO banDTO = BanDAO.getInstance().getTableById(idTable);

        if (banDTO != null) {
            jTextFieldSelectedTable.setText("Bàn " + idTable);

            if (banDTO.getTrangthai().equals("Có người")) {
                loadBill();
                jLabelSwitchTable.setEnabled(true);
                jLabelCombineTable.setEnabled(true);
            } else {
                jLabelSwitchTable.setEnabled(false);
                jLabelCombineTable.setEnabled(false);
            }

            if (banDTO.getTrangthai().equals("Trống")) {
                jLabelOrderTable.setEnabled(true);
            } else {
                jLabelOrderTable.setEnabled(false);
            }

            if (banDTO.getTrangthai().equals("Đã đặt")) {
                loadInforOrderTable();
                jLabelCancelOrder.setEnabled(true);
            } else {
                jLabelCancelOrder.setEnabled(false);
            }
        }
    }

    private String hashWithMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    //</editor-fold>
}
