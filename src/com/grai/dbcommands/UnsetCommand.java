package com.grai.dbcommands;

import com.grai.data.CommandData;
import com.grai.data.Data;

/**
 * Unsets variable value in the database. Updates the number of occurrences of
 * old value.
 */
public class UnsetCommand implements ICommand {
	// Remove varaible from database
	@Override
	public void execute(CommandData commandData, String command) {
		String[] commandWithParams = command.split("\\s");
		String variableToRemove = commandWithParams[1].trim();
		String value = commandData.getDataValue(variableToRemove);

		if (commandData.getBeginCount() > 0) {
			commandData.addCommand(command);
			commandData.addRollbackData(new Data(variableToRemove, value));
		}
		commandData.setValueInOccurenceStore(value,
				commandData.getNumOccurences(value) - 1);
		commandData.removeFromDataStore(variableToRemove);
	}
}
