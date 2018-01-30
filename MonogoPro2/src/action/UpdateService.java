package action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Employee;
import dto.MongoDBDao;

public class UpdateService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		emp.setEmpno(Double.parseDouble(request.getParameter("empno")));
		emp.setEname(request.getParameter("ename"));
		emp.setJob(request.getParameter("job"));
		emp.setDeptno(Double.parseDouble(request.getParameter("deptno")));
		
		MongoDBDao mongo = MongoDBDao.getMongo();
		mongo.update(emp);
		
		new ListService().execute(request, response);;
	}
}