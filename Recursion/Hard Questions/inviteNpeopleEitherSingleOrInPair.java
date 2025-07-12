public class inviteNpeopleEitherSingleOrInPair {
    public static int invitePeopleInparty(int n) {
        if(n <= 1) {
            return 1;
        }
        
        //Inviting Single person
        int single = invitePeopleInparty(n-1);

        //Inviting in Pair 
        int pair = (n-1) * invitePeopleInparty(n-2);

        return single + pair;
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(invitePeopleInparty(n));
    }
}
