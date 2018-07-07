package com.sudhir.innerclass;

public class InnerClassExample {

	public static void main(String[] args) {
		abc a = new xyz().m1();
		a.disp();

	}

}
interface abc{
	void disp();
} 
class xyz{
	static abc m1(){
		abc ab = new abc() {
			
			@Override
			public void disp() {
				System.out.println("in anonymous inner class");
				
			}
		};
		return ab;
	}
}