package javam.xml

import javax.xml.parsers.DocumentBuilderFactory

import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Node

import spock.lang.Specification

/**
 * @author Deniz KALFA
 *
 */
class ParserDomShouldRead extends Specification {
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
	
	
	void "the expected xml in Spock style."() {
		setup:
		def documentBuilderFactory =DocumentBuilderFactory.newInstance()
		def documentBuilder = documentBuilderFactory.newDocumentBuilder()
		def inputStream = new ByteArrayInputStream(originalXml.getBytes())
		Document doc = documentBuilder.parse(inputStream)
		doc.getDocumentElement().normalize()
		
		def node
		def staff = doc.getElementsByTagName("staff").item(0)
		if(staff.getNodeType() == Node.ELEMENT_NODE) {
			def staffAsElement = (Element)staff
			def nodeList = staffAsElement.getElementsByTagName(tagName).item(0).getChildNodes()
			node = (Node)nodeList.item(0)
		}
		
		expect:
		value == node.getNodeValue()
		
		where:
		tagName		| value
		"firstname"	| "Jack"
		"lastname"	| "Jones"
		"nickname"	| "JJ"
		"salary"	| "100000"
	}
	
	void "the expected xml in Groovy style."() {
		setup:
		def documentBuilderFactory =DocumentBuilderFactory.newInstance()
		def documentBuilder = documentBuilderFactory.newDocumentBuilder()
		def inputStream = new ByteArrayInputStream(originalXml.getBytes())
		Document doc = documentBuilder.parse(inputStream)
		doc.getDocumentElement().normalize()
		
		def printMapClosure = { tagName, value -> 
			def staff = doc.getElementsByTagName("staff").item(0)
			if(staff.getNodeType() == Node.ELEMENT_NODE) {
				def staffAsElement = (Element)staff
				def tagUnderStaff = staffAsElement.getElementsByTagName(tagName).item(0)
				def tagText = tagUnderStaff.getChildNodes().item(0)
				assert value == tagText.getNodeValue()
			} 
		}
		[ "firstname" : "Jack", "lastname" : "Jones", "nickname" : "JJ" , "salary" : "100000" ].each(printMapClosure)
		
	}
}
