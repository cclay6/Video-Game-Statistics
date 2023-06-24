package OOD_project.gamestats;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;

/**
 * Class to format data values for use with bar graph
 * library
 */
public class MyValueFormatter implements ValueFormatter {

    private DecimalFormat mFormat;

    /**
     * Sets the decimal number format
     */
    public MyValueFormatter() {
        mFormat = new DecimalFormat("###,###,###"); // use no decimal
    }

    /**
     * formats the data values for use with graph library
     * @param value
     * @param entry
     * @param dataSetIndex
     * @param viewPortHandler
     * @return
     */
    @Override
    public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
        return mFormat.format(value) + "h ";
    }

}
