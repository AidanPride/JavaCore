package adapter.math.v2.calc;


import adapter.math.Arifmetika;

public class Adapter extends Arifmetika implements Calculator{


    @Override
    public int summa(int a, int b) {
        return summa(new int[] {a,b});
    }
    @Override
    public int multiply(int a, int b) {
        return multiply(a,b);
    }

}
