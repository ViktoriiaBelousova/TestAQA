package org.example;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class TestMain1 {

    @Test
    public void testCycleOutput() {
        // Сохраняем оригинальный System.out
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            // Перенаправляем вывод в наш поток
            System.setOut(new PrintStream(outputStream));

            // Вызываем тестируемый метод
            Main.cycle(4);

            // Ожидаемый вывод
            String expectedOutput = "i = 1\r\ni = 2\r\ni = 3\r\ni = 4\r\n";

            // Проверяем соответствие вывода
            assertEquals(expectedOutput, outputStream.toString());

        } catch (Exception e) {
            // Если возникло исключение - помечаем тест как проваленный
            fail("Тест выбросил исключение: " + e.getMessage());

        } finally {
            // Всегда восстанавливаем стандартный вывод
            System.setOut(originalOut);
        }
    }
}