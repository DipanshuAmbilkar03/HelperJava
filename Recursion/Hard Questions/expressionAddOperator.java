// correct answer
import java.util.*;

class Solution {
    private List<String> ans = new ArrayList<>();

    public void backtrack(int i,String num,int target,long ansTillNow, String path,long prevNum) {
        if(i == num.length()){
            if(ansTillNow == target) {
                ans.add(path);
            }
            return;
        }

        for(int j=i; j<num.length(); j++) {
            if(j > i && num.charAt(i) == '0') {
                break;
            }

            long currNum = Long.parseLong(num.substring(i,j+1));
            if(i == 0) {
                backtrack(j+1,num,target,currNum,path + currNum,currNum);
            } else {
                backtrack(j+1,num,target,ansTillNow+currNum,path + "+" + currNum,currNum);
                backtrack(j+1,num,target,ansTillNow-currNum,path + "-" + currNum,-currNum);
                backtrack(j+1,num,target,ansTillNow-prevNum+prevNum*currNum,path + "*" + currNum,prevNum*currNum);
            }
        }
    }   

    public List<String> addOperators(String num, int target) {
        ans.clear();
        backtrack(0,num,target,0,"",0);
        return ans;
    }
}


// mycode 

class Solution {
    private List<String> ans = new ArrayList<>();

    public void backtrack(int i,String num,int target,long ansTillNow, String path,long prevNum) {
        if(i == num.length()){
            if(ansTillNow == target) {
                ans.add(path);
            }
            return;
        }

        for(int j=0; j<num.length(); j++) {
            if(j > i && num.charAt(i) == '0') {
                break;
            }

            long currNum = Long.parseLong(num.substring(i,j+1));
            if(i == 0) {
                backtrack(j+1,num,target,currNum,path+currNum,currNum);
            }else {
                backtrack(j+1,num,target,ansTillNow+currNum,path+"+",currNum);
                backtrack(j+1,num,target,ansTillNow-currNum,path+"-",-currNum);
                backtrack(j+1,num,target,ansTillNow-prevNum+prevNum*currNum,path+"*",currNum*prevNum);
            }
        }
    }   

    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        backtrack(0,num,target,0,"",0);
        return ans;
    }
}   