package listenter;

import mvc.service.GisService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 * 
 * @author qiaoliang.jian
 * @version
 */
public class SystemInitLister implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("#####system init#####");
		ApplicationContext ctx =
				WebApplicationContextUtils.
						getWebApplicationContext(arg0.getServletContext());

		GisService gisService =
				(GisService) ctx.getBean("gisService");
		System.out.println("--------------"+gisService.getJdbcTemplate());
		gisService.task();
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		Enumeration<Driver> drivers = DriverManager.getDrivers();
		while (drivers.hasMoreElements()) {
			Driver driver = drivers.nextElement();
			try {
				DriverManager.deregisterDriver(driver);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	//	@Override
//	public void sessionCreated(HttpSessionEvent arg0) {
//		System.out.println("#####session init#####");
//		 HttpSession session = arg0.getSession();
//
//         ApplicationContext ctx =
//               WebApplicationContextUtils.
//                     getWebApplicationContext(session.getServletContext());
//
//         GisService gisService =
//                     (GisService) ctx.getBean("gisService");
//         System.out.println(gisService.getJdbcTemplate2());
//	}
//
//	@Override
//	public void sessionDestroyed(HttpSessionEvent arg0) {
//		System.out.println("#####session destroye#####");
//
//	}
}
