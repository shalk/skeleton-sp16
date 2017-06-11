public class ClassNameHere {
	public static int max(int[] m) {
		int count = m.length;
		int max = m[0];
		int index = 0 ;
		while (index < count) {
			if (m[index] > max) {
				max = m[index];
			}
			index = index + 1;
		}
		return max;
	}
	public static void main(String[] args) {
		int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
		System.out.println(max(numbers));
	}
}