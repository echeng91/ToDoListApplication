import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Todolistitem;
import model.User;

/**
 * Servlet implementation class ExecuteInsert
 */
@WebServlet("/ExecuteInsert")
public class ExecuteInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecuteInsert() {
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		long itemid = Long.parseLong(request.getParameter("itemid"));
		String itemname = request.getParameter("itemname");
		String description = request.getParameter("description");
		long statusid = Long.parseLong(request.getParameter("statusid"));
		Date duedate = new Date();
		try {
			duedate = sdf.parse(request.getParameter("duedate"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BigDecimal priority = BigDecimal.valueOf(Long.parseLong((request.getParameter("priority"))));
		User currentUser = (User)session.getAttribute("user");
		ToDoListDB.addListItem(itemid, itemname, description, statusid, duedate, priority, currentUser);
		
		List<Todolistitem> toDoList = ToDoListDB.getAllToDoListItems(currentUser);
		session.setAttribute("todolist", toDoList);
		request.getRequestDispatcher("ToDoList.jsp").forward(request, response);
	}

}
