package org.example;

public class Main {
    public static void main(String[] args) {
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

            Scanner scanner = new Scanner();
            String program1 = "p1.in";
            String program2 = "p2.in";
            String program3 = "p3.in";
            String program1err = "p1err.in";
            scanner.scan(program1);
            scanner.scan(program2);
            scanner.scan(program3);
            scanner.scan(program1err);
    }
}