package com.abdurashidov.roomreference.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface MyDao {

    @Insert
    fun addCard(myCard: MyCard)

    @Query("select * from mycard")
    fun getAllCards():List<MyCard>

    @Insert
    fun addTransaction(myTransaction: MyTransaction)

    @Query("select * from mytransaction")
    fun getAllTransactions():List<MyTransaction>

    @Query("select * from mycard where id=:id")
    fun getCard(id:Int):MyCard

}