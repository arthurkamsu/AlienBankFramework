package com.alienbankframework.controller.implementations;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.alienbankframework.Alien;
import com.alienbankframework.controller.IController;
import com.alienbankframework.domain.EntryType;
import com.alienbankframework.domain.IAccount;
import com.alienbankframework.domain.IAccountFactory;
import com.alienbankframework.domain.ICustomer;
import com.alienbankframework.domain.ICustomerFactory;
import com.alienbankframework.domain.implementations.Account;
import com.alienbankframework.domain.implementations.AccountFactory;
import com.alienbankframework.domain.implementations.CustomerFactory;
import com.alienbankframework.service.implementations.AccountManager;
import com.alienbankframework.view.AbstractEntryDialog;
import com.alienbankframework.view.AlienForm;
import com.alienbankframework.view.JDialog_AddPCustomer;
import com.alienbankframework.view.JDialog_Entry;

import java.awt.event.*;
import java.time.LocalDate;
import java.util.Iterator;

public class AlienController implements IController{
	
	private static volatile AlienController instance = null;
	
	
	AlienForm frame;	
	AccountManager manager;
	JButton buttonCusAC;
	JButton buttonAddInterest;
	JButton buttonDeposit;
	JButton buttonWithdraw;
	ICustomerFactory customerFactory;
	IAccountFactory accountFactory;
	String accountnr, clientName,street,city,zip,state,accountType,email,amountDeposit;
	boolean newaccount;
    private Object rowdata[];
    private DefaultTableModel model;
    private JTable JTable1;
    String accnr = null;
    int selection = -1;
    
    
    public static AlienController getInstance() {
        if (instance == null) {
            synchronized(Alien.class) {
                if (instance == null) {
                    instance = new AlienController();
                }                
            }
        }else System.out.println("Instance of AlienController alredy exists. The existing instance is being returned.");
        return instance;
    }
    
    private AlienController() {}
	
	public void Initialize(AlienForm frame, AccountManager manager) {
		this.frame = frame;
		this.manager = manager;
		
		buttonCusAC = this.frame.getJButton_PerAC();
		buttonAddInterest = this.frame.getJButton_Addinterest();
		buttonDeposit = this.frame.getJButton_Deposit();
		buttonWithdraw = this.frame.getJButton_Withdraw();
		
		rowdata = new Object[8];
		//model = frame.getTableModel();
		JTable1 = frame.getTable();
		model = (DefaultTableModel) JTable1.getModel();
		//JTable1.setModel(model);
		
		buttonCusAC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				createCustomerAccount();
			}
		});
		
		buttonAddInterest.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				addInterest();
			}
		});
		
		buttonDeposit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				deposit();
			}
		});
		
		buttonWithdraw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				withdraw();
			}
		});
	}
	
	private void createCustomerAccount() {
		JDialog_AddPCustomer pac = new JDialog_AddPCustomer(frame, this);
		pac.setBounds(450, 20, 300, 330);
		pac.show();

		if (newaccount){
			customerFactory = new CustomerFactory(clientName, state, street, city, zip, email);
			ICustomer customer = customerFactory.getCustomer();
			accountFactory = new AccountFactory(customer, accountnr, 0);
			IAccount account = accountFactory.getAccount();
			manager.addAccount(account);
			// add row to table
            rowdata[0] = accountnr;
            rowdata[1] = clientName;
            rowdata[2] = city;
            rowdata[3] = state;
            rowdata[4] = street;
            rowdata[5] = "0";
            //System.out.println(accountnr + ", " + clientName + ", " + city);
            model.addRow(rowdata);
            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
            model.fireTableDataChanged();
            newaccount=false;
            
        }
	}
	
	public String getAccountnr() {
		return accountnr;
	}

	public void setAccountnr(String accountnr) {
		this.accountnr = accountnr;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAmountDeposit() {
		return amountDeposit;
	}

	public void setAmount(String amountDeposit) {
		this.amountDeposit = amountDeposit;
	}

	public String getAccnr() {
		return accnr;
	}

	public void setAccnr(String accnr) {
		this.accnr = accnr;
	}

	
	public boolean isNewaccount() {
		return newaccount;
	}

	public void setNewaccount(boolean newaccount) {
		this.newaccount = newaccount;
	}

	private void addInterest() {
		manager.addInterestOnAccounts(0.15);//to be changed later to give the possibility to apply a custum interest rate.
		updateAccounts();
	}
	
	private void updateAccounts() {
		int count = 0;
		Iterator iterator = manager.iterator();
		while(iterator.hasNext()) {
			Account acc = (Account) iterator.next();
			model.setValueAt(String.valueOf(acc.getCurrentBalance()),count, 5);
			count++;
		}
	}
	
	private boolean setAccnr() {
		selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			accnr = (String)model.getValueAt(selection, 0);
			return true;
		}
		return false;
	}
	
	private double getAmount(AbstractEntryDialog wd) {
		Double amount = null;
		
		//Show the dialog for adding withdraw amount for the current mane
		wd.setAccnr(accnr);
		wd.setBounds(430, 15, 275, 140);
		wd.show();
		
		// compute new amount
		if (amountDeposit != null) {
			amount = Double.parseDouble(amountDeposit);
			amountDeposit = null;
		}
		
        return amount;
	}
	
	private void deposit() {
		if (setAccnr()) {
			AbstractEntryDialog dialog = new JDialog_Entry(frame, accnr, this,"Deposit");
			Double deposit = getAmount(dialog);
			if (deposit != null && accnr != null) {
				manager.createEntry(accnr, LocalDate.now(), deposit, EntryType.DEPOSIT);
				model.setValueAt(String.valueOf(manager.getEntryBalance()),selection, 5);
			}
			accnr = null;
		}
	}
	
	private void withdraw() {
		if (setAccnr()) {
			AbstractEntryDialog dialog = new JDialog_Entry(frame, accnr, this, "Withdraw");
			Double withdraw = getAmount(dialog);
			if (withdraw != null && accnr != null) {
				manager.createEntry(accnr, LocalDate.now(), withdraw, EntryType.WITHDRAW);
				model.setValueAt(String.valueOf(manager.getEntryBalance()),selection, 5);
			}
			accnr = null;
		}
	}
}
