package com.axis.dbconnection

import java.sql.DriverManager


fun main(args: Array<String>){
    val myurl = "jdbc:mysql://localhost:3306/kotlindb"
    val connection=DriverManager.getConnection(myurl,"root","R@ksha19")
    println("connection establish successfully")

    //insert query -Create
    val stmt = connection.createStatement()
    val res=stmt.executeUpdate("insert into users values(2,'Ananya')")

    if (res > 0) {
        println("successfully inserted record into users db !!!")
    } else {
        println("Insert Not successful")
    }
}
