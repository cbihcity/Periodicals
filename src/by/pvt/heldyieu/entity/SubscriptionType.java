package by.pvt.heldyieu.entity;

import by.pvt.heldyieu.interfaces.Identified;

public class SubscriptionType implements Identified{
	private Integer id;
	private String name;
	private Integer monthValue;
	/**
	 * 
	 */
	public SubscriptionType() {
		super();
	}
	/**
	 * @param id
	 * @param name
	 * @param monthValue
	 */
	public SubscriptionType(Integer id, String name, Integer monthValue) {
		super();
		this.id = id;
		this.name = name;
		this.monthValue = monthValue;
	}
	/**
	 * @return the id
	 */
	@Override
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the monthValue
	 */
	public Integer getMonthValue() {
		return monthValue;
	}
	/**
	 * @param monthValue the monthValue to set
	 */
	public void setMonthValue(Integer monthValue) {
		this.monthValue = monthValue;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((monthValue == null) ? 0 : monthValue.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (!(obj instanceof SubscriptionType)) {
			return false;
		}
		SubscriptionType other = (SubscriptionType) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (monthValue == null) {
			if (other.monthValue != null) {
				return false;
			}
		} else if (!monthValue.equals(other.monthValue)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SubscriptionType : " + (id != null ? "id=" + id + ", " : "")
				+ (name != null ? "name=" + name + ", " : "")
				+ (monthValue != null ? "monthValue=" + monthValue : "") + "]";
	}
	
	
}
