package by.pvt.heldyieu.entity;

import by.pvt.heldyieu.enums.UserType;
import by.pvt.heldyieu.interfaces.Identified;

public class User implements Identified {
		private Integer id;
	    private String firstName;
	    private String lastName;
	    private String email;
	    private String password;
	    private UserType userType;
		/**
		 * 
		 */
		public User() {
			super();
		}
		/**
		 * @param id
		 * @param firstName
		 * @param lastName
		 * @param email
		 * @param password
		 * @param userType
		 */
		public User(Integer id, String firstName, String lastName, String email,
				String password, UserType userType) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.password = password;
			this.userType = userType;
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
		 * @return the firstName
		 */
		public String getFirstName() {
			return firstName;
		}
		/**
		 * @param firstName the firstName to set
		 */
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		/**
		 * @return the lastName
		 */
		public String getLastName() {
			return lastName;
		}
		/**
		 * @param lastName the lastName to set
		 */
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		/**
		 * @return the email
		 */
		public String getEmail() {
			return email;
		}
		/**
		 * @param email the email to set
		 */
		public void setEmail(String email) {
			this.email = email;
		}
		/**
		 * @return the password
		 */
		public String getPassword() {
			return password;
		}
		/**
		 * @param password the password to set
		 */
		public void setPassword(String password) {
			this.password = password;
		}
		/**
		 * @return the userType
		 */
		public UserType getUserType() {
			return userType;
		}
		/**
		 * @param userType the userType to set
		 */
		public void setUserType(UserType userType) {
			this.userType = userType;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((email == null) ? 0 : email.hashCode());
			result = prime * result
					+ ((firstName == null) ? 0 : firstName.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result
					+ ((lastName == null) ? 0 : lastName.hashCode());
			result = prime * result
					+ ((password == null) ? 0 : password.hashCode());
			result = prime * result
					+ ((userType == null) ? 0 : userType.hashCode());
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
			if (!(obj instanceof User)) {
				return false;
			}
			User other = (User) obj;
			if (email == null) {
				if (other.email != null) {
					return false;
				}
			} else if (!email.equals(other.email)) {
				return false;
			}
			if (firstName == null) {
				if (other.firstName != null) {
					return false;
				}
			} else if (!firstName.equals(other.firstName)) {
				return false;
			}
			if (id == null) {
				if (other.id != null) {
					return false;
				}
			} else if (!id.equals(other.id)) {
				return false;
			}
			if (lastName == null) {
				if (other.lastName != null) {
					return false;
				}
			} else if (!lastName.equals(other.lastName)) {
				return false;
			}
			if (password == null) {
				if (other.password != null) {
					return false;
				}
			} else if (!password.equals(other.password)) {
				return false;
			}
			if (userType != other.userType) {
				return false;
			}
			return true;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "User : "
					+ (id != null ? "id=" + id + ", " : "")
					+ (firstName != null ? "firstName=" + firstName + ", " : "")
					+ (lastName != null ? "lastName=" + lastName + ", " : "")
					+ (email != null ? "email=" + email + ", " : "")
					+ (password != null ? "password=" + password + ", " : "")
					+ (userType != null ? "userType=" + userType.getValue() : "") + "]";
		}
		
}
