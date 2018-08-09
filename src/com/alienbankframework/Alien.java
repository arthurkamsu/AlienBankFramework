package com.alienbankframework;

import com.alienbankframework.controller.implementations.AlienController;
import com.alienbankframework.service.implementations.AccountManager;
import com.alienbankframework.view.AlienForm;

public final class Alien {
	
	private static volatile Alien instance = null;
	
	private boolean isInitialized = false;
	private AccountManager acctManager;
	private AlienForm alienframe;
	
	public void Initialize()
	{
		this.acctManager = AccountManager.getInstance();//model-service		
		this.alienframe = AlienForm.getInstance(); //view
		AlienController.getInstance().Initialize(this.alienframe, this.acctManager);	// controller	
		this.isInitialized = true;
	}
	public void lunch() {
		if(!this.isInitialized)
			Initialize();
		this.alienframe.setVisible(true);//display the view
	}
/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		lunch();
	
	}
*/
	

    private Alien() {}

    public static Alien getInstance() {
        if (instance == null) {
            synchronized(Alien.class) {
                if (instance == null) {
                    instance = new Alien();
                }                
            }
        }else System.out.println("Instance of Alien alredy exists. The existing instance is being returned.");
        return instance;
    }
	
}
