package com.vamendrik.bootcamp.csvhandler.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.vamendrik.bootcamp.csvhandler.model.Config;

public class CSVReader {

	private File sourceFile;
	private File outputFile;
	private String template;
	private List<List<String>> array = new ArrayList<List<String>>();
	private static final Logger logger = Logger.getLogger(CSVReader.class);
	
	public CSVReader(Config config) {

		this.sourceFile = config.getSourceFile();
		this.outputFile = config.getOutputFile();
		this.template = config.getTemplate();

	}

	public void read() {

		try {
			
			String line = "";
			
			logger.info("Начата обработка файла "+this.sourceFile.getPath());

			BufferedReader br = new BufferedReader(new FileReader(this.sourceFile));

			while ((line = br.readLine()) != null) {

				String[] pars = line.split(" ");
				
				if (array.size() < pars.length) {
					int k=pars.length - array.size();
					for (int i = 0; i < k; i++) {

						List<String> column = new ArrayList<String>();
						array.add(column);

					}
				}

				for (int i = 0; i < pars.length; i++) {

					array.get(i).add(pars[i]);

				}

			}
			
			br.close();
			
			String[] format = outputFile.getName().split("[.]");

			String fileFormat = format[format.length - 1];

			if (fileFormat.equals("csv")) {
				
				boolean find=false;

				FileWriter fw=new FileWriter(this.outputFile);
				
				for (int i = 0; i < array.size(); i++) {
					for (int j = 0; j < array.get(i).size(); j++) {
						
						if (array.get(i).get(j).equals(this.template)){
							
							find=true;
							
							for(int k=0; k<array.get(i).size(); k++) {
								
								fw.write(array.get(i).get(k)+" ");
								
								
							}
							
							fw.write("\r\n");
						}

					}

				}
				
				fw.close();
				
				if (find) {
					
					logger.info("Найдены столбцы содержащие шаблон для поиска. Результат обработкм в "+this.outputFile.getPath());
				} else {
					
					logger.info("Не найдено ни одного столбца, содержащего шаблон для поиска!");
					this.outputFile.delete();
					
				}

			}

			if (fileFormat.equals("txt")) {

				FileWriter fw=new FileWriter(this.outputFile);
				
				for (int i = 0; i < array.size(); i++) {
					for (int j = 0; j < array.get(i).size(); j++) {
						
						if (array.get(i).get(j).equals(this.template)){
							
							for(int k=0; k<array.get(i).size(); k++) {
								
								fw.write(array.get(i).get(k)+"\r\n");
								
								
							}
							
							
						}

					}

				}
				
				fw.close();
			}


			

		} catch (ArrayIndexOutOfBoundsException e) {

			logger.error("Структура файла не корректна!");
			System.exit(0);
		}

		catch (IOException e) {
			logger.error("Файл " + this.sourceFile.getName() + " не найден или к нему нет доступа!");
			System.exit(0);

		}

	}

}
