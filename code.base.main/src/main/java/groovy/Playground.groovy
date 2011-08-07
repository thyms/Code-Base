

//str = sprintf( '%2$s %3$s %1$s', ['cool!', 'Groovy', 'is'])
//// Uses Java Formatter: http://download.oracle.com/javase/1.5.0/docs/api/java/util/Formatter.html
//println str

//assert 'Groovy is cool!' == sprintf( '%2$s %3$s %1$s', ['cool!', 'Groovy', 'is'])

//'notepad'.execute()

//@GrabConfig(systemClassLoader=true)
//@Grab(group='commons-codec', module='commons-codec', version='1.3')
//
//soundex = new org.apache.commons.codec.language.Soundex()
//assert soundex.soundex('Smith') == soundex.soundex('Smyth')

//new BufferedReader(new InputStreamReader(System.in)).eachLine{
//	println(">" + it.trim() + "<");
//}

//name = 'Deniz'
//string = /Mom said, $name 
//Don't do that.
///
//
//println string

//def numbers = [ 5, 7, 9, 12 ]
//numbers.eachWithIndex{ num, idx -> println "$idx: $num" }

//expected = '''Folding and splicing
//is the work of an
//editor, not a mere
//collection of
//silicon and mobile
//electrons!'''
//
//println expected

//def raw = '''
//	your text
//	goes here
//'''
//
//raw.split('\n').each { it.replaceAll(/(^\s+)(.*)/, {all, pre, suf -> println suf})}


//s = "thIS is a loNG liNE".replaceAll(/\w+/){all -> println all}

//'I am 17 years old'.replaceAll(/(\d+)(.*)/, {all, age, suf -> println all})

//s1 = 'abc\t def\tghi \n\tx'
//s1.eachLine { it.replaceAll(/([^\t]*)(\t)(.*)/) { all, pre, tab, suf ->  
//		println all
//	} 
//}

//debt = 150
//assert "You owe ${debt} to me" == 'You owe 150 to me'
//println "You owe $debt to me"

//words = ['bob', 'alpha', 'rotator', 'omega', 'reviver']
//long_palindromes = words.findAll{ w -> w == w.reverse() && w.size() > 5 }
//assert long_palindromes == ['rotator', 'reviver']

//file = new File('dk.txt')
//file.deleteOnExit()
//file.setText('Some text goes here and there...')
//file.eachByte { println it ? (char)it.next() : it.next() }

//string = "an apple a day"
//println string.split('')
//println string.split('').toList()
//println string.split('').toList().unique()
//println string.split('').toList().unique().sort()
//println string.split('').toList().unique().sort().join()

//assert string[3..7].split('')[1..5] == ['a', 'p', 'p', 'l', 'e']
//
//println string[3..7]
//println string[3..7].split('')

//assert ("HAL" as String[]).collect{it.next()}.join() == 'IBM'

//assert new String([115, 97, 109, 112, 108, 101] as char[]) == "sample"

//v1 = 'alpha'; v2 = 'omega'
//// this can done with explicit swapping via a temp variable
//// or in a slightly more interesting way with a closure
//swap = { temp = v1; v1 = v2; v2 = temp }
//swap()
//assert v1 == 'omega' && v2 == 'alpha'

//
//b = false; c = 'cat'
//assert (b ? b : c) == 'cat'

//string = "This wasn't wondrous"
//// check last ten characters match some pattern
//assert string[-10..-1] =~ /^t\sw.*s$/

//def string = 'abcd' as String[]
//string.each { println it }

//string = 'hippopotamus'
//println string
//
//sb = new StringBuffer(string)
//sb[2..-3] = 'bisc'
//println sb

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