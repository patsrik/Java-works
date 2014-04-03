package javatests;

public class ArrayRev {

	public char[] reverseArray(char[] chararray){
		
		if(chararray != null){
			int i=0,j=chararray.length-1;
			char temp;
			for(i=0;i<chararray.length/2;i++,j--){
				temp = chararray[i];
				chararray[i] = chararray[j];
				chararray[j] = temp;
			}
			
			for(char a : chararray){
				System.out.print(a + " ");
			}
		}
		
		return chararray;
	}
}
