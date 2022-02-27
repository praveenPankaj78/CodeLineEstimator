package com.praveen.demo.util;

import org.springframework.stereotype.Component;

@Component
public class CodeLine {

	private int totalLines;
	private int importLines;
	private int variableDeclarationLines;

	public int getTotalLines() {
		return totalLines;
	}

	public void setTotalLines(int totalLines) {
		this.totalLines = totalLines;
	}

	public int getImportLines() {
		return importLines;
	}

	public void setImportLines(int importLines) {
		this.importLines = importLines;
	}

	public int getVariableDeclarationLines() {
		return variableDeclarationLines;
	}

	public void setVariableDeclarationLines(int variableDeclarationLines) {
		this.variableDeclarationLines = variableDeclarationLines;
	}

	@Override
	public String toString() {
		return "CodeLine [totalLines=" + totalLines + ", importLines=" + importLines + ", variableDeclarationLines="
				+ variableDeclarationLines + "]";
	}

}
