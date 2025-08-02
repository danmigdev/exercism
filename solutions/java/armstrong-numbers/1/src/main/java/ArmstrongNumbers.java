class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {
        String numberToString = String.valueOf(numberToCheck);
        int exponent = numberToString.length();
        int armstrongNumber = 0;
        
        for (int i = 0; i < numberToString.length(); i++) {
        	armstrongNumber += Math.pow(Character.getNumericValue(numberToString.charAt(i)), exponent);
        }

        return numberToCheck == armstrongNumber;
    }

}
