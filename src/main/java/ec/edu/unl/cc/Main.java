package ec.edu.unl.cc;

import ec.edu.unl.cc.succession.business.EvenNumberCalculatorUpToLimit;
import ec.edu.unl.cc.succession.model.Printable;
import ec.edu.unl.cc.succession.model.Successionable;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el limite de la serie: de numeros pares");
        int limit = input.nextInt();

        Successionable serie = new EvenNumberCalculatorUpToLimit(limit);
        Number result = serie.calculate();
        System.out.println(((Printable)serie).print());
        System.out.println("S =  " + result);



    }
}