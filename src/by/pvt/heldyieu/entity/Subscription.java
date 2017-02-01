package by.pvt.heldyieu.entity;

import java.util.Calendar;
import java.util.Date;

import by.pvt.heldyieu.interfaces.Identified;

public class Subscription implements Identified{
	private Integer id;
	private User user ;
	private Magazine magazine;
	private SubscriptionType type;
	private Date startDate;
	private Date endDate;
	private Double price;
	/**
	 * 
	 */
	public Subscription() {
		super();
	}
	/**
	 * @param id
	 * @param user
	 * @param magazine
	 * @param type
	 * @param startDate
	 * @param endDate
	 * @param price
	 */
	public Subscription(Integer id, User user, Magazine magazine,
			SubscriptionType type, Date startDate) {
		super();
		this.id = id;
		this.user = user;
		this.magazine = magazine;
		this.type = type;
		this.startDate = startDate;
		this.endDate = addDays(startDate, type.getMonthValue());
		this.price = magazine.getPrice()*type.getMonthValue();
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the magazine
	 */
	public Magazine getMagazine() {
		return magazine;
	}
	/**
	 * @param magazine the magazine to set
	 */
	public void setMagazine(Magazine magazine) {
		this.magazine = magazine;
	}
	/**
	 * @return the type
	 */
	public SubscriptionType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(SubscriptionType type) {
		this.type = type;
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return (Date) startDate.clone();
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return (Date) endDate.clone();
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	
	private static Date addDays(Date date, int month)
	{
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    cal.add(Calendar.MONTH, month);
	    return cal.getTime();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((magazine == null) ? 0 : magazine.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Subscription)) {
			return false;
		}
		Subscription other = (Subscription) obj;
		if (endDate == null) {
			if (other.endDate != null) {
				return false;
			}
		} else if (!endDate.equals(other.endDate)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (magazine == null) {
			if (other.magazine != null) {
				return false;
			}
		} else if (!magazine.equals(other.magazine)) {
			return false;
		}
		if (price == null) {
			if (other.price != null) {
				return false;
			}
		} else if (!price.equals(other.price)) {
			return false;
		}
		if (startDate == null) {
			if (other.startDate != null) {
				return false;
			}
		} else if (!startDate.equals(other.startDate)) {
			return false;
		}
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		if (user == null) {
			if (other.user != null) {
				return false;
			}
		} else if (!user.equals(other.user)) {
			return false;
		}
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Subscription : " + (id != null ? "id=" + id + ", " : "")
				+ (user != null ? "user=" + user.toString() + ", " : "")
				+ (magazine != null ? "magazine=" + magazine.toString() + ", " : "")
				+ (type != null ? "type=" + type.toString() + ", " : "")
				+ (startDate != null ? "startDate=" + startDate + ", " : "")
				+ (endDate != null ? "endDate=" + endDate + ", " : "")
				+ (price != null ? "price=" + price : "") + "]";
	}
	
	
}
