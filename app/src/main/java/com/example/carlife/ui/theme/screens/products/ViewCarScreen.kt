
package com.example.carlife.ui.theme.screens.products

import android.content.Intent
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.carlife.R
import com.example.carlife.data.ProductViewModel
import com.example.carlife.models.Product
import com.example.carlife.navigation.ABOUT_URL
import com.example.carlife.navigation.HOME_URL
import com.example.carlife.ui.theme.WazitoECommerceTheme
import com.example.carlife.ui.theme.back_green
import com.example.carlife.ui.theme.card_green
import com.example.carlife.ui.theme.main_green
import com.example.carlife.ui.theme.secondary_blue

@Composable
fun ViewCarsScreen(navController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(back_green)
    ) {

        val context = LocalContext.current
        val shoeRepository = ProductViewModel(navController, context)


        val emptyShoeState = remember { mutableStateOf(Product("","","","","","","","")) }
        val emptyShoesListState = remember { mutableStateListOf<Product>() }

        val shoes = shoeRepository.allProducts(emptyShoeState, emptyShoesListState)


        Column(
            modifier = Modifier
                .background(back_green)
                .fillMaxSize(),
        ) {
            Spacer(modifier = Modifier.height(5.dp))
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
                        .size(75.dp),
                    shape = RoundedCornerShape(50),
                    colors = CardDefaults.cardColors(
                        containerColor = card_green
                    )
                ){
                    Image(
                        painter = painterResource(id = R.drawable.porche),
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
            Spacer(modifier = Modifier.height(3.dp))

            Text(
                text = "Buy Shoes",
                fontSize = 26.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.SansSerif,
                color = secondary_blue
            )


            Spacer(modifier = Modifier.height(10.dp))

            LazyColumn {
                items(shoes){
                    ProductItems(
                        name = it.name,
                        description = it.description,
                        price = it.price,
                        phoneno = it.phoneno,
                        location = it.location,
                        shoeImage = it.imageUrl,
                    )
                }
            }
        }
    }
}


@Composable
fun ProductItems(
    name: String,
    description: String,
    price: String,
    phoneno: String,
    location: String,
    shoeImage: String
) {

    val mContext = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 25.dp)
    ) {

        Card (
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = card_green
            )
        ){
            Column (
                modifier = Modifier.padding(horizontal = 10.dp)
            ){
                Box (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp)
                        .padding(vertical = 9.dp)
                ){
                    Image(
                        painter = rememberAsyncImagePainter(shoeImage),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(280.dp)
                            .clip(
                                RoundedCornerShape(3.dp)
                            )
                            .fillMaxSize(),
                        contentScale = ContentScale.FillBounds,
                    )
                }
                Column {
                    Text(
                        text = "Name: $name",
                        color = secondary_blue,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = "Description: $description",
                        color = secondary_blue,
                        fontSize = 17.sp,
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    //price and cart row
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            text = "Price: Ksh. $price",
                            fontSize = 17.sp
                        )
                        Row (
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ){
                            Text(
                                text = "Negotiable",
                                color = secondary_blue,
                                fontSize = 16.sp,
                            )
                        }
                    }
                    //end of price and cart row
                    Spacer(modifier = Modifier.height(3.dp))

                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = null,
                            tint = secondary_blue
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(
                            text = location,
                            color = secondary_blue,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.SemiBold,
                        )
                    }

                    Spacer(modifier = Modifier.height(3.dp))

                    //button row
                    Row (
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                    ){
                        OutlinedButton(
                            onClick = {
                                val smsIntent= Intent(Intent.ACTION_SENDTO)
                                smsIntent.data="sms to:$phoneno".toUri()
                                smsIntent.putExtra("sms_body","Hello Seller,...?")
                                mContext.startActivity(smsIntent)
                            },
                            shape = RoundedCornerShape(8.dp),

                            ) {
                            Row {
                                Icon(
                                    imageVector = Icons.Default.Send,
                                    contentDescription = "Message Seller",
                                    tint = main_green
                                )
                                Spacer(modifier = Modifier.width(3.dp))
                                Text(
                                    text = "Message Seller",
                                    color = main_green
                                )
                            }
                        }
                        Row (
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ){
                            Button(
                                onClick = {
                                    val callIntent= Intent(Intent.ACTION_DIAL)
                                    callIntent.data="tel:$phoneno".toUri()
                                    mContext.startActivity(callIntent)
                                },
                                colors = ButtonDefaults.buttonColors(
                                    main_green
                                ),
                                shape = RoundedCornerShape(8.dp)
                            ) {
                                Row {
                                    Icon(imageVector = Icons.Default.Call, contentDescription = "Call Seller")
                                    Spacer(modifier = Modifier.width(3.dp))
                                    Text(
                                        text = "Call Seller",
                                        color = Color.White
                                    )
                                }
                            }
                        }

                    }
                    //end of button row
                }

            }

        }
    }
}

@Composable
@Preview(showBackground = true)
fun ViewCarsScreenPreview(){
    WazitoECommerceTheme {
        ViewCarsScreen(navController = rememberNavController())
    }
}

