@file:Suppress("DEPRECATION")

package com.example.glamify.ui.theme.screens.products

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.glamify.R
import com.example.glamify.data.ProductViewModel
import com.example.glamify.navigation.ABOUT_URL
import com.example.glamify.navigation.HOME_URL
import com.example.glamify.navigation.VIEW_SHOES_URL
import com.example.glamify.ui.theme.WazitoECommerceTheme
import com.example.glamify.ui.theme.back_green
import com.example.glamify.ui.theme.card_green
import com.example.glamify.ui.theme.main_green
import com.example.glamify.ui.theme.secondary_blue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateShoeScreen(navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(back_green)
            .verticalScroll(rememberScrollState())
    ) {
        LocalContext.current
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
                    painter = painterResource(id = R.drawable.glamifysell),
                    contentDescription = "top icon",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                )
            }
            //end of card holding icon
        }
        // end of icon row
        Spacer(modifier = Modifier.height(7.dp))
        Text(
            text = "Update Shoe",
            fontSize = 27.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.SansSerif,
            color = secondary_blue
        )
        Spacer(modifier = Modifier.height(7.dp))

        Row (
            modifier= Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(topStart = 10.dp, bottomStart = 10.dp),
                colors = ButtonDefaults.buttonColors(main_green)
            ) {
                Text(
                    text = "Update Shoe",
                    fontSize = 16.sp
                )
            }
            Button(
                onClick = { navController.navigate(VIEW_SHOES_URL) },
                shape = RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp),
                colors = ButtonDefaults.buttonColors(card_green),
            ) {
                Text(
                    text = "View Shoes",
                    color = secondary_blue,
                    fontSize = 16.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(7.dp))

        var shoeName by remember { mutableStateOf("") }
        var shoeDescription by remember { mutableStateOf("") }
        var shoePrice by remember { mutableStateOf("") }
        var phoneNumber by remember { mutableStateOf("") }
        var location by remember { mutableStateOf("") }
        val context = LocalContext.current


        OutlinedTextField(
            value = shoeName,
            onValueChange = { shoeName = it },
            placeholder = { Text(text="eg. Nike,Cap") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "email icon"
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = secondary_blue,
                unfocusedBorderColor = main_green,
                focusedLeadingIconColor = secondary_blue,
                unfocusedLeadingIconColor = main_green,
                focusedLabelColor = secondary_blue,
                unfocusedLabelColor = main_green,
            ),
            label = { Text(text = "Shoe Name") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = shoeDescription,
            onValueChange = { shoeDescription = it },
            placeholder = { Text(text="eg. Fashionable Wear...") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "email icon"
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = secondary_blue,
                unfocusedBorderColor = main_green,
                focusedLeadingIconColor = secondary_blue,
                unfocusedLeadingIconColor = main_green,
                focusedLabelColor = secondary_blue,
                unfocusedLabelColor = main_green,
            ),
            label = { Text(text = "Shoe Description") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = shoePrice,
            onValueChange = { shoePrice = it },
            placeholder = { Text(text="eg. ksh.5.000") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "email icon"
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = secondary_blue,
                unfocusedBorderColor = main_green,
                focusedLeadingIconColor = secondary_blue,
                unfocusedLeadingIconColor = main_green,
                focusedLabelColor = secondary_blue,
                unfocusedLabelColor = main_green,
            ),
            label = { Text(text = "Shoe Price (Ksh.)") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            placeholder = { Text(text="eg. +254756783210") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Call,
                    contentDescription = "email icon"
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = secondary_blue,
                unfocusedBorderColor = main_green,
                focusedLeadingIconColor = secondary_blue,
                unfocusedLeadingIconColor = main_green,
                focusedLabelColor = secondary_blue,
                unfocusedLabelColor = main_green,
            ),
            label = { Text(text = "Phone Number") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = location,
            onValueChange = { location = it },
            placeholder = { Text(text="eg. EastLeigh,Nairobi") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "location icon"
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = secondary_blue,
                unfocusedBorderColor = main_green,
                focusedLeadingIconColor = secondary_blue,
                unfocusedLeadingIconColor = main_green,
                focusedLabelColor = secondary_blue,
                unfocusedLabelColor = main_green,
            ),
            label = { Text(text = "Shoe Location") }
        )

        Spacer(modifier = Modifier.height(20.dp))



        //---------------------IMAGE PICKER START-----------------------------------//

        val modifier = Modifier
        ImagePick(modifier,context, navController, shoeName.trim(), shoeDescription.trim(), shoePrice.trim(),phoneNumber.trim(), location.trim())

        //---------------------IMAGE PICKER END-----------------------------------//



    }
}

@Composable
fun ImagePick(modifier: Modifier = Modifier, context: Context, navController: NavHostController, name:String, description:String, price:String, phoneno:String, location:String) {
    var hasImage by remember { mutableStateOf(false) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            hasImage = uri != null
            imageUri = uri
        }
    )

    Column(modifier = modifier) {
        if (hasImage && imageUri != null) {
            val bitmap = MediaStore.Images.Media.
            getBitmap(context.contentResolver,imageUri)
            Image(
                bitmap = bitmap.asImageBitmap(),
                contentDescription = "Selected image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(320.dp)
                    .padding(vertical = 5.dp)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,) {
            Button(
                onClick = {
                    imagePicker.launch("image/*")
                },
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(card_green),
                modifier = Modifier
                    .height(52.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                border = BorderStroke(1.dp, main_green)
            ) {
                Text(
                    text = "Select Image",
                    color = secondary_blue,
                    fontSize = 18.sp
                )
            }


            Button(onClick = {
                //-----------WRITE THE UPLOAD LOGIC HERE---------------//
                val shoeRepository = ProductViewModel(navController,context)
                shoeRepository.uploadProduct(name, description, price,phoneno,location,imageUri!!)
            },
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(main_green),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp, vertical = 20.dp)
            ) {
                Text(
                    text = "Update",
                    fontSize = 17.sp
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun UpdateShoeScreenPreview(){
    WazitoECommerceTheme {
        UpdateShoeScreen(navController = rememberNavController())
    }
}

