package com.example.artspacemak

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspacemak.ui.theme.ArtSpaceMakTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceMakTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

// основная функция приложения соберает все вместе
@Composable
fun ArtSpaceApp() {
//    зададим пременые для хранения данных
    val imagePhoto: Painter
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color = Color.Cyan),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally


    ) {
        ImageKids()
        Spacer(modifier = Modifier.padding(16.dp))
        TextInformation()
        Spacer(modifier = Modifier.padding(16.dp))
        ButtonNextAndBack()
    }
}

// функция для отоброжения фото
@Composable
fun ImageKids(imageKids: Int = 1, boyOrGirl: Int = 1) {
    val contentDescription = if (boyOrGirl == 1) stringResource(id = R.string.boy)
    else stringResource(id = R.string.girl)
    val resourceDrawable = when (imageKids) {
        1 -> painterResource(id = R.drawable.mark_24_09_15)
        2 -> painterResource(id = R.drawable.mark_26_02_16)
        3 -> painterResource(id = R.drawable.mark_20_06_17)
        4 -> painterResource(id = R.drawable.mark_10_01_18)
        5 -> painterResource(id = R.drawable.maryan_6_06_21)
        6 -> painterResource(id = R.drawable.maryana_11_02_22)
        7 -> painterResource(id = R.drawable.maryana_22_04_22)
        8 -> painterResource(id = R.drawable.maryna_10_06_22)
        else -> painterResource(id = R.drawable.maryana_1_03_23)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp), contentAlignment = Alignment.Center
    ) {
        Image(
            painter = resourceDrawable,
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(300.dp)
                .clip(RoundedCornerShape(16.dp))
        )
    }
}

// функция для отоброжения текста
@Composable
fun TextInformation(name: Int = 1, textDate: Int = 1) {
    val maryanaOrMark = if (name == 1) stringResource(id = R.string.mark)
    else stringResource(id = R.string.maryana)
    val date = when (textDate) {
        1 -> stringResource(id = R.string.mark_24_09_15)
        2 -> stringResource(id = R.string.mark_26_02_16)
        3 -> stringResource(id = R.string.mark_20_06_17)
        4 -> stringResource(id = R.string.mark_10_01_18)
        5 -> stringResource(id = R.string.maryana_6_06_21)
        6 -> stringResource(id = R.string.maryana_11_02_22)
        7 -> stringResource(id = R.string.maryana_22_04_22)
        8 -> stringResource(id = R.string.maryana_10_06_22)
        else -> stringResource(id = R.string.maryana_1_03_23)

    }
    Text(
        text = maryanaOrMark,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
    )
    Spacer(modifier = Modifier.padding(8.dp))
    Text(
        text = date, fontSize = 20.sp, fontWeight = FontWeight.Bold
    )
}

// функция отвечает за кнопки
@Composable
fun ButtonNextAndBack() {
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { /*TODO*/ },
        ) {
            Text(
                text = stringResource(id = R.string.back), color = Color.Black
            )
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Button(onClick = { /*TODO*/ }) {
            Text(
                text = stringResource(id = R.string.next), color = Color.Black
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceMakTheme {
        ArtSpaceApp()
    }
}