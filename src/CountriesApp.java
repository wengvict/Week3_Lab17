import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to the Countries Maintenance Application!");
		showMenu(scan);

	}

	public static void showMenu(Scanner sc) {
		int menuSelect = 0;

		do {
			System.out.println("1 - See the list of countries\n2 - Add a country\n3 - Exit\n");
			System.out.print("Enter menu number: ");
			
			menuSelect = Validator.getMenuInt(sc, 1, 3);
			sc.nextLine();

			switch (menuSelect) {
			case 1:
				printCountryList("countries.txt");
				break;
			case 2:
				List<Country> list = createList(sc);
				CountriesTextFile.writeFile(list);
				break;
			case 3:
			default:
				System.out.println("Buh-bye!");
				break;

			}
		} while (menuSelect >= 1 && menuSelect < 3);
	}

	public static void printCountryList(String fileName) {
		List<Country> list = CountriesTextFile.readFile(fileName);
		System.out.print("\n");

		for (Country c : list) {
			//String formatPop = c.getPopulation()
			System.out.println(c.getName() + " (pop " + c.getPopulation() + ")");
		}
		System.out.print("\n");
	}

	public static List<Country> createList(Scanner sc) {
		List<Country> list = new ArrayList<>();
		String countryName = "";
		int population = 0;
		
		
		System.out.print("\nEnter country: ");
		countryName = sc.nextLine();

		System.out.print("Enter population: ");
		population = sc.nextInt();

		System.out.println("This country has been saved!\n");

		list.add(new Country(countryName, population));

		return list;
	}

}
