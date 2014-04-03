package javatests;

public class RepeatingNums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//array should contain numbers from 1 to n
		//any number can occur twice but not more than twice
		int inputArray[] = {1,2,3,2,3,4,5};
		int currentNum = 0;
		for(int i=0;i<inputArray.length;i++){
			currentNum = Math.abs(inputArray[i]);
			if(inputArray[currentNum] >= 0){
				inputArray[currentNum] = -inputArray[currentNum];
			}
			else{
				System.out.println(currentNum + "is repeating");
			}
		}
	}

}
