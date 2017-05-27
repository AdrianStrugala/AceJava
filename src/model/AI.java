package model;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import tts.TextToSpeech;
import libraries.JSGFGrammarParser;


public class AI {

	//Communication comm = new Communication();
	EnglishStringToNumber stringToNumber = new EnglishStringToNumber();
	EnglishNumberToString numberToString = new EnglishNumberToString();
	TextToSpeech Ace = new TextToSpeech();
	private String rule = null;
	private String attribute = null;
	private String array[] = null;
	private String speech = null;


	// array of avalible rules
	String ruleList[] = { "greet", "runProgram", "operation", "exit" };
	

	// constructor
	public AI(TextToSpeech textToSpeech) {
		super();
		this.Ace = textToSpeech;
	}

	/**
	 * Takes a decision based on the given result
	 * 
	 */

	public String logic(String speech) throws FileNotFoundException {

		
		// default rule
		rule = "default";

		// Split the sentence
		array = speech.split(" ");

		this.speech = speech;
		
	System.out.println(speech.indexOf(" plus "));
		
		//System.out.println("Did you say: " + speech + "?");

		Communication comm = Communication.getInstance();
		comm.setYou(speech);
		comm.setYappear(true);
		
		// HERE IS THE PART WHERE I
		// PARSE TEXT TO GRAMMA RULE
		// checks first word of sentencce and if it is present in any rule from
		// ruleList

		// finds only 2 level dependencies (like number and operation)
		// final rules keep at the beginning of gramma file
		List<String> results = JSGFGrammarParser.getRulesContainingWords(new File("resources\\grammars\\grammar.gram"),
				Arrays.asList(array[0]), true);

		for (int i = 0; i < ruleList.length; i++) {
			if (results.get(0).equals(ruleList[i])) {
				rule = ruleList[i];
			}
		}
		
		System.out.println("Try1: " + rule);
		
		// 2nd search
		if ("default".equals(rule)) {
			List<String> results2 = JSGFGrammarParser
					.getRulesContainingWords(new File("resources\\grammars\\grammar.gram"), results, true);
			if (!results2.isEmpty())
			rule = results2.get(0);
		}

		System.out.println("Try2: " + rule);

		// STARTS ACTION BASED ON RULE
		action(rule);

		return rule;

	}

	@SuppressWarnings("static-access")
	public void action(String rule) {

		switch (rule) {

		// STARTING PROGRAM
		case "runProgram":

			attribute = array[1];
			if ("calculator".equals(array[1]))
				attribute = "calc";
			
			speak("Opening " + attribute);
			
			Runtime runTime = Runtime.getRuntime();
			try {
				runTime.exec(attribute);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		// YO
		case "greet":
			speak("Hello. My name is Ace.");

			break;

		// MATH OPERATION
		case "operation":
			//Ace.speak("Math. Fuck it.", 1.5f, false, true);
			Nums nums = new Nums();
			
			
			
			speak(Integer.toString(nums.calc(speech)));
			break;

		// BYE
		case "exit":
			speak("Bye. See you.");
			// HERE WOULD BE SOME EXIT
			System.exit(0);
			break;

		case "default":
		//	Ace.speak("Sorry, I don't understand you.", 1.5f, false, true);
			speak("Sorry, I don't understand you.");
			break;
		}

	}
	
	public void speak(String msg){
		
		
		
		Communication comm = Communication.getInstance();
		
		Ace.speak(msg, 1.5f, false, true);
		
		comm.setAce(msg);
		comm.setAppear(true);
		
		
	}
	
	
	

}
