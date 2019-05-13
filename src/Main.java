import inputParameters.IInputParameters;
import inputParameters.InputParameters;
import presetParameters.IPresetParameters;
import presetParameters.PresetParameters;
import reloadStrategyCreators.IReloadStrategyCreator;
import reloadStrategyCreators.ReloadStrategyCreator;
import resultOutput.IResultOutput;
import resultOutput.ResultOutput;

public class Main {

    public static void main(String[] args) {
        IReloadStrategyCreator strategyCreator = new ReloadStrategyCreator();
        IPresetParameters presetParameters = new PresetParameters();
        IInputParameters inputParameters = new InputParameters();
        IResultOutput resultOutput = new ResultOutput();
        App app = new App(strategyCreator, presetParameters, inputParameters, resultOutput);

        app.execute();
    }
}
