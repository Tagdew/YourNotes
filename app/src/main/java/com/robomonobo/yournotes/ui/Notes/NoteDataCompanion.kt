package com.robomonobo.yournotes.ui.Notes

import com.google.android.material.textfield.TextInputEditText

class NoteDataCompanion {

    companion object NoteDataList
    {
        lateinit var noteDataList: ArrayList<NoteData>
        lateinit var noteHeaderText: TextInputEditText
        lateinit var noteBodyText: TextInputEditText
    }
}