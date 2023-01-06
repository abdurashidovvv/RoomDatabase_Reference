package com.abdurashidov.roomreference.db
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class MyCard {

    @PrimaryKey(autoGenerate = true)
    var id:Int?=null

    var name:String?=null
    var number:String?=null

    constructor(name: String?, number: String?) {
        this.name = name
        this.number = number
    }

    constructor()


}