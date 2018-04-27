class PrintFactors {
  public static List<List<Integer>> getFactors(int n) {
      List<List<Integer>> result = new ArrayList<>();
      if (n < 1) {
          return result;
      }
      // 1, n
      List<Integer> first = new ArrayList<>();
      first.add(1);
      first.add(n);
      result.add(first);
      List<Integer> list = new ArrayList<>();
      getFactors(result, list, n, 2); // starting from 2
      return result;
  }

  public static void getFactors(List<List<Integer>> result, List<Integer> list, int n, int start) {
      for (int i = start; i <= Math.sqrt(n); i++) {
          if (n % i == 0 && n / i >= i) {
              list.add(i);
              list.add(n / i);
              result.add(new ArrayList<Integer>(list));
              list.remove(list.size() - 1);
              getFactors(result, list, n / i, i);
              list.remove(list.size() - 1);
          }
      }
  }
}
