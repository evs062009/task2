package presetParameters;

public class PresetParameters implements IPresetParameters {
    @Override
    public int getMinBlockQuantity() {
        return 3;
    }

    @Override
    public int getMaxBlockQuantity() {
        return 8;
    }
}
