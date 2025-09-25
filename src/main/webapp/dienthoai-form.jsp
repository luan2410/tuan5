<%--
  Created by IntelliJ IDEA.
  User: nguyentranlong
  Date: 28/9/25
  Time: 20:14
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
  <form action="dienthoai" method="post">
    <div>
      <label>Ten dien thoai:</label>
      <input name="tenDT">
    </div>
    <div>
      <label>Nam san xuat</label>
      <input name="namSX">
    </div>
    <div>
      <label>Cau hinh</label>
      <input name="cauHinh">
    </div>
    <select name="nhaCungCapId">
      <c:forEach items="${listdt}" var="dienthoai">
        <option value="${dienthoai.ncc.maNCC}">${dienthoai.ncc.maNCC}</option>
      </c:forEach>
    </select>
    <div>
      <label>Hinh anh</label>
      <input name="hinhAnh">
    </div>
    <button type="submit">Tao moi</button>
  </form>
</body>
</html>
