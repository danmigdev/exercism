class CalculatorConundrum {
    
    public String calculate(int operand1, int operand2, String operation) {
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        }
        else if (operation.equals("")) {
            throw new IllegalArgumentException("Operation cannot be empty");
        }
        
        switch (operation) {
            case "+":
                return String.format("%d %s %d = %d", operand1, operation, operand2, operand1 + operand2);

            case "*":
                return String.format("%d %s %d = %d", operand1, operation, operand2, operand1 * operand2);

            case "/":
                try {
                    return String.format("%d %s %d = %d", operand1, operation, operand2, operand1 / operand2);
                }
                catch (ArithmeticException ex) {
                    throw new IllegalOperationException("Division by zero is not allowed", ex);
                }

            default:
                throw new IllegalOperationException(String.format("Operation '%s' does not exist", operation));
        }
    }
    
}
