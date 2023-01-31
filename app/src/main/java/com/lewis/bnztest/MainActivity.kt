package com.lewis.bnztest

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.lewis.bnztest.ui.school.RecordUio
import com.lewis.bnztest.ui.theme.BNZTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        setup()
        setContent {
            BNZTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AllSchools(viewModel)
                }
            }
        }

    }

    private fun setup() {
        lifecycleScope.launchWhenResumed {
            viewModel.loadSchoolData(
                applicationContext.getString(R.string.resource_id),
                limit = applicationContext.getString(R.string.limit)
            )

        }
    }

}

// Separation of component rather than bundled into one class
// PreviewParameterProvider with pros & cons
// UI states for loading & display results
// As UI implementation can vary depending on the use case, thus putting everything in activity

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AllSchools(viewModel: MainActivityViewModel) {
    var schoolList = viewModel.schoolList.observeAsState().value ?: emptyList()
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                title = { Text(stringResource(R.string.app_name)) }
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(schoolList) { school ->
                SchoolCard(school)
            }
        }
    }
}

@Composable
fun SchoolCard(school: RecordUio) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = school.schoolID.toString(),
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface,
            )
            Text(
                text = school.orgName.toString(),
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface,
            )
            Text(
                text = school.telephone.toString(),
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface,
            )
            Text(
                text = school.email.toString(),
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface,
            )
        }
    }
}