package com.praveen.demo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praveen.demo.model.ScanRequest;
import com.praveen.demo.model.ScanResponse;
import com.praveen.demo.util.CLang;
import com.praveen.demo.util.CodeLine;
import com.praveen.demo.util.JavaLang;

@Service
public class ScanService {

	@Autowired
	ScanResponse response;

	@Autowired
	JavaLang javaLang;

	@Autowired
	CLang cLang;

	@Autowired
	CodeLine codeLine;

	public ScanResponse scan(ScanRequest request) {
		if (request.getLanguage().equalsIgnoreCase("java")) {
			computeResponse(request.getFilePath(), javaLang.getIMPORT(), javaLang.getVARSYMBOLS(),
					javaLang.getSINGLE_LINE_COMMENT_SYMBOL(), javaLang.getMULTI_LINE_COMMENT_START(),
					javaLang.getMULTI_LINE_COMMENT_END());
		} else if (request.getLanguage().equalsIgnoreCase("C")) {
			computeResponse(request.getFilePath(), cLang.getIMPORT(), cLang.getVARSYMBOLS(),
					cLang.getSINGLE_LINE_COMMENT_SYMBOL(), cLang.getMULTI_LINE_COMMENT_START(),
					cLang.getMULTI_LINE_COMMENT_END());
		}

		return response;
	}

	private void computeResponse(ArrayList<String> filePath, String imports, ArrayList<String> variableSymbols,
			String singleComment, String multiCommentStart, String multiCommentEnd) {
		// TODO Auto-generated method stub
		int blankLines = 0;
		int commentLines = 0;
		int totalCodeLines = 0;
		int variableDecl = 0;
		int importLines = 0;

		for (int i = 0; i < filePath.size(); ++i) {
			File file = new File(filePath.get(i));
			try {
				Scanner sc = new Scanner(file);
				boolean multiCommentFlag = false;

				while (sc.hasNextLine()) {
					String line = sc.nextLine().trim();

					// Check if it is blank line
					if (line.isBlank()) {
						++blankLines;
						continue;
					}
					/*
					 * System.out.println(line.length()); System.out.println(line.substring(0,
					 * singleComment.length()-1)); System.out.println("");
					 */

					// Check if it is a single comment line. This line for example.
					if (line.length() >= singleComment.length()
							&& line.substring(0, singleComment.length()).equalsIgnoreCase(singleComment)) {
						++commentLines;
						continue;
					}

					// Check for multi line comment already exists
					if (multiCommentFlag) {
						++commentLines;

						// Check if multiComment ends in this line.
						if (line.contains(multiCommentEnd)) {
							multiCommentFlag = false;
						}

						continue;

					}

					// Check if multi line comment starts here
					if (line.length() >= multiCommentStart.length()
							&& line.substring(0, multiCommentStart.length()).equalsIgnoreCase(multiCommentStart)) {

						if (!line.contains(multiCommentEnd)) {
							multiCommentFlag = true;
						}
						++commentLines;
						continue;
					}

					// Check if multicomment starts in the middle of the line
					if (line.contains(multiCommentStart)) {
						if (line.contains(multiCommentEnd)
								&& (line.indexOf(multiCommentEnd) - line.indexOf(multiCommentStart)) > 0) {
							multiCommentFlag = false;
						} else {
							multiCommentFlag = true;
						}

					}

					// Check if it is import statement
					if (line.length() >= imports.length()
							&& line.substring(0, imports.length()).equalsIgnoreCase(imports)) {
						++importLines;
					}

					/*
					 * Check if there is a variable declaration. Please check Language class in util
					 * module for list of supported data types. This code checks variable type and =
					 * presence in the line with = being present after dataType.
					 */
					for (int j = 0; j < variableSymbols.size(); ++j) {
						if (line.contains(variableSymbols.get(j)) && line.contains("=")
								&& (line.indexOf("=") - line.indexOf(variableSymbols.get(j)) > 0)) {
							++variableDecl;
							break;
						}
					}

					++totalCodeLines;

				}

				sc.close();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Error occured while reading file :" + filePath.get(i));
				e.printStackTrace();
			}
		}

		response.setBlankLines(blankLines);
		response.setCommentLines(commentLines);
		codeLine.setImportLines(importLines);
		codeLine.setTotalLines(totalCodeLines);
		codeLine.setVariableDeclarationLines(variableDecl);
		response.setCodeLines(codeLine);

	}

}
