package com.example.contactsproject
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
class Contact() {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "contactID")
    var id: Int = 0

    @ColumnInfo(name = "contactName")
    var contactName: String? = null

    var phNumber: String? = null

    constructor(contactName: String, phNumber: String ) : this() {
        this.contactName = contactName
        this.phNumber = phNumber
    }

}