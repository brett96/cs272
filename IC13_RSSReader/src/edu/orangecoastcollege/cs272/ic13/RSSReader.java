package edu.orangecoastcollege.cs272.ic13;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * The <code>RSSReader</code> class represents an entity that is able to read Really Simple Syndicate (RSS) feeds
 * as XML data and parse them to gather specific information, such as version, title and item count.
 * 
 * It allows XML data to come from the following sources:
 * a) A byte stream, e.g. <rss> ... </rss>
 * b) A URI, e.g. https://cyber.harvard.edu/rss/examples/rss2sample.xml
 * c) A file, e.g. rss2sample.xml
 *  
 * @author 
 * @version 1.0
 */
public class RSSReader {
	private Document doc;
	private XPath path;

	/**
	 * <code>RSSReader</code> constructor initializes a Really Simple Syndicate (RSS) feed to a
	 * source specified as either: 
	 * a) A byte stream, e.g. <rss> ... </rss>
	 * b) A URI, e.g. https://cyber.harvard.edu/rss/examples/rss2sample.xml
	 * c) A file, e.g. rss2sample.xml
	 * 
	 * @param source The source of RSS data, either as byte stream, URI or file name.
	 * @throws ParserConfigurationException If document cannot be created from the byte stream.
	 * @throws SAXException If there is an error parsing the RSS source.
	 * @throws IOException If there is an error opening the XML file.
	 */
	public RSSReader(String source) throws ParserConfigurationException, SAXException, IOException  {

		// Suto import = ctrl + shift + o
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbFactory.newDocumentBuilder();
		// To connect to an XML source (3 ways):
		if(source.contains("://"))
		{
			// URL
			doc = builder.parse(source);
		}
		else if(source.startsWith("<"))
		{
			// Stream (e.g. String)
			doc = builder.parse(new ByteArrayInputStream(source.getBytes()));
		}
		else
		{
			//File
			doc = builder.parse(new File(source));
		}
		
		// To make a path, we use XPathFactory
		XPathFactory xpFactory = XPathFactory.newInstance();
		path = xpFactory.newXPath();
	}

	/**
	 * Counts the items (elements with <item> tag) in the XML document.
	 * 
	 * @return The number of items in the document.
	 * @throws XPathExpressionException If there is an error traversing the XPath through the document.
	 */
	public int countItems() throws XPathExpressionException {
		// Use the doc and path to count all items
		// All results from XML come back as strings
		String result = path.evaluate("count(rss/channel/item)", doc);
		return Integer.parseInt(result);
	}

	/**
	 * Gets the version attribute (e.g. version="2.0") from the XML document.
	 * 
	 * @return The version attribute.
	 * @throws XPathExpressionException If there is an error traversing the XPath through the document.
	 */
	public String getVersion() throws XPathExpressionException {
		// Attributes need @ symbol in front of name
		String result = path.evaluate("rss/@version", doc);
		return result;
	}
	
	public String getDescription() throws XPathExpressionException
	{
		String result = path.evaluate("rss/channel/item/description", doc);
		return result;
	}

	/**
	 * Gets the title element associated with a specific <item>.  Remember, elements in XML are 1 based,
	 * rather than 0 based (like arrays), so item[1] is the first item in the XML document.
	 * 
	 * @param itemNumber The item number for which to find the title.
	 * @return The title of the specified item
	 * @throws XPathExpressionException If there is an error traversing the XPath through the document.
	 */
	public String getItemTitle(int itemNumber) throws XPathExpressionException {
		// All results come back as strings
		String result = path.evaluate("rss/channel/item[" + itemNumber + "]/title", doc);
		return result;
	}

	/**
	 * Starts RSS Reader
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			//RSSReader reader = new RSSReader("https://cyber.harvard.edu/rss/examples/rss2sample.xml");
			// Can create reader directly from a file too:
			RSSReader reader = new RSSReader("rss2sample.xml");
			
			int count = reader.countItems();
			System.out.println("~~~~~~~~~~RSS Reader Data~~~~~~~~~~");			
			System.out.println("RSS Version : " + reader.getVersion());			
			System.out.println("Total Items : " + reader.countItems());
			//Loop through all item titles:
			for(int i = 1; i <= count; i++)
			{
				System.out.println("Item " + i + " Title: " + reader.getItemTitle(i));
				System.out.println("Item " + i + " Description: " + reader.getDescription());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
