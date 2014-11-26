package com.grai.dbcommands;

import com.grai.data.CommandData;

/**
 * Retrieves number of variable with values equal to the number input by user
 */
public class NumEqualToCommand implements ICommand {
	@Override
	public void execute(CommandData commandData, String command) {
		String[] commandWithParams = command.split("\\s");
		String value = commandWithParams[1].trim();
		Integer num = commandData.getNumOccurences(value);
		if (num == null) {
			System.out.println(0);
		} else {
			System.out.println(num);
		}

	}

}
