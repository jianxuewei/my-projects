package org.fxsw.DAO;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.fxsw.vo.*;
import org.dom4j.Element;

public class CoursesDAO {
	public Document getDocument () throws DocumentException{
		SAXReader reader=new SAXReader();
		return reader.read(this.getClass().getResourceAsStream("/courses.xml"));
		
	}
	public List<Course> getAllCourses() 
	{
		
		Document document=null;
		try {
			document=this.getDocument();
			
		} catch (DocumentException e) {
			
			e.printStackTrace();
		}
		Element root=document.getRootElement();
		List<Element> course_nodes=root.elements("course");
		List<Course> courses=new ArrayList<Course>();
		for(Element course_node: course_nodes)
		{
			Course course=new Course();
			course.setName(course_node.elementTextTrim("name"));
			
			course.setDate(course_node.elementTextTrim("time"));
			
			course.setDescribe(course_node.elementTextTrim("describe"));
			courses.add(course);
		}
		return courses;
	}
}
