package iuh.fit.se.ltwww_java_18092025_tuan5_nguyentranlong.servlet;

import iuh.fit.se.ltwww_java_18092025_tuan5_nguyentranlong.dao.DienThoaiDAO;
import iuh.fit.se.ltwww_java_18092025_tuan5_nguyentranlong.dao.NhaCungCapDAO;
import iuh.fit.se.ltwww_java_18092025_tuan5_nguyentranlong.modal.DienThoai;
import iuh.fit.se.ltwww_java_18092025_tuan5_nguyentranlong.modal.NhaCungCap;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/dienthoai")
public class DienThoaiServlet extends HttpServlet {
    private DienThoaiDAO dienThoaiDAO;
    private NhaCungCapDAO nhaCungCapDAO;
    @Override
    public void init(ServletConfig config) throws ServletException {
        dienThoaiDAO = new DienThoaiDAO();
        nhaCungCapDAO = new NhaCungCapDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listdt",dienThoaiDAO.findAll());

        String action = req.getParameter("action");

        if(action!=null && action.equals("CREATE")){
            req.getRequestDispatcher("dienthoai-form.jsp").forward(req, resp);
            return;
        }
        if(action!=null && action.equals("DELETE")){
            String id = req.getParameter("id");
            if(!id.isBlank()){
                dienThoaiDAO.delete(Long.parseLong(id));
                resp.sendRedirect("dssdt-form.jsp");
            }
        }
        req.getRequestDispatcher("list-dienthoai.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tenDT = req.getParameter("tenDT");
        String namSX = req.getParameter("namSX");
        String cauHinh = req.getParameter("cauHinh");
        NhaCungCap nhaCungCapId=nhaCungCapDAO.findById(Long.parseLong(req.getParameter("nhaCungCapId")));
        String hinhAnh=req.getParameter("hinhAnh");
        DienThoai dienThoai = new DienThoai(
                null,tenDT,namSX,cauHinh,nhaCungCapId,hinhAnh
        );

        dienThoaiDAO.save(dienThoai);
        resp.sendRedirect("list-dienthoai.jsp");
    }
}
