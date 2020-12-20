package com.germanstuff.consumption;

import java.util.Locale;
import java.util.Scanner;

public class MeasuredValues {
  private double[] values;

  public MeasuredValues() {
    // values = new double[7];
    values = new double[6];
    values[0] = 3.1;
    values[1] = 3.9;
    values[2] = 5.3;
    values[3] = 6.1;
    values[4] = 6.8;
    values[5] = 6.8;
  }

  public MeasuredValues(int dim) {
    values = new double[dim];
    readIn();
  }

  private void readIn() {
    Scanner scan = new Scanner(System.in);
    scan.useLocale(Locale.ENGLISH);

    for (int iter = 0; iter != values.length; ++iter) {
      System.out.println("Valeur[" + iter + "]: ");
      values[iter] = scan.nextDouble();
    }
  }

  public void output() {
    for (double elt : values) {
      System.out.print(elt + "\t");
    }
  }

  public double[] getValues() {
    return values;
  }

  public double valueOfIndex(int index) {
    if (index >= 0 && index < values.length) {
      return values[index];
    } else {
      throw new IndexOutOfBoundsException();
      // return 0.0;
    }
  }

  public void setValues(int index, double newValue) {
    if (index >= 0 && index < values.length) {
      values[index] = newValue;
    } else {
      throw new IndexOutOfBoundsException();
    }
  }

  public double mArith() {
    double sum = 0.0;
    for (double elt : values) {
      sum += elt;
    }

    return sum / (double) values.length;
  }

  public double mGeom() {
    double product = 1.0;
    for (double elt : values) {
      product *= elt;
    }

    return Math.pow(product, 1.0 / (values.length));
  }

  public double variance() {
    double sum = 0.0;
    double nbElts = 0.0;

    for (double elts : values) {
      sum += Math.pow((elts - this.mArith()), 2);
      nbElts += 1;
    }

    return sum / nbElts;
  }

  public double stdabw() {
    return Math.sqrt(this.variance());
  }

  public boolean contains(double value) {
    boolean result = false;

    for (double elts : values) {
      if (elts == value) {
        result = true;
        break;
      }
    }

    return result;
  }

  public int frequency(double value) {
    int frequency = 0;
    for (double elts : values) {
      if (elts == value) {
        // ++frequency;

        frequency = frequency + 1;
        // frequency += 1;
      }
    }

    return frequency;
  }

  public static void main(String[] args) {
    MeasuredValues measures = new MeasuredValues();
    /*double[] values = measures.getValues();

    for (double elt : values) {
      System.out.println(elt);
    }

    measures.setValues(2,10.50);

    measures.output();

    System.out.println("\nArith mean: "+measures.mArith());
    System.out.println("\nGeom mean: "+measures.mGeom());

    System.out.println("elt[2]: " + measures.valueOfIndex(9));*/

    System.out.println("Arithm mean: " + measures.mArith());
    System.out.println("Geom mean: " + measures.mGeom());
    System.out.println("variance: " + measures.variance());
    System.out.println("deviation: " + measures.stdabw());
    System.out.println("contained?: " + measures.contains(3.9));
    System.out.println("frequency: " + measures.frequency(6.8));
  }
}
