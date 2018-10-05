package edu.orangecoastcollege.cs272.btomita.ic03;

public abstract class Security implements Comparable<Security>//implements Valuation
// extends = inheritance; implements = interfaces
{
    protected String mISIN;
    protected String mIssuer;
    
    public int compareTo(Security o)
    {
        return 0;
    }

    public String getmISIN()
    {
        return mISIN;
    }

    public void setmISIN(String mISIN)
    {
        this.mISIN = mISIN;
    }

    public String getmIssuer()
    {
        return mIssuer;
    }

    public void setmIssuer(String mIssuer)
    {
        this.mIssuer = mIssuer;
    }


    public abstract double totalReturn();


    public abstract double percentReturn();

}
