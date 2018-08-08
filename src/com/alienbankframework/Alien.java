package com.alienbankframework;

import com.alienbankframework.controller.implementations.AlienController;
import com.alienbankframework.service.implementations.AccountManager;
import com.alienbankframework.view.AlienForm;

public class Alien {
	private static boolean isInitialized = false;
	private static AccountManager acctManager;
	private static AlienForm alienframe;
	
	public static void Initialize()
	{
		acctManager = new AccountManager();
		alienframe = new AlienForm(); 
		new AlienController(alienframe, acctManager);	
		isInitialized = true;
	}
	public static void lunch() {
		if(!isInitialized)
			Initialize();
		alienframe.setVisible(true);
	}
/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		lunch();
	
	}
*/
	
}
