package com.axis.dbconnection

import java.sql.DriverManager


fun main(args: Array<String>){
    val myurl = "jdbc:mysql://localhost:3306/kotlindb"
    val connection=DriverManager.getConnection(myurl,"root","R@ksha19")
    println("connection establish successfully")

    //delete

    val stmt = connection.createStatement()
    val delete_res=stmt.executeUpdate("delete from users where id = 2")
    if( delete_res > 0){
        println("successfully updated record in users db !!!")
        println("$delete_res rows deleted!!")
    } else{
        println("Update Not successful")
    }
}
