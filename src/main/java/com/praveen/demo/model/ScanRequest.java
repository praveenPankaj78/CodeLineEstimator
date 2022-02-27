package com.praveen.demo.model;

import java.util.ArrayList;

public class ScanRequest {

	private String language;
	private ArrayList<String> filePath;

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public ArrayList<String> getFilePath() {
		return filePath;
	}

	public void setFilePath(ArrayList<String> filePath) {
		this.filePath = filePath;
	}

	@Override
	public String toString() {
		return "ScanRequest [language=" + language + ", filePath=" + filePath + "]";
	}

}
