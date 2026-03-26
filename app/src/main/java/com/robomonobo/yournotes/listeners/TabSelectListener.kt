package com.robomonobo.yournotes.listeners

import android.widget.Toast
import androidx.compose.ui.text.TextLayoutInput
import com.google.android.material.tabs.TabLayout
import com.robomonobo.yournotes.MainActivity
import com.robomonobo.yournotes.ui.Notes.NoteData

class TabSelectListener : TabLayout.OnTabSelectedListener {
    override fun onTabSelected(tab: TabLayout.Tab?) {
        NoteData.currentTabIndex = tab!!.position

        val bodyText: String = NoteData.noteDataList[tab!!.position].bodyText
        NoteData.noteBodyText.setText(bodyText)

        val HeaderText: String = NoteData.noteDataList[tab!!.position].headerText
        NoteData.noteHeaderText.setText(HeaderText)
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {

    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
        println(NoteData.currentTabIndex)
        println("-")
        println("="+NoteData.noteHeaderText.toString())
        println("="+NoteData.noteBodyText.toString())
        println("-")
        println("="+NoteData.noteDataList[NoteData.currentTabIndex].headerText)
        println("="+NoteData.noteDataList[NoteData.currentTabIndex].bodyText)
        println("="+NoteData.noteDataList[NoteData.currentTabIndex].customHeaderText)
    }
}