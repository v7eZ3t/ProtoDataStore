package com.example.protodatastore.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.protodatastore.HomeEvents
import com.example.protodatastore.HomeViewModel
import com.example.protodatastore.ui.theme.Purple200
import com.tomcz.ellipse.common.collectAsState


private var loginInput = ""
private var passwordInput = ""
private var pinInput = ""

@Composable
fun HomeScreen() {
    val processor = viewModel<HomeViewModel>().processor

    val savedLogin by processor.collectAsState { it.login }
    val savedPassword by processor.collectAsState { it.password }
    val savedPin by processor.collectAsState { it.pin }

    Column(
        Modifier
            .padding(16.dp)
            .background(MaterialTheme.colors.background)
    ) {
        Spacer(modifier = Modifier.weight(2f))
        InputColumn()
        Spacer(modifier = Modifier.weight(2f))
        SavedValuesColumn(savedLogin, savedPassword, savedPin)
        Spacer(modifier = Modifier.weight(7f))
        SaveButton(
            "Sign In"
        ) { processor.sendEvent(HomeEvents.Login(loginInput, passwordInput, pinInput)) }
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun InputColumn() {
    Column {
        InputField(
            placeholder = "Login",
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Text,
            textData = loginInput,
            hideText = false,
            onChange = { loginInput = it })
        Spacer(Modifier.size(16.dp))
        InputField(
            placeholder = "Password",
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Password,
            textData = passwordInput,
            hideText = true,
            onChange = { passwordInput = it })
        Spacer(Modifier.size(16.dp))
        InputField(
            placeholder = "Pin",
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.NumberPassword,
            textData = pinInput,
            hideText = true,
            onChange = { pinInput = it })
    }
}

@Composable
fun SavedValuesColumn(savedLogin: String, savedPassword: String, savedPin: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = savedLogin)
        Text(text = savedPassword)
        Text(text = savedPin)
    }
}

@Composable
fun InputField(
    placeholder: String,
    imeAction: ImeAction,
    keyboardType: KeyboardType,
    textData: String,
    hideText: Boolean,
    onChange: (String) -> Unit = {}

) {

    var textInput by remember { mutableStateOf(textData) }
    val localFocusManager = LocalFocusManager.current

    TextField(
        value = textInput,
        onValueChange = {
            textInput = it
            onChange(it)
        },
        modifier = Modifier
            .background(
                color = MaterialTheme.colors.background,
                shape = RoundedCornerShape(16.dp)
            )
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = MaterialTheme.colors.primary,
                shape = RoundedCornerShape(16.dp)
            ),
        enabled = true,
        placeholder = { Text(text = placeholder) },
        shape = RoundedCornerShape(16.dp),
        maxLines = 1,
        singleLine = true,
        visualTransformation = if (hideText) PasswordVisualTransformation() else VisualTransformation.None,
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction,
        ),
        keyboardActions = KeyboardActions(
            onDone = { localFocusManager.clearFocus() }
        )
    )
}


@Composable
fun SaveButton(
    text: String,
    sendEvent: () -> Unit
) {
    TextButton(modifier = Modifier
        .background(
            color = Purple200,
            shape = RoundedCornerShape(16.dp)
        )
        .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        onClick = { sendEvent.invoke()
        clearLoginFields()})
    {
        Text(text = text, color = MaterialTheme.colors.primaryVariant)
    }
}

fun clearLoginFields(){
    loginInput = ""
    passwordInput = ""
    pinInput = ""
}