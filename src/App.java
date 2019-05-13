import inputParameters.IInputParameters;
import presetParameters.IPresetParameters;
import reloadStrategyCreators.IReloadStrategyCreator;
import resultOutput.IResultOutput;
import utilities.IncorrectReplaceException;

class App {
    private IReloadStrategyCreator strategyCreator;
    private IPresetParameters presetParameters;
    private IInputParameters inputParameters;
    private IResultOutput resultOutput;

    App(IReloadStrategyCreator strategyCreator, IPresetParameters presetParameters,
        IInputParameters inputParameters, IResultOutput resultOutput) {
        this.strategyCreator = strategyCreator;
        this.presetParameters = presetParameters;
        this.inputParameters = inputParameters;
        this.resultOutput = resultOutput;
    }

    void execute() {
        String message = "Enter blocks quantity in range " +
                presetParameters.getMinBlockQuantity() + " - " + presetParameters.getMaxBlockQuantity() + ": ";
        int blockQuantity = inputParameters.inputBlockQuantity(message, presetParameters.getMinBlockQuantity(),
                presetParameters.getMaxBlockQuantity());

        try {
            resultOutput.printResult(strategyCreator.createStrategy(blockQuantity));
        } catch (IncorrectReplaceException ex) {
            resultOutput.printMessage(ex.getMessage());
        }
    }
}
