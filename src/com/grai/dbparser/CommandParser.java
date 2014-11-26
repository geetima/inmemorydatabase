package com.grai.dbparser;

import com.grai.data.CommandData;
import com.grai.dbcommands.BeginCommand;
import com.grai.dbcommands.CommitCommand;
import com.grai.dbcommands.GetCommand;
import com.grai.dbcommands.ICommand;
import com.grai.dbcommands.NumEqualToCommand;
import com.grai.dbcommands.RollbackCommand;
import com.grai.dbcommands.SetCommand;
import com.grai.dbcommands.UnsetCommand;

/**
 * Parser to make calls to required commands as input by the user or ask the
 * user to enter the command in case of invalid input.
 */
public class CommandParser {
	CommandData commandData = new CommandData();

	public void parseCommand(String command) {
		String[] commandWithParams = command.split("\\s+");
		String comm = commandWithParams[0].trim();
		ICommand ic = null;
		if ((comm.equals(DBCommandConstants.SET))
				&& (commandWithParams.length == DBCommandConstants.NUM_OF_WORDS_IN_SET)) {
			ic = new SetCommand();
			ic.execute(commandData, command);
		} else if ((comm.equals(DBCommandConstants.UNSET))
				&& (commandWithParams.length == DBCommandConstants.NUM_OF_WORDS_IN_UNSET)) {
			ic = new UnsetCommand();
			ic.execute(commandData, command);
		} else if ((comm.equals(DBCommandConstants.GET))
				&& (commandWithParams.length == DBCommandConstants.NUM_OF_WORDS_IN_GET)) {
			ic = new GetCommand();
			ic.execute(commandData, command);
		} else if ((comm.equals(DBCommandConstants.NUMEQUALTO))
				&& (commandWithParams.length == DBCommandConstants.NUM_OF_WORDS_IN_NUMEQUALTO)) {
			ic = new NumEqualToCommand();
			ic.execute(commandData, command);
		} else if ((comm.equals(DBCommandConstants.BEGIN))
				&& (commandWithParams.length == DBCommandConstants.NUM_OF_WORDS_IN_BEGIN)) {
			ic = new BeginCommand();
			ic.execute(commandData, command);
		} else if ((comm.equals(DBCommandConstants.COMMIT))
				&& (commandWithParams.length == DBCommandConstants.NUM_OF_WORDS_IN_COMMIT)) {
			ic = new CommitCommand();
			ic.execute(commandData, command);
		} else if ((comm.equals(DBCommandConstants.ROLLBACK))
				&& (commandWithParams.length == DBCommandConstants.NUM_OF_WORDS_IN_ROLLBACK)) {
			ic = new RollbackCommand();
			ic.execute(commandData, command);
		} else {
			System.out.println("INVALID COMMAND. TRY AGAIN");
		}
	}

}
