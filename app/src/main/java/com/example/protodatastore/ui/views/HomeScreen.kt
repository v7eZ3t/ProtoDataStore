package com.example.protodatastore.ui.views
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.text.KeyboardActions
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalFocusManager
//import androidx.compose.ui.text.input.ImeAction
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.text.input.TextFieldValue
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import com.example.protodatastore.HomeEvents
//import com.example.protodatastore.HomeViewModel
//import com.example.protodatastore.ui.theme.Purple200
//import com.tomcz.ellipse.common.collectAsState
//
//
//@Composable
//fun HomeScreen() {
//    val processor = viewModel<HomeViewModel>().processor
//    val currNumber by processor.collectAsState { it.login }
//  //  processor.sendEvent(HomeEvents.ChangeNumber(currNumber))
//}
//
//@Composable
//fun HomeScreen2() {
//    val processor = viewModel<HomeViewModel>().processor
//
//    var login by remember { mutableStateOf(TextFieldValue("")) }
//    var password by remember { mutableStateOf(TextFieldValue("")) }
//
//    Column(
//        Modifier
//            .padding(16.dp)
//            .background(MaterialTheme.colors.background)
//    ) {
//        Spacer(modifier = Modifier.weight(2f))
//        CredentialsColumn(login, password)
//        Spacer(modifier = Modifier.weight(7f))
//        SaveButton("Login") { processor.sendEvent(HomeEvents.Login(login, password)) }
//        Spacer(modifier = Modifier.weight(0.5f))
//        SaveButton("Load Previous Credentials")
//        Spacer(modifier = Modifier.weight(1f))
//    }
//}
//
//@Composable
//fun CredentialsColumn(login: TextFieldValue, password: TextFieldValue) {
//    val spacerModifier = Modifier.size(16.dp)
//    Column {
//        InputField(placeholder = "Login", ImeAction.Next, KeyboardType.Text, login)
//        Spacer(spacerModifier)
//        InputField(placeholder = "Password", ImeAction.Done, KeyboardType.Password, password)
//    }
//}
//
//@Composable
//fun SaveButton(text: String, onClick: ()-> Unit) {
//    TextButton(modifier = Modifier
//        .background(
//            color = Purple200,
//            shape = RoundedCornerShape(16.dp)
//        )
//        .fillMaxWidth(),
//        shape = RoundedCornerShape(16.dp),
//        onClick = { /*TODO*/ }) {
//        Text(text = text, color = MaterialTheme.colors.primaryVariant)
//    }
//}
//
//@Composable
//fun InputField(
//    placeholder: String,
//    imeAction: ImeAction,
//    keyboardType: KeyboardType,
//    text: TextFieldValue
//) {
//    val localFocusManager = LocalFocusManager.current
//
//    TextField(
//        modifier = Modifier
//            .background(
//                color = MaterialTheme.colors.background,
//                shape = RoundedCornerShape(16.dp)
//            )
//            .fillMaxWidth()
//            .border(
//                width = 1.dp,
//                color = MaterialTheme.colors.primary,
//                shape = RoundedCornerShape(16.dp)
//            ),
//        value = text,
//        onValueChange = { newText ->
//            text = newText
//        },
//        placeholder = { Text(text = placeholder) },
//        shape = RoundedCornerShape(16.dp),
//        maxLines = 1,
//        colors = TextFieldDefaults.textFieldColors(
//            focusedIndicatorColor = Color.Transparent,
//            unfocusedIndicatorColor = Color.Transparent,
//            disabledIndicatorColor = Color.Transparent
//        ),
//        keyboardOptions = KeyboardOptions(
//            keyboardType = keyboardType,
//            imeAction = imeAction,
//        ),
//        keyboardActions = KeyboardActions(
//            onDone = {localFocusManager.clearFocus()}
//        )
//    )
//}
//
//@Preview
//@Composable
//fun ComposablePreview() {
//    HomeScreen2()
//}