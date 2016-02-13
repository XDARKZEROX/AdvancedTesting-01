package shop.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Random;

import au.com.bytecode.opencsv.CSVReader;


public class CuponDataAccess{
	public int obtenerPorcentajeDescuento(String cupon) throws Exception {
		simulateDelay();
		CSVReader reader = null;
		try {
			reader = createCSVReader("cupones.txt");
			String[] nextLine;
			while ((nextLine = reader.readNext()) != null) {
				String cuponCSV = nextLine[0];
				String porcentajeCSV = nextLine[1];
				if (cuponCSV.equals(cupon)) {
					return Integer.parseInt(porcentajeCSV);
				}
			}
			throw new Exception("Cupon no encontrado");
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

	private CSVReader createCSVReader(String fileName) throws Exception {
		File file = getFile(fileName);
		InputStream input = new FileInputStream(file);
		return new CSVReader(new InputStreamReader(input), ',', '\0');
	}

	private File getFile(String fileName) throws Exception {
		URL resourceUrl = getClass().getProtectionDomain().getCodeSource()
				.getLocation();
		File file = new File(resourceUrl.toURI());
		String dirPath = file.getParentFile().getParent();
		return new File(dirPath + "/data/" + fileName);
	}

	private void simulateDelay() throws Exception {
		int min = 4000;
		int max = 8000;
		Random rand = new Random();
		int miliseconds = rand.nextInt((max - min) + 1) + min;
		Thread.sleep(miliseconds);
	}
}
