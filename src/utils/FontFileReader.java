package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FontFileReader {
	
	private File fontFile;
	
	private Map<Integer, Char> charDetailMap = new HashMap<Integer, Char>();
	private Map<String, String> valueMap = new HashMap<String, String>();
	public List<String> lines = new ArrayList<String>();
	
	public FontFileReader(File fontFile) {
		this.fontFile = fontFile;
	}
	
	private void readFile(){
		try {
			BufferedReader br = new BufferedReader(new FileReader(fontFile));
			
			while(br.readLine() != null){
				processLine(br.readLine());
			}
			
			
		} catch (FileNotFoundException e) {
			System.err.println("Exception: Failed to read fontFile in");
		} catch (IOException e) {
			System.err.println("Execption: " + e.getMessage());
		}
	}
	
	private void parseCharDetails(Map<String, String> valueMap){
		Char newChar = new Char();
		newChar.setId(Integer.parseInt(valueMap.get("id")));
		newChar.setX((float) Integer.parseInt(valueMap.get("x")));
		newChar.setY((float) Integer.parseInt(valueMap.get("y")));
		newChar.setWidth((float) Integer.parseInt(valueMap.get("width")));
		newChar.setHeight((float) Integer.parseInt(valueMap.get("height")));
		charDetailMap.put(newChar.getId(), newChar);
	}
	
	private Char getCharValues(int asciiValue){
		Char getChar = charDetailMap.get(asciiValue);
		return charDetailMap.get(asciiValue);
	}
    
	private boolean processLine(String line){
		valueMap.clear();
		if(line == null) 
			return false;
		
		if(line.contains("char ")){
			for(String value : line.split(" ")){
				String[] keyValue = value.split("=");
				if(keyValue.length == 2){
					valueMap.put(keyValue[0], keyValue[1]);
				}
			}
			System.out.println(valueMap);
			parseCharDetails(valueMap);
		}
		
		return true;
	}
	
    public static void main(String[] args){
    	FontFileReader fileReader = new FontFileReader(new File("fonts/arial.fnt"));
    	fileReader.readFile();
    }

}
