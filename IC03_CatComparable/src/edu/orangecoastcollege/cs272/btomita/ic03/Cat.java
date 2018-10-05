package edu.orangecoastcollege.cs272.btomita.ic03;

public class Cat implements Comparable<Cat>
{
    private String mName;
    private String mBreed;
    private int mAge;
    // Window -> Preferences -> Java -> Code Style: in Prefix list: if add 'm', won't add m to getters&setters
    @Override
    public int compareTo(Cat other)  // returns negative num if object is less than other cat
    //returns 0 if same as other cat; else returns positive num if this cat is greater than other cat
    {
        int nameComp = this.mName.compareTo(other.mName);
        if(nameComp != 0) return nameComp;
        // Only way we get to this point if names are the same
        int breedComp = this.mBreed.compareTo(other.mBreed);
        if(breedComp != 0) return breedComp;
        // Now compare ages
        return this.mAge - other.mAge;
    }
    
    public String getName()
    {
        return mName;
    }

    public void setName(String mName)
    {
        this.mName = mName;
    }

    public String getBreed()
    {
        return mBreed;
    }

    public void setBreed(String mBreed)
    {
        this.mBreed = mBreed;
    }

    public int getAge()
    {
        return mAge;
    }

    public void setAge(int mAge)
    {
        this.mAge = mAge;
    }
    
    public Cat(String mName, String mBreed, int mAge)
    {
        this.mName = mName;
        this.mBreed = mBreed;
        this.mAge = mAge;
    }
    
    public Cat(Cat cat)
    {
        mName = cat.getName();
        mBreed = cat.getBreed();
        mAge = cat.getAge();
    }
    
    public int ageInHumanYears(int mAge)
    {
        int humanAge = 0;
        if (mAge == 1) return 15;
        humanAge+=15;
        if(mAge == 2) return 24;
        humanAge += 9;
        return humanAge + 4*(mAge-2);
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + mAge;
        result = prime * result + ((mBreed == null) ? 0 : mBreed.hashCode());
        result = prime * result + ((mName == null) ? 0 : mName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Cat other = (Cat) obj;
        if (mAge != other.mAge) return false;
        if (mBreed == null)
        {
            if (other.mBreed != null) return false;
        }
        else if (!mBreed.equals(other.mBreed)) return false;
        if (mName == null)
        {
            if (other.mName != null) return false;
        }
        else if (!mName.equals(other.mName)) return false;
        return true;
    }
    
    @Override
    public String toString()
    {
        return("Cat [Name = " + mName + ", Breed = " + mBreed + ", Age = " + mAge + ", Human Age = " + ageInHumanYears(getAge())+"]");
    }
    
    
    
    
}
