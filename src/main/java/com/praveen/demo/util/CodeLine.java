package com.praveen.demo.util;

import org.springframework.stereotype.Component;

@Component
public class CodeLine {

	private int totalLineOfCode;
	private int importLines;
	private int variableDeclarationLines;

	public int getTotalLineOfCode() {
		return totalLineOfCode;
	}

	public void setTotalLineOfCode(int totalLines) {
		this.totalLineOfCode = totalLines;
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
		return "CodeLine [totalLines=" + totalLineOfCode + ", importLines=" + importLines
				+ ", variableDeclarationLines=" + variableDeclarationLines + "]";
	}

}
