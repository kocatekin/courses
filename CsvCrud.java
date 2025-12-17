import java.io.*;
import java.nio.file.*;
import java.util.*;

public class CsvCrud {

    private CsvCrud() {
        // Prevent instantiation
    }

    /* ===================== CREATE ===================== */

    public static void create(String fileName, String csvLine) {
        try (BufferedWriter writer =
                     Files.newBufferedWriter(
                             Paths.get(fileName),
                             StandardOpenOption.CREATE,
                             StandardOpenOption.APPEND)) {

            writer.write(csvLine);
            writer.newLine();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* ===================== READ ===================== */

    public static List<String> readAll(String fileName) {
        List<String> lines = new ArrayList<>();

        Path path = Paths.get(fileName);
        if (!Files.exists(path)) {
            return lines;
        }

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;

            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return lines;
    }

    public static String readById(String fileName, String id) {
        List<String> lines = readAll(fileName);

        for (String line : lines) {
            if (line.startsWith(id + ",")) {
                return line;
            }
        }
        return null;
    }

    /* ===================== UPDATE ===================== */

    public static void update(String fileName, String id, String newCsvLine) {
        List<String> lines = readAll(fileName);
        List<String> updated = new ArrayList<>();

        for (String line : lines) {
            if (line.startsWith(id + ",")) {
                updated.add(newCsvLine);
            } else {
                updated.add(line);
            }
        }

        writeAll(fileName, updated);
    }

    /* ===================== DELETE ===================== */

    public static void delete(String fileName, String id) {
        List<String> lines = readAll(fileName);
        List<String> remaining = new ArrayList<>();

        for (String line : lines) {
            if (!line.startsWith(id + ",")) {
                remaining.add(line);
            }
        }

        writeAll(fileName, remaining);
    }

    /* ===================== HELPER ===================== */

    private static void writeAll(String fileName, List<String> lines) {
        Path path = Paths.get(fileName);

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
