<%--
  Created by IntelliJ IDEA.
  User: nguyentranlong
  Date: 28/9/25
  Time: 00:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <a href="dienthoai">Danh sach dien thoai</a>
  <a href="dienthoai?action=CREATE">Them san pham</a>
  <a>Quan ly san pham</a>

  <h1>Danh sach dien thoai</h1>

  <table border="1" width="80%">
    <tr>
      <th>MADT</th>
      <th>TENDT</th>
      <th>NAMSANXUAT</th>
      <th>CAUHINH</th>
      <th>MANCC</th>
      <th>HINHANH</th>
    </tr>

    <c:forEach items="${listdt}" var="dt">
      <tr>
        <th>${dt.maDT}</th>
        <th>${dt.tenDT}</th>
        <th>${dt.namSX}</th>
        <th>${dt.cauHinh}</th>
        <th>${dt.ncc.maNCC}</th>
        <th>${dt.hinhAnh}</th>
      </tr>
    </c:forEach>
  </table>
  </form>
</body>
</html>
