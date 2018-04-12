package xyz.neolith.wall;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xyz.neolith.wall.associationanalysis.AprioriAnalysis;
import xyz.neolith.wall.associationanalysis.RecordReaderImpl;

/**
 * @author sunlggggg
 * @date 2018/4/6
 */
@SpringBootApplication
public class AprioriApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AprioriApplication.class, args);
    }

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) {
        new AprioriAnalysis().analysis(new RecordReaderImpl());
    }
}
