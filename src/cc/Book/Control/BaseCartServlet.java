package cc.Book.Control;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 	运用了反射机制，通过传入一个方法名称参数，通过方法名称既能调用该方法，减少代码冗余
 * 测试未通过，未使用
 * @author Administrator
 *
 */
@WebServlet("/baseBook.do")
public class BaseCartServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getParameter("action");//获取传入的方法参数
		
		Class clazz = this.getClass();//获取本类的字节码
		
		try {
			//通过类字节码可以调用该类所有的属性与方法
			Method method = clazz.getMethod(action, HttpServletRequest.class, HttpServletResponse.class);
			if(method != null) {
				try {
					String path = null;
					//反射机制，调用方法
					path = (String) method.invoke(this, request, response);
					if(path != null) {
						//根据调用方法的返回值，请求转发到指定界面
						request.getRequestDispatcher(path).forward(request, response);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
