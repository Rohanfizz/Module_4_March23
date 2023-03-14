class Solution {
    public List<List<Integer>> fourSum(int[] a, int target) {
        Arrays.sort(a);
        List<List<Integer>> ans = new ArrayList<>();
    
        if(a.length < 4) return ans;
        int n = a.length;
        int i = 0;

        while(i<a.length){
            int j = i+1;
            while(j<a.length){
                
                long newTarget =1L* (target - ((long)(a[i] + a[j])));
                int left = j+1;
                int right = n-1;
                while(left<right){
                    long csum = (long)(a[left] + a[right]);

                    if(csum == newTarget){
                        List<Integer> cres = new ArrayList<>();
                        cres.add(a[i]);
                        cres.add(a[j]);
                        cres.add(a[left]);
                        cres.add(a[right]);
                        ans.add(cres);

                        left++;
                        while(left<n && a[left] == a[left-1]) left++;

                        right--;
                        while(right>=0 && a[right] == a[right+1]) right--;

                    }else if(csum < newTarget){
                        left++;
                        // while(left<n && a[left] == a[left-1]) left++;
                    }else{
                        right--;
                        // while(right>=0 && a[right] == a[right+1]) right--;
                    }
                }

                j++;
                while(j<n && a[j]==a[j-1]) j++;
            }
            i++;
            while(i<n && a[i]==a[i-1]) i++;
        }
        return ans;
    }
}