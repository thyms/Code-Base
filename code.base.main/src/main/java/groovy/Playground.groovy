

//foodColor = [Apple:'red', Carrot:'orange', Banana:'yellow', Cherry:'black']
//count = [:]
//letters = []
//foodColor.values().each{ letters.addAll((it as String[])) }
//letters.each{ if (count.containsKey(it)) count[it] += 1 else count[it] = 1 }
//assert count == ["o":3, "d":1, "k":1, "w":2, "r":2, "c":1, "l":5, "g":1, "b":1, "a":2, "y":2, "n":1, "e":4]


//hash = [:]
//println hash.capacity()
//
//hash = new HashMap()
//println hash.capacity()
//
//('A'..'Z').each { hash[it] = it }
//println hash.size()
//println hash.capacity()
//
//hash = new HashMap(100)
//hash = new HashMap(100, 0.8f)

//colors1 = ['yellow', 'orange', 'red']
//colors2 = ['yellow']
//
//same = colors1.intersect(colors2)
//assert same == ['yellow']
//
//diff = colors1 - colors2
//assert diff == ['orange', 'red']

//foodColor = [Apple:'red', Carrot:'orange', Banana:'yellow', Cherry:'black']
//foodColor['Lemon'] = 'yellow'
//citrusColor = [Lemon:'yellow', Orange: 'orange', Lime: 'green']
//println foodColor
//println citrusColor
//
//common = foodColor.keySet().intersect(citrusColor.keySet())
//println "common: $common"
//
//foodButNotCitrus = foodColor.keySet() - citrusColor.keySet()
//assert foodButNotCitrus.sort() == [ 'Apple', 'Banana', 'Carrot', 'Cherry']

//def letters = 'A'..'Z'
//for(letter in letters) {
//	println letter
//}

//def letters = 'A'..'Z'
//letters.eachWithIndex { letter, index -> 
//	println "$index $letter"
//}

//println 'A' in 'A'..'Z'

//foodColor = [Apple:'red', Carrot:'orange', Banana:'yellow', Cherry:'black']
//
//drinkColor = [Galliano: 'yellow', 'Mai Tai': 'blue']
//ingestedColor = [:]
//ingestedColor.putAll(drinkColor)
//ingestedColor.putAll(foodColor)
//
//totalColors = ingestedColor.values().sort().unique()
//assert totalColors == ['black', 'blue', 'orange', 'red', 'yellow']


//foodColor = [Apple:'red', Carrot:'orange', Banana:'yellow', Cherry:'black']
//assert foodColor.keySet().sort() == ["Apple", "Banana", "Carrot", "Cherry"]
//assert foodColor.values().sort() == ['black', 'orange', 'red', 'yellow']
//assert foodColor.values().sort{it.size()} == ["red", "black", "orange", "yellow"]

//foods = ['apple', 'banana']
//str = foods.join(', ')
//println str


//surname = [Mickey: 'Mantle', Babe: 'Ruth']
//
//firstName = [:]
//surname.each { entry -> firstName[entry.value] = entry.key }
//firstName.each { entry -> println "$entry.key ${entry.value}" }

//surname = [Mickey: 'Mantle', Babe: 'Ruth']
//println surname.findAll { it.value == 'Mantle' }.collect { it.key }

//foodsOfColor = [Yellow: ['Banana', 'Lemon'], Green: ['Apple']]
//foodsOfColor['Green'] += 'Melon'
//assert foodsOfColor == [Green: ['Apple', 'Melon'], Yellow: ['Banana', 'Lemon']]

//foodColor = new LinkedHashMap()
//foodColor['Banana'] = 'Yellow'
//foodColor['Apple'] = 'Green'
//foodColor['Lemon'] = 'Yellow'
//
//foodColor.keySet().each { key -> println key }

//hash = [a:1, b:2, c:3]
//println hash
//hash.each {key, value -> println "$key => $value"}

//fakedInput = '''
//From: someone@somewhere.com
//From: someone@spam.com
//From: someone@somewhere.com
//'''
//
//from = [:]
//fakedInput.split('\n').each{
//	matcher = (it =~ /^From:\s+([^\s>]*)/)
//	if (matcher.matches()) {
//		sender = matcher[0][1]
//		if (from.containsKey(sender)) from[sender] += 1
//		else from[sender] = 1
//	}
//}
//
//// More useful to sort by number of received mail by person
//from.entrySet().sort {a, b -> b.value <=> a.value }.each { entry -> 
//	println "${entry.key}: ${entry.value}"
//}

//foodColor = [
//	Apple: 'read',
//	Banana: 'yellow',
//	Lemon: 'yellow',
//	Carrot: 'orange'
//]
//
//foodColorsSortedByFood = []
//foodColor.keySet().sort().each { k -> foodColorsSortedByFood << foodColor[k] }
//foodColorsSortedByFood.each { println it }
//assert foodColorsSortedByFood == ["red", "yellow", "orange", "yellow"]

//hash = [:]
//hash.each { key, value ->
//	// do something with key and value
//}
//
//hash.each { entry ->
//	// do something with entry
//}
//
//hash.keySet().each { key ->
//	// do something with key
//}

//foodColor = [
//	Apple: 'read',
//	Banana: 'yellow',
//	Lemon: 'yellow',
//	Carrot: 'orange'
//]
//assert foodColor.size() == 4
//foodColor.remove('Banana')
//assert foodColor.size() == 3


//foodColor = [
//	Apple: 'read',
//	Banana: 'yellow',
//	Lemon: 'yellow',
//	Carrot: 'orange'
//]
//
//assert ['Banana', 'Martini'].collect{ foodColor.containsKey(it)?'food':'drink' } == [ 'food', 'drink' ]
//
//age = [Toddler:3, Unborn:0, Phantasm:null]
//['Toddler', 'Unborn', 'Phantasm', 'Relic'].each{ key ->
//	print "$key: "
//	if (age.containsKey(key)) print 'has key '
//	if (age.containsKey(key) && age[key]!=null) print 'non-null '
//	if (age.containsKey(key) && age[key]) print 'true '
//	println ''
//}

//foodColor = [
//	Apple: 'read',
//	Banana: 'yellow',
//	Lemon: 'yellow',
//	Carrot: 'orange'
//]
//
//println foodColor['Lemon']
//foodColor['Lemon'] = 'green'
//println foodColor['Lemon']
//
//println foodColor.size()
//foodColor['Raspberry'] = 'pink'
//foodColor['Raspberry'] += 'pink'
//println foodColor.size()
//println foodColor['Raspberry']


//age = [Nat: 24, Jules: 25, Josh: 17]
//println age['Nat']
//println age.'Nat'

//import java.text.DateFormatSymbols as Symbols
//items = new Symbols(Locale.ENGLISH).shortWeekdays.toList()[1..7]
//assert items == ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"]
//// not as random as you might expect
//println items.sort{ Math.random() }
//// => ["Sat", "Tue", "Sun", "Wed", "Mon", "Thu", "Fri"]
//// better to use the built-in method for this purpose
//Collections.shuffle(items)
//println items
//// => ["Wed", "Tue", "Fri", "Sun", "Sat", "Thu", "Mon"]

//items = [1, 2, 3, 4, 5]
//processed = []
//10.times{
//	processed << items[0]
//	items = items[1..-1] + items[0]
//}
//assert processed == [1, 2, 3, 4, 5, 1, 2, 3, 4, 5]

//class Employee {
//	def name
//	def position
//	def salary
//}
//staff = [new Employee(name:'Jim',position:'Manager',salary:26000),
//		 new Employee(name:'Jill',position:'Engineer',salary:24000),
//		 new Employee(name:'Jack',position:'Engineer',salary:22000)]
//println staff*.name
//
//assert staff.sort { a,b -> a.name <=> b.name }*.name == ["Jack", "Jill", "Jim"]
//// sort by first two characters of name and if equal by descending salary
//assert staff.sort { a,b ->
//	astart = a.name[0..1]
//	bstart = b.name[0..1]
//	if (astart == bstart) return b.salary <=> a.salary
//	return astart <=> bstart
//}*.name == ["Jack", "Jim", "Jill"]

//boolean result = ''.trim()
//println result	// false

//boolean result = 'd'.trim()
//println result	// true


//println line = ''' 
//	fda
//	
// a'''.split('\n').findAll { it.trim() }.collect { it.trim() }

//class Employee {
//	def name
//	def position
//	def salary
//}
//staff = [new Employee(name:'Jim',position:'Manager',salary:26000),
//		 new Employee(name:'Jill',position:'Engineer',salary:24000),
//		 new Employee(name:'Jack',position:'Engineer',salary:22000)]
//
//engineers = staff.findAll { e -> e.position == 'Engineer' }
//assert engineers.size() == 2
//
//highPaid = staff.findAll { e -> e.salary > 23000 }
//assert highPaid*.name == ["Jim", "Jill"]


//class Employee {
//    def name
//    def position
//    def salary
//}
//staff = [new Employee(name:'Jim',position:'Manager',salary:26000),
//         new Employee(name:'Jill',position:'Engineer',salary:24000),
//         new Employee(name:'Jack',position:'Engineer',salary:22000)]
//highestEngineer = staff.find { emp -> emp.position == 'Engineer' }
//assert highestEngineer.salary == 24000

//2.times { println 'Deniz' }

//def shift2 = {friends -> one = friends[0]; two = friends[1]; 2.times{friends.remove(0)}}
//friends = 'Peter Paul Mary Jim Tim'.split(' ').toList()
//shift2(friends)
//assert one == 'Peter'
//assert two == 'Paul'
//assert friends == ["Mary", "Jim", "Tim"]
//
//def pop2(items) { items[0..1] }
//beverages = 'Dew Jolt Cola Sprite Fresca'.split(' ').toList()
//pair = pop2(beverages)
//assert pair == ["Dew", "Jolt"]

//items = ["the", "quick", "brown", "fox"]
//assert items.reverse() == ["fox", "brown", "quick", "the"]
//
//firstLetters = []
//items.reverseEach{ firstLetters += it[0] }
//assert firstLetters.join() == 'fbqt'
//
//descending = items.sort().reverse()
//assert descending == ["the", "quick", "fox", "brown"]
//descendingBySecondLastLetter = items.sort { a,b -> b[-2] <=> a[-2] }
//assert descendingBySecondLastLetter == ["brown", "fox", "the", "quick"]

//members = [ "Time", "Flies" ]
//initiates =  [ "An", "Arrow" ]
//members += initiates
//assert members == ["Time", "Flies", "An", "Arrow"]
//
//members.add(2, "Like")
//assert members == ["Time", "Flies", "Like", "An", "Arrow"]
//
//members[0] = "Fruit"

//members[2..4] = ["A", "Banana"]
//assert members == ["Fruit", "Flies",  "A", "Banana"]

//a = [1, 3, 5, 6, 7, 8]
//b = [2, 3, 5, 7, 9]
//// intersection
//assert a.intersect(b) == [3, 5, 7]
//// union
//assert (a + b).unique().sort() == [1, 2, 3, 5, 6, 7, 8, 9]
//// difference
//assert (a - b) == [1, 6, 8]

//assert [ 1, 1, 2, 2, 3, 3, 3, 5 ].unique() == [ 1, 2, 3, 5 ]
//assert [ 1, 1, 2, 2, 3, 3, 3, 4, 5 ] - [ 1, 2, 4 ]  ==  [3, 3, 3, 5]
//assert [ 1, 1, 2, 2, 3, 3, 3, 4, 5 ].unique() - [ 1, 2, 4 ]  ==  [3, 5]


//a = [0.5, 3]; b = [0, 1]
//assert [a, b].flatten().collect{ it * 7 } == [3.5, 21, 0, 8]

//marbleColors = 'red green yellow'.split(' ').grep(~/^g.*n$/)
//println marbleColors

//marbleColors = 'red green yellow'.split(' ')
//def result = marbleColors.find{ it =~ /ee/ }

//marbleColors = ['red', 'green', 'yellow']
//def result = marbleColors.find{ it =~ /ee/ } 

//import java.text.DateFormat
//import java.text.SimpleDateFormat
//
//cal = Calendar.instance
//cal.set(2007, 0, 1)
//df = new SimpleDateFormat('E M d hh:mm:ss z yyyy')
//println 'Customized format gives: ' + df.format(cal.time)
//// => Mon 1 1 09:02:29 EST 2007 (differs depending on your timezone)
//df = DateFormat.getDateInstance(DateFormat.FULL, Locale.FRANCE)
//println 'Customized format gives: ' + df.format(cal.time)
//// => lundi 1 janvier 2007

//import java.text.SimpleDateFormat
//
//input = "1998-06-03"
//df1 = new SimpleDateFormat("yyyy-MM-dd")
//date = df1.parse(input)
//df2 = new SimpleDateFormat("MMM/dd/yyyy")
//println 'Date was ' + df2.format(date)

//import java.text.SimpleDateFormat
//
//df = new SimpleDateFormat()
//printCal = {cal -> df.format(cal.time)}
//cal = Calendar.instance
//cal.timeZone = TimeZone.getTimeZone("UTC")
//cal.set(1973, 0, 18, 3, 45, 50)
//cal.add(Calendar.DATE, 55)
//cal.add(Calendar.HOUR_OF_DAY, 2)
//cal.add(Calendar.MINUTE, 17)
//cal.add(Calendar.SECOND, 5)
//assert printCal(cal) == '14/03/73 16:02'

//import java.text.SimpleDateFormat
//
//time = System.currentTimeMillis()
//long difference = 100
//long after = time + difference
//long before = time - difference
//
//// any field of a calendar is incrementable via add() and roll() methods
//cal = Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"), Locale.ENGLISH)
//df = new SimpleDateFormat()
//printCal = {cal -> df.format(cal.time)}
//cal.set(2000, 0, 1, 00, 01, 0)
//assert printCal(cal) == '1/01/00 00:01'
//// roll minute back by 2 but don't adjust other fields
//cal.roll(Calendar.MINUTE, -2)
//assert printCal(cal) == '1/01/00 00:59'
//// adjust hour back 1 and adjust other fields if needed
//cal.add(Calendar.HOUR, -1)
//assert printCal(cal) == '31/12/99 23:59'

//printCal = {abc -> println abc}
//printCal('den')

//cal = Calendar.instance
//cal.setTime(new Date(System.currentTimeMillis()))
//println('Dateline: '
//	+ cal.get(Calendar.HOUR_OF_DAY) + ':'
//	+ cal.get(Calendar.MINUTE) + ':'
//	+ cal.get(Calendar.SECOND) + '-'
//	+ cal.get(Calendar.YEAR) + '/'
//	+ (cal.get(Calendar.MONTH) + 1) + '/'
//	+ cal.get(Calendar.DATE))

//cal = Calendar.instance
//// set time zone using long or short timezone values
//cal.timeZone = TimeZone.getTimeZone("America/Los_Angeles")
//cal.timeZone = TimeZone.getTimeZone("UTC")
//// set date fields one at a time
//cal.set(Calendar.MONTH, Calendar.DECEMBER)

//cal = Calendar.instance
//Y = cal.get(Calendar.YEAR)
//M = cal.get(Calendar.MONTH)
//D = cal.get(Calendar.DATE)
//println "The current date is $Y $M $D"

//cal = Calendar.instance
//println 'Today is day ' + cal.get(Calendar.DAY_OF_YEAR) + ' of the current year.'

//nf = NumberFormat.getInstance(new Locale('tr'))
//assert nf.format(-1740525205) == '-1.740.525.205'

//nf = NumberFormat.getInstance()
//assert nf.format(-1740525205) == '-1,740,525,205'

//long seed = System.currentTimeMillis() + Runtime.runtime.freeMemory()
//random1 = new Random(seed)
//random2 = new Random(seed)
//assert random1.nextInt() == random2.nextInt()

//random = new Random()
//100.times{
//	next = random.nextInt(50) + 25
//	assert next > 24
//	assert next < 76
//}
//random = new Random()
//chars = []
//['A'..'Z','a'..'z','0'..'9',('!@$%^&*' as String[]).toList()].each{chars += it}
//password = (1..8).collect{ chars[random.nextInt(chars.size())] }.join()
//println password
//assert password.size() == 8


//years = []
//(5..<13).each {age -> years += age}
//assert years == [5, 6, 7, 8, 9, 10, 11, 12]
//println years

//x=3; y=20
//assert (x..y).step(7) == [3, 10, 17]

//x=3; y=20
//(x..<y).each {
//	println it
//}

//x=3; y=20
//for(i in x..y) {
//	println i
//}

//assert Integer.parseInt('0110110', 2) == 54
//assert Integer.toString(54, 2) == '110110'
//assert Integer.toString(60, 16) == '3'

//a = [3.3, 3.5, 3.7, -3.3] as double[]
//rintExpected = [3.0, 4.0, 4.0, -3] as double[]
//floorExpected = [3.0, 3.0, 3.0, -4.0] as double[]
//ceilExpected = [4.0, 4.0, 4.0, -3.0] as double[]
//
//a.eachWithIndex { val, i ->
//	assert Math.rint(val) == rintExpected[i]
//	assert Math.floor(val) == floorExpected[i]
//	assert Math.ceil(val) == ceilExpected[i]
//}

//a = 0.255
//b = a.setScale(2, BigDecimal.ROUND_HALF_DOWN)
//assert a.toString() == '0.255'
//assert b.toString() == '0.25'

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