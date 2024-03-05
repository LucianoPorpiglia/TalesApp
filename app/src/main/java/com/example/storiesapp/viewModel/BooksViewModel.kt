package com.example.storiesapp.viewModel

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.storiesapp.model.BooksModel
import com.example.storiesapp.repository.BooksRepository
import com.example.storiesapp.state.BookState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(private val repo: BooksRepository) : ViewModel() {

    private val _books = MutableStateFlow<List<BooksModel>>(emptyList())

    val books = _books.asStateFlow()

    var state by mutableStateOf(BookState())
        private set

    init {
        fetchBooks()
    }

    private fun fetchBooks() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = repo.getBooks()
                _books.value = result ?: emptyList()
            }
        }
    }

    fun getBookById(id: String){
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
//                val result = repo.getBookById(id)
                val result = _books.value.firstOrNull { it.id == id }
                state = state.copy(
                    title = result?.title ?: "",
                    creatorName = result?.creatorName ?: "",
                    mediaPath = result?.mediaPath ?: "",
                    content = result?.content ?: ""
                )
            }
        }
    }

    private var textToSpeech: TextToSpeech? = null

    fun textToSpeech(context: Context){
        textToSpeech = TextToSpeech(
            context
        ){
            if(it == TextToSpeech.SUCCESS){
                textToSpeech?.let {txtToSpeech ->
                    txtToSpeech.language = Locale.ENGLISH
                    txtToSpeech.setSpeechRate(1.0f)
                    txtToSpeech.speak(
                        state.content,
                        TextToSpeech.QUEUE_ADD,
                        null,
                        null
                    )
                }
            }
        }
    }
}



