package mBeans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class MrBean {
	private String name;

	public String displayName() {
		System.out.println(name);
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
