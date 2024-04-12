
public class MultidimentionalArray 
{
	
	public static void main(String[] args) {
		
		////a[row][coloum]


		int a[][] = new int[2][3];
		a[0][0]=2;
		a[0][1]=4;
		a[0][2]=5;
		a[1][0]=3;
		a[1][1]=4;
		a[1][2]=7;
		//System.out.println(a[1][0]);
		/*int b[][]= {‌{2,4,5},{3,4,7},{5,2,1}};
		System.out.println(b[2][1]);*/

		for(int i=0;i<2;i++) // this for loop is to iterate the row
		{

			for(int j=0;j<3;j++) // this is for column
			{

				System.out.print(a[i][j]);
				
				System.out.print("\t");
			}
		//	System.out.println("");
			System.out.println(" ");
		}

	}

		

}
