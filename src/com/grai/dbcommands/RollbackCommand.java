package com.grai.dbcommands;

import com.grai.data.CommandData;
import com.grai.data.Data;
import com.grai.dbparser.DBCommandConstants;

/**
 * Rolls back all the SET/UNSET transactions until the last BEGIN statement is
 * encountered
 */
public class RollbackCommand implements ICommand {

	@Override
	public void execute(CommandData commandData, String command) {
		int beginCount = commandData.getBeginCount();
		if (beginCount > 0) {
			String lastCommand = commandData.popCommand();
			while (!lastCommand.equals(DBCommandConstants.BEGIN)) {
				reverseCommand(commandData, lastCommand.trim());
				lastCommand = commandData.popCommand();
			}
			commandData.setBeginCount(beginCount - 1);
		} else {
			System.out.println("NO TRANSACTION");
		}

	}

	public void reverseCommand(CommandData commandData, String command) {
		String[] commandWithParams = command.split(" ");
		String comm = commandWithParams[0].trim();
		Data lastRecord = commandData.popRollbackData();
		if (comm.equals(DBCommandConstants.SET)
				|| command.equals(DBCommandConstants.UNSET)) {
			String variable = lastRecord.getVariable();
			String currentValue = commandData.getDataValue(variable);
			String prevValue = lastRecord.getValue();

			int currentValueCount = commandData.getNumOccurences(currentValue);
			commandData.setValueInOccurenceStore(currentValue, currentValueCount - 1);
			Integer prevValueCount = commandData.getNumOccurences(prevValue);

			if (prevValueCount != null) {
				commandData.setValueInOccurenceStore(prevValue, prevValueCount + 1);
			} else {
				commandData.setValueInOccurenceStore(prevValue, 1);
			}
			commandData.setValueInDataStore(variable, prevValue);

		}
	}

}
