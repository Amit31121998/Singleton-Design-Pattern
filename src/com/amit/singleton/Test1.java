package com.amit.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test1  implements Cloneable{

	public static void main(String[] args) throws Exception {
		
		SingletonExmpl s1 = SingletonExmpl.getInstance();
		System.out.println(s1.hashCode());
		
		
		  SingletonExmpl s2 = SingletonExmpl.getInstance();
		 System.out.println(s2.hashCode());
		  
		  SingletonExmpl s3 = SingletonExmpl.getInstance();
		  System.out.println(s3.hashCode());
		 
		
		//reflection-- private constructor & private method
		
		/*
		Constructor<SingletonExmpl> s4 = SingletonExmpl.class.getDeclaredConstructor();
		
		s4.setAccessible(true);
		s4.newInstance();
		System.out.println(s4.hashCode());
		
		*/
		// by using De-Serilization
		
		//serilization
		
		FileOutputStream fos=new FileOutputStream("C:\\Users\\DELL\\OneDrive\\Desktop\\serilize.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(s1);
		
		
		//De-serilize
		
		FileInputStream fis=new FileInputStream("C:\\Users\\DELL\\OneDrive\\Desktop\\serilize.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		SingletonExmpl s5=(SingletonExmpl)ois.readObject();
		System.out.println(s5.hashCode());
		
		// by using clone 
		SingletonExmpl s6=(SingletonExmpl) s5.clone();
		System.out.println(s6.hashCode());
	}
 }
