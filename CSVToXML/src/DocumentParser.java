import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class DocumentParser {
	public static Element parseRows(ArrayList<String> rows, String delimter)
			throws ParserConfigurationException, TransformerException {
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document doc = builder.newDocument();
		Node root = doc.createElement(XMLTags.POLICIES.getName());
		for (int i = 0; i < rows.size(); i++) {
			String policy = rows.get(i);
			String[] fields = policy.split(delimter);
			if (fields != null && fields.length == 5) {
				root.appendChild(createPolicyElement(fields, doc, i));
			} else {
				System.out.println("Error: No policies found!");
			}
		}
		return (Element) root;
	}

	private static Node createPolicyElement(String[] fields, Document doc, int rowIndex) throws TransformerException {
		Element policyNode = doc.createElement(XMLTags.POLICY.getName());
		if (fields != null && fields.length == 5) {
			policyNode.appendChild(getValidatedField(XMLTags.INSURED_NAME, fields[0], rowIndex, doc));
			policyNode.appendChild(getValidatedField(XMLTags.PHONE_NUMBER, fields[1], rowIndex, doc));
			policyNode.appendChild(getValidatedField(XMLTags.ZIP, fields[2], rowIndex, doc));
			policyNode.appendChild(getValidatedField(XMLTags.CITY, fields[3], rowIndex, doc));
			policyNode.appendChild(getValidatedField(XMLTags.INSURANCE_DATE, fields[4], rowIndex, doc));
		} else {
			policyNode.setAttribute("type", "Error");
			policyNode.setAttribute("line", Integer.toString(rowIndex));
		}

		// PrintXMLDocument.printElement((Element)policyNode);
		return policyNode;
	}

	private static Node getValidatedField(XMLTags type, String value, int rowIndex, Document doc) {
		Element elem = doc.createElement(type.getName());
		boolean isValid = false;
		switch (type) {
		case INSURED_NAME:
			isValid = Pattern.matches("[a-zA-Z]+", value);
			break;
		case CITY:
			isValid = Pattern.matches("^[\\w\\s_@./#&+-]*", value);
			break;
		case INSURANCE_DATE:
			isValid = Pattern.matches("\\d{2}\\/\\d{2}\\/\\d{4}", value);
			break;
		case PHONE_NUMBER:
			isValid = Pattern.matches("^\\(\\d{3}\\)\\s\\d{3}-\\d{4}", value);
			break;
		case ZIP:
			isValid = Pattern.matches("\\d{5}", value);
			break;
		default:
			break;
		}
		if (!isValid) {
			elem.setAttribute("type", "Error");
			elem.setAttribute("line", Integer.toString(rowIndex));
			elem.setTextContent(" ");
		} else {
			elem.setTextContent(value);
		}
		//System.out.println(type.getName()+"="+value+"; valid="+isValid);
		return elem;
	}
}
