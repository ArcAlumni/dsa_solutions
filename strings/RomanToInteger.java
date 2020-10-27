class RomanToInteger {
    
    public int romanToInt(String s) {
        
        int len = s.length();
        
        int[] map = new int[256];
        map['I' - '0'] = 1;
        map['V' - '0'] = 5;
        map['X' - '0'] = 10;
        map['L' - '0'] = 50;
        map['C' - '0'] = 100;
        map['D' - '0'] = 500;
        map['M' - '0'] = 1000;
        
        int res = 0;
        
        for(int i=0;i<len;i++){
            
            char ch = s.charAt(i);
            int chVal = map[ch - '0'];
            
            if(i < len - 1){
                char nextCh = s.charAt(i + 1);
                int nextChVal = map[nextCh - '0'];
                if(chVal < nextChVal){
                    res += nextChVal - chVal;
                    i++;
                }else{
                    res += chVal;
                }
            }else{
                res += chVal;
            }
            
        }
        
        return res;
    }
    
}
