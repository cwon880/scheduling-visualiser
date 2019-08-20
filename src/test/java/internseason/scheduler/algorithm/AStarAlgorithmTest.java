package internseason.scheduler.algorithm;

import internseason.scheduler.input.DOTParser;
import internseason.scheduler.exceptions.InputException;
import internseason.scheduler.model.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AStarAlgorithmTest {
    private Graph graph;
    private DOTParser parser;
    @Before
    public void setup() {
        this.parser = new DOTParser();
    }

    @Test
    public void testAStarSchedule() {
        try {
            Graph graph = this.parser.parse("src/test/resources/Test_Diamond.dot");
            BaseAlgorithm algorithm = AlgorithmFactory.getAlgorithm(AlgorithmType.A_STAR_ALGORITHM, 0);
            Schedule schedule = algorithm.execute(graph, 2);
            //System.out.println(schedule);
            assertEquals("Processor 0\n" +
                    "t1 scheduled at: 4\n" +
                    "t3 scheduled at: 6\n" +
                    "Cost of Processor 0: 8\n" +
                    "Processor 1\n" +
                    "t0 scheduled at: 0\n" +
                    "t2 scheduled at: 2\n" +
                    "Cost of Processor 1: 5\n" +
                    "Total schedule cost is: 8", schedule.toString());
        } catch (InputException e) {
            e.printStackTrace();
        }
    }
}
