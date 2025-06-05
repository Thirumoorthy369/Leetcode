class Solution {
    public boolean detectCapitalUse(String word) {
        int l=word.length();
        boolean flag=true;
        if(l==1) return true;
        if(Character.isUpperCase(word.charAt(0)))
        {
            if(Character.isUpperCase(word.charAt(1)))
            {
                for(int i=2;i<l;i++)
                {
                    if(!Character.isUpperCase(word.charAt(i)))
                    {
                        flag=false;
                        break;
                    }
                }
            }
            else
            {
                for(int i=2;i<l;i++)
                {
                    if(Character.isUpperCase(word.charAt(i)))
                    {
                        flag=false;
                        break;
                    }
                }
            }
        }
        else
        {
            for(int i=1;i<l;i++)
                {
                    if(Character.isUpperCase(word.charAt(i)))
                    {
                        flag=false;
                        break;
                    }
                }
        }
        return flag;
    }
}