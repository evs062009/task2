package reloadStrategyCreators;

import utilities.IncorrectReplaceException;
import utilities.SlotsNames;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReloadStrategyCreator implements IReloadStrategyCreator {
    private List<String> strategy = new ArrayList<>();

    public List<String> createStrategy(int blockQuantity) throws IncorrectReplaceException {
        Slot fromSlot = new Slot(SlotsNames.FROM.getName());
        Slot toSlot = new Slot(SlotsNames.TO.getName());
        Slot transitSlot = new Slot(SlotsNames.TRANSIT.getName());

        for (int i = blockQuantity; i > 0; i--) {
            fromSlot.blocks.push(i);
        }
        reload(blockQuantity, fromSlot, toSlot, transitSlot);
        return strategy;
    }

    private void reload(int blockQuantity, Slot fromSlot, Slot toSlot, Slot transitSlot)
            throws IncorrectReplaceException {
        if (blockQuantity == 1) {
            replace(fromSlot, toSlot);
        } else {
            reload(blockQuantity - 1, fromSlot, transitSlot, toSlot);
            replace(fromSlot, toSlot);
            reload(blockQuantity - 1, transitSlot, toSlot, fromSlot);
        }
    }

    private void replace(Slot fromSlot, Slot toSlot) throws IncorrectReplaceException {

        if (!toSlot.blocks.empty() && toSlot.blocks.peek() <= fromSlot.blocks.peek()) {
            throw new IncorrectReplaceException(strategy.toString() +
                    "\nIt is impossible to load a larger block to a smaller one.");
        }
        Integer block = fromSlot.blocks.peek();
        fromSlot.blocks.pop();
        toSlot.blocks.push(block);
        strategy.add("#" + block + " " + fromSlot.name + " -> " + toSlot.name);
    }

    private class Slot {
        private String name;
        Stack<Integer> blocks;

        private Slot(String name) {
            this.name = name;
            blocks = new Stack<>();
        }
    }
}
