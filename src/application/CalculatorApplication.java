package application;
 


import calculator.Model;
import calculator.Operation;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

 
public class CalculatorApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

	private Button btn;
	private Button btn1;
	private Button btn2;
	private Button btn3;
	private Button btn4;
	private Button btn5;
	private Button btn6;
	private Button btn7;
	private Button btn8;
	private Button btn9;
	private Button btnEnter;
	private Button btnCHS;
	private Button btnCLX;
	private Button btnCSTK;
	private Button btnPlus;
	private Button btnMinus;
	private Button btnDiv;
	private Button btnMul;
	private boolean StackShowed = true;
	private VBox StackBox;
	private GridPane grid;
	private HBox displayBox;
	private MenuBar menuBar;
	private Text displayText;
	private Text textStack1;
	private Text textStack2;
	private Text textStack3;
	private Model calcModel;
	private boolean clearButton;
	private int ButtonValue;
	private int buttonEntry;
	private boolean pushEntry;
    
	

    @Override
    public void start(Stage primaryStage) {
    	//Create instance of the model of the calculator
    	calcModel = new Model();

        //Create the file and show menu on top of the screen.
		createMenu();
		
		//Create the display where result from calculations is shown
		createDisplay();

        //Create display where the stack is shown
        createStackDisplay();

        //Create buttons
        createButtons();
        
        //Add buttons to a GridPane
        addButtons();
        
        //Root is the stage to where we add the features of the calculator
        BorderPane root = new BorderPane();
        
        //add the button grid to the bottom of the stage
        root.setBottom(grid);
       
        //Add top menus and the screen to a Vbox so that they stack nicely.
        VBox topOfScreen = new VBox();
        topOfScreen.getChildren().addAll(menuBar,displayBox);
        root.setTop(topOfScreen);
        
        //Add the StackPane to the center of stage
        root.setCenter(StackBox);
        
        //Finally create the stage, with its children
        primaryStage.setTitle("Calculator!");
        primaryStage.setScene(new Scene(root, 320, 490));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    private void createMenu(){
    	//Quit the program
		final Menu menuFile = new Menu("File");
        final MenuItem menuFileItem = new MenuItem("Exit");
		menuFileItem.setOnAction(e -> Platform.exit());
		menuFile.getItems().addAll(menuFileItem);
		
		//Show the stack or not
		final Menu ShowStackMenu = new Menu("View");
		final MenuItem ShowStack = new MenuItem("Show Stack");
		ShowStack.setOnAction(e -> ShowStack());
		ShowStackMenu.getItems().add(ShowStack);
		
		//Add the the menu items to menus
		menuBar = new MenuBar();
		menuBar.getMenus().addAll(menuFile,ShowStackMenu);
    	
    }
    
    private void createDisplay(){
        //Display
        displayText = new Text("0.0");
        displayText.setFill(Color.BLACK);
        displayText.setStyle("-fx-font: 50 arial;");
        displayBox = new HBox();
        displayBox.getChildren().add(displayText);
        displayBox.setPrefHeight(50);
        displayBox.setStyle("-fx-padding: 10;" + 
                "-fx-border-style: solid inside;" + 
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" + 
                "-fx-border-radius: 5;" + 
                "-fx-border-color: Black;");
        displayBox.setAlignment(Pos.CENTER_RIGHT);
    	
    }
    
    private void createStackDisplay(){
        //Create Vbox that we add the stack onto
        StackBox = new VBox();

        //Display of the stack
        textStack1 = new Text("0.0");
        textStack1.setFill(Color.BLACK);
        textStack1.setStyle("-fx-font: 50 arial;");
        
        textStack2 = new Text("0.0");
        textStack2.setFill(Color.BLACK);
        textStack2.setStyle("-fx-font: 50 arial;");
        
        textStack3 = new Text("0.0");
        textStack3.setFill(Color.BLACK);
        textStack3.setStyle("-fx-font: 50 arial;");

        //Add the stackdisplay to the stackbox so that they stack nicely
        StackBox.getChildren().addAll(textStack1,textStack2,textStack3);
        StackBox.setPrefHeight(50);
        StackBox.setStyle("-fx-padding: 10;" + 
                "-fx-border-style: solid inside;" + 
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" + 
                "-fx-border-radius: 5;" + 
                "-fx-border-color: Black;");
        StackBox.setAlignment(Pos.BOTTOM_RIGHT);
    	
    }
    
    private void addButtons() {
    	//Create grid pane to add buttons
        grid = new GridPane();
        grid.setHgap(0);
        grid.setVgap(0);
        grid.add(btnEnter, 0, 0);
        grid.add(btnCHS, 1, 0);
        grid.add(btnCLX, 2, 0);
        grid.add(btnCSTK, 3, 0);
        grid.add(btnPlus, 0, 1);
        grid.add(btn7, 1, 1);
        grid.add(btn8, 2, 1);
        grid.add(btn9, 3, 1);
        grid.add(btnMinus, 0, 2);
        grid.add(btn4, 1, 2);
        grid.add(btn5, 2, 2);
        grid.add(btn6, 3, 2);
        grid.add(btnMul, 0, 3);
        grid.add(btn1, 1, 3);
        grid.add(btn2, 2, 3);
        grid.add(btn3, 3, 3);
        grid.add(btnDiv, 0, 4);
        grid.add(btn, 1, 4);

		
	}

	private void createButtons() {
    	final double width = 80.0;
    	
    	btn = new Button("0");
    	btn.setMinWidth(width);
    	btn.setPrefWidth(width);
    	btn.setMaxWidth(width);
		btn.setOnAction(e -> setButtonValue(0));
    	
		btn1 = new Button("1");
    	btn1.setMinWidth(width);
    	btn1.setPrefWidth(width);
    	btn1.setMaxWidth(width);
		btn1.setOnAction(e -> setButtonValue(1));
		
		btn2 = new Button("2");
    	btn2.setMinWidth(width);
    	btn2.setPrefWidth(width);
    	btn2.setMaxWidth(width);
		btn2.setOnAction(e -> setButtonValue(2));
		
		btn3 = new Button("3");
    	btn3.setMinWidth(width);
    	btn3.setPrefWidth(width);
    	btn3.setMaxWidth(width);
		btn3.setOnAction(e -> setButtonValue(3));
		
		btn4 = new Button("4");
    	btn4.setMinWidth(width);
    	btn4.setPrefWidth(width);
    	btn4.setMaxWidth(width);
		btn4.setOnAction(e -> setButtonValue(4));
		
		btn5 = new Button("5");
    	btn5.setMinWidth(width);
    	btn5.setPrefWidth(width);
    	btn5.setMaxWidth(width);
		btn5.setOnAction(e -> setButtonValue(5));
		
		btn6 = new Button("6");
    	btn6.setMinWidth(width);
    	btn6.setPrefWidth(width);
    	btn6.setMaxWidth(width);
		btn6.setOnAction(e -> setButtonValue(6));
		
		btn7 = new Button("7");
    	btn7.setMinWidth(width);
    	btn7.setPrefWidth(width);
    	btn7.setMaxWidth(width);
		btn7.setOnAction(e -> setButtonValue(7));
		
		btn8 = new Button("8");
    	btn8.setMinWidth(width);
    	btn8.setPrefWidth(width);
    	btn8.setMaxWidth(width);
		btn8.setOnAction(e -> setButtonValue(8));
		
		btn9 = new Button("9");
    	btn9.setMinWidth(width);
    	btn9.setPrefWidth(width);
    	btn9.setMaxWidth(width);
		btn9.setOnAction(e -> setButtonValue(9));
		
		btnEnter = new Button("Enter");
    	btnEnter.setMinWidth(width);
    	btnEnter.setPrefWidth(width);
    	btnEnter.setMaxWidth(width);
		btnEnter.setOnAction(e -> updateScreen(Operation.ENTER));
		
		btnCHS = new Button("CHS");
    	btnCHS.setMinWidth(width);
    	btnCHS.setPrefWidth(width);
    	btnCHS.setMaxWidth(width);
		btnCHS.setOnAction(e -> updateScreen(Operation.CHS));
		
		btnCLX = new Button("CLX");
    	btnCLX.setMinWidth(width);
    	btnCLX.setPrefWidth(width);
    	btnCLX.setMaxWidth(width);
		btnCLX.setOnAction(e -> updateScreen(Operation.CLEAR));
		
		btnCSTK = new Button("CSTK");
    	btnCSTK.setMinWidth(width);
    	btnCSTK.setPrefWidth(width);
    	btnCSTK.setMaxWidth(width);
		btnCSTK.setOnAction(e -> updateScreen(Operation.CLEARSTACK));
		
		btnPlus = new Button("+");
    	btnPlus.setMinWidth(width);
    	btnPlus.setPrefWidth(width);
    	btnPlus.setMaxWidth(width);
		btnPlus.setOnAction(e -> updateScreen(Operation.PLUS));
		
		btnMinus = new Button("-");
    	btnMinus.setMinWidth(width);
    	btnMinus.setPrefWidth(width);
    	btnMinus.setMaxWidth(width);
		btnMinus.setOnAction(e -> updateScreen(Operation.MINUS));
		
		btnDiv = new Button("/");
    	btnDiv.setMinWidth(width);
    	btnDiv.setPrefWidth(width);
    	btnDiv.setMaxWidth(width);
		btnDiv.setOnAction(e -> updateScreen(Operation.DIVIDES));
		
		btnMul = new Button("*");
    	btnMul.setMinWidth(width);
    	btnMul.setPrefWidth(width);
    	btnMul.setMaxWidth(width);
		btnMul.setOnAction(e -> updateScreen(Operation.TIMES));
		
	}

	private void ShowStack(){
		if(StackShowed == true){
			StackBox.setVisible(false);
			StackShowed = false;
		}
		else{
			StackBox.setVisible(true);
			StackShowed = true;
		}
    	System.out.println("button");
    }
	
	private void setButtonValue(int entry){
		buttonEntry = entry;
		updateScreen(Operation.BUTTON);
	}
	
	
	private int getButtonValue(){
		if(clearButton){
			ButtonValue = buttonEntry;
			clearButton = false;
		}
		else{
			int temp = Integer.valueOf(String.valueOf(ButtonValue) + String.valueOf(buttonEntry));
			//reduces overflow
			if(temp>=1e7){
				temp = 0;
				Dialogs.alert("Too large Number Entered", "", "Too large value 1e7, entry set to zero.");
			}
			ButtonValue = temp;
		}
		return ButtonValue;
	}
	
	private void updateScreen(Operation operation){
		switch(operation){
		case BUTTON:
			if(pushEntry){
				calcModel.doOperation(Operation.ENTER);
				pushEntry = false;
			}
			calcModel.setEntry(getButtonValue());
			calcModel.doOperation(Operation.BUTTON);
			break;
		case PLUS:
			calcModel.doOperation(Operation.PLUS);
			clearButton = true;
			pushEntry = true;
			break;
		case MINUS:
			calcModel.doOperation(Operation.MINUS);
			clearButton = true;
			pushEntry = true;
			break;
		case TIMES:
			calcModel.doOperation(Operation.TIMES);
			clearButton = true;
			pushEntry = true;
			break;
		case DIVIDES:
			double temp1 = calcModel.pop();
			if (calcModel.peek() == 0){
				Dialogs.alert("Can't divide by zero", "", "Division by zero error.");
			}
			calcModel.push(temp1);
			calcModel.doOperation(Operation.DIVIDES);
			clearButton = true;
			pushEntry = true;
			break;
		case ENTER:
			calcModel.doOperation(Operation.ENTER);
			clearButton = true;
			pushEntry = false;
			break;
		case CLEAR:
			calcModel.doOperation(Operation.CLEAR);
			break;
		case CHS:
			calcModel.doOperation(Operation.CHS);
			clearButton = true;
			break;
		case CLEARSTACK:
			calcModel.doOperation(Operation.CLEARSTACK);
		}
		
		
		if(calcModel.getValue()> 1e7 || calcModel.getValue() < -1e7){
			calcModel.pop();
			Dialogs.alert("Arithmetic Operation OverFlow", "", "Value went outside bound 1e7 or -1e7, entry set to zero.");
		}
		
		//updates the screen and stack
		double[] tempStack = calcModel.getWholeStack();
		displayText.setText(Double.toString(tempStack[0]));
		textStack1.setText(Double.toString(tempStack[1]));
		textStack2.setText(Double.toString(tempStack[2]));
		textStack3.setText(Double.toString(tempStack[3]));
	}
		
		
		
	
}