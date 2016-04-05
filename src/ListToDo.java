

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBUtil;
import model.User;
import model.Todolistitem;
import java.util.List;

/**
 * Servlet implementation class ListToDo
 */
@WebServlet("/ListToDo")
public class ListToDo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListToDo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String sendTo = "";
		User found;
		List<Todolistitem> toDoList = null;
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT u from User u WHERE u.username = '" + request.getParameter("user") 
		+ "' AND u.userpass = '" + request.getParameter("pass") + "'";
		TypedQuery<User> q = em.createQuery(qString, User.class);
		try {
			if(q.getResultList().isEmpty()) {
				sendTo = "index.jsp";
				request.setAttribute("notfound", "The user name and password provided do not match any in our database.");
			} else {
				sendTo = "ToDoList.jsp";
				found = q.getSingleResult();
				session.setAttribute("user", found);
				toDoList = ToDoListDB.getAllToDoListItems(found);
				
			}
		} catch (Exception e) {
			e.getMessage();
		} finally {
			em.close();
		}
		session.setAttribute("todolist", toDoList);
		request.getRequestDispatcher(sendTo).forward(request, response);
	}

}
