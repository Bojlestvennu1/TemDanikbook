package com.example.bookapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BookViewModel : ViewModel() {
    // Список книг
    val books = MutableLiveData<List<Book>>(
        mutableListOf(
            Book("Война и мир", "Лев Толстой", "Эпическая сага о жизни и любви на фоне войны."),
            Book("Преступление и наказание", "Фёдор Достоевский", "История о моральной борьбе и искуплении вины."),
            Book("Мастер и Маргарита", "Михаил Булгаков", "Мистический роман о добре, зле и любви.")
        )
    )

    // Выбранная книга
    val selectedBook = MutableLiveData<Book>()

    // Метод для обновления книги
    fun updateBook(updatedBook: Book) {
        val currentBooks = books.value?.toMutableList() ?: mutableListOf()
        val index = currentBooks.indexOfFirst { it.title == updatedBook.title }
        if (index != -1) {
            currentBooks[index] = updatedBook
            books.value = currentBooks
        }
    }
}
