package org.example;

import java.util.ArrayList;

public class HashTable<T> {
    private ArrayList<ArrayList<T>> tableItems;
    private int size;

    public HashTable(int size){
        this.size=size;
        tableItems=new ArrayList<>();
        for(int i=0;i<size;i++)
            tableItems.add(new ArrayList<>());
    }

    public int hash(int key){
        return key%size;
    }
    public int hash(String key){
        int sum=0;
        for(int i=0;i<key.length();i++)
        {
            sum+=key.charAt(i);
        }
        return sum%size;
    }
    public int getHash(T key)
    {
        int hashVal=-1;
        if(key instanceof Integer)
        {
            hashVal=hash((int) key);
        } else if (key instanceof String) {
            hashVal=hash((String) key);
        }
        return hashVal;
    }
    public Pair<Integer,Integer> add(T key) throws Exception{
        int hashVal=getHash(key);
        if(!tableItems.get(hashVal).contains(key)){
            tableItems.get(hashVal).add(key);
            return new Pair<>(hashVal,tableItems.get(hashVal).indexOf(key));
        }
        throw new Exception("Key "+key+" already exists in table");
    }

    public boolean contains(T key){
        int hashVal=getHash(key);
        return tableItems.get(hashVal).contains(key);
    }
    public Pair<Integer,Integer> getPosition(T key){
        if(this.contains(key)){
            int hashVal=getHash(key);
            return new Pair<>(hashVal,tableItems.get(hashVal).indexOf(key));
        }
        return new Pair<>(-1,-1);
    }
    @Override
    public String toString(){
        return "HashTable{ "+tableItems+" }";
    }
}
