import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;

public class ImprovedWordCounter {

	public static void main(String[] args) {
		ArrayList<String> listOfStrings = new ArrayList<String>();
		HashMap<String, Integer> mapa = new HashMap<String, Integer>();
		BufferedReader br;

		try {
			br = new BufferedReader(
					new FileReader(
							"C:\\Users\\Darko\\Desktop\\Eclipse Projects\\WordCounter\\src\\wordCount.txt"));

			String line = null;
			try {
				while ((line = br.readLine()) != null) {
					String[] parts = line.split(" ");
					for (int i = 0; i < parts.length; i++) {
						listOfStrings.add(StringUtils.capitalize(parts[i]));
					}
				}

				for (String zbor : listOfStrings) {
					if (mapa.containsKey(zbor)) {
						mapa.put(zbor,
								mapa.get(zbor) + 1);
					} else {
						mapa.put(zbor, 1);
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(mapa);

	}

}