package action;

import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Employee;
import dto.MongoDBDao;

public class InputService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		emp.setEmpno(Double.parseDouble(request.getParameter("empno")));
		emp.setEname(request.getParameter("ename"));
		emp.setJob(request.getParameter("job"));
		emp.setHiredate(new Date());
		emp.setDeptno(Double.parseDouble(request.getParameter("deptno")));
		
		MongoDBDao mongo = MongoDBDao.getMongo();
		mongo.insert(emp);
		new ListService().execute(request, response);
	}
}
