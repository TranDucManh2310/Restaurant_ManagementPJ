CREATE DATABASE QL_QUANAN_JAVA
GO
USE QL_QUANAN_JAVA
GO

CREATE TABLE NHANVIEN 
(
    MANHANVIEN VARCHAR(10) NOT NULL,
    HOTEN NVARCHAR(100) NULL,
    PHAI NVARCHAR(4) NULL CHECK (PHAI = N'Nam' OR PHAI = N'Nữ'),
    NGAYSINH DATE NULL,
    DIACHI NVARCHAR(255) NULL,
    SDT VARCHAR(12) NULL CHECK (SDT LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
    NGAYVAOLAM DATE NULL,
    LUONGCOBAN DECIMAL(12, 2) NULL DEFAULT 0,
    DAXOA BIT NOT NULL DEFAULT 0

    CONSTRAINT PK_NHANVIEN PRIMARY KEY(MANHANVIEN)
)
GO

CREATE TABLE TAIKHOAN
(
    TENDANGNHAP VARCHAR(50) NOT NULL,
    MANHANVIEN VARCHAR(10) NOT NULL,
    TENHIENTHI NVARCHAR(50) NOT NULL,
    MATKHAU NVARCHAR(100) NOT NULL,
    TRANGTHAI NVARCHAR(50) NULL, --NHAN VIEN OR ADMIN
    DAXOA BIT NOT NULL DEFAULT 0,

    CONSTRAINT PK_TAIKHOAN PRIMARY KEY(TENDANGNHAP),
    CONSTRAINT FK_TAIKHOAN_NHANVIEN FOREIGN KEY(MANHANVIEN) REFERENCES NHANVIEN(MANHANVIEN)
)
GO

CREATE TABLE BAN
(
    MABAN INT IDENTITY NOT NULL,
    SOLUONGNGUOI INT NULL CHECK (SOLUONGNGUOI > 0),    
    TRANGTHAI NVARCHAR(255) NULL,
    DAXOA BIT NOT NULL DEFAULT 0,

    CONSTRAINT PK_BAN PRIMARY KEY(MABAN)
)
GO

CREATE TABLE NHACUNGCAP
(
   MANCC INT IDENTITY NOT NULL,
   TENNC NVARCHAR(100) NOT NULL,
   DIACHI NVARCHAR(255) NOT NULL,
   EMAIL NVARCHAR(100) NOT NULL,
   SDT VARCHAR(12) NOT NULL,

   CONSTRAINT PK_NCC PRIMARY KEY (MANCC)
)
GO

CREATE TABLE HOADON
(
    MAHOADON INT IDENTITY NOT NULL, 
    MABAN INT NOT NULL,
    MANHANVIEN VARCHAR(10) NOT NULL,
    NGAYVAO DATETIME NULL,
    NGAYRA DATETIME NULL,
    GIAMGIA INT NULL DEFAULT 0,
    THANHTIEN DECIMAL(12, 2) NULL DEFAULT 0,
    DAXOA BIT NOT NULL DEFAULT 0

    CONSTRAINT PK_HOADON PRIMARY KEY(MAHOADON),
    CONSTRAINT FK_HOADON_BAN FOREIGN KEY(MABAN) REFERENCES BAN(MABAN),
    CONSTRAINT FK_HOADON_NHANVIEN FOREIGN KEY(MANHANVIEN) REFERENCES NHANVIEN(MANHANVIEN)
)
GO

CREATE TABLE NGUYENLIEU
(
    MANGUYENLIEU INT IDENTITY NOT NULL,
    MANCC INT NULL,
    TENNGUYENLIEU NVARCHAR(100) NULL UNIQUE,
    SOLUONG INT NULL,
    DAXOA BIT NOT NULL DEFAULT 0,

    CONSTRAINT PK_NGUYENLIEU PRIMARY KEY(MANGUYENLIEU),
    CONSTRAINT FK_NGUYENLIEU_NHACUNGCAP FOREIGN KEY(MANCC) REFERENCES NHACUNGCAP(MANCC)
)
GO

CREATE TABLE LOAIMONAN
(
    MALOAIMONAN INT IDENTITY NOT NULL,
    TENLOAIMONAN NVARCHAR(50) NULL UNIQUE,
    DAXOA BIT NOT NULL DEFAULT 0,

    CONSTRAINT PK_LOAIMONAN PRIMARY KEY(MALOAIMONAN)
)
GO

CREATE TABLE MONAN
(
    MAMONAN INT IDENTITY NOT NULL,
    MALOAIMONAN INT NOT NULL,
    TENMONAN NVARCHAR(100) NULL UNIQUE,
    DVT NVARCHAR(20) NULL,
    DONGIA DECIMAL(10, 2) NULL DEFAULT 0,
    HINHANH NVARCHAR(MAX) NULL,
    DAXOA BIT NOT NULL DEFAULT 0,

    CONSTRAINT PK_MONAN PRIMARY KEY(MAMONAN),
    CONSTRAINT FK_MONAN_LOAIMONAN FOREIGN KEY(MALOAIMONAN) REFERENCES LOAIMONAN(MALOAIMONAN)
)
GO

CREATE TABLE CONGTHUC
(
    MACONGTHUC INT IDENTITY NOT NULL,
    MAMONAN INT NOT NULL,
    MANGUYENLIEU INT NOT NULL,
    SOLUONG INT NOT NULL DEFAULT 0,
    DONVI NVARCHAR(100) NULL,

    CONSTRAINT PK_CONGTHUC PRIMARY KEY(MACONGTHUC),
    CONSTRAINT FK_CONTHUC_NGUYENLIEU FOREIGN KEY(MANGUYENLIEU) REFERENCES NGUYENLIEU(MANGUYENLIEU), 
    CONSTRAINT FK_CONGTHUC_MONAN FOREIGN KEY(MAMONAN) REFERENCES MONAN(MAMONAN)
)
GO

CREATE TABLE CHITIETHOADON
(
    MACHITIETHD INT IDENTITY NOT NULL,
    MAMONAN INT NOT NULL,
    MAHOADON INT NOT NULL,
    SOLUONG INT NULL DEFAULT 0,

    CONSTRAINT PK_CHITIETHOADON PRIMARY KEY(MACHITIETHD),
    CONSTRAINT FK_CHITIETHOADON_MONAN FOREIGN KEY(MAMONAN) REFERENCES MONAN(MAMONAN),
    CONSTRAINT FK_CHITIETHOADON_HOADON FOREIGN KEY(MAHOADON) REFERENCES HOADON(MAHOADON)
)
GO

CREATE TABLE PHIEUNHAP
(
    MAPN INT IDENTITY NOT NULL,
    MANCC INT NOT NULL,
    NGAYNHAP DATE NOT NULL,
    DAXOA BIT NOT NULL,
        
    CONSTRAINT PK_PN PRIMARY KEY (MAPN),
    CONSTRAINT FK_PN_NCC FOREIGN KEY (MANCC) REFERENCES NHACUNGCAP(MANCC) 
)
GO

CREATE TABLE CHITIETPHIEUNHAP
(
    MACTPN INT IDENTITY NOT NULL,
    MAPN INT NOT NULL,
    MANGUYENLIEU INT NOT NULL,
    DONGIANHAP DECIMAL(18,0) NOT NULL,
    SOLUONGNHAP INT NOT NULL,

    CONSTRAINT PK_CTPN PRIMARY KEY (MACTPN),
    CONSTRAINT FK_CTPN_PN FOREIGN KEY(MAPN) REFERENCES PHIEUNHAP(MAPN),
    CONSTRAINT FK_CTPN_NL FOREIGN KEY(MANGUYENLIEU) REFERENCES NGUYENLIEU(MANGUYENLIEU)
)
GO

CREATE TABLE THONGTINDATBAN
(
	MATTDB INT IDENTITY NOT NULL,
	MABAN INT NOT NULL,
	NGAYDAT DATETIME NOT NULL,
	HOTENKH NVARCHAR(100) NOT NULL,
	SDT VARCHAR(12) NOT NULL,
	DAXOA BIT DEFAULT 0 NOT NULL,

	CONSTRAINT PK_THONGTINDATBAN PRIMARY KEY(MATTDB),
    CONSTRAINT FK_THONGTINDATBAN_BAN FOREIGN KEY(MABAN) REFERENCES BAN(MABAN)
)
GO

INSERT INTO NHANVIEN(MANHANVIEN, HOTEN, PHAI, NGAYSINH, DIACHI, SDT, NGAYVAOLAM, LUONGCOBAN) VALUES
('NV001', N'Trần Đức Mạnh', N'Nam', '2004-10-23', N'Nghệ An', '0334884082', '2024-10-01', 300000),
('NV002', N'Phan Trang', N'Nữ', '2004-10-20', N'Nghệ An', '0985135976', '2024-10-01', 100000)
GO

INSERT INTO TAIKHOAN(TENDANGNHAP, MANHANVIEN, TENHIENTHI, MATKHAU, TRANGTHAI) VALUES
('admin', 'NV001', N'ADMIN', 'c4ca4238a0b923820dcc509a6f75849b',  N'Admin'),
('tranmanh2004', 'NV002', N'Trần Mạnh', 'c4ca4238a0b923820dcc509a6f75849b',  N'Nhân viên')
GO

INSERT INTO LOAIMONAN(TENLOAIMONAN) VALUES
(N'Hấp'),
(N'Xào'),
(N'Nướng'),
(N'Đồ nguội'),
(N'Đồ sống'),
(N'Combo'),
(N'Chiên'),
(N'Luộc'),
(N'Món Ăn kèm'),
(N'Món Tráng miệng'),
(N'Đồ uống cồn'),
(N'Đồ uống không cồn')
GO

INSERT INTO MONAN(MALOAIMONAN, TENMONAN, DVT, DONGIA, HINHANH) VALUES
(1, N'Gà hấp sả', N'Con', 150000, null),
(1, N'Cá thu hấp', N'Con', 100000, null), 
(2, N'Bạch Tuộc Xốt Tôm Chua', N'Đĩa', 269000, null),
(2, N'Cá Hồi Xốt Mù Tạt', N'Đĩa', 279000, null),
(2, N'Tôm Lửa Hồng', N'Đĩa', 289000, null),
(2, N'Cá Mai Xốt Ớt Xanh', N'Đĩa', 149000, null),
(2, N'Cà Tím Xào Lá Quế', N'Đĩa', 79000, null),
(2, N'Rau Rừng Xào X.O', N'Đĩa', 99000, null),
(2, N'Bông Cải Baby Xào Tỏi', N'Đĩa', 99000, null),
(2, N'Đọt Su Xào Ba Rọi Xông Khói', N'Đĩa', 109000, null),
(2, N'Bánh Đa Xào Bò', N'Đĩa', 189000, null),
(3, N'Ếch Nướng Gỗ Sồi', N'Phần', 249000, null),
(3, N'Hàu Hạ Long Nướng Phô Mai (1 con)', N'Con', 39000, null),
(3, N'Sò Điệp Xốt Trứng Muối (1 con)', N'Con', 45000, null),
(3, N'Bào Ngư Xốt Trứng Muối', N'Con', 69000, null),
(3, N'Cà Tím Nướng Mỡ Hành', N'Đĩa', 69000, null),
(3, N'Ba Chỉ Heo Nướng Mật Ong', N'Đĩa', 149000, null),
(3, N'Ba Chỉ Bò Nướng Xốt Cay', N'Đĩa', 179000, null),
(3, N'Dẻ Sườn Bò Mỹ Nướng Xốt Cay', N'Đĩa', 249000, null),
(3, N'Bò Mỹ Nướng Ống Tre', N'Đĩa', 249000, null),
(3, N'Bò Mỹ Xì Xèo', N'Đĩa', 269000, null),
(4, N'Bánh Mè Chả Đùm', N'Phần', 109000, null),
(5, N'Hàu Hạ Long Ăn Sống (1 con)', N'Con', 35000, null),
(6, N'Combo Hải Sản', N'Phần', 599000, null),
(6, N'Combo Thịt Nướng', N'Phần', 699000, null),
(6, N'Combo Đặc Biệt', N'Phần', 899000, null),
(6, N'Đại Tiệc Thịt Nướng Budweiser', N'Phần', 999000, null),
(6, N'Đảo Hải Sản Hoegaarden', N'Phần', 999000, null),
(7, N'Cơm Chiên Thơm Chay', N'Đĩa', 99000, null),
(7, N'Cơm Chiên Cá Mặn', N'Tô', 129000, null),
(7, N'Cơm Chiên Lá Cẩm Hải Sản', N'Tô', 199000, null),
(8, N'Miến Trộn Chua Cay', N'Đĩa', 269000, null),
(9, N'Khoai Tây Phô Mai', N'Đĩa', 79000, null),
(9, N'Khoai Mì Viên Chiên', N'Đĩa', 79000, null),
(9, N'Xôi Chiên Phồng', N'Đĩa', 69000, null),
(9, N'Khoai Lang Tím Nghiền', N'Đĩa', 69000, null),
(9, N'Khoai Mì Nghiền', N'Đĩa', 69000, null),
(10, N'Cam', N'Đĩa', 69000, null),
(10, N'Xoài', N'Đĩa', 49000, null),
(10, N'Nho', N'Đĩa', 59000, null),
(10, N'Bưởi', N'Đĩa', 49000, null),
(10, N'Dưa hấu', N'Đĩa', 59000, null),
(11, N'Budweiser Draught - Ly 330ml', N'Ly', 39000, null),
(11, N'Budweiser Draught - Tháp 3000ml', N'Tháp', 340000, null),
(11, N'Hoegaarden Draught - Ly 250ml', N'Ly', 49000, null),
(11, N'Hoegaarden Draught - Tháp 3000ml', N'Tháp', 450000, null),
(11, N'Budweiser', N'Chai', 29000, null),
(11, N'Corona 250ml', N'Chai', 39000, null),
(11, N'Hoegaarden White', N'Chai', 69000, null),
(11, N'Tiger Lon', N'Lon', 29000, null),
(11, N'Tiger Crytal Lon', N'Lon', 30000, null),
(11, N'Heineken Silver Lon', N'Lon', 35000, null),
(12, N'La Vie Still 450ml', N'Chai', 29000, null),
(12, N'Sting Dâu Lon', N'Lon', 25000, null),
(12, N'7Up Lon', N'Lon', 25000, null),
(12, N'Pepsi Lon', N'Lon', 25000, null),
(12, N'CocaCola Lon', N'Lon', 25000, null)
GO

INSERT INTO NGUYENLIEU(TENNGUYENLIEU, SOLUONG, DAXOA) VALUES
(N'Gà', 1, 0),
(N'Vịt',1,0),
(N'Cá hồi', 1, 0),
(N'Cá thu', 1, 0),
(N'Ếch', 1, 0),
(N'Hào', 1, 0),
(N'Sò điệp', 1, 0),
(N'Bào ngư', 1, 0),
(N'Cà tím', 1, 0),
(N'Rau rừng', 1, 0),
(N'Đường', 1, 0),
(N'Muối', 1, 0),
(N'Bột ngọt', 1, 0),
(N'Bột nêm', 1, 0),
(N'Ớt', 1, 0),
(N'Tỏi', 1, 0),
(N'Tiêu', 1, 0),
(N'Nước mắm', 1, 0),
(N'Giấm', 1, 0)
GO

INSERT INTO BAN (SOLUONGNGUOI, TRANGTHAI, DAXOA) VALUES 
(5, N'Trống', 0),
(5, N'Trống', 0),
(4, N'Trống', 0),
(4, N'Trống', 0),
(6, N'Trống', 0),
(6, N'Trống', 0),
(6, N'Trống', 0),
(6, N'Trống', 0),
(1, N'Trống', 0),
(1, N'Trống', 0);
GO
-- Dữ liệu về hóa đơn
INSERT INTO HOADON(MABAN, MANHANVIEN, NGAYVAO, NGAYRA, GIAMGIA, THANHTIEN)
VALUES
(1, 'NV001', '2024-04-24 12:30:00', '2024-04-24 14:30:00', 10, 250000),
(2, 'NV002', '2024-04-24 13:45:00', '2024-04-24 15:30:00', 5, 180000),
(3, 'NV001', '2024-04-24 17:00:00', '2024-04-24 18:30:00', 0, 120000),
(4, 'NV002', '2024-04-24 18:15:00', '2024-04-24 20:00:00', 0, 300000),
(5, 'NV001', '2024-04-24 19:30:00', '2024-04-24 21:00:00', 15, 210000),
(6, 'NV002', '2024-04-24 20:45:00', '2024-04-24 22:30:00', 10, 240000),
(7, 'NV001', '2024-04-24 11:00:00', '2024-04-24 13:00:00', 0, 150000),
(8, 'NV002', '2024-04-24 12:30:00', '2024-04-24 14:15:00', 5, 175000),
(9, 'NV001', '2024-04-24 14:45:00', '2024-04-24 16:30:00', 0, 200000),
(10, 'NV002', '2024-04-24 16:00:00', '2024-04-24 17:45:00', 0, 220000);
GO

-- Dữ liệu về chi tiết hóa đơn
INSERT INTO CHITIETHOADON(MAMONAN, MAHOADON, SOLUONG)
VALUES
(1, 1, 2),
(2, 1, 3),
(3, 2, 1),
(4, 2, 2),
(5, 3, 2),
(6, 3, 1),
(7, 4, 3),
(8, 4, 2),
(9, 5, 2),
(10, 5, 3);
GO

-- Dữ liệu về nhà cung cấp
INSERT INTO NHACUNGCAP(TENNC, DIACHI, EMAIL, SDT) VALUES
(N'Nhà cung cấp A', N'Hust D9', N'nccA@example.com', '0362111222'),
(N'Nhà cung cấp B', N'Hust B1', N'nccB@example.com', '0362111333'),
(N'Nhà cung cấp C', N'Hust C7', N'nccC@example.com', '0362111444');
GO

-- Dữ liệu về phiếu nhập
INSERT INTO PHIEUNHAP(MANCC, NGAYNHAP, DAXOA) VALUES
(1, '2024-04-20', 0),
(2, '2024-04-21', 0),
(3, '2024-04-22', 0);
GO

-- Dữ liệu về chi tiết phiếu nhập
INSERT INTO CHITIETPHIEUNHAP(MAPN, MANGUYENLIEU, DONGIANHAP, SOLUONGNHAP) VALUES
(1, 1, 50000, 100),
(1, 2, 45000, 100),
(1, 3, 120000, 50),
(2, 4, 40000, 150),
(2, 5, 30000, 200),
(2, 6, 35000, 100),
(3, 7, 60000, 80),
(3, 8, 55000, 70),
(3, 9, 30000, 120),
(3, 10, 25000, 150);
GO

--Xử lý--

--Đăng nhập
CREATE PROC USP_Login 
    @userName nvarchar(100),
    @passWord nvarchar(100)
AS
BEGIN
    SELECT *
    FROM TAIKHOAN
    WHERE BINARY_CHECKSUM(TENDANGNHAP) = BINARY_CHECKSUM(@userName) AND BINARY_CHECKSUM(MATKHAU) = BINARY_CHECKSUM(@passWord);
END
GO
--Lấy tài khoản bởi tên đăng nhập
CREATE PROC USP_GetAccountByUserName
    @userName nvarchar(100)
AS
    BEGIN
        SELECT * FROM TAIKHOAN WHERE @userName = TENDANGNHAP
    END
GO

--Thay đổi mật khẩu
CREATE PROC USP_ChangePassword
    @userName VARCHAR(MAX),
    @password NVARCHAR(MAX),
    @newPassword NVARCHAR(MAX)
AS
BEGIN
    DECLARE @isRightPass INT = 0

    SELECT @isRightPass = COUNT(*) FROM TAIKHOAN WHERE TENDANGNHAP = @userName AND MATKHAU = @password

    IF(@isRightPass = 1)
        BEGIN
            UPDATE TAIKHOAN SET MATKHAU = @newPassword WHERE TENDANGNHAP = @userName
        END
END
GO
--Lấy danh sách tài khoản
CREATE PROC USP_GetListAccount
AS
    BEGIN
        SELECT * FROM TAIKHOAN
    END
GO
--Lấy danh sách mã nhân viên
CREATE PROC USP_GetListEmployeeByID
AS
    BEGIN 
        SELECT NHANVIEN.MANHANVIEN FROM NHANVIEN
    END
GO
--Lấy danh sách tên nhân viên
CREATE PROC USP_GetListNameEmployee
AS
    BEGIN 
        SELECT TAIKHOAN.TENHIENTHI FROM TAIKHOAN
    END
GO
CREATE PROC USP_layTKtheoTenDN
@tendangnhap NVARCHAR(50)
AS
    BEGIN
        SELECT * FROM TAIKHOAN WHERE TENDANGNHAP = @tendangnhap
    END
GO

--Lấy danh sách trạng thái tài khoản
CREATE PROC USP_GetListStatus
AS
    BEGIN 
        SELECT TAIKHOAN.TRANGTHAI FROM TAIKHOAN
    END
GO
--Cài lại mật khẩu
CREATE PROC USP_ResetPassWord
    @userName VARCHAR(50)
AS
    BEGIN
        UPDATE TAIKHOAN
        SET MATKHAU = 'c4ca4238a0b923820dcc509a6f75849b'
        WHERE TENDANGNHAP = @userName
    END
GO
--Thêm tài khoản
CREATE PROC USP_InsertAccount
    @userName VARCHAR(50),
    @staffid VARCHAR(10),
    @displayName NVARCHAR(50),
    @status NVARCHAR(50)
AS
    BEGIN
        INSERT INTO TAIKHOAN(TENDANGNHAP, MANHANVIEN, TENHIENTHI, MATKHAU, TRANGTHAI) VALUES
        (@userName, @staffid, @displayName, 'c4ca4238a0b923820dcc509a6f75849b', @status)
    END
GO
--Lấy tài khoản bởi mã nhân viên
CREATE PROC USP_GetAccountByStaffID
    @staffid VARCHAR(10)
AS
    BEGIN
        SELECT * FROM TAIKHOAN WHERE MANHANVIEN = @staffid
    END
GO
--Xóa tài khoản
CREATE PROC USP_DeleteAccount
    @userName VARCHAR(50)
AS
    BEGIN
        DELETE TAIKHOAN WHERE TENDANGNHAP = @userName
    END
GO
--Sửa tài khoản
CREATE PROC USP_UpdateAccount
    @status NVARCHAR(50),
    @userName VARCHAR(10)
AS
    BEGIN
        UPDATE TAIKHOAN
        SET TRANGTHAI = @status
        WHERE TENDANGNHAP = @userName
    END
GO

--Lấy danh sách nhân viên
CREATE PROC USP_GetListEmployee
AS
    BEGIN
        SELECT * FROM NHANVIEN WHERE DAXOA = 0
    END
GO

--Lấy nhân viên bởi mã nhân viên
CREATE PROC USP_GetEmployeeByStaffID
    @staffid VARCHAR(10)
AS
    BEGIN
        SELECT * FROM NHANVIEN WHERE MANHANVIEN = @staffid
    END
GO

-- Thêm nhân viên
CREATE PROC USP_InsertEmployee
    @staffid VARCHAR(10),
    @name NVARCHAR(100),
    @sex NVARCHAR(4),
    @dateofbirth DATE,
    @address NVARCHAR(255),
    @phone VARCHAR(12),
    @dateofwork DATE,
    @basicsalary DECIMAL(12, 2)
AS
    BEGIN
        INSERT INTO NHANVIEN(MANHANVIEN, HOTEN, PHAI, NGAYSINH, DIACHI, SDT, NGAYVAOLAM, LUONGCOBAN) VALUES
        (@staffid, @name, @sex, @dateofbirth, @address, @phone, @dateofwork, @basicsalary)
    END
GO

--Xóa nhân viên
CREATE PROC USP_DeleteEmployee
    @staffid VARCHAR(10)
AS
    BEGIN
        UPDATE NHANVIEN
        SET DAXOA = 1
        WHERE MANHANVIEN = @staffid
    END
GO

--Sửa nhân viên
CREATE PROC USP_UpdateEmployee
    @staffid VARCHAR(10),
    @name NVARCHAR(100),
    @sex NVARCHAR(4),
    @dateofbirth DATE,
    @address NVARCHAR(255),
    @phone VARCHAR(12),
    @dateofwork DATE,
    @basicsalary DECIMAL(12, 2)
AS
    BEGIN
        UPDATE NHANVIEN
        SET HOTEN = @name, PHAI = @sex, NGAYSINH = @dateofbirth, DIACHI = @address, SDT = @phone, NGAYVAOLAM = @dateofwork, LUONGCOBAN = @basicsalary
        WHERE MANHANVIEN = @staffid
    END
GO

-- Function Loại bỏ dấu tiếng Việt, giữ nguyên chữ in hoa và các ký tự đặc biệt
CREATE FUNCTION [dbo].[fuConvertToUnsign1]
(
 @strInput NVARCHAR(4000)
)
RETURNS NVARCHAR(4000)
AS
BEGIN 
 IF @strInput IS NULL RETURN @strInput
 IF @strInput = '' RETURN @strInput
 DECLARE @RT NVARCHAR(4000)
 DECLARE @SIGN_CHARS NCHAR(136)
 DECLARE @UNSIGN_CHARS NCHAR (136)
 SET @SIGN_CHARS = N'ăâđêôơưàảãạáằẳẵặắầẩẫậấèẻẽẹéềểễệế
 ìỉĩịíòỏõọóồổỗộốờởỡợớùủũụúừửữựứỳỷỹỵý
 ĂÂĐÊÔƠƯÀẢÃẠÁẰẲẴẶẮẦẨẪẬẤÈẺẼẸÉỀỂỄỆẾÌỈĨỊÍ
 ÒỎÕỌÓỒỔỖỘỐỜỞỠỢỚÙỦŨỤÚỪỬỮỰỨỲỶỸỴÝ'
 +NCHAR(272)+ NCHAR(208)
 SET @UNSIGN_CHARS = N'aadeoouaaaaaaaaaaaaaaaeeeeeeeeee
 iiiiiooooooooooooooouuuuuuuuuuyyyyy
 AADEOOUAAAAAAAAAAAAAAAEEEEEEEEEEIIIII
 OOOOOOOOOOOOOOOUUUUUUUUUUYYYYYDD'
 DECLARE @COUNTER int
 DECLARE @COUNTER1 int
 SET @COUNTER = 1
 WHILE (@COUNTER <=LEN(@strInput))
 BEGIN 
 SET @COUNTER1 = 1
 WHILE (@COUNTER1 <=LEN(@SIGN_CHARS)+1)
 BEGIN
 IF UNICODE(SUBSTRING(@SIGN_CHARS, @COUNTER1,1))
 = UNICODE(SUBSTRING(@strInput,@COUNTER ,1) )
 BEGIN 
 IF @COUNTER=1
 SET @strInput = SUBSTRING(@UNSIGN_CHARS, @COUNTER1,1)
 + SUBSTRING(@strInput, @COUNTER+1,LEN(@strInput)-1) 
 ELSE
 SET @strInput = SUBSTRING(@strInput, 1, @COUNTER-1)
 +SUBSTRING(@UNSIGN_CHARS, @COUNTER1,1)
 + SUBSTRING(@strInput, @COUNTER+1,LEN(@strInput)- @COUNTER)
 BREAK
 END
 SET @COUNTER1 = @COUNTER1 +1
 END
 SET @COUNTER = @COUNTER +1
 END
 SET @strInput = replace(@strInput,' ','-')
 RETURN @strInput
END
GO

--Tìm nhân viên theo tên
CREATE PROC USP_SearchEmployeeByName
    @name NVARCHAR(100)
AS
    BEGIN
        SELECT *
        FROM NHANVIEN
        WHERE [dbo].[fuConvertToUnsign1](HOTEN) LIKE N'%' + [dbo].[fuConvertToUnsign1](@name) + N'%' AND DAXOA = 0;
    END
GO

--Tìm nhân viên theo lương
CREATE PROC USP_SearchEmployeeBySalary
     @basicsalary DECIMAL(12, 2)
AS
    BEGIN
        SELECT * FROM NHANVIEN WHERE LUONGCOBAN = @basicsalary AND DAXOA = 0
    END
GO

--Tìm nhân viên theo giới tính
CREATE PROC USP_SearchEmployeeBySex
   @sex NVARCHAR(4)
AS
    BEGIN
        SELECT * FROM NHANVIEN WHERE PHAI = @sex AND DAXOA = 0
    END
GO

--Món ăn
--Lấy mã theo tên loại món được chọn
CREATE PROCEDURE USP_GetMaLoaiMonAnByTenLoai
    @tenloai NVARCHAR(50)
AS
BEGIN
    SELECT MALOAIMONAN 
    FROM LOAIMONAN 
    WHERE TENLOAIMONAN = @tenloai;
END
GO

--Xóa loại món ăn
CREATE PROC USP_XoaLoaiMonAn
    @maLoai INT
AS
    BEGIN
        UPDATE LOAIMONAN
        SET DAXOA = 1
        WHERE MALOAIMONAN = @maLoai
    END
GO

--Thêm loại món ăn
CREATE PROC USP_ThemLoaiMonAn
    @tenLoai NVARCHAR(50)
AS
    BEGIN
        INSERT INTO LOAIMONAN(TENLOAIMONAN) VALUES
        (@tenLoai)
    END
GO

--Sửa loại món ăn
CREATE PROC USP_SuaLoaiMonAn
    @maLoai INT,
    @tenLoai NVARCHAR(50)
AS
    BEGIN
        UPDATE LOAIMONAN 
        SET TENLOAIMONAN = @tenLoai WHERE MALOAIMONAN = @maLoai
    END
GO

--Tìm nhân viên theo tên
CREATE PROC USP_SearchLMAByName
    @name NVARCHAR(100)
AS
    BEGIN
        SELECT *
        FROM LOAIMONAN
        WHERE [dbo].[fuConvertToUnsign1](TENLOAIMONAN) LIKE N'%' + [dbo].[fuConvertToUnsign1](@name) + N'%' AND DAXOA = 0;
    END
GO

CREATE PROCEDURE GetMonAnByLoaiMonAn
    @tenLoaiMonAn NVARCHAR(255)
    AS
        BEGIN
            SELECT MONAN.*
            FROM MONAN
            INNER JOIN LOAIMONAN ON MONAN.MALOAIMONAN = LOAIMONAN.MALOAIMONAN
            WHERE MONAN.DAXOA = 0 AND LOAIMONAN.TENLOAIMONAN = @tenLoaiMonAn;
        END;
GO
-- Lấy tên loại của món thông qua mã món
CREATE PROC USP_LayTenLoaiTheoMaMon
    @maMon INT
AS
    BEGIN
        SELECT TENLOAIMONAN
		FROM LOAIMONAN, MONAN
		WHERE LOAIMONAN.MALOAIMONAN = MONAN.MALOAIMONAN AND MAMONAN = @maMon
    END
GO
--Xóa món ăn
CREATE PROC USP_XoaMonAn
    @maMon INT
AS
    BEGIN
        UPDATE MONAN
        SET DAXOA = 1
        WHERE MAMONAN = @maMon
    END
GO
--Thêm món ăn
CREATE PROC USP_ThemMonAn
	@maLoai INT,
    @tenMon NVARCHAR(100), 
    @unit NVARCHAR(20),
    @gia DECIMAL(10, 2),
    @images NVARCHAR(MAX)
AS
    BEGIN
        INSERT INTO MONAN(MALOAIMONAN, TENMONAN, DVT, DONGIA, HINHANH) VALUES
        (@maLoai, @tenMon, @unit, @gia, @images)
    END
GO
--Sửa món ăn
CREATE PROC USP_CapNhatMonAn
    @maLoai INT,
	@maMon INT,
    @tenMon NVARCHAR(100), 
    @unit NVARCHAR(20),
    @gia DECIMAL(10, 2),
    @images NVARCHAR(MAX)
AS
    BEGIN
        UPDATE MONAN
        SET MALOAIMONAN = @maLoai, TENMONAN = @tenMon, DVT = @unit, DONGIA = @gia, HINHANH = @images
        WHERE MAMONAN = @maMon
    END
GO
-- Lấy ra mã món từ tên món được chọn
CREATE PROC USP_LayMaMon
	@tenMon NVARCHAR(100)
AS
	BEGIN
		SELECT CONGTHUC.MAMONAN
		FROM CONGTHUC, MONAN
		WHERE CONGTHUC.MAMONAN = MONAN.MAMONAN AND MONAN.TENMONAN = @tenMon
	END
GO

-- Lấy ra mã nguyên liệu từ tên nguyên được chọn
CREATE PROC USP_LayMaNguyenLieu
	@tenNguyenLieu NVARCHAR(100)
AS
	BEGIN
		SELECT NGUYENLIEU.MANGUYENLIEU
		FROM CONGTHUC, NGUYENLIEU
		WHERE CONGTHUC.MANGUYENLIEU = NGUYENLIEU.MANGUYENLIEU AND NGUYENLIEU.TENNGUYENLIEU = @tenNguyenLieu
	END
GO

--Thêm công thức
CREATE PROC USP_ThemCongThuc
	@maMon INT,
	@maNgLieu INT,
	@sL INT,
	@donvi NVARCHAR(100)
AS
    BEGIN
        INSERT INTO CONGTHUC (MAMONAN, MANGUYENLIEU, SOLUONG, DONVI) VALUES
        (@maMon, @maNgLieu, @sL, @donvi)
    END
GO

--Sửa công thức
CREATE PROC USP_SuaCongThuc
	@maMon INT,
	@maNgLieu INT,
	@sL INT,
	@donvi NVARCHAR(100)
AS
    BEGIN
        UPDATE CONGTHUC
		SET SOLUONG =@sL, DONVI = @donvi
		WHERE MAMONAN = @maMon AND MANGUYENLIEU = @maNgLieu
    END
GO

--Xóa công thức
CREATE PROC USP_XoaCongThuc
    @maMon INT
AS
	BEGIN
		DELETE FROM CONGTHUC 
		WHERE MAMONAN = @maMon
	END
GO

--Xóa nguyên liệu
CREATE PROC USP_XoaNgLieu
    @maNL INT
AS
    BEGIN
        UPDATE NGUYENLIEU
        SET DAXOA = 1
        WHERE MANGUYENLIEU = @maNL
    END
GO

--Thêm nguyên liệu
CREATE PROC USP_ThemNgLieu
    @tenNL NVARCHAR(100)
AS
    BEGIN
        INSERT INTO NGUYENLIEU(TENNGUYENLIEU) VALUES
        (@tenNL)
    END
GO

--Sửa nguyên liệu
CREATE PROC USP_CapNhatNgLieu
    @maNL INT,
    @tenNL NVARCHAR(100)
AS
    BEGIN
        UPDATE NGUYENLIEU 
        SET TENNGUYENLIEU = @tenNL
        WHERE MANGUYENLIEU = @maNL
    END
GO

-- Lấy thông tin bàn thông qua mã bàn
CREATE PROC USP_layTTTheoMaBan
    @maBan INT
AS
    BEGIN
        SELECT MABAN, SOLUONGNGUOI, TRANGTHAI
		FROM BAN WHERE DAXOA = 0 AND MABAN = @maBan
    END
GO

--Thêm bàn ăn
CREATE PROC USP_ThemBan
    @soLuongNguoi INT,
    @trangThai NVARCHAR(50)
AS
    BEGIN
        INSERT INTO BAN(SOLUONGNGUOI, TRANGTHAI) VALUES
        (@soLuongNguoi, @trangThai)
    END
GO

--Sửa thông tin bàn ăn
CREATE PROC USP_CapNhatBan
    @maBan INT,
    @soLuong INT,
    @trangThai NVARCHAR(50)
AS
    BEGIN
        UPDATE BAN 
        SET SOLUONGNGUOI = @soLuong, TRANGTHAI = @trangThai
        WHERE MABAN = @maBan
    END
GO

--Xóa thông tin bàn
CREATE PROC USP_XoaBan
    @maBan INT
AS
    BEGIN
        UPDATE BAN
        SET DAXOA = 1
        WHERE MABAN = @maBan 
    END
GO

--Lấy danh sách hóa đơn theo ngày ra
CREATE PROC USP_GetListBillByDateOut
    @dateStart DATE, @dateEnd DATE
AS
    BEGIN
        SELECT * FROM HOADON WHERE NGAYRA >= @dateStart AND NGAYRA <= @dateEnd 
    END
GO

--Lấy danh sách hóa đơn theo ngày ra và nhân viên
CREATE PROC USP_GetListBillByDateOutAndStaff
    @dateStart DATE, @dateEnd DATE, @staffId VARCHAR(10)
AS
    BEGIN
        SELECT * FROM HOADON WHERE NGAYRA >= @dateStart AND NGAYRA <= @dateEnd AND MANHANVIEN = @staffId
    END
GO

--Lấy chi tiết hóa đơn theo hóa đơn
CREATE PROC USP_GetBillInfoByBill
    @billId INT
AS
    BEGIN
        SELECT * FROM CHITIETHOADON WHERE MAHOADON = @billId
    END
GO

-- TONY
CREATE PROC USP_SearchDishByKeyWord
    @keyWord NVARCHAR(100)
AS
BEGIN
    SELECT *
    FROM MONAN
    WHERE TENMONAN LIKE N'%' + @keyWord + '%';
END
GO

CREATE PROC USP_SearchDishByKeyWordAndCategory
    @keyWord NVARCHAR(100),
	@category NVARCHAR(100)
AS
BEGIN
    SELECT *
    FROM MONAN, LOAIMONAN
    WHERE TENMONAN LIKE N'%' + @keyWord + '%' AND MONAN.MALOAIMONAN = LOAIMONAN.MALOAIMONAN AND LOAIMONAN.TENLOAIMONAN = @category
END
GO

CREATE PROC USP_GetTableById
	@id INT
AS
	BEGIN
	SELECT * FROM BAN WHERE MABAN = @id;
	END
GO

CREATE PROC USP_GetDishById
	@id INT
AS
	BEGIN
	SELECT * FROM MONAN WHERE MAMONAN = @id;
	END
GO

CREATE PROC USP_CreateBill
	@tableId INT,
	@staffId VARCHAR(10),
	@dateIn DATETIME,
	@dateOut DATETIME,
	@discount INT,
	@total DECIMAL(12, 2)
AS
	BEGIN
		INSERT INTO HOADON (MABAN, MANHANVIEN, NGAYVAO, NGAYRA, GIAMGIA, THANHTIEN)
		VALUES (@tableId, @staffId, @dateIn, @dateOut, @discount, @total)
	END
GO

CREATE PROC USP_InsertBillDetails
	@dishId INT,
	@billId INT,
	@count INT
AS
	BEGIN
		INSERT INTO CHITIETHOADON (MAMONAN, MAHOADON, SOLUONG)
		VALUES (@dishId, @billId, @count)
	END
GO

CREATE PROC USP_UpdateTableStatus
	@tableId INT,
	@status NVARCHAR(255)
AS
	BEGIN
		UPDATE BAN SET TRANGTHAI = @status WHERE MABAN = @tableId;
	END
GO

CREATE PROC USP_UpdateDishCountInBillDetail
	@billId INT,
	@dishId INT,
	@count INT
AS
	BEGIN
		UPDATE CHITIETHOADON SET SOLUONG = @count WHERE MAHOADON = @billId AND MAMONAN = @dishId
	END
GO

CREATE PROC USP_RemoveDishFromBillDetail
	@billId INT,
	@dishId INT
AS
	BEGIN
		DELETE FROM CHITIETHOADON WHERE MAHOADON = @billId AND MAMONAN = @dishId;
	END
GO

CREATE PROC USP_UpdateTableIdForBill
	@billId INT,
    @tableId INT
AS
    BEGIN
        UPDATE HOADON SET MABAN = @tableId WHERE MAHOADON = @billId
    END
GO

CREATE PROC USP_InsertInforOrderTable
	@idTable INT,
	@date DATETIME,
	@name NVARCHAR(100),
	@phone VARCHAR(12)
AS
	BEGIN
		INSERT INTO THONGTINDATBAN (MABAN, NGAYDAT, HOTENKH, SDT)
		VALUES (@idTable, @date, @name, @phone)
	END
GO

--Lấy danh sách nhân viên
CREATE PROC USP_GetListNhaCC
AS
    BEGIN
        SELECT * FROM NHACUNGCAP
    END
GO

CREATE PROC USP_layDSNguyenLieuTheoMaNCC
@mancc int
AS
    BEGIN
        SELECT * FROM NGUYENLIEU WHERE MANCC = @mancc
    END
GO  

CREATE PROC USP_layDSPN
AS
    BEGIN
        SELECT * FROM PHIEUNHAP
    END
GO

CREATE PROC USP_layDSCTPNtheoMa
@mapn INT
AS
    BEGIN
        SELECT * FROM CHITIETPHIEUNHAP WHERE MAPN = @mapn
    END
GO

CREATE PROC USP_layDSPNtheoNgayNhap
@ngaynhap DATE
AS 
    BEGIN
        SELECT * FROM PHIEUNHAP WHERE NGAYNHAP = @ngaynhap      
    END
GO

CREATE PROC USP_layDSPNtheoMa
@mapn INT
AS
    BEGIN
        SELECT * FROM PHIEUNHAP WHERE MAPN = @mapn
    END
GO