import java.util.*;

class Solution {
      public char[][] rotateMatrix(char a[][]){
        //Write your code here        
		  //https://course.acciojob.com/idle?question=f2366ea2-c1b5-4b49-9557-0d7c47964933
		  for(int i = 0;i<a.length;i++){
			  int[] diffarr = new int[a[0].length];
			  int diff = 0;
			  for(int j = a[0].length-1;j>=0;j--){
				  if(a[i][j] == '#'){
					  diffarr[j] = diff;
				  }else if(a[i][j] == '.'){
					  diff++;
					  diffarr[j] = diff;
				  }else if(a[i][j] == '*'){
					  diff = 0;
					  diffarr[j] = diff;
				  }
			  }

			  for(int j = a[0].length-1;j>=0;j--){
				  if(a[i][j] == '#'){
					  a[i][j] = '.';
					  a[i][j+diffarr[j]] = '#';
				  }
			  }
		  }

		  char[][] res = new char[a[0].length][a.length];

		  for(int i = 0 , rj = res[0].length-1 ; i<a.length ; i++,rj--){
				  for(int j = 0, ri = 0 ; j<a[0].length ; j++,ri++){
				  res[ri][rj] = a[i][j];
			  }
		  }
		  return res;
         
    }   

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M= sc.nextInt();
        int N= sc.nextInt();
        char Matrix[][] = new char[M][N];

        sc.nextLine();

        for(int i=0; i<M; i++){
            String S= sc.nextLine();
            int k=0;
            for(int j= 0; j<S.length(); j++)
                if(S.charAt(j)!=' ')
                    Matrix[i][k++]=S.charAt(j);
            
        }

        Solution obj = new Solution();
        Matrix= obj.rotateMatrix(Matrix);

        for(int i=0; i< Matrix.length; i++){
            for(int j=0; j<Matrix[0].length; j++)
                System.out.print(Matrix[i][j]+" ");
            
            System.out.println("");
        }
    }
}