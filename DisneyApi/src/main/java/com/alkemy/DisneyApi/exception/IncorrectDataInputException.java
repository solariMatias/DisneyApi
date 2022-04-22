package com.alkemy.DisneyApi.exception;

public class IncorrectDataInputException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -236551382289982723L;
	private String resourceName;
	private String fieldName;

	public IncorrectDataInputException(String resourceName, String fieldName) {
		super(String.format("Object %s must have '%s' as null", resourceName, fieldName));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
}
