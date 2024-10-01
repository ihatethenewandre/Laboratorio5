package com.example.laboratorio6

import androidx.compose.foundation.background
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio6.ui.theme.Amarillo

@Composable
fun Pantalla4() {
    var notificationsEnabled by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(90.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Amarillo),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "User Icon",
                    modifier = Modifier.size(100.dp),
                    tint = Color.White
                )
                Text(text = "André Pivaral", fontSize = 24.sp, color = Color.White)
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            item {
                ConfigOption(
                    icon = Icons.Default.Person,
                    title = "Editar Perfil"
                )
            }
            item {
                ConfigOption(
                    icon = Icons.Default.Lock,
                    title = "Cambiar Contraseña"
                )
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Notifications Icon",
                            tint = Amarillo
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(text = "Notificaciones", fontSize = 18.sp)
                    }
                    Switch(
                        checked = notificationsEnabled,
                        onCheckedChange = { notificationsEnabled = it }
                    )
                }
            }
            item {
                ConfigOption(
                    icon = Icons.Default.Star,
                    title = "Favoritos"
                )
            }
        }
    }
}

@Composable
fun ConfigOption(icon: androidx.compose.ui.graphics.vector.ImageVector, title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "$title Icon",
            tint = Amarillo
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = title, fontSize = 18.sp)
    }
}