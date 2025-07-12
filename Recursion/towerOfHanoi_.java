package Recursion;

public class towerOfHanoi_ {
    public static void towerOfHanoi(int n,String source, String helper,String destination) {
        if(n == 1) {
            System.out.println("Disk send "+n+" from "+source+" to "+destination);    
            return;
        }
        
        towerOfHanoi(n-1, source, destination, helper);
        System.out.println("Disk send "+n+" from "+source+" to "+destination);    
        towerOfHanoi(n-1, helper, source, destination);
    }   
    public static void main(String[] args) {
        // number of disk in tower 
        int n = 3;
        towerOfHanoi(n, "S", "H", "D");
    }
}