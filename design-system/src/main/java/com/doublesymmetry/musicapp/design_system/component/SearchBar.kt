package com.doublesymmetry.musicapp.design_system.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.doublesymmetry.musicapp.design_system.R
import com.doublesymmetry.musicapp.design_system.theme.SFProDisplay

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint: String,
    onTextChanged: (String) -> Unit
) {

    var value by rememberSaveable { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    Card(
        modifier = modifier,
        elevation = 0.dp,
        shape = RoundedCornerShape(10.dp),
        backgroundColor = Color(0x3D767680),
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 7.dp)
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "",
                    tint = Color(0x99EBEBF5)
                )

                BasicTextField(
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .fillMaxWidth(),
                    value = value,
                    onValueChange = {
                        value = it
                        onTextChanged(it)
                    },
                    textStyle = TextStyle(
                        color = Color.White,
                        fontSize = 17.sp,
                        fontFamily = SFProDisplay,
                        fontWeight = FontWeight.Normal
                    ),
                    singleLine = true,
                    decorationBox = { innerTextField ->
                        if (value.isEmpty()) {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 2.dp, bottom = 2.dp),
                                text = hint,
                                fontSize = 17.sp,
                                color = Color(0x99EBEBF5),
                                fontFamily = SFProDisplay,
                                fontWeight = FontWeight.Normal
                            )
                            keyboardController?.hide()
                            focusManager.clearFocus(force = true)
                        }
                        innerTextField()
                    },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                    keyboardActions = KeyboardActions(
                        onSearch = {
                            keyboardController?.hide()
                            focusManager.clearFocus(force = true)
                        }
                    )
                )

            }
        }
    }

}
