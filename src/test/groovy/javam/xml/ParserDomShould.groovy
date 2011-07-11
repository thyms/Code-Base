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
import org.w3c.dom.Attr
import org.w3c.dom.Document
import org.w3c.dom.Element

/**
 * @author Deniz KALFA
 *
 */
class ParserDomShould {
	def expectedXml = '''
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
	
	@Test
	void "create the desired expectedXml."() {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance()
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder()

		// root elements
		Document doc = docBuilder.newDocument()
		Element rootElement = doc.createElement("company")
		doc.appendChild(rootElement)

		// staff elements
		Element staff = doc.createElement("staff")
		rootElement.appendChild(staff)

		// set attribute to staff element
		Attr attributeId = doc.createAttribute("id")
		attributeId.setValue("1")
		staff.setAttributeNode(attributeId)

		// shorter way
		// staff.setAttribute("id", "1")

		// firstname element
		Element firstname = doc.createElement("firstname")
		firstname.appendChild(doc.createTextNode("Jack"))
		staff.appendChild(firstname)
		
		// lastname element
		Element lastname = doc.createElement("lastname")
		lastname.appendChild(doc.createTextNode("Jones"))
		staff.appendChild(lastname)

		// nickname element
		Element nickname = doc.createElement("nickname")
		nickname.appendChild(doc.createTextNode("JJ"))
		staff.appendChild(nickname)

		// salary element
		Element salary = doc.createElement("salary")
		salary.appendChild(doc.createTextNode("100000"))
		staff.appendChild(salary)

		TransformerFactory transformerFactory = TransformerFactory.newInstance()
		Transformer transformer = transformerFactory.newTransformer()
		DOMSource source = new DOMSource(doc);
		OutputStream outputStream = new ByteArrayOutputStream()
		StreamResult result = new StreamResult(outputStream)
		transformer.transform(source, result)

		def actualXml = outputStream.toString()

		XMLUnit.setIgnoreWhitespace(true)
		def xmlDiff = new Diff(actualXml, expectedXml)
		assert xmlDiff.identical()
	}
}
