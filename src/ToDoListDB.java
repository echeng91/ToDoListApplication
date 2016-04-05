import java.math.BigDecimal;
import java.util.List;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import customTools.DBUtil;
import model.Todolistitem;
import model.User;
import model.Status;


public class ToDoListDB {

	public static List<Todolistitem> getAllToDoListItems(User userp) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT t from Todolistitem t WHERE t.user.userid = " + userp.getUserid()  + " ORDER BY t.itemid";
		TypedQuery<Todolistitem> q = em.createQuery(qString, Todolistitem.class);
		List<Todolistitem> toDoList = null;
		try {
			toDoList = q.getResultList();
			if(toDoList == null || toDoList.isEmpty()) {
				toDoList = null;
			}
		} catch (Exception e) {
			e.getMessage();
		} finally {
			em.close();
		}
		return toDoList;
	}
	
	public static Todolistitem getToDoListItemByID(long listItemId) {
		Todolistitem found = new Todolistitem();
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT t FROM Todolistitem t WHERE t.itemid = " + listItemId;
		TypedQuery<Todolistitem> q = em.createQuery(qString, Todolistitem.class);
		try {
			found = q.getSingleResult();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			em.close();
		}
		return found;
	}
	
	public static Status findStatus(long statusId) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT s FROM Status s WHERE s.statusid = " + statusId;
		TypedQuery<Status> q = em.createQuery(qString, Status.class);
		Status found = new Status();
		try {
			found = q.getSingleResult();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			em.close();
		}
		return found;
	}
	
	public static void addListItem(long itemId, String itemName, String description, long statusId, Date dueDate, BigDecimal priority, User user) {
		Todolistitem add = new Todolistitem();
		add.setItemid(itemId);
		add.setItemname(itemName);
		add.setItemdescription(description);
		Status newStatus = ToDoListDB.findStatus(statusId);
		add.setStatus(newStatus);
		add.setDuedate(dueDate);
		add.setPriority(priority);
		add.setUser(user);
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(add);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void updateListItem(long listItemId, long statusId, Date due) {
		Todolistitem upd = ToDoListDB.getToDoListItemByID(listItemId);
		Status newStatus = ToDoListDB.findStatus(statusId);
		upd.setStatus(newStatus);
		if(upd.getStatus().getStatusdescription().equals("complete")) {
			upd.setDatecompleted(new Date());
		} else {
			upd.setDatecompleted(null);
		}
		upd.setDuedate(due);

		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(upd);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
}
