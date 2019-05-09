import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CountriesTextFile {

	public static List<Country> readFile(String fileName) {
		List<Country> list = new ArrayList<>();
		
		Path filePath = Paths.get(fileName);
		File f = filePath.toFile();
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(f));
			String line = br.readLine();
			
			while(line != null) {
				String[] arr = line.split(",");
				Country country = new Country(arr[0], Integer.parseInt(arr[1]));
				list.add(country);
				line = br.readLine();
				//System.out.println(list);
				
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.print("Oops, file not found. Try adding some countries first!");
		} catch(IOException e) {
			System.out.println("Really, really bad error occurred. Contact help.");
		}
		
		return list;
		
	}
	
	public static void writeFile(List<Country> list) {
		String fileName = "countries.txt";
		Path path = Paths.get(fileName);
		File file = path.toFile();
		
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));
			
			for(int i = 0; i < list.size(); i++) {
				pw.println(list.get(i));
			}
			
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("File can't write, find help!");
		} 
		
	}
	
	public static void createFile(String fileName) {
		Path path = Paths.get(fileName);
		
		if(Files.notExists(path)) {
			try {
				Files.createFile(path);
				System.out.println("File is created and is all set!\n");
				
			} catch (IOException e) {
				System.out.println("Something went wrong! Folder not created.\n");
			}
			
		} else {
			System.out.println("There's already a file named that here!\n");
		}
	}
	
}
