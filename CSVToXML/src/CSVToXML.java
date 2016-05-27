import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Element;

public class CSVToXML {

	public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException {
		ArrayList<String> policyStr = new ArrayList<>();
		FileInputStream is = new FileInputStream("sampleData.txt");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(is);
		sc.nextLine();
		while(sc.hasNext()){
			policyStr.add(sc.nextLine());
		}
		Element doc = DocumentParser.parseRows(policyStr, ",");
		PrintXMLDocument.printElement(doc);
	}

}
