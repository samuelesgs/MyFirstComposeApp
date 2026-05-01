package com.saltwortdevs.myfirstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import com.saltwortdevs.myfirstcomposeapp.components.MyModalDrawer
import com.saltwortdevs.myfirstcomposeapp.components.animations.FullAnimateAsState
import com.saltwortdevs.myfirstcomposeapp.components.animations.MyAnimationVisibility
import com.saltwortdevs.myfirstcomposeapp.components.animations.MyCrossFade
import com.saltwortdevs.myfirstcomposeapp.components.navigation.NavigationWrapper
import com.saltwortdevs.myfirstcomposeapp.login.Greeting
import com.saltwortdevs.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstComposeAppTheme {
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val snackBarHostState = remember { SnackbarHostState() }
                //MyDialog()
                //MyDateDialog()
                //MyTimePicker()
                val scope = rememberCoroutineScope()

                //NavigationWrapper()
                //MyAnimationVisibility()
                //FullAnimateAsState()
                MyCrossFade()

                /*
                MyModalDrawer(drawerState = drawerState) {
                    /*Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = {
                            MyTopAppBar {
                                scope.launch { drawerState.open() }
                            }
                        },
                        snackbarHost = { SnackbarHost(hostState = snackBarHostState) },
                        floatingActionButton = { MyFAB() },
                        floatingActionButtonPosition = FabPosition.Start,
                        bottomBar = { MyNavigationBar() },
                    ) { innerPadding ->
                        //Greeting(
                          //  name = "Android",
                           // modifier = Modifier.padding(innerPadding)
                        //)
                        //MyColumn(Modifier.padding(innerPadding))
                        //MyRow(Modifier.padding(innerPadding))
                        //MyComplexLayout(Modifier.padding(innerPadding))
                        //MyFirstExample(Modifier.padding(innerPadding))
                        //MyConstraintLayout(Modifier.padding(innerPadding))
                        //MyConstraintLayout2(Modifier.padding(innerPadding))
                        //ConstraintExampleLayoutGuide(Modifier.padding(innerPadding))
                        //ConstraintBarrier(Modifier.padding(innerPadding))
                        //ConstraintChain(Modifier.padding(innerPadding))
                        //MyState(Modifier.padding(innerPadding))
                        //MyTexts(Modifier.padding(innerPadding))
                        //MyTextFieldParent(Modifier.padding(innerPadding))
                        //MyButtons(Modifier.padding(innerPadding))
                        //MyImage(Modifier.padding(innerPadding))
                        //MyNetWorkImage(Modifier.padding(innerPadding))
                        //MyProgress(Modifier.padding(innerPadding))
                        //MyProgressAdvance(Modifier.padding(innerPadding))
                        //ProgressAnimation(Modifier.padding(innerPadding))
                        //MySwitch(Modifier.padding(innerPadding))
                        //MyCheckBox(Modifier.padding(innerPadding))
                        //ParentCheckBox(Modifier.padding(innerPadding))
                        //TriStateCheckBox(Modifier.padding(innerPadding))
                        //MyRadioButton(Modifier.padding(innerPadding))
                        //MyRadioButtonList(Modifier.padding(innerPadding))
                        //MySlider(Modifier.padding(innerPadding))
                        //MySliderAdvance(Modifier.padding(innerPadding))
                        //MyRangeSlider(Modifier.padding(innerPadding))
                        //MyDropdownItem(Modifier.padding(innerPadding))
                        //MyDropdownMenu(Modifier.padding(innerPadding))
                        //MyExposedDropdownMenu(Modifier.padding(innerPadding))
                        // MyScaffold(Modifier.padding(innerPadding))
                        Box(
                            modifier = Modifier
                                .padding(innerPadding)
                                .fillMaxSize()
                                .background(Color.Black), contentAlignment = Alignment.Center
                        ) {
                            /*Text("Screen", modifier = Modifier.clickable {
                                scope.launch {
                                    val result = snackBarHostState.showSnackbar(
                                        message = "ejemplo",
                                        actionLabel = "Revertir"
                                    )
                                    if (result == SnackbarResult.ActionPerformed) {

                                    } else {

                                    }
                                }
                            })*/
                            Box(modifier = Modifier.fillMaxSize()) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    //MyCard()
                                    //MyElevatedCard()
                                    //MyOutlinedCard()
                                    //MyBadGetBox()
                                    //MyDivider()
                                    //MyAdvanceList()
                                    //ScrollList()
                                    MyGridList()
                                }
                            }

                        }
                    }*/
                }
                */
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyFirstComposeAppTheme {
        Greeting("Android")
    }
}