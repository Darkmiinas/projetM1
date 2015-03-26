package com.supinforce.mewpipe.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {
	private PersistenceManager(){
		//
	}
	//
	private static EntityManagerFactory entityManagerFactory=null;
	public static EntityManagerFactory getEntityManagerFactory(){
		if(entityManagerFactory==null){
			entityManagerFactory= Persistence.createEntityManagerFactory("NewPersistenceUnit");
		}
		return entityManagerFactory;
	}
	public static void closeEntityManagerFactory(){
		if(entityManagerFactory!=null && entityManagerFactory.isOpen()){
			entityManagerFactory.close();
		}
	}
}
