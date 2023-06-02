package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtComposeImg()
            }
        }
    }
}

@Composable
fun ArtComposeImg(modifier: Modifier=Modifier){
    var img by remember { mutableStateOf(value = 1) }
    var imgResource = getImg(img)
    var txtResource = getTxt(img)
    var titu = getTitu(img)


    Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
        Row(horizontalArrangement = Arrangement.Center) {
            Image(painter = painterResource(id = imgResource), contentDescription =null)

        }

        Spacer(modifier = Modifier.height(60.dp))

        Row(horizontalArrangement = Arrangement.Center) {
            Text(stringResource(id = titu))
        }

        Spacer(modifier = Modifier.height(5.dp))

        Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
            Text(stringResource(id = txtResource), textAlign = TextAlign.Center)
        }

        Spacer(modifier = Modifier.height(25.dp))

        Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = {
                if (img>0 || img<4){
                    img--
                }
                if(img<=0){
                    img=1
                }
            }) {
                Text(text = "Previos")
            }

            Button(onClick = {
                if (img>0 || img<4){
                    img++
                }
                if(img>=4){
                    img=4
                }
            }) {
                Text(text = "Next ")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtComposeImg()
    }
}

private fun getImg(id:Int):Int{
    val imgResource = when (id){
        1->R.drawable.dos_de
        2->R.drawable.murdoc
        3->R.drawable.noodle
        else->R.drawable.russel
    }
    return  imgResource
}

private fun getTxt(id:Int):Int{
    val txtResource = when (id){
        1->R.string.creacionT1
        2->R.string.creacionT2
        3->R.string.creacionT3
        else->R.string.creacionT4
    }

    return txtResource
}

private fun getTitu(id: Int):Int{
    val titulo= when (id){
        1->R.string.t1
        2->R.string.t2
        3->R.string.t3
        else->R.string.t4
    }

    return titulo
}