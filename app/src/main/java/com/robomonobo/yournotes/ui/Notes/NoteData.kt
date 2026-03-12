package com.robomonobo.yournotes.ui.Notes

import android.text.format.DateFormat
data class NoteData(var date: DateFormat = DateFormat(),
                    var headerText: String = "",
                    var bodyText: String = "",
                    var customHeaderText: String = "",
                    var noteSettings: NoteSettingData = NoteSettingData()
)
{

    data class NoteSettingData(val cornerSmoothnessWeight: Int = 50)

    fun getNoteDisplayText(): String {
        if (customHeaderText!="")
        {
            return this.customHeaderText!!
        }
        else if (headerText!="")
        {
            return headerText!!.substring(0,10)
        }
        else if (bodyText!=""){
            return bodyText!!.substring(0,10)
        }
        return "Uh Oh"
    }

}