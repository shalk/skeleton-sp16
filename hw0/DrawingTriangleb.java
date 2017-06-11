public class DrawingTriangleb {
   public static void drawTriangle(int N) {
		
		int count = 0;
      while (count < N){
			int col = 0;
			while( col <= count ){
				System.out.print("*");
				col = col + 1;
			}
			System.out.println();
			count = count + 1;
		}
   }
   public static void main(String[] args){
      drawTriangle(10);
	}
}