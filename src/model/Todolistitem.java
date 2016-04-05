package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the TODOLISTITEMS database table.
 * 
 */
@Entity
@Table(name="TODOLISTITEMS")
@NamedQuery(name="Todolistitem.findAll", query="SELECT t FROM Todolistitem t")
public class Todolistitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long itemid;

	@Temporal(TemporalType.DATE)
	private Date datecompleted;

	@Temporal(TemporalType.DATE)
	private Date duedate;

	private String itemdescription;

	private String itemname;

	private BigDecimal priority;

	//bi-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name="ITEMSTATUS")
	private Status status;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="ITEMUSER")
	private User user;

	public Todolistitem() {
	}

	public long getItemid() {
		return this.itemid;
	}

	public void setItemid(long itemid) {
		this.itemid = itemid;
	}

	public Date getDatecompleted() {
		return this.datecompleted;
	}

	public void setDatecompleted(Date datecompleted) {
		this.datecompleted = datecompleted;
	}

	public Date getDuedate() {
		return this.duedate;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}

	public String getItemdescription() {
		return this.itemdescription;
	}

	public void setItemdescription(String itemdescription) {
		this.itemdescription = itemdescription;
	}

	public String getItemname() {
		return this.itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public BigDecimal getPriority() {
		return this.priority;
	}

	public void setPriority(BigDecimal priority) {
		this.priority = priority;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}