package com.axis.dbconnection

import java.sql.DriverManager

data class Product(val id:Int,val name:String,val price:Int)

fun main(args: Array<String>){
    val myurl = "jdbc:mysql://localhost:3306/kotlindb"
    val connection=DriverManager.getConnection(myurl,"root","R@ksha19")
    println("Connection establish successfully")

    //Create
    val stmt = connection.createStatement()
    stmt.execute("create table product(id int,name varchar(25),price int);")
    print("Table Created")

    //insert
    //val stmt=connection.createStatement()
    val res=stmt.executeUpdate("insert into product values(1,'Laptop',50000)")

    if (res > 0) {
        println("successfully inserted record into users db !!!")
    } else {
        println("Insert Not successful")
    }

    //retrieve
    val query = connection.prepareStatement("select * from product")
    val result = query.executeQuery()//whenever we want retrieve we use execute query
    val product = mutableListOf<Product>()

    while(result.next()){
        val id = result.getInt("id")
        val name = result.getString("name")
        val price=result.getInt("price")
        product.add(Product(id, name, price))
    }

    for(products in product){
        println(products)
    }
}
