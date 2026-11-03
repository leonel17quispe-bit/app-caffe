import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.proyectocafe.R

@Composable
fun CampoTextoPersonalizado(
    value: String,                          // El texto actual que contiene el campo
    onValueChange: (String) -> Unit,        // Función que se ejecuta cuando el usuario escribe
    placeholderText: String,                // El texto de guía (placeholder)
    leadingIcon: ImageVector,               // El icono que va al inicio
    keyboardType: KeyboardType = KeyboardType.Text, // Tipo de teclado por defecto
    modifier: Modifier = Modifier           // Modificador para ajustar márgenes o tamaño desde afuera
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(placeholderText, color = Color.Gray) },
        leadingIcon = {
            Icon(
                imageVector = leadingIcon,
                contentDescription = null,
                tint = colorResource(R.color.cafe_medio) // Asegúrate de tener definida esta variable de color en tu proyecto
            )
        },
        singleLine = true,
        shape = RoundedCornerShape(16.dp),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(R.color.cafe_medio),
            unfocusedBorderColor = colorResource(R.color.cafe_oscuro_principal).copy(alpha = 0.4f), // Asegúrate de tener este color
            focusedContainerColor = Color.White.copy(alpha = 0.85f),
            unfocusedContainerColor = Color.White.copy(alpha = 0.75f),
        ),
        modifier = modifier.fillMaxWidth()
    )
}