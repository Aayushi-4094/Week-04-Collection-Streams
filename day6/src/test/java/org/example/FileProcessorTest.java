package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class FileProcessorTest {

    @TempDir
    Path tempDir;  // JUnit creates and cleans up a temp directory

    @Test
    void testWriteAndReadFile() throws IOException {
        // Arrange
        Path testFile = tempDir.resolve("test.txt");
        String content = "Hello JUnit 5!";

        // Act
        FileProcessor.writeToFile(testFile.toString(), content);
        String readContent = FileProcessor.readFromFile(testFile.toString());

        // Assert
        assertEquals(content, readContent);
        assertTrue(Files.exists(testFile));
    }

    @Test
    void testFileExistsAfterWriting() throws IOException {
        // Arrange
        Path testFile = tempDir.resolve("exists.txt");
        String content = "Test content";

        // Act
        FileProcessor.writeToFile(testFile.toString(), content);

        // Assert
        assertTrue(Files.exists(testFile));
        assertEquals(content, Files.readString(testFile));
    }

    @Test
    void testReadFromNonExistentFile() {
        // Arrange
        Path nonExistentFile = tempDir.resolve("nonexistent.txt");

        // Act & Assert
        IOException exception = assertThrows(IOException.class, () -> {
            FileProcessor.readFromFile(nonExistentFile.toString());
        });

        assertTrue(exception.getMessage().contains("nonexistent.txt"));
    }
}