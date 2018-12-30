package AudINtel;

public class Main {

	public static void main(String[] args) {
		new Solution().solution(1);
		A b  = new B();
		b.cal(10, 20);
		System.out.println(b.i);
	}

}

class A{
	int i=10;
	public void cal(int z,int x) {
		System.out.println("A");
	}
}
class B extends A{
	int a = 20;
	 public void cal(int z,int x) {
		System.out.println("B");
	}
}

class Solution {
    public void solution(int N){
        //
        // write your logic here and print the desired output
        //
        for(int i=0;i<N;i++){
            for(int j=i;j<N;j++)
                System.out.print(" ");
            if(i==0 || i==N-1)
                for(int j=0;j<N;j++)
                    System.out.print("*");
            else{
                for(int j=0;j<N;j++)
                    if(j==0 || j==N-1)
                        System.out.print("*");
                    else
                        System.out.print(" ");
            }       
            System.out.println();
        }
    }
}