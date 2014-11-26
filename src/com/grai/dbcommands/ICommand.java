package com.grai.dbcommands;

import com.grai.data.CommandData;

/**
 * Interface implemented by all supported command classes
 */
public interface ICommand {
	public void execute(CommandData commandData, String command);
}
