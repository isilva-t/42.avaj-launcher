package pt.isilvat.avaj.tools;

import pt.isilvat.avaj.exceptions.InvalidFileExtension;
import pt.isilvat.avaj.exceptions.InvalidCoordinates;

public class Validator {

    public static void validateFIleExtension (String fileName) {
        try {
            if (!fileName.endsWith(".txt")) {
                throw new InvalidFileExtension();
            }
            if (fileName.equals(".txt") || fileName.endsWith("/.txt")) {
                throw new InvalidFileExtension("Only a hidden \".txt\" file.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public static int getGeoCoord(String s_value) {
        try {
            int value = Integer.parseInt(s_value);
            if (value < 1) {
                throw new InvalidCoordinates("longitude");
            }
            return value;
        } catch (InvalidCoordinates e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return -1;
    } 

    public static int getHeight(String s_height) {
        try {
            int height = Integer.parseInt(s_height);
            if (height > 100 || height < 0) {
                throw new InvalidCoordinates("height");
            }
            return height;
        } catch (InvalidCoordinates e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return -1;
    }
}