package com.axis.dbconnection

import java.sql.DriverManager
import java.util.Scanner


fun main(args: Array<String>){

    var scan=Scanner(System.`in`)

    print("Enter user Id: ")
    var id=scan.nextInt()
    print("Enter User Name: ")
    var name=scan.next()

    val myurl = "jdbc:mysql://localhost:3306/kotlindb"
    val connection=DriverManager.getConnection(myurl,"root","R@ksha19")
    println("connection establish successfully")

    val prestmt=connection.prepareStatement("insert into users values(?,?)")
    //prestmt.setInt(1,3)
    //prestmt.setString(2,"Sanvi")

    prestmt.setInt(1,id)
    prestmt.setString(2,name)
    val result=prestmt.executeUpdate()

    if(result>0){
        println("Inserted")
    }else{
        println("Not Inserted")
    }
}
