package com.vamendrik.bootcamp.csvhandler.parser;

import java.io.File;

import org.apache.log4j.Logger;

import com.vamendrik.bootcamp.csvhandler.model.Config;

public class Parser {

	private File sourceFile;
	private File outputFile;
	private String template;
	
	private static final Logger logger = Logger.getLogger(Parser.class);

	public Config Validate(String[] args) {

		String find = "";

		for (int i = 0; i < args.length; i++) {

			if (args[i].equals("-i") || args[i].equals("-q") || args[i].equals("-o")) {

				find += args[i];

			}
		}

		if ((find.equals("-i-q-o")) && (args.length == 6)) {

			for (int i = 0; i < args.length; i++) {

				if (args[i].equals("-i")) {

					File file = new File(args[i + 1]);

					this.sourceFile = file;
					continue;

				}

				if (args[i].equals("-o")) {

					File file = new File(args[i + 1]);
					
					this.outputFile = file;
					
					String[] format = outputFile.getName().split("[.]");

					String fileFormat = format[format.length - 1];
					
					if (!fileFormat.equals("csv") && !fileFormat.equals("txt")) {

						logger.error("Неизвестный формат выходного файла.");
						System.exit(0);

					}
					
					continue;

				}


				if (args[i].equals("-q")) {

					this.template = args[i + 1];
					continue;

				}


			}

		} else {

			logger.error("Параметры указаны неверно!");
			System.exit(0);

		}
		return new Config(this.sourceFile,this.outputFile,this.template);

	}

}

