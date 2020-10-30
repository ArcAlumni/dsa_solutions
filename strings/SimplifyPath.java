class SimplifyPath {

    public String simplifyPath(String path) {
        
        Deque<String> stack = new LinkedList<>();
        
        for(String s : path.split("/")){
            
            if(s.length() == 0){
                continue;
            }
            
            if(s.equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
            }else if(!s.equals(".")){
                stack.push(s);
            }
            
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(new StringBuilder(stack.pop()).reverse()).append("/");
        }
        
        return sb.length() == 0 ? "/" : sb.reverse().toString();
    }
    
}
