package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Employee;
import dto.MongoDBDao;

public class ListService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		// TODO Auto-generated method stub
		MongoDBDao mongoDao=MongoDBDao.getMongo();
		ArrayList<Employee> listemp=mongoDao.find();
		request.setAttribute("employees", listemp);
		try {
			request.getRequestDispatcher("/listPage.jsp").forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}