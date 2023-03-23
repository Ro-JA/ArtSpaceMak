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
    var imageState by remember { mutableStateOf(1) }
    var markOrMaryana by remember { mutableStateOf(1) }
    if (imageState in 1..4) markOrMaryana = 1 else markOrMaryana = 2
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color = Color.Cyan),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally


    ) {

        ImageKids(imageState, markOrMaryana)
        Spacer(modifier = Modifier.padding(16.dp))
        TextInformation(imageState, markOrMaryana)
        Spacer(modifier = Modifier.padding(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    --imageState
                    if (imageState == 1) {
                        imageState = 1
                    }
                          },
            ) {
                Text(
                    text = stringResource(id = R.string.back), color = Color.Black
                )
            }
            Spacer(modifier = Modifier.padding(8.dp))
            Button(onClick = {
                imageState++
                if(imageState == 10) {
                    imageState = 1
                }
            }) {
                Text(
                    text = stringResource(id = R.string.next), color = Color.Black
                )
            }

        }
    }
}

// функция для отоброжения фото принимает пармаметр imageKids для фото и boyOrGirl для contentDescription
@Composable
fun ImageKids(imageKids: Int, boyOrGirl: Int) {
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

// функция для отоброжения текста принимает два параметра textDate отображает дату, а name имя
@Composable
fun TextInformation(textDate: Int, name: Int) {
    val textOne = if (name == 1)   stringResource(id = R.string.mark)
    else  stringResource(id = R.string.maryana)

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
        text = textOne,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
    )
    Spacer(modifier = Modifier.padding(8.dp))
    Text(
        text = date,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceMakTheme {
        ArtSpaceApp()
    }
}