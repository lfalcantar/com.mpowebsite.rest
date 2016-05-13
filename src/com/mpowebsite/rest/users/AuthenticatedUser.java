package com.mpowebsite.rest.users;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mpowebsite.rest.user.query.UserQuery;
import com.mpowebsite.rest.util.*;

@Path("/User")
public class AuthenticatedUser extends User {

	private String id;
	private String userName;
	private String password;
	private String firstName;
	private String middleName;
	private String lastNAme;
	private String organization;
	private String department;
	private String positionTitle;
	private String departmentContactInformation;
	private String email;
	private byte permissions;
	private UserType type;
	
	@Path("/login")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String deleteUser(@QueryParam("user") String user,@QueryParam("password") String password) throws Exception {
		return UserQuery.logIn(user,password);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) { 
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String passport_text) {
		this.password = Encode.encode(passport_text);
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastNAme() {
		return lastNAme;
	}

	public void setLastNAme(String lastNAme) {
		this.lastNAme = lastNAme;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPositionTitle() {
		return positionTitle;
	}

	public void setPositionTitle(String positionTitle) {
		this.positionTitle = positionTitle;
	}

	public String getDepartmentContactInformation() {
		return departmentContactInformation;
	}

	public void setDepartmentContactInformation(String departmentContactInformation) {
		this.departmentContactInformation = departmentContactInformation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getPermissions() {
		return permissions;
	}

	public void setPermissions(byte permissions) {
		this.permissions = permissions;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

}
