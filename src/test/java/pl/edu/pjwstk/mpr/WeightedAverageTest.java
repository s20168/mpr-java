package pl.edu.pjwstk.mpr;

import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WeightedAverageTest {

    @Test
    public void should_create_class() { //that tests can be easily removed
       var average =  new WeightedAverage();

       assertThat(average).isNotNull();
    }

    @Test
    public void should_calculate_v1_average() throws IOException {
        //assume
        var average =  new WeightedAverage("test_avg_1.txt");
        //act
        BigDecimal avg = average.calculate();
        //assert
        assertThat(avg.doubleValue()).isEqualTo(4.11);
        System.out.println(avg);

    }

    @Test
    public void should_calculate_v2_average() throws IOException {
        //assume
        var average =  new WeightedAverage("test_avg_2.txt");
        //act
        BigDecimal avg = average.calculate();
        //assert
        assertThat(avg.doubleValue()).isEqualTo(2.08);
        System.out.println(avg);

    }

    @Test
    public void should_calculate_v3_average() throws IOException {
        //assume
        var average =  new WeightedAverage("test_avg_3.txt");
        //act
        BigDecimal avg = average.calculate();
        //assert
        assertThat(avg.doubleValue()).isEqualTo(2.55);
        System.out.println(avg);

    }

    @Test
    public void should_calculate_big_file_average() throws IOException {
        //assume
        var average =  new WeightedAverage("BigFile.txt");
        //act
        BigDecimal avg = average.calculate();
        //assert
        assertThat(avg.doubleValue()).isEqualTo(4.11);
        System.out.println(avg);

    }

    @Test
    public void should_execute_when_file_not_found() throws IOException {
        var average =  new WeightedAverage("not_found.txt");
        assertThatThrownBy(average::calculate)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("File not found");
    }

    @Test
    public void should_remove_redundant_zeros() throws IOException {
        var average =  new WeightedAverage("test_avg_4.txt");
        var averageTwo=  new WeightedAverage("test_avg_5.txt");
        BigDecimal avg = average.calculate();
        BigDecimal avg2 = averageTwo.calculate();
        assertThat(avg.doubleValue()).isEqualTo(3.5);
        assertThat(avg2.doubleValue()).isEqualTo(3);
        System.out.println(avg);
        System.out.println(avg2);
    }

}