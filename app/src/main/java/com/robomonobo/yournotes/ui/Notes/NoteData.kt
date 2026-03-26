package com.robomonobo.yournotes.ui.Notes

import android.text.format.DateFormat
import com.google.android.material.tabs.TabLayout
import com.google.android.material.textfield.TextInputEditText

data class NoteData(
    var dateEdited: DateFormat = DateFormat(),
    var dateModified: DateFormat = DateFormat(),
    var headerText: String = "",
    var bodyText: String = "",
    var customHeaderText: String = "",
    var noteSettings: NoteSettingData = NoteSettingData()
)
{
    data class NoteSettingData(
        val cornerSmoothnessWeight: Int = 50
    )

    companion object NoteDataList
    {
        lateinit var tabList: ArrayList<TabLayout.Tab>
        lateinit var noteDataList: ArrayList<NoteData>

        var currentTabIndex = 0
        lateinit var noteHeaderText: TextInputEditText
        lateinit var noteBodyText: TextInputEditText
        lateinit var defaultNoteSettings: NoteSettingData
    }

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
        return "Uh Oh - Display Text Is Broken"
    }

}