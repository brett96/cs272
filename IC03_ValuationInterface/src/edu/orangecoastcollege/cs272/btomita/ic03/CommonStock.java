package edu.orangecoastcollege.cs272.btomita.ic03;

public class CommonStock extends Security implements Valuation//Comparable<CommonStock>, Valuation
{
    private int mShares;
    private double mPurchasePrice;
    private double mCurrentPrice;
    
    public CommonStock(String mISIN, String mIssuer, int mShares, double mPurchasePrice, double mCurrentPrice)
    {
        mISIN = this.mISIN;
        mIssuer = this.mIssuer;
        mShares = this.mShares;
        mPurchasePrice = this.mPurchasePrice;
        mCurrentPrice = this.mCurrentPrice;
    }
    
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(mCurrentPrice);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(mPurchasePrice);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + mShares;
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        CommonStock other = (CommonStock) obj;
        if (Double.doubleToLongBits(mCurrentPrice) != Double.doubleToLongBits(other.mCurrentPrice)) return false;
        if (Double.doubleToLongBits(mPurchasePrice) != Double.doubleToLongBits(other.mPurchasePrice)) return false;
        if (mShares != other.mShares) return false;
        return true;
    }

    public int compareTo(Security other)
    {
        int isinComp = this.mISIN.compareTo(other.mISIN);
        if(isinComp != 0) return isinComp;
        int issuerComp = this.mIssuer.compareTo(other.mIssuer);
        if(issuerComp != 0) return issuerComp;
        //Cast other into CommonStock
        if(other instanceof CommonStock)
        {
            CommonStock otherStock = (CommonStock) other;
            int sharesComp = mShares - otherStock.mShares;
            if(sharesComp != 0) return sharesComp;
            double purchasePriceComp = Double.compare(mPurchasePrice, otherStock.mPurchasePrice);// this.mPurchasePrice - other.mPurchasePrice;
            if(purchasePriceComp != 0.0) return (int)purchasePriceComp;
            return Double.compare(mCurrentPrice,  otherStock.mCurrentPrice);//(int)(this.mCurrentPrice - other.mCurrentPrice);
        }
        return 0;
        
//        int sharesComp = mShares - otherStock.mShares;
//        if(sharesComp != 0) return sharesComp;
//        double purchasePriceComp = Double.compare(mPurchasePrice, other.mPurchasePrice);// this.mPurchasePrice - other.mPurchasePrice;
//        if(purchasePriceComp != 0.0) return (int)purchasePriceComp;
//        return Double.compare(mCurrentPrice,  other.mCurrentPrice);//(int)(this.mCurrentPrice - other.mCurrentPrice);
        
    }
    @Override
    public double totalReturn()
    {
        // TODO Auto-generated method stub
        return (mCurrentPrice - mPurchasePrice)*mShares;
    }

    @Override
    public double percentReturn()
    {
        return (mCurrentPrice - mPurchasePrice)/mShares;
    }
    
    @Override
    public String toString()
    {
        return ("Common Stock: " + mISIN + ", " + mIssuer +", " + mPurchasePrice + ", "  
                + mCurrentPrice + ", " + mShares + ", " + totalReturn() + ", " + percentReturn());
    }

}
