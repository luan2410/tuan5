package iuh.fit.se.ltwww_java_18092025_tuan5_nguyentranlong;


import iuh.fit.se.ltwww_java_18092025_tuan5_nguyentranlong.util.JpaUtil;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class Application implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        JpaUtil.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        JpaUtil.destroy();
    }
}
