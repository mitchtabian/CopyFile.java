import java.io.*;
import java.io.BufferedWriter;

public class CopyFile{
	public static void main(String[] args) throws IOException{
		BufferedReader input = null;
		String inputFile = args[0];
		StringBuilder copiedText = new StringBuilder();
		String originalText;
		String lineSeparator  = System.getProperty("line.separator");
		
		try{
			input = new BufferedReader(new FileReader(inputFile));
			while((originalText = input.readLine()) != null){
				copiedText.append(originalText + lineSeparator);
			}
		}catch(IOException e){
			System.out.println(e.toString());
		}
		BufferedWriter writer = null;
		try{
			String copyName = "Copy" + inputFile;
			System.out.println("The new file is named: " + copyName);
			File copiedFile = new File(copyName);
			copiedFile.createNewFile();
			writer = new BufferedWriter(new FileWriter(copiedFile));
			writer.write(copiedText.toString());
		}catch(IOException e){
			System.out.println(e.toString());
		}
		finally{
			if(writer != null){
				writer.close();
			}
		}
	}
}