package com.robomonobo.yournotes

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TableLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.Tab
import com.robomonobo.yournotes.databinding.ActivityMainBinding
import com.robomonobo.yournotes.ui.Notes.NoteData
import java.io.File

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
        var noteDataList = ArrayList<NoteData>()
        noteDataList.add(NoteData(headerText = "ThisHeaderText"))
        noteDataList.add(NoteData(bodyText = "ThisBodyText"))
        noteDataList.add(NoteData(customHeaderText = "ThisIsACustomHeaderText"))

        val bottomBarTabLayout: TabLayout = findViewById<TabLayout>(R.id.Bottom_Bar_Tab_Layout)

        for (thisNoteData in noteDataList)
        {
            bottomBarTabLayout.addTab(bottomBarTabLayout.newTab().setText(thisNoteData.getNoteDisplayText()))
        }

        val noteAppTopToolbar: Toolbar = binding.NoteAppTopToolbar

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        val appBarConfiguration = AppBarConfiguration(appBarNavigationArray)
        setSupportActionBar(noteAppTopToolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)

    }
}