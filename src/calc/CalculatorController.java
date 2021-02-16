package calc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class CalculatorController {
	
	@FXML
	private Label expression;
	@FXML
	private Label result;
	
	//Display the numbers on the label expression
	public void insertOperator(String operator) {
		expression.setText(expression.getText()+ " " + operator + " " );
	}
	
	//Display the operators on the label expression
	public void insertNumber(String number) {
		expression.setText(expression.getText() + number );
	}
	
	//clear function
	public void clearExp() {
		expression.setText("");
	}
	
	public void deleteLast() {
		if(!getExpression().getText().isEmpty()) {
			StringBuilder text = new StringBuilder(getExpression().getText());
			if(getExpression().getText().charAt(getExpression().getText().length()-1)==' ')
					text.deleteCharAt(text.length()-2);
			else
				text.deleteCharAt(text.length()-1);
			getExpression().setText(text.toString());
		}
	}
	
	//attach the previous result to the expression
	public void ans(String answer) {
		 expression.setText(expression.getText() + answer);
	}
	
	public Label getExpression() {
		return expression;
	}
	
	public void setResult(String newResult) {
		this.result.setText("= " + newResult);		
	}
	
	public Label getResult() {
		return result;
	}
	
	public void onKeyPressed (KeyEvent keyEvent){
		String key = keyEvent.getText();
		KeyCode CODE = keyEvent.getCode();
		System.out.println(CODE);
		String keyCode = CODE.toString();
		
		switch(keyCode) {
		case "NUMPAD1":
		case "NUMPAD2":
		case "NUMPAD3":
		case "NUMPAD4":
		case "NUMPAD5":
		case "NUMPAD6":
		case "NUMPAD7":
		case "NUMPAD8":
		case "NUMPAD9":
		case "NUMPAD0":
		case "DIGIT1":
		case "DIGIT2":
		case "DIGIT3":
		case "DIGIT4":
		case "DIGIT5":
		case "DIGIT6":
		case "DIGIT7":
		case "DIGIT8":
		case "DIGIT9":
		case "DIGIT0":
			insertNumber(key);
			break;
		case "DIVIDE":
		case "MULTIPLY":
		case "SUBSTRACT":
		case "ADD":
			insertOperator(key);
			break;	
		case "ENTER":
			int result = EvaluateString.evaluate(this.getExpression().getText());
			setResult(String.valueOf(result));
			break;
		case "DELETE":
			clearExp();
			break;
		case "BACK_SPACE":
			deleteLast();
			break;
		}
	}
	
	public void onMouseClick(MouseEvent mouseEvent) {
		Button button = (Button) mouseEvent.getSource();
		String buttonText = button.getText();
		
		switch(buttonText) {
		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "7":
		case "8":
		case "9":
		case "0":
			insertNumber(buttonText);
			break;
		case "/":
		case "*":
		case "-":
		case "+":
			insertOperator(buttonText);
			break;	
		case "CLEAR":
			clearExp();
			break;
		case "=":
			int result = EvaluateString.evaluate(this.getExpression().getText());
			setResult(String.valueOf(result));
			break;
		case "ANS":
			ans(getResult().getText().substring(2));
			break;
		case "CANC":
			deleteLast();
			break;
			}
	}
}
