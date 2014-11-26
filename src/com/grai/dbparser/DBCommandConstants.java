package com.grai.dbparser;

/**
 * Declaring command constants with expected number of parameters for each
 * command
 */
public class DBCommandConstants {

	public static final String SET = "SET";
	public static final String GET = "GET";
	public static final String UNSET = "UNSET";
	public static final String NUMEQUALTO = "NUMEQUALTO";
	public static final String END = "END";
	public static final String BEGIN = "BEGIN";
	public static final String ROLLBACK = "ROLLBACK";
	public static final String COMMIT = "COMMIT";
	public static final int NUM_OF_WORDS_IN_SET = 3;
	public static final int NUM_OF_WORDS_IN_GET = 2;
	public static final int NUM_OF_WORDS_IN_UNSET = 2;
	public static final int NUM_OF_WORDS_IN_NUMEQUALTO = 2;
	public static final int NUM_OF_WORDS_IN_END = 1;
	public static final int NUM_OF_WORDS_IN_BEGIN = 1;
	public static final int NUM_OF_WORDS_IN_ROLLBACK = 1;
	public static final int NUM_OF_WORDS_IN_COMMIT = 1;

}
