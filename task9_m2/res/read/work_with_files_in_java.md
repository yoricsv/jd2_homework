# [jd2_homework *(Enterprise homeworks)*][goBack] > web.xml Template structure
[goBack]: ../../README.md

<!-- ---------------------------------- * Navigation * ---------------------------------- -->

## WRITING examples:

### to write value into the file (by IO):
```java
private void writeDataIO (int newValue)
    throw IOException
{
    BufferedWriter fbw =
        new BufferedWriter(
            new FileWriter (file.getFile(), false)                  // false - means append is false (rewrite file)
    );
    fbw.write(String.valueOf(newValue));
    fbw.flush();
    fbw.close();
}
```

### to write value into the file (by Stream):
```java
private void writeDataStream (int newValue)
    throw IOException
{
    FileOutputStream fileOutputStream =
        new FileOutputStream(file.getFile(), false);

    fileOutputStream.write(
        String.valueOf(newValue)
        .getBytes()
    );

    fileOutputStream.close();
}
```
### to write value into the file (by NIO):
```java
private void writeDataNIO (int newValue)
    throw IOException
{
    FileOutputStream fileOutputStream =
        new FileOutputStream(file.getFile(), false);

    FileChannel outStreamChannel = fileOutputStream.getChannel();   // connect to the stream channel (file)
    ByteBuffer  outStreamBuffer  = ByteBuffer.allocate(4096);       // set the buffer page size

    outStreamBuffer.put(                                            // write output stream into the buffer
        String.valueOf(newValue).getBytes(StandardCharsets.UTF_8)   // specified the encoding
        // Byte.parseByte(String.valueOf(newValue))                 // the same as previous one (without encoding)
    );

    outStreamBuffer.flip();                                         // return the buffer cursor to the starting position
    outStreamChannel.write(outStreamBuffer);                        // write the buffer context to the channel (file)
    
    outStreamBuffer.clear();                                        // clear the buffer
    fileOutputStream.close();                                       // close the file stream
}
```

---

## READING examples:

### to READ value form the file (by IO and char array buffer):
```java
private int readData ()
    throw IOException
{
    Reader readData = new FileReader (file.getFile());

    char[] arr = new char[4096];

    StringBuilder quantity = new StringBuilder();

    int numberOfCharsInString;
    while ((numberOfCharsInString = readData.read(arr, 0, arr.length)) != -1)
        quantity.append(arr, 0, numberOfCharsInString);

    readData.close();

    return quantity.toString();
}
```
### to READ value form the file (by IO and BufferReader):
```java
private int readData ()
    throw IOException
{
    BufferedReader reader =
        new BufferedReader(
            new FileReader(file.getFile())
        );
    String quantity = reader.readLine();
    reader.close();
    return quantity;
}
```

### to READ value from the file (by Stream):
```java
// to read
private int readData ()
    throw IOException
{
    BufferedReader  fileBufferReader =
        new BufferedReader(
            new InputStreamReader(
                new FileInputStream(file.getFile()), "utf-8"),
                ALLOCATE_MEMORY
        );

    String quantity =
        fileBufferReader
        .lines()
        .collect(
            Collectors.joining("\n")
        );

    fileBufferReader.close();

    return quantity;
}
```

> ***NOTE***: To change a charset see: [The simple converter][1]

[1]: simple_charset_encoder.md

---