package cc.Book.test;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class CharacterEncodingFilter
 */
public class CharacterEncodingFilter implements Filter{

	private String characterEncoding;//编码方式，配置在web.xml中
	private boolean enabled;//是否启用该Filter，配置在web.xml中

	//初始化是加载参数
    public void init(FilterConfig config) throws ServletException{
	
 	   characterEncoding=config.getInitParameter("characterEncoding");
	      

        enabled = "true".equalsIgnoreCase(
                       config.getInitParameter("enabled").trim());//启用
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws ServletException, IOException {

		if (enabled || characterEncoding != null) { // 如果启用该Filter
			// 设置request编码
			request.setCharacterEncoding(characterEncoding);
			// 设置response编码
			response.setCharacterEncoding(characterEncoding);
		}
		chain.doFilter(request, response); // doFilter,执行下一个Filter或者Servlet
	}

	public void destroy(){
		characterEncoding = null;//销毁时清空资源
	}
}

