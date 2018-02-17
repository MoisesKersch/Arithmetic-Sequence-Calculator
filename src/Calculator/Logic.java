package Calculator;

import java.util.Vector;

public class Logic
{
    private Vector input;
    private float number1;
    private float number2;
    private int term;

    Logic()
    {
        input = new Vector();
    }

    private float privateGetCommonDiference(float input1, float input2)
    {
        return input1 - input2;
    }

    public void add(float number1, float number2)
    {
        this.number1 = number1;
        this.number2 = number2;
    }

    public float getCommonDiference()
    {
        return privateGetCommonDiference(number2, number1);
    }

    public float getFirstTerm()
    {
        return number1;
    }

    public void setTerm(int term)
    {
        this.term = term;
    }

    public int getTerm()
    {
        return term;
    }

    public float getCertainTermValue()
    {
        return getFirstTerm() + ((getTerm() - 1)* getCommonDiference());
    }

    public float getSum()  // return the sum of a value sequence example: 3, 6 = 9;
    {
        try{
            return (getFirstTerm() + getCertainTermValue()) * getTerm() / 2;
        }catch (Exception e){return 0;}
    }
}

