package com.axis.dbconnection

import java.sql.DriverManager


fun main(args: Array<String>){
    val myurl = "jdbc:mysql://localhost:3306/kotlindb"
    val connection=DriverManager.getConnection(myurl,"root","R@ksha19")
    println("connection establish successfully")

    //update

    val stmt = connection.createStatement()
    val update_res=stmt.executeUpdate("update users set name = 'Rohith' where id = 2")
    if( update_res > 0){
        println("successfully updated record in users db !!!")
        println("$update_res updated!!")
    } else{
        println("Update Not successful")
    }
}
