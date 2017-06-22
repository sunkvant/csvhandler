package com.vamendrik.bootcamp.csvhandler.start;

import org.apache.log4j.Logger;

import com.vamendrik.bootcamp.csvhandler.model.Config;
import com.vamendrik.bootcamp.csvhandler.parser.CSVReader;
import com.vamendrik.bootcamp.csvhandler.parser.Parser;

public class Start {

	private static final Logger logger = Logger.getLogger(Parser.class);
	
	public static void main(String[] args) {
		
		Parser parser=new Parser();
		
		Config config=parser.Validate(args);
		
		CSVReader reader=new CSVReader(config);
		
		reader.read();
		
		

	}

}
