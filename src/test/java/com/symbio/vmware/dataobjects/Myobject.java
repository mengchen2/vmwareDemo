package com.symbio.vmware.dataobjects;
public class Myobject{
  private String testcaseid;
  private String locale;
  private String user;
  private String password;
  private String state; 
  private String priority;

  public String getTestcaseid() {
    return testcaseid;
  }

  public void setTestcaseid(String testcaseid) {
    this.testcaseid = testcaseid;
  }

  
  public String getUser() {
	return user;
}

public void setUser(String user) {
	this.user = user;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getLocale() {
	return locale;
}

public void setLocale(String locale) {
	this.locale = locale;
}


public String getPriority() {
	return priority;
}

public void setPriority(String priority) {
	this.priority = priority;
}

public String toString() {
    return "testcaseid: " + getTestcaseid().toString() + ", locale: "
      + this.getLocale().toString();
  }
}