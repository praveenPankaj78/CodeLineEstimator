package com.praveen.demo.model;

import org.springframework.stereotype.Component;

import com.praveen.demo.util.CodeLine;

@Component
public class ScanResponse {

	private int blankLines;
	private int commentLines;
	private int totalFileLines;
	private CodeLine codeLines;

	public int getBlankLines() {
		return blankLines;
	}

	public int getTotalFileLines() {
		return totalFileLines;
	}

	public void setTotalFileLines(int totalFileLines) {
		this.totalFileLines = totalFileLines;
	}

	public void setBlankLines(int blankLines) {
		this.blankLines = blankLines;
	}

	public int getCommentLines() {
		return commentLines;
	}

	public void setCommentLines(int commentLines) {
		this.commentLines = commentLines;
	}

	public CodeLine getCodeLines() {
		return codeLines;
	}

	public void setCodeLines(CodeLine codeLines) {
		this.codeLines = codeLines;
	}

	@Override
	public String toString() {
		return "ScanResponse [blankLines=" + blankLines + ", commentLines=" + commentLines + ", codeLines=" + codeLines
				+ "]";
	}

}
