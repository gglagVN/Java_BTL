<h1 align="center">
  <br>
  <a href="https://github.com/gglagVN/Java_BTL"><img src="https://avatars.githubusercontent.com/u/82758184?v=4" alt="Java Project" width="200"></a>
  <br>
  Java Project - Student Manager App
  <br>
</h1>

<h4 align="center">A Java Project built by a team of 4 - <a href="https://github.com/gglagVN/Java_BTL" target="_blank">Student Manager App</a>.</h4>

<p align="center">
  <a href="#key-features">Key Features</a> •
  <a href="#how-to-use">How To Use</a> •
  <a href="#download">Download</a> •
  <a href="#credits">Credits</a> •
  <a href="#bugs">Bugs</a> 
</p>

## Key Features

- 👨‍🎓 Add, Edit, Delete student records
- 📊 Manage academic scores and subjects
- 💾 Save/load data from SQL Server database
- 🔍 Search by name, ID, or academic status
- 📋 User-friendly Java Swing interface (GUI)
- 🗃️ Support for `sa` SQL Server authentication


## How To Use

1. Tải JDBC tại https://learn.microsoft.com/vi-vn/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server?view=sql-server-ver16
2. Mở file trên với netbean/eclipse hoặc IDE Java và sau đó resolve problems của project do không thấy driver JDBC , giải nén file tải ở bước 1 , chọn vào file enu/jars/mssql-jdbc-12.10.0.jre8.jar
3. Chỉnh URL trên file DBConnection.java thành "jdbc:sqlserver://{your server name}\\SQLEXPRESS:1433;databaseName=QLSinhVien;encrypt=true;trustServerCertificate=true" *server name lấy ở sql studio
4. Mở SQL Studio sau đó chọn properties của server bạn đang dùng ( với Window Authentication ) trong Object Explorer , vào phần security và chọn SQL server and Window Authentication Mode , click OK
5. Click mở server chọn phần Security/Logins , nhấn chuột phải vào sa và chọn Properties , chỉnh password trùng với trong file DBConnection , Status/Login = On , Perm = Grant
6. Vào SQL Server Configuration Manager trong Window ( thường cài kèm SQL Server ) , chọn SQL Network Configuration/Protocol for SQLExpress/TCP/IP , rồi enable nó lên , ở bảng IP Address trong TCP/IP , lướt xuống mục IPAll , xóa IP dynamic ports để trống và chỉnh TCP port thành 1433
7. Mở SQL Studio , đăng nhập với sql authentication , user/pass : sa/123456789 , trust authentication => đăng nhập thành công và có thể chạy file java kết nối với sql .

> **Note**
KHÔNG VÀO ĐƯỢC THÌ HẾT CỨU ĐỪNG HỎI T :)) T GIẤU NGHỀ , CHÚNG M NGU THẬT - KHÔI NGUYỄN

## Download

You can [click here](https://github.com/gglagVN/Java_BTL/archive/refs/heads/main.zip) to download the latest installable version 


## Credits

 - Java Swing GUI framework<br>
 - Microsoft SQL Server<br>
 - Team members of BTL project ( Đức , Linh , Hải , Khôi )<br>

## Bugs

CÒN BUG NÀO NỮA FIX ĐI


