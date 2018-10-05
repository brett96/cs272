package edu.orangecoastcollege.cs272.btomita.ic03;

public interface Valuation
{
    //totalReturn method is just a promise that any class who implements Valuation will provide 
    // a real definition for this method
    /**
     * Calculates the total return in a valuation
     * @return The total return of a valuation
     */
    public double totalReturn();
    
    /**
     * Calculates the precent return of a valuation
     * @return The percent return of a valuation
     */
    public double percentReturn();
}
