package inputParameters;

import java.util.Scanner;

public class InputParameters implements IInputParameters {

    @Override
    public int inputBlockQuantity(String message, int minBlockQuantity, int maxBlockQuantity) {
        int blockQuantity;

        System.out.println("____________________________________________");
        System.out.print(message);
        while (true) {
            blockQuantity = inputInt();
            if (blockQuantity >= minBlockQuantity && blockQuantity <= maxBlockQuantity) {
                System.out.println();
                return blockQuantity;
            }
            System.out.println("Quantity not in range.");
        }
    }

    private int inputInt() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }
            System.out.println("Invalid input format.");
        }
    }
}
