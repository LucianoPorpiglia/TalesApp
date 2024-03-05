package com.example.storiesapp.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.storiesapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailField(
    email: String,
    onTextFieldChanged: (String) -> Unit,
    padding: PaddingValues
) {

    OutlinedTextField(
        value = email,
        onValueChange = {
            onTextFieldChanged(it)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(padding),
        placeholder = {
            Text(
                text = "Email", color = Color.LightGray
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        textStyle = MaterialTheme.typography.titleSmall,
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colorScheme.onSecondary
        ),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.email),
                contentDescription = "",
                tint = Color.LightGray
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField(
    password: String,
    onTextFieldChanged: (String) -> Unit,
    padding: PaddingValues,
    text: String
) {

    OutlinedTextField(
        value = password, onValueChange = { onTextFieldChanged(it) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(padding),
        placeholder = {
            Text(
                text = text, color = Color.LightGray
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        textStyle = MaterialTheme.typography.titleSmall,
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colorScheme.onSecondary
        ),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.lock),
                contentDescription = "",
                tint = Color.LightGray
            )
        },
        visualTransformation = PasswordVisualTransformation()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResetEmailField(
    sendEmail: String,
    onSendEmailChanged: (String) -> Unit,
    padding: PaddingValues
) {

    OutlinedTextField(
        value = sendEmail,
        onValueChange = {
            onSendEmailChanged(it)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(padding),
        placeholder = {
            Text(
                text = "Email", color = Color.LightGray
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        textStyle = MaterialTheme.typography.titleSmall,
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colorScheme.onSecondary
        ),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.email),
                contentDescription = "",
                tint = Color.LightGray
            )
        }
    )
}
