package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Employee;
import dto.MongoDBDao;

public class UpdateFormService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		// TODO Auto-generated method stub
		Double empno = Double.parseDouble(request.getParameter("empno"));
		MongoDBDao mongo = MongoDBDao.getMongo();
		Employee emp = mongo.findOne(empno);
		request.setAttribute("employee", emp);
		try {
			request.getRequestDispatcher("/update_form.jsp").forward(request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}