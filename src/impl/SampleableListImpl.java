package impl;

import interfaces.SampleableList;

/**
 * Created by vladimirsivanovs on 05/11/2015.
 */
public class SampleableListImpl extends ArrayList implements SampleableList {

    @Override
    public SampleableList sample() {
        SampleableList sampled = new SampleableListImpl();

        if (this.isEmpty()) return sampled;

        for (int i = 0; i < this.size(); i++) {
            if (isEven(i)) {
                sampled.add(this.get(i).getReturnValue());
            }
        }
        return sampled;
    }

    /**
     * Checks if number is even.
     *
     * @param num number to check
     * @return true if number is even, false otherwise
     */
    public boolean isEven(int num) {
        if ((num & 1) == 0) return true;
        return false;
    }

}
