public class TestBigNats {

  public static void main(String[] args) {
    //make sure there are no new print statements in main
    printMenu();
    int order = IOUtil.readInt();
    switch (order){
      case 0 : System.exit(0);
      case 1 : addTest();main(args);
      case 2 : subTest();main(args);
      case 3 : mulTest();main(args);
      case 4 : fibTest();main(args);
      case 5 : helperTests();main(args);
      default : System.exit(0);
    }
  }

  public static void printMenu() {
    System.out.println("0: Quit");
    System.out.println("1: Add two numbers");
    System.out.println("2: Subtract the second number from the first number");
    System.out.println("3: Mul");
    System.out.println("4: Calculate a Fibonacci number using big numbers rather than integers");
    System.out.println("5. Test helper functions");
  }

  public static void addTest() {
    System.out.print("Please type in two big numbers -> ");
    BigNatLibrary.print(BigNatLibrary.add(BigNatLibrary.read(), BigNatLibrary.read()));

  }

  public static void subTest() {
    System.out.print("Please type in two big numbers -> ");
    BigNatLibrary.print(BigNatLibrary.sub(BigNatLibrary.read(), BigNatLibrary.read()));
    System.out.println();
  }
  public static void mulTest() {
    System.out.print("Please type in two big numbers -> ");
    BigNatLibrary.print(BigNatLibrary.mul(BigNatLibrary.read(), BigNatLibrary.read()));
    System.out.println();
  }
  public static void fibTest() {
    System.out.print("Which Fibonacci number do you want -> ");
    BigNatLibrary.print(BigNatLibrary.fib(BigNatLibrary.read()));
    System.out.println();
  }

  public static void helperTests() {
    int[] first;
    int[] second;
    int n = 0;
    System.out.print("Please type in two big numbers -> ");
    first = BigNatLibrary.read();
    second = BigNatLibrary.read();
    if (BigNatLibrary.areEqual(first, second)) {
      System.out.println("The numbers are equal.");
    } else {
      System.out.println("The numbers are not equal.");
    }
    if (BigNatLibrary.isGreater(first, second)) {
      System.out.println("The first number is greater than the second number.");
    } else {
      System.out.println("The first number is not greater than the second number.");
    }
    System.out.print("Reversing the first number gives  ");
    BigNatLibrary.print(BigNatLibrary.reverse(first));
    System.out.println();
    System.out.print("Please type in a positive integer to convert to a big natural number -> ");
    BigNatLibrary.print(BigNatLibrary.intToBigNat(IOUtil.readInt()));
    System.out.println();
  }
}
