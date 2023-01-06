package com.abdurashidov.roomreference.db

import android.annotation.SuppressLint
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.*

@Entity
class MyTransaction {

    @PrimaryKey(autoGenerate = true)
    var id:Int?=null

    var from_card_id:Int?=null
    var to_card_id:Int?=null
    var summa:String?=null
    @SuppressLint("SimpleDateFormat")
    var date= SimpleDateFormat("yyyy.MM.dd HH.mm.ss").format(Date())

    constructor(from_card_id: Int?, to_card_id: Int?, summa: String?) {
        this.from_card_id = from_card_id
        this.to_card_id = to_card_id
        this.summa = summa
    }

    constructor()
}



