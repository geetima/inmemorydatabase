package com.grai.dbcommands;

import java.util.Stack;

import com.grai.data.CommandData;
import com.grai.data.Data;

/**
 * Commit marks the commitment to all transactions since the first BEGIN
 * statement entered by the user. If no BEGIN statement has been entered, NO
 * TRANSACTION is output
 */
public class CommitCommand implements ICommand {

	@Override
	public void execute(CommandData commandData, String command) {
		if (commandData.getBeginCount() == 0) {
			System.out.println("NO TRANSACTION");
		} else {
			commandData.setBeginCount(0);
			commandData.setCommandStack(new Stack<String>());
			commandData.setRollbackHelperStack(new Stack<Data>());
		}

	}

}
