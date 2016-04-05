package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
@Table(name="USERS")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long userid;

	private String username;

	private String userpass;

	//bi-directional many-to-one association to Todolistitem
	@OneToMany(mappedBy="user")
	private List<Todolistitem> todolistitems;

	public User() {
	}

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpass() {
		return this.userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public List<Todolistitem> getTodolistitems() {
		return this.todolistitems;
	}

	public void setTodolistitems(List<Todolistitem> todolistitems) {
		this.todolistitems = todolistitems;
	}

	public Todolistitem addTodolistitem(Todolistitem todolistitem) {
		getTodolistitems().add(todolistitem);
		todolistitem.setUser(this);

		return todolistitem;
	}

	public Todolistitem removeTodolistitem(Todolistitem todolistitem) {
		getTodolistitems().remove(todolistitem);
		todolistitem.setUser(null);

		return todolistitem;
	}

}