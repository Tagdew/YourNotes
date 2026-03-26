package com.robomonobo.yournotes.listeners

import android.text.Editable
import android.text.TextWatcher
import com.robomonobo.yournotes.ui.Notes.NoteData

class HeaderInputListener : TextWatcher{

    override fun afterTextChanged(headerTextInput: Editable?) {
        if (NoteData.noteHeaderText.isFocused) NoteData.noteDataList[NoteData.currentTabIndex].headerText=headerTextInput.toString()
    }

    override fun beforeTextChanged(sequence: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(sequence: CharSequence?, start: Int, before: Int, count: Int) {}
}

class BodyInputListener : TextWatcher{

    override fun afterTextChanged(bodyTextInput: Editable?) {

        if (NoteData.noteBodyText.isFocused) NoteData.noteDataList[NoteData.currentTabIndex].bodyText=bodyTextInput.toString()
    }

    override fun beforeTextChanged(sequence: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(sequence: CharSequence?, start: Int, before: Int, count: Int) {}
}