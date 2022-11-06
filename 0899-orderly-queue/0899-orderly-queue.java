class Solution {
    public String orderlyQueue(String s, int k) {
        
        if(k==1){
            String res = s;
            
            for(int i=0;i<s.length();++i){
                String temp = s.substring(i) + s.substring(0, i);
                
                if(temp.compareTo(res)<0){
                    res = temp;
                }
            }
            return res;
        }
        else{
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }
}