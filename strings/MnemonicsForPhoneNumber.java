class MnemonicsForPhoneNumber {
    
    public List<String> letterCombinationsIterative(String digits) {
        
        if(digits.length() == 0)
            return new ArrayList<>();
        
        List<List<Character>> listArray = new ArrayList(10);
        listArray.add(new ArrayList());
        listArray.add(new ArrayList());
        listArray.add(Arrays.asList('a','b','c'));
        listArray.add(Arrays.asList('d','e','f'));
        listArray.add(Arrays.asList('g','h','i'));
        listArray.add(Arrays.asList('j','k','l'));
        listArray.add(Arrays.asList('m','n','o'));
        listArray.add(Arrays.asList('p','q','r','s'));
        listArray.add(Arrays.asList('t','u','v'));
        listArray.add(Arrays.asList('w','x','y','z'));
        
                
        
        List<String> list = listArray.get((int) digits.charAt(0) - '0').stream()
                                .map(c -> String.valueOf(c))
                                .collect(Collectors.toList());
        
        for(int i=1;i<digits.length();i++){

            int digit = digits.charAt(i) - '0';
            ArrayList<String> temp = new ArrayList<>();
            
            for(String s : list){
                for(Character newChar : listArray.get(digit)){
                    StringBuilder sb = new StringBuilder();
                    sb.append(s).append(newChar);
                    temp.add(sb.toString());
                }
            }
            
            list = temp;
            
        }
            
        return list;
        
    }
    
    public List<String> letterCombinationsRecursive(String digits) {
        
        res = new ArrayList<>();
        
        if(digits.length() == 0)
            return res;
        
        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a','b','c'});
        map.put('3', new char[]{'d','e','f'});
        map.put('4', new char[]{'g','h','i'});
        map.put('5', new char[]{'j','k','l'});
        map.put('6', new char[]{'m','n','o'});
        map.put('7', new char[]{'p','q','r','s'});
        map.put('8', new char[]{'t','u','v'});
        map.put('9', new char[]{'w','x','y','z'});
        
        List<char[]> li = new ArrayList<>();
        
        for(int i=0;i<digits.length();i++){
            li.add(map.get(digits.charAt(i)));
        }
        
        rec(li, new StringBuilder(), 0);
        
        return res;
    }
    
    List<String> res;
    
    void rec(List<char[]> arrList, StringBuilder sb, int idx){
        if(sb.length() == arrList.size()){
            res.add(sb.toString());
            return;
        }
        
        if(idx >= arrList.size())
            return;
        
        for(int i=idx;i<arrList.size();i++){
            char[] carr = arrList.get(i);
            for(char c : carr){
                sb.append(c);
                rec(arrList, sb, i+1);    
                sb.deleteCharAt(sb.length() - 1);                
            }
        }
                    
            
    }
    
}
