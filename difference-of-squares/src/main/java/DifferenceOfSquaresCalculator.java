class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
	   int sum=0;
       for (int i=1;i<=input;i++)
		   sum+=i;
	   
	   return (int)Math.pow(sum,2);   
    }

    int computeSumOfSquaresTo(int input) {
		int sum=0;
		for(int i=1;i<=input;i++)
			sum+=Math.pow(i,2);
		
		return sum;
    }

    int computeDifferenceOfSquares(int input) {
		return (int)computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);  
    }

}
