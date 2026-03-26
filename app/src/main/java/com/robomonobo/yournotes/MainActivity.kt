package com.robomonobo.yournotes

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.textfield.TextInputEditText
import com.robomonobo.yournotes.databinding.ActivityMainBinding
import com.robomonobo.yournotes.listeners.BodyInputListener
import com.robomonobo.yournotes.listeners.HeaderInputListener
import com.robomonobo.yournotes.listeners.TabSelectListener
import com.robomonobo.yournotes.ui.Notes.NoteData

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var appBarNavigationArray = setOf(
        R.id.navigation_note
    )

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Note Stuff test, deals with Function in NoteData

        val bottomBarTabLayout: TabLayout = findViewById<TabLayout>(R.id.Bottom_Bar_Tab_Layout)

        NoteData.noteHeaderText = findViewById<TextInputEditText>(R.id.NoteHeaderTextInput)
        NoteData.noteBodyText = findViewById<TextInputEditText>(R.id.NoteBodyTextInput)

        NoteData.noteDataList = ArrayList<NoteData>()
        NoteData.tabList = ArrayList<TabLayout.Tab>()

        NoteData.noteDataList.add(NoteData(headerText = "ThisHeaderText"))
        NoteData.noteDataList.add(NoteData(bodyText = "ThisBodyText"))
        NoteData.noteDataList.add(NoteData(customHeaderText = "ThisIsACustomHeaderText"))

        for (thisNoteData in NoteData.noteDataList)
        {
            NoteData.tabList.add(bottomBarTabLayout.newTab().setText(thisNoteData.getNoteDisplayText()))
        }

        for (thisTab in NoteData.tabList)
        {
            bottomBarTabLayout.addTab(thisTab)
        }

        NoteData.noteHeaderText.addTextChangedListener(HeaderInputListener())
        NoteData.noteBodyText.addTextChangedListener(BodyInputListener())
        bottomBarTabLayout.addOnTabSelectedListener(TabSelectListener())

        ////

        val noteAppTopToolbar: Toolbar = binding.NoteAppTopToolbar

        val navController = findNavController(R.id.navigation_host_fragment_note_app_activity)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        val appBarConfiguration = AppBarConfiguration(appBarNavigationArray)
        setSupportActionBar(noteAppTopToolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)

    }
}