# [jd2_homework *(Enterprise homeworks)*][goBack] > [Work with Files in Java][wwf] > The simple charset encoder
[goBack]: ../../README.md
[wwf]: work_with_files_in_java.md

<!-- ---------------------------------- * Navigation * ---------------------------------- -->

### Simple encoder: 
```java
// converter (msg, "cp1251", "utf-8")
private String converter (String handlingMessage, String fromCharset, String toCharset)
{
    ByteBuffer byteBuffer = ByteBuffer.wrap(handlingMessage.getBytes());
    CharBuffer charBuffer = Charset.forName(toCharset).decode(byteBuffer);

    return new String(Charset.forName(fromCharset).encode(charBuffer).array());
};
```

---