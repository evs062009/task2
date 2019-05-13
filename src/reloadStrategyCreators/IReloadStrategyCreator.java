package reloadStrategyCreators;

import utilities.IncorrectReplaceException;

import java.util.List;

public interface IReloadStrategyCreator {

    List<String> createStrategy(int blockQuantity)
            throws IncorrectReplaceException;
}
