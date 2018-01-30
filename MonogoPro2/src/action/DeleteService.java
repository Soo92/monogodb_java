package action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MongoDBDao;

public class DeleteService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		// TODO Auto-generated method stub
		double empno=Double.parseDouble(request.getParameter("empno"));
		MongoDBDao mongo = MongoDBDao.getMongo();
		mongo.delete(empno);
		new ListService().execute(request, response);
	}
}