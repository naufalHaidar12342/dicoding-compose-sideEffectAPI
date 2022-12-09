package com.example.navigationsnackbarcompose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.navigationsnackbarcompose.ui.theme.NavigationSnackbarComposeTheme
import kotlinx.coroutines.launch

@Composable
fun NavDrawerComposeApp(){
    val scaffoldState= rememberScaffoldState()
    val scope= rememberCoroutineScope()
    val context= LocalContext.current
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopNavigation(
                onMenuClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        drawerContent = {
            Text(text = stringResource(id = R.string.hello_from_nav_drawer))
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Text(text = stringResource(id = R.string.hello_world))
        }
    }
}

@Composable
fun TopNavigation(onMenuClick:()->Unit){
    TopAppBar(
        navigationIcon = {
            IconButton(
                onClick = { onMenuClick() }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = stringResource(R.string.menu)
                )

            }
        },
        title = {
            Text(stringResource(R.string.app_name))
        },
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NavigationSnackbarComposeTheme {
        NavDrawerComposeApp()
    }
}