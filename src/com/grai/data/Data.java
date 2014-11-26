package com.grai.data;

/**
 * Class representing data stored in in-memory database
 */
public class Data {

	private String variable;
	private String value;

	public Data(String variable, String value) {
		setVariable(variable);
		setValue(value);
	}

	public String getVariable() {
		return variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
