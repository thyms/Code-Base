package javam.xml

import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.Transformer
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult

import org.custommonkey.xmlunit.Diff
import org.custommonkey.xmlunit.XMLUnit
import org.junit.Test
import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.NamedNodeMap
import org.w3c.dom.NodeList
import org.w3c.dom.Node

/**
 * @author Deniz KALFA
 *
 */
class ParserDomShouldModify {
	def originalXml = '''
		<?xml version="1.0" encoding="UTF-8" standalone="no" ?> 
		<company>
			<staff id="1">
				<firstname>Jack</firstname>
				<lastname>Jones</lastname>
				<nickname>JJ</nickname>
				<salary>100000</salary>
			</staff>
		</company>
	'''.trim()

	def expectedXml = '''
		<?xml version="1.0" encoding="UTF-8" standalone="no" ?> 
		<company>
			<staff id="2">
				<firstname>Jack</firstname>
				<lastname>Jones</lastname>
				<nickname>JJ</nickname>
				<salary>200000</salary>
				<age>35</age>
			</staff>
		</company>
	'''.trim()

	@Test
	void "original xml into expected xml."() {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance()
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder()
		InputStream inputStream = new ByteArrayInputStream(originalXml.getBytes())
		Document doc = documentBuilder.parse(inputStream)

		// Get the root element
		Node company = doc.getFirstChild()

		// Get the staff element
		Node staff = doc.getElementsByTagName("staff").item(0)

		// Update staff attribute
		NamedNodeMap attributes = staff.getAttributes()
		Node nodeAttribute = attributes.getNamedItem("id")
		nodeAttribute.setTextContent("2")

		// Append a new node to staff
		Element age = doc.createElement("age")
		age.setTextContent("35") 	// same as age.appendChild(doc.createTextNode("28"))
		staff.appendChild(age)

		NodeList list = staff.getChildNodes()
		for (Node node : list) {
			if("salary".equals(node.getNodeName())){
				node.setTextContent("200000")
			}
		}
		
		// Write the content to output stream
		TransformerFactory transformerFactory = TransformerFactory.newInstance()
		Transformer transformer = transformerFactory.newTransformer()
		DOMSource source = new DOMSource(doc)
		OutputStream outputStream = new ByteArrayOutputStream() 
		StreamResult result = new StreamResult(outputStream)
		transformer.transform(source, result)
		
		def actualXml = outputStream.toString()
		
		XMLUnit.setIgnoreWhitespace(true)
		def xmlDiff = new Diff(actualXml, expectedXml)
		assert xmlDiff.identical()
	}
}
