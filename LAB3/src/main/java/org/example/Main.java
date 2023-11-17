package org.example;

import org.example.FiniteAutomata.FiniteAutomata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
//        SymbolTable symbolTable = new SymbolTable(47);
//        Pair<Integer, Integer> p1;
//        Pair<Integer, Integer> p2;
//        Pair<Integer, Integer> p3;
//        try {
//            p1 = symbolTable.addIdentifier("abc");
//            System.out.println("abc -> " + p1);
//            System.out.println("c -> " + symbolTable.addIdentifier("c").toString());
//            System.out.println("a -> " + symbolTable.addIdentifier("a").toString());
//            System.out.println("bc -> " + symbolTable.addIdentifier("bc").toString());
//            System.out.println("ba -> " + symbolTable.addIdentifier("ba").toString());
//
//            System.out.println("2 -> " + symbolTable.addInteger(2).toString());
//            System.out.println("3 -> " + symbolTable.addInteger(3).toString());
//            p2 = symbolTable.addInteger(100);
//            System.out.println("100 -> " + p2);
//            System.out.println("20 -> " + symbolTable.addInteger(20).toString());
//            System.out.println("131 -> " + symbolTable.addInteger(131).toString());
//            System.out.println("49 -> " + symbolTable.addInteger(49).toString());
//            System.out.println("96 -> " + symbolTable.addInteger(96).toString());
//
//            System.out.println("string1 -> " + symbolTable.addString("string1").toString());
//            System.out.println("another -> " + symbolTable.addString("another").toString());
//            System.out.println("lab -> " + symbolTable.addString("lab").toString());
//            System.out.println("hello -> " + symbolTable.addString("hello").toString());
//            p3 = symbolTable.addString("world");
//            System.out.println("world -> " + p3);
//
//            System.out.println("abc -> " + symbolTable.addIdentifier("abc").toString());
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//        System.out.println(symbolTable);

//            Scanner scanner = new Scanner();
//            String program1 = "p1.in";
//            String program2 = "p2.in";
//            String program3 = "p3.in";
//            String program1err = "p1err.in";
//            scanner.scan(program1);
//            scanner.scan(program2);
//            scanner.scan(program3);
//            scanner.scan(program1err);
//    }
            var finite_automata = new FiniteAutomata("C:\\Users\\Ovidiu\\Desktop\\FLCD\\FLCD\\LAB3\\src\\main\\resources\\FA.in");
            System.out.println("1.Print states\n2.Print alphabet\n3.Print output states\n4.Print input states\n5.Print transitions\n6.Check word\n7.Get matching substring\n0.Exit\n");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader wordReader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                    System.out.print(">/");
                    var op = reader.readLine();
                    switch (op) {
                            case "0":
                                    return;
                            case "1":
                                    finite_automata.printStates();
                                    break;
                            case "2":
                                    finite_automata.printAlphabet();
                                    break;
                            case "3":
                                    finite_automata.printOutputStates();
                                    break;
                            case "4":
                                    finite_automata.printInitialState();
                                    break;
                            case "5":
                                    finite_automata.printTransitions();
                                    break;
                            case "6":
                                    var word = wordReader.readLine();
                                    System.out.println(finite_automata.checkAccepted(word));
                            case "7":
                                    word = wordReader.readLine();
                                    var acc = finite_automata.checkAccepted(word);
                                    if (Objects.equals(acc, " ")) {
                                            System.out.println("No matching substring");
                                    } else {
                                            System.out.println(acc);
                                    }
                                    break;
                            default:
                                    System.out.println("Invalid option");
                    }
            }
    }
}