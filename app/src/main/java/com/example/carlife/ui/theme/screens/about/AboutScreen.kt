package com.example.carlife.ui.theme.screens.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.carlife.navigation.HOME_URL
import com.example.carlife.ui.theme.home_black
import com.example.carlife.ui.theme.secondary_blue

@Composable
fun AboutScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(home_black)
            .verticalScroll(rememberScrollState())
    ) {
        Column (
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 3.dp)
        ){
            Spacer(modifier = Modifier.height(8.dp))
            // home icon
            Row (
                verticalAlignment = Alignment.CenterVertically,
            ){
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null,
                    modifier = Modifier.clickable { navController.navigate(HOME_URL) },
                    tint = secondary_blue
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "Home",
                    modifier = Modifier.clickable { navController.navigate(HOME_URL) },
                    fontWeight = FontWeight.SemiBold,
                    color = secondary_blue
                )
            }
            //end of home icon
            //intro row
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                //card holding icon
                Card (
                    modifier = Modifier
                        .size(70.dp),
                    shape = RoundedCornerShape(50),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent
                    )
                ){
                    Image(
                        painter = painterResource(id = R.drawable.jeff),
                        contentDescription = "top icon",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(6.dp)
                    )
                }
                //end of card holding icon

            }
            Text(
                text = "How To Use",
                color = secondary_blue,
                fontSize = 28.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline
            )
            // intro row end
            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "Here at CarLife you can access a great variety off car models available on the market",
                fontSize = 17.sp,
                color = Color.Green
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "Buy CarLife",
                color = secondary_blue,
                fontSize = 23.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline
            )

            Spacer(modifier = Modifier.height(6.dp))

            Box (
                modifier = Modifier.fillMaxWidth()
                    .height(500.dp)
                    .padding(horizontal = 45.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.shelby),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
            }

            Spacer(modifier = Modifier.height(7.dp))

            Text(
                text = "Here at CarLife we allow you the customers," +
                        "to sell you cars," +
                        "add be able to interact with the customers",
                fontSize = 17.sp,
                color = Color.Green
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Sell at CarLife",
                color = secondary_blue,
                fontSize = 23.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline
            )

            Spacer(modifier = Modifier.height(6.dp))

            Box (
                modifier = Modifier.fillMaxWidth()
                    .height(500.dp)
                    .padding(horizontal = 45.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.porche),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds,
                )
            }

            Spacer(modifier = Modifier.height(7.dp))

            Text(
                text = "You will be welcomed with a form that allows you to upload your product to " +
                        "the servers to allow buying of your cars by other Carlife users. By clicking" +
                        " on \"View Cars\" button  you will be able to see " +
                        "all products that you have ever uploaded with your account and allows updating and deleting" +
                        " of the same.",
                fontSize = 17.sp,
                color = Color.Green
            )
            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Menu",
                color = secondary_blue,
                fontSize = 23.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline
            )

            Spacer(modifier = Modifier.height(6.dp))

            Box (
                modifier = Modifier.fillMaxWidth()
                    .height(500.dp)
                    .padding(horizontal = 45.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.menu),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds,
                )
            }

            Spacer(modifier = Modifier.height(7.dp))

            Text(
                text = "Here you will be able to do additional tasks such as creating an account, logging into a different account and logging out",
                fontSize = 17.sp,
                color = Color.Green
            )

            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun AboutScreenPreview(){
    AboutScreen(navController = rememberNavController())
}