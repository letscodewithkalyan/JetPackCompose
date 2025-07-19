package com.kp.composenotes.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kp.composenotes.domain.model.Note
import com.kp.composenotes.domain.usecase.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val getNotesUseCase: GetNotesUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val addNoteUseCase: AddNoteUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase,
    private val getNoteByIdUseCase: GetNoteByIdUseCase
) : ViewModel() {

    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes: StateFlow<List<Note>> = _notes.asStateFlow()

    private val _currentNote = MutableStateFlow<Note?>(null)
    val currentNote: StateFlow<Note?> = _currentNote.asStateFlow()

    init {
        viewModelScope.launch {
            getNotesUseCase().collect {
                _notes.value = it
            }
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            deleteNoteUseCase(note)
        }
    }

    fun saveNote(title: String, content: String, noteId: Int? = null) {
        viewModelScope.launch {
            val note = Note(
                id = noteId ?: 0,
                title = title,
                content = content,
                timestamp = System.currentTimeMillis()
            )

            if (noteId == null) {
                addNoteUseCase(note)
            } else {
                updateNoteUseCase(note)
            }
        }
    }

    fun getNoteById(id: Int) {
        viewModelScope.launch {
            _currentNote.value = getNoteByIdUseCase(id)
        }
    }
}