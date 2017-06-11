public class DrawingTriangle {
	public static void main(String[] args){
		int SIZE = 5;
		int count = 0;
      while (count < SIZE){
			int col = 0;
			while( col <= count ){
				System.out.print("*");
				col = col + 1;
			}
			System.out.println();
			count = count + 1;
		}
	}
}