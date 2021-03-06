package com.cheea.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cheea.excption.DataBaseException;
import com.cheea.excption.RutimeException;
import com.cheea.excption.ServiceException;
import com.cheea.factory.AutoObjectFactory;
import com.cheea.service.CourseService;
import com.cheea.service.TeacherService;
import com.cheea.util.Debug;

public class DeleteCourseByAdmin implements CommonAction {

	@Override
	public Object doService(HttpServletRequest request,
			HttpServletResponse response) throws ServiceException,
			RutimeException, DataBaseException {
		PrintWriter out=null;
		try {
			out=response.getWriter();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//int id=Integer.parseInt(request.getParameter("id"));
		String ids=request.getParameter("id");
		CourseService ser=(CourseService) AutoObjectFactory.getInstance("CourseServiceImpl");
		try {
             ser.deleteCourse(ids);
		} catch (Exception e) {
			out.print("fail");
		}
		out.print("ok");
		return null;
	}

}
