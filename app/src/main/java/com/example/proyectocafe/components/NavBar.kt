package com.example.proyectocafe.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Book
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults.colors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectocafe.R
import com.example.proyectocafe.ui.theme.PoppinsFontFamily


data class BottomNavItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)
@Composable
fun CoffeeBottomBar(
    selectedItemIndex: Int,
    onItemSelected: (Int) -> Unit
) {
    val items = listOf(
        BottomNavItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home
        ),
        BottomNavItem(
            title = "Menu",
            selectedIcon = Icons.Outlined.Book,
            unselectedIcon = Icons.Outlined.Book
        ),
        BottomNavItem(
            title = "Favourite",
            selectedIcon = Icons.Outlined.FavoriteBorder,
            unselectedIcon = Icons.Outlined.FavoriteBorder
        ),
        BottomNavItem(
            title = "Cart",
            selectedIcon = Icons.Outlined.ShoppingCart,
            unselectedIcon = Icons.Outlined.ShoppingCart
        ),
        BottomNavItem(
            title = "Profile",
            selectedIcon = Icons.Outlined.Person,
            unselectedIcon = Icons.Outlined.Person
        )
    )


    NavigationBar(
        containerColor = colorResource(R.color.cafe_fondo_suave),
        tonalElevation = 8.dp
    ) {
        items.forEachIndexed { index, item ->
            val isSelected = selectedItemIndex == index

            NavigationBarItem(
                selected = isSelected,
                onClick = { onItemSelected(index) },
                icon = {
                    Icon(
                        imageVector = if (isSelected) item.selectedIcon else item.unselectedIcon,
                        contentDescription = item.title,
                        modifier = Modifier.size(26.dp)
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        fontFamily = PoppinsFontFamily,
                        fontSize = 11.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                    )
                },
                colors = colors(
                    selectedIconColor = colorResource(R.color.cafe_oscuro_principal),
                    selectedTextColor = colorResource(R.color.cafe_oscuro_principal),
                    unselectedIconColor = colorResource(R.color.cafe_medio),
                    unselectedTextColor =colorResource(R.color.cafe_medio)

                )
            )
        }
    }
}
