package com.grai.inmemorydb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.grai.dbparser.CommandParser;

/**
 * Main class to get user input from the command line.
 */
public class DataBase {

	public static void main(String[] args) {
		CommandParser commandParser = new CommandParser();
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String input = "";
			while ((input = br.readLine().trim()) != null) {
				if (input.equals("END")) {
					break;
				}
				commandParser.parseCommand(input.trim());
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
