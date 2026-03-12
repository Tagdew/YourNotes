package com.robomonobo.yournotes.listeners

import android.widget.Toast
import androidx.compose.ui.text.TextLayoutInput
import com.google.android.material.tabs.TabLayout
import com.robomonobo.yournotes.MainActivity
import com.robomonobo.yournotes.ui.Notes.NoteData
import com.robomonobo.yournotes.ui.Notes.NoteDataCompanion

class TabSelectListener : TabLayout.OnTabSelectedListener {
    override fun onTabSelected(tab: TabLayout.Tab?) {
        val bodyText: String = NoteDataCompanion.noteDataList.get(tab!!.position).bodyText
        NoteDataCompanion.noteBodyText.setText(bodyText)
        val HeaderText: String = NoteDataCompanion.noteDataList.get(tab!!.position).headerText
        NoteDataCompanion.noteHeaderText.setText(HeaderText)
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {

    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
    }
}