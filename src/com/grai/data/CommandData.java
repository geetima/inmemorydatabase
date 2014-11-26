package com.grai.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/**
 * Class consisting of in-memory data storage, number of occurrences of each value.
 * Modifies data in between function calls for different commands.
 */
public class CommandData {

	// In-memory storage
	Map<String, String> dataStore = new HashMap<String, String>();

	// HashMap to keep count of number of occurences of values
	Map<String, Integer> occurenceStore = new HashMap<String, Integer>();

	// Count for number of BEGIN statements
	int beginCount = 0;

	// Stack for storing commands after BEGIN statement
	Stack<String> commandStack = new Stack<String>();

	// Data stack to roll back to previous BEGIN statement
	Stack<Data> rollbackHelperStack = new Stack<Data>();

	public Map<String, String> getDataStore() {
		return dataStore;
	}

	public void setDataStore(Map<String, String> store) {
		this.dataStore = store;
	}

	public Map<String, Integer> getOccurenceStore() {
		return occurenceStore;
	}

	public void setOccurenceStore(Map<String, Integer> occurenceStore) {
		this.occurenceStore = occurenceStore;
	}

	public int getBeginCount() {
		return beginCount;
	}

	public void setBeginCount(int beginCount) {
		this.beginCount = beginCount;
	}

	public Stack<String> getCommandStack() {
		return commandStack;
	}

	public void setCommandStack(Stack<String> commandsStack) {
		this.commandStack = commandsStack;
	}

	public Stack<Data> getRollbackHelperStack() {
		return rollbackHelperStack;
	}

	public void setRollbackHelperStack(Stack<Data> rollbackHelperStack) {
		this.rollbackHelperStack = rollbackHelperStack;
	}

	public void setValueInDataStore(String variable, String value) {
		getDataStore().put(variable, value);
	}

	public void setValueInOccurenceStore(String value, Integer num) {
		getOccurenceStore().put(value, num);
	}

	public void addCommand(String command) {
		getCommandStack().push(command);
	}

	public void addRollbackData(Data data) {
		getRollbackHelperStack().push(data);
	}

	public boolean dataStoreContainsKey(String key) {
		return getDataStore().containsKey(key);
	}

	public boolean occurenceStoreContainsKey(String key) {
		return getOccurenceStore().containsKey(key);
	}

	public String getDataValue(String key) {
		return getDataStore().get(key);
	}

	public Integer getNumOccurences(String value) {
		return getOccurenceStore().get(value);
	}

	public String popCommand() {
		return getCommandStack().pop();
	}

	public Data popRollbackData() {
		return getRollbackHelperStack().pop();
	}

	public void removeFromDataStore(String variable) {
		getDataStore().remove(variable);
	}

}
