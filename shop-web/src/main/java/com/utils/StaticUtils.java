package com.utils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;
import javax.servlet.ServletContext;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
public class StaticUtils implements ServletContextAware {
	//声明 freemarker配置类
	private Configuration conf;
	private ServletContext servletContext;
	//实现化配置类
	public void setFreeMarkerConfigurer(FreeMarkerConfigurer freeMarkerConfigurer){
		this.conf = freeMarkerConfigurer.getConfiguration();
	}
	//获取到了 servletContext 容器的上下文
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext=servletContext;
		
	}
	public void staticPageIndex(Map<String,Object> data,Integer id) {
		//设置模板的文件夹路径
		//获取模板  /WEB-INF/ftl/prodcutDetail.html
		//输出路径  webapp/html/ + prouduct/ + id + ".html"
		String templePath = "productDetail.html";
		String outPath = getPath("/html/product/" + id + ".html");
		Writer out =null;
		File filePath = new File(outPath);
		File parenFile = filePath.getParentFile();
		
		if(!parenFile.exists()){
			parenFile.mkdirs();
		}
		try {
			out = new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8");
			Template template = conf.getTemplate(templePath);
			template.process(data, out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(out!=null){
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	//获取路径
	private String getPath(String name) {
		return servletContext.getRealPath(name);
	}
}
