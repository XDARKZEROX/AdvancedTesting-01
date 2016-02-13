package shop.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import shop.domain.Revision;
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class RevisionDataAccess {

	public Revision buscar(int productId, String revisorNombre)
			throws Exception {
		simulateDelay();
		List<Revision> revisiones = obtenerTodos();

		for (Revision revision : revisiones) {
			if (revision.getProductId() == productId
					&& revision.getRevisorNombre().equals(revisorNombre)) {
				return revision;
			}
		}
		return null;
	}

	public List<Revision> obtenerTodos() throws Exception {
		List<Revision> revisiones = new ArrayList<Revision>();
		CSVReader reader = null;
		try {
			ColumnPositionMappingStrategy<Revision> strategy = new ColumnPositionMappingStrategy<Revision>();
			strategy.setType(Revision.class);
			strategy.setColumnMapping(columns);
			CsvToBean<Revision> csv = new CsvToBean<Revision>();
			revisiones = csv.parse(strategy, createCSVReader(fileName));
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		return revisiones;
	}

	public void grabar(Revision revision) throws Exception {
		simulateDelay();
		//String uniqueID = UUID.randomUUID().toString();
		int uniqueID=new Random().nextInt(100);
		revision.setId(uniqueID);

		CSVWriter writer = null;
		try {
			writer = createCSVWriter(fileName);
			writer.writeNext(new String[] { 
					String.valueOf(revision.getId()),
					String.valueOf(revision.getProductId()),
					revision.getRevisorNombre(),
					String.valueOf(revision.getCalificacion()),
					revision.getComentario() });
			writer.flush();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

	public void eliminarTodo() throws Exception {
		File file = getFile(fileName);
		PrintWriter writer = new PrintWriter(file);
		for (int i = 0; i < columns.length; i++) {
			String separator = i + 1 != columns.length ? "," : "\n";
			writer.print(columns[i] + separator);
		}
		writer.close();
	}

	String fileName = "revisiones.txt";
	String[] columns = new String[] { "id", "productId", "revisorNombre",
			"calificacion", "comentario" };

	private CSVWriter createCSVWriter(String fileName) throws Exception {
		File file = getFile(fileName);
		OutputStream output = new FileOutputStream(file, true);
		return new CSVWriter(new OutputStreamWriter(output), ',', '\0');
	}

	private CSVReader createCSVReader(String fileName) throws Exception {
		File file = getFile(fileName);
		InputStream input = new FileInputStream(file);
		return new CSVReader(new InputStreamReader(input), ',', '\0', 1);
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
