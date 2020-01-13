package ch.bbw.algorithmproj.controller;

import java.util.List;

import ch.bbw.algorithmproj.model.BoyerMooreAlgorithm;
import ch.bbw.algorithmproj.view.MessageBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class TextEditorController {
	@FXML
	private TextArea textArea;
	@FXML
	private TextField searchField;
	@FXML
	private Button searchButton;
	
	@FXML
	private void searchText(ActionEvent event) {
		if(!textArea.getText().isEmpty() && !searchField.getText().isEmpty()){
			List<Integer> finds = BoyerMooreAlgorithm.search(textArea.getText().toCharArray(), searchField.getText().toCharArray());
			displayFoundPositions(finds);
		}
	}
	
	private void displayFoundPositions(List<Integer> pos) {
		StringBuilder sb = new StringBuilder();
		for(int position : pos) {
			sb.append(fetchPartOfText(position));
			sb.append("\t\t\t");
			sb.append("Position:  ");
			sb.append(position);
			sb.append("\n");
		}
		
		if(pos.isEmpty()) {
			MessageBox.show("Keine Gefundene Stellen", "Dieser Suchstring kommt nie vor" , AlertType.INFORMATION);
		} else {
			MessageBox.show("Gefundene Stellen", sb.toString() , AlertType.INFORMATION);
		}
	}
	
	private String fetchPartOfText(int position) {
		String searchText = searchField.getText().replace("\n", "");
		String text = textArea.getText();
		
		int amountOfExtraLetters = 5;
		int startPos;
		int endPos;
		
		if(position - amountOfExtraLetters < 0) {
			startPos = 0;
		} else {
			startPos = position - amountOfExtraLetters;
		}
		
		if(position + searchText.length() + amountOfExtraLetters > text.length()) {
			endPos = text.length();
		} else {
			endPos = position + searchText.length() + amountOfExtraLetters;
		}
		
		if(startPos == 0 && endPos == text.length()) {
			return text.substring(startPos, endPos);
		} else if(startPos == 0) {
			return text.substring(startPos, endPos) + "...";
		} else if(endPos == text.length()) {
			return "..." + text.substring(startPos, endPos);
		} else {
			return "..." + text.substring(startPos, endPos) + "...";
		}
	}
}
