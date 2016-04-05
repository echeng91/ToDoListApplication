package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the STATUS database table.
 * 
 */
@Entity
@NamedQuery(name="Status.findAll", query="SELECT s FROM Status s")
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long statusid;

	private String statusdescription;

	//bi-directional many-to-one association to Todolistitem
	@OneToMany(mappedBy="status")
	private List<Todolistitem> todolistitems;

	public Status() {
	}

	public long getStatusid() {
		return this.statusid;
	}

	public void setStatusid(long statusid) {
		this.statusid = statusid;
	}

	public String getStatusdescription() {
		return this.statusdescription;
	}

	public void setStatusdescription(String statusdescription) {
		this.statusdescription = statusdescription;
	}

	public List<Todolistitem> getTodolistitems() {
		return this.todolistitems;
	}

	public void setTodolistitems(List<Todolistitem> todolistitems) {
		this.todolistitems = todolistitems;
	}

	public Todolistitem addTodolistitem(Todolistitem todolistitem) {
		getTodolistitems().add(todolistitem);
		todolistitem.setStatus(this);

		return todolistitem;
	}

	public Todolistitem removeTodolistitem(Todolistitem todolistitem) {
		getTodolistitems().remove(todolistitem);
		todolistitem.setStatus(null);

		return todolistitem;
	}

}