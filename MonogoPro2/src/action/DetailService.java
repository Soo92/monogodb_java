package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Employee;
import dto.MongoDBDao;

public class DetailService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		// TODO Auto-generated method stub
		double empno=Double.parseDouble(request.getParameter("empno"));
		MongoDBDao mongo = MongoDBDao.getMongo();
		ArrayList<Employee> listemp=new ArrayList<Employee>();
		listemp.add(mongo.findOne(empno));
		request.setAttribute("employees", listemp);
		try {
			request.getRequestDispatcher("/listPage.jsp").forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}