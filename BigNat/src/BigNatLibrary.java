public class BigNatLibrary {

  static int max = 10; //for testing purposes this number is small

  public static void main(String[] args) {
    char[] a =  {'2'};
    System.out.println(areDigits(a));
  }
  static boolean areDigits(char[] cs) {
    //replace stub code
    int tmp;
    for(tmp=0;tmp<cs.length;tmp++)
    {
      if(cs[tmp] > '9' || cs[tmp] < '0' )
        return false;
    }
    return true;
  }

  public static boolean areEqual(int[] a, int[] b) {
    if(a.length!=b.length)
      return false;
    else
      for(int i = 0; i<a.length;i++)
      {
        if (a[i] != b[i])
          return false;
      }
    return true;
  }

  public static boolean isGreater(int[] a, int[] b) {
    //replace stub code
    if (a.length == b.length)
      for(int i = 0;i<a.length;i++)
      {
        if(a[i] > b[i])
          return true;
      }
    else
      if(a.length > b.length)
        return true;
      else
        return false;
    return false;
  }

  public static int[] init() {
    int[] result = new int[max];
    for (int i = 0; i < max; i++) {
      result[i] = 0;
    }
    return result;
  }

  public static int[] read() {
    String s = IOUtil.readString();
    char[] cs = s.toCharArray();
    assert (cs.length < max) : "input number too large";
    assert (areDigits(cs)) : "non-numeric character input";
    int[] result;
    result = new int[cs.length];
    for (int i = 0; i < s.length(); i++)
      result[i] = cs[i] - '0';
    return result;
  }

  public static void print(int[] a) {
    assert (a[0] > 0) : "must be at least one digit";
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i]);
    }
  }

  public static int[] reverse(int[] a) {
    //replace stub code
    int[] reversed;
    reversed = new int [a.length];
    for(int i = 0; i<a.length;i++)
      reversed[i] = a[a.length-i-1];
    return reversed;
  }

  public static int[] intToBigNat(int n) {
    //replace stub code
    int[] a;
    int tmpCounter = 0;
    int nDigits = (int)Math.log10((float)n)+1;
    a = new int [nDigits];
    while(n!=0)
    {
      a[nDigits-tmpCounter-1] = n % 10;
      tmpCounter ++;
      n /= 10;
    }
    return a;
  }

  public static int[] add(int[] a, int[] b) {
    //replace stub code
    int[] m_a = toFull(a);
    int[] m_b = toFull(b);
    int[] m_result;
    int tmp,toNext=0;
    m_result = new int[max];
    for(int i=0;i<max;i++)
    {
      tmp = m_a[max-i-1] + m_b[max-i-1] + toNext;
      toNext = 0;
      if(tmp>=10) {
        toNext = 1;
        tmp -= 10;
      }
      m_result[max-i-1] = tmp;
    }

    return (removeZero(m_result));
  }

  public static int[] sub(int[] a, int[] b) {
    //replace stub code
    assert (isGreater(b,a)) : "Second is larger than the first!";
    int[] m_a = toFull(a);
    int[] m_b = toFull(b);
    int[] m_result;
    m_result = new int[max];
    int tmp,toNext=0;
    for(int i=0;i<max;i++)
    {
      if((m_a[max-i-1]-toNext)<m_b[max-i-1]){
        tmp = m_a[max-i-1] + 10 - m_b[max-i-1] -toNext;
        toNext = 1;
      }
      else {
        tmp = m_a[max - i - 1] - toNext - m_b[max - i - 1];
        toNext = 0;
      }
      m_result[max-i-1] = tmp;
    }
    return (removeZero(m_result));
  }

  public static int[] fib(int[] n) {
    //replace stub code
      int[] tmp1 = {0},tmp2= {1},tmp3={2};
      if(areEqual(toFull(n),toFull(tmp2)) || areEqual(toFull(n),toFull(tmp3)))
          return (toFull(tmp2));
      else
          return (add(fib(sub(n,tmp2)),fib(sub(n,tmp3))));
  }
  public static int[] mul(int[] a,int[] b){
    int[] result = {0};
    int subAmount = 1;
    while(!areEqual(toFull(b),init())){
        result = add(result,a);
        b = sub(b,intToBigNat(subAmount));
    }
    return result;
  }
  public static int[] toFull(int[] a){
    int[] toReturn;
    toReturn = new int[max];
    for(int i=0;i<max;i++)
    {
      toReturn[i] = 0;
    }
    for(int j=0;j<a.length;j++)
    {
      toReturn[max-j-1] = a[a.length-j-1];
    }
    return toReturn;
  }
  public static int[] removeZero(int[] a)
  {
    int[] toReturn;
    int i=0;
    while(a[i]==0 && i<max-1)
      i++;
    toReturn = new int [max-i];
    for(int j=0;i<a.length;i++){
      toReturn[j] = a[i];
      j++;
    }
    return toReturn;

  }
}
