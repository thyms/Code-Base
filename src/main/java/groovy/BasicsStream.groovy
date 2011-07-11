package groovy
def fos= new FileOutputStream('TestFile.txt')

//These methods are available for all output streams, not just FileOutputStream:
[ 21, 34, 43, 79 ].each{ fos.write(it) }
    //write out the lowest-order 8 bits of the supplied integer
fos.flush()
fos.write([69, 32, 22] as byte[])
fos.write([10, 11, 12, 13, 88, 89] as byte[], 3, 2)
    //write 2 bytes from array starting at index 3
fos.close()
try{ fos.write(77); assert 0 }catch(e){ assert e instanceof IOException }
    //no writing after file closed


//check the byte contents of the file with a File utility method:
assert new File('TestFile.txt').readBytes().toList() ==
    [ 21, 34, 43, 79, 69, 32, 22, 13, 88 ]


def fis= new FileInputStream('TestFile.txt')

//These methods are available for all input streams, not just FileInputStream:
assert fis.available() == 9
    //an estimate of bytes left for reading or skipping in the input stream
assert fis.read() == 21 //actually, the next byte is returned as an integer
fis.skip(2) //skip over, here, 2 bytes of data from the stream
assert fis.available() == 6
def ba2= new byte[3]
fis.read(ba2)
assert ba2.toList() == [79, 69, 32]
def ba3= new byte[6]
assert fis.read(ba3, 3, 2) == 2 //fill ba3 with 2 elements from index 3,
                                //return num of elements copied, here, 2
assert ba3.toList() == [0, 0, 0, 22, 13, 0]
assert fis.read(ba3) == 1 //return num of elements copied, here, 1
assert ba3.toList() == [88, 0, 0, 22, 13, 0]
assert fis.read(ba3) == -1 //return -1 if already at end-of-stream

//true if this input stream support the mark() and reset() methods...
if( fis.markSupported() ){
  fis.reset()
      //reset reading to beginning of stream if mark() hasn't ever been called
  assert fis.read() == 21
  fis.mark(0) //mark this position in the stream; argument has no meaning here
  fis.read(new byte[4])
  fis.reset() //reset reading to where the last mark() method was called
  assert fis.read() == 34
}
fis.close()
try{ fis.read(); assert 0 }catch(e){ assert e instanceof IOException }


new File('TestFile.txt').delete() // delete the file used by this example