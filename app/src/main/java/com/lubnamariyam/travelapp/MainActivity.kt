package com.lubnamariyam.travelapp

import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.lubnamariyam.travelapp.model.onboardPages
import com.lubnamariyam.travelapp.ui.theme.TravelzTheme
import com.lubnamariyam.travelapp.view.HomeUi
import com.lubnamariyam.travelapp.view.PageUi

@ExperimentalPagerApi
class MainActivity : ComponentActivity() {
    @ExperimentalPagerApi
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TravelzTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    OnboardingUi()
                }
            }
        }
    }
}


@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun OnboardingUi(
) {

    val pagerState = rememberPagerState(pageCount = 3)

    Column {

        Text(text = "Skip" , modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable { })

        HorizontalPager(state = pagerState , modifier = Modifier
            .fillMaxSize()
            .weight(1f)) {
            page ->
            PageUi(page = onboardPages[page])
        }

        HorizontalPagerIndicator(pagerState = pagerState, modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(16.dp),
        activeColor = Color.Blue)

        AnimatedVisibility(visible = pagerState.currentPage == 2) {
            OutlinedButton(shape = RoundedCornerShape(20.dp), modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),onClick = {}, colors = ButtonDefaults.outlinedButtonColors(backgroundColor = colorResource(
                id = R.color.purple_500), colorResource(id = R.color.white))) {

                Text(text = "Let's Start")

            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TravelzTheme {

    }
}