package me.delev.javaskop17.springspock.service

/**
 * Reading CSV files in tests
 */
class TestUtils {

    static loadCsvFile(String fileName) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader()
        InputStream is = classloader.getResourceAsStream(fileName)
        if (is == null) {
            throw new RuntimeException(String.format("File '%s' not found", fileName))
        }
        return new ByteArrayInputStream(is.getBytes())
    }
}
