package com.example.myrecipeapp.ui.theme





import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.myrecipeapp.Category
import com.example.myrecipeapp.MainViewModel

@Composable
fun RecipeScreen(modifier: Modifier = Modifier,
                 viewstate : MainViewModel.RecipeState,
                 navigatetoDetail : (Category)-> Unit){

    Box(modifier = Modifier.fillMaxSize()){
        when{
            viewstate.loading ->{
                CircularProgressIndicator(modifier.align(Alignment.Center))
            }

            viewstate.error != null ->{
                Text("ERROR OCCURRED")
            }
            else ->{
                CategoryScreen(categories = viewstate.list,
                    navigatetoDetail)
            }
        }
    }
}

@Composable
fun CategoryScreen(categories: List<Category>,
                   navigatetoDetail : (Category)-> Unit){
    LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier.fillMaxSize()){
        items(categories){
                category ->
            CategoryItem(category = category , navigatetoDetail)
              }
         }
    }
// How each Items looks like
@Composable
fun CategoryItem(category: Category , navigatetoDetail : (Category)-> Unit ){
    Column(modifier = Modifier
        .padding(8.dp)
        .fillMaxSize()
        .clickable {navigatetoDetail(category)  },
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)
        )


        Text(
            text = category.strCategory,
            color = Color.Black,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top=4.dp)
        )
    }
}