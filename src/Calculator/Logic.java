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

    public boolean setSequence(String input)//
    {
        String[] array = input.trim().split(",");

        for(String x: array)
        {
            try
            {
                this.input.add(Float.parseFloat(x));
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid input");
                return false;
            }
        }
        return true;
    }


    public void getSequence()
    {
        for(int x = 0; x<this.input.size(); x++)
        {
            System.out.println(this.input.get(x));
        }
        System.out.println();
    }

    public boolean hasCommonDifference()//
    {
        float[] tempt = new float[input.size()-1];

        if (input.size() >= 1)
        {
            for(int x = 0; x<this.input.size()-1; x++)
            {
                tempt[x] = ((float)(input.get(x+1)) - ((float)(input.get(x))));
            }

            for(float x: tempt)
            {
                if (tempt[0] != x)
                {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public float getCommonDiference() //
    {
        if (input.size() == 1)
        {
            return (float)input.get(0);
        }
        else
            return ((float)this.input.get(1) - (float)this.input.get(0));
    }

    public int getSize()//
    {
        return input.size();
    }

    public float getFirstTerm()//
    {
        return (float)this.input.get(0);
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

    public long getSum()  // return the sum of a value sequence example: 3, 6 = 9;
    {
        try{
            return (long)(getFirstTerm() + getCertainTermValue()) * getTerm() / 2;
        }catch (Exception e){return 0;}
    }

    public void cleaner()
    {
        this.input.clear();
    }
}

