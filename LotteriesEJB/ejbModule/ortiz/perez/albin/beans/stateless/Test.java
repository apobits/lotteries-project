/**
 * 
 */
package ortiz.perez.albin.beans.stateless;

/**
 * @author Administrador
 *
 */
public class Test {

	public boolean sleepIn(boolean weekday, boolean vacation) {
		if ((!weekday && !vacation) || (!weekday && vacation) || (weekday && vacation)) {
			return true;
		}
		return false;
	}

	public String lol() {
		System.out.println("lol");
		return "";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int a[][][] = {
//				{ { 1, 1, 1, 1, 1, 1 }, { 2, 2, 2, 2, 2, 2 }, { 3, 3, 3, 3, 3, 3 }, { 4, 4, 4, 4, 4, 4 },
//						{ 5, 5, 5, 5, 5, 5 }, { 6, 6, 6, 6, 6, 6 } },
//				{ { 1, 1, 1, 1, 1, 1 }, { 2, 2, 2, 2, 2, 2 }, { 3, 3, 3, 3, 3, 3 }, { 4, 4, 4, 4, 4, 4 },
//						{ 5, 5, 5, 5, 5, 5 }, { 6, 6, 6, 6, 6, 6 } } };
//
//		for (int i = 0; i < 2; i++) {
//			for (int j = 0; j < 6; j++) {
//				for (int k = 0; k < 6; k++) {
//					System.out.print(a[i][j][k]);
//				}
//				System.out.println();
//			}
//			System.out.println();
//		} 00000001 00000010
//		int x = 0;
//		for(int i= 0;i<15;i++){
//			x+=(Math.pow(2, i));
//		}
//		System.out.println(x);
//		
//		System.out.println(123_456);
//		
//		System.out.println(1<<2);
		int a = 1, b = 0;
		if((a/1== 0)&(a/b==1)){
			
		}
	}

}
