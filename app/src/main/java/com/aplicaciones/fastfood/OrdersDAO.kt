package com.aplicaciones.fastfood

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface OrdersDAO {
    @Query("SELECT * FROM orders")
    fun getAll(): LiveData<List<Order>>

    @Query("SELECT*FROM orders WHERE idOrder = :id")
    fun get(id:Int): LiveData<Order>

    @Insert
    fun insertAll(vararg orders: Order)

    @Update
    fun update(order:Order)

    @Delete
    fun delete(order: Order)
}