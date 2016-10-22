package com.appdirect.model;

public class AppDirectException extends Exception{

	
	 /**
	 * 
	 */
	private static final long serialVersionUID = -3431296220120603812L;
	private int code;
	  public AppDirectException (int code, String msg) {
	    super(msg);
	    this.code = code;
	  }
}
