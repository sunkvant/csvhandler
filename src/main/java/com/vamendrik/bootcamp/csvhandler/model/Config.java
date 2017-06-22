package com.vamendrik.bootcamp.csvhandler.model;

import java.io.File;

public class Config {
	
	private File sourceFile;
	private File outputFile;
	private String template;

	public Config(File sourceFile,File outputFile,String template) {
		
		this.sourceFile=sourceFile;
		this.outputFile=outputFile;
		this.template=template;
		
		
	}
	
	public File getSourceFile() {
		return sourceFile;
	}
	
	public File getOutputFile() {
		return outputFile;
	}
	
	public String getTemplate() {
		return template;
	}

}
