package LastRun6.Graph;

import java.util.*;

class AccountDisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public AccountDisjointSet(int n) {
        for (int i = 0; i < n; i++) {
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) return node;

        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp); // Path compression
        return ulp;
    }

    public void unionByRank(int u, int v) {
        int pu = findUPar(u);
        int pv = findUPar(v);

        if (pu == pv) return;

        if (rank.get(pu) < rank.get(pv)) {
            parent.set(pu, pv);
        } else if (rank.get(pv) < rank.get(pu)) {
            parent.set(pv, pu);
        } else {
            parent.set(pv, pu);
            rank.set(pu, rank.get(pu) + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int pu = findUPar(u);
        int pv = findUPar(v);

        if (pu == pv) return;

        if (size.get(pu) < size.get(pv)) {
            parent.set(pu, pv);
            size.set(pv, size.get(pv) + size.get(pu));
        } else {
            parent.set(pv, pu);
            size.set(pu, size.get(pu) + size.get(pv));
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        AccountDisjointSet ds = new AccountDisjointSet(n);

        Map<String, Integer> map = new HashMap<>();

        // Step 1: Union accounts with same emails
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);

                if (!map.containsKey(mail)) {
                    map.put(mail, i);
                } else {
                    ds.unionBySize(i, map.get(mail));
                }
            }
        }

        // Step 2: Group emails by parent
        List<List<String>> merged = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            merged.add(new ArrayList<>());
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String mail = entry.getKey();
            int parent = ds.findUPar(entry.getValue());
            merged.get(parent).add(mail);
        }

        // Step 3: Prepare final answer
        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (merged.get(i).isEmpty()) continue;

            Collections.sort(merged.get(i));

            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0)); // Name

            temp.addAll(merged.get(i));
            ans.add(temp);
        }

        return ans;
    }
}

public class mergerAccount_graph {
    public static void main(String[] args) {
        Solution sol = new Solution();

        List<List<String>> accounts = new ArrayList<>();

        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        accounts.add(Arrays.asList("Mary", "mary@mail.com"));
        accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));

        List<List<String>> result = sol.accountsMerge(accounts);

        // Print output
        System.out.println("Merged Accounts:");
        for (List<String> acc : result) {
            System.out.println(acc);
        }
    }
}