public class DecodeString {
    
    public static void main(String[] args) {
        DecodeString obj = new DecodeString();
        String str = "3[a]2[bc]";
        System.out.println(obj.decode(str));
    }
    
    String decode(String str){
        Queue<Character> q = new LinkedList<>();
        for(char ch : str.toCharArray())
            q.add(ch);
        return helper(q);
    }
    
    String helper(Queue<Character> q) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while(!q.isEmpty()){
            char ch = q.poll();
            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');                
            }else if(ch == '['){
                String sub = helper(q);
                for(int i=0;i<num;i++)
                    sb.append(sub);
                num = 0;
            }else if(ch == ']'){
                break;
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    
}
