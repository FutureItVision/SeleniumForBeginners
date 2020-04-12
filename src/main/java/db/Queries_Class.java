package db;

public class Queries_Class {
    public static  String workerInfo(){
        String q="Select * from `Worker_Info` where name='Khan'";
        return q;

    }
    public static  String workerInfoById(){
        String q="Select * from `Worker_Info` where id=12345";
        return q;

    }
}
