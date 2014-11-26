package com.grai.dbcommands;

import com.grai.data.CommandData;
import com.grai.data.Data;

/**
 * Sets variable value in the database Updates the number of occurrences of old
 * value and the new value of the variable.
 */
public class SetCommand implements ICommand {
	
	@Override
	public void execute(CommandData commandData, String command) {
		String[] commandWithParams = command.split("\\s");
		String variable = commandWithParams[1].trim();
		String value = commandData.getDataValue(variable);
		if (commandData.getBeginCount() > 0) {
			commandData.addCommand(command);
			commandData.addRollbackData(new Data(variable, value));
		}
		
		if (value!=null) {
			int numOccurencesOldValue = commandData.getNumOccurences(value);
			commandData.setValueInOccurenceStore(value, numOccurencesOldValue-1);
		}
		String newValue = commandWithParams[2].trim();
		commandData.setValueInDataStore(commandWithParams[1].trim(),newValue);
		Integer numOccurencesNewValue = commandData.getNumOccurences(newValue);
		
		if(numOccurencesNewValue!=null) {
			commandData.setValueInOccurenceStore(newValue, numOccurencesNewValue+1);
		} else {
			commandData.setValueInOccurenceStore(newValue, 1);
		}

	}

}
