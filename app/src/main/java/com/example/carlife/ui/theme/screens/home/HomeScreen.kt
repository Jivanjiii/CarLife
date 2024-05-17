package com.example.carlife.ui.theme.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.carlife.R
import com.example.carlife.R.drawable.glamifybuy
import com.example.carlife.R.drawable.supra
import com.example.carlife.navigation.ABOUT_URL
import com.example.carlife.navigation.ADD_SHOES_URL
import com.example.carlife.navigation.MORE_URL
import com.example.carlife.navigation.VIEW_USER_SHOE
import com.example.carlife.ui.theme.WazitoECommerceTheme
import com.example.carlife.ui.theme.main_green

@SuppressLint("SuspiciousIndentation")
@Composable
fun HomeScreen(navController:NavHostController){
    val scrollStateVertical = rememberScrollState()
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollStateVertical)
                    .paint(
                        painterResource(id = R.drawable.speed),
                        contentScale = ContentScale.FillBounds),
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                Spacer(modifier = Modifier.height(5.dp))
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "HOME SCREEN",
                        fontSize = 27.sp,
                        fontWeight = FontWeight.ExtraBold,
                        textAlign = TextAlign.Left,
                        textDecoration = TextDecoration.Underline,
                        color = Color.White
                    )
                    Row (
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = null,
                            modifier = Modifier
                                .clickable {
                                navController.navigate(ABOUT_URL)
                            }
                                .background(color = Color.White)
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(
                            text = "Help",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.clickable {
                                navController.navigate(ABOUT_URL)
                            },
                            color = Color.White
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))

                //row 1
                Row {
                    //card 1
                    Card(
                        modifier = Modifier
                            .clickable {
                                navController.navigate(VIEW_USER_SHOE)
                            }
                            .height(160.dp)
                            .width(175.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Transparent
                        ),
                        border = BorderStroke(1.dp, main_green)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(115.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Image(
                                    painter = painterResource(id = supra),
                                    contentDescription = null,
                                    modifier = Modifier.size(95.dp),
                                )
                            }

                            Spacer(modifier = Modifier.width(3.dp))
                            Text(
                                text = "Buy cars",
                                color = Color.Yellow,
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    //end of card 1
                }
                //end of row 1
                Spacer(modifier = Modifier.height(15.dp))
                //row 2
                Row {
                    //card 2
                    Card (
                        modifier = Modifier
                            .clickable {
                                navController.navigate(ADD_SHOES_URL)
                            }
                            .height(160.dp)
                            .width(175.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Transparent
                        ),
                        border = BorderStroke(1.dp, main_green)
                    ){
                        Column (
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Column (
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(115.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ){
                                Image(
                                    painter = painterResource(id = R.drawable.c1r),
                                    modifier = Modifier.size(95.dp),
                                    contentDescription = null
                                )
                            }

                            Spacer(modifier = Modifier.width(3.dp))

                            Text(
                                text = "Sell Car$",
                                color = Color.Yellow,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    //end of card 2

                }
                //end of row 2

                Spacer(modifier = Modifier.height(15.dp))

                //row 3
                Row {
                    //card 3
                    Card (
                        modifier = Modifier
                            .clickable {
                                navController.navigate(MORE_URL)
                            }
                            .height(160.dp)
                            .width(175.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Transparent
                        ),
                        border = BorderStroke(1.dp, main_green)
                    ){
                        Column (
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Column (
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(115.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ){
                                Image(
                                    painter = painterResource(id = R.drawable.men2),
                                    modifier = Modifier.size(95.dp),
                                    contentDescription = null
                                )
                            }

                            Spacer(modifier = Modifier.width(3.dp))

                            Text(
                                text = "Menu",
                                color = Color.Yellow,
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    //end of card 3

                }
                //end of row 3

            }
            //End of column
        }

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun HomeScreenPreview(){
    WazitoECommerceTheme {
        HomeScreen(navController = rememberNavController())
    }
}

