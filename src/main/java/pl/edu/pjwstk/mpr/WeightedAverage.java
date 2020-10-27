package pl.edu.pjwstk.mpr;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class WeightedAverage {
    private final File testFile;

    public WeightedAverage(String filePath) {
        this.testFile = new File("./src/test/resources/average/" + filePath);
    }

    public WeightedAverage() {
        this.testFile = null;
    }

    public BigDecimal calculate() throws IOException, IllegalArgumentException {
        String fullPath = testFile.getPath(); //robi String z pełna ścieżka pliku
        double wage;
        double number;
        double wageNumSum = 0;
        double wageTogether = 0;

        if(!testFile.exists()){
            throw new IllegalArgumentException("File not found");
        }


        Scanner file = new Scanner(new File(fullPath));
        while (file.hasNext()) {
            wage = file.nextDouble();
            number = file.nextDouble();
            wageTogether = wageTogether + wage;
            wageNumSum = (wageNumSum + (wage * number));
        }
        double FinalWage = wageNumSum / wageTogether;

        return new BigDecimal(FinalWage).setScale(2, RoundingMode.HALF_UP).stripTrailingZeros();


    }

}