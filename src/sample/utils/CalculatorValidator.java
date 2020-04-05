package sample.utils;

public class CalculatorValidator {
    private int openedBark = 0;
    private int textFieldCount = 24;

    public int getOpenedBark() {
        return openedBark;
    }

    public void setOpenedBark(int openedBark) {
        this.openedBark = openedBark;
    }

    private void decreaseOpenBark() {openedBark++;}

    private void increaseOpenBark() {openedBark--;}

    public boolean isCanAdd(String val) {
        return val == null || val.length() < (textFieldCount-openedBark);
    }

    public boolean canAddOperator(String val) {
        if(val == null || val.equals("")) {
            return false;
        }
        String lastSymbol = val.substring(val.length()-1);
        return !lastSymbol.equals("+")
                && !lastSymbol.equals("-")
                && !lastSymbol.equals("*")
                && !lastSymbol.equals("/")
                && !lastSymbol.equals("(");
    }

    public boolean canAddMines(String val) {
        if(val == null || val.equals("") ) {
            return true;
        }
        String lastSymbol = val.substring(val.length()-1);
        return !lastSymbol.equals("+")
                && !lastSymbol.equals("-")
                && !lastSymbol.equals("*")
                && !lastSymbol.equals("/");
    }

    public boolean canAddOpenBark(String val) {
        if (val.length() == 0) {
            return true;
        }
        String lastSymbol = val.substring(val.length()-1);
        increaseOpenBark();
        if (lastSymbol.equals("+")
                || lastSymbol.equals("-")
                || lastSymbol.equals("*")
                || lastSymbol.equals("/")
                || lastSymbol.equals("(")
        ) {
            increaseOpenBark();
            return true;
        } else {
            return false;
        }
    }

    public boolean canAddCloseBark(String val) {
        if (val.length() == 0 || getOpenedBark() == 0) {
            return false;
        }
        String lastSymbol = val.substring(val.length()-1);
        if (lastSymbol.equals("+")
                || lastSymbol.equals("-")
                || lastSymbol.equals("*")
                || lastSymbol.equals("/")
                || lastSymbol.equals("(")
                || lastSymbol.equals(".")
        ) {
            return false;
        } else {
            decreaseOpenBark();
            return true;
        }
    }
}
