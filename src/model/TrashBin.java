package model;

public class TrashBin {
	
	
	
	
	//	GUI.infoArea.appendText("Did you say: " + speech + "?");
	
	// textToSpeech.speak("Did you say" + speech + "?", 1.5f, false, true);

	// READING GRAMMA TO LIST
//	fr = new FileReader(file);
//	br = new BufferedReader(fr);
//	try (BufferedReader reader = br) {
//		String line = reader.readLine();
//		while (line != null) {
//			result.add(line);
//			line = reader.readLine();
//		}
//	} catch (IOException exc) {
//
//	}
	
	

//	for (String curVal : result) {
//	if (curVal.contains(array[0])) {
//		Pattern pattern = Pattern.compile("<\\w+");
//		matcher = pattern.matcher(curVal);
//	}
//}
//
//if (matcher.find())
//	tempRule = matcher.group();
//
//System.out.println(tempRule);
//
//for (int i = 0; i < ruleList.length; i++) {
//	if (tempRule.equals(ruleList[i])) {
//		rule = ruleList[i];
//	}
//}
//
//if ("default".equals(rule)) {
//	String tempRule2 = null;
//
//	for (String curVal : result) {
//		if (curVal.contains(tempRule + ">")) {
//			Pattern pattern = Pattern.compile("<\\w+");
//			matcher = pattern.matcher(curVal);
//		}
//	}
//
//	if (matcher.find())
//		tempRule2 = matcher.group();
//
//	System.out.println(tempRule2);
//
//	for (int i = 0; i < ruleList.length; i++) {
//		if (tempRule2.equals(ruleList[i])) {
//			rule = ruleList[i];
//		}
//	}
//}
	
	
	/**
	 * Takes a decision based on the given result
	 */
	// public void makeDecision(String speech) {
	//
	// if ("fuck you mary".equalsIgnoreCase(speech)){
	// textToSpeech.speak("You too motherfucker", 1.5f, false, true);
	// return;
	// }else if ("how are you".equalsIgnoreCase(speech)){
	// textToSpeech.speak("Good thank you", 1.5f, false, true);
	// return;
	// }
	//
	// // Split the sentence
	// String[] array = speech.split(" ");
	//
	// // return if user said only one number
	// if (array.length != 3)
	// return;
	//
	// // Find the two numbers
	// int number1 = stringToNumber.convert(array[0]);
	// int number2 = stringToNumber.convert(array[2]);
	//
	// // Calculation result in int representation
	// int calculationResult = 0;
	// String symbol = "?";
	//
	// // Find the mathematical symbol
	// if ("plus".equals(array[1])) {
	// calculationResult = number1 + number2;
	// symbol = "+";
	// } else if ("minus".equals(array[1])) {
	// calculationResult = number1 - number2;
	// symbol = "-";
	// } else if ("multiply".equals(array[1])) {
	// calculationResult = number1 * number2;
	// symbol = "*";
	// } else if ("division".equals(array[1])) {
	// calculationResult = number1 / number2;
	// symbol = "/";
	// }
	//
	// String res = numberToString.convert(Math.abs(calculationResult));
	//
	// // With words
	// System.out.println("Said:[ " + speech + " ]\n\t\t which after calculation
	// is:[ "
	// + (calculationResult >= 0 ? "" : "minus ") + res + " ] \n");
	//
	// // With numbers and math
	// System.out.println("Said:[ " + number1 + " " + symbol + " " + number2 +
	// "]\n\t\t which after calculation is:[ "
	// + calculationResult + " ]");
	//
	// // Speak Mary Speak
	// textToSpeech.speak((calculationResult >= 0 ? "" : "minus ") + res, 1.5f,
	// false, true);
	//
	// }
	
//	package model;
//
//	import java.io.IOException;
//	import java.util.logging.Level;
//	import java.util.logging.Logger;
//
//	import javafx.fxml.FXML;
//	import javafx.fxml.FXMLLoader;
//	import javafx.scene.control.Button;
//	import javafx.scene.control.Label;
//	import javafx.scene.control.TextArea;
//	import javafx.scene.layout.BorderPane;
//
//	/**
//	 * The main interface of the application
//	 * 
//	 * @author GOXR3PLUS
//	 *
//	 */
//	public class MainInterfaceController extends BorderPane {
//
//		// Thread used to communicate between logic and GUI
//		Thread commThread;
//
//		String Ace;
//		String You;
//
//		@FXML
//		private Button start;
//
//		@FXML
//		private Button stop;
//
//		@FXML
//		private Button restart;
//
//		@FXML
//		private Label statusLabel;
//
//		@FXML
//		public TextArea infoArea;
//
//		// -----------------------------------------
//
//		private General speechCalculator = new General();
//
//		/**
//		 * Constructor
//		 */
//		public MainInterfaceController() {
//
//			// FXMLLoader
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainInterfaceController.fxml"));
//			loader.setController(this);
//			loader.setRoot(this);
//
//			try {
//				loader.load();
//			} catch (IOException ex) {
//				Logger.getLogger(getClass().getName()).log(Level.SEVERE, " FXML can't be loaded!", ex);
//			}
//
//		}
//
//		protected void startCommThread() {
//
//			// alive?
//			if (commThread != null && commThread.isAlive())
//				return;
//
//			commThread = new Thread(() -> {
//				try {
//
//					// Detect if the microphone is available
//					while (true) {
//
//						Communication comm = Communication.getInstance();
//
//						Ace = comm.getAce();
//						You = comm.getYou();
//
//						if (comm.getYappear()) {
//							infoArea.appendText("You: " + comm.getYou() + "\n");
//							comm.setYappear(false);
//						}
//
//						if (comm.getAppear()) {
//							infoArea.appendText("Ace: " + Ace + "\n");
//							comm.setAppear(false);
//						}
//
//						Thread.sleep(10);
//					}
//
//				} catch (InterruptedException ex) {
//
//					commThread.interrupt();
//				}
//			});
//
//			// Start
//			commThread.start();
//		}
//
//		/**
//		 * As soon as fxml has been loaded then this method will be called
//		 * 1)-constructor,2)-FXMLLOADER,3)-initialize();
//		 */
//		@FXML
//		private void initialize() {
//
//			// start
//			start.setOnAction(a -> {
//				statusLabel.setText("Status : [Running]");
//				infoArea.appendText("Starting Speech Recognizer\n");
//				speechCalculator.startSpeechThread();
//			});
//
//			// stop
//			stop.setOnAction(a -> {
//				statusLabel.setText("Status : [Stopped]");
//				infoArea.appendText("Stopping Speech Recognizer\n");
//				speechCalculator.stopSpeechThread();
//			});
//
//			// restart
//			restart.setDisable(true);
//
//			startCommThread();
//
//		}
//	}

	
//	<?xml version="1.0" encoding="UTF-8"?>
//
//	<?import javafx.geometry.Insets?>
//	<?import javafx.scene.Cursor?>
//	<?import javafx.scene.control.Button?>
//	<?import javafx.scene.control.Label?>
//	<?import javafx.scene.control.TextArea?>
//	<?import javafx.scene.layout.BorderPane?>
//	<?import javafx.scene.layout.HBox?>
//
//
//	<fx:root prefHeight="293.0" prefWidth="418.0" style="-fx-background-color: black;" type="BorderPane" xmlns:fx="http://javafx.com/fxml/1" xmlns="http://javafx.com/javafx/8.0.111">
//	   <center>
//	      <HBox alignment="CENTER" prefHeight="100.0" prefWidth="200.0" spacing="10.0" BorderPane.alignment="CENTER">
//	         <children>
//	            <Button fx:id="start" mnemonicParsing="false" text="Start">
//	               <cursor>
//	                  <Cursor fx:constant="HAND" />
//	               </cursor>
//	            </Button>
//	            <Button fx:id="stop" mnemonicParsing="false" text="Stop">
//	               <cursor>
//	                  <Cursor fx:constant="HAND" />
//	               </cursor>
//	            </Button>
//	            <Button fx:id="restart" mnemonicParsing="false" text="Restart">
//	               <cursor>
//	                  <Cursor fx:constant="HAND" />
//	               </cursor>
//	            </Button>
//	         </children>
//	      </HBox>
//	   </center>
//	   <top>
//	      <Label fx:id="statusLabel" alignment="CENTER" maxWidth="1.7976931348623157E308" style="-fx-font-weight: bold; -fx-font-size: 17; -fx-text-fill: white;" text="Status : [ Stopped ]" BorderPane.alignment="CENTER" />
//	   </top>
//	   <bottom>
//	      <TextArea fx:id="infoArea" editable="false" prefHeight="200.0" prefWidth="200.0" promptText="..information area" BorderPane.alignment="CENTER">
//	         <BorderPane.margin>
//	            <Insets bottom="5.0" left="5.0" right="5.0" top="5.0" />
//	         </BorderPane.margin>
//	      </TextArea>
//	   </bottom>
//	   <padding>
//	      <Insets bottom="5.0" left="5.0" right="5.0" top="5.0" />
//	   </padding>
//	</fx:root>

	
	
	
}
