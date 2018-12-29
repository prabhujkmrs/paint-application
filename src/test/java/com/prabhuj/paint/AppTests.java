package com.prabhuj.paint;

import com.prabhuj.paint.service.Draw;
import com.prabhuj.paint.service.DrawImpl;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class AppTests {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    private Draw draw = new DrawImpl();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testGetUserInput() {
        draw.getUserInput();
        String expected = "Please enter the command:\n";
        assertEquals(expected, outputStream.toString());

    }

    @Test
    public void testInvalidCommandInput() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("X 20 5".getBytes());
        System.setIn(inputStream);
        draw.processInput();
        String expected = "Command Invalid. Please enter a valid command:\n";
        assertEquals(expected,outputStream.toString());
    }

    @Test
    public void testValidCommandInput() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("C 20 5".getBytes());
        System.setIn(inputStream);
        draw.processInput();
        String expected =" --------------------\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                " --------------------\n";
        assertEquals(expected,outputStream.toString());
    }

    @Test
    public void testHorizontalLineCommand() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("C 20 6".getBytes());
        System.setIn(inputStream);
        draw.processInput();
        ByteArrayInputStream inputStream1 = new ByteArrayInputStream("L 1 3 7 3".getBytes());
        System.setIn(inputStream1);
        draw.processInput();
        String expected =" --------------------\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                " --------------------\n" +
                " --------------------\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|xxxxxxx             |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                " --------------------\n";
        assertEquals(expected,outputStream.toString());
    }

    @Test
    public void testVerticalLine() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("C 20 6".getBytes());
        System.setIn(inputStream);
        draw.processInput();
        ByteArrayInputStream inputStream1 = new ByteArrayInputStream("L 7 1 7 3".getBytes());
        System.setIn(inputStream1);
        draw.processInput();
        String expected =" --------------------\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                " --------------------\n" +
                " --------------------\n" +
                "|      x             |\n" +
                "|      x             |\n" +
                "|      x             |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                " --------------------\n";
        assertEquals(expected,outputStream.toString());
    }

    @Test
    public void testDrawRectangleCommand(){
        ByteArrayInputStream inputStream = new ByteArrayInputStream("C 20 5".getBytes());
        System.setIn(inputStream);
        draw.processInput();
        ByteArrayInputStream inputStream2 = new ByteArrayInputStream("R 15 2 20 5".getBytes());
        System.setIn(inputStream2);
        draw.processInput();
        String expected =" --------------------\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                " --------------------\n" +
                " --------------------\n" +
                "|                    |\n" +
                "|              xxxxxx|\n" +
                "|              x    x|\n" +
                "|              x    x|\n" +
                "|              xxxxxx|\n" +
                " --------------------\n";
        assertEquals(expected,outputStream.toString());


    }
}
