//import groovy.xml.DOMBuilder 
//import org.custommonkey.xmlunit.* 
//// uncomment below to show what happens when differences occur (1 of 2) 
////import groovy.xml.dom.DOMCategory 
//import static groovy.xml.XmlUtil.serialize 
//
//def input  = '<root><foo bar="baz"/></root>' 
//def reader = new StringReader(input) 
//def doc    = DOMBuilder.parse(reader) 
//def root   = doc.documentElement 
//
//assert doc instanceof org.w3c.dom.Document 
//assert root instanceof org.w3c.dom.Element 
//
//// uncomment below to show what happens when differences occur (2 of 2) 
////use(DOMCategory) { 
////  root.foo.each { it['@bar'] = 'bazza!' } 
////} 
//
//XMLUnit.setIgnoreWhitespace(true) 
//def output = serialize(root) 
//def xmlDiff = new Diff(output, input) 
//assert xmlDiff.identical() 