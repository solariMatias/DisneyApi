package com.alkemy.DisneyApi.exception;

public class DuplicatedItemException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -677787986891327727L;

	private final static String ALRDY_ON_LIST = "Item already on list";

	public DuplicatedItemException() {
		super(ALRDY_ON_LIST);
	}

	public static String getAlrdyOnList() {
		return ALRDY_ON_LIST;
	}

}
