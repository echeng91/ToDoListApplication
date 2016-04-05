
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Todolistitem;
import model.User;

/**
 * Servlet implementation class ExecuteUpdate
 */
@WebServlet("/ExecuteUpdate")
public class ExecuteUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecuteUpdate() {
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
		long updateItemId = Long.parseLong(request.getParameter("updateitemid"));
		long updateStatusId = Long.parseLong(request.getParameter("newstatusid"));
		Date dueDate = new Date();
		try {
			dueDate = sdf.parse(request.getParameter("duedate"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ToDoListDB.updateListItem(updateItemId, updateStatusId, dueDate);
		
		List<Todolistitem> toDoList = ToDoListDB.getAllToDoListItems((User)session.getAttribute("user"));
		session.setAttribute("todolist", toDoList);
		request.getRequestDispatcher("ToDoList.jsp").forward(request, response);
	}

}
