package resultOutput;

import java.util.List;

public class ResultOutput implements IResultOutput {

    @Override
    public void printResult(List<String> result) {
        System.out.println("=================================");
        System.out.println("Blocks replacement strategy:");
        System.out.println("=================================");
        result.forEach(System.out::println);
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }
}
