package org.example;

public class SymbolTable {
    private int size;
    private HashTable<Integer> integerHashTable;
    private HashTable<String> stringHashTable;

    private HashTable<String> identifierHashTable;

    public SymbolTable(int size){
        this.size=size;
        this.identifierHashTable = new HashTable<>(size);
        this.integerHashTable = new HashTable<>(size);
        this.stringHashTable = new HashTable<>(size);
    }

    public Pair<Integer,Integer> addIdentifier(String name) throws Exception {
        return identifierHashTable.add(name);
    }
    public Pair<Integer,Integer> addString(String name) throws Exception {
        return stringHashTable.add(name);
    }
    public Pair<Integer,Integer> addInteger(Integer name) throws Exception {
        return integerHashTable.add(name);
    }
    public boolean hasIdentifier(String name) {
        return identifierHashTable.contains(name);
    }

    public boolean hasIntConstant(int constant) {
        return integerHashTable.contains(constant);
    }

    public boolean hasStringConstant(String constant) {
        return stringHashTable.contains(constant);
    }

    public Pair<Integer, Integer> getPositionIdentifier(String name) {
        return identifierHashTable.getPosition(name);
    }

    public Pair<Integer, Integer> getPositionIntConstant(int constant) {
        return integerHashTable.getPosition(constant);
    }

    public Pair<Integer, Integer> getPositionStringConstant(String constant) {
        return stringHashTable.getPosition(constant);
    }

    @Override
    public String toString() {
        return "SymbolTable:"+
                "\nInteger Hash Table:"+integerHashTable+
                "\nString Hash Table"+stringHashTable+
                "\nIdentifier Hash Table"+identifierHashTable;
    }
}
