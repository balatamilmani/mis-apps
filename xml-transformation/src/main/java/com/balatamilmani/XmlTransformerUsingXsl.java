package com.balatamilmani;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * This class transforms given XML content into HTML using XSL
 *
 */
public class XmlTransformerUsingXsl {
	public static void main(String[] args) {
		System.out.println("Starting XML Transformation!");
		XmlTransformerUsingXsl app = new XmlTransformerUsingXsl();
		app.transform();
		System.out.println("XML Transformation completed");
	}

	/**
	 * method which transform the given xml into html using xsl
	 */
	private void transform() {
		try {
			Path xmlFile = Paths.get(getClass().getClassLoader().getResource("article.xml").toURI());
			Path xslFile = Paths.get(getClass().getClassLoader().getResource("article1a.xsl").toURI());
			// this file is created in root folder i.e. xml-transformation
			// folder
			Path htmlFile = Paths.get("./output.html");

			// Create XSL Transformer passing the .xsl
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Source xslt = new StreamSource(xslFile.toFile());
			Transformer transformer = transformerFactory.newTransformer(xslt);

			// Read the Source .xml file
			Source data = new StreamSource(xmlFile.toFile());

			// Create OutputStream to send the transformed .html
			FileOutputStream outputStream = new FileOutputStream(htmlFile.toFile());
			Result result = new StreamResult(outputStream);

			// do the transformation
			transformer.transform(data, result);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
