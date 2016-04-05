import model.Status;
import model.Todolistitem;

import java.util.List;
import java.util.Date;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customTools.DBUtil;

/**
 * Servlet implementation class EditListItem
 */
@WebServlet("/EditListItem")
public class EditListItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListItem() {
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
		long editItemId = Long.parseLong(request.getParameter("edititemid"));
		Todolistitem editItem = ToDoListDB.getToDoListItemByID(editItemId);
		Date itemCurrentDueDate = editItem.getDuedate();
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT s FROM Status s ORDER BY s.statusid";
		TypedQuery<Status> q = em.createQuery(qString, Status.class);
		List<Status> statusOptions = q.getResultList();
		request.setAttribute("itemname", editItem.getItemname());
		request.setAttribute("statusoptions", statusOptions);
		request.setAttribute("edititemid", editItemId);
		request.setAttribute("defaultduedate", itemCurrentDueDate);
		
		request.getRequestDispatcher("ItemEdit.jsp").forward(request, response);
	}

}
