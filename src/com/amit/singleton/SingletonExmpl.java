package com.amit.singleton;

import java.io.Serializable;

public class SingletonExmpl extends Thread implements Serializable,Cloneable{

	
	public static void main(String[] args) throws Exception {
		SingletonExmpl t1=new SingletonExmpl();
		t1.start();
		
		
		SingletonExmpl t2=new SingletonExmpl();
		t2.start();
		
	}
	
	// static SingletonExmpl s=new SingletonExmpl();// Eager Initialization: In this
	// approach,
	// the instance is created eagerly, at the time of
	// class loading.

	static SingletonExmpl s = null; // Lazy initialization: create the instance only when it's needed

	private SingletonExmpl() throws Exception{

	}

	{
		if(s!=null) {
			//instance initilizer block
			//throw new Exception("Obj is already present");
		}
	}
	
	static SingletonExmpl getInstance() throws Exception {
		if (s == null) {
			synchronized (SingletonExmpl.class) {
				if(s==null) {                             // double chech locking
					s = new SingletonExmpl();	
				}
			}
			//s = new SingletonExmpl();
		}
		return s;
	}
	
	Object readResolve() {  // we override readResolve method 
	 return s;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return s;
	}
	
	@Override
	public void run() {
		try {
			SingletonExmpl s6 = SingletonExmpl.getInstance();
			System.out.println(s6.hashCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}