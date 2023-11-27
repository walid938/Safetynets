package com.safetynet.alerts.model.specific;

import java.util.List;

import com.safetynet.alerts.model.Person;

	public class ChildFamily {
	    private List<Child> child;
	    private List<Person> family;

	    public ChildFamily(List<Child> child, List<Person> family) {
	        this.child = child;
	        this.family = family;
	    }

	    public List<Child> getChild() {
	        return child;
	    }

	    public void setChildInfo(List<Child> childInfo) {
	        this.child = child;
	    }

	    public List<Person> getFamily() {
	        return family;
	    }

	    public void setFamily(List<Person> family) {
	        this.family = family;
	    }

		public void addChild(String string, String string2, int i) {
			// TODO Auto-generated method stub
			
		}
	}
	
