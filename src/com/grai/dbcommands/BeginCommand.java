package com.grai.dbcommands;

import java.util.HashMap;
import java.util.Stack;

import com.grai.data.CommandData;
import com.grai.data.Data;

/**
 * Begin signifies a new transaction. If user has input the first BEGIN
 * statement, all storage is refreshed. If user inputs nested BEGIN statements,
 * all GET, SET and BEGIN commands are stored in command stack to be used later
 * for ROLLBACK.
 */
public class BeginCommand implements ICommand {

	@Override
	public void execute(CommandData commandData, String command) {
		int beginCount = commandData.getBeginCount();
		if (beginCount == 0) {
			commandData.setDataStore(new HashMap<String, String>());
			commandData.setCommandStack(new Stack<String>());
			commandData.setRollbackHelperStack(new Stack<Data>());
			commandData.setOccurenceStore(new HashMap<String, Integer>());
		}
		beginCount++;
		commandData.setBeginCount(beginCount);
		commandData.addCommand(command);
	}

}
