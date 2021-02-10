package kh.java.control;

public class StarTest {
	public void star1() {
		for(int i=0;i<5;i++) {
			System.out.print("*");
		}
	}
	public void star2() {
		for(int i=0;i<5;i++) {
			System.out.println("*");
		}
	}
	public void star3() {
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void star4() {
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				System.out.printf("%d",i);
			}
			System.out.println();
		}
	}
	public void star5() {
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				System.out.printf("%d",j);
			}
			System.out.println();
		}
	}
	public void star6() {
		for(int i=1;i<=5;i++) {
			for(int j=0;j<5;j++) {
				System.out.printf("%d",j+i);
			}
			System.out.println();
		}	
	}
	public void star7() {
		for(int i=5;i>0;i--) {
			for(int j=0;j<5;j++) {
				System.out.printf("%d",j+i);
			}
			System.out.println();
		}
	}
	public void star8() {
		for(int i=0;i<5;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void star9() {
		for(int i=0;i<5;i++) {
			for(int j=5;j>i;j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void star10() {
		for(int i=0;i<5;i++) {
			for(int j=0;j<i;j++) {
				System.out.print(" ");
			}
			for(int j=5;j>i;j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void star11() {
		for(int i=0;i<5;i++) {
			for(int j=5;j>i;j--) {
				System.out.print(" ");
			}
			for(int j=0;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void star12() {
		for(int i=0;i<10;i++) {
			if(i<5) {
				for(int j=0;j<=i;j++) {
					System.out.print("*");
				}
			}
			if(i>=5) {
				for(int j=9;j>i;j--) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	public void star13() {
		for(int i=0;i<9;i++) {
			if(i<5) {
				for(int j=5;j>i;j--) {
					System.out.print("*");
				}
			}
			if(i>=5) {
				for(int j=0;j<=i-4;j++) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	///
	public void star16() {
		for(int i=0;i<5;i++) {
			for(int j=4;j>i;j--) {
				System.out.print(" ");
			}
			for(int j=0;j<=i*2;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void star17() {
		for(int i=0;i<5;i++) {
			for(int j=0;j<i;j++) {
				System.out.print(" ");
			}
			for(int j=5*2-1;j>i*2;j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void star18() {
		for(int i=0;i<9;i++) {
			if(i<5) {
				for(int j=4;j>i;j--) {
					System.out.print(" ");
				}
				for(int j=0;j<=i*2;j++) {
					System.out.print("*");
				}
			}
			if(i>=5) {
				for(int j=0;j<i-4;j++) {
					System.out.print(" ");
				}
				for(int j=9*2-1;j>i*2;j--) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	///
	public void star19() {
		for(int i=0;i<9;i++) {
			if(i<5) {
				for(int j=5;j>i;j--) {
					System.out.print("*");
				}			
				for(int j=0;j<=i*2;j++) {
					System.out.print(" ");
				}
				for(int j=5;j>i;j--) {
					System.out.print("*");
				}
			}
			if(i>=5) {
				for(int j=5;j<=i+1;j++) {
					System.out.print("*");
				}
				for(int j=9*2-1;j>i*2;j--) {
					System.out.print(" ");
				}
				for(int j=5;j<=i+1;j++) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	public void star20() {
		for(int i=1;i<=10;i++) {
			if(i<=5) {
				for(int j=1;j<=i;j++) {
					System.out.print("*");
				}
				for(int j=9-i+1;j>=i;j--) {
					System.out.print(" ");
				}
				for(int j=1;j<=i;j++) {
					System.out.print("*");
				}
			}
			if(i>5) {
				for(int j=10;j>i;j--) {
					System.out.print("*");
				}
				if(i!=10) {
					for(int j=5*2-i;j<=i;j++) {
						System.out.print(" ");
					}
				}
				for(int j=10;j>i;j--) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	public void star21() {
		for(int i=1;i<=10;i++) {
			if(i<=5) {
				for(int j=1;j<=i;j++) {
					System.out.print(" ");
				}
				for(int j=9-i+1;j>=i;j--) {
					System.out.print("*");
				}
			
			}
			if(i>5) {
				for(int j=10;j>i;j--) {
					System.out.print(" ");
				}
				if(i!=10) {
					for(int j=5*2-i;j<=i;j++) {
						System.out.print("*");
					}
				}
				
			}
			System.out.println();
		}
	}
}
