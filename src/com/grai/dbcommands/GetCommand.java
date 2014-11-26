package com.grai.dbcommands;

import com.grai.data.CommandData;

/**
 * Retrieves value for stored variable in database. Prints NULL if not present
 */
public class GetCommand implements ICommand {

	@Override
	public void execute(CommandData commandData, String command) {
		String[] commandWithParams = command.split("\\s");
		String value = commandData.getDataValue(commandWithParams[1].trim());
		if (value == null) {
			System.out.println("NULL");
		} else {
			System.out.println(value);
		}

	}

}
