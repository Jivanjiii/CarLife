package com.example.carlife.ui.theme.screens.menu

import android.widget.Toast
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.carlife.R
import com.example.carlife.data.AuthViewModel
import com.example.carlife.navigation.ABOUT_URL
import com.example.carlife.navigation.HOME_URL
import com.example.carlife.navigation.LOGIN_URL
import com.example.carlife.navigation.SIGNUP_URL
import com.example.carlife.ui.theme.back_green
import com.example.carlife.ui.theme.card_green
import com.example.carlife.ui.theme.home_black
import com.example.carlife.ui.theme.secondary_blue


@Composable
fun MenuScreen(navController: NavHostController){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp)
            .background(home_black)
            .verticalScroll(rememberScrollState())
    ){
        val mContext = LocalContext.current
        Spacer(modifier = Modifier.height(8.dp))
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 6.dp),
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
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        navController.navigate(ABOUT_URL)
                    },
                    tint = secondary_blue
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Help",
                    color = secondary_blue,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.clickable {
                        navController.navigate(ABOUT_URL)
                    }
                )
            }
        }
        // icon row
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
                    containerColor = card_green
                )
            ){
                Image(
                    painter = painterResource(id = R.drawable.men2),
                    contentDescription = "top icon",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(6.dp)
                )
            }
            //end of card holding icon
        }
        // end of icon row
        Spacer(modifier = Modifier.height(7.dp))
        Text(
            text = "Menu",
            fontSize = 24.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.SansSerif,
            color = secondary_blue
        )
        Spacer(modifier = Modifier.height(10.dp))

        //account title
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                imageVector = Icons.Default.AccountBox,
                contentDescription = null,
                tint = secondary_blue
            )
            Spacer(modifier = Modifier.width(7.dp))
            Text(
                text = "Account Details",
                fontSize = 19.sp,
            )
        }
        //end of account title

        Spacer(modifier = Modifier.height(12.dp))

        //account details
        //create new account
        Card (
            modifier = Modifier
                .clickable {
                    navController.navigate(SIGNUP_URL)
                }
                .height(50.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = card_green
            )
        ){
            Row (
                modifier = Modifier
                    .height(50.dp)
                    .padding(7.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(imageVector = Icons.Default.AddCircle, contentDescription = null)
                Spacer(modifier = Modifier.width(7.dp))
                Text(
                    text = "Create New Account",
                    fontSize = 16.sp
                )
            }
        }
        //end create new account

        Spacer(modifier = Modifier.height(10.dp))

        //log into another account
        Card (
            modifier = Modifier
                .clickable {
                    navController.navigate(LOGIN_URL)
                }
                .height(50.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = card_green
            )
        ){
            Row (
                modifier = Modifier
                    .height(50.dp)
                    .padding(7.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
                Spacer(modifier = Modifier.width(7.dp))
                Text(
                    text = "Log Into Another Account",
                    fontSize = 16.sp
                )
            }
        }
        //end log into another account

        Spacer(modifier = Modifier.height(10.dp))
        val context = LocalContext.current
        val authViewModel = AuthViewModel(navController, context)

        //log out of account
        Card (
            modifier = Modifier
                .clickable {
                    Toast
                        .makeText(mContext, "Logged out", Toast.LENGTH_SHORT)
                        .show()
                    authViewModel.logout()
                }
                .height(50.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = card_green
            )
        ){
            Row (
                modifier = Modifier
                    .height(50.dp)
                    .padding(7.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(imageVector = Icons.Default.ExitToApp, contentDescription = null)
                Spacer(modifier = Modifier.width(7.dp))
                Text(
                    text = "Log Out",
                    fontSize = 16.sp
                )
            }
        }
        //end log out of account

        //end of account details

    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun MenuScreenPreview(){
    MenuScreen(navController = rememberNavController())
}

